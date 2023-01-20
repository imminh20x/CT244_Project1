package view;

import Control.Server;
import java.awt.Toolkit;
import java.io.IOException;

public class ServerFrame extends javax.swing.JFrame {
   private  Thread serverThread;
   private Server server;
    public ServerFrame() {
        initComponents();
        setIconImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bntRun = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        labelNotification = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TchaTSever");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(54, 54, 54));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        bntRun.setBackground(new java.awt.Color(255, 255, 255));
        bntRun.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        bntRun.setForeground(new java.awt.Color(51, 51, 51));
        bntRun.setText("Run Sever");
        bntRun.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bntRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRunActionPerformed(evt);
            }
        });
        jPanel1.add(bntRun);
        bntRun.setBounds(150, 30, 140, 59);

        btnStop.setBackground(new java.awt.Color(255, 255, 255));
        btnStop.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnStop.setForeground(new java.awt.Color(51, 51, 51));
        btnStop.setText("Stop");
        btnStop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jPanel1.add(btnStop);
        btnStop.setBounds(150, 230, 140, 59);

        labelNotification.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        labelNotification.setForeground(new java.awt.Color(255, 255, 255));
        labelNotification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNotification.setText("The Server is stopping");
        labelNotification.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(labelNotification);
        labelNotification.setBounds(80, 120, 260, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //title
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/tchat_title_white.png")));
    }
    
    private void bntRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRunActionPerformed
         serverThread= new Thread() {
            public void run() {
                try {
                    server = new Server();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        serverThread.start();
        bntRun.setEnabled(false);
        labelNotification.setText("Sever run successful");
    }//GEN-LAST:event_bntRunActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnStopActionPerformed

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
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntRun;
    private javax.swing.JButton btnStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNotification;
    // End of variables declaration//GEN-END:variables
}
