Feature: Registration


  @sanity
  Scenario: User registration details
    Given enter username
    When enter password
    When click login
    When click create
    Then click user button
    Given enter first name
    When enter lastname
    When enter email
    When enter title
    Then click save button
