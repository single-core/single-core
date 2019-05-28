package controllers

import com.singlecore.domain.Tasks._
import com.singlecore.service.TaskService
import javax.inject._
import play.api.libs.json.Json._
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext

@Singleton
class TaskController @Inject()(cc: ControllerComponents, taskService: TaskService)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  def glassTasks() = Action.async {
    taskService.findGlassTask().map(taskSeq => Ok(toJson(taskSeq)))
  }

  def quickTasks() = Action.async {
    taskService.findQuickTask().map(taskSeq => Ok(toJson(taskSeq)))
  }

  def task(id: Long) = Action.async {
    taskService.find(id).map(_ match {
      case Some(task) => Ok(toJson(task))
      case None => Ok("find nothing")
    })
  }
}
