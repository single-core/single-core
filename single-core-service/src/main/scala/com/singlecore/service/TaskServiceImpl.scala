package com.singlecore.service

import com.singlecore.dao.TaskDao
import com.singlecore.domain.{Task, TaskType}
import javax.inject.{Inject, Singleton}

import scala.concurrent.Future

trait TaskService {
  def find(id: Long): Future[Option[Task]]

  def create(task: Task): Future[Unit]

  def update(task: Task): Future[Unit]

  def findQuickTask(): Future[Seq[Task]]

  def findGlassTask(): Future[Seq[Task]]
}

@Singleton
class TaskServiceImpl @Inject()(taskDao: TaskDao) extends TaskService {
  override def find(id: Long): Future[Option[Task]] = taskDao.findById(id)

  override def create(task: Task): Future[Unit] = taskDao.insert(task)

  override def update(task: Task): Future[Unit] = taskDao.update(task)

  override def findQuickTask(): Future[Seq[Task]] = taskDao.findByTaskType(TaskType.QuickTask)

  override def findGlassTask(): Future[Seq[Task]] = taskDao.findByTaskType(TaskType.GlassTask)
}
