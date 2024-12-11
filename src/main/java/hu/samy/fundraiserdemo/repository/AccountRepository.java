package hu.samy.fundraiserdemo.repository;

import hu.samy.fundraiserdemo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select case when(count(a)>0)then true else false end from Account a where a.ipAddress=:ipAddress")
    boolean ipAddressIsExists(String ipAddress);


    Optional<Account> findByIpAddress(String ipAddress);



    @Query("select a from Account a where a.ipAddress != :remoteAddr")
    List<Account> getAllAccountsExceptMine(String remoteAddr);
}
