package rs.ac.uns.ftn.sep.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.sep.authentication.bom.UserAccount;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findOneByEmail(String email);

}
