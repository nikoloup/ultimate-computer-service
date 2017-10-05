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
 * Η κλάση UserList χειρίζεται τους χρήστες
 */

public class UserList
{
    private ArrayList<User> users;
    /**
     * Κατασκευαστής
     */

    public UserList()
    {
        users=new ArrayList<User>();
    }

    /**
     * Προσθέτει χρήστη
     * @param newUser Νέος χρήστης
     */

    public boolean addUser(User newUser)
    {
        for (User x : users) //Έλεγχος για ύπαρξη χρήστη με ίδιο username
        {
            if (newUser.getUsername().equals(x.getUsername()))
            return false;
        }
        users.add(newUser);
        return true;
    }

    /**
     * Επιστρέφει την λίστα με τους χρήστες
     * @return Ένα ArrayList<User>
     */

    public ArrayList<User> getUserList()
    {
        return users;
    }

    /**
     * Επιστρέφει την λίστα με τους τεχνικούς λογισμικού
     * @return Ένα ArrayList<User>
     */

    public ArrayList<Technician> getSoftwareTechnicians()
    {
        ArrayList<Technician> tech;
        tech=new ArrayList<Technician>();
        for(User user:users)
            if(user.getType().equals("Software Technician"))
                tech.add((Technician)user);
        return tech;
    }

    /**
     * Επιστρέφει την λίστα με τους τεχνικούς υλικού
     * @return Ένα ArrayList<User>
     */

    public ArrayList<Technician> getHardwareTechnicians()
    {
        ArrayList<Technician> tech;
        tech=new ArrayList<Technician>();
        for(User user:users)
            if(user.getType().equals("Hardware Technician"))
                tech.add((Technician)user);
        return tech;
    }

    /**
     * Φορτώνει τη λιστα χρηστών απο το αρχείο
     */

    public void Load()
    {
        try
        {
            FileInputStream fis = new FileInputStream("users");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>)ois.readObject();
            ois.close();
        }
        catch (FileNotFoundException ex)
        {
            Administrator admin = new Administrator("admin","1234","","");
            users.add(admin);
            JOptionPane.showMessageDialog(null, String.format("Δεν υπάρχει αρχείο χρηστών. Δημιουργία νέου. \nDefault Administrator:\nUsername : admin\nPassword : 1234"),"Information", JOptionPane.INFORMATION_MESSAGE);
            Save();
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
     * Αποθηκεύει τη λίστα χρηστών σε ενα αρχείο
     */

    public void Save()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("users");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        }
        catch(IOException ex2)
        {
            JOptionPane.showMessageDialog(null, "Σφάλμα εγγραφής αρχείου.","ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Ελέγχει αν υπάρχει χρήστης με το συγκεκριμένο όνομα και κωδικό και τον επιστρέφει
     * αλλιώς επιστρέφει null
     * @param username όνομα χρήστη
     * @param password κωδικός χρήστη
     * @return Αντικείμενο χρήστη
     */

    public User LogIn(String username,String password)
    {
        for(User user:users)
        {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password))
                return user;
        }
        return null;
    }
}
