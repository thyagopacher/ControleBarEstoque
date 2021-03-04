/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.TipoPagamentoPers;
import vo.TipoPagamento;

/**
 *
 * @author Thyago H Pacher
 */
public class TipoPagamentoRN {
    
    public List<TipoPagamento> procurarTipo(int codempresa){
        return new TipoPagamentoPers().procurarTipo(codempresa);
    }
    
    public String setObj(List<TipoPagamento> tipos) {
        return new TipoPagamentoPers().setObj(tipos);
    }
    
    public List<TipoPagamento> getListaCache(){
        return new TipoPagamentoPers().getListaCache();
    }
}
