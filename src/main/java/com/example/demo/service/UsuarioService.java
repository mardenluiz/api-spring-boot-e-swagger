package com.example.demo.service;

import com.example.demo.handler.CampoObrigatorioException;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void saveUser(Usuario usuario){

        if(usuario.getLogin() == null || usuario.getLogin() == "") {
            throw new CampoObrigatorioException("login");
        }

        if(usuario.getPassword() == null || usuario.getPassword() == "") {
            throw new CampoObrigatorioException("password");
        }

        if(usuario.getId() == null) {
            repository.save(usuario);
        }
        else {
            repository.save(usuario);
        }
    }
}
