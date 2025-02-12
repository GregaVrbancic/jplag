package de.jplag.javax;

import java.io.File;

public class Parser extends de.jplag.Parser implements JavaTokenConstants {
	private String actFile;

	private de.jplag.TokenList struct;

	public de.jplag.TokenList parse(File dir, String files[]) {
		struct = new de.jplag.TokenList();
		errors = 0;
		JavaParser parser = null;// no worry it will be reinitialized
		// in method parseFile(...)
		for (int i = 0; i < files.length; i++) {
			actFile = files[i];
			getProgram().print(null, "Parsing file " + files[i] + "\n");
			if (!JavaParser.parseFile(dir, files[i], parser, this))
				errors++;
			struct.addToken(new JavaToken(FILE_END, actFile, 0));
		}
		if (errors == 0)
			program.print(null, "OK\n");
		else
			program.print(null, errors + " ERRORS\n");
		this.parseEnd();
		return struct;
	}

	public void add(int type, Token token) {
		struct.addToken(new JavaToken(type, actFile, token.beginLine));
	}

}
