package com.school.uted.dao;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.uted.entities.ClassSt;
import com.school.uted.entities.Etudiant;
import com.school.uted.entities.FinanceStudent;

public interface FinanceRepository extends JpaRepository<FinanceStudent, Long> {

	
/*	@Query("select o from FinanceStudent o where o.etudiant.n_regi like :x and o.classStudent.yearsStady like :y") 
	 public FinanceStudent findFinance(@Param("x")String n_regi,@Param("y")String yeras);*/
	@Query("select e from FinanceStudent e where e.Month like :m")
	public FinanceStudent findMonthFinance(@Param("m")String month);
	

	
	
	@Query("select o from FinanceStudent o where o.student.n_regi like :x and o.years like :y order by o.date_received desc") 
    public Page<FinanceStudent> chercherFinance(@Param("x")String n_regi,@Param("y")String years,Pageable pageabel);

}
