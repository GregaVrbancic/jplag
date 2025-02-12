package de.jplag.java17;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import de.jplag.StrippedProgram;
import de.jplag.java17.grammar.Java7Lexer;
import de.jplag.java17.grammar.Java7Parser;

public class ParserTest {

	private static File srcTestResources;

	@BeforeClass
	public static void getPaths() {
		srcTestResources = new File(System.getProperty("user.dir"), "src/test/resources");
	}

	/**
	 * Parses a (useless) class that uses all the fancy Java 7 syntax features
	 * that I was able to find so far. The output is not compared to anything.
	 * This test should only assure that we have covered all new features with
	 * the grammar.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testTheNewFancyJava7Features() throws IOException {
		File file = new File(srcTestResources, "Java7FeatureTest.java");
		FileInputStream fis = new FileInputStream(file);
		CharStream input = CharStreams.fromStream(fis);
		Java7Lexer lexer = new Java7Lexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Java7Parser parser = new Java7Parser(tokens);
		parser.compilationUnit();
	}

	@Ignore
	public void j7Template() throws IOException {
		File file = new File(srcTestResources, "J7StringSwitch.java");
		String expected = ""// @formatter:off
				+ "********\n"; // @formatter:on
		String tokens = parseWithJ7Parser(file, false);
		assertEquals(expected, tokens);
	}

	/**
	 * added for ticket #58
	 */
	@Test
	public void emptyFileOnlyComments() throws IOException {
		compareWithParser15(new File(srcTestResources, "EmptyFileOnlyComments.java"));
	}

	@Test
	public void emptyFile() throws IOException {
		compareWithParser15(new File(srcTestResources, "EmptyFile.java"));
	}

	@Test
	public void j7StringSwitchTest() throws IOException {
		File file = new File(srcTestResources, "J7StringSwitch.java");
		String expected ="" // @formatter:off
				+"CLASS{  \n"
				+"VOID    \n"
				+"METHOD{ \n"
				+"SWITCH{ \n"
				+"CASE    \n"
				+"BREAK   \n"
				+"CASE    \n"
				+"CASE    \n"
				+"BREAK   \n"
				+"CASE    \n"
				+"BREAK   \n"
				+"}SWITCH \n"
				+"}METHOD \n"
				+"}CLASS  \n"
				+ "********\n"; // @formatter:on
		String tokens = parseWithJ7Parser(file, false);
		assertEquals(expected, tokens);
	}

	@Test
	public void j7TryCatchTest() throws IOException {
		File file = new File(srcTestResources, "J7TryCatch.java");
		String expected ="IMPORT  \n" // @formatter:off
				+"IMPORT  \n"
				+"IMPORT  \n"
				+"CLASS{  \n"
				+"VOID    \n"
				+"METHOD{ \n"
				+"TRY{    \n"
				+"CATCH{  \n"
				+"}CATCH  \n"
				+"FINALLY \n"
				+"}METHOD \n"
				+"VOID    \n"
				+"METHOD{ \n"
				+"TRY{    \n"
				+"TRY_RES \n"
				+"NEWCLASS\n"
				+"APPLY   \n"
				+"CATCH{  \n"
				+"}CATCH  \n"
				+"}METHOD \n"
				+"VOID    \n"
				+"METHOD{ \n"
				+"TRY{    \n"
				+"TRY_RES \n"
				+"NEWCLASS\n"
				+"TRY_RES \n"
				+"NEWCLASS\n"
				+"APPLY   \n"
				+"CATCH{  \n"
				+"}CATCH  \n"
				+"}METHOD \n"
				+"VOID    \n"
				+"METHOD{ \n"
				+"TRY{    \n"
				+"APPLY   \n"
				+"CATCH{  \n"
				+"}CATCH  \n"
				+"}METHOD \n"
				+"VOID    \n"
				+"METHOD{ \n"
				+"TRY{    \n"
				+"APPLY   \n"
				+"CATCH{  \n"
				+"}CATCH  \n"
				+"CATCH{  \n"
				+"}CATCH  \n"
				+"}METHOD \n"
				+"}CLASS  \n"
				+"********\n";// @formatter:on

		String tokens = parseWithJ7Parser(file, false);
		assertEquals(expected, tokens);
	}

	@Test
	public void compArray() throws IOException {
		compareWithParser15(new File(srcTestResources, "ArrayTest.java"));
	}

	@Test
	public void compSimpleClass() throws IOException {
		compareWithParser15(new File(srcTestResources, "SimpleClass.java"));
	}

	@Test
	public void compEnum() {
		compareWithParser15(new File(srcTestResources, "EnumTest.java"));
	}

	@Test
	public void compGeneric() {
		compareWithParser15(new File(srcTestResources, "GenericPocket.java"));
	}

	@Test
	public void compInnerClass() {
		compareWithParser15(new File(srcTestResources, "InnerClass.java"));
	}

	@Test
	public void compAnonymousClass() {
		compareWithParser15(new File(srcTestResources, "AnonymousClass.java"));
	}

	@Test
	public void compAnnotations_Usage() {
		compareWithParser15(new File(srcTestResources, "AnnotationText.java"));
	}

	@Test
	public void compAnnotations_PackageUsage() {
		compareWithParser15(new File(srcTestResources, "package-info.java"));
	}

	@Test
	public void compAnnotations_Definition() {
		compareWithParser15(new File(srcTestResources, "OptimizeAnnotation.java"));
	}

	@Test
	public void j7Generics() throws IOException {
		File file = new File(srcTestResources, "J7Generics.java");
		String expected = ""// @formatter:off
				+ "CLASS{  \n"
				+ "VOID    \n"
				+ "METHOD{ \n"
				+ "GENERIC \n"
				+ "VARDEF  \n"
				+ "ASSIGN  \n"
				+ "GENERIC \n"
				+ "NEWCLASS\n"
				+ "}METHOD \n"
				+ "}CLASS  \n"
				+ "********\n"; // @formatter:on
		String tokens = parseWithJ7Parser(file, false);
		assertEquals(expected, tokens);
	}

	@Test
	public void assureBackwardsCompatibility2() throws IOException {
		compareWithParser15(new File(srcTestResources, "ExceptionTwo.java"));
	}

	@Test
	public void assureBackwardsCompatibility3() throws IOException {
		compareWithParser15(new File(srcTestResources, "ExceptionThree.java"));
	}

	@Test
	public void assureBackwardsCompatibility4() throws IOException {
		compareWithParser15(new File(srcTestResources, "Calendar.java"));
	}

	/**
	 * Compare results (token sequence) with Java 1.5 parser (without method
	 * separators ; if you know why they exist, PLEASE tell us or document at
	 * https://svn.ipd.kit.edu/trac/de/jplag/wiki/Server/Frontends/Java-1.5)
	 * 
	 * @param javaFile
	 * @throws IOException
	 */
	private void compareWithParser15(File javaFile) {
		if (!javaFile.exists()) {
			fail("Test not implemented - cannot find file >" + javaFile + "<");
		}
		String newTokens = parseWithJ7Parser(javaFile, true);
		String oldTokens = parseWithJ5Parser(javaFile);
		// compare token sequence?
		Assert.assertEquals(oldTokens, newTokens);
	}

	private String parseWithJ5Parser(File javaFile) {

		// parse with old parser
		de.jplag.java15.Parser oldParser = new de.jplag.java15.Parser(false);
		oldParser.setProgram(new StrippedProgram());
		de.jplag.TokenList oldStruct = oldParser.parse(javaFile.getParentFile(), new String[] { javaFile.getName() });

		String oldTokens = buildTokenString(oldStruct, true);
		return oldTokens;
	}

	/**
	 * assumes that the token types have not changed from java 1.5 to Java 1.7
	 * (meaning the integer values are the same but Java 1.7 has more than Java
	 * 1.5)
	 * 
	 * @see de.jplag.java17.JavaToken
	 * 
	 * @param oldStruct
	 * @param withDetails
	 * @return
	 */
	private String buildTokenString(de.jplag.TokenList oldStruct, boolean withDetails) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < oldStruct.size(); i++) {
			sb.append(de.jplag.java17.JavaToken.type2string(oldStruct.getToken(i).type));
			if (withDetails) {
				sb.append(" L:" + oldStruct.getToken(i).getLine()  
				+ " C:" + oldStruct.getToken(i).getLine()
				+ " l:" + oldStruct.getToken(i).getLine());
			}
			sb.append("\n");
		}

		String oldTokens = sb.toString();
		return oldTokens;
	}

	private String parseWithJ7Parser(File javaFile, boolean withDetails) {
		// parse with new parser
		de.jplag.java17.Parser newParser = new Parser();
		newParser.setProgram(new StrippedProgram());
		de.jplag.TokenList newStruct = newParser.parse(javaFile.getParentFile(), new String[] { javaFile.getName() });

		String newTokens = buildTokenString(newStruct, withDetails);
		return newTokens;
	}
}
