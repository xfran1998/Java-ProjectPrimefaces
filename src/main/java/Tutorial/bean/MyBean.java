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
    private Employee emp;
     
    @Inject
    private EmployeeService service;
 
    @PostConstruct
    public void init() {
        service.updateEmployees();
    	employees = service.getEmployees();
    	emp = new Employee();
    }
     
    public List<String> getFirstNames() {
        return employees.stream().map(Employee::getFirstName).collect(Collectors.toList());
    }
    
    
   public List<String> getLastNames() {
       return employees.stream().map(Employee::getLastName).collect(Collectors.toList());
   }
   
   public List<Employee> getEmployees(){
        return service.updateEmployees();
   }
   
    public void setService(EmployeeService service) {
        this.service = service;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
	
	public void addEmployee() {		
		service.addEmployee(new Employee(emp));
		System.out.println("Add user");
	}

    public void updateEmployees() {
    	employees = service.updateEmployees();
    }
}