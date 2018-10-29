function showMe() {

		var statusKey = document.getElementById("statusKey").value;
		var islemDiv = document.getElementById("islemDiv");
		var islm_id=document.getElementById("islm_id");
		
		
		
		
		
		if (statusKey==1) {
			
			islm_id.disabled=true;
			islemDiv.style.display="none";
			
				

		}
		
		if (statusKey==2) {
			
			islm_id.disabled=false;
			islemDiv.style.display="block";
			
			
		}
	
		
		
	}
