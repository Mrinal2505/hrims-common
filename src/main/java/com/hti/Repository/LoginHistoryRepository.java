// LoginHistoryRepository.java
package com.hti.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hti.entity.LoginHistory;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, UUID> {

    List<LoginHistory> findByUserIdOrderByLoginAtDesc(UUID userId);
}