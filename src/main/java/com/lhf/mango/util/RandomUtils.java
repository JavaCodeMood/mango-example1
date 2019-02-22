package com.lhf.mango.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @ClassName: RandomUtils
 * @Desc:
 * @Author: liuhefei
 * @Date: 2018/12/21 11:55
 */
public class RandomUtils {

    public static String randomStringId(int count) {
        return RandomStringUtils.random(count, false, true);
    }
}
