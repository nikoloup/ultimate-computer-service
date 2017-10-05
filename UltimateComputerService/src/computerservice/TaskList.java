package computerservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Η κλάση TaskList χειρίζεται τα Tasks
 */

public class TaskList
{

    private ArrayList<Task> tasklist;

    /**
     * Κατασκευαστής
     */

    public TaskList()
    {
        tasklist = new ArrayList<Task>();
    }

    /**
     * Προσθέτει Task στη TaskList
     * @param task Νέα εργασία
     */

    public void addTask(Task task)
    {
        tasklist.add(task);
    }

    /**
     * Επιστρέφει το πλήθος των εργασιών
     * @return Έναν int
     */

    public int getSize()
    {
        return tasklist.size();
    }

    /**
     * Επιστρέφει την λίστα με τις εργασίες
     * @return Ένα ArrayList<Task>
     */

    public ArrayList<Task> getTasklist()
    {
        return tasklist;
    }

    /**
     * Επιστρέφει μία εργασία
     * @param id Αύξων αριθμός εργασίας
     * @return Ένα Task
     */

    public Task getTask(Integer id)
    {
        return tasklist.get(id.intValue());
    }

    /**
     * Επιστρέφει μία λίστα με τις ανοιχτές εργασίες
     * @return Ένα ArrayList<Task>
     */

    public ArrayList<Task> getOpen()
    {
        ArrayList<Task> list;
        list = new ArrayList<Task>();
        for (Task task : tasklist) {
            if (task.getStatus().equals("Ανοιχτή"))
            list.add(task);
        }
        return list;
    }

    /**
     * Επιστρέφει μία λίστα με τις εργασίες σε εξέλιξη
     * @return Ένα ArrayList<Task>
     */

    public ArrayList<Task> getInProgress()
    {
        ArrayList<Task> list;
        list = new ArrayList<Task>();
        for (Task task : tasklist) {
            if (task.getStatus().equals("Σε εξέλιξη"))
            list.add(task);
        }
        return list;
    }

    /**
     * Επιστρέφει μία λίστα με τις ολοκληρωμένες εργασίες
     * @return Ένα ArrayList<Task>
     */

    public ArrayList<Task> getFinished()
    {
        ArrayList<Task> list;
        list = new ArrayList<Task>();
        for (Task task : tasklist) {
            if (task.getStatus().equals("Ολοκληρωμένη"))
            list.add(task);
        }
        return list;
    }

    /**
     * Επιστρέφει μία λίστα με τις αρχειοθετημένες εργασίες
     * @return Ένα ArrayList<Task>
     */

    public ArrayList<Task> getArchived()
    {
        ArrayList<Task> list;
        list = new ArrayList<Task>();
        for (Task task : tasklist) {
            if (task.getStatus().equals("Αρχείο"))
            list.add(task);
        }
        return list;
    }

    /**
     * Φορτώνει τις εργασίες από το αρχείο
     */

    public void Load()
    {
        try
        {
            FileInputStream fis = new FileInputStream("tasks");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tasklist = (ArrayList<Task>)ois.readObject();
            ois.close();
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει αρχείο εργασιών.","Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException ex2)
        {
            JOptionPane.showMessageDialog(null, "Σφάλμα ανάγνωσης αρχείου.","ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex3)
        {
            JOptionPane.showMessageDialog(null, "Σφάλμα.","ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Αποθηκεύει τις εργασίες στο αρχείο
     */

    public void Save()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("tasks");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tasklist);
            oos.close();
        }
        catch(IOException ex2)
        {
            JOptionPane.showMessageDialog(null, "Σφάλμα εγγραφής αρχείου.","ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
