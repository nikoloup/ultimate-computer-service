package computerservice;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Η κλάση Moderator δημιουργεί συντονιστές
 */

public class Moderator extends User
{
    /**
     * Κατασκευαστής
     * @param username Όνομα χρήστη
     * @param password Κωδικός χρήστη
     * @param name Όνομα
     * @param surname Επώνυμο
     */

    public Moderator(String username,String password,String name,String surname)
    {
        super(username,password,"Moderator",name,surname);
    }

    /**
     * Επιστρέφει τις ανοιχτές εργασίες
     * @param list Λίστα εργασιών
     * @return Ένα ArrayList<Task>
     */

    public ArrayList<Task> printTaskOpen(TaskList list)
    {
        return list.getOpen();
    }

    /**
     * Επιστρέφει τις εργασίες σε εξέλιξη
     * @param list Λίστα εργασιών
     * @return Ένα ArrayList<Task>
     */

    public ArrayList<Task> printTaskRunning(TaskList list)
    {        
        return list.getInProgress();
    }

    /**
     * Αναθέτει μια εργασία σε έναν τεχνικό
     * @param tlist Λίστα εργασιών
     * @param ulist Λίστα χρηστών
     * @param id Αύξων αριθμός εργασίας
     * @param choice True για τεχνικό λογισμικού ή false για τεχνικό υλικού
     * @return Επιστρέφει μια boolean μεταβλητή για επιτυχία/αποτυχία ανάθεσης
     */

    public boolean assignTask(TaskList tlist, UserList ulist, Integer id,boolean choice)
    {
        Technician tech;
        int min=Integer.MAX_VALUE;
        ArrayList<Technician> users;
        if (choice) //Εξακρίβωση είδους τεχνικού και δημιουργία dummy αντικειμένου για τη σύγκριση
        {
            users=ulist.getSoftwareTechnicians();
            tech=new SoftwareTechnician("**","**","**","**");
        }
        else
        {
            users=ulist.getHardwareTechnicians();
            tech=new HardwareTechnician("**","**","**","**");
        }
        for (Technician x : users) //Εύρεση τεχνικού με λιγότερα tasks
        {
            if (min>x.getNumberOfTasks())
            {
                min=x.getNumberOfTasks();
                tech=x;
            }
        }
        if(!tech.getUsername().equals("**"))
        {
            tech.addTask(id); //Ανάθεση
            tlist.getTask(id).setStatus("Σε εξέλιξη");
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Δημιουργεί το γραφικό περιβάλλον του συντονιστή
     * @param frame Το παράθυρο της εφαρμογής
     */

    @Override
    public void showPanel(JFrame frame, UserList ul, TaskList tl)
    {   
        ModPanel mPanel=new ModPanel(this,ul,tl,frame);
        mPanel.setVisible(true);
        frame.add(mPanel);
    }
}
