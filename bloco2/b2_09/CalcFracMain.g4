grammar CalcFracMain;

program:
    line * EOF
    ;

line:
    (print|assignment) ';' ? NEWLINE
    ;

assignment:
    expr '->' ID
    ;

print:
    'print' expr
    ;

expr:
    // Integer '/' Integer             #ExprFrac
    // | 'reduce' expr                 #ExprRedux
    // | expr op=('*'|':'|'^') expr    #ExprMultDivPow
    // | expr op=('+'|'-') expr        #ExprAddSub
    // | Integer                       #ExprInteger
    // | '(' expr ')'                  #ExprParent
    // | ID                            #ExprID
    // | 'read' InputMsg               #ExprRead
    // ;
    op=('+'|'-') expr                #ExprAddSub
    | 'reduce' expr                   #ExprRedux
    | '(' expr ')' '^' expr                   #ExprPow
    | '(' expr ')'                   #ExprParent
    | expr op=(':'|'*') expr                   #ExprMultDiv
    | expr op=('+'|'-') expr                   #ExprAddSub
    | Literal                         #ExprLiteral
    | Integer                         #ExprInteger
    | ID                              #ExprID
    ;

Integer: [0-9]+;
Literal: Integer '/' Integer;
InputMsg: '"' .*? '"';
ID: [a-zA-Z]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;