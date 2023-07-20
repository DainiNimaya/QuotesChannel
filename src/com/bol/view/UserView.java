/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bol.view;

import com.bol.services.Observer;
import com.bol.services.impl.Channel;

/**
 *
 * @author USER
 */
public class UserView extends javax.swing.JFrame implements Observer {

    private Channel channellist = new Channel();
    private String nameChannel = null;
    
    public UserView(String s) {
        initComponents();
        nameChannel = s;
        userChannel.setText(s);
        userUnSubsBtn.setVisible(true);
        userSubsBtn.setVisible(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtArea = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        userUnSubsBtn = new javax.swing.JButton();
        userChannel = new javax.swing.JLabel();
        userSubsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 350, 170));

        userUnSubsBtn.setText("Unsubscribe");
        userUnSubsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userUnSubsBtnActionPerformed(evt);
            }
        });
        getContentPane().add(userUnSubsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));
        getContentPane().add(userChannel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 20));

        userSubsBtn.setText("Subscribe");
        userSubsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSubsBtnActionPerformed(evt);
            }
        });
        getContentPane().add(userSubsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userUnSubsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userUnSubsBtnActionPerformed
        this.channellist.unSubscribeChannel(nameChannel,this);
        userUnSubsBtn.setVisible(false);
        userSubsBtn.setVisible(true);
    }//GEN-LAST:event_userUnSubsBtnActionPerformed

    private void userSubsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSubsBtnActionPerformed
        this.channellist.subscribeChannel(nameChannel,this);
        userUnSubsBtn.setVisible(true);
        userSubsBtn.setVisible(false);
    }//GEN-LAST:event_userSubsBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel txtArea;
    private javax.swing.JLabel userChannel;
    private javax.swing.JButton userSubsBtn;
    private javax.swing.JButton userUnSubsBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(String t) {
        textArea.append(t +"\n");
    }
}
