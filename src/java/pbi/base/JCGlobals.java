/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbi.base;
/**
 *
 * @author LALO-DOCIZ
 */
public class JCGlobals {
    private static int id_session;
    private static String NoEmp;
    private static String NombreC;
    private static String idAdsc;
    private static String DescAdsc;
       
    public JCGlobals(){}
    
    public void setid_session(int id_session){ this.id_session = id_session;}
    public int getid_session(){return this.id_session;}

    public void setNoEmp(String NoEmp){ this.NoEmp = NoEmp;}
    public String getNoEmp(){return this.NoEmp;}
    
    public void setNombreC(String NombreC){ this.NombreC = NombreC;}
    public String getNombreC(){return this.NombreC;}
    
    public void setidAdsc(String idAdsc){ this.idAdsc = idAdsc;}
    public String getidAdsc(){return this.idAdsc;}
    
    public void setDescAdsc(String DescAdsc){ this.DescAdsc = DescAdsc;}
    public String getDescAdsc(){return this.DescAdsc;}    
}