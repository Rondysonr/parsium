// Generated from c:/Users/nicol/Downloads/Compiladores_v3/Compiladores_v3/Parsium/src/main/grammar/Parsium.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ParsiumParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SE=2, SENAO=3, ENQUANTO=4, ESCREVA=5, LEIA=6, INT=7, STRING=8, 
		IPAREN=9, FPAREN=10, ICHAVES=11, FCHAVES=12, PVIRG=13, IGUAL=14, SOMA=15, 
		SUB=16, MUL=17, DIV=18, EQ=19, DIF=20, AND=21, OR=22, NOT=23, MAIORQ=24, 
		MENORQ=25, MAIORIG=26, MENORIG=27, VAR=28, NUMEROS=29, STRINGVAL=30, WS=31;
	public static final int
		RULE_prog = 0, RULE_programa = 1, RULE_declaracoes = 2, RULE_atribuicoes = 3, 
		RULE_leitura = 4, RULE_saida = 5, RULE_loop = 6, RULE_while = 7, RULE_bloco = 8, 
		RULE_expr = 9, RULE_logicExpr = 10, RULE_relacionalExpr = 11, RULE_expressaoigual = 12, 
		RULE_expressaoaritmetica = 13, RULE_termo = 14, RULE_fator = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "programa", "declaracoes", "atribuicoes", "leitura", "saida", 
			"loop", "while", "bloco", "expr", "logicExpr", "relacionalExpr", "expressaoigual", 
			"expressaoaritmetica", "termo", "fator"
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

	@Override
	public String getGrammarFileName() { return "Parsium.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParsiumParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ParsiumParser.EOF, 0); }
		public List<ProgramaContext> programa() {
			return getRuleContexts(ProgramaContext.class);
		}
		public ProgramaContext programa(int i) {
			return getRuleContext(ProgramaContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1887437812L) != 0)) {
				{
				{
				setState(32);
				programa();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public AtribuicoesContext atribuicoes() {
			return getRuleContext(AtribuicoesContext.class,0);
		}
		public LeituraContext leitura() {
			return getRuleContext(LeituraContext.class,0);
		}
		public SaidaContext saida() {
			return getRuleContext(SaidaContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PVIRG() { return getToken(ParsiumParser.PVIRG, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programa);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				declaracoes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				atribuicoes();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				leitura();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				saida();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				loop();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				while_();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(46);
				expr();
				setState(47);
				match(PVIRG);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracoesContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(ParsiumParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(ParsiumParser.VAR, i);
		}
		public TerminalNode PVIRG() { return getToken(ParsiumParser.PVIRG, 0); }
		public TerminalNode INT() { return getToken(ParsiumParser.INT, 0); }
		public TerminalNode STRING() { return getToken(ParsiumParser.STRING, 0); }
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitDeclaracoes(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(52);
			match(VAR);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(53);
				match(T__0);
				setState(54);
				match(VAR);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(PVIRG);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtribuicoesContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ParsiumParser.VAR, 0); }
		public TerminalNode IGUAL() { return getToken(ParsiumParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PVIRG() { return getToken(ParsiumParser.PVIRG, 0); }
		public AtribuicoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterAtribuicoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitAtribuicoes(this);
		}
	}

	public final AtribuicoesContext atribuicoes() throws RecognitionException {
		AtribuicoesContext _localctx = new AtribuicoesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atribuicoes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(VAR);
			setState(63);
			match(IGUAL);
			setState(64);
			expr();
			setState(65);
			match(PVIRG);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LeituraContext extends ParserRuleContext {
		public TerminalNode ESCREVA() { return getToken(ParsiumParser.ESCREVA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PVIRG() { return getToken(ParsiumParser.PVIRG, 0); }
		public LeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitLeitura(this);
		}
	}

	public final LeituraContext leitura() throws RecognitionException {
		LeituraContext _localctx = new LeituraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_leitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(ESCREVA);
			setState(68);
			expr();
			setState(69);
			match(PVIRG);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SaidaContext extends ParserRuleContext {
		public TerminalNode ESCREVA() { return getToken(ParsiumParser.ESCREVA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PVIRG() { return getToken(ParsiumParser.PVIRG, 0); }
		public SaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterSaida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitSaida(this);
		}
	}

	public final SaidaContext saida() throws RecognitionException {
		SaidaContext _localctx = new SaidaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_saida);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(ESCREVA);
			setState(72);
			expr();
			setState(73);
			match(PVIRG);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(ParsiumParser.SE, 0); }
		public TerminalNode IPAREN() { return getToken(ParsiumParser.IPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAREN() { return getToken(ParsiumParser.FPAREN, 0); }
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(ParsiumParser.SENAO, 0); }
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitLoop(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(SE);
			setState(76);
			match(IPAREN);
			setState(77);
			expr();
			setState(78);
			match(FPAREN);
			setState(79);
			bloco();
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(80);
				match(SENAO);
				setState(81);
				bloco();
				}
				break;
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode ENQUANTO() { return getToken(ParsiumParser.ENQUANTO, 0); }
		public TerminalNode IPAREN() { return getToken(ParsiumParser.IPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAREN() { return getToken(ParsiumParser.FPAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitWhile(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(ENQUANTO);
			setState(85);
			match(IPAREN);
			setState(86);
			expr();
			setState(87);
			match(FPAREN);
			setState(88);
			bloco();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public TerminalNode ICHAVES() { return getToken(ParsiumParser.ICHAVES, 0); }
		public TerminalNode FCHAVES() { return getToken(ParsiumParser.FCHAVES, 0); }
		public List<ProgramaContext> programa() {
			return getRuleContexts(ProgramaContext.class);
		}
		public ProgramaContext programa(int i) {
			return getRuleContext(ProgramaContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bloco);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ICHAVES:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(ICHAVES);
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1887437812L) != 0)) {
					{
					{
					setState(91);
					programa();
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97);
				match(FCHAVES);
				}
				break;
			case SE:
			case ENQUANTO:
			case ESCREVA:
			case LEIA:
			case INT:
			case STRING:
			case IPAREN:
			case NOT:
			case VAR:
			case NUMEROS:
			case STRINGVAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				programa();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			logicExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicExprContext extends ParserRuleContext {
		public List<RelacionalExprContext> relacionalExpr() {
			return getRuleContexts(RelacionalExprContext.class);
		}
		public RelacionalExprContext relacionalExpr(int i) {
			return getRuleContext(RelacionalExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(ParsiumParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ParsiumParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(ParsiumParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ParsiumParser.OR, i);
		}
		public LogicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterLogicExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitLogicExpr(this);
		}
	}

	public final LogicExprContext logicExpr() throws RecognitionException {
		LogicExprContext _localctx = new LogicExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_logicExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			relacionalExpr();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(104);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(105);
				relacionalExpr();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelacionalExprContext extends ParserRuleContext {
		public List<ExpressaoigualContext> expressaoigual() {
			return getRuleContexts(ExpressaoigualContext.class);
		}
		public ExpressaoigualContext expressaoigual(int i) {
			return getRuleContext(ExpressaoigualContext.class,i);
		}
		public TerminalNode MAIORQ() { return getToken(ParsiumParser.MAIORQ, 0); }
		public TerminalNode MENORQ() { return getToken(ParsiumParser.MENORQ, 0); }
		public TerminalNode MAIORIG() { return getToken(ParsiumParser.MAIORIG, 0); }
		public TerminalNode MENORIG() { return getToken(ParsiumParser.MENORIG, 0); }
		public RelacionalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relacionalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterRelacionalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitRelacionalExpr(this);
		}
	}

	public final RelacionalExprContext relacionalExpr() throws RecognitionException {
		RelacionalExprContext _localctx = new RelacionalExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_relacionalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			expressaoigual();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 251658240L) != 0)) {
				{
				setState(112);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 251658240L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(113);
				expressaoigual();
				}
			}

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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoigualContext extends ParserRuleContext {
		public List<ExpressaoaritmeticaContext> expressaoaritmetica() {
			return getRuleContexts(ExpressaoaritmeticaContext.class);
		}
		public ExpressaoaritmeticaContext expressaoaritmetica(int i) {
			return getRuleContext(ExpressaoaritmeticaContext.class,i);
		}
		public TerminalNode EQ() { return getToken(ParsiumParser.EQ, 0); }
		public TerminalNode DIF() { return getToken(ParsiumParser.DIF, 0); }
		public ExpressaoigualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoigual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterExpressaoigual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitExpressaoigual(this);
		}
	}

	public final ExpressaoigualContext expressaoigual() throws RecognitionException {
		ExpressaoigualContext _localctx = new ExpressaoigualContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expressaoigual);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			expressaoaritmetica();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ || _la==DIF) {
				{
				setState(117);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==DIF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(118);
				expressaoaritmetica();
				}
			}

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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoaritmeticaContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> SOMA() { return getTokens(ParsiumParser.SOMA); }
		public TerminalNode SOMA(int i) {
			return getToken(ParsiumParser.SOMA, i);
		}
		public List<TerminalNode> SUB() { return getTokens(ParsiumParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(ParsiumParser.SUB, i);
		}
		public ExpressaoaritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoaritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterExpressaoaritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitExpressaoaritmetica(this);
		}
	}

	public final ExpressaoaritmeticaContext expressaoaritmetica() throws RecognitionException {
		ExpressaoaritmeticaContext _localctx = new ExpressaoaritmeticaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressaoaritmetica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			termo();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SOMA || _la==SUB) {
				{
				{
				setState(122);
				_la = _input.LA(1);
				if ( !(_la==SOMA || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(123);
				termo();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(ParsiumParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(ParsiumParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(ParsiumParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(ParsiumParser.DIV, i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			fator();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(130);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(131);
				fator();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode NUMEROS() { return getToken(ParsiumParser.NUMEROS, 0); }
		public TerminalNode VAR() { return getToken(ParsiumParser.VAR, 0); }
		public TerminalNode STRINGVAL() { return getToken(ParsiumParser.STRINGVAL, 0); }
		public TerminalNode LEIA() { return getToken(ParsiumParser.LEIA, 0); }
		public TerminalNode IPAREN() { return getToken(ParsiumParser.IPAREN, 0); }
		public TerminalNode FPAREN() { return getToken(ParsiumParser.FPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ParsiumParser.NOT, 0); }
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParsiumListener ) ((ParsiumListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fator);
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMEROS:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(NUMEROS);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(VAR);
				}
				break;
			case STRINGVAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				match(STRINGVAL);
				}
				break;
			case LEIA:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				match(LEIA);
				setState(141);
				match(IPAREN);
				setState(142);
				match(FPAREN);
				}
				break;
			case IPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				match(IPAREN);
				setState(144);
				expr();
				setState(145);
				match(FPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				match(NOT);
				setState(148);
				fator();
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

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u0098\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00012\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00028\b"+
		"\u0002\n\u0002\f\u0002;\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006S\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b]\b\b\n\b\f\b`\t"+
		"\b\u0001\b\u0001\b\u0003\bd\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0005\nk\b\n\n\n\f\nn\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000bs\b\u000b\u0001\f\u0001\f\u0001\f\u0003\fx\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0005\r}\b\r\n\r\f\r\u0080\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u0085\b\u000e\n\u000e\f\u000e\u0088\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0096"+
		"\b\u000f\u0001\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0006\u0001\u0000"+
		"\u0007\b\u0001\u0000\u0015\u0016\u0001\u0000\u0018\u001b\u0001\u0000\u0013"+
		"\u0014\u0001\u0000\u000f\u0010\u0001\u0000\u0011\u0012\u009c\u0000#\u0001"+
		"\u0000\u0000\u0000\u00021\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000"+
		"\u0000\u0006>\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000\u0000\nG\u0001"+
		"\u0000\u0000\u0000\fK\u0001\u0000\u0000\u0000\u000eT\u0001\u0000\u0000"+
		"\u0000\u0010c\u0001\u0000\u0000\u0000\u0012e\u0001\u0000\u0000\u0000\u0014"+
		"g\u0001\u0000\u0000\u0000\u0016o\u0001\u0000\u0000\u0000\u0018t\u0001"+
		"\u0000\u0000\u0000\u001ay\u0001\u0000\u0000\u0000\u001c\u0081\u0001\u0000"+
		"\u0000\u0000\u001e\u0095\u0001\u0000\u0000\u0000 \"\u0003\u0002\u0001"+
		"\u0000! \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000"+
		"\u0000\u0000#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000\u0000%#\u0001"+
		"\u0000\u0000\u0000&\'\u0005\u0000\u0000\u0001\'\u0001\u0001\u0000\u0000"+
		"\u0000(2\u0003\u0004\u0002\u0000)2\u0003\u0006\u0003\u0000*2\u0003\b\u0004"+
		"\u0000+2\u0003\n\u0005\u0000,2\u0003\f\u0006\u0000-2\u0003\u000e\u0007"+
		"\u0000./\u0003\u0012\t\u0000/0\u0005\r\u0000\u000002\u0001\u0000\u0000"+
		"\u00001(\u0001\u0000\u0000\u00001)\u0001\u0000\u0000\u00001*\u0001\u0000"+
		"\u0000\u00001+\u0001\u0000\u0000\u00001,\u0001\u0000\u0000\u00001-\u0001"+
		"\u0000\u0000\u00001.\u0001\u0000\u0000\u00002\u0003\u0001\u0000\u0000"+
		"\u000034\u0007\u0000\u0000\u000049\u0005\u001c\u0000\u000056\u0005\u0001"+
		"\u0000\u000068\u0005\u001c\u0000\u000075\u0001\u0000\u0000\u00008;\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005\r\u0000\u0000"+
		"=\u0005\u0001\u0000\u0000\u0000>?\u0005\u001c\u0000\u0000?@\u0005\u000e"+
		"\u0000\u0000@A\u0003\u0012\t\u0000AB\u0005\r\u0000\u0000B\u0007\u0001"+
		"\u0000\u0000\u0000CD\u0005\u0005\u0000\u0000DE\u0003\u0012\t\u0000EF\u0005"+
		"\r\u0000\u0000F\t\u0001\u0000\u0000\u0000GH\u0005\u0005\u0000\u0000HI"+
		"\u0003\u0012\t\u0000IJ\u0005\r\u0000\u0000J\u000b\u0001\u0000\u0000\u0000"+
		"KL\u0005\u0002\u0000\u0000LM\u0005\t\u0000\u0000MN\u0003\u0012\t\u0000"+
		"NO\u0005\n\u0000\u0000OR\u0003\u0010\b\u0000PQ\u0005\u0003\u0000\u0000"+
		"QS\u0003\u0010\b\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"S\r\u0001\u0000\u0000\u0000TU\u0005\u0004\u0000\u0000UV\u0005\t\u0000"+
		"\u0000VW\u0003\u0012\t\u0000WX\u0005\n\u0000\u0000XY\u0003\u0010\b\u0000"+
		"Y\u000f\u0001\u0000\u0000\u0000Z^\u0005\u000b\u0000\u0000[]\u0003\u0002"+
		"\u0001\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000ad\u0005\f\u0000\u0000bd\u0003\u0002\u0001\u0000"+
		"cZ\u0001\u0000\u0000\u0000cb\u0001\u0000\u0000\u0000d\u0011\u0001\u0000"+
		"\u0000\u0000ef\u0003\u0014\n\u0000f\u0013\u0001\u0000\u0000\u0000gl\u0003"+
		"\u0016\u000b\u0000hi\u0007\u0001\u0000\u0000ik\u0003\u0016\u000b\u0000"+
		"jh\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000m\u0015\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000or\u0003\u0018\f\u0000pq\u0007\u0002\u0000\u0000qs\u0003"+
		"\u0018\f\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0017"+
		"\u0001\u0000\u0000\u0000tw\u0003\u001a\r\u0000uv\u0007\u0003\u0000\u0000"+
		"vx\u0003\u001a\r\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"x\u0019\u0001\u0000\u0000\u0000y~\u0003\u001c\u000e\u0000z{\u0007\u0004"+
		"\u0000\u0000{}\u0003\u001c\u000e\u0000|z\u0001\u0000\u0000\u0000}\u0080"+
		"\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f\u001b\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000"+
		"\u0000\u0081\u0086\u0003\u001e\u000f\u0000\u0082\u0083\u0007\u0005\u0000"+
		"\u0000\u0083\u0085\u0003\u001e\u000f\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u001d\u0001\u0000\u0000"+
		"\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u0096\u0005\u001d\u0000"+
		"\u0000\u008a\u0096\u0005\u001c\u0000\u0000\u008b\u0096\u0005\u001e\u0000"+
		"\u0000\u008c\u008d\u0005\u0006\u0000\u0000\u008d\u008e\u0005\t\u0000\u0000"+
		"\u008e\u0096\u0005\n\u0000\u0000\u008f\u0090\u0005\t\u0000\u0000\u0090"+
		"\u0091\u0003\u0012\t\u0000\u0091\u0092\u0005\n\u0000\u0000\u0092\u0096"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0017\u0000\u0000\u0094\u0096"+
		"\u0003\u001e\u000f\u0000\u0095\u0089\u0001\u0000\u0000\u0000\u0095\u008a"+
		"\u0001\u0000\u0000\u0000\u0095\u008b\u0001\u0000\u0000\u0000\u0095\u008c"+
		"\u0001\u0000\u0000\u0000\u0095\u008f\u0001\u0000\u0000\u0000\u0095\u0093"+
		"\u0001\u0000\u0000\u0000\u0096\u001f\u0001\u0000\u0000\u0000\f#19R^cl"+
		"rw~\u0086\u0095";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}