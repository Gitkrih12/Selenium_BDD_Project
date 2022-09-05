Feature: Login

  @36468
  Scenario: Verify the "Welcome to Claims Adjudication" text along with NG in Login page screen
    Given the user is in CA Login screen
    When user navigates to the Login page UI
    Then user able to view the Welcome to Adjudication text along with NG in login page

  @37656
  Scenario: Verify "User Login" text should display in the Login screen
    Given the user is in CA Login screen
    When user views the Login screen with User Login text
    Then user should be able to view the User Login text just above the username field

  @37835
  Scenario: Verify the hospital pictography along with the texts displayed in Login Screen
    Given the user is in CA Login screen
    When user views the hospital pictography and Hospital, Claim Form texts displayed
    Then user should be able to view the hospital pictography and Hospital, Claim Form texts displayed

#  DSNP Adjudicator login
  @Sanity @34750
  Scenario: Verify user able to login with valid username and password for DSNP adjudicator role
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    Then user should be able to login to the CA screen successfully

#  DSNP Admin login
  @Sanity @37649
  Scenario: Verify user able to login with valid username and password for DSNP admin role
    Given the user enters the valid username and password and click on login button for admin role
    When user lands directly to the page
    Then user should navigate to the DSNP admin page after successful login

#  Non DSNP Adjudicator login
  @51207
  Scenario: Verify user able to login with valid username and password for non DSNP adjudicator role
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button for Non DSNP adjudicator role
    Then User should be able to login to application successfully with Non DSNP adjudicator credentials

#  Non DSNP Admin login
  @51208
  Scenario: Verify user able to login with valid username and password for non DSNP admin role
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button for Non DSNP admin role
    Then User should be able to login to application successfully with Non DSNP admin role

  @37657
  Scenario: Verify user able to view Mirra logo besides User Login text in Login screen
    Given the user is in CA Login screen
    When user views Mirra logo in Login page
    Then user should be able to view the Mirra logo besides the User Login text


  @Sanity @37674
  Scenario: Verify user should be able to view the "Valor Health Plan", "Insurance focused on you." texts one after the other in Login screen
    Given the user is in CA Login screen
    When user views the Valor Health Plan, Insurance focused on you. texts one after the other
    Then user views the text one by one successfully.

  @37671
  Scenario: Verify user views "Login" button besides rightwards arrow symbol in Login screen
    Given the user is in CA Login screen
    When user views the Login button besides rightwards arrow symbol
    Then user successfully views the Login button besides the rightwards arrow symbol

  @37668
  Scenario: Verify user views the "Forgot Password?" text in the Login page
    Given the user is in CA Login screen
    When user views the Forgot Password? text under Password grey field
    Then user successfully views the Forgot Password? text under Password grey field


  @37666
  Scenario: Verify user views the "Password" text besides lock icon with grey field along with the inner text
    Given the user is in CA Login screen
    When user views the Password text beside lock icon in Login page
    When user views the grey field under the Password text
    Then user view the inner text as Enter Password in the grey field

  @37665
  Scenario: Verify user views the "Username" text besides person icon with grey field along with the inner text
    Given the user is in CA Login screen
    When user views the Username text beside person icon in Login page
    When user views the grey field under the Username text
    Then user views the inner text as Enter Username in the grey field

  @38688
  Scenario: Verify user lands to the home page when logged in to the CA application
    Given the user logged into CA application
    When user directly lands to the home page
    Then user should land to home page by default

  @Sanity @38695
  Scenario: Verify user should be able to view the Universal Search Place holder in home page view
    Given the user is in Home page view
    When user views the Universal Search place holder at the top right corner
    Then user should be able to view the Universal Search place holder at the top right corner of home page


  @38696
  Scenario: Verify user should view the App Drawer icon at the top right corner in the home page view
    Given the user is in Home page view
    When user able to view the App drawer icon
    Then user views the App drawer icon at the top right corner in the home page view

  @38697
  Scenario: Verify user should view the Notification icon in the home page screen
    Given the user is in Home page view
    When user views the notification icon
    Then user should view the Notification icon in the home page screen

  @Sanity @38709
  Scenario: Verify user views the User Options on clicking username dropdown in the home page screen
    Given the user is in Home page view
    When user views User options under username dropdown
    Then user views the user options under username dropdown in the home page screen
