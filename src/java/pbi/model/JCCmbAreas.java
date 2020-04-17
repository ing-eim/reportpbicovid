/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbi.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import pbi.base.dbConnect;
import pbi.base.JCGlobals;
/**
 *
 * @author depdes10
 */
public class JCCmbAreas {
    private String combo;
    private String idAdsc;
    private String DescPuesto;
    
    public JCCmbAreas(String idAdsc, String DescPuesto){
        this.idAdsc = idAdsc;
        this.DescPuesto = DescPuesto;
        this.CargaCmbAreas();
    }
    
    private void CargaCmbAreas(){    
        String cmb = "";
        Connection conn = new dbConnect().getConnection();        
        try{
            String query = "{call db_pbi_reportcovid19.sp_get_areas()}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);            
            System.out.println("Cns Registros CmbAreas ... ");           
            boolean hadResults = stmt.execute(); 
            // print headings            
            System.out.println("================================");
            String nIdAdsc = this.idAdsc;
            System.out.println(this.idAdsc);

            String tDescPuesto = this.DescPuesto;
                       System.out.println(this.DescPuesto);
            int tp = 0;
            if(tDescPuesto.equals("DIRECTOR ADMINISTRATIVO")){
                tp = 0;
            }else if(tDescPuesto.equals("SUBDIRECTOR DE AREA")){
                tp = 1;
            }
            if (tp == 0)
                cmb= "<option value = '0'> -- Seleccione una Opción -- </option>";
            
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();                
                while(rs.next()){
                    if(tp == 0)
                        cmb += "<option value = '"+(rs.getString("nIdAdscripcion")).subSequence(0, 3)+"'>"+rs.getString("tDescAdscripcion")+"</option>";
                    else if( tp == 1 && ( (nIdAdsc.subSequence(0,3)).equals((rs.getString("nIdAdscripcion")).subSequence(0, 3)))){
                        cmb += "<option value = '"+(rs.getString("nIdAdscripcion")).subSequence(0, 3)+"'>"+rs.getString("tDescAdscripcion")+"</option>";
                    }                        
                }                
                hadResults = stmt.getMoreResults();
            } 
            stmt.close();                        
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());            
        }                
        setCombo(cmb);
    }    
    
    private void setCombo(String cmb){
        this.combo = cmb;
    }
    
    public String getCombo(){return this.combo;}
}
