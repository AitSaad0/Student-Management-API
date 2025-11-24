package org.example.Student.Management.API.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Student.Management.API.dto.LoginRequestDto;
import org.example.Student.Management.API.dto.LoginResponseDto;
import org.example.Student.Management.API.dto.RegisterRequestDto;
import org.example.Student.Management.API.dto.StudentDto;
import org.example.Student.Management.API.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> apiLogin(@RequestBody LoginRequestDto loginRequestDto) {
        try{
            Authentication authentication = authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(loginRequestDto.username(),
                    loginRequestDto.password()));
            String jwtToken = jwtUtil.generateJwtToken(authentication);
            var studentDto = new StudentDto();
            var logginUser = (User) authentication.getPrincipal();
            studentDto.setFirst_name(logginUser.getUsername());
            return ResponseEntity.ok(new LoginResponseDto(HttpStatus.OK.getReasonPhrase(), studentDto, jwtToken));

        }catch(BadCredentialsException e){
            return buildErrorResponse(HttpStatus.UNAUTHORIZED,
                    "Invalid username or password");
        }catch (AuthenticationException ex) {
            return buildErrorResponse(HttpStatus.UNAUTHORIZED,
                    "Authentication failed");
        } catch (Exception ex) {
            return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    "An unexpected error occurred");
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> apiRegister(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        InMemoryUserDetailsManager inMemoryUserDetailsManager =  (InMemoryUserDetailsManager)userDetailsService;
        inMemoryUserDetailsManager.createUser(new User(registerRequestDto.getEmail(),
                passwordEncoder.encode(registerRequestDto.getPassword()),
                List.of(new SimpleGrantedAuthority("USER"))));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Registration successful");
    }


    private ResponseEntity<LoginResponseDto> buildErrorResponse(HttpStatus status,
                                                                String message) {
        return ResponseEntity
                .status(status)
                .body(new LoginResponseDto(message, null, null));
    }
}
