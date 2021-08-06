package filmdb.filmdb.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filmdb.filmdb.business.abstracts.LanguageService;
import filmdb.filmdb.core.utilities.results.DataResult;
import filmdb.filmdb.core.utilities.results.Result;
import filmdb.filmdb.core.utilities.results.SuccessDataResult;
import filmdb.filmdb.core.utilities.results.SuccessResult;
import filmdb.filmdb.dataAccess.abstracts.LanguageDao;
import filmdb.filmdb.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),"Data listelendi");

	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Dil Eklendi");
	}
}
