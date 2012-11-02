import java.io.FileInputStream;
import java.cup.runime.Symbol;
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
		42
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
		/* 0 */ YY_NO_ANCHOR,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NOT_ACCEPT,
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
		/* 36 */ YY_NOT_ACCEPT,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NOT_ACCEPT,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NOT_ACCEPT,
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
		/* 91 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"32:8,33:2,1,32:2,1,32:18,33,12,32:6,2,3,6,5,32,4,32,7,35:10,8,13,10,9,11,32" +
":2,36:26,32:4,34,32,19,24,36,23,17,18,25,29,26,36:2,20,36,22,27,28,36,15,21" +
",14,16,30,31,36:3,32:5,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,92,
"0,1:3,2:2,1:2,3,4,5,1,6,2,1:5,7:15,1,8,9,10,3,11,12,9,13,14,11,15,6,16,17,1" +
"8,19,20,21,22,10,23,12,24,14,25,26,27,2,28,29,30,17,7,19,31,21,32,26,33,34," +
"35,36,37,38,39,40,41,42,43,44,45,46,47,7,31,32,33")[0];

	private int yy_nxt[][] = unpackFromString(48,37,
"1,35,2,3,4,5,6,7,8,36,9,10,39,11,12,88:2,66,89,68,88:2,70,37,90,88,40,43,88" +
":2,72,91,-1,35,88,13,88,-1:72,13,-1:10,14,-1:36,16,-1:36,17,-1:41,88,74,88:" +
"13,75,88:2,-1:3,88:2,-1:14,88:18,-1:3,88:2,-1,35,-1:31,35,-1:12,15,-1:41,88" +
":13,19,88:4,-1:3,88:2,-1:9,18,-1:41,88:4,20,88:3,79,88:9,-1:3,88:2,1,-1,34:" +
"2,4,5,6,7,38,41,9,10,44,11,46,67:2,48,69,50,67:2,52,54,71,67,56,58,67:2,60," +
"73,34:2,67,62,67,-1:14,88,21,80,88:15,-1:3,88:2,-1:14,88:9,22,88:8,-1:3,88:" +
"2,-1:14,88:9,23,88:8,-1:3,88:2,-1:14,88:6,76,88,45,88:9,-1:3,88:2,-1:14,24," +
"88:17,-1:3,88:2,-1:14,88:8,47,88:9,-1:3,88:2,-1:14,88,25,88:16,-1:3,88:2,-1" +
":14,88:13,49,88:4,-1:3,88:2,-1:14,88:3,26,88:14,-1:3,88:2,-1:14,88:8,27,88:" +
"9,-1:3,88:2,-1:14,88:3,28,88:14,-1:3,88:2,-1:14,88:3,29,88:14,-1:3,88:2,-1:" +
"14,88:5,51,88:12,-1:3,88:2,-1:14,88:8,30,88:9,-1:3,88:2,-1:14,31,88:17,-1:3" +
",88:2,-1:14,88:3,32,88:14,-1:3,88:2,-1:14,33,88:17,-1:3,88:2,-1:14,88:5,77," +
"88:12,-1:3,88:2,-1:14,88:3,78,88:14,-1:3,88:2,-1:14,88:15,81,88:2,-1:3,88:2" +
",-1:14,88:2,53,88:15,-1:3,88:2,-1:14,88:3,55,88:14,-1:3,88:2,-1:14,88:7,57," +
"88:10,-1:3,88:2,-1:14,88:6,82,88:11,-1:3,88:2,-1:14,88:11,83,88:6,-1:3,88:2" +
",-1:14,88:14,84,88:3,-1:3,88:2,-1:14,85,88:17,-1:3,88:2,-1:14,88:12,86,88:5" +
",-1:3,88:2,-1:14,88:7,59,88:10,-1:3,88:2,-1:14,88:12,61,88:5,-1:3,88:2,-1:1" +
"4,88:2,63,88:15,-1:3,88:2,-1:14,88:14,87,88:3,-1:3,88:2,-1:14,88:6,64,88:11" +
",-1:3,88:2,-1:14,88:2,65,88:15,-1:3,88:2");

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
					case 0:
						{System.out.println("whitespace found");}
					case -2:
						break;
					case 1:
						
					case -3:
						break;
					case 2:
						{System.out.println("right bracet found");
		return new Symbol(sym.LPAREN);
}
					case -4:
						break;
					case 3:
						{System.out.println("left bracet found");
		return new Symbol(sym.RPAREN);
}
					case -5:
						break;
					case 4:
						{System.out.println("minus found");
     return new Symbol(sym.MINUS);
}
					case -6:
						break;
					case 5:
						{System.out.println("plus found");
     return new Symbol(sym.PLUS);
}
					case -7:
						break;
					case 6:
						{
	System.out.println("multiply found");
	return new Symbol(sym.MULTIPLY);
}
					case -8:
						break;
					case 7:
						{
	System.out.println("divide found");
	return new Symbol(sym.SEMI);
}
					case -9:
						break;
					case 9:
						{
	System.out.println("less than found");
	return new Symbol(sym.SEMI);
}
					case -10:
						break;
					case 10:
						{System.out.println("greater than found");}
					case -11:
						break;
					case 11:
						{System.out.println("semicolon found");}
					case -12:
						break;
					case 12:
						{System.out.println("identifier found");}
					case -13:
						break;
					case 13:
						{System.out.println("integer found");}
					case -14:
						break;
					case 14:
						{
	System.out.println("equals found");
	return new Symbol(sym.EQ);
}
					case -15:
						break;
					case 15:
						{System.out.println("equalequal found");}
					case -16:
						break;
					case 16:
						{System.out.println("less than or equals found");}
					case -17:
						break;
					case 17:
						{System.out.println("greater than or equals found");}
					case -18:
						break;
					case 18:
						{System.out.println("notequals found");}
					case -19:
						break;
					case 19:
						{System.out.println("do found");}
					case -20:
						break;
					case 20:
						{System.out.println("if found");}
					case -21:
						break;
					case 21:
						{System.out.println("or found");}
					case -22:
						break;
					case 22:
						{System.out.println("end found");}
					case -23:
						break;
					case 23:
						{System.out.println("and found");}
					case -24:
						break;
					case 24:
						{System.out.println("not found");}
					case -25:
						break;
					case 25:
						{System.out.println("var found");}
					case -26:
						break;
					case 26:
						{System.out.println("true found");}
					case -27:
						break;
					case 27:
						{System.out.println("then found");}
					case -28:
						break;
					case 28:
						{System.out.println("else found");}
					case -29:
						break;
					case 29:
						{System.out.println("false found");}
					case -30:
						break;
					case 30:
						{System.out.println("begin found");}
					case -31:
						break;
					case 31:
						{System.out.println("input found");}
					case -32:
						break;
					case 32:
						{System.out.println("while found");}
					case -33:
						break;
					case 33:
						{System.out.println("output found");}
					case -34:
						break;
					case 34:
						{/*next pattern matches identifiers*/}
					case -35:
						break;
					case 35:
						{System.out.println("whitespace found");}
					case -36:
						break;
					case 37:
						{System.out.println("identifier found");}
					case -37:
						break;
					case 38:
						{/*next pattern matches identifiers*/}
					case -38:
						break;
					case 40:
						{System.out.println("identifier found");}
					case -39:
						break;
					case 41:
						{/*next pattern matches identifiers*/}
					case -40:
						break;
					case 43:
						{System.out.println("identifier found");}
					case -41:
						break;
					case 44:
						{/*next pattern matches identifiers*/}
					case -42:
						break;
					case 45:
						{System.out.println("identifier found");}
					case -43:
						break;
					case 46:
						{/*next pattern matches identifiers*/}
					case -44:
						break;
					case 47:
						{System.out.println("identifier found");}
					case -45:
						break;
					case 48:
						{/*next pattern matches identifiers*/}
					case -46:
						break;
					case 49:
						{System.out.println("identifier found");}
					case -47:
						break;
					case 50:
						{/*next pattern matches identifiers*/}
					case -48:
						break;
					case 51:
						{System.out.println("identifier found");}
					case -49:
						break;
					case 52:
						{/*next pattern matches identifiers*/}
					case -50:
						break;
					case 53:
						{System.out.println("identifier found");}
					case -51:
						break;
					case 54:
						{/*next pattern matches identifiers*/}
					case -52:
						break;
					case 55:
						{System.out.println("identifier found");}
					case -53:
						break;
					case 56:
						{/*next pattern matches identifiers*/}
					case -54:
						break;
					case 57:
						{System.out.println("identifier found");}
					case -55:
						break;
					case 58:
						{/*next pattern matches identifiers*/}
					case -56:
						break;
					case 59:
						{System.out.println("identifier found");}
					case -57:
						break;
					case 60:
						{/*next pattern matches identifiers*/}
					case -58:
						break;
					case 61:
						{System.out.println("identifier found");}
					case -59:
						break;
					case 62:
						{/*next pattern matches identifiers*/}
					case -60:
						break;
					case 63:
						{System.out.println("identifier found");}
					case -61:
						break;
					case 64:
						{System.out.println("identifier found");}
					case -62:
						break;
					case 65:
						{System.out.println("identifier found");}
					case -63:
						break;
					case 66:
						{System.out.println("identifier found");}
					case -64:
						break;
					case 67:
						{/*next pattern matches identifiers*/}
					case -65:
						break;
					case 68:
						{System.out.println("identifier found");}
					case -66:
						break;
					case 69:
						{/*next pattern matches identifiers*/}
					case -67:
						break;
					case 70:
						{System.out.println("identifier found");}
					case -68:
						break;
					case 71:
						{/*next pattern matches identifiers*/}
					case -69:
						break;
					case 72:
						{System.out.println("identifier found");}
					case -70:
						break;
					case 73:
						{/*next pattern matches identifiers*/}
					case -71:
						break;
					case 74:
						{System.out.println("identifier found");}
					case -72:
						break;
					case 75:
						{System.out.println("identifier found");}
					case -73:
						break;
					case 76:
						{System.out.println("identifier found");}
					case -74:
						break;
					case 77:
						{System.out.println("identifier found");}
					case -75:
						break;
					case 78:
						{System.out.println("identifier found");}
					case -76:
						break;
					case 79:
						{System.out.println("identifier found");}
					case -77:
						break;
					case 80:
						{System.out.println("identifier found");}
					case -78:
						break;
					case 81:
						{System.out.println("identifier found");}
					case -79:
						break;
					case 82:
						{System.out.println("identifier found");}
					case -80:
						break;
					case 83:
						{System.out.println("identifier found");}
					case -81:
						break;
					case 84:
						{System.out.println("identifier found");}
					case -82:
						break;
					case 85:
						{System.out.println("identifier found");}
					case -83:
						break;
					case 86:
						{System.out.println("identifier found");}
					case -84:
						break;
					case 87:
						{System.out.println("identifier found");}
					case -85:
						break;
					case 88:
						{System.out.println("identifier found");}
					case -86:
						break;
					case 89:
						{System.out.println("identifier found");}
					case -87:
						break;
					case 90:
						{System.out.println("identifier found");}
					case -88:
						break;
					case 91:
						{System.out.println("identifier found");}
					case -89:
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
