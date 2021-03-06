/* ===========================================================
 * $Id: AclClass.java 520 2009-08-27 05:59:23Z bitorb $
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * ACL领域对象。
 */
@Entity
@Table(name = "acl_class")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AclClass {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "class", nullable = false)
    private String cls;

    /**
     * No-arg constructor for JavaBean tools.
     */
    public AclClass() {
        
    }

    /**
     * Full constructor
     */
    public AclClass(String cls) {
        this.cls = cls;
    }
    
    public String getCls() {
        return cls;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Accessor Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~//     
    public long getId() {
        return id;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public void setId(long id) {
        this.id = id;
    }
}
