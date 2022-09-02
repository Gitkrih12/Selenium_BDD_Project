Feature: Left Navigation non admin

  Background:
#  DSNP Adjudicator login (Non admin)
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @Sanity @38679
  Scenario: Verify Adjudication section should be in expanded mode by default in left navigation mode for non admin role
    When left navigation loaded
    Then user can able to see the Adjudication section expandable mode by default

  @38684
  Scenario: Verify Queue Management section should be in expanded mode by default in left navigation mode for non admin role
    When left navigation loaded
    Then user can able to see the Queue Management section expandable mode by default

  @34777
  Scenario: Validate Account Management Menu for adjudicator role
    When left navigation loaded
    Then user should able to view the AR Ledger Menu under Account Management Menu

  @34768
  Scenario: Validate Adjudication Menu for adjudicator role
    When left navigation loaded
    Then user should be able to view the Global Search Menu under Adjudication Menu

  @34778
  Scenario: Validate Check Management Menu for adjudicator role
    When left navigation loaded
    Then user should be able to view the following sub menus under Check Management main Menu for non admin role
      | Check Refund   |
      | Check Void     |
      | Check Reissue  |
      | Check Register |

  @39437
  Scenario: Validate expanding collapsing action for all menu's in left navigation for adjudicator role
    When left navigation loaded
    Then user should be able to perform expanding and collapsing actions for all menus

  @39535
  Scenario: Validate expanding collapsing left navigation menu on clicking Menu Toggle for adjudicator role
    When left navigation loaded
    And user clicks on Menu Toggle in left navigation menu
    Then left navigation menu should be changed to Collapsible mode
    And user clicks on Menu Toggle when left navigation menu in collapsible mode
    Then Left navigation menu should be changed to expandable mode

  @34794
  Scenario: Validate Fee Schedule Menu for adjudicator role
    When left navigation loaded
    Then user should able to view the Medicare and Medicaid Menu's under Fee Schedule Menu

  @34776
  Scenario: Validate File Management Menu for adjudicator role
    When left navigation loaded
    Then user should be able to view the following sub menus under File Management main menu
      | Letters         |
      | Files           |
      | Upload Files    |
      | Great Plains    |
      | Encounter Files |

  @34793
  Scenario: Validate Member Management Menu for adjudicator role
    When left navigation loaded
    Then user should be able to view the following sub menus under Member Management main Menu for non admin role
      | Members List        |
      | MOOP Ledger         |
      | Prior Authorization |

  @34774
  Scenario: Validate Queue Management Menu for adjudicator role
    When left navigation loaded
    Then user should be able to view the following sub menus under Queue Management main menu
      | FFS Professional  |
      | CAP Professional  |
      | FFS Institutional |
      | CAP Institutional |
      | Dental            |

  @34795
  Scenario: Validate Settings Menu for adjudicator role
    When left navigation loaded
    Then user should able to view the Plain Language and Instructions Menus under Settings Menu

#  @38268 is already covered under global search page

  @Sanity @34753
  Scenario: Verify left navigation loaded for adjudicator role
    Then user should be able to view the left navigation for his role

  @Sanity @34766
  Scenario: Verify left navigation menu for adjudicator role
    When left navigation loaded
    Then user should be able to view the "Claims Adjudication" Label, Menu toggle on the top view
    And user should be able to view the following menu items under left navigation panel for non admin role
      | Adjudication       |
      | Queue Management   |
      | File Management    |
      | Account Management |
      | Check Management   |
      | Member Management  |
      | Fee Schedule       |
      | Settings           |

  @34851
  Scenario: Verify user not able to view Reports Menu in Left Navigation for adjudicator role
    When left navigation loaded
    Then user should not be able to view the Reports Menu in Left Navigation for adjudicator role

  @34850
  Scenario: Verify user not able to view the few sub menu's under Adjudication Menu for adjudicator role
    When left navigation loaded
    Then user should see the Global search menu under Adjudication section
    And user should not be able to view the following sub menus under adjudication main menu
      | Home              |
      | Claims Reprocess  |
      | Claims Assignment |

  @34852
  Scenario: Verify user not able to view User Management Menu in Left Navigation for adjudicator role
    When left navigation loaded
    Then user not able to view the User Management Menu in Left Navigation for adjudicator role
