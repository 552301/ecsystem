package com.jimy.ec.core.interfaces;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * 〈一句话功能简述〉
 * 〈通用枚举转换接口实现类〉
 *
 * @author jimy
 * @create 2019/3/21
 * @since 1.0.0
 */
public class EnumConverterFactory implements ConverterFactory<Integer, IEnumInfomation> {


    @Override
    public <T extends IEnumInfomation> Converter<Integer, T> getConverter(Class<T> targetType) {
        return new EnumvalueToIEnum<>(targetType);
    }

    private static class EnumvalueToIEnum<T extends IEnumInfomation>  implements Converter<Integer, T> {
        private  Class<T> targerType;
        /**
         * Instantiates a new String to i eum.
         *
         * @param targerType the targer type
         */
        public EnumvalueToIEnum(Class<T> targerType) {
            this.targerType = targerType;
        }

        @Override
        public T convert(Integer source) {
            if(source == null)
                return null;
            return (T) getIEnum(this.targerType,source);
        }
    }

    public static <T extends IEnumInfomation> Object getIEnum(Class<T> targerType, Integer source) {
        for(T enumObj : targerType.getEnumConstants()){
            if(source .equals( enumObj.getValue())){
                return enumObj;
            }
        }
        return null;
    }
}
