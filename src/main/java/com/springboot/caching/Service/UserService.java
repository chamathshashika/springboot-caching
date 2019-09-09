package com.springboot.caching.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.springboot.caching.entity.User;

@Service
@CacheConfig(cacheNames= {"users"})//tell spring to where to store cache for this class
public class UserService {

	private List<User> users = new ArrayList<>();

	@Autowired
	public UserService() {

	}

	@PostConstruct // execute after dependancy injection is done
	private void fillAllUsers() {
		users.add(User.builder().username("Chamath").age(20).build());
		users.add(User.builder().username("Sandun").age(76).build());
		users.add(User.builder().username("Pradeep").age(54).build());
		users.add(User.builder().username("Namal").age(30).build());
	}

	@Cacheable //cache the result
	public List<User> findAll() {
		simulateSlowService();
		return this.users;
	}
	
	@CachePut
	public User updateUser(User user) {
		this.users.set(0,user);
		return this.users.get(0);
	}

	private void simulateSlowService() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}




	public boolean addUser() {
		
		return users.add(User.builder().username("Shashika").age(60).build());
		
	}

	@CacheEvict(allEntries = true)
	public void deleteAll() {
		
		users.clear();
		
		
		
	}

}
