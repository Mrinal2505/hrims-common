package com.hti.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hti.entity.ActionLink;
import com.hti.entity.Otp;

@Repository
public interface ActionLinkRepository extends JpaRepository<ActionLink, UUID> {

    Optional<ActionLink> findByToken(String token);

    @Modifying
    @Transactional
    @Query("DELETE FROM ActionLink a WHERE a.userId = :userId AND a.purpose = :purpose")
    void deleteByUserIdAndPurpose(
            @Param("userId") UUID userId,
            @Param("purpose") String purpose);
    
    
}