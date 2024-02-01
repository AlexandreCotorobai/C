grammar StrLang;

program: stat* EOF;

stat: printStat
    | assignStat
    ;

printStat: 'print' expr;

assignStat: ID ':' expr;

expr:
    'input(' expr ')' #exprInput
    | expr '+' expr #ExprAdd
    | expr '-' expr #ExprSub
    | 'trim' expr #ExprTrim
    | '(' expr ')' #ExprParen
    | expr '/' expr '/' expr #ExprChange
    | STRING #exprString
    | ID #exprID
    ;


ID: [a-zA-Z][a-zA-Z0-9]*;
STRING: '"' .*? '"';
WS: [ \t\r\n]+ -> skip;
Comment: '//' .*? '\n' -> skip;
// Error: .;
