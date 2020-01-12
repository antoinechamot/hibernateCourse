package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity(name="Child2")
public class Child {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column
	private String name2;
	
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="firstname_fk2", referencedColumnName="firstname2"),
		@JoinColumn(name="lastname_fk2", referencedColumnName="lastname2")
	})
	private Parent parent2;
	
	
	public Child() {
		
	}
	
	public Child(String name) {
		this.name2 = name;
	}

	public Parent getParent() {
		return parent2;
	}

	public void setParent(Parent parent) {
		this.parent2 = parent;
	}
	
	
}
