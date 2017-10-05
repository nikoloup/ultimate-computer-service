
package computerservice;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ShowUsersPanel extends javax.swing.JPanel {

    /** Creates new form ShowUsersPanel */
    private UserList uList;
    private Administrator adm;

    public ShowUsersPanel(UserList uList, Administrator admin) {
        this.uList = uList;
        adm = admin;
        initComponents();
    }

     private class MyTableModel extends AbstractTableModel {

        private String[] columnNames;
        private String[][] data;

        public MyTableModel() {
            ArrayList<User> array=adm.showUsers(uList);
            data = new String[array.size()][5];
            for (int i = 0; i < array.size(); i++) {
                data[i][0] = array.get(i).getUsername();
                data[i][1] = array.get(i).getPassword();
                data[i][2] = array.get(i).getName();
                data[i][3] = array.get(i).getSurname();
                data[i][4] = array.get(i).getType();
            }
            columnNames = new String[5];
            columnNames[0] = "Username";
            columnNames[1] = "Password";
            columnNames[2] = "Όνομα";
            columnNames[3] = "Επώνυμο";
            columnNames[4] = "Τύπος χρήστη";
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        usrTable = new javax.swing.JTable();
        retBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(472, 341));

        usrTable.setModel(new MyTableModel());
        jScrollPane1.setViewportView(usrTable);

        retBtn.setText("Επιστροφή");
        retBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(retBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(retBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void retBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_retBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton retBtn;
    private javax.swing.JTable usrTable;
    // End of variables declaration//GEN-END:variables

}
