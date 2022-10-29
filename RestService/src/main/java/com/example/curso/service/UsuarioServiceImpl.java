package com.example.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.curso.dao.IUsuarioDao;
import com.example.curso.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioDao.findAll();
	}
	

	@Override
	@Transactional
	public void save(Usuario usuario) {
		 usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findUsuario(Usuario usuario) {
		return (Usuario) usuarioDao.findByEmail(usuario.getEmail());
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario checkUsuarioLogin(Usuario usuario) {
		return (Usuario) usuarioDao.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
	}

	@Override
	@Transactional
	public void deleteUsuario(Usuario usuario) {
		usuarioDao.deleteById(usuario.getId());
		
	}

	@Override
	@Transactional
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findUsuarioById(Long id) {
		return (Optional<Usuario>) usuarioDao.findById(id);
	}

	@Override
	@Transactional
	public void deleteUsuario(Long id) {
		usuarioDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return  usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByIdSQL(Long id) {
		return (Usuario) usuarioDao.findByIdSQL(id);
	}


}
