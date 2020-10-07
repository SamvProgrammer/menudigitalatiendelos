/**
 * 
 */


var cerrarSesion = function(){
	   console.log("si entra al submit");
	   document.getElementById("forms1").submit();
   }
   var mostrar = function(){
	   console.log("si sirve");
	   $(".page-wrapper").addClass("toggled");
   }
   
   var cerrar = function(){
	   $(".page-wrapper").removeClass("toggled");
   }
   
   
   $(document).ready(function(){
	   $(".sidebar-dropdown > a").click(function() {
	        $(".sidebar-submenu").slideUp(200);
	        if (
	          $(this)
	            .parent()
	            .hasClass("active")
	        ) {
	          $(".sidebar-dropdown").removeClass("active");
	          $(this)
	            .parent()
	            .removeClass("active");
	        } else {
	          $(".sidebar-dropdown").removeClass("active");
	          $(this)
	            .next(".sidebar-submenu")
	            .slideDown(200);
	          $(this)
	            .parent()
	            .addClass("active");
	        }
	      });
	   
	   
	   $(".page-wrapper").removeClass("toggled");
   });