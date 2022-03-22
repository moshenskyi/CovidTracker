rootProject.name = "CovidTracker"
include(":app", ":covid-data", ":core", ":core-android", ":auth")

buildCache {
	local {
		directory = File(rootDir, "build-cache")
		removeUnusedEntriesAfterDays = 30
	}
}
