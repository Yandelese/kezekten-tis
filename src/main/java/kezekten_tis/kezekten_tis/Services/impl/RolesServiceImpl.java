package kezekten_tis.kezekten_tis.Services.impl;
import kezekten_tis.kezekten_tis.Services.RolesService;
import kezekten_tis.kezekten_tis.models.Role;
import kezekten_tis.kezekten_tis.repositories.RolesRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RolesServiceImpl implements RolesService {

    private final RolesRepositories rolesrepositories;

    @Override
    public List<Role> get_role_list() {
        return rolesrepositories.findAll();
    }
}
