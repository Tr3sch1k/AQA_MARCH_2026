Feature: some feature

  Background:
    Given Add user to DB
      | firstName | John |
      | lastName  | Doe  |
      | nat       | US   |
      | gender    | male |
      | title     | Mr   |

  @regression_desktop
  Scenario: Retrieve and store people to DB
    Given I request 10 random people from randomuser.me
    When I store them to "my_users" DB
    Then DB entries in "my_users" count increases by 30
    And New entries have user type MANAGER
    And User nationalities in DB are:
      | UA |
      | DE |
      | DE |
      | US |

  @regression_mobile
  Scenario: Scenario 2
    Given I request 20 random people from randomuser.me

  @regression_mobile @skip
  Scenario: Scenario 3
    Given I request 30 random people from randomuser.me

  @regression_desktop @regression_mobile
  Scenario: Scenario 4
    Given I request 40 random people from randomuser.me

  @regression_desktop @regression_mobile
  Scenario Outline: Scenario 5
    Given I request <amount> random people from randomuser.me
    Examples:
      | amount |
      | 50     |
      | 60     |
      | 70     |
      | 80     |