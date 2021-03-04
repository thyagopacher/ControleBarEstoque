/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.rmi.RemoteException;
import java.util.List;
import persistencia.PedidoPers;
import vo.Pedido;

/**
 *
 * @author Thyago H Pacher
 */
public class PedidoRN {
    
    PedidoPers pp;
    String msg = "";
    
    public PedidoRN(){
        pp = new PedidoPers();
    }
 
    
    public String procurarCodigoPedido(int codempresa){
        try {
            return pp.procurarCodigoPedido(codempresa);
        } catch (RemoteException ex) {
            return "Erro causado por:" + ex;
        }
    }     

    public String inserirPedido(Pedido pedido_aberto) {
        return pp.inserirPedido(pedido_aberto);
    }

    public String atualizarPedido(Pedido pedido_aberto) {
        return pp.atualizarPedido(pedido_aberto);
    }

    public List<Pedido> procurarPedido(String hoje2, int codempresa) {
        return pp.procurarPedido(hoje2, codempresa);
    }

    public List<Pedido> procurarPedidoStatus(int codstatus, int codempresa) {
        return pp.procurarPedidoStatus(codstatus, codempresa);
    }
}
