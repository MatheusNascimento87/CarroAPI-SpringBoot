package carros.carroAPI.SpringBoot.service;

import carros.carroAPI.SpringBoot.entities.Carro;
import carros.carroAPI.SpringBoot.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public Carro findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Erro com o ID mencionado, tente novamente"));
    }
    public List<Carro> findAll(){
        return repository.findAll();
    }

    public void post(Carro carro){
        repository.saveAndFlush(carro);
    }
    public void deleteById(Long id){
        Carro carroDel = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Erro com o ID mencionado, tente novamente"));

        repository.delete(carroDel);
    }
    public void update(Long id, Carro newCar){
        Carro oldCar = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Erro com o ID mencionado, tente novamente"));
        oldCar.setModelo(newCar.getModelo());
        oldCar.setAno(newCar.getAno());
        oldCar.setProprietarios(newCar.getProprietarios());
        oldCar.setMarca(newCar.getMarca());

        repository.saveAndFlush(oldCar);
    }
}
