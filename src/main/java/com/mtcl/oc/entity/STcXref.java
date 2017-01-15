package com.mtcl.oc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the s_tc_xref database table.
 * 
 */
@Entity
@Table(name="s_tc_xref")
@NamedQuery(name="STcXref.findAll", query="SELECT s FROM STcXref s")
public class STcXref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="s_id")
	private Student student;

	//bi-directional many-to-one association to TCXref
	@ManyToOne
	@JoinColumn(name="tc_id")
	private TCXref TCXref;

	public STcXref() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TCXref getTCXref() {
		return this.TCXref;
	}

	public void setTCXref(TCXref TCXref) {
		this.TCXref = TCXref;
	}

}