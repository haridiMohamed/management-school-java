var rh = rh ||{};
rh.mq = rh.mq ||{};
rh.mq.editing = false;
$(document).ready(function(){
	$("#showEdit").click(function(){

		if(rh.mq.editing){
			rh.mq.editing = false;
			$(".columnEdit").fadeToggle(1000).addClass();
			$(this).html("Show Edit");
		}else{
			rh.mq.editing= true;
			$(".columnEdit").fadeToggle(1000).removeClass("hidden");
			$(this).html("Done Edit");
		}
		
	 });

	$("#addClass").click(function(){
			//for change title         
			$("#inset-modal .modal-title").html("Insert Class");	
			$("#inset-modal button[type=submit]").html("Add Class");
			//make input empty
			$("#inset-modal input[name=section]").val("");
			$("#inset-modal input[name=livel]").val("");
			$("#inset-modal input[name=yearsStady]").val("");
			$("#inset-modal input[name=id]").val("").prop("disabled",true);
		});
		$(".deleClass").click(function(){
			//for change title in modal bootstrap
		 	$("#dele-modal .modal-title").html("Delete Class");
		 	$("#dele-modal button[type=submit]").html("Delete");
		 	id =$(this).find(".autoId").html();

			$("#dele-modal input[name=autoId]").val(id);
			
		});
		$(".editClass").click(function(){
			//for change title in modal bootstrap
		 	$("#inset-modal .modal-title").html("Edit this Class");
		 	$("#inset-modal button[type=submit]").html("Save Class");

		 	id =$(this).find(".autoId").html();
		 	section =$(this).find(".section").html();
		 	livel =$(this).find(".livel").html();
		 	yearsStady =$(this).find(".yearsStady").html();
		 	
			$("#inset-modal input[name=section]").val(section);
			$("#inset-modal input[name=livel]").val(livel);
			$("#inset-modal input[name=yearsStady]").val(yearsStady);
			$("#inset-modal input[name=autoId]").val(id);
			
		});
	
	
	});