
package computerservice;

import computerservice.Email.DefaultAuthenticator;
import computerservice.Email.Email;
import computerservice.Email.EmailException;
import computerservice.Email.SimpleEmail;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InformClientPanel extends javax.swing.JPanel {

    /** Creates new form InformClientPanel */
    private TaskList tList;
    private Secretary secr;
    private int id;

    public InformClientPanel(TaskList tList, Secretary secr) {
        id = -1;
        this.tList = tList;
        this.secr = secr;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        okBtn = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        archBtn = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();
        warningLabel2 = new javax.swing.JLabel();
        mailBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(472, 341));

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 16));
        idLabel.setText("Α.Α");

        idField.setFont(new java.awt.Font("Tahoma", 0, 16));

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        titleLabel.setForeground(new java.awt.Color(51, 51, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Ενημέρωση & Αρχειοθέτηση");

        okBtn.setFont(new java.awt.Font("Tahoma", 1, 14));
        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        archBtn.setText("Αρχειοθέτηση");
        archBtn.setEnabled(false);
        archBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archBtnActionPerformed(evt);
            }
        });

        warningLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        warningLabel.setForeground(new java.awt.Color(255, 0, 0));
        warningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        warningLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        warningLabel2.setForeground(new java.awt.Color(255, 0, 0));
        warningLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mailBtn.setText("Αποστολή E-mail");
        mailBtn.setEnabled(false);
        mailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mailLabel)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(phoneLabel)
                            .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(okBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(warningLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mailBtn)
                                            .addComponent(archBtn))))
                                .addGap(29, 29, 29))))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {mailLabel, nameLabel, phoneLabel, surnameLabel});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {archBtn, mailBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(okBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phoneLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mailLabel)
                    .addComponent(mailBtn))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(archBtn)
                    .addComponent(warningLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {mailLabel, nameLabel, phoneLabel, surnameLabel});

    }// </editor-fold>//GEN-END:initComponents

    private void archBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archBtnActionPerformed
        if (id==-1)
        {
            warningLabel2.setText("Δεν δόθηκε επιλογή.");
        }
        else
        {
            secr.setTaskArchive(tList, id);
            tList.Save();
            JOptionPane.showMessageDialog(null, "Η εργασία αρχειοθετήθηκε.","Information", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
    }//GEN-LAST:event_archBtnActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        try{
            String temp = idField.getText();
            id = Integer.parseInt(temp);
            if(tList.getTask(id).getStatus().equals("Ολοκληρωμένη"))
            {
                nameLabel.setText(tList.getTask(id).getName());
                surnameLabel.setText(tList.getTask(id).getSurname());
                phoneLabel.setText(tList.getTask(id).getPhone());
                mailLabel.setText(tList.getTask(id).getEmail());
                archBtn.setEnabled(true);
                mailBtn.setEnabled(true);
            }
            else
            {
                warningLabel.setText("Εργασία μη ολοκληρωμένη.");
            }
        }
        catch(NullPointerException e)
        {
                warningLabel.setText("Λανθασμένο id");
        }
        catch(NumberFormatException f){
                warningLabel.setText("Λανθασμένο id");
        }
        catch(ArrayIndexOutOfBoundsException g){
                warningLabel.setText("Λανθασμένο id");
        }
    }//GEN-LAST:event_okBtnActionPerformed

    private void mailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailBtnActionPerformed
        if (id==-1)
        {
            warningLabel2.setText("Δεν δόθηκε επιλογή.");
        }
        else
        {
            sendMail();
        }
    }//GEN-LAST:event_mailBtnActionPerformed

    private void sendMail()
    {
            String mailadd = tList.getTask(id).getEmail();
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("computerservice.csd", "19181944"));
            email.setTLS(true);
            try
            {
            email.setFrom("computerservice.csd@gmail.com", "ComputerService Solutions");
            email.setSubject("Ενημέρωση για παραλαβή υπολογιστή");
            email.setCharset("iso-8859-7");
            email.setMsg("Κύριε/α " + tList.getTask(id).getSurname() + ", \n\nΟ υπολογιστής σας έχει επισκευαστεί. Παρακαλούμε περάστε από το κατάστημα μας για να τον παραλάβετε.\n\nΜε εκτίμηση, \nComputerService");
            email.addTo(mailadd);
            email.send();
            JOptionPane.showMessageDialog(null, "Το e-mail στάλθηκε.","Information", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(EmailException ex)
            {
                warningLabel2.setText("Πρόβλημα στην αποστολή e-mail.");
            }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton archBtn;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton mailBtn;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okBtn;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JLabel warningLabel2;
    // End of variables declaration//GEN-END:variables

}