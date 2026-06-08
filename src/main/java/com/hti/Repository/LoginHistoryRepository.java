// LoginHistoryRepository.java
package com.hti.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hti.entity.LoginHistory;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, UUID>,
JpaSpecificationExecutor<LoginHistory> {

    List<LoginHistory> findByUserIdOrderByLoginAtDesc(UUID userId);
}