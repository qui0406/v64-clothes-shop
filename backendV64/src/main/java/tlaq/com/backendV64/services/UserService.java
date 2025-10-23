package tlaq.com.backendV64.services;

import tlaq.com.backendV64.dto.request.RegisterRequest;
import tlaq.com.backendV64.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(RegisterRequest request);
    void deleteUser(String userId);
    UserResponse getMyInfo();
    List<UserResponse> getUsers();
    UserResponse getUser(String id);
}
