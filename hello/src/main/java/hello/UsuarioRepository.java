package hello;

import org.springframework.data.repository.CrudRepository;

import hello.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findByLogin(String login);
}
