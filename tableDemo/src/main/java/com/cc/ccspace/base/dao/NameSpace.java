package com.cc.ccspace.base.dao;

public enum NameSpace {

     TestMapper("com.cc.ccspace.mapper.TestMapper");
    private final String value;

    private NameSpace(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}