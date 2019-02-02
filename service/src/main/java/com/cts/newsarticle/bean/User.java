package com.cts.newsarticle.bean;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@NotNull(message = "User Name cannot be empty")
	@Size(min = 1, max = 50, message = "Name must be 3 to 50 characters")
	@Column(name = "us_name")
	private String name;

	@NotNull(message = "Email cannot be empty")
	@Size(min = 3, max = 30, message = "Email must be 3 to 10 characters")
	@Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid")
	@Column(name = "us_email")
	private String email;

	@NotNull(message = "Password cannot be empty")
	@Size(min = 6, max = 15, message = "Password must be 6 to 15 characters")
	@Column(name = "us_password")
	private String password;
	
	@ManyToOne(cascade = CascadeType.MERGE) 
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "us_ro_id")
	private Role role;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "us_la_id")
	private Language language;
	

	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "favourite_article", joinColumns = { @JoinColumn(name = "fa_us_id") }, inverseJoinColumns = {
			@JoinColumn(name = "fa_ar_id") })
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Article> articles;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User(int id,
			@NotNull(message = "User Name cannot be empty") @Size(min = 1, max = 50, message = "Name must be 3 to 50 characters") String name,
			@NotNull(message = "Email cannot be empty") @Size(min = 3, max = 30, message = "Email must be 3 to 10 characters") @Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid") String email,
			@NotNull(message = "Password cannot be empty") @Size(min = 6, max = 15, message = "Password must be 6 to 15 characters") String password,
			Role role, Language language) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.language = language;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}



	public List<Article> getArticles() {
		return articles;
	}



	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", language=" + language + "]";
	}

	
	
}
