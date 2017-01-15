package com.mtcl.oc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the t_c_xref database table.
 * 
 */
@Entity
@Table(name="t_c_xref")
@NamedQuery(name="TCXref.findAll", query="SELECT t FROM TCXref t")
public class TCXref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tc_id")
	private int tcId;

	//bi-directional many-to-one association to STcXref
	@OneToMany(mappedBy="TCXref")
	private List<STcXref> STcXrefs;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="c_id")
	private Course course;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	@JoinColumn(name="t_id")
	private Teacher teacher;

	public TCXref() {
	}

	public int getTcId() {
		return this.tcId;
	}

	public void setTcId(int tcId) {
		this.tcId = tcId;
	}

	public List<STcXref> getSTcXrefs() {
		return this.STcXrefs;
	}

	public void setSTcXrefs(List<STcXref> STcXrefs) {
		this.STcXrefs = STcXrefs;
	}

	public STcXref addSTcXref(STcXref STcXref) {
		getSTcXrefs().add(STcXref);
		STcXref.setTCXref(this);

		return STcXref;
	}

	public STcXref removeSTcXref(STcXref STcXref) {
		getSTcXrefs().remove(STcXref);
		STcXref.setTCXref(null);

		return STcXref;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}