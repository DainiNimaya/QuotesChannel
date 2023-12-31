/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bol.view;

import com.bol.services.impl.QuoteChannel;
import com.bol.controller.ChannelController;


public class HomeView extends javax.swing.JFrame {

    private QuoteChannel quoteChannel;
    private final ChannelController channelController = new ChannelController();
    
    public HomeView() {
        initComponents();
        subscribeBtn.setVisible(false);
        channelLabl.setVisible(false);
    }
    
    public HomeView(QuoteChannel channel) {
        this();
        this.quoteChannel = channel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        channelLabl = new javax.swing.JLabel();
        startChannelBtn = new javax.swing.JButton();
        startChannelTxt = new javax.swing.JTextField();
        subscribeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        channelLbl = new javax.swing.JLabel();
        userLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        channelLabl.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        channelLabl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(channelLabl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 170, 30));

        startChannelBtn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        startChannelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bol/assets/start_24px.png"))); // NOI18N
        startChannelBtn.setText("Start Channel");
        startChannelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startChannelBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        startChannelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startChannelBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startChannelBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startChannelBtnMouseExited(evt);
            }
        });
        startChannelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startChannelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(startChannelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 160, 30));

        startChannelTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startChannelTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        startChannelTxt.setToolTipText("Enter Channel Name");
        jPanel1.add(startChannelTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 180, 30));

        subscribeBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        subscribeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bol/assets/facebook_like_30px.png"))); // NOI18N
        subscribeBtn.setText("Subscribe");
        subscribeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subscribeBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subscribeBtn.setMaximumSize(new java.awt.Dimension(108, 27));
        subscribeBtn.setMinimumSize(new java.awt.Dimension(108, 27));
        subscribeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subscribeBtnActionPerformed(evt);
            }
        });
        jPanel1.add(subscribeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("No Channels Avaliable Yet...!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 180, 20));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Channel Name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        channelLbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        channelLbl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Channel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(1, 0, 0))); // NOI18N
        jPanel1.add(channelLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 210));

        userLbl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Subscribers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanel1.add(userLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 230, 210));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 470, 20));

        mainLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/bol/assets/bd.jpg"))); // NOI18N
        jPanel1.add(mainLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void subscribeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subscribeBtnActionPerformed
        UserView user = new UserView(quoteChannel);
        this.channelController.subscribeChannel(quoteChannel,user);
        user.setVisible(true);
    }//GEN-LAST:event_subscribeBtnActionPerformed

    private void startChannelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startChannelBtnMouseClicked
        quoteChannel.startChannel(startChannelTxt.getText());
        jLabel1.setVisible(false);
        channelLabl.setText(startChannelTxt.getText());
        startChannelBtn.setEnabled(false);
        subscribeBtn.setVisible(true);
        channelLabl.setVisible(true);
        new NewChannelView().setVisible(true);
    }//GEN-LAST:event_startChannelBtnMouseClicked

    private void startChannelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startChannelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startChannelBtnActionPerformed

    private void startChannelBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startChannelBtnMouseEntered
       // greenStartLbl.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_startChannelBtnMouseEntered

    private void startChannelBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startChannelBtnMouseExited
       // greenStartLbl.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_startChannelBtnMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel channelLabl;
    private javax.swing.JLabel channelLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mainLbl;
    private javax.swing.JButton startChannelBtn;
    private javax.swing.JTextField startChannelTxt;
    private javax.swing.JButton subscribeBtn;
    private javax.swing.JLabel userLbl;
    // End of variables declaration//GEN-END:variables
}
