package computerservice;

import javax.swing.JFrame;

/**
 * Η κλάση HardwareTechnician δημιουργεί τεχνικούς υλικού.
 */

public class HardwareTechnician extends Technician
{
    /**
     * Κατασκευαστής
     * @param username Όνομα χρήστη
     * @param password Κωδικός χρήστη
     * @param name Όνομα
     * @param surname Επώνυμο
     */
    public  HardwareTechnician(String username,String password,String name,String surname)
    {
        super(username,password,"Hardware Technician",name,surname);
    }

    /**
     * Δημιουργεί το γραφικό περιβάλλον του τεχνικου υλικού
     * @param frame Το παράθυρο της εφαρμογής
     */

    @Override
    public void showPanel(JFrame frame, UserList ul, TaskList tl)
    {
        TchPanel mPanel=new TchPanel(this,ul,tl,frame);
        mPanel.setVisible(true);
        frame.add(mPanel);
    }
}
