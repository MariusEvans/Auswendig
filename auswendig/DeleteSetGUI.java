/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class DeleteSetGUI extends javax.swing.JFrame 
{
    //OBJECTS
    DeleteSet deleteSet = new DeleteSet();
    
    public DeleteSetGUI() 
    {
        System.out.println("Running DeleteSetGUI.");
        initComponents();
        deleteSet.readFileNames();
        List<String> listOfFileNames1 = deleteSet.listOfFileNames;
        for(int i = 0; i<listOfFileNames1.size(); i++)
        {
            cbxDeleteSet.addItem(""+listOfFileNames1.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        STYLEPANEL = new javax.swing.JPanel();
        cbxDeleteSet = new javax.swing.JComboBox<>();
        btnDeleteSet = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        menuFolders = new javax.swing.JMenu();
        miOpenFolder = new javax.swing.JMenuItem();
        miCreateFolder = new javax.swing.JMenuItem();
        miEditFolder = new javax.swing.JMenuItem();
        miDeleteSet = new javax.swing.JMenuItem();
        menuSets = new javax.swing.JMenu();
        miOpenSet = new javax.swing.JMenuItem();
        miCreateSet = new javax.swing.JMenuItem();
        miEditSet = new javax.swing.JMenuItem();
        menuOther = new javax.swing.JMenu();
        miSearchbyTag = new javax.swing.JMenuItem();
        miSettings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auswendig");
        setBackground(new java.awt.Color(153, 153, 255));

        STYLEPANEL.setBackground(new java.awt.Color(255, 255, 255));

        btnDeleteSet.setText("Delete");
        btnDeleteSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout STYLEPANELLayout = new javax.swing.GroupLayout(STYLEPANEL);
        STYLEPANEL.setLayout(STYLEPANELLayout);
        STYLEPANELLayout.setHorizontalGroup(
            STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STYLEPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxDeleteSet, 0, 500, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteSet, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        STYLEPANELLayout.setVerticalGroup(
            STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STYLEPANELLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxDeleteSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteSet))
                .addContainerGap(241, Short.MAX_VALUE))
        );

        MenuBar.setBackground(new java.awt.Color(255, 255, 255));

        menuFolders.setText("Folders");
        menuFolders.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        miOpenFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/export-icon.png"))); // NOI18N
        miOpenFolder.setText("Export Folder");
        miOpenFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenFolderActionPerformed(evt);
            }
        });
        menuFolders.add(miOpenFolder);

        miCreateFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/plus-icon.png"))); // NOI18N
        miCreateFolder.setText("Create Folder");
        miCreateFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCreateFolderActionPerformed(evt);
            }
        });
        menuFolders.add(miCreateFolder);

        miEditFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/edit-icon.png"))); // NOI18N
        miEditFolder.setText("Edit Folder");
        miEditFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditFolderActionPerformed(evt);
            }
        });
        menuFolders.add(miEditFolder);

        miDeleteSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/delete-icon.png"))); // NOI18N
        miDeleteSet.setText("Delete Folder");
        miDeleteSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteSetActionPerformed(evt);
            }
        });
        menuFolders.add(miDeleteSet);

        MenuBar.add(menuFolders);

        menuSets.setText("Sets");
        menuSets.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        miOpenSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/folder-open-icon.png"))); // NOI18N
        miOpenSet.setText("Open Set");
        miOpenSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenSetActionPerformed(evt);
            }
        });
        menuSets.add(miOpenSet);

        miCreateSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/plus-icon.png"))); // NOI18N
        miCreateSet.setText("Create Set");
        miCreateSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCreateSetActionPerformed(evt);
            }
        });
        menuSets.add(miCreateSet);

        miEditSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/edit-icon.png"))); // NOI18N
        miEditSet.setText("Edit Set");
        miEditSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditSetActionPerformed(evt);
            }
        });
        menuSets.add(miEditSet);

        MenuBar.add(menuSets);

        menuOther.setText("Other");
        menuOther.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        miSearchbyTag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/search-icon.png"))); // NOI18N
        miSearchbyTag.setText("Search by Tag");
        miSearchbyTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSearchbyTagActionPerformed(evt);
            }
        });
        menuOther.add(miSearchbyTag);

        miSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/settings-icon.png"))); // NOI18N
        miSettings.setText("Settings");
        miSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSettingsActionPerformed(evt);
            }
        });
        menuOther.add(miSettings);

        MenuBar.add(menuOther);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STYLEPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STYLEPANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCreateSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCreateSetActionPerformed
        System.out.println("miCreateSet pressed.");
        this.setVisible(false);
        HomeGUI.createSetGUI.setVisible(true);
    }//GEN-LAST:event_miCreateSetActionPerformed

    private void miCreateFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCreateFolderActionPerformed
        System.out.println("miCreateFolder pressed.");
        this.setVisible(false);
        HomeGUI.createFolderGUI.setVisible(true);
    }//GEN-LAST:event_miCreateFolderActionPerformed

    private void miOpenSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenSetActionPerformed
        System.out.println("miOpenSet pressed.");
        this.setVisible(false);
        HomeGUI.openSetGUI.setVisible(true);
    }//GEN-LAST:event_miOpenSetActionPerformed

    private void miOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenFolderActionPerformed
        System.out.println("miOpenFolder pressed.");
        this.setVisible(false);
        HomeGUI.openFolderGUI.setVisible(true);
    }//GEN-LAST:event_miOpenFolderActionPerformed

    private void miDeleteSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteSetActionPerformed
        System.out.println("miDeleteFolder pressed.");
        this.setVisible(false);
        HomeGUI.deleteFolderGUI.setVisible(true);
    }//GEN-LAST:event_miDeleteSetActionPerformed

    private void miEditSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditSetActionPerformed
        System.out.println("miEditSet pressed.");
        this.setVisible(false);
        HomeGUI.editSetGUI.setVisible(true);
    }//GEN-LAST:event_miEditSetActionPerformed

    private void btnDeleteSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSetActionPerformed
        System.out.println("btnDeleteSet pressed.");
        String selectedItem = cbxDeleteSet.getSelectedItem().toString();
        System.out.println("selected item: "+selectedItem);
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete"+selectedItem+"?", "Delete",  JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
        {
           deleteSet.delete(selectedItem);
        }
        if(reply == JOptionPane.NO_OPTION)
        {
        }
    }//GEN-LAST:event_btnDeleteSetActionPerformed

    private void miEditFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditFolderActionPerformed
        System.out.println("miEditFolder pressed.");
        this.setVisible(false);
        HomeGUI.editFolderGUI.setVisible(true);
    }//GEN-LAST:event_miEditFolderActionPerformed

    private void miSearchbyTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSearchbyTagActionPerformed
        System.out.println("miSearchbyTag pressed");
        this.setVisible(false);
        HomeGUI.searchTagGUI.setVisible(true);
    }//GEN-LAST:event_miSearchbyTagActionPerformed

    private void miSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSettingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miSettingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteSetGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel STYLEPANEL;
    private javax.swing.JButton btnDeleteSet;
    private javax.swing.JComboBox<String> cbxDeleteSet;
    private javax.swing.JMenu menuFolders;
    private javax.swing.JMenu menuOther;
    private javax.swing.JMenu menuSets;
    private javax.swing.JMenuItem miCreateFolder;
    private javax.swing.JMenuItem miCreateSet;
    private javax.swing.JMenuItem miDeleteSet;
    private javax.swing.JMenuItem miEditFolder;
    private javax.swing.JMenuItem miEditSet;
    private javax.swing.JMenuItem miOpenFolder;
    private javax.swing.JMenuItem miOpenSet;
    private javax.swing.JMenuItem miSearchbyTag;
    private javax.swing.JMenuItem miSettings;
    // End of variables declaration//GEN-END:variables
}
