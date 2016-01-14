/**
 * 
 */
package com.jingoal.test.util;

import java.lang.management.ManagementFactory;

/**
 * @author fuyc@jingoal.com
 *
 */
public class Util {

    public static String getSelfId() {
        return String.format("%s #%d %s",
                ManagementFactory.getRuntimeMXBean().getName(),
                Thread.currentThread().getId(),
                Thread.currentThread()
                );
    }
    
    public static String getSelfId(String desc) {
        return getSelfId() + desc;
    }
}
