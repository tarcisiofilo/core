package com.sica.repository;

import com.sica.domain.Incidente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Incidente entity.
 */
@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long> {

    @Query(value = "select distinct incidente from Incidente incidente left join fetch incidente.ativos",
        countQuery = "select count(distinct incidente) from Incidente incidente")
    Page<Incidente> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct incidente from Incidente incidente left join fetch incidente.ativos")
    List<Incidente> findAllWithEagerRelationships();

    @Query("select incidente from Incidente incidente left join fetch incidente.ativos where incidente.id =:id")
    Optional<Incidente> findOneWithEagerRelationships(@Param("id") Long id);

}
