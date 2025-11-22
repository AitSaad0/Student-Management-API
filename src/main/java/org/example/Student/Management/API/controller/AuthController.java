package org.example.Student.Management.API.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> apiLogin(@RequestBody LoginRequestDto loginRequestDto) {
        try{
            Authentication authentication = authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(loginRequestDto.username(),
                    loginRequestDto.password()));
            String jwtToken = jwtUtil.generateJwtToken(authentication);
            var userDto = new UserDto();
            var logginUser = (User) authentication.getPrincipal();
            userDto.setFullName(logginUser.getUsername());
            return ResponseEntity.ok(new LoginResponseDto(HttpStatus.OK.getReasonPhrase(), userDto, jwtToken));

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
