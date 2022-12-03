Feature: Registration
  Scenario: User should able to register successfully

    Given user is on register page
    And user clicks radio button male
    And user enters "First name" with "DB"
    And user enters "Last name" with "Patel"
    And user select "Day" of "Date of Birth" with "10"
    And user select "Month" of "Date of Birth" with "March"
    And user select "Year" of "Date of Birth" with "1914"
    And user enters "Email" with "abcd@gmail.com"
    And user enters "Password" with "123456"
    And user enters "Confirm password" with "123456"
    And user clicks on "Register" button
    Then user should able to register successfully
    And "Your registration completed" message should appear on the screen

