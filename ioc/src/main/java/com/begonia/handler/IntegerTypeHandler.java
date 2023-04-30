package com.begonia.handler;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 5:17 PM
 */
public class IntegerTypeHandler implements TypeHandler{
    @Override
    public boolean supports(Class<?> type) {
        return type == Integer.class;
    }

    @Override
    public Object handleType(String stringValue) {
        return Integer.parseInt(stringValue);
    }
}
