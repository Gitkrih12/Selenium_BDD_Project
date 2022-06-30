Feature: Login

  Scenario: Verify the "Welcome to Claims Adjudication" text along with NG in Login page screen
    Given the user is in CA Login screen
    When user navigates to the Login page UI

  Scenario: Verify "User Login" text should display in the Login screen
    Given the user is in CA Login screen
    When user views the Login screen with User Login text

  Scenario: Verify the hospital pictography along with the texts displayed in Login Screen
    Given the user is in CA Login screen
    When user views the hospital pictography and Hospital, Claim Form texts displayed

#  DSNP Adjudicator login
  Scenario: Verify user able to login with valid username and password for DSNP adjudicator role
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

#  DSNP Admin login
  Scenario: Verify user able to login with valid username and password for DSNP admin role
    Given the user enters the valid username and password and click on login button for admin role
    When user lands directly to the page

#  Non DSNP Adjudicator login
  Scenario: Verify user able to login with valid username and password for non DSNP adjudicator role
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button for Non DSNP adjudicator role

#  Non DSNP Admin login
  Scenario: Verify user able to login with valid username and password for non DSNP admin role
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button for Non DSNP admin role

  Scenario: Verify user able to view Mirra logo besides User Login text in Login screen
    Given the user is in CA Login screen
    When user views Mirra logo in Login page


  Scenario: Verify user should be able to view the "Valor Health Plan", "Insurance focused on you." texts one after the other in Login screen
    Given the user is in CA Login screen
    When user views the Valor Health Plan, Insurance focused on you. texts one after the other


  Scenario:  Verify user views "Login" button besides rightwards arrow symbol in Login screen
    Given the user is in CA Login screen
    When user views the Login button besides rightwards arrow symbol

  Scenario: Verify user views the "Forgot Password?" text in the Login page
    Given the user is in CA Login screen
    When user views the Forgot Password? text under Password grey field

  Scenario: Verify user views the "Password" text besides lock icon with grey field along with the inner text
    Given the user is in CA Login screen
    When user views the Password text beside lock icon in Login page
    When user views the grey field under the Password text
    When user view the inner text as Enter Password in the grey field

  Scenario: Verify user views the "Username" text besides person icon with grey field along with the inner text
    Given the user is in CA Login screen
    When user views the Username text beside person icon in Login page
    When user views the grey field under the Username text
    When user views the inner text as Enter Username in the grey field

  Scenario: Verify user lands to the home page when logged in to the CA application
    Given the user logged into CA application
    When user directly lands to the home page

  Scenario: Verify user should be able to view the Universal Search Place holder in home page view
    Given the user is in Home page view
    When user views the Universal Search place holder at the top right corner

  Scenario: Verify user should view the App Drawer icon at the top right corner in the home page view
    Given the user is in Home page view
    When user able to view the App drawer icon

  Scenario: Verify user should view the Notification icon in the home page screen
    Given the user is in Home page view
    When user views the notification icon

  Scenario: Verify user views the User Options on clicking username dropdown in the home page screen
    Given the user is in Home page view
    When user views User options under username dropdown

