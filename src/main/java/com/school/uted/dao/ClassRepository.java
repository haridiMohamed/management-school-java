package com.school.uted.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.school.uted.entities.ClassSt;
import com.school.uted.entities.Etudiant;


	public interface ClassRepository extends JpaRepository<ClassSt,Long> {
			

		@Query("select e from ClassSt e where e.section like :x")
		public Page<ClassSt> chercherYearsClass(@Param("x")String section,Pageable pageabel);
		
		@Query("select o from ClassSt o where o.section like :s and o.livel like :l")
		public ClassSt getInfoClass(@Param("s")String section,@Param("l")String level);
			
		@Query("select e from ClassSt e where e.autoId like :x")
		public Page<ClassSt> chercherIdClass(@Param("x")Long autoId,Pageable pageabel);
		@Query("select e from ClassSt e where e.autoId like :x")
		public ClassSt getIdClass(@Param("x")Long autoId);		
	@Transactional
	  @Modifying(clearAutomatically = true)
	    @Query("update ClassSt c set c.section = :section , c.livel = :livel where c.autoId = :autoId")
	    void updateClass(@Param("autoId") Long autoId, @Param("section") String section, @Param("livel") String livel);
	  
		 @Query("select x from ClassSt x")
		    public List<ClassSt> findAllActivit();

		
//			
//			@Transactional
//		    @Modifying
//			@Query("delete from ClassStudent o.section like :s and o.livel like :l") 
	/*//		public void deleteYears(@Param("s")String section,@Param("l")String level);
	 * 
	 * 
	 * 
	 */
	/*	@Modifying
	   @Query("update ClassSt u set u.section =:s , u.livel =:l where u.autoId =:a")
	   void updateClass(@Param("a") Long autoId);*/
		
		
	
	
		
		
		
		
		
		
		
		
		
		
	//	public List<ClassStudent> FindBy
		
	
/*
		@Query("select o from ClassStudent o where o.etudiant.n_regi like :x") 
	    public Page<ClassStudent> chercherRegiTowTable(@Param("x")String n_regi,Pageable pageabel);
	
		@Query("select o from ClassStudent o where o.etudiant.n_regi like :x and o.yearsStady like :y") 
		 public ClassStudent findYears(@Param("x")String n_regi,@Param("y")String yeras);
	
		@Transactional
	    @Modifying
		@Query("delete from ClassStudent o where o.etudiant.n_regi like :x and o.yearsStady like :y") 
		public void deleteYears(@Param("x")String n_regi,@Param("y")String years);
		
		@Query("select o from ClassStudent o where o.yearsStady like :y") 
		 public ClassStudent findYearsOne(@Param("y")String yeras);
	*/

		/*@Modifying
		@Query("update ClassStudent c set c.section = ?, c.livel = ? where etudiant.n_regi like :x and yearsStady like :y")
		 public ClassStudent updateClass(@Param("x")String n_regi,@Param("y")String yeras);
		
		
		*/
		//		@Query("update ClassStudent SET  where etudiant.n_regi like :x and yearsStady like :y") 

		/*@Query("select o from ClassStudent o where o.etudiant.n_regi like :x and o.yearsStady like :y") 
		public ClassStudent getYearsClass(@Param("x")String n_regi, @Param("y")String years);
	
	 		*/


	
}