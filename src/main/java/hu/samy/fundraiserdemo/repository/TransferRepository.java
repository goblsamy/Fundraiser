package hu.samy.fundraiserdemo.repository;

import hu.samy.fundraiserdemo.domain.Transfer;
import hu.samy.fundraiserdemo.dto.TransferListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query("select new hu.samy.fundraiserdemo.dto.TransferListItem(t.id, t.source.username,t.target.username, t.amount, t.timestamp) " +
            "from Transfer  t")
    List<TransferListItem> findAllTransfers();
}
