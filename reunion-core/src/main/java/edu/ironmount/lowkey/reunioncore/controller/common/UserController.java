package edu.ironmount.lowkey.reunioncore.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ironmount.lowkey.reunioncore.model.common.User;
import edu.ironmount.lowkey.reunioncore.model.request.UserDetail;
import edu.ironmount.lowkey.reunioncore.service.common.UserService;

@Controller
@RequestMapping(path = "/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/")
    public @ResponseBody ResponseEntity<UserDetail> createUser(@RequestBody UserDetail body) {
        userService.createUser(body);
        return ResponseEntity.ok(body);
    }

    @GetMapping(path = "/page")
    public @ResponseBody ResponseEntity<Iterable<User>> getUsers(
        @RequestParam(name = "limit", defaultValue = "10") Integer limit,
        @RequestParam(name = "offset", defaultValue = "0") Integer offset
    ) {
        List<User> users = userService.getUserBySortPage(limit, offset, "user_id");
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<UserDetail> updateUser(@PathVariable(name = "id") Long id, @RequestBody UserDetail detail) {
        userService.updateUser(id, detail);
        return ResponseEntity.ok(detail);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Long> deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(id);
    }
}
