Feature: Managing To-Do items
  In order to be successful in my business
  As a very busy human being
  I want to manage my To-Do items easily

  Scenario: Create a To-Do item
    Given I am on the To-Do page
    When I fill in "new-todo" with "Make all the people happy"
    And I press "Return"
    Then I should see "Make all the people happy" item
    And I should see "1 item left" in the "todo-count" block

  Scenario: Complete a To-Do item
    Given I have created "Make all the people happy" item
    When I "Make all the people happy" item as done
    Then I should see done "Make all the people happy" item
    And I should see "0 items left" in the "todo-count" block
