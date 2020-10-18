var rh = rh ||{};
rh.mq = rh.mq ||{};
rh.mq.editing = false;
$(document).ready(function(){	
//	$("#jqxListBox").jqxListBox({ width: '200px', height: '50px'}); 
//	$("#jqxListBox").jqxListBox('loadFromSelect', 'select');	
	
	$("#showEdit").click(function(){

		if(rh.mq.editing){
			rh.mq.editing = false;
			$(".columnEdit").fadeToggle(1000).addClass("");
			$(this).html("Show Edit");
		}else{
			rh.mq.editing= true;
			$(".columnEdit").fadeToggle(1000).removeClass("hidden");
			$(this).html("Done Edit");
		}
		
	 });

	$("#addClass").click(function(){
			//for change title         
			$("#inset-modal .modal-title").html("Insert Sector");	
			$("#inset-modal button[type=submit]").html("Add Sector");
			//make input empty
			$("#inset-modal input[name=section]").val("");
			$("#inset-modal input[name=livel]").val("");
			$("#inset-modal input[name=yearsStady]").val("");
			$("#inset-modal input[name=id]").val("").prop("disabled",true);
		});
		$(".deleClass").click(function(){
			//for change title in modal bootstrap
		 	$("#dele-modal .modal-title").html("Delete Sector");
		 	$("#dele-modal button[type=submit]").html("Delete");
		 	id =$(this).find(".autoId").html();

			$("#dele-modal input[name=autoId]").val(id);
			
		});
		$(".editClass").click(function(){
			//for change title in modal bootstrap
		 	$("#update-modal .modal-title").html("Edit this Sector");
		 	$("#update-modal button[type=submit]").html("Save Class");

		 	id =$(this).find(".autoId").html();
		 	section =$(this).find(".section").html();
		 	livel =$(this).find(".livel").html();
		 	yearsStady =$(this).find(".yearsStady").html();
		 	
			$("#update-modal input[name=section]").val(section);
			$("#update-modal input[name=livel]").val(livel);
			$("#update-modal input[name=yearsStady]").val(yearsStady);
			$("#update-modal input[name=autoId]").val(id);
			
		});
	
		$(".deleStudent").click(function(){
			//for change title in modal bootstrap
		 	$("#dele-modal .modal-title").html("Delete Student");
		 	$("#dele-modal button[type=submit]").html("Delete");
		 	id =$(this).find(".n_regi").html();

			$("#dele-modal input[name=n_regi").val(id);
			
		});

		
	});