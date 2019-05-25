package com.singlecore.dao

import com.singlecore.domain.{Task, TaskStatus, TaskType}
import org.joda.time.DateTime
import org.specs2.mutable.Specification
import play.api.Application
import play.api.test.WithApplicationLoader

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

class TaskDaoSpec extends Specification {

  "TaskDao" should {
    "work as expected" in new WithApplicationLoader() {
      val app2dao = Application.instanceCache[TaskDao]
      val dao: TaskDao = app2dao(app)

      Await.result(dao.createSchema(), 2 seconds)
      val testTasks = Set(
        Task(Option.empty, "defaultTask", "content", "sdf", TaskType.GlassTask, TaskStatus.CREATE, new DateTime()),
        Task(Option.empty, "defaultTask", "content", "sdf", TaskType.GlassTask, TaskStatus.CREATE, new DateTime()),
        Task(Option.empty, "defaultTask", "content", "sdf", TaskType.GlassTask, TaskStatus.CREATE, new DateTime()),
      )

      Await.result(Future.sequence(testTasks.map(dao.insert)), 1 seconds)
      val sotredCats = Await.result(dao.all(), 1 seconds)

      sotredCats.size must equalTo(testTasks.size)
    }
  }
}
