package tlaq.com.backendV64.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tlaq.com.backendV64.dto.request.RegisterRequest;
import tlaq.com.backendV64.dto.response.UserResponse;
import tlaq.com.backendV64.entity.Role;
import tlaq.com.backendV64.entity.User;
import tlaq.com.backendV64.exeptions.AppException;
import tlaq.com.backendV64.exeptions.ErrorCode;
import tlaq.com.backendV64.mapper.UserMapper;
import tlaq.com.backendV64.repository.RoleRepository;
import tlaq.com.backendV64.repository.UserRepository;
import tlaq.com.backendV64.services.UserService;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(RegisterRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<Role> roles = new HashSet<>();
        roles.add(Role.builder()
                        .id(1)
                        .name("ROLE_USER")
                        .description("ROLE_USER")
                .build());
        user.setRoles(roles);
        user.setEmailVerified(false);

        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        User user = userRepository.findById(name)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() ->
                        new AppException(ErrorCode.USER_NOT_EXISTED)));
    }
}
