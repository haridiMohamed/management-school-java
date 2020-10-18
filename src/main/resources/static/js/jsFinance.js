$(document).ready(function(){
	$("#edit_finance").click(function(){
		
		$(".test").hide();
		
	});	
	
	$(".delFinance").click(function(){
		//for change title in modal bootstrap
	 	$("#dele-modal .modal-title").html("Delete Received");
	 	$("#dele-modal button[type=submit]").html("Delete");
	 	id =$(this).find(".n_received").html();
	 	years =$(this).find(".years").html();
	 	n_regi=$(this).find(".n_regi").html();
		$("#dele-modal input[name=n_received").val(id);
		$("#dele-modal input[name=years").val(years);
		$("#dele-modal input[name=n_regi").val(n_regi);
	
	});
	
	$(".editFinance").click(function(){
	 	regi =$(this).find(".regi").html();
	 	schooling =$(this).find(".Schooling").html();
	 	other =$(this).find(".Other").html();
	 	rece =$(this).find(".rece").html();
	 	
		$("input[id=registration").val(regi);
		$("input[id=Schooling").val(schooling);
		$("input[id=Other").val(other);
		$("input[id=n_received").val(rece);
	});

	
	
});