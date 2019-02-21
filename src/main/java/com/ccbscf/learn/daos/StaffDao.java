package com.ccbscf.learn.daos;

import com.ccbscf.learn.pojos.Staff;
import com.ccbscf.learn.util.JooqUtil;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ccbscf.learn.Staff.STAFF;

public class StaffDao {
    private static DSLContext context = JooqUtil.getContext();

    /**
     * 插入一条数据
     *
     * @param staff
     * @return 插入数量
     */
    public int addStaff(Staff staff) {
        return context.insertInto(STAFF)
                .set(STAFF.NAME, staff.getName())
                .set(STAFF.GENDER, staff.getGender())
                .set(STAFF.STATUS, staff.getStatus())
                .set(STAFF.DOCUMENT_TYPE, staff.getDocumentType())
                .set(STAFF.DOCUMENT_NUMBER, staff.getDocumentNumber())
                .set(STAFF.CREATE_BY, staff.getCreateBy())
                .set(STAFF.CREATE_AT, staff.getCreateAt())
                .set(STAFF.UPDATE_BY, staff.getUpdateBy())
                .set(STAFF.UPDATE_AT, staff.getUpdateAt())
                .set(STAFF.DELETE_BY, staff.getDeleteBy())
                .set(STAFF.DELETE_AT, staff.getDeleteAt())
                .execute();
    }

    /**
     * 根据主键查询数据
     *
     * @param id
     * @return
     */
    public Staff findById(UInteger id) {
        Field<?>[] fields =
                {STAFF.ID,
                        STAFF.NAME,
                        STAFF.GENDER,
                        STAFF.IMG,
                        STAFF.STATUS,
                        STAFF.DOCUMENT_TYPE,
                        STAFF.DOCUMENT_NUMBER,
                        STAFF.CREATE_BY,
                        STAFF.CREATE_AT,
                        STAFF.UPDATE_BY,
                        STAFF.UPDATE_AT,
                        STAFF.DELETE_BY,
                        STAFF.DELETE_AT};
        SelectConditionStep<Record> result = context.select(fields).from(STAFF).where(STAFF.ID.eq(id));
        return result.fetchOneInto(Staff.class);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<Staff> findAll() {
        List<Staff> staffs = new ArrayList<Staff>();
        Result<Record1<UInteger>> result = context.select(STAFF.ID).from(STAFF).fetch();
        for (Record1<UInteger> record : result) {
            staffs.add(findById(record.getValue(STAFF.ID)));
        }
        return staffs;
    }

    public List<Staff> quary(int gender, int status) {
        List<Staff> staffs = new ArrayList<Staff>();
        SelectQuery selectQuery = context.selectQuery();
        selectQuery.addSelect(STAFF.ID);
        selectQuery.addConditions(DSL.field(STAFF.GENDER).eq(gender), DSL.field(STAFF.STATUS).eq(status));
        Result<Record1<UInteger>> record1s=selectQuery.fetch();
        for (Record1<UInteger> record : record1s) {
            staffs.add(findById(record.getValue(STAFF.ID)));
        }
        return staffs;
    }

    /**
     * 分页查询
     *
     * @param offset 起始行
     * @param size   page size
     * @return 查询结果
     */
    public List<Staff> findPage(int offset, int size) {
        List<Staff> staffs = new ArrayList<Staff>();
        Result<Record1<UInteger>> result = context.select(STAFF.ID).from(STAFF).limit(offset, size).fetch();
        for (Record1<UInteger> record : result) {
            staffs.add(findById(record.getValue(STAFF.ID)));
        }
        return staffs;
    }

    /**
     * 修改指定id的名字
     *
     * @param id
     * @param name
     * @return
     */
    public int update(UInteger id, String name) {
        return context.update(STAFF).set(STAFF.NAME, name).where(STAFF.ID.eq(id)).execute();
    }

    /**
     * 删除指定主键的记录
     *
     * @param id
     * @return
     */
    public int delete(UInteger id) {
        return context.delete(STAFF).where(STAFF.ID.eq(id)).execute();
    }
}
