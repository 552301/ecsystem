package com.jimy.server.ec.biz.brand;

import com.jimy.server.ec.biz.ECBaseTable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @author code generator
 * @Description 品牌表
 * @date 2019-03-22 03:30:59
 */
@ApiModel(description = "品牌表")
@Entity
@Table(name = "oc_brand")
public class BrandTable extends ECBaseTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 品牌编号 */
    @Id
    @Column(name = "brand_id", nullable = false)
    @ApiModelProperty(name = "品牌编号[PK]", dataType = "Long", required = true, notes = "品牌编号")
    private Long brandId;

    /** 品牌编码 */
    @Column(name = "brand_code", nullable = false, length = 50)
    @ApiModelProperty(name = "品牌编码", dataType = "String", required = true, notes = "品牌编码")
    private String brandCode;

    /** 品牌名称 */
    @Column(name = "brand_name", nullable = false, length = 50)
    @ApiModelProperty(name = "品牌名称", dataType = "String", required = true, notes = "品牌名称")
    private String brandName;

    /** 描述 */
    @Column(name = "brand_note", length = 100)
    @ApiModelProperty(name = "描述", dataType = "String", required = false, notes = "描述")
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