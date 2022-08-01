# Parchis_Oca Application 

This is a project of Group 1 September:

Daniel Toledo Villalba

This is a fork of https://github.com/spring-projects/spring-petclinic to be used for the DP1 course. 
For this course, i have implemented a web application based on two board games: [Parchís](https://en.wikipedia.org/wiki/Parch%C3%ADs) 
and [Oca](https://en.wikipedia.org/wiki/Game_of_the_Goose).
These game can be played by up to 4 players.

## Running Parchis_Oca locally
Parchis_Oca is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). 
You can build a jar file and run it from the command line:

```
git clone https://github.com/dantolvil/dp1-2021-2022-g1-septiembre
cd dp1-2021-2022-g1-septiembre
./mvnw package
java -jar target/*.jar
```

You can then access Parchis_Oca here: http://localhost:8080/

src/main/resources/static/resources/images/parchis&oca.png

Or you can run it from Maven directly using the Spring Boot Maven plugin. 
If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```
## Database configuration

In its default configuration, Parchis_Oca uses an in-memory database (H2) which
gets populated at startup with data. 

## Working with Petclinic in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 11 or newer.
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE 
  * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, just follow the install process here: https://www.eclipse.org/m2e/
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)

### Steps:

1) On the command line
```
git clone https://github.com/dantolvil/dp1-2021-2022-g1-septiembre
```
2) Inside Eclipse or STS
```
File -> Import -> Maven -> Existing Maven project
```

Then either build on the command line `./mvnw generate-resources` or using the Eclipse launcher (right click on project and `Run As -> Maven install`) 
to generate the css. Run the application main method by right clicking on it and choosing `Run As -> Java Application`.

3) Inside IntelliJ IDEA

In the main menu, choose `File -> Open` and select the Parchis_Oca [pom.xml](pom.xml). Click on the `Open` button.

CSS files are generated from the Maven build. You can either build them on the command line `./mvnw generate-resources`
or right click on the `parchis_oca` project then `Maven -> Generates sources and Update Folders`.

A run configuration named `ParchisOcaApplication` should have been created for you if you're using a recent Ultimate
version. Otherwise, run the application by right clicking on the `ParchisOcaApplication` main class and choosing
`Run 'ParchisOcaApplication'`.

4) Navigate to Parchis_Oca

Visit [http://localhost:8080](http://localhost:8080) in your browser.
