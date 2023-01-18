package com.project.site.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class RoleDto implements Serializable {
    public static final String TITLE = "title";
    private String id;
    private String name;
    private String title;

    public RoleDto() {
    }

    public RoleDto(String id) {
        this(id, (String)null, (String)null);
    }

    public RoleDto(String id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public boolean equals(Object object) {
        if (object instanceof RoleDto) {
            return this.id != null ? this.id.equals(((RoleDto)object).getId()) : super.equals(object);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.getId() == null ? super.hashCode() : this.getId().hashCode();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
