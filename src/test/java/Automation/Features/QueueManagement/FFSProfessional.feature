Feature: FFS Professional

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

    #41481- As an adjudicator, I should be able to view Corrected colour codings in the FFS Professional page so that I can easily identify the corrected claims details
  @TC_42519
  Scenario: Verify color code for corrected claims in FFS Professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters Corrected claim in FFS Professional search criteria
    Then user should able to view corrected claim in FFS Professional Grid
    And user should able to see vertical line beside claim number with color code "#AD71FF" in FFS Professional page
    And color indication information should be available on top of grid in FFS Professional page

  @TC_42549
  Scenario: Verify color code for COB In Member House in FFS Professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters COB In Member House claim in search criteria
    Then user should able to view COB In Member House claim
    And user should able to view patient name with color code "00FF00" in FFS Professional page
    And color indication information for COB In Member House should be available on top of grid

  @TC_42606
  Scenario: Verify color code for COB Not In Member House in FFS Professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters COB Not In Member House claim in search criteria
    Then user should able to view COB Not In Member House claim
    And user should able to view patient name with color code "#FF0000" in FFS Professional page
    And color indication information for COB Not In Member House should be available on top of grid


