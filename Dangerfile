danger.import_plugin("Danger/Plugins/*.rb")

# Sometimes it's a README fix, or something like that - which isn't relevant for
# including in a project's CHANGELOG for example
declared_trivial = github.pr_title.include? "#trivial"

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
warn("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

# Warn when there is a big PR
warn("Big PR") if git.lines_of_code > 500

# Don't let testing shortcuts get into master by accident
fail("fdescribe left in tests") if `grep -r fdescribe specs/ `.length > 1
fail("fit left in tests") if `grep -r fit specs/ `.length > 1

lint_modules = [
    "app",
    "auth",
    "covid_data"
]

# This section processes each of the JUnit report XML files.
###########################################
#                  JUnit                  #
###########################################

junit_tests_dir = "**/test-results/**/*.xml"
Dir[junit_tests_dir].each do |file_name|
  junit.parse file_name
  junit.report
end

###########################################
#                   LINT                  #
###########################################

# lint_dir = "**/reports/lint-results.xml"
# Dir[lint_dir].each do |file_name|
#  android_lint.skip_gradle_task = true
#  android_lint.filtering = true
#  android_lint.report_file = file_name
#  android_lint.lint
# end

lint_reports = lint_modules.map do |module_name|
    Danger::LintReport.new(
        name: "#{module_name}",
        xml_path: "#{module_name}/build/reports/lint-results.xml",
        html_path: "#{module_name}/build/reports/lint-results.html"
    )
end

message << lint.markdown(reports: lint_reports, build_url: build_url)

###########################################
#               Checkstyle                #
###########################################

checkstyle_dir = "**/checkstyle/checkstyle.xml"
Dir[checkstyle_dir].each do |file_name|
  checkstyle_format.base_path = file_name
  checkstyle_format.report file_name
end
