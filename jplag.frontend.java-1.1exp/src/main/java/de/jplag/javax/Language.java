package de.jplag.javax;

import java.io.File;

import de.jplag.ProgramI;

public class Language implements de.jplag.Language {
	private Parser parser;

	public Language(ProgramI program) {
		this.parser = new Parser();
		this.parser.setProgram(program);

	}

	@Override
    public int errorsCount() {
		return this.parser.errorsCount();
	}

	@Override
    public String[] suffixes() {
		String[] res = { ".java", ".jav", ".JAVA", ".JAV" };
		return res;
	}

	@Override
    public String name() {
		return "experimental Java1.1";
	}

	@Override
    public String getShortName() {
		return "Java1.1(exp)";
	}

	@Override
    public int min_token_match() {
		return 15;
	}

	@Override
    public boolean supportsColumns() {
		return false;
	}

	@Override
    public boolean isPreformatted() {
		return true;
	}

	@Override
    public boolean usesIndex() {
		return false;
	}

	@Override
    public de.jplag.TokenList parse(File dir, String[] files) {
		return this.parser.parse(dir, files);
	}

	@Override
    public boolean errors() {
		return this.parser.getErrors();
	}

	@Override
    public int noOfTokens() {
		return de.jplag.javax.JavaToken.numberOfTokens();
	}

	@Override
    public String type2string(int type) {
		return de.jplag.javax.JavaToken.type2string(type);
	}
}
