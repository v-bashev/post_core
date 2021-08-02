package su.nsk.iae.post.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import su.nsk.iae.post.services.PoSTGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPoSTParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SINGLE_DECLARATION", "RULE_INTERVAL_DECLARATION", "RULE_PRIORITY_DECLARATION", "RULE_INTEGER", "RULE_OR_OPERATOR", "RULE_XOR_OPERATOR", "RULE_AND_OPERATOR", "RULE_POWER_OPERATOR", "RULE_DIRECT_VARIABLE", "RULE_TIME_PREF_LITERAL", "RULE_INTERVAL", "RULE_BIT_STRING_TYPE_NAME", "RULE_TIME_TYPE_NAME", "RULE_STRING_TYPE_NAME", "RULE_REAL_TYPE_NAME", "RULE_SIGNED_INTEGER_TYPE_NAME", "RULE_UNSIGNED_INTEGER_TYPE_NAME", "RULE_BINARY_INTEGER", "RULE_OCTAL_INTEGER", "RULE_HEX_INTEGER", "RULE_BOOLEAN_LITERAL", "RULE_REAL", "RULE_DIRECT_TYPE_PREFIX", "RULE_DIRECT_SIZE_PREFIX", "RULE_DIGIT", "RULE_BIT", "RULE_OCTAL_DIGIT", "RULE_HEX_DIGIT", "RULE_LETTER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'CONFIGURATION'", "'END_CONFIGURATION'", "'RESOURCE'", "'ON'", "'END_RESOURCE'", "';'", "'TASK'", "'('", "')'", "':='", "','", "'PROGRAM'", "'WITH'", "':'", "'PROCESS'", "'ACTIVE'", "'END_PROGRAM'", "'FUNCTION_BLOCK'", "'END_FUNCTION_BLOCK'", "'END_PROCESS'", "'STATE'", "'LOOPED'", "'END_STATE'", "'SET'", "'NEXT'", "'IN'", "'INACTIVE'", "'STOP'", "'ERROR'", "'START'", "'RESTART'", "'TIMEOUT'", "'THEN'", "'END_TIMEOUT'", "'RESET'", "'TIMER'", "'IF'", "'ELSIF'", "'ELSE'", "'END_IF'", "'CASE'", "'OF'", "'END_CASE'", "'FOR'", "'DO'", "'END_FOR'", "'TO'", "'BY'", "'WHILE'", "'END_WHILE'", "'REPEAT'", "'UNTIL'", "'END_REPEAT'", "'RETURN'", "'EXIT'", "'VAR_INPUT'", "'END_VAR'", "'VAR_OUTPUT'", "'VAR_IN_OUT'", "'VAR'", "'CONSTANT'", "'VAR_TEMP'", "'VAR_EXTERNAL'", "'AT'", "'VAR_GLOBAL'", "'VAR_PROCESS'", "'['", "']'", "'ARRAY'", "'*'", "'..'", "'#'", "'-'", "'=>'", "'='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'+'", "'/'", "'MOD'", "'NOT'"
    };
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
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__72=72;
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


        public InternalPoSTParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPoSTParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPoSTParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPoST.g"; }



     	private PoSTGrammarAccess grammarAccess;

        public InternalPoSTParser(TokenStream input, PoSTGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected PoSTGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalPoST.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalPoST.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalPoST.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalPoST.g:72:1: ruleModel returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_conf_1_0 = null;

        EObject lv_globVars_2_0 = null;

        EObject lv_programs_3_0 = null;

        EObject lv_fbs_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:78:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) ) ) )
            // InternalPoST.g:79:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) ) )
            {
            // InternalPoST.g:79:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) ) )
            // InternalPoST.g:80:3: ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) )
            {
            // InternalPoST.g:80:3: ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) )
            // InternalPoST.g:81:4: ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* )
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getModelAccess().getUnorderedGroup());
            			
            // InternalPoST.g:84:4: ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* )
            // InternalPoST.g:85:5: ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )*
            {
            // InternalPoST.g:85:5: ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )*
            loop4:
            do {
                int alt4=5;
                int LA4_0 = input.LA(1);

                if ( LA4_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 0) ) {
                    alt4=1;
                }
                else if ( LA4_0 == 102 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 1) ) {
                    alt4=2;
                }
                else if ( LA4_0 == 49 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 2) ) {
                    alt4=3;
                }
                else if ( LA4_0 == 55 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 3) ) {
                    alt4=4;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalPoST.g:86:3: ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) )
            	    {
            	    // InternalPoST.g:86:3: ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) )
            	    // InternalPoST.g:87:4: {...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalPoST.g:87:99: ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) )
            	    // InternalPoST.g:88:5: ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getModelAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalPoST.g:91:8: ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) )
            	    // InternalPoST.g:91:9: {...}? => ( (lv_conf_1_0= ruleConfiguration ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "true");
            	    }
            	    // InternalPoST.g:91:18: ( (lv_conf_1_0= ruleConfiguration ) )
            	    // InternalPoST.g:91:19: (lv_conf_1_0= ruleConfiguration )
            	    {
            	    // InternalPoST.g:91:19: (lv_conf_1_0= ruleConfiguration )
            	    // InternalPoST.g:92:9: lv_conf_1_0= ruleConfiguration
            	    {

            	    									newCompositeNode(grammarAccess.getModelAccess().getConfConfigurationParserRuleCall_0_0());
            	    								
            	    pushFollow(FOLLOW_3);
            	    lv_conf_1_0=ruleConfiguration();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getModelRule());
            	    									}
            	    									set(
            	    										current,
            	    										"conf",
            	    										lv_conf_1_0,
            	    										"su.nsk.iae.post.PoST.Configuration");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:114:3: ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) )
            	    {
            	    // InternalPoST.g:114:3: ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) )
            	    // InternalPoST.g:115:4: {...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalPoST.g:115:99: ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ )
            	    // InternalPoST.g:116:5: ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getModelAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalPoST.g:119:8: ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+
            	    int cnt1=0;
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==102) ) {
            	            int LA1_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt1=1;
            	            }


            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // InternalPoST.g:119:9: {...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleModel", "true");
            	    	    }
            	    	    // InternalPoST.g:119:18: ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) )
            	    	    // InternalPoST.g:119:19: (lv_globVars_2_0= ruleGlobalVarDeclaration )
            	    	    {
            	    	    // InternalPoST.g:119:19: (lv_globVars_2_0= ruleGlobalVarDeclaration )
            	    	    // InternalPoST.g:120:9: lv_globVars_2_0= ruleGlobalVarDeclaration
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getModelAccess().getGlobVarsGlobalVarDeclarationParserRuleCall_1_0());
            	    	    								
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_globVars_2_0=ruleGlobalVarDeclaration();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getModelRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"globVars",
            	    	    										lv_globVars_2_0,
            	    	    										"su.nsk.iae.post.PoST.GlobalVarDeclaration");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt1 >= 1 ) break loop1;
            	                EarlyExitException eee =
            	                    new EarlyExitException(1, input);
            	                throw eee;
            	        }
            	        cnt1++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalPoST.g:142:3: ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) )
            	    {
            	    // InternalPoST.g:142:3: ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) )
            	    // InternalPoST.g:143:4: {...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalPoST.g:143:99: ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ )
            	    // InternalPoST.g:144:5: ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getModelAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalPoST.g:147:8: ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==49) ) {
            	            int LA2_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt2=1;
            	            }


            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalPoST.g:147:9: {...}? => ( (lv_programs_3_0= ruleProgram ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleModel", "true");
            	    	    }
            	    	    // InternalPoST.g:147:18: ( (lv_programs_3_0= ruleProgram ) )
            	    	    // InternalPoST.g:147:19: (lv_programs_3_0= ruleProgram )
            	    	    {
            	    	    // InternalPoST.g:147:19: (lv_programs_3_0= ruleProgram )
            	    	    // InternalPoST.g:148:9: lv_programs_3_0= ruleProgram
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getModelAccess().getProgramsProgramParserRuleCall_2_0());
            	    	    								
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_programs_3_0=ruleProgram();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getModelRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"programs",
            	    	    										lv_programs_3_0,
            	    	    										"su.nsk.iae.post.PoST.Program");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalPoST.g:170:3: ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) )
            	    {
            	    // InternalPoST.g:170:3: ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) )
            	    // InternalPoST.g:171:4: {...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalPoST.g:171:99: ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ )
            	    // InternalPoST.g:172:5: ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getModelAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalPoST.g:175:8: ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==55) ) {
            	            int LA3_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt3=1;
            	            }


            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalPoST.g:175:9: {...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleModel", "true");
            	    	    }
            	    	    // InternalPoST.g:175:18: ( (lv_fbs_4_0= ruleFunctionBlock ) )
            	    	    // InternalPoST.g:175:19: (lv_fbs_4_0= ruleFunctionBlock )
            	    	    {
            	    	    // InternalPoST.g:175:19: (lv_fbs_4_0= ruleFunctionBlock )
            	    	    // InternalPoST.g:176:9: lv_fbs_4_0= ruleFunctionBlock
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getModelAccess().getFbsFunctionBlockParserRuleCall_3_0());
            	    	    								
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_fbs_4_0=ruleFunctionBlock();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getModelRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"fbs",
            	    	    										lv_fbs_4_0,
            	    	    										"su.nsk.iae.post.PoST.FunctionBlock");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getModelAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleConfiguration"
    // InternalPoST.g:208:1: entryRuleConfiguration returns [EObject current=null] : iv_ruleConfiguration= ruleConfiguration EOF ;
    public final EObject entryRuleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfiguration = null;


        try {
            // InternalPoST.g:208:54: (iv_ruleConfiguration= ruleConfiguration EOF )
            // InternalPoST.g:209:2: iv_ruleConfiguration= ruleConfiguration EOF
            {
             newCompositeNode(grammarAccess.getConfigurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConfiguration=ruleConfiguration();

            state._fsp--;

             current =iv_ruleConfiguration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfiguration"


    // $ANTLR start "ruleConfiguration"
    // InternalPoST.g:215:1: ruleConfiguration returns [EObject current=null] : (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        EObject lv_confGlobVars_2_0 = null;

        EObject lv_resources_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:221:2: ( (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' ) )
            // InternalPoST.g:222:2: (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' )
            {
            // InternalPoST.g:222:2: (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' )
            // InternalPoST.g:223:3: otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getConfigurationAccess().getCONFIGURATIONKeyword_0());
            		
            // InternalPoST.g:227:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:228:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:228:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:229:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConfigurationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConfigurationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            // InternalPoST.g:245:3: ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==102) ) {
                    alt5=1;
                }
                else if ( (LA5_0==40) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalPoST.g:246:4: ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:246:4: ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) )
            	    // InternalPoST.g:247:5: (lv_confGlobVars_2_0= ruleGlobalVarDeclaration )
            	    {
            	    // InternalPoST.g:247:5: (lv_confGlobVars_2_0= ruleGlobalVarDeclaration )
            	    // InternalPoST.g:248:6: lv_confGlobVars_2_0= ruleGlobalVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getConfigurationAccess().getConfGlobVarsGlobalVarDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_confGlobVars_2_0=ruleGlobalVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"confGlobVars",
            	    							lv_confGlobVars_2_0,
            	    							"su.nsk.iae.post.PoST.GlobalVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:266:4: ( (lv_resources_3_0= ruleResource ) )
            	    {
            	    // InternalPoST.g:266:4: ( (lv_resources_3_0= ruleResource ) )
            	    // InternalPoST.g:267:5: (lv_resources_3_0= ruleResource )
            	    {
            	    // InternalPoST.g:267:5: (lv_resources_3_0= ruleResource )
            	    // InternalPoST.g:268:6: lv_resources_3_0= ruleResource
            	    {

            	    						newCompositeNode(grammarAccess.getConfigurationAccess().getResourcesResourceParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_resources_3_0=ruleResource();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"resources",
            	    							lv_resources_3_0,
            	    							"su.nsk.iae.post.PoST.Resource");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getConfigurationAccess().getEND_CONFIGURATIONKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfiguration"


    // $ANTLR start "entryRuleResource"
    // InternalPoST.g:294:1: entryRuleResource returns [EObject current=null] : iv_ruleResource= ruleResource EOF ;
    public final EObject entryRuleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResource = null;


        try {
            // InternalPoST.g:294:49: (iv_ruleResource= ruleResource EOF )
            // InternalPoST.g:295:2: iv_ruleResource= ruleResource EOF
            {
             newCompositeNode(grammarAccess.getResourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResource=ruleResource();

            state._fsp--;

             current =iv_ruleResource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResource"


    // $ANTLR start "ruleResource"
    // InternalPoST.g:301:1: ruleResource returns [EObject current=null] : (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' ) ;
    public final EObject ruleResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_6=null;
        EObject lv_resGlobVars_4_0 = null;

        EObject lv_resStatement_5_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:307:2: ( (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' ) )
            // InternalPoST.g:308:2: (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' )
            {
            // InternalPoST.g:308:2: (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' )
            // InternalPoST.g:309:3: otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getResourceAccess().getRESOURCEKeyword_0());
            		
            // InternalPoST.g:313:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:314:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:314:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:315:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getResourceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getResourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,41,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getResourceAccess().getONKeyword_2());
            		
            // InternalPoST.g:335:3: ( (lv_type_3_0= RULE_ID ) )
            // InternalPoST.g:336:4: (lv_type_3_0= RULE_ID )
            {
            // InternalPoST.g:336:4: (lv_type_3_0= RULE_ID )
            // InternalPoST.g:337:5: lv_type_3_0= RULE_ID
            {
            lv_type_3_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_type_3_0, grammarAccess.getResourceAccess().getTypeIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getResourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_3_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            // InternalPoST.g:353:3: ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==102) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPoST.g:354:4: (lv_resGlobVars_4_0= ruleGlobalVarDeclaration )
            	    {
            	    // InternalPoST.g:354:4: (lv_resGlobVars_4_0= ruleGlobalVarDeclaration )
            	    // InternalPoST.g:355:5: lv_resGlobVars_4_0= ruleGlobalVarDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getResourceAccess().getResGlobVarsGlobalVarDeclarationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_resGlobVars_4_0=ruleGlobalVarDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getResourceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"resGlobVars",
            	    						lv_resGlobVars_4_0,
            	    						"su.nsk.iae.post.PoST.GlobalVarDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalPoST.g:372:3: ( (lv_resStatement_5_0= ruleSingleResource ) )
            // InternalPoST.g:373:4: (lv_resStatement_5_0= ruleSingleResource )
            {
            // InternalPoST.g:373:4: (lv_resStatement_5_0= ruleSingleResource )
            // InternalPoST.g:374:5: lv_resStatement_5_0= ruleSingleResource
            {

            					newCompositeNode(grammarAccess.getResourceAccess().getResStatementSingleResourceParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_8);
            lv_resStatement_5_0=ruleSingleResource();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getResourceRule());
            					}
            					set(
            						current,
            						"resStatement",
            						lv_resStatement_5_0,
            						"su.nsk.iae.post.PoST.SingleResource");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,42,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getResourceAccess().getEND_RESOURCEKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResource"


    // $ANTLR start "entryRuleSingleResource"
    // InternalPoST.g:399:1: entryRuleSingleResource returns [EObject current=null] : iv_ruleSingleResource= ruleSingleResource EOF ;
    public final EObject entryRuleSingleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleResource = null;


        try {
            // InternalPoST.g:399:55: (iv_ruleSingleResource= ruleSingleResource EOF )
            // InternalPoST.g:400:2: iv_ruleSingleResource= ruleSingleResource EOF
            {
             newCompositeNode(grammarAccess.getSingleResourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleResource=ruleSingleResource();

            state._fsp--;

             current =iv_ruleSingleResource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleResource"


    // $ANTLR start "ruleSingleResource"
    // InternalPoST.g:406:1: ruleSingleResource returns [EObject current=null] : ( () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )* ) ;
    public final EObject ruleSingleResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_tasks_1_0 = null;

        EObject lv_programConfs_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:412:2: ( ( () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )* ) )
            // InternalPoST.g:413:2: ( () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )* )
            {
            // InternalPoST.g:413:2: ( () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )* )
            // InternalPoST.g:414:3: () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )*
            {
            // InternalPoST.g:414:3: ()
            // InternalPoST.g:415:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSingleResourceAccess().getSingleResourceAction_0(),
            					current);
            			

            }

            // InternalPoST.g:421:3: ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==44) ) {
                    alt7=1;
                }
                else if ( (LA7_0==49) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPoST.g:422:4: ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' )
            	    {
            	    // InternalPoST.g:422:4: ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' )
            	    // InternalPoST.g:423:5: ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:423:5: ( (lv_tasks_1_0= ruleTask ) )
            	    // InternalPoST.g:424:6: (lv_tasks_1_0= ruleTask )
            	    {
            	    // InternalPoST.g:424:6: (lv_tasks_1_0= ruleTask )
            	    // InternalPoST.g:425:7: lv_tasks_1_0= ruleTask
            	    {

            	    							newCompositeNode(grammarAccess.getSingleResourceAccess().getTasksTaskParserRuleCall_1_0_0_0());
            	    						
            	    pushFollow(FOLLOW_9);
            	    lv_tasks_1_0=ruleTask();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getSingleResourceRule());
            	    							}
            	    							add(
            	    								current,
            	    								"tasks",
            	    								lv_tasks_1_0,
            	    								"su.nsk.iae.post.PoST.Task");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_10); 

            	    					newLeafNode(otherlv_2, grammarAccess.getSingleResourceAccess().getSemicolonKeyword_1_0_1());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:448:4: ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )
            	    {
            	    // InternalPoST.g:448:4: ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )
            	    // InternalPoST.g:449:5: ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';'
            	    {
            	    // InternalPoST.g:449:5: ( (lv_programConfs_3_0= ruleProgramConfiguration ) )
            	    // InternalPoST.g:450:6: (lv_programConfs_3_0= ruleProgramConfiguration )
            	    {
            	    // InternalPoST.g:450:6: (lv_programConfs_3_0= ruleProgramConfiguration )
            	    // InternalPoST.g:451:7: lv_programConfs_3_0= ruleProgramConfiguration
            	    {

            	    							newCompositeNode(grammarAccess.getSingleResourceAccess().getProgramConfsProgramConfigurationParserRuleCall_1_1_0_0());
            	    						
            	    pushFollow(FOLLOW_9);
            	    lv_programConfs_3_0=ruleProgramConfiguration();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getSingleResourceRule());
            	    							}
            	    							add(
            	    								current,
            	    								"programConfs",
            	    								lv_programConfs_3_0,
            	    								"su.nsk.iae.post.PoST.ProgramConfiguration");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    otherlv_4=(Token)match(input,43,FOLLOW_10); 

            	    					newLeafNode(otherlv_4, grammarAccess.getSingleResourceAccess().getSemicolonKeyword_1_1_1());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleResource"


    // $ANTLR start "entryRuleTask"
    // InternalPoST.g:478:1: entryRuleTask returns [EObject current=null] : iv_ruleTask= ruleTask EOF ;
    public final EObject entryRuleTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTask = null;


        try {
            // InternalPoST.g:478:45: (iv_ruleTask= ruleTask EOF )
            // InternalPoST.g:479:2: iv_ruleTask= ruleTask EOF
            {
             newCompositeNode(grammarAccess.getTaskRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTask=ruleTask();

            state._fsp--;

             current =iv_ruleTask; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTask"


    // $ANTLR start "ruleTask"
    // InternalPoST.g:485:1: ruleTask returns [EObject current=null] : (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' ) ;
    public final EObject ruleTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_init_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:491:2: ( (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' ) )
            // InternalPoST.g:492:2: (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' )
            {
            // InternalPoST.g:492:2: (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' )
            // InternalPoST.g:493:3: otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTaskAccess().getTASKKeyword_0());
            		
            // InternalPoST.g:497:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:498:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:498:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:499:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTaskAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTaskRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,45,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getTaskAccess().getLeftParenthesisKeyword_2());
            		
            // InternalPoST.g:519:3: ( (lv_init_3_0= ruleTaskInitialization ) )
            // InternalPoST.g:520:4: (lv_init_3_0= ruleTaskInitialization )
            {
            // InternalPoST.g:520:4: (lv_init_3_0= ruleTaskInitialization )
            // InternalPoST.g:521:5: lv_init_3_0= ruleTaskInitialization
            {

            					newCompositeNode(grammarAccess.getTaskAccess().getInitTaskInitializationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_13);
            lv_init_3_0=ruleTaskInitialization();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTaskRule());
            					}
            					set(
            						current,
            						"init",
            						lv_init_3_0,
            						"su.nsk.iae.post.PoST.TaskInitialization");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,46,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTaskAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTask"


    // $ANTLR start "entryRuleTaskInitialization"
    // InternalPoST.g:546:1: entryRuleTaskInitialization returns [EObject current=null] : iv_ruleTaskInitialization= ruleTaskInitialization EOF ;
    public final EObject entryRuleTaskInitialization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTaskInitialization = null;


        try {
            // InternalPoST.g:546:59: (iv_ruleTaskInitialization= ruleTaskInitialization EOF )
            // InternalPoST.g:547:2: iv_ruleTaskInitialization= ruleTaskInitialization EOF
            {
             newCompositeNode(grammarAccess.getTaskInitializationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTaskInitialization=ruleTaskInitialization();

            state._fsp--;

             current =iv_ruleTaskInitialization; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTaskInitialization"


    // $ANTLR start "ruleTaskInitialization"
    // InternalPoST.g:553:1: ruleTaskInitialization returns [EObject current=null] : ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) ) ;
    public final EObject ruleTaskInitialization() throws RecognitionException {
        EObject current = null;

        Token this_SINGLE_DECLARATION_0=null;
        Token otherlv_1=null;
        Token this_INTERVAL_DECLARATION_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_PRIORITY_DECLARATION_7=null;
        Token otherlv_8=null;
        Token lv_priority_9_0=null;
        EObject lv_single_2_0 = null;

        EObject lv_interval_5_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:559:2: ( ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) ) )
            // InternalPoST.g:560:2: ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) )
            {
            // InternalPoST.g:560:2: ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_SINGLE_DECLARATION) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_INTERVAL_DECLARATION) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalPoST.g:561:3: (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) )
                    {
                    // InternalPoST.g:561:3: (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) )
                    // InternalPoST.g:562:4: this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) )
                    {
                    this_SINGLE_DECLARATION_0=(Token)match(input,RULE_SINGLE_DECLARATION,FOLLOW_14); 

                    				newLeafNode(this_SINGLE_DECLARATION_0, grammarAccess.getTaskInitializationAccess().getSINGLE_DECLARATIONTerminalRuleCall_0_0());
                    			
                    otherlv_1=(Token)match(input,47,FOLLOW_15); 

                    				newLeafNode(otherlv_1, grammarAccess.getTaskInitializationAccess().getColonEqualsSignKeyword_0_1());
                    			
                    // InternalPoST.g:570:4: ( (lv_single_2_0= ruleConstant ) )
                    // InternalPoST.g:571:5: (lv_single_2_0= ruleConstant )
                    {
                    // InternalPoST.g:571:5: (lv_single_2_0= ruleConstant )
                    // InternalPoST.g:572:6: lv_single_2_0= ruleConstant
                    {

                    						newCompositeNode(grammarAccess.getTaskInitializationAccess().getSingleConstantParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_single_2_0=ruleConstant();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTaskInitializationRule());
                    						}
                    						set(
                    							current,
                    							"single",
                    							lv_single_2_0,
                    							"su.nsk.iae.post.PoST.Constant");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:591:3: ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) )
                    {
                    // InternalPoST.g:591:3: ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) )
                    // InternalPoST.g:592:4: (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) )
                    {
                    // InternalPoST.g:592:4: (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) )
                    // InternalPoST.g:593:5: this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) )
                    {
                    this_INTERVAL_DECLARATION_3=(Token)match(input,RULE_INTERVAL_DECLARATION,FOLLOW_14); 

                    					newLeafNode(this_INTERVAL_DECLARATION_3, grammarAccess.getTaskInitializationAccess().getINTERVAL_DECLARATIONTerminalRuleCall_1_0_0());
                    				
                    otherlv_4=(Token)match(input,47,FOLLOW_15); 

                    					newLeafNode(otherlv_4, grammarAccess.getTaskInitializationAccess().getColonEqualsSignKeyword_1_0_1());
                    				
                    // InternalPoST.g:601:5: ( (lv_interval_5_0= ruleConstant ) )
                    // InternalPoST.g:602:6: (lv_interval_5_0= ruleConstant )
                    {
                    // InternalPoST.g:602:6: (lv_interval_5_0= ruleConstant )
                    // InternalPoST.g:603:7: lv_interval_5_0= ruleConstant
                    {

                    							newCompositeNode(grammarAccess.getTaskInitializationAccess().getIntervalConstantParserRuleCall_1_0_2_0());
                    						
                    pushFollow(FOLLOW_16);
                    lv_interval_5_0=ruleConstant();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTaskInitializationRule());
                    							}
                    							set(
                    								current,
                    								"interval",
                    								lv_interval_5_0,
                    								"su.nsk.iae.post.PoST.Constant");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }

                    otherlv_6=(Token)match(input,48,FOLLOW_17); 

                    				newLeafNode(otherlv_6, grammarAccess.getTaskInitializationAccess().getCommaKeyword_1_1());
                    			
                    this_PRIORITY_DECLARATION_7=(Token)match(input,RULE_PRIORITY_DECLARATION,FOLLOW_14); 

                    				newLeafNode(this_PRIORITY_DECLARATION_7, grammarAccess.getTaskInitializationAccess().getPRIORITY_DECLARATIONTerminalRuleCall_1_2());
                    			
                    otherlv_8=(Token)match(input,47,FOLLOW_18); 

                    				newLeafNode(otherlv_8, grammarAccess.getTaskInitializationAccess().getColonEqualsSignKeyword_1_3());
                    			
                    // InternalPoST.g:633:4: ( (lv_priority_9_0= RULE_INTEGER ) )
                    // InternalPoST.g:634:5: (lv_priority_9_0= RULE_INTEGER )
                    {
                    // InternalPoST.g:634:5: (lv_priority_9_0= RULE_INTEGER )
                    // InternalPoST.g:635:6: lv_priority_9_0= RULE_INTEGER
                    {
                    lv_priority_9_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); 

                    						newLeafNode(lv_priority_9_0, grammarAccess.getTaskInitializationAccess().getPriorityINTEGERTerminalRuleCall_1_4_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTaskInitializationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"priority",
                    							lv_priority_9_0,
                    							"su.nsk.iae.post.PoST.INTEGER");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTaskInitialization"


    // $ANTLR start "entryRuleProgramConfiguration"
    // InternalPoST.g:656:1: entryRuleProgramConfiguration returns [EObject current=null] : iv_ruleProgramConfiguration= ruleProgramConfiguration EOF ;
    public final EObject entryRuleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfiguration = null;


        try {
            // InternalPoST.g:656:61: (iv_ruleProgramConfiguration= ruleProgramConfiguration EOF )
            // InternalPoST.g:657:2: iv_ruleProgramConfiguration= ruleProgramConfiguration EOF
            {
             newCompositeNode(grammarAccess.getProgramConfigurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgramConfiguration=ruleProgramConfiguration();

            state._fsp--;

             current =iv_ruleProgramConfiguration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramConfiguration"


    // $ANTLR start "ruleProgramConfiguration"
    // InternalPoST.g:663:1: ruleProgramConfiguration returns [EObject current=null] : (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? ) ;
    public final EObject ruleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_args_7_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:669:2: ( (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? ) )
            // InternalPoST.g:670:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? )
            {
            // InternalPoST.g:670:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? )
            // InternalPoST.g:671:3: otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramConfigurationAccess().getPROGRAMKeyword_0());
            		
            // InternalPoST.g:675:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:676:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:676:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:677:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_1_0, grammarAccess.getProgramConfigurationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProgramConfigurationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            // InternalPoST.g:693:3: (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==50) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalPoST.g:694:4: otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getProgramConfigurationAccess().getWITHKeyword_2_0());
                    			
                    // InternalPoST.g:698:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:699:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:699:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:700:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProgramConfigurationRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_20); 

                    						newLeafNode(otherlv_3, grammarAccess.getProgramConfigurationAccess().getTaskTaskCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,51,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getProgramConfigurationAccess().getColonKeyword_3());
            		
            // InternalPoST.g:716:3: ( (otherlv_5= RULE_ID ) )
            // InternalPoST.g:717:4: (otherlv_5= RULE_ID )
            {
            // InternalPoST.g:717:4: (otherlv_5= RULE_ID )
            // InternalPoST.g:718:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProgramConfigurationRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(otherlv_5, grammarAccess.getProgramConfigurationAccess().getProgramProgramCrossReference_4_0());
            				

            }


            }

            // InternalPoST.g:729:3: (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==45) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPoST.g:730:4: otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,45,FOLLOW_22); 

                    				newLeafNode(otherlv_6, grammarAccess.getProgramConfigurationAccess().getLeftParenthesisKeyword_5_0());
                    			
                    // InternalPoST.g:734:4: ( (lv_args_7_0= ruleProgramConfElements ) )
                    // InternalPoST.g:735:5: (lv_args_7_0= ruleProgramConfElements )
                    {
                    // InternalPoST.g:735:5: (lv_args_7_0= ruleProgramConfElements )
                    // InternalPoST.g:736:6: lv_args_7_0= ruleProgramConfElements
                    {

                    						newCompositeNode(grammarAccess.getProgramConfigurationAccess().getArgsProgramConfElementsParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_args_7_0=ruleProgramConfElements();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProgramConfigurationRule());
                    						}
                    						set(
                    							current,
                    							"args",
                    							lv_args_7_0,
                    							"su.nsk.iae.post.PoST.ProgramConfElements");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,46,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getProgramConfigurationAccess().getRightParenthesisKeyword_5_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramConfiguration"


    // $ANTLR start "entryRuleProgramConfElements"
    // InternalPoST.g:762:1: entryRuleProgramConfElements returns [EObject current=null] : iv_ruleProgramConfElements= ruleProgramConfElements EOF ;
    public final EObject entryRuleProgramConfElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfElements = null;


        try {
            // InternalPoST.g:762:60: (iv_ruleProgramConfElements= ruleProgramConfElements EOF )
            // InternalPoST.g:763:2: iv_ruleProgramConfElements= ruleProgramConfElements EOF
            {
             newCompositeNode(grammarAccess.getProgramConfElementsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgramConfElements=ruleProgramConfElements();

            state._fsp--;

             current =iv_ruleProgramConfElements; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramConfElements"


    // $ANTLR start "ruleProgramConfElements"
    // InternalPoST.g:769:1: ruleProgramConfElements returns [EObject current=null] : ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* ) ;
    public final EObject ruleProgramConfElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:775:2: ( ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* ) )
            // InternalPoST.g:776:2: ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* )
            {
            // InternalPoST.g:776:2: ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* )
            // InternalPoST.g:777:3: ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )*
            {
            // InternalPoST.g:777:3: ( (lv_elements_0_0= ruleProgramConfElement ) )
            // InternalPoST.g:778:4: (lv_elements_0_0= ruleProgramConfElement )
            {
            // InternalPoST.g:778:4: (lv_elements_0_0= ruleProgramConfElement )
            // InternalPoST.g:779:5: lv_elements_0_0= ruleProgramConfElement
            {

            					newCompositeNode(grammarAccess.getProgramConfElementsAccess().getElementsProgramConfElementParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_elements_0_0=ruleProgramConfElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProgramConfElementsRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_0_0,
            						"su.nsk.iae.post.PoST.ProgramConfElement");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:796:3: (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==48) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPoST.g:797:4: otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_22); 

            	    				newLeafNode(otherlv_1, grammarAccess.getProgramConfElementsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:801:4: ( (lv_elements_2_0= ruleProgramConfElement ) )
            	    // InternalPoST.g:802:5: (lv_elements_2_0= ruleProgramConfElement )
            	    {
            	    // InternalPoST.g:802:5: (lv_elements_2_0= ruleProgramConfElement )
            	    // InternalPoST.g:803:6: lv_elements_2_0= ruleProgramConfElement
            	    {

            	    						newCompositeNode(grammarAccess.getProgramConfElementsAccess().getElementsProgramConfElementParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_elements_2_0=ruleProgramConfElement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProgramConfElementsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_2_0,
            	    							"su.nsk.iae.post.PoST.ProgramConfElement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramConfElements"


    // $ANTLR start "entryRuleProgramConfElement"
    // InternalPoST.g:825:1: entryRuleProgramConfElement returns [EObject current=null] : iv_ruleProgramConfElement= ruleProgramConfElement EOF ;
    public final EObject entryRuleProgramConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfElement = null;


        try {
            // InternalPoST.g:825:59: (iv_ruleProgramConfElement= ruleProgramConfElement EOF )
            // InternalPoST.g:826:2: iv_ruleProgramConfElement= ruleProgramConfElement EOF
            {
             newCompositeNode(grammarAccess.getProgramConfElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgramConfElement=ruleProgramConfElement();

            state._fsp--;

             current =iv_ruleProgramConfElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramConfElement"


    // $ANTLR start "ruleProgramConfElement"
    // InternalPoST.g:832:1: ruleProgramConfElement returns [EObject current=null] : (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement ) ;
    public final EObject ruleProgramConfElement() throws RecognitionException {
        EObject current = null;

        EObject this_AttachVariableConfElement_0 = null;

        EObject this_TemplateProcessConfElement_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:838:2: ( (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement ) )
            // InternalPoST.g:839:2: (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement )
            {
            // InternalPoST.g:839:2: (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==52) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalPoST.g:840:3: this_AttachVariableConfElement_0= ruleAttachVariableConfElement
                    {

                    			newCompositeNode(grammarAccess.getProgramConfElementAccess().getAttachVariableConfElementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AttachVariableConfElement_0=ruleAttachVariableConfElement();

                    state._fsp--;


                    			current = this_AttachVariableConfElement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:849:3: this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement
                    {

                    			newCompositeNode(grammarAccess.getProgramConfElementAccess().getTemplateProcessConfElementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TemplateProcessConfElement_1=ruleTemplateProcessConfElement();

                    state._fsp--;


                    			current = this_TemplateProcessConfElement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramConfElement"


    // $ANTLR start "entryRuleAttachVariableConfElement"
    // InternalPoST.g:861:1: entryRuleAttachVariableConfElement returns [EObject current=null] : iv_ruleAttachVariableConfElement= ruleAttachVariableConfElement EOF ;
    public final EObject entryRuleAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttachVariableConfElement = null;


        try {
            // InternalPoST.g:861:66: (iv_ruleAttachVariableConfElement= ruleAttachVariableConfElement EOF )
            // InternalPoST.g:862:2: iv_ruleAttachVariableConfElement= ruleAttachVariableConfElement EOF
            {
             newCompositeNode(grammarAccess.getAttachVariableConfElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttachVariableConfElement=ruleAttachVariableConfElement();

            state._fsp--;

             current =iv_ruleAttachVariableConfElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttachVariableConfElement"


    // $ANTLR start "ruleAttachVariableConfElement"
    // InternalPoST.g:868:1: ruleAttachVariableConfElement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) ;
    public final EObject ruleAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_assig_1_0 = null;

        EObject lv_const_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:874:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) )
            // InternalPoST.g:875:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            {
            // InternalPoST.g:875:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            // InternalPoST.g:876:3: ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            {
            // InternalPoST.g:876:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:877:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:877:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:878:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttachVariableConfElementRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_0, grammarAccess.getAttachVariableConfElementAccess().getProgramVarSymbolicVariableCrossReference_0_0());
            				

            }


            }

            // InternalPoST.g:889:3: ( (lv_assig_1_0= ruleAssignmentType ) )
            // InternalPoST.g:890:4: (lv_assig_1_0= ruleAssignmentType )
            {
            // InternalPoST.g:890:4: (lv_assig_1_0= ruleAssignmentType )
            // InternalPoST.g:891:5: lv_assig_1_0= ruleAssignmentType
            {

            					newCompositeNode(grammarAccess.getAttachVariableConfElementAccess().getAssigAssignmentTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_assig_1_0=ruleAssignmentType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttachVariableConfElementRule());
            					}
            					set(
            						current,
            						"assig",
            						lv_assig_1_0,
            						"su.nsk.iae.post.PoST.AssignmentType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:908:3: ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_INTEGER||LA13_0==RULE_TIME_PREF_LITERAL||(LA13_0>=RULE_REAL_TYPE_NAME && LA13_0<=RULE_REAL)||LA13_0==110) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalPoST.g:909:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalPoST.g:909:4: ( (otherlv_2= RULE_ID ) )
                    // InternalPoST.g:910:5: (otherlv_2= RULE_ID )
                    {
                    // InternalPoST.g:910:5: (otherlv_2= RULE_ID )
                    // InternalPoST.g:911:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttachVariableConfElementRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_2, grammarAccess.getAttachVariableConfElementAccess().getAttVarSymbolicVariableCrossReference_2_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:923:4: ( (lv_const_3_0= ruleConstant ) )
                    {
                    // InternalPoST.g:923:4: ( (lv_const_3_0= ruleConstant ) )
                    // InternalPoST.g:924:5: (lv_const_3_0= ruleConstant )
                    {
                    // InternalPoST.g:924:5: (lv_const_3_0= ruleConstant )
                    // InternalPoST.g:925:6: lv_const_3_0= ruleConstant
                    {

                    						newCompositeNode(grammarAccess.getAttachVariableConfElementAccess().getConstConstantParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_const_3_0=ruleConstant();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttachVariableConfElementRule());
                    						}
                    						set(
                    							current,
                    							"const",
                    							lv_const_3_0,
                    							"su.nsk.iae.post.PoST.Constant");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttachVariableConfElement"


    // $ANTLR start "entryRuleTemplateProcessConfElement"
    // InternalPoST.g:947:1: entryRuleTemplateProcessConfElement returns [EObject current=null] : iv_ruleTemplateProcessConfElement= ruleTemplateProcessConfElement EOF ;
    public final EObject entryRuleTemplateProcessConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateProcessConfElement = null;


        try {
            // InternalPoST.g:947:67: (iv_ruleTemplateProcessConfElement= ruleTemplateProcessConfElement EOF )
            // InternalPoST.g:948:2: iv_ruleTemplateProcessConfElement= ruleTemplateProcessConfElement EOF
            {
             newCompositeNode(grammarAccess.getTemplateProcessConfElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemplateProcessConfElement=ruleTemplateProcessConfElement();

            state._fsp--;

             current =iv_ruleTemplateProcessConfElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateProcessConfElement"


    // $ANTLR start "ruleTemplateProcessConfElement"
    // InternalPoST.g:954:1: ruleTemplateProcessConfElement returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )? ) ;
    public final EObject ruleTemplateProcessConfElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_active_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_args_6_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:960:2: ( (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )? ) )
            // InternalPoST.g:961:2: (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )? )
            {
            // InternalPoST.g:961:2: (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )? )
            // InternalPoST.g:962:3: otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getTemplateProcessConfElementAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:966:3: ( (lv_active_1_0= 'ACTIVE' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==53) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalPoST.g:967:4: (lv_active_1_0= 'ACTIVE' )
                    {
                    // InternalPoST.g:967:4: (lv_active_1_0= 'ACTIVE' )
                    // InternalPoST.g:968:5: lv_active_1_0= 'ACTIVE'
                    {
                    lv_active_1_0=(Token)match(input,53,FOLLOW_4); 

                    					newLeafNode(lv_active_1_0, grammarAccess.getTemplateProcessConfElementAccess().getActiveACTIVEKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTemplateProcessConfElementRule());
                    					}
                    					setWithLastConsumed(current, "active", lv_active_1_0 != null, "ACTIVE");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:980:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalPoST.g:981:4: (lv_name_2_0= RULE_ID )
            {
            // InternalPoST.g:981:4: (lv_name_2_0= RULE_ID )
            // InternalPoST.g:982:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTemplateProcessConfElementAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemplateProcessConfElementRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,51,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getTemplateProcessConfElementAccess().getColonKeyword_3());
            		
            // InternalPoST.g:1002:3: ( (otherlv_4= RULE_ID ) )
            // InternalPoST.g:1003:4: (otherlv_4= RULE_ID )
            {
            // InternalPoST.g:1003:4: (otherlv_4= RULE_ID )
            // InternalPoST.g:1004:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemplateProcessConfElementRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(otherlv_4, grammarAccess.getTemplateProcessConfElementAccess().getProcessProcessCrossReference_4_0());
            				

            }


            }

            // InternalPoST.g:1015:3: (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==45) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalPoST.g:1016:4: otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getTemplateProcessConfElementAccess().getLeftParenthesisKeyword_5_0());
                    			
                    // InternalPoST.g:1020:4: ( (lv_args_6_0= ruleTemplateProcessElements ) )
                    // InternalPoST.g:1021:5: (lv_args_6_0= ruleTemplateProcessElements )
                    {
                    // InternalPoST.g:1021:5: (lv_args_6_0= ruleTemplateProcessElements )
                    // InternalPoST.g:1022:6: lv_args_6_0= ruleTemplateProcessElements
                    {

                    						newCompositeNode(grammarAccess.getTemplateProcessConfElementAccess().getArgsTemplateProcessElementsParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_args_6_0=ruleTemplateProcessElements();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTemplateProcessConfElementRule());
                    						}
                    						set(
                    							current,
                    							"args",
                    							lv_args_6_0,
                    							"su.nsk.iae.post.PoST.TemplateProcessElements");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,46,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getTemplateProcessConfElementAccess().getRightParenthesisKeyword_5_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateProcessConfElement"


    // $ANTLR start "entryRuleTemplateProcessElements"
    // InternalPoST.g:1048:1: entryRuleTemplateProcessElements returns [EObject current=null] : iv_ruleTemplateProcessElements= ruleTemplateProcessElements EOF ;
    public final EObject entryRuleTemplateProcessElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateProcessElements = null;


        try {
            // InternalPoST.g:1048:64: (iv_ruleTemplateProcessElements= ruleTemplateProcessElements EOF )
            // InternalPoST.g:1049:2: iv_ruleTemplateProcessElements= ruleTemplateProcessElements EOF
            {
             newCompositeNode(grammarAccess.getTemplateProcessElementsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemplateProcessElements=ruleTemplateProcessElements();

            state._fsp--;

             current =iv_ruleTemplateProcessElements; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateProcessElements"


    // $ANTLR start "ruleTemplateProcessElements"
    // InternalPoST.g:1055:1: ruleTemplateProcessElements returns [EObject current=null] : ( ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )* ) ;
    public final EObject ruleTemplateProcessElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1061:2: ( ( ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )* ) )
            // InternalPoST.g:1062:2: ( ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )* )
            {
            // InternalPoST.g:1062:2: ( ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )* )
            // InternalPoST.g:1063:3: ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )*
            {
            // InternalPoST.g:1063:3: ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) )
            // InternalPoST.g:1064:4: (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement )
            {
            // InternalPoST.g:1064:4: (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement )
            // InternalPoST.g:1065:5: lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement
            {

            					newCompositeNode(grammarAccess.getTemplateProcessElementsAccess().getElementsTemplateProcessAttachVariableConfElementParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_elements_0_0=ruleTemplateProcessAttachVariableConfElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemplateProcessElementsRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_0_0,
            						"su.nsk.iae.post.PoST.TemplateProcessAttachVariableConfElement");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:1082:3: (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==48) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPoST.g:1083:4: otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getTemplateProcessElementsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:1087:4: ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) )
            	    // InternalPoST.g:1088:5: (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement )
            	    {
            	    // InternalPoST.g:1088:5: (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement )
            	    // InternalPoST.g:1089:6: lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement
            	    {

            	    						newCompositeNode(grammarAccess.getTemplateProcessElementsAccess().getElementsTemplateProcessAttachVariableConfElementParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_elements_2_0=ruleTemplateProcessAttachVariableConfElement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTemplateProcessElementsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_2_0,
            	    							"su.nsk.iae.post.PoST.TemplateProcessAttachVariableConfElement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateProcessElements"


    // $ANTLR start "entryRuleTemplateProcessAttachVariableConfElement"
    // InternalPoST.g:1111:1: entryRuleTemplateProcessAttachVariableConfElement returns [EObject current=null] : iv_ruleTemplateProcessAttachVariableConfElement= ruleTemplateProcessAttachVariableConfElement EOF ;
    public final EObject entryRuleTemplateProcessAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateProcessAttachVariableConfElement = null;


        try {
            // InternalPoST.g:1111:81: (iv_ruleTemplateProcessAttachVariableConfElement= ruleTemplateProcessAttachVariableConfElement EOF )
            // InternalPoST.g:1112:2: iv_ruleTemplateProcessAttachVariableConfElement= ruleTemplateProcessAttachVariableConfElement EOF
            {
             newCompositeNode(grammarAccess.getTemplateProcessAttachVariableConfElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemplateProcessAttachVariableConfElement=ruleTemplateProcessAttachVariableConfElement();

            state._fsp--;

             current =iv_ruleTemplateProcessAttachVariableConfElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateProcessAttachVariableConfElement"


    // $ANTLR start "ruleTemplateProcessAttachVariableConfElement"
    // InternalPoST.g:1118:1: ruleTemplateProcessAttachVariableConfElement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) ;
    public final EObject ruleTemplateProcessAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_assig_1_0 = null;

        EObject lv_const_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1124:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) )
            // InternalPoST.g:1125:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            {
            // InternalPoST.g:1125:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            // InternalPoST.g:1126:3: ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            {
            // InternalPoST.g:1126:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:1127:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:1127:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:1128:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemplateProcessAttachVariableConfElementRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_0, grammarAccess.getTemplateProcessAttachVariableConfElementAccess().getProgramVarVariableCrossReference_0_0());
            				

            }


            }

            // InternalPoST.g:1139:3: ( (lv_assig_1_0= ruleAssignmentType ) )
            // InternalPoST.g:1140:4: (lv_assig_1_0= ruleAssignmentType )
            {
            // InternalPoST.g:1140:4: (lv_assig_1_0= ruleAssignmentType )
            // InternalPoST.g:1141:5: lv_assig_1_0= ruleAssignmentType
            {

            					newCompositeNode(grammarAccess.getTemplateProcessAttachVariableConfElementAccess().getAssigAssignmentTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_assig_1_0=ruleAssignmentType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemplateProcessAttachVariableConfElementRule());
            					}
            					set(
            						current,
            						"assig",
            						lv_assig_1_0,
            						"su.nsk.iae.post.PoST.AssignmentType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:1158:3: ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_INTEGER||LA17_0==RULE_TIME_PREF_LITERAL||(LA17_0>=RULE_REAL_TYPE_NAME && LA17_0<=RULE_REAL)||LA17_0==110) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalPoST.g:1159:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalPoST.g:1159:4: ( (otherlv_2= RULE_ID ) )
                    // InternalPoST.g:1160:5: (otherlv_2= RULE_ID )
                    {
                    // InternalPoST.g:1160:5: (otherlv_2= RULE_ID )
                    // InternalPoST.g:1161:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTemplateProcessAttachVariableConfElementRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_2, grammarAccess.getTemplateProcessAttachVariableConfElementAccess().getAttVarVariableCrossReference_2_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:1173:4: ( (lv_const_3_0= ruleConstant ) )
                    {
                    // InternalPoST.g:1173:4: ( (lv_const_3_0= ruleConstant ) )
                    // InternalPoST.g:1174:5: (lv_const_3_0= ruleConstant )
                    {
                    // InternalPoST.g:1174:5: (lv_const_3_0= ruleConstant )
                    // InternalPoST.g:1175:6: lv_const_3_0= ruleConstant
                    {

                    						newCompositeNode(grammarAccess.getTemplateProcessAttachVariableConfElementAccess().getConstConstantParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_const_3_0=ruleConstant();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTemplateProcessAttachVariableConfElementRule());
                    						}
                    						set(
                    							current,
                    							"const",
                    							lv_const_3_0,
                    							"su.nsk.iae.post.PoST.Constant");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateProcessAttachVariableConfElement"


    // $ANTLR start "entryRuleProgram"
    // InternalPoST.g:1197:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalPoST.g:1197:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalPoST.g:1198:2: iv_ruleProgram= ruleProgram EOF
            {
             newCompositeNode(grammarAccess.getProgramRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalPoST.g:1204:1: ruleProgram returns [EObject current=null] : (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_9=null;
        EObject lv_progInVars_2_0 = null;

        EObject lv_progOutVars_3_0 = null;

        EObject lv_progInOutVars_4_0 = null;

        EObject lv_progVars_5_0 = null;

        EObject lv_progTempVars_6_0 = null;

        EObject lv_progExternVars_7_0 = null;

        EObject lv_processes_8_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1210:2: ( (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' ) )
            // InternalPoST.g:1211:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' )
            {
            // InternalPoST.g:1211:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' )
            // InternalPoST.g:1212:3: otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramAccess().getPROGRAMKeyword_0());
            		
            // InternalPoST.g:1216:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1217:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1217:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1218:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_1_0, grammarAccess.getProgramAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProgramRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            // InternalPoST.g:1234:3: ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )*
            loop18:
            do {
                int alt18=7;
                switch ( input.LA(1) ) {
                case 93:
                    {
                    alt18=1;
                    }
                    break;
                case 95:
                    {
                    alt18=2;
                    }
                    break;
                case 96:
                    {
                    alt18=3;
                    }
                    break;
                case 97:
                    {
                    alt18=4;
                    }
                    break;
                case 99:
                    {
                    alt18=5;
                    }
                    break;
                case 100:
                    {
                    alt18=6;
                    }
                    break;

                }

                switch (alt18) {
            	case 1 :
            	    // InternalPoST.g:1235:4: ( (lv_progInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1235:4: ( (lv_progInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1236:5: (lv_progInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1236:5: (lv_progInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1237:6: lv_progInVars_2_0= ruleInputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgInVarsInputVarDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    lv_progInVars_2_0=ruleInputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProgramRule());
            	    						}
            	    						add(
            	    							current,
            	    							"progInVars",
            	    							lv_progInVars_2_0,
            	    							"su.nsk.iae.post.PoST.InputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:1255:4: ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1255:4: ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1256:5: (lv_progOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1256:5: (lv_progOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1257:6: lv_progOutVars_3_0= ruleOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgOutVarsOutputVarDeclarationParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    lv_progOutVars_3_0=ruleOutputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProgramRule());
            	    						}
            	    						add(
            	    							current,
            	    							"progOutVars",
            	    							lv_progOutVars_3_0,
            	    							"su.nsk.iae.post.PoST.OutputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalPoST.g:1275:4: ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1275:4: ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1276:5: (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1276:5: (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1277:6: lv_progInOutVars_4_0= ruleInputOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgInOutVarsInputOutputVarDeclarationParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    lv_progInOutVars_4_0=ruleInputOutputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProgramRule());
            	    						}
            	    						add(
            	    							current,
            	    							"progInOutVars",
            	    							lv_progInOutVars_4_0,
            	    							"su.nsk.iae.post.PoST.InputOutputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalPoST.g:1295:4: ( (lv_progVars_5_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1295:4: ( (lv_progVars_5_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1296:5: (lv_progVars_5_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1296:5: (lv_progVars_5_0= ruleVarDeclaration )
            	    // InternalPoST.g:1297:6: lv_progVars_5_0= ruleVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgVarsVarDeclarationParserRuleCall_2_3_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    lv_progVars_5_0=ruleVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProgramRule());
            	    						}
            	    						add(
            	    							current,
            	    							"progVars",
            	    							lv_progVars_5_0,
            	    							"su.nsk.iae.post.PoST.VarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalPoST.g:1315:4: ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1315:4: ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1316:5: (lv_progTempVars_6_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1316:5: (lv_progTempVars_6_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1317:6: lv_progTempVars_6_0= ruleTempVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgTempVarsTempVarDeclarationParserRuleCall_2_4_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    lv_progTempVars_6_0=ruleTempVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProgramRule());
            	    						}
            	    						add(
            	    							current,
            	    							"progTempVars",
            	    							lv_progTempVars_6_0,
            	    							"su.nsk.iae.post.PoST.TempVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalPoST.g:1335:4: ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1335:4: ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) )
            	    // InternalPoST.g:1336:5: (lv_progExternVars_7_0= ruleExternalVarDeclaration )
            	    {
            	    // InternalPoST.g:1336:5: (lv_progExternVars_7_0= ruleExternalVarDeclaration )
            	    // InternalPoST.g:1337:6: lv_progExternVars_7_0= ruleExternalVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgExternVarsExternalVarDeclarationParserRuleCall_2_5_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    lv_progExternVars_7_0=ruleExternalVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProgramRule());
            	    						}
            	    						add(
            	    							current,
            	    							"progExternVars",
            	    							lv_progExternVars_7_0,
            	    							"su.nsk.iae.post.PoST.ExternalVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // InternalPoST.g:1355:3: ( (lv_processes_8_0= ruleProcess ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==52) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalPoST.g:1356:4: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalPoST.g:1356:4: (lv_processes_8_0= ruleProcess )
            	    // InternalPoST.g:1357:5: lv_processes_8_0= ruleProcess
            	    {

            	    					newCompositeNode(grammarAccess.getProgramAccess().getProcessesProcessParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_28);
            	    lv_processes_8_0=ruleProcess();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProgramRule());
            	    					}
            	    					add(
            	    						current,
            	    						"processes",
            	    						lv_processes_8_0,
            	    						"su.nsk.iae.post.PoST.Process");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_9=(Token)match(input,54,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getProgramAccess().getEND_PROGRAMKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleFunctionBlock"
    // InternalPoST.g:1382:1: entryRuleFunctionBlock returns [EObject current=null] : iv_ruleFunctionBlock= ruleFunctionBlock EOF ;
    public final EObject entryRuleFunctionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionBlock = null;


        try {
            // InternalPoST.g:1382:54: (iv_ruleFunctionBlock= ruleFunctionBlock EOF )
            // InternalPoST.g:1383:2: iv_ruleFunctionBlock= ruleFunctionBlock EOF
            {
             newCompositeNode(grammarAccess.getFunctionBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionBlock=ruleFunctionBlock();

            state._fsp--;

             current =iv_ruleFunctionBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionBlock"


    // $ANTLR start "ruleFunctionBlock"
    // InternalPoST.g:1389:1: ruleFunctionBlock returns [EObject current=null] : (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' ) ;
    public final EObject ruleFunctionBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_9=null;
        EObject lv_fbInVars_2_0 = null;

        EObject lv_fbOutVars_3_0 = null;

        EObject lv_fbInOutVars_4_0 = null;

        EObject lv_fbVars_5_0 = null;

        EObject lv_fbTempVars_6_0 = null;

        EObject lv_fbExternVars_7_0 = null;

        EObject lv_processes_8_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1395:2: ( (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' ) )
            // InternalPoST.g:1396:2: (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' )
            {
            // InternalPoST.g:1396:2: (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' )
            // InternalPoST.g:1397:3: otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionBlockAccess().getFUNCTION_BLOCKKeyword_0());
            		
            // InternalPoST.g:1401:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1402:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1402:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1403:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFunctionBlockAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionBlockRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            // InternalPoST.g:1419:3: ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )*
            loop20:
            do {
                int alt20=7;
                switch ( input.LA(1) ) {
                case 93:
                    {
                    alt20=1;
                    }
                    break;
                case 95:
                    {
                    alt20=2;
                    }
                    break;
                case 96:
                    {
                    alt20=3;
                    }
                    break;
                case 97:
                    {
                    alt20=4;
                    }
                    break;
                case 99:
                    {
                    alt20=5;
                    }
                    break;
                case 100:
                    {
                    alt20=6;
                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // InternalPoST.g:1420:4: ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1420:4: ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1421:5: (lv_fbInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1421:5: (lv_fbInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1422:6: lv_fbInVars_2_0= ruleInputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbInVarsInputVarDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_fbInVars_2_0=ruleInputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionBlockRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fbInVars",
            	    							lv_fbInVars_2_0,
            	    							"su.nsk.iae.post.PoST.InputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:1440:4: ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1440:4: ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1441:5: (lv_fbOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1441:5: (lv_fbOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1442:6: lv_fbOutVars_3_0= ruleOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbOutVarsOutputVarDeclarationParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_fbOutVars_3_0=ruleOutputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionBlockRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fbOutVars",
            	    							lv_fbOutVars_3_0,
            	    							"su.nsk.iae.post.PoST.OutputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalPoST.g:1460:4: ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1460:4: ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1461:5: (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1461:5: (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1462:6: lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbInOutVarsInputOutputVarDeclarationParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_fbInOutVars_4_0=ruleInputOutputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionBlockRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fbInOutVars",
            	    							lv_fbInOutVars_4_0,
            	    							"su.nsk.iae.post.PoST.InputOutputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalPoST.g:1480:4: ( (lv_fbVars_5_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1480:4: ( (lv_fbVars_5_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1481:5: (lv_fbVars_5_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1481:5: (lv_fbVars_5_0= ruleVarDeclaration )
            	    // InternalPoST.g:1482:6: lv_fbVars_5_0= ruleVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbVarsVarDeclarationParserRuleCall_2_3_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_fbVars_5_0=ruleVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionBlockRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fbVars",
            	    							lv_fbVars_5_0,
            	    							"su.nsk.iae.post.PoST.VarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalPoST.g:1500:4: ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1500:4: ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1501:5: (lv_fbTempVars_6_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1501:5: (lv_fbTempVars_6_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1502:6: lv_fbTempVars_6_0= ruleTempVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbTempVarsTempVarDeclarationParserRuleCall_2_4_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_fbTempVars_6_0=ruleTempVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionBlockRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fbTempVars",
            	    							lv_fbTempVars_6_0,
            	    							"su.nsk.iae.post.PoST.TempVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalPoST.g:1520:4: ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1520:4: ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) )
            	    // InternalPoST.g:1521:5: (lv_fbExternVars_7_0= ruleExternalVarDeclaration )
            	    {
            	    // InternalPoST.g:1521:5: (lv_fbExternVars_7_0= ruleExternalVarDeclaration )
            	    // InternalPoST.g:1522:6: lv_fbExternVars_7_0= ruleExternalVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbExternVarsExternalVarDeclarationParserRuleCall_2_5_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_fbExternVars_7_0=ruleExternalVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionBlockRule());
            	    						}
            	    						add(
            	    							current,
            	    							"fbExternVars",
            	    							lv_fbExternVars_7_0,
            	    							"su.nsk.iae.post.PoST.ExternalVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // InternalPoST.g:1540:3: ( (lv_processes_8_0= ruleProcess ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==52) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalPoST.g:1541:4: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalPoST.g:1541:4: (lv_processes_8_0= ruleProcess )
            	    // InternalPoST.g:1542:5: lv_processes_8_0= ruleProcess
            	    {

            	    					newCompositeNode(grammarAccess.getFunctionBlockAccess().getProcessesProcessParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_30);
            	    lv_processes_8_0=ruleProcess();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFunctionBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"processes",
            	    						lv_processes_8_0,
            	    						"su.nsk.iae.post.PoST.Process");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_9=(Token)match(input,56,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getFunctionBlockAccess().getEND_FUNCTION_BLOCKKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionBlock"


    // $ANTLR start "entryRuleProcess"
    // InternalPoST.g:1567:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalPoST.g:1567:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalPoST.g:1568:2: iv_ruleProcess= ruleProcess EOF
            {
             newCompositeNode(grammarAccess.getProcessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;

             current =iv_ruleProcess; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalPoST.g:1574:1: ruleProcess returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_9=null;
        EObject lv_procInVars_2_0 = null;

        EObject lv_procOutVars_3_0 = null;

        EObject lv_procInOutVars_4_0 = null;

        EObject lv_procProcessVars_5_0 = null;

        EObject lv_procVars_6_0 = null;

        EObject lv_procTempVars_7_0 = null;

        EObject lv_states_8_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1580:2: ( (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS' ) )
            // InternalPoST.g:1581:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS' )
            {
            // InternalPoST.g:1581:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS' )
            // InternalPoST.g:1582:3: otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:1586:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1587:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1587:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1588:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(lv_name_1_0, grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            // InternalPoST.g:1604:3: ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )*
            loop22:
            do {
                int alt22=7;
                switch ( input.LA(1) ) {
                case 93:
                    {
                    alt22=1;
                    }
                    break;
                case 95:
                    {
                    alt22=2;
                    }
                    break;
                case 96:
                    {
                    alt22=3;
                    }
                    break;
                case 103:
                    {
                    alt22=4;
                    }
                    break;
                case 97:
                    {
                    alt22=5;
                    }
                    break;
                case 99:
                    {
                    alt22=6;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // InternalPoST.g:1605:4: ( (lv_procInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1605:4: ( (lv_procInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1606:5: (lv_procInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1606:5: (lv_procInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1607:6: lv_procInVars_2_0= ruleInputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcInVarsInputVarDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_procInVars_2_0=ruleInputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procInVars",
            	    							lv_procInVars_2_0,
            	    							"su.nsk.iae.post.PoST.InputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:1625:4: ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1625:4: ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1626:5: (lv_procOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1626:5: (lv_procOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1627:6: lv_procOutVars_3_0= ruleOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcOutVarsOutputVarDeclarationParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_procOutVars_3_0=ruleOutputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procOutVars",
            	    							lv_procOutVars_3_0,
            	    							"su.nsk.iae.post.PoST.OutputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalPoST.g:1645:4: ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1645:4: ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1646:5: (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1646:5: (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1647:6: lv_procInOutVars_4_0= ruleInputOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcInOutVarsInputOutputVarDeclarationParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_procInOutVars_4_0=ruleInputOutputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procInOutVars",
            	    							lv_procInOutVars_4_0,
            	    							"su.nsk.iae.post.PoST.InputOutputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalPoST.g:1665:4: ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1665:4: ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) )
            	    // InternalPoST.g:1666:5: (lv_procProcessVars_5_0= ruleProcessVarDeclaration )
            	    {
            	    // InternalPoST.g:1666:5: (lv_procProcessVars_5_0= ruleProcessVarDeclaration )
            	    // InternalPoST.g:1667:6: lv_procProcessVars_5_0= ruleProcessVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcProcessVarsProcessVarDeclarationParserRuleCall_2_3_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_procProcessVars_5_0=ruleProcessVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procProcessVars",
            	    							lv_procProcessVars_5_0,
            	    							"su.nsk.iae.post.PoST.ProcessVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalPoST.g:1685:4: ( (lv_procVars_6_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1685:4: ( (lv_procVars_6_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1686:5: (lv_procVars_6_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1686:5: (lv_procVars_6_0= ruleVarDeclaration )
            	    // InternalPoST.g:1687:6: lv_procVars_6_0= ruleVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcVarsVarDeclarationParserRuleCall_2_4_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_procVars_6_0=ruleVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procVars",
            	    							lv_procVars_6_0,
            	    							"su.nsk.iae.post.PoST.VarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalPoST.g:1705:4: ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1705:4: ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1706:5: (lv_procTempVars_7_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1706:5: (lv_procTempVars_7_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1707:6: lv_procTempVars_7_0= ruleTempVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcTempVarsTempVarDeclarationParserRuleCall_2_5_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_procTempVars_7_0=ruleTempVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procTempVars",
            	    							lv_procTempVars_7_0,
            	    							"su.nsk.iae.post.PoST.TempVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // InternalPoST.g:1725:3: ( (lv_states_8_0= ruleState ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==58) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalPoST.g:1726:4: (lv_states_8_0= ruleState )
            	    {
            	    // InternalPoST.g:1726:4: (lv_states_8_0= ruleState )
            	    // InternalPoST.g:1727:5: lv_states_8_0= ruleState
            	    {

            	    					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_states_8_0=ruleState();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProcessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"states",
            	    						lv_states_8_0,
            	    						"su.nsk.iae.post.PoST.State");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_9=(Token)match(input,57,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getProcessAccess().getEND_PROCESSKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleState"
    // InternalPoST.g:1752:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalPoST.g:1752:46: (iv_ruleState= ruleState EOF )
            // InternalPoST.g:1753:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalPoST.g:1759:1: ruleState returns [EObject current=null] : (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_looped_2_0=null;
        Token otherlv_5=null;
        EObject lv_statement_3_0 = null;

        EObject lv_timeout_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1765:2: ( (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' ) )
            // InternalPoST.g:1766:2: (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' )
            {
            // InternalPoST.g:1766:2: (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' )
            // InternalPoST.g:1767:3: otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getSTATEKeyword_0());
            		
            // InternalPoST.g:1771:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1772:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1772:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1773:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            // InternalPoST.g:1789:3: ( (lv_looped_2_0= 'LOOPED' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==59) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalPoST.g:1790:4: (lv_looped_2_0= 'LOOPED' )
                    {
                    // InternalPoST.g:1790:4: (lv_looped_2_0= 'LOOPED' )
                    // InternalPoST.g:1791:5: lv_looped_2_0= 'LOOPED'
                    {
                    lv_looped_2_0=(Token)match(input,59,FOLLOW_34); 

                    					newLeafNode(lv_looped_2_0, grammarAccess.getStateAccess().getLoopedLOOPEDKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getStateRule());
                    					}
                    					setWithLastConsumed(current, "looped", lv_looped_2_0 != null, "LOOPED");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:1803:3: ( (lv_statement_3_0= ruleStatementList ) )
            // InternalPoST.g:1804:4: (lv_statement_3_0= ruleStatementList )
            {
            // InternalPoST.g:1804:4: (lv_statement_3_0= ruleStatementList )
            // InternalPoST.g:1805:5: lv_statement_3_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getStateAccess().getStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_35);
            lv_statement_3_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateRule());
            					}
            					set(
            						current,
            						"statement",
            						lv_statement_3_0,
            						"su.nsk.iae.post.PoST.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:1822:3: ( (lv_timeout_4_0= ruleTimeoutStatement ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==69) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalPoST.g:1823:4: (lv_timeout_4_0= ruleTimeoutStatement )
                    {
                    // InternalPoST.g:1823:4: (lv_timeout_4_0= ruleTimeoutStatement )
                    // InternalPoST.g:1824:5: lv_timeout_4_0= ruleTimeoutStatement
                    {

                    					newCompositeNode(grammarAccess.getStateAccess().getTimeoutTimeoutStatementParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_36);
                    lv_timeout_4_0=ruleTimeoutStatement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStateRule());
                    					}
                    					set(
                    						current,
                    						"timeout",
                    						lv_timeout_4_0,
                    						"su.nsk.iae.post.PoST.TimeoutStatement");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,60,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getEND_STATEKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleSetStateStatement"
    // InternalPoST.g:1849:1: entryRuleSetStateStatement returns [EObject current=null] : iv_ruleSetStateStatement= ruleSetStateStatement EOF ;
    public final EObject entryRuleSetStateStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStatement = null;


        try {
            // InternalPoST.g:1849:58: (iv_ruleSetStateStatement= ruleSetStateStatement EOF )
            // InternalPoST.g:1850:2: iv_ruleSetStateStatement= ruleSetStateStatement EOF
            {
             newCompositeNode(grammarAccess.getSetStateStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetStateStatement=ruleSetStateStatement();

            state._fsp--;

             current =iv_ruleSetStateStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetStateStatement"


    // $ANTLR start "ruleSetStateStatement"
    // InternalPoST.g:1856:1: ruleSetStateStatement returns [EObject current=null] : ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) ) ;
    public final EObject ruleSetStateStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_next_4_0=null;


        	enterRule();

        try {
            // InternalPoST.g:1862:2: ( ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) ) )
            // InternalPoST.g:1863:2: ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) )
            {
            // InternalPoST.g:1863:2: ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) )
            // InternalPoST.g:1864:3: () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) )
            {
            // InternalPoST.g:1864:3: ()
            // InternalPoST.g:1865:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSetStateStatementAccess().getSetStateStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,61,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getSetStateStatementAccess().getSETKeyword_1());
            		
            // InternalPoST.g:1875:3: ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==58) ) {
                alt26=1;
            }
            else if ( (LA26_0==62) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalPoST.g:1876:4: (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalPoST.g:1876:4: (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) )
                    // InternalPoST.g:1877:5: otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,58,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getSetStateStatementAccess().getSTATEKeyword_2_0_0());
                    				
                    // InternalPoST.g:1881:5: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:1882:6: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:1882:6: (otherlv_3= RULE_ID )
                    // InternalPoST.g:1883:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getSetStateStatementRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    							newLeafNode(otherlv_3, grammarAccess.getSetStateStatementAccess().getStateStateCrossReference_2_0_1_0());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:1896:4: ( (lv_next_4_0= 'NEXT' ) )
                    {
                    // InternalPoST.g:1896:4: ( (lv_next_4_0= 'NEXT' ) )
                    // InternalPoST.g:1897:5: (lv_next_4_0= 'NEXT' )
                    {
                    // InternalPoST.g:1897:5: (lv_next_4_0= 'NEXT' )
                    // InternalPoST.g:1898:6: lv_next_4_0= 'NEXT'
                    {
                    lv_next_4_0=(Token)match(input,62,FOLLOW_2); 

                    						newLeafNode(lv_next_4_0, grammarAccess.getSetStateStatementAccess().getNextNEXTKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSetStateStatementRule());
                    						}
                    						setWithLastConsumed(current, "next", lv_next_4_0 != null, "NEXT");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetStateStatement"


    // $ANTLR start "entryRuleProcessStatements"
    // InternalPoST.g:1915:1: entryRuleProcessStatements returns [EObject current=null] : iv_ruleProcessStatements= ruleProcessStatements EOF ;
    public final EObject entryRuleProcessStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessStatements = null;


        try {
            // InternalPoST.g:1915:58: (iv_ruleProcessStatements= ruleProcessStatements EOF )
            // InternalPoST.g:1916:2: iv_ruleProcessStatements= ruleProcessStatements EOF
            {
             newCompositeNode(grammarAccess.getProcessStatementsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessStatements=ruleProcessStatements();

            state._fsp--;

             current =iv_ruleProcessStatements; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessStatements"


    // $ANTLR start "ruleProcessStatements"
    // InternalPoST.g:1922:1: ruleProcessStatements returns [EObject current=null] : (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement ) ;
    public final EObject ruleProcessStatements() throws RecognitionException {
        EObject current = null;

        EObject this_StartProcessStatement_0 = null;

        EObject this_StopProcessStatement_1 = null;

        EObject this_ErrorProcessStatement_2 = null;



        	enterRule();

        try {
            // InternalPoST.g:1928:2: ( (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement ) )
            // InternalPoST.g:1929:2: (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement )
            {
            // InternalPoST.g:1929:2: (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 67:
            case 68:
                {
                alt27=1;
                }
                break;
            case 65:
                {
                alt27=2;
                }
                break;
            case 66:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalPoST.g:1930:3: this_StartProcessStatement_0= ruleStartProcessStatement
                    {

                    			newCompositeNode(grammarAccess.getProcessStatementsAccess().getStartProcessStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StartProcessStatement_0=ruleStartProcessStatement();

                    state._fsp--;


                    			current = this_StartProcessStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:1939:3: this_StopProcessStatement_1= ruleStopProcessStatement
                    {

                    			newCompositeNode(grammarAccess.getProcessStatementsAccess().getStopProcessStatementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StopProcessStatement_1=ruleStopProcessStatement();

                    state._fsp--;


                    			current = this_StopProcessStatement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalPoST.g:1948:3: this_ErrorProcessStatement_2= ruleErrorProcessStatement
                    {

                    			newCompositeNode(grammarAccess.getProcessStatementsAccess().getErrorProcessStatementParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ErrorProcessStatement_2=ruleErrorProcessStatement();

                    state._fsp--;


                    			current = this_ErrorProcessStatement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessStatements"


    // $ANTLR start "entryRuleProcessStatusExpression"
    // InternalPoST.g:1960:1: entryRuleProcessStatusExpression returns [EObject current=null] : iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF ;
    public final EObject entryRuleProcessStatusExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessStatusExpression = null;


        try {
            // InternalPoST.g:1960:64: (iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF )
            // InternalPoST.g:1961:2: iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF
            {
             newCompositeNode(grammarAccess.getProcessStatusExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessStatusExpression=ruleProcessStatusExpression();

            state._fsp--;

             current =iv_ruleProcessStatusExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessStatusExpression"


    // $ANTLR start "ruleProcessStatusExpression"
    // InternalPoST.g:1967:1: ruleProcessStatusExpression returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) ) ;
    public final EObject ruleProcessStatusExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_active_4_0=null;
        Token lv_inactive_5_0=null;
        Token lv_stop_6_0=null;
        Token lv_error_7_0=null;


        	enterRule();

        try {
            // InternalPoST.g:1973:2: ( (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) ) )
            // InternalPoST.g:1974:2: (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) )
            {
            // InternalPoST.g:1974:2: (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) )
            // InternalPoST.g:1975:3: otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessStatusExpressionAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:1979:3: ( (otherlv_1= RULE_ID ) )
            // InternalPoST.g:1980:4: (otherlv_1= RULE_ID )
            {
            // InternalPoST.g:1980:4: (otherlv_1= RULE_ID )
            // InternalPoST.g:1981:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessStatusExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_1, grammarAccess.getProcessStatusExpressionAccess().getProcessVariableCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,63,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getProcessStatusExpressionAccess().getINKeyword_2());
            		
            otherlv_3=(Token)match(input,58,FOLLOW_40); 

            			newLeafNode(otherlv_3, grammarAccess.getProcessStatusExpressionAccess().getSTATEKeyword_3());
            		
            // InternalPoST.g:2000:3: ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) )
            int alt28=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt28=1;
                }
                break;
            case 64:
                {
                alt28=2;
                }
                break;
            case 65:
                {
                alt28=3;
                }
                break;
            case 66:
                {
                alt28=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalPoST.g:2001:4: ( (lv_active_4_0= 'ACTIVE' ) )
                    {
                    // InternalPoST.g:2001:4: ( (lv_active_4_0= 'ACTIVE' ) )
                    // InternalPoST.g:2002:5: (lv_active_4_0= 'ACTIVE' )
                    {
                    // InternalPoST.g:2002:5: (lv_active_4_0= 'ACTIVE' )
                    // InternalPoST.g:2003:6: lv_active_4_0= 'ACTIVE'
                    {
                    lv_active_4_0=(Token)match(input,53,FOLLOW_2); 

                    						newLeafNode(lv_active_4_0, grammarAccess.getProcessStatusExpressionAccess().getActiveACTIVEKeyword_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProcessStatusExpressionRule());
                    						}
                    						setWithLastConsumed(current, "active", lv_active_4_0 != null, "ACTIVE");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:2016:4: ( (lv_inactive_5_0= 'INACTIVE' ) )
                    {
                    // InternalPoST.g:2016:4: ( (lv_inactive_5_0= 'INACTIVE' ) )
                    // InternalPoST.g:2017:5: (lv_inactive_5_0= 'INACTIVE' )
                    {
                    // InternalPoST.g:2017:5: (lv_inactive_5_0= 'INACTIVE' )
                    // InternalPoST.g:2018:6: lv_inactive_5_0= 'INACTIVE'
                    {
                    lv_inactive_5_0=(Token)match(input,64,FOLLOW_2); 

                    						newLeafNode(lv_inactive_5_0, grammarAccess.getProcessStatusExpressionAccess().getInactiveINACTIVEKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProcessStatusExpressionRule());
                    						}
                    						setWithLastConsumed(current, "inactive", lv_inactive_5_0 != null, "INACTIVE");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:2031:4: ( (lv_stop_6_0= 'STOP' ) )
                    {
                    // InternalPoST.g:2031:4: ( (lv_stop_6_0= 'STOP' ) )
                    // InternalPoST.g:2032:5: (lv_stop_6_0= 'STOP' )
                    {
                    // InternalPoST.g:2032:5: (lv_stop_6_0= 'STOP' )
                    // InternalPoST.g:2033:6: lv_stop_6_0= 'STOP'
                    {
                    lv_stop_6_0=(Token)match(input,65,FOLLOW_2); 

                    						newLeafNode(lv_stop_6_0, grammarAccess.getProcessStatusExpressionAccess().getStopSTOPKeyword_4_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProcessStatusExpressionRule());
                    						}
                    						setWithLastConsumed(current, "stop", lv_stop_6_0 != null, "STOP");
                    					

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPoST.g:2046:4: ( (lv_error_7_0= 'ERROR' ) )
                    {
                    // InternalPoST.g:2046:4: ( (lv_error_7_0= 'ERROR' ) )
                    // InternalPoST.g:2047:5: (lv_error_7_0= 'ERROR' )
                    {
                    // InternalPoST.g:2047:5: (lv_error_7_0= 'ERROR' )
                    // InternalPoST.g:2048:6: lv_error_7_0= 'ERROR'
                    {
                    lv_error_7_0=(Token)match(input,66,FOLLOW_2); 

                    						newLeafNode(lv_error_7_0, grammarAccess.getProcessStatusExpressionAccess().getErrorERRORKeyword_4_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProcessStatusExpressionRule());
                    						}
                    						setWithLastConsumed(current, "error", lv_error_7_0 != null, "ERROR");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessStatusExpression"


    // $ANTLR start "entryRuleStartProcessStatement"
    // InternalPoST.g:2065:1: entryRuleStartProcessStatement returns [EObject current=null] : iv_ruleStartProcessStatement= ruleStartProcessStatement EOF ;
    public final EObject entryRuleStartProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcessStatement = null;


        try {
            // InternalPoST.g:2065:62: (iv_ruleStartProcessStatement= ruleStartProcessStatement EOF )
            // InternalPoST.g:2066:2: iv_ruleStartProcessStatement= ruleStartProcessStatement EOF
            {
             newCompositeNode(grammarAccess.getStartProcessStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStartProcessStatement=ruleStartProcessStatement();

            state._fsp--;

             current =iv_ruleStartProcessStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartProcessStatement"


    // $ANTLR start "ruleStartProcessStatement"
    // InternalPoST.g:2072:1: ruleStartProcessStatement returns [EObject current=null] : ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) ) ;
    public final EObject ruleStartProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalPoST.g:2078:2: ( ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) ) )
            // InternalPoST.g:2079:2: ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) )
            {
            // InternalPoST.g:2079:2: ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==67) ) {
                alt29=1;
            }
            else if ( (LA29_0==68) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalPoST.g:2080:3: ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) )
                    {
                    // InternalPoST.g:2080:3: ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) )
                    // InternalPoST.g:2081:4: () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalPoST.g:2081:4: ()
                    // InternalPoST.g:2082:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStartProcessStatementAccess().getStartProcessStatementAction_0_0(),
                    						current);
                    				

                    }

                    // InternalPoST.g:2088:4: (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )
                    // InternalPoST.g:2089:5: otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,67,FOLLOW_41); 

                    					newLeafNode(otherlv_1, grammarAccess.getStartProcessStatementAccess().getSTARTKeyword_0_1_0());
                    				
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getStartProcessStatementAccess().getPROCESSKeyword_0_1_1());
                    				
                    // InternalPoST.g:2097:5: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:2098:6: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:2098:6: (otherlv_3= RULE_ID )
                    // InternalPoST.g:2099:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getStartProcessStatementRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    							newLeafNode(otherlv_3, grammarAccess.getStartProcessStatementAccess().getProcessVariableCrossReference_0_1_2_0());
                    						

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:2113:3: ( () otherlv_5= 'RESTART' )
                    {
                    // InternalPoST.g:2113:3: ( () otherlv_5= 'RESTART' )
                    // InternalPoST.g:2114:4: () otherlv_5= 'RESTART'
                    {
                    // InternalPoST.g:2114:4: ()
                    // InternalPoST.g:2115:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStartProcessStatementAccess().getStartProcessStatementAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,68,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getStartProcessStatementAccess().getRESTARTKeyword_1_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartProcessStatement"


    // $ANTLR start "entryRuleStopProcessStatement"
    // InternalPoST.g:2130:1: entryRuleStopProcessStatement returns [EObject current=null] : iv_ruleStopProcessStatement= ruleStopProcessStatement EOF ;
    public final EObject entryRuleStopProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcessStatement = null;


        try {
            // InternalPoST.g:2130:61: (iv_ruleStopProcessStatement= ruleStopProcessStatement EOF )
            // InternalPoST.g:2131:2: iv_ruleStopProcessStatement= ruleStopProcessStatement EOF
            {
             newCompositeNode(grammarAccess.getStopProcessStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStopProcessStatement=ruleStopProcessStatement();

            state._fsp--;

             current =iv_ruleStopProcessStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStopProcessStatement"


    // $ANTLR start "ruleStopProcessStatement"
    // InternalPoST.g:2137:1: ruleStopProcessStatement returns [EObject current=null] : ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleStopProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPoST.g:2143:2: ( ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalPoST.g:2144:2: ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalPoST.g:2144:2: ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalPoST.g:2145:3: () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalPoST.g:2145:3: ()
            // InternalPoST.g:2146:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStopProcessStatementAccess().getStopProcessStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,65,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getStopProcessStatementAccess().getSTOPKeyword_1());
            		
            // InternalPoST.g:2156:3: (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==52) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalPoST.g:2157:4: otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getStopProcessStatementAccess().getPROCESSKeyword_2_0());
                    			
                    // InternalPoST.g:2161:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:2162:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:2162:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:2163:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStopProcessStatementRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_3, grammarAccess.getStopProcessStatementAccess().getProcessVariableCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStopProcessStatement"


    // $ANTLR start "entryRuleErrorProcessStatement"
    // InternalPoST.g:2179:1: entryRuleErrorProcessStatement returns [EObject current=null] : iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF ;
    public final EObject entryRuleErrorProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorProcessStatement = null;


        try {
            // InternalPoST.g:2179:62: (iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF )
            // InternalPoST.g:2180:2: iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF
            {
             newCompositeNode(grammarAccess.getErrorProcessStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleErrorProcessStatement=ruleErrorProcessStatement();

            state._fsp--;

             current =iv_ruleErrorProcessStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorProcessStatement"


    // $ANTLR start "ruleErrorProcessStatement"
    // InternalPoST.g:2186:1: ruleErrorProcessStatement returns [EObject current=null] : ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleErrorProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPoST.g:2192:2: ( ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalPoST.g:2193:2: ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalPoST.g:2193:2: ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalPoST.g:2194:3: () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalPoST.g:2194:3: ()
            // InternalPoST.g:2195:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getErrorProcessStatementAccess().getErrorProcessStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,66,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getErrorProcessStatementAccess().getERRORKeyword_1());
            		
            // InternalPoST.g:2205:3: (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==52) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalPoST.g:2206:4: otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getErrorProcessStatementAccess().getPROCESSKeyword_2_0());
                    			
                    // InternalPoST.g:2210:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:2211:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:2211:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:2212:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getErrorProcessStatementRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_3, grammarAccess.getErrorProcessStatementAccess().getProcessVariableCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErrorProcessStatement"


    // $ANTLR start "entryRuleTimeoutStatement"
    // InternalPoST.g:2228:1: entryRuleTimeoutStatement returns [EObject current=null] : iv_ruleTimeoutStatement= ruleTimeoutStatement EOF ;
    public final EObject entryRuleTimeoutStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutStatement = null;


        try {
            // InternalPoST.g:2228:57: (iv_ruleTimeoutStatement= ruleTimeoutStatement EOF )
            // InternalPoST.g:2229:2: iv_ruleTimeoutStatement= ruleTimeoutStatement EOF
            {
             newCompositeNode(grammarAccess.getTimeoutStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeoutStatement=ruleTimeoutStatement();

            state._fsp--;

             current =iv_ruleTimeoutStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeoutStatement"


    // $ANTLR start "ruleTimeoutStatement"
    // InternalPoST.g:2235:1: ruleTimeoutStatement returns [EObject current=null] : (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' ) ;
    public final EObject ruleTimeoutStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_const_1_0 = null;

        EObject lv_statement_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2241:2: ( (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' ) )
            // InternalPoST.g:2242:2: (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' )
            {
            // InternalPoST.g:2242:2: (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' )
            // InternalPoST.g:2243:3: otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeoutStatementAccess().getTIMEOUTKeyword_0());
            		
            // InternalPoST.g:2247:3: ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_INTEGER||LA32_0==RULE_TIME_PREF_LITERAL||(LA32_0>=RULE_REAL_TYPE_NAME && LA32_0<=RULE_REAL)||LA32_0==110) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalPoST.g:2248:4: ( (lv_const_1_0= ruleConstant ) )
                    {
                    // InternalPoST.g:2248:4: ( (lv_const_1_0= ruleConstant ) )
                    // InternalPoST.g:2249:5: (lv_const_1_0= ruleConstant )
                    {
                    // InternalPoST.g:2249:5: (lv_const_1_0= ruleConstant )
                    // InternalPoST.g:2250:6: lv_const_1_0= ruleConstant
                    {

                    						newCompositeNode(grammarAccess.getTimeoutStatementAccess().getConstConstantParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_const_1_0=ruleConstant();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimeoutStatementRule());
                    						}
                    						set(
                    							current,
                    							"const",
                    							lv_const_1_0,
                    							"su.nsk.iae.post.PoST.Constant");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:2268:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalPoST.g:2268:4: ( (otherlv_2= RULE_ID ) )
                    // InternalPoST.g:2269:5: (otherlv_2= RULE_ID )
                    {
                    // InternalPoST.g:2269:5: (otherlv_2= RULE_ID )
                    // InternalPoST.g:2270:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeoutStatementRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_43); 

                    						newLeafNode(otherlv_2, grammarAccess.getTimeoutStatementAccess().getVariableSymbolicVariableCrossReference_1_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,70,FOLLOW_44); 

            			newLeafNode(otherlv_3, grammarAccess.getTimeoutStatementAccess().getTHENKeyword_2());
            		
            // InternalPoST.g:2286:3: ( (lv_statement_4_0= ruleStatementList ) )
            // InternalPoST.g:2287:4: (lv_statement_4_0= ruleStatementList )
            {
            // InternalPoST.g:2287:4: (lv_statement_4_0= ruleStatementList )
            // InternalPoST.g:2288:5: lv_statement_4_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getTimeoutStatementAccess().getStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_45);
            lv_statement_4_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeoutStatementRule());
            					}
            					set(
            						current,
            						"statement",
            						lv_statement_4_0,
            						"su.nsk.iae.post.PoST.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,71,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTimeoutStatementAccess().getEND_TIMEOUTKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeoutStatement"


    // $ANTLR start "entryRuleResetTimerStatement"
    // InternalPoST.g:2313:1: entryRuleResetTimerStatement returns [EObject current=null] : iv_ruleResetTimerStatement= ruleResetTimerStatement EOF ;
    public final EObject entryRuleResetTimerStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetTimerStatement = null;


        try {
            // InternalPoST.g:2313:60: (iv_ruleResetTimerStatement= ruleResetTimerStatement EOF )
            // InternalPoST.g:2314:2: iv_ruleResetTimerStatement= ruleResetTimerStatement EOF
            {
             newCompositeNode(grammarAccess.getResetTimerStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResetTimerStatement=ruleResetTimerStatement();

            state._fsp--;

             current =iv_ruleResetTimerStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResetTimerStatement"


    // $ANTLR start "ruleResetTimerStatement"
    // InternalPoST.g:2320:1: ruleResetTimerStatement returns [EObject current=null] : ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' ) ;
    public final EObject ruleResetTimerStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalPoST.g:2326:2: ( ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' ) )
            // InternalPoST.g:2327:2: ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' )
            {
            // InternalPoST.g:2327:2: ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' )
            // InternalPoST.g:2328:3: () otherlv_1= 'RESET' otherlv_2= 'TIMER'
            {
            // InternalPoST.g:2328:3: ()
            // InternalPoST.g:2329:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getResetTimerStatementAccess().getResetTimerStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,72,FOLLOW_46); 

            			newLeafNode(otherlv_1, grammarAccess.getResetTimerStatementAccess().getRESETKeyword_1());
            		
            otherlv_2=(Token)match(input,73,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getResetTimerStatementAccess().getTIMERKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResetTimerStatement"


    // $ANTLR start "entryRuleExpression"
    // InternalPoST.g:2347:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalPoST.g:2347:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalPoST.g:2348:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalPoST.g:2354:1: ruleExpression returns [EObject current=null] : (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token this_OR_OPERATOR_2=null;
        EObject this_XorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2360:2: ( (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* ) )
            // InternalPoST.g:2361:2: (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* )
            {
            // InternalPoST.g:2361:2: (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* )
            // InternalPoST.g:2362:3: this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getExpressionAccess().getXorExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_47);
            this_XorExpression_0=ruleXorExpression();

            state._fsp--;


            			current = this_XorExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2370:3: ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_OR_OPERATOR) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalPoST.g:2371:4: () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) )
            	    {
            	    // InternalPoST.g:2371:4: ()
            	    // InternalPoST.g:2372:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getExpressionAccess().getExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_OR_OPERATOR_2=(Token)match(input,RULE_OR_OPERATOR,FOLLOW_48); 

            	    				newLeafNode(this_OR_OPERATOR_2, grammarAccess.getExpressionAccess().getOR_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2382:4: ( (lv_right_3_0= ruleXorExpression ) )
            	    // InternalPoST.g:2383:5: (lv_right_3_0= ruleXorExpression )
            	    {
            	    // InternalPoST.g:2383:5: (lv_right_3_0= ruleXorExpression )
            	    // InternalPoST.g:2384:6: lv_right_3_0= ruleXorExpression
            	    {

            	    						newCompositeNode(grammarAccess.getExpressionAccess().getRightXorExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_47);
            	    lv_right_3_0=ruleXorExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"su.nsk.iae.post.PoST.XorExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleXorExpression"
    // InternalPoST.g:2406:1: entryRuleXorExpression returns [EObject current=null] : iv_ruleXorExpression= ruleXorExpression EOF ;
    public final EObject entryRuleXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpression = null;


        try {
            // InternalPoST.g:2406:54: (iv_ruleXorExpression= ruleXorExpression EOF )
            // InternalPoST.g:2407:2: iv_ruleXorExpression= ruleXorExpression EOF
            {
             newCompositeNode(grammarAccess.getXorExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXorExpression=ruleXorExpression();

            state._fsp--;

             current =iv_ruleXorExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXorExpression"


    // $ANTLR start "ruleXorExpression"
    // InternalPoST.g:2413:1: ruleXorExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_XOR_OPERATOR_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2419:2: ( (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalPoST.g:2420:2: (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPoST.g:2420:2: (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalPoST.g:2421:3: this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_49);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2429:3: ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_XOR_OPERATOR) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalPoST.g:2430:4: () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalPoST.g:2430:4: ()
            	    // InternalPoST.g:2431:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorExpressionAccess().getXorExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_XOR_OPERATOR_2=(Token)match(input,RULE_XOR_OPERATOR,FOLLOW_48); 

            	    				newLeafNode(this_XOR_OPERATOR_2, grammarAccess.getXorExpressionAccess().getXOR_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2441:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalPoST.g:2442:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalPoST.g:2442:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalPoST.g:2443:6: lv_right_3_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_49);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXorExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"su.nsk.iae.post.PoST.AndExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXorExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalPoST.g:2465:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPoST.g:2465:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPoST.g:2466:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalPoST.g:2472:1: ruleAndExpression returns [EObject current=null] : (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_AND_OPERATOR_2=null;
        EObject this_CompExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2478:2: ( (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* ) )
            // InternalPoST.g:2479:2: (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* )
            {
            // InternalPoST.g:2479:2: (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* )
            // InternalPoST.g:2480:3: this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getCompExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_50);
            this_CompExpression_0=ruleCompExpression();

            state._fsp--;


            			current = this_CompExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2488:3: ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_AND_OPERATOR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalPoST.g:2489:4: () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) )
            	    {
            	    // InternalPoST.g:2489:4: ()
            	    // InternalPoST.g:2490:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_AND_OPERATOR_2=(Token)match(input,RULE_AND_OPERATOR,FOLLOW_48); 

            	    				newLeafNode(this_AND_OPERATOR_2, grammarAccess.getAndExpressionAccess().getAND_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2500:4: ( (lv_right_3_0= ruleCompExpression ) )
            	    // InternalPoST.g:2501:5: (lv_right_3_0= ruleCompExpression )
            	    {
            	    // InternalPoST.g:2501:5: (lv_right_3_0= ruleCompExpression )
            	    // InternalPoST.g:2502:6: lv_right_3_0= ruleCompExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightCompExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_50);
            	    lv_right_3_0=ruleCompExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"su.nsk.iae.post.PoST.CompExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleCompExpression"
    // InternalPoST.g:2524:1: entryRuleCompExpression returns [EObject current=null] : iv_ruleCompExpression= ruleCompExpression EOF ;
    public final EObject entryRuleCompExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompExpression = null;


        try {
            // InternalPoST.g:2524:55: (iv_ruleCompExpression= ruleCompExpression EOF )
            // InternalPoST.g:2525:2: iv_ruleCompExpression= ruleCompExpression EOF
            {
             newCompositeNode(grammarAccess.getCompExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompExpression=ruleCompExpression();

            state._fsp--;

             current =iv_ruleCompExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompExpression"


    // $ANTLR start "ruleCompExpression"
    // InternalPoST.g:2531:1: ruleCompExpression returns [EObject current=null] : (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* ) ;
    public final EObject ruleCompExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EquExpression_0 = null;

        Enumerator lv_compOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2537:2: ( (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* ) )
            // InternalPoST.g:2538:2: (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* )
            {
            // InternalPoST.g:2538:2: (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* )
            // InternalPoST.g:2539:3: this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getCompExpressionAccess().getEquExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_51);
            this_EquExpression_0=ruleEquExpression();

            state._fsp--;


            			current = this_EquExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2547:3: ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=112 && LA36_0<=113)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalPoST.g:2548:4: () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) )
            	    {
            	    // InternalPoST.g:2548:4: ()
            	    // InternalPoST.g:2549:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getCompExpressionAccess().getCompExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2555:4: ( (lv_compOp_2_0= ruleCompOperator ) )
            	    // InternalPoST.g:2556:5: (lv_compOp_2_0= ruleCompOperator )
            	    {
            	    // InternalPoST.g:2556:5: (lv_compOp_2_0= ruleCompOperator )
            	    // InternalPoST.g:2557:6: lv_compOp_2_0= ruleCompOperator
            	    {

            	    						newCompositeNode(grammarAccess.getCompExpressionAccess().getCompOpCompOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
            	    lv_compOp_2_0=ruleCompOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCompExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"compOp",
            	    							lv_compOp_2_0,
            	    							"su.nsk.iae.post.PoST.CompOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalPoST.g:2574:4: ( (lv_right_3_0= ruleEquExpression ) )
            	    // InternalPoST.g:2575:5: (lv_right_3_0= ruleEquExpression )
            	    {
            	    // InternalPoST.g:2575:5: (lv_right_3_0= ruleEquExpression )
            	    // InternalPoST.g:2576:6: lv_right_3_0= ruleEquExpression
            	    {

            	    						newCompositeNode(grammarAccess.getCompExpressionAccess().getRightEquExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_51);
            	    lv_right_3_0=ruleEquExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCompExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"su.nsk.iae.post.PoST.EquExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompExpression"


    // $ANTLR start "entryRuleEquExpression"
    // InternalPoST.g:2598:1: entryRuleEquExpression returns [EObject current=null] : iv_ruleEquExpression= ruleEquExpression EOF ;
    public final EObject entryRuleEquExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquExpression = null;


        try {
            // InternalPoST.g:2598:54: (iv_ruleEquExpression= ruleEquExpression EOF )
            // InternalPoST.g:2599:2: iv_ruleEquExpression= ruleEquExpression EOF
            {
             newCompositeNode(grammarAccess.getEquExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEquExpression=ruleEquExpression();

            state._fsp--;

             current =iv_ruleEquExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquExpression"


    // $ANTLR start "ruleEquExpression"
    // InternalPoST.g:2605:1: ruleEquExpression returns [EObject current=null] : (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* ) ;
    public final EObject ruleEquExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AddExpression_0 = null;

        Enumerator lv_equOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2611:2: ( (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* ) )
            // InternalPoST.g:2612:2: (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* )
            {
            // InternalPoST.g:2612:2: (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* )
            // InternalPoST.g:2613:3: this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getEquExpressionAccess().getAddExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_52);
            this_AddExpression_0=ruleAddExpression();

            state._fsp--;


            			current = this_AddExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2621:3: ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=114 && LA37_0<=117)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalPoST.g:2622:4: () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) )
            	    {
            	    // InternalPoST.g:2622:4: ()
            	    // InternalPoST.g:2623:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEquExpressionAccess().getEquExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2629:4: ( (lv_equOp_2_0= ruleEquOperator ) )
            	    // InternalPoST.g:2630:5: (lv_equOp_2_0= ruleEquOperator )
            	    {
            	    // InternalPoST.g:2630:5: (lv_equOp_2_0= ruleEquOperator )
            	    // InternalPoST.g:2631:6: lv_equOp_2_0= ruleEquOperator
            	    {

            	    						newCompositeNode(grammarAccess.getEquExpressionAccess().getEquOpEquOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
            	    lv_equOp_2_0=ruleEquOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEquExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"equOp",
            	    							lv_equOp_2_0,
            	    							"su.nsk.iae.post.PoST.EquOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalPoST.g:2648:4: ( (lv_right_3_0= ruleAddExpression ) )
            	    // InternalPoST.g:2649:5: (lv_right_3_0= ruleAddExpression )
            	    {
            	    // InternalPoST.g:2649:5: (lv_right_3_0= ruleAddExpression )
            	    // InternalPoST.g:2650:6: lv_right_3_0= ruleAddExpression
            	    {

            	    						newCompositeNode(grammarAccess.getEquExpressionAccess().getRightAddExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_52);
            	    lv_right_3_0=ruleAddExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEquExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"su.nsk.iae.post.PoST.AddExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquExpression"


    // $ANTLR start "entryRuleAddExpression"
    // InternalPoST.g:2672:1: entryRuleAddExpression returns [EObject current=null] : iv_ruleAddExpression= ruleAddExpression EOF ;
    public final EObject entryRuleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddExpression = null;


        try {
            // InternalPoST.g:2672:54: (iv_ruleAddExpression= ruleAddExpression EOF )
            // InternalPoST.g:2673:2: iv_ruleAddExpression= ruleAddExpression EOF
            {
             newCompositeNode(grammarAccess.getAddExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddExpression=ruleAddExpression();

            state._fsp--;

             current =iv_ruleAddExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddExpression"


    // $ANTLR start "ruleAddExpression"
    // InternalPoST.g:2679:1: ruleAddExpression returns [EObject current=null] : (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* ) ;
    public final EObject ruleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MulExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2685:2: ( (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* ) )
            // InternalPoST.g:2686:2: (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* )
            {
            // InternalPoST.g:2686:2: (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* )
            // InternalPoST.g:2687:3: this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAddExpressionAccess().getMulExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_53);
            this_MulExpression_0=ruleMulExpression();

            state._fsp--;


            			current = this_MulExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2695:3: ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==110||LA38_0==118) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalPoST.g:2696:4: () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) )
            	    {
            	    // InternalPoST.g:2696:4: ()
            	    // InternalPoST.g:2697:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAddExpressionAccess().getAddExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2703:4: ( (lv_addOp_2_0= ruleAddOperator ) )
            	    // InternalPoST.g:2704:5: (lv_addOp_2_0= ruleAddOperator )
            	    {
            	    // InternalPoST.g:2704:5: (lv_addOp_2_0= ruleAddOperator )
            	    // InternalPoST.g:2705:6: lv_addOp_2_0= ruleAddOperator
            	    {

            	    						newCompositeNode(grammarAccess.getAddExpressionAccess().getAddOpAddOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
            	    lv_addOp_2_0=ruleAddOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAddExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"addOp",
            	    							lv_addOp_2_0,
            	    							"su.nsk.iae.post.PoST.AddOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalPoST.g:2722:4: ( (lv_right_3_0= ruleMulExpression ) )
            	    // InternalPoST.g:2723:5: (lv_right_3_0= ruleMulExpression )
            	    {
            	    // InternalPoST.g:2723:5: (lv_right_3_0= ruleMulExpression )
            	    // InternalPoST.g:2724:6: lv_right_3_0= ruleMulExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAddExpressionAccess().getRightMulExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_53);
            	    lv_right_3_0=ruleMulExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAddExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"su.nsk.iae.post.PoST.MulExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddExpression"


    // $ANTLR start "entryRuleMulExpression"
    // InternalPoST.g:2746:1: entryRuleMulExpression returns [EObject current=null] : iv_ruleMulExpression= ruleMulExpression EOF ;
    public final EObject entryRuleMulExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMulExpression = null;


        try {
            // InternalPoST.g:2746:54: (iv_ruleMulExpression= ruleMulExpression EOF )
            // InternalPoST.g:2747:2: iv_ruleMulExpression= ruleMulExpression EOF
            {
             newCompositeNode(grammarAccess.getMulExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMulExpression=ruleMulExpression();

            state._fsp--;

             current =iv_ruleMulExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMulExpression"


    // $ANTLR start "ruleMulExpression"
    // InternalPoST.g:2753:1: ruleMulExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) ;
    public final EObject ruleMulExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2759:2: ( (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) )
            // InternalPoST.g:2760:2: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            {
            // InternalPoST.g:2760:2: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            // InternalPoST.g:2761:3: this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMulExpressionAccess().getPowerExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_PowerExpression_0=rulePowerExpression();

            state._fsp--;


            			current = this_PowerExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2769:3: ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==107||(LA39_0>=119 && LA39_0<=120)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalPoST.g:2770:4: () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) )
            	    {
            	    // InternalPoST.g:2770:4: ()
            	    // InternalPoST.g:2771:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getMulExpressionAccess().getMulExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2777:4: ( (lv_mulOp_2_0= ruleMulOperator ) )
            	    // InternalPoST.g:2778:5: (lv_mulOp_2_0= ruleMulOperator )
            	    {
            	    // InternalPoST.g:2778:5: (lv_mulOp_2_0= ruleMulOperator )
            	    // InternalPoST.g:2779:6: lv_mulOp_2_0= ruleMulOperator
            	    {

            	    						newCompositeNode(grammarAccess.getMulExpressionAccess().getMulOpMulOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
            	    lv_mulOp_2_0=ruleMulOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMulExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"mulOp",
            	    							lv_mulOp_2_0,
            	    							"su.nsk.iae.post.PoST.MulOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalPoST.g:2796:4: ( (lv_right_3_0= rulePowerExpression ) )
            	    // InternalPoST.g:2797:5: (lv_right_3_0= rulePowerExpression )
            	    {
            	    // InternalPoST.g:2797:5: (lv_right_3_0= rulePowerExpression )
            	    // InternalPoST.g:2798:6: lv_right_3_0= rulePowerExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMulExpressionAccess().getRightPowerExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_54);
            	    lv_right_3_0=rulePowerExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMulExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"su.nsk.iae.post.PoST.PowerExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMulExpression"


    // $ANTLR start "entryRulePowerExpression"
    // InternalPoST.g:2820:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // InternalPoST.g:2820:56: (iv_rulePowerExpression= rulePowerExpression EOF )
            // InternalPoST.g:2821:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
             newCompositeNode(grammarAccess.getPowerExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerExpression=rulePowerExpression();

            state._fsp--;

             current =iv_rulePowerExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerExpression"


    // $ANTLR start "rulePowerExpression"
    // InternalPoST.g:2827:1: rulePowerExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        Token this_POWER_OPERATOR_2=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2833:2: ( (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) )
            // InternalPoST.g:2834:2: (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            {
            // InternalPoST.g:2834:2: (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            // InternalPoST.g:2835:3: this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_55);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;


            			current = this_UnaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2843:3: ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_POWER_OPERATOR) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalPoST.g:2844:4: () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) )
            	    {
            	    // InternalPoST.g:2844:4: ()
            	    // InternalPoST.g:2845:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPowerExpressionAccess().getPowerExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_POWER_OPERATOR_2=(Token)match(input,RULE_POWER_OPERATOR,FOLLOW_48); 

            	    				newLeafNode(this_POWER_OPERATOR_2, grammarAccess.getPowerExpressionAccess().getPOWER_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2855:4: ( (lv_right_3_0= ruleUnaryExpression ) )
            	    // InternalPoST.g:2856:5: (lv_right_3_0= ruleUnaryExpression )
            	    {
            	    // InternalPoST.g:2856:5: (lv_right_3_0= ruleUnaryExpression )
            	    // InternalPoST.g:2857:6: lv_right_3_0= ruleUnaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getPowerExpressionAccess().getRightUnaryExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_55);
            	    lv_right_3_0=ruleUnaryExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPowerExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"su.nsk.iae.post.PoST.UnaryExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalPoST.g:2879:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPoST.g:2879:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPoST.g:2880:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalPoST.g:2886:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_unOp_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2892:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) ) )
            // InternalPoST.g:2893:2: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) )
            {
            // InternalPoST.g:2893:2: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) )
            int alt41=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_TIME_PREF_LITERAL:
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
            case RULE_BINARY_INTEGER:
            case RULE_OCTAL_INTEGER:
            case RULE_HEX_INTEGER:
            case RULE_BOOLEAN_LITERAL:
            case RULE_REAL:
            case 45:
            case 52:
                {
                alt41=1;
                }
                break;
            case 110:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                case RULE_TIME_PREF_LITERAL:
                case RULE_REAL_TYPE_NAME:
                case RULE_SIGNED_INTEGER_TYPE_NAME:
                case RULE_UNSIGNED_INTEGER_TYPE_NAME:
                case RULE_BINARY_INTEGER:
                case RULE_OCTAL_INTEGER:
                case RULE_HEX_INTEGER:
                case RULE_BOOLEAN_LITERAL:
                case 45:
                case 52:
                case 110:
                    {
                    alt41=2;
                    }
                    break;
                case RULE_INTEGER:
                    {
                    alt41=1;
                    }
                    break;
                case RULE_REAL:
                    {
                    alt41=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 2, input);

                    throw nvae;
                }

                }
                break;
            case 121:
                {
                alt41=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalPoST.g:2894:3: this_PrimaryExpression_0= rulePrimaryExpression
                    {

                    			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;


                    			current = this_PrimaryExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:2903:3: ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) )
                    {
                    // InternalPoST.g:2903:3: ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) )
                    // InternalPoST.g:2904:4: ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) )
                    {
                    // InternalPoST.g:2904:4: ( (lv_unOp_1_0= ruleUnaryOperator ) )
                    // InternalPoST.g:2905:5: (lv_unOp_1_0= ruleUnaryOperator )
                    {
                    // InternalPoST.g:2905:5: (lv_unOp_1_0= ruleUnaryOperator )
                    // InternalPoST.g:2906:6: lv_unOp_1_0= ruleUnaryOperator
                    {

                    						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnOpUnaryOperatorEnumRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_56);
                    lv_unOp_1_0=ruleUnaryOperator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"unOp",
                    							lv_unOp_1_0,
                    							"su.nsk.iae.post.PoST.UnaryOperator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalPoST.g:2923:4: ( (lv_right_2_0= rulePrimaryExpression ) )
                    // InternalPoST.g:2924:5: (lv_right_2_0= rulePrimaryExpression )
                    {
                    // InternalPoST.g:2924:5: (lv_right_2_0= rulePrimaryExpression )
                    // InternalPoST.g:2925:6: lv_right_2_0= rulePrimaryExpression
                    {

                    						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getRightPrimaryExpressionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_2_0=rulePrimaryExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_2_0,
                    							"su.nsk.iae.post.PoST.PrimaryExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalPoST.g:2947:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPoST.g:2947:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPoST.g:2948:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalPoST.g:2954:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_const_0_0 = null;

        EObject lv_array_2_0 = null;

        EObject lv_procStatus_3_0 = null;

        EObject lv_nestExpr_5_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2960:2: ( ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) )
            // InternalPoST.g:2961:2: ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            {
            // InternalPoST.g:2961:2: ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            int alt42=5;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
            case RULE_TIME_PREF_LITERAL:
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
            case RULE_BINARY_INTEGER:
            case RULE_OCTAL_INTEGER:
            case RULE_HEX_INTEGER:
            case RULE_BOOLEAN_LITERAL:
            case RULE_REAL:
            case 110:
                {
                alt42=1;
                }
                break;
            case RULE_ID:
                {
                int LA42_2 = input.LA(2);

                if ( (LA42_2==104) ) {
                    alt42=3;
                }
                else if ( (LA42_2==EOF||(LA42_2>=RULE_OR_OPERATOR && LA42_2<=RULE_POWER_OPERATOR)||LA42_2==43||LA42_2==46||LA42_2==48||LA42_2==70||LA42_2==79||LA42_2==82||(LA42_2>=84 && LA42_2<=85)||LA42_2==90||LA42_2==105||(LA42_2>=107 && LA42_2<=108)||LA42_2==110||(LA42_2>=112 && LA42_2<=120)) ) {
                    alt42=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 2, input);

                    throw nvae;
                }
                }
                break;
            case 52:
                {
                alt42=4;
                }
                break;
            case 45:
                {
                alt42=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalPoST.g:2962:3: ( (lv_const_0_0= ruleConstant ) )
                    {
                    // InternalPoST.g:2962:3: ( (lv_const_0_0= ruleConstant ) )
                    // InternalPoST.g:2963:4: (lv_const_0_0= ruleConstant )
                    {
                    // InternalPoST.g:2963:4: (lv_const_0_0= ruleConstant )
                    // InternalPoST.g:2964:5: lv_const_0_0= ruleConstant
                    {

                    					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstConstantParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_const_0_0=ruleConstant();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    					}
                    					set(
                    						current,
                    						"const",
                    						lv_const_0_0,
                    						"su.nsk.iae.post.PoST.Constant");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:2982:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalPoST.g:2982:3: ( (otherlv_1= RULE_ID ) )
                    // InternalPoST.g:2983:4: (otherlv_1= RULE_ID )
                    {
                    // InternalPoST.g:2983:4: (otherlv_1= RULE_ID )
                    // InternalPoST.g:2984:5: otherlv_1= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                    					}
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getVariableSymbolicVariableCrossReference_1_0());
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:2996:3: ( (lv_array_2_0= ruleArrayVariable ) )
                    {
                    // InternalPoST.g:2996:3: ( (lv_array_2_0= ruleArrayVariable ) )
                    // InternalPoST.g:2997:4: (lv_array_2_0= ruleArrayVariable )
                    {
                    // InternalPoST.g:2997:4: (lv_array_2_0= ruleArrayVariable )
                    // InternalPoST.g:2998:5: lv_array_2_0= ruleArrayVariable
                    {

                    					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArrayArrayVariableParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_array_2_0=ruleArrayVariable();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    					}
                    					set(
                    						current,
                    						"array",
                    						lv_array_2_0,
                    						"su.nsk.iae.post.PoST.ArrayVariable");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalPoST.g:3016:3: ( (lv_procStatus_3_0= ruleProcessStatusExpression ) )
                    {
                    // InternalPoST.g:3016:3: ( (lv_procStatus_3_0= ruleProcessStatusExpression ) )
                    // InternalPoST.g:3017:4: (lv_procStatus_3_0= ruleProcessStatusExpression )
                    {
                    // InternalPoST.g:3017:4: (lv_procStatus_3_0= ruleProcessStatusExpression )
                    // InternalPoST.g:3018:5: lv_procStatus_3_0= ruleProcessStatusExpression
                    {

                    					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getProcStatusProcessStatusExpressionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_procStatus_3_0=ruleProcessStatusExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    					}
                    					set(
                    						current,
                    						"procStatus",
                    						lv_procStatus_3_0,
                    						"su.nsk.iae.post.PoST.ProcessStatusExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalPoST.g:3036:3: (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalPoST.g:3036:3: (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalPoST.g:3037:4: otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,45,FOLLOW_48); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalPoST.g:3041:4: ( (lv_nestExpr_5_0= ruleExpression ) )
                    // InternalPoST.g:3042:5: (lv_nestExpr_5_0= ruleExpression )
                    {
                    // InternalPoST.g:3042:5: (lv_nestExpr_5_0= ruleExpression )
                    // InternalPoST.g:3043:6: lv_nestExpr_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNestExprExpressionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_nestExpr_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"nestExpr",
                    							lv_nestExpr_5_0,
                    							"su.nsk.iae.post.PoST.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,46,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_4_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleStatementList"
    // InternalPoST.g:3069:1: entryRuleStatementList returns [EObject current=null] : iv_ruleStatementList= ruleStatementList EOF ;
    public final EObject entryRuleStatementList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementList = null;


        try {
            // InternalPoST.g:3069:54: (iv_ruleStatementList= ruleStatementList EOF )
            // InternalPoST.g:3070:2: iv_ruleStatementList= ruleStatementList EOF
            {
             newCompositeNode(grammarAccess.getStatementListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatementList=ruleStatementList();

            state._fsp--;

             current =iv_ruleStatementList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementList"


    // $ANTLR start "ruleStatementList"
    // InternalPoST.g:3076:1: ruleStatementList returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleStatementList() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3082:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalPoST.g:3083:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalPoST.g:3083:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalPoST.g:3084:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalPoST.g:3084:3: ()
            // InternalPoST.g:3085:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStatementListAccess().getStatementListAction_0(),
            					current);
            			

            }

            // InternalPoST.g:3091:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID||LA43_0==61||(LA43_0>=65 && LA43_0<=68)||LA43_0==72||LA43_0==74||LA43_0==78||LA43_0==81||LA43_0==86||LA43_0==88||(LA43_0>=91 && LA43_0<=92)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalPoST.g:3092:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalPoST.g:3092:4: (lv_statements_1_0= ruleStatement )
            	    // InternalPoST.g:3093:5: lv_statements_1_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getStatementListAccess().getStatementsStatementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_57);
            	    lv_statements_1_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStatementListRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_1_0,
            	    						"su.nsk.iae.post.PoST.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementList"


    // $ANTLR start "entryRuleStatement"
    // InternalPoST.g:3114:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalPoST.g:3114:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalPoST.g:3115:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalPoST.g:3121:1: ruleStatement returns [EObject current=null] : ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject this_AssignmentStatement_0 = null;

        EObject this_SelectionStatement_2 = null;

        EObject this_IterationStatement_3 = null;

        EObject this_SubprogramControlStatement_4 = null;

        EObject this_ExitStatement_6 = null;

        EObject this_ProcessStatements_8 = null;

        EObject this_SetStateStatement_10 = null;

        EObject this_ResetTimerStatement_12 = null;



        	enterRule();

        try {
            // InternalPoST.g:3127:2: ( ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) ) )
            // InternalPoST.g:3128:2: ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) )
            {
            // InternalPoST.g:3128:2: ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) )
            int alt44=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt44=1;
                }
                break;
            case 74:
            case 78:
                {
                alt44=2;
                }
                break;
            case 81:
            case 86:
            case 88:
                {
                alt44=3;
                }
                break;
            case 91:
                {
                alt44=4;
                }
                break;
            case 92:
                {
                alt44=5;
                }
                break;
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt44=6;
                }
                break;
            case 61:
                {
                alt44=7;
                }
                break;
            case 72:
                {
                alt44=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalPoST.g:3129:3: (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' )
                    {
                    // InternalPoST.g:3129:3: (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' )
                    // InternalPoST.g:3130:4: this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_9);
                    this_AssignmentStatement_0=ruleAssignmentStatement();

                    state._fsp--;


                    				current = this_AssignmentStatement_0;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_1=(Token)match(input,43,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:3144:3: this_SelectionStatement_2= ruleSelectionStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getSelectionStatementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SelectionStatement_2=ruleSelectionStatement();

                    state._fsp--;


                    			current = this_SelectionStatement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalPoST.g:3153:3: this_IterationStatement_3= ruleIterationStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getIterationStatementParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_IterationStatement_3=ruleIterationStatement();

                    state._fsp--;


                    			current = this_IterationStatement_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalPoST.g:3162:3: (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' )
                    {
                    // InternalPoST.g:3162:3: (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' )
                    // InternalPoST.g:3163:4: this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getSubprogramControlStatementParserRuleCall_3_0());
                    			
                    pushFollow(FOLLOW_9);
                    this_SubprogramControlStatement_4=ruleSubprogramControlStatement();

                    state._fsp--;


                    				current = this_SubprogramControlStatement_4;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_5=(Token)match(input,43,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getStatementAccess().getSemicolonKeyword_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalPoST.g:3177:3: (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' )
                    {
                    // InternalPoST.g:3177:3: (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' )
                    // InternalPoST.g:3178:4: this_ExitStatement_6= ruleExitStatement otherlv_7= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getExitStatementParserRuleCall_4_0());
                    			
                    pushFollow(FOLLOW_9);
                    this_ExitStatement_6=ruleExitStatement();

                    state._fsp--;


                    				current = this_ExitStatement_6;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_7=(Token)match(input,43,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getStatementAccess().getSemicolonKeyword_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalPoST.g:3192:3: (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' )
                    {
                    // InternalPoST.g:3192:3: (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' )
                    // InternalPoST.g:3193:4: this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getProcessStatementsParserRuleCall_5_0());
                    			
                    pushFollow(FOLLOW_9);
                    this_ProcessStatements_8=ruleProcessStatements();

                    state._fsp--;


                    				current = this_ProcessStatements_8;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_9=(Token)match(input,43,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getStatementAccess().getSemicolonKeyword_5_1());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalPoST.g:3207:3: (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' )
                    {
                    // InternalPoST.g:3207:3: (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' )
                    // InternalPoST.g:3208:4: this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getSetStateStatementParserRuleCall_6_0());
                    			
                    pushFollow(FOLLOW_9);
                    this_SetStateStatement_10=ruleSetStateStatement();

                    state._fsp--;


                    				current = this_SetStateStatement_10;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_11=(Token)match(input,43,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getStatementAccess().getSemicolonKeyword_6_1());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalPoST.g:3222:3: (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' )
                    {
                    // InternalPoST.g:3222:3: (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' )
                    // InternalPoST.g:3223:4: this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getResetTimerStatementParserRuleCall_7_0());
                    			
                    pushFollow(FOLLOW_9);
                    this_ResetTimerStatement_12=ruleResetTimerStatement();

                    state._fsp--;


                    				current = this_ResetTimerStatement_12;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_13=(Token)match(input,43,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getStatementAccess().getSemicolonKeyword_7_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleAssignmentStatement"
    // InternalPoST.g:3240:1: entryRuleAssignmentStatement returns [EObject current=null] : iv_ruleAssignmentStatement= ruleAssignmentStatement EOF ;
    public final EObject entryRuleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStatement = null;


        try {
            // InternalPoST.g:3240:60: (iv_ruleAssignmentStatement= ruleAssignmentStatement EOF )
            // InternalPoST.g:3241:2: iv_ruleAssignmentStatement= ruleAssignmentStatement EOF
            {
             newCompositeNode(grammarAccess.getAssignmentStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentStatement=ruleAssignmentStatement();

            state._fsp--;

             current =iv_ruleAssignmentStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentStatement"


    // $ANTLR start "ruleAssignmentStatement"
    // InternalPoST.g:3247:1: ruleAssignmentStatement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_array_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3253:2: ( ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalPoST.g:3254:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalPoST.g:3254:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            // InternalPoST.g:3255:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) )
            {
            // InternalPoST.g:3255:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==104) ) {
                    alt45=2;
                }
                else if ( (LA45_1==47) ) {
                    alt45=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalPoST.g:3256:4: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalPoST.g:3256:4: ( (otherlv_0= RULE_ID ) )
                    // InternalPoST.g:3257:5: (otherlv_0= RULE_ID )
                    {
                    // InternalPoST.g:3257:5: (otherlv_0= RULE_ID )
                    // InternalPoST.g:3258:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentStatementRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_14); 

                    						newLeafNode(otherlv_0, grammarAccess.getAssignmentStatementAccess().getVariableSymbolicVariableCrossReference_0_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:3270:4: ( (lv_array_1_0= ruleArrayVariable ) )
                    {
                    // InternalPoST.g:3270:4: ( (lv_array_1_0= ruleArrayVariable ) )
                    // InternalPoST.g:3271:5: (lv_array_1_0= ruleArrayVariable )
                    {
                    // InternalPoST.g:3271:5: (lv_array_1_0= ruleArrayVariable )
                    // InternalPoST.g:3272:6: lv_array_1_0= ruleArrayVariable
                    {

                    						newCompositeNode(grammarAccess.getAssignmentStatementAccess().getArrayArrayVariableParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_array_1_0=ruleArrayVariable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAssignmentStatementRule());
                    						}
                    						set(
                    							current,
                    							"array",
                    							lv_array_1_0,
                    							"su.nsk.iae.post.PoST.ArrayVariable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,47,FOLLOW_48); 

            			newLeafNode(otherlv_2, grammarAccess.getAssignmentStatementAccess().getColonEqualsSignKeyword_1());
            		
            // InternalPoST.g:3294:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalPoST.g:3295:4: (lv_value_3_0= ruleExpression )
            {
            // InternalPoST.g:3295:4: (lv_value_3_0= ruleExpression )
            // InternalPoST.g:3296:5: lv_value_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getAssignmentStatementAccess().getValueExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentStatementRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentStatement"


    // $ANTLR start "entryRuleSelectionStatement"
    // InternalPoST.g:3317:1: entryRuleSelectionStatement returns [EObject current=null] : iv_ruleSelectionStatement= ruleSelectionStatement EOF ;
    public final EObject entryRuleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionStatement = null;


        try {
            // InternalPoST.g:3317:59: (iv_ruleSelectionStatement= ruleSelectionStatement EOF )
            // InternalPoST.g:3318:2: iv_ruleSelectionStatement= ruleSelectionStatement EOF
            {
             newCompositeNode(grammarAccess.getSelectionStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelectionStatement=ruleSelectionStatement();

            state._fsp--;

             current =iv_ruleSelectionStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectionStatement"


    // $ANTLR start "ruleSelectionStatement"
    // InternalPoST.g:3324:1: ruleSelectionStatement returns [EObject current=null] : (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement ) ;
    public final EObject ruleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_IfStatement_0 = null;

        EObject this_CaseStatement_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:3330:2: ( (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement ) )
            // InternalPoST.g:3331:2: (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement )
            {
            // InternalPoST.g:3331:2: (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==74) ) {
                alt46=1;
            }
            else if ( (LA46_0==78) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalPoST.g:3332:3: this_IfStatement_0= ruleIfStatement
                    {

                    			newCompositeNode(grammarAccess.getSelectionStatementAccess().getIfStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IfStatement_0=ruleIfStatement();

                    state._fsp--;


                    			current = this_IfStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:3341:3: this_CaseStatement_1= ruleCaseStatement
                    {

                    			newCompositeNode(grammarAccess.getSelectionStatementAccess().getCaseStatementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CaseStatement_1=ruleCaseStatement();

                    state._fsp--;


                    			current = this_CaseStatement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectionStatement"


    // $ANTLR start "entryRuleIfStatement"
    // InternalPoST.g:3353:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalPoST.g:3353:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalPoST.g:3354:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // InternalPoST.g:3360:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_mainCond_1_0 = null;

        EObject lv_mainStatement_3_0 = null;

        EObject lv_elseIfCond_5_0 = null;

        EObject lv_elseIfStatements_7_0 = null;

        EObject lv_elseStatement_9_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3366:2: ( (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' ) )
            // InternalPoST.g:3367:2: (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' )
            {
            // InternalPoST.g:3367:2: (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' )
            // InternalPoST.g:3368:3: otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIFKeyword_0());
            		
            // InternalPoST.g:3372:3: ( (lv_mainCond_1_0= ruleExpression ) )
            // InternalPoST.g:3373:4: (lv_mainCond_1_0= ruleExpression )
            {
            // InternalPoST.g:3373:4: (lv_mainCond_1_0= ruleExpression )
            // InternalPoST.g:3374:5: lv_mainCond_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getMainCondExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_43);
            lv_mainCond_1_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            					}
            					set(
            						current,
            						"mainCond",
            						lv_mainCond_1_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_58); 

            			newLeafNode(otherlv_2, grammarAccess.getIfStatementAccess().getTHENKeyword_2());
            		
            // InternalPoST.g:3395:3: ( (lv_mainStatement_3_0= ruleStatementList ) )
            // InternalPoST.g:3396:4: (lv_mainStatement_3_0= ruleStatementList )
            {
            // InternalPoST.g:3396:4: (lv_mainStatement_3_0= ruleStatementList )
            // InternalPoST.g:3397:5: lv_mainStatement_3_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getMainStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_59);
            lv_mainStatement_3_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            					}
            					set(
            						current,
            						"mainStatement",
            						lv_mainStatement_3_0,
            						"su.nsk.iae.post.PoST.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:3414:3: (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==75) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalPoST.g:3415:4: otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) )
            	    {
            	    otherlv_4=(Token)match(input,75,FOLLOW_48); 

            	    				newLeafNode(otherlv_4, grammarAccess.getIfStatementAccess().getELSIFKeyword_4_0());
            	    			
            	    // InternalPoST.g:3419:4: ( (lv_elseIfCond_5_0= ruleExpression ) )
            	    // InternalPoST.g:3420:5: (lv_elseIfCond_5_0= ruleExpression )
            	    {
            	    // InternalPoST.g:3420:5: (lv_elseIfCond_5_0= ruleExpression )
            	    // InternalPoST.g:3421:6: lv_elseIfCond_5_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfCondExpressionParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_43);
            	    lv_elseIfCond_5_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elseIfCond",
            	    							lv_elseIfCond_5_0,
            	    							"su.nsk.iae.post.PoST.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_6=(Token)match(input,70,FOLLOW_58); 

            	    				newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getTHENKeyword_4_2());
            	    			
            	    // InternalPoST.g:3442:4: ( (lv_elseIfStatements_7_0= ruleStatementList ) )
            	    // InternalPoST.g:3443:5: (lv_elseIfStatements_7_0= ruleStatementList )
            	    {
            	    // InternalPoST.g:3443:5: (lv_elseIfStatements_7_0= ruleStatementList )
            	    // InternalPoST.g:3444:6: lv_elseIfStatements_7_0= ruleStatementList
            	    {

            	    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfStatementsStatementListParserRuleCall_4_3_0());
            	    					
            	    pushFollow(FOLLOW_59);
            	    lv_elseIfStatements_7_0=ruleStatementList();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elseIfStatements",
            	    							lv_elseIfStatements_7_0,
            	    							"su.nsk.iae.post.PoST.StatementList");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            // InternalPoST.g:3462:3: (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==76) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalPoST.g:3463:4: otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) )
                    {
                    otherlv_8=(Token)match(input,76,FOLLOW_60); 

                    				newLeafNode(otherlv_8, grammarAccess.getIfStatementAccess().getELSEKeyword_5_0());
                    			
                    // InternalPoST.g:3467:4: ( (lv_elseStatement_9_0= ruleStatementList ) )
                    // InternalPoST.g:3468:5: (lv_elseStatement_9_0= ruleStatementList )
                    {
                    // InternalPoST.g:3468:5: (lv_elseStatement_9_0= ruleStatementList )
                    // InternalPoST.g:3469:6: lv_elseStatement_9_0= ruleStatementList
                    {

                    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseStatementStatementListParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_61);
                    lv_elseStatement_9_0=ruleStatementList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIfStatementRule());
                    						}
                    						set(
                    							current,
                    							"elseStatement",
                    							lv_elseStatement_9_0,
                    							"su.nsk.iae.post.PoST.StatementList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,77,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getIfStatementAccess().getEND_IFKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleCaseStatement"
    // InternalPoST.g:3495:1: entryRuleCaseStatement returns [EObject current=null] : iv_ruleCaseStatement= ruleCaseStatement EOF ;
    public final EObject entryRuleCaseStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStatement = null;


        try {
            // InternalPoST.g:3495:54: (iv_ruleCaseStatement= ruleCaseStatement EOF )
            // InternalPoST.g:3496:2: iv_ruleCaseStatement= ruleCaseStatement EOF
            {
             newCompositeNode(grammarAccess.getCaseStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCaseStatement=ruleCaseStatement();

            state._fsp--;

             current =iv_ruleCaseStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseStatement"


    // $ANTLR start "ruleCaseStatement"
    // InternalPoST.g:3502:1: ruleCaseStatement returns [EObject current=null] : (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' ) ;
    public final EObject ruleCaseStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_cond_1_0 = null;

        EObject lv_caseElements_3_0 = null;

        EObject lv_elseStatement_5_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3508:2: ( (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' ) )
            // InternalPoST.g:3509:2: (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' )
            {
            // InternalPoST.g:3509:2: (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' )
            // InternalPoST.g:3510:3: otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getCaseStatementAccess().getCASEKeyword_0());
            		
            // InternalPoST.g:3514:3: ( (lv_cond_1_0= ruleExpression ) )
            // InternalPoST.g:3515:4: (lv_cond_1_0= ruleExpression )
            {
            // InternalPoST.g:3515:4: (lv_cond_1_0= ruleExpression )
            // InternalPoST.g:3516:5: lv_cond_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getCaseStatementAccess().getCondExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_62);
            lv_cond_1_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseStatementRule());
            					}
            					set(
            						current,
            						"cond",
            						lv_cond_1_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,79,FOLLOW_63); 

            			newLeafNode(otherlv_2, grammarAccess.getCaseStatementAccess().getOFKeyword_2());
            		
            // InternalPoST.g:3537:3: ( (lv_caseElements_3_0= ruleCaseElement ) )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_INTEGER||LA49_0==110) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalPoST.g:3538:4: (lv_caseElements_3_0= ruleCaseElement )
            	    {
            	    // InternalPoST.g:3538:4: (lv_caseElements_3_0= ruleCaseElement )
            	    // InternalPoST.g:3539:5: lv_caseElements_3_0= ruleCaseElement
            	    {

            	    					newCompositeNode(grammarAccess.getCaseStatementAccess().getCaseElementsCaseElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_64);
            	    lv_caseElements_3_0=ruleCaseElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCaseStatementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"caseElements",
            	    						lv_caseElements_3_0,
            	    						"su.nsk.iae.post.PoST.CaseElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);

            // InternalPoST.g:3556:3: (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==76) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalPoST.g:3557:4: otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) )
                    {
                    otherlv_4=(Token)match(input,76,FOLLOW_65); 

                    				newLeafNode(otherlv_4, grammarAccess.getCaseStatementAccess().getELSEKeyword_4_0());
                    			
                    // InternalPoST.g:3561:4: ( (lv_elseStatement_5_0= ruleStatementList ) )
                    // InternalPoST.g:3562:5: (lv_elseStatement_5_0= ruleStatementList )
                    {
                    // InternalPoST.g:3562:5: (lv_elseStatement_5_0= ruleStatementList )
                    // InternalPoST.g:3563:6: lv_elseStatement_5_0= ruleStatementList
                    {

                    						newCompositeNode(grammarAccess.getCaseStatementAccess().getElseStatementStatementListParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_66);
                    lv_elseStatement_5_0=ruleStatementList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCaseStatementRule());
                    						}
                    						set(
                    							current,
                    							"elseStatement",
                    							lv_elseStatement_5_0,
                    							"su.nsk.iae.post.PoST.StatementList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,80,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getCaseStatementAccess().getEND_CASEKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseStatement"


    // $ANTLR start "entryRuleCaseElement"
    // InternalPoST.g:3589:1: entryRuleCaseElement returns [EObject current=null] : iv_ruleCaseElement= ruleCaseElement EOF ;
    public final EObject entryRuleCaseElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseElement = null;


        try {
            // InternalPoST.g:3589:52: (iv_ruleCaseElement= ruleCaseElement EOF )
            // InternalPoST.g:3590:2: iv_ruleCaseElement= ruleCaseElement EOF
            {
             newCompositeNode(grammarAccess.getCaseElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCaseElement=ruleCaseElement();

            state._fsp--;

             current =iv_ruleCaseElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseElement"


    // $ANTLR start "ruleCaseElement"
    // InternalPoST.g:3596:1: ruleCaseElement returns [EObject current=null] : ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) ) ;
    public final EObject ruleCaseElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_caseList_0_0 = null;

        EObject lv_statement_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3602:2: ( ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) ) )
            // InternalPoST.g:3603:2: ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) )
            {
            // InternalPoST.g:3603:2: ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) )
            // InternalPoST.g:3604:3: ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) )
            {
            // InternalPoST.g:3604:3: ( (lv_caseList_0_0= ruleCaseList ) )
            // InternalPoST.g:3605:4: (lv_caseList_0_0= ruleCaseList )
            {
            // InternalPoST.g:3605:4: (lv_caseList_0_0= ruleCaseList )
            // InternalPoST.g:3606:5: lv_caseList_0_0= ruleCaseList
            {

            					newCompositeNode(grammarAccess.getCaseElementAccess().getCaseListCaseListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
            lv_caseList_0_0=ruleCaseList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseElementRule());
            					}
            					set(
            						current,
            						"caseList",
            						lv_caseList_0_0,
            						"su.nsk.iae.post.PoST.CaseList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,51,FOLLOW_67); 

            			newLeafNode(otherlv_1, grammarAccess.getCaseElementAccess().getColonKeyword_1());
            		
            // InternalPoST.g:3627:3: ( (lv_statement_2_0= ruleStatementList ) )
            // InternalPoST.g:3628:4: (lv_statement_2_0= ruleStatementList )
            {
            // InternalPoST.g:3628:4: (lv_statement_2_0= ruleStatementList )
            // InternalPoST.g:3629:5: lv_statement_2_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getCaseElementAccess().getStatementStatementListParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_statement_2_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseElementRule());
            					}
            					set(
            						current,
            						"statement",
            						lv_statement_2_0,
            						"su.nsk.iae.post.PoST.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseElement"


    // $ANTLR start "entryRuleCaseList"
    // InternalPoST.g:3650:1: entryRuleCaseList returns [EObject current=null] : iv_ruleCaseList= ruleCaseList EOF ;
    public final EObject entryRuleCaseList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseList = null;


        try {
            // InternalPoST.g:3650:49: (iv_ruleCaseList= ruleCaseList EOF )
            // InternalPoST.g:3651:2: iv_ruleCaseList= ruleCaseList EOF
            {
             newCompositeNode(grammarAccess.getCaseListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCaseList=ruleCaseList();

            state._fsp--;

             current =iv_ruleCaseList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseList"


    // $ANTLR start "ruleCaseList"
    // InternalPoST.g:3657:1: ruleCaseList returns [EObject current=null] : ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* ) ;
    public final EObject ruleCaseList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_caseListElement_0_0 = null;

        EObject lv_caseListElement_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3663:2: ( ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* ) )
            // InternalPoST.g:3664:2: ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* )
            {
            // InternalPoST.g:3664:2: ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* )
            // InternalPoST.g:3665:3: ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )*
            {
            // InternalPoST.g:3665:3: ( (lv_caseListElement_0_0= ruleSignedInteger ) )
            // InternalPoST.g:3666:4: (lv_caseListElement_0_0= ruleSignedInteger )
            {
            // InternalPoST.g:3666:4: (lv_caseListElement_0_0= ruleSignedInteger )
            // InternalPoST.g:3667:5: lv_caseListElement_0_0= ruleSignedInteger
            {

            					newCompositeNode(grammarAccess.getCaseListAccess().getCaseListElementSignedIntegerParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_caseListElement_0_0=ruleSignedInteger();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCaseListRule());
            					}
            					add(
            						current,
            						"caseListElement",
            						lv_caseListElement_0_0,
            						"su.nsk.iae.post.PoST.SignedInteger");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:3684:3: (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==48) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalPoST.g:3685:4: otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_63); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCaseListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:3689:4: ( (lv_caseListElement_2_0= ruleSignedInteger ) )
            	    // InternalPoST.g:3690:5: (lv_caseListElement_2_0= ruleSignedInteger )
            	    {
            	    // InternalPoST.g:3690:5: (lv_caseListElement_2_0= ruleSignedInteger )
            	    // InternalPoST.g:3691:6: lv_caseListElement_2_0= ruleSignedInteger
            	    {

            	    						newCompositeNode(grammarAccess.getCaseListAccess().getCaseListElementSignedIntegerParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_caseListElement_2_0=ruleSignedInteger();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCaseListRule());
            	    						}
            	    						add(
            	    							current,
            	    							"caseListElement",
            	    							lv_caseListElement_2_0,
            	    							"su.nsk.iae.post.PoST.SignedInteger");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseList"


    // $ANTLR start "entryRuleIterationStatement"
    // InternalPoST.g:3713:1: entryRuleIterationStatement returns [EObject current=null] : iv_ruleIterationStatement= ruleIterationStatement EOF ;
    public final EObject entryRuleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationStatement = null;


        try {
            // InternalPoST.g:3713:59: (iv_ruleIterationStatement= ruleIterationStatement EOF )
            // InternalPoST.g:3714:2: iv_ruleIterationStatement= ruleIterationStatement EOF
            {
             newCompositeNode(grammarAccess.getIterationStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIterationStatement=ruleIterationStatement();

            state._fsp--;

             current =iv_ruleIterationStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIterationStatement"


    // $ANTLR start "ruleIterationStatement"
    // InternalPoST.g:3720:1: ruleIterationStatement returns [EObject current=null] : (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement ) ;
    public final EObject ruleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatement_0 = null;

        EObject this_WhileStatement_1 = null;

        EObject this_RepeatStatement_2 = null;



        	enterRule();

        try {
            // InternalPoST.g:3726:2: ( (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement ) )
            // InternalPoST.g:3727:2: (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement )
            {
            // InternalPoST.g:3727:2: (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement )
            int alt52=3;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt52=1;
                }
                break;
            case 86:
                {
                alt52=2;
                }
                break;
            case 88:
                {
                alt52=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalPoST.g:3728:3: this_ForStatement_0= ruleForStatement
                    {

                    			newCompositeNode(grammarAccess.getIterationStatementAccess().getForStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForStatement_0=ruleForStatement();

                    state._fsp--;


                    			current = this_ForStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:3737:3: this_WhileStatement_1= ruleWhileStatement
                    {

                    			newCompositeNode(grammarAccess.getIterationStatementAccess().getWhileStatementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_WhileStatement_1=ruleWhileStatement();

                    state._fsp--;


                    			current = this_WhileStatement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalPoST.g:3746:3: this_RepeatStatement_2= ruleRepeatStatement
                    {

                    			newCompositeNode(grammarAccess.getIterationStatementAccess().getRepeatStatementParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_RepeatStatement_2=ruleRepeatStatement();

                    state._fsp--;


                    			current = this_RepeatStatement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIterationStatement"


    // $ANTLR start "entryRuleForStatement"
    // InternalPoST.g:3758:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalPoST.g:3758:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalPoST.g:3759:2: iv_ruleForStatement= ruleForStatement EOF
            {
             newCompositeNode(grammarAccess.getForStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForStatement=ruleForStatement();

            state._fsp--;

             current =iv_ruleForStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForStatement"


    // $ANTLR start "ruleForStatement"
    // InternalPoST.g:3765:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' ) ;
    public final EObject ruleForStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_forList_3_0 = null;

        EObject lv_statement_5_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3771:2: ( (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' ) )
            // InternalPoST.g:3772:2: (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' )
            {
            // InternalPoST.g:3772:2: (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' )
            // InternalPoST.g:3773:3: otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getFORKeyword_0());
            		
            // InternalPoST.g:3777:3: ( (otherlv_1= RULE_ID ) )
            // InternalPoST.g:3778:4: (otherlv_1= RULE_ID )
            {
            // InternalPoST.g:3778:4: (otherlv_1= RULE_ID )
            // InternalPoST.g:3779:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getForStatementRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getVariableSymbolicVariableCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,47,FOLLOW_48); 

            			newLeafNode(otherlv_2, grammarAccess.getForStatementAccess().getColonEqualsSignKeyword_2());
            		
            // InternalPoST.g:3794:3: ( (lv_forList_3_0= ruleForList ) )
            // InternalPoST.g:3795:4: (lv_forList_3_0= ruleForList )
            {
            // InternalPoST.g:3795:4: (lv_forList_3_0= ruleForList )
            // InternalPoST.g:3796:5: lv_forList_3_0= ruleForList
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getForListForListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_68);
            lv_forList_3_0=ruleForList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRule());
            					}
            					set(
            						current,
            						"forList",
            						lv_forList_3_0,
            						"su.nsk.iae.post.PoST.ForList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,82,FOLLOW_69); 

            			newLeafNode(otherlv_4, grammarAccess.getForStatementAccess().getDOKeyword_4());
            		
            // InternalPoST.g:3817:3: ( (lv_statement_5_0= ruleStatementList ) )
            // InternalPoST.g:3818:4: (lv_statement_5_0= ruleStatementList )
            {
            // InternalPoST.g:3818:4: (lv_statement_5_0= ruleStatementList )
            // InternalPoST.g:3819:5: lv_statement_5_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getStatementStatementListParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_70);
            lv_statement_5_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForStatementRule());
            					}
            					set(
            						current,
            						"statement",
            						lv_statement_5_0,
            						"su.nsk.iae.post.PoST.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,83,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getForStatementAccess().getEND_FORKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForStatement"


    // $ANTLR start "entryRuleForList"
    // InternalPoST.g:3844:1: entryRuleForList returns [EObject current=null] : iv_ruleForList= ruleForList EOF ;
    public final EObject entryRuleForList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForList = null;


        try {
            // InternalPoST.g:3844:48: (iv_ruleForList= ruleForList EOF )
            // InternalPoST.g:3845:2: iv_ruleForList= ruleForList EOF
            {
             newCompositeNode(grammarAccess.getForListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForList=ruleForList();

            state._fsp--;

             current =iv_ruleForList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForList"


    // $ANTLR start "ruleForList"
    // InternalPoST.g:3851:1: ruleForList returns [EObject current=null] : ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleForList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_start_0_0 = null;

        EObject lv_end_2_0 = null;

        EObject lv_step_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3857:2: ( ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? ) )
            // InternalPoST.g:3858:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? )
            {
            // InternalPoST.g:3858:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? )
            // InternalPoST.g:3859:3: ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )?
            {
            // InternalPoST.g:3859:3: ( (lv_start_0_0= ruleExpression ) )
            // InternalPoST.g:3860:4: (lv_start_0_0= ruleExpression )
            {
            // InternalPoST.g:3860:4: (lv_start_0_0= ruleExpression )
            // InternalPoST.g:3861:5: lv_start_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getForListAccess().getStartExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_71);
            lv_start_0_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForListRule());
            					}
            					set(
            						current,
            						"start",
            						lv_start_0_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,84,FOLLOW_48); 

            			newLeafNode(otherlv_1, grammarAccess.getForListAccess().getTOKeyword_1());
            		
            // InternalPoST.g:3882:3: ( (lv_end_2_0= ruleExpression ) )
            // InternalPoST.g:3883:4: (lv_end_2_0= ruleExpression )
            {
            // InternalPoST.g:3883:4: (lv_end_2_0= ruleExpression )
            // InternalPoST.g:3884:5: lv_end_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getForListAccess().getEndExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_72);
            lv_end_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForListRule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_2_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:3901:3: (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==85) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalPoST.g:3902:4: otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,85,FOLLOW_48); 

                    				newLeafNode(otherlv_3, grammarAccess.getForListAccess().getBYKeyword_3_0());
                    			
                    // InternalPoST.g:3906:4: ( (lv_step_4_0= ruleExpression ) )
                    // InternalPoST.g:3907:5: (lv_step_4_0= ruleExpression )
                    {
                    // InternalPoST.g:3907:5: (lv_step_4_0= ruleExpression )
                    // InternalPoST.g:3908:6: lv_step_4_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getForListAccess().getStepExpressionParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_step_4_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getForListRule());
                    						}
                    						set(
                    							current,
                    							"step",
                    							lv_step_4_0,
                    							"su.nsk.iae.post.PoST.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForList"


    // $ANTLR start "entryRuleWhileStatement"
    // InternalPoST.g:3930:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalPoST.g:3930:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalPoST.g:3931:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             newCompositeNode(grammarAccess.getWhileStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // InternalPoST.g:3937:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_cond_1_0 = null;

        EObject lv_statement_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3943:2: ( (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' ) )
            // InternalPoST.g:3944:2: (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' )
            {
            // InternalPoST.g:3944:2: (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' )
            // InternalPoST.g:3945:3: otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE'
            {
            otherlv_0=(Token)match(input,86,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWHILEKeyword_0());
            		
            // InternalPoST.g:3949:3: ( (lv_cond_1_0= ruleExpression ) )
            // InternalPoST.g:3950:4: (lv_cond_1_0= ruleExpression )
            {
            // InternalPoST.g:3950:4: (lv_cond_1_0= ruleExpression )
            // InternalPoST.g:3951:5: lv_cond_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getCondExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_68);
            lv_cond_1_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            					}
            					set(
            						current,
            						"cond",
            						lv_cond_1_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,82,FOLLOW_73); 

            			newLeafNode(otherlv_2, grammarAccess.getWhileStatementAccess().getDOKeyword_2());
            		
            // InternalPoST.g:3972:3: ( (lv_statement_3_0= ruleStatementList ) )
            // InternalPoST.g:3973:4: (lv_statement_3_0= ruleStatementList )
            {
            // InternalPoST.g:3973:4: (lv_statement_3_0= ruleStatementList )
            // InternalPoST.g:3974:5: lv_statement_3_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_74);
            lv_statement_3_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            					}
            					set(
            						current,
            						"statement",
            						lv_statement_3_0,
            						"su.nsk.iae.post.PoST.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,87,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getEND_WHILEKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleRepeatStatement"
    // InternalPoST.g:3999:1: entryRuleRepeatStatement returns [EObject current=null] : iv_ruleRepeatStatement= ruleRepeatStatement EOF ;
    public final EObject entryRuleRepeatStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeatStatement = null;


        try {
            // InternalPoST.g:3999:56: (iv_ruleRepeatStatement= ruleRepeatStatement EOF )
            // InternalPoST.g:4000:2: iv_ruleRepeatStatement= ruleRepeatStatement EOF
            {
             newCompositeNode(grammarAccess.getRepeatStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRepeatStatement=ruleRepeatStatement();

            state._fsp--;

             current =iv_ruleRepeatStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRepeatStatement"


    // $ANTLR start "ruleRepeatStatement"
    // InternalPoST.g:4006:1: ruleRepeatStatement returns [EObject current=null] : (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' ) ;
    public final EObject ruleRepeatStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_statement_1_0 = null;

        EObject lv_cond_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4012:2: ( (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' ) )
            // InternalPoST.g:4013:2: (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' )
            {
            // InternalPoST.g:4013:2: (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' )
            // InternalPoST.g:4014:3: otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_75); 

            			newLeafNode(otherlv_0, grammarAccess.getRepeatStatementAccess().getREPEATKeyword_0());
            		
            // InternalPoST.g:4018:3: ( (lv_statement_1_0= ruleStatementList ) )
            // InternalPoST.g:4019:4: (lv_statement_1_0= ruleStatementList )
            {
            // InternalPoST.g:4019:4: (lv_statement_1_0= ruleStatementList )
            // InternalPoST.g:4020:5: lv_statement_1_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getRepeatStatementAccess().getStatementStatementListParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_76);
            lv_statement_1_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRepeatStatementRule());
            					}
            					set(
            						current,
            						"statement",
            						lv_statement_1_0,
            						"su.nsk.iae.post.PoST.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,89,FOLLOW_48); 

            			newLeafNode(otherlv_2, grammarAccess.getRepeatStatementAccess().getUNTILKeyword_2());
            		
            // InternalPoST.g:4041:3: ( (lv_cond_3_0= ruleExpression ) )
            // InternalPoST.g:4042:4: (lv_cond_3_0= ruleExpression )
            {
            // InternalPoST.g:4042:4: (lv_cond_3_0= ruleExpression )
            // InternalPoST.g:4043:5: lv_cond_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getRepeatStatementAccess().getCondExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_77);
            lv_cond_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRepeatStatementRule());
            					}
            					set(
            						current,
            						"cond",
            						lv_cond_3_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,90,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getRepeatStatementAccess().getEND_REPEATKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRepeatStatement"


    // $ANTLR start "entryRuleSubprogramControlStatement"
    // InternalPoST.g:4068:1: entryRuleSubprogramControlStatement returns [EObject current=null] : iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF ;
    public final EObject entryRuleSubprogramControlStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubprogramControlStatement = null;


        try {
            // InternalPoST.g:4068:67: (iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF )
            // InternalPoST.g:4069:2: iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF
            {
             newCompositeNode(grammarAccess.getSubprogramControlStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubprogramControlStatement=ruleSubprogramControlStatement();

            state._fsp--;

             current =iv_ruleSubprogramControlStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubprogramControlStatement"


    // $ANTLR start "ruleSubprogramControlStatement"
    // InternalPoST.g:4075:1: ruleSubprogramControlStatement returns [EObject current=null] : ( () otherlv_1= 'RETURN' ) ;
    public final EObject ruleSubprogramControlStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPoST.g:4081:2: ( ( () otherlv_1= 'RETURN' ) )
            // InternalPoST.g:4082:2: ( () otherlv_1= 'RETURN' )
            {
            // InternalPoST.g:4082:2: ( () otherlv_1= 'RETURN' )
            // InternalPoST.g:4083:3: () otherlv_1= 'RETURN'
            {
            // InternalPoST.g:4083:3: ()
            // InternalPoST.g:4084:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubprogramControlStatementAccess().getSubprogramControlStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,91,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSubprogramControlStatementAccess().getRETURNKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubprogramControlStatement"


    // $ANTLR start "entryRuleExitStatement"
    // InternalPoST.g:4098:1: entryRuleExitStatement returns [EObject current=null] : iv_ruleExitStatement= ruleExitStatement EOF ;
    public final EObject entryRuleExitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitStatement = null;


        try {
            // InternalPoST.g:4098:54: (iv_ruleExitStatement= ruleExitStatement EOF )
            // InternalPoST.g:4099:2: iv_ruleExitStatement= ruleExitStatement EOF
            {
             newCompositeNode(grammarAccess.getExitStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExitStatement=ruleExitStatement();

            state._fsp--;

             current =iv_ruleExitStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExitStatement"


    // $ANTLR start "ruleExitStatement"
    // InternalPoST.g:4105:1: ruleExitStatement returns [EObject current=null] : ( () otherlv_1= 'EXIT' ) ;
    public final EObject ruleExitStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPoST.g:4111:2: ( ( () otherlv_1= 'EXIT' ) )
            // InternalPoST.g:4112:2: ( () otherlv_1= 'EXIT' )
            {
            // InternalPoST.g:4112:2: ( () otherlv_1= 'EXIT' )
            // InternalPoST.g:4113:3: () otherlv_1= 'EXIT'
            {
            // InternalPoST.g:4113:3: ()
            // InternalPoST.g:4114:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExitStatementAccess().getExitStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,92,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getExitStatementAccess().getEXITKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExitStatement"


    // $ANTLR start "entryRuleSymbolicVariable"
    // InternalPoST.g:4128:1: entryRuleSymbolicVariable returns [EObject current=null] : iv_ruleSymbolicVariable= ruleSymbolicVariable EOF ;
    public final EObject entryRuleSymbolicVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolicVariable = null;


        try {
            // InternalPoST.g:4128:57: (iv_ruleSymbolicVariable= ruleSymbolicVariable EOF )
            // InternalPoST.g:4129:2: iv_ruleSymbolicVariable= ruleSymbolicVariable EOF
            {
             newCompositeNode(grammarAccess.getSymbolicVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSymbolicVariable=ruleSymbolicVariable();

            state._fsp--;

             current =iv_ruleSymbolicVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSymbolicVariable"


    // $ANTLR start "ruleSymbolicVariable"
    // InternalPoST.g:4135:1: ruleSymbolicVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleSymbolicVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPoST.g:4141:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPoST.g:4142:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPoST.g:4142:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPoST.g:4143:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPoST.g:4143:3: (lv_name_0_0= RULE_ID )
            // InternalPoST.g:4144:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getSymbolicVariableAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getSymbolicVariableRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"su.nsk.iae.post.PoST.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSymbolicVariable"


    // $ANTLR start "entryRuleSimpleSpecificationInit"
    // InternalPoST.g:4163:1: entryRuleSimpleSpecificationInit returns [EObject current=null] : iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF ;
    public final EObject entryRuleSimpleSpecificationInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleSpecificationInit = null;


        try {
            // InternalPoST.g:4163:64: (iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF )
            // InternalPoST.g:4164:2: iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF
            {
             newCompositeNode(grammarAccess.getSimpleSpecificationInitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleSpecificationInit=ruleSimpleSpecificationInit();

            state._fsp--;

             current =iv_ruleSimpleSpecificationInit; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleSpecificationInit"


    // $ANTLR start "ruleSimpleSpecificationInit"
    // InternalPoST.g:4170:1: ruleSimpleSpecificationInit returns [EObject current=null] : ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleSimpleSpecificationInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4176:2: ( ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )? ) )
            // InternalPoST.g:4177:2: ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )? )
            {
            // InternalPoST.g:4177:2: ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )? )
            // InternalPoST.g:4178:3: () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )?
            {
            // InternalPoST.g:4178:3: ()
            // InternalPoST.g:4179:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleSpecificationInitAccess().getSimpleSpecificationInitAction_0(),
            					current);
            			

            }

            // InternalPoST.g:4185:3: ( (lv_type_1_0= ruleDataTypeName ) )
            // InternalPoST.g:4186:4: (lv_type_1_0= ruleDataTypeName )
            {
            // InternalPoST.g:4186:4: (lv_type_1_0= ruleDataTypeName )
            // InternalPoST.g:4187:5: lv_type_1_0= ruleDataTypeName
            {

            					newCompositeNode(grammarAccess.getSimpleSpecificationInitAccess().getTypeDataTypeNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_78);
            lv_type_1_0=ruleDataTypeName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleSpecificationInitRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"su.nsk.iae.post.PoST.DataTypeName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:4204:3: (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==47) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalPoST.g:4205:4: otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_48); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleSpecificationInitAccess().getColonEqualsSignKeyword_2_0());
                    			
                    // InternalPoST.g:4209:4: ( (lv_value_3_0= ruleExpression ) )
                    // InternalPoST.g:4210:5: (lv_value_3_0= ruleExpression )
                    {
                    // InternalPoST.g:4210:5: (lv_value_3_0= ruleExpression )
                    // InternalPoST.g:4211:6: lv_value_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getSimpleSpecificationInitAccess().getValueExpressionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleSpecificationInitRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"su.nsk.iae.post.PoST.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleSpecificationInit"


    // $ANTLR start "entryRuleVarList"
    // InternalPoST.g:4233:1: entryRuleVarList returns [EObject current=null] : iv_ruleVarList= ruleVarList EOF ;
    public final EObject entryRuleVarList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarList = null;


        try {
            // InternalPoST.g:4233:48: (iv_ruleVarList= ruleVarList EOF )
            // InternalPoST.g:4234:2: iv_ruleVarList= ruleVarList EOF
            {
             newCompositeNode(grammarAccess.getVarListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarList=ruleVarList();

            state._fsp--;

             current =iv_ruleVarList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarList"


    // $ANTLR start "ruleVarList"
    // InternalPoST.g:4240:1: ruleVarList returns [EObject current=null] : ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* ) ;
    public final EObject ruleVarList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_vars_0_0 = null;

        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4246:2: ( ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* ) )
            // InternalPoST.g:4247:2: ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* )
            {
            // InternalPoST.g:4247:2: ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* )
            // InternalPoST.g:4248:3: ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )*
            {
            // InternalPoST.g:4248:3: ( (lv_vars_0_0= ruleSymbolicVariable ) )
            // InternalPoST.g:4249:4: (lv_vars_0_0= ruleSymbolicVariable )
            {
            // InternalPoST.g:4249:4: (lv_vars_0_0= ruleSymbolicVariable )
            // InternalPoST.g:4250:5: lv_vars_0_0= ruleSymbolicVariable
            {

            					newCompositeNode(grammarAccess.getVarListAccess().getVarsSymbolicVariableParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_vars_0_0=ruleSymbolicVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVarListRule());
            					}
            					add(
            						current,
            						"vars",
            						lv_vars_0_0,
            						"su.nsk.iae.post.PoST.SymbolicVariable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:4267:3: (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==48) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalPoST.g:4268:4: otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getVarListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:4272:4: ( (lv_vars_2_0= ruleSymbolicVariable ) )
            	    // InternalPoST.g:4273:5: (lv_vars_2_0= ruleSymbolicVariable )
            	    {
            	    // InternalPoST.g:4273:5: (lv_vars_2_0= ruleSymbolicVariable )
            	    // InternalPoST.g:4274:6: lv_vars_2_0= ruleSymbolicVariable
            	    {

            	    						newCompositeNode(grammarAccess.getVarListAccess().getVarsSymbolicVariableParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_vars_2_0=ruleSymbolicVariable();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getVarListRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"su.nsk.iae.post.PoST.SymbolicVariable");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarList"


    // $ANTLR start "entryRuleVarInitDeclaration"
    // InternalPoST.g:4296:1: entryRuleVarInitDeclaration returns [EObject current=null] : iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF ;
    public final EObject entryRuleVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarInitDeclaration = null;


        try {
            // InternalPoST.g:4296:59: (iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF )
            // InternalPoST.g:4297:2: iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVarInitDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarInitDeclaration=ruleVarInitDeclaration();

            state._fsp--;

             current =iv_ruleVarInitDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarInitDeclaration"


    // $ANTLR start "ruleVarInitDeclaration"
    // InternalPoST.g:4303:1: ruleVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) ) ) ;
    public final EObject ruleVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_varList_0_0 = null;

        EObject lv_spec_2_0 = null;

        EObject lv_arrSpec_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4309:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) ) ) )
            // InternalPoST.g:4310:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) ) )
            {
            // InternalPoST.g:4310:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) ) )
            // InternalPoST.g:4311:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) )
            {
            // InternalPoST.g:4311:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:4312:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:4312:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:4313:5: lv_varList_0_0= ruleVarList
            {

            					newCompositeNode(grammarAccess.getVarInitDeclarationAccess().getVarListVarListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
            lv_varList_0_0=ruleVarList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVarInitDeclarationRule());
            					}
            					set(
            						current,
            						"varList",
            						lv_varList_0_0,
            						"su.nsk.iae.post.PoST.VarList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,51,FOLLOW_79); 

            			newLeafNode(otherlv_1, grammarAccess.getVarInitDeclarationAccess().getColonKeyword_1());
            		
            // InternalPoST.g:4334:3: ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_BIT_STRING_TYPE_NAME && LA56_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt56=1;
            }
            else if ( (LA56_0==106) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalPoST.g:4335:4: ( (lv_spec_2_0= ruleSimpleSpecificationInit ) )
                    {
                    // InternalPoST.g:4335:4: ( (lv_spec_2_0= ruleSimpleSpecificationInit ) )
                    // InternalPoST.g:4336:5: (lv_spec_2_0= ruleSimpleSpecificationInit )
                    {
                    // InternalPoST.g:4336:5: (lv_spec_2_0= ruleSimpleSpecificationInit )
                    // InternalPoST.g:4337:6: lv_spec_2_0= ruleSimpleSpecificationInit
                    {

                    						newCompositeNode(grammarAccess.getVarInitDeclarationAccess().getSpecSimpleSpecificationInitParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_spec_2_0=ruleSimpleSpecificationInit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVarInitDeclarationRule());
                    						}
                    						set(
                    							current,
                    							"spec",
                    							lv_spec_2_0,
                    							"su.nsk.iae.post.PoST.SimpleSpecificationInit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:4355:4: ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) )
                    {
                    // InternalPoST.g:4355:4: ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) )
                    // InternalPoST.g:4356:5: (lv_arrSpec_3_0= ruleArraySpecificationInit )
                    {
                    // InternalPoST.g:4356:5: (lv_arrSpec_3_0= ruleArraySpecificationInit )
                    // InternalPoST.g:4357:6: lv_arrSpec_3_0= ruleArraySpecificationInit
                    {

                    						newCompositeNode(grammarAccess.getVarInitDeclarationAccess().getArrSpecArraySpecificationInitParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_arrSpec_3_0=ruleArraySpecificationInit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVarInitDeclarationRule());
                    						}
                    						set(
                    							current,
                    							"arrSpec",
                    							lv_arrSpec_3_0,
                    							"su.nsk.iae.post.PoST.ArraySpecificationInit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarInitDeclaration"


    // $ANTLR start "entryRuleInputVarDeclaration"
    // InternalPoST.g:4379:1: entryRuleInputVarDeclaration returns [EObject current=null] : iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF ;
    public final EObject entryRuleInputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputVarDeclaration = null;


        try {
            // InternalPoST.g:4379:60: (iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF )
            // InternalPoST.g:4380:2: iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getInputVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInputVarDeclaration=ruleInputVarDeclaration();

            state._fsp--;

             current =iv_ruleInputVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInputVarDeclaration"


    // $ANTLR start "ruleInputVarDeclaration"
    // InternalPoST.g:4386:1: ruleInputVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleInputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4392:2: ( ( () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4393:2: ( () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4393:2: ( () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:4394:3: () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:4394:3: ()
            // InternalPoST.g:4395:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInputVarDeclarationAccess().getInputVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,93,FOLLOW_80); 

            			newLeafNode(otherlv_1, grammarAccess.getInputVarDeclarationAccess().getVAR_INPUTKeyword_1());
            		
            // InternalPoST.g:4405:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ID) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalPoST.g:4406:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4406:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4407:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4407:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4408:6: lv_vars_2_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getInputVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_2_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInputVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,43,FOLLOW_80); 

            	    				newLeafNode(otherlv_3, grammarAccess.getInputVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            otherlv_4=(Token)match(input,94,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getInputVarDeclarationAccess().getEND_VARKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInputVarDeclaration"


    // $ANTLR start "entryRuleOutputVarDeclaration"
    // InternalPoST.g:4438:1: entryRuleOutputVarDeclaration returns [EObject current=null] : iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF ;
    public final EObject entryRuleOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputVarDeclaration = null;


        try {
            // InternalPoST.g:4438:61: (iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF )
            // InternalPoST.g:4439:2: iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getOutputVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutputVarDeclaration=ruleOutputVarDeclaration();

            state._fsp--;

             current =iv_ruleOutputVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutputVarDeclaration"


    // $ANTLR start "ruleOutputVarDeclaration"
    // InternalPoST.g:4445:1: ruleOutputVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4451:2: ( ( () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4452:2: ( () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4452:2: ( () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:4453:3: () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:4453:3: ()
            // InternalPoST.g:4454:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOutputVarDeclarationAccess().getOutputVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,95,FOLLOW_80); 

            			newLeafNode(otherlv_1, grammarAccess.getOutputVarDeclarationAccess().getVAR_OUTPUTKeyword_1());
            		
            // InternalPoST.g:4464:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalPoST.g:4465:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4465:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4466:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4466:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4467:6: lv_vars_2_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getOutputVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_2_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOutputVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,43,FOLLOW_80); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOutputVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            otherlv_4=(Token)match(input,94,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getOutputVarDeclarationAccess().getEND_VARKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputVarDeclaration"


    // $ANTLR start "entryRuleInputOutputVarDeclaration"
    // InternalPoST.g:4497:1: entryRuleInputOutputVarDeclaration returns [EObject current=null] : iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF ;
    public final EObject entryRuleInputOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputOutputVarDeclaration = null;


        try {
            // InternalPoST.g:4497:66: (iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF )
            // InternalPoST.g:4498:2: iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getInputOutputVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInputOutputVarDeclaration=ruleInputOutputVarDeclaration();

            state._fsp--;

             current =iv_ruleInputOutputVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInputOutputVarDeclaration"


    // $ANTLR start "ruleInputOutputVarDeclaration"
    // InternalPoST.g:4504:1: ruleInputOutputVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleInputOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4510:2: ( ( () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4511:2: ( () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4511:2: ( () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:4512:3: () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:4512:3: ()
            // InternalPoST.g:4513:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInputOutputVarDeclarationAccess().getInputOutputVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,96,FOLLOW_80); 

            			newLeafNode(otherlv_1, grammarAccess.getInputOutputVarDeclarationAccess().getVAR_IN_OUTKeyword_1());
            		
            // InternalPoST.g:4523:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ID) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalPoST.g:4524:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4524:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4525:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4525:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4526:6: lv_vars_2_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getInputOutputVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_2_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInputOutputVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,43,FOLLOW_80); 

            	    				newLeafNode(otherlv_3, grammarAccess.getInputOutputVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

            otherlv_4=(Token)match(input,94,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getInputOutputVarDeclarationAccess().getEND_VARKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInputOutputVarDeclaration"


    // $ANTLR start "entryRuleVarDeclaration"
    // InternalPoST.g:4556:1: entryRuleVarDeclaration returns [EObject current=null] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final EObject entryRuleVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDeclaration = null;


        try {
            // InternalPoST.g:4556:55: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // InternalPoST.g:4557:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarDeclaration=ruleVarDeclaration();

            state._fsp--;

             current =iv_ruleVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDeclaration"


    // $ANTLR start "ruleVarDeclaration"
    // InternalPoST.g:4563:1: ruleVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' ) ;
    public final EObject ruleVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_const_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_vars_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4569:2: ( ( () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' ) )
            // InternalPoST.g:4570:2: ( () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' )
            {
            // InternalPoST.g:4570:2: ( () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' )
            // InternalPoST.g:4571:3: () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR'
            {
            // InternalPoST.g:4571:3: ()
            // InternalPoST.g:4572:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVarDeclarationAccess().getVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,97,FOLLOW_81); 

            			newLeafNode(otherlv_1, grammarAccess.getVarDeclarationAccess().getVARKeyword_1());
            		
            // InternalPoST.g:4582:3: ( (lv_const_2_0= 'CONSTANT' ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==98) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalPoST.g:4583:4: (lv_const_2_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4583:4: (lv_const_2_0= 'CONSTANT' )
                    // InternalPoST.g:4584:5: lv_const_2_0= 'CONSTANT'
                    {
                    lv_const_2_0=(Token)match(input,98,FOLLOW_80); 

                    					newLeafNode(lv_const_2_0, grammarAccess.getVarDeclarationAccess().getConstCONSTANTKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_2_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:4596:3: ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_ID) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalPoST.g:4597:4: ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';'
            	    {
            	    // InternalPoST.g:4597:4: ( (lv_vars_3_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4598:5: (lv_vars_3_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4598:5: (lv_vars_3_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4599:6: lv_vars_3_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_3_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_3_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,43,FOLLOW_80); 

            	    				newLeafNode(otherlv_4, grammarAccess.getVarDeclarationAccess().getSemicolonKeyword_3_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            otherlv_5=(Token)match(input,94,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getVarDeclarationAccess().getEND_VARKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarDeclaration"


    // $ANTLR start "entryRuleTempVarDeclaration"
    // InternalPoST.g:4629:1: entryRuleTempVarDeclaration returns [EObject current=null] : iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF ;
    public final EObject entryRuleTempVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTempVarDeclaration = null;


        try {
            // InternalPoST.g:4629:59: (iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF )
            // InternalPoST.g:4630:2: iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getTempVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTempVarDeclaration=ruleTempVarDeclaration();

            state._fsp--;

             current =iv_ruleTempVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTempVarDeclaration"


    // $ANTLR start "ruleTempVarDeclaration"
    // InternalPoST.g:4636:1: ruleTempVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleTempVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4642:2: ( ( () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4643:2: ( () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4643:2: ( () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:4644:3: () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:4644:3: ()
            // InternalPoST.g:4645:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTempVarDeclarationAccess().getTempVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,99,FOLLOW_80); 

            			newLeafNode(otherlv_1, grammarAccess.getTempVarDeclarationAccess().getVAR_TEMPKeyword_1());
            		
            // InternalPoST.g:4655:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalPoST.g:4656:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4656:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4657:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4657:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4658:6: lv_vars_2_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getTempVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_2_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTempVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,43,FOLLOW_80); 

            	    				newLeafNode(otherlv_3, grammarAccess.getTempVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_4=(Token)match(input,94,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTempVarDeclarationAccess().getEND_VARKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTempVarDeclaration"


    // $ANTLR start "entryRuleExternalVarInitDeclaration"
    // InternalPoST.g:4688:1: entryRuleExternalVarInitDeclaration returns [EObject current=null] : iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF ;
    public final EObject entryRuleExternalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalVarInitDeclaration = null;


        try {
            // InternalPoST.g:4688:67: (iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF )
            // InternalPoST.g:4689:2: iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF
            {
             newCompositeNode(grammarAccess.getExternalVarInitDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExternalVarInitDeclaration=ruleExternalVarInitDeclaration();

            state._fsp--;

             current =iv_ruleExternalVarInitDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalVarInitDeclaration"


    // $ANTLR start "ruleExternalVarInitDeclaration"
    // InternalPoST.g:4695:1: ruleExternalVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleExternalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_varList_0_0 = null;

        AntlrDatatypeRuleToken lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4701:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:4702:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:4702:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) )
            // InternalPoST.g:4703:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) )
            {
            // InternalPoST.g:4703:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:4704:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:4704:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:4705:5: lv_varList_0_0= ruleVarList
            {

            					newCompositeNode(grammarAccess.getExternalVarInitDeclarationAccess().getVarListVarListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
            lv_varList_0_0=ruleVarList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExternalVarInitDeclarationRule());
            					}
            					set(
            						current,
            						"varList",
            						lv_varList_0_0,
            						"su.nsk.iae.post.PoST.VarList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,51,FOLLOW_82); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalVarInitDeclarationAccess().getColonKeyword_1());
            		
            // InternalPoST.g:4726:3: ( (lv_type_2_0= ruleDataTypeName ) )
            // InternalPoST.g:4727:4: (lv_type_2_0= ruleDataTypeName )
            {
            // InternalPoST.g:4727:4: (lv_type_2_0= ruleDataTypeName )
            // InternalPoST.g:4728:5: lv_type_2_0= ruleDataTypeName
            {

            					newCompositeNode(grammarAccess.getExternalVarInitDeclarationAccess().getTypeDataTypeNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleDataTypeName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExternalVarInitDeclarationRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"su.nsk.iae.post.PoST.DataTypeName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalVarInitDeclaration"


    // $ANTLR start "entryRuleExternalVarDeclaration"
    // InternalPoST.g:4749:1: entryRuleExternalVarDeclaration returns [EObject current=null] : iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF ;
    public final EObject entryRuleExternalVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalVarDeclaration = null;


        try {
            // InternalPoST.g:4749:63: (iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF )
            // InternalPoST.g:4750:2: iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getExternalVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExternalVarDeclaration=ruleExternalVarDeclaration();

            state._fsp--;

             current =iv_ruleExternalVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalVarDeclaration"


    // $ANTLR start "ruleExternalVarDeclaration"
    // InternalPoST.g:4756:1: ruleExternalVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' ) ;
    public final EObject ruleExternalVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_const_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_vars_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4762:2: ( ( () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' ) )
            // InternalPoST.g:4763:2: ( () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' )
            {
            // InternalPoST.g:4763:2: ( () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' )
            // InternalPoST.g:4764:3: () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR'
            {
            // InternalPoST.g:4764:3: ()
            // InternalPoST.g:4765:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExternalVarDeclarationAccess().getExternalVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,100,FOLLOW_81); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalVarDeclarationAccess().getVAR_EXTERNALKeyword_1());
            		
            // InternalPoST.g:4775:3: ( (lv_const_2_0= 'CONSTANT' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==98) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalPoST.g:4776:4: (lv_const_2_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4776:4: (lv_const_2_0= 'CONSTANT' )
                    // InternalPoST.g:4777:5: lv_const_2_0= 'CONSTANT'
                    {
                    lv_const_2_0=(Token)match(input,98,FOLLOW_80); 

                    					newLeafNode(lv_const_2_0, grammarAccess.getExternalVarDeclarationAccess().getConstCONSTANTKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getExternalVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_2_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:4789:3: ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalPoST.g:4790:4: ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';'
            	    {
            	    // InternalPoST.g:4790:4: ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) )
            	    // InternalPoST.g:4791:5: (lv_vars_3_0= ruleExternalVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4791:5: (lv_vars_3_0= ruleExternalVarInitDeclaration )
            	    // InternalPoST.g:4792:6: lv_vars_3_0= ruleExternalVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getExternalVarDeclarationAccess().getVarsExternalVarInitDeclarationParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_3_0=ruleExternalVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExternalVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_3_0,
            	    							"su.nsk.iae.post.PoST.ExternalVarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_4=(Token)match(input,43,FOLLOW_80); 

            	    				newLeafNode(otherlv_4, grammarAccess.getExternalVarDeclarationAccess().getSemicolonKeyword_3_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            otherlv_5=(Token)match(input,94,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getExternalVarDeclarationAccess().getEND_VARKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalVarDeclaration"


    // $ANTLR start "entryRuleGlobalVarInitDeclaration"
    // InternalPoST.g:4822:1: entryRuleGlobalVarInitDeclaration returns [EObject current=null] : iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF ;
    public final EObject entryRuleGlobalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVarInitDeclaration = null;


        try {
            // InternalPoST.g:4822:65: (iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF )
            // InternalPoST.g:4823:2: iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF
            {
             newCompositeNode(grammarAccess.getGlobalVarInitDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGlobalVarInitDeclaration=ruleGlobalVarInitDeclaration();

            state._fsp--;

             current =iv_ruleGlobalVarInitDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalVarInitDeclaration"


    // $ANTLR start "ruleGlobalVarInitDeclaration"
    // InternalPoST.g:4829:1: ruleGlobalVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleGlobalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_location_2_0=null;
        Token otherlv_3=null;
        EObject lv_varList_0_0 = null;

        AntlrDatatypeRuleToken lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4835:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:4836:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:4836:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) )
            // InternalPoST.g:4837:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) )
            {
            // InternalPoST.g:4837:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:4838:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:4838:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:4839:5: lv_varList_0_0= ruleVarList
            {

            					newCompositeNode(grammarAccess.getGlobalVarInitDeclarationAccess().getVarListVarListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_83);
            lv_varList_0_0=ruleVarList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGlobalVarInitDeclarationRule());
            					}
            					set(
            						current,
            						"varList",
            						lv_varList_0_0,
            						"su.nsk.iae.post.PoST.VarList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,101,FOLLOW_84); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalVarInitDeclarationAccess().getATKeyword_1());
            		
            // InternalPoST.g:4860:3: ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) )
            // InternalPoST.g:4861:4: (lv_location_2_0= RULE_DIRECT_VARIABLE )
            {
            // InternalPoST.g:4861:4: (lv_location_2_0= RULE_DIRECT_VARIABLE )
            // InternalPoST.g:4862:5: lv_location_2_0= RULE_DIRECT_VARIABLE
            {
            lv_location_2_0=(Token)match(input,RULE_DIRECT_VARIABLE,FOLLOW_20); 

            					newLeafNode(lv_location_2_0, grammarAccess.getGlobalVarInitDeclarationAccess().getLocationDIRECT_VARIABLETerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGlobalVarInitDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"location",
            						lv_location_2_0,
            						"su.nsk.iae.post.PoST.DIRECT_VARIABLE");
            				

            }


            }

            otherlv_3=(Token)match(input,51,FOLLOW_82); 

            			newLeafNode(otherlv_3, grammarAccess.getGlobalVarInitDeclarationAccess().getColonKeyword_3());
            		
            // InternalPoST.g:4882:3: ( (lv_type_4_0= ruleDataTypeName ) )
            // InternalPoST.g:4883:4: (lv_type_4_0= ruleDataTypeName )
            {
            // InternalPoST.g:4883:4: (lv_type_4_0= ruleDataTypeName )
            // InternalPoST.g:4884:5: lv_type_4_0= ruleDataTypeName
            {

            					newCompositeNode(grammarAccess.getGlobalVarInitDeclarationAccess().getTypeDataTypeNameParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_4_0=ruleDataTypeName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGlobalVarInitDeclarationRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"su.nsk.iae.post.PoST.DataTypeName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalVarInitDeclaration"


    // $ANTLR start "entryRuleGlobalVarDeclaration"
    // InternalPoST.g:4905:1: entryRuleGlobalVarDeclaration returns [EObject current=null] : iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF ;
    public final EObject entryRuleGlobalVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVarDeclaration = null;


        try {
            // InternalPoST.g:4905:61: (iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF )
            // InternalPoST.g:4906:2: iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getGlobalVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGlobalVarDeclaration=ruleGlobalVarDeclaration();

            state._fsp--;

             current =iv_ruleGlobalVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalVarDeclaration"


    // $ANTLR start "ruleGlobalVarDeclaration"
    // InternalPoST.g:4912:1: ruleGlobalVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR' ) ;
    public final EObject ruleGlobalVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_const_2_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_varsSimple_3_0 = null;

        EObject lv_varsAs_5_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4918:2: ( ( () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR' ) )
            // InternalPoST.g:4919:2: ( () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR' )
            {
            // InternalPoST.g:4919:2: ( () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR' )
            // InternalPoST.g:4920:3: () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR'
            {
            // InternalPoST.g:4920:3: ()
            // InternalPoST.g:4921:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGlobalVarDeclarationAccess().getGlobalVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,102,FOLLOW_81); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalVarDeclarationAccess().getVAR_GLOBALKeyword_1());
            		
            // InternalPoST.g:4931:3: ( (lv_const_2_0= 'CONSTANT' ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==98) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalPoST.g:4932:4: (lv_const_2_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4932:4: (lv_const_2_0= 'CONSTANT' )
                    // InternalPoST.g:4933:5: lv_const_2_0= 'CONSTANT'
                    {
                    lv_const_2_0=(Token)match(input,98,FOLLOW_80); 

                    					newLeafNode(lv_const_2_0, grammarAccess.getGlobalVarDeclarationAccess().getConstCONSTANTKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGlobalVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_2_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:4945:3: ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )*
            loop66:
            do {
                int alt66=3;
                alt66 = dfa66.predict(input);
                switch (alt66) {
            	case 1 :
            	    // InternalPoST.g:4946:4: ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )
            	    {
            	    // InternalPoST.g:4946:4: ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )
            	    // InternalPoST.g:4947:5: ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';'
            	    {
            	    // InternalPoST.g:4947:5: ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4948:6: (lv_varsSimple_3_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4948:6: (lv_varsSimple_3_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4949:7: lv_varsSimple_3_0= ruleVarInitDeclaration
            	    {

            	    							newCompositeNode(grammarAccess.getGlobalVarDeclarationAccess().getVarsSimpleVarInitDeclarationParserRuleCall_3_0_0_0());
            	    						
            	    pushFollow(FOLLOW_9);
            	    lv_varsSimple_3_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getGlobalVarDeclarationRule());
            	    							}
            	    							add(
            	    								current,
            	    								"varsSimple",
            	    								lv_varsSimple_3_0,
            	    								"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    otherlv_4=(Token)match(input,43,FOLLOW_80); 

            	    					newLeafNode(otherlv_4, grammarAccess.getGlobalVarDeclarationAccess().getSemicolonKeyword_3_0_1());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:4972:4: ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' )
            	    {
            	    // InternalPoST.g:4972:4: ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' )
            	    // InternalPoST.g:4973:5: ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';'
            	    {
            	    // InternalPoST.g:4973:5: ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) )
            	    // InternalPoST.g:4974:6: (lv_varsAs_5_0= ruleGlobalVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4974:6: (lv_varsAs_5_0= ruleGlobalVarInitDeclaration )
            	    // InternalPoST.g:4975:7: lv_varsAs_5_0= ruleGlobalVarInitDeclaration
            	    {

            	    							newCompositeNode(grammarAccess.getGlobalVarDeclarationAccess().getVarsAsGlobalVarInitDeclarationParserRuleCall_3_1_0_0());
            	    						
            	    pushFollow(FOLLOW_9);
            	    lv_varsAs_5_0=ruleGlobalVarInitDeclaration();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getGlobalVarDeclarationRule());
            	    							}
            	    							add(
            	    								current,
            	    								"varsAs",
            	    								lv_varsAs_5_0,
            	    								"su.nsk.iae.post.PoST.GlobalVarInitDeclaration");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    otherlv_6=(Token)match(input,43,FOLLOW_80); 

            	    					newLeafNode(otherlv_6, grammarAccess.getGlobalVarDeclarationAccess().getSemicolonKeyword_3_1_1());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            otherlv_7=(Token)match(input,94,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getGlobalVarDeclarationAccess().getEND_VARKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalVarDeclaration"


    // $ANTLR start "entryRuleProcessVariable"
    // InternalPoST.g:5006:1: entryRuleProcessVariable returns [EObject current=null] : iv_ruleProcessVariable= ruleProcessVariable EOF ;
    public final EObject entryRuleProcessVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVariable = null;


        try {
            // InternalPoST.g:5006:56: (iv_ruleProcessVariable= ruleProcessVariable EOF )
            // InternalPoST.g:5007:2: iv_ruleProcessVariable= ruleProcessVariable EOF
            {
             newCompositeNode(grammarAccess.getProcessVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessVariable=ruleProcessVariable();

            state._fsp--;

             current =iv_ruleProcessVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessVariable"


    // $ANTLR start "ruleProcessVariable"
    // InternalPoST.g:5013:1: ruleProcessVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleProcessVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5019:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPoST.g:5020:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPoST.g:5020:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPoST.g:5021:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPoST.g:5021:3: (lv_name_0_0= RULE_ID )
            // InternalPoST.g:5022:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getProcessVariableAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getProcessVariableRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"su.nsk.iae.post.PoST.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessVariable"


    // $ANTLR start "entryRuleProcessVarList"
    // InternalPoST.g:5041:1: entryRuleProcessVarList returns [EObject current=null] : iv_ruleProcessVarList= ruleProcessVarList EOF ;
    public final EObject entryRuleProcessVarList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVarList = null;


        try {
            // InternalPoST.g:5041:55: (iv_ruleProcessVarList= ruleProcessVarList EOF )
            // InternalPoST.g:5042:2: iv_ruleProcessVarList= ruleProcessVarList EOF
            {
             newCompositeNode(grammarAccess.getProcessVarListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessVarList=ruleProcessVarList();

            state._fsp--;

             current =iv_ruleProcessVarList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessVarList"


    // $ANTLR start "ruleProcessVarList"
    // InternalPoST.g:5048:1: ruleProcessVarList returns [EObject current=null] : ( ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )* ) ;
    public final EObject ruleProcessVarList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_vars_0_0 = null;

        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5054:2: ( ( ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )* ) )
            // InternalPoST.g:5055:2: ( ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )* )
            {
            // InternalPoST.g:5055:2: ( ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )* )
            // InternalPoST.g:5056:3: ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )*
            {
            // InternalPoST.g:5056:3: ( (lv_vars_0_0= ruleProcessVariable ) )
            // InternalPoST.g:5057:4: (lv_vars_0_0= ruleProcessVariable )
            {
            // InternalPoST.g:5057:4: (lv_vars_0_0= ruleProcessVariable )
            // InternalPoST.g:5058:5: lv_vars_0_0= ruleProcessVariable
            {

            					newCompositeNode(grammarAccess.getProcessVarListAccess().getVarsProcessVariableParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_vars_0_0=ruleProcessVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProcessVarListRule());
            					}
            					add(
            						current,
            						"vars",
            						lv_vars_0_0,
            						"su.nsk.iae.post.PoST.ProcessVariable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:5075:3: (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==48) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalPoST.g:5076:4: otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getProcessVarListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:5080:4: ( (lv_vars_2_0= ruleProcessVariable ) )
            	    // InternalPoST.g:5081:5: (lv_vars_2_0= ruleProcessVariable )
            	    {
            	    // InternalPoST.g:5081:5: (lv_vars_2_0= ruleProcessVariable )
            	    // InternalPoST.g:5082:6: lv_vars_2_0= ruleProcessVariable
            	    {

            	    						newCompositeNode(grammarAccess.getProcessVarListAccess().getVarsProcessVariableParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_vars_2_0=ruleProcessVariable();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessVarListRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"su.nsk.iae.post.PoST.ProcessVariable");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessVarList"


    // $ANTLR start "entryRuleProcessVarInitDeclaration"
    // InternalPoST.g:5104:1: entryRuleProcessVarInitDeclaration returns [EObject current=null] : iv_ruleProcessVarInitDeclaration= ruleProcessVarInitDeclaration EOF ;
    public final EObject entryRuleProcessVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVarInitDeclaration = null;


        try {
            // InternalPoST.g:5104:66: (iv_ruleProcessVarInitDeclaration= ruleProcessVarInitDeclaration EOF )
            // InternalPoST.g:5105:2: iv_ruleProcessVarInitDeclaration= ruleProcessVarInitDeclaration EOF
            {
             newCompositeNode(grammarAccess.getProcessVarInitDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessVarInitDeclaration=ruleProcessVarInitDeclaration();

            state._fsp--;

             current =iv_ruleProcessVarInitDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessVarInitDeclaration"


    // $ANTLR start "ruleProcessVarInitDeclaration"
    // InternalPoST.g:5111:1: ruleProcessVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleProcessVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_varList_0_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5117:2: ( ( ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalPoST.g:5118:2: ( ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalPoST.g:5118:2: ( ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalPoST.g:5119:3: ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalPoST.g:5119:3: ( (lv_varList_0_0= ruleProcessVarList ) )
            // InternalPoST.g:5120:4: (lv_varList_0_0= ruleProcessVarList )
            {
            // InternalPoST.g:5120:4: (lv_varList_0_0= ruleProcessVarList )
            // InternalPoST.g:5121:5: lv_varList_0_0= ruleProcessVarList
            {

            					newCompositeNode(grammarAccess.getProcessVarInitDeclarationAccess().getVarListProcessVarListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
            lv_varList_0_0=ruleProcessVarList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProcessVarInitDeclarationRule());
            					}
            					set(
            						current,
            						"varList",
            						lv_varList_0_0,
            						"su.nsk.iae.post.PoST.ProcessVarList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,51,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getProcessVarInitDeclarationAccess().getColonKeyword_1());
            		
            // InternalPoST.g:5142:3: ( (otherlv_2= RULE_ID ) )
            // InternalPoST.g:5143:4: (otherlv_2= RULE_ID )
            {
            // InternalPoST.g:5143:4: (otherlv_2= RULE_ID )
            // InternalPoST.g:5144:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessVarInitDeclarationRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getProcessVarInitDeclarationAccess().getProcessProcessCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessVarInitDeclaration"


    // $ANTLR start "entryRuleProcessVarDeclaration"
    // InternalPoST.g:5159:1: entryRuleProcessVarDeclaration returns [EObject current=null] : iv_ruleProcessVarDeclaration= ruleProcessVarDeclaration EOF ;
    public final EObject entryRuleProcessVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVarDeclaration = null;


        try {
            // InternalPoST.g:5159:62: (iv_ruleProcessVarDeclaration= ruleProcessVarDeclaration EOF )
            // InternalPoST.g:5160:2: iv_ruleProcessVarDeclaration= ruleProcessVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getProcessVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessVarDeclaration=ruleProcessVarDeclaration();

            state._fsp--;

             current =iv_ruleProcessVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessVarDeclaration"


    // $ANTLR start "ruleProcessVarDeclaration"
    // InternalPoST.g:5166:1: ruleProcessVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleProcessVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5172:2: ( ( () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:5173:2: ( () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:5173:2: ( () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:5174:3: () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:5174:3: ()
            // InternalPoST.g:5175:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProcessVarDeclarationAccess().getProcessVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,103,FOLLOW_80); 

            			newLeafNode(otherlv_1, grammarAccess.getProcessVarDeclarationAccess().getVAR_PROCESSKeyword_1());
            		
            // InternalPoST.g:5185:3: ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_ID) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalPoST.g:5186:4: ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:5186:4: ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) )
            	    // InternalPoST.g:5187:5: (lv_vars_2_0= ruleProcessVarInitDeclaration )
            	    {
            	    // InternalPoST.g:5187:5: (lv_vars_2_0= ruleProcessVarInitDeclaration )
            	    // InternalPoST.g:5188:6: lv_vars_2_0= ruleProcessVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessVarDeclarationAccess().getVarsProcessVarInitDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_2_0=ruleProcessVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"su.nsk.iae.post.PoST.ProcessVarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,43,FOLLOW_80); 

            	    				newLeafNode(otherlv_3, grammarAccess.getProcessVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);

            otherlv_4=(Token)match(input,94,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getProcessVarDeclarationAccess().getEND_VARKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessVarDeclaration"


    // $ANTLR start "entryRuleArrayVariable"
    // InternalPoST.g:5218:1: entryRuleArrayVariable returns [EObject current=null] : iv_ruleArrayVariable= ruleArrayVariable EOF ;
    public final EObject entryRuleArrayVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayVariable = null;


        try {
            // InternalPoST.g:5218:54: (iv_ruleArrayVariable= ruleArrayVariable EOF )
            // InternalPoST.g:5219:2: iv_ruleArrayVariable= ruleArrayVariable EOF
            {
             newCompositeNode(grammarAccess.getArrayVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayVariable=ruleArrayVariable();

            state._fsp--;

             current =iv_ruleArrayVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayVariable"


    // $ANTLR start "ruleArrayVariable"
    // InternalPoST.g:5225:1: ruleArrayVariable returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) ;
    public final EObject ruleArrayVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_index_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5231:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) )
            // InternalPoST.g:5232:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
            {
            // InternalPoST.g:5232:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
            // InternalPoST.g:5233:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']'
            {
            // InternalPoST.g:5233:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:5234:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:5234:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:5235:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArrayVariableRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_85); 

            					newLeafNode(otherlv_0, grammarAccess.getArrayVariableAccess().getVariableSymbolicVariableCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,104,FOLLOW_48); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayVariableAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalPoST.g:5250:3: ( (lv_index_2_0= ruleExpression ) )
            // InternalPoST.g:5251:4: (lv_index_2_0= ruleExpression )
            {
            // InternalPoST.g:5251:4: (lv_index_2_0= ruleExpression )
            // InternalPoST.g:5252:5: lv_index_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getArrayVariableAccess().getIndexExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_86);
            lv_index_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArrayVariableRule());
            					}
            					set(
            						current,
            						"index",
            						lv_index_2_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,105,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getArrayVariableAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayVariable"


    // $ANTLR start "entryRuleArraySpecificationInit"
    // InternalPoST.g:5277:1: entryRuleArraySpecificationInit returns [EObject current=null] : iv_ruleArraySpecificationInit= ruleArraySpecificationInit EOF ;
    public final EObject entryRuleArraySpecificationInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecificationInit = null;


        try {
            // InternalPoST.g:5277:63: (iv_ruleArraySpecificationInit= ruleArraySpecificationInit EOF )
            // InternalPoST.g:5278:2: iv_ruleArraySpecificationInit= ruleArraySpecificationInit EOF
            {
             newCompositeNode(grammarAccess.getArraySpecificationInitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArraySpecificationInit=ruleArraySpecificationInit();

            state._fsp--;

             current =iv_ruleArraySpecificationInit; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArraySpecificationInit"


    // $ANTLR start "ruleArraySpecificationInit"
    // InternalPoST.g:5284:1: ruleArraySpecificationInit returns [EObject current=null] : ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? ) ;
    public final EObject ruleArraySpecificationInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_init_0_0 = null;

        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5290:2: ( ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? ) )
            // InternalPoST.g:5291:2: ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? )
            {
            // InternalPoST.g:5291:2: ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? )
            // InternalPoST.g:5292:3: ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )?
            {
            // InternalPoST.g:5292:3: ( (lv_init_0_0= ruleArraySpecification ) )
            // InternalPoST.g:5293:4: (lv_init_0_0= ruleArraySpecification )
            {
            // InternalPoST.g:5293:4: (lv_init_0_0= ruleArraySpecification )
            // InternalPoST.g:5294:5: lv_init_0_0= ruleArraySpecification
            {

            					newCompositeNode(grammarAccess.getArraySpecificationInitAccess().getInitArraySpecificationParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_78);
            lv_init_0_0=ruleArraySpecification();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArraySpecificationInitRule());
            					}
            					set(
            						current,
            						"init",
            						lv_init_0_0,
            						"su.nsk.iae.post.PoST.ArraySpecification");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:5311:3: (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==47) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalPoST.g:5312:4: otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) )
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_85); 

                    				newLeafNode(otherlv_1, grammarAccess.getArraySpecificationInitAccess().getColonEqualsSignKeyword_1_0());
                    			
                    // InternalPoST.g:5316:4: ( (lv_values_2_0= ruleArrayInitialization ) )
                    // InternalPoST.g:5317:5: (lv_values_2_0= ruleArrayInitialization )
                    {
                    // InternalPoST.g:5317:5: (lv_values_2_0= ruleArrayInitialization )
                    // InternalPoST.g:5318:6: lv_values_2_0= ruleArrayInitialization
                    {

                    						newCompositeNode(grammarAccess.getArraySpecificationInitAccess().getValuesArrayInitializationParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_values_2_0=ruleArrayInitialization();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArraySpecificationInitRule());
                    						}
                    						set(
                    							current,
                    							"values",
                    							lv_values_2_0,
                    							"su.nsk.iae.post.PoST.ArrayInitialization");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArraySpecificationInit"


    // $ANTLR start "entryRuleArraySpecification"
    // InternalPoST.g:5340:1: entryRuleArraySpecification returns [EObject current=null] : iv_ruleArraySpecification= ruleArraySpecification EOF ;
    public final EObject entryRuleArraySpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecification = null;


        try {
            // InternalPoST.g:5340:59: (iv_ruleArraySpecification= ruleArraySpecification EOF )
            // InternalPoST.g:5341:2: iv_ruleArraySpecification= ruleArraySpecification EOF
            {
             newCompositeNode(grammarAccess.getArraySpecificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArraySpecification=ruleArraySpecification();

            state._fsp--;

             current =iv_ruleArraySpecification; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArraySpecification"


    // $ANTLR start "ruleArraySpecification"
    // InternalPoST.g:5347:1: ruleArraySpecification returns [EObject current=null] : (otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleArraySpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_interval_2_0 = null;

        AntlrDatatypeRuleToken lv_type_6_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5353:2: ( (otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:5354:2: (otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:5354:2: (otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) ) )
            // InternalPoST.g:5355:3: otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) )
            {
            otherlv_0=(Token)match(input,106,FOLLOW_85); 

            			newLeafNode(otherlv_0, grammarAccess.getArraySpecificationAccess().getARRAYKeyword_0());
            		
            otherlv_1=(Token)match(input,104,FOLLOW_87); 

            			newLeafNode(otherlv_1, grammarAccess.getArraySpecificationAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalPoST.g:5363:3: ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID||LA70_0==RULE_INTEGER||LA70_0==RULE_TIME_PREF_LITERAL||(LA70_0>=RULE_REAL_TYPE_NAME && LA70_0<=RULE_REAL)||LA70_0==45||LA70_0==52||LA70_0==110||LA70_0==121) ) {
                alt70=1;
            }
            else if ( (LA70_0==107) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalPoST.g:5364:4: ( (lv_interval_2_0= ruleArrayInterval ) )
                    {
                    // InternalPoST.g:5364:4: ( (lv_interval_2_0= ruleArrayInterval ) )
                    // InternalPoST.g:5365:5: (lv_interval_2_0= ruleArrayInterval )
                    {
                    // InternalPoST.g:5365:5: (lv_interval_2_0= ruleArrayInterval )
                    // InternalPoST.g:5366:6: lv_interval_2_0= ruleArrayInterval
                    {

                    						newCompositeNode(grammarAccess.getArraySpecificationAccess().getIntervalArrayIntervalParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_86);
                    lv_interval_2_0=ruleArrayInterval();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArraySpecificationRule());
                    						}
                    						set(
                    							current,
                    							"interval",
                    							lv_interval_2_0,
                    							"su.nsk.iae.post.PoST.ArrayInterval");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5384:4: otherlv_3= '*'
                    {
                    otherlv_3=(Token)match(input,107,FOLLOW_86); 

                    				newLeafNode(otherlv_3, grammarAccess.getArraySpecificationAccess().getAsteriskKeyword_2_1());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,105,FOLLOW_62); 

            			newLeafNode(otherlv_4, grammarAccess.getArraySpecificationAccess().getRightSquareBracketKeyword_3());
            		
            otherlv_5=(Token)match(input,79,FOLLOW_82); 

            			newLeafNode(otherlv_5, grammarAccess.getArraySpecificationAccess().getOFKeyword_4());
            		
            // InternalPoST.g:5397:3: ( (lv_type_6_0= ruleDataTypeName ) )
            // InternalPoST.g:5398:4: (lv_type_6_0= ruleDataTypeName )
            {
            // InternalPoST.g:5398:4: (lv_type_6_0= ruleDataTypeName )
            // InternalPoST.g:5399:5: lv_type_6_0= ruleDataTypeName
            {

            					newCompositeNode(grammarAccess.getArraySpecificationAccess().getTypeDataTypeNameParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_6_0=ruleDataTypeName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArraySpecificationRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"su.nsk.iae.post.PoST.DataTypeName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArraySpecification"


    // $ANTLR start "entryRuleArrayInterval"
    // InternalPoST.g:5420:1: entryRuleArrayInterval returns [EObject current=null] : iv_ruleArrayInterval= ruleArrayInterval EOF ;
    public final EObject entryRuleArrayInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayInterval = null;


        try {
            // InternalPoST.g:5420:54: (iv_ruleArrayInterval= ruleArrayInterval EOF )
            // InternalPoST.g:5421:2: iv_ruleArrayInterval= ruleArrayInterval EOF
            {
             newCompositeNode(grammarAccess.getArrayIntervalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayInterval=ruleArrayInterval();

            state._fsp--;

             current =iv_ruleArrayInterval; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayInterval"


    // $ANTLR start "ruleArrayInterval"
    // InternalPoST.g:5427:1: ruleArrayInterval returns [EObject current=null] : ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) ) ) ;
    public final EObject ruleArrayInterval() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_start_0_0 = null;

        EObject lv_end_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5433:2: ( ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) ) ) )
            // InternalPoST.g:5434:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) ) )
            {
            // InternalPoST.g:5434:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) ) )
            // InternalPoST.g:5435:3: ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) )
            {
            // InternalPoST.g:5435:3: ( (lv_start_0_0= ruleExpression ) )
            // InternalPoST.g:5436:4: (lv_start_0_0= ruleExpression )
            {
            // InternalPoST.g:5436:4: (lv_start_0_0= ruleExpression )
            // InternalPoST.g:5437:5: lv_start_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getArrayIntervalAccess().getStartExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_88);
            lv_start_0_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArrayIntervalRule());
            					}
            					set(
            						current,
            						"start",
            						lv_start_0_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,108,FOLLOW_48); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayIntervalAccess().getFullStopFullStopKeyword_1());
            		
            // InternalPoST.g:5458:3: ( (lv_end_2_0= ruleExpression ) )
            // InternalPoST.g:5459:4: (lv_end_2_0= ruleExpression )
            {
            // InternalPoST.g:5459:4: (lv_end_2_0= ruleExpression )
            // InternalPoST.g:5460:5: lv_end_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getArrayIntervalAccess().getEndExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_end_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArrayIntervalRule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_2_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayInterval"


    // $ANTLR start "entryRuleArrayInitialization"
    // InternalPoST.g:5481:1: entryRuleArrayInitialization returns [EObject current=null] : iv_ruleArrayInitialization= ruleArrayInitialization EOF ;
    public final EObject entryRuleArrayInitialization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayInitialization = null;


        try {
            // InternalPoST.g:5481:60: (iv_ruleArrayInitialization= ruleArrayInitialization EOF )
            // InternalPoST.g:5482:2: iv_ruleArrayInitialization= ruleArrayInitialization EOF
            {
             newCompositeNode(grammarAccess.getArrayInitializationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayInitialization=ruleArrayInitialization();

            state._fsp--;

             current =iv_ruleArrayInitialization; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayInitialization"


    // $ANTLR start "ruleArrayInitialization"
    // InternalPoST.g:5488:1: ruleArrayInitialization returns [EObject current=null] : (otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleArrayInitialization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5494:2: ( (otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']' ) )
            // InternalPoST.g:5495:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']' )
            {
            // InternalPoST.g:5495:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']' )
            // InternalPoST.g:5496:3: otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,104,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getArrayInitializationAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalPoST.g:5500:3: ( (lv_elements_1_0= ruleExpression ) )
            // InternalPoST.g:5501:4: (lv_elements_1_0= ruleExpression )
            {
            // InternalPoST.g:5501:4: (lv_elements_1_0= ruleExpression )
            // InternalPoST.g:5502:5: lv_elements_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getArrayInitializationAccess().getElementsExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_89);
            lv_elements_1_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArrayInitializationRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_1_0,
            						"su.nsk.iae.post.PoST.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:5519:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==48) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalPoST.g:5520:4: otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,48,FOLLOW_48); 

            	    				newLeafNode(otherlv_2, grammarAccess.getArrayInitializationAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalPoST.g:5524:4: ( (lv_elements_3_0= ruleExpression ) )
            	    // InternalPoST.g:5525:5: (lv_elements_3_0= ruleExpression )
            	    {
            	    // InternalPoST.g:5525:5: (lv_elements_3_0= ruleExpression )
            	    // InternalPoST.g:5526:6: lv_elements_3_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getArrayInitializationAccess().getElementsExpressionParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_89);
            	    lv_elements_3_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getArrayInitializationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_3_0,
            	    							"su.nsk.iae.post.PoST.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            otherlv_4=(Token)match(input,105,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getArrayInitializationAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayInitialization"


    // $ANTLR start "entryRuleTimeLiteral"
    // InternalPoST.g:5552:1: entryRuleTimeLiteral returns [EObject current=null] : iv_ruleTimeLiteral= ruleTimeLiteral EOF ;
    public final EObject entryRuleTimeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeLiteral = null;


        try {
            // InternalPoST.g:5552:52: (iv_ruleTimeLiteral= ruleTimeLiteral EOF )
            // InternalPoST.g:5553:2: iv_ruleTimeLiteral= ruleTimeLiteral EOF
            {
             newCompositeNode(grammarAccess.getTimeLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeLiteral=ruleTimeLiteral();

            state._fsp--;

             current =iv_ruleTimeLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeLiteral"


    // $ANTLR start "ruleTimeLiteral"
    // InternalPoST.g:5559:1: ruleTimeLiteral returns [EObject current=null] : (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) ) ;
    public final EObject ruleTimeLiteral() throws RecognitionException {
        EObject current = null;

        Token this_TIME_PREF_LITERAL_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_interval_3_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5565:2: ( (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) ) )
            // InternalPoST.g:5566:2: (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) )
            {
            // InternalPoST.g:5566:2: (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) )
            // InternalPoST.g:5567:3: this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) )
            {
            this_TIME_PREF_LITERAL_0=(Token)match(input,RULE_TIME_PREF_LITERAL,FOLLOW_90); 

            			newLeafNode(this_TIME_PREF_LITERAL_0, grammarAccess.getTimeLiteralAccess().getTIME_PREF_LITERALTerminalRuleCall_0());
            		
            otherlv_1=(Token)match(input,109,FOLLOW_91); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeLiteralAccess().getNumberSignKeyword_1());
            		
            // InternalPoST.g:5575:3: (otherlv_2= '-' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==110) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalPoST.g:5576:4: otherlv_2= '-'
                    {
                    otherlv_2=(Token)match(input,110,FOLLOW_92); 

                    				newLeafNode(otherlv_2, grammarAccess.getTimeLiteralAccess().getHyphenMinusKeyword_2());
                    			

                    }
                    break;

            }

            // InternalPoST.g:5581:3: ( (lv_interval_3_0= RULE_INTERVAL ) )
            // InternalPoST.g:5582:4: (lv_interval_3_0= RULE_INTERVAL )
            {
            // InternalPoST.g:5582:4: (lv_interval_3_0= RULE_INTERVAL )
            // InternalPoST.g:5583:5: lv_interval_3_0= RULE_INTERVAL
            {
            lv_interval_3_0=(Token)match(input,RULE_INTERVAL,FOLLOW_2); 

            					newLeafNode(lv_interval_3_0, grammarAccess.getTimeLiteralAccess().getIntervalINTERVALTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeLiteralRule());
            					}
            					setWithLastConsumed(
            						current,
            						"interval",
            						lv_interval_3_0,
            						"su.nsk.iae.post.PoST.INTERVAL");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeLiteral"


    // $ANTLR start "entryRuleDataTypeName"
    // InternalPoST.g:5603:1: entryRuleDataTypeName returns [String current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final String entryRuleDataTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeName = null;


        try {
            // InternalPoST.g:5603:52: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // InternalPoST.g:5604:2: iv_ruleDataTypeName= ruleDataTypeName EOF
            {
             newCompositeNode(grammarAccess.getDataTypeNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeName=ruleDataTypeName();

            state._fsp--;

             current =iv_ruleDataTypeName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataTypeName"


    // $ANTLR start "ruleDataTypeName"
    // InternalPoST.g:5610:1: ruleDataTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BIT_STRING_TYPE_NAME_1=null;
        Token this_TIME_TYPE_NAME_2=null;
        Token this_STRING_TYPE_NAME_3=null;
        AntlrDatatypeRuleToken this_NumericTypeName_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5616:2: ( (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME ) )
            // InternalPoST.g:5617:2: (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME )
            {
            // InternalPoST.g:5617:2: (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME )
            int alt73=4;
            switch ( input.LA(1) ) {
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
                {
                alt73=1;
                }
                break;
            case RULE_BIT_STRING_TYPE_NAME:
                {
                alt73=2;
                }
                break;
            case RULE_TIME_TYPE_NAME:
                {
                alt73=3;
                }
                break;
            case RULE_STRING_TYPE_NAME:
                {
                alt73=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // InternalPoST.g:5618:3: this_NumericTypeName_0= ruleNumericTypeName
                    {

                    			newCompositeNode(grammarAccess.getDataTypeNameAccess().getNumericTypeNameParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericTypeName_0=ruleNumericTypeName();

                    state._fsp--;


                    			current.merge(this_NumericTypeName_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:5629:3: this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME
                    {
                    this_BIT_STRING_TYPE_NAME_1=(Token)match(input,RULE_BIT_STRING_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_BIT_STRING_TYPE_NAME_1);
                    		

                    			newLeafNode(this_BIT_STRING_TYPE_NAME_1, grammarAccess.getDataTypeNameAccess().getBIT_STRING_TYPE_NAMETerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPoST.g:5637:3: this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME
                    {
                    this_TIME_TYPE_NAME_2=(Token)match(input,RULE_TIME_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_TIME_TYPE_NAME_2);
                    		

                    			newLeafNode(this_TIME_TYPE_NAME_2, grammarAccess.getDataTypeNameAccess().getTIME_TYPE_NAMETerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPoST.g:5645:3: this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME
                    {
                    this_STRING_TYPE_NAME_3=(Token)match(input,RULE_STRING_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_STRING_TYPE_NAME_3);
                    		

                    			newLeafNode(this_STRING_TYPE_NAME_3, grammarAccess.getDataTypeNameAccess().getSTRING_TYPE_NAMETerminalRuleCall_3());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataTypeName"


    // $ANTLR start "entryRuleNumericTypeName"
    // InternalPoST.g:5656:1: entryRuleNumericTypeName returns [String current=null] : iv_ruleNumericTypeName= ruleNumericTypeName EOF ;
    public final String entryRuleNumericTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumericTypeName = null;


        try {
            // InternalPoST.g:5656:55: (iv_ruleNumericTypeName= ruleNumericTypeName EOF )
            // InternalPoST.g:5657:2: iv_ruleNumericTypeName= ruleNumericTypeName EOF
            {
             newCompositeNode(grammarAccess.getNumericTypeNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericTypeName=ruleNumericTypeName();

            state._fsp--;

             current =iv_ruleNumericTypeName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericTypeName"


    // $ANTLR start "ruleNumericTypeName"
    // InternalPoST.g:5663:1: ruleNumericTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleNumericTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_TYPE_NAME_1=null;
        AntlrDatatypeRuleToken this_IntegerTypeName_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5669:2: ( (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME ) )
            // InternalPoST.g:5670:2: (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME )
            {
            // InternalPoST.g:5670:2: (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=RULE_SIGNED_INTEGER_TYPE_NAME && LA74_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt74=1;
            }
            else if ( (LA74_0==RULE_REAL_TYPE_NAME) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalPoST.g:5671:3: this_IntegerTypeName_0= ruleIntegerTypeName
                    {

                    			newCompositeNode(grammarAccess.getNumericTypeNameAccess().getIntegerTypeNameParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerTypeName_0=ruleIntegerTypeName();

                    state._fsp--;


                    			current.merge(this_IntegerTypeName_0);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:5682:3: this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME
                    {
                    this_REAL_TYPE_NAME_1=(Token)match(input,RULE_REAL_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_REAL_TYPE_NAME_1);
                    		

                    			newLeafNode(this_REAL_TYPE_NAME_1, grammarAccess.getNumericTypeNameAccess().getREAL_TYPE_NAMETerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericTypeName"


    // $ANTLR start "entryRuleIntegerTypeName"
    // InternalPoST.g:5693:1: entryRuleIntegerTypeName returns [String current=null] : iv_ruleIntegerTypeName= ruleIntegerTypeName EOF ;
    public final String entryRuleIntegerTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerTypeName = null;


        try {
            // InternalPoST.g:5693:55: (iv_ruleIntegerTypeName= ruleIntegerTypeName EOF )
            // InternalPoST.g:5694:2: iv_ruleIntegerTypeName= ruleIntegerTypeName EOF
            {
             newCompositeNode(grammarAccess.getIntegerTypeNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerTypeName=ruleIntegerTypeName();

            state._fsp--;

             current =iv_ruleIntegerTypeName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerTypeName"


    // $ANTLR start "ruleIntegerTypeName"
    // InternalPoST.g:5700:1: ruleIntegerTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleIntegerTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIGNED_INTEGER_TYPE_NAME_0=null;
        Token this_UNSIGNED_INTEGER_TYPE_NAME_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5706:2: ( (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME ) )
            // InternalPoST.g:5707:2: (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME )
            {
            // InternalPoST.g:5707:2: (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_SIGNED_INTEGER_TYPE_NAME) ) {
                alt75=1;
            }
            else if ( (LA75_0==RULE_UNSIGNED_INTEGER_TYPE_NAME) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalPoST.g:5708:3: this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME
                    {
                    this_SIGNED_INTEGER_TYPE_NAME_0=(Token)match(input,RULE_SIGNED_INTEGER_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_SIGNED_INTEGER_TYPE_NAME_0);
                    		

                    			newLeafNode(this_SIGNED_INTEGER_TYPE_NAME_0, grammarAccess.getIntegerTypeNameAccess().getSIGNED_INTEGER_TYPE_NAMETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:5716:3: this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME
                    {
                    this_UNSIGNED_INTEGER_TYPE_NAME_1=(Token)match(input,RULE_UNSIGNED_INTEGER_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_UNSIGNED_INTEGER_TYPE_NAME_1);
                    		

                    			newLeafNode(this_UNSIGNED_INTEGER_TYPE_NAME_1, grammarAccess.getIntegerTypeNameAccess().getUNSIGNED_INTEGER_TYPE_NAMETerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerTypeName"


    // $ANTLR start "entryRuleConstant"
    // InternalPoST.g:5727:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalPoST.g:5727:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalPoST.g:5728:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalPoST.g:5734:1: ruleConstant returns [EObject current=null] : ( ( (lv_num_0_0= ruleNumericLiteral ) ) | ( (lv_time_1_0= ruleTimeLiteral ) ) | ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_oth_2_1=null;
        Token lv_oth_2_2=null;
        Token lv_oth_2_3=null;
        Token lv_oth_2_4=null;
        EObject lv_num_0_0 = null;

        EObject lv_time_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5740:2: ( ( ( (lv_num_0_0= ruleNumericLiteral ) ) | ( (lv_time_1_0= ruleTimeLiteral ) ) | ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) ) ) )
            // InternalPoST.g:5741:2: ( ( (lv_num_0_0= ruleNumericLiteral ) ) | ( (lv_time_1_0= ruleTimeLiteral ) ) | ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) ) )
            {
            // InternalPoST.g:5741:2: ( ( (lv_num_0_0= ruleNumericLiteral ) ) | ( (lv_time_1_0= ruleTimeLiteral ) ) | ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) ) )
            int alt77=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
            case RULE_REAL:
            case 110:
                {
                alt77=1;
                }
                break;
            case RULE_TIME_PREF_LITERAL:
                {
                alt77=2;
                }
                break;
            case RULE_BINARY_INTEGER:
            case RULE_OCTAL_INTEGER:
            case RULE_HEX_INTEGER:
            case RULE_BOOLEAN_LITERAL:
                {
                alt77=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalPoST.g:5742:3: ( (lv_num_0_0= ruleNumericLiteral ) )
                    {
                    // InternalPoST.g:5742:3: ( (lv_num_0_0= ruleNumericLiteral ) )
                    // InternalPoST.g:5743:4: (lv_num_0_0= ruleNumericLiteral )
                    {
                    // InternalPoST.g:5743:4: (lv_num_0_0= ruleNumericLiteral )
                    // InternalPoST.g:5744:5: lv_num_0_0= ruleNumericLiteral
                    {

                    					newCompositeNode(grammarAccess.getConstantAccess().getNumNumericLiteralParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_num_0_0=ruleNumericLiteral();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getConstantRule());
                    					}
                    					set(
                    						current,
                    						"num",
                    						lv_num_0_0,
                    						"su.nsk.iae.post.PoST.NumericLiteral");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5762:3: ( (lv_time_1_0= ruleTimeLiteral ) )
                    {
                    // InternalPoST.g:5762:3: ( (lv_time_1_0= ruleTimeLiteral ) )
                    // InternalPoST.g:5763:4: (lv_time_1_0= ruleTimeLiteral )
                    {
                    // InternalPoST.g:5763:4: (lv_time_1_0= ruleTimeLiteral )
                    // InternalPoST.g:5764:5: lv_time_1_0= ruleTimeLiteral
                    {

                    					newCompositeNode(grammarAccess.getConstantAccess().getTimeTimeLiteralParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_time_1_0=ruleTimeLiteral();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getConstantRule());
                    					}
                    					set(
                    						current,
                    						"time",
                    						lv_time_1_0,
                    						"su.nsk.iae.post.PoST.TimeLiteral");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:5782:3: ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) )
                    {
                    // InternalPoST.g:5782:3: ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) )
                    // InternalPoST.g:5783:4: ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) )
                    {
                    // InternalPoST.g:5783:4: ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) )
                    // InternalPoST.g:5784:5: (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL )
                    {
                    // InternalPoST.g:5784:5: (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL )
                    int alt76=4;
                    switch ( input.LA(1) ) {
                    case RULE_BINARY_INTEGER:
                        {
                        alt76=1;
                        }
                        break;
                    case RULE_OCTAL_INTEGER:
                        {
                        alt76=2;
                        }
                        break;
                    case RULE_HEX_INTEGER:
                        {
                        alt76=3;
                        }
                        break;
                    case RULE_BOOLEAN_LITERAL:
                        {
                        alt76=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 76, 0, input);

                        throw nvae;
                    }

                    switch (alt76) {
                        case 1 :
                            // InternalPoST.g:5785:6: lv_oth_2_1= RULE_BINARY_INTEGER
                            {
                            lv_oth_2_1=(Token)match(input,RULE_BINARY_INTEGER,FOLLOW_2); 

                            						newLeafNode(lv_oth_2_1, grammarAccess.getConstantAccess().getOthBINARY_INTEGERTerminalRuleCall_2_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getConstantRule());
                            						}
                            						setWithLastConsumed(
                            							current,
                            							"oth",
                            							lv_oth_2_1,
                            							"su.nsk.iae.post.PoST.BINARY_INTEGER");
                            					

                            }
                            break;
                        case 2 :
                            // InternalPoST.g:5800:6: lv_oth_2_2= RULE_OCTAL_INTEGER
                            {
                            lv_oth_2_2=(Token)match(input,RULE_OCTAL_INTEGER,FOLLOW_2); 

                            						newLeafNode(lv_oth_2_2, grammarAccess.getConstantAccess().getOthOCTAL_INTEGERTerminalRuleCall_2_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getConstantRule());
                            						}
                            						setWithLastConsumed(
                            							current,
                            							"oth",
                            							lv_oth_2_2,
                            							"su.nsk.iae.post.PoST.OCTAL_INTEGER");
                            					

                            }
                            break;
                        case 3 :
                            // InternalPoST.g:5815:6: lv_oth_2_3= RULE_HEX_INTEGER
                            {
                            lv_oth_2_3=(Token)match(input,RULE_HEX_INTEGER,FOLLOW_2); 

                            						newLeafNode(lv_oth_2_3, grammarAccess.getConstantAccess().getOthHEX_INTEGERTerminalRuleCall_2_0_2());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getConstantRule());
                            						}
                            						setWithLastConsumed(
                            							current,
                            							"oth",
                            							lv_oth_2_3,
                            							"su.nsk.iae.post.PoST.HEX_INTEGER");
                            					

                            }
                            break;
                        case 4 :
                            // InternalPoST.g:5830:6: lv_oth_2_4= RULE_BOOLEAN_LITERAL
                            {
                            lv_oth_2_4=(Token)match(input,RULE_BOOLEAN_LITERAL,FOLLOW_2); 

                            						newLeafNode(lv_oth_2_4, grammarAccess.getConstantAccess().getOthBOOLEAN_LITERALTerminalRuleCall_2_0_3());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getConstantRule());
                            						}
                            						setWithLastConsumed(
                            							current,
                            							"oth",
                            							lv_oth_2_4,
                            							"su.nsk.iae.post.PoST.BOOLEAN_LITERAL");
                            					

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleSignedInteger"
    // InternalPoST.g:5851:1: entryRuleSignedInteger returns [EObject current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final EObject entryRuleSignedInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedInteger = null;


        try {
            // InternalPoST.g:5851:54: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // InternalPoST.g:5852:2: iv_ruleSignedInteger= ruleSignedInteger EOF
            {
             newCompositeNode(grammarAccess.getSignedIntegerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSignedInteger=ruleSignedInteger();

            state._fsp--;

             current =iv_ruleSignedInteger; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedInteger"


    // $ANTLR start "ruleSignedInteger"
    // InternalPoST.g:5858:1: ruleSignedInteger returns [EObject current=null] : ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleSignedInteger() throws RecognitionException {
        EObject current = null;

        Token lv_iSig_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5864:2: ( ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // InternalPoST.g:5865:2: ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // InternalPoST.g:5865:2: ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // InternalPoST.g:5866:3: ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // InternalPoST.g:5866:3: ( (lv_iSig_0_0= '-' ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==110) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalPoST.g:5867:4: (lv_iSig_0_0= '-' )
                    {
                    // InternalPoST.g:5867:4: (lv_iSig_0_0= '-' )
                    // InternalPoST.g:5868:5: lv_iSig_0_0= '-'
                    {
                    lv_iSig_0_0=(Token)match(input,110,FOLLOW_18); 

                    					newLeafNode(lv_iSig_0_0, grammarAccess.getSignedIntegerAccess().getISigHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSignedIntegerRule());
                    					}
                    					setWithLastConsumed(current, "iSig", lv_iSig_0_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:5880:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // InternalPoST.g:5881:4: (lv_value_1_0= RULE_INTEGER )
            {
            // InternalPoST.g:5881:4: (lv_value_1_0= RULE_INTEGER )
            // InternalPoST.g:5882:5: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getSignedIntegerAccess().getValueINTEGERTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSignedIntegerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"su.nsk.iae.post.PoST.INTEGER");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedInteger"


    // $ANTLR start "entryRuleNumericLiteral"
    // InternalPoST.g:5902:1: entryRuleNumericLiteral returns [EObject current=null] : iv_ruleNumericLiteral= ruleNumericLiteral EOF ;
    public final EObject entryRuleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericLiteral = null;


        try {
            // InternalPoST.g:5902:55: (iv_ruleNumericLiteral= ruleNumericLiteral EOF )
            // InternalPoST.g:5903:2: iv_ruleNumericLiteral= ruleNumericLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumericLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericLiteral=ruleNumericLiteral();

            state._fsp--;

             current =iv_ruleNumericLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericLiteral"


    // $ANTLR start "ruleNumericLiteral"
    // InternalPoST.g:5909:1: ruleNumericLiteral returns [EObject current=null] : (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteral_0 = null;

        EObject this_RealLiteral_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:5915:2: ( (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalPoST.g:5916:2: (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalPoST.g:5916:2: (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt79=2;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
                {
                alt79=1;
                }
                break;
            case 110:
                {
                int LA79_2 = input.LA(2);

                if ( (LA79_2==RULE_REAL) ) {
                    alt79=2;
                }
                else if ( (LA79_2==RULE_INTEGER) ) {
                    alt79=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REAL_TYPE_NAME:
            case RULE_REAL:
                {
                alt79=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // InternalPoST.g:5917:3: this_IntegerLiteral_0= ruleIntegerLiteral
                    {

                    			newCompositeNode(grammarAccess.getNumericLiteralAccess().getIntegerLiteralParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerLiteral_0=ruleIntegerLiteral();

                    state._fsp--;


                    			current = this_IntegerLiteral_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:5926:3: this_RealLiteral_1= ruleRealLiteral
                    {

                    			newCompositeNode(grammarAccess.getNumericLiteralAccess().getRealLiteralParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RealLiteral_1=ruleRealLiteral();

                    state._fsp--;


                    			current = this_RealLiteral_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericLiteral"


    // $ANTLR start "entryRuleIntegerLiteral"
    // InternalPoST.g:5938:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // InternalPoST.g:5938:55: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // InternalPoST.g:5939:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntegerLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();

            state._fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerLiteral"


    // $ANTLR start "ruleIntegerLiteral"
    // InternalPoST.g:5945:1: ruleIntegerLiteral returns [EObject current=null] : ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5951:2: ( ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) ) )
            // InternalPoST.g:5952:2: ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) )
            {
            // InternalPoST.g:5952:2: ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) )
            // InternalPoST.g:5953:3: ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) )
            {
            // InternalPoST.g:5953:3: ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=RULE_SIGNED_INTEGER_TYPE_NAME && LA80_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalPoST.g:5954:4: ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#'
                    {
                    // InternalPoST.g:5954:4: ( (lv_type_0_0= ruleIntegerTypeName ) )
                    // InternalPoST.g:5955:5: (lv_type_0_0= ruleIntegerTypeName )
                    {
                    // InternalPoST.g:5955:5: (lv_type_0_0= ruleIntegerTypeName )
                    // InternalPoST.g:5956:6: lv_type_0_0= ruleIntegerTypeName
                    {

                    						newCompositeNode(grammarAccess.getIntegerLiteralAccess().getTypeIntegerTypeNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_90);
                    lv_type_0_0=ruleIntegerTypeName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntegerLiteralRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_0_0,
                    							"su.nsk.iae.post.PoST.IntegerTypeName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,109,FOLLOW_63); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntegerLiteralAccess().getNumberSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalPoST.g:5978:3: ( (lv_value_2_0= ruleSignedInteger ) )
            // InternalPoST.g:5979:4: (lv_value_2_0= ruleSignedInteger )
            {
            // InternalPoST.g:5979:4: (lv_value_2_0= ruleSignedInteger )
            // InternalPoST.g:5980:5: lv_value_2_0= ruleSignedInteger
            {

            					newCompositeNode(grammarAccess.getIntegerLiteralAccess().getValueSignedIntegerParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleSignedInteger();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntegerLiteralRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"su.nsk.iae.post.PoST.SignedInteger");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // InternalPoST.g:6001:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalPoST.g:6001:52: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalPoST.g:6002:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // InternalPoST.g:6008:1: ruleRealLiteral returns [EObject current=null] : ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token otherlv_1=null;
        Token lv_rSig_2_0=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalPoST.g:6014:2: ( ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) ) )
            // InternalPoST.g:6015:2: ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) )
            {
            // InternalPoST.g:6015:2: ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) )
            // InternalPoST.g:6016:3: ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) )
            {
            // InternalPoST.g:6016:3: ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_REAL_TYPE_NAME) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalPoST.g:6017:4: ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#'
                    {
                    // InternalPoST.g:6017:4: ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) )
                    // InternalPoST.g:6018:5: (lv_type_0_0= RULE_REAL_TYPE_NAME )
                    {
                    // InternalPoST.g:6018:5: (lv_type_0_0= RULE_REAL_TYPE_NAME )
                    // InternalPoST.g:6019:6: lv_type_0_0= RULE_REAL_TYPE_NAME
                    {
                    lv_type_0_0=(Token)match(input,RULE_REAL_TYPE_NAME,FOLLOW_90); 

                    						newLeafNode(lv_type_0_0, grammarAccess.getRealLiteralAccess().getTypeREAL_TYPE_NAMETerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRealLiteralRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"type",
                    							lv_type_0_0,
                    							"su.nsk.iae.post.PoST.REAL_TYPE_NAME");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,109,FOLLOW_93); 

                    				newLeafNode(otherlv_1, grammarAccess.getRealLiteralAccess().getNumberSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalPoST.g:6040:3: ( (lv_rSig_2_0= '-' ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==110) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalPoST.g:6041:4: (lv_rSig_2_0= '-' )
                    {
                    // InternalPoST.g:6041:4: (lv_rSig_2_0= '-' )
                    // InternalPoST.g:6042:5: lv_rSig_2_0= '-'
                    {
                    lv_rSig_2_0=(Token)match(input,110,FOLLOW_94); 

                    					newLeafNode(lv_rSig_2_0, grammarAccess.getRealLiteralAccess().getRSigHyphenMinusKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRealLiteralRule());
                    					}
                    					setWithLastConsumed(current, "rSig", lv_rSig_2_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:6054:3: ( (lv_value_3_0= RULE_REAL ) )
            // InternalPoST.g:6055:4: (lv_value_3_0= RULE_REAL )
            {
            // InternalPoST.g:6055:4: (lv_value_3_0= RULE_REAL )
            // InternalPoST.g:6056:5: lv_value_3_0= RULE_REAL
            {
            lv_value_3_0=(Token)match(input,RULE_REAL,FOLLOW_2); 

            					newLeafNode(lv_value_3_0, grammarAccess.getRealLiteralAccess().getValueREALTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRealLiteralRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_3_0,
            						"su.nsk.iae.post.PoST.REAL");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "ruleAssignmentType"
    // InternalPoST.g:6076:1: ruleAssignmentType returns [Enumerator current=null] : ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) ) ;
    public final Enumerator ruleAssignmentType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:6082:2: ( ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) ) )
            // InternalPoST.g:6083:2: ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) )
            {
            // InternalPoST.g:6083:2: ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==47) ) {
                alt83=1;
            }
            else if ( (LA83_0==111) ) {
                alt83=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // InternalPoST.g:6084:3: (enumLiteral_0= ':=' )
                    {
                    // InternalPoST.g:6084:3: (enumLiteral_0= ':=' )
                    // InternalPoST.g:6085:4: enumLiteral_0= ':='
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getAssignmentTypeAccess().getInEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAssignmentTypeAccess().getInEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6092:3: (enumLiteral_1= '=>' )
                    {
                    // InternalPoST.g:6092:3: (enumLiteral_1= '=>' )
                    // InternalPoST.g:6093:4: enumLiteral_1= '=>'
                    {
                    enumLiteral_1=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getAssignmentTypeAccess().getOutEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAssignmentTypeAccess().getOutEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentType"


    // $ANTLR start "ruleCompOperator"
    // InternalPoST.g:6103:1: ruleCompOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) ;
    public final Enumerator ruleCompOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:6109:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) )
            // InternalPoST.g:6110:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            {
            // InternalPoST.g:6110:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==112) ) {
                alt84=1;
            }
            else if ( (LA84_0==113) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalPoST.g:6111:3: (enumLiteral_0= '=' )
                    {
                    // InternalPoST.g:6111:3: (enumLiteral_0= '=' )
                    // InternalPoST.g:6112:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getCompOperatorAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompOperatorAccess().getEQUALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6119:3: (enumLiteral_1= '<>' )
                    {
                    // InternalPoST.g:6119:3: (enumLiteral_1= '<>' )
                    // InternalPoST.g:6120:4: enumLiteral_1= '<>'
                    {
                    enumLiteral_1=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getCompOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCompOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompOperator"


    // $ANTLR start "ruleEquOperator"
    // InternalPoST.g:6130:1: ruleEquOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleEquOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalPoST.g:6136:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) )
            // InternalPoST.g:6137:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalPoST.g:6137:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            int alt85=4;
            switch ( input.LA(1) ) {
            case 114:
                {
                alt85=1;
                }
                break;
            case 115:
                {
                alt85=2;
                }
                break;
            case 116:
                {
                alt85=3;
                }
                break;
            case 117:
                {
                alt85=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalPoST.g:6138:3: (enumLiteral_0= '<' )
                    {
                    // InternalPoST.g:6138:3: (enumLiteral_0= '<' )
                    // InternalPoST.g:6139:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEquOperatorAccess().getLESSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6146:3: (enumLiteral_1= '>' )
                    {
                    // InternalPoST.g:6146:3: (enumLiteral_1= '>' )
                    // InternalPoST.g:6147:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEquOperatorAccess().getGREATEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:6154:3: (enumLiteral_2= '<=' )
                    {
                    // InternalPoST.g:6154:3: (enumLiteral_2= '<=' )
                    // InternalPoST.g:6155:4: enumLiteral_2= '<='
                    {
                    enumLiteral_2=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getLESS_EQUEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getEquOperatorAccess().getLESS_EQUEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalPoST.g:6162:3: (enumLiteral_3= '>=' )
                    {
                    // InternalPoST.g:6162:3: (enumLiteral_3= '>=' )
                    // InternalPoST.g:6163:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getGREATER_EQUEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getEquOperatorAccess().getGREATER_EQUEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquOperator"


    // $ANTLR start "ruleAddOperator"
    // InternalPoST.g:6173:1: ruleAddOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:6179:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalPoST.g:6180:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalPoST.g:6180:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==118) ) {
                alt86=1;
            }
            else if ( (LA86_0==110) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalPoST.g:6181:3: (enumLiteral_0= '+' )
                    {
                    // InternalPoST.g:6181:3: (enumLiteral_0= '+' )
                    // InternalPoST.g:6182:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getAddOperatorAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOperatorAccess().getPLUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6189:3: (enumLiteral_1= '-' )
                    {
                    // InternalPoST.g:6189:3: (enumLiteral_1= '-' )
                    // InternalPoST.g:6190:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getAddOperatorAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAddOperatorAccess().getMINUSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddOperator"


    // $ANTLR start "ruleMulOperator"
    // InternalPoST.g:6200:1: ruleMulOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) ) ;
    public final Enumerator ruleMulOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalPoST.g:6206:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) ) )
            // InternalPoST.g:6207:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) )
            {
            // InternalPoST.g:6207:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) )
            int alt87=3;
            switch ( input.LA(1) ) {
            case 107:
                {
                alt87=1;
                }
                break;
            case 119:
                {
                alt87=2;
                }
                break;
            case 120:
                {
                alt87=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalPoST.g:6208:3: (enumLiteral_0= '*' )
                    {
                    // InternalPoST.g:6208:3: (enumLiteral_0= '*' )
                    // InternalPoST.g:6209:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getMulOperatorAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMulOperatorAccess().getMULEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6216:3: (enumLiteral_1= '/' )
                    {
                    // InternalPoST.g:6216:3: (enumLiteral_1= '/' )
                    // InternalPoST.g:6217:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getMulOperatorAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMulOperatorAccess().getDIVEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:6224:3: (enumLiteral_2= 'MOD' )
                    {
                    // InternalPoST.g:6224:3: (enumLiteral_2= 'MOD' )
                    // InternalPoST.g:6225:4: enumLiteral_2= 'MOD'
                    {
                    enumLiteral_2=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getMulOperatorAccess().getMODEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMulOperatorAccess().getMODEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMulOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalPoST.g:6235:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:6241:2: ( ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) ) )
            // InternalPoST.g:6242:2: ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) )
            {
            // InternalPoST.g:6242:2: ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==121) ) {
                alt88=1;
            }
            else if ( (LA88_0==110) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // InternalPoST.g:6243:3: (enumLiteral_0= 'NOT' )
                    {
                    // InternalPoST.g:6243:3: (enumLiteral_0= 'NOT' )
                    // InternalPoST.g:6244:4: enumLiteral_0= 'NOT'
                    {
                    enumLiteral_0=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getUnaryOperatorAccess().getNOTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getNOTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6251:3: (enumLiteral_1= '-' )
                    {
                    // InternalPoST.g:6251:3: (enumLiteral_1= '-' )
                    // InternalPoST.g:6252:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getUnaryOperatorAccess().getUNMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getUNMINUSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"

    // Delegated rules


    protected DFA66 dfa66 = new DFA66(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\4\1\uffff\1\60\1\4\2\uffff\1\60";
    static final String dfa_3s = "\1\136\1\uffff\1\145\1\4\2\uffff\1\145";
    static final String dfa_4s = "\1\uffff\1\3\2\uffff\1\1\1\2\1\uffff";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\131\uffff\1\1",
            "",
            "\1\3\2\uffff\1\4\61\uffff\1\5",
            "\1\6",
            "",
            "",
            "\1\3\2\uffff\1\4\61\uffff\1\5"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 4945:3: ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0082004000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000018000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0002140000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0002100000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000007F84100L,0x0000400000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0010000000000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000800000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000007F84110L,0x0000400000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0020000000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0050000000000000L,0x0000001BA0000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0110000000000000L,0x0000001BA0000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0110000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0600000000000000L,0x0000008BA0000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x3800000000000010L,0x000000001942453EL});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x3000000000000010L,0x000000001942453EL});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x4400000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x2000000000000010L,0x000000001942459EL});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0010200007F84110L,0x0200400000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0003000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x003C000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0040400000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0180080000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0010200007F84110L,0x0000400000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x2000000000000012L,0x000000001942451EL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x2000000000000010L,0x0000000019427D1EL});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003800L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x2000000000000010L,0x000000001942651EL});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000300100L,0x0000400000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000300100L,0x0000400000011000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x2000000000000010L,0x000000001943451EL});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x2000000000000010L,0x000000001942451EL});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x2000000000000010L,0x00000000194A451EL});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x2000000000000010L,0x0000000019C2451EL});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x2000000000000010L,0x000000001B42451EL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x00000000003F0000L,0x0000040000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000010L,0x0000000040000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000010L,0x0000000440000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0010200007F84110L,0x0200480000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0001000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000008000L,0x0000400000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000004000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000004000000L});

}
