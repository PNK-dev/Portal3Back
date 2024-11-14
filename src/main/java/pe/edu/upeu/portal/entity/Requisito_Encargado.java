package pe.edu.upeu.portal.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "requisitos_encargados")
public class Requisito_Encargado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrequisitoencargado")
	private Long idrequisitoencargado;
	@ManyToOne
    @JoinColumn(name="requisitos", nullable = false)
    private Requisitos requisitos;
	@ManyToOne
    @JoinColumn(name="estados", nullable = false)
    private Estado estado;
	@ManyToOne
    @JoinColumn(name="encargados", nullable = false)
    private Encargado encargado;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "requisito_Encargado")
    @JsonIgnore
    private Set<ProcesoPlanRequisito> procesoPlanRequisitos ;
}
