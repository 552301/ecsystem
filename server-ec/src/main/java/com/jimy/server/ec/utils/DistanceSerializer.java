package com.jimy.server.ec.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jimy.ec.core.interfaces.IEnumInfomation;
import com.jimy.server.ec.enums.EnumDepotExtType;
import org.springframework.data.geo.Distance;

import java.io.IOException;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author jimy
 * @create 2019/3/21
 * @since 1.0.0
 */
public class DistanceSerializer extends JsonSerializer<EnumDepotExtType> {

    @Override
    public void serialize(EnumDepotExtType value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
//        generator.writeFieldName("name");
//        generator.writeNumber(value.getName());
        generator.writeFieldName("value");
        generator.writeNumber(value.getValue());
        generator.writeEndObject();
    }
}