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
import vo.Ambiente;

/**
 *
 * @author Thyago H Pacher
 */
public class AmbientePers {
    
    private Session s; 
    String  msg = "";
    
    public String inserir(Ambiente objeto){
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
    
    public String atualizar(Ambiente objeto){
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
    
    public String excluir(Ambiente objeto){
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
    
    public Ambiente procuraCodigo(int codigo){
        return (Ambiente)Conexao.getInstance().get(Ambiente.class,codigo);
    }  
    
    public List<Ambiente> procuraTodos() {
        return Conexao.getInstance().createQuery("from Ambiente").list();
    }        

    //procura de ambientes por nome, dt inicio, dt final
    public List<Ambiente> procurarAmbiente(String nome, String data1, String data2, int codempresa) {
        String andAmbiente = "";
        if(nome != null && !nome.isEmpty()){
            andAmbiente += " and nome like '%"+nome+"%'";
        }
        if(data1 != null && !data1.isEmpty()){
            andAmbiente += " and dtcadastro >= '"+data1+"'";
        }
        if(data2 != null && !data2.isEmpty()){
            andAmbiente += " and dtcadastro <= '"+data2+"'";
        }
        return Conexao.getInstance().createQuery("from Ambiente where empresa.codempresa = '"+codempresa+"' " + andAmbiente).list();
    }
}
