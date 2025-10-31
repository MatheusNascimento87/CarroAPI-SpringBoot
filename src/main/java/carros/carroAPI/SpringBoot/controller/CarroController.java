package carros.carroAPI.SpringBoot.controller;

import carros.carroAPI.SpringBoot.entities.Carro;
import carros.carroAPI.SpringBoot.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Carro>> findAll() {
        try {
            List<Carro> carros = service.findAll();
            return ResponseEntity.ok(carros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Carro carro = service.findById(id);
            return ResponseEntity.ok(carro);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro inesperado ao buscar o carro.");
        }
    }
    @GetMapping("/findByModelo")
    public ResponseEntity<List<Carro>> findByModelo(@RequestParam String modelo) {
        try {
            List<Carro> carros = service.findByModelo(modelo);
            return ResponseEntity.ok(carros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    @GetMapping("/findByMarca")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam long idMarca) {
        try {
            List<Carro> carros = service.findByMarca(idMarca);
            return ResponseEntity.ok(carros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    @GetMapping("/findAcimaAno")
    public ResponseEntity<List<Carro>> findAcimaAno(@RequestParam Integer ano) {
        try {
            List<Carro> carros = service.findAcimaAno(ano);
            return ResponseEntity.ok(carros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> post(@Valid @RequestBody Carro carro) {
        try {
            service.post(carro);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Carro cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao cadastrar carro: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Carro carro) {
        try {
            service.update(id, carro);
            return ResponseEntity.ok("Carro atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar carro: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("Carro deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar carro: " + e.getMessage());
        }
    }
}
