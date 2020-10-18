package com.school.uted.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class FinanceStudent implements Serializable  {
	
	@Id @GeneratedValue
 private Long n_received;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date date_received;
	private String years;
	@Column(name="MONTH",length=30)
	private String Month;
	@Column(name="REGISTRATION")
	private int registration;
	@Column(name="SCHOOLLING")
	private int Schooling;
	@Column(name="OTHER")
	private int Other;
	@Column(name="TYPE_PAYMENT",length=15)
	private String typePayment;
	@Column(name="N_CHECK",length=20)
	private String n_check;
	@Column(name="TOTAL")
	private int total;
	
	
   @ManyToOne
   @JoinColumn(name="N_regi")
	private Etudiant student;
	
	
	/*
	   @ManyToMany(fetch = FetchType.EAGER, 
	            cascade =
	                {
	                        CascadeType.DETACH,
	                        CascadeType.MERGE,
	                        CascadeType.REFRESH,
	                        CascadeType.PERSIST
	                },
	                targetEntity = Students.class)
	    @JoinTable(name = "StdFinance", 
	           joinColumns = @JoinColumn(name = "n_received", referencedColumnName = "n_received", updatable=false, nullable=false), 
	           inverseJoinColumns = @JoinColumn(name = "n_regi", referencedColumnName = "n_regi", updatable=false, nullable=false))
	private Set<Students> students;*/
	
	  /*@ManyToMany(fetch = FetchType.EAGER, 
			    cascade =
			    {
			            CascadeType.DETACH,
			            CascadeType.MERGE,
			            CascadeType.REFRESH,
			            CascadeType.PERSIST
			    },
			    targetEntity = ClassStudent.class)
			  @JoinTable(name = "FinanceStdClass", 
			           joinColumns = @JoinColumn(name = "n_received", referencedColumnName = "n_received", updatable=false, nullable=false), 
			           inverseJoinColumns = @JoinColumn(name = "autoId", referencedColumnName = "autoId", updatable=false, nullable=false))
	  @MapKeyJoinColumn(name = "n_regi")
	  private Map<ClassStudent,Etudiant> finansStd = new HashMap<>();
	*/
	
	

		public FinanceStudent() {
			super();
			// TODO Auto-generated constructor stub
		}















	public FinanceStudent(Date date_received, String years, String month, int registration, int schooling, int other,
			String typePayment, String n_check, int total, Etudiant student) {
		super();
		this.date_received = date_received;
		this.years = years;
		Month = month;
		this.registration = registration;
		Schooling = schooling;
		Other = other;
		this.typePayment = typePayment;
		this.n_check = n_check;
		this.total = total;
		this.student = student;
	}















	public Long getN_received() {
		return n_received;
	}
	public java.util.Date getDate_received() {
		return date_received;
	}
	public void setDate_received(java.util.Date date_received) {
		this.date_received = date_received;
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public int getRegistration() {
		return registration;
	}
	public void setRegistration(int registration) {
		this.registration = registration;
	}
	public int getSchooling() {
		return Schooling;
	}
	public void setSchooling(int schooling) {
		Schooling = schooling;
	}
	public int getOther() {
		return Other;
	}
	public void setOther(int other) {
		Other = other;
	}
	public String getTypePayment() {
		return typePayment;
	}
	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}
	public String getN_check() {
		return n_check;
	}
	public void setN_check(String n_check) {
		this.n_check = n_check;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public void setN_received(Long n_received) {
		this.n_received = n_received;
	}


	public Etudiant getStudent() {
		return student;
	}


	public void setStudent(Etudiant student) {
		this.student = student;
	}


	public String getYears() {
		return years;
	}


	public void setYears(String years) {
		this.years = years;
	}


	

}