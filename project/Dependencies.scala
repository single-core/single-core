import sbt._

object Dependencies {

  object v {
    val config = "1.3.4"
    val joda_time = "2.7"
    val joda_convert = "1.7"

    val scalacheck = "1.14.0"
    val scalatest = "3.0.5"

    val logback_classic = "1.2.3"
    val scala_logging = "3.9.2"

    val slick_joda_mapper = "2.4.0"
    val play_slick = "4.0.1"
    val play_slick_evolutions = "4.0.1"
    val mysql_connector = "8.0.16"
    val h2_connector = "1.4.199"

    val scalatestplus_play = "4.0.2"
  }

  // 常用配置
  val config = "com.typesafe" % "config" % v.config
  val joda_time = "joda-time" % "joda-time" % v.joda_time
  val joda_convert = "org.joda" % "joda-convert" % v.joda_convert
  val play_json_joda = "com.typesafe.play" %% "play-json-joda" % _root_.play.core.PlayVersion.current

  // 数据库连接
  //  val mysql_connector = "mysql" % "mysql-connector-java" % v.mysql_connector
  val h2_connector = "com.h2database" % "h2" % v.h2_connector
  val play_slick = "com.typesafe.play" %% "play-slick" % v.play_slick
  val play_slick_evolutions = "com.typesafe.play" %% "play-slick-evolutions" % v.play_slick_evolutions
  val slick_joda_mapper = "com.github.tototoshi" %% "slick-joda-mapper" % v.slick_joda_mapper

  // 测试
  val scalacheck = "org.scalacheck" %% "scalacheck" % v.scalacheck % Test
  val scalatest = "org.scalatest" %% "scalatest" % v.scalatest % Test
  val play_spec2 = "com.typesafe.play" %% "play-specs2" % _root_.play.core.PlayVersion.current % Test

  // 日志
  val logback_classic = "ch.qos.logback" % "logback-classic" % v.logback_classic
  val scala_logging = "com.typesafe.scala-logging" %% "scala-logging" % v.scala_logging

  //web
  val scalatestplus_play = "org.scalatestplus.play" %% "scalatestplus-play" % v.scalatestplus_play % Test

  private lazy val commonDependencies = Seq(
    joda_time,
    joda_convert,
    config,
    scalacheck,
    scalatest,
    logback_classic,
    scala_logging,
    play_json_joda
  )

  private lazy val slickDependencies = Seq(
    //    mysql_connector,
    h2_connector,
    play_slick,
    play_slick_evolutions,
    slick_joda_mapper,
    play_spec2
  )

  lazy val daoDependencies = commonDependencies ++ slickDependencies

  lazy val webDependencies = Seq(scalatestplus_play)
}