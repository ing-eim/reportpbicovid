/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbi.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import pbi.base.JCGlobals;
import pbi.base.dbConnect;

/**
 *
 * @author depdes10
 */
public class JCSaveReport {    
    private String d_v_report;
    private String NoEmp;
    private String c_v_session;
    
    public JCSaveReport(String NoEmp, String c_v_session,String d_v_report){        
        this.NoEmp = NoEmp;
        this.c_v_session = c_v_session;
        this.d_v_report = d_v_report;
    }
     
    public boolean SaveReport(){
        boolean valido = false;
        Connection conn = new dbConnect().getConnection();
        int Numreg = 0;
        JCGlobals jc = new JCGlobals();
        try{
            String query = "{call db_pbi_reportcovid19.sp_create_report(?,?, ?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setInt(1,Integer.parseInt(this.NoEmp));/*Es un Parametro de E/S sin ninguna funcion valida al momento*/
            stmt.setString(2, this.c_v_session);
            stmt.setString(3, this.d_v_report);            
            System.out.println("5.- GUardando Reporte ... ");           
            boolean hadResults = stmt.execute(); 
            // print headings            
            System.out.println("================================");
 
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                    Numreg = rs.getInt(1);//person_exists                    
                    jc.setMsg(rs.getString("msg"));                
                }                
                hadResults = stmt.getMoreResults();
            } 
            stmt.close();                        
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());            
        }        
        if(Numreg > 0){
            valido = false;
        }else{
            valido = true;
        }
        return valido;
    }    
    
}
