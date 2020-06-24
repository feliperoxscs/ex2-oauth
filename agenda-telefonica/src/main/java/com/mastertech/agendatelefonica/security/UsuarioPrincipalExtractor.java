package com.mastertech.agendatelefonica.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

import java.util.Map;

public class UsuarioPrincipalExtractor implements PrincipalExtractor {

    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId((Integer) map.get("id"));
        usuarioDto.setName((String) map.get("name"));
        return usuarioDto;
    }
}
