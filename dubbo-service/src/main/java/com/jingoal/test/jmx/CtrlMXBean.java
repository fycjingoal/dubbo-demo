/**
 * 
 */
package com.jingoal.test.jmx;

/**
 * @author fuyc@jingoal.com
 *
 */
public interface CtrlMXBean {
    /**
     * for testing
     * @return
     */
    String getVersion();

    void setSimSlow(long simSlow);

    long getSimSlow();
}
