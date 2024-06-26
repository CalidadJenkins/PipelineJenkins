package co.edu.usbcali.airlinesapp.controllers;

import co.edu.usbcali.airlinesapp.services.interfaces.RolUsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.usbcali.airlinesapp.dtos.RolUsuarioDTO;
import co.edu.usbcali.airlinesapp.dtos.MensajeDTO;

import java.util.List;

@RestController
@RequestMapping("/rolUsuario")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class RolUsuarioController {
    private final RolUsuarioService rolUsuarioService;

    public RolUsuarioController(RolUsuarioService rolUsuarioService) {
        this.rolUsuarioService = rolUsuarioService;
    }

    @PostMapping(path = "/guardarRolUsuario",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarRolUsuario(@RequestBody RolUsuarioDTO rolUsuarioDTO) {
        try {
            return new ResponseEntity(rolUsuarioService.guardarRolUsuario(rolUsuarioDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerRolUsuarios")
    public ResponseEntity<List<RolUsuarioDTO>> obtenerRolUsuarios() {
        return new ResponseEntity(rolUsuarioService.obtenerRolUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/obtenerRolUsuariosActivos")
    public ResponseEntity<List<RolUsuarioDTO>> obtenerRolUsuariosActivos() {
        return new ResponseEntity(rolUsuarioService.obtenerRolUsuariosActivos(), HttpStatus.OK);
    }

    @GetMapping("/obtenerRolUsuario/{idRolUsuario}")
    public ResponseEntity<RolUsuarioDTO> obtenerRolUsuario(@PathVariable("idRolUsuario") Integer idRolUsuario) {
        try {
            return new ResponseEntity(rolUsuarioService.obtenerRolUsuarioPorId(idRolUsuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/actualizarRolUsuario",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarRolUsuario(@RequestBody RolUsuarioDTO rolUsuarioDTO) {
        try {
            return new ResponseEntity(rolUsuarioService.actualizarRolUsuario(rolUsuarioDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/eliminarRolUsuario/{idRolUsuario}")
    public ResponseEntity eliminarRolUsuario(@PathVariable("idRolUsuario") Integer idRolUsuario) {
        try {
            return new ResponseEntity(rolUsuarioService.eliminarRolUsuario(idRolUsuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
