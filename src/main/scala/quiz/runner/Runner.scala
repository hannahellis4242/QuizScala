package quiz.runner

import quiz.Quiz
import quiz.runner.Runner.parseAnswer

class Runner(val input: Input, val output: Output) {
  def run(quiz: Quiz): Unit = {
    var currentState = quiz
    while (currentState.question.isDefined) {
      val question = currentState.question.get;
      output.put(question.toString())
      output.put("(please put a space between your answer if you are giving more than one answer)")
      val answer = parseAnswer(input.get(), question.answers.length)
      if (answer.isDefined) {
        currentState = currentState.answer(answer.get)
      }
      else {
        output.put("Invalid input, please try again")
      }
    }
    if (currentState.review.isDefined) {
      output.put(s"${currentState.review.get.percentage}")
    }
  }
}

object Runner {
  def parseAnswer(str: String, numberOfAnswers: Int): Option[Set[Int]] = {
    try {
      val parsed = str.split(' ').map(_.toInt).toSet
      val valid = parsed.forall(x => x >= 0 && x < numberOfAnswers)
      if (valid) Some(parsed) else None
    }
    catch
      case e => None
  }
}
