package slick

import slick.jdbc.MySQLProfile.backend.Database
import com.typesafe.config.ConfigFactory

/**
  * Created by biancapetracca on 1/5/18.
  */
object DB {

  val config = ConfigFactory.load()
  val connection = Database.forConfig("h2mem1")


}
