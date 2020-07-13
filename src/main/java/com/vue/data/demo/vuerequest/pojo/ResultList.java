package com.vue.data.demo.vuerequest.pojo;

import java.util.List;
/**
 * @author hsy
 */
public class ResultList {
    /**
     * code:0
     * data:[{id: 1,name: 'Tom',age: 12,gender: '男'},{id: 2,name: 'Jerry',age: 14,gender: '女'}]
     */


private int code;
private List<User> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
