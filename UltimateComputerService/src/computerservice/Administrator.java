package computerservice;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Η κλάση Administrator δημιουργεί διαχειριστές.
 */

public class Administrator extends User
{

    /**
     * Κατασκευαστής
     * @param username Όνομα διαχειριστή
     * @param password Κωδικός διαχειριστή
     * @param name Όνομα
     * @param surname Επώνυμο
     */
    public Administrator(String username, String password,String name,String surname)
    {
        super (username,password,"Administrator",name,surname);
    }

    /**
     * Προσθήκη χρήστη στη λίστα χρηστών
     * @param username Όνομα χρήστη
     * @param password Κωδικος χρήστη
     * @param type Τύπος χρήστη
     * @param list Αντικείμενο λίστας χρηστών
     * @param name Όνομα
     * @param surname Επώνυμο
     * @return Επιστρέφει μια boolean μεταβλητή για επιτυχία/αποτυχία προσθήκης
     */

    public boolean addUser(String username, String password,String name,String surname, String type,UserList list)
    {
        if (type.equals("Administrator"))
        {
            Administrator adm = new Administrator(username,password,name,surname);
            if(list.addUser(adm)) return true;
        }

        else if(type.equals("Software Technician"))
        {
            SoftwareTechnician sft = new SoftwareTechnician(username,password,name,surname);
            if(list.addUser(sft)) return true;
        }

        else if(type.equals("Hardware Technician"))
        {
            HardwareTechnician hdt = new HardwareTechnician(username,password,name,surname);
            if(list.addUser(hdt)) return true;
        }

        else if(type.equals("Moderator"))
        {
            Moderator mdr = new Moderator (username,password,name,surname);
            if(list.addUser(mdr)) return true;
        }

        else if(type.equals("Secretary"))
        {
            Secretary scr = new Secretary (username,password,name,surname);
            if(list.addUser(scr)) return true;
        }
        return false;
    }

    /**
     * Επιστρέφει την λίστα με όλους τους χρήστες
     * @param list Αντικείμενο λίστας χρηστών
     * @return Λίστα χρηστών
     */

    public ArrayList<User> showUsers(UserList list)
    {
        return list.getUserList();
    }

    /**
     * Δημιουργεί το γραφικό περιβάλλον του διαχειριστή
     * @param frame Το παράθυρο της εφαρμογής
     */

    @Override
    public void showPanel(JFrame frame, UserList ul, TaskList tl)
    {
        AdminPanel mPanel=new AdminPanel(this,ul,tl,frame);
        mPanel.setVisible(true);
        frame.add(mPanel);
    }
}