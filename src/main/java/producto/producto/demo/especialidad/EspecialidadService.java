package producto.producto.demo.especialidad;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    //!Create
    public Especialidad save(Especialidad entity)
    {
        return especialidadRepository.save(entity);
    }

    //!Find by id
    public Especialidad findById(long id)
    {
        return especialidadRepository.findById(id).orElse(null);
    }

    //!Delete
    public void deleteById(long id)
    {
        especialidadRepository.deleteById(id);
        {
            especialidadRepository.deleteById(id);
        }
    }

    //!Select all
    public List<Especialidad> findAll()
    {
        return especialidadRepository.findAll();
    }

    //!Update by id
    public ResponseEntity<Especialidad>updateById(long id, Especialidad especialidadActualizar)
    {
        try
        {
            Especialidad especialidadExistente = findById(id);
            if(especialidadExistente == null) return ResponseEntity.notFound().build();

            if(especialidadExistente.getName() != null) especialidadExistente.setName(especialidadActualizar.getName());
            if(especialidadExistente.getDescription() != null) especialidadExistente.setDescription(especialidadActualizar.getDescription());

            Especialidad EspecialidadGuardado = save(especialidadExistente);
            return ResponseEntity.ok(EspecialidadGuardado);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
