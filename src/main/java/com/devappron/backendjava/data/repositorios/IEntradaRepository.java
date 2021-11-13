package com.devappron.backendjava.data.repositorios;

import java.util.List;

import com.devappron.backendjava.data.entidades.EntradaEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntradaRepository extends PagingAndSortingRepository<EntradaEntity, Long> {
    
    List<EntradaEntity> getByUsuarioEntityIdOrderByCreatedAtDesc(long usuarioEntityId);

    @Query(value = "SELECT * FROM entradas ORDER BY created_at DESC LIMIT 20",
            nativeQuery = true)
    List<EntradaEntity> getUltimosEntradas();

    EntradaEntity findByEntradaId(String id);

}