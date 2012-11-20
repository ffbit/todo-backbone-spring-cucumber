Feature: Managing To-Do items
  In order to be successful in my business
  As a very busy human being
  I want to manage my To-Do items easily

  Scenario: Create a To-Do item
    Given I am on the To-Do page
    When I fill in new todo with "Make all the people happy"
    And I press Return
    Then I should see "Make all the people happy" item
    And I should see "1 item left"

  Scenario: Complete a To-Do item
    Given I have created "Make all the people happy" item
    When I mark "Make all the people happy" item as done
    Then I should see completed "Make all the people happy" item
    And I should see "0 items left"

  Scenario: Edit an existing To-Do item
    Given I have created "Make all the people happy" item
    When I double click on "Make all the people happy" item
    And I replace "Make all the people happy" item label with "Feed all kitties"
    And I press Return
    Then I should see "Feed all kitties" item
    And I should not see "Make all the people happy" item
    And I should see "1 item left"

  Scenario: Delete an a completed To-Do item
    Given I have completed "Make all the people happy" item
    When I destroy "Make all the people happy" item
    Then I should not see "Make all the people happy" item
