package com.hti.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hti.entity.Otp;

@Repository
public interface OtpRepository extends JpaRepository<Otp, UUID> {

    Optional<Otp> findTopByUserIdAndPurposeAndIsUsedFalseOrderByCreatedAtDesc(
            UUID userId, String purpose);

    Optional<Otp> findTopByUserIdAndPurposeAndIsUsedTrueOrderByCreatedAtDesc(
            UUID userId, String purpose);

    @Modifying
    @Transactional
    @Query("DELETE FROM Otp o WHERE o.userId = :userId AND o.purpose = :purpose")
    void deleteByUserIdAndPurpose(
            @Param("userId") UUID userId,
            @Param("purpose") String purpose);
    
    Optional<Otp> findByUserIdAndPurpose(UUID userId, String purpose);
}