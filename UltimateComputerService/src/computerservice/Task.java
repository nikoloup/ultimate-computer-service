package computerservice;

import java.io.Serializable;

/**
 * Η κλάση Task δημιουργεί εργασίες
 */

public class Task implements Serializable
{
    private String status;
    private int id;
    private String description;
    private String name;
    private String surname;
    private String phone;
    private String email;

    /**
     * Κατασκευαστής
     * @param id Αύξων αριθμός εργασίας
     * @param description Περιγραφή εργασίας
     * @param name Όνομα πελάτη
     * @param surname Επίθετο πελάτη
     * @param phone Τηλέφωνο επικοινωνίας
     * @param email Ηλεκτρονική διεύθυνση
     */

    public Task(int id,String description, String name, String surname, String phone, String email)
    {
        status="Ανοιχτή";
        this.description=description;
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Επιστρέφει την κατάσταση της εργασίας
     * @return Ένα String
     */

    public String getStatus()
    {
        return status;
    }

    /**
     * Θέτει την κατάσταση
     * @param status Κατάσταση
     */

    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * Επιστρέφει την περιγραφή της εργασίας
     * @return Ένα String
     */

    public String getDescription()
    {
        return description;
    }

    /**
     * Επιστρέφει τον αύξων αριθμό της εργασίας
     * @return Έναν int
     */

    public int getId()
    {
        return id;
    }

    /**
     * Επιστρέφει το email του πελάτη
     * @return Ένα String
     */

    public String getEmail() {
        return email;
    }

    /**
     * Επιστρέφει το όνομα του πελάτη
     * @return Ένα String
     */

    public String getName() {
        return name;
    }

    /**
     * Επιστρέφει το τηλέφωνο του πελάτη
     * @return Ένα String
     */

    public String getPhone() {
        return phone;
    }

    /**
     * Επιστρέφει το επίθετο του πελάτη
     * @return Ένα String
     */

    public String getSurname() {
        return surname;
    }


}