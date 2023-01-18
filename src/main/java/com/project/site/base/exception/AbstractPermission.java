package com.project.site.base.exception;

import java.io.Serializable;

@FunctionalInterface
public interface AbstractPermission extends Serializable {
    String SEARCH_PERMISSION_POSTFIX = ".search";
    String CREATE_PERMISSION_POSTFIX = ".create";
    String DISPLAY_PERMISSION_POSTFIX = ".display";
    String DELETE_PERMISSION_POSTFIX = ".delete";
    String LIST_REPORT_PERMISSION_POSTFIX = ".list.report";
    String PRINT_PERMISSION_POSTFIX = ".print";

    String getId();

    default String getPermissionPrefix() {
        return null;
    }
}
