/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import brandao.swing.*;
import java.awt.HeadlessException;
import javax.swing.JPanel;

/**
 *
 * @author Thyago
 */
public class Impressao implements Printable {

    public String tituloc;
    public List titulo = new ArrayList<>(5);
    public List texto = new ArrayList<>(100);

    private Book book;
    public double fatorConverMMPt = 2.834646D;

    //========== -  Metodo de configuração da impressora Padrão - =============  

    public void imprimir() {
        PrinterJob impressoraPadrao = PrinterJob.getPrinterJob();
        //p.defaultPage();  
        impressoraPadrao.setPrintable(this);
        book = new Book();
        PageFormat pageFormat = new PageFormat();
        //pageFormat = printJob.pageDialog(pageFormat);  
        Paper Folha = new Paper();
        //Papel A4  
        //8,5 pol.  
        double width = 210.9 * fatorConverMMPt;
        //13 pol.  
        double height = 214.9 * fatorConverMMPt;
        //double width  = 8.2;  
        //double height = 8.2;  
        //System.out.print("Largura: " + width + " Altura: " + height);  
        Folha.setSize(width, height);
        Folha.setImageableArea(0.0, 0.0, width, height);
        pageFormat.setPaper(Folha);
        book.append(this, pageFormat);
        impressoraPadrao.setPageable(book);
        try {
            impressoraPadrao.print();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao imprimir, causado por:\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método da interface Printable
     */
    @Override
    public int print(Graphics g, PageFormat format, int pageIndex) throws PrinterException {

        int linha = 0;
        Graphics2D eventoGrafico = (Graphics2D) g;

        //==== - Define o formado da folha de impressão (area possivel de se fazer a impressão do conteudo) - =======  
        eventoGrafico.translate(format.getImageableX(), format.getImageableX());

        eventoGrafico.setFont(new Font("Arial", Font.BOLD, 20));
        eventoGrafico.drawString(this.tituloc, 46, 100 + linha);
        linha = linha + 20;
        //======- Imprimindo o conteudo evento.drawString(valor, eixo x, e eixo y) - ================
        if (titulo != null && !titulo.isEmpty() && texto != null && !texto.isEmpty()) {
            for (int i = 0; i < titulo.size(); i++) {
                if (titulo.get(1).toString() != null && !titulo.get(1).toString().isEmpty()) {
                    eventoGrafico.setFont(new Font("Arial", Font.BOLD, 18));
                    eventoGrafico.drawString(titulo.get(i).toString(), 46, 100 + linha);
                    linha = linha + 20;
                }
                if (texto.get(1).toString() != null && !texto.get(1).toString().isEmpty()) {
                    eventoGrafico.setFont(new Font("Arial", Font.PLAIN, 12));
                    eventoGrafico.drawString(texto.get(1).toString(), 46, 100 + linha);
                    linha = linha + 20;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Texto e titulos enviados estão em branco", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return PAGE_EXISTS;
    }

    public void visualizaImpressao(JPanel papel) {
        try {
            brandao.swing.JVisualizarImpressao jvp = new brandao.swing.JVisualizarImpressao(new javax.swing.JFrame(), true);
            jvp.getJVImpressao().addPagina(papel);
            jvp.getJVImpressao().selecionarPagina(0);
            jvp.setVisible(true);
        } catch (HeadlessException | JVException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao visualizar impressão ocasionado por:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        } catch(Throwable ex){
            JOptionPane.showMessageDialog(null, "Erro ao visualizar impressão ocasionado por:" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
