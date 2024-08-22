package dev.sunil.Asq.maintenance.security;

import dev.sunil.Asq.maintenance.Exception.UserNotFoundException;
import dev.sunil.Asq.maintenance.model.User;
import dev.sunil.Asq.maintenance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
                ()->new UserNotFoundException("User not found with email:"+email)
        );

        Set<String> roles = new HashSet<>();
        roles.add("ROLE_ADMIN");

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), getAuthorities(roles));

    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<String> roles){
        return roles.stream()
                .map(role->new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }
}
