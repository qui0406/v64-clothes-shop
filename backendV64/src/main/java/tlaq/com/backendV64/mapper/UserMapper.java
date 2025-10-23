package tlaq.com.backendV64.mapper;

import org.mapstruct.Mapper;
import tlaq.com.backendV64.dto.request.RegisterRequest;
import tlaq.com.backendV64.dto.response.UserResponse;
import tlaq.com.backendV64.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(RegisterRequest request);
    UserResponse toUserResponse(User user);

}
