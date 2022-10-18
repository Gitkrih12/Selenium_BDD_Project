Feature: Files tab

  Author: Sreenivasulu Boyapati

  Background:
#  DSNP Adjudicator login (Non admin)
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

#    57922, As a tester, i want to automate 837P Files tab on the Files page
  @45795 @Sanity
  Scenario: Verify column fields in '837P Files' tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    Then user should be able to view the following column fields under 837P Files tab
      | Control Number |
      | File Name      |
      | Sender         |
      | Receiver       |
      | Date Received  |
      | Age(Days)      |
      | Status         |
      | File Type      |
    And user should be able to view the 837P column fields search boxes

  @45797
  Scenario: Verify user should be able to see the results of rows count next to the "837P Files" tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    Then user should be able to see the results of rows count next to the 837PFiles Tab

  @45837 @Sanity
  Scenario: Validate pagination functionality in '837P Files' tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    Given the user applies a filter to any field in the 837P Files tab
    When the data exceeds the defined page size under 837P files tab
    Then the user should be able to navigate through pages under 837P files tab
    And Page size can be defined by the User as per the given option at the bottom of the grid under 837P files tab
    And the user should be able to see the page numbers as per the number of data divided by page size under 837P files tab

  @45853 @Sanity
  Scenario Outline: Verify color code for Status View under '837P Files' tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    Then the user should be able to see 837P "<status>" results with the "<color>" indication
    Examples:
      | status    | color   |
      | Processed | #0E8D00 |
      | Rejected  | #BA0000 |


#  @45840 will have multiple test cases to verify sorting for all the columns listed under 837P Files tab
  @45840-1
  Scenario: Verify Sorting functionality for "File Name" column under "837P Files" tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    And user enters 837P control number under search field
    When user able to view the 837P control numbers for the entered number
    And user gets list of records from 837P file name column before sort
    And user clicks on 837P file name column to sort records in ascending order
    Then user should be able to view the 837P file name records in ascending order

  @45840-2
  Scenario: Verify Sorting functionality for "Sender" column under "837P Files" tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    And user enters 837P control number under search field
    When user able to view the 837P control numbers for the entered number
    And user gets list of records from 837P sender column before sort
    And user clicks on 837P sender column to sort records in ascending order
    Then user should be able to view the 837P sender records in ascending order

  @45840-3
  Scenario: Verify Sorting functionality for "Receiver" column under "837P Files" tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    And user enters 837P control number under search field
    When user able to view the 837P control numbers for the entered number
    And user gets list of records from 837P receiver column before sort
    And user clicks on 837P receiver column to sort records in ascending order
    Then user should be able to view the 837P receiver records in ascending order

  @45840-4 @Sanity
  Scenario: Verify Sorting functionality for "Date received" column under "837P Files" tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    And user enters 837P control number under search field
    When user able to view the 837P control numbers for the entered number
    And user gets list of records from 837P date received column before sort in descending order
    Then user should be able to view the 837P date received records in descending order

  @45840-5 @Sanity
  Scenario: Verify Sorting functionality for "Age(Days)" column under "837P Files" tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    And user enters 837P control number under search field
    When user able to view the 837P control numbers for the entered number
    And user gets list of records from 837P age days column before sort in ascending order
    Then user should be able to view the 837P age days records in ascending order

  @45840-6 @Sanity
  Scenario: Verify Sorting functionality for "Status" column under "837P Files" tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    And user enters 837P control number under search field
    When user able to view the 837P control numbers for the entered number
    And user gets list of records from 837P status column before sort
    And user clicks on 837P status column to sort records in ascending order
    Then user should be able to view the 837P status records in ascending order

  @45840-7
  Scenario: Verify Sorting functionality for "File Type" column under "837P Files" tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    And user enters 837P control number under search field
    When user able to view the 837P control numbers for the entered number
    And user gets list of records from 837P file type column before sort
    And user clicks on 837P file type column to sort records in ascending order
    Then user should be able to view the 837P file type records in ascending order

  @45840-8 @Sanity @beta
  Scenario: Verify Sorting functionality for "Control Number" column under "837P Files" tab
    Given the user is on the "Files" page
    When the user clicks on the 837P Files tab
    And user enters 837P date under date received search field
    When user able to view the 837P received dates for the entered date
    And user gets list of records from 837P control number column before sort
    And user clicks on 837P control number column to sort records in ascending order
    Then user should be able to view the 837P control number records in ascending order

#  57949, As a tester, i want to automate 837I tab on the files page
  @45913 @Sanity
  Scenario: Validate pagination functionality in '837I Files' tab
    Given the user is on the "Files" page
    When the user clicks on the 837I Files tab
    Given the user applies a filter to any field in the 837I Files tab
    When the data exceeds the defined page size under 837I files tab
    Then the user should be able to navigate through pages under 837I files tab
    And Page size can be defined by the User as per the given option at the bottom of the grid under 837I files tab
    And the user should be able to see the page numbers as per the number of data divided by page size under 837I files tab

  @45911 @Sanity
  Scenario Outline: Verify color code for Status View under 837I files tab
    Given the user is on the "Files" page
    When the user clicks on the 837I Files tab
    Then the user should be able to see 837I "<status>" results with the "<color>" indication
    Examples:
      | status    | color   |
      | Processed | #0E8D00 |
      | Rejected  | #BA0000 |

  @45908 @Sanity
  Scenario: Verify column fields in '837I Files' tab
    Given the user is on the "Files" page
    When the user clicks on the 837I Files tab
    Then user should be able to view the following column fields under 837I Files tab
      | Control Number |
      | File Name      |
      | Sender         |
      | Receiver       |
      | Date Received  |
      | Age(Days)      |
      | Status         |
      | File Type      |
    And user should be able to view the 837I column fields search boxes

#  57944, As a tester, I want to automate the 837D tab on the Files page
  @46385 @Sanity
  Scenario: Verify column fields in '837D Files' tab
    Given the user is on the "Files" page
    When the user clicks on the 837D Files tab
    Then user should be able to view the following column fields under 837D Files tab
      | Control Number |
      | File Name      |
      | Sender         |
      | Receiver       |
      | Date Received  |
      | Age(Days)      |
      | Status         |
      | File Type      |
    And user should be able to view the 837D column fields search boxes

#  57952, As a tester, i want to automate the 999 tab on the Files page
  @46462 @Sanity
  Scenario: Validate pagination functionality in '999' tab
    Given the user is on the "Files" page
    When the user clicks on the 999 tab
    When the data exceeds the defined page size under 999 files tab
    Then the user should be able to navigate through pages under 999 files tab
    And Page size can be defined by the User as per the given option at the bottom of the grid under 999 files tab
    And the user should be able to see the page numbers as per the number of data divided by page size under 999 files tab

  @46471 @Sanity
  Scenario Outline: Verify color code for Status View under '999 Files' tab
    Given the user is on the "Files" page
    When the user clicks on the 999 tab
    Then the user should be able to see 999 "<status>" results with the "<color>" indication
    Examples:
      | status    | color   |
      | Processed | #0E8D00 |
#      | Rejected  | #BA0000 |

  @46459 @Sanity
  Scenario: Verify column fields in '999' tab
    Given the user is on the "Files" page
    When the user clicks on the 999 tab
    Then user should be able to view the following column fields under 999 Files tab
      | Control Number   |
      | File Name        |
      | Sender           |
      | Receiver         |
      | Date of Creation |
      | Age(Days)        |
      | Status           |
      | Claim Type       |
    And user should be able to view the 999 column fields search boxes

#  57954, As a tester, i want to automate 277CA tab on the Files page
  @46679
  Scenario: Validate pagination functionality in '277CA' tab
    Given the user is on the "Files" page
    When the user clicks on the 277CA tab
    When the data exceeds the defined page size under 277CA files tab
    Then the user should be able to navigate through pages under 277CA files tab
    And Page size can be defined by the User as per the given option at the bottom of the grid under 277CA files tab
    And the user should be able to see the page numbers as per the number of data divided by page size under 277CA files tab

  @46681 @Sanity
  Scenario Outline: Verify color code for Status View under '277CA' tab
    Given the user is on the "Files" page
    When the user clicks on the 277CA tab
    Then the user should be able to see 277CA "<status>" results with the "<color>" indication
    Examples:
      | status    | color   |
      | Processed | #0E8D00 |
#      | Rejected  | #BA0000 |

  @46676 @Sanity
  Scenario: Verify column fields in '277CA' tab
    Given the user is on the "Files" page
    When the user clicks on the 277CA tab
    Then user should be able to view the following column fields under 277CA Files tab
      | Control Number   |
      | File Name        |
      | Sender           |
      | Receiver         |
      | Date Of Creation |
      | Age(Days)        |
      | Status           |
      | Claim Type       |
    And user should be able to view the 277CA column fields search boxes

#  57956, As a tester, i want to automate 835 tab on the Files page
  @46695
  Scenario: Validate pagination functionality in '835' tab
    Given the user is on the "Files" page
    When the user clicks on the 835 tab
    When the data exceeds the defined page size under 835 files tab
    Then the user should be able to navigate through pages under 835 files tab
    And Page size can be defined by the User as per the given option at the bottom of the grid under 835 files tab
    And the user should be able to see the page numbers as per the number of data divided by page size under 835 files tab

  @46698 @Sanity
  Scenario Outline: Verify color code for Status View under '835' tab
    Given the user is on the "Files" page
    When the user clicks on the 835 tab
    Then the user should be able to see 835 "<status>" results with the "<color>" indication
    Examples:
      | status    | color   |
      | Processed | #0E8D00 |
#      | Rejected  | #BA0000 |

  @46692 @Sanity
  Scenario: Verify column fields in '835' tab
    Given the user is on the "Files" page
    When the user clicks on the 835 tab
    Then user should be able to view the following column fields under 835 Files tab
      | Control Number   |
      | Cheque Date      |
      | File Name        |
      | Sender           |
      | Receiver         |
      | Date of Creation |
      | Transaction      |
      | Age(Days)        |
      | Status           |
    And user should be able to view the 835 column fields search boxes
