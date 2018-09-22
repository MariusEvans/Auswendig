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
    boolean shuffleCards = false;
    boolean shuffleCardsSTARRED = false;
    
    int triesLeft=3;
    int randomDef=1;
    int randomNum1;
    int maxCards;
    int maxCardsSTARRED;
    int cardNumLeitner;
    int cardNumWrite;
    int cardNumTF;
    int cardNumListen;
    
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
        jPanel1 = new javax.swing.JPanel();
        btnListen = new javax.swing.JButton();
        lblDefinitionLISTEN = new javax.swing.JLabel();
        tfDefinitionLISTEN = new javax.swing.JTextField();
        btnRecordTerm = new javax.swing.JButton();
        btnCheckDefinitionLISTEN = new javax.swing.JButton();
        btnSkipCardLISTEN = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auswendig");
        setBackground(new java.awt.Color(153, 153, 255));

        STYLEPANEL.setBackground(new java.awt.Color(255, 255, 255));

        TABBEDPANE.setBackground(new java.awt.Color(255, 255, 255));

        LEARNPANEL.setBackground(new java.awt.Color(255, 255, 255));

        tfTags.setEditable(false);

        lblTags.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTags.setText("Tags:");

        tfExample.setEditable(false);

        lblExample.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExample.setText("Example:");

        tfTerm.setEditable(false);

        lblTerm.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
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

        lblCardCount.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblCardCount.setText("Card: START");

        lblDefinition.setText("Definition:");

        tfDefinition.setEditable(false);

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

        javax.swing.GroupLayout LEARNPANELLayout = new javax.swing.GroupLayout(LEARNPANEL);
        LEARNPANEL.setLayout(LEARNPANELLayout);
        LEARNPANELLayout.setHorizontalGroup(
            LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEARNPANELLayout.createSequentialGroup()
                .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LEARNPANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnStarCard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnShuffleCards))
                    .addGroup(LEARNPANELLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(LEARNPANELLayout.createSequentialGroup()
                                    .addComponent(lblTerm)
                                    .addGap(30, 30, 30)
                                    .addComponent(tfTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(LEARNPANELLayout.createSequentialGroup()
                                    .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTags)
                                        .addComponent(lblExample)
                                        .addComponent(lblDefinition))
                                    .addGap(30, 30, 30)
                                    .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfTags)
                                        .addComponent(tfExample)
                                        .addComponent(tfDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCardCount, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sliderCards, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(LEARNPANELLayout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(btnShowDef)))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        LEARNPANELLayout.setVerticalGroup(
            LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEARNPANELLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblCardCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowDef)
                .addGap(18, 18, 18)
                .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefinition)
                    .addComponent(tfDefinition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(LEARNPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStarCard)
                    .addComponent(btnShuffleCards))
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
        lblCardCountSTARRED.setText("Card: START");

        tfTermSTARRED.setEditable(false);

        tfExampleSTARRED.setEditable(false);

        tfTagsSTARRED.setEditable(false);

        btnShowDefSTARRED.setText("Show Definition");
        btnShowDefSTARRED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDefSTARREDActionPerformed(evt);
            }
        });

        tfDefinitionSTARRED.setEditable(false);

        lblDefinitionSTARRED.setText("Definition:");

        lblTagsSTARRED.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTagsSTARRED.setText("Tags:");

        lblExampleSTARRED.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExampleSTARRED.setText("Example:");

        lblTermSTARRED.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTermSTARRED.setText("Term:");

        btnShuffleCardsSTARRED.setText("Shuffle Cards");
        btnShuffleCardsSTARRED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShuffleCardsSTARREDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout STARREDPANELLayout = new javax.swing.GroupLayout(STARREDPANEL);
        STARREDPANEL.setLayout(STARREDPANELLayout);
        STARREDPANELLayout.setHorizontalGroup(
            STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STARREDPANELLayout.createSequentialGroup()
                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(STARREDPANELLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(STARREDPANELLayout.createSequentialGroup()
                                    .addComponent(lblTermSTARRED)
                                    .addGap(30, 30, 30)
                                    .addComponent(tfTermSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(STARREDPANELLayout.createSequentialGroup()
                                    .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTagsSTARRED)
                                        .addComponent(lblExampleSTARRED)
                                        .addComponent(lblDefinitionSTARRED))
                                    .addGap(30, 30, 30)
                                    .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfTagsSTARRED)
                                        .addComponent(tfExampleSTARRED)
                                        .addComponent(tfDefinitionSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCardCountSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sliderCardsSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(STARREDPANELLayout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(btnShowDefSTARRED))))
                    .addGroup(STARREDPANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnShuffleCardsSTARRED)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        STARREDPANELLayout.setVerticalGroup(
            STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STARREDPANELLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblCardCountSTARRED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderCardsSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTermSTARRED)
                    .addComponent(tfTermSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExampleSTARRED)
                    .addComponent(tfExampleSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTagsSTARRED)
                    .addComponent(tfTagsSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowDefSTARRED)
                .addGap(18, 18, 18)
                .addGroup(STARREDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefinitionSTARRED)
                    .addComponent(tfDefinitionSTARRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnShuffleCardsSTARRED)
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
        lblTermLEITNER.setText("Term:");

        lblExampleLEITNER.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExampleLEITNER.setText("Example:");

        lblTagsLEITNER.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTagsLEITNER.setText("Tags:");

        tfTagsLEITNER.setEditable(false);

        tfExampleLEITNER.setEditable(false);

        lblDefinitionLEITNER.setText("Definition:");

        btnShowDefLEITNER.setText("Show Definition");
        btnShowDefLEITNER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDefLEITNERActionPerformed(evt);
            }
        });

        tfTermLEITNER.setEditable(false);

        tfDefinitionLEITNER.setEditable(false);

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

        javax.swing.GroupLayout LEITNERPANELLayout = new javax.swing.GroupLayout(LEITNERPANEL);
        LEITNERPANEL.setLayout(LEITNERPANELLayout);
        LEITNERPANELLayout.setHorizontalGroup(
            LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEITNERPANELLayout.createSequentialGroup()
                .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LEITNERPANELLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(LEITNERPANELLayout.createSequentialGroup()
                                    .addComponent(lblTermLEITNER)
                                    .addGap(30, 30, 30)
                                    .addComponent(tfTermLEITNER, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(LEITNERPANELLayout.createSequentialGroup()
                                    .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTagsLEITNER)
                                        .addComponent(lblExampleLEITNER)
                                        .addComponent(lblDefinitionLEITNER))
                                    .addGap(30, 30, 30)
                                    .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfTagsLEITNER)
                                        .addComponent(tfExampleLEITNER)
                                        .addComponent(tfDefinitionLEITNER, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(LEITNERPANELLayout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(btnShowDefLEITNER))))
                    .addGroup(LEITNERPANELLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnExcellent, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGood, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOkay, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPoor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHorrible, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        LEITNERPANELLayout.setVerticalGroup(
            LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEITNERPANELLayout.createSequentialGroup()
                .addGap(62, 62, 62)
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
                .addComponent(btnShowDefLEITNER)
                .addGap(18, 18, 18)
                .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefinitionLEITNER)
                    .addComponent(tfDefinitionLEITNER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(LEITNERPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcellent)
                    .addComponent(btnGood)
                    .addComponent(btnOkay)
                    .addComponent(btnPoor)
                    .addComponent(btnHorrible))
                .addGap(21, 21, 21))
        );

        TABBEDPANE.addTab("Leitner", LEITNERPANEL);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnListen.setText("Listen to Term");

        lblDefinitionLISTEN.setText("Definition:");

        btnRecordTerm.setText("Record Term (10s)");
        btnRecordTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordTermActionPerformed(evt);
            }
        });

        btnCheckDefinitionLISTEN.setText("Check Definition");
        btnCheckDefinitionLISTEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckDefinitionLISTENActionPerformed(evt);
            }
        });

        btnSkipCardLISTEN.setText("START");
        btnSkipCardLISTEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkipCardLISTENActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRecordTerm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(lblDefinitionLISTEN)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfDefinitionLISTEN, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(btnListen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCheckDefinitionLISTEN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSkipCardLISTEN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefinitionLISTEN)
                    .addComponent(tfDefinitionLISTEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(btnListen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCheckDefinitionLISTEN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSkipCardLISTEN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(btnRecordTerm)
                .addContainerGap())
        );

        TABBEDPANE.addTab("Listen", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblDefinitionWRITE.setText("Definition:");

        lblTermWRITE.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTermWRITE.setText("Term:");

        tfTermWRITE.setEditable(false);

        lblExampleWRITE.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExampleWRITE.setText("Example:");

        tfExampleWRITE.setEditable(false);

        lblTagsWRITE.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTagsWRITE.setText("Tags:");

        tfTagsWRITE.setEditable(false);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSwap))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTermWRITE)
                                .addGap(30, 30, 30)
                                .addComponent(tfTermWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTagsWRITE)
                                    .addComponent(lblExampleWRITE)
                                    .addComponent(lblDefinitionWRITE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfTagsWRITE)
                                    .addComponent(tfExampleWRITE)
                                    .addComponent(tfDefinitionWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSkipCardWRITE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCheckCard, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefinitionWRITE)
                    .addComponent(tfDefinitionWRITE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCheckCard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSkipCardWRITE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnSwap)
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
        lblTermTF.setText("Term:");

        tfTermTF.setEditable(false);

        lblExampleTF.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblExampleTF.setText("Example:");

        tfExampleTF.setEditable(false);

        lblTagsTF.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lblTagsTF.setText("Tags:");

        tfTagsTF.setEditable(false);

        lblDefinitionTF.setText("Definition:");

        tfDefinitionTF.setEditable(false);

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblTermTF)
                                    .addGap(30, 30, 30)
                                    .addComponent(tfTermTF, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTagsTF)
                                        .addComponent(lblExampleTF))
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfTagsTF)
                                        .addComponent(tfExampleTF, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblDefinitionTF)
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(cbTrue)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbFalse))
                                        .addComponent(tfDefinitionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(lblMeans))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSkipCardTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCheckCardTF, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTermTF)
                    .addComponent(tfTermTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExampleTF)
                    .addComponent(tfExampleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTagsTF)
                    .addComponent(tfTagsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lblMeans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDefinitionTF)
                    .addComponent(tfDefinitionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFalse)
                    .addComponent(cbTrue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCheckCardTF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSkipCardTF)
                .addContainerGap(66, Short.MAX_VALUE))
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
                .addComponent(TABBEDPANE))
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
            String cardvalues1[] = flashcards.cardvalues;
            
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
                       cardNumTF+=randomNum;
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
    
    private void btnExcellentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcellentActionPerformed
        System.out.println("btnExcellent pressed.");
        String daysTillReview = "*5"; //5,3,2,1,0

        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview);
        cardNumLeitner +=1;
        flashcards.readCardLEITNER(selectedItem, cardNumLeitner);

        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
            flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
        }
        //int sliderValue = sliderCardsLEITNER.getValue();
        
        showCardLeitner();
    }//GEN-LAST:event_btnExcellentActionPerformed

    private void btnGoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoodActionPerformed
        System.out.println("btnGood pressed.");
        String daysTillReview = "*3"; //5,3,2,1,0
        
        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview);
        cardNumLeitner +=1;
        flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
        
        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
            flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
        }
 
        showCardLeitner();
    }//GEN-LAST:event_btnGoodActionPerformed

    private void btnOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkayActionPerformed
        System.out.println("btnOkay pressed.");
        String daysTillReview = "*2"; //5,3,2,1,0
        
        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview);
        flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
        cardNumLeitner +=1;
     
        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
            flashcards.readCardLEITNER(selectedItem, cardNumLeitner);
        }
        
        showCardLeitner();
    }//GEN-LAST:event_btnOkayActionPerformed

    private void btnPoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoorActionPerformed
        System.out.println("btnPoor pressed.");
        String daysTillReview = "*1"; //5,3,2,1,0
        
        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview);
        cardNumLeitner +=1;  
        flashcards.readCardLeiter1(selectedItem, cardNumLeitner);
 
        
        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
            flashcards.readCardLeiter1(selectedItem, cardNumLeitner);
        }
        
        showCardLeitner();
    }//GEN-LAST:event_btnPoorActionPerformed

    private void btnHorribleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorribleActionPerformed
        System.out.println("btnHorrible pressed.");
        String daysTillReview = "*0"; //5,3,2,1,0
        
        flashcards.SaveCardLEITNER(selectedItem, cardNumLeitner, daysTillReview);
        cardNumLeitner +=1;
        flashcards.readCardLeiter1(selectedItem, cardNumLeitner);
      
        if(cardNumLeitner>maxCards)
        {
            cardNumLeitner=0;
            flashcards.readCardLeiter1(selectedItem, cardNumLeitner);
        }
        
        showCardLeitner();
    }//GEN-LAST:event_btnHorribleActionPerformed

    private void LEITNERPANELComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_LEITNERPANELComponentShown
        cardNumLeitner = 0;
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

    private void btnCheckDefinitionLISTENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckDefinitionLISTENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckDefinitionLISTENActionPerformed

    private void btnSkipCardLISTENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipCardLISTENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSkipCardLISTENActionPerformed

    private void btnRecordTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordTermActionPerformed
        SoundRecorder soundrecorder = new SoundRecorder();
    }//GEN-LAST:event_btnRecordTermActionPerformed

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
        if (btnShuffleCards.isSelected())
        {
            shuffleCardsSTARRED=true;
        }
        else
        {
            shuffleCardsSTARRED=false;
        }
    }//GEN-LAST:event_btnShuffleCardsSTARREDActionPerformed

    
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
    private javax.swing.JButton btnCheckCardTF;
    private javax.swing.JButton btnCheckDefinitionLISTEN;
    private javax.swing.JButton btnExcellent;
    private javax.swing.JButton btnGood;
    private javax.swing.JButton btnHorrible;
    private javax.swing.JButton btnListen;
    private javax.swing.JButton btnOkay;
    private javax.swing.JButton btnPoor;
    private javax.swing.JButton btnRecordTerm;
    private javax.swing.JToggleButton btnShowDef;
    private javax.swing.JToggleButton btnShowDefLEITNER;
    private javax.swing.JToggleButton btnShowDefSTARRED;
    private javax.swing.JToggleButton btnShuffleCards;
    private javax.swing.JToggleButton btnShuffleCardsSTARRED;
    private javax.swing.JButton btnSkipCardLISTEN;
    private javax.swing.JButton btnSkipCardTF;
    private javax.swing.JButton btnSkipCardWRITE;
    private javax.swing.JToggleButton btnStarCard;
    private javax.swing.JToggleButton btnSwap;
    private javax.swing.JCheckBox cbFalse;
    private javax.swing.JCheckBox cbTrue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JLabel lblTermSTARRED;
    private javax.swing.JLabel lblTermTF;
    private javax.swing.JLabel lblTermWRITE;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenu menuFolders;
    private javax.swing.JMenu menuSets;
    private javax.swing.JMenuItem miCreateFolder;
    private javax.swing.JMenuItem miCreateSet;
    private javax.swing.JMenuItem miDeleteFolder;
    private javax.swing.JMenuItem miDeleteSet;
    private javax.swing.JMenuItem miEditFolder;
    private javax.swing.JMenuItem miEditSet;
    private javax.swing.JMenuItem miOpenFolder;
    private javax.swing.JMenuItem miOpenSet;
    private javax.swing.JSlider sliderCards;
    private javax.swing.JSlider sliderCardsSTARRED;
    private javax.swing.JTextField tfDefinition;
    private javax.swing.JTextField tfDefinitionLEITNER;
    private javax.swing.JTextField tfDefinitionLISTEN;
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
