package com.cts.newsarticle;

public class ArticleStatus {
	
	private boolean articleExists;
	private boolean articleSaved;
	private boolean articleSetFav;
	public ArticleStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isArticleExists() {
		return articleExists;
	}
	public void setArticleExists(boolean articleExists) {
		this.articleExists = articleExists;
	}
	public boolean isArticleSaved() {
		return articleSaved;
	}
	public void setArticleSaved(boolean articleSaved) {
		this.articleSaved = articleSaved;
	}
	public boolean isArticleSetFav() {
		return articleSetFav;
	}
	public void setArticleSetFav(boolean articleSetFav) {
		this.articleSetFav = articleSetFav;
	}
	@Override
	public String toString() {
		return "ArticleStatus [articleExists=" + articleExists + ", articleSaved=" + articleSaved + ", articleSetFav="
				+ articleSetFav + "]";
	}
	
	
	

}
