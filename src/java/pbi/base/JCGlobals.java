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
    private static String id_session;
    private static String NoEmp;
    private static String pk_i_persona;
    private static String NombreC;
    //private static String idAdsc;
    private static String DescAdsc;
    private static String DescPuesto;   
    private static String Msg;   
    
       
    public JCGlobals(){}
    
    public void setid_session(String id_session){ this.id_session = id_session;}
    public String getid_session(){return this.id_session;}

    public void setNoEmp(String NoEmp){ this.NoEmp = NoEmp;}
    public String getNoEmp(){return this.NoEmp;}
    
    public void setpk_i_persona(String pk_i_persona){ this.pk_i_persona = pk_i_persona;}
    public String getpk_i_persona(){return this.pk_i_persona;}
    
    public void setNombreC(String NombreC){ this.NombreC = NombreC;}
    public String getNombreC(){return this.NombreC;}
    
    /*public void setidAdsc(String idAdsc){ this.idAdsc = idAdsc;}
    public String getidAdsc(){return this.idAdsc;}*/
    
    public void setDescAdsc(String DescAdsc){ this.DescAdsc = DescAdsc;}
    public String getDescAdsc(){return this.DescAdsc;}
    
    public void setDescPuesto(String DescPuesto){ this.DescPuesto = DescPuesto;}
    public String getDescPuesto(){return this.DescPuesto;}
    
    public void setMsg(String Msg){ this.Msg = Msg;}
    public String getMsg(){return this.Msg;}
   
    
    
}