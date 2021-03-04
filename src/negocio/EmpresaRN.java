/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.rmi.RemoteException;
import persistencia.EmpresaPers;
import vo.Empresa;

/**
 *
 * @author Thyago H Pacher
 */
public class EmpresaRN {
    
    EmpresaPers pp;
    String msg = "";
    
    public EmpresaRN(){
        pp = new EmpresaPers();
    }
 
    
    public String procurarLogo(int codempresa){
        try {
            return pp.procurarLogo(codempresa);
        } catch (RemoteException ex) {
            return "Erro causado por:" + ex;
        }
    }    

    public String atualizar(Empresa empresa) {
        return pp.atualizar(empresa);
    }
}
