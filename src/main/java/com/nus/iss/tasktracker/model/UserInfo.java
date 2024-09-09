package com.nus.iss.tasktracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Setter
@Getter
@Entity
public class UserInfo {

    public UserInfo(){
        //Database - Default Value
        this.deleteFlag="FALSE";
        this.passwordChangeMandatory="TRUE";
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;

    private Integer groupId;

    private String email;

    private String name;

    private String username;

    private  String password;

    private  String role;

    private  String passwordChangeMandatory;

    private  String createdBy;

    private  Timestamp createdDate;

    private  String modifiedBy;

    private  Timestamp modifiedDate;

    private String deleteFlag;

    @Transient
    private String groupName;

    @Override
    public String toString() {
        return "UserInfo{" +
                "user_id=" + ((userId  != null ) ? userId : "") +
                ", name=" + ((name != null) ? name : "null") +
                ", email=" + ((email != null) ? email : "null") +
                ", username=" + ((username != null) ? username : "null") +
                ", group_id=" + ((groupId != null) ? groupId : "null") +
                ", role=" + ((role != null) ? role : "null") +
                ", password_change_mandatory=" + ((passwordChangeMandatory != null ) ? passwordChangeMandatory : "null") +
                ", created_by=" + ((createdBy != null) ? createdBy : "null")  +
                ", created_date=" + ((createdDate != null) ? createdDate : "null")  +
                ", modified_by=" + ((modifiedBy != null) ? modifiedBy : "null")  +
                ", modified_date=" + ((modifiedDate != null) ? modifiedDate : "null")  +
                ", delete_flag=" + ((deleteFlag != null) ? deleteFlag : "null")  +
                //Transient Field - ForeignKey Description
                ", groupName=" + ((groupName != null) ? groupName : "null")  +
                '}';
    }

}
