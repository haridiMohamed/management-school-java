package com.school.uted;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.school.uted.dao.ClassRepository;
import com.school.uted.dao.EtudiantRepository;
import com.school.uted.dao.FinanceRepository;
import com.school.uted.dao.ReposetoryStdClass;
import com.school.uted.entities.ClassSt;
import com.school.uted.entities.ClassStudent;
import com.school.uted.entities.Etudiant;
import com.school.uted.entities.FinanceStudent;



@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private ClassRepository classRepository;
	@Autowired
	private FinanceRepository financeRepository;
	@Autowired
	private ReposetoryStdClass reposetoryStdClass;
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	//create patch auto 
	String relativeWebPath ="imagepro"+File.separator;
	String absoluteDiskPath =  System.getProperty("user.home")+File.separator+relativeWebPath;
	String relativeWebPath2 ="teacher"+File.separator;
	String relativeWebPath1 ="student"+File.separator;
	  // add file
	 File file2 = new File(absoluteDiskPath,relativeWebPath2);
	 File file1 = new File(absoluteDiskPath,relativeWebPath1);
	 file2.mkdirs();
	 file1.mkdirs();
     if (!file2.exists()) {
         if (file2.mkdir()) {
             System.out.println("Directory is created!");
         } else {
             System.out.println("Failed to create directory!");
         }
     }
     
//  ClassStudent cs=reposetoryStdClass.findyears("2016/2017","1");
    
  // System.out.println(" N_regi Student :"+ cs.getStudent().getN_regi());
   // System.out.println(" AutoId Student :"+ cs.getClassSt().getLivel());
  //  System.out.println(" Years Student :"+ cs.getYears());
     
/*    Etudiant et=etudiantRepository.save(new Etudiant("1",df.parse("08-05-1986"),"LB1345",df.parse("08-05-1986"),"simo"," harid",df.parse("08-05-1986"),"bac","haysalam","ksar","090909","email@email.com","image"));
    Etudiant et1=etudiantRepository.save(new Etudiant("2",df.parse("08-05-1986"),"LB1345",df.parse("08-05-1986"),"simo"," harid",df.parse("08-05-1986"),"bac","haysalam","ksar","090909","email@email.com","image"));

    ClassSt cs1 =classRepository.save(new ClassSt("TS","DI")); 
    ClassSt cs2 =classRepository.save(new ClassSt("TS2","DI")); */
   //  FinanceStudent fs1=financeRepository.save(new FinanceStudent(df.parse("08-05-1986"),"4",10,10,10,"frd","tt",30));
//     (Lo                                                      Long Date date_received,    String , int,int,int ,String, String , int)
//     List<ClassStudent> list = et.getClassStudent();
//    // List<ClassStudent> classStudent = etudiantRepository.findAll();
//     for(ClassStudent model : list) {
//       System.out.println(model);
//        }
//   ;
     
//   //  assertNotNull(et);
//     List<ClassStudent> list = et.getClassStudent();
////     assertTrue(list.size()>1);
////     assertTrue(list.contains(list));
//     System.out.println(list.size());
     
//     List<ClassStudent> cs = classRepository.findAllActivit();
//     for(ClassStudent model : cs) {
//         System.out.println(model.getSection()+"  "+model.getLivel()+"  "+model.getYearsStady());
//     }
     //Set<ClassStudent> classStudent = et.getClassStudent().contains(o);
    
    	 
     // System.out.println(classStudent.size());

     

    // System.out.println(et.size());
//
   
   /*  Etudiant et=etudiantRepository.save(new Etudiant("1",df.parse("08-05-1986"),"LB1345",df.parse("08-05-1986"),"simo"," harid",df.parse("08-05-1986"),"bac","haysalam","ksar","090909","email@email.com","image"));
     Etudiant et1=etudiantRepository.save(new Etudiant("2",df.parse("08-05-1986"),"LB1345",df.parse("08-05-1986"),"simo"," simoni",df.parse("08-05-1986"),"bac","haysalam","ksar","090909","email@email.com","image"));
     Etudiant et3=etudiantRepository.save(new Etudiant("3",df.parse("08-05-1986"),"LB1345",df.parse("08-05-1986"),"simo"," moha",df.parse("08-05-1986"),"bac","haysalam","ksar","090909","email@email.com","image"));

     ClassStudent cs1 =classRepository.save(new ClassStudent("2017","TS","GE")); 
    ClassStudent cs2 =classRepository.save(new ClassStudent("2017","TS2","GE")); 
    //  Etudiant et = etudiantRepository.findNregi("4");
     Set<ClassStudent> classStudent = new HashSet<ClassStudent>();
     Set<ClassStudent> classStudent2 = new HashSet<ClassStudent>();

     classStudent.add(cs1);
     classStudent.add(cs2);
     classStudent2.add(cs2);
       et.setClassStudent(classStudent);
       et1.setClassStudent(classStudent);
       et3.setClassStudent(classStudent2);
      etudiantRepository.save(et);
      etudiantRepository.save(et1);
      etudiantRepository.save(et3);
    System.out.println(et.toString());
    System.out.println(et1.toString());
    System.out.println(et3.toString());
    
    
    
//  et.getClassStudent();
//     List<Etudiant> stt =etudiantRepository.findAllActivit("1");
//     for(Etudiant model : stt) {
//         System.out.println(model.getN_regi());
//          }
  //   System.out.println(et.getClassStudent().containsAll(classStudent));
     
     
     /*
 ClassStudent employee = new ClassStudent();
 
 String years=employee.getYearsStady();
 employee=classRepository.findOne(("2017"));


 System.out.println(employee.getLivel());*/
 
 
 //ClassStudent cs = new ClassStudent("2017","TS","GE");

/*ClassStudent cs =new ClassStudent();
cs.setLivel("DI");
cs.setSection("TS");
cs.setYearsStady("2017");*/
// 
 /*//ClassStudent cs2 =classRepository.save(new ClassStudent("2017","TS","GE"));
   
     Set<ClassStudent> classStudent = new HashSet<ClassStudent>();
     Set<ClassStudent> classStudent = new HashSet<ClassStudent>();
    classStudent.add(cs);
   //  classStudent1.add(cs2);
  //   et.setClassStudent(classStudent1);
     et.setClassStudent(classStudent);
    // et1.setClassStudent(classStudent);
     etudiantRepository.save(et);   
     etudiantRepository.save(et1);
     
     
     
     
     */
     
       /**//*   
     Etudiant et1=etudiantRepository.save(new Etudiant("2",df.parse("08-05-1986"),"LB1345",df.parse("08-05-1986"),"simo"," harid",df.parse("08-05-1986"),"bac","haysalam","ksar","090909","email@email.com","image"));
     ClassStudent cs1 =classRepository.save(new ClassStudent("TS","DI","2018",et1)); */ /* */
     /* financeRepository.save(new FinanceStudent(new Date() ,"may",1, 2 , 3 , "check", "n13", 5,et,cs));
      * 
      * 
      * 
         Etudiant et1 =etudiantRepository.save(new Etudiant("1",df.parse("08-05-1986"),"LB1345",df.parse("08-05-1986"),"simo"," harid",df.parse("08-05-1986"),"bac","haysalam","ksar","090909","email@email.com","image"));
     classRepository.save(new ClassStudent("TS","DI","2017/2018",et1));
////		etudiantRepository.save(new Etudiant("LB6790","moha haridi",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("LC4598","start hr",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("LB1345","simo haridi",df.parse("08-05-1986"),"email@email.com","hay salam","08051234","image"));
////		etudiantRepository.save(new Etudiant("LB6790","moha haridi",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("C34598","start hr",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("LB12345","simo haridi",df.parse("08-05-1986"),"email@email.com","hay salam","08051234","image"));
////		etudiantRepository.save(new Etudiant("LB6890","moha haridi",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("LC3459","start hr",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));		
////		etudiantRepository.save(new Etudiant("B12345","simo haridi",df.parse("08-05-1986"),"email@email.com","hay salam","08051234","image"));
////		etudiantRepository.save(new Etudiant("B67890","moha haridi",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("C34598","start hr",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("L1345","simo haridi",df.parse("08-05-1986"),"email@email.com","hay salam","08051234","image"));
////		etudiantRepository.save(new Etudiant("L6790","moha haridi",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("L4598","start hr",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("LsB1345","simo haridi",df.parse("08-05-1986"),"email@email.com","hay salam","08051234","image"));
////		etudiantRepository.save(new Etudiant("LsB6790","moha haridi",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("Cs34598","start hr",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("LdB12345","simo haridi",df.parse("08-05-1986"),"email@email.com","hay salam","08051234","image"));
////		etudiantRepository.save(new Etudiant("LdB6890","moha haridi",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
////		etudiantRepository.save(new Etudiant("LgC3459","start hr",df.parse("10-05-1998"),"know@email.com","hay xgerl","08051234","image"));
//
//	//list from etudiant in page 	
////	Page<Etudiant> etds = etudiantRepository.findAll(new PageRequest(0,5));
////	etds.forEach(e->System.out.println(e.getNom()+ " -- "+e.getDateNaissance()));
////	
	*/
	}

}
