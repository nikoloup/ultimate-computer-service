package computerservice;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Η κλάση Τechnician δημιουργεί τεχνικούς.
 */

public abstract class Technician extends User
{
    private ArrayList<Integer> tasks;

    /**
     * Κατασκευαστής
     * @param username Όνομα χρήστη
     * @param password Κωδικός χρήστη
     * @param type Τύπος χρήστη
     * @param name Όνομα
     * @param surname Επώνυμο
     */

    public Technician(String username,String password,String type,String name,String surname)
    {
        super(username,password,type,name,surname);
        tasks = new ArrayList<Integer>();
    }

    /**
     * Επιστρέφει τις εργασίες του χρήστη
     * @param list Η λίστα με όλες τις εργασίες
     * @return Ένα αντικείμενο ArrayList<Task>
     */

    public ArrayList<Task> showTasks(TaskList list)
    {
        ArrayList<Task> myTasks = new ArrayList<Task>();
        for (Integer x : tasks )
        {
            myTasks.add(list.getTask(x));
        }
        return myTasks;
    }

    /**
     * Καθιστά μια εργασία ολοκληρωμένη
     * @param id Αύξων αριθμός εργασίας
     * @param tlist Λίστα εργασιών
     */

    public void finishTask(Integer id,TaskList tlist)
    {
        if (tasks.indexOf(id)!=-1) //Έλεγχος για το εαν ανήκει στον τεχνικό το task
        {
            tlist.getTask(id).setStatus("Ολοκληρωμένη");
            tasks.remove(tasks.indexOf(id));
        }
    }

    /**
     * Ανάθεση εργασίας στον τεχνικό
     * @param id Αύξων αριθμός εργασίας
     */

    public void addTask(Integer id)
    {
        tasks.add(id);
    }

    /**
     * Επιστρέφει το πλήθος των εργασιών
     * @return Ένας int
     */

    public int getNumberOfTasks()
    {
        return tasks.size();
    }

    /**
     * Αφαιρετική μέθοδος δημιουργείας του γραφικού περιβάλλοντος του τεχνικού
     * @param frame
     */

    @Override
    public abstract void showPanel(JFrame frame, UserList ul, TaskList tl) ;
}
