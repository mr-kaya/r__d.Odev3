package org.mustafakaya.odev9.API.Contoller;

import org.mustafakaya.odev9.Core.DTO.UserSaveDto;
import org.mustafakaya.odev9.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody UserSaveDto userSaveDto) {
        userService.save(userSaveDto);

        return new ResponseEntity<>("Kullanıcı kaydı başarılı.", HttpStatus.CREATED);
    }
}
