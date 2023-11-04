package com.harvey;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


/**
 * @author : HarveyBlocks
 * @version : 1.0
 * @className : TestLogger
 * @date : 2023/10/30 00:36
 **/
public class TestLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger("TestSpring");

    /**
    * @param o 随便输,想输啥就输啥
    */
    public static void  info(Object o) {
        LOGGER.info(o.toString());
    }

    /**
     * @param o 随便输,想输啥就输啥
     */
    public static void  error(Object o) {
        if(o instanceof Throwable){
            LOGGER.error(((Throwable) o).getMessage());
        }
        LOGGER.error(o.toString());
    }
}
