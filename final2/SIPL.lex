

import java.io.FileInputStream;
import java_cup.runtime.Symbol;


/*
class SIPL {

    public static void main(String argv[]) throws java.io.IOException {
		FileInputStream in = null;

	    try {
	        in = new FileInputStream("SIPLtest.txt");
		}
		finally {}
		Yylex yy = new Yylex(in);
		Yytoken t;
		while ((t = yy.yylex()) != null)
		    System.out.println(t.getVal());
    }

}
*/

%%
%cup
%state DUMMY
%line
%char
%notunix

%%
<YYINITIAL> [\ \r\n\t\b] {//System.out.println("whitespace found");
//whitespace is ignored
}

<YYINITIAL> "(" {
		return new Symbol(sym.LPAREN);
}

<YYINITIAL> ")" {
		return new Symbol(sym.RPAREN);

}
"-" {
     return new Symbol(sym.MINUS);
}
"+" {
     return new Symbol(sym.PLUS);
     
}
"*" {
	
	return new Symbol(sym.MULTIPLY);
}
"/" {
	
	return new Symbol(sym.DIVIDE);
	
}
":=" {
	
	return new Symbol(sym.EQ);
	
}

"<" {
	
	return new Symbol(sym.LTHAN);
}

"<=" {return new Symbol(sym.LTHANEQ);}
">" {return new Symbol(sym.LTHAN);}
">=" {return new Symbol(sym.GTHANEQ);}
"==" {return new Symbol(sym.EQEQ);}
"!=" {return new Symbol(sym.NOTEQ);} 
";" {return new Symbol(sym.SEMI);}

"true" {return new Symbol(sym.TRUE);}
"false" {return new Symbol(sym.FALSE);}

"and" {return new Symbol(sym.AND);}
"begin" {return new Symbol(sym.BEGIN);}
"do" {return new Symbol(sym.DO);}
"else" {return new Symbol(sym.ELSE);}
"end" {return new Symbol(sym.END);}
"if" {return new Symbol(sym.IF);}
"input" {return new Symbol(sym.INPUT);}
"not" {return new Symbol(sym.NOT);}
"or" {return new Symbol(sym.OR);}
"output" {return new Symbol(sym.OUTPUT);}
"then" {return new Symbol(sym.THEN);}
"var" {return new Symbol(sym.VAR);}
"while" {return new Symbol(sym.WHILE);}

<DUMMY> . {/*next pattern matches identifiers*/}
[_a-zA-Z][a-zA-Z0-9]* {return new Symbol(sym.IDEN,yytext());}
<DUMMY> . {/*next pattern matches integers*/}
[0-9]+ {return new Symbol(sym.NUMBER,yytext());}
<DUMMY> . {/*next pattern matches line comments*/}
(//[^\n]*\n) {/*comments are ignored*/}
. { return new Symbol( sym.error ); }

