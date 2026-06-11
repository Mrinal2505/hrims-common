package com.hti.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hti.entity.EntityMetadata;

@Repository
public interface EntityMetadataRepository extends JpaRepository<EntityMetadata, UUID>,
        JpaSpecificationExecutor<EntityMetadata> {

    List<EntityMetadata> findByOrganisationId(UUID organisationId);

    List<EntityMetadata> findByEntityType(String entityType);

    Optional<EntityMetadata> findByOrganisationIdAndEntityType(UUID organisationId, String entityType);

    boolean existsByOrganisationIdAndEntityType(UUID organisationId, String entityType);
}