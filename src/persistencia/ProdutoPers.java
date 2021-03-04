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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import vo.Pessoa;
import vo.Produto;

/**
 *
 * @author Thyago H Pacher
 */
public class ProdutoPers {
    
    private Session s; 
    String msg = "";
    
    public String inserir(Produto objeto){
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            msg2 = gestaoCondominioPort.inserirProduto(objeto.getNome(), String.valueOf(objeto.getValor()), objeto.getCodigobarra(), objeto.getQuantidade(), objeto.getCodempresa(), objeto.getStatus());
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }
    
    public String atualizar(Produto objeto){
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            msg2 = gestaoCondominioPort.atualizarProduto(objeto.getNome(), String.valueOf(objeto.getValor()), objeto.getCodigobarra(), objeto.getQuantidade(), objeto.getCodempresa(), objeto.getCodproduto(), objeto.getStatus());
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }
    
    public String excluir(Produto objeto){
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            msg2 = gestaoCondominioPort.excluirProduto(objeto.getCodproduto(), objeto.getCodempresa());
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }
    
    public Produto procuraCodigo(int codigo){
        return (Produto)Conexao.getInstance().get(Produto.class,codigo);
    }  
    
    public List<Produto> procuraNomeParcial(String nome) {
        return Conexao.getInstance().createQuery("from Produto where nome like '%" + nome + "%' order by nome ASC").list();
    }        

    public List<Produto> procuraProdutoCodigoBarra(String codigobarra, int codempresa) {
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String separador[] = gestaoCondominioPort.procuraProdutoCodigoBarra(codigobarra, codempresa).split(";");
           
            int qtd = separador.length;
            List<Produto> produtos = new ArrayList<>(qtd);
            for(int i = 0; i < qtd; i++){
                String separador2[] = separador[i].split("-");
                if(separador2[0] != null && !separador2[0].isEmpty()){
                    Produto produto = new Produto();
                    produto.setCodproduto(Integer.valueOf(separador2[0]));
                    produto.setNome(separador2[1]);
                    produto.setValor(Double.valueOf(separador2[2]));
                    produto.setQuantidade(Integer.valueOf(separador2[3]));
                    produto.setCodigobarra(separador[4]);
                    produto.setStatus(separador2[5]);
                    produto.setCodempresa(codempresa);
                    produtos.add(produto);
                }
            }
            return produtos;
        } catch (ServiceException | RemoteException ex) {
            ex.getSuppressed();
            System.out.println("Erro causado por:" + ex);
        }
        return null;
    }

    public List<Produto> procuraProdutos(int codempresa) {
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String separador[] = gestaoCondominioPort.procuraProdutos(codempresa).split(";");
           
            int qtd = separador.length;
            List<Produto> produtos = new ArrayList<>(qtd);
            for(int i = 0; i < qtd; i++){
                String separador2[] = separador[i].split("-");
                if(separador2[0] != null && !separador2[0].isEmpty()){
                    Produto produto = new Produto();
                    produto.setCodproduto(Integer.valueOf(separador2[0]));
                    produto.setNome(separador2[1]);
                    produto.setValor(Double.valueOf(separador2[2]));
                    produto.setQuantidade(Integer.valueOf(separador2[3]));
                    produto.setCodigobarra(separador2[4]);
                    produto.setStatus(separador2[5]);
                    produto.setCodempresa(codempresa);
                    produtos.add(produto);
                }
            }
            return produtos;
        } catch (ServiceException | RemoteException ex) {
            ex.getSuppressed();
            System.out.println("Erro causado por:" + ex);
        }
        return null;
    }

    public Produto procuraProdutoCodigo(int codigo, int codempresa) {
        try{
            JSONParser parser                                         = new JSONParser();
            Produto    produto                                        = new Produto();
            servico_web.GestaoCondominio _service                     = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String msg2                                               = gestaoCondominioPort.procuraProdutoCodigo(codigo, codempresa);        
            JSONObject jsonObject                                     = (JSONObject) parser.parse(msg2);
            produto.setCodempresa(codempresa);
            produto.setCodproduto(codigo);
            produto.setNome(jsonObject.get("nome").toString());
            produto.setCodigobarra(jsonObject.get("codigobarra").toString());
            produto.setQuantidade(Integer.valueOf(jsonObject.get("quantidade").toString()));
            produto.setValor(Double.valueOf(jsonObject.get("valor").toString()));
            return produto;
        }catch(ServiceException | RemoteException | ParseException ex){
            JOptionPane.showMessageDialog(null, "Erro ao procurar produtos por código causado por:" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
