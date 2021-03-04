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
import vo.Veiculo;

/**
 *
 * @author Thyago H Pacher
 */
public class VeiculoPers {
    
    private Session s; 
    String  msg = "";
    
    public String inserir(Veiculo objeto){
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
    
    public String atualizar(Veiculo objeto){
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
    
    public String excluir(Veiculo objeto){
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
    
    public Veiculo procuraCodigo(int codigo){
        return (Veiculo)Conexao.getInstance().get(Veiculo.class,codigo);
    }  
    
    public List<Veiculo> procuraTodos() {
        return Conexao.getInstance().createQuery("from Veiculo").list();
    }        
}
