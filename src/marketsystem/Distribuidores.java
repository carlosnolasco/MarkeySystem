/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hugo
 */
public class Distribuidores extends javax.swing.JFrame {
private final CRUD crud = new CRUD();
    private DefaultTableModel model;
    private int idActual = 0;
    public Distribuidores() {
        initComponents();
        this.inicioTabla();
        this.TD.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            if (!lse.getValueIsAdjusting()) {
                int x1 =TD.getSelectedRow();
                if(model.getRowCount() > 0 && TD.getSelectedRow() >= 0){
                    LlenadoCampos(TD.getSelectedRow());
                }
            }
        });
        if(this.model.getRowCount() > 0){
            this.TD.setRowSelectionInterval(0, 0);
       
    }
    }
     private void inicioTabla(){
        this.model = (DefaultTableModel)(this.TD.getModel());
        this.TD.setModel(this.model);
        
      
        this.LlenarTabla();
    }
    private void LlenarTabla(){
        this.limpiarTabla();
        try{
            ResultSet rs = crud.obtenerDistribuidores();
            while(rs.next()){
                Object row [] = new Object[9];
                for (int i = 0; i < 9; i++) {
                    row[i] = rs.getObject(i+1);
                }
                //Agregamos cada registro al modelo de la tabla
                model.addRow(row);
            }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void LlenarTabla(String param){
        this.limpiarTabla();
        try{
            ResultSet rs = crud.obtenerDistribuidoresP(param);
            while(rs.next()){
                Object row [] = new Object[9];
                for (int i = 0; i < 9; i++) {
                    row[i] = rs.getObject(i+1);
                }
                //Agregamos cada registro al modelo de la tabla
                model.addRow(row);
            }
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void LlenarTabla(int id){
        this.limpiarTabla();
        try{
            ResultSet rs = crud.obtenerDistribuidoresId( id);
            while(rs.next()){
                Object row [] = new Object[9];
                for (int i = 0; i < 9; i++) {
                    row[i] = rs.getObject(i+1);
                }
                //Agregamos cada registro al modelo de la tabla
                model.addRow(row);
            }
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limpiarTabla(){
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i-=1;
        }
    }
     private void createNew(){
        this.limpiarTabla();
        this.idActual = 0;
        this.txtNombre.setText("");
        this.txtRFC.setText("");
        this.txtCalle.setText("");
        this.txtColonia.setText("");
        this.txtCP.setText("");
        this.txtNumeroLocal.setText("");
        this.txtTelefono.setText("");
        this.txtNombre.requestFocus();
    }
    private void LlenadoCampos(int row){
        if(this.model.getRowCount() > 0){
       this.txtNombre.setText(this.model.getValueAt(row, 1).toString());
            this.txtRFC.setText(this.model.getValueAt(row, 2).toString());
            this.txtCalle.setText(this.model.getValueAt(row, 3).toString());
            this.txtColonia.setText(this.model.getValueAt(row, 4).toString());
            this.txtCP.setText(this.model.getValueAt(row, 5).toString());
            this.txtNumeroLocal.setText(this.model.getValueAt(row, 6).toString());
            this.txtTelefono.setText(this.model.getValueAt(row, 7).toString());
            idActual = Integer.parseInt(model.getValueAt(row, 0).toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jDialog1 = new javax.swing.JDialog();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtCalle = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtCP = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        RegresarDistribuidores = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        ActualizarD = new javax.swing.JButton();
        EliminarD = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TD = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNumeroLocal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        Tipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Buscar = new javax.swing.JTextField();
        BuscarD = new javax.swing.JButton();
        NuevoD = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFCKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRFC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCP)
                    .addComponent(txtColonia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombre))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel3.setText("Calle");

        jLabel2.setText("RFC");

        jLabel1.setText("Nombre de la empresa");

        jLabel5.setText("Colonia");

        jLabel7.setText("C.P");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        jLabel6.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel6.setText(" Distribuidores");

        RegresarDistribuidores.setText("Regresar");
        RegresarDistribuidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarDistribuidoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(RegresarDistribuidores)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegresarDistribuidores)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        ActualizarD.setText("Actualizar distribuidor");
        ActualizarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActualizarDMouseClicked(evt);
            }
        });

        EliminarD.setText("Eliminar distribuidor");
        EliminarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarDMouseClicked(evt);
            }
        });

        jButton1.setText("Registrar distribuidor");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(ActualizarD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EliminarD)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ActualizarD)
                    .addComponent(EliminarD)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IdDistribuidor", "NombreEmpresa", "RFC", "Calle", "Colonia", "Codigo Postal", "Número local", "Télefono", "TipoDistribuidor"
            }
        ));
        jScrollPane2.setViewportView(TD);
        if (TD.getColumnModel().getColumnCount() > 0) {
            TD.getColumnModel().getColumn(5).setResizable(false);
            TD.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        jLabel8.setText("Número Local");

        jLabel9.setText("Télefono");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acreedor", "Proveedor" }));
        Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo de distribuidor");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addComponent(txtNumeroLocal)
                    .addComponent(txtTelefono))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumeroLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        BuscarD.setText("Buscar Distribuidor");
        BuscarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarDMouseClicked(evt);
            }
        });

        NuevoD.setText("Nuevo Distribuidor");
        NuevoD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NuevoDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuscarD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NuevoD)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarD)
                    .addComponent(NuevoD))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 8, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoActionPerformed

    private void RegresarDistribuidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarDistribuidoresActionPerformed
         VentanaPrincipal principal=new VentanaPrincipal();
      principal.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_RegresarDistribuidoresActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
                                                     
        String NombreD,Rfc,Calle,Colonia,CP,Nlocal,Tel,Tipe;
        NombreD = this.txtNombre.getText();
        Rfc= this.txtRFC.getText();
        Calle = this.txtCalle.getText();
        Colonia= this.txtColonia.getText();
        CP=this.txtCP.getText();
        Nlocal=txtNumeroLocal.getText();
        Tel=txtTelefono.getText();
        Tipe=String.valueOf(Tipo.getSelectedItem());
        Boolean res = false;
        if( NombreD.trim().length() == 0 || 
            Rfc.trim().length() == 0 || 
            Calle.trim().length() == 0 || 
            Colonia.trim().length() == 0 ||
            CP.trim().length() == 0 || 
            Nlocal.trim().length() == 0 ||
            Tel.trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Los siguientes campos son requeridos:\nNombre del distribuidor\nRFC\nCalle\nColonia\nCódigo Postal\nNúmero local\nNúmero telefonico", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        ResultSet rs = (crud.insertarDistribuidores(NombreD,Rfc,Calle,Colonia,CP,Nlocal,Tel,Tipe));
        try {
            if(rs.next()){
                res = true;
                this.idActual = (int)(rs.getLong(1));
            }
            this.LlenarTabla();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void NuevoDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoDMouseClicked
      this.createNew();
    }//GEN-LAST:event_NuevoDMouseClicked

    private void BuscarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarDMouseClicked
         String busqueda = this.Buscar.getText();
        if(!"".equals(busqueda.trim()) && busqueda.length() > 0){
            this.LlenarTabla(busqueda);
            
        }else{
            JOptionPane.showMessageDialog(this, "No hay ningún criterio de búsqueda.\nSe mostrarán todos los registros.", "Empleados", JOptionPane.INFORMATION_MESSAGE);
            this.LlenarTabla();
        }
        this.Buscar.setText("");
        if(this.model.getRowCount() > 0){
            this.TD.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_BuscarDMouseClicked

    private void ActualizarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarDMouseClicked
     
        String NombreD,Rfc,Calle,Colonia,CP,Nlocal,Tel,Tipe;
        NombreD = this.txtNombre.getText();
        Rfc= this.txtRFC.getText();
        Calle = this.txtCalle.getText();
        Colonia= this.txtColonia.getText();
        CP=this.txtCP.getText();
        Nlocal=txtNumeroLocal.getText();
        Tel=txtTelefono.getText();
        Tipe=String.valueOf(Tipo.getSelectedItem());
       
        if( NombreD.trim().length() == 0 || 
            Rfc.trim().length() == 0 || 
            Calle.trim().length() == 0 || 
            Colonia.trim().length() == 0 ||
            CP.trim().length() == 0 || 
            Nlocal.trim().length() == 0 ||
            Tel.trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Los siguientes campos son requeridos:\nNombre del distribuidor\nRFC\nCalle\nColonia\nCódigo Postal\nNúmero local\nNúmero telefonico", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       Boolean res = false;
        
        res = (crud.actualizarDistribuidores(this.idActual,NombreD,Rfc,Calle,Colonia,CP,Nlocal,Tel,Tipe));
        
        if(res){
            JOptionPane.showMessageDialog(this, "Cambios guardados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.LlenarTabla(this.idActual);
            this.TD.setRowSelectionInterval(0, 0);
        }else{
            JOptionPane.showMessageDialog(this, "No se pudieron guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ActualizarDMouseClicked

    private void EliminarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarDMouseClicked
           int id = Integer.parseInt(String.valueOf(TD.getValueAt(TD.getSelectedRow(),0)));
        int confirmacion = JOptionPane.showConfirmDialog(this,"¿Está seguro en borrar el producto?", "Error",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0){
        if(crud.eliminarDistribuidores(id)){
        this.LlenarTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Error al realizar la consulta","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_EliminarDMouseClicked

    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped
        if(txtRFC.getText().length()>12){
            evt.consume();
        }
    }//GEN-LAST:event_txtRFCKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if(txtRFC.getText().length()>9 || !Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(Distribuidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Distribuidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Distribuidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Distribuidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Distribuidores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarD;
    private javax.swing.JTextField Buscar;
    private javax.swing.JButton BuscarD;
    private javax.swing.JButton EliminarD;
    private javax.swing.JButton NuevoD;
    private javax.swing.JButton RegresarDistribuidores;
    private javax.swing.JTable TD;
    private javax.swing.JComboBox<String> Tipo;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroLocal;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
