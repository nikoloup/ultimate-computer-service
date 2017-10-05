/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package computerservice;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Albatross
 */
public class AdministratorTest {

    private UserList list;
    private Administrator admin;
    private Moderator mod;
    private Secretary sec;
    private SoftwareTechnician sft;
    private HardwareTechnician hdt;

    public AdministratorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        list = new UserList();
        admin = new Administrator("admin", "1234", "*", "*");
        mod = new Moderator("mod", "1234", "*", "*");
        sec = new Secretary ("sec",  "1234", "*", "*");
        sft = new SoftwareTechnician ("sft",  "1234", "*", "*");
        hdt = new HardwareTechnician ("hdt",  "1234", "*", "*");

    }

    @After
    public void tearDown() {
        list.getUserList().clear();
    }

    /**
     * Test of addUser method, of class Administrator.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String username = "*";
        String password = "*";
        String name = "";
        String surname = "*";
        String type = "Moderator";
        boolean expResult = true;
        boolean result = admin.addUser(username, password, name, surname, type, list);
        assertEquals(expResult, result);
    }

    /**
     * Test of showUsers method, of class Administrator.
     */
    @Test
    public void testShowUsers() {
        System.out.println("showUsers");
        ArrayList expResult = new ArrayList<User>();
        expResult.add(admin);
        expResult.add(mod);
        expResult.add(sec);
        expResult.add(sft);
        expResult.add(hdt);
        list.addUser(admin);
        list.addUser(mod);
        list.addUser(sec);
        list.addUser(sft);
        list.addUser(hdt);
        ArrayList result = admin.showUsers(list);
        assertEquals(expResult, result);
    }

    /**
     * Test of showPanel method, of class Administrator.
     */
    @Test
    public void testShowPanel() {
        System.out.println("showPanel");
    }

}