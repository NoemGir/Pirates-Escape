/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.gui;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author louistenailleau
 */
public class GridModel extends javax.swing.JPanel {
    
    private Map<Integer,Case> model;

    /**
     * Creates new form GridModel
     */
    public GridModel() {
        initComponents();
        model = new HashMap();
        for(int i = 0; i < 30; i++) {
            Case myCase = new Case();
            this.model.put(i, myCase);

        }
    }

    public Map<Integer, Case> getModel() {
        return model;
    }
    
    public Case getCase(int position) {
        return model.get(position);
    }
    
    public void setCase(int position, Case myCase) {
        model.put(position, myCase);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pion1 = new javax.swing.JPanel();
        pion2 = new javax.swing.JPanel();
        gridPanel = new javax.swing.JPanel();

        setLayout(new javax.swing.OverlayLayout(this));

        javax.swing.GroupLayout pion1Layout = new javax.swing.GroupLayout(pion1);
        pion1.setLayout(pion1Layout);
        pion1Layout.setHorizontalGroup(
            pion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        pion1Layout.setVerticalGroup(
            pion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(pion1);

        javax.swing.GroupLayout pion2Layout = new javax.swing.GroupLayout(pion2);
        pion2.setLayout(pion2Layout);
        pion2Layout.setHorizontalGroup(
            pion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        pion2Layout.setVerticalGroup(
            pion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(pion2);

        gridPanel.setLayout(new java.awt.GridLayout(5, 6));
        add(gridPanel);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gridPanel;
    private javax.swing.JPanel pion1;
    private javax.swing.JPanel pion2;
    // End of variables declaration//GEN-END:variables
}