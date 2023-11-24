package quiz

import quiz.utils.Shuffler

class QuizFactory(private val questions: Seq[Question], private val number: Int) {
  def build(shuffler: Shuffler): Option[Quiz] =
    if (questions.length < number) None
    else Some(Quiz(shuffler.shuffle(questions).take(number)))
}