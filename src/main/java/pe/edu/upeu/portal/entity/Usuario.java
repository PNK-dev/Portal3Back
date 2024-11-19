package pe.edu.upeu.portal.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idusuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contraseña")
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "personas", nullable = false)
    private Persona persona;

    @ManyToMany
    @JoinTable(
        name = "usuario_roles",
        joinColumns = @JoinColumn(name = "idusuario"),
        inverseJoinColumns = @JoinColumn(name = "idrol")
    )
    private Set<Rol> roles;
}
