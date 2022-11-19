package su.nsk.iae.post.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPoSTLexer extends Lexer {
    public static final int T__50=50;
    public static final int RULE_PRIORITY_DECLARATION=7;
    public static final int RULE_INTERVAL=15;
    public static final int RULE_BIT=30;
    public static final int RULE_SINGLE_DECLARATION=5;
    public static final int T__59=59;
    public static final int RULE_SIGNED_INTEGER_TYPE_NAME=20;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_REAL_TYPE_NAME=19;
    public static final int RULE_BOOLEAN_LITERAL=25;
    public static final int RULE_REAL=26;
    public static final int RULE_DIGIT=29;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=34;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int RULE_BIT_STRING_TYPE_NAME=16;
    public static final int T__65=65;
    public static final int RULE_DIRECT_VARIABLE=13;
    public static final int RULE_OR_OPERATOR=9;
    public static final int RULE_XOR_OPERATOR=10;
    public static final int RULE_HEX_INTEGER=24;
    public static final int RULE_TIME_TYPE_NAME=17;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_STRING_TYPE_NAME=18;
    public static final int RULE_OCTAL_DIGIT=31;
    public static final int RULE_AND_OPERATOR=11;
    public static final int RULE_LETTER=33;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_HEX_DIGIT=32;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_INTERVAL_DECLARATION=6;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int RULE_UNSIGNED_INTEGER_TYPE_NAME=21;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DIRECT_SIZE_PREFIX=28;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_DIRECT_TYPE_PREFIX=27;
    public static final int RULE_POWER_OPERATOR=12;
    public static final int RULE_BINARY_INTEGER=22;
    public static final int RULE_SL_COMMENT=35;
    public static final int RULE_TIME_PREF_LITERAL=14;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int RULE_OCTAL_INTEGER=23;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=36;
    public static final int RULE_ANY_OTHER=37;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=8;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators

    public InternalPoSTLexer() {;} 
    public InternalPoSTLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPoSTLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalPoST.g"; }

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:11:7: ( 'CONFIGURATION' )
            // InternalPoST.g:11:9: 'CONFIGURATION'
            {
            match("CONFIGURATION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:12:7: ( 'END_CONFIGURATION' )
            // InternalPoST.g:12:9: 'END_CONFIGURATION'
            {
            match("END_CONFIGURATION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:13:7: ( 'RESOURCE' )
            // InternalPoST.g:13:9: 'RESOURCE'
            {
            match("RESOURCE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:14:7: ( 'ON' )
            // InternalPoST.g:14:9: 'ON'
            {
            match("ON"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:15:7: ( 'END_RESOURCE' )
            // InternalPoST.g:15:9: 'END_RESOURCE'
            {
            match("END_RESOURCE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:16:7: ( ';' )
            // InternalPoST.g:16:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:17:7: ( 'TASK' )
            // InternalPoST.g:17:9: 'TASK'
            {
            match("TASK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:18:7: ( '(' )
            // InternalPoST.g:18:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:19:7: ( ')' )
            // InternalPoST.g:19:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:20:7: ( ':=' )
            // InternalPoST.g:20:9: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:21:7: ( ',' )
            // InternalPoST.g:21:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:22:7: ( 'PROGRAM' )
            // InternalPoST.g:22:9: 'PROGRAM'
            {
            match("PROGRAM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:23:7: ( 'WITH' )
            // InternalPoST.g:23:9: 'WITH'
            {
            match("WITH"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:24:7: ( ':' )
            // InternalPoST.g:24:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:25:7: ( 'PROCESS' )
            // InternalPoST.g:25:9: 'PROCESS'
            {
            match("PROCESS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:26:7: ( 'ACTIVE' )
            // InternalPoST.g:26:9: 'ACTIVE'
            {
            match("ACTIVE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:27:7: ( 'END_PROGRAM' )
            // InternalPoST.g:27:9: 'END_PROGRAM'
            {
            match("END_PROGRAM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:28:7: ( 'FUNCTION_BLOCK' )
            // InternalPoST.g:28:9: 'FUNCTION_BLOCK'
            {
            match("FUNCTION_BLOCK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:29:7: ( 'END_FUNCTION_BLOCK' )
            // InternalPoST.g:29:9: 'END_FUNCTION_BLOCK'
            {
            match("END_FUNCTION_BLOCK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:30:7: ( 'FUNCTION' )
            // InternalPoST.g:30:9: 'FUNCTION'
            {
            match("FUNCTION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:31:7: ( 'END_FUNCTION' )
            // InternalPoST.g:31:9: 'END_FUNCTION'
            {
            match("END_FUNCTION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:32:7: ( 'END_PROCESS' )
            // InternalPoST.g:32:9: 'END_PROCESS'
            {
            match("END_PROCESS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:33:7: ( 'STATE' )
            // InternalPoST.g:33:9: 'STATE'
            {
            match("STATE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:34:7: ( 'LOOPED' )
            // InternalPoST.g:34:9: 'LOOPED'
            {
            match("LOOPED"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:35:7: ( 'END_STATE' )
            // InternalPoST.g:35:9: 'END_STATE'
            {
            match("END_STATE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:36:7: ( 'SET' )
            // InternalPoST.g:36:9: 'SET'
            {
            match("SET"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:37:7: ( 'NEXT' )
            // InternalPoST.g:37:9: 'NEXT'
            {
            match("NEXT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:38:7: ( 'IN' )
            // InternalPoST.g:38:9: 'IN'
            {
            match("IN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:39:7: ( 'INACTIVE' )
            // InternalPoST.g:39:9: 'INACTIVE'
            {
            match("INACTIVE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:40:7: ( 'STOP' )
            // InternalPoST.g:40:9: 'STOP'
            {
            match("STOP"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:41:7: ( 'ERROR' )
            // InternalPoST.g:41:9: 'ERROR'
            {
            match("ERROR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:42:7: ( 'START' )
            // InternalPoST.g:42:9: 'START'
            {
            match("START"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:43:7: ( 'RESTART' )
            // InternalPoST.g:43:9: 'RESTART'
            {
            match("RESTART"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:44:7: ( 'TIMEOUT' )
            // InternalPoST.g:44:9: 'TIMEOUT'
            {
            match("TIMEOUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:45:7: ( 'THEN' )
            // InternalPoST.g:45:9: 'THEN'
            {
            match("THEN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:46:7: ( 'END_TIMEOUT' )
            // InternalPoST.g:46:9: 'END_TIMEOUT'
            {
            match("END_TIMEOUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:47:7: ( 'RESET' )
            // InternalPoST.g:47:9: 'RESET'
            {
            match("RESET"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:48:7: ( 'TIMER' )
            // InternalPoST.g:48:9: 'TIMER'
            {
            match("TIMER"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:49:7: ( 'IF' )
            // InternalPoST.g:49:9: 'IF'
            {
            match("IF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:50:7: ( 'ELSIF' )
            // InternalPoST.g:50:9: 'ELSIF'
            {
            match("ELSIF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:51:7: ( 'ELSE' )
            // InternalPoST.g:51:9: 'ELSE'
            {
            match("ELSE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:52:7: ( 'END_IF' )
            // InternalPoST.g:52:9: 'END_IF'
            {
            match("END_IF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:53:7: ( 'CASE' )
            // InternalPoST.g:53:9: 'CASE'
            {
            match("CASE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:54:7: ( 'OF' )
            // InternalPoST.g:54:9: 'OF'
            {
            match("OF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:55:7: ( 'END_CASE' )
            // InternalPoST.g:55:9: 'END_CASE'
            {
            match("END_CASE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:56:7: ( 'FOR' )
            // InternalPoST.g:56:9: 'FOR'
            {
            match("FOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:57:7: ( 'DO' )
            // InternalPoST.g:57:9: 'DO'
            {
            match("DO"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:58:7: ( 'END_FOR' )
            // InternalPoST.g:58:9: 'END_FOR'
            {
            match("END_FOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:59:7: ( 'TO' )
            // InternalPoST.g:59:9: 'TO'
            {
            match("TO"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:60:7: ( 'BY' )
            // InternalPoST.g:60:9: 'BY'
            {
            match("BY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:61:7: ( 'WHILE' )
            // InternalPoST.g:61:9: 'WHILE'
            {
            match("WHILE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:62:7: ( 'END_WHILE' )
            // InternalPoST.g:62:9: 'END_WHILE'
            {
            match("END_WHILE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:63:7: ( 'REPEAT' )
            // InternalPoST.g:63:9: 'REPEAT'
            {
            match("REPEAT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:64:7: ( 'UNTIL' )
            // InternalPoST.g:64:9: 'UNTIL'
            {
            match("UNTIL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:65:7: ( 'END_REPEAT' )
            // InternalPoST.g:65:9: 'END_REPEAT'
            {
            match("END_REPEAT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:66:7: ( 'RETURN' )
            // InternalPoST.g:66:9: 'RETURN'
            {
            match("RETURN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:67:7: ( 'EXIT' )
            // InternalPoST.g:67:9: 'EXIT'
            {
            match("EXIT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:68:7: ( 'VAR_INPUT' )
            // InternalPoST.g:68:9: 'VAR_INPUT'
            {
            match("VAR_INPUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:69:7: ( 'END_VAR' )
            // InternalPoST.g:69:9: 'END_VAR'
            {
            match("END_VAR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:70:7: ( 'VAR_OUTPUT' )
            // InternalPoST.g:70:9: 'VAR_OUTPUT'
            {
            match("VAR_OUTPUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:71:7: ( 'VAR_IN_OUT' )
            // InternalPoST.g:71:9: 'VAR_IN_OUT'
            {
            match("VAR_IN_OUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:72:7: ( 'VAR' )
            // InternalPoST.g:72:9: 'VAR'
            {
            match("VAR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:73:8: ( 'CONSTANT' )
            // InternalPoST.g:73:10: 'CONSTANT'
            {
            match("CONSTANT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:74:8: ( 'VAR_TEMP' )
            // InternalPoST.g:74:10: 'VAR_TEMP'
            {
            match("VAR_TEMP"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:75:8: ( 'VAR_EXTERNAL' )
            // InternalPoST.g:75:10: 'VAR_EXTERNAL'
            {
            match("VAR_EXTERNAL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:76:8: ( 'AT' )
            // InternalPoST.g:76:10: 'AT'
            {
            match("AT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:77:8: ( 'VAR_GLOBAL' )
            // InternalPoST.g:77:10: 'VAR_GLOBAL'
            {
            match("VAR_GLOBAL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:78:8: ( 'VAR_PROCESS' )
            // InternalPoST.g:78:10: 'VAR_PROCESS'
            {
            match("VAR_PROCESS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:79:8: ( '[' )
            // InternalPoST.g:79:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:80:8: ( ']' )
            // InternalPoST.g:80:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:81:8: ( 'ARRAY' )
            // InternalPoST.g:81:10: 'ARRAY'
            {
            match("ARRAY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:82:8: ( '*' )
            // InternalPoST.g:82:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:83:8: ( '..' )
            // InternalPoST.g:83:10: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:84:8: ( '#' )
            // InternalPoST.g:84:10: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:85:8: ( '-' )
            // InternalPoST.g:85:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:86:8: ( '=>' )
            // InternalPoST.g:86:10: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:87:8: ( '=' )
            // InternalPoST.g:87:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:88:8: ( '<>' )
            // InternalPoST.g:88:10: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:89:8: ( '<' )
            // InternalPoST.g:89:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:90:8: ( '>' )
            // InternalPoST.g:90:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:91:8: ( '<=' )
            // InternalPoST.g:91:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:92:8: ( '>=' )
            // InternalPoST.g:92:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:93:8: ( '+' )
            // InternalPoST.g:93:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:94:8: ( '/' )
            // InternalPoST.g:94:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:95:8: ( 'MOD' )
            // InternalPoST.g:95:10: 'MOD'
            {
            match("MOD"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:96:8: ( 'NOT' )
            // InternalPoST.g:96:10: 'NOT'
            {
            match("NOT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "RULE_SINGLE_DECLARATION"
    public final void mRULE_SINGLE_DECLARATION() throws RecognitionException {
        try {
            int _type = RULE_SINGLE_DECLARATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6809:25: ( 'SINGLE' )
            // InternalPoST.g:6809:27: 'SINGLE'
            {
            match("SINGLE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SINGLE_DECLARATION"

    // $ANTLR start "RULE_INTERVAL_DECLARATION"
    public final void mRULE_INTERVAL_DECLARATION() throws RecognitionException {
        try {
            int _type = RULE_INTERVAL_DECLARATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6811:27: ( 'INTERVAL' )
            // InternalPoST.g:6811:29: 'INTERVAL'
            {
            match("INTERVAL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTERVAL_DECLARATION"

    // $ANTLR start "RULE_PRIORITY_DECLARATION"
    public final void mRULE_PRIORITY_DECLARATION() throws RecognitionException {
        try {
            int _type = RULE_PRIORITY_DECLARATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6813:27: ( 'PRIORITY' )
            // InternalPoST.g:6813:29: 'PRIORITY'
            {
            match("PRIORITY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PRIORITY_DECLARATION"

    // $ANTLR start "RULE_OR_OPERATOR"
    public final void mRULE_OR_OPERATOR() throws RecognitionException {
        try {
            int _type = RULE_OR_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6815:18: ( 'OR' )
            // InternalPoST.g:6815:20: 'OR'
            {
            match("OR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OR_OPERATOR"

    // $ANTLR start "RULE_XOR_OPERATOR"
    public final void mRULE_XOR_OPERATOR() throws RecognitionException {
        try {
            int _type = RULE_XOR_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6817:19: ( 'XOR' )
            // InternalPoST.g:6817:21: 'XOR'
            {
            match("XOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_XOR_OPERATOR"

    // $ANTLR start "RULE_AND_OPERATOR"
    public final void mRULE_AND_OPERATOR() throws RecognitionException {
        try {
            int _type = RULE_AND_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6819:19: ( ( '&' | 'AND' ) )
            // InternalPoST.g:6819:21: ( '&' | 'AND' )
            {
            // InternalPoST.g:6819:21: ( '&' | 'AND' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='&') ) {
                alt1=1;
            }
            else if ( (LA1_0=='A') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalPoST.g:6819:22: '&'
                    {
                    match('&'); 

                    }
                    break;
                case 2 :
                    // InternalPoST.g:6819:26: 'AND'
                    {
                    match("AND"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_AND_OPERATOR"

    // $ANTLR start "RULE_POWER_OPERATOR"
    public final void mRULE_POWER_OPERATOR() throws RecognitionException {
        try {
            int _type = RULE_POWER_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6821:21: ( '**' )
            // InternalPoST.g:6821:23: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_POWER_OPERATOR"

    // $ANTLR start "RULE_TIME_PREF_LITERAL"
    public final void mRULE_TIME_PREF_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_TIME_PREF_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6823:24: ( 'T' )
            // InternalPoST.g:6823:26: 'T'
            {
            match('T'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TIME_PREF_LITERAL"

    // $ANTLR start "RULE_INTERVAL"
    public final void mRULE_INTERVAL() throws RecognitionException {
        try {
            int _type = RULE_INTERVAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6825:15: ( ( RULE_INTEGER 'd' )? ( RULE_INTEGER 'h' )? ( RULE_INTEGER 'm' )? ( RULE_INTEGER 's' )? ( RULE_INTEGER 'ms' )? )
            // InternalPoST.g:6825:17: ( RULE_INTEGER 'd' )? ( RULE_INTEGER 'h' )? ( RULE_INTEGER 'm' )? ( RULE_INTEGER 's' )? ( RULE_INTEGER 'ms' )?
            {
            // InternalPoST.g:6825:17: ( RULE_INTEGER 'd' )?
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalPoST.g:6825:18: RULE_INTEGER 'd'
                    {
                    mRULE_INTEGER(); 
                    match('d'); 

                    }
                    break;

            }

            // InternalPoST.g:6825:37: ( RULE_INTEGER 'h' )?
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalPoST.g:6825:38: RULE_INTEGER 'h'
                    {
                    mRULE_INTEGER(); 
                    match('h'); 

                    }
                    break;

            }

            // InternalPoST.g:6825:57: ( RULE_INTEGER 'm' )?
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalPoST.g:6825:58: RULE_INTEGER 'm'
                    {
                    mRULE_INTEGER(); 
                    match('m'); 

                    }
                    break;

            }

            // InternalPoST.g:6825:77: ( RULE_INTEGER 's' )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalPoST.g:6825:78: RULE_INTEGER 's'
                    {
                    mRULE_INTEGER(); 
                    match('s'); 

                    }
                    break;

            }

            // InternalPoST.g:6825:97: ( RULE_INTEGER 'ms' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalPoST.g:6825:98: RULE_INTEGER 'ms'
                    {
                    mRULE_INTEGER(); 
                    match("ms"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTERVAL"

    // $ANTLR start "RULE_DIRECT_VARIABLE"
    public final void mRULE_DIRECT_VARIABLE() throws RecognitionException {
        try {
            int _type = RULE_DIRECT_VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6827:22: ( '%' RULE_DIRECT_TYPE_PREFIX RULE_DIRECT_SIZE_PREFIX RULE_INTEGER ( '.' RULE_INTEGER )* )
            // InternalPoST.g:6827:24: '%' RULE_DIRECT_TYPE_PREFIX RULE_DIRECT_SIZE_PREFIX RULE_INTEGER ( '.' RULE_INTEGER )*
            {
            match('%'); 
            mRULE_DIRECT_TYPE_PREFIX(); 
            mRULE_DIRECT_SIZE_PREFIX(); 
            mRULE_INTEGER(); 
            // InternalPoST.g:6827:89: ( '.' RULE_INTEGER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='.') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPoST.g:6827:90: '.' RULE_INTEGER
            	    {
            	    match('.'); 
            	    mRULE_INTEGER(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIRECT_VARIABLE"

    // $ANTLR start "RULE_DIRECT_TYPE_PREFIX"
    public final void mRULE_DIRECT_TYPE_PREFIX() throws RecognitionException {
        try {
            // InternalPoST.g:6829:34: ( ( 'I' | 'Q' | 'M' ) )
            // InternalPoST.g:6829:36: ( 'I' | 'Q' | 'M' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='M'||input.LA(1)=='Q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIRECT_TYPE_PREFIX"

    // $ANTLR start "RULE_DIRECT_SIZE_PREFIX"
    public final void mRULE_DIRECT_SIZE_PREFIX() throws RecognitionException {
        try {
            // InternalPoST.g:6831:34: ( ( 'X' | 'B' | 'W' | 'D' | 'L' ) )
            // InternalPoST.g:6831:36: ( 'X' | 'B' | 'W' | 'D' | 'L' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='D'||input.LA(1)=='L'||(input.LA(1)>='W' && input.LA(1)<='X') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIRECT_SIZE_PREFIX"

    // $ANTLR start "RULE_SIGNED_INTEGER_TYPE_NAME"
    public final void mRULE_SIGNED_INTEGER_TYPE_NAME() throws RecognitionException {
        try {
            int _type = RULE_SIGNED_INTEGER_TYPE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6833:31: ( ( 'SINT' | 'INT' | 'DINT' | 'LINT' ) )
            // InternalPoST.g:6833:33: ( 'SINT' | 'INT' | 'DINT' | 'LINT' )
            {
            // InternalPoST.g:6833:33: ( 'SINT' | 'INT' | 'DINT' | 'LINT' )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 'S':
                {
                alt8=1;
                }
                break;
            case 'I':
                {
                alt8=2;
                }
                break;
            case 'D':
                {
                alt8=3;
                }
                break;
            case 'L':
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalPoST.g:6833:34: 'SINT'
                    {
                    match("SINT"); 


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6833:41: 'INT'
                    {
                    match("INT"); 


                    }
                    break;
                case 3 :
                    // InternalPoST.g:6833:47: 'DINT'
                    {
                    match("DINT"); 


                    }
                    break;
                case 4 :
                    // InternalPoST.g:6833:54: 'LINT'
                    {
                    match("LINT"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SIGNED_INTEGER_TYPE_NAME"

    // $ANTLR start "RULE_UNSIGNED_INTEGER_TYPE_NAME"
    public final void mRULE_UNSIGNED_INTEGER_TYPE_NAME() throws RecognitionException {
        try {
            int _type = RULE_UNSIGNED_INTEGER_TYPE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6835:33: ( ( 'USINT' | 'UINT' | 'UDINT' | 'ULINT' ) )
            // InternalPoST.g:6835:35: ( 'USINT' | 'UINT' | 'UDINT' | 'ULINT' )
            {
            // InternalPoST.g:6835:35: ( 'USINT' | 'UINT' | 'UDINT' | 'ULINT' )
            int alt9=4;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='U') ) {
                switch ( input.LA(2) ) {
                case 'S':
                    {
                    alt9=1;
                    }
                    break;
                case 'I':
                    {
                    alt9=2;
                    }
                    break;
                case 'D':
                    {
                    alt9=3;
                    }
                    break;
                case 'L':
                    {
                    alt9=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalPoST.g:6835:36: 'USINT'
                    {
                    match("USINT"); 


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6835:44: 'UINT'
                    {
                    match("UINT"); 


                    }
                    break;
                case 3 :
                    // InternalPoST.g:6835:51: 'UDINT'
                    {
                    match("UDINT"); 


                    }
                    break;
                case 4 :
                    // InternalPoST.g:6835:59: 'ULINT'
                    {
                    match("ULINT"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNSIGNED_INTEGER_TYPE_NAME"

    // $ANTLR start "RULE_REAL_TYPE_NAME"
    public final void mRULE_REAL_TYPE_NAME() throws RecognitionException {
        try {
            int _type = RULE_REAL_TYPE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6837:21: ( ( 'REAL' | 'LREAL' ) )
            // InternalPoST.g:6837:23: ( 'REAL' | 'LREAL' )
            {
            // InternalPoST.g:6837:23: ( 'REAL' | 'LREAL' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='R') ) {
                alt10=1;
            }
            else if ( (LA10_0=='L') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalPoST.g:6837:24: 'REAL'
                    {
                    match("REAL"); 


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6837:31: 'LREAL'
                    {
                    match("LREAL"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_REAL_TYPE_NAME"

    // $ANTLR start "RULE_BIT_STRING_TYPE_NAME"
    public final void mRULE_BIT_STRING_TYPE_NAME() throws RecognitionException {
        try {
            int _type = RULE_BIT_STRING_TYPE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6839:27: ( ( 'BOOL' | 'BYTE' | 'WORD' | 'DWORD' | 'LWORD' ) )
            // InternalPoST.g:6839:29: ( 'BOOL' | 'BYTE' | 'WORD' | 'DWORD' | 'LWORD' )
            {
            // InternalPoST.g:6839:29: ( 'BOOL' | 'BYTE' | 'WORD' | 'DWORD' | 'LWORD' )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 'B':
                {
                int LA11_1 = input.LA(2);

                if ( (LA11_1=='O') ) {
                    alt11=1;
                }
                else if ( (LA11_1=='Y') ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case 'W':
                {
                alt11=3;
                }
                break;
            case 'D':
                {
                alt11=4;
                }
                break;
            case 'L':
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalPoST.g:6839:30: 'BOOL'
                    {
                    match("BOOL"); 


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6839:37: 'BYTE'
                    {
                    match("BYTE"); 


                    }
                    break;
                case 3 :
                    // InternalPoST.g:6839:44: 'WORD'
                    {
                    match("WORD"); 


                    }
                    break;
                case 4 :
                    // InternalPoST.g:6839:51: 'DWORD'
                    {
                    match("DWORD"); 


                    }
                    break;
                case 5 :
                    // InternalPoST.g:6839:59: 'LWORD'
                    {
                    match("LWORD"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIT_STRING_TYPE_NAME"

    // $ANTLR start "RULE_TIME_TYPE_NAME"
    public final void mRULE_TIME_TYPE_NAME() throws RecognitionException {
        try {
            int _type = RULE_TIME_TYPE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6841:21: ( 'TIME' )
            // InternalPoST.g:6841:23: 'TIME'
            {
            match("TIME"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TIME_TYPE_NAME"

    // $ANTLR start "RULE_STRING_TYPE_NAME"
    public final void mRULE_STRING_TYPE_NAME() throws RecognitionException {
        try {
            int _type = RULE_STRING_TYPE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6843:23: ( ( 'STRING' | 'WSTRING' ) )
            // InternalPoST.g:6843:25: ( 'STRING' | 'WSTRING' )
            {
            // InternalPoST.g:6843:25: ( 'STRING' | 'WSTRING' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='S') ) {
                alt12=1;
            }
            else if ( (LA12_0=='W') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalPoST.g:6843:26: 'STRING'
                    {
                    match("STRING"); 


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6843:35: 'WSTRING'
                    {
                    match("WSTRING"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING_TYPE_NAME"

    // $ANTLR start "RULE_INTEGER"
    public final void mRULE_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6845:14: ( ( RULE_DIGIT )+ )
            // InternalPoST.g:6845:16: ( RULE_DIGIT )+
            {
            // InternalPoST.g:6845:16: ( RULE_DIGIT )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalPoST.g:6845:16: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER"

    // $ANTLR start "RULE_REAL"
    public final void mRULE_REAL() throws RecognitionException {
        try {
            int _type = RULE_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6847:11: ( RULE_INTEGER '.' RULE_INTEGER )
            // InternalPoST.g:6847:13: RULE_INTEGER '.' RULE_INTEGER
            {
            mRULE_INTEGER(); 
            match('.'); 
            mRULE_INTEGER(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_REAL"

    // $ANTLR start "RULE_BINARY_INTEGER"
    public final void mRULE_BINARY_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_BINARY_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6849:21: ( '2#' ( RULE_BIT )+ )
            // InternalPoST.g:6849:23: '2#' ( RULE_BIT )+
            {
            match("2#"); 

            // InternalPoST.g:6849:28: ( RULE_BIT )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='1')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPoST.g:6849:28: RULE_BIT
            	    {
            	    mRULE_BIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINARY_INTEGER"

    // $ANTLR start "RULE_OCTAL_INTEGER"
    public final void mRULE_OCTAL_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_OCTAL_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6851:20: ( '8#' ( RULE_OCTAL_DIGIT )+ )
            // InternalPoST.g:6851:22: '8#' ( RULE_OCTAL_DIGIT )+
            {
            match("8#"); 

            // InternalPoST.g:6851:27: ( RULE_OCTAL_DIGIT )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='7')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPoST.g:6851:27: RULE_OCTAL_DIGIT
            	    {
            	    mRULE_OCTAL_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCTAL_INTEGER"

    // $ANTLR start "RULE_HEX_INTEGER"
    public final void mRULE_HEX_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_HEX_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6853:18: ( '16#' ( RULE_HEX_DIGIT )+ )
            // InternalPoST.g:6853:20: '16#' ( RULE_HEX_DIGIT )+
            {
            match("16#"); 

            // InternalPoST.g:6853:26: ( RULE_HEX_DIGIT )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='F')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPoST.g:6853:26: RULE_HEX_DIGIT
            	    {
            	    mRULE_HEX_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_INTEGER"

    // $ANTLR start "RULE_BOOLEAN_LITERAL"
    public final void mRULE_BOOLEAN_LITERAL() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6855:22: ( ( 'TRUE' | 'FALSE' ) )
            // InternalPoST.g:6855:24: ( 'TRUE' | 'FALSE' )
            {
            // InternalPoST.g:6855:24: ( 'TRUE' | 'FALSE' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='T') ) {
                alt17=1;
            }
            else if ( (LA17_0=='F') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalPoST.g:6855:25: 'TRUE'
                    {
                    match("TRUE"); 


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6855:32: 'FALSE'
                    {
                    match("FALSE"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN_LITERAL"

    // $ANTLR start "RULE_LETTER"
    public final void mRULE_LETTER() throws RecognitionException {
        try {
            // InternalPoST.g:6857:22: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
            // InternalPoST.g:6857:24: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_LETTER"

    // $ANTLR start "RULE_BIT"
    public final void mRULE_BIT() throws RecognitionException {
        try {
            // InternalPoST.g:6859:19: ( ( '0' | '1' ) )
            // InternalPoST.g:6859:21: ( '0' | '1' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIT"

    // $ANTLR start "RULE_OCTAL_DIGIT"
    public final void mRULE_OCTAL_DIGIT() throws RecognitionException {
        try {
            // InternalPoST.g:6861:27: ( '0' .. '7' )
            // InternalPoST.g:6861:29: '0' .. '7'
            {
            matchRange('0','7'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_OCTAL_DIGIT"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalPoST.g:6863:21: ( '0' .. '9' )
            // InternalPoST.g:6863:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_HEX_DIGIT"
    public final void mRULE_HEX_DIGIT() throws RecognitionException {
        try {
            // InternalPoST.g:6865:25: ( ( RULE_DIGIT | 'A' .. 'F' ) )
            // InternalPoST.g:6865:27: ( RULE_DIGIT | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_DIGIT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6867:9: ( RULE_LETTER ( RULE_LETTER | RULE_DIGIT )* )
            // InternalPoST.g:6867:11: RULE_LETTER ( RULE_LETTER | RULE_DIGIT )*
            {
            mRULE_LETTER(); 
            // InternalPoST.g:6867:23: ( RULE_LETTER | RULE_DIGIT )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')||(LA18_0>='A' && LA18_0<='Z')||LA18_0=='_'||(LA18_0>='a' && LA18_0<='z')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalPoST.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6869:17: ( ( '/*' ( options {greedy=false; } : . )* '*/' | '(*' ( options {greedy=false; } : . )* '*)' ) )
            // InternalPoST.g:6869:19: ( '/*' ( options {greedy=false; } : . )* '*/' | '(*' ( options {greedy=false; } : . )* '*)' )
            {
            // InternalPoST.g:6869:19: ( '/*' ( options {greedy=false; } : . )* '*/' | '(*' ( options {greedy=false; } : . )* '*)' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='/') ) {
                alt21=1;
            }
            else if ( (LA21_0=='(') ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalPoST.g:6869:20: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // InternalPoST.g:6869:25: ( options {greedy=false; } : . )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='*') ) {
                            int LA19_1 = input.LA(2);

                            if ( (LA19_1=='/') ) {
                                alt19=2;
                            }
                            else if ( ((LA19_1>='\u0000' && LA19_1<='.')||(LA19_1>='0' && LA19_1<='\uFFFF')) ) {
                                alt19=1;
                            }


                        }
                        else if ( ((LA19_0>='\u0000' && LA19_0<=')')||(LA19_0>='+' && LA19_0<='\uFFFF')) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalPoST.g:6869:53: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    match("*/"); 


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6869:62: '(*' ( options {greedy=false; } : . )* '*)'
                    {
                    match("(*"); 

                    // InternalPoST.g:6869:67: ( options {greedy=false; } : . )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='*') ) {
                            int LA20_1 = input.LA(2);

                            if ( (LA20_1==')') ) {
                                alt20=2;
                            }
                            else if ( ((LA20_1>='\u0000' && LA20_1<='(')||(LA20_1>='*' && LA20_1<='\uFFFF')) ) {
                                alt20=1;
                            }


                        }
                        else if ( ((LA20_0>='\u0000' && LA20_0<=')')||(LA20_0>='+' && LA20_0<='\uFFFF')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalPoST.g:6869:95: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    match("*)"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6871:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalPoST.g:6871:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalPoST.g:6871:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='\u0000' && LA22_0<='\t')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPoST.g:6871:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // InternalPoST.g:6871:40: ( ( '\\r' )? '\\n' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\n'||LA24_0=='\r') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalPoST.g:6871:41: ( '\\r' )? '\\n'
                    {
                    // InternalPoST.g:6871:41: ( '\\r' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='\r') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalPoST.g:6871:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6873:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalPoST.g:6873:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalPoST.g:6873:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='\t' && LA25_0<='\n')||LA25_0=='\r'||LA25_0==' ') ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalPoST.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalPoST.g:6875:16: ( . )
            // InternalPoST.g:6875:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalPoST.g:1:8: ( T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | RULE_SINGLE_DECLARATION | RULE_INTERVAL_DECLARATION | RULE_PRIORITY_DECLARATION | RULE_OR_OPERATOR | RULE_XOR_OPERATOR | RULE_AND_OPERATOR | RULE_POWER_OPERATOR | RULE_TIME_PREF_LITERAL | RULE_INTERVAL | RULE_DIRECT_VARIABLE | RULE_SIGNED_INTEGER_TYPE_NAME | RULE_UNSIGNED_INTEGER_TYPE_NAME | RULE_REAL_TYPE_NAME | RULE_BIT_STRING_TYPE_NAME | RULE_TIME_TYPE_NAME | RULE_STRING_TYPE_NAME | RULE_INTEGER | RULE_REAL | RULE_BINARY_INTEGER | RULE_OCTAL_INTEGER | RULE_HEX_INTEGER | RULE_BOOLEAN_LITERAL | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt26=113;
        alt26 = dfa26.predict(input);
        switch (alt26) {
            case 1 :
                // InternalPoST.g:1:10: T__38
                {
                mT__38(); 

                }
                break;
            case 2 :
                // InternalPoST.g:1:16: T__39
                {
                mT__39(); 

                }
                break;
            case 3 :
                // InternalPoST.g:1:22: T__40
                {
                mT__40(); 

                }
                break;
            case 4 :
                // InternalPoST.g:1:28: T__41
                {
                mT__41(); 

                }
                break;
            case 5 :
                // InternalPoST.g:1:34: T__42
                {
                mT__42(); 

                }
                break;
            case 6 :
                // InternalPoST.g:1:40: T__43
                {
                mT__43(); 

                }
                break;
            case 7 :
                // InternalPoST.g:1:46: T__44
                {
                mT__44(); 

                }
                break;
            case 8 :
                // InternalPoST.g:1:52: T__45
                {
                mT__45(); 

                }
                break;
            case 9 :
                // InternalPoST.g:1:58: T__46
                {
                mT__46(); 

                }
                break;
            case 10 :
                // InternalPoST.g:1:64: T__47
                {
                mT__47(); 

                }
                break;
            case 11 :
                // InternalPoST.g:1:70: T__48
                {
                mT__48(); 

                }
                break;
            case 12 :
                // InternalPoST.g:1:76: T__49
                {
                mT__49(); 

                }
                break;
            case 13 :
                // InternalPoST.g:1:82: T__50
                {
                mT__50(); 

                }
                break;
            case 14 :
                // InternalPoST.g:1:88: T__51
                {
                mT__51(); 

                }
                break;
            case 15 :
                // InternalPoST.g:1:94: T__52
                {
                mT__52(); 

                }
                break;
            case 16 :
                // InternalPoST.g:1:100: T__53
                {
                mT__53(); 

                }
                break;
            case 17 :
                // InternalPoST.g:1:106: T__54
                {
                mT__54(); 

                }
                break;
            case 18 :
                // InternalPoST.g:1:112: T__55
                {
                mT__55(); 

                }
                break;
            case 19 :
                // InternalPoST.g:1:118: T__56
                {
                mT__56(); 

                }
                break;
            case 20 :
                // InternalPoST.g:1:124: T__57
                {
                mT__57(); 

                }
                break;
            case 21 :
                // InternalPoST.g:1:130: T__58
                {
                mT__58(); 

                }
                break;
            case 22 :
                // InternalPoST.g:1:136: T__59
                {
                mT__59(); 

                }
                break;
            case 23 :
                // InternalPoST.g:1:142: T__60
                {
                mT__60(); 

                }
                break;
            case 24 :
                // InternalPoST.g:1:148: T__61
                {
                mT__61(); 

                }
                break;
            case 25 :
                // InternalPoST.g:1:154: T__62
                {
                mT__62(); 

                }
                break;
            case 26 :
                // InternalPoST.g:1:160: T__63
                {
                mT__63(); 

                }
                break;
            case 27 :
                // InternalPoST.g:1:166: T__64
                {
                mT__64(); 

                }
                break;
            case 28 :
                // InternalPoST.g:1:172: T__65
                {
                mT__65(); 

                }
                break;
            case 29 :
                // InternalPoST.g:1:178: T__66
                {
                mT__66(); 

                }
                break;
            case 30 :
                // InternalPoST.g:1:184: T__67
                {
                mT__67(); 

                }
                break;
            case 31 :
                // InternalPoST.g:1:190: T__68
                {
                mT__68(); 

                }
                break;
            case 32 :
                // InternalPoST.g:1:196: T__69
                {
                mT__69(); 

                }
                break;
            case 33 :
                // InternalPoST.g:1:202: T__70
                {
                mT__70(); 

                }
                break;
            case 34 :
                // InternalPoST.g:1:208: T__71
                {
                mT__71(); 

                }
                break;
            case 35 :
                // InternalPoST.g:1:214: T__72
                {
                mT__72(); 

                }
                break;
            case 36 :
                // InternalPoST.g:1:220: T__73
                {
                mT__73(); 

                }
                break;
            case 37 :
                // InternalPoST.g:1:226: T__74
                {
                mT__74(); 

                }
                break;
            case 38 :
                // InternalPoST.g:1:232: T__75
                {
                mT__75(); 

                }
                break;
            case 39 :
                // InternalPoST.g:1:238: T__76
                {
                mT__76(); 

                }
                break;
            case 40 :
                // InternalPoST.g:1:244: T__77
                {
                mT__77(); 

                }
                break;
            case 41 :
                // InternalPoST.g:1:250: T__78
                {
                mT__78(); 

                }
                break;
            case 42 :
                // InternalPoST.g:1:256: T__79
                {
                mT__79(); 

                }
                break;
            case 43 :
                // InternalPoST.g:1:262: T__80
                {
                mT__80(); 

                }
                break;
            case 44 :
                // InternalPoST.g:1:268: T__81
                {
                mT__81(); 

                }
                break;
            case 45 :
                // InternalPoST.g:1:274: T__82
                {
                mT__82(); 

                }
                break;
            case 46 :
                // InternalPoST.g:1:280: T__83
                {
                mT__83(); 

                }
                break;
            case 47 :
                // InternalPoST.g:1:286: T__84
                {
                mT__84(); 

                }
                break;
            case 48 :
                // InternalPoST.g:1:292: T__85
                {
                mT__85(); 

                }
                break;
            case 49 :
                // InternalPoST.g:1:298: T__86
                {
                mT__86(); 

                }
                break;
            case 50 :
                // InternalPoST.g:1:304: T__87
                {
                mT__87(); 

                }
                break;
            case 51 :
                // InternalPoST.g:1:310: T__88
                {
                mT__88(); 

                }
                break;
            case 52 :
                // InternalPoST.g:1:316: T__89
                {
                mT__89(); 

                }
                break;
            case 53 :
                // InternalPoST.g:1:322: T__90
                {
                mT__90(); 

                }
                break;
            case 54 :
                // InternalPoST.g:1:328: T__91
                {
                mT__91(); 

                }
                break;
            case 55 :
                // InternalPoST.g:1:334: T__92
                {
                mT__92(); 

                }
                break;
            case 56 :
                // InternalPoST.g:1:340: T__93
                {
                mT__93(); 

                }
                break;
            case 57 :
                // InternalPoST.g:1:346: T__94
                {
                mT__94(); 

                }
                break;
            case 58 :
                // InternalPoST.g:1:352: T__95
                {
                mT__95(); 

                }
                break;
            case 59 :
                // InternalPoST.g:1:358: T__96
                {
                mT__96(); 

                }
                break;
            case 60 :
                // InternalPoST.g:1:364: T__97
                {
                mT__97(); 

                }
                break;
            case 61 :
                // InternalPoST.g:1:370: T__98
                {
                mT__98(); 

                }
                break;
            case 62 :
                // InternalPoST.g:1:376: T__99
                {
                mT__99(); 

                }
                break;
            case 63 :
                // InternalPoST.g:1:382: T__100
                {
                mT__100(); 

                }
                break;
            case 64 :
                // InternalPoST.g:1:389: T__101
                {
                mT__101(); 

                }
                break;
            case 65 :
                // InternalPoST.g:1:396: T__102
                {
                mT__102(); 

                }
                break;
            case 66 :
                // InternalPoST.g:1:403: T__103
                {
                mT__103(); 

                }
                break;
            case 67 :
                // InternalPoST.g:1:410: T__104
                {
                mT__104(); 

                }
                break;
            case 68 :
                // InternalPoST.g:1:417: T__105
                {
                mT__105(); 

                }
                break;
            case 69 :
                // InternalPoST.g:1:424: T__106
                {
                mT__106(); 

                }
                break;
            case 70 :
                // InternalPoST.g:1:431: T__107
                {
                mT__107(); 

                }
                break;
            case 71 :
                // InternalPoST.g:1:438: T__108
                {
                mT__108(); 

                }
                break;
            case 72 :
                // InternalPoST.g:1:445: T__109
                {
                mT__109(); 

                }
                break;
            case 73 :
                // InternalPoST.g:1:452: T__110
                {
                mT__110(); 

                }
                break;
            case 74 :
                // InternalPoST.g:1:459: T__111
                {
                mT__111(); 

                }
                break;
            case 75 :
                // InternalPoST.g:1:466: T__112
                {
                mT__112(); 

                }
                break;
            case 76 :
                // InternalPoST.g:1:473: T__113
                {
                mT__113(); 

                }
                break;
            case 77 :
                // InternalPoST.g:1:480: T__114
                {
                mT__114(); 

                }
                break;
            case 78 :
                // InternalPoST.g:1:487: T__115
                {
                mT__115(); 

                }
                break;
            case 79 :
                // InternalPoST.g:1:494: T__116
                {
                mT__116(); 

                }
                break;
            case 80 :
                // InternalPoST.g:1:501: T__117
                {
                mT__117(); 

                }
                break;
            case 81 :
                // InternalPoST.g:1:508: T__118
                {
                mT__118(); 

                }
                break;
            case 82 :
                // InternalPoST.g:1:515: T__119
                {
                mT__119(); 

                }
                break;
            case 83 :
                // InternalPoST.g:1:522: T__120
                {
                mT__120(); 

                }
                break;
            case 84 :
                // InternalPoST.g:1:529: T__121
                {
                mT__121(); 

                }
                break;
            case 85 :
                // InternalPoST.g:1:536: T__122
                {
                mT__122(); 

                }
                break;
            case 86 :
                // InternalPoST.g:1:543: T__123
                {
                mT__123(); 

                }
                break;
            case 87 :
                // InternalPoST.g:1:550: RULE_SINGLE_DECLARATION
                {
                mRULE_SINGLE_DECLARATION(); 

                }
                break;
            case 88 :
                // InternalPoST.g:1:574: RULE_INTERVAL_DECLARATION
                {
                mRULE_INTERVAL_DECLARATION(); 

                }
                break;
            case 89 :
                // InternalPoST.g:1:600: RULE_PRIORITY_DECLARATION
                {
                mRULE_PRIORITY_DECLARATION(); 

                }
                break;
            case 90 :
                // InternalPoST.g:1:626: RULE_OR_OPERATOR
                {
                mRULE_OR_OPERATOR(); 

                }
                break;
            case 91 :
                // InternalPoST.g:1:643: RULE_XOR_OPERATOR
                {
                mRULE_XOR_OPERATOR(); 

                }
                break;
            case 92 :
                // InternalPoST.g:1:661: RULE_AND_OPERATOR
                {
                mRULE_AND_OPERATOR(); 

                }
                break;
            case 93 :
                // InternalPoST.g:1:679: RULE_POWER_OPERATOR
                {
                mRULE_POWER_OPERATOR(); 

                }
                break;
            case 94 :
                // InternalPoST.g:1:699: RULE_TIME_PREF_LITERAL
                {
                mRULE_TIME_PREF_LITERAL(); 

                }
                break;
            case 95 :
                // InternalPoST.g:1:722: RULE_INTERVAL
                {
                mRULE_INTERVAL(); 

                }
                break;
            case 96 :
                // InternalPoST.g:1:736: RULE_DIRECT_VARIABLE
                {
                mRULE_DIRECT_VARIABLE(); 

                }
                break;
            case 97 :
                // InternalPoST.g:1:757: RULE_SIGNED_INTEGER_TYPE_NAME
                {
                mRULE_SIGNED_INTEGER_TYPE_NAME(); 

                }
                break;
            case 98 :
                // InternalPoST.g:1:787: RULE_UNSIGNED_INTEGER_TYPE_NAME
                {
                mRULE_UNSIGNED_INTEGER_TYPE_NAME(); 

                }
                break;
            case 99 :
                // InternalPoST.g:1:819: RULE_REAL_TYPE_NAME
                {
                mRULE_REAL_TYPE_NAME(); 

                }
                break;
            case 100 :
                // InternalPoST.g:1:839: RULE_BIT_STRING_TYPE_NAME
                {
                mRULE_BIT_STRING_TYPE_NAME(); 

                }
                break;
            case 101 :
                // InternalPoST.g:1:865: RULE_TIME_TYPE_NAME
                {
                mRULE_TIME_TYPE_NAME(); 

                }
                break;
            case 102 :
                // InternalPoST.g:1:885: RULE_STRING_TYPE_NAME
                {
                mRULE_STRING_TYPE_NAME(); 

                }
                break;
            case 103 :
                // InternalPoST.g:1:907: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 104 :
                // InternalPoST.g:1:920: RULE_REAL
                {
                mRULE_REAL(); 

                }
                break;
            case 105 :
                // InternalPoST.g:1:930: RULE_BINARY_INTEGER
                {
                mRULE_BINARY_INTEGER(); 

                }
                break;
            case 106 :
                // InternalPoST.g:1:950: RULE_OCTAL_INTEGER
                {
                mRULE_OCTAL_INTEGER(); 

                }
                break;
            case 107 :
                // InternalPoST.g:1:969: RULE_HEX_INTEGER
                {
                mRULE_HEX_INTEGER(); 

                }
                break;
            case 108 :
                // InternalPoST.g:1:986: RULE_BOOLEAN_LITERAL
                {
                mRULE_BOOLEAN_LITERAL(); 

                }
                break;
            case 109 :
                // InternalPoST.g:1:1007: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 110 :
                // InternalPoST.g:1:1015: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 111 :
                // InternalPoST.g:1:1031: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 112 :
                // InternalPoST.g:1:1047: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 113 :
                // InternalPoST.g:1:1055: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA2_eotS =
        "\1\2\3\uffff";
    static final String DFA2_eofS =
        "\4\uffff";
    static final String DFA2_minS =
        "\2\60\2\uffff";
    static final String DFA2_maxS =
        "\1\71\1\163\2\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\4\uffff}>";
    static final String[] DFA2_transitionS = {
            "\12\1",
            "\12\1\52\uffff\1\3\3\uffff\1\2\4\uffff\1\2\5\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "6825:17: ( RULE_INTEGER 'd' )?";
        }
    }
    static final String DFA3_eotS =
        "\1\2\3\uffff";
    static final String DFA3_eofS =
        "\4\uffff";
    static final String DFA3_minS =
        "\2\60\2\uffff";
    static final String DFA3_maxS =
        "\1\71\1\163\2\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA3_specialS =
        "\4\uffff}>";
    static final String[] DFA3_transitionS = {
            "\12\1",
            "\12\1\56\uffff\1\3\4\uffff\1\2\5\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "6825:37: ( RULE_INTEGER 'h' )?";
        }
    }
    static final String DFA4_eotS =
        "\1\2\2\uffff\1\4\1\uffff";
    static final String DFA4_eofS =
        "\5\uffff";
    static final String DFA4_minS =
        "\2\60\1\uffff\1\163\1\uffff";
    static final String DFA4_maxS =
        "\1\71\1\163\1\uffff\1\163\1\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA4_specialS =
        "\5\uffff}>";
    static final String[] DFA4_transitionS = {
            "\12\1",
            "\12\1\63\uffff\1\3\5\uffff\1\2",
            "",
            "\1\2",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "6825:57: ( RULE_INTEGER 'm' )?";
        }
    }
    static final String DFA5_eotS =
        "\1\2\3\uffff";
    static final String DFA5_eofS =
        "\4\uffff";
    static final String DFA5_minS =
        "\2\60\2\uffff";
    static final String DFA5_maxS =
        "\1\71\1\163\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA5_specialS =
        "\4\uffff}>";
    static final String[] DFA5_transitionS = {
            "\12\1",
            "\12\1\63\uffff\1\2\5\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "6825:77: ( RULE_INTEGER 's' )?";
        }
    }
    static final String DFA26_eotS =
        "\1\46\4\60\1\uffff\1\77\1\101\1\uffff\1\104\1\uffff\14\60\2\uffff\1\153\1\55\2\uffff\1\160\1\163\1\165\1\uffff\1\170\2\60\1\uffff\1\175\1\uffff\1\55\3\175\3\uffff\2\60\1\uffff\5\60\1\u008e\1\u008f\1\u0090\1\uffff\3\60\1\u0094\1\60\7\uffff\6\60\1\u009d\16\60\1\u00b0\1\u00b1\1\u00b2\2\60\1\u00b6\7\60\21\uffff\2\60\3\uffff\1\175\3\uffff\1\175\1\uffff\12\60\3\uffff\3\60\1\uffff\10\60\1\uffff\1\60\1\173\1\60\1\u00dd\4\60\1\u00e3\6\60\1\u00eb\1\60\1\u00ee\3\uffff\3\60\1\uffff\6\60\1\u00f9\1\u00fa\1\u00fb\1\uffff\2\60\1\u00fe\3\60\1\u010a\1\u010b\5\60\1\u0111\1\u0112\1\u0115\1\u0116\1\u0117\3\60\1\u011b\1\60\1\u011d\4\60\1\uffff\3\60\1\u0125\1\60\1\uffff\1\60\1\u00ee\1\60\1\u00ee\2\60\1\u012b\1\uffff\2\60\1\uffff\1\u00ee\1\60\2\u011d\2\60\1\u0131\3\60\3\uffff\2\60\1\uffff\11\60\1\u0147\1\u0148\2\uffff\2\60\1\u014b\2\60\2\uffff\1\60\1\u014f\3\uffff\3\60\1\uffff\1\u0153\1\uffff\2\60\1\u0156\1\60\1\u0117\1\u0158\1\u0159\1\uffff\3\60\1\u0111\1\u011d\1\uffff\2\60\1\u011d\1\u015f\1\u0131\1\uffff\2\u0131\20\60\1\u0171\2\60\2\uffff\2\60\1\uffff\1\u0176\1\u0177\1\60\1\uffff\3\60\1\uffff\1\60\1\u017d\1\uffff\1\60\2\uffff\1\u017f\1\u0180\1\u0181\2\60\1\uffff\16\60\1\u0194\2\60\1\uffff\1\60\1\u0198\1\60\1\u019a\2\uffff\1\u019b\1\u019c\1\u019d\1\60\1\u017f\1\uffff\1\60\3\uffff\12\60\1\u01aa\1\60\1\u01ac\5\60\1\uffff\3\60\1\uffff\1\u01b5\4\uffff\1\u01b6\1\u01b8\1\u01b9\1\u01ba\3\60\1\u01be\4\60\1\uffff\1\60\1\uffff\5\60\1\u01c9\1\60\1\u01cb\2\uffff\1\60\3\uffff\1\u01cd\2\60\1\uffff\6\60\1\u01d6\3\60\1\uffff\1\60\1\uffff\1\60\1\uffff\1\u01dc\1\u01dd\1\60\1\u01df\4\60\1\uffff\1\u01e4\1\u01e5\1\60\1\u01e7\1\60\2\uffff\1\60\1\uffff\1\u01ea\2\60\1\u01ed\2\uffff\1\u01ef\1\uffff\1\60\1\u01f1\1\uffff\1\u01f2\1\60\1\uffff\1\60\1\uffff\1\60\2\uffff\2\60\1\u01f8\2\60\1\uffff\2\60\1\u01fd\1\60\1\uffff\1\u01ff\1\uffff";
    static final String DFA26_eofS =
        "\u0200\uffff";
    static final String DFA26_minS =
        "\1\0\1\101\1\114\1\105\1\106\1\uffff\1\60\1\52\1\uffff\1\75\1\uffff\1\122\1\110\1\103\1\101\1\105\1\111\1\105\1\106\1\111\1\117\1\104\1\101\2\uffff\1\52\1\56\2\uffff\1\76\2\75\1\uffff\1\52\2\117\1\uffff\1\43\1\uffff\1\111\1\43\2\56\3\uffff\1\116\1\123\1\uffff\1\104\1\122\1\123\1\111\1\101\3\60\1\uffff\1\123\1\115\1\105\1\60\1\125\7\uffff\1\111\1\124\1\111\1\122\2\124\1\60\1\122\1\104\1\116\1\122\1\114\1\101\1\124\1\116\1\117\1\116\1\105\1\117\1\130\1\124\3\60\1\116\1\117\1\60\1\117\1\124\1\111\1\116\2\111\1\122\21\uffff\1\104\1\122\3\uffff\1\56\3\uffff\1\43\1\uffff\1\106\1\105\1\137\1\117\1\105\1\124\2\105\1\125\1\114\3\uffff\1\113\1\105\1\116\1\uffff\1\105\1\103\1\117\1\110\1\114\1\104\1\122\1\111\1\uffff\1\101\1\60\1\103\1\60\1\123\1\122\1\120\1\111\1\60\1\107\1\120\1\124\1\101\1\122\1\124\1\60\1\103\1\60\3\uffff\1\124\1\122\1\105\1\uffff\1\114\1\111\1\116\1\124\2\116\3\60\1\uffff\1\111\1\124\1\60\1\103\1\122\1\106\2\60\1\125\1\101\1\124\1\101\1\122\5\60\1\122\1\105\1\122\1\60\1\105\1\60\1\111\1\126\1\131\1\124\1\uffff\2\105\1\124\1\60\1\116\1\uffff\1\114\1\60\1\105\1\60\1\114\1\104\1\60\1\uffff\1\124\1\122\1\uffff\1\60\1\104\2\60\1\114\1\124\1\60\2\124\1\105\3\uffff\1\107\1\101\1\uffff\1\101\1\105\1\122\1\117\1\124\1\111\1\106\1\110\1\101\2\60\2\uffff\2\122\1\60\1\124\1\116\2\uffff\1\125\1\60\3\uffff\1\101\1\123\1\111\1\uffff\1\60\1\uffff\1\116\1\105\1\60\1\111\3\60\1\uffff\1\107\1\105\1\104\2\60\1\uffff\1\111\1\126\3\60\1\uffff\2\60\1\116\1\125\1\105\1\130\1\114\1\122\1\125\2\116\1\123\1\120\1\117\1\116\1\122\1\101\1\115\1\60\1\111\1\122\2\uffff\1\103\1\124\1\uffff\2\60\1\124\1\uffff\1\115\1\123\1\124\1\uffff\1\107\1\60\1\uffff\1\117\2\uffff\3\60\1\126\1\101\1\uffff\1\120\1\124\1\115\1\124\2\117\1\122\1\124\1\106\1\105\1\117\1\105\2\103\1\60\1\124\1\105\1\uffff\1\114\1\60\1\105\1\60\2\uffff\3\60\1\131\1\60\1\uffff\1\116\3\uffff\1\105\1\114\1\125\1\117\2\120\1\105\1\102\1\103\1\101\1\60\1\111\1\60\1\125\1\101\1\122\1\105\1\124\1\uffff\1\105\1\117\1\105\1\uffff\1\60\4\uffff\4\60\1\124\2\125\1\60\1\122\1\101\1\105\1\124\1\uffff\1\107\1\uffff\1\122\1\124\1\101\1\123\1\111\1\60\1\125\1\60\2\uffff\1\102\3\uffff\1\60\2\124\1\uffff\1\116\1\114\1\123\1\111\1\125\1\103\1\60\1\115\1\123\1\117\1\uffff\1\124\1\uffff\1\114\1\uffff\2\60\1\101\1\60\1\123\1\117\1\122\1\105\1\uffff\2\60\1\116\1\60\1\117\2\uffff\1\114\1\uffff\1\60\1\116\1\101\1\60\2\uffff\1\60\1\uffff\1\103\1\60\1\uffff\1\60\1\124\1\uffff\1\102\1\uffff\1\113\2\uffff\1\111\1\114\1\60\2\117\1\uffff\1\116\1\103\1\60\1\113\1\uffff\1\60\1\uffff";
    static final String DFA26_maxS =
        "\1\uffff\1\117\1\130\1\105\1\122\1\uffff\1\172\1\52\1\uffff\1\75\1\uffff\1\122\1\123\1\124\1\125\1\124\1\127\1\117\1\116\1\127\1\131\1\123\1\101\2\uffff\1\52\1\56\2\uffff\2\76\1\75\1\uffff\1\57\2\117\1\uffff\1\163\1\uffff\1\121\3\163\3\uffff\1\116\1\123\1\uffff\1\104\1\122\1\123\1\111\1\124\3\172\1\uffff\1\123\1\115\1\105\1\172\1\125\7\uffff\1\117\1\124\1\111\1\122\2\124\1\172\1\122\1\104\1\116\1\122\1\114\1\122\1\124\1\116\1\117\1\116\1\105\1\117\1\130\1\124\3\172\1\116\1\117\1\172\1\117\1\124\1\111\1\116\2\111\1\122\21\uffff\1\104\1\122\3\uffff\1\163\3\uffff\1\163\1\uffff\1\123\1\105\1\137\1\117\1\111\2\124\1\105\1\125\1\114\3\uffff\1\113\1\105\1\116\1\uffff\1\105\1\107\1\117\1\110\1\114\1\104\1\122\1\111\1\uffff\1\101\1\172\1\103\1\172\1\123\1\124\1\120\1\111\1\172\1\124\1\120\1\124\1\101\1\122\1\124\1\172\1\103\1\172\3\uffff\1\124\1\122\1\105\1\uffff\1\114\1\111\1\116\1\124\2\116\3\172\1\uffff\1\111\1\124\1\172\1\127\1\122\1\106\2\172\1\125\1\101\1\124\1\101\1\122\5\172\1\122\1\105\1\122\1\172\1\105\1\172\1\111\1\126\1\131\1\124\1\uffff\2\105\1\124\1\172\1\116\1\uffff\1\114\1\172\1\105\1\172\1\114\1\104\1\172\1\uffff\1\124\1\122\1\uffff\1\172\1\104\2\172\1\114\1\124\1\172\3\124\3\uffff\1\107\1\101\1\uffff\1\117\1\105\1\122\1\125\1\124\1\111\1\106\1\110\1\101\2\172\2\uffff\2\122\1\172\1\124\1\116\2\uffff\1\125\1\172\3\uffff\1\101\1\123\1\111\1\uffff\1\172\1\uffff\1\116\1\105\1\172\1\111\3\172\1\uffff\1\107\1\105\1\104\2\172\1\uffff\1\111\1\126\3\172\1\uffff\2\172\1\116\1\125\1\105\1\130\1\114\1\122\1\125\2\116\2\123\1\117\1\116\1\122\1\101\1\115\1\172\1\111\1\122\2\uffff\1\103\1\124\1\uffff\2\172\1\124\1\uffff\1\115\1\123\1\124\1\uffff\1\107\1\172\1\uffff\1\117\2\uffff\3\172\1\126\1\101\1\uffff\1\137\1\124\1\115\1\124\2\117\1\122\1\124\1\106\1\105\1\117\1\105\1\107\1\103\1\172\1\124\1\105\1\uffff\1\114\1\172\1\105\1\172\2\uffff\3\172\1\131\1\172\1\uffff\1\116\3\uffff\1\105\1\114\1\125\1\117\2\120\1\105\1\102\1\103\1\101\1\172\1\111\1\172\1\125\1\101\1\122\1\105\1\124\1\uffff\1\105\1\117\1\105\1\uffff\1\172\4\uffff\4\172\1\124\2\125\1\172\1\122\1\101\1\105\1\124\1\uffff\1\107\1\uffff\1\122\1\124\1\101\1\123\1\111\1\172\1\125\1\172\2\uffff\1\102\3\uffff\1\172\2\124\1\uffff\1\116\1\114\1\123\1\111\1\125\1\103\1\172\1\115\1\123\1\117\1\uffff\1\124\1\uffff\1\114\1\uffff\2\172\1\101\1\172\1\123\1\117\1\122\1\105\1\uffff\2\172\1\116\1\172\1\117\2\uffff\1\114\1\uffff\1\172\1\116\1\101\1\172\2\uffff\1\172\1\uffff\1\103\1\172\1\uffff\1\172\1\124\1\uffff\1\102\1\uffff\1\113\2\uffff\1\111\1\114\1\172\2\117\1\uffff\1\116\1\103\1\172\1\113\1\uffff\1\172\1\uffff";
    static final String DFA26_acceptS =
        "\5\uffff\1\6\2\uffff\1\11\1\uffff\1\13\14\uffff\1\105\1\106\2\uffff\1\112\1\113\3\uffff\1\123\3\uffff\1\134\1\uffff\1\137\4\uffff\1\155\1\160\1\161\2\uffff\1\155\10\uffff\1\6\5\uffff\1\136\1\156\1\10\1\11\1\12\1\16\1\13\42\uffff\1\105\1\106\1\135\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\121\1\117\1\122\1\120\1\123\1\157\1\124\2\uffff\1\134\1\151\1\147\1\uffff\1\150\1\140\1\152\1\uffff\1\160\12\uffff\1\4\1\54\1\132\3\uffff\1\61\10\uffff\1\102\22\uffff\1\34\1\47\1\57\3\uffff\1\62\11\uffff\1\153\34\uffff\1\56\5\uffff\1\32\7\uffff\1\126\2\uffff\1\141\12\uffff\1\76\1\125\1\133\2\uffff\1\53\13\uffff\1\51\1\71\5\uffff\1\143\1\7\2\uffff\1\145\1\43\1\154\3\uffff\1\15\1\uffff\1\144\7\uffff\1\36\5\uffff\1\33\5\uffff\1\142\25\uffff\1\37\1\50\2\uffff\1\45\3\uffff\1\46\3\uffff\1\63\2\uffff\1\107\1\uffff\1\27\1\40\5\uffff\1\66\21\uffff\1\52\4\uffff\1\65\1\70\5\uffff\1\20\1\uffff\1\146\1\127\1\30\22\uffff\1\60\3\uffff\1\73\1\uffff\1\41\1\42\1\14\1\17\14\uffff\1\77\1\uffff\1\55\10\uffff\1\3\1\131\1\uffff\1\24\1\35\1\130\3\uffff\1\100\12\uffff\1\31\1\uffff\1\64\1\uffff\1\72\10\uffff\1\67\5\uffff\1\75\1\74\1\uffff\1\103\4\uffff\1\21\1\26\1\uffff\1\44\2\uffff\1\104\2\uffff\1\5\1\uffff\1\25\1\uffff\1\101\1\1\5\uffff\1\22\4\uffff\1\2\1\uffff\1\23";
    static final String DFA26_specialS =
        "\1\0\u01ff\uffff}>";
    static final String[] DFA26_transitionS = {
            "\11\55\2\54\2\55\1\54\22\55\1\54\2\55\1\33\1\55\1\47\1\44\1\55\1\7\1\10\1\31\1\40\1\12\1\34\1\32\1\41\1\52\1\51\1\45\5\52\1\50\1\52\1\11\1\5\1\36\1\35\1\37\2\55\1\15\1\24\1\1\1\23\1\2\1\16\2\53\1\22\2\53\1\20\1\42\1\21\1\4\1\13\1\53\1\3\1\17\1\6\1\25\1\26\1\14\1\43\2\53\1\27\1\55\1\30\1\55\1\53\1\55\32\53\uff85\55",
            "\1\57\15\uffff\1\56",
            "\1\63\1\uffff\1\61\3\uffff\1\62\5\uffff\1\64",
            "\1\65",
            "\1\67\7\uffff\1\66\3\uffff\1\70",
            "",
            "\12\60\7\uffff\1\72\6\60\1\74\1\73\5\60\1\75\2\60\1\76\10\60\4\uffff\1\60\1\uffff\32\60",
            "\1\100",
            "",
            "\1\103",
            "",
            "\1\106",
            "\1\110\1\107\5\uffff\1\111\3\uffff\1\112",
            "\1\113\12\uffff\1\116\3\uffff\1\115\1\uffff\1\114",
            "\1\121\15\uffff\1\120\5\uffff\1\117",
            "\1\123\3\uffff\1\124\12\uffff\1\122",
            "\1\126\5\uffff\1\125\2\uffff\1\127\4\uffff\1\130",
            "\1\131\11\uffff\1\132",
            "\1\134\7\uffff\1\133",
            "\1\136\5\uffff\1\135\7\uffff\1\137",
            "\1\141\11\uffff\1\140",
            "\1\145\4\uffff\1\144\2\uffff\1\146\1\uffff\1\142\4\uffff\1\143",
            "\1\147",
            "",
            "",
            "\1\152",
            "\1\154",
            "",
            "",
            "\1\157",
            "\1\162\1\161",
            "\1\164",
            "",
            "\1\100\4\uffff\1\167",
            "\1\171",
            "\1\172",
            "",
            "\1\174\12\uffff\1\177\1\uffff\12\176\52\uffff\1\46\3\uffff\1\46\4\uffff\1\46\5\uffff\1\46",
            "",
            "\1\u0080\3\uffff\1\u0080\3\uffff\1\u0080",
            "\1\u0081\12\uffff\1\177\1\uffff\12\176\52\uffff\1\46\3\uffff\1\46\4\uffff\1\46\5\uffff\1\46",
            "\1\177\1\uffff\6\176\1\u0082\3\176\52\uffff\1\46\3\uffff\1\46\4\uffff\1\46\5\uffff\1\46",
            "\1\177\1\uffff\12\176\52\uffff\1\46\3\uffff\1\46\4\uffff\1\46\5\uffff\1\46",
            "",
            "",
            "",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008d\16\uffff\1\u008b\2\uffff\1\u008a\1\u008c",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0095",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0097\5\uffff\1\u0096",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3\15\uffff\1\u00a4\2\uffff\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\12\60\7\uffff\1\u00ae\22\60\1\u00af\6\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00b3",
            "\1\u00b4",
            "\12\60\7\uffff\23\60\1\u00b5\6\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00be",
            "\1\u00bf",
            "",
            "",
            "",
            "\1\177\1\uffff\12\176\52\uffff\1\46\3\uffff\1\46\4\uffff\1\46\5\uffff\1\46",
            "",
            "",
            "",
            "\1\u00c0\12\uffff\1\177\1\uffff\12\176\52\uffff\1\46\3\uffff\1\46\4\uffff\1\46\5\uffff\1\46",
            "",
            "\1\u00c1\14\uffff\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c7\3\uffff\1\u00c6",
            "\1\u00c8",
            "\1\u00cb\11\uffff\1\u00c9\4\uffff\1\u00ca",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "",
            "",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "",
            "\1\u00d2",
            "\1\u00d4\3\uffff\1\u00d3",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "\1\u00db",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00dc",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00de",
            "\1\u00e0\1\uffff\1\u00df",
            "\1\u00e1",
            "\1\u00e2",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00e4\14\uffff\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00ec",
            "\12\60\7\uffff\4\60\1\u00ed\25\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\12\60\7\uffff\32\60\4\uffff\1\u00f8\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00fc",
            "\1\u00fd",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00ff\2\uffff\1\u0102\2\uffff\1\u0105\6\uffff\1\u0101\1\uffff\1\u0100\1\u0103\1\u0104\1\uffff\1\u0107\1\u0106",
            "\1\u0108",
            "\1\u0109",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\16\60\1\u0113\2\60\1\u0114\10\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u011c",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0126",
            "",
            "\1\u0127",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0128",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0129",
            "\1\u012a",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u012c",
            "\1\u012d",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u012e",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u012f",
            "\1\u0130",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0132",
            "\1\u0133",
            "\1\u0137\1\uffff\1\u0138\1\uffff\1\u0134\5\uffff\1\u0135\1\u0139\3\uffff\1\u0136",
            "",
            "",
            "",
            "\1\u013a",
            "\1\u013b",
            "",
            "\1\u013d\15\uffff\1\u013c",
            "\1\u013e",
            "\1\u013f",
            "\1\u0141\5\uffff\1\u0140",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "\1\u0149",
            "\1\u014a",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u014c",
            "\1\u014d",
            "",
            "",
            "\1\u014e",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u0154",
            "\1\u0155",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0157",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u015d",
            "\1\u015e",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "\1\u016b\2\uffff\1\u016a",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0172",
            "\1\u0173",
            "",
            "",
            "\1\u0174",
            "\1\u0175",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0178",
            "",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "",
            "\1\u017c",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u017e",
            "",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0182",
            "\1\u0183",
            "",
            "\1\u0184\16\uffff\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "\1\u0192\3\uffff\1\u0191",
            "\1\u0193",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0195",
            "\1\u0196",
            "",
            "\1\u0197",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u0199",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u019e",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u019f",
            "",
            "",
            "",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01ab",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01ad",
            "\1\u01ae",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "",
            "\1\u01b2",
            "\1\u01b3",
            "\1\u01b4",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\u01b7\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01bb",
            "\1\u01bc",
            "\1\u01bd",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01bf",
            "\1\u01c0",
            "\1\u01c1",
            "\1\u01c2",
            "",
            "\1\u01c3",
            "",
            "\1\u01c4",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
            "\1\u01c8",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01ca",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "\1\u01cc",
            "",
            "",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01ce",
            "\1\u01cf",
            "",
            "\1\u01d0",
            "\1\u01d1",
            "\1\u01d2",
            "\1\u01d3",
            "\1\u01d4",
            "\1\u01d5",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01d7",
            "\1\u01d8",
            "\1\u01d9",
            "",
            "\1\u01da",
            "",
            "\1\u01db",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01de",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01e0",
            "\1\u01e1",
            "\1\u01e2",
            "\1\u01e3",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01e6",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01e8",
            "",
            "",
            "\1\u01e9",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01eb",
            "\1\u01ec",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\u01ee\1\uffff\32\60",
            "",
            "\1\u01f0",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01f3",
            "",
            "\1\u01f4",
            "",
            "\1\u01f5",
            "",
            "",
            "\1\u01f6",
            "\1\u01f7",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01f9",
            "\1\u01fa",
            "",
            "\1\u01fb",
            "\1\u01fc",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u01fe",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | RULE_SINGLE_DECLARATION | RULE_INTERVAL_DECLARATION | RULE_PRIORITY_DECLARATION | RULE_OR_OPERATOR | RULE_XOR_OPERATOR | RULE_AND_OPERATOR | RULE_POWER_OPERATOR | RULE_TIME_PREF_LITERAL | RULE_INTERVAL | RULE_DIRECT_VARIABLE | RULE_SIGNED_INTEGER_TYPE_NAME | RULE_UNSIGNED_INTEGER_TYPE_NAME | RULE_REAL_TYPE_NAME | RULE_BIT_STRING_TYPE_NAME | RULE_TIME_TYPE_NAME | RULE_STRING_TYPE_NAME | RULE_INTEGER | RULE_REAL | RULE_BINARY_INTEGER | RULE_OCTAL_INTEGER | RULE_HEX_INTEGER | RULE_BOOLEAN_LITERAL | RULE_ID | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_0 = input.LA(1);

                        s = -1;
                        if ( (LA26_0=='C') ) {s = 1;}

                        else if ( (LA26_0=='E') ) {s = 2;}

                        else if ( (LA26_0=='R') ) {s = 3;}

                        else if ( (LA26_0=='O') ) {s = 4;}

                        else if ( (LA26_0==';') ) {s = 5;}

                        else if ( (LA26_0=='T') ) {s = 6;}

                        else if ( (LA26_0=='(') ) {s = 7;}

                        else if ( (LA26_0==')') ) {s = 8;}

                        else if ( (LA26_0==':') ) {s = 9;}

                        else if ( (LA26_0==',') ) {s = 10;}

                        else if ( (LA26_0=='P') ) {s = 11;}

                        else if ( (LA26_0=='W') ) {s = 12;}

                        else if ( (LA26_0=='A') ) {s = 13;}

                        else if ( (LA26_0=='F') ) {s = 14;}

                        else if ( (LA26_0=='S') ) {s = 15;}

                        else if ( (LA26_0=='L') ) {s = 16;}

                        else if ( (LA26_0=='N') ) {s = 17;}

                        else if ( (LA26_0=='I') ) {s = 18;}

                        else if ( (LA26_0=='D') ) {s = 19;}

                        else if ( (LA26_0=='B') ) {s = 20;}

                        else if ( (LA26_0=='U') ) {s = 21;}

                        else if ( (LA26_0=='V') ) {s = 22;}

                        else if ( (LA26_0=='[') ) {s = 23;}

                        else if ( (LA26_0==']') ) {s = 24;}

                        else if ( (LA26_0=='*') ) {s = 25;}

                        else if ( (LA26_0=='.') ) {s = 26;}

                        else if ( (LA26_0=='#') ) {s = 27;}

                        else if ( (LA26_0=='-') ) {s = 28;}

                        else if ( (LA26_0=='=') ) {s = 29;}

                        else if ( (LA26_0=='<') ) {s = 30;}

                        else if ( (LA26_0=='>') ) {s = 31;}

                        else if ( (LA26_0=='+') ) {s = 32;}

                        else if ( (LA26_0=='/') ) {s = 33;}

                        else if ( (LA26_0=='M') ) {s = 34;}

                        else if ( (LA26_0=='X') ) {s = 35;}

                        else if ( (LA26_0=='&') ) {s = 36;}

                        else if ( (LA26_0=='2') ) {s = 37;}

                        else if ( (LA26_0=='%') ) {s = 39;}

                        else if ( (LA26_0=='8') ) {s = 40;}

                        else if ( (LA26_0=='1') ) {s = 41;}

                        else if ( (LA26_0=='0'||(LA26_0>='3' && LA26_0<='7')||LA26_0=='9') ) {s = 42;}

                        else if ( ((LA26_0>='G' && LA26_0<='H')||(LA26_0>='J' && LA26_0<='K')||LA26_0=='Q'||(LA26_0>='Y' && LA26_0<='Z')||LA26_0=='_'||(LA26_0>='a' && LA26_0<='z')) ) {s = 43;}

                        else if ( ((LA26_0>='\t' && LA26_0<='\n')||LA26_0=='\r'||LA26_0==' ') ) {s = 44;}

                        else if ( ((LA26_0>='\u0000' && LA26_0<='\b')||(LA26_0>='\u000B' && LA26_0<='\f')||(LA26_0>='\u000E' && LA26_0<='\u001F')||(LA26_0>='!' && LA26_0<='\"')||LA26_0=='$'||LA26_0=='\''||(LA26_0>='?' && LA26_0<='@')||LA26_0=='\\'||LA26_0=='^'||LA26_0=='`'||(LA26_0>='{' && LA26_0<='\uFFFF')) ) {s = 45;}

                        else s = 38;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}