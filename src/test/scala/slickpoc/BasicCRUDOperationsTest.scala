package slickpoc

import org.scalatest.{FlatSpec, Matchers}
import slick.jdbc.MySQLProfile.api._
import slickpoc.config.DB
import slickpoc.model.Tables._
import slickpoc.model.{Item, User}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by biancapetracca on 1/8/18.
  */
class BasicCRUDOperationsTest extends FlatSpec with Matchers {

  behavior of "basic crud operations"

  def setupSimpleSchema(db: DB): Database = {
    db.connection.run(DBIO.seq(
      users.schema.create,
      items.schema.create,
      users += User("user1", "surname1")))
    db.connection
  }

  val db = setupSimpleSchema(new DB("h2mem1"))

  it should "create schema" in {


    Await.result(db.run(users.filter(_.name === "user1").result), 1 second)
      .foreach(filteredUsers => assert(filteredUsers.name === "user1"))
  }


  it should "insert a user" in {
    db.run(DBIO.seq(users += User("some_user", "some_surname")))
    Await.result(db.run(users.size.result), 1 second) should equal(2)
  }

  it should "insert an item" in {
    val expectedUser: User = User("userA", "aaa")
    db.run(DBIO.seq(items.forceInsert(Item(1, "itemA", expectedUser))))
    Await.result(db.run(items.result), 1 second).head.user should equal(expectedUser)
  }

}
