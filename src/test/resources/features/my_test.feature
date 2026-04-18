Feature: some feature

  Scenario: Retrieve and store people to DB
    Given I request random people from randomuser.me
    When I store them to DB
    Then DB entry count increases
