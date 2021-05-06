package br.com.tiagoiwamoto.iwtlulu.controller.rest;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 05/05/2021 | 20:50
 */

import br.com.tiagoiwamoto.iwtlulu.business.object.UserBO;
import br.com.tiagoiwamoto.iwtlulu.entity.User;
import br.com.tiagoiwamoto.iwtlulu.model.ApiDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/api/users")
public class UserRestController {

    private final UserBO userBO;

    public UserRestController(UserBO userBO) {
        this.userBO = userBO;
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public ResponseEntity<ApiDTO<User>> login(@RequestHeader(name = "x-username") String username,
                                              @RequestHeader(name = "x-password") String password){
        return ResponseEntity.ok(this.userBO.performLogin(username, password));
    }

    @PostMapping(path = "/email")
    @ResponseBody
    public ResponseEntity<ApiDTO<User>> recoverUserByEmail(@RequestHeader(name = "x-email") String email){
        return ResponseEntity.ok(this.userBO.performFindUserByEmail(email));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ApiDTO<User>> create(@RequestBody User user){
        return ResponseEntity.ok(this.userBO.performUserCreation(user));
    }
}
