package com.spring.service;
import java.util.List;
import java.util.Optional;

import com.spring.model.Parent;

public interface ParentService 
{
	public List<Parent> fetchAllParent();
	void addParent(Parent parent);
	public String deleteParentId(int id);
	public Optional<Parent> getParentId(int id);
}
