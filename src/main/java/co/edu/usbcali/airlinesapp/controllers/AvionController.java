package co.edu.usbcali.airlinesapp.controllers;

import co.edu.usbcali.airlinesapp.services.interfaces.AvionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.usbcali.airlinesapp.dtos.AvionDTO;
import co.edu.usbcali.airlinesapp.dtos.MensajeDTO;

import java.util.List;

@RestController
@RequestMapping("/avion")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class AvionController {
    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @PostMapping(path = "/guardarAvion",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarAvion(@RequestBody AvionDTO avionDTO) {
        try {
            return new ResponseEntity(avionService.guardarAvion(avionDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerAviones")
    public ResponseEntity<List<AvionDTO>> obtenerAviones() {
        return new ResponseEntity(avionService.obtenerAviones(), HttpStatus.OK);
    }

    @GetMapping("/obtenerAvionesActivos")
    public ResponseEntity<List<AvionDTO>> obtenerAvionesActivos() {
        return new ResponseEntity(avionService.obtenerAvionesActivos(), HttpStatus.OK);
    }

    @GetMapping("/obtenerAvion/{idAvion}")
    public ResponseEntity<AvionDTO> obtenerAvion(@PathVariable("idAvion") Integer idAvion) {
        try {
            return new ResponseEntity(avionService.obtenerAvionPorId(idAvion), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/actualizarAvion",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarAvion(@RequestBody AvionDTO avionDTO) {
        try {
            return new ResponseEntity(avionService.actualizarAvion(avionDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/eliminarAvion/{idAvion}")
    public ResponseEntity eliminarAvion(@PathVariable("idAvion") Integer idAvion) {
        try {
            return new ResponseEntity(avionService.eliminarAvion(idAvion), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
