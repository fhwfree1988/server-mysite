package com.project.site.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class PostDto implements Serializable {
    public static final String CODE_AND_TITLE = "codeAndTitle";
    private String id;
    private String title;
    private String code;
    private Boolean enabled;
    private Boolean editableByOrgManager;
    //private OrganizationDto organization;
    private HashSet<RoleDto> roles;

    public PostDto() {
    }

    public PostDto(String id) {
        this(id, (String)null, (String)null, (Boolean)null, (Boolean)null, /*(OrganizationDto)null,*/ (HashSet)null);
    }

    public PostDto(String id, String title, String code, Boolean enabled, Boolean editableByOrgManager/*, OrganizationDto organization*/) {
        this(id, title, code, enabled, editableByOrgManager, /*organization,*/ (HashSet)null);
    }

    public PostDto(String id, String title, String code, Boolean enabled, Boolean editableByOrgManager, /*OrganizationDto organization, */HashSet<RoleDto> roles) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.enabled = enabled;
        this.editableByOrgManager = editableByOrgManager;
        //this.organization = organization;
        this.roles = roles;
    }

    public boolean equals(Object object) {
        if (object instanceof PostDto) {
            return this.id != null ? this.id.equals(((PostDto)object).getId()) : super.equals(object);
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEditableByOrgManager() {
        return this.editableByOrgManager;
    }

    public void setEditableByOrgManager(Boolean editableByOrgManager) {
        this.editableByOrgManager = editableByOrgManager;
    }

    @JsonIgnore
    public String getCodeAndTitle() {
        return this.getCode() != null && this.getCode().trim().length() > 0 ? this.getCode() + " : " + this.getTitle() : null;
    }

    /*public OrganizationDto getOrganization() {
        return this.organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }*/

    public HashSet<RoleDto> getRoles() {
        if (this.roles == null) {
            this.roles = new HashSet();
        }

        return this.roles;
    }

    @JsonIgnore
    public HashSet<String> getRolesTitle() {
        HashSet<String> rolesTitle = new HashSet();
        Iterator var2 = this.getRoles().iterator();

        while(var2.hasNext()) {
            RoleDto role = (RoleDto)var2.next();
            rolesTitle.add(role.getTitle());
        }

        return rolesTitle;
    }

    public void setRoles(HashSet<RoleDto> roles) {
        this.roles = roles;
    }
}
