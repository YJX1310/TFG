// Generated from Expr.g4 by ANTLR 4.7.1
package acide.process.parser.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(ExprParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(ExprParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ExprParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ExprParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#starStatement}.
	 * @param ctx the parse tree
	 */
	void enterStarStatement(ExprParser.StarStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#starStatement}.
	 * @param ctx the parse tree
	 */
	void exitStarStatement(ExprParser.StarStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#orbitsStatement}.
	 * @param ctx the parse tree
	 */
	void enterOrbitsStatement(ExprParser.OrbitsStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#orbitsStatement}.
	 * @param ctx the parse tree
	 */
	void exitOrbitsStatement(ExprParser.OrbitsStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#satelliteStatement}.
	 * @param ctx the parse tree
	 */
	void enterSatelliteStatement(ExprParser.SatelliteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#satelliteStatement}.
	 * @param ctx the parse tree
	 */
	void exitSatelliteStatement(ExprParser.SatelliteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#planetStatement}.
	 * @param ctx the parse tree
	 */
	void enterPlanetStatement(ExprParser.PlanetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#planetStatement}.
	 * @param ctx the parse tree
	 */
	void exitPlanetStatement(ExprParser.PlanetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#intermediateStatement}.
	 * @param ctx the parse tree
	 */
	void enterIntermediateStatement(ExprParser.IntermediateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#intermediateStatement}.
	 * @param ctx the parse tree
	 */
	void exitIntermediateStatement(ExprParser.IntermediateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#orbitsPredicate}.
	 * @param ctx the parse tree
	 */
	void enterOrbitsPredicate(ExprParser.OrbitsPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#orbitsPredicate}.
	 * @param ctx the parse tree
	 */
	void exitOrbitsPredicate(ExprParser.OrbitsPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#notIntermediatePredicate}.
	 * @param ctx the parse tree
	 */
	void enterNotIntermediatePredicate(ExprParser.NotIntermediatePredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#notIntermediatePredicate}.
	 * @param ctx the parse tree
	 */
	void exitNotIntermediatePredicate(ExprParser.NotIntermediatePredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#notStarPredicate}.
	 * @param ctx the parse tree
	 */
	void enterNotStarPredicate(ExprParser.NotStarPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#notStarPredicate}.
	 * @param ctx the parse tree
	 */
	void exitNotStarPredicate(ExprParser.NotStarPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#starPredicate}.
	 * @param ctx the parse tree
	 */
	void enterStarPredicate(ExprParser.StarPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#starPredicate}.
	 * @param ctx the parse tree
	 */
	void exitStarPredicate(ExprParser.StarPredicateContext ctx);
}
