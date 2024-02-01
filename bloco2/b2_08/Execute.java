import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Long> {

   HashMap<String, Long> variables = new HashMap<String, Long>();
   
   @Override public Long visitProgram(CalculatorParser.ProgramContext ctx) {
      Long res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Long visitStat(CalculatorParser.StatContext ctx) {
      Long res = visit(ctx.expr());

      if(ctx.expr() == null){
         return null;
      }
      System.out.println(res);

      return res;
      //return res;
   }

   @Override public Long visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Long res = null;

      Long a = visit(ctx.expr(0));

      Long b = visit(ctx.expr(1));

      String op = ctx.op.getText();

      switch (op) {
         case "+":
            res = a + b;
            break;
         case "-":
            res = a - b;
            break;
         default:
            System.out.println("Operador inválido");
      }

      return res;
   }

   @Override public Long visitExprParens(CalculatorParser.ExprParensContext ctx) {
      Long res = null;

      res = visit(ctx.expr());

      return res;
   }

   @Override public Long visitExprUnary(CalculatorParser.ExprUnaryContext ctx) {
      Long res = null;
      
      String op = ctx.op.getText();
      if(op.equals("!-")){
         res = -visit(ctx.expr());
      }else{
         res = visit(ctx.expr());
      }

      return res;
   }

   @Override public Long visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      // Long res = null;
      return Long.parseLong(ctx.Integer().getText());
      //return res;
   }

   @Override public Long visitExprAssignment(CalculatorParser.ExprAssignmentContext ctx) {
      String b = ctx.ID().getText();
      Long a = visit(ctx.expr());

      // if(variables.containsKey(b)){
      //    variables.replace(b, a);
      // }else{
      variables.put(b, a);
      // }

      return a;
   }

   @Override public Long visitExprID(CalculatorParser.ExprIDContext ctx) {
      Long res = variables.get(ctx.ID().getText());
      return res;
   }

   @Override public Long visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Long res = null;

      Long a = visit(ctx.expr(0));
      
      Long b = visit(ctx.expr(1));

      String op = ctx.op.getText();

      switch (op) {
         case "*":
            res = a * b;
            break;
         case "/":
            res = a / b;
            break;
         case "%":
            res = a % b;
            break;
         default:
            System.out.println("Operador inválido");
      }

      return res;
   }
}
