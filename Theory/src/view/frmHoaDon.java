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
public class frmHoaDon extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmHoaDon
     */
     public void getHoaDon() {

        try {

            DefaultTableModel dt = (DefaultTableModel) tbHoaDon.getModel();
            dt.setRowCount(0);
            DatabaseHelper cn = new DatabaseHelper();
            // Create a JTable model to store the retrieved data
            System.out.println("Connected mySQL success");
            Object[] argv = new Object[0];
            try (ResultSet resultSet = cn.selectQuery("SELECT *  FROM HoaDon", argv)) {
                // Create a JTable model to store the retrieved data
                System.out.println("Ket noi ok" + resultSet);
                while (resultSet.next()) {
                    Vector v = new Vector();
                    v.add(resultSet.getString("Mahd")); // id
                    v.add(resultSet.getString("Manv"));// name    
                    v.add(resultSet.getString("Makh")); // create_time                   
                     v.add(resultSet.getString("Ngaytao")); // create_time    
                    v.add(resultSet.getString("Tienban"));
                    v.add(resultSet.getString("Giamgia"));
                    v.add(resultSet.getString("Thanhtoan"));
                    dt.addRow(v);

                }

                cn.close();
            }

        } catch (Exception e) {
        }

    }   
    
    public int insertHoaDon() {
        // ID is Auto inc
        String id = txtID.getText();
        String manv = txtIdnv.getText();       
        String makh = txtIdkh.getText();
        String ngay = txtDate.getText();
        String tienban = txtTienban.getText();
        String giamgia = txtGiamgia.getText();
        String thanhtoan = txtThanhtoan.getText();
        Object[] argv = new Object[7];
        
        argv[0] = Integer.parseInt(id);
        argv[1] = manv;
        argv[2] = makh;       
        argv[3] = ngay; 
        argv[4] = tienban; 
        argv[5] = giamgia; 
        argv[6] = thanhtoan; 
        
      
        try {

            DatabaseHelper cn = new DatabaseHelper();
            int rs = cn.executeQuery("INSERT INTO HoaDon (Mahd,Manv,Makh,Ngaytao,Tienban,Giamgia,Thanhtoan) VALUES (?,?,?,?,?,?,?)", argv);
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
    public int updateHoaDon() {
        // ID is Auto inc
         // ID is Auto inc
         // ID is Auto inc
        String id = txtID.getText();
        String manv = txtIdnv.getText();       
        String makh = txtIdkh.getText();
        String ngay = txtDate.getText();
        String tienban = txtTienban.getText();
        String giamgia = txtGiamgia.getText();
        String thanhtoan = txtThanhtoan.getText();
        Object[] argv = new Object[7];
        
        
        argv[0] = manv;
        argv[1] = makh;       
        argv[2] = ngay; 
        argv[3] = tienban; 
        argv[4] = giamgia; 
        argv[5] = thanhtoan; 
        argv[6] = Integer.parseInt(id);
       
        try {
            DatabaseHelper cn = new DatabaseHelper();
            int rs = cn.executeQuery("UPDATE HoaDon SET Manv=?,Makh=?, Ngaytao=?,Tienban=?,Giamgia=?,Thanhtoan=? WHERE Mahd =?", argv);
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
    public int deleteHoaDon() {
        // ID is Auto inc
        String id = txtID.getText();     
        Object[] argv = new Object[1];
        argv[0] = Integer.parseInt(id);
        try {
            DatabaseHelper cn = new DatabaseHelper();
            int rs = cn.executeQuery("DELETE FROM HoaDon WHERE Mahd =?", argv);
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
        txtIdnv.setText("");
        txtIdkh.setText("");
        txtDate.setText("");
        txtTienban.setText("");
        txtGiamgia.setText(""); 
        txtThanhtoan.setText("");
    }
    public frmHoaDon() {
        initComponents();
        getHoaDon();
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
        txtDate = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtIdnv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnLoadData = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtIdkh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGiamgia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTienban = new javax.swing.JTextField();
        txtThanhtoan = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);

        jLabel4.setText("Mã nhân viên ");

        jLabel1.setText("Mã hóa đơn");

        jLabel3.setText("Ngày tạo ");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

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

        txtIdnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdnvActionPerformed(evt);
            }
        });

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn ", "Mã nhân viên ", "Mã khách hàng ", "Ngày tạo ", "Tiền bán (đ)", "Giảm giá (%) ", "Thanh toán (đ)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbHoaDon.setDragEnabled(true);
        tbHoaDon.setShowGrid(true);
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

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

        jLabel2.setText("Mã khách hàng ");

        txtIdkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdkhActionPerformed(evt);
            }
        });

        jLabel5.setText("Tiền bán ");

        jLabel6.setText("Giảm giá ");

        jLabel7.setText("Thanh toán ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAdd))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnExit)
                                .addGap(65, 65, 65)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(btnLoadData)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(113, 113, 113)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(255, 255, 255)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(37, 37, 37)
                                        .addComponent(txtTienban, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIdnv)
                                            .addComponent(txtIdkh)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGiamgia, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(txtThanhtoan))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdnv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtGiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTienban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdkh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnUpdate)
                    .addComponent(btnLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        insertHoaDon();
        getHoaDon();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
       this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        deleteHoaDon();
        getHoaDon();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // TODO add your handling code here:
        //mouse click load text field to data
        int i = tbHoaDon.getSelectedRow();
        String id = tbHoaDon.getValueAt(i, 0).toString();
        String manv = tbHoaDon.getValueAt(i, 1).toString();   
        String makh = tbHoaDon.getValueAt(i, 2).toString();       
        String ngaytao = tbHoaDon.getValueAt(i, 3).toString(); 
        String tienban = tbHoaDon.getValueAt(i, 3).toString();  
        String giamgia = tbHoaDon.getValueAt(i, 3).toString();  
        String thanhtoan = tbHoaDon.getValueAt(i, 3).toString();  
        txtID.setText(id);
        txtIdnv.setText(manv);     
        txtIdkh.setText(makh);        
        txtDate.setText(ngaytao);
        txtTienban.setText(tienban);
        txtGiamgia.setText(giamgia);
        txtThanhtoan.setText(thanhtoan);
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         updateHoaDon();
        getHoaDon();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        // TODO add your handling code here:
        getHoaDon();
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void txtIdkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdkhActionPerformed

    private void txtIdnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdnvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdnvActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed


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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtGiamgia;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdkh;
    private javax.swing.JTextField txtIdnv;
    private javax.swing.JTextField txtThanhtoan;
    private javax.swing.JTextField txtTienban;
    // End of variables declaration//GEN-END:variables
}
