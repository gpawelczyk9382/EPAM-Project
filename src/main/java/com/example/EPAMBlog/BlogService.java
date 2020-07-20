package com.example.EPAMBlog;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogService {

	@Autowired
	private BlogInterface blogInterface;
	
	//Create operation
	public String create(String BlogCreator, String BlogTitle, String BlogText, String BlogType, String BlogParent) {
	    Date date = new Date();	 
	    
	    Blog b = blogInterface.save(new Blog(ObjectId.get(), BlogCreator, BlogTitle, BlogText, date,BlogType,BlogParent));
		return b.toString() + " has been created.";
	}
	
	//Retrieve all records operation
	public List<Blog> getAll(){
		return blogInterface.findAll();		
	}

	
	//Update blog record
	public String update(ObjectId Id, String BlogTitle, String BlogText) {
		Blog b = blogInterface.findBy_id(Id);	
		if(b != null) {
		
			if(!BlogTitle.equals("NV")) {
				b.setBlogText(BlogTitle);
			}

			if(!BlogText.equals("NV")) {
				b.setBlogText(BlogText);
			}
			
		blogInterface.save(b);
		return b.toString() + " is updated.";
		}
		return "Blog ID Not Found";
		
	}

	//delete blog record
	public String delete(ObjectId BlogId) {
		Blog b = blogInterface.findBy_id(BlogId);	
		if(b != null) {
		blogInterface.delete(b);
		return b.toString() + " is deleted.";
		}
		return "Blog ID Not Found";	
	}
	
	public void deleteAll(){
		blogInterface.deleteAll();
	}
	

	public Optional<Blog> getBlog(String BlogId) {
		Optional<Blog> b = blogInterface.findById(BlogId);
		return b;
	}
	
	public List<Blog> getByBlogCreator(String blogCreator){		
		List<Blog> blogList = blogInterface.findByBlogCreator(blogCreator);
		List<Blog> b = 
				blogList.stream()
			            //.filter(p -> BlogCreator.equals(p.getBlogCreator()))  
			            .sorted(Comparator.comparing(Blog::getBlogPublishDt).reversed())
			            .collect(Collectors.toList());
		return b;		
	}
	
	
}
