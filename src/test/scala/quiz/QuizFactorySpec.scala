package quiz

import org.scalatest.*
import funsuite.AnyFunSuite
import matchers.should.Matchers
import quiz.utils.Shuffler

class QuizFactorySpec extends AnyFunSuite with Matchers {
  class FakeShuffler extends Shuffler{
    def shuffle[T](xs:Seq[T]):Seq[T] = xs
  }
  val fakeShuffler = new FakeShuffler()
/*
  test("Empty") {
    val questions = Nil
    val factory = new QuizFactory(questions,number=5);
    factory.build(fakeShuffler) should be (None)
  }
  test("One question") {
    val questions = List(Question("Question1",("a","b","c","d"),0))
    val factory = new QuizFactory(questions, number = 1);
    val quiz = factory.build(fakeShuffler);
    quiz.map(x=>x.questions).getOrElse(Nil) should have size(1)
  }
  test("Many questions") {
    val questions = Range(0,10).map(i=>Question(s"Question ${i+1}", ("a", "b", "c", "d"), 0))
    val factory = new QuizFactory(questions, number = 5);
    val quiz = factory.build(fakeShuffler);
    quiz.map(x => x.questions).getOrElse(Nil) should have size (5)
  }
*/
}
