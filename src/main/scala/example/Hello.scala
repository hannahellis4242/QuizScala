package example

import quiz.{Answer, Question, Quiz}

import scala.io.StdIn.readLine
//import upickle.default.*

//case class HelloMessage(message:String) derives Reader

object Hello extends App {
  val question1 = Question("my question is this?",List(Answer("a",true),Answer("b",false)))
  val question2 = Question("question 2?",List(Answer("c",true),Answer("d",false)))
  var quiz = Quiz(List(question1,question2))
  while( quiz.question.isDefined )
  {
    val question= quiz.question.get;
    println(question)
    val answerString = readLine("your answer >")
    val answers = answerString.split(',')
    val answerSet = answers.map((str)=>str.toInt).map(x=>x-1).toSet
    val valid = answerSet.forall(x=> x < question.answers.length)
    if(valid)
      {
        quiz = quiz.answer(answerSet)
      }
      else{
      println("Invalid input")
    }
  }
  val result = quiz.review.get
  val percentageCorrect: Double = result.correct.length * 100.0 / result.questions.length;
  println(s"$percentageCorrect%");
  /*
  lazy val greeting: String = read[HelloMessage](os.read(os.pwd / "hello.json")).message
  println(greeting)*/
}

