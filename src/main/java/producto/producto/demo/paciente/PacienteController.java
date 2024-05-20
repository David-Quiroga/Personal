package producto.producto.demo.paciente;

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
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    //!Create
    @PostMapping(value = "paciente")
    public Paciente save(@RequestBody Paciente entity)
    {
        return pacienteService.save(entity);
    }

    //!Select by id
    @GetMapping(value = "paciente/{id}")
    public Paciente findById(@PathVariable Long id)
    {
        return pacienteService.findById(id);
    }

    //! update
    @PutMapping(value = "paciente")
    public Paciente Update(@RequestBody Paciente entity)
    {
        return pacienteService.save(entity);
    }

    //! Delete
    @DeleteMapping(value = "paciente/{id}")
    public void deleteById(@PathVariable Long id)
    {
        pacienteService.deleteById(id);
    }

    //! Select all
    @GetMapping(value = "paciente")
    public List<Paciente> findAll()
    {
        return pacienteService.findAll();
    }

    //! Update by id
    @PutMapping(value = "paciente/{id}")
    public ResponseEntity<Paciente> updateById(@PathVariable Long id,@RequestBody Paciente entity)
    {
        return pacienteService.updateById(id, entity);
    }
}
