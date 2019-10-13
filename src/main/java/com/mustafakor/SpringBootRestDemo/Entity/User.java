package com.mustafakor.SpringBootRestDemo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="email", unique = true, nullable = false)
	@NotEmpty
	@Email
	private String email;
	
	@Column(name = "last_name")
	@NotEmpty
	private String lastName;
	
	@Column(name = "first_name")
	@NotEmpty
	private String firstName;
	
	@Column(name="password", nullable = false)
	@NotEmpty
	@Size(min=4)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		name = "user_role",
		joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")}
	)
	private List<Role> roles;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "user_producer",
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "producer_id", referencedColumnName = "id")}
	)
	private List<Producer> producers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}	
	
}
