package seguridadreact3.seguridadreact.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class PublicoController {

    @GetMapping("/info")
    public Map<String, Object> getInfoPublica() {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Este es un recurso público");
        response.put("timestamp", System.currentTimeMillis());

        return response;
    }
}