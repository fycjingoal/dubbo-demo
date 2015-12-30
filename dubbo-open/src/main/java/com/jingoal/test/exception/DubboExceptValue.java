package com.jingoal.test.exception;

public enum DubboExceptValue implements ExceptionEnumIface {

    USER_ALREADY_DELETE(1001, "user.already.delete", "用户已经删除"), NOT_RIGHT_OPERATE(1002, "not.right.operate", "您无权操作此用户");

    private DubboExceptValue() {

    }

    private DubboExceptValue(int code, String resKey, String description) {
        this.code = code;
        this.resKey = resKey;
        this.description = description;
    }

    // 错误编码
    private int    code;
    // 国际化key
    private String resKey;
    // 错误描述
    private String description;

    public int getCode() {
        return code;
    }

    public String getResKey() {
        return resKey;
    }

    public String getDescription() {
        return description;
    }

    public String getAjaxLightWarn() {
        return "memo/common/ajaxLightWarn";
    }

    public String getAjaxWarn() {
        return "memo/common/ajaxWarn";
    }

}
