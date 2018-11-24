/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class CreateSetGUI extends javax.swing.JFrame 
{
    //OBJECTS
    CreateSet createSet = new CreateSet();
    
    int min4Card=0;
    
    public CreateSetGUI() 
    {
        System.out.println("Running CreateSetGUI.");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAddCard = new javax.swing.JButton();
        tfDefinition = new javax.swing.JTextField();
        lblDefinition = new javax.swing.JLabel();
        tfTags = new javax.swing.JTextField();
        lblTags = new javax.swing.JLabel();
        tfExample = new javax.swing.JTextField();
        lblExample = new javax.swing.JLabel();
        tfTerm = new javax.swing.JTextField();
        lblTerm = new javax.swing.JLabel();
        btnCreateSet = new javax.swing.JButton();
        tfDescription = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        tfSetName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        menuFolders = new javax.swing.JMenu();
        miOpenFolder = new javax.swing.JMenuItem();
        miCreateFolder = new javax.swing.JMenuItem();
        miEditFolder = new javax.swing.JMenuItem();
        miDeleteFolder = new javax.swing.JMenuItem();
        menuSets = new javax.swing.JMenu();
        miOpenSet = new javax.swing.JMenuItem();
        miEditSet = new javax.swing.JMenuItem();
        miDeleteSet = new javax.swing.JMenuItem();
        menuOther = new javax.swing.JMenu();
        miSearchbyTag = new javax.swing.JMenuItem();
        miSettings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auswendig");
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnAddCard.setBackground(new java.awt.Color(255, 255, 255));
        btnAddCard.setText("Add Card");
        btnAddCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCardActionPerformed(evt);
            }
        });

        lblDefinition.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblDefinition.setText("Definition:");

        tfTags.setText("Separate tags with \"/\"");

        lblTags.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTags.setText("Tags:");

        lblExample.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExample.setText("Example:");

        lblTerm.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTerm.setText("Term:");

        btnCreateSet.setBackground(new java.awt.Color(255, 255, 255));
        btnCreateSet.setText("Create Set");
        btnCreateSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateSetActionPerformed(evt);
            }
        });

        lblDescription.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblDescription.setText("Description:");

        lblName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblName.setText("Name:");

        tfSetName.setText("Spaces must be separted with \"_\"");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setText("Create Set.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTerm)
                                    .addComponent(lblTags)
                                    .addComponent(lblExample)
                                    .addComponent(lblDefinition))
                                .addGap(106, 106, 106)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfExample)
                                    .addComponent(tfTerm)
                                    .addComponent(tfTags, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                    .addComponent(tfDefinition)
                                    .addComponent(btnAddCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDescription))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfSetName, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                    .addComponent(tfDescription))))
                        .addContainerGap(143, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(234, 234, 234))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreateSet)
                .addGap(239, 239, 239))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfSetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDescription)))
                        .addGap(31, 31, 31)
                        .addComponent(tfTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfExample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(lblTags)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblDefinition))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblTerm)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblExample))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddCard)
                .addGap(26, 26, 26)
                .addComponent(btnCreateSet)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        MenuBar.setBackground(new java.awt.Color(255, 255, 255));

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

        MenuBar.add(menuFolders);

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

        MenuBar.add(menuSets);

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

        MenuBar.add(menuOther);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenFolderActionPerformed
        System.out.println("miOpenFolder pressed.");
        this.setVisible(false);
        HomeGUI.createFolderGUI.setVisible(true);
    }//GEN-LAST:event_miOpenFolderActionPerformed

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

    private void miDeleteFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteFolderActionPerformed
        System.out.println("miDeleteFolder pressed.");
        this.setVisible(false);
        HomeGUI.deleteFolderGUI.setVisible(true);
    }//GEN-LAST:event_miDeleteFolderActionPerformed

    private void miDeleteSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteSetActionPerformed
        System.out.println("miDeleteSet pressed.");
        this.setVisible(false);
        HomeGUI.deleteSetGUI.setVisible(true);
    }//GEN-LAST:event_miDeleteSetActionPerformed

    private void miEditSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditSetActionPerformed
        System.out.println("miEditSet pressed.");
        this.setVisible(false);
        HomeGUI.editSetGUI.setVisible(true);
    }//GEN-LAST:event_miEditSetActionPerformed

    private void btnAddCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCardActionPerformed
        System.out.println("btnAddCard pressed.");
        min4Card=min4Card+1;
        boolean validated = false;
        tfSetName.setEditable(false);
        tfDescription.setEditable(false);
        
        String setName = tfSetName.getText();
        if(setName.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Name field cannot be longer than 32 characters, try again");
        }
        if(setName.contains(","))
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Names cannot contain ',', try again");
        }
        if(setName.contains(".txt"))
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Names cannot contain '.txt', try again");
        }
        String description = tfDescription.getText();
        if(description.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Description field cannot be longer than 32 characters, try again");
        }
        if(description.contains(","))
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Descriptions cannot contain ',', try again");
        }
        
        String term = tfTerm.getText();
        if(term.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Term field cannot be longer than 32 characters, try again");
        }
        if(term.contains(","))
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Terms cannot be contain ',', try again");
        }
        String example = tfExample.getText();
        if(example.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Example field cannot be longer than 32 characters, try again");
        }
        if(example.contains(","))
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Examples cannot be contain ',', try again");
        }
        String tags = tfTags.getText();
        if(tags.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Tags field cannot be longer than 32 characters, try again");
        }
        if(tags.contains(","))
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Tags cannot be contain or be separated by ',', try again");
        }
        String definition = tfDefinition.getText();
        if(definition.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Definition field cannot be longer than 32 characters, try again");
        }
        if(definition.contains(","))
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Definitions cannot be contain ',', try again");
        }
        System.out.println("//--- New Card");
        System.out.println("Term: "+term);
        System.out.println("Example: "+example);
        System.out.println("Tags: "+tags);
        System.out.println("Definition: "+definition);
        
        if(validated==false)
        {
            createSet.AddCard(setName, description, term, example, tags, definition);

            //CLEAR CARD
            tfTerm.setText("");
            tfExample.setText("");
            tfDefinition.setText("");
        }
    }//GEN-LAST:event_btnAddCardActionPerformed

    private void btnCreateSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateSetActionPerformed
        //this button press, titles and gives a description to the set when all cards have been added
        System.out.println("btnCreateSet pressed.");
        if(min4Card==4 || min4Card>4) //only allow a set to be made if it has a minimum of 4 cards (for Multi-Choice activity)
        {
            String setName = tfSetName.getText();
            String description = tfDescription.getText();

            System.out.println("//--- New Set");
            System.out.println("Set Name: "+setName);
            System.out.println("Description: "+description);

            createSet.makeSet();
            createSet.createStarredSet();
            createSet.createLeitnerSet();
            tfSetName.setEditable(false);
            JOptionPane.showMessageDialog(null, "Set successfully created, reload Auswendig to open set");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You must add a minimum of 4 cards to a set in order to create it, try again");
        }
    }//GEN-LAST:event_btnCreateSetActionPerformed

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
            java.util.logging.Logger.getLogger(CreateSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateSetGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton btnAddCard;
    private javax.swing.JButton btnCreateSet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDefinition;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblExample;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTags;
    private javax.swing.JLabel lblTerm;
    private javax.swing.JMenu menuFolders;
    private javax.swing.JMenu menuOther;
    private javax.swing.JMenu menuSets;
    private javax.swing.JMenuItem miCreateFolder;
    private javax.swing.JMenuItem miDeleteFolder;
    private javax.swing.JMenuItem miDeleteSet;
    private javax.swing.JMenuItem miEditFolder;
    private javax.swing.JMenuItem miEditSet;
    private javax.swing.JMenuItem miOpenFolder;
    private javax.swing.JMenuItem miOpenSet;
    private javax.swing.JMenuItem miSearchbyTag;
    private javax.swing.JMenuItem miSettings;
    private javax.swing.JTextField tfDefinition;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfExample;
    private javax.swing.JTextField tfSetName;
    private javax.swing.JTextField tfTags;
    private javax.swing.JTextField tfTerm;
    // End of variables declaration//GEN-END:variables
}
