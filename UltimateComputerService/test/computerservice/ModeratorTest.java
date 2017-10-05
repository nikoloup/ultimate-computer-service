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
public class ModeratorTest {

    private TaskList tl;
    private UserList ul;
    private Moderator mod;
    private SoftwareTechnician sft;
    private HardwareTechnician hdt;

    public ModeratorTest() {
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
        hdt = new HardwareTechnician ("hdt",  "1234", "*", "*");
        ul.addUser(sft);
        ul.addUser(hdt);
    }

    @After
    public void tearDown() {
    }





    /**
     * Test of assignTask method, of class Moderator.
     */
    @Test
    public void testAssignTask() {
        System.out.println("assignTask");
        Task task = new Task(0,"*","*","*","*","*");
        tl.addTask(task);
        Integer id = 0;
        boolean choice = true;
        mod.assignTask(tl, ul, id, choice);
        assertTrue(sft.showTasks(tl).contains(task));

        
    }

}