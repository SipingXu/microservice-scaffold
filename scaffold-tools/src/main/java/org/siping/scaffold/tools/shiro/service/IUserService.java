package org.siping.scaffold.tools.shiro.service;


import org.siping.scaffold.tools.shiro.entity.IUser;

public interface IUserService {
	
	IUser findUserByUsername(String username);

}
