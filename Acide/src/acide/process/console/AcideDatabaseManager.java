/*
 * ACIDE - A Configurable IDE
 * Official web site: http://acide.sourceforge.net
 *
 * Copyright (C) 2007-2023
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
 * 			- Yuejie Xu
 * 			- Yihang Zhuo
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
package acide.process.console;

import java.util.LinkedList;
import java.util.Vector;

/**
 * ACIDE - A Configurable IDE database manager.
 * 
 * @version 0.11
 */
@SuppressWarnings("rawtypes") 
public abstract class AcideDatabaseManager {

	/**
	 * ACIDE - The instance of the Database manager
	 */
	static AcideDatabaseManager _instance;

	/**
	 * This method allows to change the manager from DES to ODBC or another implementations
	 *
	 * @param AcideDatabaseManager instance
	 */
	public static void setInstance(AcideDatabaseManager instance){
		_instance = instance;
	}

	/**
	 *  Returns the instance of the manager
	 * @return AcideDatabaseManager
	 */
	public static AcideDatabaseManager getInstance(){
		if (_instance==null){
			_instance = new DesDatabaseManager();
		}
		return _instance;
	}

	/**
	 * Returns all the databases connected to the panel
	 *
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getDatabases();

	/**
	 * Returns all the tables of the database
	 *
	 * @param String database
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getTables(String database);

	/**
	 * Returns all the columns of a table
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getFields(String database, String table);

	/**
	 * Returns all the views of the database
	 *
	 * @param String database
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getViews(String database);

	/**
	 * Returns all the functional dependencies of a table
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getFuncionDep(String database, String table);

	/**
	 * Returns all the integrity constraints of a table
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getIntConst(String database, String table);

	/**
	 * Returns the candidate key of a table
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getCandidateKey(String database, String table);

	/**
	 * Returns all the foreign keys of a table
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getForeignKey(String database, String table);

	/**
	 * Returns the primary key of a table
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getPrimKey(String database, String table);

	/**
	 * Returns the SQL command of a view
	 *
	 * @param String database
	 * @param String view
	 * @return String
	 */
	public abstract String getSQLText(String database, String view);

	/**
	 * Returns the RA command of a view
	 *
	 * @param String database
	 * @param String view
	 * @return String
	 */
	public abstract String getRAText(String database, String view);

	/**
	 * Returns the Datalog command of a view (NOT IMPLEMENTED)
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract String getDatalogText(String database, String view);

	/**
	 * Returns the rules of an intentional predicate
	 *
	 * @param String predicate
	 *
	 * @return String
	 */
	public abstract String getRules(String predicate);

	/**
	 * Returns all the rows of a table
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getSelectAll(String database, String table);

	/**
	 * Returns all the tuples of a predicate
	 *
	 * @param String predicate
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getAllTuples(String predicate);

	/**
	 * Returns the subset of tuples
	 *
	 * @param String predicate
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getSolutions(String predicate);

	/**
	 * Returns the model of a table
	 *
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getTableModel(String table);

	/**
	 * Executes a command in the database connected
	 *
	 * @param String command
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> executeCommand(String comandParam);

	/**
	 * Returns the integrity constraints of a database
	 *
	 * @param String database
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getIntConst(String database);

	/**
	 * Test the connection
	 *
	 * @return String
	 */
	public abstract String test();

	/**
	 * Opens a new connection
	 *
	 * @param String database
	 * @param String user
	 * @param String password
	 * @return String
	 */
	public abstract String createDatabase(String database, String user, String password);

	/**
	 * Makes a database the default connection
	 *
	 * @param String database
	 * @return LinkedList<String>
	 */
	public abstract String setAsDefault(String database);

	/**
	 * Close the connection with the given database
	 *
	 * @param String database
	 * @return LinkedList<String>
	 */
	public abstract String closeConnection(String database);

	/**
	 * Drop the gicen restriction
	 *
	 * @param String database
	 * @param String table
	 * @param String type_restriction
	 * @param String restriction
	 * @return LinkedList<String>
	 */
	public abstract String dropRestriction (String restriction);

	/**
	 * Returns if a relation exists
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract boolean existsRelation(String database, String table);

	/**
	 * Inserts values in a table
	 *
	 * @param String table
	 * @param Vector<String> dataColumns
	 * @return String
	 */
	public abstract String insertValues(String table,Vector<String> dataColumns);

	/**
	 * Insert tuple in a predicate
	 *
	 * @param String predicate
	 * @param Vector<String> arguments
	 * @return String
	 */
	public abstract String insertTuple(String predicate,Vector<String> arguments);

	/**
	 * Drop a view
	 *
	 * @param String database
	 * @param String view
	 * @return String
	 */
	public abstract String dropView(String database, String view);

	/**
	 * Drop a intensional predicate
	 *
	 * @param String predicate
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> dropIntensionalPredicate(String predicate);

	/**
	 * Renames a view
	 *
	 * @param String database
	 * @param String view
	 * @param String newName
	 * @return String
	 */
	public abstract String renameView(String database, String view, String newName);

	/**
	 * Paste a view
	 *
	 * @param String database
	 * @param String newview
	 * @param String oldview
	 * @return String
	 */
	public abstract String pasteView(String database, String newView, String oldView);

	/**
	 * Creates a new restriction
	 *
	 * @param String restriction
	 * @return String
	 */
	public abstract String createRestriction(String restriction);

	/**
	 * Drop a table
	 *
	 * @param String database
	 * @param String table
	 * @return String
	 */
	public abstract LinkedList<String> dropTable(String database, String table);

	/**
	 * Paste a table
	 *
	 * @param String database
	 * @param String result
	 * @param String option
	 * @return String
	 */
	public abstract String pasteTable(String s, String result, int option);

	/**
	 * Renames a table
	 *
	 * @param String database
	 * @param String table
	 * @param String newNAme
	 * @return String
	 */
	public abstract String renameTable(String database,String table, String selection);

	/**
	 * Returns the info of the restrictions
	 *
	 * @param String database
	 * @param String table
	 * @return Vector<Boolean>
	 */
	public abstract Vector<Boolean> infoRestrictions(String string, String substring);

	/**
	 * return the nullables fields of a table
	 *
	 * @param String database
	 * @param String table
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getNullables(String string, String substring);

	/**
	 * Return the columns of a view
	 *
	 * @param String database
	 * @param String view
	 * @return LinkedList<String>
	 */
	public abstract LinkedList<String> getViewFields(String string, String substring);

	/**
	 * Returns if a name is of a table
	 *
	 * @param String database
	 * @param String table
	 * @return boolean
	 */
	public abstract boolean isTable(String db, String tabla);

	/**
	 * Returns if a name is of a extensional predicate
	 *
	 * @param String database
	 * @param String predicate
	 * @return boolean
	 */
	public abstract boolean isExtensional(String db,String predicate);

	/**
	 * Delete a row of a table
	 *
	 * @param String database
	 * @param String table
	 * @param Vector<Vector<String>> dataColumns
	 * @param Vector<String> columnsNames
	 * @return String
	 */
	public abstract String deleteRow(String database, String table, Vector<Vector<String>> dataColumns,Vector<String> columnsNames);

	/**
	 * Updates a field of a table
	 * @param table
	 * @param database
	 * @param columnsNames
	 * @param infoRow
	 * @param newInfoRow
	 * @return
	 */
	public abstract String updateField(String table, String database,Vector<String> columnsNames, Vector infoRow, Vector newInfoRow);

	/**
	 * Returns if a table is empty
	 *
	 * @param String database
	 * @param String table
	 * @return boolean
	 */
	public abstract boolean isEmpty(String db, String table);

	/**
	 * Creates the primary key of a table
	 * @param db
	 * @param table
	 * @param pk
	 * @return
	 */
	public abstract boolean pk(String db, String table, LinkedList<String> pk);

	/**
	 * Creates the not nulls restrictions of a table
	 * @param db
	 * @param table
	 * @param nn
	 * @return
	 */
	public abstract boolean nn(String db, String table, LinkedList<String> nn);

	/**
	 * Types the table definition
	 * @param db
	 * @param table
	 * @param cols
	 * @return
	 */
	public abstract boolean type(String db, String table, LinkedList<String> cols);

	/**
	 * Returns the current connection
	 * @return
	 */
	public abstract String currentDB();

	/**
	 * Returns the type of a given view
	 * @return
	 */
	public abstract String getViewType(String database, String node);

	/**
	 * Returns to a state before or after debugging specified by
	 * the state number to which you want to return
	 *
	 * @param stateNumber
	 * @return
	 */
	public abstract LinkedList<String> restoreDebugState(int stateNumber);

	/**
	 * Save current state in debugging
	 *
	 * @param stateNumber
	 * @return
	 */
	public abstract LinkedList<String> saveDebugState(int stateNumber);

	public abstract LinkedList<String> orderColumns(String table, String command);

    public abstract LinkedList<String> startSQLDebug(String view, String debugConfiguration, String option);

    public abstract LinkedList<String> startDatalogDebug(String predicate, String debugConfiguration, String option);

	public abstract LinkedList<String> setViewNodeState(String nodeName, String state);

	public abstract LinkedList<String> setPredicateNodeState(String nodeName, String state);
	public abstract LinkedList<String> debugCurrentSQLQuestion();

	public abstract LinkedList<String> debugCurrentDatalogQuestion();

	public abstract LinkedList<String> debugCurrentSQLAnswer(String question, String answer);

	public abstract LinkedList<String> debugCurrentDatalogAnswer(String question, String answer);

	public abstract void stopDebug();

	public abstract LinkedList<String> getSQLNodeStates();

	public abstract LinkedList<String> getDatalogNodeStates();

	public abstract LinkedList<String> getSQLDebugStats();

	public abstract LinkedList<String> getDatalogDebugStats();

	public abstract boolean isSQLSessionDebugging();

	public abstract boolean isDatalogSessionDebugging();

}
