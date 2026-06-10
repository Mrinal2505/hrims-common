package com.hti.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hti.entity.LoginHistory;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, UUID>,
        JpaSpecificationExecutor<LoginHistory> {

    List<LoginHistory> findByUserIdOrderByLoginAtDesc(UUID userId);

    List<LoginHistory> findByUserIdAndStatus(UUID userId, String status);
}