package kezekten_tis.kezekten_tis.Services;
import kezekten_tis.kezekten_tis.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDetails loadUserByUsername(String email);
    void adduser(User user,String re_password);
    void updateuserpassword(User user,String oldpassword,String newpassword,String renewpassword);
    User getcurrentuser();

    }
