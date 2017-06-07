package oop.shcherbak.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kolja on 01.06.2017.
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String getIndex(){
        return "<a href=\"t_issued.html\"><button>Видані автомобілі</button></a>\n" +
                "<a href=\"t_cars.html\"><button>Автомобілі</button></a>\n" +
                "<a href=\"t_client.html\"><button>Клієнт</button></a>";
    }
}
