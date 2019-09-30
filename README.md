# OverStoryAssignment
The Project is about Automating the TestCases of Oven Story.
The Project is using Page Object Design Pattern with TestNG.
In this Project the TestCases which are automated are:
TC1-Adding a Prouduct to the Cart
TC2-Validating each links are opening from Side Menu Button
Tc3-Changing the Address 
All these TC has been achieved and put into package "com.OvenStory.Assignment.testcases"
The Test Methods are stored in "com.OvenStory.Assignment.pages"
The Base Class is to initialise the Driver and stored in "com.OvenStory.Assignment.base"
To Read the property it is stored in "Lib class" under "com.OvenStory.Assignment.base" package
The Util package is stored in "com.OvenStory.Assignment.util" with two classes ListenersTest(to capture the screenshot when ever my test will fail and it will store in Screenshot Folder)
Test.util class is used for implicity wait and Page Timeout.
The drivers are located inside "Drivers" Folder
The Screenshot folder is created to capture the failed TestCases
The testdata folder is created to have the config file which stores the Browser name and URL
The Testng xml file is created to run the Testng suite "OvenStory.xml"
The pom.xml contains all the dependencies which will be required to run the Testcases
I have introduced profiling concept so that if many testng files are there we can run with Ids
Run maven command : test -POvenStory
The Result can be seen in path : "target/surefire-reports/testng-results.xml"
