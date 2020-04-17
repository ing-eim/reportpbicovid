<%-- 
    Document   : reportedia
    Created on : 14/04/2020, 08:34:55 PM
    Author     : LALO-DOCIZ
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pbi.base.JCGlobals;"%>
<%
    if(new JCGlobals().getid_session().equals("0") || new JCGlobals().getid_session().isEmpty()||new JCGlobals().getid_session() == "0" || new JCGlobals().getid_session().equals(""))
    {
%>
<html>
    <head></head>  
    <body>    
        <div style="width: 100%;height: 100%;background-image: url('../images/ilegal.png')">
            
        </div>
    </body>
</html>
<%}else{%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> PBI - Reporte Actividades Contingencia 2020 </title>
         <script src="../js/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="../js/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="../js/jquery-3.5.0.min.js"></script>
        <script src="../js/Utils.js"></script>        
        <script src="../js/actions_report.js"></script>
        <script src="../js/close_ses.js"></script>        
        <link rel="stylesheet" href="../css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/styles.css"/>
        <link rel="stylesheet" href="../css/pbi_style.css"/>        
    </head>
    <body>
        <br/>
        <div class="title_sis">
            SISTEMA DE REPORTE DE ACTIVIDADES POR CONTINGENCIA
        </div>
        <div id="panelSup">Bienvenido <br/><%
                out.println(new JCGlobals().getNoEmp());
                out.println("  |  ");
                out.println(new JCGlobals().getNombreC());
                out.println("( <small><strong>");
                out.println(new JCGlobals().getDescPuesto());
                out.println("</strong></small> )");
                %>
        </div>
        <div id="reloj" class='reloj_s'>                    
        </div>
        <div id='session_progress'>            
        </div>
        <br/>
        <br/>
        <nav>
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Redactar Informe</a>
                <%if (new JCGlobals().getDescPuesto().equals("DIRECTOR ADMINISTRATIVO")||new JCGlobals().getDescPuesto().equals("SUBDIRECTOR DE AREA")){%>
                <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false" onclick="loadCmb();">Reporte de Área</a>
                <%}%>                        
                <a class="nav-item nav-link" id="nav-contact-tab" onclick ="c_s();" data-toggle="tab" href="#" role="tab" aria-controls="nav-contact" aria-selected="false">Cierre Session</a>
            </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="Escribir Reporte del día">
                <div class="container">
                    <form>
                        <div class="row">
                            <div class="form-group">
                            <br/>
                            <label for="txtreporte">Escriba su reporte de Actividades de Hoy</label>
                            <input type="submit" class="btn btn-info" value="Guardar Reporte">
                            <textarea id="txtreporte" class="form-control" cols="500" rows="20">
                            </textarea>
                            </div>
                        </div>
                    </form>                    
                </div>
            </div>
            <!--              PANEL GENRA REPORTE       -->
            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="Mostrar Reporte">
                <div class="container">
                    <div class="row col-10">
                        <div class="form-group col-md-4">
                            <label for="txtfechareporte">Fecha de Reporte</label>
                            <input type="date" id="txtfechareport" class="form-control">                            
                        </div>
                        <div class="form-group col-4">
                            <label for="cmbarea">Área</label>
                            <select name="cmbarea" id="cmbarea" class="form-control"></select>                        
                        </div>                           
                    </div>
                    <div class="row col-10">
                        <div class="form-group">                                                       
                            <input type = "button" id="btnGeneraReport" class="form-control btn btn-success" value="Mostrar" onclick ='llamareporte();'>
                        </div>                        
                    </div>
                </div>
                <div class="container" id="reportexarea">                    
                </div>
                
            </div>            
        </div>
            <script>
                /*window.addEventListener("beforeunload", function (e) {
                        saveFormData();
                        (e || window.event).returnValue = null;
                        return null;
                });
                function saveFormData() {
                    console.log('saved');
                }*/
    /*
    var myEvent = window.attachEvent || window.addEventListener;
    var chkevent = window.attachEvent ? 'onbeforeunload' : 'beforeunload'; /// make IE7, IE8 compitable

               myEvent(chkevent, function(e) { // For >=IE7, Chrome, Firefox
                   var confirmationMessage = 'Are you sure to leave the page?';  // a space
                   (e || window.event).returnValue = confirmationMessage;
                   return confirmationMessage;
               });*/
</script>
</html>
<% } %>