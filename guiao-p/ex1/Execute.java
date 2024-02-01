import java.util.*;
import java.io.*;

@SuppressWarnings("CheckReturnValue")
public class Execute extends StrLangBaseVisitor<String> {

   private HashMap<String, String> assignments = new HashMap<>();

   private static Scanner scan = new Scanner(System.in);

   @Override
   public String visitPrintStat(StrLangParser.PrintStatContext ctx) {
      String res = visit(ctx.expr());
      if (res == null) {
         System.err.println("ERROR ID");
         System.exit(0);
      }
      System.out.println(res);

      return res;
   }

   @Override
   public String visitAssignStat(StrLangParser.AssignStatContext ctx) {
      String ID = ctx.ID().getText();
      String expr = visit(ctx.expr());

      if (ID == null | expr == null) {
         System.err.println("ERROR ID");
         System.exit(0);
      }

      assignments.put(ID, expr);

      return expr;
      // return res;
   }

   @Override
   public String visitExprString(StrLangParser.ExprStringContext ctx) {
      String res = ctx.STRING().getText();
      res = res.substring(1, res.length() - 1);
      return res;
      // return res;
   }

   @Override
   public String visitExprID(StrLangParser.ExprIDContext ctx) {
      String res = ctx.ID().getText();

      if (res == null) {
         System.err.println("ERROR");
         System.exit(0);
      }

      String value = assignments.get(res);

      return value;
      // return res;
   }

   @Override
   public String visitExprInput(StrLangParser.ExprInputContext ctx) {
      String prompt = visit(ctx.expr());

      if (prompt == null) {
         System.err.println("ERROR ID");
         System.exit(0);
      }

      System.out.print(prompt);

      String in = scan.nextLine();

      return in;
      // return res;
   }

   @Override
   public String visitExprAdd(StrLangParser.ExprAddContext ctx) {
      String res = null;

      String e1 = visit(ctx.expr(0));
      String e2 = visit(ctx.expr(1));

      if (e1 == null || e2 == null) {
         System.err.println("ERROR ID");
         System.exit(0);
      }

      res = e1 + e2;

      return res;
      // return res;
   }

   @Override
   public String visitExprSub(StrLangParser.ExprSubContext ctx) {
      String res = null;

      String e1 = visit(ctx.expr(0));
      String e2 = visit(ctx.expr(1));

      if (e1 == null | e2 == null) {
         System.err.println("ERROR ID");
         System.exit(0);
      }

      res = e1.replace(e2, "");

      return res;
      // return res;
   }

   @Override
   public String visitExprTrim(StrLangParser.ExprTrimContext ctx) {
      String res = null;

      String e = visit(ctx.expr());

      if (e == null) {
         System.err.println("ERROR ID");
         System.exit(0);
      }

      res = e.trim();

      return res;
      // return res;
   }

   @Override
   public String visitExprParen(StrLangParser.ExprParenContext ctx) {
      String res = null;

      res = visit(ctx.expr());

      if (res == null) {
         System.err.println("ERROR ID");
         System.exit(0);
      }

      return res;
      // return res;
   }

   @Override
   public String visitExprChange(StrLangParser.ExprChangeContext ctx) {
      String res = null;

      String e1 = visit(ctx.expr(0));
      String e2 = visit(ctx.expr(1));
      String e3 = visit(ctx.expr(2));

      if (e1 == null | e2 == null | e3 == null) {
         System.err.println("ERROR ID");
         System.exit(0);
      }
      res = e1.replace(e2, e3);

      return res;
      // return res;
   }
}
