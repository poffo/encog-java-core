package org.encog.app.generate.generators;

import java.io.File;

import org.encog.app.generate.program.EncogProgram;

public interface LanguageSpecificGenerator {
	void generate(EncogProgram program, boolean embed);
	void writeContents(File targetFile);
	String getContents();
}
