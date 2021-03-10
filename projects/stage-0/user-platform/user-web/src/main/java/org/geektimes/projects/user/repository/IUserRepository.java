package org.geektimes.projects.user.repository;


import org.geektimes.projects.user.domain.User;

public interface IUserRepository {

    boolean saveUser(User user);

}