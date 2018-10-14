/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class EditSetGUI extends javax.swing.JFrame 
{
    //OBJECTS
    EditSet editSet = new EditSet();
    
    public EditSetGUI() 
    {
        System.out.println("Running EditSetGUI.");
        initComponents();
        editSet.readFileNames();
        List<String> listOfFileNames1 = editSet.listOfFileNames;
        List<String> listOfFileNamesStarred1 = editSet.listOfFileNamesStarred;
        for(int i = 0; i<listOfFileNames1.size(); i++)
        {
            cbxLoadSet.addItem(""+listOfFileNames1.get(i));
        }
        for(int z=0; z<listOfFileNamesStarred1.size(); z++)
        {
            cbxLoadSet.addItem(""+listOfFileNamesStarred1.get(z));
        }
        sliderCards.setEnabled(false);
        btnAddCard.setEnabled(false);
        btnDeleteCard.setEnabled(false);
        btnSaveSet.setEnabled(false);
        btnSaveCard.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        STYLEPANEL = new javax.swing.JPanel();
        tfSetName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
        btnSaveSet = new javax.swing.JButton();
        sliderCards = new javax.swing.JSlider();
        lblCardCount = new javax.swing.JLabel();
        lblTerm = new javax.swing.JLabel();
        lblExample = new javax.swing.JLabel();
        tfExample = new javax.swing.JTextField();
        lblTags = new javax.swing.JLabel();
        tfTags = new javax.swing.JTextField();
        lblDefinition = new javax.swing.JLabel();
        tfDefinition = new javax.swing.JTextField();
        btnAddCard = new javax.swing.JButton();
        btnDeleteCard = new javax.swing.JButton();
        btnLoadSet = new javax.swing.JButton();
        cbxLoadSet = new javax.swing.JComboBox<>();
        tfTerm = new javax.swing.JTextField();
        btnSaveCard = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        menuFolders = new javax.swing.JMenu();
        miOpenFolder = new javax.swing.JMenuItem();
        miCreateFolder = new javax.swing.JMenuItem();
        miEditFolder = new javax.swing.JMenuItem();
        miDeleteFolder = new javax.swing.JMenuItem();
        menuSets = new javax.swing.JMenu();
        miOpenSet = new javax.swing.JMenuItem();
        miCreateSet = new javax.swing.JMenuItem();
        miDeleteSet = new javax.swing.JMenuItem();
        menuOther = new javax.swing.JMenu();
        miMergeFolders = new javax.swing.JMenuItem();
        miMergeSets = new javax.swing.JMenuItem();
        miSearchbyTag = new javax.swing.JMenuItem();
        miSettings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auswendig");
        setBackground(new java.awt.Color(153, 153, 255));

        STYLEPANEL.setBackground(new java.awt.Color(255, 255, 255));
        STYLEPANEL.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                STYLEPANELComponentShown(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblName.setText("Name:");

        lblDescription.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblDescription.setText("Description:");

        btnSaveSet.setText("Save Set");
        btnSaveSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSetActionPerformed(evt);
            }
        });

        sliderCards.setBackground(new java.awt.Color(255, 255, 255));
        sliderCards.setMajorTickSpacing(10);
        sliderCards.setMaximum(200);
        sliderCards.setMinimum(1);
        sliderCards.setPaintTicks(true);
        sliderCards.setValue(1);
        sliderCards.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderCardsStateChanged(evt);
            }
        });

        lblCardCount.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblCardCount.setText("Card: 1 / 200");

        lblTerm.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTerm.setText("Term:");

        lblExample.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExample.setText("Example:");

        lblTags.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTags.setText("Tags:");

        lblDefinition.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblDefinition.setText("Definition:");

        btnAddCard.setText("Add Card");
        btnAddCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCardActionPerformed(evt);
            }
        });

        btnDeleteCard.setText("Delete Card");
        btnDeleteCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCardActionPerformed(evt);
            }
        });

        btnLoadSet.setText("Load Set");
        btnLoadSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadSetActionPerformed(evt);
            }
        });

        cbxLoadSet.setMaximumRowCount(20);

        btnSaveCard.setText("Save Card");
        btnSaveCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout STYLEPANELLayout = new javax.swing.GroupLayout(STYLEPANEL);
        STYLEPANEL.setLayout(STYLEPANELLayout);
        STYLEPANELLayout.setHorizontalGroup(
            STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STYLEPANELLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(STYLEPANELLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSaveCard, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCardCount, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(STYLEPANELLayout.createSequentialGroup()
                                .addComponent(lblDefinition)
                                .addGap(30, 30, 30)
                                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAddCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnDeleteCard, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(STYLEPANELLayout.createSequentialGroup()
                                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDescription))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfSetName)
                                    .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(sliderCards, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, STYLEPANELLayout.createSequentialGroup()
                                    .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTags)
                                        .addComponent(lblExample)
                                        .addComponent(lblTerm))
                                    .addGap(30, 30, 30)
                                    .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfTags, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfExample, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(STYLEPANELLayout.createSequentialGroup()
                        .addComponent(cbxLoadSet, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLoadSet)))
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, STYLEPANELLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveSet)
                .addGap(241, 241, 241))
        );
        STYLEPANELLayout.setVerticalGroup(
            STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STYLEPANELLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnLoadSet, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cbxLoadSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblCardCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sliderCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTerm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExample)
                    .addComponent(tfExample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTags)
                    .addComponent(tfTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefinition)
                    .addComponent(tfDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddCard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteCard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveCard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveSet)
                .addGap(41, 41, 41))
        );

        MenuBar.setBackground(new java.awt.Color(255, 255, 255));

        menuFolders.setText("Folders");
        menuFolders.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        miOpenFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/folder-open-icon.png"))); // NOI18N
        miOpenFolder.setText("Open Folder");
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

        miDeleteFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/delete-icon.png"))); // NOI18N
        miDeleteFolder.setText("Delete Folder");
        miDeleteFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteFolderActionPerformed(evt);
            }
        });
        menuFolders.add(miDeleteFolder);

        MenuBar.add(menuFolders);

        menuSets.setText("Sets");
        menuSets.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

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

        miDeleteSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/delete-icon.png"))); // NOI18N
        miDeleteSet.setText("Delete Set");
        miDeleteSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteSetActionPerformed(evt);
            }
        });
        menuSets.add(miDeleteSet);

        MenuBar.add(menuSets);

        menuOther.setText("Other");
        menuOther.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        miMergeFolders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/join-icon.png"))); // NOI18N
        miMergeFolders.setText("Merge Folders");
        miMergeFolders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMergeFoldersActionPerformed(evt);
            }
        });
        menuOther.add(miMergeFolders);

        miMergeSets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/join-icon.png"))); // NOI18N
        miMergeSets.setText("Merge Sets");
        miMergeSets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMergeSetsActionPerformed(evt);
            }
        });
        menuOther.add(miMergeSets);

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
            .addComponent(STYLEPANEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 463, Short.MAX_VALUE)
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

    private void miCreateSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCreateSetActionPerformed
        System.out.println("miCreateSet pressed.");
        this.setVisible(false);
        HomeGUI.createSetGUI.setVisible(true);
    }//GEN-LAST:event_miCreateSetActionPerformed

    private void btnLoadSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadSetActionPerformed
        System.out.println("btnLoadSet pressed.");
        boolean starred;
        String selectedItem = cbxLoadSet.getSelectedItem().toString();
        System.out.println("selected item: "+selectedItem);
        cbxLoadSet.setEnabled(false);
        btnLoadSet.setEnabled(false);
        sliderCards.setEnabled(true);
        btnAddCard.setEnabled(true);
        btnDeleteCard.setEnabled(true);
        btnSaveSet.setEnabled(true);
        btnSaveCard.setEnabled(true);
        if(selectedItem.contains("Starred"))
        {
            starred = true;
            editSet.readLines(selectedItem, true);
            tfDescription.setEditable(false);
            tfDescription.setText("No description for starred sets");
        }
        else
        {
            starred = false;
            editSet.readLines(selectedItem, false);
            editSet.readDescription(selectedItem);
        }
        
        editSet.readCard(0, starred);
        String[] cardvalues1 = editSet.cardvalues;
        sliderCards.setValue(sliderCards.getValue()+1); //swap cards to show first card
        sliderCards.setValue(sliderCards.getValue()-1);
        
        if(selectedItem.contains(".txt"))
        {
           String selectedItemNOTXT = selectedItem.replace(".txt", "");
           tfSetName.setText(""+selectedItemNOTXT);
        }
        else
        {
            tfSetName.setText(""+selectedItem);
        }
        
        for(int i=0; i<cardvalues1.length; i++)
        {
            if(i==1)
            {
               tfTerm.setText(cardvalues1[i]);
            }
            if(i==2)
            {
               tfExample.setText(cardvalues1[i]);
            }
            if(i==3)
            {
               tfTags.setText(cardvalues1[i]);
            }
            if(i==4)
            {
               tfDefinition.setText(cardvalues1[i]);
            }
        }
        
        String description1 = editSet.descriptionGLOBAL;
        tfDescription.setText(""+description1);
    }//GEN-LAST:event_btnLoadSetActionPerformed

    private void miEditFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditFolderActionPerformed
        System.out.println("miEditFolder pressed.");
        this.setVisible(false);
        HomeGUI.editFolderGUI.setVisible(true);
    }//GEN-LAST:event_miEditFolderActionPerformed

    private void sliderCardsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderCardsStateChanged
        System.out.println("sliderCards changed.");
        int sliderValue = sliderCards.getValue();
        String selectedItem = cbxLoadSet.getSelectedItem().toString();
        System.out.println("Slider value: "+sliderValue);
        lblCardCount.setText("Card: "+sliderValue+" / 200");
        if(selectedItem.contains("Starred"))
        {
           editSet.readCard(sliderValue, true); 
        }
        else
        {
            editSet.readCard(sliderValue, false); 
        }
        
        
        try
        {
            Path path;
            int ifStarred=0;
            if(selectedItem.contains("Starred"))
            {
                path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItem);
            }
            else
            {
                path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
                ifStarred=ifStarred-2;
            }
            System.out.println("path chosen: "+path.toString());
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            if(lines.size()-ifStarred<sliderValue)
            {
               tfTerm.setText("");
               tfExample.setText("");
               tfTags.setText("");
               tfDefinition.setText(""); 
            }
        }
        catch(Exception e)
        {
            System.out.println("Could not get line count");
            System.out.println(""+e);
        }
        
        String cardvalues1[] = editSet.cardvalues;
        for(int i=0; i<cardvalues1.length; i++)
        {
           if(i==1)
           {
               tfTerm.setText(cardvalues1[i]);
           }
           else if(i==2)
           {
             tfExample.setText(cardvalues1[i]);  
           }
           else if(i==3)
           {
               tfTags.setText(cardvalues1[i]);
           }
           else if(i==4)
           {
              tfDefinition.setText(cardvalues1[i]); 
           }
        }
            
    }//GEN-LAST:event_sliderCardsStateChanged

    private void btnSaveSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSetActionPerformed
        System.out.println("btnSaveSet pressed.");
        cbxLoadSet.setEnabled(true);
        btnLoadSet.setEnabled(true);
        sliderCards.setEnabled(false);
        sliderCards.setValue(1);
        btnAddCard.setEnabled(false);
        btnDeleteCard.setEnabled(false);
        btnSaveSet.setEnabled(false);
        btnSaveCard.setEnabled(false);
        
        String setName = tfSetName.getText();
        String description = tfDescription.getText();
        String selectedItem = cbxLoadSet.getSelectedItem().toString();
        editSet.saveSet(selectedItem, setName, description);
        
        tfSetName.setText("");
        tfDescription.setText("");
        tfTerm.setText("");
        tfExample.setText("");
        tfTags.setText("");
        tfDefinition.setText("");
    }//GEN-LAST:event_btnSaveSetActionPerformed

    private void btnDeleteCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCardActionPerformed
        System.out.println("btnDeleteCard pressed");
        tfSetName.setEditable(false);
        tfDescription.setEditable(false);
        String selectedItem = cbxLoadSet.getSelectedItem().toString();
        int sliderValue = sliderCards.getValue();
        
        String setName = tfSetName.getText();
        String description = tfDescription.getText();
        
        String term = tfTerm.getText();
        String example = tfExample.getText();
        String tags = tfTags.getText();
        String definition = tfDefinition.getText();
                
        System.out.println("//--- Delete Card");
        System.out.println("Term: "+term);
        System.out.println("Example: "+example);
        System.out.println("Tags: "+tags);
        System.out.println("Definition: "+definition);
        
        editSet.deleteCard(selectedItem, sliderValue);
    }//GEN-LAST:event_btnDeleteCardActionPerformed

    private void btnAddCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCardActionPerformed
        System.out.println("btnAddCard pressed.");
        boolean validated=false;
        tfSetName.setEditable(false);
        tfDescription.setEditable(false);
        
        int sliderValue = sliderCards.getValue();
        String selectedItem = cbxLoadSet.getSelectedItem().toString();
        
        String term = tfTerm.getText();
        if(term.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Term field cannot be longer than 32 characters, try again");
        }
        String example = tfExample.getText();
        if(example.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Example field cannot be longer than 32 characters, try again");
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
                
        System.out.println("//--- New Card");
        System.out.println("Term: "+term);
        System.out.println("Example: "+example);
        System.out.println("Tags: "+tags);
        System.out.println("Definition: "+definition);
        
        System.out.println("validated ="+validated);
        if(validated==false)
        {
            boolean starred2;
            if(selectedItem.contains("Starred"))
            {
                starred2=true;
            }
            else
            {
                starred2=false;
            }
            editSet.AddCard(sliderValue, selectedItem, term, example, tags, definition, starred2);
            editSet.readLines(selectedItem, starred2);
            JOptionPane.showMessageDialog(null,"Card successfully added");
            sliderCards.setValue(sliderCards.getValue()+1);
        }
    }//GEN-LAST:event_btnAddCardActionPerformed

    private void btnSaveCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCardActionPerformed
        System.out.println("btnSaveCard pressed.");
        boolean validated=false;
        tfSetName.setEditable(false);
        tfDescription.setEditable(false);
        
        int sliderValue = sliderCards.getValue();
        String selectedItem = cbxLoadSet.getSelectedItem().toString();
        
        String term = tfTerm.getText();
        if(term.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Term field cannot be longer than 32 characters, try again");
        }
        String example = tfExample.getText();
        if(example.length()>32)
        {
            validated=true;
            JOptionPane.showMessageDialog(null,"Example field cannot be longer than 32 characters, try again");
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
                
        System.out.println("//--- Edited Card");
        System.out.println("Term: "+term);
        System.out.println("Example: "+example);
        System.out.println("Tags: "+tags);
        System.out.println("Definition: "+definition);
        
        if(validated==false)
        {
            editSet.SaveCard(selectedItem, sliderValue, term, example, tags, definition);
            JOptionPane.showMessageDialog(null,"Card successfully saved");
        }
    }//GEN-LAST:event_btnSaveCardActionPerformed

    private void STYLEPANELComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_STYLEPANELComponentShown
        JOptionPane.showMessageDialog(null,"Please note that editing a set will not automatically change cards in the corresponding starred or leitner set");
    }//GEN-LAST:event_STYLEPANELComponentShown

    private void miMergeFoldersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMergeFoldersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miMergeFoldersActionPerformed

    private void miMergeSetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMergeSetsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miMergeSetsActionPerformed

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
            java.util.logging.Logger.getLogger(EditSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSetGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSetGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel STYLEPANEL;
    private javax.swing.JButton btnAddCard;
    private javax.swing.JButton btnDeleteCard;
    private javax.swing.JButton btnLoadSet;
    private javax.swing.JButton btnSaveCard;
    private javax.swing.JButton btnSaveSet;
    private javax.swing.JComboBox<String> cbxLoadSet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCardCount;
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
    private javax.swing.JMenuItem miCreateSet;
    private javax.swing.JMenuItem miDeleteFolder;
    private javax.swing.JMenuItem miDeleteSet;
    private javax.swing.JMenuItem miEditFolder;
    private javax.swing.JMenuItem miMergeFolders;
    private javax.swing.JMenuItem miMergeSets;
    private javax.swing.JMenuItem miOpenFolder;
    private javax.swing.JMenuItem miOpenSet;
    private javax.swing.JMenuItem miSearchbyTag;
    private javax.swing.JMenuItem miSettings;
    private javax.swing.JSlider sliderCards;
    private javax.swing.JTextField tfDefinition;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfExample;
    private javax.swing.JTextField tfSetName;
    private javax.swing.JTextField tfTags;
    private javax.swing.JTextField tfTerm;
    // End of variables declaration//GEN-END:variables
}
