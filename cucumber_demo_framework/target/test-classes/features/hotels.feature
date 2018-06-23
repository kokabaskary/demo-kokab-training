@hotel-regression@web
Feature: Hotels.com Feature

  Background:
    Given I am on Hotels website homepage
    And I click to continue on hotels page

  @hotel-regression-1
  Scenario: Verify current location is selected on destination text field
    When I Click on GPS locator button
    Then I verify destination field is pre-populated with current location

  @hotel-regression-2
  Scenario: Verify Hotel Search
#    When I select city "new York" from search bar
#    When I select checkin date as "Tomorrow"
    When I select checkout date as "7 days from tomorrow"
    Then  I verify "7" night is displayed
    And I verify checkin and checkout days are same