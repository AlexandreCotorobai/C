// Generated from Complex.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ComplexParser}.
 */
public interface ComplexListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ComplexParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ComplexParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComplexParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ComplexParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComplexParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ComplexParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComplexParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ComplexParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComplexParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ComplexParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComplexParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ComplexParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ComplexParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ComplexParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ComplexParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ComplexParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(ComplexParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(ComplexParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParen}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParen(ComplexParser.ExprParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParen}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParen(ComplexParser.ExprParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprUnary(ComplexParser.ExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprUnary}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprUnary(ComplexParser.ExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDiv(ComplexParser.ExprMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDiv(ComplexParser.ExprMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprImag}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprImag(ComplexParser.ExprImagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprImag}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprImag(ComplexParser.ExprImagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprReal}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprReal(ComplexParser.ExprRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprReal}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprReal(ComplexParser.ExprRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(ComplexParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link ComplexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(ComplexParser.ExprIDContext ctx);
}