package com.api.contadigital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.contadigital.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String usuario) {
		return Optional.ofNullable(repository.findByUsuario(usuario))
				.orElseThrow(() -> new UsernameNotFoundException("Erro! Usuario não encontrado!"));
	}

//	public Usuario login(UsuarioDTO usuarioDTO) {
//		try {
//			Usuario usuario = repository.findByUsuario(usuarioDTO.getUsuario());
//			BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
//			textEncryptor.setPasswordCharArray("conta-digital".toCharArray()); // key
//			String senha = textEncryptor.decrypt(usuario.getSenha()); // password
//			if (usuarioDTO.getUsuario().equals(usuario.getUsername())
//					&& usuarioDTO.getSenha().equals(senha)) {
//				return usuario;
//			}
//			throw new CredenciaisInvalidasException("Error! credenciais inválidas!");
//		} catch (Exception e) {
//			throw new UsuarioException("Erro! usuário inexistente!");
//		}
//	}
}
