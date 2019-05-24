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

    val slick = "3.3.0"
    val slick_joda_mapper = "2.4.0"
    //    val slf4j_nop = "1.6.4"
    val mysql_connector = "8.0.16"
  }

  // 常用配置
  val config = "com.typesafe" % "config" % v.config
  val joda_time = "joda-time" % "joda-time" % v.joda_time
  val joda_convert = "org.joda" % "joda-convert" % v.joda_convert

  // dao
  val slick = "com.typesafe.slick" %% "slick" % v.slick
  val slick_hikaricp = "com.typesafe.slick" %% "slick-hikaricp" % v.slick
  val slick_joda_mapper = "com.github.tototoshi" %% "slick-joda-mapper" % v.slick_joda_mapper
  //  val slf4j_nop = "org.slf4j" % "slf4j-nop" % "1.6.4" % v.slf4j_nop
  val mysql_connector = "mysql" % "mysql-connector-java" % v.mysql_connector

  // 测试
  val scalacheck = "org.scalacheck" %% "scalacheck" % v.scalacheck % "test"
  val scalatest = "org.scalatest" %% "scalatest" % v.scalatest % "test"

  // 日志
  val logback_classic = "ch.qos.logback" % "logback-classic" % v.logback_classic
  val scala_logging = "com.typesafe.scala-logging" %% "scala-logging" % v.scala_logging


  private lazy val commonDependencies = Seq(
    joda_time,
    joda_convert,
    config,
    scalacheck,
    scalatest,
    logback_classic,
    scala_logging
  )

  private lazy val slickDependencies = Seq(
    slick,
    //    slf4j_nop,
    slick_hikaricp,
    slick_joda_mapper
  )

  lazy val daoDependencies = commonDependencies ++ slickDependencies
}