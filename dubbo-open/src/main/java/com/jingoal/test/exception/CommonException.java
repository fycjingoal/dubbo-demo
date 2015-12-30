package com.jingoal.test.exception;


/**
 * @description: 自定义异常类型，页面弹框提示
 * 
 * @company: 亿企通信息技术有限公司
 * @author: chenbin
 * @time: 2015-1-31 下午1:16:15
 */
public class CommonException extends RuntimeException {

    private static final long  serialVersionUID = 8817486119953958786L;

    private ExceptionEnumIface ei;

    public CommonException() {
    }

    public CommonException(ExceptionEnumIface ei) {
        this.ei = ei;
    }

    public ExceptionEnumIface getEi() {
        return ei;
    }

    public void setEi(ExceptionEnumIface ei) {
        this.ei = ei;
    }
}
