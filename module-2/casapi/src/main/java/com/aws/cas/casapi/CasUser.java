package com.aws.cas.casapi;
public class CasUser{
    private String orgId;
    private String groupId ;
    private String userId  ;
    private String name    ;
    private String roleId  ;
    private String email   ;
    private String password;

    public CasUser() {
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CasUser{" +
                "orgId='" + orgId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", roleId='" + roleId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}