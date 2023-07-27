package com.dev.authserver.service;

import com.dev.authserver.feignclients.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = userRepository.findByUsuario(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));

        if (user.equals(null)) {
            logger.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }

        final var simpleGrantedAuthorityRoles = new SimpleGrantedAuthority("ROLE_" + user.getRoles());
        final var simpleGrantedAuthorityMenu = new SimpleGrantedAuthority("MENU_" + user.getMenu());

        return new User(
                user.getEmail(),
                user.getPassword(),
                List.of(simpleGrantedAuthorityRoles,simpleGrantedAuthorityMenu));
    }
}
