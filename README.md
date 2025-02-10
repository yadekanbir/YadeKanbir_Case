TECHNOLOGIES USED

Java: The primary programming language used for writing the automation test cases.
Selenium WebDriver: Used to execute tests in a real browser environment.
TestNG: The test framework utilized for organizing, managing, and executing test cases (including parallel execution).
Extent Reports: Integrated to transform test execution results into dynamic and detailed visual reports.

PROJECT FEATURES
Modular Structure: Implemented using the Page Object Model (POM), which simplifies maintenance and scalability of the test code.
Dynamic Reporting: Each test step is logged using Extent Reports, allowing for in-depth analysis of the test execution through visual reports.
Parallel Test Execution: Leveraging TestNG's capabilities to run tests in parallel, thereby optimizing test execution time.
Robust Error Handling: Any issues or exceptions encountered during test steps are captured and logged, facilitating rapid identification and resolution of problems.

HOW IT WORKS
Test Cases: The test cases, written for various components of the web application, are managed by the TestNG framework.
Page Object Model: Separate page classes are created for each web page, centralizing UI element interactions and simplifying maintenance.
Reporting: During test execution, log messages are recorded using Extent Reports. Upon completion, the results are saved to the target/Spark.html file, which can be opened in a web browser to review the detailed test report.

HOW TO RUN THE PROJECT
Install Dependencies: If you are using Maven, ensure that the dependencies in your pom.xml file are up-to-date and build the project.
Execute the Tests: Run the tests using the TestNG framework.
View the Report: After the tests have executed, open the target/Spark.html file in your web browser to view the test report.
