package slickpoc.config

import com.typesafe.config.ConfigFactory
import slick.jdbc.MySQLProfile.api._

/**
  * Created by biancapetracca on 1/5/18.
  */
class DB(db : String) {

  val config = ConfigFactory.load()
  val connection : Database = Database.forConfig(db)


}
