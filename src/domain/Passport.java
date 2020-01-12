package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="passport_number")
	private String passportNumber;

	public Passport(String passportNumber) {
		super();
		this.passportNumber = passportNumber;
	}


	@OneToOne(mappedBy="passport")
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}
}
