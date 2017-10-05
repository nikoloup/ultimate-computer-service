
package computerservice;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ShowInProgressPanel extends javax.swing.JPanel {

    private Moderator mod;
    private TaskList tList;


    public ShowInProgressPanel(Moderator mod, TaskList tl)
    {
        this.mod = mod;
        tList = tl;
        initComponents();
    }

     private class MyTableModel extends AbstractTableModel {

        private String[] columnNames;
        private String[][] data;

        public MyTableModel()
        {
            ArrayList<Task> array=mod.printTaskRunning(tList);
            data = new String[array.size()][3];
            for (int i = 0; i < array.size(); i++) {
                data[i][0] = array.get(i).getId() + "";
                data[i][1] = array.get(i).getDescription();
                data[i][2] = array.get(i).getStatus();
            }
            columnNames = new String[3];
            columnNames[0] = "Α.Α";
            columnNames[1] = "Περιγραφή";
            columnNames[2] = "Κατάσταση";
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        retBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(472, 341));

        taskTable.setModel(new MyTableModel());
        taskTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        taskTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        taskTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(taskTable);

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
                    .addComponent(retBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1))
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
    private javax.swing.JTable taskTable;
    // End of variables declaration//GEN-END:variables

}
