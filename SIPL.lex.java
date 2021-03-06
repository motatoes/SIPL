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


class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int DUMMY = 1;
	private final int yy_state_dtrans[] = {
		0,
		41
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NOT_ACCEPT,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NOT_ACCEPT,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"32:8,33:2,1,32:2,37,32:18,33,12,32:6,2,3,6,5,32,4,32,7,35:10,8,13,10,9,11,3" +
"2:2,36:26,32:4,34,32,19,24,36,23,17,18,25,29,26,36:2,20,36,22,27,28,36,15,2" +
"1,14,16,30,31,36:3,32:5,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,95,
"0,1:7,2,3,4,5,1,6,7,1:5,8:3,1,8:12,1,9,10,11,3,12,13,14,10,1,15,13,16,6,17," +
"18,19,20,21,22,23,11,24,14,25,15,26,27,28,7,29,30,31,18,8,20,32,22,33,27,34" +
",35,36,37,38,39,40,41,42,43,44,45,46,47,48,8,32,33,34")[0];

	private int yy_nxt[][] = unpackFromString(49,38,
"1,2,3,4,5,6,7,8,9,38,10,11,42,12,13,91:2,69,92,71,91:2,73,39,93,91,43,46,91" +
":2,75,94,45,2,91,14,91,2,-1:45,37,-1:39,15,-1:37,17,-1:37,18,-1:42,91,77,91" +
":13,78,91:2,-1:3,91:2,-1:36,14,-1:16,91:18,-1:3,91:2,-1:2,23,37:36,-1:9,16," +
"-1:42,91:13,20,91:4,-1:3,91:2,-1,1,-1,36:2,5,6,7,8,40,44,10,11,47,12,49,70:" +
"2,51,72,53,70:2,55,57,74,70,59,61,70:2,63,76,36:2,70,65,70,-1:10,19,-1:42,9" +
"1:4,21,91:3,82,91:9,-1:3,91:2,-1:15,91,22,83,91:15,-1:3,91:2,-1:15,91:9,24," +
"91:8,-1:3,91:2,-1:15,91:9,25,91:8,-1:3,91:2,-1:15,91:6,79,91,48,91:9,-1:3,9" +
"1:2,-1:15,26,91:17,-1:3,91:2,-1:15,91:8,50,91:9,-1:3,91:2,-1:15,91,27,91:16" +
",-1:3,91:2,-1:15,91:13,52,91:4,-1:3,91:2,-1:15,91:3,28,91:14,-1:3,91:2,-1:1" +
"5,91:8,29,91:9,-1:3,91:2,-1:15,91:3,30,91:14,-1:3,91:2,-1:15,91:3,31,91:14," +
"-1:3,91:2,-1:15,91:5,54,91:12,-1:3,91:2,-1:15,91:8,32,91:9,-1:3,91:2,-1:15," +
"33,91:17,-1:3,91:2,-1:15,91:3,34,91:14,-1:3,91:2,-1:15,35,91:17,-1:3,91:2,-" +
"1:15,91:5,80,91:12,-1:3,91:2,-1:15,91:3,81,91:14,-1:3,91:2,-1:15,91:15,84,9" +
"1:2,-1:3,91:2,-1:15,91:2,56,91:15,-1:3,91:2,-1:15,91:3,58,91:14,-1:3,91:2,-" +
"1:15,91:7,60,91:10,-1:3,91:2,-1:15,91:6,85,91:11,-1:3,91:2,-1:15,91:11,86,9" +
"1:6,-1:3,91:2,-1:15,91:14,87,91:3,-1:3,91:2,-1:15,88,91:17,-1:3,91:2,-1:15," +
"91:12,89,91:5,-1:3,91:2,-1:15,91:7,62,91:10,-1:3,91:2,-1:15,91:12,64,91:5,-" +
"1:3,91:2,-1:15,91:2,66,91:15,-1:3,91:2,-1:15,91:14,90,91:3,-1:3,91:2,-1:15," +
"91:6,67,91:11,-1:3,91:2,-1:15,91:2,68,91:15,-1:3,91:2,-1");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{//System.out.println("whitespace found");
//whitespace is ignored
}
					case -3:
						break;
					case 3:
						{
		return new Symbol(sym.LPAREN);
}
					case -4:
						break;
					case 4:
						{
		return new Symbol(sym.RPAREN);
}
					case -5:
						break;
					case 5:
						{
     return new Symbol(sym.MINUS);
}
					case -6:
						break;
					case 6:
						{
     return new Symbol(sym.PLUS);
}
					case -7:
						break;
					case 7:
						{
	return new Symbol(sym.MULTIPLY);
}
					case -8:
						break;
					case 8:
						{
	return new Symbol(sym.DIVIDE);
}
					case -9:
						break;
					case 9:
						{ return new Symbol( sym.error ); }
					case -10:
						break;
					case 10:
						{
	return new Symbol(sym.LTHAN);
}
					case -11:
						break;
					case 11:
						{return new Symbol(sym.LTHAN);}
					case -12:
						break;
					case 12:
						{return new Symbol(sym.SEMI);}
					case -13:
						break;
					case 13:
						{return new Symbol(sym.IDEN,yytext());}
					case -14:
						break;
					case 14:
						{return new Symbol(sym.NUMBER,yytext());}
					case -15:
						break;
					case 15:
						{
	return new Symbol(sym.EQ);
}
					case -16:
						break;
					case 16:
						{return new Symbol(sym.EQEQ);}
					case -17:
						break;
					case 17:
						{return new Symbol(sym.LTHANEQ);}
					case -18:
						break;
					case 18:
						{return new Symbol(sym.GTHANEQ);}
					case -19:
						break;
					case 19:
						{return new Symbol(sym.NOTEQ);}
					case -20:
						break;
					case 20:
						{return new Symbol(sym.DO);}
					case -21:
						break;
					case 21:
						{return new Symbol(sym.IF);}
					case -22:
						break;
					case 22:
						{return new Symbol(sym.OR);}
					case -23:
						break;
					case 23:
						{/*comments are ignored*/}
					case -24:
						break;
					case 24:
						{return new Symbol(sym.END);}
					case -25:
						break;
					case 25:
						{return new Symbol(sym.AND);}
					case -26:
						break;
					case 26:
						{return new Symbol(sym.NOT);}
					case -27:
						break;
					case 27:
						{return new Symbol(sym.VAR);}
					case -28:
						break;
					case 28:
						{return new Symbol(sym.TRUE);}
					case -29:
						break;
					case 29:
						{return new Symbol(sym.THEN);}
					case -30:
						break;
					case 30:
						{return new Symbol(sym.ELSE);}
					case -31:
						break;
					case 31:
						{return new Symbol(sym.FALSE);}
					case -32:
						break;
					case 32:
						{return new Symbol(sym.BEGIN);}
					case -33:
						break;
					case 33:
						{return new Symbol(sym.INPUT);}
					case -34:
						break;
					case 34:
						{return new Symbol(sym.WHILE);}
					case -35:
						break;
					case 35:
						{return new Symbol(sym.OUTPUT);}
					case -36:
						break;
					case 36:
						{/*next pattern matches identifiers*/}
					case -37:
						break;
					case 38:
						{ return new Symbol( sym.error ); }
					case -38:
						break;
					case 39:
						{return new Symbol(sym.IDEN,yytext());}
					case -39:
						break;
					case 40:
						{/*next pattern matches identifiers*/}
					case -40:
						break;
					case 42:
						{ return new Symbol( sym.error ); }
					case -41:
						break;
					case 43:
						{return new Symbol(sym.IDEN,yytext());}
					case -42:
						break;
					case 44:
						{/*next pattern matches identifiers*/}
					case -43:
						break;
					case 45:
						{ return new Symbol( sym.error ); }
					case -44:
						break;
					case 46:
						{return new Symbol(sym.IDEN,yytext());}
					case -45:
						break;
					case 47:
						{/*next pattern matches identifiers*/}
					case -46:
						break;
					case 48:
						{return new Symbol(sym.IDEN,yytext());}
					case -47:
						break;
					case 49:
						{/*next pattern matches identifiers*/}
					case -48:
						break;
					case 50:
						{return new Symbol(sym.IDEN,yytext());}
					case -49:
						break;
					case 51:
						{/*next pattern matches identifiers*/}
					case -50:
						break;
					case 52:
						{return new Symbol(sym.IDEN,yytext());}
					case -51:
						break;
					case 53:
						{/*next pattern matches identifiers*/}
					case -52:
						break;
					case 54:
						{return new Symbol(sym.IDEN,yytext());}
					case -53:
						break;
					case 55:
						{/*next pattern matches identifiers*/}
					case -54:
						break;
					case 56:
						{return new Symbol(sym.IDEN,yytext());}
					case -55:
						break;
					case 57:
						{/*next pattern matches identifiers*/}
					case -56:
						break;
					case 58:
						{return new Symbol(sym.IDEN,yytext());}
					case -57:
						break;
					case 59:
						{/*next pattern matches identifiers*/}
					case -58:
						break;
					case 60:
						{return new Symbol(sym.IDEN,yytext());}
					case -59:
						break;
					case 61:
						{/*next pattern matches identifiers*/}
					case -60:
						break;
					case 62:
						{return new Symbol(sym.IDEN,yytext());}
					case -61:
						break;
					case 63:
						{/*next pattern matches identifiers*/}
					case -62:
						break;
					case 64:
						{return new Symbol(sym.IDEN,yytext());}
					case -63:
						break;
					case 65:
						{/*next pattern matches identifiers*/}
					case -64:
						break;
					case 66:
						{return new Symbol(sym.IDEN,yytext());}
					case -65:
						break;
					case 67:
						{return new Symbol(sym.IDEN,yytext());}
					case -66:
						break;
					case 68:
						{return new Symbol(sym.IDEN,yytext());}
					case -67:
						break;
					case 69:
						{return new Symbol(sym.IDEN,yytext());}
					case -68:
						break;
					case 70:
						{/*next pattern matches identifiers*/}
					case -69:
						break;
					case 71:
						{return new Symbol(sym.IDEN,yytext());}
					case -70:
						break;
					case 72:
						{/*next pattern matches identifiers*/}
					case -71:
						break;
					case 73:
						{return new Symbol(sym.IDEN,yytext());}
					case -72:
						break;
					case 74:
						{/*next pattern matches identifiers*/}
					case -73:
						break;
					case 75:
						{return new Symbol(sym.IDEN,yytext());}
					case -74:
						break;
					case 76:
						{/*next pattern matches identifiers*/}
					case -75:
						break;
					case 77:
						{return new Symbol(sym.IDEN,yytext());}
					case -76:
						break;
					case 78:
						{return new Symbol(sym.IDEN,yytext());}
					case -77:
						break;
					case 79:
						{return new Symbol(sym.IDEN,yytext());}
					case -78:
						break;
					case 80:
						{return new Symbol(sym.IDEN,yytext());}
					case -79:
						break;
					case 81:
						{return new Symbol(sym.IDEN,yytext());}
					case -80:
						break;
					case 82:
						{return new Symbol(sym.IDEN,yytext());}
					case -81:
						break;
					case 83:
						{return new Symbol(sym.IDEN,yytext());}
					case -82:
						break;
					case 84:
						{return new Symbol(sym.IDEN,yytext());}
					case -83:
						break;
					case 85:
						{return new Symbol(sym.IDEN,yytext());}
					case -84:
						break;
					case 86:
						{return new Symbol(sym.IDEN,yytext());}
					case -85:
						break;
					case 87:
						{return new Symbol(sym.IDEN,yytext());}
					case -86:
						break;
					case 88:
						{return new Symbol(sym.IDEN,yytext());}
					case -87:
						break;
					case 89:
						{return new Symbol(sym.IDEN,yytext());}
					case -88:
						break;
					case 90:
						{return new Symbol(sym.IDEN,yytext());}
					case -89:
						break;
					case 91:
						{return new Symbol(sym.IDEN,yytext());}
					case -90:
						break;
					case 92:
						{return new Symbol(sym.IDEN,yytext());}
					case -91:
						break;
					case 93:
						{return new Symbol(sym.IDEN,yytext());}
					case -92:
						break;
					case 94:
						{return new Symbol(sym.IDEN,yytext());}
					case -93:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
