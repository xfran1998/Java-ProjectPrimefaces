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