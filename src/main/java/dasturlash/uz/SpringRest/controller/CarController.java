package dasturlash.uz.SpringRest.controller;

import dasturlash.uz.SpringRest.dto.CarDTO;
import dasturlash.uz.SpringRest.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    public CarService carService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CarDTO dto) {
        try {
            CarDTO responseDTO = carService.create(dto);

            ResponseEntity<CarDTO> response = new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(200));
            return response;
        } catch (IllegalArgumentException e) {
            ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
            return response;
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody CarDTO dto) {
        try {
            boolean result = carService.update(id, dto);
            //ResponseEntity<Boolean> response = new ResponseEntity<>(result, HttpStatus.OK);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return carService.delete(id);
    }

    @GetMapping(value = "/all")
    public List<CarDTO> getAll() {
        return carService.cardto();
    }

    @RequestMapping("/byid/{id}")
    public CarDTO getById(@PathVariable("id") String id) {
        return carService.getById(id);
    }

}
