package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name="Parent2")
public class Parent {
	
	
	@EmbeddedId
	private ParentPrimaryKey parentPrimaryKey2;
	
	@OneToMany(mappedBy="parent2",cascade= {CascadeType.PERSIST})
	private Set<Child> children2 = new HashSet<>();

	public Parent() { }
	public Parent(ParentPrimaryKey parentPrimaryKey2) {
		super();
		this.parentPrimaryKey2 = parentPrimaryKey2;
	}
	
	public void addChild(Child child) {
		child.setParent(this);
		this.children2.add(child);
	}


}
