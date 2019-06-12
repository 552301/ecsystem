package com.jimy.server.ec.converter;

import com.jimy.server.ec.enums.EnumDepotExtType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author jimy
 * @create 2019/3/21
 * @since 1.0.0
 */
@Converter(autoApply = true)
public class EnumDepotExtConverter implements AttributeConverter<EnumDepotExtType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EnumDepotExtType attribute) {
        return attribute.getValue();
    }

    @Override
    public EnumDepotExtType convertToEntityAttribute(Integer dbData) {
        try {
            return EnumDepotExtType.fromValue(dbData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
