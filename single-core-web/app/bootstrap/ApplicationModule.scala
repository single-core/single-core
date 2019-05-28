package bootstrap

import com.google.inject.AbstractModule
import com.singlecore.service.{TaskService, TaskServiceImpl}

class ApplicationModule extends AbstractModule {

  override def configure(): Unit = {
    bind(classOf[InitSchema]).asEagerSingleton()
    bind(classOf[TaskService]).to(classOf[TaskServiceImpl])
  }

}
