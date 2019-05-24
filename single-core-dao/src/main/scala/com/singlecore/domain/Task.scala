package com.singlecore.domain

import org.joda.time.DateTime
import com.singlecore.JdbcSupport.api._
import com.singlecore.JdbcJodaSupport._

case class Task(id: Option[Long],
                name: String,
                content: String,
                tag: String,
                taskType: TaskType.Value,
                taskStatus: TaskStatus.Value,
                deadDate: DateTime)

class TasksTable(dbTag: Tag) extends Table[Task](dbTag, "TASK") {

  def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME")

  def content = column[String]("CONTENT")

  def tag = column[String]("TAG")

  implicit val taskTypeMapper = MappedColumnType.base[TaskType.Value, String](
    e => e.toString,
    s => TaskType.withName(s)
  )

  def taskType = column[TaskType.Value]("TASK_TYPE")

  implicit val taskStatusMapper = MappedColumnType.base[TaskStatus.Value, String](
    e => e.toString,
    s => TaskStatus.withName(s)
  )

  def taskStatus = column[TaskStatus.Value]("TASK_STATUS")

  def deadDate = column[DateTime]("deadDate")

  override def * = (id.?, name, content, tag, taskType, taskStatus, deadDate) <> (Task.tupled, Task.unapply)
}

object TaskType extends Enumeration {
  val TaskType = Value
  val QuickTask, GlassTask = Value

}

object TaskStatus extends Enumeration {
  val TaskStatus = Value
  val CREATE, TODO, DOING, DONE = Value

}

