package bootstrap

import com.singlecore.dao.TaskDao
import javax.inject.Inject

private[bootstrap] class InitSchema @Inject()(taskDao: TaskDao) {

  def doInit(): Unit = {
    taskDao.createSchema()
  }

  doInit()
}
