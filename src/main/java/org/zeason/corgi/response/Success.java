package org.zeason.corgi.response;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/9/9 23:21
 */
public class Success extends BaseResponse {
    public Success(Object resultMessage) {
        super.setRs(1);
        setResultMessage(resultMessage);
    }
}
