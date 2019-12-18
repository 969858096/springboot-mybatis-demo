package com.lsp.springbootmybatisdemo.utils;

import com.lsp.springbootmybatisdemo.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @FileName: ReflectUtils
 * @Description: 反射工具类
 * @AuthOr: lsp
 * @Date: 2019/12/12 22:22
 */
public class ReflectUtils<T> {
    /**    String 属性类型位置  */
    private static String  STRING_INDEX = "java.lang.String";
    /**    Double 属性类型位置  */
    private static String DOUBLE_INDEX = "java.lang.Double";
    /**    Int 属性类型位置  */
    private static String INT_INDEX = "int";
    /**    Integer 属性类型位置  */
    private static String INTEGER_INDEX = "java.lang.Integer";
    /**    Date 属性类型位置  */
    private static String DATE_INDEX = "java.util.Date";
    /**    Boolean 属性类型位置  */
    private static String BOOLEAN_INDEX = "java.lang.Boolean";
    /**    Long 属性类型位置  */
    private static String LONG_INDEX = "java.lang.Long";

    public static Object mapToJavaObject(Class<?> clazz, Map<String,Object> map) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object o = clazz.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            Class<?> paramType = declaredField.getType();
            String StrParamType = paramType.getName();
            String method = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Method set = clazz.getMethod(method,paramType);
            Object value = map.get(fieldName);
            if (STRING_INDEX .equals(StrParamType)){
                set.invoke(o,value.toString());
            }
            if (INTEGER_INDEX .equals(StrParamType)){
                set.invoke(o, Integer.valueOf(value.toString()));
            }
        }
        return o;
    }
}
