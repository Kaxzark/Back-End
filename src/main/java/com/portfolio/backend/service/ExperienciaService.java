/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.repository.ExperienciaRepository;
import com.portfolio.backend.security.entity.Usuario;
import com.portfolio.backend.security.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego
 */

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepository;
    
    public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return experienciaRepository.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia exp){
        experienciaRepository.save(exp);
    }
    
    public void delete(int id){
        experienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return experienciaRepository.existsById(id);
    }
    
    public boolean existsByNombreExp(String nombreExp){
        return experienciaRepository.existsByNombreExp(nombreExp);
    }
    
    @Autowired
    private UsuarioService usuarioService;
    
    public Experiencia saveInformation(Experiencia experiencia, int userId) {
        Optional<Usuario> usuarioOptional = usuarioService.getUserById(userId);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        experiencia.setUsuario(usuario);
        return experienciaRepository.save(experiencia);
    }
    
    public List<Experiencia> getAllExperienciasByUsuario(int usuarioId) {
        return experienciaRepository.findAllByUsuarioId(usuarioId);
    }
    
}
