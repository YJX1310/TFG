/*
 * ACIDE - A Configurable IDE
 * Official web site: http://acide.sourceforge.net
 *
 * Copyright (C) 2007-2013
 * Authors:
 * 		- Fernando Sáenz Pérez (Team Director).
 *      - Version from 0.1 to 0.6:
 *      	- Diego Cardiel Freire.
 *			- Juan José Ortiz Sánchez.
 *          - Delfín Rupérez Cañas.
 *      - Version 0.7:
 *          - Miguel Martín Lázaro.
 *      - Version 0.8:
 *      	- Javier Salcedo Gómez.
 *      - Version from 0.9 to 0.11:
 *      	- Pablo Gutiérrez García-Pardo.
 *      	- Elena Tejeiro Pérez de Ágreda.
 *      	- Andrés Vicente del Cura.
 *      - Version from 0.12 to 0.16
 *      	- Semíramis Gutiérrez Quintana
 *      	- Juan Jesús Marqués Ortiz
 *      	- Fernando Ordás Lorente
 *      - Version 0.17
 *      	- Sergio Domínguez Fuentes
 * 		- Version 0.18
 * 			- Sergio García Rodríguez
 * 		- Version 0.19
 * 			- Carlos González Torres
 * 			- Cristina Lara López
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package acide.process.parser;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;

import acide.gui.mainWindow.AcideMainWindow;
import acide.main.AcideMain;
import acide.process.parser.grammar.ExprLexer;
import acide.process.parser.grammar.ExprParser;

/**
 * ACIDE - A Configurable IDE grammar analyzer.
 * @version 0.20
 * @see Thread
 */
public class AcideGrammarAnalyzer extends Thread{
	/**
	 * ACIDE - A Configurable IDE grammar analyzer text to analyze.
	 */
	private String _text;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer lexer.
	 */
	private ExprLexer _lexer;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer lexer object.
	 */
	private Object _Olexer;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer lexer class.
	 */
	private Class<?> _Clexer;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer token.
	 */
	private CommonTokenStream _token;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer parser.
	 */
	private ExprParser _parser;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer parser object.
	 */
	private Object _Oparser;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer parser class.
	 */
	private Class<?> _Cparser;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer errors.
	 */
	private HashMap<String, String> _errors;
	/**
	 * Creates a new ACIDE - A Configurable IDE grammar analyzer.
	 */
	private Object _lock;
	
	public AcideGrammarAnalyzer() {
		
	}
	
	static class TestClassLoader extends ClassLoader {

		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
		
			if (name.equals("acide.process.parser.grammar.ExprLexer")) {
				try {
					InputStream is = AcideMain.class.getClassLoader().getResourceAsStream("acide/process/parser/grammar/ExprLexer.class");
					byte[] buf = new byte[1000000];
					int len = is.read(buf);
					return defineClass(name, buf, 0, len);
				} catch (IOException e) {
					throw new ClassNotFoundException("", e);
				}
			}
			else if(name.equals("acide.process.parser.grammar.ExprParser")) {
				try {
					InputStream is = AcideMain.class.getClassLoader().getResourceAsStream("acide/process/parser/grammar/ExprParser.class");
					byte[] buf = new byte[1000000];
					int len = is.read(buf);
					return defineClass(name, buf, 0, len);
				} catch (IOException e) {
					throw new ClassNotFoundException("", e);
				}
			}
			return getParent().loadClass(name);
		
		}

	}
	
	/**
	 * Prepare the lexer and the parser of antlr4
	 * @param text
	 *            the text to analyze
	 */
	private void constructor(String text) {
		// Store the text
		_text = text;
		
		// Initialize the error
		_errors = new HashMap<String, String>();
		
		/*
		try {
			// Crear una instancia de URLClassLoader para cargar clases desde un directorio específico
			@SuppressWarnings("resource")
			URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("out/production/Acide/acide/process/parser/grammar/ExprLexer.class").toURI().toURL()});
			
			// Cargar la clase dinámicamente utilizando el class loader
			@SuppressWarnings("unchecked")
			//Class<ExprLexer> dynamicClass = (Class<ExprLexer>) classLoader.loadClass("acide.process.parser.grammar.ExprLexer");
			Class<ExprLexer> dynamicClass = (Class<ExprLexer>) Class.forName("acide.process.parser.grammar.ExprLexer");
			// Obtener una instancia del constructor que recibe dos parámetros de tipo int y String
			Constructor<ExprLexer> constructor = dynamicClass.getConstructor(CharStream.class);
			
			// Crear una nueva instancia de la clase cargada dinámicamente utilizando el constructor con parámetros
			_lexer = constructor.newInstance(CharStreams.fromString(_text));
			_lexer.getAllTokens();
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		try {
			myErrorListener errorListener = new myErrorListener(_errors);
			
			// Create lexer class
			_Clexer = new TestClassLoader().loadClass("acide.process.parser.grammar.ExprLexer");
			
			// Create lexer constructor
			Constructor<ExprLexer> constructor = (Constructor<ExprLexer>) _Clexer.getConstructor(CharStream.class);
			
			// Create lexer object
			_Olexer = constructor.newInstance(CharStreams.fromString(_text));
			
			// Invoke lexer class removeErrorListeners()
			_Clexer.getMethod("removeErrorListeners").invoke(_Olexer);
			
			// Invoke lexer class addErrorListener(ANTLRErrorListener obj)
			_Clexer.getMethod("addErrorListener", ANTLRErrorListener.class).invoke(_Olexer, errorListener);

			// Create the token
			_token = new CommonTokenStream((TokenSource) _Olexer); 
			
			// Create parser class
			_Cparser = new TestClassLoader().loadClass("acide.process.parser.grammar.ExprParser");
			
			// Create parser constructor
			Constructor<ExprParser> constructor1 = (Constructor<ExprParser>) _Cparser.getConstructor(TokenStream.class);
			
			// Create parser object
			_Oparser = constructor1.newInstance(_token);

			// Invoke parser class removeErrorListeners()
			_Cparser.getMethod("removeErrorListeners").invoke(_Oparser);
			
			// Invoke parser class addErrorListener(ANTLRErrorListener obj)
			_Cparser.getMethod("addErrorListener", ANTLRErrorListener.class).invoke(_Oparser, errorListener);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
		try {
			// Crear una instancia de URLClassLoader para cargar clases desde un directorio específico
			@SuppressWarnings("resource")
			URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("out/production/Acide/acide/process/parser/grammar/ExprParser.class").toURI().toURL()});
			
			// Cargar la clase dinámicamente utilizando el class loader
			@SuppressWarnings("unchecked")
			//Class<ExprParser> dynamicClass = (Class<ExprParser>) classLoader.loadClass("acide.process.parser.grammar.ExprParser");
			Class<ExprParser> dynamicClass = (Class<ExprParser>) Class.forName("acide.process.parser.grammar.ExprParser");

			// Obtener una instancia del constructor que recibe dos parámetros de tipo int y String
			Constructor<ExprParser> constructor = dynamicClass.getConstructor(TokenStream.class);
			
			// Crear una nueva instancia de la clase cargada dinámicamente utilizando el constructor con parámetros
			_parser = constructor.newInstance(_token);
			_parser.getRuleNames();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		// Create the parser
		//_parser = new ExprParser(_token);

		// Set the error listener for the lexer
		/*
		_lexer.removeErrorListeners();
		_lexer.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
					int charPositionInLine, String msg, RecognitionException e) {
				_errors.put(line + ":" + charPositionInLine, msg);
			}
		});
		myErrorListener a = new myErrorListener();
		_lexer.addErrorListener(a);
		// Set the error listener for the parser
		_parser.removeErrorListeners();
		_parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
					int charPositionInLine, String msg, RecognitionException e) {
				_errors.put(line + ":" + charPositionInLine, msg);
			}
		});*/
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
    @Override
    public void run() {
    synchronized (_lock) {
        try {
          _lock.wait();
          constructor(AcideMainWindow.getInstance()
					.getFileEditorManager().getSelectedFileEditorPanel().getActiveTextEditionArea().getText());
          analyzeText();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
	
	/**
	 * Analyze the entire text according to the grammar rules
	 */
	public void analyzeText() {
		try {
			Method geRulesNames = _Cparser.getMethod("getRuleNames");
			Object[] rulesName = (Object[]) geRulesNames.invoke(_Oparser);
			for(Object a: rulesName)
				System.out.println(a.toString());
			_Cparser.getMethod(rulesName[0].toString()).invoke(_Oparser);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//_Cparser.getMethod(name, parameterTypes)
		/*
		try {
			for(int i = 0; i < _parser.getRuleNames().length; i++)
				System.out.println(_parser.getRuleNames()[i]);
			ParseTree tree = (ParseTree)_parser.getClass().getMethod(_parser.getRuleNames()[0]).invoke(_parser);
			_token.seek(0);
			System.out.println("Parse Tree: "
					  + tree.toStringTree(_parser));
			// Updates the log
			AcideLog.getLog().info(
					AcideLanguageManager.getInstance().getLabels()
							.getString("s2433"));
			
			// Print the errors
			for(HashMap.Entry<String, String> entry : _errors.entrySet()) {
			    String key = entry.getKey();
			    String value = entry.getValue();
			    System.out.println(key + ": " +value);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e1) {
			// Updates the log
			AcideLog.getLog().error(
					AcideLanguageManager.getInstance().getLabels()
							.getString("Analyze text error: " + e1.getMessage()));
			e1.printStackTrace();
		}*/
	}
	
	public void setLock(Object lock) {
		_lock = lock;
	}
	
	/**
	 * Returns the ACIDE - A Configurable IDE grammar analyzer grammar mistakes.
	 * 
	 * @return the ACIDE - A Configurable IDE grammar analyzer grammar mistakes.
	 */
	public HashMap<String, String> getErrors(){
		return _errors;
	}
	
	public void setErrors(HashMap<String, String> _errors) {
		this._errors = _errors;
	}

	/**
	 * Returns the ACIDE - A Configurable IDE grammar analyzer grammar text.
	 * 
	 * @return the ACIDE - A Configurable IDE grammar analyzer grammar text.
	 */
	public String getText() {
		return _text;
	}

	public void setText(String _text) {
		constructor(_text);
	}

	/**
	 * Returns the ACIDE - A Configurable IDE grammar analyzer grammar lexer.
	 * 
	 * @return the ACIDE - A Configurable IDE grammar analyzer grammar lexer.
	 */
	public ExprLexer getLexer() {
		return _lexer;
	}

	public void setLexer(ExprLexer _lexer) {
		this._lexer = _lexer;
	}

	/**
	 * Returns the ACIDE - A Configurable IDE grammar analyzer grammar parser.
	 * 
	 * @return the ACIDE - A Configurable IDE grammar analyzer grammar parser.
	 */
	public ExprParser getParser() {
		return _parser;
	}

	public void setParser(ExprParser _parser) {
		this._parser = _parser;
	}
	
	
}
