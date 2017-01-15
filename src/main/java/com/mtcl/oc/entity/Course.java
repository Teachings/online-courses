package com.mtcl.oc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_id")
	private int cId;

	private String name;

	//bi-directional many-to-one association to TCXref
	@OneToMany(fetch = FetchType.LAZY, mappedBy="course")
	private List<TCXref> TCXrefs;

	public Course() {
	}

	public int getCId() {
		return this.cId;
	}

	public void setCId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TCXref> getTCXrefs() {
		return this.TCXrefs;
	}

	public void setTCXrefs(List<TCXref> TCXrefs) {
		this.TCXrefs = TCXrefs;
	}

	public TCXref addTCXref(TCXref TCXref) {
		getTCXrefs().add(TCXref);
		TCXref.setCourse(this);

		return TCXref;
	}

	public TCXref removeTCXref(TCXref TCXref) {
		getTCXrefs().remove(TCXref);
		TCXref.setCourse(null);

		return TCXref;
	}

}