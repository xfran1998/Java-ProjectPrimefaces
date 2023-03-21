package Tutorial.bean;


import org.junit.Before;
import org.junit.Test;

import Tutorial.bean.Employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee(1, "John", "Doe", 15000, 1);
    }

    @Test
    public void testId() {
        assertEquals(1, employee.getId());
    }

    @Test
    public void testFirstName() {
        assertEquals("John", employee.getFirstName());
    }

    @Test
    public void testLastName() {
        assertEquals("Doe", employee.getLastName());
    }

    @Test
    public void testSalary() {
        assertEquals(15000, employee.getSalary());
    }

    @Test
    public void testCategory() {
        assertEquals(1, employee.getCategory());
    }


    /* 		For JUnit test		*/
	/*	   14000 - 16000 == 1 	*/
	/*	   16001 - 18000 == 2 	*/
	/*	   18001 - 20000 == 3 	*/
	/*	   20001 - 22000 == 4 	*/
	/*	   22001 - 24000 == 5 	*/
	/*	   24001 - INF   == 6 	*/
    @Test
    public void testSalaryCategory1() {
        // Passing test
        int categoryExpected = 0;
        int salary = employee.getSalary();

        if (salary >= 14000 && salary <= 16000) {
            categoryExpected = 1;
        } else if (salary >= 16001 && salary <= 18000) {
            categoryExpected = 2;
        } else if (salary >= 18001 && salary <= 20000) {
            categoryExpected = 3;
        } else if (salary >= 20001 && salary <= 22000) {
            categoryExpected = 4;
        } else if (salary >= 22001 && salary <= 24000) {
            categoryExpected = 5;
        } else if (salary >= 24001) {
            categoryExpected = 6;
        }

        assertEquals(categoryExpected, employee.getCategory());
    }
    

    @Test
    public void testSalaryCategory2() {
        // Not passing test
        int categoryExpected = 0;
        employee.setSalary(17000);

        int salary = employee.getSalary();

        if (salary >= 14000 && salary <= 16000) {
            categoryExpected = 1;
        } else if (salary >= 16001 && salary <= 18000) {
            categoryExpected = 2;
        } else if (salary >= 18001 && salary <= 20000) {
            categoryExpected = 3;
        } else if (salary >= 20001 && salary <= 22000) {
            categoryExpected = 4;
        } else if (salary >= 22001 && salary <= 24000) {
            categoryExpected = 5;
        } else if (salary >= 24001) {
            categoryExpected = 6;
        }

        assertEquals(categoryExpected, employee.getCategory());
    }
}
