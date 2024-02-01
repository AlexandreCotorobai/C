import java.util.*;

import org.antlr.v4.parse.ANTLRParser.exceptionGroup_return;
import org.stringtemplate.v4.compiler.STParser.exprNoComma_return;

@SuppressWarnings("CheckReturnValue")
public class Execute extends FracLangBaseVisitor<Fraction> {

   private HashMap<String, Fraction> variables = new HashMap<>();
   private static Scanner in = new Scanner(System.in);

   @Override
   public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Fraction res = visit(ctx.expr());

      if (res != null) {
         System.out.println(res);
      }
      return res;
   }

   @Override
   public Fraction visitAssignment(FracLangParser.AssignmentContext ctx) {
      Fraction res = visit(ctx.expr());
      String id = ctx.ID().getText();

      if (res != null) {
         variables.put(id, res);
      }
      return res;
   }

   @Override
   public Fraction visitExprFraction(FracLangParser.ExprFractionContext ctx) {
      String frac = ctx.Fraction().getText();
      Fraction res = new Fraction(frac);
      if (res.error()) {
         System.err.println("ERRO FRACAO FUDIDA");
      }

      return res;
   }

   @Override
   public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
      Fraction res = variables.get(ctx.ID().getText());
      return res;
   }

   @Override
   public Fraction visitExprUnary(FracLangParser.ExprUnaryContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null) {
         if ("-".equals(ctx.op.getText())) {
            res = new Fraction(-res.num(), res.den());
         }
      }
      return res;
   }

   @Override
   public Fraction visitExprMultDiv(FracLangParser.ExprMultDivContext ctx) {
      Fraction res = null;
      Fraction e1 = visit(ctx.expr(0));
      Fraction e2 = visit(ctx.expr(1));

      if (e1 != null && e2 != null) {
         switch (ctx.op.getText()) {
            case "*":
               res = new Fraction(e1.num() * e2.num(), e1.num() * e1.den());
               break;
            case ":":
               res = new Fraction(e1.num() * e2.den(), e1.den() * e2.num());
               break;
         }
      }
      return res;
   }

   @Override
   public Fraction visitExprAddSub(FracLangParser.ExprAddSubContext ctx) {
      Fraction res = null;
      Fraction e1 = visit(ctx.expr(0));
      Fraction e2 = visit(ctx.expr(1));

      if (e1 != null && e2 != null) {
         switch (ctx.op.getText()) {
            case "+":
               res = new Fraction(e1.num() * e2.den() + e2.num() * e1.den(), e1.den() * e2.den());
               break;
            case "-":
               res = new Fraction(e1.num() * e2.den() - e2.num() * e1.den(), e1.den() * e2.den());
               break;
            default:
               break;
         }
      }
      return res;
   }

   @Override
   public Fraction visitExprParen(FracLangParser.ExprParenContext ctx) {
      Fraction res = null;
      res = visit(ctx.expr());
      return res;
   }

   @Override
   public Fraction visitExprString(FracLangParser.ExprStringContext ctx) {
      Fraction res = null;
      String prompt = ctx.STRING().getText();
      prompt = prompt.substring(1, prompt.length() - 1);
      System.out.println(prompt + ": ");

      String frac = in.nextLine();

      res = new Fraction(frac);

      return res;
   }

   @Override
   public Fraction visitExprReduce(FracLangParser.ExprReduceContext ctx) {
      Fraction res = null;
      res = visit(ctx.expr());
      if (res != null){
         res = res.reduce();
      }
      return res;
   }

}
