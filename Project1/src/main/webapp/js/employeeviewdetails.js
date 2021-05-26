/**
 * 
 */

/*

 window.onload = function(){
	getSessVill();
	alert("inside employeeview js");
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
	xhttp.open("GET", "http://localhost:9026/Project1/Reimbursemnet.reim");
	

	xhttp.send();
}


*/

window.onload = function(){
	
}

let button =document.getElementById("bvse").addEventListener("click", myFunction);
	console.log(button);

function myFunction() 

{
  alert ("inside employee js");
  
  
  let xhttp = new XMLHttpRequest();
  	let vill1 = xhttp.responseText;
  	alert(vill1);
  	console.log(vill1);
	console.log("b"+xhttp);
	
	xhttp.onreadystatechange = function(){
/*

		console.log("c"+xhttp);
		console.log("state value:  "+xhttp.readyState);
		console.log("status value:  "+xhttp.status);
		*/
		if(xhttp.readyState == 4 && xhttp.status==200){
alert("inside"+xhttp.status)

console.log(xhttp.responseText);
			let vill = JSON.parse(xhttp.responseText);
			vill = xhttp.responseText;
			console.log("vill value is:"+vill);
			console.log("-----------------------");
			//console.log(vill.USER_FIRST_NAME);






/*
			let reimbursements = JSON.parse(xhttp.responseText);
				console.log('1', xhttp.responseText);
				for(let reims of reimbursements) {
					
					console.log(reims);
					//reimburseLists(reims);
					
				}
				
				
				
		*/		
				
				
				
				
				let reimbursements = JSON.parse(xhttp.responseText);
				console.log('1', xhttp.responseText);
			
			var table = document.getElementById("customers");
			
			/*	for(let reims of reimbursements) {
					
					//console.log(reims);
					//reimburseLists(reims);
					var row = table.insertRow(20);
					 var cell1 = row.insertCell(9);
					cell1.innerhtml=reimbursements[reims];
				}*/
				
				for (i=1; i<45; i++)
				{
					var row = table.insertRow();
					for (j=1;j<=7;j++)
					 var cell1 = row.insertCell();
					
				}
				
				
				
				
				
				
				
				
		
		
		
		
		


}
	}
	
	xhttp.open("GET", "http://localhost:9026/Project1/ViewReimbersemnt");
	//xhttp.open("GET", "http://localhost:8080/Project1/login.change");
	

	xhttp.send();


}







