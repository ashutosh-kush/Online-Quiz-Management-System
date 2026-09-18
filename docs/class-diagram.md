# Class Diagram

```text
                 +------------------+
                 | <<abstract>>     |
                 | User             |
                 +------------------+
                 | username         |
                 | password         |
                 +--------+---------+
                          ^
                    +-----+-----+
                    |           |
             +------+---+   +---+------+
             | Student |   |  Admin   |
             +---------+   +----------+

+----------------+       +----------------+
| Question       |<>-----| Quiz           |
+----------------+       +----------------+
| text           |       | title          |
| options        |       | questions      |
| correctOption  |       | calculateScore |
+----------------+       +----------------+

+----------------+       +----------------+
| Result         |       | QuizManager    |
+----------------+       +----------------+
| username       |       | addQuestion    |
| quizTitle      |       | viewQuestions  |
| score / total  |       | removeQuestion |
+----------------+       +----------------+

                 +----------------+
                 | FileManager    |
                 +----------------+
                 | read/write data|
                 +----------------+
```
