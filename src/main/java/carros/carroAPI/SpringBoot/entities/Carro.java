package carros.carroAPI.SpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_carros")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @NotNull(message = "Campo modelo nulo")
    private String modelo;
    @NotNull(message = "Campo ano nulo")
    private Integer ano;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("carros")
    private Marca marca;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "carro_proprietario")
    private List<Proprietarios> proprietarios;
}
