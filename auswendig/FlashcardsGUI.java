/* Copyright (C) Septemeber 2018, Marius Evans, All Rights Reserved
 * This file is part of project Auswendig
 * Reproduction, sale and commerical distribution of this material is strictly forbidden unless prior written permission is obtained from Marius Evans
 * Written by Marius Evans (mariusevans@outlook.com)
 */

package auswendig;

import Planning.SoundRecorder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FlashcardsGUI extends javax.swing.JFrame 
{   
    Flashcards flashcards;
    String selectedItemSet1 = OpenSetGUI.selectedItemSet;
    String selectedItem = selectedItemSet1;
    Random random = new Random();
    
    boolean showDefLEARN = false;
    boolean showDefLEITNER = false;
    boolean showDefSTARRED = false;
    boolean swapTandD = false;
    
    boolean isTrue = false;
    boolean isFalse = false;
    boolean isA, isB, isC, isD, isNone = false;
    
    boolean shuffleCards = false;
    boolean shuffleCardsSTARRED = false;
    boolean ifOpened = false;
    
    int triesLeft=3;
    int randomDef=1;
    int randomNum1;
    int maxCards;
    int maxCardsSTARRED;
    public int cardNumLeitner;
    int cardNumWrite;
    int cardNumTF;
    int cardNumListen;
    int cardNumMC;
    int randomCardNum;
    int randomCardNumSTARRED;
    
    public FlashcardsGUI() 
    {
        System.out.println("Running FlashcardsGUI.");
        initComponents();
        flashcards = new Flashcards(selectedItem);
        System.out.println("FLASHCARDSGUI SELECTED ITEM: "+selectedItem);
        this.selectedItem = selectedItem;
        lblTitle.setText(selectedItem.replace(".txt", ""));
        flashcards.readDescription(selectedItem);
        String description1 = flashcards.descriptionGLOBAL;
        tfDescription.setText(""+description1);
        
        //SET MAXIMUM SIZE OF SLIDERCARDS TO SIZE OF DECK OF CARDS
        try
        {
            Path path = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\Sets\\"+selectedItem);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            
            String selectedItemNOTXT = selectedItem.replace(".txt", "");
            Path pathStarred = Paths.get("C:\\Users\\Marius Evans\\Documents\\NetBeansProjects\\Auswendig\\src\\StarredSets\\"+selectedItemNOTXT+"Starred.txt");
            List<String> linesStarred = Files.readAllLines(pathStarred, StandardCharsets.UTF_8);
            sliderCards.setMaximum(lines.size()-2);
            sliderCardsSTARRED.setMaximum(linesStarred.size());
            maxCards = lines.size()-2;
            maxCardsSTARRED = linesStarred.size();
        }
        catch(Exception e)
        {
            System.out.println("Could not get line count");
            System.out.println(""+e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        STYLEPANEL = new javax.swing.JPanel();
        TABBEDPANE = new javax.swing.JTabbedPane();
        LEARNPANEL = new javax.swing.JPanel();
        tfTags = new javax.swing.JTextField();
        lblTags = new javax.swing.JLabel();
        tfExample = new javax.swing.JTextField();
        lblExample = new javax.swing.JLabel();
        tfTerm = new javax.swing.JTextField();
        lblTerm = new javax.swing.JLabel();
        sliderCards = new javax.swing.JSlider();
        lblCardCount = new javax.swing.JLabel();
        lblDefinition = new javax.swing.JLabel();
        tfDefinition = new javax.swing.JTextField();
        btnShowDef = new javax.swing.JToggleButton();
        btnStarCard = new javax.swing.JToggleButton();
        btnShuffleCards = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        STARREDPANEL = new javax.swing.JPanel();
        sliderCardsSTARRED = new javax.swing.JSlider();
        lblCardCountSTARRED = new javax.swing.JLabel();
        tfTermSTARRED = new javax.swing.JTextField();
        tfExampleSTARRED = new javax.swing.JTextField();
        tfTagsSTARRED = new javax.swing.JTextField();
        btnShowDefSTARRED = new javax.swing.JToggleButton();
        tfDefinitionSTARRED = new javax.swing.JTextField();
        lblDefinitionSTARRED = new javax.swing.JLabel();
        lblTagsSTARRED = new javax.swing.JLabel();
        lblExampleSTARRED = new javax.swing.JLabel();
        lblTermSTARRED = new javax.swing.JLabel();
        btnShuffleCardsSTARRED = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        LEITNERPANEL = new javax.swing.JPanel();
        lblTermLEITNER = new javax.swing.JLabel();
        lblExampleLEITNER = new javax.swing.JLabel();
        lblTagsLEITNER = new javax.swing.JLabel();
        tfTagsLEITNER = new javax.swing.JTextField();
        tfExampleLEITNER = new javax.swing.JTextField();
        lblDefinitionLEITNER = new javax.swing.JLabel();
        btnShowDefLEITNER = new javax.swing.JToggleButton();
        tfTermLEITNER = new javax.swing.JTextField();
        tfDefinitionLEITNER = new javax.swing.JTextField();
        btnExcellent = new javax.swing.JButton();
        btnGood = new javax.swing.JButton();
        btnOkay = new javax.swing.JButton();
        btnPoor = new javax.swing.JButton();
        btnHorrible = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblDefinitionLISTEN = new javax.swing.JLabel();
        tfDefinitionMC = new javax.swing.JTextField();
        btnSkipCardMC = new javax.swing.JButton();
        cbA = new javax.swing.JCheckBox();
        cbB = new javax.swing.JCheckBox();
        cbC = new javax.swing.JCheckBox();
        btnCheckCardMC = new javax.swing.JButton();
        cbD = new javax.swing.JCheckBox();
        cbNone = new javax.swing.JCheckBox();
        lblTermMC = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfDefinitionWRITE = new javax.swing.JTextField();
        lblDefinitionWRITE = new javax.swing.JLabel();
        lblTermWRITE = new javax.swing.JLabel();
        tfTermWRITE = new javax.swing.JTextField();
        lblExampleWRITE = new javax.swing.JLabel();
        tfExampleWRITE = new javax.swing.JTextField();
        lblTagsWRITE = new javax.swing.JLabel();
        tfTagsWRITE = new javax.swing.JTextField();
        btnSkipCardWRITE = new javax.swing.JButton();
        btnSwap = new javax.swing.JToggleButton();
        btnCheckCard = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        cbTrue = new javax.swing.JCheckBox();
        cbFalse = new javax.swing.JCheckBox();
        lblTermTF = new javax.swing.JLabel();
        tfTermTF = new javax.swing.JTextField();
        lblExampleTF = new javax.swing.JLabel();
        tfExampleTF = new javax.swing.JTextField();
        lblTagsTF = new javax.swing.JLabel();
        tfTagsTF = new javax.swing.JTextField();
        lblDefinitionTF = new javax.swing.JLabel();
        tfDefinitionTF = new javax.swing.JTextField();
        lblMeans = new javax.swing.JLabel();
        btnCheckCardTF = new javax.swing.JButton();
        btnSkipCardTF = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        TITLEPANEL = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
        MenuBar = new javax.swing.JMenuBar();
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
        setBackground(new java.awt.Color(153, 153, 255));

        STYLEPANEL.setBackground(new java.awt.Color(255, 255, 255));

        TABBEDPANE.setBackground(new java.awt.Color(255, 255, 255));
        TABBEDPANE.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        LEARNPANEL.setBackground(new java.awt.Color(255, 255, 255));

        tfTags.setEditable(false);
        tfTags.setBackground(new java.awt.Color(255, 255, 255));
        tfTags.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTags.setBorder(null);

        lblTags.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTags.setForeground(new java.awt.Color(204, 204, 204));
        lblTags.setText("Tags:");

        tfExample.setEditable(false);
        tfExample.setBackground(new java.awt.Color(255, 255, 255));
        tfExample.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfExample.setBorder(null);

        lblExample.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExample.setForeground(new java.awt.Color(204, 204, 204));
        lblExample.setText("Example:");

        tfTerm.setEditable(false);
        tfTerm.setBackground(new java.awt.Color(255, 255, 255));
        tfTerm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTerm.setBorder(null);

        lblTerm.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTerm.setForeground(new java.awt.Color(204, 204, 204));
        lblTerm.setText("Term:");

        sliderCards.setBackground(new java.awt.Color(255, 255, 255));
        sliderCards.setMaximum(200);
        sliderCards.setPaintTicks(true);
        sliderCards.setValue(0);
        sliderCards.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderCardsStateChanged(evt);
            }
        });

        lblCardCount.setBackground(new java.awt.Color(255, 255, 255));
        lblCardCount.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblCardCount.setForeground(new java.awt.Color(204, 204, 204));
        lblCardCount.setText("Card: START");

        lblDefinition.setForeground(new java.awt.Color(204, 204, 204));
        lblDefinition.setText("Definition:");

        tfDefinition.setEditable(false);
        tfDefinition.setBackground(new java.awt.Color(255, 255, 255));
        tfDefinition.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfDefinition.setBorder(null);
        tfDefinition.setFocusable(false);

        btnShowDef.setText("Show Definition");
        btnShowDef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDefActionPerformed(evt);
            }
        });

        btnStarCard.setText("Star Card");
        btnStarCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStarCardActionPerformed(evt);
            }
        });

        btnShuffleCards.setText("Shuffle Cards");
        btnShuffleCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShuffleCardsActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout LEARNPANELLayout = new javax.swing.GroupLayout(LEARNPANEL);
        LEARNPANEL.setLayout(LEARNPANELLayout);
        LEARNPANELLayout.setHorizontalGroup(
            LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEARNPANELLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LEARNPANELLayout.createSequentialGroup()
                        .addComponent(btnStarCard, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShuffleCards)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowDef))
                    .addGroup(LEARNPANELLayout.createSequentialGroup()
                        .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExample)
                            .addComponent(lblTags)
                            .addComponent(lblDefinition)
                            .addComponent(lblTerm)
                            .addComponent(lblCardCount, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LEARNPANELLayout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfTags, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                                        .addComponent(tfExample, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfTerm, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addComponent(sliderCards, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LEARNPANELLayout.setVerticalGroup(
            LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEARNPANELLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCardCount))
                .addGap(15, 15, 15)
                .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LEARNPANELLayout.createSequentialGroup()
                        .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTerm)
                            .addComponent(tfTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblExample)
                            .addComponent(tfExample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTags)
                            .addComponent(tfTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDefinition)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShuffleCards)
                    .addComponent(btnStarCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShowDef))
                .addContainerGap())
        );

        TABBEDPANE.addTab("Learn", LEARNPANEL);

        STARREDPANEL.setBackground(new java.awt.Color(255, 255, 255));

        sliderCardsSTARRED.setBackground(new java.awt.Color(255, 255, 255));
        sliderCardsSTARRED.setMaximum(200);
        sliderCardsSTARRED.setPaintTicks(true);
        sliderCardsSTARRED.setValue(0);
        sliderCardsSTARRED.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderCardsSTARREDStateChanged(evt);
            }
        });

        lblCardCountSTARRED.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblCardCountSTARRED.setForeground(new java.awt.Color(204, 204, 204));
        lblCardCountSTARRED.setText("Card: START");

        tfTermSTARRED.setEditable(false);
        tfTermSTARRED.setBackground(new java.awt.Color(255, 255, 255));
        tfTermSTARRED.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTermSTARRED.setBorder(null);

        tfExampleSTARRED.setEditable(false);
        tfExampleSTARRED.setBackground(new java.awt.Color(255, 255, 255));
        tfExampleSTARRED.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfExampleSTARRED.setBorder(null);

        tfTagsSTARRED.setEditable(false);
        tfTagsSTARRED.setBackground(new java.awt.Color(255, 255, 255));
        tfTagsSTARRED.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTagsSTARRED.setBorder(null);

        btnShowDefSTARRED.setText("Show Definition");
        btnShowDefSTARRED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDefSTARREDActionPerformed(evt);
            }
        });

        tfDefinitionSTARRED.setEditable(false);
        tfDefinitionSTARRED.setBackground(new java.awt.Color(255, 255, 255));
        tfDefinitionSTARRED.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfDefinitionSTARRED.setBorder(null);

        lblDefinitionSTARRED.setForeground(new java.awt.Color(204, 204, 204));
        lblDefinitionSTARRED.setText("Definition:");

        lblTagsSTARRED.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTagsSTARRED.setForeground(new java.awt.Color(204, 204, 204));
        lblTagsSTARRED.setText("Tags:");

        lblExampleSTARRED.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExampleSTARRED.setForeground(new java.awt.Color(204, 204, 204));
        lblExampleSTARRED.setText("Example:");

        lblTermSTARRED.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTermSTARRED.setForeground(new java.awt.Color(204, 204, 204));
        lblTermSTARRED.setText("Term:");

        btnShuffleCardsSTARRED.setText("Shuffle Cards");
        btnShuffleCardsSTARRED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShuffleCardsSTARREDActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout STARREDPANELLayout = new javax.swing.GroupLayout(STARREDPANEL);
        STARREDPANEL.setLayout(STARREDPANELLayout);
        STARREDPANELLayout.setHorizontalGroup(
            STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STARREDPANELLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(STARREDPANELLayout.createSequentialGroup()
                        .addComponent(lblCardCountSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(sliderCardsSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(STARREDPANELLayout.createSequentialGroup()
                        .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(STARREDPANELLayout.createSequentialGroup()
                                .addComponent(btnShuffleCardsSTARRED)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnShowDefSTARRED)
                                    .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfDefinitionSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tfTagsSTARRED)
                                            .addComponent(tfExampleSTARRED, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfTermSTARRED, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(STARREDPANELLayout.createSequentialGroup()
                                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTagsSTARRED)
                                    .addComponent(lblExampleSTARRED)
                                    .addComponent(lblTermSTARRED)
                                    .addComponent(lblDefinitionSTARRED))
                                .addGap(26, 26, 26)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        STARREDPANELLayout.setVerticalGroup(
            STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STARREDPANELLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderCardsSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCardCountSTARRED))
                .addGap(18, 18, 18)
                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, STARREDPANELLayout.createSequentialGroup()
                        .addComponent(lblTermSTARRED)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblExampleSTARRED)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTagsSTARRED)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDefinitionSTARRED))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(STARREDPANELLayout.createSequentialGroup()
                        .addComponent(tfTermSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfExampleSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTagsSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDefinitionSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShuffleCardsSTARRED)
                    .addComponent(btnShowDefSTARRED))
                .addContainerGap())
        );

        TABBEDPANE.addTab("Starred", STARREDPANEL);

        LEITNERPANEL.setBackground(new java.awt.Color(255, 255, 255));
        LEITNERPANEL.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                LEITNERPANELComponentShown(evt);
            }
        });

        lblTermLEITNER.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTermLEITNER.setForeground(new java.awt.Color(204, 204, 204));
        lblTermLEITNER.setText("Term:");

        lblExampleLEITNER.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExampleLEITNER.setForeground(new java.awt.Color(204, 204, 204));
        lblExampleLEITNER.setText("Example:");

        lblTagsLEITNER.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTagsLEITNER.setForeground(new java.awt.Color(204, 204, 204));
        lblTagsLEITNER.setText("Tags:");

        tfTagsLEITNER.setEditable(false);
        tfTagsLEITNER.setBackground(new java.awt.Color(255, 255, 255));
        tfTagsLEITNER.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTagsLEITNER.setBorder(null);

        tfExampleLEITNER.setEditable(false);
        tfExampleLEITNER.setBackground(new java.awt.Color(255, 255, 255));
        tfExampleLEITNER.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfExampleLEITNER.setBorder(null);

        lblDefinitionLEITNER.setForeground(new java.awt.Color(204, 204, 204));
        lblDefinitionLEITNER.setText("Definition:");

        btnShowDefLEITNER.setText("Show Definition");
        btnShowDefLEITNER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDefLEITNERActionPerformed(evt);
            }
        });

        tfTermLEITNER.setEditable(false);
        tfTermLEITNER.setBackground(new java.awt.Color(255, 255, 255));
        tfTermLEITNER.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTermLEITNER.setBorder(null);

        tfDefinitionLEITNER.setEditable(false);
        tfDefinitionLEITNER.setBackground(new java.awt.Color(255, 255, 255));
        tfDefinitionLEITNER.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfDefinitionLEITNER.setBorder(null);

        btnExcellent.setText("5 days");
        btnExcellent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcellentActionPerformed(evt);
            }
        });

        btnGood.setText("3 days");
        btnGood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoodActionPerformed(evt);
            }
        });

        btnOkay.setText("2 days");
        btnOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkayActionPerformed(evt);
            }
        });

        btnPoor.setText("1 day");
        btnPoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPoorActionPerformed(evt);
            }
        });

        btnHorrible.setText("Again");
        btnHorrible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorribleActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout LEITNERPANELLayout = new javax.swing.GroupLayout(LEITNERPANEL);
        LEITNERPANEL.setLayout(LEITNERPANELLayout);
        LEITNERPANELLayout.setHorizontalGroup(
            LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEITNERPANELLayout.createSequentialGroup()
                .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LEITNERPANELLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTermLEITNER)
                            .addComponent(lblExampleLEITNER)
                            .addComponent(lblTagsLEITNER)
                            .addComponent(lblDefinitionLEITNER))
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfExampleLEITNER, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(tfTermLEITNER)
                            .addComponent(tfTagsLEITNER, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDefinitionLEITNER)))
                    .addGroup(LEITNERPANELLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnShowDefLEITNER)
                            .addGroup(LEITNERPANELLayout.createSequentialGroup()
                                .addComponent(btnExcellent, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGood, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOkay, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPoor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHorrible, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        LEITNERPANELLayout.setVerticalGroup(
            LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEITNERPANELLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LEITNERPANELLayout.createSequentialGroup()
                        .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTermLEITNER)
                            .addComponent(tfTermLEITNER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblExampleLEITNER)
                            .addComponent(tfExampleLEITNER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTagsLEITNER)
                            .addComponent(tfTagsLEITNER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDefinitionLEITNER)
                            .addComponent(tfDefinitionLEITNER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcellent)
                    .addComponent(btnGood)
                    .addComponent(btnOkay)
                    .addComponent(btnPoor)
                    .addComponent(btnHorrible))
                .addGap(27, 27, 27)
                .addComponent(btnShowDefLEITNER)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        TABBEDPANE.addTab("Leitner", LEITNERPANEL);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblDefinitionLISTEN.setForeground(new java.awt.Color(204, 204, 204));
        lblDefinitionLISTEN.setText("means/is:");

        tfDefinitionMC.setEditable(false);
        tfDefinitionMC.setBackground(new java.awt.Color(255, 255, 255));
        tfDefinitionMC.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfDefinitionMC.setBorder(null);

        btnSkipCardMC.setText("START");
        btnSkipCardMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkipCardMCActionPerformed(evt);
            }
        });

        cbA.setBackground(new java.awt.Color(255, 255, 255));
        cbA.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbA.setText("a");
        cbA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAItemStateChanged(evt);
            }
        });

        cbB.setBackground(new java.awt.Color(255, 255, 255));
        cbB.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbB.setText("b");
        cbB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBItemStateChanged(evt);
            }
        });

        cbC.setBackground(new java.awt.Color(255, 255, 255));
        cbC.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbC.setText("c");
        cbC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCItemStateChanged(evt);
            }
        });

        btnCheckCardMC.setText("Check Card");
        btnCheckCardMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckCardMCActionPerformed(evt);
            }
        });

        cbD.setBackground(new java.awt.Color(255, 255, 255));
        cbD.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbD.setText("d");
        cbD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDItemStateChanged(evt);
            }
        });

        cbNone.setBackground(new java.awt.Color(255, 255, 255));
        cbNone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbNone.setText("None of the above");
        cbNone.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNoneItemStateChanged(evt);
            }
        });

        lblTermMC.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTermMC.setForeground(new java.awt.Color(204, 204, 204));
        lblTermMC.setText("Term:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnCheckCardMC, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSkipCardMC, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNone)
                            .addComponent(cbC)
                            .addComponent(cbB)
                            .addComponent(cbA)
                            .addComponent(cbD)
                            .addComponent(lblDefinitionLISTEN)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTermMC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDefinitionMC, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTermMC)
                    .addComponent(tfDefinitionMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(lblDefinitionLISTEN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbNone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSkipCardMC)
                    .addComponent(btnCheckCardMC))
                .addGap(21, 21, 21))
        );

        TABBEDPANE.addTab("Multi-Choice", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tfDefinitionWRITE.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfDefinitionWRITE.setForeground(new java.awt.Color(0, 0, 0));
        tfDefinitionWRITE.setBorder(null);

        lblDefinitionWRITE.setBackground(new java.awt.Color(255, 255, 255));
        lblDefinitionWRITE.setForeground(new java.awt.Color(204, 204, 204));
        lblDefinitionWRITE.setText("Definition:");

        lblTermWRITE.setBackground(new java.awt.Color(255, 255, 255));
        lblTermWRITE.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTermWRITE.setForeground(new java.awt.Color(204, 204, 204));
        lblTermWRITE.setText("Term:");

        tfTermWRITE.setEditable(false);
        tfTermWRITE.setBackground(new java.awt.Color(255, 255, 255));
        tfTermWRITE.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTermWRITE.setForeground(new java.awt.Color(0, 0, 0));
        tfTermWRITE.setBorder(null);

        lblExampleWRITE.setBackground(new java.awt.Color(255, 255, 255));
        lblExampleWRITE.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExampleWRITE.setForeground(new java.awt.Color(204, 204, 204));
        lblExampleWRITE.setText("Example:");

        tfExampleWRITE.setEditable(false);
        tfExampleWRITE.setBackground(new java.awt.Color(255, 255, 255));
        tfExampleWRITE.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfExampleWRITE.setForeground(new java.awt.Color(0, 0, 0));
        tfExampleWRITE.setBorder(null);

        lblTagsWRITE.setBackground(new java.awt.Color(255, 255, 255));
        lblTagsWRITE.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTagsWRITE.setForeground(new java.awt.Color(204, 204, 204));
        lblTagsWRITE.setText("Tags:");

        tfTagsWRITE.setEditable(false);
        tfTagsWRITE.setBackground(new java.awt.Color(255, 255, 255));
        tfTagsWRITE.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTagsWRITE.setForeground(new java.awt.Color(0, 0, 0));
        tfTagsWRITE.setBorder(null);

        btnSkipCardWRITE.setText("START");
        btnSkipCardWRITE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkipCardWRITEActionPerformed(evt);
            }
        });

        btnSwap.setText("Swap Term and Definition");
        btnSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapActionPerformed(evt);
            }
        });

        btnCheckCard.setText("Check Card");
        btnCheckCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckCardActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSwap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckCard, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSkipCardWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTermWRITE)
                            .addComponent(lblDefinitionWRITE)
                            .addComponent(lblTagsWRITE)
                            .addComponent(lblExampleWRITE))
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfDefinitionWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfTagsWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfTermWRITE)
                                .addComponent(tfExampleWRITE)))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTermWRITE)
                            .addComponent(tfTermWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblExampleWRITE)
                            .addComponent(tfExampleWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTagsWRITE)
                            .addComponent(tfTagsWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDefinitionWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDefinitionWRITE)))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSwap)
                    .addComponent(btnCheckCard)
                    .addComponent(btnSkipCardWRITE))
                .addContainerGap())
        );

        TABBEDPANE.addTab("Write", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cbTrue.setBackground(new java.awt.Color(255, 255, 255));
        cbTrue.setText("True");
        cbTrue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTrueItemStateChanged(evt);
            }
        });

        cbFalse.setBackground(new java.awt.Color(255, 255, 255));
        cbFalse.setText("False");
        cbFalse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFalseItemStateChanged(evt);
            }
        });

        lblTermTF.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTermTF.setForeground(new java.awt.Color(204, 204, 204));
        lblTermTF.setText("Term:");

        tfTermTF.setEditable(false);
        tfTermTF.setBackground(new java.awt.Color(255, 255, 255));
        tfTermTF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTermTF.setBorder(null);

        lblExampleTF.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExampleTF.setForeground(new java.awt.Color(204, 204, 204));
        lblExampleTF.setText("Example:");

        tfExampleTF.setEditable(false);
        tfExampleTF.setBackground(new java.awt.Color(255, 255, 255));
        tfExampleTF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfExampleTF.setBorder(null);

        lblTagsTF.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTagsTF.setForeground(new java.awt.Color(204, 204, 204));
        lblTagsTF.setText("Tags:");

        tfTagsTF.setEditable(false);
        tfTagsTF.setBackground(new java.awt.Color(255, 255, 255));
        tfTagsTF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfTagsTF.setBorder(null);

        lblDefinitionTF.setForeground(new java.awt.Color(204, 204, 204));
        lblDefinitionTF.setText("Definition:");

        tfDefinitionTF.setEditable(false);
        tfDefinitionTF.setBackground(new java.awt.Color(255, 255, 255));
        tfDefinitionTF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfDefinitionTF.setBorder(null);

        lblMeans.setForeground(new java.awt.Color(204, 204, 204));
        lblMeans.setText("means");

        btnCheckCardTF.setText("Check Card");
        btnCheckCardTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckCardTFActionPerformed(evt);
            }
        });

        btnSkipCardTF.setText("START");
        btnSkipCardTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkipCardTFActionPerformed(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCheckCardTF, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSkipCardTF, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDefinitionTF)
                            .addComponent(lblTermTF)
                            .addComponent(lblExampleTF)
                            .addComponent(lblTagsTF))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFalse)
                            .addComponent(cbTrue)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfTermTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfExampleTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfTagsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfDefinitionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(147, 147, 147)
                                        .addComponent(lblMeans)))))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTermTF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblExampleTF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTagsTF)
                        .addGap(30, 30, 30)
                        .addComponent(lblDefinitionTF))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfTermTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfExampleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTagsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMeans)
                        .addGap(5, 5, 5)
                        .addComponent(tfDefinitionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(cbTrue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFalse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckCardTF)
                    .addComponent(btnSkipCardTF))
                .addContainerGap())
        );

        TABBEDPANE.addTab("True/False", jPanel3);

        TITLEPANEL.setBackground(new java.awt.Color(51, 51, 255));
        TITLEPANEL.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("SET_NAME");

        tfDescription.setEditable(false);
        tfDescription.setBackground(new java.awt.Color(0, 51, 255));
        tfDescription.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        tfDescription.setForeground(new java.awt.Color(255, 255, 255));
        tfDescription.setText("Default");
        tfDescription.setBorder(null);

        javax.swing.GroupLayout TITLEPANELLayout = new javax.swing.GroupLayout(TITLEPANEL);
        TITLEPANEL.setLayout(TITLEPANELLayout);
        TITLEPANELLayout.setHorizontalGroup(
            TITLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLEPANELLayout.createSequentialGroup()
                .addGroup(TITLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TITLEPANELLayout.setVerticalGroup(
            TITLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLEPANELLayout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout STYLEPANELLayout = new javax.swing.GroupLayout(STYLEPANEL);
        STYLEPANEL.setLayout(STYLEPANELLayout);
        STYLEPANELLayout.setHorizontalGroup(
            STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TABBEDPANE)
            .addComponent(TITLEPANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        STYLEPANELLayout.setVerticalGroup(
            STYLEPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, STYLEPANELLayout.createSequentialGroup()
                .addComponent(TITLEPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TABBEDPANE, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        miEditSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auswendig/res/edit-icon.png"))); // NOI18N
        miEditSet.setText("Edit Set");
        miEditSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditSetActionPerformed(evt);
            }
        });
        menuSets.add(miEditSet);

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
            .addComponent(STYLEPANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(STYLEPANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOpenFolderActionPerformed
        System.out.println("miOpenFolder pressed.");
        this.setVisible(false);
        HomeGUI.openFolderGUI.setVisible(true);
    }//GEN-LAST:event_miOpenFolderActionPerformed

    private void miCreateSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCreateSetActionPerformed
        System.out.println("miCreateSet pressed.");
        this.setVisible(false);
        HomeGUI.createSetGUI.setVisible(true);
    }//GEN-LAST:event_miCreateSetActionPerformed

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

    private void miCreateFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCreateFolderActionPerformed
        System.out.println("miCreateFolder pressed.");
        this.setVisible(false);
        HomeGUI.createFolderGUI.setVisible(true);
    }//GEN-LAST:event_miCreateFolderActionPerformed

    private void miEditFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditFolderActionPerformed
        System.out.println("miEditFolder pressed.");
        this.setVisible(false);
        HomeGUI.editFolderGUI.setVisible(true);
    }//GEN-LAST:event_miEditFolderActionPerformed

    private void btnShowDefLEITNERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDefLEITNERActionPerformed
        if (btnShowDefLEITNER.isSelected())
        {
            System.out.println("button selected");
            btnShowDefLEITNER.setText("       Hide       ");
            showDefLEITNER = true;
            String definition = tfDefinitionLEITNER.getText();
            if(definition.isEmpty()) //if def field is empty, load the def by switching to the next or previous card and back
            {
                /*int sliderValue = sliderCardsLEITNER.getValue();
                int max = sliderCardsLEITNER.getMaximum();
                int min = sliderCardsLEITNER.getMinimum();
                //avoid null pointer errors
                if(sliderValue==max || sliderValue>min+1)
                {
                    sliderCardsLEITNER.setValue(sliderValue-1);
                }
                else if(sliderValue==min)
                {
                    sliderCardsLEITNER.setValue(sliderValue+1);
                }
                sliderCardsLEITNER.setValue(sliderValue);*/
            }
        }
        else
        {
            System.out.println("button not selected");
            btnShowDefLEITNER.setText("       Show       ");
            tfDefinitionLEITNER.setText("");
            showDefLEITNER = false;
        }
        showCardLeitner();
    }//GEN-LAST:event_btnShowDefLEITNERActionPerformed

    private void btnShowDefSTARREDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDefSTARREDActionPerformed
        System.out.println("btnShowDefSTARRED pressed");
        if (btnShowDefSTARRED.isSelected())
        {
            System.out.println("button selected");
            btnShowDefSTARRED.setText("       Hide       ");
            showDefSTARRED = true;
            String definition = tfDefinitionSTARRED.getText();
            if(definition.isEmpty()) //if def field is empty, load the def by switching to the next or previous card and back
            {
                int sliderValue = sliderCardsSTARRED.getValue();
                int max = sliderCardsSTARRED.getMaximum();
                int min = sliderCardsSTARRED.getMinimum();
                //avoid null pointer errors
                if(sliderValue==max || sliderValue>min+1)
                {
                    sliderCardsSTARRED.setValue(sliderValue-1);
                }
                else if(sliderValue==min)
                {
                    sliderCardsSTARRED.setValue(sliderValue+1);
                }
                sliderCardsSTARRED.setValue(sliderValue);
                if(shuffleCardsSTARRED==true) //go back to original card
                {
                    sliderCardsSTARRED.setValue(randomCardNumSTARRED);
                }
            }
        }
        else
        {
            System.out.println("button not selected");
            btnShowDefSTARRED.setText("       Show       ");
            tfDefinitionSTARRED.setText("");
            showDefSTARRED = false;
        }
    }//GEN-LAST:event_btnShowDefSTARREDActionPerformed

    private void sliderCardsSTARREDStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderCardsSTARREDStateChanged
        System.out.println("sliderCardsSTARRED button pressed");
        int sliderValue = sliderCardsSTARRED.getValue();
        if(shuffleCardsSTARRED==true)
        {
            sliderValue = random.nextInt(maxCardsSTARRED);
            randomCardNumSTARRED = sliderValue;
        }
        System.out.println("Slider value: "+sliderValue);
        lblCardCountSTARRED.setText("Card: "+sliderValue);
        flashcards.readCardSTARRED(sliderValue);

        if(sliderValue==0)
        {
            sliderValue = sliderValue+1;
            sliderCardsSTARRED.setValue(1);
            sliderCardsSTARRED.setMinimum(1);
            lblCardCountSTARRED.setText("Card: "+sliderValue);
        }
        else
        {
            String cardvalues1[] = flashcards.cardvaluesStarred;
            
            for(int i=0; i<cardvalues1.length; i++)
            {
                if(i==1)
                {
                    tfTermSTARRED.setText(cardvalues1[i]);
                }
                else if(i==2)
                {
                    tfExampleSTARRED.setText(cardvalues1[i]);
                }
                else if(i==3)
                {
                    tfTagsSTARRED.setText(cardvalues1[i]);
                }
                else if(i==4)
                {
                    if(showDefSTARRED==true)
                    {
                        tfDefinitionSTARRED.setText(cardvalues1[i]);
                    }
                }
            }
        }
    }//GEN-LAST:event_sliderCardsSTARREDStateChanged

    private void btnStarCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStarCardActionPerformed
        System.out.println("btnStarCard pressed");
        boolean flag = false; //only allow a card to be starred if the definition is shown
        int sliderValue = sliderCards.getValue();
        String term = tfTerm.getText();
        String example = tfExample.getText();
        String tags = tfTags.getText();
        String definition = tfDefinition.getText();
        if(definition.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "You must show the definition before you can star a card, try again.");
            flag = true;
        }
        else
        {
            System.out.println("//--- New Starred/Unstarred Card");
            System.out.println("Term: "+term);
            System.out.println("Example: "+example);
            System.out.println("Tags: "+tags);
            System.out.println("Definition: "+definition);
            flag = false;
        }

        //IF CARD IS NOT STARRED THEN SHOW THIS -->> STAR CARD NOW, IF CARD IS STARRED THEN SHOW THIS -->> UNSTAR CARD NOW
        //THIS MEANS YOU HAVE TO READ THE CURRENT CARD IN THE STARRED SET
        if (btnStarCard.isSelected() && flag==false)
        {
            System.out.println("btnStarCard selected");
            //btnStarCard.setText(" Star Card ");
            flashcards.StarCard(sliderValue, selectedItem, term, example, tags, definition);
            JOptionPane.showMessageDialog(null, "Starred card. You may have to reload to see changes.");
        }
        else
        {
            if(flag==true)
            {

            }
            else
            {
                //btnStarCard.setText(" Unstar Card ");
                System.out.println("btnStarCard not selected");
                flashcards.UnstarCard(selectedItem,sliderValue);
                JOptionPane.showMessageDialog(null, "Unstarred card. You may have to reload to see changes.");
            }
        }
    }//GEN-LAST:event_btnStarCardActionPerformed

    private void btnShowDefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDefActionPerformed
        if (btnShowDef.isSelected())
        {
            System.out.println("button selected");
            btnShowDef.setText("       Hide       ");
            showDefLEARN = true;
            String definition = tfDefinition.getText();
            if(definition.isEmpty()) //if def field is empty, load the def by switching to the next or previous card and back
            {
                int sliderValue = sliderCards.getValue();
                int max = sliderCards.getMaximum();
                int min = sliderCards.getMinimum();
                //avoid null pointer errors
                if(sliderValue==max || sliderValue>min+1)
                {
                    sliderCards.setValue(sliderValue-1);
                }
                else if(sliderValue==min)
                {
                    sliderCards.setValue(sliderValue+1);
                }
                sliderCards.setValue(sliderValue);
                if(shuffleCards==true) //go back to original card
                {
                    sliderCards.setValue(randomCardNum);
                }
            }
        }
        else
        {
            System.out.println("button not selected");
            btnShowDef.setText("       Show       ");
            tfDefinition.setText("");
            showDefLEARN = false;
        }
    }//GEN-LAST:event_btnShowDefActionPerformed

    private void sliderCardsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderCardsStateChanged
        System.out.println("sliderCards changed.");
        int sliderValue = sliderCards.getValue();
        if(shuffleCards==true)
        {
            sliderValue = random.nextInt(maxCards);
            randomCardNum = sliderValue;
        }
        System.out.println("Slider value: "+sliderValue);
        lblCardCount.setText("Card: "+sliderValue);
        flashcards.readCard(sliderValue);
        //flashcards.checkStarred(selectedItem, sliderValue);
        
        boolean starred1 = flashcards.checkStarred(selectedItem, sliderValue);

        if(starred1==true)
        {
            btnStarCard.setText(" Unstar Card ");
            System.out.print("Starred");
        }
        else if(starred1==false)
        {
            btnStarCard.setText(" Star Card ");
            System.out.print("Not starred");
        }

        if(sliderValue==0)
        {
            sliderValue = sliderValue+1;
            sliderCards.setValue(1);
            sliderCards.setMinimum(1);
            lblCardCount.setText("Card: "+sliderValue);
        }
        else
        {
            String cardvalues1[] = flashcards.cardvalues;
            
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
                    if(showDefLEARN==true)
                    {
                        tfDefinition.setText(cardvalues1[i]);
                    }
                }
            }
        }
    }//GEN-LAST:event_sliderCardsStateChanged

    public void showCardLeitner()
    {
        String cardvalues1[] = flashcards.cardvalues;

        for(int i=0; i<cardvalues1.length; i++)
        {
            if(i==1)
            {
                tfTermLEITNER.setText(cardvalues1[i]);
            }
            else if(i==2)
            {
                tfExampleLEITNER.setText(cardvalues1[i]);
            }
            else if(i==3)
            {
                tfTagsLEITNER.setText(cardvalues1[i]);
            }
            else if(i==4)
            {
                if(showDefLEITNER==true)
                {
                    tfDefinitionLEITNER.setText(cardvalues1[i]);
                }
            }
        }
    }
    
    public void showCardWrite()
    {
        String cardvalues1[] = flashcards.cardvalues;

        for(int i=0; i<cardvalues1.length; i++)
        {
            if(i==1 && swapTandD==false)
            {
                tfTermWRITE.setText(cardvalues1[i]);
                tfDefinitionWRITE.setText("");
            }
            else if(i==2 && swapTandD==false) //only show example when person is writing out term
            {
                tfExampleWRITE.setText(cardvalues1[i]);
            }
            else if(i==3)
            {
                tfTagsWRITE.setText(cardvalues1[i]);
            }
            else if(i==4 && swapTandD==true)
            {
                tfDefinitionWRITE.setText(cardvalues1[i]);
                tfTermWRITE.setText("");
            }
        }
    }
    
    public void showCardTrueOrFalse()
    {
        String cardvalues1[] = flashcards.cardvalues;
        randomDef +=1;
        int randomNum = random.nextInt(maxCards);
        int cardNumTF1 = cardNumTF;
        for(int i=0; i<cardvalues1.length; i++)
        {
            if(randomDef%2==0) //if this is the first time reading the card, read all fields EXCEPT the def
            {
                if(i==1)
                {
                    tfTermTF.setText(cardvalues1[i]);
                }
                else if(i==2)
                {
                    tfExampleTF.setText(cardvalues1[i]);
                }
                else if(i==3)
                {
                    tfTagsTF.setText(cardvalues1[i]);
                }
                else if(i==4)
                {
                    //tfDefinitionTF.setText(cardvalues1[i]);
                    if(cardNumTF>maxCards-1)
                    {
                        cardNumTF=0;
                    }
                    else 
                    {
                       cardNumTF=randomNum;
                       randomNum1 = cardNumTF;
                    }
                    flashcards.readCard(cardNumTF);
                    showCardTrueOrFalse();
                    cardNumTF = cardNumTF1; //set card num back to original
                }
            }
            else //then read a random def
            {
                if(i==4)
                {
                    tfDefinitionTF.setText(cardvalues1[i]);
                }
            }
        }
    }
    
     public void showCardMultiChoice()
    {
        String cardvalues1[] = flashcards.cardvalues;
        int randomNum = random.nextInt(maxCards);
        int cardNumMC1 = cardNumMC;
        for(int i=0; i<cardvalues1.length; i++)
        {
            if(i==1)
            {
                tfDefinitionMC.setText(cardvalues1[i]);
            }
            if(i==4)
            {
                //tfDefinitionTF.setText(cardvalues1[i]);
                if(cardNumMC>maxCards-1)
                {
                    cardNumMC=0;
                }
                else 
                {
                   cardNumMC=randomNum;
                   randomNum1 = cardNumMC;

                   randomNum = random.nextInt(maxCards);
                   flashcards.readCard(randomNum);
                   String cardvalues1V2[] = flashcards.cardvalues;
                   cbA.setText(cardvalues1V2[i]);
                    //showCardMultiChoice();

                   randomNum = random.nextInt(maxCards);
                   flashcards.readCard(randomNum);
                   String cardvalues2[] = flashcards.cardvalues;
                   cbB.setText(cardvalues2[i]);

                   randomNum = random.nextInt(maxCards);
                   flashcards.readCard(randomNum);
                   String cardvalues3[] = flashcards.cardvalues;
                   cbC.setText(cardvalues3[i]);

                   randomNum = random.nextInt(maxCards);
                   flashcards.readCard(randomNum);
                   String cardvalues4[] = flashcards.cardvalues;
                   cbD.setText(cardvalues4[i]);
                }

                //showCardMultiChoice();

                cardNumMC = cardNumMC1; //set card num back to original
                
            }
        }
    }
    
    private void btnExcellentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcellentActionPerformed
        System.out.println("btnExcellent pressed.");
        String daysTillReview = "*5"; //5,3,2,1,0

        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview); 
        
        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
        }
        else
        {
            cardNumLeitner +=1;
        }
        flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
    }//GEN-LAST:event_btnExcellentActionPerformed

    private void btnGoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoodActionPerformed
        System.out.println("btnGood pressed.");
        String daysTillReview = "*3"; //5,3,2,1,0
        
        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview); 
        
        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
        }
        else
        {
            cardNumLeitner +=1;
        }
        flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
    }//GEN-LAST:event_btnGoodActionPerformed

    private void btnOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkayActionPerformed
        System.out.println("btnOkay pressed.");
        String daysTillReview = "*2"; //5,3,2,1,0
        
        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview); 
        
        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
        }
        else
        {
            cardNumLeitner +=1;
        }
        flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
    }//GEN-LAST:event_btnOkayActionPerformed

    private void btnPoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoorActionPerformed
        System.out.println("btnPoor pressed.");
        String daysTillReview = "*1"; //5,3,2,1,0
        
        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview); 
        
        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
        }
        else
        {
            cardNumLeitner +=1;
        }
        flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
        showCardLeitner();
    }//GEN-LAST:event_btnPoorActionPerformed

    private void btnHorribleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorribleActionPerformed
        System.out.println("btnHorrible pressed.");
        String daysTillReview = "*0"; //5,3,2,1,0
        
        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview); 
        
        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
        }
        else
        {
            cardNumLeitner +=1;
        }
        flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
    }//GEN-LAST:event_btnHorribleActionPerformed

    private void LEITNERPANELComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_LEITNERPANELComponentShown
        if(ifOpened==false)
        {
            cardNumLeitner = 1;
            //String daysTillReview = "*0"; //5,3,2,1,0
            //flashcards.createSetOrAddCardLeitner(selectedItem, maxCards, cardNumLeitner, daysTillReview);
            flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
            showCardLeitner();
            cardNumLeitner+=1;
            cardNumWrite=0;
            flashcards.readCard(cardNumWrite);
            showCardWrite();
            cardNumWrite+=1;
            cardNumTF=0;
            flashcards.readCard(cardNumTF);
            cardNumTF+=1;
            ifOpened=true;
        }
    }//GEN-LAST:event_LEITNERPANELComponentShown

    private void btnSkipCardWRITEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipCardWRITEActionPerformed
        System.out.println("btnSkipCardWRITE pressed");
        btnSkipCardWRITE.setText("    Skip Card    ");
        if(cardNumWrite>maxCards-1)
        {
            cardNumWrite=0;
        }
        else 
        {
           cardNumWrite+=1; 
        }
        flashcards.readCard(cardNumWrite);
        showCardWrite();
    }//GEN-LAST:event_btnSkipCardWRITEActionPerformed

    private void btnCheckCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckCardActionPerformed
        System.out.println("btnCheckCard pressed");
        String term = tfTermWRITE.getText();
        String definition = tfDefinitionWRITE.getText();
  
        String cardvalues1[] = flashcards.cardvalues;

        for(int i=0; i<cardvalues1.length; i++)
        {
            if(swapTandD==false && i==1)
            {
                if(cardvalues1[4].equalsIgnoreCase(definition))
                {
                    tfDefinitionWRITE.setText("Correct, press skip card");
                    try 
                    {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } 
                    catch (InterruptedException ex) 
                    {
                        Logger.getLogger(FlashcardsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cardNumWrite+=1;
                    flashcards.readCard(cardNumWrite);
                    showCardWrite(); 
                }
                else
                {
                    triesLeft=triesLeft-1;
                    if(triesLeft>0)
                    {
                      tfDefinitionWRITE.setText("False, "+triesLeft+" try/tries left.");  
                    }
                    else
                    {
                        tfDefinitionWRITE.setText(cardvalues1[4]); 
                        triesLeft=3;
                    }
                }
            }
            
            if(swapTandD==true && i==4)
            {
                if(cardvalues1[1].equalsIgnoreCase(term))
                {
                    tfTermWRITE.setText("Correct, press skip card");
                    try 
                    {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } 
                    catch (InterruptedException ex) 
                    {
                        Logger.getLogger(FlashcardsGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cardNumWrite+=1;
                    flashcards.readCard(cardNumWrite);
                    showCardWrite();
                }
                else
                {
                    triesLeft=triesLeft-1;
                    if(triesLeft>0)
                    {
                      tfTermWRITE.setText("False, "+triesLeft+" try/tries left.");  
                    }
                    else
                    {
                        tfTermWRITE.setText(cardvalues1[1]);
                        triesLeft=3;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCheckCardActionPerformed

    private void btnSwapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwapActionPerformed
        System.out.println("btnSwap pressed");
        if (btnSwap.isSelected())
        {
            swapTandD = true;
            showCardWrite();
            tfExampleWRITE.setText("Hidden to prevent cheating");
            tfTermWRITE.setEditable(true);
            tfDefinitionWRITE.setEditable(false);
        }
        else
        {
            swapTandD=false;
            showCardWrite();
            tfTermWRITE.setEditable(false);
            tfDefinitionWRITE.setEditable(true);
        }
    }//GEN-LAST:event_btnSwapActionPerformed

    private void btnCheckCardTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckCardTFActionPerformed
        String term = tfTermTF.getText();
        String definition = tfDefinitionTF.getText();
        if(isTrue==false && isFalse==false)
        {
            JOptionPane.showMessageDialog(null,"Select either true or false");
        }
        else
        {
            
            flashcards.readCard(cardNumTF);
            String cardvalues1[] = flashcards.cardvalues;
            
            for(int i=0; i<cardvalues1.length; i++)
            {
                if(i==4)
                {
                    System.out.println("");
                    System.out.println("Card Number: "+cardNumTF);
                    System.out.println("Term: "+term);
                    System.out.println("Actual Def: "+cardvalues1[4]);
                    System.out.println("Tf Def: "+definition);
                    System.out.println("");
                    
                    if(definition.equals(cardvalues1[i])==true && isTrue==true)
                    {
                        if(cardNumTF>maxCards-1)
                        {
                            cardNumTF=0;
                        }
                        else 
                        {
                           cardNumTF+=1; 
                        }
                        try 
                        {
                            TimeUnit.MILLISECONDS.sleep(50);
                        } 
                        catch (InterruptedException ex) 
                        {
                            Logger.getLogger(FlashcardsGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        flashcards.readCard(cardNumTF);
                        showCardTrueOrFalse();
                    }
                    else if(definition.equals(cardvalues1[i])==true && isTrue==false)
                    {
                        cbTrue.setEnabled(false);
                        cbFalse.setEnabled(true);
                    }
                    
                    if(definition.equals(cardvalues1[i])==false && isFalse==true)
                    {
                        if(cardNumTF>maxCards-1)
                        {
                            cardNumTF=0;
                        }
                        else 
                        {
                           cardNumTF+=1; 
                        }
                        try 
                        {
                            TimeUnit.MILLISECONDS.sleep(50);
                        } 
                        catch (InterruptedException ex) 
                        {
                            Logger.getLogger(FlashcardsGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        flashcards.readCard(cardNumTF);
                        showCardTrueOrFalse();
                    }
                    else if(definition.equals(cardvalues1[i])==true && isFalse==false)
                    {
                        cbTrue.setEnabled(true);
                        cbFalse.setEnabled(false);
                    }
                    
                }
            }
        }
    }//GEN-LAST:event_btnCheckCardTFActionPerformed

    private void btnSkipCardTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipCardTFActionPerformed
        System.out.println("btnSkipCardTF pressed");
        btnSkipCardTF.setText("    Skip Card    ");
        System.out.println("cardNumTF "+cardNumTF);
        if(cardNumTF>maxCards-1)
        {
            cardNumTF=0;
        }
        else 
        {
           cardNumTF+=1; 
        }
        System.out.println("cardNumTF "+cardNumTF);
        flashcards.readCard(cardNumTF);
        showCardTrueOrFalse();
    }//GEN-LAST:event_btnSkipCardTFActionPerformed

    private void cbTrueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTrueItemStateChanged
        System.out.println("cbTrue presssed");
        if(isTrue==true)
        {
            isTrue=false;
            cbFalse.setEnabled(true);
        }
        else if(isTrue==false)
        {
           isTrue = true; 
           cbFalse.setEnabled(false);
        }
    }//GEN-LAST:event_cbTrueItemStateChanged

    private void cbFalseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFalseItemStateChanged
        System.out.println("cbFalse presssed");
        if(isFalse==true)
        {
            isFalse=false;
            cbTrue.setEnabled(true);
        }
        else if(isFalse==false)
        {
           isFalse = true; 
           cbTrue.setEnabled(false);
        }
    }//GEN-LAST:event_cbFalseItemStateChanged

    private void btnSkipCardMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipCardMCActionPerformed
        System.out.println("btnSkipCard pressed");
        btnSkipCardMC.setText("    Skip Card    ");
        System.out.println("cardNumMC "+cardNumMC);
        if(cardNumMC>maxCards-1)
        {
            cardNumMC=0;
        }
        else 
        {
           cardNumMC+=1; 
        }
        System.out.println("cardNumMC "+cardNumMC);
        flashcards.readCard(cardNumMC);
        showCardMultiChoice();
    }//GEN-LAST:event_btnSkipCardMCActionPerformed

    private void btnShuffleCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShuffleCardsActionPerformed
        System.out.println("btnShuffleCards pressed");
        if (btnShuffleCards.isSelected())
        {
            shuffleCards=true;
        }
        else
        {
            shuffleCards=false;
        }
    }//GEN-LAST:event_btnShuffleCardsActionPerformed

    private void btnShuffleCardsSTARREDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShuffleCardsSTARREDActionPerformed
        System.out.println("btnShuffleCardsSTARRED pressed");
        if (btnShuffleCardsSTARRED.isSelected())
        {
            shuffleCardsSTARRED=true;
        }
        else
        {
            shuffleCardsSTARRED=false;
        }
    }//GEN-LAST:event_btnShuffleCardsSTARREDActionPerformed

    private void btnCheckCardMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckCardMCActionPerformed
        System.out.println("btnCheckCard pressed");
        String term = tfDefinitionMC.getText();
        String definitionA = cbA.getText();
        String definitionB = cbB.getText();
        String definitionC = cbC.getText();
        String definitionD = cbD.getText();
        
        if(isA==false && isB==false && isC==false && isD==false && isNone==false)
        {
            JOptionPane.showMessageDialog(null,"Select one check box");
        }
        else
        {
            
            flashcards.readCard(cardNumMC);
            String cardvalues1[] = flashcards.cardvalues;
            
            for(int i=0; i<cardvalues1.length; i++)
            {
                if(i==4)
                {
                    System.out.println("");
                    System.out.println("Card Number: "+cardNumMC);
                    System.out.println("Term: "+term);
                    System.out.println("Actual Def: "+cardvalues1[4]);
                    
                    System.out.println("");
                    
                    if(definitionA.equals(cardvalues1[i])==true && isA==true)
                    {
                        if(cardNumMC>maxCards-1)
                        {
                            cardNumMC=0;
                        }
                        else 
                        {
                           cardNumMC+=1; 
                        }
                        try 
                        {
                            TimeUnit.MILLISECONDS.sleep(50);
                        } 
                        catch (InterruptedException ex) 
                        {
                            Logger.getLogger(FlashcardsGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        flashcards.readCard(cardNumMC);
                        showCardMultiChoice();
                    }
                    
                    if(definitionB.equals(cardvalues1[i])==true && isB==true)
                    {
                        if(cardNumMC>maxCards-1)
                        {
                            cardNumMC=0;
                        }
                        else 
                        {
                           cardNumMC+=1; 
                        }
                        try 
                        {
                            TimeUnit.MILLISECONDS.sleep(50);
                        } 
                        catch (InterruptedException ex) 
                        {
                            Logger.getLogger(FlashcardsGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        flashcards.readCard(cardNumMC);
                        showCardMultiChoice();
                    }
                    
                    if(definitionC.equals(cardvalues1[i])==true && isC==true)
                    {
                        if(cardNumMC>maxCards-1)
                        {
                            cardNumMC=0;
                        }
                        else 
                        {
                           cardNumMC+=1; 
                        }
                        try 
                        {
                            TimeUnit.MILLISECONDS.sleep(50);
                        } 
                        catch (InterruptedException ex) 
                        {
                            Logger.getLogger(FlashcardsGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        flashcards.readCard(cardNumMC);
                        showCardMultiChoice();
                    }
                    
                    if(definitionD.equals(cardvalues1[i])==true && isD==true)
                    {
                        if(cardNumMC>maxCards-1)
                        {
                            cardNumMC=0;
                        }
                        else 
                        {
                           cardNumMC+=1; 
                        }
                        try 
                        {
                            TimeUnit.MILLISECONDS.sleep(50);
                        } 
                        catch (InterruptedException ex) 
                        {
                            Logger.getLogger(FlashcardsGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        flashcards.readCard(cardNumMC);
                        showCardMultiChoice();
                    }
                    
                    if(definitionA.equals(cardvalues1[i])==false && definitionB.equals(cardvalues1[i])==false && definitionC.equals(cardvalues1[i])==false && definitionD.equals(cardvalues1[i])==false && isNone==true)
                    {
                        if(cardNumMC>maxCards-1)
                        {
                            cardNumMC=0;
                        }
                        else 
                        {
                           cardNumMC+=1; 
                        }
                        try 
                        {
                            TimeUnit.MILLISECONDS.sleep(50);
                        } 
                        catch (InterruptedException ex) 
                        {
                            Logger.getLogger(FlashcardsGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        flashcards.readCard(cardNumMC);
                        showCardMultiChoice();
                    }
                    
                }
            }
        }
    }//GEN-LAST:event_btnCheckCardMCActionPerformed

    private void cbAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAItemStateChanged
        System.out.println("cbA pressed");
        if(isA==true)
        {
            isA=false;
            cbA.setEnabled(true);
            cbB.setEnabled(true);
            cbC.setEnabled(true);
            cbD.setEnabled(true);
            cbNone.setEnabled(true);
        }
        else if(isA==false)
        {
           isA = true; 
           cbA.setEnabled(true);
           cbB.setEnabled(false);
           cbC.setEnabled(false);
           cbD.setEnabled(false);
           cbNone.setEnabled(false);
        }
    }//GEN-LAST:event_cbAItemStateChanged

    private void cbBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBItemStateChanged
        System.out.println("cbB pressed");
        if(isB==true)
        {
            isB=false;
            cbA.setEnabled(true);
            cbB.setEnabled(true);
            cbC.setEnabled(true);
            cbD.setEnabled(true);
            cbNone.setEnabled(true);
        }
        else if(isB==false)
        {
           isB= true; 
           cbA.setEnabled(false);
           cbB.setEnabled(true);
           cbC.setEnabled(false);
           cbD.setEnabled(false);
           cbNone.setEnabled(false);
        }
    }//GEN-LAST:event_cbBItemStateChanged

    private void cbCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCItemStateChanged
        System.out.println("cbC pressed");
        if(isC==true)
        {
            isC=false;
            cbA.setEnabled(true);
            cbB.setEnabled(true);
            cbC.setEnabled(true);
            cbD.setEnabled(true);
            cbNone.setEnabled(true);
        }
        else if(isC==false)
        {
           isC = true; 
           cbA.setEnabled(false);
           cbB.setEnabled(false);
           cbC.setEnabled(true);
           cbD.setEnabled(false);
           cbNone.setEnabled(false);
        }
    }//GEN-LAST:event_cbCItemStateChanged

    private void cbDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDItemStateChanged
        System.out.println("cbD pressed");
        if(isD==true)
        {
            isD=false;
            cbA.setEnabled(true);
            cbB.setEnabled(true);
            cbC.setEnabled(true);
            cbD.setEnabled(true);
            cbNone.setEnabled(true);
        }
        else if(isD==false)
        {
           isD = true; 
           cbA.setEnabled(false);
           cbB.setEnabled(false);
           cbC.setEnabled(false);
           cbD.setEnabled(true);
           cbNone.setEnabled(false);
        }
    }//GEN-LAST:event_cbDItemStateChanged

    private void cbNoneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNoneItemStateChanged
        System.out.println("cbNone pressed");
        if(isNone==true)
        {
            isNone=false;
            cbA.setEnabled(true);
            cbB.setEnabled(true);
            cbC.setEnabled(true);
            cbD.setEnabled(true);
            cbNone.setEnabled(true);
        }
        else if(isNone==false)
        {
           isNone = true; 
           cbA.setEnabled(false);
           cbB.setEnabled(false);
           cbC.setEnabled(false);
           cbD.setEnabled(false);
           cbNone.setEnabled(true);
        }
    }//GEN-LAST:event_cbNoneItemStateChanged

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
            java.util.logging.Logger.getLogger(FlashcardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlashcardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlashcardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashcardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlashcardsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LEARNPANEL;
    private javax.swing.JPanel LEITNERPANEL;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel STARREDPANEL;
    private javax.swing.JPanel STYLEPANEL;
    private javax.swing.JTabbedPane TABBEDPANE;
    private javax.swing.JPanel TITLEPANEL;
    private javax.swing.JButton btnCheckCard;
    private javax.swing.JButton btnCheckCardMC;
    private javax.swing.JButton btnCheckCardTF;
    private javax.swing.JButton btnExcellent;
    private javax.swing.JButton btnGood;
    private javax.swing.JButton btnHorrible;
    private javax.swing.JButton btnOkay;
    private javax.swing.JButton btnPoor;
    private javax.swing.JToggleButton btnShowDef;
    private javax.swing.JToggleButton btnShowDefLEITNER;
    private javax.swing.JToggleButton btnShowDefSTARRED;
    private javax.swing.JToggleButton btnShuffleCards;
    private javax.swing.JToggleButton btnShuffleCardsSTARRED;
    private javax.swing.JButton btnSkipCardMC;
    private javax.swing.JButton btnSkipCardTF;
    private javax.swing.JButton btnSkipCardWRITE;
    private javax.swing.JToggleButton btnStarCard;
    private javax.swing.JToggleButton btnSwap;
    private javax.swing.JCheckBox cbA;
    private javax.swing.JCheckBox cbB;
    private javax.swing.JCheckBox cbC;
    private javax.swing.JCheckBox cbD;
    private javax.swing.JCheckBox cbFalse;
    private javax.swing.JCheckBox cbNone;
    private javax.swing.JCheckBox cbTrue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblCardCount;
    private javax.swing.JLabel lblCardCountSTARRED;
    private javax.swing.JLabel lblDefinition;
    private javax.swing.JLabel lblDefinitionLEITNER;
    private javax.swing.JLabel lblDefinitionLISTEN;
    private javax.swing.JLabel lblDefinitionSTARRED;
    private javax.swing.JLabel lblDefinitionTF;
    private javax.swing.JLabel lblDefinitionWRITE;
    private javax.swing.JLabel lblExample;
    private javax.swing.JLabel lblExampleLEITNER;
    private javax.swing.JLabel lblExampleSTARRED;
    private javax.swing.JLabel lblExampleTF;
    private javax.swing.JLabel lblExampleWRITE;
    private javax.swing.JLabel lblMeans;
    private javax.swing.JLabel lblTags;
    private javax.swing.JLabel lblTagsLEITNER;
    private javax.swing.JLabel lblTagsSTARRED;
    private javax.swing.JLabel lblTagsTF;
    private javax.swing.JLabel lblTagsWRITE;
    private javax.swing.JLabel lblTerm;
    private javax.swing.JLabel lblTermLEITNER;
    private javax.swing.JLabel lblTermMC;
    private javax.swing.JLabel lblTermSTARRED;
    private javax.swing.JLabel lblTermTF;
    private javax.swing.JLabel lblTermWRITE;
    private javax.swing.JLabel lblTitle;
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
    private javax.swing.JSlider sliderCards;
    private javax.swing.JSlider sliderCardsSTARRED;
    private javax.swing.JTextField tfDefinition;
    private javax.swing.JTextField tfDefinitionLEITNER;
    private javax.swing.JTextField tfDefinitionMC;
    private javax.swing.JTextField tfDefinitionSTARRED;
    private javax.swing.JTextField tfDefinitionTF;
    private javax.swing.JTextField tfDefinitionWRITE;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfExample;
    private javax.swing.JTextField tfExampleLEITNER;
    private javax.swing.JTextField tfExampleSTARRED;
    private javax.swing.JTextField tfExampleTF;
    private javax.swing.JTextField tfExampleWRITE;
    private javax.swing.JTextField tfTags;
    private javax.swing.JTextField tfTagsLEITNER;
    private javax.swing.JTextField tfTagsSTARRED;
    private javax.swing.JTextField tfTagsTF;
    private javax.swing.JTextField tfTagsWRITE;
    private javax.swing.JTextField tfTerm;
    private javax.swing.JTextField tfTermLEITNER;
    private javax.swing.JTextField tfTermSTARRED;
    private javax.swing.JTextField tfTermTF;
    private javax.swing.JTextField tfTermWRITE;
    // End of variables declaration//GEN-END:variables
}
