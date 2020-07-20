package com.example.EPAMBlog;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EPAMController {

	@Autowired
	private BlogService blogService;
	
	@GetMapping("/SubmitBlog")
	public String SubmitBlog(@RequestParam("BlogCreator") String BlogCreator, 
							@RequestParam(value = "BlogTitle", defaultValue = "No Value") String BlogTitle,
							@RequestParam(value = "BlogText", defaultValue = "No Value") String BlogText)
	{	
		return blogService.create(BlogCreator,BlogTitle,BlogText,"B","PARENT");
	}
	
/*	@GetMapping("/GetAllBlog")
	public List<Blog> GetAll()
	{	
		return blogService.getAll();
	}*/

	@GetMapping("/GetAllBlog")
	public List<Blog> GetAll()
	{	
		return blogService.getAll();
	}
	
	
	@GetMapping("/DeleteAll")
	public void DeleteAll()
	{	
		blogService.deleteAll();
	}
	
	@GetMapping("/ViewContent")
	public List<Blog> ViewContent(@RequestParam(value = "BlogCreator", defaultValue = "No Value") String BlogCreator)
	{
		return blogService.getByBlogCreator(BlogCreator);
	}
	
	@GetMapping("/UpdateBlog")
	public String UpdateBlog(@RequestParam("Id") ObjectId Id,
			@RequestParam(value = "BlogTitle", defaultValue = "NV") String BlogTitle,
			@RequestParam(value = "BlogText", defaultValue = "NV") String BlogText)
	{
		String b = blogService.update(Id, BlogTitle, BlogText);
		return b.toString();
	}
		
		
	@GetMapping("/CommentBlog")
	public String CommentBlog(@RequestParam("Id") String Id,
							@RequestParam("BlogCommentCreator") String BlogCommentCreator,
							@RequestParam("BlogCommentText") String BlogCommentText)
	{		
		return blogService.create(BlogCommentCreator,"",BlogCommentText,"C",Id);
	}
}