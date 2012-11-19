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
    When I mark "Make all the people happy" item as done
    Then I should see done "Make all the people happy" item
    And I should see "0 items left" in the "todo-count" block

  Scenario: Edit an existing To-Do item
    Given I have created "Make all the people happy" item
    When I double click on "Make all the people happy" item
    And I fill in "edit" with "Feed all kitties"
    And I press "Return"
    Then I should see "Feed all kitties" item
    And I should not see "Make all the people happy" item
    And I should see "1 item left" in the "todo-count" block
