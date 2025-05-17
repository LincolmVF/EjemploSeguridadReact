package seguridadreact.seguridadreact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import seguridadreact.seguridadreact.entity.UserEntity;
import seguridadreact.seguridadreact.repository.UserRepository;

import java.util.ArrayList;

@Service
public class AppUserDetailsService implements UserDetailsService {
@Autowired
private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity existingUser= userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El emanl no fue encontrado"+email));



        return new User(existingUser.getEmail(),
                existingUser.getPassword()
        ,new ArrayList<>());
    }
}
