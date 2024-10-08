package dasturlash.uz.SpringRest;

import dasturlash.uz.SpringRest.controller.CarController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
        CarController carController = new CarController();
        carController.getAll();
    }

}
