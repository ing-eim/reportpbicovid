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

/**
 *
 * @author depdes10
 */
public class JCCmbAreas {
    private String combo;
    
    public JCCmbAreas(){
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
            cmb= "<option value = '0'> -- Seleccione una Opción -- </option>";
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();
                
                while(rs.next()){
                    cmb += "<option value = '"+(rs.getString("nIdAdscripcion")).subSequence(0, 3)+"'>"+rs.getString("tDescAdscripcion")+"</option>";
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
