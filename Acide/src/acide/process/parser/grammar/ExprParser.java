// Generated from Expr.g4 by ANTLR 4.7.1
package acide.process.parser.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ID=12, WS=13, COMMENT=14;
	public static final int
		RULE_parse = 0, RULE_statement = 1, RULE_starStatement = 2, RULE_orbitsStatement = 3, 
		RULE_satelliteStatement = 4, RULE_planetStatement = 5, RULE_intermediateStatement = 6, 
		RULE_orbitsPredicate = 7, RULE_notIntermediatePredicate = 8, RULE_notStarPredicate = 9, 
		RULE_starPredicate = 10;
	public static final String[] ruleNames = {
		"parse", "statement", "starStatement", "orbitsStatement", "satelliteStatement", 
		"planetStatement", "intermediateStatement", "orbitsPredicate", "notIntermediatePredicate", 
		"notStarPredicate", "starPredicate"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'star'", "'('", "')'", "'.'", "'orbits'", "','", "':-'", "'satellite'", 
		"'planet'", "'intermediate'", "'not'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ID", "WS", "COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				statement();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StarStatementContext starStatement() {
			return getRuleContext(StarStatementContext.class,0);
		}
		public OrbitsStatementContext orbitsStatement() {
			return getRuleContext(OrbitsStatementContext.class,0);
		}
		public SatelliteStatementContext satelliteStatement() {
			return getRuleContext(SatelliteStatementContext.class,0);
		}
		public PlanetStatementContext planetStatement() {
			return getRuleContext(PlanetStatementContext.class,0);
		}
		public IntermediateStatementContext intermediateStatement() {
			return getRuleContext(IntermediateStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				starStatement();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				orbitsStatement();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				satelliteStatement();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(30);
				planetStatement();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(31);
				intermediateStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StarStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public StarStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterStarStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitStarStatement(this);
		}
	}

	public final StarStatementContext starStatement() throws RecognitionException {
		StarStatementContext _localctx = new StarStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_starStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__0);
			setState(35);
			match(T__1);
			setState(36);
			match(ID);
			setState(37);
			match(T__2);
			setState(38);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrbitsStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public OrbitsPredicateContext orbitsPredicate() {
			return getRuleContext(OrbitsPredicateContext.class,0);
		}
		public OrbitsStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orbitsStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterOrbitsStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitOrbitsStatement(this);
		}
	}

	public final OrbitsStatementContext orbitsStatement() throws RecognitionException {
		OrbitsStatementContext _localctx = new OrbitsStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_orbitsStatement);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(T__4);
				setState(41);
				match(T__1);
				setState(42);
				match(ID);
				setState(43);
				match(T__5);
				setState(44);
				match(ID);
				setState(45);
				match(T__2);
				setState(46);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(T__4);
				setState(48);
				match(T__1);
				setState(49);
				match(ID);
				setState(50);
				match(T__5);
				setState(51);
				match(ID);
				setState(52);
				match(T__2);
				setState(53);
				match(T__6);
				setState(54);
				orbitsPredicate();
				setState(55);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SatelliteStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public OrbitsPredicateContext orbitsPredicate() {
			return getRuleContext(OrbitsPredicateContext.class,0);
		}
		public NotIntermediatePredicateContext notIntermediatePredicate() {
			return getRuleContext(NotIntermediatePredicateContext.class,0);
		}
		public NotStarPredicateContext notStarPredicate() {
			return getRuleContext(NotStarPredicateContext.class,0);
		}
		public SatelliteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_satelliteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSatelliteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSatelliteStatement(this);
		}
	}

	public final SatelliteStatementContext satelliteStatement() throws RecognitionException {
		SatelliteStatementContext _localctx = new SatelliteStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_satelliteStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__7);
			setState(60);
			match(T__1);
			setState(61);
			match(ID);
			setState(62);
			match(T__5);
			setState(63);
			match(ID);
			setState(64);
			match(T__2);
			setState(65);
			match(T__6);
			setState(66);
			orbitsPredicate();
			setState(67);
			match(T__5);
			setState(68);
			notIntermediatePredicate();
			setState(69);
			match(T__5);
			setState(70);
			notStarPredicate();
			setState(71);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlanetStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public OrbitsPredicateContext orbitsPredicate() {
			return getRuleContext(OrbitsPredicateContext.class,0);
		}
		public StarPredicateContext starPredicate() {
			return getRuleContext(StarPredicateContext.class,0);
		}
		public NotIntermediatePredicateContext notIntermediatePredicate() {
			return getRuleContext(NotIntermediatePredicateContext.class,0);
		}
		public PlanetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_planetStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPlanetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPlanetStatement(this);
		}
	}

	public final PlanetStatementContext planetStatement() throws RecognitionException {
		PlanetStatementContext _localctx = new PlanetStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_planetStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__8);
			setState(74);
			match(T__1);
			setState(75);
			match(ID);
			setState(76);
			match(T__2);
			setState(77);
			match(T__6);
			setState(78);
			orbitsPredicate();
			setState(79);
			match(T__5);
			setState(80);
			starPredicate();
			setState(81);
			match(T__5);
			setState(82);
			notIntermediatePredicate();
			setState(83);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntermediateStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public List<OrbitsPredicateContext> orbitsPredicate() {
			return getRuleContexts(OrbitsPredicateContext.class);
		}
		public OrbitsPredicateContext orbitsPredicate(int i) {
			return getRuleContext(OrbitsPredicateContext.class,i);
		}
		public IntermediateStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intermediateStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterIntermediateStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitIntermediateStatement(this);
		}
	}

	public final IntermediateStatementContext intermediateStatement() throws RecognitionException {
		IntermediateStatementContext _localctx = new IntermediateStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_intermediateStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__9);
			setState(86);
			match(T__1);
			setState(87);
			match(ID);
			setState(88);
			match(T__5);
			setState(89);
			match(ID);
			setState(90);
			match(T__2);
			setState(91);
			match(T__6);
			setState(92);
			orbitsPredicate();
			setState(93);
			match(T__5);
			setState(94);
			orbitsPredicate();
			setState(95);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrbitsPredicateContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public OrbitsPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orbitsPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterOrbitsPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitOrbitsPredicate(this);
		}
	}

	public final OrbitsPredicateContext orbitsPredicate() throws RecognitionException {
		OrbitsPredicateContext _localctx = new OrbitsPredicateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_orbitsPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__4);
			setState(98);
			match(T__1);
			setState(99);
			match(ID);
			setState(100);
			match(T__5);
			setState(101);
			match(ID);
			setState(102);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotIntermediatePredicateContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ExprParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ExprParser.ID, i);
		}
		public NotIntermediatePredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notIntermediatePredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterNotIntermediatePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitNotIntermediatePredicate(this);
		}
	}

	public final NotIntermediatePredicateContext notIntermediatePredicate() throws RecognitionException {
		NotIntermediatePredicateContext _localctx = new NotIntermediatePredicateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_notIntermediatePredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__10);
			setState(105);
			match(T__1);
			setState(106);
			match(T__9);
			setState(107);
			match(T__1);
			setState(108);
			match(ID);
			setState(109);
			match(T__5);
			setState(110);
			match(ID);
			setState(111);
			match(T__2);
			setState(112);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotStarPredicateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public NotStarPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notStarPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterNotStarPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitNotStarPredicate(this);
		}
	}

	public final NotStarPredicateContext notStarPredicate() throws RecognitionException {
		NotStarPredicateContext _localctx = new NotStarPredicateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_notStarPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__10);
			setState(115);
			match(T__1);
			setState(116);
			match(T__0);
			setState(117);
			match(T__1);
			setState(118);
			match(ID);
			setState(119);
			match(T__2);
			setState(120);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StarPredicateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public StarPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterStarPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitStarPredicate(this);
		}
	}

	public final StarPredicateContext starPredicate() throws RecognitionException {
		StarPredicateContext _localctx = new StarPredicateContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_starPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__0);
			setState(123);
			match(T__1);
			setState(124);
			match(ID);
			setState(125);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u0082\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\3\3\3\3\3\3\5\3#\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5<\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26"+
		"\2\2\2|\2\31\3\2\2\2\4\"\3\2\2\2\6$\3\2\2\2\b;\3\2\2\2\n=\3\2\2\2\fK\3"+
		"\2\2\2\16W\3\2\2\2\20c\3\2\2\2\22j\3\2\2\2\24t\3\2\2\2\26|\3\2\2\2\30"+
		"\32\5\4\3\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34"+
		"\3\3\2\2\2\35#\5\6\4\2\36#\5\b\5\2\37#\5\n\6\2 #\5\f\7\2!#\5\16\b\2\""+
		"\35\3\2\2\2\"\36\3\2\2\2\"\37\3\2\2\2\" \3\2\2\2\"!\3\2\2\2#\5\3\2\2\2"+
		"$%\7\3\2\2%&\7\4\2\2&\'\7\16\2\2\'(\7\5\2\2()\7\6\2\2)\7\3\2\2\2*+\7\7"+
		"\2\2+,\7\4\2\2,-\7\16\2\2-.\7\b\2\2./\7\16\2\2/\60\7\5\2\2\60<\7\6\2\2"+
		"\61\62\7\7\2\2\62\63\7\4\2\2\63\64\7\16\2\2\64\65\7\b\2\2\65\66\7\16\2"+
		"\2\66\67\7\5\2\2\678\7\t\2\289\5\20\t\29:\7\6\2\2:<\3\2\2\2;*\3\2\2\2"+
		";\61\3\2\2\2<\t\3\2\2\2=>\7\n\2\2>?\7\4\2\2?@\7\16\2\2@A\7\b\2\2AB\7\16"+
		"\2\2BC\7\5\2\2CD\7\t\2\2DE\5\20\t\2EF\7\b\2\2FG\5\22\n\2GH\7\b\2\2HI\5"+
		"\24\13\2IJ\7\6\2\2J\13\3\2\2\2KL\7\13\2\2LM\7\4\2\2MN\7\16\2\2NO\7\5\2"+
		"\2OP\7\t\2\2PQ\5\20\t\2QR\7\b\2\2RS\5\26\f\2ST\7\b\2\2TU\5\22\n\2UV\7"+
		"\6\2\2V\r\3\2\2\2WX\7\f\2\2XY\7\4\2\2YZ\7\16\2\2Z[\7\b\2\2[\\\7\16\2\2"+
		"\\]\7\5\2\2]^\7\t\2\2^_\5\20\t\2_`\7\b\2\2`a\5\20\t\2ab\7\6\2\2b\17\3"+
		"\2\2\2cd\7\7\2\2de\7\4\2\2ef\7\16\2\2fg\7\b\2\2gh\7\16\2\2hi\7\5\2\2i"+
		"\21\3\2\2\2jk\7\r\2\2kl\7\4\2\2lm\7\f\2\2mn\7\4\2\2no\7\16\2\2op\7\b\2"+
		"\2pq\7\16\2\2qr\7\5\2\2rs\7\5\2\2s\23\3\2\2\2tu\7\r\2\2uv\7\4\2\2vw\7"+
		"\3\2\2wx\7\4\2\2xy\7\16\2\2yz\7\5\2\2z{\7\5\2\2{\25\3\2\2\2|}\7\3\2\2"+
		"}~\7\4\2\2~\177\7\16\2\2\177\u0080\7\5\2\2\u0080\27\3\2\2\2\5\33\";";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
