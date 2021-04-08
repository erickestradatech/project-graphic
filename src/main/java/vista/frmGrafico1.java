package vista;

import modelo.*;
import controlador.Negocio;
import java.awt.BorderLayout;
import org.jfree.chart.*;

import org.jfree.data.general.DefaultPieDataset;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class frmGrafico1 extends javax.swing.JFrame {

    Negocio obj = new Negocio();

    void lineal(int an) {

        XYSeries serie = new XYSeries("venta");

        for (Resumen x : obj.lisMes(an)) {

            serie.add(x.getMes(), x.getTotal());
        }

        XYDataset ds = new XYSeriesCollection(serie);
        JFreeChart jg = ChartFactory.createXYLineChart("Año " + an, "Mes", "venta", ds, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel cp = new ChartPanel(jg);
        panel1.removeAll();
        panel1.setLayout(new java.awt.BorderLayout());
        panel1.add(cp, BorderLayout.CENTER);
        panel1.validate();
    }

    void barra(int an) {

        DefaultCategoryDataset ds = new DefaultCategoryDataset();

        for (Resumen x : obj.lisMes(an)) {

            ds.setValue(x.getTotal(), "Ventas", x.Lmes());
        }

        JFreeChart jg = ChartFactory.createBarChart3D("Año: " + an, "Mes", "Venta", ds, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel cp = new ChartPanel(jg);
        panel1.removeAll();
        panel1.setLayout(new java.awt.BorderLayout());
        panel1.add(cp, BorderLayout.CENTER);
        panel1.validate();
    }

    void circulo(int an) {

        DefaultPieDataset ds = new DefaultPieDataset();
        for (Resumen x : obj.lisMes(an)) {
            ds.setValue(x.Lmes(), x.getTotal());
        }

        JFreeChart jg = ChartFactory.createPieChart3D("Year " + an, ds, true, true, true);
        ChartPanel cp = new ChartPanel(jg);
        panel1.removeAll();
        panel1.setLayout(new java.awt.BorderLayout());
        panel1.add(cp, BorderLayout.CENTER);
        panel1.validate();
    }

    public frmGrafico1() {
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtan = new javax.swing.JTextField();
        btnCirculo = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        btnBarra = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INGRESE ANIO");

        btnCirculo.setText("CIRCULAR");
        btnCirculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoActionPerformed(evt);
            }
        });

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfico"));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        btnBarra.setText("Barras");
        btnBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarraActionPerformed(evt);
            }
        });

        jButton1.setText("Lineal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(txtan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnCirculo)
                        .addGap(32, 32, 32)
                        .addComponent(btnBarra)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCirculo)
                    .addComponent(btnBarra)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCirculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoActionPerformed
        int an = Integer.parseInt(txtan.getText());
        circulo(an);
    }//GEN-LAST:event_btnCirculoActionPerformed

    private void btnBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarraActionPerformed
        int an = Integer.parseInt(txtan.getText());
        barra(an);
    }//GEN-LAST:event_btnBarraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int an = Integer.parseInt(txtan.getText());
        lineal(an);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmGrafico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGrafico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGrafico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGrafico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGrafico1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarra;
    private javax.swing.JButton btnCirculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel1;
    private javax.swing.JTextField txtan;
    // End of variables declaration//GEN-END:variables
}
