package com.singlecore.domain

import org.joda.time.DateTime

class Task(id: Long,
           var name: String,
           var content: String,
           var tag: String,
           var taskType: TaskType.Value,
           var taskStatus: TaskStatus.Value,
           var deadDate: DateTime
          ) {
}

object TaskType extends Enumeration {
  val TaskType = Value
  val QuickTask, GlassTask = Value
}

object TaskStatus extends Enumeration {
  val TaskStatus = Value
  val CREATE, TODO, DOING, DONE = Value
}