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
public class UserListTest {

    private TaskList tl;
    private UserList ul;
    private Moderator mod;
    private SoftwareTechnician sft;
    private HardwareTechnician hdt;
    private Secretary sec;

    public UserListTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        ul = new UserList();
        mod = new Moderator("mod","*","*","*");
        sft = new SoftwareTechnician ("sft",  "1234", "*", "*");
        sec = new Secretary ("sec", "1234", "*", "*");
        hdt = new HardwareTechnician ("hdt",  "1234", "*", "*");
        ul.addUser(hdt);
        ul.addUser(sec);
        ul.addUser(mod);
        ul.addUser(sft);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class UserList.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        Moderator mod2 = new Moderator("mod","*","*","*");
        Moderator mod3 = new Moderator("mod3","*","*","*");
        assertFalse(ul.addUser(mod2));
        ul.addUser(mod3);
        assertTrue(ul.getUserList().contains(mod3));
    }

    /**
     * Test of getSoftwareTechnicians method, of class UserList.
     */
    @Test
    public void testGetSoftwareTechnicians() {
        System.out.println("getSoftwareTechnicians");
        ArrayList<Technician> users = ul.getHardwareTechnicians();
        for (Technician x : users)
        {
            assertEquals(x.getType(),"Hardware Technician");
        }
    }

    /**
     * Test of getHardwareTechnicians method, of class UserList.
     */
    @Test
    public void testGetHardwareTechnicians() {
        System.out.println("getHardwareTechnicians");
        ArrayList<Technician> users = ul.getSoftwareTechnicians();
        for (Technician x : users)
        {
            assertEquals(x.getType(),"Software Technician");
        }
    }

    /**
     * Test of LogIn method, of class UserList.
     */
    @Test
    public void testLogIn() {
        System.out.println("LogIn");
        String username = "mod";
        String password = "*";
        assertEquals(ul.LogIn(username, password),mod);
        username = "mod";
        password = "1234";
        assertNull(ul.LogIn(username, password));
        
    }

}