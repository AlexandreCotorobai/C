// Generated from StrLang.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StrLangParser}.
 */
public interface StrLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StrLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(StrLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(StrLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(StrLangParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(StrLangParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrLangParser#printStat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(StrLangParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrLangParser#printStat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(StrLangParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrLangParser#assignStat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(StrLangParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrLangParser#assignStat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(StrLangParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprChange}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprChange(StrLangParser.ExprChangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprChange}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprChange(StrLangParser.ExprChangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInput}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInput(StrLangParser.ExprInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInput}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInput(StrLangParser.ExprInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParen}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParen(StrLangParser.ExprParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParen}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParen(StrLangParser.ExprParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprString}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprString(StrLangParser.ExprStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprString}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprString(StrLangParser.ExprStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(StrLangParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(StrLangParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSub(StrLangParser.ExprSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSub(StrLangParser.ExprSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprTrim}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprTrim(StrLangParser.ExprTrimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprTrim}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprTrim(StrLangParser.ExprTrimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(StrLangParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAdd}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(StrLangParser.ExprAddContext ctx);
}