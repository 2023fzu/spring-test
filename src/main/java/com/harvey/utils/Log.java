package com.harvey.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : MyLog
 * @date : 2023/11/03 00:17
 **/

public class Log {
    private static final Logger LOGGER = LoggerFactory.getLogger("SpringLog");

    /**
     * @param o 随便输,像输啥就输啥
     */
    public static void  info(Object o) {
        LOGGER.info(o.toString());
    }

    /**
     * @param o 随便输,像输啥就输啥
     */
    public static void error(Object o){
        LOGGER.error(o.toString());
    }

}
