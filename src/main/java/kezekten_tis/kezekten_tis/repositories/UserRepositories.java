package kezekten_tis.kezekten_tis.repositories;


import kezekten_tis.kezekten_tis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepositories extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
