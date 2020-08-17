package com.capgemini.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.onlinetest.entity.Tests;

/*************************************************************************************************************************************
- File Name        : TestDao.java
- Author           : Capgemini
- Creation Date    : 13-08-2020
- Description      : This Dao class is responsible for accessing the data through database.
 *************************************************************************************************************************************/

@Repository
public interface TestDao extends JpaRepository<Tests, Integer> {

}
