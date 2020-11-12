package com.nefu.project1;

import com.nefu.project1.dao.VendorDao;
import com.nefu.project1.entity.Table_Vendor;
import org.junit.Test;

/**
 * @author zsy
 * @date 2020/11/11 0011 - 14:58
 */
public class VendorTest {
     VendorDao vendorDao = new VendorDao();
    @Test
    public void test_getVendorByID() {
        Table_Vendor vendor = vendorDao.getVendorByID(1);
        System.out.println(vendor);
    }
}
