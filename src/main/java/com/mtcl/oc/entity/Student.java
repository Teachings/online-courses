package com.mtcl.oc.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="s_id")
	private int sId;

	private String name;

	//bi-directional many-to-one association to STcXref
	@OneToMany(fetch = FetchType.LAZY, mappedBy="student")
	private List<STcXref> STcXrefs;

	public Student() {
	}

	public int getSId() {
		return this.sId;
	}

	public void setSId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<STcXref> getSTcXrefs() {
		return this.STcXrefs;
	}

	public void setSTcXrefs(List<STcXref> STcXrefs) {
		this.STcXrefs = STcXrefs;
	}

	public STcXref addSTcXref(STcXref STcXref) {
		getSTcXrefs().add(STcXref);
		STcXref.setStudent(this);

		return STcXref;
	}

	public STcXref removeSTcXref(STcXref STcXref) {
		getSTcXrefs().remove(STcXref);
		STcXref.setStudent(null);

		return STcXref;
	}

}