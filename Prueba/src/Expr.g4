grammar Expr;
expr: INT | expr op=('-'|'+') expr;
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;