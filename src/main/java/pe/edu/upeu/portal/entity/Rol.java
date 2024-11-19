package pe.edu.upeu.portal.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Long idrol;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "estados", nullable = false)
    private Estado estado;

    @ManyToMany
    @JoinTable(
        name = "rol_privilegios",
        joinColumns = @JoinColumn(name = "idrol"),
        inverseJoinColumns = @JoinColumn(name = "idprivilegios")
    )
    private Set<Privilegios> privilegios;

    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;
}
