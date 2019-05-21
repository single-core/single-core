import Dependencies._

name := "single-core"

lazy val commonSetting = Seq(
  organizationName := "single core",
  version := "0.1",
  scalaVersion := "2.12.8"
)

lazy val single_core_dao = (project in file("single-core-dao"))
  .settings(commonSetting)
  .dependsOn(single_core_domain)

lazy val single_core_domain = (project in file("single-core-domain"))
  .settings(commonSetting,
    libraryDependencies ++= common)
