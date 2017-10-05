
package computerservice;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Nikos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        TaskList tList = new TaskList();   //Δημιουργία αντικειμένων για τη
        UserList uList = new UserList();  // φόρτωση των δεδομένων
        tList.Load();  // Φόρτωση
        uList.Load();  // Φόρτωση

/* Εκκίνηση γραφικού περιβάλλοντος */

        JFrame application = new JFrame("Computer Service");
        LoginPane login = new LoginPane(uList,application,tList);
        application.add(login);
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.setSize(400, 300);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int X = (screen.width / 2) - (200); // Center horizontally.
        int Y = (screen.height / 2) - (150); // Center vertically.
        application.setLocation(new Point(X,Y));
        application.setResizable(false);
        application.setVisible( true );

    }

}