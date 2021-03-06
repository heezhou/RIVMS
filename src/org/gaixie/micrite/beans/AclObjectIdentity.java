/* ===========================================================
 * $Id: AclObjectIdentity.java 520 2009-08-27 05:59:23Z bitorb $
 * This file is part of Micrite
 * ===========================================================
 *
 * (C) Copyright 2009, by Gaixie.org and Contributors.
 * 
 * Project Info:  http://micrite.gaixie.org/
 *
 * Micrite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Micrite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Micrite.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.gaixie.micrite.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * ACL领域对象实例相关信息。
 */
@Entity
@Table(name = "acl_object_identity")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AclObjectIdentity {

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne(targetEntity = AclClass.class)
    @JoinColumn(name = "object_id_class", nullable = false)
    private AclClass aclClass;

    @Column(name = "object_id_identity", nullable = false)
    private long objectId;

    @ManyToOne(targetEntity = AclObjectIdentity.class)
    @JoinColumn(name = "parent_object")
    private AclObjectIdentity parentAclObject;
    
    @ManyToOne(targetEntity = AclSid.class)
    @JoinColumn(name = "owner_sid")
    private AclSid aclSid;
    
    @Column(name = "entries_inheriting", nullable = false)
    private boolean inheriting;
    
    /**
     * No-arg constructor for JavaBean tools.
     */
    public AclObjectIdentity() {
        
    }

    /**
     * Simple constructor
     */
    public AclObjectIdentity(AclClass aclClass,long objectId, AclSid aclSid,boolean inheriting) {
        this.aclClass = aclClass;
        this.objectId = objectId;
        this.aclSid = aclSid;
        this.inheriting = inheriting;           
    }    
    public AclClass getAclClass() {
        return aclClass;
    }

    public AclSid getAclSid() {
        return aclSid;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Accessor Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~//     
    public long getId() {
        return id;
    }

    public long getObjectId() {
        return objectId;
    }
    
    public AclObjectIdentity getParentAclObject() {
        return parentAclObject;
    }

    public boolean isInheriting() {
        return inheriting;
    }  
    
    public void setAclClass(AclClass aclClass) {
        this.aclClass = aclClass;
    }

    public void setAclSid(AclSid aclSid) {
        this.aclSid = aclSid;
    }      
    
    public void setId(long id) {
        this.id = id;
    }

    public void setInheriting(boolean inheriting) {
        this.inheriting = inheriting;
    }    
    
    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }
    
    public void setParentAclObject(AclObjectIdentity parentAclObject) {
        this.parentAclObject = parentAclObject;
    }    
}
