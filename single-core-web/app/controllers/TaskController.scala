package controllers

import javax.inject._
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class TaskController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

}
