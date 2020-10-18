package com.school.uted.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
@Embeddable
public class ClassStudentId implements Serializable {
	@ManyToOne
	 private Etudiant student;
	@ManyToOne
	 private ClassSt classSt;
	
	 @Column(name = "years")
      private String years;
	 
	 
	
	public Etudiant getStudent() {
		return student;
	}

	public void setStudent(Etudiant student) {
		this.student = student;
	}
   
	public ClassSt getClassSt() {
		return classSt;
	}

	public void setClassSt(ClassSt classSt) {
		this.classSt = classSt;
	}

    public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}
	
	

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassStudentId that = (ClassStudentId) o;

        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (classSt != null ? !classSt.equals(that.classSt) : that.classSt != null) return false;
        if (years != null ? !years.equals(that.years) : that.years != null) return false;

        return true;
    }


	public int hashCode() {
        int result;
        result = (student != null ? student.hashCode() : 0);
        result = 31 * result + (classSt != null ? classSt.hashCode() : 0);
        result = (years != null ? years.hashCode() : 0);
        return result;
    }
	
	
	

}
