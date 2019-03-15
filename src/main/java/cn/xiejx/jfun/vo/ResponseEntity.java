package cn.xiejx.jfun.vo;

import lombok.Data;

/**
 * @Author 谢镜勋
 * @Date 2019/3/12
 */
@Data
public class ResponseEntity {
    private int status;
    private Object message;

    public ResponseEntity success() {
        this.status = 200;
        this.message = "操作成功";
        return this;
    }

    public ResponseEntity status(int status) {
        this.status = status;
        return this;
    }

    public ResponseEntity msg(Object message) {
        this.message = message;
        return this;
    }

    public ResponseEntity error() {
        this.status = 500;
        return this;
    }
}
