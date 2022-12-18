package ma.ensias.springbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Map<Integer,String> welcomeToSpring() {
        Map<Integer,String> map = new HashMap<>() ;
        Stream.of("ali" , "med" , "ahmed").forEach(
                n -> {
                    map.put( new Random().nextInt(20) , n ) ;
                }
        );

        return map ;
    }
}
