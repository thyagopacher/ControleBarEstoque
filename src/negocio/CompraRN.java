/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.CompraPers;
import vo.Compra;

/**
 *
 * @author Thyago H Pacher
 */
public class CompraRN {
    
    CompraPers pp;
    String msg = "";
    
    public CompraRN(){
        pp = new CompraPers();
    }
    
    public String valida(Compra objeto){
        String msg2 = "";
        if(objeto.getPessoa() == null){
            msg2 += "\nDefina quem está comprando!";
        }
        if(objeto.getProduto() == null){
            msg2 += "\nDefina o produto comprado!";
        }
        return msg2;
    }
    
    public String inserir(Compra objeto){
        String res = this.valida(objeto);
        if(res == null || res.isEmpty()){
            return pp.inserir(objeto);
        }else{
            return res;
        }
    }
    
    public String atualizar(Compra objeto){
        String res = this.valida(objeto);
        if(res == null || res.isEmpty()){
            return pp.atualizar(objeto);
        }else{
            return res;
        }
    }
    
    public String excluir(Compra objeto){
        return pp.excluir(objeto);
    }
    
    public Compra procuraCodigo(int codigo){
        return pp.procuraCodigo(codigo);
    }
    
    public List<Compra> procuraTodos(){
        return pp.procuraTodos();
    }
}
