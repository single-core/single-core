import Dependencies._

name := "single-core"

lazy val commonSetting = Seq(
  organizationName := "single core",
  version := "0.1",
  scalaVersion := "2.12.8"
)

lazy val single_core_dao = (project in file("single-core-dao"))
  .settings(commonSetting,
    libraryDependencies ++= daoDependencies)

lazy val single_core_web = (project in file("single-core-web"))
  .enablePlugins(PlayScala)
  .settings(commonSetting,
    libraryDependencies ++= guice +: webDependencies)
  .dependsOn(single_core_dao)

lazy val single_core_root = (project in file("."))
  .dependsOn(single_core_dao, single_core_web)
  .aggregate(single_core_dao, single_core_web)
  .enablePlugins(PlayScala)