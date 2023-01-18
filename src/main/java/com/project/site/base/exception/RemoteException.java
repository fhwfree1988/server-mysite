package com.project.site.base.exception;

import com.fasterxml.jackson.annotation.*;
import com.project.site.base.util.StringUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class RemoteException extends RuntimeException {
    public static final String CONTENT_TYPE_PROBLEM_JSON_UTF8 = "application/problem+json;charset=utf-8";
    public static final String ACCEPT_LANGUAGE_HEADER_NAME = "Accept-Language";
    public static final String CONTENT_LANGUAGE_HEADER_NAME = "Content-Language";
    public static final String EXTENDED_PROPERTIES_PARAM_PREFIX = "param";
    public static final String EXTENDED_PROPERTIES_PERMISSION = "permission";
    private Integer status;
    private Integer type;
    private String title;
    private String detail;
    private Map<String, Object> extendedProperties;
    @JsonIgnore
    private boolean logOnServer;

    protected RemoteException(Integer status) {
        this(status, (Integer)null, (String)null, (String)null, (Map)null, (Throwable)null);
    }

    protected RemoteException(Integer status, Integer type, String title) {
        this(status, type, title, title, (Map)null, (Throwable)null);
    }

    protected RemoteException(Integer status, Integer type, String title, Throwable cause) {
        this(status, type, title, title, (Map)null, cause);
    }

    @JsonCreator
    protected RemoteException(@JsonProperty("status") Integer status, @JsonProperty("type") Integer type, @JsonProperty("title") String title, @JsonProperty("detail") String detail) {
        this(status, type, title, detail, (Map)null, (Throwable)null);
    }

    protected RemoteException(Integer status, Integer type, String title, String detail, Throwable cause) {
        this(status, type, title, detail, (Map)null, false, cause);
    }

    protected RemoteException(Integer status, Integer type, String title, String detail, Map<String, Object> extendedProperties, Throwable cause) {
        this(status, type, title, detail, extendedProperties, false, cause);
    }

    protected RemoteException(Integer status, Integer type, String title, String detail, Map<String, Object> extendedProperties) {
        this(status, type, title, detail, extendedProperties, false, (Throwable)null);
    }

    protected RemoteException(Integer status, Integer type, String title, String detail, Map<String, Object> extendedProperties, boolean logOnServer, Throwable cause) {
        super("RemoteException(status=[" + status + "], type=[" + type + "], title=[" + title + "], detail=[" + detail + "], extendedProperties=[" + extendedProperties + "])", cause);
        if (status == null) {
            throw new IllegalArgumentException("'status' cannot be null.");
        } else {
            this.status = status;
            this.type = type;
            this.title = title;
            this.detail = detail;
            this.extendedProperties = extendedProperties;
            this.logOnServer = logOnServer;
        }
    }

    public Integer getStatus() {
        return this.status;
    }

    @JsonIgnore
    public Integer getType() {
        return this.type;
    }

    @JsonProperty("type")
    public String getTypeToString() {
        return this.type != null ? this.type.toString() : null;
    }

    @JsonProperty("type")
    public void setTypeToString(String typeToString) {
        this.type = StringUtil.hasText(typeToString) ? Integer.parseInt(typeToString) : null;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDetail() {
        return this.detail;
    }

    @JsonAnySetter
    public void addExtendedProperties(String key, String value) {
        this.getExtendedProperties().put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getExtendedProperties() {
        if (this.extendedProperties == null) {
            this.extendedProperties = new LinkedHashMap();
        }

        return this.extendedProperties;
    }

    public boolean getLogOnServer() {
        return this.logOnServer;
    }

    @JsonIgnore
    public String getMessage() {
        return this.getDetail();
    }

    @JsonIgnore
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @JsonIgnore
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof RemoteException)) {
            return false;
        } else {
            RemoteException remoteException = (RemoteException)o;
            return this.status == remoteException.status && Objects.equals(this.type, remoteException.type) && Objects.equals(this.title, remoteException.title) && Objects.equals(this.detail, remoteException.detail);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.status, this.type, this.title, this.detail});
    }
}
