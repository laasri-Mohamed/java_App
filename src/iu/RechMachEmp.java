/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;
import beans.Employe;
import beans.Machine;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import service.EmployeService;
import service.MachineService;

/**
 *
 * @author admin
 */
public class RechMachEmp extends javax.swing.JInternalFrame {
 EmployeService es;
    MachineService ms;
    DefaultTableModel model;
    List<Machine> list = new ArrayList<>();
   
    
    
    /**
     * Creates new form Rechmachemp
     */
    public RechMachEmp() {
        initComponents();
        es = new EmployeService();
        ms = new MachineService();
        model = (DefaultTableModel) listeMachines.getModel();
        load();
    
    }
void load() {
        model.setRowCount(0);
        for (Machine m : list) {
            model.addRow(new Object[]{
                m.getEmploye().getId(),
                m.getEmploye().getNom(),
                m.getReference(),
                m.getMarque()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        returnMachine = new javax.swing.JButton();
        idEmpTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeMachines = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche des machines"));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche des machines"));

        jLabel1.setText("Idemp");

        returnMachine.setText("affciher  les employes");
        returnMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnMachineActionPerformed(evt);
            }
        });

        idEmpTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idEmpTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(idEmpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
                .addComponent(returnMachine)
                .addGap(275, 275, 275))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnMachine)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(idEmpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        listeMachines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nom", "reference", "marque"
            }
        ));
        jScrollPane1.setViewportView(listeMachines);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idEmpTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idEmpTxtActionPerformed
         
    }//GEN-LAST:event_idEmpTxtActionPerformed

    private void returnMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnMachineActionPerformed
    int e = Integer.parseInt(idEmpTxt.getText());
        list = ms.returnMachines(es.findById(e));
        load();
    }//GEN-LAST:event_returnMachineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idEmpTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeMachines;
    private javax.swing.JButton returnMachine;
    // End of variables declaration//GEN-END:variables
}
