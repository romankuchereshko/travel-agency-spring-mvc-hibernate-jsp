package com.travel.agency.model;

public enum Permission {
    ADMIN_PERMISSION("ADMIN"),
    USER_PERMISSION("USER");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
