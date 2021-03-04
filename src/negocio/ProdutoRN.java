/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.ProdutoPers;
import vo.Produto;

/**
 *
 * @author Thyago H Pacher
 */
public class ProdutoRN {
    
    ProdutoPers pp;
    String msg = "";
    
    public ProdutoRN(){
        pp = new ProdutoPers();
    }
    
    public String valida(Produto objeto){
        String msg2 = "";
        if(objeto.getNome() == null || objeto.getNome().isEmpty()){
            msg2 += "\nNome não pode ficar em branco!";
        }
        if(objeto.getValor() == 0.0){
            msg2 += "\nValor não pode ficar em branco!";
        }
        return msg2;
    }
    
    public String inserir(Produto objeto){
        String res = this.valida(objeto);
        if(res == null || res.isEmpty()){
            return pp.inserir(objeto);
        }else{
            return res;
        }
    }
    
    public String atualizar(Produto objeto){
        String res = this.valida(objeto);
        if(res == null || res.isEmpty()){
            return pp.atualizar(objeto);
        }else{
            return res;
        }
    }
    
    public String excluir(Produto objeto){
        return pp.excluir(objeto);
    }
    
    public Produto procuraProdutoCodigo(int codigo, int codempresa){
        return pp.procuraProdutoCodigo(codigo, codempresa);
    }
    
    public List<Produto> procura(String nome){
        return pp.procuraNomeParcial(nome);
    }
    
    public List<Produto> procuraProdutoCodigoBarra(String codigobarra, int codempresa){
        return pp.procuraProdutoCodigoBarra(codigobarra, codempresa);
    }
    
    public List<Produto> procuraProdutos(int codempresa){
        return pp.procuraProdutos(codempresa);
    }
}
