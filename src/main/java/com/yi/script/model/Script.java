package com.yi.script.model;

/**
 * 命令指令
 * @author YI
 * @date 2018-4-29 19:15:37
 */
public enum Script {
    RED("linux命令", 0), GREEN("linux shll脚本", 1), BLANK("windows命令", 2), YELLO("windows bat脚本", 3);

    // 成员变量
    private String name;
    private int value;

    // 构造方法
    private Script(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.value+"_"+this.name;
    }
}
