package com.school.uted.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.school.uted.entities.ClassSt;
import com.school.uted.entities.ClassStudent;
import com.school.uted.entities.Etudiant;

public interface ReposetoryStdClass extends JpaRepository<ClassStudent,String> {

	@Query("select e from ClassStudent e where e.pk.years like :y and e.pk.student.n_regi like :n")
	public ClassStudent findyears(@Param("y")String years,@Param("n")String n_regi);
//	@Transactional
//	  @Modifying(clearAutomatically = true)
//	@Query("delete * from ClassStudent e where e.pk.years like :y")
//	public ClassStudent deltetclass(@Param("y")String years);
	@Query("select e from ClassStudent e where e.pk.student.n_regi like :n")
	 public List<ClassStudent>  findAllClass(@Param("n")String n_regi);

	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@Modifying
	@Query("delete o from ClassStudent where o.n_regi like :s and o.auto_id like :l") 
	public void deleteYears(@Param("s")String n_regi,@Param("l")Long autoId)*/;


	/*//@Query("select o from ClassStudent o where o.years like :s and o.student.n_regi like :n")
	@Query("SELECT * FROM ClassStudent WHERE years like :s ")
	public ClassStudent getInfoClass(@Param("y")String years);*/
}
