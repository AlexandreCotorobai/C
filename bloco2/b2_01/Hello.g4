grammar Hello;
//Parte com esteroides
program:
        stat * EOF
    ;
stat:
        greetings ? NEWLINE
    ;

greetings : 'hello' ID+  #Hello
            |'bye' ID+ #BYE
            ;
ID : [a-zA-Z]+ ;
NEWLINE:'\r'? '\n' ;
WS : [ \t\r\n]+ -> skip;

