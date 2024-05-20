package producto.producto.demo.especialidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    //!Create
    @PostMapping(value = "especialidad")
    public Especialidad save(@RequestBody Especialidad entity)
    {
        return especialidadService.save(entity);
    }

    //!Select by id
    @GetMapping( value = "especialidad/{id}")
    public Especialidad findById(@PathVariable Long id)
    {
        return especialidadService.findById(id);
    }

    //!update
    @PutMapping(value = "especialidad")
    public Especialidad Update(@RequestBody Especialidad entity)
    {
        return especialidadService.save(entity);
    }

    //!Delete
    @DeleteMapping(value = "especialidad/{id}")
    public void deleteById(@PathVariable Long id)
    {
        especialidadService.deleteById(id);
    }

    //!Select all
    @GetMapping(value = "especialidad")
    public List<Especialidad> findAll()
    {
        return especialidadService.findAll();
    }

    //!Update by 
    @PutMapping(value = "especialidad/{id}")
    public ResponseEntity<Especialidad> updateById(@PathVariable Long id, @RequestBody Especialidad entity)
    {
        return especialidadService.updateById(id, entity);
    }
}
