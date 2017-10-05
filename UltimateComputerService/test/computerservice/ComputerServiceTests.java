/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package computerservice;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Albatross
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({computerservice.TechnicianTest.class,computerservice.UserListTest.class,computerservice.SecretaryTest.class,computerservice.TaskListTest.class,computerservice.ModeratorTest.class,computerservice.AdministratorTest.class})
public class ComputerServiceTests {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}