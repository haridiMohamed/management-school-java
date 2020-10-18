package com.school.uted.miteir;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;

import com.school.uted.entities.ClassSt;
import com.school.uted.entities.Etudiant;
import com.school.uted.entities.FinanceStudent;

public interface SchoolMiteir {
	 public void updateClass(ClassSt updateC, EntityManager em);
	public List<ClassSt>list();
	public Etudiant consulterEtudiant(String n_regi);
	public ClassSt getInfoClass(String section,String level);

	public Page<ClassSt>chercherRegiTowTable(String codeCompte,int page,int size);
	public Page<FinanceStudent>chercherFinance(String N_regi,String years,int page,int size);
	
}
