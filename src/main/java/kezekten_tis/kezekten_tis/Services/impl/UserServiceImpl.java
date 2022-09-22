package kezekten_tis.kezekten_tis.Services.impl;


import kezekten_tis.kezekten_tis.Services.RolesService;
import kezekten_tis.kezekten_tis.Services.UserService;
import kezekten_tis.kezekten_tis.models.User;
import kezekten_tis.kezekten_tis.repositories.UserRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositories user_repositories;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolesService rolesService;

    @Override
    public UserDetails loadUserByUsername(String user_email) throws UsernameNotFoundException {
        User user = user_repositories.findByEmail(user_email);
        if (user != null)
            return user;
        throw new UsernameNotFoundException("User not Found");
    }

    @Override
    public void adduser(User user,String re_password) {
        if(user.getPassword().equals(re_password)){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
         user_repositories.save(user);
    }

    @Override
    public void updateuserpassword(User user, String oldpassword, String newpassword, String renewpassword) {
        passwordEncoder.matches(oldpassword,user.getPassword());
        user.setPassword(passwordEncoder.encode(newpassword));
        user_repositories.save(user);
    }

    @Override
    public User getcurrentuser() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User user= (User) authentication.getPrincipal();
            return user;
        }

        return null;
    }


}
