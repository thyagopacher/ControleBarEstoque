/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import org.hibernate.Session;
import vo.Pagina;

/**
 *
 * @author Thyago H Pacher
 */
public class PaginaPers {
    
    private Session s; 
    String msg = "";
    
    public String inserir(Pagina objeto){
        String msg2 = "";
//        try { 
//            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
//            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
//            msg2 = gestaoCondominioPort.inserirPagina(objeto.getNome(), String.valueOf(objeto.getValor()), objeto.getCodigobarra(), objeto.getQuantidade(), objeto.getCodempresa(), objeto.getStatus());
//        } catch (ServiceException | RemoteException ex) {
//            msg2 = "Erro causado por:" + ex;
//        }
        return msg2;
    }
    
    public String atualizar(Pagina objeto){
        String msg2 = "";
//        try { 
//            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
//            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
//            msg2 = gestaoCondominioPort.atualizarPagina(objeto.getNome(), String.valueOf(objeto.getValor()), objeto.getCodigobarra(), objeto.getQuantidade(), objeto.getCodempresa(), objeto.getCodpagina(), objeto.getStatus());
//        } catch (ServiceException | RemoteException ex) {
//            msg2 = "Erro causado por:" + ex;
//        }
        return msg2;
    }
    
    public String excluir(Pagina objeto){
//        String msg2 = "";
//        try { 
//            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
//            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
//            msg2 = gestaoCondominioPort.excluirPagina(objeto.getCodpagina(), objeto.getCodempresa());
//        } catch (ServiceException | RemoteException ex) {
//            msg2 = "Erro causado por:" + ex;
//        }
        return "";
    }
    
    public Pagina procuraCodigo(int codigo){
        return (Pagina)Conexao.getInstance().get(Pagina.class,codigo);
    }  
    
    public List<Pagina> procuraNomeParcial(String nome) {
        return Conexao.getInstance().createQuery("from Pagina where nome like '%" + nome + "%' order by nome ASC").list();
    }        

    public List<Pagina> procuraPaginaCodigoBarra(String codigobarra, int codempresa) {
//        try { 
//            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
//            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
//            String separador[] = gestaoCondominioPort.procuraPaginaCodigoBarra(codigobarra, codempresa).split(";");
//           
//            int qtd = separador.length;
//            List<Pagina> paginas = new ArrayList<>(qtd);
//            for(int i = 0; i < qtd; i++){
//                String separador2[] = separador[i].split("-");
//                if(separador2[0] != null && !separador2[0].isEmpty()){
//                    Pagina pagina = new Pagina();
//                    pagina.setCodpagina(Integer.valueOf(separador2[0]));
//                    pagina.setNome(separador2[1]);
//                    pagina.setValor(Double.valueOf(separador2[2]));
//                    pagina.setQuantidade(Integer.valueOf(separador2[3]));
//                    pagina.setCodigobarra(separador[4]);
//                    pagina.setStatus(separador2[5]);
//                    pagina.setCodempresa(codempresa);
//                    paginas.add(pagina);
//                }
//            }
//            return paginas;
//        } catch (ServiceException | RemoteException ex) {
//            ex.getSuppressed();
//            System.out.println("Erro causado por:" + ex);
//        }
        return null;
    }

    public List<Pagina> procuraPaginas(int codempresa) {
//        try { 
//            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
//            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
//            String separador[] = gestaoCondominioPort.procuraPaginas(codempresa).split(";");
//           
//            int qtd = separador.length;
//            List<Pagina> paginas = new ArrayList<>(qtd);
//            for(int i = 0; i < qtd; i++){
//                String separador2[] = separador[i].split("-");
//                if(separador2[0] != null && !separador2[0].isEmpty()){
//                    Pagina pagina = new Pagina();
//                    pagina.setCodpagina(Integer.valueOf(separador2[0]));
//                    pagina.setNome(separador2[1]);
//                    pagina.setValor(Double.valueOf(separador2[2]));
//                    pagina.setQuantidade(Integer.valueOf(separador2[3]));
//                    pagina.setCodigobarra(separador2[4]);
//                    pagina.setStatus(separador2[5]);
//                    pagina.setCodempresa(codempresa);
//                    paginas.add(pagina);
//                }
//            }
//            return paginas;
//        } catch (ServiceException | RemoteException ex) {
//            ex.getSuppressed();
//            System.out.println("Erro causado por:" + ex);
//        }
        return null;
    }

    public Pagina procuraPaginaCodigo(int codigo, int codempresa) {
//        try{
//            JSONParser parser                                         = new JSONParser();
//            Pagina    pagina                                        = new Pagina();
//            servico_web.GestaoCondominio _service                     = new servico_web.GestaoCondominio_Impl();
//            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
//            String msg2                                               = gestaoCondominioPort.procuraPaginaCodigo(codigo, codempresa);        
//            JSONObject jsonObject                                     = (JSONObject) parser.parse(msg2);
//            pagina.setCodempresa(codempresa);
//            pagina.setCodpagina(codigo);
//            pagina.setNome(jsonObject.get("nome").toString());
//            pagina.setCodigobarra(jsonObject.get("codigobarra").toString());
//            pagina.setQuantidade(Integer.valueOf(jsonObject.get("quantidade").toString()));
//            pagina.setValor(Double.valueOf(jsonObject.get("valor").toString()));
//            return pagina;
//        }catch(ServiceException | RemoteException | ParseException ex){
//            JOptionPane.showMessageDialog(null, "Erro ao procurar paginas por código causado por:" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
//        }
        return null;
    }
}
