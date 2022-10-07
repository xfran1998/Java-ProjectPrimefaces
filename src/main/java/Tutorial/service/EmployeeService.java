package Tutorial.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import Tutorial.bean.Employee;
import Tutorial.dao.myBeanDAO;

@Named
@ApplicationScoped
public class EmployeeService {
    private static List<Employee> employees;
     

    public EmployeeService() {
    	// create random list of employees
    	updateEmployees();   
    }
     
    public List<Employee> getEmployees() {
    	return employees;       
    }
     
    public List<Employee> updateEmployees() {
    	System.out.println("Update user");
    	employees = myBeanDAO.findAll();
        return employees;
    }

    public void addEmployee(Employee emp) {
        myBeanDAO.save(emp);
    	/*emp.setId(getRandomId());
    	employees.add(emp);*/
    }
}