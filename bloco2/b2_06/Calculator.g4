grammar Calculator;

program:
    stat * EOF
    ;

stat:
    expr ? NEWLINE
    ;

expr:
    ID                            #ExprID
    | ID '=' expr                     #ExprAssignment
    | op=('+'|'-') expr               #ExprUnary
    | expr op=('*'|'/'| 'expr') expr  #ExprMultDivMod
    | expr op=('+'|'-') expr        #ExprAddSub
    | Integer                       #ExprInteger
    | '(' expr ')'                  #ExprParens
    ;

Integer: [0-9]+; //implement with long integers
ID: [a-zA-Z]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
