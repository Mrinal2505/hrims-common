package com.hti.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hti.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>,
        JpaSpecificationExecutor<User> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    List<User> findByOrganisationId(UUID organisationId);
    
    Optional<User> findByUsernameOrEmail(String username, String email);
    
    boolean existsByEmailAndIdNot(String email, UUID id);
}