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
public class TaskListTest {

    private TaskList tl;
    private UserList ul;
    private Moderator mod;
    private SoftwareTechnician sft;
    private Secretary sec;

    public TaskListTest() {
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
        tl.addTask(new Task(0,"","","","",""));
        tl.addTask(new Task(1,"","","","",""));
        tl.addTask(new Task(2,"","","","",""));
        tl.addTask(new Task(3,"","","","",""));
        tl.addTask(new Task(4,"","","","",""));
        ul = new UserList();
        mod = new Moderator("mod","*","*","*");
        sft = new SoftwareTechnician ("sft",  "1234", "*", "*");
        sec = new Secretary ("sec", "1234", "*", "*");
        ul.addUser(sft);
        mod.assignTask(tl, ul, 1, true);
        mod.assignTask(tl, ul, 2, true);
        mod.assignTask(tl, ul, 3, true);
        mod.assignTask(tl, ul, 4, true);
        sft.finishTask(3, tl);
        sft.finishTask(4, tl);
        sec.setTaskArchive(tl, 4);
    }

    @After
    public void tearDown() {
    }


    /**
     * Test of getOpen method, of class TaskList.
     */
    @Test
    public void testGetOpen() {
        System.out.println("getOpen");
        ArrayList<Task> tasks = tl.getOpen();
        for (Task x : tasks)
        {
            assertEquals(x.getStatus(),"Ανοιχτή");
        }
    }

    /**
     * Test of getInProgress method, of class TaskList.
     */
    @Test
    public void testGetInProgress() {
        System.out.println("getInProgress");
        ArrayList<Task> tasks = tl.getInProgress();
        for (Task x : tasks)
        {
            assertEquals(x.getStatus(),"Σε εξέλιξη");
        }
    }

    /**
     * Test of getFinished method, of class TaskList.
     */
    @Test
    public void testGetFinished() {
        System.out.println("getFinished");
        ArrayList<Task> tasks = tl.getFinished();
        for (Task x : tasks)
        {
            assertEquals(x.getStatus(),"Ολοκληρωμένη");
        }
    }

    /**
     * Test of getArchived method, of class TaskList.
     */
    @Test
    public void testGetArchived() {
        System.out.println("getArchived");
        ArrayList<Task> tasks = tl.getArchived();
        for (Task x : tasks)
        {
            assertEquals(x.getStatus(),"Αρχείο");
        }
    }

   
}