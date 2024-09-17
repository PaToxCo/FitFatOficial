package pe.edu.upc.fitfat.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.fitfat.dtos.UsuariosDTO;
import pe.edu.upc.fitfat.entities.Usuarios;
import pe.edu.upc.fitfat.serviceinterfaces.IUsuariosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuariosService uS;

    @GetMapping
    public List<UsuariosDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuariosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuariosDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuarios usuario = m.map(dto, Usuarios.class);
        uS.insert(usuario);
    }

    @GetMapping("/{id}")
    public UsuariosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(uS.listId(id), UsuariosDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody UsuariosDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuarios usuario = m.map(dto, Usuarios.class);
        uS.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        uS.delete(id);
    }

    @GetMapping("/buscarxcorreo")
    public List<UsuariosDTO> buscarxcorreo(@RequestParam String email) {
        return uS.buscarxcorreo(email).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuariosDTO.class);
        }).collect(Collectors.toList());
    }
}
