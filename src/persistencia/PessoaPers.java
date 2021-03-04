/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import vo.Apartamento;
import vo.Bloco;
import vo.Empresa;
import vo.Pessoa;

/**
 *
 * @author Thyago H Pacher
 */
public class PessoaPers {

    private Session s;
    String msg = "";

    public String inserir(Pessoa objeto) {
        try {
            s = Conexao.getInstance();
            Transaction tx = s.beginTransaction();
            s.save(objeto);
            tx.commit();//faz a transacao
        } catch (HibernateException ex) {
            msg = "Erro ao inserir: " + ex;
        }
        return null;
    }

    public String atualizar(Pessoa objeto) {
        try {
            s = Conexao.getInstance();
            Transaction tx = s.beginTransaction();
            s.update(objeto);
            tx.commit();//faz a transacao
        } catch (HibernateException ex) {
            msg = "Erro ao atualizar: " + ex;
        }
        return null;
    }

    public String excluir(Pessoa objeto) {
        try {
            s = Conexao.getInstance();
            Transaction tx = s.beginTransaction();
            s.delete(objeto);
            tx.commit();//faz a transacao
        } catch (HibernateException ex) {
            msg = "Erro ao excluir: " + ex;
        }
        return null;
    }

    public Pessoa procuraCodigo(int codigo) {
        return (Pessoa) Conexao.getInstance().get(Pessoa.class, codigo);
    }

    public List<Pessoa> procuraNomeParcial(String nome) {
        return Conexao.getInstance().createQuery("from Pessoa where nome like '%" + nome + "%' order by nome ASC").list();
    }

    public Pessoa login1(String email, String senha) throws UnsupportedEncodingException {
        byte[] bytes = senha.getBytes("UTF-8");
        String encoded = Base64.getEncoder().encodeToString(bytes);        
        return (Pessoa)Conexao.getInstance().createQuery("from Pessoa where email = '" + email + "' and senha = '"+encoded+"' order by nome ASC").list().iterator().next();
    }

    public String Login(String email, String senha) throws RemoteException {
        String msg2 = "";
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            msg2 = gestaoCondominioPort.login(email, senha, InetAddress.getLocalHost().getHostAddress(), "desktop");
        } catch (ServiceException | UnknownHostException | RemoteException ex) {
            msg2 = "Erro causado por:" + ex;
        }
        return msg2;
    }

    public List<Bloco> procuraBlocos(int codempresa) throws RemoteException {
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String separador[] = gestaoCondominioPort.procuraBlocos(codempresa).split(";");
            int qtdBlocos = separador.length;
            List<Bloco> blocos = new ArrayList<>(qtdBlocos);
            for(int i = 0; i < qtdBlocos; i++){
                blocos.add(new Bloco(separador[i]));
            }
            return blocos;
        } catch (ServiceException | RemoteException ex) {
            ex.getSuppressed();
        }
        return null;
    }

    public List<Apartamento> procuraApartamentos(String bloco, int codempresa) {
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String separador[] = gestaoCondominioPort.procuraApartamentos(bloco, codempresa).split(";");
           
            int qtd = separador.length;
            List<Apartamento> apartamentos = new ArrayList<>(qtd);
            for(int i = 0; i < qtd; i++){
                Apartamento apartamento = new Apartamento();
                apartamento.setBloco(bloco);
                apartamento.setApartamento(separador[i]);
                apartamentos.add(apartamento);
            }
            return apartamentos;
        } catch (ServiceException | RemoteException ex) {
            ex.getSuppressed();
            System.out.println("Erro causado por:" + ex);
        }
        return null;
    }
    

    public List<Apartamento> procuraApartamentos2(int codempresa) {
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String separador[] = gestaoCondominioPort.procuraApartamentos2(codempresa).split(";");
           
            int qtd = separador.length;
            List<Apartamento> apartamentos = new ArrayList<>(qtd);
            for(int i = 0; i < qtd; i++){
                String      separador2[] = separador[i].split("-");
                Apartamento apartamento  = new Apartamento();
                apartamento.setBloco(separador2[1]);
                apartamento.setApartamento(separador2[0]);
                apartamentos.add(apartamento);
            }
            return apartamentos;
        } catch (ServiceException | RemoteException ex) {
            ex.getSuppressed();
            System.out.println("Erro causado por:" + ex);
        }
        return null;
    }    
    
    public List<Pessoa> procuraMorador(String bloco, String apartamento, int codempresa) {
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String separador[] = gestaoCondominioPort.procuraMorador(bloco, apartamento, codempresa).split(";");
           
            int qtd = separador.length;
            List<Pessoa> pessoas = new ArrayList<>(qtd);
            for(int i = 0; i < qtd; i++){
                String separador2[] = separador[i].split("-");
                if(separador2[0] != null && !separador2[0].isEmpty()){
                    Pessoa morador = new Pessoa();
                    morador.setCodpessoa(Integer.valueOf(separador2[0]));
                    morador.setNome(separador2[1].toUpperCase());
                    morador.setApartamento(apartamento);
                    morador.setBloco(bloco);
                    morador.setEmpresa(new Empresa(codempresa));
                    pessoas.add(morador);
                }
            }
            return pessoas;
        } catch (ServiceException | RemoteException ex) {
            ex.getSuppressed();
            System.out.println("Erro causado por:" + ex);
        }
        return null;
    }    
    
    public Pessoa procuraMoradorCodigo(int codempresa, int codpessoa) {
        try{
            JSONParser parser = new JSONParser();
            JSONObject jsonObject;
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String msg2   = gestaoCondominioPort.procuraMoradorCodigo(codempresa, codpessoa);        
            jsonObject    = (JSONObject) parser.parse(msg2);
            Pessoa pessoa = new Pessoa();
            pessoa.setCodpessoa(codpessoa);
            pessoa.setNome(jsonObject.get("nome").toString());
            pessoa.setApartamento(jsonObject.get("apartamento").toString());
            pessoa.setBloco(jsonObject.get("bloco").toString());
            pessoa.setCodcategoria(Integer.valueOf(jsonObject.get("codcategoria").toString()));
            pessoa.setEmpresa(new Empresa(codempresa));
            return pessoa;
        }catch (ServiceException | ParseException | RemoteException ex) {
            ex.getSuppressed();
            System.out.println("Erro causado por:" + ex);
        }
        return null;
    }
    

    public List<Pessoa> procuraMoradorEmpresa(int codempresa) {
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String separador[] = gestaoCondominioPort.procuraMoradorEmpresa(codempresa).split(";");
           
            int qtd = separador.length;
            List<Pessoa> pessoas = new ArrayList<>(qtd);
            for(int i = 0; i < qtd; i++){
                String separador2[] = separador[i].split("-");
                if(separador2[0] != null && !separador2[0].isEmpty()){
                    Pessoa morador = new Pessoa();
                    morador.setCodpessoa(Integer.valueOf(separador2[0]));
                    morador.setNome(separador2[1].toUpperCase());
                    morador.setApartamento(separador2[2]);
                    morador.setBloco(separador2[3]);
                    morador.setEmpresa(new Empresa(codempresa));
                    pessoas.add(morador);
                }
            }
            return pessoas;
        } catch (ServiceException | RemoteException ex) {
            ex.getSuppressed();
            System.out.println("Erro causado por:" + ex);
        }
        return null;
    }    
    
    /**lista pessoas que foram logadas
     * @return retorna pessoas que já fizeram login algum dia*/
    public List<Pessoa> getListaCache(){
        File arquivo = new File("pessoa");
        try {
            if(arquivo.exists()){
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("pessoa")))) {
                    return (List<Pessoa>) ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            if(arquivo.exists()){
                boolean resapagar = arquivo.delete();
                if(resapagar == false){
                    JOptionPane.showMessageDialog(null, "Erro ao apagar cache de arquivo de pessoas logadas!!!", "ERRO:", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, ex, "ERRO:", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;    
    }
    
    /**
     * seta novas pessoas que logaram
     * @param pessoas para passar a pessoa que está logando
     * @return 
     */
    public String setObj(List<Pessoa> pessoas) {
        java.io.ObjectOutputStream oos;
        try {
            oos = new java.io.ObjectOutputStream(new FileOutputStream(new File("pessoa")));
            oos.writeObject(pessoas);
            oos.close();            
        } catch (IOException ex) {
            return "Erro ao registrar pessoa no cache causado por:" + ex;
        }
        return null;
    }    
    
    /**lista pessoas que foram logadas
     * @return retorna pessoas que já fizeram login algum dia*/
    public List<Pessoa> getListaCacheMorador(){
        File arquivo = new File("morador");
        try {
            if(arquivo.exists()){
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("morador")))) {
                    return (List<Pessoa>) ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            if(arquivo.exists()){
                boolean resapagar = arquivo.delete();
                if(resapagar == false){
                    JOptionPane.showMessageDialog(null, "Erro ao apagar cache de arquivo de pessoas logadas!!!", "ERRO:", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, ex, "ERRO:", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;    
    }
    
    /**
     * seta novas pessoas que logaram
     * @param pessoas para passar a pessoa que está logando
     * @return retorna erro ou vazio caso tenha ido certo
     */
    public String setObjMorador(List<Pessoa> pessoas) {
        java.io.ObjectOutputStream oos;
        try {
            oos = new java.io.ObjectOutputStream(new FileOutputStream(new File("morador")));
            oos.writeObject(pessoas);
            oos.close();            
        } catch (IOException ex) {
            return "Erro ao registrar pessoa no cache causado por:" + ex;
        }
        return null;
    }    




}



