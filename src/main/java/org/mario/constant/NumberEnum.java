package org.mario.constant;

/**
 * @author CYX
 * @Date: 2018/11/15 11:46
 */
public enum NumberEnum {

    ZERO_STR("0"),
    ZERO_NUM(0),
    ONE_STR("1"),
    ONE_NUM(1),
    TWO_STR("2"),
    TWO_NUM(2);

    private String numStr;
    private int num;

    public String getNumStr() {
        return numStr;
    }

    public int getNum() {
        return num;
    }

    NumberEnum(String numStr) {
        this.numStr = numStr;
    }

    NumberEnum(int num) {
        this.num = num;
    }
}
