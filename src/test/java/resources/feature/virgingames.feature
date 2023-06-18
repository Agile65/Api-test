@Regression
Feature: Testing different request on the virgin games API

  Scenario: Check if the virgin game application can be accessed by users
    When User sends a GET request to roxor endpoint
    Then User must get back a valid status code 200

  Scenario: Display all the records with currency GBP
    When User sends a GET request with GBP query parameter to roxor endpoint
    Then User should see currency in GBP and status code 200

  Scenario: Display all the records with currency EUR
    When User sends a GET request with EUR query parameter to roxor endpoint
    Then User should see currency in EUR and status code 200

  Scenario: Display all the records with currency SEK
    When User sends a GET request with SEK query parameter to roxor endpoint
    Then User should see currency in SEK and status code 200

  Scenario: Verify pots id = "bouncy_bubbles_id" and name = "play-bouncy-bubbles"
    When User sends a GET request to roxor endpoint
    Then User can see id and name matching as per the scenario

  Scenario: Verify total number of records are 43
    When User sends a GET request to roxor endpoint
    Then User can see total records are 43





