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
 * @author LALO-DOCIZ
 */
public class validation {
    private String Us;
    private String pwd;
    private String ip;
    private String host;
    private String navigator;
    private boolean Session;
    
    public validation(String us, String pwd,String ip, String host,String navigator){
        this.Us = us;
        this.pwd = pwd;
        
        this.ip = ip;
        this.host = host;
        this.navigator = navigator;
        
        if(ValidaUsuario()){
           this.SetSession(true);
        }else{
               this.SetSession(false);
        }
    }
    private void SetSession(boolean s){
        this.Session = s;
    }
    public boolean getSesion(){
        return this.Session;
    }
    private boolean ValidaUsuario(){
        boolean valido = false;
        Connection conn = new dbConnect().getConnection();
        int Numreg = 0;
        JCGlobals jc = new JCGlobals();
        try{
            String query = "{call db_pbi_reportcovid19.sp_inicio_session(?,?,?,?,?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);
            stmt.setInt(1,Integer.parseInt(this.Us));/*Es un Parametro de E/S sin ninguna funcion valida al momento*/
            stmt.setString(2, this.pwd);
            stmt.setString(3, this.ip);
            stmt.setString(4, this.host);
            stmt.setString(5, this.navigator);
            System.out.println("5.- Sincronizando Registros ... ");
           
            boolean hadResults = stmt.execute();
 
            // print headings            
            System.out.println("================================");
            
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                    Numreg = rs.getInt(1);//person_exists
                    jc.setid_session(rs.getString("c_v_session_s"));
                    jc.setpk_i_persona(rs.getString("pk_i_persona"));
                    jc.setNoEmp(rs.getString("placa"));
                    jc.setNombreC(rs.getString("NombreC"));
                    jc.setDescAdsc(rs.getString("adsc"));
                    jc.setDescPuesto(rs.getString("puesto"));                
                    jc.setMsg(rs.getString("error_msg"));
                    jc.setidAdsc(rs.getString("nIdAdscripcion"));
                }                
                hadResults = stmt.getMoreResults();
            } 
            stmt.close();                        
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());            
        }        
        if(jc.getid_session().equals("")|| jc.getid_session().isEmpty()||jc.getid_session().equals("0")){
            valido = false;
        }else{
            valido = true;
        }
        return valido;
    }    
    /*public static void main (String []args){
        dbConnect d =  new dbConnect();
        
    }*/
}
