Feature: Registration

  @regression
  Scenario: User should able to register successfully

    Given user is on register page
    When user enter required registration details
    Then user should able to register successfully
