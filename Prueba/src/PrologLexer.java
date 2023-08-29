// Generated from C:\Users\34642\eclipse\TFG\Github\Prueba\src\Expr.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PrologLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, WS=12, COMMENT=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "ID", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'star('", "')'", "';'", "'orbits('", "','", "'satellite('", "':'", 
		"'not('", "'planet('", "'intermediate('"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "ID", 
		"WS", "COMMENT"
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


	public PrologLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17p\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\7\f\\\n\f\f\f\16\f_\13\f\3\r\6\rb\n\r\r\r\16\rc\3\r\3\r"+
		"\3\16\3\16\7\16j\n\16\f\16\16\16m\13\16\3\16\3\16\2\2\17\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\6\5\2C\\aac|\6\2"+
		"\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2r\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\3\35\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13/\3\2\2\2\r\61\3"+
		"\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23C\3\2\2\2\25K\3\2\2\2\27Y\3\2\2\2\31"+
		"a\3\2\2\2\33g\3\2\2\2\35\36\7u\2\2\36\37\7v\2\2\37 \7c\2\2 !\7t\2\2!\""+
		"\7*\2\2\"\4\3\2\2\2#$\7+\2\2$\6\3\2\2\2%&\7=\2\2&\b\3\2\2\2\'(\7q\2\2"+
		"()\7t\2\2)*\7d\2\2*+\7k\2\2+,\7v\2\2,-\7u\2\2-.\7*\2\2.\n\3\2\2\2/\60"+
		"\7.\2\2\60\f\3\2\2\2\61\62\7u\2\2\62\63\7c\2\2\63\64\7v\2\2\64\65\7g\2"+
		"\2\65\66\7n\2\2\66\67\7n\2\2\678\7k\2\289\7v\2\29:\7g\2\2:;\7*\2\2;\16"+
		"\3\2\2\2<=\7<\2\2=\20\3\2\2\2>?\7p\2\2?@\7q\2\2@A\7v\2\2AB\7*\2\2B\22"+
		"\3\2\2\2CD\7r\2\2DE\7n\2\2EF\7c\2\2FG\7p\2\2GH\7g\2\2HI\7v\2\2IJ\7*\2"+
		"\2J\24\3\2\2\2KL\7k\2\2LM\7p\2\2MN\7v\2\2NO\7g\2\2OP\7t\2\2PQ\7o\2\2Q"+
		"R\7g\2\2RS\7f\2\2ST\7k\2\2TU\7c\2\2UV\7v\2\2VW\7g\2\2WX\7*\2\2X\26\3\2"+
		"\2\2Y]\t\2\2\2Z\\\t\3\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\30"+
		"\3\2\2\2_]\3\2\2\2`b\t\4\2\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2d"+
		"e\3\2\2\2ef\b\r\2\2f\32\3\2\2\2gk\7\'\2\2hj\n\5\2\2ih\3\2\2\2jm\3\2\2"+
		"\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\b\16\2\2o\34\3\2\2\2\6\2"+
		"]ck\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}