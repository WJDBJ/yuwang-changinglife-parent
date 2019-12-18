package com.util;

import org.springframework.beans.BeanUtils;

/**
 * @author XJ
 */
public class CopyUtil {
    public static Object copy(Object object,Class<?> clz) {
        Object result = null;
        try {
            result = clz.newInstance();
            BeanUtils.copyProperties(object,result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }
}
