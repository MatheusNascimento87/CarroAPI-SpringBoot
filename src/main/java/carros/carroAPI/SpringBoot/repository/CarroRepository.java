package carros.carroAPI.SpringBoot.repository;

import carros.carroAPI.SpringBoot.entities.Carro;
import carros.carroAPI.SpringBoot.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro,Long> {
    public List<Carro> findByModelo(String modelo);
    public List<Carro> findByMarca(Marca marca);
    @Query("FROM Carro c WHERE c.ano > :ano")
    public List<Carro> findAcimaAno(Integer ano);
}
