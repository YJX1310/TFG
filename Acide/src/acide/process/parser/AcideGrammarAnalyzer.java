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

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;

import acide.language.AcideLanguageManager;
import acide.log.AcideLog;
import acide.process.parser.grammar.ExprLexer;
import acide.process.parser.grammar.ExprParser;

/**
 * ACIDE - A Configurable IDE grammar analyzer.
 */
public class AcideGrammarAnalyzer {
	/**
	 * ACIDE - A Configurable IDE grammar analyzer text to analyze.
	 */
	private String _text;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer lexer.
	 */
	private ExprLexer _lexer;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer token.
	 */
	private CommonTokenStream _token;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer parser.
	 */
	private ExprParser _parser;
	/**
	 * ACIDE - A Configurable IDE grammar analyzer errors.
	 */
	private HashMap<String, String> _errors;
	/**
	 * Creates a new ACIDE - A Configurable IDE grammar analyzer.
	 */
	public AcideGrammarAnalyzer(String text) {
		constructor(text);
	}
	
	private void constructor(String text) {
		// Store the text
		_text = text;
		
		// Initialize the error
		_errors = new HashMap<String, String>();
		
		// Create the lexer
		_lexer = new ExprLexer(CharStreams.fromString(_text));
		
		//	Create the token
		_token = new CommonTokenStream(_lexer); 
		
		// Create the parser
		_parser = new ExprParser(_token);

		// Set the error listener for the lexer
		_lexer.removeErrorListeners();
		_lexer.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
					int charPositionInLine, String msg, RecognitionException e) {
				_errors.put(line + ":" + charPositionInLine, msg);
			}
		});
		// Set the error listener for the parser
		_parser.removeErrorListeners();
		_parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
					int charPositionInLine, String msg, RecognitionException e) {
				_errors.put(line + ":" + charPositionInLine, msg);
			}
		});
	}

	/**
	 * Analyze the entire text according to the grammar rules
	 */
	public void analyzeText() {
		try {
			ParseTree tree = (ParseTree)_parser.getClass().getMethod(_parser.getRuleNames()[0]).invoke(_parser);
			_token.seek(0);
			System.out.println("Parse Tree: "
					  + tree.toStringTree(_parser));
			// Updates the log
			AcideLog.getLog().info(
					AcideLanguageManager.getInstance().getLabels()
							.getString("s2433"));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e1) {
			// Updates the log
			AcideLog.getLog().error(
					AcideLanguageManager.getInstance().getLabels()
							.getString("Analyze text error: " + e1.getMessage()));
			e1.printStackTrace();
		}
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
