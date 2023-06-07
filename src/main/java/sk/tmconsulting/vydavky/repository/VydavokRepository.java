package sk.tmconsulting.vydavky.repository;

import sk.tmconsulting.vydavky.model.Vydavok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VydavokRepository extends JpaRepository<Vydavok, Long> {
}
