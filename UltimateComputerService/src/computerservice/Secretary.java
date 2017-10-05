package computerservice;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Η κλάση Secretary δημιουργεί γραμματείς
 */

public class Secretary extends User
{
    /**
     * Κατασκευαστής
     * @param username Όνομα χρήστη
     * @param password Κωδικός χρήστη
     * @param name Όνομα
     * @param surname Επώνυμο
     */

    public Secretary(String username, String password,String name,String surname)
    {
        super(username,password,"Secretary",name,surname);
    }

    /**
     * Καταχώριση νέας εργασίας
     * @param list Λίστα εργασιών
     * @param description Περιγραφή εργασίας
     * @param name Όνομα πελάτη
     * @param surname Επίθετο πελάτη
     * @param phone Τηλέφωνο επικοινωνίας
     * @param email Ηλεκτρονική διεύθυνση
     */

    public void addTask (TaskList list, String description, String name, String surname, String phone, String email)
    {
        int size = list.getSize();
        Task task = new Task(size,description,name,surname,phone,email);
        list.addTask(task);
    }

    /**
     * Επιστρέφει τις ολοκληρωμένες εργασίες
     * @param list Λίστα εργασιών
     * @return Ένα ArrayList<Task>
     */

    public ArrayList<Task> printTaskComplete(TaskList list)
    {
        return list.getFinished();
    }

    /**
     * Επιστρέφει τις αρχειοθετημένες εργασίες
     * @param list Λίστα εργασιών
     * @return Ένα ArrayList<Task>
     */
    
    public ArrayList<Task> printTaskArchive(TaskList list)
    {
        return list.getArchived();
    }

    /**
     * Καθιστά μια εργασία ολοκληρωμένη
     * @param list Λίστα εργασιών
     * @param id Αύξων αριθμός εργασίας
     */

    public void setTaskArchive(TaskList list, int id)
    {
        list.getTasklist().get(id).setStatus("Αρχείο");
    }

    /*
     * Δημιουργεί το γραφικό περιβάλλον του γραμματέα
     * @param frame Το παράθυρο της εφαρμογής
     */

    @Override
    public void showPanel(JFrame frame, UserList ul, TaskList tl) {
        SecrPanel mPanel=new SecrPanel(this,ul,tl,frame);
        mPanel.setVisible(true);
        frame.add(mPanel);
    }
}
