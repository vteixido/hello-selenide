Feature: Robobar cart
  Scenario: user add one cola
    Given user opens robobar website
    When user adds a cola
    Then total should be €1.25
  Scenario: user adds two colas
    Given user opens robobar website
    When user adds a cola
    And user adds a cola
    Then total should be €2.50

