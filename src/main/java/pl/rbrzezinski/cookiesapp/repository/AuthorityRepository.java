package pl.rbrzezinski.cookiesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rbrzezinski.cookiesapp.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
