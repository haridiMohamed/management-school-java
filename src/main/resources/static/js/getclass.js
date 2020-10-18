var rh = rh ||{};
rh.mq = rh.mq ||{};
rh.mq.editing = false;
$(document).ready(function(){	


	
	$("#showClassStudent").click(function(){

		if(rh.mq.editing){
			rh.mq.editing = false;
			$(".divTable").fadeToggle(1000).addClass("");
			$(this).html("Show All Class");
		}else{
			rh.mq.editing= true;
			$(".divTable").fadeToggle(1000).removeClass("hidden");
			$(this).html("Done All Class");
		}
		
	 });

	
//	$("#addClassStd").click(function(){
//		var url = window.location;
//		var getword=$("#jqxListBox").find(":selected").val();
//		var getRegi=$("#getRegi").val();
//
//		$.ajax({
//			type : "Post",
////			
//			url: "/saveClassStd",
//			 data: { 
//			        'getRegi': getRegi, 
//			        'getword': getword
//			      },
//			success: function(data){
//				alert("success save");
//			console.log(url);
//	        $("#div1").html(data);
//	        console.log(data);
//	    }
//			      });
//		
//			
//		
//		
//	});
	$("#showEditClass").click(function(){

		if(rh.mq.editing){
			rh.mq.editing = false;
			$(".columnEditClass").fadeToggle(1000).addClass("");
			$(this).html("Show Edit");
		}else{
			rh.mq.editing= true;
			$(".columnEditClass").fadeToggle(1000).removeClass("hidden");
			$(this).html("Done Edit");
		}
		
	 });
	$(".editClass").click(function(){
		//for change title in modal bootstrap
	 	$("#inset-modal .modal-title").html("Edit this Class");
	 	$("#inset-modal button[type=submit]").html("Save Class");

	 	id =$(this).find(".autoId").html();
	 	section =$(this).find(".section").html();
	 	livel =$(this).find(".livel").html();
	 //	yearsStady =$(this).find(".yearsStady").html();
	 	
		$("#inset-modal input[name=section]").val(section);
		$("#inset-modal input[name=livel]").val(livel);
	//	$("#inset-modal input[name=yearsStady]").val(yearsStady);
		$("#inset-modal input[name=autoId]").val(id);
		
	});
	
/*	
	$(".deletstdclass").click(function(){

		var autoId =$(this).find(".autoId").html();
		 alert(id);

		
		var url = window.location;
	var getword=$("#jqxListBox").find(":selected").val();
		var getRegi=$("#getRegi").val();
		id=$(this).find(".autoId").html();
		console.log(id);
		var getword=$(".autoId").val();
		$.ajax({
			type : "Post",
			
			url: "/deleClassStd",
			 data: { 
			        'getRegi': getRegi, 
			        'autoId': autoId
			      },
			success: function(data){
				alert("success Delete");
			console.log(url);
	        $("#div1").html(data);
	        console.log(data);
	    }
	});
	});
	*/
});