package seguridadreact.seguridadreact.service;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import seguridadreact.seguridadreact.entity.UserEntity;
import seguridadreact.seguridadreact.io.ProfileRequest;
import seguridadreact.seguridadreact.io.ProfileResponse;
import seguridadreact.seguridadreact.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final  UserRepository userRepository;

private final PasswordEncoder passwordEncoder;


    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
        UserEntity newProfile = convertToUserEntity(request);
        if(!userRepository.existsByEmail(request.getEmail())) {
            newProfile = userRepository.save(newProfile);


            return convertToProfileResponse(newProfile);
        }
throw new ResponseStatusException(HttpStatus.CONFLICT, "El email ya existe");

    }

    @Override
    public ProfileResponse getProfile(String email) {
       UserEntity existingUser =     userRepository.findByEmail(email)
                  .orElseThrow(() -> new UsernameNotFoundException("El usuario"+ email +"no fue encontrado"));

return convertToProfileResponse(existingUser);
    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
    return ProfileResponse.builder()
            .name(newProfile.getName())
            .email(newProfile.getEmail())
            .userId(newProfile.getUserId())
            .isAccountVerified(newProfile.getIsAccountVerified())
            .build();
    }

    private UserEntity convertToUserEntity(ProfileRequest request) {
         return UserEntity.builder()
                .email(request.getEmail())
                .userId(UUID.randomUUID().toString())
                .name(request.getNombre())
                .password(passwordEncoder.encode(request.getPassword()))
                .isAccountVerified(false)
                .resetOtpExpireAt(0L)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .resetOtp(null)
                .build();
    }
}
