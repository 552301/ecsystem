package com.jimy.server.ec.biz;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class ECBaseTable implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 创建时间 */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", updatable = false)
    @ApiModelProperty(name = "创建时间", dataType = "Date", required = false, notes = "创建时间")
    private Date createDate;

    /** 创建人 */
    @Column(name = "create_name", length = 48, updatable = false)
    @ApiModelProperty(name = "创建人", dataType = "String", required = false, notes = "创建人")
    private String createName;

    /** 更新时间 */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    @ApiModelProperty(name = "更新时间", dataType = "Date", required = false, notes = "更新时间")
    private Date updateDate;

    /** 更新人 */
    @Column(name = "update_name", length = 30)
    @ApiModelProperty(name = "更新人", dataType = "String", required = false, notes = "更新人")
    private String updateName;

    public ECBaseTable() {
    }

    @PrePersist
    public void prePersist() {
//        TokenEntity token = TokenContextHolder.getContext();
//        this.createName = token.getUserName();
//        this.createDate = new Date();
//        this.updateName = token.getUserName();
        this.updateDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
//        TokenEntity token = TokenContextHolder.getContext();
//        this.updateName = token.getUserName();
        this.updateDate = new Date();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }
}
