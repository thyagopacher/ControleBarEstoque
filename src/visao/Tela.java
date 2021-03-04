/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author ThyagoHenrique
 */
public class Tela {

    public void centralizarComponente(JFrame janela) {
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = janela.getSize();
        janela.setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }
    
    public String abreArquivo() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getPath();
        } else {
            return null;
        }
    }    
}
