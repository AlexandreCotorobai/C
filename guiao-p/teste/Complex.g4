grammar Complex;

program: (stat? ';')* EOF;

stat: assign | print;

print: 'output' expr;

assign: expr '=>' ID;

expr: 
    op=('+'|'-') expr #ExprUnary
    | expr op=('*'|':') expr  #ExprMultDiv
    | expr op=('+'|'-') expr  #ExprAddSub
    | '(' expr ')' #ExprParen
    | INTEGER? 'i' #ExprImag
    | INTEGER #ExprReal
    | ID #ExprID
    ;




ID: [a-zA-Z][a-zA-Z0-9]*;
INTEGER: [0-9]+;
WS: [ \n\t\r]+ -> skip;
Comment: '##' .*? '\n' -> skip;
// Error: .;

