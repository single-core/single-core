package com.singlecore.domain

import org.joda.time.DateTime

case class Task(id: Option[Long],
                name: String,
                content: String,
                tag: String,
                taskType: TaskType.Value,
                taskStatus: TaskStatus.Value,
                deadDate: DateTime)


object TaskType extends Enumeration {
  val TaskType = Value
  val QuickTask, GlassTask = Value
}

object TaskStatus extends Enumeration {
  val TaskStatus = Value
  val CREATE, TODO, DOING, DONE = Value
}

