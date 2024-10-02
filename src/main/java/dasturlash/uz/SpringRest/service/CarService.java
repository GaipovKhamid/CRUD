package dasturlash.uz.SpringRest.service;

import dasturlash.uz.SpringRest.dto.CarDTO;
import org.springframework.stereotype.Service;


import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class CarService {
    private List<CarDTO> CarList = new LinkedList<>();

    public List<CarDTO> cardto() {
        return CarList;
    }

    public CarDTO getById(String id) {
        for (CarDTO dto : CarList) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }
        return null;
    }

    public CarDTO create(CarDTO dto) {
        validation(dto);
        dto.setId(UUID.randomUUID().toString());
        CarList.add(dto);
        return dto;
    }

    public boolean update(String id, CarDTO dto) {
        validation(dto);

        CarDTO exist = get(id);
        if (exist == null) {
            throw new IllegalArgumentException("Car not found");
        }

        exist.setName(dto.getName());
        exist.setModel(dto.getModel());
        exist.setYear(dto.getYear());
        return false;
    }

    public boolean delete(String id) {
        for (CarDTO exist : CarList) {
            if (exist.getId().equals(id)) {
                CarList.remove(exist);
                return true;
            }
        }
        return false;
    }

    public void validation(CarDTO dto) {
        if (dto.getName() == null || dto.getName().trim().length() < 2) {
            throw new IllegalArgumentException("Name required");
        }
        if (dto.getModel() == null || dto.getModel().trim().length() < 2) {
            throw new IllegalArgumentException("Model required");
        }
        if (dto.getYear() == null || dto.getYear().length() < 2) {
            throw new IllegalArgumentException("Year required");
        }
    }

    public CarDTO get(String id) {
        for (CarDTO exist : CarList) {
            if (exist.getId().equals(id)) {
                return exist;
            }
        }
        return null;
    }

}
