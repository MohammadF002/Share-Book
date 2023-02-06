package ir.sharif.sharebook.ap.person;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    public Optional<User> findUserById(Integer id);
}
