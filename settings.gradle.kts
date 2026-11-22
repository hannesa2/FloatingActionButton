pluginManagement {
    plugins {
        kotlin("jvm") version "2.4.21"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
include(":sample")
include(":library")
include(":compose-sample")
include(":compose-sample")
