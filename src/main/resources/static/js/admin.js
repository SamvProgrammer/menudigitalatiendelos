

var cambiando = function(elemento){
	elemento.nextSibling.nextSibling.firstChild.nextSibling.style.display = elemento.checked ? "none":"inline"
}


var obteniendohoras = function(dia){
	 console.log(dia);
	 var split = dia.split("-")
	 console.log(split);
	 var primero = split[0].trim();
	 var segundo = split[1].trim();
	 
	 if(primero.includes("p. m.")){
		 var horas = Number(primero.split(":")[0])+12;
		 var minutos = primero.split(":")[1];
		 
		 
		 
		 
		 primero = (horas.toString().lengh == 1)?"0"+horas.toString():horas.toString()+":"+minutos.replace(" p. m.","");
		 
	 }
	 
	 if(segundo.includes("p. m.")){
		 var horas = Number(segundo.split(":")[0])+12;
		 var minutos = segundo.split(":")[1];
		 
		 
		 segundo = (horas.toString().lengh == 1)?"0"+horas.toString():horas.toString()+":"+minutos.replace(" p. m.","");
		 
	 }
	 
	 primero = primero.replace(" a. m.","")
	 segundo = segundo.replace(" a. m.","");
	 
	 var horafinal = primero.split(":")[0].length == 1 ? "0"+primero.split(":")[0]:primero.split(":")[0];
	 var minutiFinal =  primero.split(":")[1].length == 1 ? "0"+primero.split(":")[1]:primero.split(":")[1];
	 
	 primero = horafinal + ":"+minutiFinal;
	 
	 var horafinal = segundo.split(":")[0].length == 1 ? "0"+segundo.split(":")[0]:segundo.split(":")[0];
	 var minutiFinal =  segundo.split(":")[1].length == 1 ? "0"+segundo.split(":")[1]:segundo.split(":")[1];
	 
	 segundo = horafinal + ":"+minutiFinal;
	 
	 return primero+"-"+segundo;
}


