package carros.carroAPI.SpringBoot.controller;

import carros.carroAPI.SpringBoot.entities.Carro;
import carros.carroAPI.SpringBoot.repository.CarroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CarroControllerTest {

    @Autowired
    CarroController carroController;

    @MockitoBean
    CarroRepository carroRepository;

    Carro carroMock;

    @BeforeEach
    void setup(){
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro(1L, "Modelo1", 2020, null,null));
        carros.add(new Carro(2L, "Modelo2", 2025, null, null));
        carros.add(new Carro(3L, "Modelo3", 2023, null, null));

        carroMock = new Carro(1L,"modelo1",2025,null,null);

        when(carroRepository.findById(1L)).thenReturn(Optional.of(carroMock));
        when(carroRepository.findAll()).thenReturn(carros);
    }

    @Test
    void findAllTeste01(){
        ResponseEntity<List<Carro>> retorno = carroController.findAll();
        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }

    @Test
    void findByIdTeste01(){
        ResponseEntity<?> retorno = carroController.findById(-1L);
        assertEquals(HttpStatus.BAD_REQUEST,retorno.getStatusCode());
    }
    @Test
    void postTeste01(){
        ResponseEntity<?> retorno = carroController.post(carroMock);
        assertEquals("Carro cadastrado com sucesso!", retorno.getBody());
    }

}
