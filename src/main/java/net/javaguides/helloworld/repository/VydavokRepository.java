package net.javaguides.helloworld.repository;

import net.javaguides.helloworld.model.Vydavok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VydavokRepository extends JpaRepository<Vydavok, Long> {
}
