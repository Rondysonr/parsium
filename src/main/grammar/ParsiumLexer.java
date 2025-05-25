// Generated from Parsium.g4 by ANTLR 4.13.2
package main.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ParsiumLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SE=2, SENAO=3, ENQUANTO=4, ESCREVA=5, LEIA=6, INT=7, STRING=8, 
		IPAREN=9, FPAREN=10, ICHAVES=11, FCHAVES=12, PVIRG=13, IGUAL=14, SOMA=15, 
		SUB=16, MUL=17, DIV=18, EQ=19, DIF=20, AND=21, OR=22, NOT=23, MAIORQ=24, 
		MENORQ=25, MAIORIG=26, MENORIG=27, VAR=28, NUMEROS=29, STRINGVAL=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "SE", "SENAO", "ENQUANTO", "ESCREVA", "LEIA", "INT", "STRING", 
			"IPAREN", "FPAREN", "ICHAVES", "FCHAVES", "PVIRG", "IGUAL", "SOMA", "SUB", 
			"MUL", "DIV", "EQ", "DIF", "AND", "OR", "NOT", "MAIORQ", "MENORQ", "MAIORIG", 
			"MENORIG", "VAR", "NUMEROS", "STRINGVAL", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'if'", "'else'", "'while'", "'echo'", "'readline'", "'int'", 
			"'string'", "'('", "')'", "'{'", "'}'", "';'", "'='", "'+'", "'-'", "'*'", 
			"'/'", "'=='", "'!='", "'&&'", "'||'", "'!'", "'>'", "'<'", "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "SE", "SENAO", "ENQUANTO", "ESCREVA", "LEIA", "INT", "STRING", 
			"IPAREN", "FPAREN", "ICHAVES", "FCHAVES", "PVIRG", "IGUAL", "SOMA", "SUB", 
			"MUL", "DIV", "EQ", "DIF", "AND", "OR", "NOT", "MAIORQ", "MENORQ", "MAIORIG", 
			"MENORIG", "VAR", "NUMEROS", "STRINGVAL", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public ParsiumLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Parsium.g4"; }

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
		"\u0004\u0000\u001f\u00b3\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0098\b\u001b\n\u001b\f\u001b"+
		"\u009b\t\u001b\u0001\u001c\u0004\u001c\u009e\b\u001c\u000b\u001c\f\u001c"+
		"\u009f\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u00a6"+
		"\b\u001d\n\u001d\f\u001d\u00a9\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0004\u001e\u00ae\b\u001e\u000b\u001e\f\u001e\u00af\u0001\u001e\u0001"+
		"\u001e\u0000\u0000\u001f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d"+
		";\u001e=\u001f\u0001\u0000\u0005\u0003\u0000AZ__az\u0004\u000009AZ__a"+
		"z\u0001\u000009\u0002\u0000\"\"\\\\\u0003\u0000\t\n\r\r  \u00b7\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0001?\u0001\u0000\u0000\u0000\u0003A\u0001\u0000"+
		"\u0000\u0000\u0005D\u0001\u0000\u0000\u0000\u0007I\u0001\u0000\u0000\u0000"+
		"\tO\u0001\u0000\u0000\u0000\u000bT\u0001\u0000\u0000\u0000\r]\u0001\u0000"+
		"\u0000\u0000\u000fa\u0001\u0000\u0000\u0000\u0011h\u0001\u0000\u0000\u0000"+
		"\u0013j\u0001\u0000\u0000\u0000\u0015l\u0001\u0000\u0000\u0000\u0017n"+
		"\u0001\u0000\u0000\u0000\u0019p\u0001\u0000\u0000\u0000\u001br\u0001\u0000"+
		"\u0000\u0000\u001dt\u0001\u0000\u0000\u0000\u001fv\u0001\u0000\u0000\u0000"+
		"!x\u0001\u0000\u0000\u0000#z\u0001\u0000\u0000\u0000%|\u0001\u0000\u0000"+
		"\u0000\'\u007f\u0001\u0000\u0000\u0000)\u0082\u0001\u0000\u0000\u0000"+
		"+\u0085\u0001\u0000\u0000\u0000-\u0088\u0001\u0000\u0000\u0000/\u008a"+
		"\u0001\u0000\u0000\u00001\u008c\u0001\u0000\u0000\u00003\u008e\u0001\u0000"+
		"\u0000\u00005\u0091\u0001\u0000\u0000\u00007\u0094\u0001\u0000\u0000\u0000"+
		"9\u009d\u0001\u0000\u0000\u0000;\u00a1\u0001\u0000\u0000\u0000=\u00ad"+
		"\u0001\u0000\u0000\u0000?@\u0005,\u0000\u0000@\u0002\u0001\u0000\u0000"+
		"\u0000AB\u0005i\u0000\u0000BC\u0005f\u0000\u0000C\u0004\u0001\u0000\u0000"+
		"\u0000DE\u0005e\u0000\u0000EF\u0005l\u0000\u0000FG\u0005s\u0000\u0000"+
		"GH\u0005e\u0000\u0000H\u0006\u0001\u0000\u0000\u0000IJ\u0005w\u0000\u0000"+
		"JK\u0005h\u0000\u0000KL\u0005i\u0000\u0000LM\u0005l\u0000\u0000MN\u0005"+
		"e\u0000\u0000N\b\u0001\u0000\u0000\u0000OP\u0005e\u0000\u0000PQ\u0005"+
		"c\u0000\u0000QR\u0005h\u0000\u0000RS\u0005o\u0000\u0000S\n\u0001\u0000"+
		"\u0000\u0000TU\u0005r\u0000\u0000UV\u0005e\u0000\u0000VW\u0005a\u0000"+
		"\u0000WX\u0005d\u0000\u0000XY\u0005l\u0000\u0000YZ\u0005i\u0000\u0000"+
		"Z[\u0005n\u0000\u0000[\\\u0005e\u0000\u0000\\\f\u0001\u0000\u0000\u0000"+
		"]^\u0005i\u0000\u0000^_\u0005n\u0000\u0000_`\u0005t\u0000\u0000`\u000e"+
		"\u0001\u0000\u0000\u0000ab\u0005s\u0000\u0000bc\u0005t\u0000\u0000cd\u0005"+
		"r\u0000\u0000de\u0005i\u0000\u0000ef\u0005n\u0000\u0000fg\u0005g\u0000"+
		"\u0000g\u0010\u0001\u0000\u0000\u0000hi\u0005(\u0000\u0000i\u0012\u0001"+
		"\u0000\u0000\u0000jk\u0005)\u0000\u0000k\u0014\u0001\u0000\u0000\u0000"+
		"lm\u0005{\u0000\u0000m\u0016\u0001\u0000\u0000\u0000no\u0005}\u0000\u0000"+
		"o\u0018\u0001\u0000\u0000\u0000pq\u0005;\u0000\u0000q\u001a\u0001\u0000"+
		"\u0000\u0000rs\u0005=\u0000\u0000s\u001c\u0001\u0000\u0000\u0000tu\u0005"+
		"+\u0000\u0000u\u001e\u0001\u0000\u0000\u0000vw\u0005-\u0000\u0000w \u0001"+
		"\u0000\u0000\u0000xy\u0005*\u0000\u0000y\"\u0001\u0000\u0000\u0000z{\u0005"+
		"/\u0000\u0000{$\u0001\u0000\u0000\u0000|}\u0005=\u0000\u0000}~\u0005="+
		"\u0000\u0000~&\u0001\u0000\u0000\u0000\u007f\u0080\u0005!\u0000\u0000"+
		"\u0080\u0081\u0005=\u0000\u0000\u0081(\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005&\u0000\u0000\u0083\u0084\u0005&\u0000\u0000\u0084*\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0005|\u0000\u0000\u0086\u0087\u0005|\u0000\u0000"+
		"\u0087,\u0001\u0000\u0000\u0000\u0088\u0089\u0005!\u0000\u0000\u0089."+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005>\u0000\u0000\u008b0\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0005<\u0000\u0000\u008d2\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0005>\u0000\u0000\u008f\u0090\u0005=\u0000\u0000\u00904"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0005<\u0000\u0000\u0092\u0093\u0005"+
		"=\u0000\u0000\u00936\u0001\u0000\u0000\u0000\u0094\u0095\u0005$\u0000"+
		"\u0000\u0095\u0099\u0007\u0000\u0000\u0000\u0096\u0098\u0007\u0001\u0000"+
		"\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000"+
		"\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000"+
		"\u0000\u009a8\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009c\u009e\u0007\u0002\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0:\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a7\u0005\"\u0000\u0000\u00a2\u00a6\b\u0003\u0000\u0000\u00a3\u00a4"+
		"\u0005\\\u0000\u0000\u00a4\u00a6\t\u0000\u0000\u0000\u00a5\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0005\"\u0000\u0000\u00ab<\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ae\u0007\u0004\u0000\u0000\u00ad\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0006\u001e\u0000\u0000\u00b2>\u0001\u0000\u0000"+
		"\u0000\u0006\u0000\u0099\u009f\u00a5\u00a7\u00af\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}