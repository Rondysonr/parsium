// Generated from C:/Users/nicol/Downloads/Compiladores_v3/Compiladores_v3/Parsium/src/main/grammar/Parsium.g4 by ANTLR 4.13.2
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParsiumParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParsiumVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ParsiumParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(ParsiumParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(ParsiumParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#atribuicoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicoes(ParsiumParser.AtribuicoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#leitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeitura(ParsiumParser.LeituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(ParsiumParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(ParsiumParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ParsiumParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr(ParsiumParser.LogicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#relacionalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelacionalExpr(ParsiumParser.RelacionalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#expressaoigual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoigual(ParsiumParser.ExpressaoigualContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#expressaoaritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoaritmetica(ParsiumParser.ExpressaoaritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(ParsiumParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ParsiumParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(ParsiumParser.FatorContext ctx);
}