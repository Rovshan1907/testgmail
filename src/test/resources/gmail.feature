Feature: Gmail Test

  Scenario: Send and Verify Email
    Given I am on the Gmail login page
    When I enter valid credentials
    And I navigate to the Gmail inbox
    And I click on the "Compose" button
    And I enter a valid recipient, subject, and body
    And I click on the "Send" button
    Then I verify that the email is received with the proper subject and body
