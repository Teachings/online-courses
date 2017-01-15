package com.mtcl.oc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="t_id")
	private int tId;

	private String name;

	//bi-directional many-to-one association to TCXref
	@OneToMany(fetch = FetchType.LAZY, mappedBy="teacher")
	private List<TCXref> TCXrefs;

	public Teacher() {
	}

	public int getTId() {
		return this.tId;
	}

	public void setTId(int tId) {
		this.tId = tId;
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
		TCXref.setTeacher(this);

		return TCXref;
	}

	public TCXref removeTCXref(TCXref TCXref) {
		getTCXrefs().remove(TCXref);
		TCXref.setTeacher(null);

		return TCXref;
	}

}