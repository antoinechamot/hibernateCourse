package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(name="employee_id",unique=true)
	private String employeeId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="employee_status")
	private EmployeeStatus employeeStatus;
	
	public Employee() {
		
	}

	public Employee(String name, String employeeId, EmployeeStatus employeeStatus) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.employeeStatus = employeeStatus;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", employeeId=" + employeeId + ", employeeStatus="
				+ employeeStatus + "]";
	}

	
	
	
}
