import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
        String input = "10+(1)+20*30";
        ExprLexer lexer = new ExprLexer(CharStreams.fromString(input));
        ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expr();
        
        System.out.println("Expression: " + input);
        System.out.println("Parse Tree: " + tree.toStringTree(parser));
        */
		
		try {
			ExprLexer lexer = new ExprLexer(new ANTLRFileStream("src\\prueba.txt"));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ExprParser parser = new ExprParser(tokens);
			
	        ParseTree tree = parser.expr();
	        
	        System.out.println("Parse Tree: " + tree.toStringTree(parser));
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		/*try {
			Runtime.getRuntime().exec("java -jar antlr-4.11.1-complete.jar -visitor grammar.g4");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
