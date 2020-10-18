package com.school.uted.web;



import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.school.uted.dao.ClassRepository;
import com.school.uted.dao.EtudiantRepository;
import com.school.uted.dao.FinanceRepository;
import com.school.uted.dao.ReposetoryStdClass;
import com.school.uted.entities.ClassSt;
import com.school.uted.entities.ClassStudent;
import com.school.uted.entities.Etudiant;
import com.school.uted.entities.FinanceStudent;
import com.school.uted.miteir.SchoolMiteir;
import com.school.uted.entities.ClassStudent;

@Controller
@RequestMapping("/")
public class EtudiantController extends HttpServlet {
	@Autowired	
	private EtudiantRepository etudiantRepository; 
	@Autowired	
	private ClassRepository classRepository;
	@Autowired
	SchoolMiteir schoolMiteir;
	@Autowired
	private FinanceRepository financeRepository;
	@Autowired
	private ReposetoryStdClass reposetoryStdClass;
	
	
	 Long autoId;
	
	//path for fielder but not create this patch because it create in run (MAIN)
	
	String relativeWebPath ="imagepro/student"+File.separator;
	String absoluteDiskPath =  System.getProperty("user.home")+File.separator+relativeWebPath;
	
/*
    
									SOR GET PAGE EYMPT

	*/
//	@RequestMapping("/login")
//	public String login() {
//		return "index";
//}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
}
	@RequestMapping("/financeStudent")
	public String FinanceStudent() {
		return "pages/financeStudent";
}
	@RequestMapping("/infofinStudent")
	public String infofinStudent() {
		return "pages/infofinStudent";
}

	//send constructor empty to page newStudent html for pace exception thymeleaf  th:field
	@Secured(value= {"ROLE_ADMIN","ROLE_SCOLARITE"})
	@RequestMapping(value="/newstudent",method=RequestMethod.GET)
	public String newEtudiant(Model model) {
		model.addAttribute("etudiant",new Etudiant());
		return "pages/newstudent";
	}	
	
	//send constructor empty to page classStudent html for pace exception thymeleaf  th:field
	@Secured(value= {"ROLE_ADMIN","ROLE_SCOLARITE"})
	@RequestMapping(value="/classStudents",method=RequestMethod.GET)
	public String AddClass(Model model) {
		model.addAttribute("classStudent",new ClassSt());
		model.addAttribute("getNregi",new Etudiant());
		return "pages/classStudents";
	}
	@RequestMapping(value="/financeStudent",method=RequestMethod.GET)
	public String financeStudent(Model model) {
		model.addAttribute("finance",new FinanceStudent());
		model.addAttribute("getNregi",new Etudiant());
		return "pages/financeStudent";
	}
	/*
	
	             						SEARCH INFORMATIONS STUDENTS
	
	*/
				
	
	
	 @RequestMapping(value="/searchStudent")
	public String searchStudent(Model model,
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="motCin",defaultValue="")String n_regi) {
		
			Page<Etudiant>cinEtudiants= etudiantRepository.chercherCinEtudiants("%"+n_regi+"%",new PageRequest(p,10));	
		//	Page<ClassStudent>dEtudiants= classRepository.chercherRegiTowTable("%"+cin+"%",new PageRequest(p,3));	
			
			int pageCount = cinEtudiants.getTotalPages();
			int[] pages = new int[pageCount];
			for(int i=0;i<pageCount;i++)
				pages[i]=i;
			model.addAttribute("pages", pages);
			model.addAttribute("cinEtudiants", cinEtudiants.getContent());
		//	model.addAttribute("dEtudiants", dEtudiants.getContent());			
			model.addAttribute("pageCourante",p); 
			model.addAttribute("motCin", n_regi);
			return "pages/searchStudent";
		}
	 
	    /*
	 
	 						           				SEARSH CLASS
	 
		*/
	 @RequestMapping(value="/newclass")
		public String getClass(Model model,
				@RequestParam(name="page",defaultValue="0") int p,
				@RequestParam(name="motCin",defaultValue="")String n_regi) {
			
				//Page<Etudiant>cinEtudiants= etudiantRepository.chercherCinEtudiants("%"+n_regi+"%",new PageRequest(p,3));	
				Page<ClassSt>dEtudiants= classRepository.chercherYearsClass("%"+n_regi+"%",new PageRequest(p,10));	
				int pageCount = dEtudiants.getTotalPages();
				int[] pages = new int[pageCount];
				for(int i=0;i<pageCount;i++)
					pages[i]=i;
				model.addAttribute("pages", pages);
				model.addAttribute("listclass", dEtudiants.getContent());
				model.addAttribute("classSt",new ClassSt());
				model.addAttribute("pageCourante",p); 
				model.addAttribute("motCin", n_regi);
				return "pages/newClass";
			}
		/*
	 														SAVE INFORMATIONS STUDENT
	 
	
	    */					
	
	
	@RequestMapping(value="/SaveEtudiant",method=RequestMethod.POST)
	public String saveEtudiant(@Valid Etudiant et,
		BindingResult bindingResult,
	@RequestParam(name="picture")MultipartFile file) throws Exception  
			{
	if(bindingResult.hasErrors()) {
				
		return "pages/newstudent";
	}
	
	//etudiantRepository.save(et);
	// ida kana tojado sora da3 ism l7a9i9i dakhila photo
	if(!file.isEmpty()) { 
		et.setPhoto(file.getOriginalFilename());
		}
	String n_regi = et.getN_regi();
	Etudiant e = etudiantRepository.findNregi(n_regi);
	if(e!=null) {
		
		return "redirect:/newstudent?error=1";
	}else {
		etudiantRepository.save(et);
	}
	// ida kana tojado sora 9om bi ta7wil sora ila milaf wa rabtiha bi n_regi
	 // IF WAS FIND PICTURE CONVIRE IT TO FILE AND RELATE WITH N_REGI--> STUDENT
	if(!file.isEmpty()) {
	
			et.setPhoto(file.getOriginalFilename());
			//this path for 
		    //String filePath = System.getProperty("java.io.tmpdir")  + file.getOriginalFilename();
			
			//save image onle
		   // String filePath = System.getProperty(absoluteDiskPath+ file.getOriginalFilename());
			
			
			//transfer picture with N_regi (picture with n_regi in one fichier)
		    file.transferTo(new File(absoluteDiskPath+et.getN_regi()));		   
	}
	return "redirect:/getStdClass?n_regi="+n_regi;
//	return "pages/newstudent";
	}	
	/*
               											Get picture for Page HTML
	
	*/
			@RequestMapping(value="/getPhoto",
			produces=MediaType.IMAGE_JPEG_VALUE)
			@ResponseBody
			public byte[] getPhotp(String n_regi) throws Exception {
			//	System.out.println(absoluteDiskPath+n_regi);
				File f = new File(absoluteDiskPath+n_regi);
				return IOUtils.toByteArray(new FileInputStream(f));				
			}
			/*			
															 SAVE CLASS
			
			*/
	@RequestMapping(value="/SaveClass",method=RequestMethod.GET )
	public String SaveClass(@Valid ClassSt cs,
		BindingResult bindingResult)throws Exception
			{
	if(bindingResult.hasErrors()) {
		return "pages/newClass";		
	}
	
	String section = cs.getSection();
	String level=cs.getLivel();
	Long autoId = cs.getAutoId();
	ClassSt csq = new ClassSt(); 
	
	csq=classRepository.getInfoClass(section, level);
	
if(csq==null) {
	classRepository.save(cs);
	return "redirect:/newclass?msg3=";
}else {
	
	
	return "redirect:/newclass?error1=";
	}
}
	@RequestMapping(value="/updateClass",method=RequestMethod.GET)
	public String updateClassSt(@Valid ClassSt cs) {
		
		Long autoId = cs.getAutoId();
		String section = cs.getSection();
		String level = cs.getLivel();
		
		classRepository.updateClass(autoId, section, level);
		
		return "redirect:/newclass?msg2=";
		
		
	}
	/*
														GET INFORMATION CLASS FOR STUDENT
	
	
	*/
@RequestMapping(value="/getStdClass",method=RequestMethod.GET)
public String consulter(Model model ,String n_regi) {
	 model.addAttribute("classStudent", n_regi);
	
	 try {
		 Etudiant et= schoolMiteir.consulterEtudiant(n_regi);
	
			List<ClassSt> cls = classRepository.findAllActivit();
			Etudiant et1 = etudiantRepository.findNregi(n_regi);

	      model.addAttribute("etudiant",et);
	      model.addAttribute("listclass",cls);
	      model.addAttribute("classStudent",new ClassSt());
	     // model.addAttribute("classStudent",etds.toString());
	     model.addAttribute("list",et1.getClassStudent());
     
	 }catch(Exception e) {
		 return "redirect:/classStudents?error="+e.getMessage();
	 }	
	 return "pages/classStudents";	
}
	
/*	
													DELETE INFORMATION STUDENT

*/
@RequestMapping(value="/delete")
public String delete(String n_regi) {
try {
etudiantRepository.delete(n_regi);
}catch(Exception e) {
return "redirect:/searchStudent?error="+e.getMessage()+"**********this my massege**********";
}
return "redirect:searchStudent";
}

/*	
												DELETE INFORMATION CLASS

*/
@RequestMapping(value="/deleteClass")
public String deleteClass(Long autoId) {
System.out.println(autoId);

try {
	ClassSt cs = new ClassSt();
	
classRepository.delete(autoId);
}catch(Exception e) {
return "redirect:/newclass?error1=";
}
return "redirect:/newclass";
}

      /*       					         		 UPDATE STUDENT
            									 get N_regi for update

	*/
@RequestMapping(value="/update")		
		public String update(Model model,String n_regi) {			
			Etudiant et = etudiantRepository.getOne(n_regi);
			model.addAttribute("etudiant",et);
		return "pages/updateStudent";
}
	
		
   /* 
													UPDATE INFORMATIONS Student
		

	*/	
@RequestMapping(value="/updateEtudiant",method=RequestMethod.POST)
public String supdateEtudiant(@Valid Etudiant et,
BindingResult bindingResult,
@RequestParam(name="picture")MultipartFile file) throws Exception  
{
if(bindingResult.hasErrors()) {

return "pages/updatestudent";
}
String n_regi= et.getN_regi();
//Date dateRegistr=et.getDateRegistr();
String cin=et.getCin(); 
//Date dateCard=et.getDateCard(); 
String firstname=et.getFirstname(); 
String lastname=et.getLastname(); 
Date dateNaissance=et.getDateNaissance();
String livelStudy=et.getLivelStudy();
String adrres=et.getAdrres();
String city=et.getCity();
String tel=et.getTel(); 
String email=et.getEmail();
String photo=et.getPhoto();

if(!file.isEmpty()) { et.setPhoto(file.getOriginalFilename());}

etudiantRepository.updateSt(n_regi, cin, firstname, lastname, 
		                   dateNaissance, livelStudy, adrres, city, tel, email, photo);
if(!file.isEmpty()) {
et.setPhoto(file.getOriginalFilename());
file.transferTo(new File(absoluteDiskPath+et.getN_regi()));	   
}
return "redirect:searchStudent";

}
/*

											get all information about student by n_regi and years Study
                           // my problem here i can't get years from page SearshStuden.html because i don't have it
                            * i thank i well remove info class from this page and let info student alone 
*/
@RequestMapping(value="/infoStudent")
public String infoStudent(Model model,String n_regi,String years) {
	// Etudiant et= schoolMiteir.consulterEtudiant(n_regi);
	//ClassStudent cs = reposetoryStdClass.findyears(years);
	Etudiant et = etudiantRepository.getOne(n_regi);
	//cs.getYears();
	List<ClassSt> cls = classRepository.findAllActivit();
	 
	List<ClassStudent> cs=reposetoryStdClass.findAllClass(n_regi);
	
	//System.out.println("----- *****-----"+cs.getYears());
	 //ClassStudent cs= schoolMiteir.consulterClassStudent(years);
	//ClassStudent cs = classRepository.findAll(n_regi);
//	model.addAttribute("etudiantclass",cs.getYears());
	model.addAttribute("classStudent",cs);	
	model.addAttribute("etudiant",et);
	model.addAttribute("list",et.getClassStudent());
	return "pages/infoStudent";
}


/*
											FOR SAVE CLASS STUDENT

*/
@RequestMapping(value="/saveClassStd",method = RequestMethod.POST)
public String Greeting(Model model,String n_regi ,Long autoId,String years,String dateRegistr,String livel){
	System.out.println(n_regi);
	System.out.println(autoId);
	Etudiant et = etudiantRepository.findNregi(n_regi);
    ClassSt cs1 =classRepository.findOne(autoId);
	   ClassStudent classStudent = new ClassStudent();
	   Set<ClassStudent> classStudent2 = new HashSet<ClassStudent>();
	   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	   
	   classStudent.setStudent(et);
	   classStudent.setClassSt(cs1);
	   classStudent.setYears(years);
	   classStudent.setLivel(livel);
	   try {
		classStudent.setDateRegistr(df.parse(dateRegistr));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   classStudent2.add(classStudent);
        //et.addClassStudent(classStudent);
        et.setClassStudent(classStudent2);
        
      etudiantRepository.save(et);
    return "redirect:/getStdClass?n_regi="+n_regi;

}

/*
                                            FOR DELETE CLASS STUDENT

*/
@RequestMapping(value="/deleClassStd",method = RequestMethod.POST)
public String DeletClasStd(Model model,String n_regi ,String years,Long autoId){

	Etudiant et = etudiantRepository.findNregi(n_regi);
    ClassSt cs1 =classRepository.findOne(autoId);
	 
	 ClassStudent classStudent = new ClassStudent();
	 classStudent.setStudent(et);
     classStudent.setClassSt(cs1);
     classStudent.setYears(years);
     
     System.out.println("After   :  "+et.getClassStudent().size());
    // reposetoryStdClass.deleteYears(n_regi,autoId);
    et.getClassStudent().remove(classStudent); 
    // reposetoryStdClass.delete(classStudent);
     reposetoryStdClass.delete(classStudent);
     
    System.out.println("years  :  "+years);  
     System.out.println("Before  :  "+et.getClassStudent().size());  
  //   System.out.println("for class  :  "+ classStudent.getClassStudent().size());   
     etudiantRepository.save(et);
	 System.out.println("Before2  :  "+et.getClassStudent().size());	
		   return "redirect:/getStdClass?n_regi="+n_regi;
}

/*

																SAVE FINANCE
*/

@RequestMapping(value="/SaveStFinance",method=RequestMethod.GET )
public String SaveStFinance(@Valid FinanceStudent fc,
BindingResult bindingResult)throws Exception
{
	
String n_regi=fc.getStudent().getN_regi();
String years=fc.getYears();
int regi = fc.getRegistration();
int school= fc.getSchooling();
int other= fc.getOther();
fc.setTotal(regi+school+other);
fc.setDate_received(new Date());
/*String month=fc.getMonth();
FinanceStudent fc2 = new FinanceStudent();
fc2=financeRepository.findMonthFinance(month);
String month1=fc2.getMonth();*/
if(bindingResult.hasErrors()) {

return "redirect:/getStfinance?n_regi="+n_regi+"&years="+years;
}
if(n_regi==null) {
	financeRepository.save(fc);
}

//Long n_received =fc.getN_received();
return "redirect:/getStfinance?n_regi="+n_regi+"&years="+years;
}
/*
													GET FINANCE STUDENT BY N_REGI AND YEARS


*/
@RequestMapping("/getStfinance")
public String getAllStfinance(Model model ,
		  @RequestParam(name="n_regi")String n_regi ,
		  @RequestParam(name="years")String years,
		  @RequestParam(name="page",defaultValue="0")int page ,
		  @RequestParam(name="size",defaultValue="3")int size ) {

try {
ClassStudent cs = reposetoryStdClass.findyears(years,n_regi);
Etudiant et = etudiantRepository.findNregi(n_regi);

//ClassSt cs=classRepository.getIdClass(autoId);
et.getClassStudent();
Page<FinanceStudent>pageFinance=schoolMiteir.chercherFinance(n_regi,years, page, size);



int pageCount = pageFinance.getTotalPages();
int[] pages = new int[pageCount];
for(int i=0;i<pageCount;i++)
	pages[i]=i;
//number on page
model.addAttribute("pageCourante",page); 
//pages count
model.addAttribute("pages",pages);
model.addAttribute("etudiant",et);
model.addAttribute("classStd",cs);
model.addAttribute("financeliste",pageFinance.getContent());
model.addAttribute("finance",new FinanceStudent());
}catch(Exception e) {
return "redirect:/financeStudent?error="+e.getMessage();
}	
return "pages/financeStudent";	
}

/*
													DELETE INFORMATION FINANCE

*/
@RequestMapping(value="/deleteFinance")
public String deleteFinance(Long n_received,String n_regi,String years) {
try {
financeRepository.delete(n_received);
}catch(Exception e) {
return "pages/financeStudent";
}
return "redirect:/getStfinance?n_regi="+n_regi+"&years="+years;
}



/*


                                  FIN CODE FOR MANAGEMENT STUDENT



*/










// test operation in home page
@RequestMapping(value = "/getRegi", method = RequestMethod.GET)
public String intro(Model model)
{
	List<ClassSt> cut = classRepository.findAllActivit();
	
	
	for(ClassSt modelee : cut) {
		model.addAttribute("first",modelee.getSection());
		model.addAttribute("laste",modelee.getLivel());

    }
	
	
  return "home";
}




//@ResponseBody
//@RequestMapping(value="/deleClassStd",method = RequestMethod.POST)
//public String DeletClasStd(Model model,String getRegi ,Long autoId){
//	  Set<ClassStudent> classStudent = new HashSet<ClassStudent>();
//	System.out.println(getRegi);
//	System.out.println(autoId);
//	 ClassStudent cs1 =classRepository.findOne(autoId);
//	
//	Etudiant et = etudiantRepository.findNregi(getRegi);
//	System.out.println(": "+et.getClassStudent());
//	
//	 et.getClassStudent().remove(cs1); 
//	 classStudent.addAll(et.getClassStudent());
//	  et.setClassStudent(classStudent);
//	  etudiantRepository.save(et);
//	  // System.out.println("Return value after remove: "+isremoved);
//	   System.out.println(": "+et.getClassStudent());
//    return "Delete Good";
//}

/*
//get info class for update class

@RequestMapping(value="/updateC")
public String updateClass(Model model,String years,String section,String level) {
	 ClassStudent cs= schoolMiteir.getInfoClass(years,section,level);
	model.addAttribute("classStudent",cs);
	
	///return "redirect:/newclass";
	return "pages/newClass";	

}*/
/*@RequestMapping(value="/updateC")
public String updateClass(Model model,String years,String section,String level) {
	 ClassStudent cs= schoolMiteir.getInfoClass(years,section,level);
	model.addAttribute("classStudent",cs);
	String update = "update";
	model.addAttribute("update",update);
	///return "redirect:/newclass";
	return "pages/newClass :: modalContents";	

}*/

/*	//update class

@RequestMapping(value="/updateClassS",method=RequestMethod.GET)
public String updateClass(@Valid ClassStudent sc,
BindingResult bindingResult)throws Exception  
{
if(bindingResult.hasErrors()) {

return "pages/newclass";
}
String section = sc.getSection();
String level = sc.getLivel();
String years = sc.getYearsStady();
System.out.println(section);
System.out.println(level);
System.out.println(years);
classRepository.save(sc);
return "redirect:/newclass";
}

	
	
	*/
	



/*
			//get information class
//@RequestMapping("/getStfinance")
//public String getStfinance(Model model ,String n_regi,String years)
//	 {
// try {
//	 
//	 ClassStudent cs = classRepository.findYears(n_regi, years);	
//	  model.addAttribute("finance",new FinanceStudent());
//      model.addAttribute("etudiant",cs);
//      
// }catch(Exception e) {
//	 return "redirect:/financeStudent?error="+e.getMessage();
// }	
// return "pages/financeStudent";	
//}
//
//
//@RequestMapping("/getAllStfinance")
// public String getAllStfinance (Model model,String n_regi) {
//
////  Page<ClassStudent>pageClass=schoolMiteir.chercherRegiTowTable(n_regi, page, size);
//
// FinanceStudent fs= financeRepository.findYearsFinance(n_regi);
// 
//  model.addAttribute("finance",new FinanceStudent());
//  model.addAttribute("finance",fs);
//
//
//
//return "pages/AllfinanceStudent";
//}


*/


//@ResponseBody
//@RequestMapping(value = "/home", method = RequestMethod.GET)
//public Des getResource() {
//new Gson(.toJson());
//return "hello haridi you can't find your way";
//}
	
	
	
	




}