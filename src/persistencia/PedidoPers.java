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
import visao.Validacao;
import vo.Empresa;
import vo.Pedido;
import vo.Pessoa;
import vo.TipoPagamento;

/**
 *
 * @author Thyago H Pacher
 */
public class PedidoPers {
    public String procurarCodigoPedido(int codempresa) throws RemoteException {
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            msg2 = String.valueOf(gestaoCondominioPort.procurarCodigoPedido(codempresa));
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }    

    public String inserirPedido(Pedido pedido){
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            JSONObject jobjeto = new JSONObject();
            jobjeto.put("codpedido", pedido.getCodpedido());
            jobjeto.put("codempresa", pedido.getEmpresa().getCodempresa());
            jobjeto.put("codfuncionario", pedido.getFuncionario().getCodpessoa());
            jobjeto.put("codmorador", pedido.getMorador().getCodpessoa());
            jobjeto.put("tipopagamento", pedido.getTipo().getCodtipo());
            jobjeto.put("valor", pedido.getValor());
            String json_string = jobjeto.toJSONString();
            msg2               = String.valueOf(gestaoCondominioPort.inserirPedido(json_string));
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }

    public String atualizarPedido(Pedido pedido) {
        Validacao validacao = new Validacao();
        String    msg2      = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            JSONObject jobjeto = new JSONObject();
            jobjeto.put("codpedido", pedido.getCodpedido());
            jobjeto.put("codempresa", pedido.getEmpresa().getCodempresa());
            jobjeto.put("codfuncionario", pedido.getFuncionario().getCodpessoa());
            jobjeto.put("codmorador", pedido.getMorador().getCodpessoa());
            jobjeto.put("tipopagamento", pedido.getTipo().getCodtipo());
            jobjeto.put("valor", pedido.getValor());
            jobjeto.put("dtfechamento", validacao.mascaraData("yyyy-MM-dd", pedido.getDtpedido()));
            jobjeto.put("codstatus", pedido.getCodstatus());
            String json_string = jobjeto.toJSONString();
            msg2               = gestaoCondominioPort.atualizarPedido(json_string);
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }

    public List<Pedido> procurarPedido(String hoje2, int codempresa) {
        String              msg2         = "";
        List<Pedido>        pedidos      = new ArrayList<>(10);
        List<TipoPagamento> tipos        = new TipoPagamentoPers().getListaCache();
        int                 qtdTipo      = 0;
        if(tipos != null){
            qtdTipo = tipos.size();
        }
        JSONParser          parser       = new JSONParser();
        PessoaPers          pePers       = new PessoaPers();
        TipoPagamento       tipo         = new TipoPagamento();
        JSONObject          jsonObject;
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            msg2                      = gestaoCondominioPort.procurarPedido(hoje2, codempresa);
            String separador_pedido[] = msg2.split(";");
            int    qtd_pedido         = separador_pedido.length;
            for(int i = 0; i < qtd_pedido; i++){
                if(separador_pedido[i] != null && !separador_pedido[i].isEmpty()){
                    jsonObject = (JSONObject) parser.parse(separador_pedido[i]);
                    Pessoa morador = pePers.procuraMoradorCodigo(codempresa, Integer.valueOf(jsonObject.get("codmorador").toString()));
                    Pedido pedido = new Pedido();
                    pedido.setCodpedido(Integer.valueOf(jsonObject.get("codpedido").toString()));
                    pedido.setCodstatus(Integer.valueOf(jsonObject.get("codstatus").toString()));
                    pedido.setEmpresa(new Empresa(Integer.valueOf(jsonObject.get("codempresa").toString())));
                    pedido.setFuncionario(new Pessoa(Integer.valueOf(jsonObject.get("codfuncionario").toString()), codempresa));
                    if(tipos != null && qtdTipo > 0){
                        for(int j = 0; j < qtdTipo; j++){
                            if(tipos.get(j).getCodtipo() == Integer.valueOf(jsonObject.get("tipopagamento").toString())){
                                tipo = tipos.get(j);
                                break;
                            }
                        }
                    }
                    if(tipo == null || tipo.getCodtipo() == 0){
                        tipo = new TipoPagamento(Integer.valueOf(jsonObject.get("tipopagamento").toString()), codempresa);
                    }
                    pedido.setTipo(tipo);
                    if(jsonObject.get("valor") == null || jsonObject.get("valor").toString() == null || jsonObject.get("valor").toString().isEmpty()){
                        pedido.setValor(Double.valueOf(0.0));
                    }else{
                        pedido.setValor(Double.valueOf(jsonObject.get("valor").toString()));
                    }
                    pedido.setMorador(morador);
                    pedidos.add(pedido);
                }
            }
        } catch (ServiceException | ParseException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar pedidos causado por:" + ex, "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
        return pedidos;
    }

    public List<Pedido> procurarPedidoStatus(int codstatus, int codempresa) {
        String              msg2         = "";
        List<Pedido>        pedidos      = new ArrayList<>(10);
        List<TipoPagamento> tipos        = new TipoPagamentoPers().getListaCache();
        int                 qtdTipo      = 0;
        if(tipos != null){
            qtdTipo = tipos.size();
        }
        JSONParser          parser       = new JSONParser();
        PessoaPers          pePers       = new PessoaPers();
        TipoPagamento       tipo         = new TipoPagamento();
        JSONObject          jsonObject;
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            msg2                      = gestaoCondominioPort.procurarPedidoStatus(codstatus, codempresa);
            String separador_pedido[] = msg2.split(";");
            int    qtd_pedido         = separador_pedido.length;
            for(int i = 0; i < qtd_pedido; i++){
                jsonObject = (JSONObject) parser.parse(separador_pedido[i]);
                Pedido pedido = new Pedido();
                Pessoa morador = pePers.procuraMoradorCodigo(codempresa, Integer.valueOf(jsonObject.get("codmorador").toString()));
                pedido.setMorador(morador);                
                pedido.setCodpedido(Integer.valueOf(jsonObject.get("codpedido").toString()));
                pedido.setCodstatus(Integer.valueOf(jsonObject.get("codstatus").toString()));
                pedido.setEmpresa(new Empresa(Integer.valueOf(jsonObject.get("codempresa").toString())));
                pedido.setFuncionario(new Pessoa(Integer.valueOf(jsonObject.get("codfuncionario").toString()), codempresa));
                

                if(tipos != null && qtdTipo > 0){
                    for(int j = 0; j < qtdTipo; j++){
                        if(tipos.get(j).getCodtipo() == Integer.valueOf(jsonObject.get("tipopagamento").toString())){
                            tipo = tipos.get(j);
                            break;
                        }
                    }
                }
                if(tipo == null || tipo.getCodtipo() == 0){
                    tipo = new TipoPagamento(Integer.valueOf(jsonObject.get("tipopagamento").toString()), codempresa);
                }
                pedido.setTipo(tipo);
                if(jsonObject.get("valor") == null || jsonObject.get("valor").toString() == null || jsonObject.get("valor").toString().isEmpty()){
                    pedido.setValor(Double.valueOf(0.0));
                }else{
                    pedido.setValor(Double.valueOf(jsonObject.get("valor").toString()));
                }
                pedidos.add(pedido);
            }
        } catch (ServiceException | ParseException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar pedidos causado por:" + ex, "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
        return pedidos;
    }
}
