Feature: Test Automation Case Study-1

  Background:
    Given homepage is open
    And I close the pop up

  @smoke
  Scenario: Logo verification
    Then logo should be displayed

  @search
  Scenario: task 1 - searching for item
    And verification of page title
    And maximize window
    When I search for "Drone"
    Then search result should be for "Drone"

  @signin
  Scenario: task 2 - sign in page verification
    And I open "Account" dropdown menu
    When I choose Sing In page
    Then sign in page should open
    And login with email and password
    Then verification of singing
  @signinwgoogle
  Scenario: task 3 - Signing with google
    And I open "Account" dropdown menu
    When I choose Sing In page
    Then sign in page should open
    And sign in with Google with email and password
    #And wait until page loads
    And open new tab
    #Then verification of singing

  @saveitem
  Scenario: task 4
    And I open Menu
    And I open Audio submenu
    And I open Headphones submenu
    And I open Wireless Headphones submenu
    And Select Brand
    And Select second product
    Then Save product
    And I open "Saved Items" dropdown menu
    And verification of "saved item" page