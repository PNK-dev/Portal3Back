package pe.edu.upeu.portal.security.config;

import pe.edu.upeu.portal.entity.Usuario;
import pe.edu.upeu.portal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario user = userRepository.findByNombre(nombre)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no existe: " + nombre));

        // Map roles through usuarioRoles relationship
        Set<GrantedAuthority> authorities = user.getUsuarioRoles().stream()
                .map(usuarioRol -> new SimpleGrantedAuthority(usuarioRol.getRol().getNombre()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getNombre(),
                user.getContraseña(),
                authorities
        );
    }
}