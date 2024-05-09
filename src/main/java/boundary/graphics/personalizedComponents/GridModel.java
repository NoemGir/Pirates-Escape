/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.graphics.personalizedComponents;

import boundary.graphics.Dialog;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Panel Personnalisé représentant le plateau
 *
 * @author Louis TENAILLEAU
 */
public class GridModel extends javax.swing.JPanel {

    private Dialog dialog;
    private boolean resetPawnEnabled = true;
    
    /**
     * Creates new form GridModel
     */
    public GridModel() {
        initComponents();
        manualInit();
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
        dialog.addPiratePawn(piratePawn1);
        dialog.addPiratePawn(piratePawn2);
    }

    private void manualInit(){
        for(int i = 0; i < 30; i++) {
            CasePanel myCase = new CasePanel();
            myCase.setText("" + i);
            gridPanel.add(myCase);
        }

        piratePawn2.setOffset(6);
        piratePawn2.setColor(Color.blue);
    }

    public JLayeredPane getjLayeredPane1() {
        return jLayeredPane1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        piratePawn1 = new boundary.graphics.personalizedComponents.PiratePawn();
        piratePawn2 = new boundary.graphics.personalizedComponents.PiratePawn();
        gridPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(550, 400));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout piratePawn1Layout = new javax.swing.GroupLayout(piratePawn1);
        piratePawn1.setLayout(piratePawn1Layout);
        piratePawn1Layout.setHorizontalGroup(
            piratePawn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        piratePawn1Layout.setVerticalGroup(
            piratePawn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout piratePawn2Layout = new javax.swing.GroupLayout(piratePawn2);
        piratePawn2.setLayout(piratePawn2Layout);
        piratePawn2Layout.setHorizontalGroup(
            piratePawn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        piratePawn2Layout.setVerticalGroup(
            piratePawn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        gridPanel.setLayout(new java.awt.GridLayout(6, 5));

        jLayeredPane1.setLayer(piratePawn1, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(piratePawn2, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(gridPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(piratePawn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(piratePawn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(piratePawn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(piratePawn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(337, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getGridPanel() {
        return gridPanel;
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        dialog.eventMousePressedGrid(evt.getPoint());
    }//GEN-LAST:event_formMousePressed

    public void setResetPawnEnabled(boolean resetPawnEnabled) {
        this.resetPawnEnabled = resetPawnEnabled;
    }
            
    @Override
    public void paintComponent(Graphics g){
        System.out.println("Paint component grille -> reset");
        super.paintComponent(g);
        if(resetPawnEnabled){
            piratePawn1.resetLocation();
            piratePawn2.resetLocation();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gridPanel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private boundary.graphics.personalizedComponents.PiratePawn piratePawn1;
    private boundary.graphics.personalizedComponents.PiratePawn piratePawn2;
    // End of variables declaration//GEN-END:variables
}
