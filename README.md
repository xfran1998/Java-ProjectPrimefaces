# Creating a Primefaces project and Managed Beans

We will be using:

- JSPs
- Servlets
- JSFs
- Primefaces
- Beans
- Mysql (database)

## Step 1: Create Dynamic Web Project

The project have to start as a Dynamic Web Project, on next step we will convert it as Maven project.


## Step 2: Converting to Maven

Right click on the project (Project Folder window) 	→  Configure → Convert to Maven project.

Change version to 0.0.1 and click Finish.

To see the change reflected we have to _Full Publish_ the project

- (_Server window_)Right click on the project → Full publish

Now the url of the server has change to: `` localhost:8080/project_name-0.0.1/ ``

## Step 3: Create a simple JSF to test it's all working

### Add dependencies needed

Add this lines to pom.xml above **build** tag

```xml
  <description>Java primefaces project</description>
    <dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>3.8.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.sun.faces</groupId>
        <artifactId>jsf-api</artifactId>
        <version>2.1.7</version>
    </dependency>
    <dependency>
        <groupId>com.sun.faces</groupId>
        <artifactId>jsf-impl</artifactId>
        <version>2.1.7</version>
    </dependency>
  </dependencies>
  ```

junit: Library to make unitary tests
jsf-api and jsf-impl: Libraries needed to use JSF in our project

Complete pom.xml:
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>Java-Primefaces</groupId>
  <artifactId>Java-Primefaces</artifactId>
  <version>0.0.1</version>
  <packaging>war</packaging>
  <name>Java-Primefaces</name>
  <description>Java primefaces project</description>
    <dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>3.8.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.sun.faces</groupId>
        <artifactId>jsf-api</artifactId>
        <version>2.1.7</version>
    </dependency>
    <dependency>
        <groupId>com.sun.faces</groupId>
        <artifactId>jsf-impl</artifactId>
        <version>2.1.7</version>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <release>16</release>
        </configuration>
      </plugin>
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.2.3</version>
      </plugin>
    </plugins>
  </build>
</project>
```

