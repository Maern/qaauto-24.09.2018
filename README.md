Tools installation
1. JDK 10 (https://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
2. Firefox
3. IntelliJ Idea (Community Edition will be enough - https://www.jetbrains.com/idea/download/#section=windows)
4. GeckoDriver (https://github.com/mozilla/geckodriver/releases)
5. Git for Windows (if you don't have one https://gitforwindows.org/)

Tools setup
1. To install GeckoDriver - put it to Windows\System32 folder
2. To install and run JDK to your PC - open Environment Variables
and add Variable JAVA_HOME with path to JDK installation folder (i.e. C:\Program Files\Java\jdk-10.0.2)

Project-related files explanation

pom.xml - contains all dependencies required to run project. DO NOT DELETE

.gitignore - contains files and folders to be ignored by Git when commiting and pushing to repository

README.md - just README file ))))

HOW TO RUN
1. Clone repository from Git to Idea (VCS->Git->Clone)
2. Open cloned project files in Idea
3. Run BadCodeExample from src/main/java folder