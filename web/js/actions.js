/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() { 
    $("form").submit(function(e){
        e.preventDefault();
        var us = $("#txtempleado").val();
        var pwd = $("#txtpassword").val();
        $.ajax({
			url : 'ingreso',
                        type: 'post',
			data : {
				us : us,
                                pwd : pwd
			},
			success : function(responseText) {
				if(JSON.parse(responseText)){
                                    window.location.href = 'reportedia.jsp';
                                }
			}
		});
   });
    
});

