package uz.group.mppguiproject.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.group.mppguiproject.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
