Feature: Google search tests

#  TODO: write tests for ${your.site.name} as cucumber scenarios

  Scenario Outline: Simple Cucumber Scenario
    Given I retrieve a random user from API as "user_1"
    Given I retrieve a random user from API as "user_2"
    Given I load google page
    Given I accept cookies if present
    When I google for "<user_id>"
    Then I can see at least <search_count> search results for "<user_id>"
    Examples:
      | search_count | user_id |
      | 1            | user_1  |
      | 2            | user_2  |
      | 3            | user_1  |
      | 8            | user_2  |
