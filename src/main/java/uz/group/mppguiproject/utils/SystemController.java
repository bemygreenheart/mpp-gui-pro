package uz.group.mppguiproject.utils;

import org.springframework.stereotype.Component;
import uz.group.mppguiproject.config.Session;
import uz.group.mppguiproject.entity.User;
import uz.group.mppguiproject.repos.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class SystemController implements ControllerInterface {

    private final Session session;
    private final UserRepository repository;

    public SystemController(Session session, UserRepository repository) {
        this.session = session;
        this.repository = repository;
    }

    public void login(String id, String password) throws LoginException {
        Optional<User> currentUser = repository.findById(id);
        if(currentUser.isEmpty()) throw new LoginException("User with id = " + id + " does not exist");
		String passwordFound = currentUser.get().getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		session.setUser(currentUser.get());
	}

	@Override
	public List<String> allMemberIds() {
		return Collections.emptyList();
	}

	@Override
	public List<String> allBookIds() {
        return Collections.emptyList();
	}

}
