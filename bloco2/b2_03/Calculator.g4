grammar Calculator;

program:
    stat * EOF
    ;

stat:
    expr ? NEWLINE
    ;

expr:
    op=('+'|'-') expr               #ExprUnary
    | expr op=('*'|'/'| '%') expr   #ExprMultDivMod
    | expr op=('+'|'-') expr        #ExprAddSub
    | Integer                       #ExprInteger
    | '(' expr ')'                  #ExprParens
    ; 

Integer: [0-9]+; //implement with long integers
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
