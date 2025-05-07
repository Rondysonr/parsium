// Generated from c:/Users/nicol/Downloads/Compiladores_v3/Compiladores_v3/Parsium/src/main/grammar/Parsium.g4 by ANTLR 4.13.1
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
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SE=1, SENAO=2, ENQUANTO=3, ESCREVA=4, LEIA=5, INT=6, STRING=7, IPAREN=8, 
		FPAREN=9, ICHAVES=10, FCHAVES=11, PVIRG=12, IGUAL=13, SOMA=14, SUB=15, 
		MUL=16, DIV=17, EQ=18, DIF=19, AND=20, OR=21, NOT=22, MAIORQ=23, MENORQ=24, 
		MAIORIG=25, MENORIG=26, VAR=27, NUMEROS=28, STRINGVAL=29, WS=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SE", "SENAO", "ENQUANTO", "ESCREVA", "LEIA", "INT", "STRING", "IPAREN", 
			"FPAREN", "ICHAVES", "FCHAVES", "PVIRG", "IGUAL", "SOMA", "SUB", "MUL", 
			"DIV", "EQ", "DIF", "AND", "OR", "NOT", "MAIORQ", "MENORQ", "MAIORIG", 
			"MENORIG", "VAR", "NUMEROS", "STRINGVAL", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'while'", "'echo'", "'readline'", "'int'", "'string'", 
			"'('", "')'", "'{'", "'}'", "';'", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'=='", "'!='", "'&&'", "'||'", "'!'", "'>'", "'<'", "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SE", "SENAO", "ENQUANTO", "ESCREVA", "LEIA", "INT", "STRING", 
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
		"\u0004\u0000\u001e\u00af\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0094"+
		"\b\u001a\n\u001a\f\u001a\u0097\t\u001a\u0001\u001b\u0004\u001b\u009a\b"+
		"\u001b\u000b\u001b\f\u001b\u009b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0005\u001c\u00a2\b\u001c\n\u001c\f\u001c\u00a5\t\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0004\u001d\u00aa\b\u001d\u000b\u001d\f\u001d"+
		"\u00ab\u0001\u001d\u0001\u001d\u0000\u0000\u001e\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d;\u001e\u0001\u0000\u0005\u0003\u0000AZ__az\u0004\u0000"+
		"09AZ__az\u0001\u000009\u0002\u0000\"\"\\\\\u0003\u0000\t\n\r\r  \u00b3"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0001="+
		"\u0001\u0000\u0000\u0000\u0003@\u0001\u0000\u0000\u0000\u0005E\u0001\u0000"+
		"\u0000\u0000\u0007K\u0001\u0000\u0000\u0000\tP\u0001\u0000\u0000\u0000"+
		"\u000bY\u0001\u0000\u0000\u0000\r]\u0001\u0000\u0000\u0000\u000fd\u0001"+
		"\u0000\u0000\u0000\u0011f\u0001\u0000\u0000\u0000\u0013h\u0001\u0000\u0000"+
		"\u0000\u0015j\u0001\u0000\u0000\u0000\u0017l\u0001\u0000\u0000\u0000\u0019"+
		"n\u0001\u0000\u0000\u0000\u001bp\u0001\u0000\u0000\u0000\u001dr\u0001"+
		"\u0000\u0000\u0000\u001ft\u0001\u0000\u0000\u0000!v\u0001\u0000\u0000"+
		"\u0000#x\u0001\u0000\u0000\u0000%{\u0001\u0000\u0000\u0000\'~\u0001\u0000"+
		"\u0000\u0000)\u0081\u0001\u0000\u0000\u0000+\u0084\u0001\u0000\u0000\u0000"+
		"-\u0086\u0001\u0000\u0000\u0000/\u0088\u0001\u0000\u0000\u00001\u008a"+
		"\u0001\u0000\u0000\u00003\u008d\u0001\u0000\u0000\u00005\u0090\u0001\u0000"+
		"\u0000\u00007\u0099\u0001\u0000\u0000\u00009\u009d\u0001\u0000\u0000\u0000"+
		";\u00a9\u0001\u0000\u0000\u0000=>\u0005i\u0000\u0000>?\u0005f\u0000\u0000"+
		"?\u0002\u0001\u0000\u0000\u0000@A\u0005e\u0000\u0000AB\u0005l\u0000\u0000"+
		"BC\u0005s\u0000\u0000CD\u0005e\u0000\u0000D\u0004\u0001\u0000\u0000\u0000"+
		"EF\u0005w\u0000\u0000FG\u0005h\u0000\u0000GH\u0005i\u0000\u0000HI\u0005"+
		"l\u0000\u0000IJ\u0005e\u0000\u0000J\u0006\u0001\u0000\u0000\u0000KL\u0005"+
		"e\u0000\u0000LM\u0005c\u0000\u0000MN\u0005h\u0000\u0000NO\u0005o\u0000"+
		"\u0000O\b\u0001\u0000\u0000\u0000PQ\u0005r\u0000\u0000QR\u0005e\u0000"+
		"\u0000RS\u0005a\u0000\u0000ST\u0005d\u0000\u0000TU\u0005l\u0000\u0000"+
		"UV\u0005i\u0000\u0000VW\u0005n\u0000\u0000WX\u0005e\u0000\u0000X\n\u0001"+
		"\u0000\u0000\u0000YZ\u0005i\u0000\u0000Z[\u0005n\u0000\u0000[\\\u0005"+
		"t\u0000\u0000\\\f\u0001\u0000\u0000\u0000]^\u0005s\u0000\u0000^_\u0005"+
		"t\u0000\u0000_`\u0005r\u0000\u0000`a\u0005i\u0000\u0000ab\u0005n\u0000"+
		"\u0000bc\u0005g\u0000\u0000c\u000e\u0001\u0000\u0000\u0000de\u0005(\u0000"+
		"\u0000e\u0010\u0001\u0000\u0000\u0000fg\u0005)\u0000\u0000g\u0012\u0001"+
		"\u0000\u0000\u0000hi\u0005{\u0000\u0000i\u0014\u0001\u0000\u0000\u0000"+
		"jk\u0005}\u0000\u0000k\u0016\u0001\u0000\u0000\u0000lm\u0005;\u0000\u0000"+
		"m\u0018\u0001\u0000\u0000\u0000no\u0005=\u0000\u0000o\u001a\u0001\u0000"+
		"\u0000\u0000pq\u0005+\u0000\u0000q\u001c\u0001\u0000\u0000\u0000rs\u0005"+
		"-\u0000\u0000s\u001e\u0001\u0000\u0000\u0000tu\u0005*\u0000\u0000u \u0001"+
		"\u0000\u0000\u0000vw\u0005/\u0000\u0000w\"\u0001\u0000\u0000\u0000xy\u0005"+
		"=\u0000\u0000yz\u0005=\u0000\u0000z$\u0001\u0000\u0000\u0000{|\u0005!"+
		"\u0000\u0000|}\u0005=\u0000\u0000}&\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"&\u0000\u0000\u007f\u0080\u0005&\u0000\u0000\u0080(\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0005|\u0000\u0000\u0082\u0083\u0005|\u0000\u0000\u0083"+
		"*\u0001\u0000\u0000\u0000\u0084\u0085\u0005!\u0000\u0000\u0085,\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0005>\u0000\u0000\u0087.\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0005<\u0000\u0000\u00890\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0005>\u0000\u0000\u008b\u008c\u0005=\u0000\u0000\u008c2\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005<\u0000\u0000\u008e\u008f\u0005=\u0000"+
		"\u0000\u008f4\u0001\u0000\u0000\u0000\u0090\u0091\u0005$\u0000\u0000\u0091"+
		"\u0095\u0007\u0000\u0000\u0000\u0092\u0094\u0007\u0001\u0000\u0000\u0093"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095"+
		"\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096"+
		"6\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u009a"+
		"\u0007\u0002\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c8\u0001\u0000\u0000\u0000\u009d\u00a3\u0005"+
		"\"\u0000\u0000\u009e\u00a2\b\u0003\u0000\u0000\u009f\u00a0\u0005\\\u0000"+
		"\u0000\u00a0\u00a2\t\u0000\u0000\u0000\u00a1\u009e\u0001\u0000\u0000\u0000"+
		"\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005\"\u0000\u0000\u00a7:\u0001\u0000\u0000\u0000\u00a8"+
		"\u00aa\u0007\u0004\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0006\u001d\u0000\u0000\u00ae<\u0001\u0000\u0000\u0000\u0006\u0000"+
		"\u0095\u009b\u00a1\u00a3\u00ab\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}