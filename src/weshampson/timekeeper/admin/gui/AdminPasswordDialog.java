
package weshampson.timekeeper.admin.gui;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import weshampson.commonutils.logging.Level;
import weshampson.commonutils.logging.Logger;

/**
 *
 * @author  Wes Hampson
 * @version 0.3.0 (Nov 23, 2014)
 * @since   0.3.0 (Nov 17, 2014)
 */
public class AdminPasswordDialog extends javax.swing.JDialog {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private final String adminPasswordHash;
    private MessageDigest messageDigest;
    private boolean accessGranted;

    public AdminPasswordDialog(java.awt.Frame parent, boolean modal, String adminPasswordHash) {
        super(parent, modal);
        initComponents();
        this.adminPasswordHash = adminPasswordHash;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            // Shouldn't happen
            Logger.log(Level.ERROR, ex, "Unable to find password hash algorithm - " + ex.toString());
        }
        adminPasswordField.requestFocus();
    }
    public AdminPasswordDialog(java.awt.Dialog parent, boolean modal, String adminPasswordHash) {
        super(parent, modal);
        initComponents();
        this.adminPasswordHash = adminPasswordHash;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            // Shouldn't happen
            Logger.log(Level.ERROR, ex, "Unable to find password hash algorithm - " + ex.toString());
        }
    }
    private String bytesToHexString(byte[] b) {
        char[] hexChars = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[v >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return(new String(hexChars));
    }
    public boolean isAccessGranted() {
        return(accessGranted);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminPasswordLabel = new javax.swing.JLabel();
        adminPasswordField = new javax.swing.JPasswordField();
        cancelButton = new javax.swing.JButton();
        oKButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin Password Required");

        adminPasswordLabel.setText("Admin password:");

        adminPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminPasswordFieldActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        oKButton.setText("OK");
        oKButton.setMaximumSize(new java.awt.Dimension(65, 23));
        oKButton.setMinimumSize(new java.awt.Dimension(65, 23));
        oKButton.setPreferredSize(new java.awt.Dimension(65, 23));
        oKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adminPasswordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminPasswordField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 133, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oKButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminPasswordLabel)
                    .addComponent(adminPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oKButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminPasswordFieldActionPerformed
        oKButton.doClick();
    }//GEN-LAST:event_adminPasswordFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void oKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oKButtonActionPerformed
        if (adminPasswordField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Please enter the admin password.", "Admin Password Required", JOptionPane.ERROR_MESSAGE);
            adminPasswordField.requestFocus();
            return;
        }
        String typedPasswordHash = bytesToHexString(messageDigest.digest(new String(adminPasswordField.getPassword()).getBytes()));
        if (!adminPasswordHash.equalsIgnoreCase(typedPasswordHash)) {
            JOptionPane.showMessageDialog(this, "Invalid password!", "Invalid Password", JOptionPane.ERROR_MESSAGE);
            adminPasswordField.selectAll();
            adminPasswordField.requestFocus();
            return;
        }
        accessGranted = true;
        dispose();
    }//GEN-LAST:event_oKButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField adminPasswordField;
    private javax.swing.JLabel adminPasswordLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton oKButton;
    // End of variables declaration//GEN-END:variables
}