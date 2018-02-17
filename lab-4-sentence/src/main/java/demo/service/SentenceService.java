package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.AdjectiveClient;
import demo.dao.ArticleClient;
import demo.dao.NounClient;
import demo.dao.SubjectClient;
import demo.dao.VerbClient;

@Service
public class SentenceService {

	@Autowired
	private AdjectiveClient adjectiveClient;

	@Autowired
	private VerbClient verbClient;

	@Autowired
	private ArticleClient articleClient;

	@Autowired
	private SubjectClient subjectClient;

	@Autowired
	private NounClient nounClient;

	public String getWords() {
		String phrase =
			String.format("%s %s %s %s %s",
				this.subjectClient.getWords(),
				this.verbClient.getWords(),
				this.articleClient.getWords(),
				this.adjectiveClient.getWords(),
				this.nounClient.getWords());
		return phrase;
	}

}
