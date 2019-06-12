package com.jimy.server.ec.biz.brand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * @author code generator
 * @Description 品牌表参数实体
 * @date 2019-03-22 03:32:50
 */
@ApiModel(description = "品牌表")
public class BrandEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 品牌编号 */
    @ApiModelProperty(name = "品牌编号[PK]", dataType = "Long", required = true, notes = "品牌编号")
    private Long brandId;

    /** 品牌编码 */
    @ApiModelProperty(name = "品牌编码", dataType = "String(50)", required = true, notes = "品牌编码")
    private String brandCode;

    /** 品牌名称 */
    @ApiModelProperty(name = "品牌名称", dataType = "String(50)", required = true, notes = "品牌名称")
    private String brandName;

    /** 描述 */
    @ApiModelProperty(name = "描述", dataType = "String(100)", required = false, notes = "描述")
    private String brandNote;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandNote() {
        return brandNote;
    }

    public void setBrandNote(String brandNote) {
        this.brandNote = brandNote;
    }
}