package com.school.uted.entities;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




//
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity //@IdClass(IdClassStd.class)
@Table(name = "classSt")
public class ClassSt implements Serializable  {
 
    @Id @GeneratedValue 
    @Column(name="autoId")
    private Long autoId;
	@NotNull
	@Column(name="SECTION",length=20)
	private String section;
	@NotNull
	@Column(name="LIVEL",length=20)
	private String livel;
//	@ElementCollection(fetch = FetchType.EAGER)  
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.classSt", cascade = CascadeType.ALL)
	    private Set<ClassStudent> classStudent = new HashSet<ClassStudent>(0);



	public ClassSt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassSt(String section, String livel, Set<ClassStudent> classStudent) {
		super();
		this.section = section;
		this.livel = livel;
		this.classStudent = classStudent;
	}

	public ClassSt(String section, String livel) {
		super();
		this.section = section;
		this.livel = livel;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getLivel() {
		return livel;
	}

	public void setLivel(String livel) {
		this.livel = livel;
	}

	public Long getAutoId() {
		return autoId;
	}

	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}

	@Override
	  public String toString() {
	    return "Class:" + section + " " +livel +" " ;
	  }

	public void addClassStudent(ClassStudent classStudent) {
        this.classStudent.add(classStudent);
    }

	public Set<ClassStudent> getClassStudent() {
		return classStudent;
	}

	public void setClassStudent(Set<ClassStudent> classStudent) {
		this.classStudent = classStudent;
	} 
	
	
	
	
	
	
	
	
	

/*
	public Set<Etudiant> getStudents() {
		return students;
	}
	public void setStudents(Set<Etudiant> students) {
		this.students = students;
	}
*/

	
/*
	   @ManyToMany(fetch = FetchType.EAGER, 
	            cascade =
	                {
	                        CascadeType.DETACH,
	                        CascadeType.MERGE,
	                        CascadeType.REFRESH,
	                        CascadeType.PERSIST
	                },
	                targetEntity = Etudiant.class)
	    @JoinTable(name = "Collaborators", 
	           joinColumns = @JoinColumn(name = "autoId", referencedColumnName = "autoId", updatable=false, nullable=false), 
	           inverseJoinColumns = @JoinColumn(name = "n_regi", referencedColumnName = "n_regi", updatable=false, nullable=false))
	    private Set<Etudiant> students = new HashSet<>();
	*/

/*
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}
*/

/*
	public ClassSt(Long autoId, String section, String livel, Set<Students> students) {
	super();
	this.autoId = autoId;
	this.section = section;
	this.livel = livel;
	this.students = students;
}

*/


/*	public Set<Etudiant> getStudents() {
		return students;
	}

	public void setStudents(Set<Etudiant> students) {
		this.students = students;
	}*/


/*
	public Etudiant getStudents() {
		return students;
	}



	public void setStudents(Etudiant students) {
		this.students = students;
	}
*/
	
	
	
	/*//	@ManyToOne
	@JoinColumn(name="n_regi")
	private Etudiant Student;*/
	

	
	/*
	@ManyToMany(mappedBy = "classStudent")
	//private Etudiant students;
	private Set<Students> students;
*/
	
/*	
	  @ManyToMany(fetch = FetchType.EAGER, 
			    cascade =
			    {
			            CascadeType.DETACH,
			            CascadeType.MERGE,
			            CascadeType.REFRESH,
			            CascadeType.PERSIST
			    },
			    targetEntity = FinanceStudent.class)
			  @JoinTable(name = "Collaborators", 
			           joinColumns = @JoinColumn(name = "autoId", referencedColumnName = "autoId", updatable=false, nullable=false), 
			           inverseJoinColumns = @JoinColumn(name = "n_received", referencedColumnName = "n_received", updatable=false, nullable=false))
	  @MapKeyJoinColumn(name = "n_regi")
	  private Map<FinanceStudent,Etudiant> finansStd = new HashMap<>();*/
	
	
	
	
//	
//	 @JoinTable(name = "class_finance", 
//	            joinColumns = @JoinColumn(name = "autoId", referencedColumnName = "autoId"),   
//     inverseJoinColumns = {@JoinColumn(name = "n_received", referencedColumnName = "n_received")})
//		private Set<FinanceStudent> finance;
	
//	@OneToMany(mappedBy="classStudent")
//	private Set<FinanceStudent>finance;
//	
/*		@ManyToMany(
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL
)
@JoinTable(
    name = "Collaborators",
    joinColumns = @JoinColumn(name = "autoId", referencedColumnName = "autoId", updatable = false, nullable = false),
    inverseJoinColumns = @JoinColumn(name = "n_received", referencedColumnName = "n_received", updatable=false, nullable=false))
@MapKeyJoinColumn(name = "n_regi")
//@MapKeyJoinColumn(name = "autoId")
 
  private Map<Etudiant,FinanceStudent> stdClassFinance = new HashMap<>();*/
	
	
}


