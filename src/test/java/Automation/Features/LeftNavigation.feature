Feature: Left Navigation

  Background:
    #  DSNP Admin login
    Given the user enters the valid username and password and click on login button for admin role
    When user lands directly to the page
    Then user should navigate to the DSNP admin page after successful login

  @39436
  Scenario:  Validate expanding collapsing action for all menu's in left navigation for admin role
    When left navigation loaded
    Then user should be able to perform expanding and collapsing actions for all menus
    
  @34890
  Scenario: Validate Account Management Menu for admin role
    When left navigation loaded
    Then user should able to view the AR Ledger Menu under Account Management Menu

