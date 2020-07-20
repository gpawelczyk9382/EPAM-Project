package com.example.EPAMBlog;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogInterface extends MongoRepository<Blog, String>
{
	public List<Blog> findByBlogCreator(String blogCreator);
	public Blog findBy_id(ObjectId _id);
}
