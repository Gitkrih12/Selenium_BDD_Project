Feature: Service Details

  Background:
    Given the user enters the valid username and password and click on login button for admin role
    When user lands directly to the page
    Then user should navigate to the DSNP admin page after successful login

  @37693
  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
