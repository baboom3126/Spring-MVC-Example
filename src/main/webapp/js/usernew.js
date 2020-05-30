
function newuser(){
	var userId = $("#userId").val();
	var userName = $("#userName").val();
	console.log(userId+" : "+userName);
	
	
	$.ajax({
		type: 'POST',                    
		url: "/demo3/user/"+userId+"/"+userName,              
		cache: false,                    
		success :function(result){
			alert("success");
			$("#userId").val("");
			$("#userName").val("");
		}
	});
}


