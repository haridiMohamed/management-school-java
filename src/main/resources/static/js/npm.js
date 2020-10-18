$(document).ready(function(){
	$(".delStdClass").click(function(){
		//for change title in modal bootstrap
	 	$("#dele-modal .modal-title").html("Delete Sector");
	 	$("#dele-modal button[type=submit]").html("Delete");
	 	years =$(this).find(".years").html();
	 	id =$(this).find(".autoId").html();
	 	regi=$(this).find(".n_regi").html();
	 	livel=$(this).find(".livel").html();
		$("#dele-modal input[name=autoId]").val(id);
		$("#dele-modal input[name=n_regi]").val(regi);
		$("#dele-modal input[name=years]").val(years);
		$("#dele-modal input[name=livel]").val(livel);
	});
	
	$("#addClassStd").click(function(){
		//for change title in modal bootstrap
	 	$("#save-modal .modal-title").html("Save Sector");
	 	$("#save-modal button[type=submit]").html("Save");
	 	//id =$(this).find(".autoId").html();
	 	 getword=$("#jqxListBox").find(":selected").val();
	 	 getyears=$("#jqxlistyears").find(":selected").val();
	 	 getlivel=$("#jqyears").find(":selected").val();
	 	getdateregi=$("#dateRegistr").val();
	 	

//	 	 getdateregi=$("#dateRegistr").find(":selected").val();
	//	id =$(this).find(".autoId").html();
	 	regi=$(this).find(".n_regi").html();
		$("#save-modal input[name=autoId]").val(getword);
		$("#save-modal input[name=n_regi]").val(regi);
		$("#save-modal input[name=livel]").val(getlivel);
		$("#save-modal input[name=years]").val(getyears);
		$("#save-modal input[name=dateRegistr]").val(getdateregi);
		
		
	});
$(".edit_finance").click(function(){
		
		$(this).hide();
		
	});	
	
});