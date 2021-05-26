/**
 * 
 */
 //window.onload = function(){
	//getSessUser();
//}
/*
function getSessUser() {
	let xhttp = new XMLHttpRequest();
	console.log("a"+xhttp);
	xhttp.onreadystatechange = function(){
		console.log("b"+xhttp);

				if(xhttp.readyState == 4 && xhttp.status==200){
			let user = JSON.parse(xhttp.responseText);
			console.log(user);
			document.getElementById("welcomeHeader").innerText=`Welcome ${user.ERS_USERNAME}`;
		}
	}
	
	xhttp.open("GET", "http://localhost:9020/Project1/getsessionuser.json");

	xhttp.send();
}
*/

let button1 =document.getElementById("subb").addEventListener('click',loginfunc);

function loginfunc(){

let username = document.getElementById("un").value;
let password = document.getElementById("password-field").value;

alert(username);
alert(password);




let user = {
			
		ERS_USERNAME :document.getElementById('un').value,
		ERS_PASSWORD :document.getElementById('password-field').value
	
	};
//	alert(user);
	console.log(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
	alert("hi");
	alert(xhr);
	alert(xhr.readyState);
	console.log(xhr);
	alert(xhr.status);
		if(xhr.readyState == 4 && xhr.status == 200) 
		{
				let success = xhr.responseText;
			//	console.log('data is sent successfully');
			alert(success);
			console.log(success);
		
			if(success == 'Employee'){
			location.href = "http://localhost:8080/Project1/html/createNew.html";
			}
			else if(success == 'Manager')
			location.href = "http://localhost:8080/Project1/html/welcomeManager.html";
			//else if(success == 'invalid'){
			//	document.getElementById("invalid").innerHTML = "Invalid Credentials";
				
			//location.href = "http://localhost:8081/ERS/HTML/error.html%22;
			
			
		}else
		Console.log("error");
			
		}
		
		
	
	
	//xhr.open("GET", `http://localhost:8080/Project1/login?username=${username}&password=${password}`);
	xhr.open("POST", `http://localhost:8080/Project1/login?username=${username}&password=${password}`);
	//xhr.open("GET", `http://localhost:8080/ERS/byStatus?statusId=$%7Ba%7D%60`);
	//xhr.setRequestHeader("Content-type", "application/json");
	//var toSend = JSON.stringify(user);
	//console.log("send in login:" + toSend);
	//alert("send in logi)
//xhr.send(toSend);
xhr.send();


}


