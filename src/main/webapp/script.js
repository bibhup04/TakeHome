

function checkPassword(){
	
	var p1 = document.getElementById("pass").value;
	var p2 = document.getElementById("confPass").value;
	
	if(p1 != p2 || p1.length == 0){
		alert("Please enter same password for both the field.");
		return false;
	}
	else{
		//alert("Password matching.");
		return true;
	}
}