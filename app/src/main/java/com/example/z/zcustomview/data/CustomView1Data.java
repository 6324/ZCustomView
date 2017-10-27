package com.example.z.zcustomview.data;

/**
 *消费情况
 * @author z
 * @date 2017/10/27 下午4:15
 */

public class CustomView1Data {
    //购买类别
    private String name;
    //钱的数量
    private float num;

    public CustomView1Data(String name, float num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }
}
