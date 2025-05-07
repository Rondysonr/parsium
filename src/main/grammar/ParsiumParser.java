// Generated from C:/Users/nicol/Downloads/Compiladores_v3/Compiladores_v3/Parsium/src/main/grammar/Parsium.g4 by ANTLR 4.13.2
package  main.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ParsiumParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SE=1, SENAO=2, ENQUANTO=3, ESCREVA=4, LEIA=5, INT=6, STRING=7, IPAREN=8, 
		FPAREN=9, ICHAVES=10, FCHAVES=11, PVIRG=12, IGUAL=13, SOMA=14, SUB=15, 
		MUL=16, DIV=17, EQ=18, DIF=19, AND=20, OR=21, NOT=22, MAIORQ=23, MENORQ=24, 
		MAIORIG=25, MENORIG=26, VAR=27, NUMEROS=28, STRINGVAL=29, WS=30;
	public static final int
		RULE_program = 0, RULE_programa = 1, RULE_declaracoes = 2, RULE_atribuicoes = 3, 
		RULE_leitura = 4, RULE_loop = 5, RULE_while = 6, RULE_expr = 7, RULE_logicExpr = 8, 
		RULE_relacionalExpr = 9, RULE_expressaoigual = 10, RULE_expressaoaritmetica = 11, 
		RULE_termo = 12, RULE_fator = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programa", "declaracoes", "atribuicoes", "leitura", "loop", 
			"while", "expr", "logicExpr", "relacionalExpr", "expressaoigual", "expressaoaritmetica", 
			"termo", "fator"
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
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ParsiumParser.EOF, 0); }
		public List<ProgramaContext> programa() {
			return getRuleContexts(ProgramaContext.class);
		}
		public ProgramaContext programa(int i) {
			return getRuleContext(ProgramaContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 943718906L) != 0)) {
				{
				{
				setState(28);
				programa();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programa);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				declaracoes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				atribuicoes();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				leitura();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				loop();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				while_();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				expr();
				setState(42);
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
		public TerminalNode VAR() { return getToken(ParsiumParser.VAR, 0); }
		public TerminalNode PVIRG() { return getToken(ParsiumParser.PVIRG, 0); }
		public TerminalNode INT() { return getToken(ParsiumParser.INT, 0); }
		public TerminalNode STRING() { return getToken(ParsiumParser.STRING, 0); }
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(47);
			match(VAR);
			setState(48);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitAtribuicoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicoesContext atribuicoes() throws RecognitionException {
		AtribuicoesContext _localctx = new AtribuicoesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atribuicoes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(VAR);
			setState(51);
			match(IGUAL);
			setState(52);
			expr();
			setState(53);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitLeitura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeituraContext leitura() throws RecognitionException {
		LeituraContext _localctx = new LeituraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_leitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(ESCREVA);
			setState(56);
			expr();
			setState(57);
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
		public List<TerminalNode> ICHAVES() { return getTokens(ParsiumParser.ICHAVES); }
		public TerminalNode ICHAVES(int i) {
			return getToken(ParsiumParser.ICHAVES, i);
		}
		public List<TerminalNode> FCHAVES() { return getTokens(ParsiumParser.FCHAVES); }
		public TerminalNode FCHAVES(int i) {
			return getToken(ParsiumParser.FCHAVES, i);
		}
		public List<ProgramaContext> programa() {
			return getRuleContexts(ProgramaContext.class);
		}
		public ProgramaContext programa(int i) {
			return getRuleContext(ProgramaContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(ParsiumParser.SENAO, 0); }
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(SE);
			setState(60);
			match(IPAREN);
			setState(61);
			expr();
			setState(62);
			match(FPAREN);
			setState(63);
			match(ICHAVES);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 943718906L) != 0)) {
				{
				{
				setState(64);
				programa();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(FCHAVES);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(71);
				match(SENAO);
				setState(72);
				match(ICHAVES);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 943718906L) != 0)) {
					{
					{
					setState(73);
					programa();
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				match(FCHAVES);
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
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode ENQUANTO() { return getToken(ParsiumParser.ENQUANTO, 0); }
		public TerminalNode IPAREN() { return getToken(ParsiumParser.IPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAREN() { return getToken(ParsiumParser.FPAREN, 0); }
		public TerminalNode ICHAVES() { return getToken(ParsiumParser.ICHAVES, 0); }
		public TerminalNode FCHAVES() { return getToken(ParsiumParser.FCHAVES, 0); }
		public List<ProgramaContext> programa() {
			return getRuleContexts(ProgramaContext.class);
		}
		public ProgramaContext programa(int i) {
			return getRuleContext(ProgramaContext.class,i);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ENQUANTO);
			setState(83);
			match(IPAREN);
			setState(84);
			expr();
			setState(85);
			match(FPAREN);
			setState(86);
			match(ICHAVES);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 943718906L) != 0)) {
				{
				{
				setState(87);
				programa();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(FCHAVES);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExprContext logicExpr() throws RecognitionException {
		LogicExprContext _localctx = new LogicExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logicExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			relacionalExpr();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(98);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(99);
				relacionalExpr();
				}
				}
				setState(104);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitRelacionalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelacionalExprContext relacionalExpr() throws RecognitionException {
		RelacionalExprContext _localctx = new RelacionalExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relacionalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			expressaoigual();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) {
				{
				setState(106);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(107);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitExpressaoigual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoigualContext expressaoigual() throws RecognitionException {
		ExpressaoigualContext _localctx = new ExpressaoigualContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expressaoigual);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			expressaoaritmetica();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ || _la==DIF) {
				{
				setState(111);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==DIF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(112);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitExpressaoaritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoaritmeticaContext expressaoaritmetica() throws RecognitionException {
		ExpressaoaritmeticaContext _localctx = new ExpressaoaritmeticaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expressaoaritmetica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			termo();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SOMA || _la==SUB) {
				{
				{
				setState(116);
				_la = _input.LA(1);
				if ( !(_la==SOMA || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(117);
				termo();
				}
				}
				setState(122);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			fator();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(124);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(125);
				fator();
				}
				}
				setState(130);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParsiumVisitor ) return ((ParsiumVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fator);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMEROS:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(NUMEROS);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(VAR);
				}
				break;
			case STRINGVAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				match(STRINGVAL);
				}
				break;
			case LEIA:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				match(LEIA);
				setState(135);
				match(IPAREN);
				setState(136);
				match(FPAREN);
				}
				break;
			case IPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(137);
				match(IPAREN);
				setState(138);
				expr();
				setState(139);
				match(FPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 6);
				{
				setState(141);
				match(NOT);
				setState(142);
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
		"\u0004\u0001\u001e\u0092\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0005\u0000\u001e\b\u0000"+
		"\n\u0000\f\u0000!\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001-\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005B\b\u0005\n\u0005\f\u0005"+
		"E\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"K\b\u0005\n\u0005\f\u0005N\t\u0005\u0001\u0005\u0003\u0005Q\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006Y\b\u0006\n\u0006\f\u0006\\\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\be\b\b\n\b\f\bh\t\b\u0001"+
		"\t\u0001\t\u0001\t\u0003\tm\b\t\u0001\n\u0001\n\u0001\n\u0003\nr\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000bw\b\u000b\n\u000b\f\u000bz\t"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u007f\b\f\n\f\f\f\u0082\t\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u0090\b\r\u0001\r\u0000\u0000\u000e\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0006"+
		"\u0001\u0000\u0006\u0007\u0001\u0000\u0014\u0015\u0001\u0000\u0017\u001a"+
		"\u0001\u0000\u0012\u0013\u0001\u0000\u000e\u000f\u0001\u0000\u0010\u0011"+
		"\u0097\u0000\u001f\u0001\u0000\u0000\u0000\u0002,\u0001\u0000\u0000\u0000"+
		"\u0004.\u0001\u0000\u0000\u0000\u00062\u0001\u0000\u0000\u0000\b7\u0001"+
		"\u0000\u0000\u0000\n;\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000"+
		"\u000e_\u0001\u0000\u0000\u0000\u0010a\u0001\u0000\u0000\u0000\u0012i"+
		"\u0001\u0000\u0000\u0000\u0014n\u0001\u0000\u0000\u0000\u0016s\u0001\u0000"+
		"\u0000\u0000\u0018{\u0001\u0000\u0000\u0000\u001a\u008f\u0001\u0000\u0000"+
		"\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d\u001c\u0001\u0000\u0000"+
		"\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000"+
		"\u001f \u0001\u0000\u0000\u0000 \"\u0001\u0000\u0000\u0000!\u001f\u0001"+
		"\u0000\u0000\u0000\"#\u0005\u0000\u0000\u0001#\u0001\u0001\u0000\u0000"+
		"\u0000$-\u0003\u0004\u0002\u0000%-\u0003\u0006\u0003\u0000&-\u0003\b\u0004"+
		"\u0000\'-\u0003\n\u0005\u0000(-\u0003\f\u0006\u0000)*\u0003\u000e\u0007"+
		"\u0000*+\u0005\f\u0000\u0000+-\u0001\u0000\u0000\u0000,$\u0001\u0000\u0000"+
		"\u0000,%\u0001\u0000\u0000\u0000,&\u0001\u0000\u0000\u0000,\'\u0001\u0000"+
		"\u0000\u0000,(\u0001\u0000\u0000\u0000,)\u0001\u0000\u0000\u0000-\u0003"+
		"\u0001\u0000\u0000\u0000./\u0007\u0000\u0000\u0000/0\u0005\u001b\u0000"+
		"\u000001\u0005\f\u0000\u00001\u0005\u0001\u0000\u0000\u000023\u0005\u001b"+
		"\u0000\u000034\u0005\r\u0000\u000045\u0003\u000e\u0007\u000056\u0005\f"+
		"\u0000\u00006\u0007\u0001\u0000\u0000\u000078\u0005\u0004\u0000\u0000"+
		"89\u0003\u000e\u0007\u00009:\u0005\f\u0000\u0000:\t\u0001\u0000\u0000"+
		"\u0000;<\u0005\u0001\u0000\u0000<=\u0005\b\u0000\u0000=>\u0003\u000e\u0007"+
		"\u0000>?\u0005\t\u0000\u0000?C\u0005\n\u0000\u0000@B\u0003\u0002\u0001"+
		"\u0000A@\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000"+
		"\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000EC\u0001"+
		"\u0000\u0000\u0000FP\u0005\u000b\u0000\u0000GH\u0005\u0002\u0000\u0000"+
		"HL\u0005\n\u0000\u0000IK\u0003\u0002\u0001\u0000JI\u0001\u0000\u0000\u0000"+
		"KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MO\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OQ\u0005\u000b"+
		"\u0000\u0000PG\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000Q\u000b"+
		"\u0001\u0000\u0000\u0000RS\u0005\u0003\u0000\u0000ST\u0005\b\u0000\u0000"+
		"TU\u0003\u000e\u0007\u0000UV\u0005\t\u0000\u0000VZ\u0005\n\u0000\u0000"+
		"WY\u0003\u0002\u0001\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000"+
		"\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005\u000b\u0000\u0000^\r\u0001"+
		"\u0000\u0000\u0000_`\u0003\u0010\b\u0000`\u000f\u0001\u0000\u0000\u0000"+
		"af\u0003\u0012\t\u0000bc\u0007\u0001\u0000\u0000ce\u0003\u0012\t\u0000"+
		"db\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000g\u0011\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000il\u0003\u0014\n\u0000jk\u0007\u0002\u0000\u0000km\u0003"+
		"\u0014\n\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u0013"+
		"\u0001\u0000\u0000\u0000nq\u0003\u0016\u000b\u0000op\u0007\u0003\u0000"+
		"\u0000pr\u0003\u0016\u000b\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000r\u0015\u0001\u0000\u0000\u0000sx\u0003\u0018\f\u0000tu\u0007"+
		"\u0004\u0000\u0000uw\u0003\u0018\f\u0000vt\u0001\u0000\u0000\u0000wz\u0001"+
		"\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"y\u0017\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{\u0080\u0003"+
		"\u001a\r\u0000|}\u0007\u0005\u0000\u0000}\u007f\u0003\u001a\r\u0000~|"+
		"\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080~\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0019\u0001"+
		"\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0090\u0005"+
		"\u001c\u0000\u0000\u0084\u0090\u0005\u001b\u0000\u0000\u0085\u0090\u0005"+
		"\u001d\u0000\u0000\u0086\u0087\u0005\u0005\u0000\u0000\u0087\u0088\u0005"+
		"\b\u0000\u0000\u0088\u0090\u0005\t\u0000\u0000\u0089\u008a\u0005\b\u0000"+
		"\u0000\u008a\u008b\u0003\u000e\u0007\u0000\u008b\u008c\u0005\t\u0000\u0000"+
		"\u008c\u0090\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0016\u0000\u0000"+
		"\u008e\u0090\u0003\u001a\r\u0000\u008f\u0083\u0001\u0000\u0000\u0000\u008f"+
		"\u0084\u0001\u0000\u0000\u0000\u008f\u0085\u0001\u0000\u0000\u0000\u008f"+
		"\u0086\u0001\u0000\u0000\u0000\u008f\u0089\u0001\u0000\u0000\u0000\u008f"+
		"\u008d\u0001\u0000\u0000\u0000\u0090\u001b\u0001\u0000\u0000\u0000\f\u001f"+
		",CLPZflqx\u0080\u008f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}