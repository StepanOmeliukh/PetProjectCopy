package com.softserve.travelagency.model.enums;

public enum Permission {
    DEVELOPERS_BOOK("developers:book"),
    DEVELOPERS_EDIT("developers:edit");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}