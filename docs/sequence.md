# Sequence Diagram - Attempt Quiz

```text
Student      Main       QuizManager       Quiz        FileManager
  |            |             |              |              |
  | Login      |             |              |              |
  |----------->|             |              |              |
  |            | Verify      |              |              |
  |            |---------------------------->|              |
  |            |             |              |              |
  | Attempt    |             |              |              |
  |----------->|------------>|              |              |
  |            |             | getQuiz()    |              |
  |            |             |------------->|              |
  |            |             |<-------------|              |
  |            |             |              |              |
  | Answer questions         |              |              |
  |------------------------->|              |              |
  |            |             | calculateScore              |
  |            |             |------------->|              |
  |            |             |<-------------|              |
  |            |             | saveResult   |              |
  |            |             |---------------------------->|
  |            |             |              |              |
  |<-----------| Score shown |              |              |
```
