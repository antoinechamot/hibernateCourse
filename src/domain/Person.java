package domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="street",column=@Column(name="street")),
			@AttributeOverride(name="city",column=@Column(name="city")),
			@AttributeOverride(name="zipcode",column=@Column(name="zipcode"))
	}
	)
	Address address;
	
	
	public Person() {}	
	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
