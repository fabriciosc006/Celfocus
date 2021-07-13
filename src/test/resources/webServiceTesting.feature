@serviceTest
Feature: Product Subscription

  @Regression
  Scenario: Validate possible add new user and job
    Given I use user creation service
    When I set name "Toy"
    And I set job "singer"
    Then I validate my response is correct

  Scenario: Delete an User
    When I Delete an user
    Then I validate user deleted

  Scenario: Not possible submit register without password
    When I submit a register without password
    Then I validate the register is not created
