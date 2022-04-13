import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;


public class LotteryMachine extends javax.swing.JFrame
{
    DefaultListModel dlm = new DefaultListModel();
   
    String[][] customList =
    {
        {},//Pusty
        {"1", "2", "3"},//D3
        {"1", "2", "3","4","5","6"},//D6
        {"1", "2", "3","4","5","6","7","8","9","10"},//D10
        {"1", "2", "3","4","5","6","7","8","9","10","11","12"},//D12
        {"Czerwony","Żółty","Zielony","Niebieski","Fioletowy"},//Kolory
        {"Biały","Czarny"}//Czarno-biały
    };
    
    public static void main(String args[])
    {   
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new LotteryMachine().setVisible(true);
            }
        }); 
    }
    public void AddToPool()
    {
        String tempNewName = jTextField1.getText();
   
        if(dlm.size() > 0)
        {
            if(!dlm.contains(tempNewName))
            {
                dlm.addElement(tempNewName);
                CalculateChance();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Element o takiej nazwie już istnieje", "Błąd",JOptionPane.ERROR_MESSAGE);    
            }    
        }
        else
        {   
            mainList.setModel(dlm);
            dlm.addElement(tempNewName);
            CalculateChance();
        }
        
        //System.out.print(dlm.size());        
    }
    
    public void LoadPresetsPool()
    {
        DeleteAllPool();
        mainList.setModel(dlm);
        
        int currentSelectedIndex = PresetsList.getSelectedIndex();
        
        for(int i = 0; i < customList[currentSelectedIndex].length;i++)
        { 
          dlm.addElement(customList[currentSelectedIndex][i]);
        }
        
        CalculateChance();
    }
    
    public void DeleteAllPool()
    {
        
        dlm.removeAllElements();
        CalculateChance();
       
    }
    
    public void DeleteSelectedElement()
    {
        int currentSelectedIndex = mainList.getSelectedIndex();
        
        if(currentSelectedIndex != -1)
        {
            dlm.remove(currentSelectedIndex);
            CalculateChance();
        }    
    }
    
    public void CalculateChance()
    {
        double chanceValue = 0;
        
        if(dlm.size() > 0)
        {   
            chanceValue = (1/(double)dlm.size()) * 100;
        }
        
        if(chanceValue >= 10 || chanceValue == 0)
        {
            chanceText.setText(String.format("%.0f",chanceValue) + "%");
        }
        else
        {
            chanceText.setText(String.format("%.2f",chanceValue) + "%");
        }  
    }
    
    public void CalculateResult()
    {
       if(dlm.size() > 0)
       {
            Random ran = new Random();
       
            int randomScore;
       
            randomScore = ran.nextInt(dlm.size());
            JOptionPane.showMessageDialog(null, dlm.elementAt(randomScore), "Losowanie zakończone sukcesem",JOptionPane.INFORMATION_MESSAGE);
       }
       else
       {
            JOptionPane.showMessageDialog(null, "Nie wpisano żadnych wartości do losowania", "Błąd",JOptionPane.ERROR_MESSAGE);
       }
       
    }
    
    public LotteryMachine()
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainList = new javax.swing.JList<>();
        chanceText = new javax.swing.JLabel();
        RollButton = new javax.swing.JButton();
        DeleteSelected = new javax.swing.JButton();
        PresetsList = new javax.swing.JComboBox<>();
        DeleteAll = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Maszyna losująca"); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 600));

        jButton1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jButton1.setText("Dodaj do puli");
        jButton1.setActionCommand("addButton");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AddNewButton(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jTextField1.setText("Nazwa");
        jTextField1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                EnterNewPoolName(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 0, 32)); // NOI18N
        jLabel1.setText("Program do losowania");

        mainList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(mainList);

        chanceText.setFont(new java.awt.Font("Microsoft YaHei", 0, 24)); // NOI18N
        chanceText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chanceText.setText("0%");

        RollButton.setFont(new java.awt.Font("Microsoft YaHei", 0, 24)); // NOI18N
        RollButton.setText("Losuj");
        RollButton.setActionCommand("RollButton");
        RollButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RollTheResult(evt);
            }
        });

        DeleteSelected.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        DeleteSelected.setText("Usuń wybrany");
        DeleteSelected.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                DeleteSelectedActionPerformed(evt);
            }
        });

        PresetsList.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        PresetsList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pusty", "D3", "D6", "D10", "D12", "Kolory", "Czarno-biały" }));
        PresetsList.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                PresetsListActionPerformed(evt);
            }
        });

        DeleteAll.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        DeleteAll.setText("Usuń wszystko");
        DeleteAll.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                DeleteAllActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Szansa na wylosowanie:");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Gotowe wzorce");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(layout.createSequentialGroup()
                                .add(DeleteSelected)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(DeleteAll))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 333, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(79, 79, 79)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(chanceText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(RollButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 350, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(62, 62, 62)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(PresetsList, 0, 140, Short.MAX_VALUE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(9, 9, 9)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jButton1)
                            .add(PresetsList, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(29, 29, 29)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(10, 10, 10)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(DeleteSelected)
                            .add(DeleteAll)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(chanceText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(RollButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jButton1.getAccessibleContext().setAccessibleName("addButton");
        jButton1.getAccessibleContext().setAccessibleDescription("");
        jTextField1.getAccessibleContext().setAccessibleName("newPoolName");

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    private void AddNewButton(java.awt.event.ActionEvent evt)//GEN-FIRST:event_AddNewButton
    {//GEN-HEADEREND:event_AddNewButton
        AddToPool();     
    }//GEN-LAST:event_AddNewButton

    private void EnterNewPoolName(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EnterNewPoolName
    {//GEN-HEADEREND:event_EnterNewPoolName

    }//GEN-LAST:event_EnterNewPoolName

    private void RollTheResult(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RollTheResult
    {//GEN-HEADEREND:event_RollTheResult
        CalculateResult();
    }//GEN-LAST:event_RollTheResult

    private void PresetsListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_PresetsListActionPerformed
    {//GEN-HEADEREND:event_PresetsListActionPerformed
        LoadPresetsPool();
    }//GEN-LAST:event_PresetsListActionPerformed

    private void DeleteAllActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_DeleteAllActionPerformed
    {//GEN-HEADEREND:event_DeleteAllActionPerformed
        DeleteAllPool();
    }//GEN-LAST:event_DeleteAllActionPerformed

    private void DeleteSelectedActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_DeleteSelectedActionPerformed
    {//GEN-HEADEREND:event_DeleteSelectedActionPerformed
        DeleteSelectedElement();
    }//GEN-LAST:event_DeleteSelectedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteAll;
    private javax.swing.JButton DeleteSelected;
    private javax.swing.JComboBox<String> PresetsList;
    private javax.swing.JButton RollButton;
    private javax.swing.JLabel chanceText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTextField jTextField1;
    public javax.swing.JList<String> mainList;
    // End of variables declaration//GEN-END:variables
   
    
}
