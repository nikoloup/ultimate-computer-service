/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package computerservice;

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
public class SecretaryTest {

    private TaskList tl;
    private UserList ul;
    private Moderator mod;
    private SoftwareTechnician sft;
    private Secretary sec;

    public SecretaryTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        tl = new TaskList();
        ul = new UserList();
        mod = new Moderator("mod","*","*","*");
        sft = new SoftwareTechnician ("sft",  "1234", "*", "*");
        sec = new Secretary ("sec", "1234", "*", "*");
        ul.addUser(sft);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addTask method, of class Secretary.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        String description = "";
        String name = "";
        String surname = "";
        String phone = "";
        String email = "";
        sec.addTask(tl, description, name, surname, phone, email);
        assertEquals(tl.getTask(0).getDescription(),description);
        assertEquals(tl.getTask(0).getName(),name);
        assertEquals(tl.getTask(0).getSurname(),surname);
        assertEquals(tl.getTask(0).getPhone(),phone);
        assertEquals(tl.getTask(0).getEmail(),email);
    }

    /**
     * Test of setTaskArchive method, of class Secretary.
     */
    @Test
    public void testSetTaskArchive() {
        System.out.println("setTaskArchive");
        Task task = new Task(0,"","","","","");
        tl.addTask(task);
        mod.assignTask(tl, ul, 0, true);
        sft.finishTask(0, tl);
        sec.setTaskArchive(tl, 0);
        assertEquals(tl.getTask(0).getStatus(),"Αρχείο");
    }

}