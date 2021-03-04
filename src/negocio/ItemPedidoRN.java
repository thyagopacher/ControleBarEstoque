/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.ItemPedidoPers;
import vo.ItemPedido;

/**
 *
 * @author Thyago H Pacher
 */
public class ItemPedidoRN {
    
    ItemPedidoPers pp;
    String msg = "";
    
    public ItemPedidoRN(){
        pp = new ItemPedidoPers();
    }
 
    public String inserirItemPedido(ItemPedido item) {
        return pp.inserirItemPedido(item);
    }

    public String atualizarItemPedido(ItemPedido item) {
        return pp.atualizarItemPedido(item);
    }

    public String excluirItemPedido(ItemPedido item) {
        return pp.excluirItemPedido(item);
    }

    public List<ItemPedido> procurarItemPedido(int codpedido, int codempresa) {
        return pp.procurarItemPedido(codpedido, codempresa);
    }

}
