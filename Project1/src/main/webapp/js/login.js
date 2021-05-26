/**
 * 
 */


/* 
 window.onload = function(){
	getSessVill();
}


function getSessVill() {
	//console.log("a"+xhttp);
	let xhttp = new XMLHttpRequest();
	console.log("b"+xhttp);
	
	xhttp.onreadystatechange = function(){
		console.log("c"+xhttp);
		console.log("state value:  "+xhttp.readyState);
		console.log("status value:  "+xhttp.status);
		if(xhttp.readyState == 4 && xhttp.status==200){
alert("inside"+xhttp.status)

console.log(xhttp.responseText);
			let vill = JSON.parse(xhttp.responseText);
			console.log("vill value is:"+vill);
			console.log("-----------------------");
			//console.log(vill.USER_FIRST_NAME);



}
	}
	
	//xhttp.open("GET", "http://localhost:8080/Project1/getsessionvill.json");
	xhttp.open("GET", "http://localhost:8080/Project1/login.change");
	

	xhttp.send();
}

*/


window.onload = function(){
	let button =document.getElementById("subb").addEventListener("click", myFunction);
	console.log(button);
}



function myFunction() {
  alert ("Hello World!");
  
  
  let xhttp = new XMLHttpRequest();
  	let vill1 = xhttp.responseText;
  	alert(vill1);
  	console.log(vill1);
	console.log("b"+xhttp);
	
	xhttp.onreadystatechange = function(){
		console.log("c"+xhttp);
		console.log("state value:  "+xhttp.readyState);
		console.log("status value:  "+xhttp.status);
		if(xhttp.readyState == 4 && xhttp.status==200){
alert("inside"+xhttp.status)

console.log(xhttp.responseText);
			//let vill = JSON.parse(xhttp.responseText);
			let vill = xhttp.responseText;
			console.log("vill value is:"+vill);
			console.log("-----------------------");
			//console.log(vill.USER_FIRST_NAME);



}
	}
	
	xhttp.open("GET", "http://localhost:9026/Project1/login.change");
	//xhttp.open("GET", "http://localhost:8080/Project1/login.change");
	

	//xhttp.send();
}





