package com.cxd.wecahtdemo.dao;

import com.cxd.wecahtdemo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea()  {

        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById()  {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());

    }

    @Test
    @Ignore
    public void insertArea()  {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int insertArea = areaDao.insertArea(area);
        assertEquals(1,insertArea);
    }

    @Test
    @Ignore
    public void updateArea()  {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int updateArea = areaDao.updateArea(area);
        assertEquals(1,updateArea);
    }

    @Test
    public void deleteArea()  {
        int deleteArea = areaDao.deleteArea(3);
        assertEquals(1,deleteArea);
    }

}