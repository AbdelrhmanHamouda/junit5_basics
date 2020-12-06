# Simple COVID calculator

This project implements a very basic "source" code to run some Junit5 tests against.  
The main idea here is HOW to setup, run and see results of junit tests.

# Installation
On macOS, use the following command to install "allure". For more info about installing it, take a look at this link: ```https://docs.qameta.io/allure/#_get_started```
```shell
brew install allure
```
After this is done, build the project.
```shell
./gradlew clean build
```
# How to run
```shell
./gradlew clean test
```

## Expected results
Expected several tests to run. Some will  pass and few should fail "on purpose".

To visualize the tests, open ```<repoPath>/build/reports/tests/test/index.html```

![img.png](test_report.png)


# How to run with Allure
```shell
./gradlew clean test
./gradlew allureServe
```

## Visualize the report
Run the following command in your terminal
```shell
allure serve <pathToRepo>/calculator/build/allure-results
```
### Generated report overview
The result should be something like this
![img.png](Allure_overview_page.png)
![img.png](Behaviors.png)