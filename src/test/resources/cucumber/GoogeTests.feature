Feature: Google search tests

#  TODO: write tests for ${your.site.name} as cucumber scenarios
# TODO 2.1: create SQL table with product name and product price
# TODO 2.2: Write test that will search for a product and record its price into DB if this product is not there yet
# TODO 2.3: Check that current price is same as price in DB. IF price is different, update price in DB and fail test

  Scenario: Simple Cucumber Scenario
    Given I retrieve a random user from API as "user_1"
    Given I retrieve a random user from API as "user_2"
    Given I store user "user_1" in DB
    Given I store user "user_2" in DB
    Given I pick a random user from DB as "random_user"
    Given I load google page
    Given I accept cookies if present
    When I google for "random_user"
    Then I can see at least 3 search results for "random_user"
