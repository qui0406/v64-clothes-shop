package tlaq.com.backendV64.mapper;

import org.mapstruct.Mapper;
import tlaq.com.backendV64.dto.request.RoleRequest;
import tlaq.com.backendV64.dto.response.RoleResponse;
import tlaq.com.backendV64.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
