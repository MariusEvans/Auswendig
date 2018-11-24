/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class HomeGUI extends javax.swing.JFrame 
{
    //OBJECTS
    public static CreateSetGUI createSetGUI = new CreateSetGUI();
    public static CreateFolderGUI createFolderGUI = new CreateFolderGUI();
    public static ExportFolderGUI openFolderGUI = new ExportFolderGUI();
    public static OpenSetGUI openSetGUI = new OpenSetGUI();
    public static DeleteFolderGUI deleteFolderGUI = new DeleteFolderGUI();
    public static DeleteSetGUI deleteSetGUI = new DeleteSetGUI();
    public static EditSetGUI editSetGUI = new EditSetGUI();
    public static EditFolderGUI editFolderGUI = new EditFolderGUI();
    public static SearchTagGUI searchTagGUI = new SearchTagGUI();
    Home home = new Home();
    
    public HomeGUI() 
    {
        System.out.println("Running HomeGUI.");
        String destAddress = Paths.get(".").toAbsolutePath().normalize().toString(); //get current directory
        //String destAddress1 = destAddress.replace
        System.out.println(destAddress);
        //JOptionPane.showMessageDialog(null,destAddress);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RECENTPANEL = new javax.swing.JPanel();
        TITLEPANEL = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuFolders = new javax.swing.JMenu();
        miOpenFolder = new javax.swing.JMenuItem();
        miCreateFolder = new javax.swing.JMenuItem();
        miEditFolder = new javax.swing.JMenuItem();
        miDeleteFolder = new javax.swing.JMenuItem();
        menuSets = new javax.swing.JMenu();
        miOpenSet = new javax.swing.JMenuItem();
        miCreateSet = new javax.swing.JMenuItem();
        miEditSet = new javax.swing.JMenuItem();
        miDeleteSet = new javax.swing.JMenuItem();
        menuOther = new javax.swing.JMenu();
        miSearchbyTag = new javax.swing.JMenuItem();
        miSettings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auswendig");
        setBackground(new java.awt.Color(255, 255, 255));

        RECENTPANEL.setBackground(new java.awt.Color(255, 255, 255));

        TITLEPANEL.setBackground(new java.awt.Color(102, 153, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Auswendig.");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Auswendig has been written and created by Marius Evans.");

        javax.swing.GroupLayout TITLEPANELLayout = new javax.swing.GroupLayout(TITLEPANEL);
        TITLEPANEL.setLayout(TITLEPANELLayout);
        TITLEPANELLayout.setHorizontalGroup(
            TITLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLEPANELLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(TITLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TITLEPANELLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TITLEPANELLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41))))
        );
        TITLEPANELLayout.setVerticalGroup(
            TITLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLEPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout RECENTPANELLayout = new javax.swing.GroupLayout(RECENTPANEL);
        RECENTPANEL.setLayout(RECENTPANELLayout);
        RECENTPANELLayout.setHorizontalGroup(
            RECENTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TITLEPANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RECENTPANELLayout.setVerticalGroup(
            RECENTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TITLEPANEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu.setBackground(java.awt.Color.white);
        menu.setBorder(null);
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N

        menuFolders.setBorder(null);
        menuFolders.setForeground(new java.awt.Color(204, 204, 204));
        menuFolders.setText("Folders");
        menuFolders.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        miOpenFolder.setBackground(new java.awt.Color(255, 255, 255));
        miOpenFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/export-icon.png"))); // NOI18N
        miOpenFolder.setText("Export Folder");
        miOpenFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenFolderActionPerformed(evt);
            }
        });
        menuFolders.add(miOpenFolder);

        miCreateFolder.setBackground(new java.awt.Color(255, 255, 255));
        miCreateFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/plus-icon.png"))); // NOI18N
        miCreateFolder.setText("Create Folder");
        miCreateFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCreateFolderActionPerformed(evt);
            }
        });
        menuFolders.add(miCreateFolder);

        miEditFolder.setBackground(new java.awt.Color(255, 255, 255));
        miEditFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/edit-icon.png"))); // NOI18N
        miEditFolder.setText("Edit Folder");
        miEditFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditFolderActionPerformed(evt);
            }
        });
        menuFolders.add(miEditFolder);

        miDeleteFolder.setBackground(new java.awt.Color(255, 255, 255));
        miDeleteFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/delete-icon.png"))); // NOI18N
        miDeleteFolder.setText("Delete Folder");
        miDeleteFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteFolderActionPerformed(evt);
            }
        });
        menuFolders.add(miDeleteFolder);

        menu.add(menuFolders);

        menuSets.setBorder(null);
        menuSets.setForeground(new java.awt.Color(204, 204, 204));
        menuSets.setText("Sets");
        menuSets.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        miOpenSet.setBackground(new java.awt.Color(255, 255, 255));
        miOpenSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/folder-open-icon.png"))); // NOI18N
        miOpenSet.setText("Open Set");
        miOpenSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOpenSetActionPerformed(evt);
            }
        });
        menuSets.add(miOpenSet);

        miCreateSet.setBackground(new java.awt.Color(255, 255, 255));
        miCreateSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/plus-icon.png"))); // NOI18N
        miCreateSet.setText("Create Set");
        miCreateSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCreateSetActionPerformed(evt);
            }
        });
        menuSets.add(miCreateSet);

        miEditSet.setBackground(new java.awt.Color(255, 255, 255));
        miEditSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/edit-icon.png"))); // NOI18N
        miEditSet.setText("Edit Set");
        miEditSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditSetActionPerformed(evt);
            }
        });
        menuSets.add(miEditSet);

        miDeleteSet.setBackground(new java.awt.Color(255, 255, 255));
        miDeleteSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/delete-icon.png"))); // NOI18N
        miDeleteSet.setText("Delete Set");
        miDeleteSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteSetActionPerformed(evt);
            }
        });
        menuSets.add(miDeleteSet);

        menu.add(menuSets);

        menuOther.setBorder(null);
        menuOther.setForeground(new java.awt.Color(204, 204, 204));
        menuOther.setText("Other");
        menuOther.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        miSearchbyTag.setBackground(new java.awt.Color(255, 255, 255));
        miSearchbyTag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/search-icon.png"))); // NOI18N
        miSearchbyTag.setText("Search by Tag");
        miSearchbyTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSearchbyTagActionPerformed(evt);
            }
        });
        menuOther.add(miSearchbyTag);

        miSettings.setBackground(new java.awt.Color(255, 255, 255));
        miSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/settings-icon.png"))); // NOI18N
        miSettings.setText("Settings");
        miSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSettingsActionPerformed(evt);
            }
        });
        menuOther.add(miSettings);

        menu.add(menuOther);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RECENTPANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RECENTPANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenFolderActionPerformed
        System.out.println("miOpenFolder pressed.");
        this.setVisible(false);
        openFolderGUI.setVisible(true);
    }//GEN-LAST:event_miOpenFolderActionPerformed

    private void miCreateSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCreateSetActionPerformed
        System.out.println("miCreateSet pressed.");
        this.setVisible(false);
        createSetGUI.setVisible(true);
    }//GEN-LAST:event_miCreateSetActionPerformed

    private void miCreateFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCreateFolderActionPerformed
        System.out.println("miCreateFolder pressed.");
        this.setVisible(false);
        createFolderGUI.setVisible(true);
    }//GEN-LAST:event_miCreateFolderActionPerformed

    private void miOpenSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenSetActionPerformed
        System.out.println("miOpenSet pressed.");
        this.setVisible(false);
        openSetGUI.setVisible(true);
    }//GEN-LAST:event_miOpenSetActionPerformed

    private void miDeleteFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteFolderActionPerformed
        System.out.println("miDeleteFolder pressed.");
        this.setVisible(false);
        deleteFolderGUI.setVisible(true);
    }//GEN-LAST:event_miDeleteFolderActionPerformed

    private void miDeleteSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteSetActionPerformed
        System.out.println("miDeleteSet pressed.");
        this.setVisible(false);
        deleteSetGUI.setVisible(true);
    }//GEN-LAST:event_miDeleteSetActionPerformed

    private void miEditSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditSetActionPerformed
        System.out.println("miEditSet pressed.");
        this.setVisible(false);
        editSetGUI.setVisible(true);
    }//GEN-LAST:event_miEditSetActionPerformed

    private void miEditFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditFolderActionPerformed
        System.out.println("miEditFolder pressed.");
        this.setVisible(false);
        editFolderGUI.setVisible(true);
    }//GEN-LAST:event_miEditFolderActionPerformed

    private void miSearchbyTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSearchbyTagActionPerformed
        System.out.println("miSearchbyTag pressed");
        this.setVisible(false);
        searchTagGUI.setVisible(true);
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
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RECENTPANEL;
    private javax.swing.JPanel TITLEPANEL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuFolders;
    private javax.swing.JMenu menuOther;
    private javax.swing.JMenu menuSets;
    private javax.swing.JMenuItem miCreateFolder;
    private javax.swing.JMenuItem miCreateSet;
    private javax.swing.JMenuItem miDeleteFolder;
    private javax.swing.JMenuItem miDeleteSet;
    private javax.swing.JMenuItem miEditFolder;
    private javax.swing.JMenuItem miEditSet;
    private javax.swing.JMenuItem miOpenFolder;
    private javax.swing.JMenuItem miOpenSet;
    private javax.swing.JMenuItem miSearchbyTag;
    private javax.swing.JMenuItem miSettings;
    // End of variables declaration//GEN-END:variables
}
