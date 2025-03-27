package GUI.adminView;

import BUS.AccountBUS;
import DTO.AccountDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import GUI.swing.ModelCard;
import GUI.ScrollBarTable;
import GUI.TableModel.TableModel;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

public class PanelAccount extends javax.swing.JPanel {

    private int selectedRow = -1;
    private ArrayList<AccountDTO> accounts;
    private AccountBUS accountBUS;
    private boolean openExcel;

    public PanelAccount() {
        initComponents();

        accountBUS = new AccountBUS();

        setLayout(new BorderLayout());
        ScrollBarTable.setScrollBarTable(jScrollPane1);
        setData();
        setForm(panelMain);

        lbAdd.setSvgImage("add", 32, 32);
        lbRemove.setSvgImage("remove", 32, 32);
        lbEdit.setSvgImage("edit", 32, 32);
        lbExcel.setSvgImage("excel", 32, 32);
        lbRemove.setEnabled(false);
        lbEdit.setEnabled(false);

        lbImport.setSvgImage("import", 32, 32);
        lbExport.setSvgImage("export", 32, 32);
        openExcel = false;
        lbImport.setVisible(openExcel);
        lbExport.setVisible(openExcel);
    }

    private void setForm(Component com) {
        this.removeAll();
        this.add(com);
        this.repaint();
        this.revalidate();
    }

    private void setData() {
        accounts = (new AccountBUS()).getAll();
        DefaultTableModel model = TableModel.getAccount(accounts);
        table1.setModel(model);
        cardSummary1.setModel(new ModelCard("account-card", "Số tài khoản", Integer.toString(accounts.size()), Color.decode("#ea728c")));

    }

    private void setModelTable(ArrayList<AccountDTO> arr) {
        DefaultTableModel model = TableModel.getAccount(arr);
        table1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        cardSummary1 = new GUI.component.CardSummary();
        panelTable1 = new GUI.component.PanelRoundRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new GUI.component.Table();
        lbAdd = new GUI.component.Svg();
        lbRemove = new GUI.component.Svg();
        lbEdit = new GUI.component.Svg();
        cbxOrder = new GUI.component.Combobox();
        jLabel1 = new javax.swing.JLabel();
        searchBar1 = new GUI.component.SearchBar();
        cbxSearch = new GUI.component.Combobox();
        lbExcel = new GUI.component.Svg();
        lbImport = new GUI.component.Svg();
        lbExport = new GUI.component.Svg();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.setPreferredScrollableViewportSize(new java.awt.Dimension(818, 400));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout panelTable1Layout = new javax.swing.GroupLayout(panelTable1);
        panelTable1.setLayout(panelTable1Layout);
        panelTable1Layout.setHorizontalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelTable1Layout.setVerticalGroup(
            panelTable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTable1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        lbRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRemoveMouseClicked(evt);
            }
        });

        cbxOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID (Tăng dần)", "ID (Giảm dần)", "Giáo viên", "Học sinh", "Admin" }));
        cbxOrder.setPreferredSize(new java.awt.Dimension(215, 35));
        cbxOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Order By");
        jLabel1.setToolTipText("");

        searchBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBar1MouseClicked(evt);
            }
        });

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã tài khoản", "Tên tài khoản" }));
        cbxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSearchActionPerformed(evt);
            }
        });

        lbExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExcelMouseClicked(evt);
            }
        });

        lbImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImportMouseClicked(evt);
            }
        });

        lbExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelTable1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMainLayout.createSequentialGroup()
                            .addComponent(searchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelMainLayout.createSequentialGroup()
                            .addComponent(lbExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbImport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lbAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardSummary1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(lbAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(lbRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addComponent(lbExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbImport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbExport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        selectedRow = table1.getSelectedRow();
        if (selectedRow != -1) {
            lbRemove.setEnabled(true);
            lbEdit.setEnabled(true);
        } else {
            lbRemove.setEnabled(false);
            lbEdit.setEnabled(false);
        }
    }//GEN-LAST:event_table1MouseClicked

    private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        int selected = table1.getSelectedRow();
        int id = (int) table1.getModel().getValueAt(selected, 0);
        setData();
    }//GEN-LAST:event_lbRemoveMouseClicked

    private void cbxOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderActionPerformed
        if (cbxOrder.getSelectedIndex() == 0) {
            Collections.sort(accounts, (AccountDTO s1, AccountDTO s2) -> {
                if (s1.getAccounId() < s2.getAccounId()) {
                    return -1;
                } else if (s1.getAccounId() > s2.getAccounId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(accounts);
        }
        if (cbxOrder.getSelectedIndex() == 1) {
            Collections.sort(accounts, (AccountDTO s1, AccountDTO s2) -> {
                if (s1.getAccounId() > s2.getAccounId()) {
                    return -1;
                } else if (s1.getAccounId() < s2.getAccounId()) {
                    return 1;
                }
                return 0;
            });
            setModelTable(accounts);
        }
        if (cbxOrder.getSelectedIndex() == 2) {
            accounts = accountBUS.getAllTeachers();
            setModelTable(accounts);
        }
        if (cbxOrder.getSelectedIndex() == 3) {
            accounts = accountBUS.getAllStudents();
            setModelTable(accounts);
        }
        if (cbxOrder.getSelectedIndex() == 4) {
            accounts = accountBUS.getAllAdmin();
            setModelTable(accounts);
        }
    }//GEN-LAST:event_cbxOrderActionPerformed

    private void searchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBar1MouseClicked
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(accountBUS.findById(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(accountBUS.find(txt));
            return;
        }
    }//GEN-LAST:event_searchBar1MouseClicked

    private void cbxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSearchActionPerformed
        int selected = cbxSearch.getSelectedIndex();
        String txt = searchBar1.getText();
        if (selected == 0) {
            setModelTable(accountBUS.findById(txt));
            return;
        }
        if (selected == 1) {
            setModelTable(accountBUS.find(txt));
            return;
        }
    }//GEN-LAST:event_cbxSearchActionPerformed

    private void lbImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImportMouseClicked

    }//GEN-LAST:event_lbImportMouseClicked

    private void lbExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExportMouseClicked
        if (lbExport.isVisible()) {

        }
    }//GEN-LAST:event_lbExportMouseClicked

    private void lbExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExcelMouseClicked
        openExcel = !openExcel;
        lbImport.setVisible(openExcel);
        lbExport.setVisible(openExcel);
    }//GEN-LAST:event_lbExcelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.component.CardSummary cardSummary1;
    private GUI.component.Combobox cbxOrder;
    private GUI.component.Combobox cbxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.component.Svg lbAdd;
    private GUI.component.Svg lbEdit;
    private GUI.component.Svg lbExcel;
    private GUI.component.Svg lbExport;
    private GUI.component.Svg lbImport;
    private GUI.component.Svg lbRemove;
    private javax.swing.JPanel panelMain;
    private GUI.component.PanelRoundRect panelTable1;
    private GUI.component.SearchBar searchBar1;
    private GUI.component.Table table1;
    // End of variables declaration//GEN-END:variables
}
