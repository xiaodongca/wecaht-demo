package com.cxd.wecahtdemo.service.impl;

import com.cxd.wecahtdemo.dao.AreaDao;
import com.cxd.wecahtdemo.entity.Area;
import com.cxd.wecahtdemo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cxd
 * Date: 2018/02/25
 * Description:
 */
@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaDao areaDao;

    @Override
    public Area getAreaByAreaId(Integer areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum >0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败："+e.getMessage());
            }
        }else {
            throw new RuntimeException("插入区域信息不能为空");
        }
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null && area.getAreaId()>0){
            //设置默认值
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum >0){
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败："+e.getMessage());
            }
        }else {
            throw new RuntimeException("更新区域信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteArea(Integer areaId) {
        if (areaId >0){
            try{
                //删除区域信息
                int deleteArea = areaDao.deleteArea(areaId);
                if (deleteArea>0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败！");
                }

            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败："+e.toString());
            }
        }else {
            throw new RuntimeException("区域Id不能为空！");
        }

    }
}
