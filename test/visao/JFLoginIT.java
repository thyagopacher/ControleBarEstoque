/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vo.Pessoa;

/**
 *
 * @author Thyago H Pacher
 */
public class JFLoginIT {
    
    public JFLoginIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class JFLogin.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        JFLogin.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class JFLogin.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        JFLogin instance = new JFLogin();
        instance.login();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of centralizarComponente method, of class JFLogin.
     */
    @Test
    public void testCentralizarComponente() {
        System.out.println("centralizarComponente");
        JFLogin instance = new JFLogin();
        instance.centralizarComponente();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of montaListaEmail method, of class JFLogin.
     */
    @Test
    public void testMontaListaEmail() {
        System.out.println("montaListaEmail");
        List<Pessoa> pessoas = null;
        JFLogin instance = new JFLogin();
        List<String> expResult = null;
        List<String> result = instance.montaListaEmail(pessoas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
