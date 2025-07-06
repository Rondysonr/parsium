// Generated from c:/Users/nicol/Downloads/Compiladores_v3/Compiladores_v3/Parsium/src/main/grammar/Parsium.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParsiumParser}.
 */
public interface ParsiumListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ParsiumParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ParsiumParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(ParsiumParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(ParsiumParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(ParsiumParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(ParsiumParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#atribuicoes}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicoes(ParsiumParser.AtribuicoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#atribuicoes}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicoes(ParsiumParser.AtribuicoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#leitura}.
	 * @param ctx the parse tree
	 */
	void enterLeitura(ParsiumParser.LeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#leitura}.
	 * @param ctx the parse tree
	 */
	void exitLeitura(ParsiumParser.LeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#saida}.
	 * @param ctx the parse tree
	 */
	void enterSaida(ParsiumParser.SaidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#saida}.
	 * @param ctx the parse tree
	 */
	void exitSaida(ParsiumParser.SaidaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(ParsiumParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(ParsiumParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(ParsiumParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(ParsiumParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(ParsiumParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(ParsiumParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ParsiumParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ParsiumParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr(ParsiumParser.LogicExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr(ParsiumParser.LogicExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#relacionalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelacionalExpr(ParsiumParser.RelacionalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#relacionalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelacionalExpr(ParsiumParser.RelacionalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#expressaoigual}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoigual(ParsiumParser.ExpressaoigualContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#expressaoigual}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoigual(ParsiumParser.ExpressaoigualContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#expressaoaritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoaritmetica(ParsiumParser.ExpressaoaritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#expressaoaritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoaritmetica(ParsiumParser.ExpressaoaritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(ParsiumParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(ParsiumParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParsiumParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(ParsiumParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParsiumParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(ParsiumParser.FatorContext ctx);
}