package com.school.uted.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.school.uted.entities.ClassSt;
import com.school.uted.entities.ClassStudent;
import com.school.uted.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant ,String> {
	/**/

	public List<Etudiant> findByCin(String n);
	public Page<Etudiant> findByCin(String n,Pageable pageable);
	@Query("select e from Etudiant e where e.lastname like :x")
	public Page<Etudiant> chercherEtudiants(@Param("x")String mc,Pageable pageabel);
	@Query("select e from Etudiant e where e.n_regi like :x")
	public Page<Etudiant> chercherCinEtudiants(@Param("x")String cin,Pageable pageabel);
	@Query("select e from Etudiant e where e.n_regi like :x")
	public Etudiant findNregi(@Param("x")String n_regi);
	
	@Transactional
	  @Modifying(clearAutomatically = true)
    @Query("update Etudiant c set c.cin = :cin , c.firstname = :firstname , c.lastname = :lastname ,c.dateNaissance = :dateNaissance , c.livelStudy = :livelStudy , c.adrres = :adrres ,c.city = :city , c.tel = :tel ,c.email = :email , c.photo = :photo where c.n_regi = :n_regi")
	   public void updateSt(@Param("n_regi")String n_regi, @Param("cin")String cin, @Param("firstname")String firstname, @Param("lastname")String lastname,
	    		@Param("dateNaissance")Date dateNaissance, @Param("livelStudy")String livelStudy, @Param("adrres")String adrres, @Param("city")String city, @Param("tel")String tel, @Param("email")String email,
	    		@Param("photo")String photo);
//	@Transactional
//	  @Modifying(clearAutomatically = true)
//	    @Query("update Etudiant c set c.dateRegistr = :dateRegistr where c.n_regi = :n_regi")
//	    void updateData(@Param("n_regi")String n_regi, @Param("dateRegistr")Date dateRegistr);
	    		
	
	
	
	
	
	
	
	
	
	
	
//	@Query("select e from student_class e where e.n_regi like :x")
//	public Etudiant findJoinTable(@Param("x")String n_regi);
	/*@Query("select e from student_class e where e.n_regi like :x")
    public List<Etudiant> findAllActivit(@Param("x")String n_regi);*/
//	
/*	@Modifying
	@Query("delete from Students where n_regi like :s and auto_id like :l") 
	public void deleteYears(@Param("s")String n_regi,@Param("l")Long autoId);*/

}
