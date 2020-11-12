package com.nefu.project1;

import com.nefu.project1.dao.VendorDao;
import com.nefu.project1.entity.Table_Vendor;
import org.junit.Test;

public class VendorDaoTest {

    VendorDao vendorDao = new VendorDao();

    @Test
    public void test_getAllVendor() {
        for (Table_Vendor vendor : vendorDao.getAllVendor()) {
            System.out.println(vendor);
        }
    }

    @Test
    public void test_insertVendor() {
        Table_Vendor table_vendor = new Table_Vendor();
        table_vendor.setVendor_name("玉米哥");
        System.out.println(vendorDao.insertVendor(table_vendor));

    }

    @Test
    public void test_updateVendor() {
        Table_Vendor table_vendo = vendorDao.getAllVendor().get(3);
        table_vendo.setVendor_phone("1111");
        System.out.println(vendorDao.updateVendor(table_vendo));
    }

    @Test
    public void test_getVendorByID() {
        System.out.println(vendorDao.getVendorByID(3));
    }
}
