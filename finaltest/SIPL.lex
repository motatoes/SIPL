

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

<YYINITIAL> "(" {System.out.println("left bracet found");
		return new Symbol(sym.LPAREN);
}

<YYINITIAL> ")" {System.out.println("right bracet found");
		return new Symbol(sym.RPAREN);

}
"-" {System.out.println("minus found");
     return new Symbol(sym.MINUS);
}
"+" {System.out.println("plus found");
     return new Symbol(sym.PLUS);
     
}
"*" {
	System.out.println("multiply found");
	return new Symbol(sym.MULTIPLY);
}
"/" {
	System.out.println("divide found");
	return new Symbol(sym.DIVIDE);
	
}
":=" {
	System.out.println("equals found");
	return new Symbol(sym.EQ);
	
}

"<" {
	System.out.println("less than found");
	return new Symbol(sym.LTHAN);
}

"<=" {System.out.println("less than or equals found");return new Symbol(sym.LTHANEQ);}
">" {System.out.println("greater than found");return new Symbol(sym.LTHAN);}
">=" {System.out.println("greater than or equals found");return new Symbol(sym.GTHANEQ);}
"==" {System.out.println("equalequal found");return new Symbol(sym.EQEQ);}
"!=" {System.out.println("notequals found");return new Symbol(sym.NOTEQ);} 
";" {System.out.println("semicolon found");return new Symbol(sym.SEMI);}

"true" {System.out.println("true found");return new Symbol(sym.TRUE);}
"false" {System.out.println("false found");return new Symbol(sym.FALSE);}

"and" {System.out.println("and found");return new Symbol(sym.AND);}
"begin" {System.out.println("begin found");return new Symbol(sym.BEGIN);}
"do" {System.out.println("do found");return new Symbol(sym.DO);}
"else" {System.out.println("else found");return new Symbol(sym.ELSE);}
"end" {System.out.println("end found");return new Symbol(sym.END);}
"if" {System.out.println("if found");return new Symbol(sym.IF);}
"input" {System.out.println("input found");return new Symbol(sym.INPUT);}
"not" {System.out.println("not found");return new Symbol(sym.NOT);}
"or" {System.out.println("or found");return new Symbol(sym.OR);}
"output" {System.out.println("output found");return new Symbol(sym.OUTPUT);}
"then" {System.out.println("then found");return new Symbol(sym.THEN);}
"var" {System.out.println("var found");return new Symbol(sym.VAR);}
"while" {System.out.println("while found");return new Symbol(sym.WHILE);}

<DUMMY> . {/*next pattern matches identifiers*/}
[_a-zA-Z][a-zA-Z0-9]* {System.out.println("identifier found");return new Symbol(sym.IDEN,yytext());}
<DUMMY> . {/*next pattern matches integers*/}
[0-9]+ {System.out.println("integer found");return new Symbol(sym.NUMBER,yytext());}
<DUMMY> . {/*next pattern matches line comments*/}
(//[^\n]*\n) {/*comments are ignored*/}
. { return new Symbol( sym.error ); }
