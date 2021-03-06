package com.fst.sir.security.service.facade;

import com.fst.sir.security.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    String getUserRole(String username);

    List<User> findAll();


    List<User> findByAuthorities();

    User findByUsername(String username);

    User findByPhone(String phone);

    User findById(Long id);

    void deleteById(Long id);

    /*  Client  */
    User save(User user);



    int blockUnblock(String username);

    User getCurrentUser();



    /*  Admin  */
    User saveAdmin(User user);

    /*  Gerant  */
    User saveAGENT(User user);

    User update(User user);

    int delete(Long id);

    User findByUsernameWithRoles(String username);

    int deleteByUsername(String username);

    UserDetails loadUserByUsername(String username);

}
