package seguridadreact.seguridadreact.service;


import seguridadreact.seguridadreact.io.ProfileRequest;
import seguridadreact.seguridadreact.io.ProfileResponse;

public interface ProfileService {


 ProfileResponse createProfile(ProfileRequest request);

 ProfileResponse getProfile(String email);


}
