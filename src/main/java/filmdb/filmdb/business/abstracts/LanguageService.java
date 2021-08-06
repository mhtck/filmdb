package filmdb.filmdb.business.abstracts;

import java.util.List;

import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.entities.concretes.Language;

public interface LanguageService {
	DataResult<List<Language>> getAll();
	Result add(Language language);
}
