package com.singlecore.dao

import com.singlecore.domain.{Task, TaskStatus, TaskType}
import javax.inject.{Inject, Singleton}
import org.joda.time.DateTime
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class TaskDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
                       (implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._
  import com.singlecore.JdbcJodaSupport._

  private val Tasks = TableQuery[TasksTable]

  implicit val taskTypeMapper = MappedColumnType.base[TaskType.Value, String](
    e => e.toString,
    s => TaskType.withName(s)
  )

  implicit val taskStatusMapper = MappedColumnType.base[TaskStatus.Value, String](
    e => e.toString,
    s => TaskStatus.withName(s)
  )

  def findAll(): Future[Seq[Task]] = db.run(Tasks.result)

  def findById(id: Long): Future[Option[Task]] = db.run(Tasks.filter(_.id === id).result.headOption)

  def findByTaskType(taskType: TaskType.Value): Future[Seq[Task]] = db.run(Tasks.filter(_.taskType === taskType).result)

  def insert(task: Task): Future[Unit] = db.run(Tasks += task).map { _ => () }

  def update(task: Task): Future[Unit] = db.run(Tasks.filter(_.id === task.id).update(task).map(_ => ()))

  def createSchema() = db.run(Tasks.schema.createIfNotExists)


  class TasksTable(dbTag: Tag) extends Table[Task](dbTag, "TASK") {

    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def name = column[String]("NAME")

    def content = column[String]("CONTENT")

    def tag = column[String]("TAG")

    def taskType = column[TaskType.Value]("TASK_TYPE")

    def taskStatus = column[TaskStatus.Value]("TASK_STATUS")

    def deadDate = column[DateTime]("DEAD_DATE")

    def * = (id.?, name, content, tag, taskType, taskStatus, deadDate) <> (Task.tupled, Task.unapply)
  }

}
