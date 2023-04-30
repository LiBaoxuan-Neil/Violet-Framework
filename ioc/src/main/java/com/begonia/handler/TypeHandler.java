package com.begonia.handler;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : LiBaoxuan
 * @create 2023/4/30 5:15 PM
 */
public interface TypeHandler {

    boolean supports(Class<?> type);

    Object handleType(String stringValue);

}
