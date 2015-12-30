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
        return String.format("%s %s %d",
                ManagementFactory.getRuntimeMXBean().getName(),
                Thread.currentThread(),
                Thread.currentThread().getId());
    }
}
