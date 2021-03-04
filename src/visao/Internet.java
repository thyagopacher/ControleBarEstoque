/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Thyago H Pacher
 */
public class Internet {

    String site;

    /**usado para carregar qualquer arquivo da internet*/
    public InputStream lerArquivoNet(String relatorio) {
        InputStream is = null;
        try {
            String urlString = site + relatorio;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Request-Method", "GET");

            connection.setDoInput(true);
            connection.setDoOutput(false);

            connection.connect();
            is = connection.getInputStream();
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "URL mal formatada:\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de IO ao acessar arquivo:\n" + ex);
        }
        return is;
    }

    /**usado para carregar imagens da internet e usar em jlabel no icon*/
    public Image lerImagemNet(String arquivo) {
        Image image = null;
        try {
            // Lendo de uma URL
            URL url = new URL(arquivo);
            image = ImageIO.read(url);
            return image;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de IO ao acessar arquivo:\n" + ex);
        }
        return null;
    }
}
