package com.kwler.commons.db.blog.nosql.mongo.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

import com.kwler.commons.db.scheduler.job.nosql.mongo.model.HarvestingResult;

/**
 * 
 * @author Joseph Siegar
 *
 */
@Entity(value = "blogItem", noClassnameStored = true)
public class BlogItem extends HarvestingResult {

	private String blogId;
	private String name;
	private List<Item> items;
	
	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static class Item{
		
		private String url;
		private String content;
		private String country;
		private String title;
		private List<Entity> entities;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
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
