package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Customer(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}

	private String name;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="passport_id",unique=true)
	private Passport passport;
	
	public Passport getPassport() {
		return passport;
	}

}
