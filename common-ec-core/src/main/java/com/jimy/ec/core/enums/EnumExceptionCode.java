package com.jimy.ec.core.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jimy.ec.core.interfaces.IEnumInfomation;

/**
 * 〈一句话功能简述〉
 * 〈全局异常编号枚举类〉
 *
 * @author 周金明
 * @create 2019/4/28
 * @since 1.0.0
 */
public enum EnumExceptionCode implements IEnumInfomation {
    /** 业务错误 */
    BUSINESSPROPERTIES(-1,"业务错误"),

    /** 正常 */
    NONE(0, "正常"),

    /** 空值 */
    NULLOREMPTY(1, "空值"),

    /** SESSION找不到 */
    SESSIONNOTFOUND(2, "SESSION找不到"),

    /** 属性错误 */
    ILLEGALPROPERTIES(3, "属性错误"),

    /** 数据验证 */
    METHODARGUMENTNOTVALID(4, "数据验证"),

    /** 通用错误代码 */
    EXCEPTION(5, "通用错误代码");

    private int value;
    private String name;

    EnumExceptionCode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /** 获取值 */
    @Override
    @JsonValue
    public int getValue() {
        return this.value;
    }

    /** 获取名称 */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 按枚举值获取枚举类型
     *
     * @param value
     * @return
     * @throws Exception
     */
    public static EnumExceptionCode fromValue(int value) throws Exception {

        for (EnumExceptionCode enums : EnumExceptionCode.values()) {
            if (enums.getValue() == value) {
                return enums;
            }
        }
        throw new Exception("按值[" + value + "]未获取到枚举 EnumExceptionCode ！");
    }
}
