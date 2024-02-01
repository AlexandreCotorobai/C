grammar FracLang;

program: (command? ';')* EOF;

command: display | assignment;

display: 'display' expr;

assignment: ID '<=' expr;

expr:
    op=('+'|'-') expr #ExprUnary
    | expr op=('*'|':') expr #ExprMultDiv
    | expr op=('+'|'-') expr #ExprAddSub
    | 'reduce' expr #ExprReduce
    | '(' expr ')'      #ExprParen
    | 'read' STRING #ExprString
    | Fraction   #ExprFraction
    | ID        #ExprID
    ;


ID: [a-z]+;
Fraction: [0-9]+ ('/' [0-9]+)?;
STRING: '"' .*? '"';
WS: [ \t\r\n]+ -> skip;
Comment: '--' .*? '\n' -> skip;
Error: .;
