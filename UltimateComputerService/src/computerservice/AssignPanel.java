
package computerservice;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AssignPanel extends javax.swing.JPanel {

    private Moderator mod;
    private UserList uList;
    private TaskList tList;

    /** Creates new form AssignPanel */
    public AssignPanel(Moderator mod, UserList ul, TaskList tl) {
        this.mod = mod;
        uList = ul;
        tList = tl;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        idBut = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        assignLabel = new javax.swing.JLabel();
        sTech = new javax.swing.JRadioButton();
        hTech = new javax.swing.JRadioButton();
        okButton = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(472, 341));

        idBut.setFont(new java.awt.Font("Tahoma", 0, 16));
        idBut.setText("Α.Α");

        idField.setFont(new java.awt.Font("Tahoma", 0, 16));

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(51, 51, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Ανάθεση εργασιών");

        assignLabel.setFont(new java.awt.Font("Tahoma", 0, 16));
        assignLabel.setText("Ανάθεση σε");

        buttonGroup1.add(sTech);
        sTech.setText("Τεχνικός λογισμικού");

        buttonGroup1.add(hTech);
        hTech.setText("Τεχνικός υλικού");

        okButton.setFont(new java.awt.Font("Tahoma", 0, 18));
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        warningLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(204, 0, 0));
        warningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(idBut, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(assignLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sTech)
                        .addGap(37, 37, 37)
                        .addComponent(hTech)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idBut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hTech)
                    .addComponent(sTech))
                .addGap(34, 34, 34)
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {idBut, idField});

    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String index = null;
        int id = -1;
        try {
            index = idField.getText();
            id = Integer.parseInt(index);
            if (id < tList.getSize() && tList.getTask(new Integer(id)).getStatus().equals("Ανοιχτή")) {
                if (sTech.isSelected()) {
                    if(mod.assignTask(tList, uList, id, true))
                    {
                    this.setVisible(false);
                    tList.Save();
                    uList.Save();
                    JOptionPane.showMessageDialog(null, "Η εργασία ανατέθηκε.");
                    }
                    else
                    {
                        warningLabel.setText("Δεν υπάρχει τεχνικός λογισμικού.");
                    }
                } else if (hTech.isSelected()) {
                    if(mod.assignTask(tList, uList, id, false))
                    {
                    this.setVisible(false);
                    tList.Save();
                    uList.Save();
                    JOptionPane.showMessageDialog(null, "Η εργασία ανατέθηκε.","Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        warningLabel.setText("Δεν υπάρχει τεχνικός υλικού.");
                    }
                } else
                    warningLabel.setText("Παρακαλώ επιλέξτε έναν τύπο τεχνικού!");
            } else {
                idField.setText("");
                warningLabel.setText("Παρακαλώ εισάγετε έναν εγκυρο αριθμό!");
            }
        } catch (NullPointerException e) {
            warningLabel.setText("Υπάρχουν κενά πεδία!");
        } catch (NumberFormatException ex) {
            warningLabel.setText("Παρακαλώ εισάγετε έναν εγκυρο αριθμό!");
        }
    }//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assignLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton hTech;
    private javax.swing.JLabel idBut;
    private javax.swing.JTextField idField;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton sTech;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
