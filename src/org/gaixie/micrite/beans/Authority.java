/* ===========================================================
 * $Id: Authority.java 520 2009-08-27 05:59:23Z bitorb $
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Micrite的一个授权资源，结合角色来实现系统安全策略。
 */
@Entity
@Table(name = "authorities")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Authority {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String type;

    private String value;
    
    private int order1;
    private int order2;
    private String iconCls1;
    private String iconCls2;
    private int state;

    public int getOrder1() {
		return order1;
	}

	public void setOrder1(int order1) {
		this.order1 = order1;
	}

	public int getOrder2() {
		return order2;
	}

	public void setOrder2(int order2) {
		this.order2 = order2;
	}

	public String getIconCls1() {
		return iconCls1;
	}

	public void setIconCls1(String iconCls1) {
		this.iconCls1 = iconCls1;
	}

	public String getIconCls2() {
		return iconCls2;
	}

	public void setIconCls2(String iconCls2) {
		this.iconCls2 = iconCls2;
	}

	@ManyToMany(targetEntity = Role.class)  
    @JoinTable(name = "role_authority_map", joinColumns = @JoinColumn(name = "authority_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Role> roles;

    /**
     * No-arg constructor for JavaBean tools.
     */
    public Authority() {

    }

    /**
     * Simple constructor
     */
    public Authority(String name,String type,String value) {
        this.name = name;
        this.type = type;     
        this.value = value;  
    }    
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Accessor Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~//    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Business Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~//
    /**
     * 得到 <code>Authority</code> 被分配角色名称的字符串，并以 "," 分隔开。 
     * <p>
     * 如果访问一个 <code>URL</code> 需要拥有 <code>ROLE_ADMIN</code> 
     * 或者 <code>ROLE_USER</code> 角色，那么得到的字符串的值为：
     * </p>
     * <p>
     * <code>ROLE_ADMIN,ROLE_USER</code>
     * </p>
     */
    @Transient
    public String getRolesString() {
        List<String> rolesList = new ArrayList<String>();
        for (Role role : roles) {
            rolesList.add(role.getName());
        }
        return StringUtils.join(rolesList, ",");
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}
	@Override
	public String toString() {
		return "Authority [id=" + id + ", name=" + name + ", iconCls2=" + iconCls2
				+ ", iconCls1=" + iconCls1 + ", order1=" + order1
				+ ", order2=" + order2 + ", roles=" + roles + ", type=" + type
				+ ", value=" + value + "" 
				+ ", state=" + state + "]";
	}

    
}
