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
public class JCReport {
    private String table_report;
    private String adsc;
    private String fecha;
    
    public JCReport(String adsc, String fecha){
        this.adsc = adsc;
        this.fecha = fecha;
        this.CargaReport();
    }
    
    private void CargaReport(){    
        String table = "";
        Connection conn = new dbConnect().getConnection();        
        try{
            String query = "{call db_pbi_reportcovid19.sp_genera_reporte(?,?)}";
            CallableStatement stmt;
            stmt = conn.prepareCall(query);            
            stmt.setString(1,this.adsc);/*Es un Parametro de E/S sin ninguna funcion valida al momento*/
            stmt.setString(2, this.fecha);
            
            System.out.println("Cns Registros Reporte ... ");           
            boolean hadResults = stmt.execute(); 
            // print headings            
            System.out.println("================================");
            table= "<table><thead></thead><tbody>";
            while (hadResults) {
                ResultSet rs = stmt.getResultSet();                
                while(rs.next()){
                    table += "<tr><td>"+rs.getString("DescAdsc")+"</td><td>"+rs.getString("NombreC")+"</td><td><strong>"+rs.getString("fecha_registro")+"</strong><br/>"+rs.getString("reporte")+"</td></tr>";
                }                
                hadResults = stmt.getMoreResults();
            } 
            table += "</tbody></table>";
            stmt.close();                        
            conn.close();
        }catch(Exception w){
            System.out.println("¡ ERROR !"+w.getMessage());            
        }                
        setTable(table);
    }    
    
    private void setTable(String table){
        this.table_report = table;
    }
    
    public String getTable(){return this.table_report;}
    
}
