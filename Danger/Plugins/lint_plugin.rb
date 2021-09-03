require "nokogiri"

module Danger
    # The lint plugin generates markdown for each of the lint reports
    class DangerLint < Plugin
        def self.instance_name
            "lint"
        end

        def markdown(reports:, build_url:)
            message += "## Lint\n\n"
            message << "| Name | Status | Fatal | Error | Warning | Informational |\n"
            message << "| ---- | ------ | ----- | ----- | ------- | ------------- |\n"

            reports.each do |report|
                # build_report_path = "#{build_urls}artifact/#{report.html_path}"
                name = "[`#{report.name}`](#{report.html_path})"

                results = lint_results(name: report.name, xml_path: report.xml_path)
                # status = status_icon(results[:extraction_succeeded], results[:total_fatal_count], results[:total_error_count])

                fatal_count = results[:total_fatal_count].to_s
                error_count = results[:total_error_count].to_s
                warning_count = results[:total_warning_count].to_s
                informational_count = results[:total_informational_count].to_s

                message << "| #{name} | #{status} | #{fatal_count} | #{error_count} |#{warning_count} | #{informational_count} |\n"
                results[:failure_messages].each {|msg| warn msg}
            end
            message
        end


        def lint_results(name:, xml_path:)
            fatal_error_count = 0
            error_count = 0
            warning_count = 0
            informational_count = 0
            failure_messages = []

            begin
                doc = File.open(xml_path) { |f| Nokogiri::XML(f) }
            rescue StandardError => e
                warn "Failed to extract lint results for \"#{name}\": #{e}"
                return {
                    extraction_succeeded: false,
                    total_fatal_count: fatal_count,
                    total_error_count: error_count,
                    total_warning_count: warning_count,
                    total_informational_count: informational_count,
                    failure_messages: failure_messages
                }
            end

            doc.at_xpath("issues").xpath("issue").each do |issue|
                case issue.attribute("severity").to_s
                when "Fatal"
                    fatal_count += 1
                when "Error"
                    error_count += 1
                when "Warning"
                    warning_count += 1
                else
                    informational_count += 1
                end
                failure_messages << issue.attribute("message").to_s
            end

            {
                extraction_succeeded: true,
                total_fatal_count: fatal_count,
                total_error_count: error_count,
                total_warning_count: warning_count,
                total_informational_count: informational_count,
                failure_messages: failure_messages
            }
        end

        class LintReport
            attr_reader :name, :xml_path, :html_path

            def initialize(name:, xml_path:, html_path:)
                @name = name
                @xml_path = xml_path
                @html_path = html_path
            end
        end
    end