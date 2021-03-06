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
public class Close_Session {
    private String c_v_session;
    public Close_Session(String c_v_session){
        this.c_v_session = c_v_session;
    }
    public boolean Close(){
        boolean valido = false;
        Connection conn = new dbConnect().getConnection();
        int Numreg = 0;
        JCGlobals jc = new JCGlobals();
        try{
            String query = "{call db_pbi_reportcovid19.sp_close_session(?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setString(1,this.c_v_session);/*Es un Parametro de E/S sin ninguna funcion valida al momento*/
            boolean hadResults = stmt.execute();
             // print headings            
            System.out.println("================================");
             while (hadResults) {
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                    Numreg = rs.getInt(1);//session_id
                    jc.setMsg(rs.getString("msg"));               
                }                
                hadResults = stmt.getMoreResults();
            } 
            stmt.close();                        
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());            
        }        
        if(Numreg == 0){
            valido = false;
        }else{
            valido = true;
        }
        return valido;
    }    
}
