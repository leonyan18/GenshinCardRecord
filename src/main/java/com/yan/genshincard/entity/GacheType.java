package com.yan.genshincard.entity;

public enum GacheType {
    // 新手池
    NOVICE("新手池",100),
    // up池
    UP("up池",301),
    // 武器池
    WEAPON("武器池",302),
    // 常驻池
    PERMANENT("常驻池",200);

    private String name;
    private Integer value;
    private GacheType(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
