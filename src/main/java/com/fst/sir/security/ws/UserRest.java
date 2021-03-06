package com.fst.sir.security.ws;

import com.fst.sir.security.bean.User;
import com.fst.sir.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admin")
@RestController
// @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
public class UserRest {

    @GetMapping("/block-unblock/{username}")
    public int blockUnblock(@PathVariable String username) {
        return userService.blockUnblock(username);
    }

    @GetMapping("/current-user/")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @Autowired
    private UserService userService;

    @GetMapping("/agent/")
    public List<User> findByAuthorities() {
        return userService.findByAuthorities();
    }

    @GetMapping("/")
    public List<User> findAll() {
        return this.userService.findAll();
    }


    /* Admin */
    @PostMapping("/save")
    public User saveAdmin(@RequestBody User user) {
        return userService.saveAdmin(user);
    }

    /* Agent */
    @PostMapping("/agent/add/")
    public User saveAgent(@RequestBody User user) {
        return userService.saveAGENT(user);
    }

    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }


    @PutMapping("/")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/id/{id}")
    public int delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/username/{username}")
    public User findByUsernameWithRoles(@PathVariable String username) {
        return userService.findByUsernameWithRoles(username);
    }

    @DeleteMapping("/username/{username}")
    public int deleteByUsername(@PathVariable String username) {
        return userService.deleteByUsername(username);
    }

}

