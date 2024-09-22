package dasturlash.uz.SpringRest;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/car")
@RestController
public class CarController {

    private List<CarDTO> CarList = new LinkedList<>();

    @PostMapping("/create")
    public CarDTO create(@RequestBody CarDTO dto) {
        dto.setId(UUID.randomUUID().toString());
        CarList.add(dto);
        return dto;
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") String id, @RequestBody CarDTO dto) {
        for (CarDTO dto1 : CarList) {
            if (dto1.getId().equals(id)) {
                dto1.setName(dto.getName());
                dto1.setModel(dto.getModel());
                dto1.setYear(dto.getYear());
                return true;
            }
        }
        return false;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        for (CarDTO exist : CarList) {
            if (exist.getId().equals(id)) {
                CarList.remove(exist);
                return true;
            }
        }
        return false;
    }

    @GetMapping(value = "/all")
    public List<CarDTO> getAll() {
        return CarList;
    }

    @RequestMapping("/byid/{id}")
    public CarDTO getById(@PathVariable("id") String id) {
        for (CarDTO dto : CarList) {
            if (dto.getName().equals(id)) {
                return dto;
            }
        }
        return null;
    }

}
