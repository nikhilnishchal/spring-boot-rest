package com.niknis.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.niknis.cms.domain.repository.UserRepository;
import com.niknis.cms.entity.UserEntity;
import com.niknis.cms.model.User;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	public void create(User userEntry) {
		userRepository.insert(userEntry.formatUserEntity());
	}

	public User update(User userEntry) {
		return userRepository.save(userEntry.formatUserEntity()).format();
	}

	/*public void delete(Long idUser) {
		userRepository.delete(idUser);
	}
*/
	public User findByID(String idUser) {
		User retorno = null;
		Optional<UserEntity> findById = userRepository.findById(idUser);
		if (findById.isPresent())
			retorno = findById.get().format();
		return retorno;
	}

	public List<User> list() {
		Supplier<List<User>> supplier = ArrayList::new;
		List<UserEntity> findAll = userRepository.findAll();
		
		List<User> retorno = findAll
        .stream()
        .map(user -> new User(user.id, user.name, user.email, user.password))
		.collect(Collectors.toCollection(supplier));
		
		return retorno;
	}
	
	public User findByEmail(String email) {
		User retorno = null;
		Optional<UserEntity> findByEmail = userRepository.findByEmail(email);
		if (findByEmail.isPresent())
			retorno = findByEmail.get().format();
		return retorno;
	}
}
