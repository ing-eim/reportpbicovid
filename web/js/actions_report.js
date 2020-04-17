/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {   
    reloj();
    $("form").submit(function(e){
        e.preventDefault();
        var d_v_report = $("#txtreporte").val();        
        $.ajax({
			url : 'savereport',
                        type: 'post',
			data : {
				d_v_report:d_v_report
			},
			success : function(responseText) {                                
                                var s =  responseText.split("|");
				if(s[0] === true || s[0]=== "true"){
                                    alert(s[1]);                                    
                                    $("#txtreporte").val("");
                                    
                                }else{                                    
                                    alert(s[1]);                                    
                                }                              
                                
			}
		});
   });    
});
function loadCmb(){
        $.ajax({
			url : 'loadcmbareas',
                        type: 'post',			
			success : function(responseText) {                                     
                                $("#cmbarea").empty();
                                $("#cmbarea").append(responseText);
			}
		});        
}

    function llamareporte(){
        var f = $("#txtfechareport").val();
        var area = $("#cmbarea").val();   
        if(area == 0 || area == "0"){
            alert ("Debe Seleccionar un elemento ");
            $("#cmbarea").focus();
            return 0;
        }    
        $.ajax({
			url : 'loadreport',
                        type: 'post',			
                        data: { 
                            fecha :f,
                            area : area
                        },
			success : function(responseText) {                 
                                $("#reportexarea").html();
                                $("#reportexarea").html(responseText);
			}
		});        
    
}

