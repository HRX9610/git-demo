package com.gec.security.utils;

import com.web.shopping.pojo.TbSeller;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// 建议该类不放到pojo包中。
public class UserDetailImpl implements UserDetails {
	
	private TbSeller tbSeller;
	
	private Collection<? extends GrantedAuthority> authorities;	

	public UserDetailImpl(TbSeller tbSeller, Collection<? extends GrantedAuthority> authorities) {
		this.tbSeller = tbSeller;
		this.authorities = authorities;
	}

	@Override   //获取权限列表
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return tbSeller.getPassword();
	}

	@Override
	public String getUsername() {
		return tbSeller.getSellerId();
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

	public TbSeller getTbSeller() {
		return tbSeller;
	}

	public void setTbSeller(TbSeller tbSeller) {
		this.tbSeller = tbSeller;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
