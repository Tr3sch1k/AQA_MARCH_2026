Feature: test API + DB setup

  @rest_and_db
  Scenario: Request and add multiple users to DB
    Given Entries count in table "Persons" as "initial_count_persons"
    Given I request 1 random people from randomuser.me API as "group_1"
    When I store "group_1" to "Persons" table
    Then Table "Persons" has 1 more records than "initial_count_persons"
