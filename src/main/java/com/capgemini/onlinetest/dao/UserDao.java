package com.capgemini.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetest.entity.User;
@Repository
public interface UserDao extends JpaRepository<User, Long>{
	@Query("select u.userId from User u where u.email=?1")
	public Long getIdByEmail(String email);
	

}
