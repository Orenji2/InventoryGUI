import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Claude
 */
public class InventoryFrame extends javax.swing.JFrame {

    DefaultTableModel model;
    
    public InventoryFrame() {
        initComponents();
        
        //Puts the window at the Center of Screen
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        model = (DefaultTableModel) Table.getModel();
        SelectedPane.setVisible(false);
        RecipePane.setVisible(false);
        RIPane.setVisible(false);
    }
    
    //A Method to Search for Items
    private void Filter(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        Table.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    //A Method to Add a Row in Inventory Table
    private void AddRow(String ItemName, String ItemQuantity){
        //If neither TextField is Blank then Error pops up
        if(ItemName.isBlank()||ItemQuantity.isBlank()){
            JOptionPane.showMessageDialog(this, "Invalid Input.");
        }else{
            model.insertRow(
                    model.getRowCount(),new Object[]{ItemName,ItemQuantity}
            );
            //After Adding a Row, Close Panes and Reset TextFields
            SelectedPane.setVisible(false);
            RecipePane.setVisible(false);
            Table.clearSelection();
            Filter("");
            ItemTF.setText("");QuantityTF.setText("");
            SItem.setText("");NQuantityTF.setText("");
        }
    }
    
    //A Method to Decrement the Quantity of the Item
    private void Decrement(int Value, String Name){
        if(Name.equals("TableSelect")){
            //Gets the index of Selected Row
            int row = Table.getSelectedRow();
            //Converts the Quantity of that Row into int
            int StoredQuantity = 
                    Integer.parseInt(model.getValueAt(row, 1).toString());
            //Decrements
            int NewQuantity = StoredQuantity - Value;
            //If NewQuantity goes negative, Stays at 0
            if (NewQuantity < 0){
                model.setValueAt(0, row, 1);
                NQuantityTF.setText("0");
            }else{
                //Changes the Quantity inside Inventory Table
                String NewValue = String.valueOf(NewQuantity);
                model.setValueAt(NewValue, row, 1);
                NQuantityTF.setText(NewValue);
            }
        }
        //Same Process, Different Table
        if(Name.equals("RecipeSelect")){
            int row = RecipeTable.getSelectedRow();
            int StoredQuantity = Integer.parseInt(RecipeTable.getValueAt(row, 1).toString());
            int NewQuantity = StoredQuantity - Value;
            if (NewQuantity < 0){
                RecipeTable.setValueAt(0, row, 1);
                NQuantityTF.setText("0");
            }else{
                String NewValue = String.valueOf(NewQuantity);
                RecipeTable.setValueAt(NewValue, row, 1);
                NQuantityTF.setText(NewValue);
            }
        }
    }
    
    //A Method to Increment the Quantity of the Item
    private void Increment(int Value, String Name){
        if(Name.equals("TableSelect")){
            //Gets the index of Selected Row
            int row = Table.getSelectedRow();
            //Converts the Quantity of that Row into int
            int StoredQuantity = 
                    Integer.parseInt(model.getValueAt(row, 1).toString());
            //Increments
            int NewQuantity = StoredQuantity + Value;
            //Changes the Quantity inside Inventory Table
            String NewValue = String.valueOf(NewQuantity);
            model.setValueAt(NewQuantity, row, 1);
            NQuantityTF.setText(NewValue);
        }
        if(Name.equals("RecipeSelect")){
            int row = RecipeTable.getSelectedRow();
            int StoredQuantity = Integer.parseInt(RecipeTable.getValueAt(row, 1).toString());
            int NewQuantity = StoredQuantity + Value;
            String NewValue = String.valueOf(NewQuantity);
            
            RecipeTable.setValueAt(NewValue, row, 1);
            NQuantityTF.setText(NewValue);
        }
    }
    
    //A Method to clear Recipe Table
    private void ClearRecipe(){
        DefaultTableModel RT = (DefaultTableModel) RecipeTable.getModel();
        for (int x = RecipeTable.getRowCount()-1; x >= 0; x--){
            //int x = 0; x < RecipeTable.getRowCount(); x++
            //int x = RecipeTable.getRowCount()-1; x >= 0; x--
            RT.removeRow(x);
        }
    }
    
    //A Method to Enable/Disable Increment/Decrement Buttons
    private void SEnabled(boolean con){
        if(!con){
            dec1.setEnabled(false);
            dec5.setEnabled(false);
            inc1.setEnabled(false);
            inc5.setEnabled(false);
            NQuantityTF.setEnabled(false);
        }else{
            dec1.setEnabled(true);
            dec5.setEnabled(true);
            inc1.setEnabled(true);
            inc5.setEnabled(true);
            NQuantityTF.setEnabled(true);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        InventoryPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SRecipes = new javax.swing.JTable();
        RIPane = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        IngredientsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        UseRecipeButton = new javax.swing.JButton();
        DeleteRecipeButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        BackEnd = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ItemTF = new javax.swing.JTextField();
        QuantityTF = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SelectedPane = new javax.swing.JPanel();
        SItem = new javax.swing.JLabel();
        dec5 = new javax.swing.JButton();
        dec1 = new javax.swing.JButton();
        NQuantityTF = new javax.swing.JTextField();
        inc1 = new javax.swing.JButton();
        inc5 = new javax.swing.JButton();
        RecipePane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        RecipeNTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        RecipeTable = new javax.swing.JTable();
        SelectedItems = new javax.swing.JLabel();
        AddRecipeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory System");
        setPreferredSize(new java.awt.Dimension(1000, 601));
        setSize(new java.awt.Dimension(965, 601));

        InventoryPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
        );

        InventoryPane.addTab("Inventory", jPanel1);

        SRecipes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recipes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SRecipes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SRecipesMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(SRecipes);
        if (SRecipes.getColumnModel().getColumnCount() > 0) {
            SRecipes.getColumnModel().getColumn(0).setResizable(false);
        }

        IngredientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Stored", "Needed", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(IngredientsTable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        UseRecipeButton.setText("Use Recipe");
        UseRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UseRecipeButtonActionPerformed(evt);
            }
        });

        DeleteRecipeButton.setText("Delete");
        DeleteRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRecipeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RIPaneLayout = new javax.swing.GroupLayout(RIPane);
        RIPane.setLayout(RIPaneLayout);
        RIPaneLayout.setHorizontalGroup(
            RIPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RIPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RIPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addGroup(RIPaneLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UseRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        RIPaneLayout.setVerticalGroup(
            RIPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RIPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RIPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RIPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UseRecipeButton)
                        .addComponent(DeleteRecipeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RIPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RIPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        InventoryPane.addTab("Recipes", jPanel2);

        BackEnd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodeName", "Item Names", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(BackEnd);
        if (BackEnd.getColumnModel().getColumnCount() > 0) {
            BackEnd.getColumnModel().getColumn(0).setResizable(false);
            BackEnd.getColumnModel().getColumn(1).setResizable(false);
            BackEnd.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
        );

        InventoryPane.addTab("BackEnd", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(398, 138));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Item Name");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quantity");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setPreferredSize(new java.awt.Dimension(63, 20));

        ItemTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ItemTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ItemTFKeyReleased(evt);
            }
        });

        QuantityTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                QuantityTFKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QuantityTFKeyTyped(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(AddButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeleteButton))
                            .addComponent(QuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ItemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ItemTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(DeleteButton))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        SelectedPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SelectedPane.setPreferredSize(new java.awt.Dimension(398, 138));

        SItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SItem.setAutoscrolls(true);
        SItem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dec5.setText("-5");
        dec5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dec5ActionPerformed(evt);
            }
        });

        dec1.setText("-1");
        dec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dec1ActionPerformed(evt);
            }
        });

        NQuantityTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NQuantityTF.setMinimumSize(new java.awt.Dimension(64, 47));
        NQuantityTF.setPreferredSize(new java.awt.Dimension(64, 47));
        NQuantityTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NQuantityTFFocusLost(evt);
            }
        });
        NQuantityTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NQuantityTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NQuantityTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NQuantityTFKeyTyped(evt);
            }
        });

        inc1.setText("+1");
        inc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inc1ActionPerformed(evt);
            }
        });

        inc5.setText("+5");
        inc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inc5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SelectedPaneLayout = new javax.swing.GroupLayout(SelectedPane);
        SelectedPane.setLayout(SelectedPaneLayout);
        SelectedPaneLayout.setHorizontalGroup(
            SelectedPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectedPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SItem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dec5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dec1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inc1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inc5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        SelectedPaneLayout.setVerticalGroup(
            SelectedPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SelectedPaneLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(SelectedPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(NQuantityTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inc5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dec1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dec5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        RecipePane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        RecipePane.setPreferredSize(new java.awt.Dimension(398, 138));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Recipe Name");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        RecipeNTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RecipeNTFKeyReleased(evt);
            }
        });

        RecipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RecipeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecipeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(RecipeTable);

        SelectedItems.setText("Selected Items (x)");

        AddRecipeButton.setText("Add Recipe");
        AddRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecipeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RecipePaneLayout = new javax.swing.GroupLayout(RecipePane);
        RecipePane.setLayout(RecipePaneLayout);
        RecipePaneLayout.setHorizontalGroup(
            RecipePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecipePaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(RecipePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RecipePaneLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(RecipePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SelectedItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddRecipeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(RecipePaneLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RecipeNTF, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        RecipePaneLayout.setVerticalGroup(
            RecipePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecipePaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(RecipePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(RecipeNTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RecipePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(RecipePaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AddRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SelectedItems)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InventoryPane))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SelectedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RecipePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RecipePane, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
                    .addComponent(InventoryPane))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    //Deletes the Selected Row in Inventory Table
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(Table.getSelectedRowCount() == 1){
            model.removeRow(Table.getSelectedRow());
            //Hides unused Panes and Resets TextFields
            SelectedPane.setVisible(false);
            RecipePane.setVisible(false);
            Table.clearSelection();
            ItemTF.setText("");QuantityTF.setText("");SItem.setText("");NQuantityTF.setText("");
        }else{
            //If there is No Selected Row then Error message pops up
            if(Table.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Table is Empty.");
            }else{
                JOptionPane.showMessageDialog(this, "Please Select a single Row.");
            }
        }
    }                                            

    //Adds the Item in the Inventory Table
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        AddRow(ItemTF.getText(),QuantityTF.getText());
    }                                         

    //If User types a Non-Digit character, then it gets Voided
    private void QuantityTFKeyTyped(java.awt.event.KeyEvent evt) {                                    
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }                                   

    //While User is typing in Item Name TextField, It's running as Search Bar
    private void ItemTFKeyReleased(java.awt.event.KeyEvent evt) {                                   
        String query = ItemTF.getText();
        Filter(query);
    }                                  
    //If User presses Enter from Item Name TextField, 
    //Moves focus on Quantity TextField
    private void ItemTFKeyPressed(java.awt.event.KeyEvent evt) {                                  
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            QuantityTF.requestFocus();
        }
    }                                 
    //If User presses Enter from Quantity TextField, 
    //Adds Row then goes back to Item Name TextField
    private void QuantityTFKeyPressed(java.awt.event.KeyEvent evt) {                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            AddRow(ItemTF.getText(),QuantityTF.getText());
            ItemTF.requestFocus();
        }
    }                                     

    //Decrement Selected Row value by 1
    private void dec1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if(Table.getSelectedRowCount() == 1){
            Decrement(1,"TableSelect");
        }
        if(RecipeTable.getSelectedRowCount() == 1){
            Decrement(1,"RecipeSelect");
        }
    }                                    
    //Decrement Selected Row value by 5
    private void dec5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if(Table.getSelectedRowCount() == 1){
            Decrement(5,"TableSelect");
        }
        if(RecipeTable.getSelectedRowCount() == 1){
            Decrement(5,"RecipeSelect");
        }
    }                                    

    //Increment Selected Row value by 1
    private void inc1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if(Table.getSelectedRowCount() == 1){
            Increment(1,"TableSelect");
        }
        if(RecipeTable.getSelectedRowCount() == 1){
            Increment(1,"RecipeSelect");
        }
    }                                    
    //Increment Selected Row value by 5
    private void inc5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if(Table.getSelectedRowCount() == 1){
            Increment(5,"TableSelect");
        }
        if(RecipeTable.getSelectedRowCount() == 1){
            Increment(5,"RecipeSelect");
        }
    }                                    

    //If User types a Non-Digit character, then it gets Voided
    private void NQuantityTFKeyTyped(java.awt.event.KeyEvent evt) {                                     
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }                                    
    //While User is typing new Value, Changes Value in the Selected Table
    private void NQuantityTFKeyReleased(java.awt.event.KeyEvent evt) {                                        
        if(Table.getSelectedRowCount()==1){
            int row = Table.getSelectedRow();
            model.setValueAt(NQuantityTF.getText(), row, 1);
        }
        if(RecipeTable.getSelectedRowCount()==1){
            int row = RecipeTable.getSelectedRow();
            RecipeTable.setValueAt(NQuantityTF.getText(), row, 1);
        }
    }                                       

    //If TextField loses focus with Whitespace, then sets default value to 0
    private void NQuantityTFFocusLost(java.awt.event.FocusEvent evt) {                                      
        if(Table.getSelectedRowCount()==1){
            int row = Table.getSelectedRow();
            if(NQuantityTF.getText().isBlank()){
                NQuantityTF.setText("0");
                model.setValueAt("0", row, 1);
            }
        }
        if(RecipeTable.getSelectedRowCount()==1){
            int row = RecipeTable.getSelectedRow();
            if(NQuantityTF.getText().isBlank()){
                NQuantityTF.setText("0");
                RecipeTable.setValueAt("0", row, 1);
            }
        }
    }                                     

    //When Selecting a row in Inventory Table
    private void TableMouseClicked(java.awt.event.MouseEvent evt) {                                   
        SelectedPane.setVisible(true);
        RecipePane.setVisible(true);
        RecipeTable.clearSelection();
        //Clears previous data
        ClearRecipe();
        //Enable/Disable Increment/Decrement Buttons
        SEnabled(Table.getSelectedRowCount() == 1);
        
        //Displays all Selected Row from Inventory Table to Recipe Table
        int index[] = Table.getSelectedRows();
        Object[] Selected = new Object[2];
        DefaultTableModel RT = (DefaultTableModel) RecipeTable.getModel();
        for(int i = 0; i < index.length; i++){
            SItem.setText(Table.getValueAt(index[i],0).toString());
            NQuantityTF.setText(Table.getValueAt(index[i], 1).toString());
            Selected[0] = Table.getValueAt(index[i],0);
            Selected[1] = 1;

            RT.addRow(Selected);
        }
        jPanel1.requestFocus();
        //Shows how many Rows are Selected
        SelectedItems.setText(
                "Selected Items (" + Table.getSelectedRowCount() + ")");
    }                                  

    //Exits out of the TextField when User presses Enter 
    private void NQuantityTFKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            jPanel1.requestFocus();
        }
    }                                      
    //When Editing an Item Name in Inventory Table, after User presses Enter,
    //Updates necessary Fields
    private void TableKeyReleased(java.awt.event.KeyEvent evt) {                                  
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            int row = Table.getSelectedRow();
            SItem.setText(model.getValueAt(row, 0).toString());
            Table.clearSelection();
            SelectedPane.setVisible(false);
            RecipePane.setVisible(false);
            ClearRecipe();
            jPanel1.requestFocus();
        }
    }                                 

    //A Button that Adds a Recipe with the Items in Recipe Table
    private void AddRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        RecipeTable.clearSelection();
        DefaultTableModel SR = (DefaultTableModel) SRecipes.getModel();
        //Gets Recipe Name and saves it in Saved Recipes Table
        String RecipeName = RecipeNTF.getText();
        if(!RecipeName.isBlank()){
            SR.insertRow( SR.getRowCount(),new Object[]{RecipeName});
        }else{
            //If Recipe Name TextField is Empty, Error message pops up
            JOptionPane.showMessageDialog(this, "Please Input a Recipe Name.");
            return;
        }
        //Adds all Items in Recipe Table into Back End Table
        DefaultTableModel BE = (DefaultTableModel) BackEnd.getModel();
    for(int i = 0; i < RecipeTable.getRowCount(); i++){
        String ItemName = RecipeTable.getValueAt(i, 0).toString();
        int Quantity = Integer.parseInt(RecipeTable.getValueAt(i, 1).toString());
        BE.insertRow(
                BE.getRowCount(),new Object[]{RecipeName,ItemName,Quantity}
        );
    }
        //Resets Recipe Name TextField and Recipe Table
        RecipeNTF.setText("");
        ClearRecipe();
        Table.clearSelection();
        SelectedPane.setVisible(false);
        RecipePane.setVisible(false);
        jPanel1.requestFocus();
    }                                               

    //Shows all Ingredients when a Recipe is Selected from Saved Recipes Table
    private void SRecipesMouseReleased(java.awt.event.MouseEvent evt) {                                       
        UseRecipeButton.setEnabled(true);
        RIPane.setVisible(true);

        DefaultTableModel IT = (DefaultTableModel) IngredientsTable.getModel();
        String Code = 
                SRecipes.getValueAt(SRecipes.getSelectedRow(), 0).toString();
        jLabel4.setText("Recipe Ingredients of " + Code);
        //Clears the Ingredients Table from previous Instance
        for (int x = IngredientsTable.getRowCount()-1; x >= 0 ; x--){
            IT.removeRow(x);
        }
for(int i = 0; i < BackEnd.getRowCount(); i++){
    //Compares the Code of the Recipe to the BackEnd Table
    //And Displays found Data in Ingredients Table
    if(Code.equals(BackEnd.getValueAt(i, 0))){
        Object[] Ingredient = new Object[4];
        String ItemName = BackEnd.getValueAt(i, 1).toString();
        Ingredient[0] = ItemName;
        Ingredient[2] = BackEnd.getValueAt(i, 2);
        //A Loop to see the Difference of the Quantity from Inventory Table and BackEnd Table
        for(int x = 0; x < Table.getRowCount(); x++){
            if(Table.getValueAt(x, 0).equals(ItemName)){
                int SQuantity = Integer.parseInt(Table.getValueAt(x, 1).toString());
                Ingredient[1] = SQuantity;

                int Diff = SQuantity - Integer.parseInt(BackEnd.getValueAt(i, 2).toString());
                StringBuilder Missing = new StringBuilder("Missing: ");
                if(Diff < 0){
                    //If there is a Missing Quantity, Disabled Use Recipe Button
                    UseRecipeButton.setEnabled(false);
                    Ingredient[3] = Missing.append(Integer.parseInt(BackEnd.getValueAt(i, 2).toString()) - SQuantity);
                }else{
                    Ingredient[3] = Diff;
                }
            }
        }
        IT.addRow(Ingredient);
    }
}
    }                                      

    //While in Recipe Name TextField. If User presses Enter, Focuses on Add Recipe Button
    private void RecipeNTFKeyReleased(java.awt.event.KeyEvent evt) {                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            AddRecipeButton.requestFocus();
        }
    }                                     
    //Deducts the Selected Recipe from Inventory Table
    private void UseRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        for(int i = 0; i < IngredientsTable.getRowCount(); i++){
            for(int x = 0; x < Table.getRowCount(); x++){
                String Ingredient = IngredientsTable.getValueAt(i, 0).toString();
                if(Ingredient.equals(Table.getValueAt(x, 0))){
                    Table.setValueAt(IngredientsTable.getValueAt(i, 3), x, 1);
                }
            }
        }
        SRecipes.clearSelection();
        jPanel1.requestFocus();
        RIPane.setVisible(false);
        InventoryPane.setSelectedIndex(0);
    }                                               

    //Deletes the Selected Recipe and All Ingredients with the same Code in the BackEnd
    private void DeleteRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        DefaultTableModel SR = (DefaultTableModel) SRecipes.getModel();
        DefaultTableModel BE = (DefaultTableModel) BackEnd.getModel();
        if(SRecipes.getSelectedRowCount() == 1){
            String Code = SRecipes.getValueAt(SRecipes.getSelectedRow(), 0).toString();
            for(int i = BackEnd.getRowCount() - 1; i >= 0; i--){
                if (Code.equals(BackEnd.getValueAt(i, 0))){
                    BE.removeRow(i);
                }
            }
            SR.removeRow(SRecipes.getSelectedRow());
            RIPane.setVisible(false);
        }else{
            //If Saved Recipe Table is Empty, Message pops up
            if(SRecipes.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Table is Empty.");
            }else{
                JOptionPane.showMessageDialog(this, "Please Select a single Row.");
            }
        }
    }                                                  

    //Updates Data in certain Fields when User Clicks a Row in Recipe Table
    private void RecipeTableMouseClicked(java.awt.event.MouseEvent evt) {                                         
        Table.clearSelection();
        SEnabled(RecipeTable.getSelectedRowCount()==1);
        SItem.setText(RecipeTable.getValueAt(RecipeTable.getSelectedRow(), 0).toString());
        NQuantityTF.setText(RecipeTable.getValueAt(RecipeTable.getSelectedRow(), 1).toString());
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddButton;
    private javax.swing.JButton AddRecipeButton;
    private javax.swing.JTable BackEnd;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton DeleteRecipeButton;
    private javax.swing.JTable IngredientsTable;
    private javax.swing.JTabbedPane InventoryPane;
    private javax.swing.JTextField ItemTF;
    private javax.swing.JTextField NQuantityTF;
    private javax.swing.JTextField QuantityTF;
    private javax.swing.JPanel RIPane;
    private javax.swing.JTextField RecipeNTF;
    private javax.swing.JPanel RecipePane;
    private javax.swing.JTable RecipeTable;
    private javax.swing.JLabel SItem;
    private javax.swing.JTable SRecipes;
    private javax.swing.JLabel SelectedItems;
    private javax.swing.JPanel SelectedPane;
    private javax.swing.JTable Table;
    private javax.swing.JButton UseRecipeButton;
    private javax.swing.JButton dec1;
    private javax.swing.JButton dec5;
    private javax.swing.JButton inc1;
    private javax.swing.JButton inc5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration                   
}
