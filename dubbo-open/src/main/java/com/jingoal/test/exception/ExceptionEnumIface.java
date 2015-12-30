package com.jingoal.test.exception;

/**
 * @Title ExceptionEnumIface.java
 * @Description 异常枚举接口
 * @Author Lee
 * @Since Mar 17, 2015 11:28:25 AM
 * @Copyright Copyright (c) 2015
 * @Company Beijing YiQiTong
 */
public interface ExceptionEnumIface {
    /**
     * 
     * @Title getCode
     * @return
     * @Author Lee
     * @Since Mar 17, 2015 11:45:22 AM
     */
    public int getCode();

    /**
     * 异常的errorCode
     * 
     * @Title getResKey
     * @return
     * @Author Lee
     * @Since Mar 17, 2015 11:30:04 AM
     */
    public String getResKey();

    /**
     * 异常的枚举描述
     * 
     * @Title getDescription
     * @return
     * @Author Lee
     * @Since Mar 17, 2015 11:33:07 AM
     */
    public String getDescription();

    /**
     * 异常抛出的页面轻量级提示
     * 
     * @Title getAjaxLightWarn
     * @return
     * @Author Lee
     * @Since Mar 17, 2015 11:33:19 AM
     */
    public String getAjaxLightWarn();

    /**
     * 异常抛出页面
     * 
     * @Title getAjaxWarn
     * @return
     * @Author Lee
     * @Since Mar 17, 2015 11:41:09 AM
     */
    public String getAjaxWarn();
}
