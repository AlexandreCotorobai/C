
import java.util.*;

@SuppressWarnings("CheckReturnValue")
public class Execute extends ComplexBaseVisitor<Complex> {

   private HashMap<String,Complex> map = new HashMap<>();


   @Override public Complex visitPrint(ComplexParser.PrintContext ctx) {
      Complex res = visit(ctx.expr());

      System.out.println(res.toString());
      return res;
      //return res;
   }

   @Override public Complex visitAssign(ComplexParser.AssignContext ctx) {
      Complex expr = visit(ctx.expr());
      String id = ctx.ID().getText();

      map.put(id, expr);

      return expr;
   }

   @Override public Complex visitExprAddSub(ComplexParser.ExprAddSubContext ctx) {
      Complex res = null;

      String op = ctx.op.getText();
      Complex e1 = visit(ctx.expr(0));
      Complex e2 = visit(ctx.expr(1));


      switch(op){
         case "+":
            res = e1.sum(e2.real(), e2.im());
            break;
         case "-":
            res = e1.sub(e2.real(), e2.im());
            break;            
      }

      return res;
      //return res;
   }

   @Override public Complex visitExprParen(ComplexParser.ExprParenContext ctx) {
      Complex res = null;

      return visit(ctx.expr());
      //return res;
   }

   @Override public Complex visitExprMultDiv(ComplexParser.ExprMultDivContext ctx) {
      Complex res = null;

      String op = ctx.op.getText();
      Complex e1 = visit(ctx.expr(0));
      Complex e2 = visit(ctx.expr(1));

      switch(op){
         case "*":
            res = e1.mult(e2.real(), e2.im());
            break;
         case ":":
            // res = e1.div(e2.real(), e2.im());
            break;            
      }

      return res;
      //return res;
   }

   @Override public Complex visitExprImag(ComplexParser.ExprImagContext ctx) {
      Complex res = null;

      // String i = ctx.INTEGER().getText();
      // Complex text = visit(ctx.INTEGER());
      int i;

      if (ctx.INTEGER() == null){
         i = 1;
      }else{
         i = Integer.parseInt(ctx.INTEGER().getText());
      }

      return new Complex(0, i);
      //return res;
   }

   @Override public Complex visitExprReal(ComplexParser.ExprRealContext ctx) {
      Complex res = null;

      String r = ctx.INTEGER().getText();

      return new Complex(Integer.parseInt(r), 0);
   }

   @Override public Complex visitExprID(ComplexParser.ExprIDContext ctx) {
      Complex res = null;
      String id = ctx.ID().getText();

      res = map.get(id);
      return res;
   }
}
