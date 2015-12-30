/**
 * 
 */
package com.jingoal.test.jmx;

import org.springframework.stereotype.Component;

import com.effectivebiz.mailserver.jmx.JmxBean;
import com.jingoal.test.common.CtrlVar;

/**
 * @author fuyc@jingoal.com
 *
 */
@Component
public class CtrlBean extends JmxBean implements CtrlMXBean {
    
    /* (non-Javadoc)
     * @see com.jingoal.test.jmx.CtrlMXBean#getVersion()
     */
    public String getVersion() {
        return "0.0.2";
    }

    @Override
    public long getSimSlow() {
        return CtrlVar.simSlow;
    }

    @Override
    public void setSimSlow(long arg) {
        CtrlVar.simSlow = arg;
    }

}
