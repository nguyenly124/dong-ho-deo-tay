/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;
import database.DatabaseHelper;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MY PC
 */
public class frmKhachHang extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmKhachHang
     */
     public void getKhachHang() {

        try {

            DefaultTableModel dt = (DefaultTableModel) tbKhachHang.getModel();
            dt.setRowCount(0);
            DatabaseHelper cn = new DatabaseHelper();
            // Create a JTable model to store the retrieved data
            System.out.println("Connected mySQL success");
            Object[] argv = new Object[0];
            try (ResultSet resultSet = cn.selectQuery("SELECT *  FROM KhachHang", argv)) {
                // Create a JTable model to store the retrieved data
                System.out.println("Ket noi ok" + resultSet);
                while (resultSet.next()) {
                    Vector v = new Vector();
                    v.add(resultSet.getString("Makh")); // id
                    v.add(resultSet.getString("Tenkh"));// name    
                    v.add(resultSet.getString("Diachi")); // create_time                   
                    v.add(resultSet.getString("Sodt")); // create_time  
                    v.add(resultSet.getString("Gioitinh"));
                    v.add(resultSet.getString("Luotmua"));
                    dt.addRow(v);
                }

                cn.close();
            }

        } catch (Exception e) {
        }

    }   
    
    public int insertKhachHang() {
        // ID is Auto inc
        String id = txtID.getText();
        String name = txtName.getText();       
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String Gioitinh = txtGt.getText();
        String Luotmua = txtLuotmua.getText();
        Object[] argv = new Object[6];
        
        argv[1] = name;
        argv[2] = address;       
        argv[3] = phone; 
        argv[4] = Gioitinh; 
        argv[5] = Luotmua; 
        argv[0] = Integer.parseInt(id);
      
        try {

            DatabaseHelper cn = new DatabaseHelper();
            int rs = cn.executeQuery("INSERT INTO KhachHang (Makh,Tenkh,Diachi,Sodt,Gioitinh,Luotmua) VALUES (?,?,?,?,?,?)", argv);
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Thêm mới thành công dữ liệu id:"+id);
                clearText();
            }
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại dữ liệu id:"+id+ e);                
            System.out.println(e);
            return 0;
        }

    }
    public int updateKhachHang() {
        // ID is Auto inc
         // ID is Auto inc
         // ID is Auto inc
        String id = txtID.getText();
        String name = txtName.getText();       
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String Gioitinh = txtGt.getText();
        String Luotmua = txtLuotmua.getText();
        Object[] argv = new Object[6];
       
        argv[0] = name;
        argv[1] = address;       
        argv[2] = phone; 
        argv[3] = Gioitinh; 
        argv[4] = Luotmua; 
        argv[5] = Integer.parseInt(id);
        try {
            DatabaseHelper cn = new DatabaseHelper();
            int rs = cn.executeQuery("UPDATE KhachHang SET Tenkh=?,Diachi=?, Sodt=?,Gioitinh=?,Luotmua=? WHERE Makh =?", argv);
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công dữ liệu id:"+id);
                clearText();
            }
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại dữ liệu id:"+id +", error detail:"+ e );                 
            System.out.println(e);
            return 0;
        }

    }
    public int deleteKhachHang() {
        // ID is Auto inc
        String id = txtID.getText();     
        Object[] argv = new Object[1];
        argv[0] = Integer.parseInt(id);
        try {
            DatabaseHelper cn = new DatabaseHelper();
            int rs = cn.executeQuery("DELETE FROM KhachHang WHERE Makh =?", argv);
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công dữ liệu id:"+id);
                clearText();
            }            
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại dữ liệu id:"+id +", error detail:"+ e );                 
            System.out.println(e);
            return 0;
        }

    }
    public void clearText() {
        txtID.setText("");
        txtName.setText("");
        txtAddress.setText("");  
        txtPhone.setText("");
        txtGt.setText("");
        txtLuotmua.setText("");
    }
    public frmKhachHang() {
        initComponents();
        getKhachHang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnLoadData = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        txtGt = new javax.swing.JTextField();
        txtLuotmua = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jLabel4.setText("Địa chỉ");

        jLabel1.setText("Mã khách hàng");

        jLabel3.setText("Tên khách hàng");

        btnAdd.setText("Thêm mới");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Giới tính", "Lượt mua"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbKhachHang.setDragEnabled(true);
        tbKhachHang.setShowGrid(true);
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnLoadData.setText("Làm mới");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });

        jLabel2.setText("Số điện thoại");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtLuotmua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuotmuaActionPerformed(evt);
            }
        });

        jLabel5.setText("Lượt mua");

        jLabel6.setText("Giới tính ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(btnLoadData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(72, 72, 72)
                .addComponent(btnUpdate)
                .addGap(62, 62, 62)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btnExit)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGt)
                    .addComponent(txtName)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLuotmua)
                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(txtAddress))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuotmua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(54, 54, 54)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd)
                    .addComponent(btnLoadData))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addGap(194, 194, 194)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        insertKhachHang();
        getKhachHang();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
       this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        deleteKhachHang();
        getKhachHang();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        // TODO add your handling code here:
        //mouse click load text field to data
        int i = tbKhachHang.getSelectedRow();
        String id = tbKhachHang.getValueAt(i, 0).toString();
        String name = tbKhachHang.getValueAt(i, 1).toString();   
        String address = tbKhachHang.getValueAt(i, 2).toString();       
        String phone = tbKhachHang.getValueAt(i, 3).toString();  
        String Gioitinh = tbKhachHang.getValueAt(i, 4).toString();
        String Luotmua = tbKhachHang.getValueAt(i, 5).toString();
        txtID.setText(id);
        txtName.setText(name);     
        txtAddress.setText(address);        
        txtPhone.setText(phone);   
        txtGt.setText(Gioitinh);  
        txtLuotmua.setText(Luotmua);  

    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         updateKhachHang();
        getKhachHang();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        // TODO add your handling code here:
        getKhachHang();
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtLuotmuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuotmuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuotmuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtGt;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLuotmua;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
