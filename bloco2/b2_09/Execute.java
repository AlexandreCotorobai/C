import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalcFracMainBaseVisitor<Fraction> {

   HashMap<String, Fraction> memory = new HashMap<>();
   
   @Override public Fraction visitProgram(CalcFracMainParser.ProgramContext ctx) {
      Fraction res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Fraction visitLine(CalcFracMainParser.LineContext ctx) {
      Fraction res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Fraction visitAssignment(CalcFracMainParser.AssignmentContext ctx) {
      Fraction res = visit(ctx.expr());
      memory.put(ctx.ID().getText(), res);

      return visitChildren(ctx);
   }

   @Override public Fraction visitPrint(CalcFracMainParser.PrintContext ctx) {
      Fraction res = visit(ctx.expr());
      if(res != null) {
         System.out.println(res);
      }
      return visitChildren(ctx);
   }

   @Override public Fraction visitExprFrac(CalcFracMainParser.ExprFracContext ctx) {
      Fraction res = new Fraction(Integer.parseInt(ctx.Integer(0).getText()), Integer.parseInt(ctx.Integer(1).getText()));
      return res;

   }

   @Override public Fraction visitExprAddSub(CalcFracMainParser.ExprAddSubContext ctx) {
      Fraction fract1 = visit(ctx.expr(0));
      Fraction fract2 = visit(ctx.expr(1));
      char op = ctx.op.getText().charAt(0);
      switch (op) {
         case '+':
            fract1.add(fract2);
         case '-':
            fract1.sub(fract2);
      }
      return fract1;
   }

   @Override public Fraction visitExprRead(CalcFracMainParser.ExprReadContext ctx) {
          // get input from user
      System.out.println(ctx.InputMsg().getText());
      String input = System.console().readLine();
      Fraction res = null;
      if (input.contains("/")) {
         String[] parts = input.split("/");
         res = new Fraction(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
      } else {
         res = new Fraction(Integer.parseInt(input), 1);
      }
      return res;
   }

   @Override public Fraction visitExprMultDivPow(CalcFracMainParser.ExprMultDivPowContext ctx) {
      Fraction fract1 = visit(ctx.expr(0));
      Fraction fract2 = visit(ctx.expr(1));
      char op = ctx.op.getText().charAt(0);
      switch (op) {
         case '*':
            fract1.mul(fract2);
            break;
         case ':':
            fract1.div(fract2);
            break;
         case '^':
            fract1.pow(fract2);
            break;
      }
      return fract1;
      //return res;
   }

   @Override public Fraction visitExprParent(CalcFracMainParser.ExprParentContext ctx) {
      Fraction res = null;
      return visitChildren(ctx);
   }

   @Override public Fraction visitExprRedux(CalcFracMainParser.ExprReduxContext ctx) {
      Fraction res = visit(ctx.expr());
      res.reduce();
      return res;
   }

   @Override public Fraction visitExprInteger(CalcFracMainParser.ExprIntegerContext ctx) {
      Fraction res = new Fraction(Integer.parseInt(ctx.getText()), 1);
      return res;
      // return visitChildren(ctx);
   }

   @Override public Fraction visitExprID(CalcFracMainParser.ExprIDContext ctx) {
      Fraction res = memory.get(ctx.ID().getText());
      // return visitChildren(ctx);
      return res;
   }
}
