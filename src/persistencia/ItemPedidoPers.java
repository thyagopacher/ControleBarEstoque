/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import vo.Empresa;
import vo.ItemPedido;
import vo.Pedido;
import vo.Pessoa;
import vo.TipoPagamento;

/**
 *
 * @author Thyago H Pacher
 */
public class ItemPedidoPers {

    public String inserirItemPedido(ItemPedido item){
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            JSONObject jobjeto = new JSONObject();
            jobjeto.put("codempresa", item.getEmpresa().getCodempresa());
            jobjeto.put("codfuncionario", item.getFuncionario().getCodpessoa());
            jobjeto.put("quantidade", item.getQtd());
            jobjeto.put("valor", item.getUnitario());
            jobjeto.put("codpedido", item.getPedido().getCodpedido());
            jobjeto.put("codproduto", item.getProduto().getCodproduto());
            
            String json_string = jobjeto.toJSONString();
            msg2               = String.valueOf(gestaoCondominioPort.inserirItemPedido(json_string));
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }

    public String atualizarItemPedido(ItemPedido item) {
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            JSONObject jobjeto = new JSONObject();
            jobjeto.put("coditem", item.getCoditem());
            jobjeto.put("codempresa", item.getEmpresa().getCodempresa());
            jobjeto.put("codfuncionario", item.getFuncionario().getCodpessoa());
            jobjeto.put("quantidade", item.getQtd());
            jobjeto.put("valor", item.getUnitario());
            jobjeto.put("codpedido", item.getPedido().getCodpedido());
            jobjeto.put("codproduto", item.getProduto().getCodproduto());
            String json_string = jobjeto.toJSONString();
            msg2               = String.valueOf(gestaoCondominioPort.atualizarItemPedido(json_string));
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }

    public String excluirItemPedido(ItemPedido item) {
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            JSONObject jobjeto = new JSONObject();
            jobjeto.put("coditem", item.getCoditem());
            jobjeto.put("codempresa", item.getEmpresa().getCodempresa());
            jobjeto.put("codpedido", item.getPedido().getCodpedido());
            String json_string = jobjeto.toJSONString();
            msg2               = String.valueOf(gestaoCondominioPort.excluirItemPedido(json_string));
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }

    public List<ItemPedido> procurarItemPedido(int codpedido, int codempresa){
        String              msg2         = "";
        List<ItemPedido>    items        = new ArrayList<>(10);
        JSONParser          parser       = new JSONParser();
        JSONObject          jsonObject;
        try { 
            ProdutoPers                  prPers   = new ProdutoPers();
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            msg2                                                      = gestaoCondominioPort.procurarItemPedido(codpedido, codempresa);
            String separador_item[]                                   = msg2.split(";");
            int    qtd_item                                           = separador_item.length;
            for(int i = 0; i < qtd_item; i++){
                if(separador_item[i] != null && !separador_item[i].isEmpty()){
                    jsonObject = (JSONObject) parser.parse(separador_item[i]);
                    ItemPedido item = new ItemPedido();
                    item.setCoditem(Integer.valueOf(jsonObject.get("coditem").toString()));
                    item.setEmpresa(new Empresa(Integer.valueOf(jsonObject.get("codempresa").toString())));
                    item.setFuncionario(new Pessoa(Integer.valueOf(jsonObject.get("codfuncionario").toString()), codempresa));
                    item.setProduto(prPers.procuraProdutoCodigo(Integer.valueOf(jsonObject.get("codproduto").toString()), codempresa));
                    item.setQtd(Integer.valueOf(jsonObject.get("quantidade").toString()));
                    item.setUnitario(Double.valueOf(jsonObject.get("valor").toString()));
                    item.setPedido(new Pedido(Integer.valueOf(jsonObject.get("codpedido").toString())));
                    items.add(item);
                }
            }
        } catch (ServiceException | RemoteException | ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar items causado por:" + ex, "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
        return items;
    } 
    
}
