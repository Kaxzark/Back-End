package com.portfolio.backend.repository;

import com.portfolio.backend.model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Integer> {
    public Optional<Persona> findByNombre(String nombre);
    public List<Persona> findAllByUsuarioId(int id);
    public boolean existsByNombre(String nombre);
}
