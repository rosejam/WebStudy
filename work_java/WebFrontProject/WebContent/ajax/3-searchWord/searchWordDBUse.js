/**
 * 
 */
var xhr = null;
function getXHR(){
	xhr = new XMLHttpRequest();
}
function startMethod(){//get방식.
	getXHR(); 
	
	var word = document.getElementById("word");
	if(word.value.length > 0){ //글자가 들어왔을 때
		var param = "?word=" + word.value;
		
		xhr.open("get", "searchWordDB.jsp" + param, true);
		xhr.onreadystatechange = callback; 
		xhr.send(null);
	}else{ //글자가 없으면 팝업이 안보이게
		document.getElementById("popupPart").style.display = "none";
	}
}
function callback(){ 
	if(xhr.readyState == 4 && xhr.status == 200){
/*		var popupPart = document.getElementById("popupPart");
		popupPart.innerHTML = xhr.responseText;
		popupPart.style.display = "block";*/
		
		var data = eval(xhr.responseText);
		var popupPart = document.getElementById("popupPart");
		var msg = "";
		if(data != null){ //서버에서 null이 아닌 데이터가 왔으면
			for(var i=0; i<data.length; i++){
				msg += data[i] + "<br>";
			}
			popupPart.innerHTML = msg;
			popupPart.style.display = "block";
		}
	}
}