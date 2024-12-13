package invest.invest.repositories;

import invest.invest.models.FiiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FiiRepository extends JpaRepository<FiiModel, UUID> {

    Optional<FiiModel> findBySiglaFii(String siglaFii);
}
