grammar Calculator;

program:
    stat * EOF
    ;

stat:
    expr ? NEWLINE
    ;

expr:
    ID                              #ExprID
    | ID '=' expr                     #ExprAssignment
    | expr op=('!+'|'!-')             #ExprUnary
    | expr expr op=('*'|'/'| 'expr')  #ExprMultDivMod
    | expr expr op=('+'|'-')        #ExprAddSub
    | Integer                       #ExprInteger
    | '(' expr ')'                  #ExprParens
    ;

Integer: [0-9]+; //implement with long integers
ID: [a-zA-Z]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
