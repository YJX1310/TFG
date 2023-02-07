/*
 * ACIDE - A Configurable IDE
 * Official web site: http://acide.sourceforge.net
 *
 * Copyright (C) 2007-2013
 * Authors:
 * 		- Fernando S�enz P�rez (Team Director).
 *      - Version from 0.1 to 0.6:
 *      	- Diego Cardiel Freire.
 *			- Juan Jos� Ortiz S�nchez.
 *          - Delf�n Rup�rez Ca�as.
 *      - Version 0.7:
 *          - Miguel Mart�n L�zaro.
 *      - Version 0.8:
 *      	- Javier Salcedo G�mez.
 *      - Version from 0.9 to 0.11:
 *      	- Pablo Guti�rrez Garc�a-Pardo.
 *      	- Elena Tejeiro P�rez de �greda.
 *      	- Andr�s Vicente del Cura.
 *      - Version from 0.12 to 0.16
 *      	- Sem�ramis Guti�rrez Quintana
 *      	- Juan Jes�s Marqu�s Ortiz
 *      	- Fernando Ord�s Lorente
 *      - Version 0.17
 *      	- Sergio Dom�nguez Fuentes
 * 		- Version 0.18
 * 			- Sergio Garc�a Rodr�guez
 * 		- Version 0.19
 * 			- Carlos Gonz�lez Torres
 * 			- Cristina Lara L�pez
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

import java.io.File;

import javax.swing.JOptionPane;

import acide.files.AcideFileManager;
import acide.files.bytes.AcideByteFileManager;
import acide.gui.mainWindow.AcideMainWindow;
import acide.language.AcideLanguageManager;
import acide.log.AcideLog;
import acide.process.gui.AcideProgressWindow;
import acide.resources.AcideResourceManager;

/**
 * ACIDE - A Configurable IDE grammar file creation process.
 * 
 * @version 0.11
 * @see Thread
 */
public class AcideGrammarFileCreationProcess extends Thread {

	/**
	 * ACIDE - A Configurable IDE grammar file creation process grammar name.
	 */
	private String _grammarName;
	/**
	 * ACIDE - A Configurable IDE grammar file creation process verbose process.
	 */
	private boolean _verboseProcess;

	/**
	 * Creates a new ACIDE - A Configurable IDE grammar file creation process.
	 * 
	 * @param grammarName
	 *            grammar name.
	 * @param verboseProcess
	 *            verbose process flag.
	 */
	public AcideGrammarFileCreationProcess(String grammarName,
			boolean verboseProcess) {

		// Stores the grammar name
		_grammarName = grammarName;

		// Stores the verbose process flag
		_verboseProcess = verboseProcess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		// If the verbose flag is true then
		if (_verboseProcess) {

			// Sets the initial text in the progress window
			AcideProgressWindow.getInstance().setInitialText(
					AcideLanguageManager.getInstance().getLabels()
							.getString("s1063"));

			// Shows the progress window
			AcideProgressWindow.getInstance().showWindow();
		}
		// Executes the antlr to obtain the .java files from the grammar
		executeAntlr();

		// Modifies the generated GrammarParser.java
		//modifyGrammarParserFile();

		// Compiles the generated files to obtain the .class files
		//compileGeneratedFiles();
		
		// Reallocates the generated files in the correspondent folder
		reallocateGeneratedFiles();
		
		//
		addPackage();

		// Generates the .jar file
		//generateJarFile();

		// Deletes the generated files
		//deleteGeneratedFiles();

		// Reallocates the generated .jar file into the correspondent folder
		//reallocateJarFile();

		// If the verbose flag is true then
		if (_verboseProcess)
			// Enables the close button in the progress window
			AcideProgressWindow.getInstance().enableCloseButton();
		else {

			// Displays a success message
			JOptionPane.showMessageDialog(
					AcideMainWindow.getInstance(),
					AcideLanguageManager.getInstance().getLabels()
							.getString("s1065"), AcideLanguageManager
							.getInstance().getLabels().getString("s1066"),
					JOptionPane.INFORMATION_MESSAGE);

			// Enables the main window
			AcideMainWindow.getInstance().setEnabled(true);

			// Brings the main window to the front
			AcideMainWindow.getInstance().setAlwaysOnTop(true);

			// Only this time
			AcideMainWindow.getInstance().setAlwaysOnTop(false);
		}
	}

	/**
	 * Executes ANTLR for generating the required files to generate the .jar
	 * file.
	 */
	private void executeAntlr() {

		String javaPath = null;

		try {

			// Gets the java path from the ACIDE - A Configurable IDE resource
			// manager
			javaPath = AcideResourceManager.getInstance().getProperty(
					"javaPath");
			if (javaPath.equals("null"))
				throw new Exception(AcideLanguageManager.getInstance()
						.getLabels().getString("s927"));
		} catch (Exception exception) {

			// Displays an error message
			JOptionPane.showMessageDialog(
					null,
					AcideLanguageManager.getInstance().getLabels()
							.getString("s928"),
					AcideLanguageManager.getInstance().getLabels()
							.getString("s934"), JOptionPane.ERROR_MESSAGE);

			// Updates the log
			AcideLog.getLog().error(exception.getMessage());
			exception.printStackTrace();

			// Closes the progress window
			AcideProgressWindow.getInstance().closeWindow();

			return;
		}

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1049"));

		// Updates the progress window
		AcideProgressWindow
				.getInstance()
				.setText("\"" + javaPath + "\" -jar ./lib/antlr-4.7.1-complete.jar Expr.g4");

		// Executes antlr to generate the files which will be at the .jar
		Process process = null;

		try {

			// Executes the command
			process = Runtime.getRuntime().exec("\"" + javaPath + "\" -jar ./lib/antlr-4.7.1-complete.jar Expr.g4");


			// Waits for the process to finish
			process.waitFor();
		} catch (Exception exception) {

			// Updates the log
			AcideLog.getLog().error(exception.getMessage());
			exception.printStackTrace();

			// Closes the progress window
			AcideProgressWindow.getInstance().closeWindow();

			return;
		}

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1050"));
	}

	/**
	 * Adds the exceptions to the generated GrammarParser.java file.
	 */
	private void modifyGrammarParserFile() {

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1051"));

		File file = new File("GrammarParser.java");
		if (!file.exists()) {
			return;
		}

		// Gets the file content
		String fileContent = null;
		fileContent = AcideFileManager.getInstance().load("GrammarParser.java");
		String exception = "throw new RecognitionException();";

		// Inserts the first exception
		String aux = "";
		int index = fileContent.indexOf("recover(ex");
		index++;
		aux = fileContent.substring(index);
		int indexAux = aux.indexOf(";");
		index += indexAux + 1;
		String head = fileContent.substring(0, index);
		String tail = fileContent.substring(index);
		fileContent = head + exception + tail;

		// Inserts the following exceptions
		boolean finished = false;
		while (!finished) {
			index = fileContent.lastIndexOf(exception);
			aux = fileContent.substring(index);
			indexAux = aux.indexOf("recover(ex");
			if (indexAux == -1)
				finished = true;
			else {
				String aux2 = aux.substring(indexAux);
				int indexAux2 = aux2.indexOf(";");
				index = index + indexAux + indexAux2 + 1;
				head = fileContent.substring(0, index);
				tail = fileContent.substring(index);
				fileContent = head + exception + tail;
			}
		}

		// Updates the grammar parser file with the new content
		AcideFileManager.getInstance().write("GrammarParser.java", fileContent);

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1052"));
	}

	/**
	 * Compiles the generated files by ANTLR to obtain the .class files.
	 */
	private void compileGeneratedFiles() {

		String javacPath = null;

		try {

			// Gets the javac path from the ACIDE - A Configurable IDE resource
			// manager
			javacPath = AcideResourceManager.getInstance().getProperty(
					"javacPath");
			if (javacPath.equals("null"))
				throw new Exception(AcideLanguageManager.getInstance()
						.getLabels().getString("s929"));
		} catch (Exception exception) {

			// Displays an error message
			JOptionPane.showMessageDialog(
					null,
					AcideLanguageManager.getInstance().getLabels()
							.getString("s929"),
					AcideLanguageManager.getInstance().getLabels()
							.getString("s933"), JOptionPane.ERROR_MESSAGE);

			// Updates the log
			AcideLog.getLog().error(exception.getMessage());
			exception.printStackTrace();

			// Closes the progress window
			AcideProgressWindow.getInstance().closeWindow();

			return;
		}

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1053"));

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				"\"" + javacPath + "\" -cp .;c:\\classes .\\*.java -d .");

		Process process = null;
		try {

			// Executes the command
			process = Runtime.getRuntime().exec(
					"\"" + javacPath + "\" -cp .;c:\\classes .\\*.java -d .");

			// Waits for the process to finish
			process.waitFor();
		} catch (Exception exception) {

			// Updates the log
			AcideLog.getLog().error(exception.getMessage());
			exception.printStackTrace();

			// Closes the progress window
			AcideProgressWindow.getInstance().closeWindow();

			return;
		}

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1054"));
	}

	
	private void addPackage() {
		// Add package to the ExprBaseListener.java file
		AcideByteFileManager.getInstance().addPackage("src/acide/process/parser/grammar/ExprBaseListener.java");

		// Add package to the ExprBaseVisitor.java file
		AcideByteFileManager.getInstance().addPackage("src/acide/process/parser/grammar/ExprLexer.java");
		
		// Add package to the ExprBaseVisitor.java file
		AcideByteFileManager.getInstance().addPackage("src/acide/process/parser/grammar/ExprListener.java");
		
		// Add package to the ExprBaseVisitor.java file
		AcideByteFileManager.getInstance().addPackage("src/acide/process/parser/grammar/ExprParser.java");
	}
	
	/**
	 * Reallocates the generated files into the correspondent folder in the
	 * source folder of ACIDE - A Configurable IDE.
	 */
	private void reallocateGeneratedFiles() {

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1055"));

		// Reallocates the Expr.g4 file
		AcideByteFileManager.getInstance().reallocateFile("Expr.g4",
				"src/acide/process/parser/grammar/Expr.g4");
		
		// Reallocates the Expr.interp file
		AcideByteFileManager.getInstance().reallocateFile("Expr.interp",
				"src/acide/process/parser/grammar/Expr.interp");
		
		// Reallocates the Expr.tokens file
		AcideByteFileManager.getInstance().reallocateFile("Expr.tokens",
				"src/acide/process/parser/grammar/Expr.tokens");

		// Reallocates the ExprBaseListener.java file
		AcideByteFileManager.getInstance().reallocateFile("ExprBaseListener.java",
				"src/acide/process/parser/grammar/ExprBaseListener.java");

		// Reallocates the ExprLexer.interp file
		AcideByteFileManager.getInstance().reallocateFile("ExprLexer.interp",
				"src/acide/process/parser/grammar/ExprLexer.interp");
		
		// Reallocates the ExprLexer.java file
		AcideByteFileManager.getInstance().reallocateFile("ExprLexer.java",
				"src/acide/process/parser/grammar/ExprLexer.java");
		
		// Reallocates the ExprLexer.tokens file
		AcideByteFileManager.getInstance().reallocateFile("ExprLexer.tokens",
				"src/acide/process/parser/grammar/ExprLexer.tokens");
		
		// Reallocates the ExprListener.java file
		AcideByteFileManager.getInstance().reallocateFile("ExprListener.java",
				"src/acide/process/parser/grammar/ExprListener.java");

		// Reallocates the ExprParser.java file
		AcideByteFileManager.getInstance().reallocateFile("ExprParser.java",
				"src/acide/process/parser/grammar/ExprParser.java");

		// Reallocates the syntaxRules.txt file
		AcideByteFileManager.getInstance().reallocateFile("syntaxRules.txt",
				"src/acide/process/parser/grammar/syntaxRules.txt");

		// Reallocates the lexicalCategories.txt file
		AcideByteFileManager.getInstance().reallocateFile(
				"lexicalCategories.txt",
				"src/acide/process/parser/grammar/lexicalCategories.txt");

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1056"));
	}

	/**
	 * Generates the .jar file which contains the grammar configuration.
	 */
	private void generateJarFile() {

		String jarPath = null;
		try {

			// Gets the jar path from the ACIDE - A Configurable IDE resource
			// manager
			jarPath = AcideResourceManager.getInstance().getProperty("jarPath");

			if (jarPath.equals("null"))
				throw new Exception(AcideLanguageManager.getInstance()
						.getLabels().getString("s930"));
		} catch (Exception exception) {

			// Displays an error message
			JOptionPane.showMessageDialog(
					null,
					AcideLanguageManager.getInstance().getLabels()
							.getString("s930"),
					AcideLanguageManager.getInstance().getLabels()
							.getString("s932"), JOptionPane.ERROR_MESSAGE);

			// Updates the log
			AcideLog.getLog().error(exception.getMessage());
			exception.printStackTrace();
		}

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1057"));

		Process process = null;
		try {

			// Executes the command
			process = Runtime.getRuntime().exec(
					"\"" + jarPath + "\" cfm " + _grammarName + ".jar "
							+ "acide/process/parser/grammar/manifest.txt "
							+ "acide/process/parser/grammar");

			// Waits for the process to finish
			process.waitFor();
		} catch (Exception exception) {

			// Updates the log
			AcideLog.getLog().error(exception.getMessage());
			exception.printStackTrace();

			// Closes the progress window
			AcideProgressWindow.getInstance().closeWindow();

			return;
		}

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1058"));
	}

	/**
	 * Deletes the generated files by ANTLR once the .jar file is generated and
	 * they have been reallocated in the correspondent folder.
	 */
	private void deleteGeneratedFiles() {

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1059"));

		// Deletes the Expr.g4 file
		File file = new File("Expr.g4");
		file.delete();

		// Deletes the Expr.interp file
		file = new File("Expr.interp");
		file.delete();

		// Deletes the Expr.tokens file
		file = new File("Expr.tokens");
		file.delete();

		// Deletes the ExprBaseListener.java file
		file = new File("ExprBaseListener.java");
		file.delete();

		// Deletes the ExprLexer.interp file
		file = new File("ExprLexer.interp");
		file.delete();

		// Deletes the ExprLexer.java file
		file = new File("ExprLexer.java");
		file.delete();

		// Deletes the ExprLexer.tokens file
		file = new File("ExprLexer.tokens");
		file.delete();

		// Deletes the ExprListener.java file
		file = new File("ExprListener.java");
		file.delete();

		// Deletes the ExprParser.java file
		file = new File("ExprParser.java");
		file.delete();
		
		// Deletes the syntaxRules.txt
		file = new File("syntaxRules.txt");
		file.delete();

		// Deletes the lexicalCategories.txt
		file = new File("lexicalCategories.txt");
		file.delete();

		// Deletes the acide folder
		file = new File("acide");
		deleteSubdirectories(file);
		file.delete();

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1060"));
	}

	/**
	 * Reallocates the generated .jar file in the the grammar configuration
	 * folder.
	 */
	private void reallocateJarFile() {

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1061"));

		// Reallocates the .jar file
		AcideByteFileManager.getInstance().reallocateFile(
				_grammarName + ".jar",
				"./configuration/grammars/" + _grammarName + ".jar");

		// Updates the progress window
		AcideProgressWindow.getInstance().setText(
				AcideLanguageManager.getInstance().getLabels()
						.getString("s1062"));
	}

	/**
	 * Deletes the sub directories of a directory given as a parameter.
	 * 
	 * The method file.delete() only works for empty directories. This method
	 * deletes all the files in each sub directory from the original directory
	 * using recursion.
	 * 
	 * @param directory
	 *            directory to delete.
	 */
	private void deleteSubdirectories(File directory) {

		// Gets the files for the directory
		File[] files = directory.listFiles();

		for (int index = 0; index < files.length; index++) {

			// Recursion for the directories
			if (files[index].isDirectory()) {
				deleteSubdirectories(files[index]);
			}

			// Delete the file
			files[index].delete();
		}
	}
}
