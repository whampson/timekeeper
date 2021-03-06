
package weshampson.timekeeper.admin.gui;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import weshampson.commonutils.logging.Level;
import weshampson.commonutils.logging.Logger;
import weshampson.timekeeper.activity.ActivityLogger;
import weshampson.timekeeper.settings.SettingsManager;
import weshampson.timekeeper.tech.Tech;
import weshampson.timekeeper.tech.TechManager;

/**
 *
 * @author  Wes Hampson
 * @version 0.3.0 (Nov 23, 2014)
 * @since   0.3.0 (Nov 17, 2014)
 */
public class AdminManagerDialog extends javax.swing.JDialog {
    private final DefaultListModel<Tech> adminsListModel = new DefaultListModel<>();
    private final DefaultListModel<Tech> techsListModel = new DefaultListModel<>();

    /** Creates new form AdminManagerDialog */
    public AdminManagerDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initLists();
    }
    @SuppressWarnings("unchecked")
    private void initLists() {
        final DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();
        ListCellRenderer manageAdminsListCellRenderer = new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Tech t = (Tech)value;
                JLabel label = (JLabel)defaultListCellRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setText(t.getName());
                if (isSelected) {
                    label.setBackground(list.getSelectionBackground());
                }
                return(label);
            }
        };
        adminsList.setCellRenderer(manageAdminsListCellRenderer);
        techsList.setCellRenderer(manageAdminsListCellRenderer);
        List<Tech> techList = TechManager.getTechList();
        for (Tech t : techList) {
            if (t.isAdmin()) {
                adminsListModel.addElement(t);
            } else {
                techsListModel.addElement(t);
            }
        }
        adminsList.setModel(adminsListModel);
        techsList.setModel(techsListModel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminManagerTechsLabel = new javax.swing.JLabel();
        techsScrollPane = new javax.swing.JScrollPane();
        techsList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        adminsLabel = new javax.swing.JLabel();
        adminsScrollPane = new javax.swing.JScrollPane();
        adminsList = new javax.swing.JList();
        cancelButton = new javax.swing.JButton();
        oKButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin Manager");

        adminManagerTechsLabel.setText("Techs:");

        techsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                techsListMouseClicked(evt);
            }
        });
        techsScrollPane.setViewportView(techsList);

        addButton.setText(">");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("<");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        adminsLabel.setText("Admins:");

        adminsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminsListMouseClicked(evt);
            }
        });
        adminsScrollPane.setViewportView(adminsList);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(techsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addButton)
                                    .addComponent(removeButton)))
                            .addComponent(adminManagerTechsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(adminsLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(adminsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(adminManagerTechsLabel)
                    .addComponent(adminsLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(techsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oKButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void techsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_techsListMouseClicked
        adminsList.clearSelection();
    }//GEN-LAST:event_techsListMouseClicked

    @SuppressWarnings("unchecked")
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (techsList.getSelectedIndex() == -1) {
            return;
        }
        List<Tech> techs = techsList.getSelectedValuesList();
        for (Tech t : techs) {
            techsListModel.removeElement(t);
            adminsListModel.addElement(t);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    @SuppressWarnings("unchecked")
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (adminsList.getSelectedIndex() == -1) {
            return;
        }
        List<Tech> techs = adminsList.getSelectedValuesList();
        for (Tech t : techs) {
            adminsListModel.removeElement(t);
            techsListModel.addElement(t);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void adminsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminsListMouseClicked
        techsList.clearSelection();
    }//GEN-LAST:event_adminsListMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void oKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oKButtonActionPerformed
        for (int i = 0; i < adminsListModel.getSize(); i++) {
            Tech t = adminsListModel.get(i);
            if (!t.isAdmin()) {
                t.setAdmin(true);
                ActivityLogger.logActivity(ActivityLogger.Action.TECH_MARK_ADMIN, t, t.getName() + " is now an admin.");
            }
        }
        for (int i = 0; i < techsListModel.size(); i++) {
            Tech t = techsListModel.get(i);
            if (t.isAdmin()) {
                t.setAdmin(false);
                ActivityLogger.logActivity(ActivityLogger.Action.TECH_UNMARK_ADMIN, t, t.getName() + " is no longer an admin.");
            }
        }
        try {
            TechManager.saveTechs(new File(SettingsManager.get(SettingsManager.PROPERTY_TECH_DATA_FILE)));
        } catch (IOException ex) {
            Logger.log(Level.ERROR, ex, "Failed to save tech data - " + ex.toString());
            JOptionPane.showMessageDialog(this, "Failed to save tech data:\n"
                    + "\n"
                    + ex.toString(), "Error Saving Tech Data", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_oKButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel adminManagerTechsLabel;
    private javax.swing.JLabel adminsLabel;
    private javax.swing.JList adminsList;
    private javax.swing.JScrollPane adminsScrollPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton oKButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JList techsList;
    private javax.swing.JScrollPane techsScrollPane;
    // End of variables declaration//GEN-END:variables
}