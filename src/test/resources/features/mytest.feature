Feature: test1 REST + DB + WEB

  @mytest
  Scenario: All in one test

    Given I load AlloUA page
    And I search product "iphone"
    And I accept search value and save suggestions by key "ListIphone"
    Given I create DB
    Then I storage 3 product in DB by key "ListIphone"