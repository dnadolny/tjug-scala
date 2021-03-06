object CaseClasses {
  //Step 0:
  
  val name: String = "John"                       //> name  : String = John
  //name = "Fred" //can't do it
  var age: Int = 20                               //> age  : Int = 20
  age = 30
  
  println("Hi " + name)                           //> Hi John
  
  def getGreeting(name: String, age: Int): String = {
    "Hi " + name + ", you are " + age + " years old"
  }                                               //> getGreeting: (name: String, age: Int)String
  val greeting = getGreeting(name, age)           //> greeting  : String = Hi John, you are 30 years old

  //Step 1:
  //val p1 = Person("John", "Smith", 60)
  //val p2 = Person("John", "Smith", 60)
  //p1 == p2

  //Step 2:
  //val p3 = Person("John", "Smith", 30)
  //val p4 = Person(first = "John", last = "Smith", age = 30)
  //p4.age = 32
  //p4

  //Step 3: start with just last 2, add in Student, add in SuperHero nested
  def printSuperPower(p: Person) = {
    p match {
      //case Student("John", lastName, _) => println("You are a John, Mr " + lastName)
      //case SuperHero(firstName, _, _, SuperPower("superhuman reflexes", powerLevel)) => println("Nice reflexes " + firstName + ", you're a level " + powerLevel)
      case SuperHero(_, _, _, superPower) => println(p.first + " has " + superPower.ability)
      case _ => println(p.getClass().getName() + "s have no superpowers")
    }
  }                                               //> printSuperPower: (p: Person)Unit

  val s = Student("John", "Smith", 23)            //> s  : Student = Student(John,Smith,23)
  val s2 = SuperHero("Tony", "Stark", 30, SuperPower("superhuman reflexes", 5))
                                                  //> s2  : SuperHero = SuperHero(Tony,Stark,30,SuperPower(superhuman reflexes,5)
                                                  //| )

  printSuperPower(s)                              //> Students have no superpowers
  printSuperPower(s2)                             //> Tony has superhuman reflexes

}

//Step 1: Basic syntax, equals, hashcode, toString, immutable fields
//case class Person(first: String, last: String, age: Int)

//Step 2: Default and named parameters, mutable fields
//case class Person(first: String, last: String, var age: Int, middle: String = "")

//Step 3: Pattern Matching
trait Person {
  def first: String
  def last: String
  def age: Int
}
case class Student(first: String, last: String, age: Int) extends Person
case class Teacher(first: String, last: String, age: Int) extends Person
case class SuperHero(first: String, last: String, age: Int, superPower: SuperPower) extends Person
case class SuperPower(ability: String, powerLevel: Int)