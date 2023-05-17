function checkValue(obj, message){
	var val= obj.value;
	if(val == ""){
		alert(message);
		obj.focus();
		return true;
	}
	return false;
}