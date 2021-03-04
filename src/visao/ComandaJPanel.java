/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import java.util.List;
import negocio.ItemPedidoRN;
import negocio.PedidoRN;
import vo.ItemPedido;
import vo.Pedido;
import vo.Pessoa;

/**
 *
 * @author Thyago H Pacher
 */
public class ComandaJPanel extends javax.swing.JPanel {

    PedidoRN             piRN   = new PedidoRN();
    ItemPedidoRN         iRN    = new ItemPedidoRN();
    Pedido               pedido = new Pedido();
    List<ItemPedido>     itens  = new ArrayList<>(5);
    /**
     * Creates new form NewJPanel
     */
    public ComandaJPanel() {
        initComponents();
    }
    
    public ComandaJPanel(Pedido pedido, Pessoa usuario) {
        initComponents();
//        setLayout(null);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(283, 800));
        setPreferredSize(new java.awt.Dimension(283, 800)); 
        
        lcondominio_nome.setText(lcondominio_nome.getText() + " " + usuario.getEmpresa());
//        lcondominio_nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);//centraliza o titulo
        lcondominio_nome.setBounds(10, 40, 590, 42);        
           
        lcomanda.setBounds(10, 80, 590, 42);
        lnumeral_comanda.setBounds(100, 80, 590, 42);
        lnumeral_comanda.setText(String.valueOf(pedido.getCodpedido()));
        
        lstatus.setBounds(10, 100, 590, 42);    
        lsituacao_comanda.setBounds(100, 100, 590, 42);  
        
        ldescricao.setBounds(10, 120, 590, 42);        
        lunitario.setBounds(85, 120, 590, 42);        
        lqtd.setBounds(150, 120, 590, 42);        
        lapagar.setBounds(200, 120, 590, 42);                           
        
        tabela_comanda.setBounds(10, 200, 590, 42);
        
        ltotal_geral.setBounds(10, 670, 590, 42);     
        lbloco_escrito.setBounds(130, 670, 590, 42);        
        lapto.setBounds(150, 670, 590, 42);    
        lapto_escrito.setBounds(180, 670, 590, 42);
        lvalor_escrito.setBounds(220, 670, 590, 42);   
        
//        limportante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);//centraliza o titulo
        limportante.setBounds(10, 700, 590, 42);  
        lreclamacao.setBounds(10, 720, 590, 42);        
        lvalores.setBounds(10, 750, 590, 42);          
        lmarca_gestccon.setBounds(10, 770, 590, 42);        
        this.pedido = pedido;
        itens       = iRN.procurarItemPedido(pedido.getCodpedido(), pedido.getEmpresa().getCodempresa());
        if(pedido.getCodstatus() == 1){
            lsituacao_comanda.setText("ABERTO");
        }else if(pedido.getCodstatus() == 2){
            lsituacao_comanda.setText("FECHADO");
        }
        lbloco_escrito.setText(pedido.getMorador().getBloco());
        lapto_escrito.setText(pedido.getMorador().getApartamento());
        add(lcondominio_nome);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lcondominio_nome = new javax.swing.JLabel();
        lcomanda = new javax.swing.JLabel();
        lstatus = new javax.swing.JLabel();
        ldescricao = new javax.swing.JLabel();
        lunitario = new javax.swing.JLabel();
        lqtd = new javax.swing.JLabel();
        lapagar = new javax.swing.JLabel();
        lreclamacao = new javax.swing.JLabel();
        limportante = new javax.swing.JLabel();
        lvalores = new javax.swing.JLabel();
        lmarca_gestccon = new javax.swing.JLabel();
        ltotal_geral = new javax.swing.JLabel();
        lvalor_escrito = new javax.swing.JLabel();
        lapto = new javax.swing.JLabel();
        lsituacao_comanda = new javax.swing.JLabel();
        lbloco_escrito = new javax.swing.JLabel();
        lapto_escrito = new javax.swing.JLabel();
        lnumeral_comanda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_comanda = new javax.swing.JTable();

        setBackground(java.awt.Color.white);

        lcondominio_nome.setBackground(new java.awt.Color(0, 102, 204));
        lcondominio_nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lcondominio_nome.setText("Condominio");

        lcomanda.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lcomanda.setText("COMANDA");

        lstatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lstatus.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        lstatus.setText("STATUS");

        ldescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ldescricao.setText("Descrição");

        lunitario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lunitario.setText("Unitário");

        lqtd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lqtd.setText("Qtd.");

        lapagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lapagar.setText("À pagar");

        lreclamacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lreclamacao.setText("<html>RECLAMAÇÃO SÓ SERÁ ACEITA COM ESTE<br>COMPROVANTE EM MÃOS.<html>");

        limportante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        limportante.setText("#IMPORTANTE#");

        lvalores.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lvalores.setText("<html>OS VALORES CONSTANDO COMO BOLETO, SERÃO COBRADOS NA<br> COTA CONDOMINIAL</html>");

        lmarca_gestccon.setText("@GestCCon");

        ltotal_geral.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ltotal_geral.setText("Total Geral para o BL:");

        lvalor_escrito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lvalor_escrito.setText("R$ 0,00");

        lapto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lapto.setText("Apto:");

        lsituacao_comanda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lsituacao_comanda.setText("situação comanda");

        lbloco_escrito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbloco_escrito.setText("bloco");

        lapto_escrito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lapto_escrito.setText("apartamento");

        lnumeral_comanda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lnumeral_comanda.setText("numeral_comanda");

        tabela_comanda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela_comanda.setToolTipText("");
        jScrollPane1.setViewportView(tabela_comanda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(lcondominio_nome))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ltotal_geral)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbloco_escrito))
                            .addComponent(ldescricao))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lunitario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lapagar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lapto)
                                .addGap(18, 18, 18)
                                .addComponent(lapto_escrito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lvalor_escrito))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lreclamacao)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lstatus)
                                    .addComponent(lcomanda))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lnumeral_comanda)
                                    .addComponent(lsituacao_comanda)))
                            .addComponent(lvalores)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lmarca_gestccon))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(limportante)))
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lcondominio_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcomanda)
                    .addComponent(lnumeral_comanda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lstatus)
                    .addComponent(lsituacao_comanda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ldescricao)
                    .addComponent(lunitario)
                    .addComponent(lqtd)
                    .addComponent(lapagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ltotal_geral)
                    .addComponent(lvalor_escrito, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lapto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbloco_escrito)
                    .addComponent(lapto_escrito))
                .addGap(31, 31, 31)
                .addComponent(limportante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lreclamacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lvalores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(lmarca_gestccon)
                .addGap(13, 13, 13))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(165, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(245, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lapagar;
    private javax.swing.JLabel lapto;
    private javax.swing.JLabel lapto_escrito;
    private javax.swing.JLabel lbloco_escrito;
    private javax.swing.JLabel lcomanda;
    private javax.swing.JLabel lcondominio_nome;
    private javax.swing.JLabel ldescricao;
    private javax.swing.JLabel limportante;
    private javax.swing.JLabel lmarca_gestccon;
    private javax.swing.JLabel lnumeral_comanda;
    private javax.swing.JLabel lqtd;
    private javax.swing.JLabel lreclamacao;
    private javax.swing.JLabel lsituacao_comanda;
    private javax.swing.JLabel lstatus;
    private javax.swing.JLabel ltotal_geral;
    private javax.swing.JLabel lunitario;
    private javax.swing.JLabel lvalor_escrito;
    private javax.swing.JLabel lvalores;
    private javax.swing.JTable tabela_comanda;
    // End of variables declaration//GEN-END:variables
}
