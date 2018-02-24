package com.example.blog.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>{
    /**
     * 根据姓名查找
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 根据姓名和年龄查找
     * @param name
     * @param age
     * @return
     */
    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
