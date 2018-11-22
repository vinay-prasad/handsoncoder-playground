# CluLink Networking problem's solution

With this java-maven based application I am costructing Spanning tree for a given graph in order to achive the best bottleneck rate between any two nodes.

## Pre-requisites
### Java 7 or higher
-   Download jdk from [oracle-downloads](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
-   Extract binaries and set JAVA_HOME system variables e.g "C:\Program Files\Java\jdk1.8.0_181"
-   Add %JAVA_HOME%/bin to system path variable e.g {exisiting_path};%JAVA_HOME%/bin
- Verify installation with running command "java -version"
### Maven 3.5.x or higher
-   Download maven binary zip file from [maven-downloads](http://maven.apache.org/download.cgi) e.g apache-maven-3.6.0-bin.zip
-   Extract binaries and set MAVEN_HOME and M2_HOME system variables e.g "C:\Program Files\apache-maven-3.5.4"
-   Add %MAVEN_HOME%/bin to system path variable e.g {exisiting_path};%MAVEN_HOME%/bin
-   Verify installation with running command "mvn -version"

## Executing Test cases
The test cases are organized as standard maven Junit tests under src/test/java while the source code lived under src/main/java

| Task | Maven Command |
| ------ | ------ |
| Build | mvn clean install -Dmaven.test.skip=true |
| Build and Execute test cases| mvn clean install |
| Execute all tests | mvn clean test |
| Execute PerformanceTest | mvn clean -Dtest=PerformanceMetricsTest test  |
| Execute GenerateTest | mvn clean -Dtest=GenerateConnectedGraphTest test |
| Execute VerifyTest | mvn clean -Dtest=BestBottleneckPathTest test  |
| Execute DemoTest | mvn clean -Dtest=DemoTest test  |

Moreover, these tests can be executed directly from IDE eclipse, STS, Intellij etc
## Logging
The application can log on both console and file. Currently the file logging is turned off. To enable update root logger in src/main/resources/log4j.xml

## Reports
-   Performance metrics are generated under target/results/
-   JUnit reports are generated under target/surefire-reports/