/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.graphics;

/**
 *
 * @author corentin
 */
public class HealtBar extends javax.swing.JPanel {

    /**
     * Creates new form HealtBar
     */
    public HealtBar() {
        initComponents();
    }

    public void repaintCoeurs(int nbCoeur){
        switch (nbCoeur){
            case 5:
                heartPanel5.repaintCoeur(true);
                heartPanel4.repaintCoeur(true);
                heartPanel3.repaintCoeur(true);
                heartPanel2.repaintCoeur(true);
                heartPanel1.repaintCoeur(true);
                break;
            case 4:
                heartPanel5.repaintCoeur(false);
                heartPanel4.repaintCoeur(true);
                heartPanel3.repaintCoeur(true);
                heartPanel2.repaintCoeur(true);
                heartPanel1.repaintCoeur(true);
                break;
            case 3:
                heartPanel5.repaintCoeur(false);
                heartPanel4.repaintCoeur(false);
                heartPanel3.repaintCoeur(true);
                heartPanel2.repaintCoeur(true);
                heartPanel1.repaintCoeur(true);
                break;
            case 2:
                heartPanel5.repaintCoeur(false);
                heartPanel4.repaintCoeur(false);
                heartPanel3.repaintCoeur(false);
                heartPanel2.repaintCoeur(true);
                heartPanel1.repaintCoeur(true);
                break;
            case 1:
                heartPanel5.repaintCoeur(false);
                heartPanel4.repaintCoeur(false);
                heartPanel3.repaintCoeur(false);
                heartPanel2.repaintCoeur(false);
                heartPanel1.repaintCoeur(true);
                break;
            default:
                heartPanel5.repaintCoeur(false);
                heartPanel4.repaintCoeur(false);
                heartPanel3.repaintCoeur(false);
                heartPanel2.repaintCoeur(false);
                heartPanel1.repaintCoeur(false);
                break;   
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

        heartPanel1 = new boundary.graphics.HeartPanel();
        heartPanel2 = new boundary.graphics.HeartPanel();
        heartPanel3 = new boundary.graphics.HeartPanel();
        heartPanel4 = new boundary.graphics.HeartPanel();
        heartPanel5 = new boundary.graphics.HeartPanel();

        setLayout(new java.awt.GridLayout(5, 1));

        javax.swing.GroupLayout heartPanel1Layout = new javax.swing.GroupLayout(heartPanel1);
        heartPanel1.setLayout(heartPanel1Layout);
        heartPanel1Layout.setHorizontalGroup(
            heartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );
        heartPanel1Layout.setVerticalGroup(
            heartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        add(heartPanel1);

        javax.swing.GroupLayout heartPanel2Layout = new javax.swing.GroupLayout(heartPanel2);
        heartPanel2.setLayout(heartPanel2Layout);
        heartPanel2Layout.setHorizontalGroup(
            heartPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );
        heartPanel2Layout.setVerticalGroup(
            heartPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        add(heartPanel2);

        javax.swing.GroupLayout heartPanel3Layout = new javax.swing.GroupLayout(heartPanel3);
        heartPanel3.setLayout(heartPanel3Layout);
        heartPanel3Layout.setHorizontalGroup(
            heartPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );
        heartPanel3Layout.setVerticalGroup(
            heartPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        add(heartPanel3);

        javax.swing.GroupLayout heartPanel4Layout = new javax.swing.GroupLayout(heartPanel4);
        heartPanel4.setLayout(heartPanel4Layout);
        heartPanel4Layout.setHorizontalGroup(
            heartPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );
        heartPanel4Layout.setVerticalGroup(
            heartPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        add(heartPanel4);

        javax.swing.GroupLayout heartPanel5Layout = new javax.swing.GroupLayout(heartPanel5);
        heartPanel5.setLayout(heartPanel5Layout);
        heartPanel5Layout.setHorizontalGroup(
            heartPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );
        heartPanel5Layout.setVerticalGroup(
            heartPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        add(heartPanel5);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private boundary.graphics.HeartPanel heartPanel1;
    private boundary.graphics.HeartPanel heartPanel2;
    private boundary.graphics.HeartPanel heartPanel3;
    private boundary.graphics.HeartPanel heartPanel4;
    private boundary.graphics.HeartPanel heartPanel5;
    // End of variables declaration//GEN-END:variables

}
