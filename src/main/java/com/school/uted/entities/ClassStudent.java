package com.school.uted.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "classStudent")
@AssociationOverrides({
		@AssociationOverride(name = "pk.student",
			joinColumns = @JoinColumn(name = "N_REGI")),
		@AssociationOverride(name = "pk.classSt",
			joinColumns = @JoinColumn(name = "autoId")), 
			@AssociationOverride(name = "pk.years",
			joinColumns = @JoinColumn(name = "years")) })
public class ClassStudent implements Serializable {

	 @EmbeddedId
	 private ClassStudentId pk = new ClassStudentId();
	
	 @Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private java.util.Date dateRegistr;
	
	 @Column(name = "livel")
	    private String Livel;

	 
   //  private Set<ClassStudent> classStudent = new HashSet<ClassStudent>();

   
	 public String getLivel() {
		return Livel;
	}

	public void setLivel(String livel) {
		Livel = livel;
	}

//
public java.util.Date getDateRegistr() {
		return dateRegistr;
	}

	public void setDateRegistr(java.util.Date dateRegistr) {
		this.dateRegistr = dateRegistr;
	}


public ClassStudentId getPk() {
	return pk;
}

public void setPk(ClassStudentId pk) {
	this.pk = pk;
}

@Transient
public Etudiant getStudent() {
	return getPk().getStudent();
}

public void setStudent(Etudiant student) {
	getPk().setStudent(student);
}

@Transient
public ClassSt getClassSt() {
	return getPk().getClassSt();
}

public void setClassSt(ClassSt classSt) {
	getPk().setClassSt(classSt);
}
@Transient
public String getYears() {
	return getPk().getYears();
}

public void setYears(String Years) {
	getPk().setYears(Years);
}


public ClassStudent() {
	super();
	// TODO Auto-generated constructor stub
}


public boolean equals(Object o) {
	if (this == o)
		return true;
	if (o == null || getClass() != o.getClass())
		return false;

	ClassStudent that = (ClassStudent) o;

	if (getPk() != null ? !getPk().equals(that.getPk())
			: that.getPk() != null)
		return false;

	return true;
}

public int hashCode() {
	return (getPk() != null ? getPk().hashCode() : 0);
}








/*
public Set<ClassStudent> getClassStudent() {
	return classStudent;
}

public void setClassStudent(Set<ClassStudent> classStudent) {
	this.classStudent = classStudent;
}*/

}