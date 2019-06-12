package com.jimy.server.ec.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jimy.ec.core.interfaces.IEnumInfomation;


public enum EnumDepotExtType implements IEnumInfomation {

    /** 旗舰店 */
    FLAGSHIP(0, "旗舰店"),

    /** 普通C店 */
    C_NORMAL(70, "普通C店"),

    /** 特殊C店 */
    C_SPECIAL(20, "旗舰店"),

    /** 京东LBP店 */
    JD_LBP(300, "京东LBP店"),

    /** 京东SOP店 */
    JD_SOP(400, "京东SOP店"),

    /** 京东SOPL店 */
    JD_SOPL(500, "京东SOPL店"),

    /** 分销店 */
    DISTRIBUTION(600, "分销店"),

    /** 唯品会JIT模式 */
    VIP_JIT(700, "唯品会JIT模式"),

    /** 唯品会常态模式 */
    VIP_OXO(8000, "唯品会常态模式");

    private int value;
    private String name;

    private EnumDepotExtType(int value, String name) {
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
     */
    public static EnumDepotExtType fromValue(int value) throws Exception {

        for (EnumDepotExtType enums : EnumDepotExtType.values()) {
            if (enums.getValue() == value) {
                return enums;
            }
        }
        throw new Exception("按值[" + value + "]未获取到枚举 EnumDepotExtType ！");
    }

}
