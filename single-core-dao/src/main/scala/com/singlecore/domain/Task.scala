package com.singlecore.domain

import org.joda.time.DateTime
import play.api.libs.json.{Format, JodaReads, JodaWrites, JsString, JsSuccess, JsValue, Json}

case class Task(id: Option[Long] = None,
                name: String,
                content: String,
                tag: String,
                taskType: TaskType.Value,
                taskStatus: TaskStatus.Value,
                deadDate: DateTime)

object Tasks {

  implicit val jodaDateReads = JodaReads.jodaDateReads("yyyy-MM-dd HH:mm:ss")
  implicit val jodaDateWrites = JodaWrites.jodaDateWrites("yyyy-MM-dd HH:mm:ss")

  implicit val taskTypeFormat = new Format[TaskType.Value] {
    def reads(json: JsValue) = JsSuccess(TaskType.withName(json.as[String]))

    def writes(myEnum: TaskType.Value) = JsString(myEnum.toString)
  }

  implicit val taskStatusFormat = new Format[TaskStatus.Value] {
    def reads(json: JsValue) = JsSuccess(TaskStatus.withName(json.as[String]))

    def writes(myEnum: TaskStatus.Value) = JsString(myEnum.toString)
  }

  implicit val taskWrites = Json.writes[Task]
  implicit val taskFormat = Json.format[Task]
}

object TaskType extends Enumeration {
  val TaskType = Value
  val QuickTask, GlassTask = Value
}

object TaskStatus extends Enumeration {
  val TaskStatus = Value
  val CREATE, TODO, DOING, DONE = Value
}

