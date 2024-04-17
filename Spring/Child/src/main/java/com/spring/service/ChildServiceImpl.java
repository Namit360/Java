package com.spring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.spring.model.Child;
import com.spring.repository.ChildRepository;

@Service
public class ChildServiceImpl implements ChildService
{
	@Autowired
	ChildRepository childrepo;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Child> fetchAllChild() 
	{
		List<Child> child = childrepo.findAll();
		return child;
	}

	@Override
	public void addChild(Child child) 
	{
		childrepo.save(child);
	}

	@Override
	public String deleteChildId(int id) 
	{
		childrepo.deleteById(id);
		return "removed "+id;
	}

	@Override
	public Object fetchParent() 
	{
		return restTemplate.getForObject("http://localhost:8484/v1//parent/123", Object.class);
	}
}
