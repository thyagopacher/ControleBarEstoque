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
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;
import vo.Pessoa;
import vo.TipoPagamento;

/**
 *
 * @author Thyago H Pacher
 */
public class TipoPagamentoPers {
    
    public List<TipoPagamento> procurarTipo(int codempresa){
        try { 
            servico_web.GestaoCondominio _service = new servico_web.GestaoCondominio_Impl();
            servico_web.GestaoCondominioPortType gestaoCondominioPort = _service.getGestaoCondominioPort();
            String separador[] = gestaoCondominioPort.procuraTipoPagamento(codempresa).split(";");
           
            int qtd = separador.length;
            List<TipoPagamento> tipos = new ArrayList<>(qtd);
            for(int i = 0; i < qtd; i++){
                String separador2[] = separador[i].split("-");
                TipoPagamento tp = new TipoPagamento();
                tp.setCodtipo(Integer.valueOf(separador2[0]));
                tp.setNome(separador2[1]);
                tipos.add(tp);
            }
            return tipos;
        } catch (ServiceException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar formas de pagamento causado por:" + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return null;        
    }
    
    /**lista pessoas que foram logadas
     * @return retorna pessoas que já fizeram login algum dia*/
    public List<TipoPagamento> getListaCache(){
        File arquivo = new File("tipoPagamento");
        try {
            if(arquivo.exists()){
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                    return (List<TipoPagamento>) ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            if(arquivo.exists()){
                boolean resapagar = arquivo.delete();
                if(resapagar == false){
                    JOptionPane.showMessageDialog(null, "Erro ao apagar cache de arquivo de tipo de pagamento!!!", "ERRO:", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, ex, "ERRO:", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;    
    }
    
    /**
     * seta novas pessoas que logaram
     * @param tipos de pagamentos ja pesquisados anteriormente
     * @return erro se houver ou em branco caso tenha ocorrido tudo bem.
     */
    public String setObj(List<TipoPagamento> tipos) {
        java.io.ObjectOutputStream oos;
        try {
            oos = new java.io.ObjectOutputStream(new FileOutputStream(new File("tipoPagamento")));
            oos.writeObject(tipos);
            oos.close();            
        } catch (IOException ex) {
            return "Erro ao registrar tipo de pagamento no cache causado por:" + ex;
        }
        return null;
    }        
}
