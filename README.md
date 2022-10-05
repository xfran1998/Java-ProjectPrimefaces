# Creating a Primefaces project and Managed Beans

We will be using:

- JSPs
- Servlets
- JSFs
- Primefaces
- Beans
- Mysql (database)

<br>
<br>
<hr>
<br>
<br>

## Step 1: Create Dynamic Web Project

The project have to start as a Dynamic Web Project, on next step we will convert it as Maven project.

<br>
<br>
<hr>
<br>
<br>

## Step 2: Converting to Maven

```
Right click on the project (Project Folder window) 	→  Configure → Convert to Maven project.
```

Change version to 0.0.1 and click Finish.

To see the change reflected we have to _Full Publish_ the project

```
(Server window) Right click on the project → Full publish
```

Now the url of the server has change to: `` localhost:8080/project_name-0.0.1/ ``

<br>
<br>
<hr>
<br>
<br>

## Step 3: Install dependencies

We need to add the depencies to the pom.xml file situated on the root of the project

### Adding to pom.xml

Add this lines to pom.xml above **build** tag

```xml
<dependencies>
    <dependency>
        <groupId>javax</groupId>
        <artifactId>javaee-api</artifactId>
        <version>8.0</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.36</version>
    </dependency>
    <dependency>
        <groupId>org.primefaces</groupId>
        <artifactId>primefaces</artifactId>
        <version>7.0</version>
    </dependency>
    <dependency>
        <groupId>org.omnifaces</groupId>
        <artifactId>omnifaces</artifactId>
        <version>3.12</version>
    </dependency>
</dependencies>
  ```

this will install Primefaces and a simple loggin library

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
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>8.0</version>
            <scope>provided</scope>
        </dependency>
		<dependency>
		    <groupId>org.slf4j</groupId>
		    <artifactId>slf4j-api</artifactId>
		    <version>1.7.36</version>
		</dependency>
		<dependency>
			<groupId>org.primefaces</groupId>
			<artifactId>primefaces</artifactId>
			<version>7.0</version>
		</dependency>

		<dependency>
    		<groupId>org.omnifaces</groupId>
    		<artifactId>omnifaces</artifactId>
    		<version>3.12</version>
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

### Installing dependecies

When it's all set up we need to install the depencies to the project, for that:

```
Right click on the project name → Run As → Maven Clean
Right click on the project name → Run As → Maven Install
```

That will install and build all the packages we need.

If the build fail check the version of the java you are using (need java 1.8)

<br>
<br>
<hr>
<br>
<br>

## Step 4: Create a simple JSF to test it's all working

Create a index.xhtml on webapp folder

(If u don't have the option u can just create a file and name it like index.xhtml)

To test is working we will be using the hello world example on Primefaces

```xhtml
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:jsf="http://xmlns.jcp.org/jsf"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:p="http://primefaces.org/ui">

    <f:view contentType="text/html;charset=UTF-8" encoding="UTF-8">
        <h:head>

        </h:head>
        <h:body>
            <p:textEditor />
        </h:body>
    </f:view>

</html>
```

We should see a text editor at ``http://localhost:8080/Java-Primefaces-0.0.1/index.xhtml``

![img](https://i.imgur.com/Wrpz31d.png)
<br>
<br>
<hr>
<br>
<br>

## Step 5: Create a simple bean we can use on the JSF

We will be creating a package it's all wrapped called Tutorial

```
Right java package → new → create other → package
```

Inside Tutorial package we will have a **bean** and **service** folder and the project structure at the end of this step will be like:

![img](https://i.imgur.com/kVjold7.png)

### Creating the bean

We need to create a

```java
package Tutorial.bean;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Tutorial.service.EmployeeService;

@Named("dtBasicView")
@ViewScoped
public class MyBean implements Serializable {
     
    private List<Employee> employees;
    private String firstName;
    private String lastName;
     
    @Inject
    private EmployeeService service;
 
    @PostConstruct
    public void init() {
    	employees = service.getEmployees();
    }
     
    public List<String> getFirstNames() {
        return employees.stream().map(Employee::getFirstName).collect(Collectors.toList());
    }
    
    
   public List<String> getLastNames() {
       return employees.stream().map(Employee::getLastName).collect(Collectors.toList());
   }
   
   public List<Employee> getEmployees(){
	   return employees;
   }
   
    public void setService(EmployeeService service) {
        this.service = service;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void addEmployee() {
		//System.out.println("[TEST]");
		System.out.println("[" + firstName + "," + lastName + "]");
		service.addEmployee(firstName, lastName);
	}
}
```

In this bean we are injecting the service will provide the data of the javabean 
``employee``

## 

