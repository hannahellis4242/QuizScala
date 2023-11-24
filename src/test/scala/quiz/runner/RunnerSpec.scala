package quiz.runner

import org.scalatest.*
import matchers.should.Matchers
import funsuite.AnyFunSuite
import quiz.Quiz

import scala.collection.mutable

class FakeOutput extends Output{
  val outputs:mutable.Queue[String]=mutable.Queue()

  override def put(s: String): Unit = outputs.enqueue(s)
  def calledWith(s:String):Boolean = outputs.dequeue() == s
  def clear():Unit=outputs.clear()
}

class FakeInput extends Input{
  val inputs:mutable.Queue[String]=mutable.Queue()

  def returns(s:String):Unit = inputs.enqueue(s)

  override def get(): String = inputs.dequeue()
  def clear():Unit=inputs.clear()
}

class RunnerSpec extends AnyFunSuite with Matchers with BeforeAndAfterEach {
  val output = new FakeOutput()
  val input = new FakeInput()

  override def beforeEach(): Unit = {
  output.clear()
  input.clear()
}

  test("run empty quiz") {
    val runner = new Runner( input, output)
    val quiz = Quiz(Nil)
    runner.run(quiz)
  }
}
