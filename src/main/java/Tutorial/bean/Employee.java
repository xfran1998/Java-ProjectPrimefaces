package Tutorial.bean;

// Importing required classes
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;

	/* 		For JUnit test		*/
	/*	   14000 - 16000 == 1 	*/
	/*	   16001 - 18000 == 2 	*/
	/*	   18001 - 20000 == 3 	*/
	/*	   20001 - 22000 == 4 	*/
	/*	   22001 - 24000 == 5 	*/
	/*	   24001 - INF   == 6 	*/
	private int salary;
	private int category;
	
	
	public Employee() {
		id = -1;
		firstName = "";
		lastName = "";
	}
	
	public Employee(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee(int id, String firstName, String lastName, int salary, int category) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.category = category;
	}

	public Employee(Employee e) {
		this.id = e.id;
		this.firstName = e.firstName;
		this.lastName = e.lastName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	public String toString() {
		return "[ " + id + " ]: " + firstName + ", " + lastName;
	}
}
