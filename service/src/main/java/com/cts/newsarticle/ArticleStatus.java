package com.cts.newsarticle;

public class ArticleStatus {
	
	private boolean articleExists;
	private boolean articleSaved;
	private boolean articleSetFav;
	public ArticleStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ArticleStatus(boolean articleExists, boolean articleSaved, boolean articleSetFav) {
		super();
		this.articleExists = articleExists;
		this.articleSaved = articleSaved;
		this.articleSetFav = articleSetFav;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (articleExists ? 1231 : 1237);
		result = prime * result + (articleSaved ? 1231 : 1237);
		result = prime * result + (articleSetFav ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleStatus other = (ArticleStatus) obj;
		if (articleExists != other.articleExists)
			return false;
		if (articleSaved != other.articleSaved)
			return false;
		if (articleSetFav != other.articleSetFav)
			return false;
		return true;
	}
	
	
	

}
