Feature: Application login validation

  @Test
  Scenario: Validate login process3
    Given User lands on application home page
    When User enters UserName as "admin" and Password as "admin"
    Then User sees successful login details

  @Test
  Scenario: Validate login process4
    Given User lands on application home page
    When User enters UserName as "admin" and Password as "admin"
    Then User sees successful login details
