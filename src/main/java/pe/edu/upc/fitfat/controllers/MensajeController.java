package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.MensajeDTO;
import pe.edu.upc.fitfat.entities.Mensaje;
import pe.edu.upc.fitfat.serviceinterfaces.IMensajeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    @Autowired
    private IMensajeService mS;

    @GetMapping
    public List<MensajeDTO> listar() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MensajeDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody MensajeDTO dto) {
        ModelMapper m = new ModelMapper();
        Mensaje mensaje = m.map(dto, Mensaje.class);
        mS.insert(mensaje);
    }

    @GetMapping("/{id}")
    public MensajeDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(mS.listId(id), MensajeDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody MensajeDTO dto) {
        ModelMapper m = new ModelMapper();
        Mensaje mensaje = m.map(dto, Mensaje.class);
        mS.update(mensaje);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        mS.delete(id);
    }

    @GetMapping("/buscarxasunto")
    public List<MensajeDTO> buscarxasunto(@RequestParam String a) {
        return mS.buscarxasunto(a).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MensajeDTO.class);
        }).collect(Collectors.toList());
    }
}
