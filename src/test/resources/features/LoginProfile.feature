@LoginProfile
Feature: Get Weather info

  Scenario: User calls web service to get a weather info
    Given a Weather url has been provided
    Then I get the status code is 200
