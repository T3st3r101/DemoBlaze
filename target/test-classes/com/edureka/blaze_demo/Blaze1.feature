#Author: guillen.1antonio@gmail.com
Feature: Test case for Demo Blaze Project

  @Tag1
  Scenario: To verify the URL for Demo_blaze on the Google browser
    Given the user is on webBrowser
    When to validate if the user is able to access Demo_blaze website in the Google browser
    When user opens the Google browser and types : "https://www.demoblaze.com" into search field
    Then it will navigate to Google search page results
    Then click Demo Blaze link to go to the Demo Blaze website

  @Tag2
  Scenario: To verify whether the site displays the user registration
    Given the user is on webBrowser and giving the greetings
     When enter the URL
    When the user registers a new account
    When the user enters the valid username "Blazetest@gmail.com" and password "Edureka123" credentials
    Then alert will generate saying user already exists

  @Tag3
  Scenario: To verify that the user redirects to the sign up page
    Given user opens the browser
    When user validates the sucessful navigation to Demo_blaze Home Page
    When enter login user "Blazetest@gmail.com" and pass "Edureka123" credentials
    When clicks log in
    Then welcome the user to the site
