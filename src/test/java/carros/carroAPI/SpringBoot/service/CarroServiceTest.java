package carros.carroAPI.SpringBoot.service;

import carros.carroAPI.SpringBoot.entities.Carro;
import carros.carroAPI.SpringBoot.entities.Marca;
import carros.carroAPI.SpringBoot.repository.CarroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CarroServiceTest {

    @MockBean
    CarroRepository carroRepository;

    @BeforeEach
    void setup() {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Modelo1", 2020, null, null));
        carros.add(new Carro(2L, "Modelo2", 2025, null, null));
        carros.add(new Carro(3L, "Modelo3", 2023, null, null));

        Carro carroMock = new Carro(1L, "modelo1", 2025, null, null);

        when(carroRepository.findById(1L)).thenReturn(Optional.of(carroMock));
        when(carroRepository.findAll()).thenReturn(carros);
    }

    @Test
    void findAllTeste01() {
        List<Carro> retorno = carroRepository.findAll();
        assertEquals(3, retorno.size());
    }

    @Test
    void findByIdTeste01(){
        Optional<Carro> retorno = carroRepository.findById(1L);
        assertEquals(2025,retorno.get().getAno());
    }

}
