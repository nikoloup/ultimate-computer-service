/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package computerservice;

import java.util.ArrayList;
import javax.swing.JFrame;
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
public class TechnicianTest {

    private TaskList tl;
    private UserList ul;
    private Moderator mod;
    private SoftwareTechnician sft;
    private Secretary sec;

    public TechnicianTest() {
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
     * Test of showTasks method, of class Technician.
     */
    @Test
    public void testShowTasks() {
        System.out.println("showTasks");
        sec.addTask(tl, "", "", "", "", "");
        sec.addTask(tl, "", "", "", "", "");
        sec.addTask(tl, "", "", "", "", "");
        sec.addTask(tl, "", "", "", "", "");
        sec.addTask(tl, "", "", "", "", "");
        sec.addTask(tl, "", "", "", "", "");
        sec.addTask(tl, "", "", "", "", "");
        sec.addTask(tl, "", "", "", "", "");
        mod.assignTask(tl, ul, 0, true);
        mod.assignTask(tl, ul, 2, true);
        mod.assignTask(tl, ul, 6, true);
        ArrayList<Task> myTasks = sft.showTasks(tl);
        int i[] = new int[3];
        i[0]=0;
        i[1]=2;
        i[2]=6;
        int j=0;
        for (Task x : myTasks)
        {
            assertEquals(x.getId(),i[j]);
            j++;
        }
    }

    /**
     * Test of finishTask method, of class Technician.
     */
    @Test
    public void testFinishTask() {
        System.out.println("finishTask");
        sec.addTask(tl, "", "", "", "", "");
        sec.addTask(tl, "", "", "", "", "");
        mod.assignTask(tl, ul, 0, true);
        sft.finishTask(0, tl);
        assertEquals(tl.getTask(0).getStatus(),"Ολοκληρωμένη");
        assertTrue(sft.showTasks(tl).isEmpty());
    }

    public class TechnicianImpl extends Technician {

        public TechnicianImpl() {
            super("", "", "", "", "");
        }

        public void showPanel(JFrame frame, UserList ul, TaskList tl) {
        }
    }

}