package domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ParentPrimaryKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstname2;
	private String lastname2;
	
	@Override
	public int hashCode() {
		int result = firstname2.hashCode();
		result = 31 * result + lastname2.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;		
		ParentPrimaryKey parentPrimaryKey = (ParentPrimaryKey) o;		
		if (!firstname2.equals(parentPrimaryKey.firstname2)) return false;		
		if (!lastname2.equals(parentPrimaryKey.lastname2)) return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ParentPrimaryKey [firstname=" + firstname2 + ", lastname=" + lastname2 + "]";
	}	

	public ParentPrimaryKey() {}
	public ParentPrimaryKey(String firstname2, String lastname2) {
		super();
		this.firstname2 = firstname2;
		this.lastname2 = lastname2;;
	}
	
	
}
