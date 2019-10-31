package com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.security;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.Role;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.User;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the {@link UserDetailsService}.
 * <p>
 * This implementation searches for {@link User} entities by the e-mail address
 * supplied in the login screen.
 */
@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Recovers the {@link User} from the database using the e-mail address supplied
     * in the login screen. If the user is found, returns a
     * {@link org.springframework.security.core.userdetails.User}.
     *
     * @param username User's e-mail address
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if (null == user) {
            throw new UsernameNotFoundException("Kullanıcı adı bulunamadı : " + username);
        } else {

            List<SimpleGrantedAuthority> currentUserRoles = new ArrayList<>();
            for (Role role : user.getRoles()) {
                currentUserRoles.add(new SimpleGrantedAuthority(role.getRole()));
            }

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswordHash(),
                    currentUserRoles);
        }
    }
}