package br.com.repositorio;

import java.util.ArrayList;
import java.util.List;
import br.com.model.Usuario;

public class UsuarioRepositorio {
/**
 * Lista estatica de usuários, já inicia populada com 3 usuários cadastrado.
 */
	private static List<Usuario> lista = new ArrayList<Usuario>();

	static {
		lista.add(new Usuario(String.valueOf(System.currentTimeMillis() + 1), "Usuario1", "1"));
		lista.add(new Usuario(String.valueOf(System.currentTimeMillis() + 2), "Usuario2", "2"));
		lista.add(new Usuario(String.valueOf(System.currentTimeMillis() + 3), "Usuario3", "admin"));

	}
/**
 * @param nome
 * @return
 * Methodo que busca o usuário.
 */
	public Usuario buscarPorNome(String nome) {
		if (nome == null) {
			return null;
		}
		for (Usuario usuario : lista) {
			if (nome.equals(usuario.getUsuario())) {
				return usuario;
			}

		}
		return null;
	}

}
