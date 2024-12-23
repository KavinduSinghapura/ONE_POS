/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Model.MySQL;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class SupplierRegistration extends javax.swing.JFrame {

    Grn grn;

    private String companyId;

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String name) {
        jTextField5.setText(name);
    }

    public void getSupplierDetails(Grn grn) {
        this.grn = grn;
    }

    public SupplierRegistration() {
        initComponents();
        loadSuppliers("first_name", "ASC", "");
        jButton2.setEnabled(false);
    }

    private void loadSuppliers(String column, String orderBy, String mobile) {
        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `supplier` "
                    + "INNER JOIN `company` ON `supplier`.`company_id` = "
                    + "`company`.`id` WHERE `mobile` LIKE '" + mobile + "%' ORDER BY "
                    + "`" + column + "` " + orderBy + " ");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("company.name"));

                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search() {
        String mobile = jTextField1.getText();
        if (jComboBox1.getSelectedIndex() == 0) {
            loadSuppliers("first_name", "ASC", mobile);
        } else if (jComboBox1.getSelectedIndex() == 1) {
            loadSuppliers("first_name", "DESC", mobile);
        } else if (jComboBox1.getSelectedIndex() == 2) {
            loadSuppliers("company`.`name", "ASC", mobile);
        } else if (jComboBox1.getSelectedIndex() == 3) {
            loadSuppliers("company`.`name", "DESC", mobile);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 557));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel14.setText("Supplier Sort By:");

        jComboBox1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name A-Z", "Name Z-A", "Company A-Z", "Company Z-A" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel20.setText("Total GRN:");

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("0");

        jLabel22.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel22.setText("Pending Payments:");

        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("0");

        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "Mobile", "First Name", "Last Name", "Email", "Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 557));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("SUPPLIER REGISTRATION");

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel15.setText("Mobile");

        jTextField1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel16.setText("First Name");

        jTextField2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel17.setText("Last Name");

        jTextField3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel18.setText("Email");

        jTextField4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel19.setText("Select Company");

        jTextField5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        jButton13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton13.setText("Select");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton1.setText("Create Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel24.setText("NIC");

        jTextField6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel24))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19))
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Company_registration cr = new Company_registration(this);
        cr.setVisible(true);
        cr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String mobile = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField4.getText();
        String nic = jTextField6.getText();

        if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "supplier NIC", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "supplier mobile number", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24"
                + "|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|"
                + "65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "valid mobile number", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "supplier first name", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "supplier last name", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "supplier email", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "valid supplier email", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (companyId == null) {
            JOptionPane.showMessageDialog(this, "Please select "
                    + "company", "Warining", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `supplier`"
                        + " WHERE `mobile`='" + mobile + "' OR `email`='" + email + "'");
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "supplier "
                            + "already registered", "Warining", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.executeIUD("INSERT INTO `supplier`(`nic`,`mobile`,"
                            + "`first_name`,`last_name`,`email`,`company_id`) VALUES"
                            + "('" + nic + "','" + mobile + "','" + fname + "','" + lname + "','" + email + "','" + companyId + "')");
                    reset();
                    JOptionPane.showMessageDialog(this, "Supplier "
                            + "added", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reset() {
        jTextField6.setText("");
        jTextField6.setEditable(true);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jLabel21.setText("0");
        jLabel23.setText("0");
        loadSuppliers("first_name", "ASC", "");
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String mobile = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField4.getText();
        String nic = jTextField6.getText();

        if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "supplier first name", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "supplier last name", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "supplier email", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Please enter "
                    + "valid supplier email", "Warining", JOptionPane.WARNING_MESSAGE);
        } else if (companyId == null) {
            JOptionPane.showMessageDialog(this, "Please select "
                    + "company", "Warining", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `supplier`"
                        + " WHERE `nic`='" + nic + "' AND `email`='" + email + "' AND `mobile`='" + mobile + "'"
                        + "AND `first_name`='" + fname + "' AND `last_name`='" + lname + "'"
                        + "AND `company_id`='" + companyId + "'");
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Same details! "
                            + "supplier available", "Warining", JOptionPane.WARNING_MESSAGE);
                } else {

                    MySQL.executeIUD("UPDATE `supplier` SET `mobile`='" + mobile + "', `first_name`="
                            + "'" + fname + "',`last_name`='" + lname + "',"
                            + "`email`='" + email + "',`company_id` = '" + companyId + "' WHERE "
                            + "`nic`='" + nic + "'");
                    reset();
                    JOptionPane.showMessageDialog(this, "Supplier "
                            + "Updated", "Warining", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();

        jButton2.setEnabled(true);

        jTextField6.setText(String.valueOf(jTable1.getValueAt(row, 0)));
        jTextField6.setEditable(false);
        jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 1)));
        jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 2)));
        jTextField3.setText(String.valueOf(jTable1.getValueAt(row, 3)));
        jTextField4.setText(String.valueOf(jTable1.getValueAt(row, 4)));
        jTextField5.setText(String.valueOf(jTable1.getValueAt(row, 5)));
        jButton1.setEnabled(false);

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `grn`"
                    + "INNER JOIN `grn_item` ON `grn`.`id`=`grn_item`.`grn_id`"
                    + "WHERE `grn`.`supplier_nic`= '" + String.valueOf(jTable1.getValueAt(row, 0)) + "'");

            double total = 0;

            HashMap<Integer, Double> grnCount = new HashMap<>();

            while (resultSet.next()) {
                double qty = resultSet.getDouble("grn_item.qty");
                double buyingPrice = resultSet.getDouble("grn_item.price");
                double itemTotal = qty * buyingPrice;

                total += itemTotal;

                grnCount.put(resultSet.getInt("grn_id"), resultSet.getDouble("paid_amount"));
            }

            double totalPaid = 0;

            for (double paid : grnCount.values()) {
                totalPaid += paid;
            }

            jLabel21.setText(String.valueOf(grnCount.size()));
            jLabel23.setText(String.valueOf(total - totalPaid));

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (evt.getClickCount() == 2) {
            if (grn != null) {
                String supplierName = String.valueOf(jTable1.getValueAt(row, 2));
                String supplierNIC = String.valueOf(jTable1.getValueAt(row, 0));

                grn.setSupplierDetails(supplierName, supplierNIC);
                this.dispose();
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        search();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        search();
    }//GEN-LAST:event_jTextField1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
