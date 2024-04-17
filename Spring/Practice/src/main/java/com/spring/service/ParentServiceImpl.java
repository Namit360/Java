package com.spring.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.model.Parent;
import com.spring.repository.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService
{
	@Autowired
	ParentRepository parentrepo;
	
	@Override
	public List<Parent> fetchAllParent() 
	{
		List<Parent> parent=parentrepo.findAll();
		return parent;
	}

	@Override
	public String deleteParentId(int id) 
	{
		parentrepo.deleteById(id);
		return "removed "+id;
	}
	
	public Optional<Parent> getParentId(int parentid) 
	{
		Optional<Parent> parent=parentrepo.findById(parentid);
	    return parent;
	}

	@Override
	public void addParent(Parent parent) 
	{
		parentrepo.save(parent);
	}
}
