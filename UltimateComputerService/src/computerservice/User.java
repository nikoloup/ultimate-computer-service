package computerservice;

import java.io.Serializable;
import javax.swing.JFrame;

/**
 * Η αφαιρετική κλάση User δημιουργεί χρήστες
 */

public abstract class User implements Serializable
{
    private String username;
    private String password;
    private String type;
    private String name;
    private String surname;

    /**
     * Κατασκευαστής
     * @param username Όνομα χρήστη
     * @param password Κωδικός χρήστη
     * @param type Τύπος χρήστη
     * @param name Όνομα
     * @param surname Επώνυμο
     */
    
    public User(String username,String password,String type,String name,String surname)
    {
        this.username=username;
        this.password=password;
        this.type=type;
        this.name=name;
        this.surname=surname;
    }

    /**
     * Επιστρέφει το όνομα του χρήστη
     * @return Ένα String
     */

    public String getName() {
        return name;
    }

    /**
     * Επιστρέφει το επίθετο του χρήστη
     * @return Ένα String
     */

    public String getSurname() {
        return surname;
    }

    /**
     * Επιστρέφει το όνομα χρήστη
     * @return Ένα String
     */

    public String getUsername()
    {
        return username;
    }

    /**
     * Επιστέφει τον κωδικό χρήστη
     * @return Ένα String
     */

    public String getPassword()
    {
        return password;
    }

    /**
     * Επιστρέφει τον τύπο του χρήστη
     * @return Ενα String
     */

    public String getType()
    {
        return type;
    }

    /**
     * Αφαιρετική μέθοδος δημιουργείας του γραφικού περιβάλλοντος του χρήστη
     * @param frame
     */
    
    public abstract void showPanel(JFrame frame, UserList ul, TaskList tl);

}