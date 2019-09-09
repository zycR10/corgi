package org.zeason.corgi.response;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/9 23:19
 */
public class BaseResponse {
    private Integer rs;
    private Object resultMessage;

    public Integer getRs() {
        return rs;
    }

    public void setRs(Integer rs) {
        this.rs = rs;
    }

    public Object getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(Object resultMessage) {
        this.resultMessage = resultMessage;
    }
}
