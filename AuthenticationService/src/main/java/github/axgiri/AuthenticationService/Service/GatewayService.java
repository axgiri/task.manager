package github.axgiri.AuthenticationService.Service;

import org.springframework.stereotype.Service;

import github.axgiri.AuthenticationService.DTO.AuthRequestDTO;
import github.axgiri.AuthenticationService.Security.Middleware;
import github.axgiri.AuthenticationService.Security.TokenService;

@Service
public class GatewayService {

    public UserCompanyService userCompanyService;
    public Middleware middleware;
    public TokenService tokenService;

    public GatewayService(UserCompanyService userCompanyService, Middleware middleware, TokenService tokenService) {
        this.userCompanyService = userCompanyService;
        this.middleware = middleware;
        this.tokenService = tokenService;
    }

    public boolean checkIsMember(AuthRequestDTO authRequestDTO) {
        String email = tokenService.extractUsername(authRequestDTO.getToken());
        return middleware.isCompanyMember(email, authRequestDTO.getCompanyId());
    }

    public boolean checkIsModerator(AuthRequestDTO authRequestDTO) {
        String email = tokenService.extractUsername(authRequestDTO.getToken());
        return middleware.isCompanyModerator(email, authRequestDTO.getCompanyId());
    };

    public boolean checkIsAdmin(AuthRequestDTO authRequestDTO) {
        String email = tokenService.extractUsername(authRequestDTO.getToken());
        return middleware.isCompanyAdmin(email, authRequestDTO.getCompanyId());
    }

    public boolean checkIsSameUser(AuthRequestDTO authRequestDTO) {
        String email = tokenService.extractUsername(authRequestDTO.getToken());
        return middleware.isSameUser(email, authRequestDTO.getCreatedBy());
    }

    public boolean checkTokenAndCompany(String token) {
        return userCompanyService.validate(token);
    }
}
