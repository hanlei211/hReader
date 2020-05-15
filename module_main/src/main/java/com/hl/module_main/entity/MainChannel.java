package com.hl.module_main.entity;

/**
 * Description: <主频道类型><br>
 * Update:     <br>
 */
public enum MainChannel {
    NEWS(0,"READ"), VIDEO(1,"MESSAGE"),ME(2,"ME");
    public int id;
    public String name;
    MainChannel(int id, String name){
        this.id = id;
        this.name = name;
    }
}
