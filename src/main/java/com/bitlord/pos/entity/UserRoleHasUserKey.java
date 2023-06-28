package com.bitlord.pos.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class UserRoleHasUserKey implements Serializable {

    @Column(length = 45, name = "user_id")
    private String userId;

    @Column(length = 45, name = "role_id")
    private String roleId;

}