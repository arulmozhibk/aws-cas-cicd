package com.aws.cas.casapi;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

@DynamoDBTable(tableName="CasUserTable")
public class CasUser{
    private String orgId;
    private String groupId ;
    private String userId  ;
    private String name    ;
    private String email   ;
    private String password;
    private String roleId  ;

    @DynamoDBAttribute(attributeName="orgId")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
@DynamoDBAttribute(attributeName="groupId")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
@DynamoDBHashKey(attributeName="userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
@DynamoDBAttribute(attributeName="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@DynamoDBAttribute(attributeName="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@DynamoDBAttribute(attributeName="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


@DynamoDBAttribute(attributeName="roleId")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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