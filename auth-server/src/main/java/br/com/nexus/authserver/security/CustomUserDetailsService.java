package br.com.nexus.authserver.security;

import br.com.nexus.authserver.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        final var simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + user.getTipo().name());

        return new User(
                user.getEmail(),
                user.getPassword(),
                List.of(simpleGrantedAuthority)
        );
    }
}
