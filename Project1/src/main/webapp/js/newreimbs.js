/**
 * 
 */
 /*window.onload = function() {

	console.log('js loaded');
	loadUser();
	loadReimbursements();
}*/


window.onload = function(){
	alert("inside of the newimbkljs ")
}
let button =document.getElementById("bvse").addEventListener("click", myFunction);
	console.log(button);

function myFunction() 

{
  alert ("inside newreimbs js button click function");
  
  
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
			
			for(let reims of reimbursements) {
					
					console.log(reims);
					reimburseLists(reims);
					//var row = table.insertRow(20);
					// var cell1 = row.insertCell(9);
					//cell1.innerhtml=reimbursements[reims];
				}
				/*
				for (i=1; i<45; i++)
				{
					var row = table.insertRow();
					for (j=1;j<=7;j++)
					 var cell1 = row.insertCell();
					
				}*/
				
				
				
				
				
				
				
				
		
		
		
		
		


}
	}
	
	xhttp.open("GET", "http://localhost:9026/Project1/ViewReimbersemnt");
	//xhttp.open("GET", "http://localhost:8080/Project1/login.change");
	

	xhttp.send();


}

//function called when view button is clicked


function reimburseLists(reims){
		
	//	alert('insdie reimb list');
		let status = "";
		let type = "";
		
		switch(reims.reimb_status_id) {
		    case 1:
		        status = "Pending";
		        break;
		        
		    case 2:
		        status = "Approved";
		        break;
		    
		    case 3:
		        status = "Denied";
		        break;
		     
		    default:
		    	break;
		
		}

		 switch(reims.reimb_type_id) {
		 
		    case 1:
		        type = "Lodging";
		        break;
		        
		    case 2:
		        type = "Travel";
		        break;
		    
		    case 3:
		        type = "Food";
		        break;
		    
		    case 4:
		        type = "Other";
		        break;
		        
		    default:
		    	break;
		    
		 
		}
		console.log('in remiblooop ');
	//	alert(reims.reimb);
	
	//alert(reims.reimb_id + "---"+reims.reimb_amount +"---"+ reims.reimb_resolved+"---"+ reims.reimb_description);
	
	//alert('type of reims is '+ typeof(reims));
	  var tableRef = document.getElementById('customers').getElementsByTagName('tbody')[0];

   var submitTime = new Date(reims.reimb_SUBMITTED);
   if(reims.reimb_RESOLVED == null)
   {
   resTime=0;
   }
   else
   {
    resTime=new Date(reims.reimb_RESOLVED);;
   }
  // var resolvedTime = new Date(reims.reimb_resolved);
        //insert Row
      //  alert('inside loop')
        tableRef.insertRow().innerHTML = 
        "<td>" +reims.reimb_ID+ "</td>" + 
        "<td>" +reims.reimb_AMOUNT+ "</td>"+
        "<td>" +submitTime+ "</td>"+
        "<td>" +resTime+ "</td>"+
        "<td>" +reims.reimb_DESCRIPTION+ "</td>"+
       /* "<td>" +reims.reimb_author+ "</td>"+*/
        "<td>" +status+ "</td>"+
        "<td>" +type+ "</td>";
  //  }
	
	
	
	}
	
	
	
	
	
	
	
		
		





















	

	
	
		
