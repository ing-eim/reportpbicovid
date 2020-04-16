/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function reloj() {
			//Variables
			horareal = new Date()
			hora = horareal.getHours()
			minuto = horareal.getMinutes()
			segundo = horareal.getSeconds()
                        
                        nmes = horareal.getMonth() + 1 ;
                        ndia = horareal.getDate();
                        nanio = horareal.getFullYear();
                        ndiaSem = horareal.getDay();
                        namedia = valida_dia(ndiaSem);
                        nameMes = valida_Mes(nmes);
                        
			//Codigo para evitar que solo se vea un numero en los segundos
			comprobarsegundo = new String (segundo)
			if (comprobarsegundo.length == 1)
			segundo = "0" + segundo
			//Codigo para evitar que solo se vea un numero en los minutos
			comprobarminuto = new String (minuto)
			if (comprobarminuto.length == 1)
			minuto = "0" + minuto
			//Codigo para evitar que solo se vea un numero en las horas
			comprobarhora = new String (hora)
			if (comprobarhora.length == 1)
			hora = "0" + hora
			// Codigo para mostrar el reloj en pantalla
			verhora = hora + " : " + minuto + " : " + segundo
                        verfecha =namedia+" "+ ndia + " de "+ nameMes + " de "+nanio;
			//document.reloj_javascript.reloj.value = verhora
                        $("#reloj").html(verfecha +" <br> "+ verhora);
			setTimeout("reloj()",1000);
                        
		}
                function valida_dia(ndiaSem){
                    var name_dia;
                    switch (ndiaSem){
                        case 1: 
                                name_dia = "Lunes";
                                break;
                        case 2: 
                                name_dia = "Martes";
                                break;
                        case 3: 
                                name_dia = "Miércoles";
                                break;
                        case 4: 
                                name_dia = "Jueves";
                                break;
                        case 5: 
                                name_dia = "Viernes";
                                break;
                        case 6: 
                                name_dia = "Sábado";
                                break;
                        case 7: 
                                name_dia = "Domingo";
                                break;
                    }
                    return name_dia;                    
                }
                
                
                function valida_Mes(nmes){
                    var name_mes;
                    switch (nmes){
                        case 1: 
                                name_mes = "Enero";
                                break;
                        case 2: 
                                name_mes = "Febrero";
                                break;
                        case 3: 
                                name_mes = "Marzo";
                                break;
                        case 4: 
                                name_mes = "Abril";
                                break;
                        case 5: 
                                name_mes = "Mayo";
                                break;
                        case 6: 
                                name_mes = "Junio";
                                break;
                        case 7: 
                                name_mes = "Julio";
                                break;
                        case 8: 
                                name_mes = "Agosto";
                                break;
                        case 9: 
                                name_mes = "Septiembre";
                                break;
                        case 10: 
                                name_mes = "Octubre";
                                break;
                        case 11: 
                                name_mes = "Noviembre";
                                break;
                        case 12: 
                                name_mes = "Diciembre";
                                break;                        
                    }
                    return name_mes;                    
                }