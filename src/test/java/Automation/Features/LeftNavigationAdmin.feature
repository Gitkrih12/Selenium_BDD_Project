Feature: Left Navigation

  Background:
    #  DSNP Admin login
    Given the user enters the valid username and password and click on login button for admin role
    When user lands directly to the page
    Then user should navigate to the DSNP admin page after successful login

  @Sanity @Smoke @39436
  Scenario:  Validate expanding collapsing action for all menu's in left navigation for admin role
    When left navigation loaded
    Then user should be able to perform expanding and collapsing actions for all menus

  @Sanity @Smoke @34890
  Scenario: Validate Account Management Menu for admin role
    When left navigation loaded
    Then user should able to view the AR Ledger Menu under Account Management Menu

  @Sanity @Smoke @34864
  Scenario: Validate Adjudication Menu for admin role
    When left navigation loaded
    Then user should able to view the Home, Global Search, Claim Reprocess, Claims Assignment Menu under Adjudication Menu
      |Home|
      |Global Search|
      |Claims Reprocess|
      |Claims Assignment|

  @Sanity @Smoke @34891
  Scenario: Validate Check Management Menu for admin role
    When left navigation loaded
    Then user should able to view the Check Refund, Check Void, Check Reissue, Check Register Menu's under Check Management Menu
      |Check Refund|
      |Check Void|
      |Check Reissue|
      |Check Register|

