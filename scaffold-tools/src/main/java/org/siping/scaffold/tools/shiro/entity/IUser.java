package org.siping.scaffold.tools.shiro.entity;

public interface IUser {

	String getUsername();

	String getPassword();

	Boolean getDisabled();

	Integer getDeleted();

	Boolean getLocked();

}
