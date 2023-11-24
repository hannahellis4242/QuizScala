package quiz

import org.scalatest.*
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class QuizSpec extends AnyFunSuite with Matchers {
  test("Empty Quiz") {
    val questions = List()
    val quiz = Quiz(questions)
    quiz.question should be(None)
    quiz.complete should be(true)
    quiz.answer(Set(0)) should be(quiz)
    quiz.review should be(Some(Review(Nil, Nil)))
  }
  test("Quiz with one question answered correctly") {
    val question = new Question("This is my question?",
      List(Answer("answer1", true), Answer("answer2", false), Answer("answer3", false), Answer("answer4", false)))
    val questions = List(question)
    val quiz = Quiz(questions)
    quiz.question should be(Some(question))
    quiz.complete should be(false)
    quiz.review should be(None)
    val next = quiz.answer(Set(0))
    next should not be quiz
    next.questions should be(questions)
    next.question should be(None)
    next.complete should be(true)
    val review = next.review
    review should be(Some(Review(questions, questions)))
  }
  test("Quiz with one question answered incorrectly") {
    val question = new Question("This is my question?",
      List(Answer("answer1", true), Answer("answer2", false), Answer("answer3", false), Answer("answer4", false)))
    val questions = List(question)
    val quiz = Quiz(questions)
    quiz.question should be(Some(question))
    quiz.complete should be(false)
    quiz.review should be(None)
    val next = quiz.answer(Set(1))
    next should not be quiz
    next.questions should be(questions)
    next.complete should be(true)
    val review = next.review
    review should be(Some(Review(questions, Nil)))
  }
  test("Quiz with two questions") {
    val question1 = Question("This is my question?",
      List(Answer("answer1", true), Answer("answer2", false), Answer("answer3", false), Answer("answer4", false)))
    val question2 = Question("question 2",
      List(Answer("a", false), Answer("b", true), Answer("c", false), Answer("d", false)))
    val questions = List(question1, question2)

    val quiz = Quiz(questions)
    {
      quiz.question should be(Some(question1))
      quiz.complete should be(false)
      quiz.review should be(None)
    }
    val next = quiz.answer(Set(1))
    {
      next should not be quiz
      next.questions should be(questions)
      next.question should be(Some(question2))
      next.complete should be(false)
      next.review should be(None)
    }
    val next2 = next.answer(Set(2))
    {
      next2 should not be quiz
      next2 should not be next
      next2.questions should be(questions)
      next2.question should be(None)
      next2.complete should be(true)
      next2.review should be(Some(Review(questions, Nil)))
    }
  }
}
