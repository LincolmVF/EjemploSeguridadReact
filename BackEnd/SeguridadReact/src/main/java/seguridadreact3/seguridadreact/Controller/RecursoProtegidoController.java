package seguridadreact3.seguridadreact.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/protegido")
public class RecursoProtegidoController {

    @GetMapping("/info")
    public ResponseEntity<?> getInfoProtegida() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Este es un recurso protegido");
        response.put("usuario", auth.getName());
        response.put("roles", auth.getAuthorities());

        return ResponseEntity.ok(response);
    }
}