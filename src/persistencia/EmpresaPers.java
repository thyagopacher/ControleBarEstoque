/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.rmi.RemoteException;
import java.util.List;
import javax.xml.rpc.ServiceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vo.Empresa;

/**
 *
 * @author Thyago H Pacher
 */
public class EmpresaPers {
    
    private Session s; 
    String  msg = "";
    
    public String inserir(Empresa objeto){
        try{
            s              = Conexao.getInstance();
            Transaction tx = s.beginTransaction();            
            s.save(objeto);
            tx.commit();//faz a transacao
        }catch(HibernateException ex){
            msg = "Erro ao inserir: " + ex;
        }
        return null;
    }
    
    public String atualizar(Empresa objeto){
        try{
            s              = Conexao.getInstance();
            Transaction tx = s.beginTransaction();            
            s.update(objeto);
            tx.commit();//faz a transacao
        }catch(HibernateException ex){
            msg = "Erro ao atualizar: " + ex;
        }
        return null;
    }
    
    public String excluir(Empresa objeto){
        try{
            s              = Conexao.getInstance();
            Transaction tx = s.beginTransaction();            
            s.delete(objeto);
            tx.commit();//faz a transacao
        }catch(HibernateException ex){
            msg = "Erro ao excluir: " + ex;
        }
        return null;
    }
    
    public Empresa procuraCodigo(int codigo){
        return (Empresa)Conexao.getInstance().get(Empresa.class,codigo);
    }  
    
    public List<Empresa> procuraTodos() {
        return Conexao.getInstance().createQuery("from Empresa").list();
    }            
    
    public String procurarLogo(int codempresa) throws RemoteException {
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            msg2 = gestaoCondominioPort.procurarLogo(codempresa);
        } catch (ServiceException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }    

}
