package com.hti.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hti.entity.EntityMetadata;

@Repository
public interface EntityMetadataRepository extends JpaRepository<EntityMetadata, UUID>,
        JpaSpecificationExecutor<EntityMetadata> {

    List<EntityMetadata> findByEntityId(UUID entityId);

    List<EntityMetadata> findByOrganisationId(UUID organisationId);

    boolean existsByEntityId(UUID entityId);

    boolean existsByOrganisationId(UUID organisationId);
}