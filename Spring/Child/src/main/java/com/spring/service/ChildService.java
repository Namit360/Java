package com.spring.service;
import java.util.List;
import com.spring.model.Child;

public interface ChildService 
{
	public List<Child> fetchAllChild();
	void addChild(Child child);
	public String deleteChildId(int id);
	public Object fetchParent();
}
