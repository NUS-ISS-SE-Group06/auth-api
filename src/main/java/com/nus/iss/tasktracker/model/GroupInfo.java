package com.nus.iss.tasktracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class GroupInfo {

    public GroupInfo(){
        //Database - Default Value
        this.deleteFlag="FALSE";
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer groupId;

    private String groupName;

    private  String groupDescription;

    private  String createdBy;

    private  String createdDate;

    private  String modifiedBy;

    private  String modifiedDate;

    private String deleteFlag;

    @Override
    public String toString() {
        return "GroupInfo{" +
                "group_id=" + ((groupId != null) ? groupId : "") +
                ", group_name=" + ((groupName != null) ? groupName : "null") +
                ", group_description=" + ((groupDescription != null) ? groupDescription : "null") +
                ", created_by=" + ((createdBy != null) ? createdBy : "null")  +
                ", created_date=" + ((createdDate != null) ? createdDate : "null")  +
                ", modified_by=" + ((modifiedBy != null) ? modifiedBy : "null")  +
                ", modified_date=" + ((modifiedDate != null) ? modifiedDate : "null")  +
                ", delete_flag=" + ((deleteFlag != null) ? deleteFlag : "null")  +
                '}';
    }


}
