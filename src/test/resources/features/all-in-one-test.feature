Feature: test REST + DB + WEB

  @all_in_one
  Scenario: All in one test
    Given I request 3 random people from randomuser.me API as "group_1"
    When I store "group_1" to "Persons" table
    Given I pick a random person from DB as "random_user_1"
    And I load google page
    And I accept cookies if present
    When I set search value to "random_user_1" First and Last name
    Then Search input is not empty

  Scenario: All in one test
    Given I request 3 random people from randomuser.me API as "group_1"
    When I store "group_1" to "Persons" table
    Given I pick a random person from DB as "random_user_1"
    Given I load "https://google.com/"
    And I click COOKIES_ACCEPT_BUTTON if COOKIES_LINK is VISIBLE
    And I click SEARCH_INPUT element
    When I set SEARCH_INPUT value to "random_user_1"
    Then Element SEARCH_SUGGESTIONS is VISIBLE