package com.example.EPAMBlog;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Blog {

		@Id
		ObjectId _id;
		String blogCreator;
		String blogTitle;
		String blogText;
		Date blogPublishDt;
		String blogType;
		String blogParent;

		public Blog(ObjectId _id, String blogCreator, String blogTitle, String blogText, Date blogPublishDt, String blogType, String blogParent) {
			this._id = _id;
			this.blogCreator = blogCreator;
			this.blogTitle = blogTitle;
			this.blogText = blogText;
			this.blogPublishDt = blogPublishDt;
			this.blogType = blogType;
			this.blogParent = blogParent;
		}

		public String get_id() 
		{ 
			return _id.toHexString(); 
		}
				
		public String getBlogParent() {
			return blogParent;
		}

		public String getBlogType() {
			return blogType;
		}

		public String getBlogCreator() {
			return blogCreator;
		}	
		
		public String getBlogTitle() {
			return blogTitle;
		}
		
		public String getBlogText() {
			return blogText;
		}
		
		public Date getBlogPublishDt() {
			return blogPublishDt;
		}
		
		public void setBlogType(String blogType) {
			this.blogType = blogType;
		}

		public void setBlogCreator(String blogCreator) {
			this.blogCreator = blogCreator;
		}

		public void setBlogTitle(String blogTitle) {
			this.blogTitle = blogTitle;
		}

		public void setBlogText(String blogText) {
			this.blogText = blogText;
		}

		public void set_id(ObjectId _id) 
		{ 
			this._id = _id; 
		}	
		
		public void setBlogParent(String blogParent) {
			this.blogParent = blogParent;
		}
		
		public void setBlogPublishDt(Date blogPublishDt) {
			this.blogPublishDt = blogPublishDt;
		}			
		
		public String toString() {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  	   
		    String sBlogPublishDt = dateFormat.format(blogPublishDt);
			return "BlogId:" + _id + " BlogCreator: " + blogCreator + " BlogTitle: " + blogTitle + " BlogText: " + blogText + " BlogPublishDt:" + sBlogPublishDt + " BlogType:" + blogType + " BlogParent:" + blogParent;
		}
	}

