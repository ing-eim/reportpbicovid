/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pbi.base.dbConnect;
/**
 *
 * @author LALO-DOCIZ
 */
public class validation {
    private String Us;
    private String pwd;
    private boolean Session;
    public validation(String us, String pwd){
        this.Us = us;
        this.pwd = pwd;
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
        try{
            Statement stmt=conn.createStatement();

            String query = "SELECT count(*) FROM " +
                            "	db_pbi_rhumanos.f_personal a " +
                            "       join db_pbi_rhumanos.tblRHPersonalesComp b on (a.nIdNumEmp = b.nIdNumEmp)\n" +
                            " where a.nIdNumEmp = '"+this.Us+"' and a.tRFC = '"+this.pwd+"';";
            ResultSet rs=stmt.executeQuery(query);
            
            while(rs.next()){                
                Numreg = rs.getInt(1);
            }
            System.out.println("1.- Obteniendo Ultimo Registro ... OK");
            
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());
            
        }        
        if(Numreg > 0){
            valido = true;
        }else{
            valido = false;
        }
        return valido;
    }    
    /*public static void main (String []args){
        dbConnect d =  new dbConnect();
        
    }*/
}
