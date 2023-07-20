/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package tela;

import entidades.Cidade;
import entidades.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.HibernateUtil;

/**
 *
 * @author jaimedias
 */
public class CidadeTela extends javax.swing.JDialog {

    private Cidade cid = new Cidade();
    private List<Cidade> listaCidades = new ArrayList<>();
    private List<Estado> listaEstados = new ArrayList<>();

    public void montaCombo() {

        cEstado.removeAllItems();
        listaEstados = HibernateUtil.getSession().createQuery("from Estado order by nome").list();
        for (Estado e : listaEstados) {
            cEstado.addItem(e.getNome());
        }

    }

    public void validaCampos(String operacao) {
        if (operacao.equals("inicio")) {
            btNovo.setEnabled(true);
            btEditar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            cNome.setEnabled(false);
            cEstado.setEnabled(false);
        } else if (operacao.equals("novo")) {
            btNovo.setEnabled(false);
            btEditar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
            btSair.setEnabled(false);
            cNome.setEnabled(true);
            cEstado.setEnabled(true);
        } else if (operacao.equals("selecionado")) {
            btNovo.setEnabled(true);
            btEditar.setEnabled(true);
            btExcluir.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
            btSair.setEnabled(true);
            cNome.setEnabled(false);
            cEstado.setEnabled(false);
        }

    }

    public void montaTabela() {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Estado");

        listaCidades = HibernateUtil.getSession().createQuery("from Cidade").list();
        for (Cidade e : listaCidades) {
            modelo.addRow(new Object[]{e.getId(), e.getNome(), e.getEstado().getNome()});
        }
        tabela.setModel(modelo);
    }

    /**
     * Creates new form CidadeTela
     */
    public CidadeTela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        montaTabela();
        validaCampos("inicio");
        montaCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cCodigo = new javax.swing.JTextField();
        cNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        cEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Cidade");

        jLabel2.setText("Código:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Estado:");

        cCodigo.setEditable(false);
        cCodigo.setEnabled(false);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        cEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cNome, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btEditar, btExcluir, btNovo, btSair, btSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btSair)
                    .addComponent(btExcluir)
                    .addComponent(btNovo)
                    .addComponent(btEditar)
                    .addComponent(btCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed

//Simplesmente fecha a tela, mas o sistema continua rodando.        
        dispose();
//Encerra a aplicação como um todo, fecha todo o sistema.
//        System.exit(1);

    }//GEN-LAST:event_btSairActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        String mensagem = "";
        if (cNome.getText().equals("")) {
            mensagem = mensagem + "O campo nome é obrigatório!";
        }
        if (cEstado.getSelectedItem().equals("")) {
            if (!mensagem.equals("")) {
                mensagem = mensagem + "\n";
            }
            mensagem = mensagem + "O campo estado é obrigatório!";
        }
        if (!mensagem.equals("")) {
            JOptionPane.showMessageDialog(null, mensagem);
        } else {

            if (!cCodigo.getText().equals("")) {
                cid.setId(Long.parseLong(cCodigo.getText()));
            }
            cid.setNome(cNome.getText());
            cid.setEstado(listaEstados.get(cEstado.getSelectedIndex()));

            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().merge(cid);
            HibernateUtil.commitTransaction();
            HibernateUtil.closeSession();

            cid = new Cidade();
            limpaCampos();
            montaTabela();
            validaCampos("inicio");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    public void limpaCampos() {
        cCodigo.setText("");
        cNome.setText("");
        cEstado.setSelectedItem(null);
    }

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

        cid = listaCidades.get(tabela.getSelectedRow());
        cCodigo.setText(cid.getId().toString());
        cNome.setText(cid.getNome());
        cEstado.setSelectedItem(cid.getEstado().getNome());
        validaCampos("selecionado");

    }//GEN-LAST:event_tabelaMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(cid);
        HibernateUtil.commitTransaction();
        HibernateUtil.closeSession();

        cid = new Cidade();
        montaTabela();
        limpaCampos();
        validaCampos("inicio");

    }//GEN-LAST:event_btExcluirActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

        cid = new Cidade();
        limpaCampos();
        validaCampos("novo");

        // TODO add your handling code here:
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        limpaCampos();
        validaCampos("inicio");
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        validaCampos("novo");
        // TODO add your handling code here:
    }//GEN-LAST:event_btEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CidadeTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CidadeTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CidadeTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CidadeTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CidadeTela dialog = new CidadeTela(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField cCodigo;
    private javax.swing.JComboBox<String> cEstado;
    private javax.swing.JTextField cNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}