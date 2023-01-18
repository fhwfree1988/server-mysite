package com.project.site.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.site.base.util.StringUtil;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class UserDto implements Serializable {
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String NATIONAL_CODE = "nationalCode";
    public static final String MOBILE_NUMBER = "mobileNumber";
    public static final String ENABLED = "enabled";
    public static final String ENABLING_REASON = "enablingReason";
    public static final String IS_LDAP_BASED = "isLdapBased";
    public static final String ACTIVATION_TIME_FROM = "activationTimeFrom";
    public static final String ACTIVATION_TIME_FROM_FROM = "activationTimeFromFrom";
    public static final String ACTIVATION_TIME_FROM_TO = "activationTimeFromTo";
    public static final String ACTIVATION_TIME_TO = "activationTimeTo";
    public static final String ACTIVATION_TIME_TO_FROM = "activationTimeToFrom";
    public static final String ACTIVATION_TIME_TO_TO = "activationTimeToTo";
    public static final String ACTIVATION_START_HOUR = "activationStartHour";
    public static final String ACTIVATION_END_HOUR = "activationEndHour";
    public static final String LAST_LOGIN_TIME = "lastLoginTime";
    public static final String FORCE_PASSWORD_CHANGE = "forcePasswordChange";
    public static final String LAST_PASSWORD_CHANGE_TIME = "lastPasswordChangeTime";
    public static final String IS_SUPERVISOR = "isSupervisor";
    public static final String INCORRECT_LOGINS_COUNT = "incorrectLoginsCount";
    public static final String INCORRECT_LOGIN_DISABLED_TIME = "incorrectLoginDisabledTime";
    public static final String BROWSER_LOGIN_AUTHORITY = "browserLoginAuthority";
    public static final String SERVICE_LOGIN_AUTHORITY = "serviceLoginAuthority";
    public static final String CREATION_TIME = "creationTime";
    public static final String LAST_UPDATE_TIME = "lastUpdateTime";
    public static final String PICTURE = "picture";
    public static final String SIGNATURE = "signature";
    public static final String ROLES = "roles";
    public static final String IP_RANGES = "ipRanges";
    public static final String USER_POSTS = "userPosts";
    public static final String FULL_NAME = "fullName";
    public static final String HAS_USER_PROFILE_CHANGE_PICTURE_PERMISSION = "hasUserProfileChangePicturePermission";
    public static final String REAUTHENTICATION_URLS = "reauthenticationUrls";
    public static final String ROLE_PERMISSIONS_ID = "rolePermissionsId";
    public static final String ALL_PERMISSIONS = "allPermissions";
    public static final String ALL_PERMISSIONS_ID = "allPermissionsId";
    public static final String CURRENT_USER_POST = "currentUserPost";
    public static final String DELEGATED_USER_POSTS = "delegatedUserPosts";
    public static final String MENUS = "menus";
    public static final String PERMISSION_WITH_DATA_SET = "permissionWithDataSet";
    public static final String EXTRA_INFO_MAP = "extraInfoMap";
    public static final String ADDITIONAL_ACCESS_TOKENS = "additionalAccessTokens";
    public static final String SSI = "ssi";
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String nationalCode;
    private String mobileNumber;
    private Boolean enabled;
    private String enablingReason;
    private Boolean isLdapBased;
    private Date activationTimeFrom;
    private Date activationTimeTo;
    private Integer activationStartHour;
    private Integer activationEndHour;
    private String pictureContentBase64Url;
    private Date lastLoginTime;
    private Boolean forcePasswordChange;
    private Boolean isSupervisor;
    private Boolean browserLoginAuthority;
    private Boolean serviceLoginAuthority;
    private Date creationTime;
    private Date lastUpdateTime;
    private boolean hasUserProfileChangePicturePermission;
    private String reauthenticationUrls;
    /*private FileDto picture;
    private FileDto signature;
    private HashSet<RoleDto> roles;
    private HashSet<PermissionDto> allPermissions;
    private HashSet<String> allPermissionsId;
    private HashSet<IpRangeDto> ipRanges;
    private ArrayList<UserPostDto> userPosts;
    private UserPostDto currentUserPost;
    private ArrayList<UserPostDto> delegatedUserPosts;
    private ArrayList<MenuDto> menus;
    private HashSet<PermissionWithDataDto> permissionWithDataSet;
    private HashMap<String, Object> extraInfoMap;
    private ArrayList<KeyValueDto> additionalAccessTokens;
    private boolean isWsCall;
    private boolean checkAuthorization;
    private Date loginTime;
    private String ssi;*/

    public UserDto() {
        //this.isWsCall = false;
        //this.checkAuthorization = true;
    }

    public UserDto(String id) {
        //this.isWsCall = false;
        //this.checkAuthorization = true;
        this.id = id;
    }

    /*public UserDto(String id, String username, String firstName, String lastName, Boolean enabled, Boolean forcePasswordChange, Boolean isSupervisor, Boolean browserLoginAuthority, Boolean serviceLoginAuthority, Boolean isLdapBased) {
        this(id, username, firstName, lastName, (String)null, (String)null, enabled, (String)null, (Date)null, (Date)null, (Integer)null, (Integer)null, (String)null, (Date)null, forcePasswordChange, isSupervisor, browserLoginAuthority, serviceLoginAuthority, isLdapBased, (Date)null, (Date)null, false, (String)null, (HashSet)null, (HashSet)null, (HashSet)null, (HashSet)null, (ArrayList)null, (UserPostDto)null, (ArrayList)null, (ArrayList)null, (HashSet)null, (HashMap)null, (ArrayList)null, (Date)null, (String)null);
    }*/

    /*public UserDto(String id, String username, String firstName, String lastName, String nationalCode, String mobileNumber, Boolean enabled, String enablingReason, Date activationTimeFrom, Date activationTimeTo, Integer activationStartHour, Integer activationEndHour, String pictureContentBase64Url, Date lastLoginTime, Boolean forcePasswordChange, Boolean isSupervisor, Boolean browserLoginAuthority, Boolean serviceLoginAuthority, Boolean isLdapBased, Date creationTime, Date lastUpdateTime, boolean hasUserProfileChangePicturePermission, String reauthenticationUrls, HashSet<RoleDto> roles, HashSet<PermissionDto> allPermissions, HashSet<String> allPermissionsId, HashSet<IpRangeDto> ipRanges, ArrayList<UserPostDto> userPosts, UserPostDto currentUserPost, ArrayList<UserPostDto> delegatedUserPosts, ArrayList<MenuDto> menus, HashSet<PermissionWithDataDto> permissionWithDataSet, HashMap<String, Object> extraInfoMap, ArrayList<KeyValueDto> additionalAccessTokens, Date loginTime, String ssi) {
        this.isWsCall = false;
        this.checkAuthorization = true;
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.mobileNumber = mobileNumber;
        this.enabled = enabled;
        this.enablingReason = enablingReason;
        this.isLdapBased = isLdapBased;
        this.activationTimeFrom = activationTimeFrom;
        this.activationTimeTo = activationTimeTo;
        this.activationStartHour = activationStartHour;
        this.activationEndHour = activationEndHour;
        this.pictureContentBase64Url = pictureContentBase64Url;
        this.lastLoginTime = lastLoginTime;
        this.forcePasswordChange = forcePasswordChange;
        this.isSupervisor = isSupervisor;
        this.browserLoginAuthority = browserLoginAuthority;
        this.serviceLoginAuthority = serviceLoginAuthority;
        this.lastUpdateTime = lastUpdateTime;
        this.creationTime = creationTime;
        this.hasUserProfileChangePicturePermission = hasUserProfileChangePicturePermission;
        this.reauthenticationUrls = reauthenticationUrls;
        this.roles = roles;
        this.allPermissions = allPermissions;
        this.allPermissionsId = allPermissionsId;
        this.ipRanges = ipRanges;
        this.userPosts = userPosts;
        this.currentUserPost = currentUserPost;
        this.delegatedUserPosts = delegatedUserPosts;
        this.menus = menus;
        this.permissionWithDataSet = permissionWithDataSet;
        this.extraInfoMap = extraInfoMap;
        this.additionalAccessTokens = additionalAccessTokens;
        this.loginTime = loginTime;
        this.ssi = ssi;
    }*/

    public boolean equals(Object object) {
        if (object instanceof UserDto) {
            return this.id != null ? this.id.equals(((UserDto)object).getId()) : super.equals(object);
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonIgnore
    public String getFullName() {
        return StringUtil.hasText(this.getFirstName()) ? this.getFirstName() + "\u200c" + " " + this.getLastName() + " (" + this.getUsername() + ")" : null;
    }

    public void setFullName(String fullName) {
        if (StringUtil.hasText(fullName) && fullName.contains("\u200c")) {
            this.setFirstName(fullName.substring(0, fullName.indexOf("\u200c")));
            this.setLastName(fullName.substring(fullName.indexOf("\u200c") + 2, fullName.lastIndexOf(40) - 1));
            this.setUsername(fullName.substring(fullName.lastIndexOf(40) + 1, fullName.length() - 1));
        } else {
            this.setFirstName((String)null);
            this.setLastName((String)null);
            this.setUsername((String)null);
        }

    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalCode() {
        return this.nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEnablingReason() {
        return this.enablingReason;
    }

    public void setEnablingReason(String enablingReason) {
        this.enablingReason = enablingReason;
    }

    public Boolean getIsLdapBased() {
        return this.isLdapBased;
    }

    public void setIsLdapBased(Boolean isLdapBased) {
        this.isLdapBased = isLdapBased;
    }

    public Date getActivationTimeFrom() {
        return this.activationTimeFrom;
    }

    public void setActivationTimeFrom(Date activationTimeFrom) {
        this.activationTimeFrom = activationTimeFrom;
    }

    public Date getActivationTimeTo() {
        return this.activationTimeTo;
    }

    public void setActivationTimeTo(Date activationTimeTo) {
        this.activationTimeTo = activationTimeTo;
    }

    public Integer getActivationStartHour() {
        return this.activationStartHour;
    }

    public void setActivationStartHour(Integer activationStartHour) {
        this.activationStartHour = activationStartHour;
    }

    public Integer getActivationEndHour() {
        return this.activationEndHour;
    }

    public void setActivationEndHour(Integer activationEndHour) {
        this.activationEndHour = activationEndHour;
    }

    public String getPictureContentBase64Url() {
        return this.pictureContentBase64Url;
    }

    public void setPictureContentBase64Url(String pictureContentBase64Url) {
        this.pictureContentBase64Url = pictureContentBase64Url;
    }

    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Boolean getForcePasswordChange() {
        return this.forcePasswordChange;
    }

    public void setForcePasswordChange(Boolean forcePasswordChange) {
        this.forcePasswordChange = forcePasswordChange;
    }

    public Boolean getIsSupervisor() {
        return this.isSupervisor;
    }

    public void setIsSupervisor(Boolean isSupervisor) {
        this.isSupervisor = isSupervisor;
    }

    public Boolean getBrowserLoginAuthority() {
        return this.browserLoginAuthority;
    }

    public void setBrowserLoginAuthority(Boolean browserLoginAuthority) {
        this.browserLoginAuthority = browserLoginAuthority;
    }

    public Boolean getServiceLoginAuthority() {
        return this.serviceLoginAuthority;
    }

    public void setServiceLoginAuthority(Boolean serviceLoginAuthority) {
        this.serviceLoginAuthority = serviceLoginAuthority;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public boolean getHasUserProfileChangePicturePermission() {
        return this.hasUserProfileChangePicturePermission;
    }

    public void setHasUserProfileChangePicturePermission(boolean hasUserProfileChangePicturePermission) {
        this.hasUserProfileChangePicturePermission = hasUserProfileChangePicturePermission;
    }

    public String getReauthenticationUrls() {
        return this.reauthenticationUrls;
    }

    public void setReauthenticationUrls(String reauthenticationUrls) {
        this.reauthenticationUrls = reauthenticationUrls;
    }

    /*public FileDto getPicture() {
        return this.picture;
    }

    public void setPicture(FileDto picture) {
        this.picture = picture;
    }

    public FileDto getSignature() {
        return this.signature;
    }

    public void setSignature(FileDto signature) {
        this.signature = signature;
    }

    public HashSet<RoleDto> getRoles() {
        if (this.roles == null) {
            this.roles = new HashSet();
        }

        return this.roles;
    }

    public void setRoles(HashSet<RoleDto> roles) {
        this.roles = roles;
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

     HashSet<PermissionDto> getAllPermissions() {
        if (this.allPermissions == null) {
            this.allPermissions = new HashSet();
        }

        return this.allPermissions;
    }

    public void setAllPermissions(HashSet<PermissionDto> allPermissions) {
        this.allPermissions = allPermissions;
    }

    public HashSet<String> getAllPermissionsId() {
        if (this.allPermissionsId == null) {
            this.allPermissionsId = new HashSet();
        }

        return this.allPermissionsId;
    }

    public void setAllPermissionsId(HashSet<String> allPermissionsId) {
        this.allPermissionsId = allPermissionsId;
    }

    public HashSet<IpRangeDto> getIpRanges() {
        if (this.ipRanges == null) {
            this.ipRanges = new HashSet();
        }

        return this.ipRanges;
    }

    public void setIpRanges(HashSet<IpRangeDto> ipRanges) {
        this.ipRanges = ipRanges;
    }

    public ArrayList<UserPostDto> getUserPosts() {
        if (this.userPosts == null) {
            this.userPosts = new ArrayList();
        }

        return this.userPosts;
    }

    public void setUserPosts(ArrayList<UserPostDto> userPosts) {
        this.userPosts = userPosts;
    }

    public UserPostDto getCurrentUserPost() {
        return this.currentUserPost;
    }

    public void setCurrentUserPost(UserPostDto currentUserPost) {
        this.currentUserPost = currentUserPost;
    }

    public ArrayList<UserPostDto> getDelegatedUserPosts() {
        if (this.delegatedUserPosts == null) {
            this.delegatedUserPosts = new ArrayList();
        }

        return this.delegatedUserPosts;
    }

    public void setDelegatedUserPosts(ArrayList<UserPostDto> delegatedUserPosts) {
        this.delegatedUserPosts = delegatedUserPosts;
    }

    public ArrayList<MenuDto> getMenus() {
        if (this.menus == null) {
            this.menus = new ArrayList();
        }

        return this.menus;
    }

    public void setMenus(ArrayList<MenuDto> menus) {
        this.menus = menus;
    }

    public HashSet<PermissionWithDataDto> getPermissionWithDataSet() {
        if (this.permissionWithDataSet == null) {
            this.permissionWithDataSet = new HashSet();
        }

        return this.permissionWithDataSet;
    }

    public void setPermissionWithDataSet(HashSet<PermissionWithDataDto> permissionWithDataSet) {
        this.permissionWithDataSet = permissionWithDataSet;
    }

    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public HashMap<String, Object> getExtraInfoMap() {
        if (this.extraInfoMap == null) {
            this.extraInfoMap = new HashMap();
        }

        return this.extraInfoMap;
    }

    public void setExtraInfoMap(HashMap<String, Object> extraInfoMap) {
        this.extraInfoMap = extraInfoMap;
    }

    public ArrayList<KeyValueDto> getAdditionalAccessTokens() {
        if (this.additionalAccessTokens == null) {
            this.additionalAccessTokens = new ArrayList();
        }

        return this.additionalAccessTokens;
    }

    public void setAdditionalAccessTokens(ArrayList<KeyValueDto> additionalAccessTokens) {
        this.additionalAccessTokens = additionalAccessTokens;
    }

    @JsonIgnore
    public boolean getIsWsCall() {
        return this.isWsCall;
    }

    public void setIsWsCall(boolean isWsCall) {
        this.isWsCall = isWsCall;
    }

    @JsonIgnore
    public boolean getCheckAuthorization() {
        return this.checkAuthorization;
    }

    public void setCheckAuthorization(boolean checkAuthorization) {
        this.checkAuthorization = checkAuthorization;
    }

    public Date getLoginTime() {
        return this.loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getSsi() {
        return this.ssi;
    }

    public void setSsi(String ssi) {
        this.ssi = ssi;
    }*/
}
