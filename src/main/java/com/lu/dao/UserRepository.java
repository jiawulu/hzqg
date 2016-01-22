package com.lu.dao;

import com.lu.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User getUserById(Integer id);

    public User getUserBySid(String sid);

    public User getUserByUserNameAndPassWord(String userName, String passWord);

}
