/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.PaginaPers;
import vo.Pagina;

/**
 *
 * @author Thyago H Pacher
 */
public class PaginaRN {
    
    PaginaPers pp;
    String msg = "";
    
    public PaginaRN(){
        pp = new PaginaPers();
    }
    
    public String valida(Pagina objeto){
        String msg2 = "";
        if(objeto.getNome() == null || objeto.getNome().isEmpty()){
            msg2 += "\nNome não pode ficar em branco!";
        }
        return msg2;
    }
    
    public String inserir(Pagina objeto){
        String res = this.valida(objeto);
        if(res == null || res.isEmpty()){
            return pp.inserir(objeto);
        }else{
            return res;
        }
    }
    
    public String atualizar(Pagina objeto){
        String res = this.valida(objeto);
        if(res == null || res.isEmpty()){
            return pp.atualizar(objeto);
        }else{
            return res;
        }
    }
    
    public String excluir(Pagina objeto){
        return pp.excluir(objeto);
    }
    
    public Pagina procuraPaginaCodigo(int codigo, int codempresa){
        return pp.procuraPaginaCodigo(codigo, codempresa);
    }
    
    public List<Pagina> procura(String nome){
        return pp.procuraNomeParcial(nome);
    }
    
    public List<Pagina> procuraPaginaCodigoBarra(String codigobarra, int codempresa){
        return pp.procuraPaginaCodigoBarra(codigobarra, codempresa);
    }
    
    public List<Pagina> procuraPaginas(int codempresa){
        return pp.procuraPaginas(codempresa);
    }
}
