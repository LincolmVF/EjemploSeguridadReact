package seguridadreact.seguridadreact.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;
import seguridadreact.seguridadreact.io.ProfileRequest;
import seguridadreact.seguridadreact.io.ProfileResponse;
import seguridadreact.seguridadreact.service.ProfileService;

@RestController

public class ProfileController {

    @Autowired
    private ProfileService profileService;

@PostMapping("/register")
@ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest profileRequest) {
        ProfileResponse profileResponse = profileService.createProfile(profileRequest);
    return profileResponse;
    }


@GetMapping("/profile")
public ProfileResponse getProfile(@CurrentSecurityContext(expression = "authentication?.name") String email) {
 return profileService.getProfile(email);
}

}
