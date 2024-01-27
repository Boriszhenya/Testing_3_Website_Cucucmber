Feature: а test of the TO-DO List App

  @positive
  Scenario: adding an entry to the To-Do List
    Given user is on the main page
    When a user adds the new task "Hello world!"
    Then this entry "Hello world!" will appear on the To-Do list
