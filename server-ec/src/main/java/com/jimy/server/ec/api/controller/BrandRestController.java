package com.jimy.server.ec.api.controller;

import com.jimy.server.ec.api.service.IBrandService;
import com.jimy.server.ec.biz.brand.BrandEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈品牌接口服务管理〉
 *
 * @author jimy
 * @create 2019/3/22
 * @since 1.0.0
 */
@Api(tags = "品牌接口服务管理")
@RestController
@RequestMapping("/brand")
public class BrandRestController {
    @Autowired
    private IBrandService brandService;

    @ApiOperation(value = "添加品牌服务管理",notes = "添加品牌服务管理")
    @ApiImplicitParam(name ="entity",value = "BrandEntity",paramType = "body",required = true,dataType = "BrandEntity")
    @PostMapping(name="添加品牌服务管理",value = "/insert",produces = "application/json;charset=UTF-8")
    public void insert(@RequestBody BrandEntity entity) {
        brandService.insert(entity);
    }

    @ApiOperation(value = "更新品牌服务管理",notes = "更新品牌服务管理")
    @ApiImplicitParam(name ="entity",value = "BrandEntity",paramType = "body",required = true,dataType = "BrandEntity")
    @PutMapping(name="更新品牌服务管理",value = "/update",produces = "application/json;charset=UTF-8")
    public void update(@RequestBody BrandEntity entity) {
        brandService.update(entity);
    }

    @ApiOperation(value = "批量保存品牌服务管理",notes = "批量保存品牌服务管理")
    @ApiImplicitParam(name ="entities",value = "List<BrandEntity>",paramType = "body",required = true,dataType = "BrandEntity",allowMultiple=true)
    @PostMapping(name="批量品牌服务管理",value = "/batchSave",produces = "application/json;charset=UTF-8")
    public void batchSave(@RequestBody List<BrandEntity> entities) {
        brandService.batchAdd(entities);
    }

    @ApiOperation(value = "分页查询品牌服务管理",notes = "分页查询品牌服务管理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "offset",value = "数据开始位置",dataType = "Integer",paramType = "path",example = "1"),
            @ApiImplicitParam(name = "limit",value = "多少条数据",dataType = "Integer",paramType = "path",example = "100")
    })
    @GetMapping(name="分页查询品牌服务管理",value = "/findAllToPage/{offset}/{limit}", produces = "application/json;charset=UTF-8")
    public List<BrandEntity> findAllToPage(@PathVariable("offset") int offset, @PathVariable("limit") int limit) {
        return brandService.pageList(offset, limit);
    }

//    @ApiOperation(value = "分页查询品牌服务管理-带筛选条件",notes = "分页查询品牌服务管理-带筛选条件")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "offset",value = "数据开始位置",dataType = "Integer",paramType = "path",example = "1"),
//            @ApiImplicitParam(name = "limit",value = "多少条数据",dataType = "Integer",paramType = "path",example = "100"),
//            @ApiImplicitParam(name = "entity",value = "BrandEntity",dataType = "BrandEntity",paramType = "body",example = "")
//    })
//    @PostMapping(name="分页查询品牌服务管理-带筛选条件",value = "/findAllByConditionToPage/filter/{offset}/{limit}",produces = "application/json;charset=UTF-8")
//    public List<BrandEntity> findAllByConditionToPage(@PathVariable("offset") int offset,@PathVariable("limit") int limit, @RequestBody BrandEntity entity) {
//        return brandService.findAllByConditionToPage(offset, limit,entity);
//    }

    @ApiOperation(value = "查询品牌服务管理",notes = "查询品牌服务管理")
    @GetMapping(name="查询Brand",value = "/findAll", produces = "application/json;charset=UTF-8")
    public List<BrandEntity> findAll() {
        return brandService.listAll();
    }

    @ApiOperation(value = "统计所有品牌服务管理",notes = "统计所有品牌服务管理")
    @GetMapping(name="统计所有品牌服务管理",value = "/countAll", produces = "application/json;charset=UTF-8")
    public Long countAll() {
        return brandService.countAll();
    }
//
//    @ApiOperation(value = "查询品牌服务管理-带筛选条件",notes = "查询品牌服务管理-带筛选条件")
//    @ApiImplicitParam(name ="entity",value = "BrandEntity",paramType = "body",required = true,dataType = "BrandEntity")
//    @PostMapping(name="查询品牌服务管理-带筛选条件",value = "/findAllByCondition/filter",produces = "application/json;charset=UTF-8")
//    public List<BrandEntity> findAllByCondition(@RequestBody BrandEntity entity) {
//        return brandService.findAllByCondition(entity);
//    }
//
//    @ApiOperation(value = "统计所有品牌服务管理-带筛选条件",notes = "统计所有品牌服务管理-带筛选条件")
//    @ApiImplicitParam(name ="entity",value = "BrandEntity",paramType = "body",required = true,dataType = "BrandEntity")
//    @PostMapping(name="统计所有品牌服务管理-带筛选条件",value = "/countAllByCondition/filter",produces = "application/json;charset=UTF-8")
//    public Long countAllByCondition(@RequestBody BrandEntity entity) {
//        return brandService.countAllByCondition(entity);
//    }

    @ApiOperation(value = "根据ID检查品牌服务管理是否存在",notes = "检查品牌服务管理是否存在")
    @ApiImplicitParam(name ="brandId",value = "brandId",paramType = "path",required = true,dataType = "Long")
    @GetMapping(name="检查Brand是否存在",value = "/exists/{brandId}", produces = "application/json;charset=UTF-8")
    public Boolean existsById(@PathVariable("brandId") Long brandId) {
        return brandService.existsById(brandId);
    }

    @ApiOperation(value = "根据ID查询一个品牌服务管理",notes = "查询一个品牌服务管理")
    @ApiImplicitParam(name ="brandId",value = "brandId",paramType = "path",required = true,dataType = "Long")
    @GetMapping(name="查询一个品牌服务管理",value = "/get/{brandId}",produces = "application/json;charset=UTF-8")
    public BrandEntity findById(@PathVariable("brandId") Long brandId) {
        return  brandService.findOne(brandId);
    }

    @ApiOperation(value = "根据ID删除品牌服务管理",notes = "删除品牌服务管理")
    @ApiImplicitParam(name ="brandId",value = "brandId",paramType = "path",required = true,dataType = "Long")
    @DeleteMapping(name="删除品牌服务管理",value = "/delete/{brandId}", produces = "application/json;charset=UTF-8")
    public int deleteById(@PathVariable("brandId") Long brandId) {
        return brandService.delete(brandId);
    }

    @ApiOperation(value = "批量删除品牌服务管理",notes = "批量删除品牌服务管理")
    @ApiImplicitParam(name ="brandIds",value = "",paramType = "body",required = true,dataType = "Long",allowMultiple=true)
    @DeleteMapping(name="批量删除品牌服务管理",value = "/batchDelete", produces = "application/json;charset=UTF-8")
    public void deleteBrandByBrandIdIn(@RequestBody List<Long> brandIds) {
        brandService.batchDelete(brandIds);
    }
}
