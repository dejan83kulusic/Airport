package com.dejan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.dejan.model.*;



@Entity
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(nullable = false)
		private String username;
		@Column(nullable = false)
		private String password;
		private String passwordConfirm;
		@Column(nullable = false)
		private String firstName;

		@Column(nullable = false)
		private String lastName;

		@ManyToMany
		@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
		private List<Role> roles;

		

		public User() {
		}

		public User(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public User(String username, String password, String firstName, String lastName) {
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Transient
		public String getPasswordConfirm() {
			return passwordConfirm;
		}

		public void setPasswordConfirm(String passwordConfirm) {
			this.passwordConfirm = passwordConfirm;
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

		public List<Role> getRoles() {
			return roles;
		}

		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}

		

	

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
					+ ", lastName=" + lastName + "]";
		}


	

}

