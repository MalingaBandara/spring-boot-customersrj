package com.bitlord.pos.security;

public enum ApplicationUserPermission {

    // Permission Enum
    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write"),
    ITEM_READ("item:read"),
    ITEM_WRITE("item:write");


    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }

}
