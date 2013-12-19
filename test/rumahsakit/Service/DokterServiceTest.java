/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rumahsakit.Service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rumahsakit.Entity.Dokter;
import rumahsakit.KoneksiDatabase.KoneksiDB;

/**
 *
 * @author asus
 */
public class DokterServiceTest {
    //Connection connection;

    public DokterServiceTest() {        
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
     * Test of serviceInsertDokter method, of class DokterService.
     */
    @Test
    public void testServiceInsertDokter() {
        System.out.println("serviceInsertDokter");
        Dokter d = new Dokter();
        d.setIdDokter("DK017");
        d.setNmDokter("LALA YEYEYE");
        d.setIdSpesialis("SP004");
        DokterService instance = new DokterService();
        instance.serviceInsertDokter(d);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of serviceUpdateDokter method, of class DokterService.
     */
    @Test
    public void testServiceUpdateDokter() {
        System.out.println("serviceUpdateDokter");
        Dokter d = new Dokter();
        d.setNmDokter("TRALALA TRILILI");
        d.setIdSpesialis("SP006");
        String idDokter = "DK017";
        DokterService instance = new DokterService();
        instance.serviceUpdateDokter(d, idDokter);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of serviceDeleteDokter method, of class DokterService.
     */
    @Test
    public void testServiceDeleteDokter() {
        System.out.println("serviceDeleteDokter");
        String idDokter = "DK017";
        DokterService instance = new DokterService();
        instance.serviceDeleteDokter(idDokter);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of serviceGetAllDokter method, of class DokterService.
//     */
//    @Test
//    public void testServiceGetAllDokter() {
//        String getAllDokter =
//            "SELECT d.id_dokter, d.nm_dokter, s.nm_spesialis "
//            + "FROM dokter d, spesialis s "
//            + "WHERE d.id_spesialis=s.id_spesialis "
//            + "ORDER BY d.id_dokter ASC";
//
//        Connection connection = KoneksiDB.getConnection();
//
//        System.out.println("serviceGetAllDokter");
//
//        DokterService instance = new DokterService();
//        List expResult = new ArrayList();
//
//        try {
//            Statement s = (Statement) connection.createStatement();
//            ResultSet rs = s.executeQuery(getAllDokter);
//            while(rs.next()){
//                Dokter d = new Dokter();
//                d.setIdDokter(rs.getString("id_dokter"));
//                d.setNmDokter(rs.getString("nm_dokter"));
//                d.setIdSpesialis(rs.getString("nm_spesialis"));
//                expResult.add(d);
//                //System.out.println(d);
//            }
//            rs.close();
//            s.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DokterServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        List result = instance.serviceGetAllDokter();
//        assertEquals(expResult, result);
//        //System.out.println(expResult+", "+result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of serviceGetByIdDoker method, of class DokterService.
//     */
//    @Test
//    public void testServiceGetByIdDoker() {
//        System.out.println("serviceGetByIdDoker");
//        String idDokter = "";
//        DokterService instance = new DokterService();
//        List expResult = null;
//        List result = instance.serviceGetByIdDoker(idDokter);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of serviceGetByIdSpesialis method, of class DokterService.
//     */
//    @Test
//    public void testServiceGetByIdSpesialis() {
//        System.out.println("serviceGetByIdSpesialis");
//        String idSpesialis = "";
//        DokterService instance = new DokterService();
//        List expResult = null;
//        List result = instance.serviceGetByIdSpesialis(idSpesialis);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of serviceNamaDokter method, of class DokterService.
//     */
//    @Test
//    public void testServiceNamaDokter() {
//        System.out.println("serviceNamaDokter");
//        String spesialis = "";
//        int total = 0;
//        DokterService instance = new DokterService();
//        String[] expResult = null;
//        String[] result = instance.serviceNamaDokter(spesialis, total);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of serviceTampilIdDokterByNama method, of class DokterService.
//     */
//    @Test
//    public void testServiceTampilIdDokterByNama() {
//        System.out.println("serviceTampilIdDokterByNama");
//        String nama = "";
//        DokterService instance = new DokterService();
//        String expResult = "";
//        String result = instance.serviceTampilIdDokterByNama(nama);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

}