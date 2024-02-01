@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitHello(HelloParser.HelloContext ctx) {
      String res = "Olá ";// + ctx.ID().getText();
      for (int i = 0; i < ctx.ID().size(); i++) {
         res += ctx.ID(i).getText() + " ";
      }
		System.out.println(res);
		return visitChildren(ctx);
   }

   @Override public String visitBYE(HelloParser.BYEContext ctx) {
      String res = "Bye ";// + ctx.ID().getText();
      for (int i = 0; i < ctx.ID().size(); i++) {
         res += ctx.ID(i).getText() + " ";
      }
		System.out.println(res);
		return visitChildren(ctx);
   }
}
