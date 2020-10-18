
package com.school.uted.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


import org.json.JSONArray;
import org.json.JSONObject;

@Entity
@Table(name = "student")
public class Etudiant implements Serializable {
	
   /* @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;*/
	@Id
	@NotEmpty
	@Column(name="N_REGI",length=20)
		private String n_regi;
		 
//		@Temporal(TemporalType.DATE)
//		@DateTimeFormat(pattern="yyyy-MM-dd")
//		private java.util.Date dateRegistr;
		
		@NotEmpty
		@Column(name="CIN",length=10)
		private String cin;
		
//		@Temporal(TemporalType.DATE)
//		@DateTimeFormat(pattern="yyyy-MM-dd")
//		private java.util.Date dateCard;
		
		@Column(name="FIRSTNAME",length=30)
		@NotEmpty
		private String firstname;
		
		@Column(name="LASTNAME",length=30)
		@NotEmpty
		private String lastname;
		
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private java.util.Date dateNaissance;
		
		@Column(name="LIVESTUDY",length=30)
		@NotEmpty
		private String livelStudy;
		
		private String adrres;
		
		private String city;
		
		@Column(name="TEL",length=20)
		private String tel;
		
		@Column(name="EMAIL",length=100)
		@Email
		private String email;
		

		private String photo;
		
		@OneToMany(mappedBy="student")
		private Set<FinanceStudent>financeStd;
		//cascade for save and update in collection
	//	@ElementCollection(fetch = FetchType.EAGER)  
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.student", cascade = CascadeType.ALL)
	      private Set<ClassStudent> classStudent = new HashSet<ClassStudent>();


		public Etudiant() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Etudiant(String n_regi, String cin, String firstname, String lastname,
				Date dateNaissance, String livelStudy, String adrres, String city, String tel, String email,
				String photo) {
			super();
			this.n_regi = n_regi;
//			this.dateRegistr = dateRegistr;
			this.cin = cin;
//			this.dateCard = dateCard;
			this.firstname = firstname;
			this.lastname = lastname;
			this.dateNaissance = dateNaissance;
			this.livelStudy = livelStudy;
			this.adrres = adrres;
			this.city = city;
			this.tel = tel;
			this.email = email;
			this.photo = photo;
		}




		public String getN_regi() {
			return n_regi;
		}


		public void setN_regi(String n_regi) {
			this.n_regi = n_regi;
		}


//		public java.util.Date getDateRegistr() {
//			return dateRegistr;
//		}
//
//
//		public void setDateRegistr(java.util.Date dateRegistr) {
//			this.dateRegistr = dateRegistr;
//		}


		public String getCin() {
			return cin;
		}


		public void setCin(String cin) {
			this.cin = cin;
		}


//		public java.util.Date getDateCard() {
//			return dateCard;
//		}
//
//
//		public void setDateCard(java.util.Date dateCard) {
//			this.dateCard = dateCard;
//		}


		public String getFirstname() {
			return firstname;
		}


		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public String getLastname() {
			return lastname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public java.util.Date getDateNaissance() {
			return dateNaissance;
		}


		public void setDateNaissance(java.util.Date dateNaissance) {
			this.dateNaissance = dateNaissance;
		}


		public String getLivelStudy() {
			return livelStudy;
		}


		public void setLivelStudy(String livelStudy) {
			this.livelStudy = livelStudy;
		}


		public String getAdrres() {
			return adrres;
		}


		public void setAdrres(String adrres) {
			this.adrres = adrres;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getTel() {
			return tel;
		}


		public void setTel(String tel) {
			this.tel = tel;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPhoto() {
			return photo;
		}


		public void setPhoto(String photo) {
			this.photo = photo;
		}

		  @Override
		  public String toString() {
		    return "Student :["+ n_regi + "" + classStudent.toString() +"]";
		  }


		public Set<ClassStudent> getClassStudent() {
			return classStudent;
		}


		public void setClassStudent(Set<ClassStudent> classStudent) {
			this.classStudent = classStudent;
		}


	
		public void addClassStudent(ClassStudent classStudent) {
	        this.classStudent.add(classStudent);
	    }


		public Set<FinanceStudent> getFinanceStd() {
			return financeStd;
		}


		public void setFinanceStd(Set<FinanceStudent> financeStd) {
			this.financeStd = financeStd;
		} 
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	/*	public Collection<ClassStudent> getClassStudent() {
			return classStudent;
		}


		public void setClassStudent(Collection<ClassStudent> classStudent) {
			this.classStudent = classStudent;
		}*/


	/*	public List<ClassStudent> getClassStudent() {
			return classStudent;
		}


		public void setClassStudent(List<ClassStudent> classStudent) {
			this.classStudent = classStudent;
		}*/




//		@Override
//		public String toString(){
//			String info = "";
//			JSONObject jsonInfo = new JSONObject();
//			jsonInfo.put("name",this.n_regi);
//			JSONArray subArray = new JSONArray();
//			this.classStudent.forEach(sub->{
//				JSONObject subJson = new JSONObject();
//				subJson.put("name", sub.getAutoId());
//				subArray.put(subJson);
//			});
//			jsonInfo.put("subjects", subArray);
//			info = jsonInfo.toString();
//			return info;
//		}
//		
//
//
//		
//		


/*
		public Long getStudent_id() {
			return id;
		}


		public void setStudent_id(Long student_id) {
			this.id = student_id;
		}*/

		
		
//		@OneToMany(mappedBy="etudiant")
//		private Collection<FinanceStudent>financeStudent;
		
		//private Collection<FinanceStudent>comptes;
		
		
		
		
		
		/*@ManyToMany
		@JoinTable(name="JOIN_CLASS_STUDENTS",
		joinColumns=@JoinColumn(name="n_regi"),
		inverseJoinColumns=@JoinColumn(name="yearsStady"))
		private List<ClassStudent>classStudent=new ArrayList<ClassStudent>();*/
	/*	@OneToMany(mappedBy="etudiant",fetch=FetchType.LAZY)
		private Collection<ClassStudent>classStudent;*/
	/*	@OneToMany(mappedBy="etudiant")
		private Collection<FinanceStudent>financeStudent;*/
	
	/*	@ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "student_class", 
	            joinColumns = @JoinColumn(name = "n_regi", referencedColumnName = "n_regi"),   
        inverseJoinColumns = {@JoinColumn(name = "autoId", referencedColumnName = "autoId")})
		 @JoinColumn(name = "yearsStady", referencedColumnName = "yearsStady"),
    						 @JoinColumn(name = "section", referencedColumnName = "section"),
  						 @JoinColumn(name = "livel", referencedColumnName = "livel")})
		private Set<ClassStudent> classStudent;*/
		
		
		/*   @ManyToMany(fetch = FetchType.EAGER, 
		            cascade =
		                {
		                        CascadeType.DETACH,
		                        CascadeType.MERGE,
		                        CascadeType.REFRESH,
		                        CascadeType.PERSIST
		                },
		                targetEntity = ClassSt.class)
		    @JoinTable(name = "StdClass", 
		           joinColumns = @JoinColumn(name = "n_regi", referencedColumnName = "n_regi", updatable=false, nullable=false), 
		           inverseJoinColumns = @JoinColumn(name = "autoId", referencedColumnName = "autoId", updatable=false, nullable=false))
		    private Set<ClassSt> classStudent = new HashSet<>();*/	
		
}