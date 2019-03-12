package cn.xiejx.jfun.vo;

import lombok.Data;

/**
 * @Author 谢镜勋
 * @Date 2019/3/12
 */
@Data
public class ResponseEntity {
    private int code;
    private Object message;

    public ResponseEntity success() {
        this.code = 200;
        this.message = "操作成功";
        return this;
    }

    public ResponseEntity code(int code) {
        this.code = code;
        return this;
    }

    public ResponseEntity msg(Object message) {
        this.message = message;
        return this;
    }

    public ResponseEntity error() {
        this.code = 500;
        return this;
    }
}
