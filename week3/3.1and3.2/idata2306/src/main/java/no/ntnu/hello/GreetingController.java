package no.ntnu.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST API controller which responds to HTTP requests for /hello
 */
@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String greeting() {
        return "Hei, World";
    }

    @DeleteMapping("/hello")
    public ResponseEntity<String> delete() {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


    @GetMapping("/hei")
    public ResponseEntity<String> hei() {
        return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
    }
}

