# Workflow

```text
Start
  |
  v
Main Menu
  |
  +--> Register --> Save Student --> Main Menu
  |
  +--> Student Login --> Student Menu
  |                         |
  |                         +--> Attempt Quiz --> Calculate Score
  |                         |                       |
  |                         |                       v
  |                         |                  Save Result
  |                         |
  |                         +--> View Results
  |                         |
  |                         +--> Logout
  |
  +--> Admin Login --> Admin Menu
                            |
                            +--> Add Question
                            +--> View Questions
                            +--> Remove Question
                            +--> View Results
                            +--> Logout
  |
  v
Exit
