package quiz

import org.scalatest._
import funsuite.AnyFunSuite
import matchers.should.Matchers

class QuestionSpec extends AnyFunSuite with Matchers {
  test("True False type question corect"){
    val answer1 = Answer("True",correct=false)
    val answer2 = Answer("False",correct=true)
    val question = Question("This statement is true?",List(answer1,answer2))
    question.mark(Set(1)) should be (true)
  }
  test("True False type question incorrect") {
    val answer1 = Answer("True", correct = true)
    val answer2 = Answer("False", correct = false)
    val question = Question("This statement is true?", List(answer1, answer2))
    question.mark(Set(1)) should be(false)
  }
}
