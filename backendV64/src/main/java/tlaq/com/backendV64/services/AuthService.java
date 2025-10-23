package tlaq.com.backendV64.services;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;
import tlaq.com.backendV64.dto.request.AuthRequest;
import tlaq.com.backendV64.dto.request.IntrospectRequest;
import tlaq.com.backendV64.dto.request.LogoutRequest;
import tlaq.com.backendV64.dto.request.RefreshRequest;
import tlaq.com.backendV64.dto.response.AuthResponse;
import tlaq.com.backendV64.dto.response.IntrospectResponse;
import tlaq.com.backendV64.entity.User;

import java.text.ParseException;

public interface AuthService {
    IntrospectResponse introspect(IntrospectRequest request);
    AuthResponse authenticate(AuthRequest request);
    void logout(LogoutRequest request);
    AuthResponse refreshToken(RefreshRequest request) throws ParseException, JOSEException;
    String generateToken(User user);
}
