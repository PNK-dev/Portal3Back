package pe.edu.upeu.portal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "rolPrivilegios")
public class RolPrivilegios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrolprivilegios")
	private Long idrolprivilegios;
	@ManyToOne
    @JoinColumn(name="roles", nullable = false)
    private Rol rol;
	@ManyToOne
    @JoinColumn(name="privilegios", nullable = false)
    private Privilegios privilegios;
}
