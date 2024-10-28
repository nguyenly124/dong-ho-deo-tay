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
public class frmSanPham extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmSanPhamSanPham
     */
     public void getSanPham() {

        try {

            DefaultTableModel dt = (DefaultTableModel) tbSanPham.getModel();
            dt.setRowCount(0);
            DatabaseHelper cn = new DatabaseHelper();
            // Create a JTable model to store the retrieved data
            System.out.println("Connected mySQL success");
            Object[] argv = new Object[0];
            try (ResultSet resultSet = cn.selectQuery("SELECT *  FROM SanPham", argv)) {
                // Create a JTable model to store the retrieved data
                System.out.println("Ket noi ok" + resultSet);
                while (resultSet.next()) {
                    Vector v = new Vector();
                    v.add(resultSet.getString("Masp")); // id
                    v.add(resultSet.getString("Tensp"));// name    
                    v.add(resultSet.getString("Soluong")); // create_time                   
                     v.add(resultSet.getString("Gianhap")); // create_time  
                     v.add(resultSet.getString("Giaban"));
                     v.add(resultSet.getString("Hang"));
                     v.add(resultSet.getString("Mota"));
                    dt.addRow(v);

                }

                cn.close();
            }

        } catch (Exception e) {
        }

    }   
    
    public int insertSanPham() {
        // ID is Auto inc
        String id = txtID.getText();
        String name = txtName.getText();    
        String Soluong = txtSoluong.getText();
        String Gianhap = txtGianhap.getText();
        String Giaban = txtGiaban.getText();
        String Hang = txtHang.getText();
        String Mota = txtMota.getText();
        Object[] argv = new Object[7];
        
        argv[0] = Integer.parseInt(id);
        argv[1] = name;
        argv[2] = Soluong;
        argv[3] = Gianhap;
        argv[4] = Giaban;
        argv[5] = Hang;
        argv[6] = Mota;
      
        try {

            DatabaseHelper cn = new DatabaseHelper();
            int rs = cn.executeQuery("INSERT INTO SanPham (Masp,Tensp,Soluong,Gianhap,Giaban,Hang,Mota) VALUES (?,?,?,?,?,?,?)", argv);
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
    public int updateSanPham() {
        // ID is Auto inc
         // ID is Auto inc
         // ID is Auto inc
        String id = txtID.getText();
        String name = txtName.getText();    
        String Soluong = txtSoluong.getText();
        String Gianhap = txtGianhap.getText();
        String Giaban = txtGiaban.getText();
        String Hang = txtHang.getText();
        String Mota = txtMota.getText();
        Object[] argv = new Object[7];
        
        
        argv[0] = name;
        argv[1] = Soluong;
        argv[2] = Gianhap;
        argv[3] = Giaban;        
        argv[4] = Hang;
        argv[5] = Mota;
        argv[6] = Integer.parseInt(id);
       
        try {
            DatabaseHelper cn = new DatabaseHelper();
            int rs = cn.executeQuery("UPDATE SanPham SET Tensp=?,Soluong=?, Gianhap=?,Giaban=?,Hang=?,Mota=? WHERE Masp =?", argv);
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
    public int deleteSanPham() {
        // ID is Auto inc
        String id = txtID.getText();     
        Object[] argv = new Object[1];
        argv[0] = Integer.parseInt(id);
        try {
            DatabaseHelper cn = new DatabaseHelper();
            int rs = cn.executeQuery("DELETE FROM SanPham WHERE Masp =?", argv);
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
        txtSoluong.setText("");
        txtGianhap.setText("");    
        txtGiaban.setText("");
        txtHang.setText("");
        txtMota.setText("");
    }
    public frmSanPham() {
        initComponents();
        getSanPham();
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
        txtGianhap = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnLoadData = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtGiaban = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextPane();

        setClosable(true);
        setResizable(true);

        jLabel4.setText("Giá nhập ");

        jLabel1.setText("Mã sản phẩm ");

        jLabel3.setText("Tên sản phẩm ");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
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

        txtGianhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGianhapActionPerformed(evt);
            }
        });

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm ", "Tên sản phẩm ", "Số lượng", "Giá nhập ", "Giá bán ", "Hãng ", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbSanPham.setDragEnabled(true);
        tbSanPham.setShowGrid(true);
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);

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

        jLabel2.setText("Giá bán ");

        txtGiaban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiabanActionPerformed(evt);
            }
        });

        jLabel5.setText("Số lượng");

        jLabel6.setText("Hãng");

        jLabel7.setText("Mô tả");

        jScrollPane2.setViewportView(txtMota);

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
                    .addComponent(jLabel5))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHang, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 298, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(39, 39, 39)
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
        insertSanPham();
        getSanPham();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
       this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        deleteSanPham();
        getSanPham();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        // TODO add your handling code here:
        //mouse click load text field to data
        int i = tbSanPham.getSelectedRow();
        String id = tbSanPham.getValueAt(i,0).toString();
        String name = tbSanPham.getValueAt(i,1).toString();
        String Soluong = tbSanPham.getValueAt(i, 2).toString(); 
         String Gianhap = tbSanPham.getValueAt(i,3).toString();
        String Giaban = tbSanPham.getValueAt(i,4).toString();    
                   
        String Hang = tbSanPham.getValueAt(i,5).toString();   
        String Mota = tbSanPham.getValueAt(i,6).toString();  
        
        txtID.setText(id);
        txtName.setText(name);     
        txtSoluong.setText(Soluong);        
        txtGianhap.setText(Gianhap);    
        txtGiaban.setText(Giaban);    
        txtHang.setText(Hang);   
        txtMota.setText(Mota);    
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         updateSanPham();
        getSanPham();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        // TODO add your handling code here:
        getSanPham();
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void txtGiabanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiabanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiabanActionPerformed

    private void txtGianhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGianhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGianhapActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed


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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtGiaban;
    private javax.swing.JTextField txtGianhap;
    private javax.swing.JTextField txtHang;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextPane txtMota;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSoluong;
    // End of variables declaration//GEN-END:variables
}
