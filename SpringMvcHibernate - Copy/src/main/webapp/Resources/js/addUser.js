function myFunction() {
  alert("I am an alert box!");
}
function formValidation2() {
	// Make quick references to our fields.
	var userName = document.getElementById('userName');
	
	
	
	// Check each input in the order that it appears in the form.
	
	
		if(inputAlphabet(userName, "* For User Name please use alphabets only *")){
							
							return true;
				}
		return false;
}
//Function that checks whether input text is an alphabetic character or not.
function inputAlphabet(inputtext, alertMsg) {
var alphaExp = /^[a-z A-Z]+$/;
if (inputtext.value.match(alphaExp)) {
return true;
} else {
document.getElementById('p1').innerText = alertMsg; // This segment displays the validation rule for name.
//alert(alertMsg);
inputtext.focus();
return false;
}
}