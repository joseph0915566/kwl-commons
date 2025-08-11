package com.kwler.commons.db.facebook.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "facebookPostResult", noClassnameStored = true)
public class FacebookPostResult extends HarvestingResult {

	private String pageId;
	private List<Post> posts;
	
	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public static class Post{
		
		private String message;
		private List<Entity> entities;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public List<Entity> getEntities() {
			return entities;
		}

		public void setEntities(List<Entity> entities) {
			this.entities = entities;
		}

		public static class Entity{
			
			private int count;
			private String text;	
			private String type;
			
			public int getCount() {
				return count;
			}
			
			public void setCount(int count) {
				this.count = count;
			}
			
			public String getText() {
				return text;
			}
			
			public void setText(String text) {
				this.text = text;
			}
			
			public String getType() {
				return type;
			}
			
			public void setType(String type) {
				this.type = type;
			}
			
		}
		
	}

}
