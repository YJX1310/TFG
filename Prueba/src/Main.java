import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Linea 1;Linea 2\nLinea 3";
		int index = text.indexOf(";");
		String firstLine = "Nueva línea 1;\n";
		String modifiedText = firstLine + text.substring(index + 1);
		
		System.out.println(modifiedText);
		/*
		String newLine = "grammar Expr";

		try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\34642\\eclipse\\TFG\\Github\\Prueba\\src\\Expr.g4"))) {
			StringBuilder sb = new StringBuilder();
			int i = 0;

			String line = reader.readLine();
			while (line != null) {
				if (i == 0)
					line = newLine;
				sb.append(line).append(System.lineSeparator());
				line = reader.readLine();
				i++;
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\\\Users\\\\34642\\\\eclipse\\\\TFG\\\\Github\\\\Prueba\\\\src\\\\Expr.g4"))) {
				writer.write(sb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		/*
		String input = "(2*1)";
		ExprLexer lexer = new ExprLexer(CharStreams.fromString(input));
		MiErrorListener errorListener = new MiErrorListener();
		ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
		lexer.removeErrorListeners();
		lexer.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
					int charPositionInLine, String msg, RecognitionException e) {
				System.err.println("Error de sintaxis en la línea " + line + ":" + charPositionInLine + " - " + msg);
			}
		});
		parser.removeErrorListeners();
		parser.addErrorListener(errorListener);
		ParseTree tree = parser.expr();

		System.out.println("Expression: " + input);
		System.out.println("Parse Tree: " + tree.toStringTree(parser));
		*/
		/*
		 * String input = "10+(1)+20*30"; ExprLexer lexer = new
		 * ExprLexer(CharStreams.fromString(input)); ExprParser parser = new
		 * ExprParser(new CommonTokenStream(lexer)); ParseTree tree = parser.expr();
		 * 
		 * System.out.println("Expression: " + input); System.out.println("Parse Tree: "
		 * + tree.toStringTree(parser));
		 */

		/*
		 * String fileName =
		 * "C:\\Users\\34642\\eclipse\\TFG\\Github\\Prueba\\src\\prueba.txt"; String
		 * newLine = "package acide.process.parser.grammar;";
		 * 
		 * try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
		 * StringBuilder sb = new StringBuilder(); int i = 0;
		 * 
		 * String line = reader.readLine(); while (line != null) {
		 * sb.append(line).append(System.lineSeparator()); if(i == 0)
		 * sb.append(newLine).append(System.lineSeparator());; line = reader.readLine();
		 * i++; }
		 * 
		 * try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
		 * writer.write(sb.toString()); } } catch (IOException e) { e.printStackTrace();
		 * }
		 */
		/*
		 * try { System.out.print("\""); RandomAccessFile file = new RandomAccessFile(
		 * "C:\\Users\\34642\\eclipse\\TFG\\Github\\Prueba\\src\\prueba.txt", "rw");
		 * file.seek(40); // mueve el cursor a la posición 10
		 * file.writeChars("package acide.process.parser.grammar;"); file.close(); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */
		/*
		 * try { ExprLexer lexer = new ExprLexer(new
		 * ANTLRFileStream("src\\prueba.txt")); CommonTokenStream tokens = new
		 * CommonTokenStream(lexer); ExprParser parser = new ExprParser(tokens);
		 * 
		 * ParseTree tree = parser.expr();
		 * 
		 * System.out.println("Parse Tree: " + tree.toStringTree(parser));
		 * 
		 * } catch (IOException e1) { // TODO Auto-generated catch block
		 * System.out.println(e1.getMessage()); }
		 */
		/*
		 * try { Runtime.getRuntime().
		 * exec("java -jar antlr-4.7.1-complete.jar -visitor Expr.g4"); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

}
