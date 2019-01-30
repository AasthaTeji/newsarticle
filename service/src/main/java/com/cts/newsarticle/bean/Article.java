package com.cts.newsarticle.bean;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ar_id")
	private int id;
	
	@Column(name = "ar_title")
	private String title;
	
	@Column(name = "ar_desc")
	private String description;
	
	@Column(name = "ar_author")
	private String author;
	
	@Column(name = "ar_content")
	private String content;
	
	@Column(name = "ar_url")
	private String url;
	
	@Column(name = "ar_url_to_image")
	private String urlToImage;
	
	@Column(name = "ar_published_at")
	private Date publishedAt;

	@Transient
	private String email;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public Date getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
				+ ", content=" + content + ", url=" + url + ", urlToImage=" + urlToImage + ", publishedAt="
				+ publishedAt + "]";
	}
	
	

}
