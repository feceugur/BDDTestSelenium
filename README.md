# BDDTestCase1_Kloia

This repo is prepared for the test case given by [Kloia](https://www.kloia.com/).

It includes testing of basic functions such as searching, logging in, registering products on a website.

## Details

You can run the test individually from the `BDDTestCase1.feature` file or for scenarios using tagNames, while you can test all scenarios from the `CucumberRunner` file.


The default email and password used in the work belong to an account created for trial purposes. You can change the email and password in the `config.properties` file. 
Also since my computer does not have enough RAM, I specified your browser from the `config.properties` file instead of _cross-testing_, allowing you to test in different browsers. It works in Chrome by default.
Since I could not complete the solution of the `.click()` error experienced in the buttons in the Firefox browser, I got an error in some scenarios in the test. It will be arranged in the future.
Test documents for Chrome, Firefox and Edge browsers (_.html file_) have been added to begin with the browser name.
