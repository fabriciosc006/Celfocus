@browserTest
Feature: Product Subscription

  @Regression
  Scenario: Validate product Price
    Given I open Chrome and launch the application
    And I select type "Special"
    And I select support plan "Full"
    And I write monthly duration of "6"
    When I click in calculate price button
    Then I validate price is "2249.10 $"