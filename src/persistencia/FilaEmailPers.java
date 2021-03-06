/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vo.FilaEmail;

/**
 *
 * @author Thyago H Pacher
 */
public class FilaEmailPers {
    
    
    private Session s; 
    String  msg = "";
    
    public String inserir(FilaEmail objeto){
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
    
    public String atualizar(FilaEmail objeto){
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
    
    public String excluir(FilaEmail objeto){
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
    
    public FilaEmail procuraCodigo(int codigo){
        return (FilaEmail)Conexao.getInstance().get(FilaEmail.class,codigo);
    }  
    
    public List<FilaEmail> procuraTodos() {
        return Conexao.getInstance().createQuery("from FilaEmail").list();
    }            
    
}
