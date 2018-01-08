package slickpoc.model
import slick.jdbc.MySQLProfile.api._

/**
  * Created by biancapetracca on 1/8/18.
  */
object Tables {


  class Items(tag: Tag) extends Table[Item](tag, "ITEMS") {

    def id = column[Int]("id", O.AutoInc)

    def name = column[String]("item_name")

    def username = column[String]("item_user_username")

    def surname = column[String]("item_user_surname")

    def user = (username, surname) <> (User.tupled, User.unapply)

    override def * = (id, name, user) <> (Item.tupled, Item.unapply)
  }

  class Users(tag: Tag) extends Table[User](tag, "USERS") {

    def name = column[String]("user_name")

    def surname = column[String]("user_surname")

    override def * = (name, surname) <> (User.tupled, User.unapply)
  }


  val users = TableQuery[Users]
  val items = TableQuery[Items]

}
