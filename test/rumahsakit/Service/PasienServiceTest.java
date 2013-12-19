/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.Service;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rumahsakit.Entity.Pasien;

/**
 *
 * @author asus
 */
public class PasienServiceTest {

    public PasienServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of serviceInsertPasien method, of class PasienService.
     */
    @Test
    public void testServiceInsertPasien() {
        System.out.println("serviceInsertPasien");
        Pasien p = new Pasien();
        p.setIdPasien("000021");
        p.setNmPasien("Handi Handoko Susilo");
        PasienService instance = new PasienService();
        instance.serviceInsertPasien(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of serviceUpdatePasien method, of class PasienService.
     */
    @Test
    public void testServiceUpdatePasien() {
        System.out.println("serviceUpdatePasien");
        Pasien p = new Pasien();
        p.setNmPasien("Joko Santoso");
        String idPasien = "000021";
        PasienService instance = new PasienService();
        instance.serviceUpdatePasien(p, idPasien);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of serviceDeletePasien method, of class PasienService.
     */
    @Test
    public void testServiceDeletePasien() {
        System.out.println("serviceDeletePasien");
        String idPasien = "000021";
        PasienService instance = new PasienService();
        instance.serviceDeletePasien(idPasien);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of serviceGetAllPasien method, of class PasienService.
//     */
//    @Test
//    public void testServiceGetAllPasien() {
//        System.out.println("serviceGetAllPasien");
//        PasienService instance = new PasienService();
//        List expResult = null;
//        List result = instance.serviceGetAllPasien();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of serviceGetByIdPasien method, of class PasienService.
//     */
//    @Test
//    public void testServiceGetByIdPasien() {
//        System.out.println("serviceGetByIdPasien");
//        String idPasien = "";
//        PasienService instance = new PasienService();
//        List expResult = null;
//        List result = instance.serviceGetByIdPasien(idPasien);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of serviceNamaByIdPasien method, of class PasienService.
//     */
//    @Test
//    public void testServiceNamaByIdPasien() {
//        System.out.println("serviceNamaByIdPasien");
//        String idPasien = "";
//        PasienService instance = new PasienService();
//        String expResult = "";
//        String result = instance.serviceNamaByIdPasien(idPasien);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of serviceGenerateIdPasien method, of class PasienService.
//     */
//    @Test
//    public void testServiceGenerateIdPasien() {
//        System.out.println("serviceGenerateIdPasien");
//        PasienService instance = new PasienService();
//        String expResult = "";
//        String result = instance.serviceGenerateIdPasien();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}