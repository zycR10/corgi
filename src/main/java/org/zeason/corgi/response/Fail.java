package org.zeason.corgi.response;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/9 23:21
 */
public class Fail extends BaseResponse {
    public Fail(Object resultMessage) {
        super.setRs(0);
        super.setResultMessage(resultMessage);
    }

    public Fail() {
        setRs(0);
        setResultMessage("fail");
    }
}
