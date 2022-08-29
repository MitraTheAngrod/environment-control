package com.ufg.environmentcontrol.cript.repository;

import com.ufg.environmentcontrol.cript.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    /**
     * Searches for login in DB using JPA
     * @param login - The username of user
     * @return - Optional of the entity UserModel
     */
    public Optional<UserModel> findByLogin(String login);
}
