package carros.carroAPI.SpringBoot.repository;

import carros.carroAPI.SpringBoot.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro,Long> {
}
