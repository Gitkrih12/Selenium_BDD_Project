Feature: Left Navigation Admin

  Background:
    #  DSNP Admin login
    Given the user enters the valid username and password and click on login button for admin role
    When user lands directly to the page
    Then user should navigate to the DSNP admin page after successful login

  @Sanity @38675
  Scenario: Verify Adjudication section should be in expanded mode by default in left navigation mode for Admin role
    When left navigation loaded
    Then user can able to see the Adjudication section expandable mode by default

  @38682
  Scenario: Verify Queue Management section should be expanded mode by default in left navigation mode for Admin role
    When left navigation loaded
    Then user can able to see the Queue Management section expandable mode by default


  @39436
  Scenario:  Validate expanding collapsing action for all menu's in left navigation for admin role
    When left navigation loaded
    Then user should be able to perform expanding and collapsing actions for all menus

  @34890
  Scenario: Validate Account Management Menu for admin role
    When left navigation loaded
    Then user should able to view the AR Ledger Menu under Account Management Menu

  @34864
  Scenario: Validate Adjudication Menu for admin role
    When left navigation loaded
    Then user should able to view the Home, Global Search, Claim Reprocess, Claims Assignment Menu under Adjudication Menu
      |Home|
      |Global Search|
      |Claims Reprocess|
      |Claims Assignment|

  @34891
  Scenario: Validate Check Management Menu for admin role
    When left navigation loaded
    Then user should able to view the Check Refund, Check Void, Check Reissue, Check Register Menu's under Check Management Menu
      |Check Refund|
      |Check Void|
      |Check Reissue|
      |Check Register|

  @39536
  Scenario: Validate expanding collapsing left navigation menu on clicking Menu Toggle for admin role
    When left navigation loaded
    And user clicks on Menu Toggle in left navigation menu
    Then left navigation menu should be changed to Collapsible mode
    And user clicks on Menu Toggle when left navigation menu in collapsible mode
    Then Left navigation menu should be changed to expandable mode

  @34893
  Scenario: Validate Fee Schedule Menu for admin role
    When left navigation loaded
    Then user should able to view the Medicare and Medicaid Menu's under Fee Schedule Menu

  @34889
  Scenario: Validate File Management Menu for admin role
    When left navigation loaded
    Then user should be able to view the following sub menus under File Management main menu
      | Letters         |
      | Files           |
      | Upload Files    |
      | Great Plains    |
      | Encounter Files |

  @34888
  Scenario: Validate Member Management Menu for admin role
    When left navigation loaded
    Then user should be able to view the following sub menus under Member Management main Menu
      | Members List        |
      | MOOP Ledger         |
      | Prior Authorization |

  @34884
  Scenario: Validate Queue Management Menu for admin role
    When left navigation loaded
    Then user should be able to view the following sub menus under Queue Management main menu
      | FFS Professional  |
      | CAP Professional  |
      | FFS Institutional |
      | CAP Institutional |
      | Dental            |

  @34928
  Scenario: Validate Reports Menu for admin role
    When left navigation loaded
    Then user should able to view the SSRS Reports Menu under Reports Menu

  @34894
  Scenario: Validate Settings Menu for admin role
    When left navigation loaded
    Then user should able to view the Plain Language and Instructions Menus under Settings Menu

  @34896
  Scenario: Validate User Management Menu for admin role
    When left navigation loaded
    Then user should be able to view the Manage Users, Manage Role menus under User Management Menu

  @Sanity @39530
  Scenario: Verify admin should land on Home/Dashboard page
    When left navigation loaded
    Then user should land on Home and Dashboard page

  @Sanity @34860
  Scenario: Verify left navigation loaded for admin role
    Then user should be able to view the left navigation for his role

  @Sanity @34863
  Scenario: Verify left navigation menu for admin role
    When left navigation loaded
    Then user should be able to view the "Claims Adjudication" Label, Menu toggle on the top view
    And user should be able to view the following menu items under left navigation panel
      | Adjudication       |
      | Queue Management   |
      | File Management    |
      | Reports            |
      | Account Management |
      | Check Management   |
      | Member Management  |
      | Fee Schedule       |
      | Settings           |
      | User Management    |
