package kezekten_tis.kezekten_tis.api;


import kezekten_tis.kezekten_tis.Services.RolesService;
import kezekten_tis.kezekten_tis.Services.UserService;
import kezekten_tis.kezekten_tis.models.Role;
import kezekten_tis.kezekten_tis.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/register")
@RequiredArgsConstructor

public class User_Rest_controller {

    private final UserService userService;
    private final RolesService rolesService;

    @PostMapping
    public ModelAndView adduser(@RequestParam(name = "full_name") String fullname,
                                @RequestParam(name = "email") String email,
                                @RequestParam(name = "password")String password,
                                @RequestParam(name = "confirmed_password")String confirmed_password){


    List<Role> rolesList=rolesService.get_role_list();
    Role user_role=rolesList.get(1);

            User user=new User();
            user.setFull_name(fullname);
            user.setEmail(email);
            user.setPassword(password);
            ArrayList<Role>roleslist=new ArrayList<>();
            roleslist.add(user_role);
            user.setRolesList(roleslist);
            userService.adduser(user,confirmed_password);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("signup");
        return mv;
    }






}
