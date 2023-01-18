package com.project.site.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class UserPostDto implements Serializable {
    public static final String FULL_TITLE = "fullTitle";
    private String id;
    private String postTitlePrefix;
    private Boolean defaultPost;
    private Boolean signAuthority;
    private String letterNumber;
    private Date letterDate;
    private byte[] letterContent;
    private String letterFileName;
    private String letterContentType;
    private Date activationTimeFrom;
    private Date activationTimeTo;
    private UserDto user;
    private PostDto post;
    private UserPostDto delegatorUserPost;
    private String fullTitle;

    public UserPostDto() {
    }

    public UserPostDto(String id) {
        this.id = id;
    }

    public UserPostDto(String id, String postTitlePrefix, Boolean defaultPost, Boolean signAuthority, Date activationTimeFrom, Date activationTimeTo, UserDto user, PostDto post, UserPostDto delegatorUserPost, String fullTitle) {
        this.id = id;
        this.postTitlePrefix = postTitlePrefix;
        this.defaultPost = defaultPost;
        this.signAuthority = signAuthority;
        this.activationTimeFrom = activationTimeFrom;
        this.activationTimeTo = activationTimeTo;
        this.user = user;
        this.post = post;
        this.delegatorUserPost = delegatorUserPost;
        this.fullTitle = fullTitle;
    }

    public boolean equals(Object object) {
        if (object instanceof UserPostDto) {
            return this.id != null ? this.id.equals(((UserPostDto)object).getId()) : super.equals(object);
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

    public String getPostTitlePrefix() {
        return this.postTitlePrefix;
    }

    public void setPostTitlePrefix(String postTitlePrefix) {
        this.postTitlePrefix = postTitlePrefix;
    }

    public Boolean getDefaultPost() {
        return this.defaultPost;
    }

    public void setDefaultPost(Boolean defaultPost) {
        this.defaultPost = defaultPost;
    }

    public Boolean getSignAuthority() {
        return this.signAuthority;
    }

    public void setSignAuthority(Boolean signAuthority) {
        this.signAuthority = signAuthority;
    }

    public String getLetterNumber() {
        return this.letterNumber;
    }

    public void setLetterNumber(String letterNumber) {
        this.letterNumber = letterNumber;
    }

    public Date getLetterDate() {
        return this.letterDate;
    }

    public void setLetterDate(Date letterDate) {
        this.letterDate = letterDate;
    }

    public byte[] getLetterContent() {
        return this.letterContent;
    }

    public void setLetterContent(byte[] letterContent) {
        this.letterContent = letterContent;
    }

    public String getLetterFileName() {
        return this.letterFileName;
    }

    public void setLetterFileName(String letterFileName) {
        this.letterFileName = letterFileName;
    }

    public String getLetterContentType() {
        return this.letterContentType;
    }

    public void setLetterContentType(String letterContentType) {
        this.letterContentType = letterContentType;
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

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PostDto getPost() {
        return this.post;
    }

    public void setPost(PostDto post) {
        this.post = post;
    }

    public UserPostDto getDelegatorUserPost() {
        return this.delegatorUserPost;
    }

    public void setDelegatorUserPost(UserPostDto delegatorUserPost) {
        this.delegatorUserPost = delegatorUserPost;
    }

    public String getFullTitle() {
        return this.fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    @JsonIgnore
    public boolean isValid() {
        Date now = new Date();
        return (this.activationTimeFrom == null || now.after(this.activationTimeFrom)) && (this.activationTimeTo == null || now.before(this.activationTimeTo));
    }
}
