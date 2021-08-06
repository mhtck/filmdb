package filmdb.filmdb.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import filmdb.filmdb.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

}
