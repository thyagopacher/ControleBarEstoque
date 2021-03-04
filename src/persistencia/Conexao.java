/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author Thyago
 */
public class Conexao {

    private static final SessionFactory       f; 
    private static Session                    s;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();

    static{
        Configuration configuration = new Configuration();
        configuration.configure("persistencia/hibernate.cfg.xml").getProperties();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        f = configuration.buildSessionFactory(serviceRegistry);     
    }
    
    //retorna uma sessao de comunicacao com o BD
    public static Session getInstance(){
        s = threadLocal.get();
        if(s == null || s.isOpen() == false){
            s = f.openSession();
            threadLocal.set(s);
        }
        return s;
    }
    
    public static Connection getConnection() {
        try {
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) threadLocal.get().getSessionFactory();
            return sessionFactoryImpl.getConnectionProvider().getConnection();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao pegar conexão para abrir relatório! Causado por:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
