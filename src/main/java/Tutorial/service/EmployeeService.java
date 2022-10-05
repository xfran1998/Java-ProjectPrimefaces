package Tutorial.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import Tutorial.bean.Employee;

@Named
@ApplicationScoped
public class EmployeeService {
    private final static String[] firstName;
    private final static String[] lastName;
    private final static int INIT_EMPLOYEES = 10; 
    private static List<Employee> employees;
     
    static {
    	firstName = new String[10];
    	firstName[0] = "Jose";
    	firstName[1] = "David";
    	firstName[2] = "Pepe";
    	firstName[3] = "Diego";
    	firstName[4] = "Ana";
    	firstName[5] = "Bea";
    	firstName[6] = "Susana";
        firstName[7] = "Gustavo";
        firstName[8] = "Juan";
        firstName[9] = "Elena";
        
        lastName = new String[10];   
        lastName[0] = "Yannick";
        lastName[1] = "Uncio";
        lastName[2] = "Noah";
        lastName[3] = "Sevi";
        lastName[4] = "Marin";
        lastName[5] = "Albert";
        lastName[6] = "Garcia";
        lastName[7] = "Sanchez";
        lastName[8] = "Gomez";
        lastName[9] = "Illana";        
    }
    
    public EmployeeService() {
    	// create random list of employees
    	employees = new ArrayList<Employee>();
        for (int i=0; i < INIT_EMPLOYEES ; i++){
            employees.add(new Employee(getRandomId(), getRandomFirstName(), getRandomLastName()));
        }
    }
     
    public List<Employee> getEmployees() {
    	return employees;       
    }
     
    private int getRandomId() {
        return (int) (Math.random() * 1000);
    }
     
    private String getRandomFirstName() {
        return firstName[(int) (Math.random() * 10)];
    }
    
    private String getRandomLastName() {
        return lastName[(int) (Math.random() * 10)];
    }
     
    public List<String> getFirstName() {
        return Arrays.asList(firstName);
    }
    
    public List<String> getLastName() {
        return Arrays.asList(lastName);
    }
    
    public void addEmployee(String fistName, String lastName) {
    	employees.add(new Employee(getRandomId(), fistName, lastName));
    }
}