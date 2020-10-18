package com.school.uted.miteir;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.uted.dao.ClassRepository;
import com.school.uted.dao.EtudiantRepository;
import com.school.uted.dao.FinanceRepository;
import com.school.uted.entities.ClassSt;
import com.school.uted.entities.Etudiant;
import com.school.uted.entities.FinanceStudent;
@Service
@Transactional
public class SchoolMiteirImplement implements SchoolMiteir {
	@Autowired	
	private EtudiantRepository etudiantRepository; 
	@Autowired	
	private ClassRepository classRepository;
	
	@Autowired	
	private FinanceRepository financeRepository;
	
	@Override
	public Page<ClassSt> chercherRegiTowTable(String n_regi, int page, int size) {
		
		//return classRepository.chercherRegiTowTable(n_regi,new PageRequest(page,size));
		return null;
	}
	@Override
	public Etudiant consulterEtudiant(String n_regi) {
		Etudiant et=etudiantRepository.findOne(n_regi);
		if(et==null) throw new RuntimeException("Etudiant Introuvable");
		return et;
	}
	@Override
	public ClassSt getInfoClass(String section,String level) {
		ClassSt cs=classRepository.getInfoClass(section, level);
		if(cs==null) throw new RuntimeException("ClassStudent Introuvable");
		return cs;
	}
	@Override
	public Page<FinanceStudent> chercherFinance(String N_regi,String years, int page, int size) {
		return financeRepository.chercherFinance(N_regi,years,new PageRequest(page,size));
	}

	@Override
	public List<ClassSt> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateClass(ClassSt updateC, EntityManager em) {
		ClassSt existingUser = em.find(ClassSt.class, updateC.getAutoId());  
	       if (existingUser != null) {  
	         //  existingUser.merge(updateC);  
	       }  		
	}

	

}
