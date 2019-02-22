package com.ccbscf.learn.daos;


import com.ccbscf.learn.pojos.Staff;
import org.jooq.types.UInteger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StaffDaoTest {

    StaffDao staffDao = null;
    ClassPathXmlApplicationContext context = null;

    @Before
    public void before() {

        context = new ClassPathXmlApplicationContext("app.xml");
        staffDao = context.getBean("staffDao",StaffDao.class);
        System.out.println("init");
    }

    @Test
    public void FIND_STAFF() throws Exception {
        Staff staff = new Staff();
        staff.setName("lzq");
        staff.setImg("www.baidu.com");
        staff.setGender(0);
        staff.setDocumentType(0);
        staff.setDocumentNumber("52212219950320");
        staff.setStatus(0);
        staff.setCreateBy("lzq");
        for (int i = 0; i < 5; i++) {
            staffDao.addStaff(staff);
        }
    }

    @Test
    public void FIND_ALL() {
        List<Staff> staffs = staffDao.findAll();
        staffs.forEach((a) -> {
            System.out.println(a);
        });
    }

    @Test
    public void DELETE_ID_EQ_1() {
        staffDao.delete(UInteger.valueOf(1));
        Assert.assertEquals(null, staffDao.findById(UInteger.valueOf(1)));
    }


}
