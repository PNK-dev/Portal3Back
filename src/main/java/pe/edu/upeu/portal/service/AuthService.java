package pe.edu.upeu.portal.service;

import pe.edu.upeu.portal.dto.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}