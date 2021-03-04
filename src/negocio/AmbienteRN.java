/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.AmbientePers;
import vo.Ambiente;

/**
 *
 * @author Thyago H Pacher
 */
public class AmbienteRN {
    
    AmbientePers pp;
    String msg = "";
    
    public AmbienteRN(){
        pp = new AmbientePers();
    }
    
    public String valida(Ambiente objeto){
        String msg2 = "";
        if(objeto.getNome() == null){
            msg2 += "\nDefina quem está comprando!";
        }
        return msg2;
    }
    
    public String inserir(Ambiente objeto){
        String res = this.valida(objeto);
        if(res == null || res.isEmpty()){
            return pp.inserir(objeto);
        }else{
            return res;
        }
    }
    
    public String atualizar(Ambiente objeto){
        String res = this.valida(objeto);
        if(res == null || res.isEmpty()){
            return pp.atualizar(objeto);
        }else{
            return res;
        }
    }
    
    public String excluir(Ambiente objeto){
        return pp.excluir(objeto);
    }
    
    public Ambiente procuraCodigo(int codigo){
        return pp.procuraCodigo(codigo);
    }
    
    public List<Ambiente> procuraTodos(){
        return pp.procuraTodos();
    }

    public List<Ambiente> procurar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Ambiente> procurarAmbiente(String nome, String data1, String data2, int codempresa) {
        return pp.procurarAmbiente(nome, data1, data2, codempresa);
    }
}
