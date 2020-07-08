package com.gec.security.utils;

import com.gec.security.pojo.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// 建议该类不放到pojo包中。
public class UserDetailImpl implements UserDetails {
	
	private SysUser sysUser;
	
	private Collection<? extends GrantedAuthority> authorities;	

	public UserDetailImpl(SysUser sysUser, Collection<? extends GrantedAuthority> authorities) {
		this.sysUser = sysUser;
		this.authorities = authorities;
	}

	@Override   //获取权限列表
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return sysUser.getPassword();
	}

	@Override
	public String getUsername() {
		return sysUser.getUsercode();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
