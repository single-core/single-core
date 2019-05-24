package com.singlecore

import com.github.tototoshi.slick.GenericJodaSupport
import slick.jdbc.MySQLProfile

object JdbcJodaSupport extends GenericJodaSupport(MySQLProfile) {

}
