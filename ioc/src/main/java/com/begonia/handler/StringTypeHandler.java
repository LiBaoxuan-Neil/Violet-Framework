package com.begonia.handler;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 5:28 PM
 */
public class StringTypeHandler implements TypeHandler{
    @Override
    public boolean supports(Class<?> type) {
        return type == String.class;
    }

    @Override
    public Object handleType(String stringValue) {
        return stringValue;
    }
}
