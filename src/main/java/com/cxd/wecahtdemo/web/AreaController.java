package com.cxd.wecahtdemo.web;

import com.cxd.wecahtdemo.entity.Area;
import com.cxd.wecahtdemo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: cxd
 * Date: 2018/02/25
 * Description:
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/listarea")
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }

    @GetMapping("/getareabyid")
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<>();
        Area area = areaService.getAreaByAreaId(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    @PostMapping("/addarea")
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>();
        //添加区域信息
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    @PostMapping("/modifyarea")
    private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>();
        //修改区域信息
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }

    @GetMapping("/removearea")
    private Map<String,Object> removeArea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<>();
        //删除区域信息
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }


}
