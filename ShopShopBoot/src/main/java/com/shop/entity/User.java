package com.shop.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
	
	@Entity
	@Table(name = "User")
	public class User extends BaseEntity implements UserDetails {

		private static final long serialVersionUID = 1L;
		
		@Column
		private String login;
		
		@Column
		private String password;
		
		@Column
		private String email;
		
		@Transient
		private String passConfirm;

		@Column(name = "first_name", length = 20)
		private String firstName;

		@Column(name = "last_name", length = 20)
		private String lastName;
		private int age;

		@Enumerated
		private Role role;

		@OneToMany(mappedBy = "user")
		private List<Items> items = new ArrayList<>();

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public List<Items> getItems() {
			return items;
		}

		public void setItems(List<Items> items) {
			this.items = items;
		}

		public String getPassConfirm() {
			return passConfirm;
		}

		public void setPassConfirm(String passConfirm) {
			this.passConfirm = passConfirm;
		}

		@Override
		public String toString() {
			return "User [login=" + login + ", password=" + password + ", email=" + email + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", age=" + age + ", role=" + role + ", items=" + items + "]";
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
		}

		@Override
		public String getUsername() {
			return login;
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
		
		
	
}
