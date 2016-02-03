package com.pvelychko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pvelychko.model.enums.UserProfileType;

@Entity
@Table(name="UserProfile")
public class UserProfile extends BaseItem {

    @Column(name="type", length=15, unique=true, nullable=false)
    private String type = UserProfileType.USER.getUserProfileType();
   
    // Type
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.getId();
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserProfile))
            return false;
        UserProfile other = (UserProfile) obj;
        if (super.getId() != other.getId())
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "UserProfile [id=" + super.getId() + ", type=" + type  + "]";
    }

}
