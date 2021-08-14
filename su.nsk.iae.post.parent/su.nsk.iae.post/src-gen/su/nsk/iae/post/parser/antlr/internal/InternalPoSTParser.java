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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SINGLE_DECLARATION", "RULE_INTERVAL_DECLARATION", "RULE_PRIORITY_DECLARATION", "RULE_INTEGER", "RULE_OR_OPERATOR", "RULE_XOR_OPERATOR", "RULE_AND_OPERATOR", "RULE_POWER_OPERATOR", "RULE_DIRECT_VARIABLE", "RULE_TIME_PREF_LITERAL", "RULE_INTERVAL", "RULE_BIT_STRING_TYPE_NAME", "RULE_TIME_TYPE_NAME", "RULE_STRING_TYPE_NAME", "RULE_REAL_TYPE_NAME", "RULE_SIGNED_INTEGER_TYPE_NAME", "RULE_UNSIGNED_INTEGER_TYPE_NAME", "RULE_BINARY_INTEGER", "RULE_OCTAL_INTEGER", "RULE_HEX_INTEGER", "RULE_BOOLEAN_LITERAL", "RULE_REAL", "RULE_DIRECT_TYPE_PREFIX", "RULE_DIRECT_SIZE_PREFIX", "RULE_DIGIT", "RULE_BIT", "RULE_OCTAL_DIGIT", "RULE_HEX_DIGIT", "RULE_LETTER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'CONFIGURATION'", "'END_CONFIGURATION'", "'RESOURCE'", "'ON'", "'END_RESOURCE'", "';'", "'TASK'", "'('", "')'", "':='", "','", "'PROGRAM'", "'WITH'", "':'", "'PROCESS'", "'ACTIVE'", "'END_PROGRAM'", "'FUNCTION_BLOCK'", "'END_FUNCTION_BLOCK'", "'FUNCTION'", "'END_FUNCTION'", "'END_PROCESS'", "'STATE'", "'LOOPED'", "'END_STATE'", "'SET'", "'NEXT'", "'IN'", "'INACTIVE'", "'STOP'", "'ERROR'", "'START'", "'RESTART'", "'TIMEOUT'", "'THEN'", "'END_TIMEOUT'", "'RESET'", "'TIMER'", "'IF'", "'ELSIF'", "'ELSE'", "'END_IF'", "'CASE'", "'OF'", "'END_CASE'", "'FOR'", "'DO'", "'END_FOR'", "'TO'", "'BY'", "'WHILE'", "'END_WHILE'", "'REPEAT'", "'UNTIL'", "'END_REPEAT'", "'RETURN'", "'EXIT'", "'VAR_INPUT'", "'END_VAR'", "'VAR_OUTPUT'", "'VAR_IN_OUT'", "'VAR'", "'CONSTANT'", "'VAR_TEMP'", "'VAR_EXTERNAL'", "'AT'", "'VAR_GLOBAL'", "'VAR_PROCESS'", "'['", "']'", "'ARRAY'", "'*'", "'..'", "'#'", "'-'", "'=>'", "'='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'+'", "'/'", "'MOD'", "'NOT'"
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
    // InternalPoST.g:72:1: ruleModel returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )* ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_conf_1_0 = null;

        EObject lv_globVars_2_0 = null;

        EObject lv_programs_3_0 = null;

        EObject lv_fbs_4_0 = null;

        EObject lv_funs_5_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:78:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )* ) ) ) )
            // InternalPoST.g:79:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )* ) ) )
            {
            // InternalPoST.g:79:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )* ) ) )
            // InternalPoST.g:80:3: ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )* ) )
            {
            // InternalPoST.g:80:3: ( ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )* ) )
            // InternalPoST.g:81:4: ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )* )
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getModelAccess().getUnorderedGroup());
            			
            // InternalPoST.g:84:4: ( ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )* )
            // InternalPoST.g:85:5: ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )*
            {
            // InternalPoST.g:85:5: ( ({...}? => ( ({...}? => ( (lv_conf_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) ) )*
            loop5:
            do {
                int alt5=6;
                int LA5_0 = input.LA(1);

                if ( LA5_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 0) ) {
                    alt5=1;
                }
                else if ( LA5_0 == 104 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 1) ) {
                    alt5=2;
                }
                else if ( LA5_0 == 49 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 2) ) {
                    alt5=3;
                }
                else if ( LA5_0 == 55 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 3) ) {
                    alt5=4;
                }
                else if ( LA5_0 == 57 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 4) ) {
                    alt5=5;
                }


                switch (alt5) {
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

            	        if ( (LA1_0==104) ) {
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
            	case 5 :
            	    // InternalPoST.g:198:3: ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) )
            	    {
            	    // InternalPoST.g:198:3: ({...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ ) )
            	    // InternalPoST.g:199:4: {...}? => ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalPoST.g:199:99: ( ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+ )
            	    // InternalPoST.g:200:5: ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getModelAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalPoST.g:203:8: ({...}? => ( (lv_funs_5_0= ruleFunction ) ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==57) ) {
            	            int LA4_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalPoST.g:203:9: {...}? => ( (lv_funs_5_0= ruleFunction ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleModel", "true");
            	    	    }
            	    	    // InternalPoST.g:203:18: ( (lv_funs_5_0= ruleFunction ) )
            	    	    // InternalPoST.g:203:19: (lv_funs_5_0= ruleFunction )
            	    	    {
            	    	    // InternalPoST.g:203:19: (lv_funs_5_0= ruleFunction )
            	    	    // InternalPoST.g:204:9: lv_funs_5_0= ruleFunction
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getModelAccess().getFunsFunctionParserRuleCall_4_0());
            	    	    								
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_funs_5_0=ruleFunction();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getModelRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"funs",
            	    	    										lv_funs_5_0,
            	    	    										"su.nsk.iae.post.PoST.Function");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModelAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // InternalPoST.g:236:1: entryRuleConfiguration returns [EObject current=null] : iv_ruleConfiguration= ruleConfiguration EOF ;
    public final EObject entryRuleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfiguration = null;


        try {
            // InternalPoST.g:236:54: (iv_ruleConfiguration= ruleConfiguration EOF )
            // InternalPoST.g:237:2: iv_ruleConfiguration= ruleConfiguration EOF
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
    // InternalPoST.g:243:1: ruleConfiguration returns [EObject current=null] : (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        EObject lv_confGlobVars_2_0 = null;

        EObject lv_resources_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:249:2: ( (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' ) )
            // InternalPoST.g:250:2: (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' )
            {
            // InternalPoST.g:250:2: (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' )
            // InternalPoST.g:251:3: otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getConfigurationAccess().getCONFIGURATIONKeyword_0());
            		
            // InternalPoST.g:255:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:256:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:256:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:257:5: lv_name_1_0= RULE_ID
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

            // InternalPoST.g:273:3: ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) | ( (lv_resources_3_0= ruleResource ) ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==104) ) {
                    alt6=1;
                }
                else if ( (LA6_0==40) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalPoST.g:274:4: ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:274:4: ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) )
            	    // InternalPoST.g:275:5: (lv_confGlobVars_2_0= ruleGlobalVarDeclaration )
            	    {
            	    // InternalPoST.g:275:5: (lv_confGlobVars_2_0= ruleGlobalVarDeclaration )
            	    // InternalPoST.g:276:6: lv_confGlobVars_2_0= ruleGlobalVarDeclaration
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
            	    // InternalPoST.g:294:4: ( (lv_resources_3_0= ruleResource ) )
            	    {
            	    // InternalPoST.g:294:4: ( (lv_resources_3_0= ruleResource ) )
            	    // InternalPoST.g:295:5: (lv_resources_3_0= ruleResource )
            	    {
            	    // InternalPoST.g:295:5: (lv_resources_3_0= ruleResource )
            	    // InternalPoST.g:296:6: lv_resources_3_0= ruleResource
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
            	    break loop6;
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
    // InternalPoST.g:322:1: entryRuleResource returns [EObject current=null] : iv_ruleResource= ruleResource EOF ;
    public final EObject entryRuleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResource = null;


        try {
            // InternalPoST.g:322:49: (iv_ruleResource= ruleResource EOF )
            // InternalPoST.g:323:2: iv_ruleResource= ruleResource EOF
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
    // InternalPoST.g:329:1: ruleResource returns [EObject current=null] : (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' ) ;
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
            // InternalPoST.g:335:2: ( (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' ) )
            // InternalPoST.g:336:2: (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' )
            {
            // InternalPoST.g:336:2: (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' )
            // InternalPoST.g:337:3: otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getResourceAccess().getRESOURCEKeyword_0());
            		
            // InternalPoST.g:341:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:342:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:342:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:343:5: lv_name_1_0= RULE_ID
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
            		
            // InternalPoST.g:363:3: ( (lv_type_3_0= RULE_ID ) )
            // InternalPoST.g:364:4: (lv_type_3_0= RULE_ID )
            {
            // InternalPoST.g:364:4: (lv_type_3_0= RULE_ID )
            // InternalPoST.g:365:5: lv_type_3_0= RULE_ID
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

            // InternalPoST.g:381:3: ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==104) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalPoST.g:382:4: (lv_resGlobVars_4_0= ruleGlobalVarDeclaration )
            	    {
            	    // InternalPoST.g:382:4: (lv_resGlobVars_4_0= ruleGlobalVarDeclaration )
            	    // InternalPoST.g:383:5: lv_resGlobVars_4_0= ruleGlobalVarDeclaration
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
            	    break loop7;
                }
            } while (true);

            // InternalPoST.g:400:3: ( (lv_resStatement_5_0= ruleSingleResource ) )
            // InternalPoST.g:401:4: (lv_resStatement_5_0= ruleSingleResource )
            {
            // InternalPoST.g:401:4: (lv_resStatement_5_0= ruleSingleResource )
            // InternalPoST.g:402:5: lv_resStatement_5_0= ruleSingleResource
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
    // InternalPoST.g:427:1: entryRuleSingleResource returns [EObject current=null] : iv_ruleSingleResource= ruleSingleResource EOF ;
    public final EObject entryRuleSingleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleResource = null;


        try {
            // InternalPoST.g:427:55: (iv_ruleSingleResource= ruleSingleResource EOF )
            // InternalPoST.g:428:2: iv_ruleSingleResource= ruleSingleResource EOF
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
    // InternalPoST.g:434:1: ruleSingleResource returns [EObject current=null] : ( () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )* ) ;
    public final EObject ruleSingleResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_tasks_1_0 = null;

        EObject lv_programConfs_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:440:2: ( ( () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )* ) )
            // InternalPoST.g:441:2: ( () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )* )
            {
            // InternalPoST.g:441:2: ( () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )* )
            // InternalPoST.g:442:3: () ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )*
            {
            // InternalPoST.g:442:3: ()
            // InternalPoST.g:443:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSingleResourceAccess().getSingleResourceAction_0(),
            					current);
            			

            }

            // InternalPoST.g:449:3: ( ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ) | ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==44) ) {
                    alt8=1;
                }
                else if ( (LA8_0==49) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalPoST.g:450:4: ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' )
            	    {
            	    // InternalPoST.g:450:4: ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' )
            	    // InternalPoST.g:451:5: ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:451:5: ( (lv_tasks_1_0= ruleTask ) )
            	    // InternalPoST.g:452:6: (lv_tasks_1_0= ruleTask )
            	    {
            	    // InternalPoST.g:452:6: (lv_tasks_1_0= ruleTask )
            	    // InternalPoST.g:453:7: lv_tasks_1_0= ruleTask
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
            	    // InternalPoST.g:476:4: ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )
            	    {
            	    // InternalPoST.g:476:4: ( ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )
            	    // InternalPoST.g:477:5: ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';'
            	    {
            	    // InternalPoST.g:477:5: ( (lv_programConfs_3_0= ruleProgramConfiguration ) )
            	    // InternalPoST.g:478:6: (lv_programConfs_3_0= ruleProgramConfiguration )
            	    {
            	    // InternalPoST.g:478:6: (lv_programConfs_3_0= ruleProgramConfiguration )
            	    // InternalPoST.g:479:7: lv_programConfs_3_0= ruleProgramConfiguration
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
            	    break loop8;
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
    // InternalPoST.g:506:1: entryRuleTask returns [EObject current=null] : iv_ruleTask= ruleTask EOF ;
    public final EObject entryRuleTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTask = null;


        try {
            // InternalPoST.g:506:45: (iv_ruleTask= ruleTask EOF )
            // InternalPoST.g:507:2: iv_ruleTask= ruleTask EOF
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
    // InternalPoST.g:513:1: ruleTask returns [EObject current=null] : (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' ) ;
    public final EObject ruleTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_init_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:519:2: ( (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' ) )
            // InternalPoST.g:520:2: (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' )
            {
            // InternalPoST.g:520:2: (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' )
            // InternalPoST.g:521:3: otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTaskAccess().getTASKKeyword_0());
            		
            // InternalPoST.g:525:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:526:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:526:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:527:5: lv_name_1_0= RULE_ID
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
            		
            // InternalPoST.g:547:3: ( (lv_init_3_0= ruleTaskInitialization ) )
            // InternalPoST.g:548:4: (lv_init_3_0= ruleTaskInitialization )
            {
            // InternalPoST.g:548:4: (lv_init_3_0= ruleTaskInitialization )
            // InternalPoST.g:549:5: lv_init_3_0= ruleTaskInitialization
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
    // InternalPoST.g:574:1: entryRuleTaskInitialization returns [EObject current=null] : iv_ruleTaskInitialization= ruleTaskInitialization EOF ;
    public final EObject entryRuleTaskInitialization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTaskInitialization = null;


        try {
            // InternalPoST.g:574:59: (iv_ruleTaskInitialization= ruleTaskInitialization EOF )
            // InternalPoST.g:575:2: iv_ruleTaskInitialization= ruleTaskInitialization EOF
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
    // InternalPoST.g:581:1: ruleTaskInitialization returns [EObject current=null] : ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) ) ;
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
            // InternalPoST.g:587:2: ( ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) ) )
            // InternalPoST.g:588:2: ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) )
            {
            // InternalPoST.g:588:2: ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_SINGLE_DECLARATION) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_INTERVAL_DECLARATION) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalPoST.g:589:3: (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) )
                    {
                    // InternalPoST.g:589:3: (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) )
                    // InternalPoST.g:590:4: this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) )
                    {
                    this_SINGLE_DECLARATION_0=(Token)match(input,RULE_SINGLE_DECLARATION,FOLLOW_14); 

                    				newLeafNode(this_SINGLE_DECLARATION_0, grammarAccess.getTaskInitializationAccess().getSINGLE_DECLARATIONTerminalRuleCall_0_0());
                    			
                    otherlv_1=(Token)match(input,47,FOLLOW_15); 

                    				newLeafNode(otherlv_1, grammarAccess.getTaskInitializationAccess().getColonEqualsSignKeyword_0_1());
                    			
                    // InternalPoST.g:598:4: ( (lv_single_2_0= ruleConstant ) )
                    // InternalPoST.g:599:5: (lv_single_2_0= ruleConstant )
                    {
                    // InternalPoST.g:599:5: (lv_single_2_0= ruleConstant )
                    // InternalPoST.g:600:6: lv_single_2_0= ruleConstant
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
                    // InternalPoST.g:619:3: ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) )
                    {
                    // InternalPoST.g:619:3: ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) )
                    // InternalPoST.g:620:4: (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) )
                    {
                    // InternalPoST.g:620:4: (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) )
                    // InternalPoST.g:621:5: this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) )
                    {
                    this_INTERVAL_DECLARATION_3=(Token)match(input,RULE_INTERVAL_DECLARATION,FOLLOW_14); 

                    					newLeafNode(this_INTERVAL_DECLARATION_3, grammarAccess.getTaskInitializationAccess().getINTERVAL_DECLARATIONTerminalRuleCall_1_0_0());
                    				
                    otherlv_4=(Token)match(input,47,FOLLOW_15); 

                    					newLeafNode(otherlv_4, grammarAccess.getTaskInitializationAccess().getColonEqualsSignKeyword_1_0_1());
                    				
                    // InternalPoST.g:629:5: ( (lv_interval_5_0= ruleConstant ) )
                    // InternalPoST.g:630:6: (lv_interval_5_0= ruleConstant )
                    {
                    // InternalPoST.g:630:6: (lv_interval_5_0= ruleConstant )
                    // InternalPoST.g:631:7: lv_interval_5_0= ruleConstant
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
                    			
                    // InternalPoST.g:661:4: ( (lv_priority_9_0= RULE_INTEGER ) )
                    // InternalPoST.g:662:5: (lv_priority_9_0= RULE_INTEGER )
                    {
                    // InternalPoST.g:662:5: (lv_priority_9_0= RULE_INTEGER )
                    // InternalPoST.g:663:6: lv_priority_9_0= RULE_INTEGER
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
    // InternalPoST.g:684:1: entryRuleProgramConfiguration returns [EObject current=null] : iv_ruleProgramConfiguration= ruleProgramConfiguration EOF ;
    public final EObject entryRuleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfiguration = null;


        try {
            // InternalPoST.g:684:61: (iv_ruleProgramConfiguration= ruleProgramConfiguration EOF )
            // InternalPoST.g:685:2: iv_ruleProgramConfiguration= ruleProgramConfiguration EOF
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
    // InternalPoST.g:691:1: ruleProgramConfiguration returns [EObject current=null] : (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? ) ;
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
            // InternalPoST.g:697:2: ( (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? ) )
            // InternalPoST.g:698:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? )
            {
            // InternalPoST.g:698:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? )
            // InternalPoST.g:699:3: otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramConfigurationAccess().getPROGRAMKeyword_0());
            		
            // InternalPoST.g:703:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:704:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:704:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:705:5: lv_name_1_0= RULE_ID
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

            // InternalPoST.g:721:3: (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==50) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPoST.g:722:4: otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getProgramConfigurationAccess().getWITHKeyword_2_0());
                    			
                    // InternalPoST.g:726:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:727:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:727:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:728:6: otherlv_3= RULE_ID
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
            		
            // InternalPoST.g:744:3: ( (otherlv_5= RULE_ID ) )
            // InternalPoST.g:745:4: (otherlv_5= RULE_ID )
            {
            // InternalPoST.g:745:4: (otherlv_5= RULE_ID )
            // InternalPoST.g:746:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProgramConfigurationRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(otherlv_5, grammarAccess.getProgramConfigurationAccess().getProgramProgramCrossReference_4_0());
            				

            }


            }

            // InternalPoST.g:757:3: (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==45) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalPoST.g:758:4: otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,45,FOLLOW_22); 

                    				newLeafNode(otherlv_6, grammarAccess.getProgramConfigurationAccess().getLeftParenthesisKeyword_5_0());
                    			
                    // InternalPoST.g:762:4: ( (lv_args_7_0= ruleProgramConfElements ) )
                    // InternalPoST.g:763:5: (lv_args_7_0= ruleProgramConfElements )
                    {
                    // InternalPoST.g:763:5: (lv_args_7_0= ruleProgramConfElements )
                    // InternalPoST.g:764:6: lv_args_7_0= ruleProgramConfElements
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
    // InternalPoST.g:790:1: entryRuleProgramConfElements returns [EObject current=null] : iv_ruleProgramConfElements= ruleProgramConfElements EOF ;
    public final EObject entryRuleProgramConfElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfElements = null;


        try {
            // InternalPoST.g:790:60: (iv_ruleProgramConfElements= ruleProgramConfElements EOF )
            // InternalPoST.g:791:2: iv_ruleProgramConfElements= ruleProgramConfElements EOF
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
    // InternalPoST.g:797:1: ruleProgramConfElements returns [EObject current=null] : ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* ) ;
    public final EObject ruleProgramConfElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:803:2: ( ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* ) )
            // InternalPoST.g:804:2: ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* )
            {
            // InternalPoST.g:804:2: ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* )
            // InternalPoST.g:805:3: ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )*
            {
            // InternalPoST.g:805:3: ( (lv_elements_0_0= ruleProgramConfElement ) )
            // InternalPoST.g:806:4: (lv_elements_0_0= ruleProgramConfElement )
            {
            // InternalPoST.g:806:4: (lv_elements_0_0= ruleProgramConfElement )
            // InternalPoST.g:807:5: lv_elements_0_0= ruleProgramConfElement
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

            // InternalPoST.g:824:3: (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==48) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPoST.g:825:4: otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_22); 

            	    				newLeafNode(otherlv_1, grammarAccess.getProgramConfElementsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:829:4: ( (lv_elements_2_0= ruleProgramConfElement ) )
            	    // InternalPoST.g:830:5: (lv_elements_2_0= ruleProgramConfElement )
            	    {
            	    // InternalPoST.g:830:5: (lv_elements_2_0= ruleProgramConfElement )
            	    // InternalPoST.g:831:6: lv_elements_2_0= ruleProgramConfElement
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
            	    break loop12;
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
    // InternalPoST.g:853:1: entryRuleProgramConfElement returns [EObject current=null] : iv_ruleProgramConfElement= ruleProgramConfElement EOF ;
    public final EObject entryRuleProgramConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfElement = null;


        try {
            // InternalPoST.g:853:59: (iv_ruleProgramConfElement= ruleProgramConfElement EOF )
            // InternalPoST.g:854:2: iv_ruleProgramConfElement= ruleProgramConfElement EOF
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
    // InternalPoST.g:860:1: ruleProgramConfElement returns [EObject current=null] : (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement ) ;
    public final EObject ruleProgramConfElement() throws RecognitionException {
        EObject current = null;

        EObject this_AttachVariableConfElement_0 = null;

        EObject this_TemplateProcessConfElement_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:866:2: ( (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement ) )
            // InternalPoST.g:867:2: (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement )
            {
            // InternalPoST.g:867:2: (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            else if ( (LA13_0==52) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalPoST.g:868:3: this_AttachVariableConfElement_0= ruleAttachVariableConfElement
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
                    // InternalPoST.g:877:3: this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement
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
    // InternalPoST.g:889:1: entryRuleAttachVariableConfElement returns [EObject current=null] : iv_ruleAttachVariableConfElement= ruleAttachVariableConfElement EOF ;
    public final EObject entryRuleAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttachVariableConfElement = null;


        try {
            // InternalPoST.g:889:66: (iv_ruleAttachVariableConfElement= ruleAttachVariableConfElement EOF )
            // InternalPoST.g:890:2: iv_ruleAttachVariableConfElement= ruleAttachVariableConfElement EOF
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
    // InternalPoST.g:896:1: ruleAttachVariableConfElement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) ;
    public final EObject ruleAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_assig_1_0 = null;

        EObject lv_const_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:902:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) )
            // InternalPoST.g:903:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            {
            // InternalPoST.g:903:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            // InternalPoST.g:904:3: ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            {
            // InternalPoST.g:904:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:905:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:905:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:906:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttachVariableConfElementRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_0, grammarAccess.getAttachVariableConfElementAccess().getProgramVarSymbolicVariableCrossReference_0_0());
            				

            }


            }

            // InternalPoST.g:917:3: ( (lv_assig_1_0= ruleAssignmentType ) )
            // InternalPoST.g:918:4: (lv_assig_1_0= ruleAssignmentType )
            {
            // InternalPoST.g:918:4: (lv_assig_1_0= ruleAssignmentType )
            // InternalPoST.g:919:5: lv_assig_1_0= ruleAssignmentType
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

            // InternalPoST.g:936:3: ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_INTEGER||LA14_0==RULE_TIME_PREF_LITERAL||(LA14_0>=RULE_REAL_TYPE_NAME && LA14_0<=RULE_REAL)||LA14_0==112) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalPoST.g:937:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalPoST.g:937:4: ( (otherlv_2= RULE_ID ) )
                    // InternalPoST.g:938:5: (otherlv_2= RULE_ID )
                    {
                    // InternalPoST.g:938:5: (otherlv_2= RULE_ID )
                    // InternalPoST.g:939:6: otherlv_2= RULE_ID
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
                    // InternalPoST.g:951:4: ( (lv_const_3_0= ruleConstant ) )
                    {
                    // InternalPoST.g:951:4: ( (lv_const_3_0= ruleConstant ) )
                    // InternalPoST.g:952:5: (lv_const_3_0= ruleConstant )
                    {
                    // InternalPoST.g:952:5: (lv_const_3_0= ruleConstant )
                    // InternalPoST.g:953:6: lv_const_3_0= ruleConstant
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
    // InternalPoST.g:975:1: entryRuleTemplateProcessConfElement returns [EObject current=null] : iv_ruleTemplateProcessConfElement= ruleTemplateProcessConfElement EOF ;
    public final EObject entryRuleTemplateProcessConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateProcessConfElement = null;


        try {
            // InternalPoST.g:975:67: (iv_ruleTemplateProcessConfElement= ruleTemplateProcessConfElement EOF )
            // InternalPoST.g:976:2: iv_ruleTemplateProcessConfElement= ruleTemplateProcessConfElement EOF
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
    // InternalPoST.g:982:1: ruleTemplateProcessConfElement returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )? ) ;
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
            // InternalPoST.g:988:2: ( (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )? ) )
            // InternalPoST.g:989:2: (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )? )
            {
            // InternalPoST.g:989:2: (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )? )
            // InternalPoST.g:990:3: otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getTemplateProcessConfElementAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:994:3: ( (lv_active_1_0= 'ACTIVE' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==53) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalPoST.g:995:4: (lv_active_1_0= 'ACTIVE' )
                    {
                    // InternalPoST.g:995:4: (lv_active_1_0= 'ACTIVE' )
                    // InternalPoST.g:996:5: lv_active_1_0= 'ACTIVE'
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

            // InternalPoST.g:1008:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalPoST.g:1009:4: (lv_name_2_0= RULE_ID )
            {
            // InternalPoST.g:1009:4: (lv_name_2_0= RULE_ID )
            // InternalPoST.g:1010:5: lv_name_2_0= RULE_ID
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
            		
            // InternalPoST.g:1030:3: ( (otherlv_4= RULE_ID ) )
            // InternalPoST.g:1031:4: (otherlv_4= RULE_ID )
            {
            // InternalPoST.g:1031:4: (otherlv_4= RULE_ID )
            // InternalPoST.g:1032:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemplateProcessConfElementRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(otherlv_4, grammarAccess.getTemplateProcessConfElementAccess().getProcessProcessCrossReference_4_0());
            				

            }


            }

            // InternalPoST.g:1043:3: (otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==45) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalPoST.g:1044:4: otherlv_5= '(' ( (lv_args_6_0= ruleTemplateProcessElements ) ) otherlv_7= ')'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getTemplateProcessConfElementAccess().getLeftParenthesisKeyword_5_0());
                    			
                    // InternalPoST.g:1048:4: ( (lv_args_6_0= ruleTemplateProcessElements ) )
                    // InternalPoST.g:1049:5: (lv_args_6_0= ruleTemplateProcessElements )
                    {
                    // InternalPoST.g:1049:5: (lv_args_6_0= ruleTemplateProcessElements )
                    // InternalPoST.g:1050:6: lv_args_6_0= ruleTemplateProcessElements
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
    // InternalPoST.g:1076:1: entryRuleTemplateProcessElements returns [EObject current=null] : iv_ruleTemplateProcessElements= ruleTemplateProcessElements EOF ;
    public final EObject entryRuleTemplateProcessElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateProcessElements = null;


        try {
            // InternalPoST.g:1076:64: (iv_ruleTemplateProcessElements= ruleTemplateProcessElements EOF )
            // InternalPoST.g:1077:2: iv_ruleTemplateProcessElements= ruleTemplateProcessElements EOF
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
    // InternalPoST.g:1083:1: ruleTemplateProcessElements returns [EObject current=null] : ( ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )* ) ;
    public final EObject ruleTemplateProcessElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1089:2: ( ( ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )* ) )
            // InternalPoST.g:1090:2: ( ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )* )
            {
            // InternalPoST.g:1090:2: ( ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )* )
            // InternalPoST.g:1091:3: ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )*
            {
            // InternalPoST.g:1091:3: ( (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement ) )
            // InternalPoST.g:1092:4: (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement )
            {
            // InternalPoST.g:1092:4: (lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement )
            // InternalPoST.g:1093:5: lv_elements_0_0= ruleTemplateProcessAttachVariableConfElement
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

            // InternalPoST.g:1110:3: (otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==48) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalPoST.g:1111:4: otherlv_1= ',' ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getTemplateProcessElementsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:1115:4: ( (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement ) )
            	    // InternalPoST.g:1116:5: (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement )
            	    {
            	    // InternalPoST.g:1116:5: (lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement )
            	    // InternalPoST.g:1117:6: lv_elements_2_0= ruleTemplateProcessAttachVariableConfElement
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
            	    break loop17;
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
    // InternalPoST.g:1139:1: entryRuleTemplateProcessAttachVariableConfElement returns [EObject current=null] : iv_ruleTemplateProcessAttachVariableConfElement= ruleTemplateProcessAttachVariableConfElement EOF ;
    public final EObject entryRuleTemplateProcessAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateProcessAttachVariableConfElement = null;


        try {
            // InternalPoST.g:1139:81: (iv_ruleTemplateProcessAttachVariableConfElement= ruleTemplateProcessAttachVariableConfElement EOF )
            // InternalPoST.g:1140:2: iv_ruleTemplateProcessAttachVariableConfElement= ruleTemplateProcessAttachVariableConfElement EOF
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
    // InternalPoST.g:1146:1: ruleTemplateProcessAttachVariableConfElement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) ;
    public final EObject ruleTemplateProcessAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_assig_1_0 = null;

        EObject lv_const_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1152:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) )
            // InternalPoST.g:1153:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            {
            // InternalPoST.g:1153:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            // InternalPoST.g:1154:3: ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            {
            // InternalPoST.g:1154:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:1155:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:1155:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:1156:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemplateProcessAttachVariableConfElementRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_0, grammarAccess.getTemplateProcessAttachVariableConfElementAccess().getProgramVarVariableCrossReference_0_0());
            				

            }


            }

            // InternalPoST.g:1167:3: ( (lv_assig_1_0= ruleAssignmentType ) )
            // InternalPoST.g:1168:4: (lv_assig_1_0= ruleAssignmentType )
            {
            // InternalPoST.g:1168:4: (lv_assig_1_0= ruleAssignmentType )
            // InternalPoST.g:1169:5: lv_assig_1_0= ruleAssignmentType
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

            // InternalPoST.g:1186:3: ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_INTEGER||LA18_0==RULE_TIME_PREF_LITERAL||(LA18_0>=RULE_REAL_TYPE_NAME && LA18_0<=RULE_REAL)||LA18_0==112) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalPoST.g:1187:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalPoST.g:1187:4: ( (otherlv_2= RULE_ID ) )
                    // InternalPoST.g:1188:5: (otherlv_2= RULE_ID )
                    {
                    // InternalPoST.g:1188:5: (otherlv_2= RULE_ID )
                    // InternalPoST.g:1189:6: otherlv_2= RULE_ID
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
                    // InternalPoST.g:1201:4: ( (lv_const_3_0= ruleConstant ) )
                    {
                    // InternalPoST.g:1201:4: ( (lv_const_3_0= ruleConstant ) )
                    // InternalPoST.g:1202:5: (lv_const_3_0= ruleConstant )
                    {
                    // InternalPoST.g:1202:5: (lv_const_3_0= ruleConstant )
                    // InternalPoST.g:1203:6: lv_const_3_0= ruleConstant
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
    // InternalPoST.g:1225:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalPoST.g:1225:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalPoST.g:1226:2: iv_ruleProgram= ruleProgram EOF
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
    // InternalPoST.g:1232:1: ruleProgram returns [EObject current=null] : (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' ) ;
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
            // InternalPoST.g:1238:2: ( (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' ) )
            // InternalPoST.g:1239:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' )
            {
            // InternalPoST.g:1239:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' )
            // InternalPoST.g:1240:3: otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramAccess().getPROGRAMKeyword_0());
            		
            // InternalPoST.g:1244:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1245:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1245:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1246:5: lv_name_1_0= RULE_ID
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

            // InternalPoST.g:1262:3: ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )*
            loop19:
            do {
                int alt19=7;
                switch ( input.LA(1) ) {
                case 95:
                    {
                    alt19=1;
                    }
                    break;
                case 97:
                    {
                    alt19=2;
                    }
                    break;
                case 98:
                    {
                    alt19=3;
                    }
                    break;
                case 99:
                    {
                    alt19=4;
                    }
                    break;
                case 101:
                    {
                    alt19=5;
                    }
                    break;
                case 102:
                    {
                    alt19=6;
                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // InternalPoST.g:1263:4: ( (lv_progInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1263:4: ( (lv_progInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1264:5: (lv_progInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1264:5: (lv_progInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1265:6: lv_progInVars_2_0= ruleInputVarDeclaration
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
            	    // InternalPoST.g:1283:4: ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1283:4: ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1284:5: (lv_progOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1284:5: (lv_progOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1285:6: lv_progOutVars_3_0= ruleOutputVarDeclaration
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
            	    // InternalPoST.g:1303:4: ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1303:4: ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1304:5: (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1304:5: (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1305:6: lv_progInOutVars_4_0= ruleInputOutputVarDeclaration
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
            	    // InternalPoST.g:1323:4: ( (lv_progVars_5_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1323:4: ( (lv_progVars_5_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1324:5: (lv_progVars_5_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1324:5: (lv_progVars_5_0= ruleVarDeclaration )
            	    // InternalPoST.g:1325:6: lv_progVars_5_0= ruleVarDeclaration
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
            	    // InternalPoST.g:1343:4: ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1343:4: ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1344:5: (lv_progTempVars_6_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1344:5: (lv_progTempVars_6_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1345:6: lv_progTempVars_6_0= ruleTempVarDeclaration
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
            	    // InternalPoST.g:1363:4: ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1363:4: ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) )
            	    // InternalPoST.g:1364:5: (lv_progExternVars_7_0= ruleExternalVarDeclaration )
            	    {
            	    // InternalPoST.g:1364:5: (lv_progExternVars_7_0= ruleExternalVarDeclaration )
            	    // InternalPoST.g:1365:6: lv_progExternVars_7_0= ruleExternalVarDeclaration
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
            	    break loop19;
                }
            } while (true);

            // InternalPoST.g:1383:3: ( (lv_processes_8_0= ruleProcess ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==52) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPoST.g:1384:4: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalPoST.g:1384:4: (lv_processes_8_0= ruleProcess )
            	    // InternalPoST.g:1385:5: lv_processes_8_0= ruleProcess
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
            	    break loop20;
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
    // InternalPoST.g:1410:1: entryRuleFunctionBlock returns [EObject current=null] : iv_ruleFunctionBlock= ruleFunctionBlock EOF ;
    public final EObject entryRuleFunctionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionBlock = null;


        try {
            // InternalPoST.g:1410:54: (iv_ruleFunctionBlock= ruleFunctionBlock EOF )
            // InternalPoST.g:1411:2: iv_ruleFunctionBlock= ruleFunctionBlock EOF
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
    // InternalPoST.g:1417:1: ruleFunctionBlock returns [EObject current=null] : (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' ) ;
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
            // InternalPoST.g:1423:2: ( (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' ) )
            // InternalPoST.g:1424:2: (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' )
            {
            // InternalPoST.g:1424:2: (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' )
            // InternalPoST.g:1425:3: otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionBlockAccess().getFUNCTION_BLOCKKeyword_0());
            		
            // InternalPoST.g:1429:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1430:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1430:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1431:5: lv_name_1_0= RULE_ID
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

            // InternalPoST.g:1447:3: ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )*
            loop21:
            do {
                int alt21=7;
                switch ( input.LA(1) ) {
                case 95:
                    {
                    alt21=1;
                    }
                    break;
                case 97:
                    {
                    alt21=2;
                    }
                    break;
                case 98:
                    {
                    alt21=3;
                    }
                    break;
                case 99:
                    {
                    alt21=4;
                    }
                    break;
                case 101:
                    {
                    alt21=5;
                    }
                    break;
                case 102:
                    {
                    alt21=6;
                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // InternalPoST.g:1448:4: ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1448:4: ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1449:5: (lv_fbInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1449:5: (lv_fbInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1450:6: lv_fbInVars_2_0= ruleInputVarDeclaration
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
            	    // InternalPoST.g:1468:4: ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1468:4: ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1469:5: (lv_fbOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1469:5: (lv_fbOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1470:6: lv_fbOutVars_3_0= ruleOutputVarDeclaration
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
            	    // InternalPoST.g:1488:4: ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1488:4: ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1489:5: (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1489:5: (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1490:6: lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration
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
            	    // InternalPoST.g:1508:4: ( (lv_fbVars_5_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1508:4: ( (lv_fbVars_5_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1509:5: (lv_fbVars_5_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1509:5: (lv_fbVars_5_0= ruleVarDeclaration )
            	    // InternalPoST.g:1510:6: lv_fbVars_5_0= ruleVarDeclaration
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
            	    // InternalPoST.g:1528:4: ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1528:4: ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1529:5: (lv_fbTempVars_6_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1529:5: (lv_fbTempVars_6_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1530:6: lv_fbTempVars_6_0= ruleTempVarDeclaration
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
            	    // InternalPoST.g:1548:4: ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1548:4: ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) )
            	    // InternalPoST.g:1549:5: (lv_fbExternVars_7_0= ruleExternalVarDeclaration )
            	    {
            	    // InternalPoST.g:1549:5: (lv_fbExternVars_7_0= ruleExternalVarDeclaration )
            	    // InternalPoST.g:1550:6: lv_fbExternVars_7_0= ruleExternalVarDeclaration
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
            	    break loop21;
                }
            } while (true);

            // InternalPoST.g:1568:3: ( (lv_processes_8_0= ruleProcess ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==52) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPoST.g:1569:4: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalPoST.g:1569:4: (lv_processes_8_0= ruleProcess )
            	    // InternalPoST.g:1570:5: lv_processes_8_0= ruleProcess
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
            	    break loop22;
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


    // $ANTLR start "entryRuleFunction"
    // InternalPoST.g:1595:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalPoST.g:1595:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalPoST.g:1596:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
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
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalPoST.g:1602:1: ruleFunction returns [EObject current=null] : (otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataTypeName ) ) ( ( (lv_funInVars_4_0= ruleInputVarDeclaration ) ) | ( (lv_funOutVars_5_0= ruleOutputVarDeclaration ) ) | ( (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration ) ) | ( (lv_funVars_7_0= ruleVarDeclaration ) ) )* ( (lv_statement_8_0= ruleStatementList ) ) otherlv_9= 'END_FUNCTION' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_type_3_0 = null;

        EObject lv_funInVars_4_0 = null;

        EObject lv_funOutVars_5_0 = null;

        EObject lv_funInOutVars_6_0 = null;

        EObject lv_funVars_7_0 = null;

        EObject lv_statement_8_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1608:2: ( (otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataTypeName ) ) ( ( (lv_funInVars_4_0= ruleInputVarDeclaration ) ) | ( (lv_funOutVars_5_0= ruleOutputVarDeclaration ) ) | ( (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration ) ) | ( (lv_funVars_7_0= ruleVarDeclaration ) ) )* ( (lv_statement_8_0= ruleStatementList ) ) otherlv_9= 'END_FUNCTION' ) )
            // InternalPoST.g:1609:2: (otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataTypeName ) ) ( ( (lv_funInVars_4_0= ruleInputVarDeclaration ) ) | ( (lv_funOutVars_5_0= ruleOutputVarDeclaration ) ) | ( (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration ) ) | ( (lv_funVars_7_0= ruleVarDeclaration ) ) )* ( (lv_statement_8_0= ruleStatementList ) ) otherlv_9= 'END_FUNCTION' )
            {
            // InternalPoST.g:1609:2: (otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataTypeName ) ) ( ( (lv_funInVars_4_0= ruleInputVarDeclaration ) ) | ( (lv_funOutVars_5_0= ruleOutputVarDeclaration ) ) | ( (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration ) ) | ( (lv_funVars_7_0= ruleVarDeclaration ) ) )* ( (lv_statement_8_0= ruleStatementList ) ) otherlv_9= 'END_FUNCTION' )
            // InternalPoST.g:1610:3: otherlv_0= 'FUNCTION' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataTypeName ) ) ( ( (lv_funInVars_4_0= ruleInputVarDeclaration ) ) | ( (lv_funOutVars_5_0= ruleOutputVarDeclaration ) ) | ( (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration ) ) | ( (lv_funVars_7_0= ruleVarDeclaration ) ) )* ( (lv_statement_8_0= ruleStatementList ) ) otherlv_9= 'END_FUNCTION'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getFUNCTIONKeyword_0());
            		
            // InternalPoST.g:1614:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1615:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1615:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1616:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,51,FOLLOW_31); 

            			newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getColonKeyword_2());
            		
            // InternalPoST.g:1636:3: ( (lv_type_3_0= ruleDataTypeName ) )
            // InternalPoST.g:1637:4: (lv_type_3_0= ruleDataTypeName )
            {
            // InternalPoST.g:1637:4: (lv_type_3_0= ruleDataTypeName )
            // InternalPoST.g:1638:5: lv_type_3_0= ruleDataTypeName
            {

            					newCompositeNode(grammarAccess.getFunctionAccess().getTypeDataTypeNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_32);
            lv_type_3_0=ruleDataTypeName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_3_0,
            						"su.nsk.iae.post.PoST.DataTypeName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:1655:3: ( ( (lv_funInVars_4_0= ruleInputVarDeclaration ) ) | ( (lv_funOutVars_5_0= ruleOutputVarDeclaration ) ) | ( (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration ) ) | ( (lv_funVars_7_0= ruleVarDeclaration ) ) )*
            loop23:
            do {
                int alt23=5;
                switch ( input.LA(1) ) {
                case 95:
                    {
                    alt23=1;
                    }
                    break;
                case 97:
                    {
                    alt23=2;
                    }
                    break;
                case 98:
                    {
                    alt23=3;
                    }
                    break;
                case 99:
                    {
                    alt23=4;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // InternalPoST.g:1656:4: ( (lv_funInVars_4_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1656:4: ( (lv_funInVars_4_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1657:5: (lv_funInVars_4_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1657:5: (lv_funInVars_4_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1658:6: lv_funInVars_4_0= ruleInputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionAccess().getFunInVarsInputVarDeclarationParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_32);
            	    lv_funInVars_4_0=ruleInputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"funInVars",
            	    							lv_funInVars_4_0,
            	    							"su.nsk.iae.post.PoST.InputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:1676:4: ( (lv_funOutVars_5_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1676:4: ( (lv_funOutVars_5_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1677:5: (lv_funOutVars_5_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1677:5: (lv_funOutVars_5_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1678:6: lv_funOutVars_5_0= ruleOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionAccess().getFunOutVarsOutputVarDeclarationParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_32);
            	    lv_funOutVars_5_0=ruleOutputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"funOutVars",
            	    							lv_funOutVars_5_0,
            	    							"su.nsk.iae.post.PoST.OutputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalPoST.g:1696:4: ( (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1696:4: ( (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1697:5: (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1697:5: (lv_funInOutVars_6_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1698:6: lv_funInOutVars_6_0= ruleInputOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionAccess().getFunInOutVarsInputOutputVarDeclarationParserRuleCall_4_2_0());
            	    					
            	    pushFollow(FOLLOW_32);
            	    lv_funInOutVars_6_0=ruleInputOutputVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"funInOutVars",
            	    							lv_funInOutVars_6_0,
            	    							"su.nsk.iae.post.PoST.InputOutputVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalPoST.g:1716:4: ( (lv_funVars_7_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1716:4: ( (lv_funVars_7_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1717:5: (lv_funVars_7_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1717:5: (lv_funVars_7_0= ruleVarDeclaration )
            	    // InternalPoST.g:1718:6: lv_funVars_7_0= ruleVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionAccess().getFunVarsVarDeclarationParserRuleCall_4_3_0());
            	    					
            	    pushFollow(FOLLOW_32);
            	    lv_funVars_7_0=ruleVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"funVars",
            	    							lv_funVars_7_0,
            	    							"su.nsk.iae.post.PoST.VarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // InternalPoST.g:1736:3: ( (lv_statement_8_0= ruleStatementList ) )
            // InternalPoST.g:1737:4: (lv_statement_8_0= ruleStatementList )
            {
            // InternalPoST.g:1737:4: (lv_statement_8_0= ruleStatementList )
            // InternalPoST.g:1738:5: lv_statement_8_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getFunctionAccess().getStatementStatementListParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_33);
            lv_statement_8_0=ruleStatementList();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionRule());
            					}
            					set(
            						current,
            						"statement",
            						lv_statement_8_0,
            						"su.nsk.iae.post.PoST.StatementList");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,58,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getFunctionAccess().getEND_FUNCTIONKeyword_6());
            		

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
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleProcess"
    // InternalPoST.g:1763:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalPoST.g:1763:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalPoST.g:1764:2: iv_ruleProcess= ruleProcess EOF
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
    // InternalPoST.g:1770:1: ruleProcess returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS' ) ;
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
            // InternalPoST.g:1776:2: ( (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS' ) )
            // InternalPoST.g:1777:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS' )
            {
            // InternalPoST.g:1777:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS' )
            // InternalPoST.g:1778:3: otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )* ( (lv_states_8_0= ruleState ) )* otherlv_9= 'END_PROCESS'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:1782:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1783:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1783:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1784:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_34); 

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

            // InternalPoST.g:1800:3: ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) ) | ( (lv_procVars_6_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) ) )*
            loop24:
            do {
                int alt24=7;
                switch ( input.LA(1) ) {
                case 95:
                    {
                    alt24=1;
                    }
                    break;
                case 97:
                    {
                    alt24=2;
                    }
                    break;
                case 98:
                    {
                    alt24=3;
                    }
                    break;
                case 105:
                    {
                    alt24=4;
                    }
                    break;
                case 99:
                    {
                    alt24=5;
                    }
                    break;
                case 101:
                    {
                    alt24=6;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // InternalPoST.g:1801:4: ( (lv_procInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1801:4: ( (lv_procInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1802:5: (lv_procInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1802:5: (lv_procInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1803:6: lv_procInVars_2_0= ruleInputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcInVarsInputVarDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_34);
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
            	    // InternalPoST.g:1821:4: ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1821:4: ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1822:5: (lv_procOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1822:5: (lv_procOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1823:6: lv_procOutVars_3_0= ruleOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcOutVarsOutputVarDeclarationParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_34);
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
            	    // InternalPoST.g:1841:4: ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1841:4: ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1842:5: (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1842:5: (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1843:6: lv_procInOutVars_4_0= ruleInputOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcInOutVarsInputOutputVarDeclarationParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_34);
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
            	    // InternalPoST.g:1861:4: ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1861:4: ( (lv_procProcessVars_5_0= ruleProcessVarDeclaration ) )
            	    // InternalPoST.g:1862:5: (lv_procProcessVars_5_0= ruleProcessVarDeclaration )
            	    {
            	    // InternalPoST.g:1862:5: (lv_procProcessVars_5_0= ruleProcessVarDeclaration )
            	    // InternalPoST.g:1863:6: lv_procProcessVars_5_0= ruleProcessVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcProcessVarsProcessVarDeclarationParserRuleCall_2_3_0());
            	    					
            	    pushFollow(FOLLOW_34);
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
            	    // InternalPoST.g:1881:4: ( (lv_procVars_6_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1881:4: ( (lv_procVars_6_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1882:5: (lv_procVars_6_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1882:5: (lv_procVars_6_0= ruleVarDeclaration )
            	    // InternalPoST.g:1883:6: lv_procVars_6_0= ruleVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcVarsVarDeclarationParserRuleCall_2_4_0());
            	    					
            	    pushFollow(FOLLOW_34);
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
            	    // InternalPoST.g:1901:4: ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1901:4: ( (lv_procTempVars_7_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1902:5: (lv_procTempVars_7_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1902:5: (lv_procTempVars_7_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1903:6: lv_procTempVars_7_0= ruleTempVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcTempVarsTempVarDeclarationParserRuleCall_2_5_0());
            	    					
            	    pushFollow(FOLLOW_34);
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
            	    break loop24;
                }
            } while (true);

            // InternalPoST.g:1921:3: ( (lv_states_8_0= ruleState ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==60) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalPoST.g:1922:4: (lv_states_8_0= ruleState )
            	    {
            	    // InternalPoST.g:1922:4: (lv_states_8_0= ruleState )
            	    // InternalPoST.g:1923:5: lv_states_8_0= ruleState
            	    {

            	    					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_35);
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
            	    break loop25;
                }
            } while (true);

            otherlv_9=(Token)match(input,59,FOLLOW_2); 

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
    // InternalPoST.g:1948:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalPoST.g:1948:46: (iv_ruleState= ruleState EOF )
            // InternalPoST.g:1949:2: iv_ruleState= ruleState EOF
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
    // InternalPoST.g:1955:1: ruleState returns [EObject current=null] : (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' ) ;
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
            // InternalPoST.g:1961:2: ( (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' ) )
            // InternalPoST.g:1962:2: (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' )
            {
            // InternalPoST.g:1962:2: (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' )
            // InternalPoST.g:1963:3: otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getSTATEKeyword_0());
            		
            // InternalPoST.g:1967:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1968:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1968:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1969:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_36); 

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

            // InternalPoST.g:1985:3: ( (lv_looped_2_0= 'LOOPED' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==61) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalPoST.g:1986:4: (lv_looped_2_0= 'LOOPED' )
                    {
                    // InternalPoST.g:1986:4: (lv_looped_2_0= 'LOOPED' )
                    // InternalPoST.g:1987:5: lv_looped_2_0= 'LOOPED'
                    {
                    lv_looped_2_0=(Token)match(input,61,FOLLOW_37); 

                    					newLeafNode(lv_looped_2_0, grammarAccess.getStateAccess().getLoopedLOOPEDKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getStateRule());
                    					}
                    					setWithLastConsumed(current, "looped", lv_looped_2_0 != null, "LOOPED");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:1999:3: ( (lv_statement_3_0= ruleStatementList ) )
            // InternalPoST.g:2000:4: (lv_statement_3_0= ruleStatementList )
            {
            // InternalPoST.g:2000:4: (lv_statement_3_0= ruleStatementList )
            // InternalPoST.g:2001:5: lv_statement_3_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getStateAccess().getStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_38);
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

            // InternalPoST.g:2018:3: ( (lv_timeout_4_0= ruleTimeoutStatement ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==71) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalPoST.g:2019:4: (lv_timeout_4_0= ruleTimeoutStatement )
                    {
                    // InternalPoST.g:2019:4: (lv_timeout_4_0= ruleTimeoutStatement )
                    // InternalPoST.g:2020:5: lv_timeout_4_0= ruleTimeoutStatement
                    {

                    					newCompositeNode(grammarAccess.getStateAccess().getTimeoutTimeoutStatementParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_39);
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

            otherlv_5=(Token)match(input,62,FOLLOW_2); 

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
    // InternalPoST.g:2045:1: entryRuleSetStateStatement returns [EObject current=null] : iv_ruleSetStateStatement= ruleSetStateStatement EOF ;
    public final EObject entryRuleSetStateStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStatement = null;


        try {
            // InternalPoST.g:2045:58: (iv_ruleSetStateStatement= ruleSetStateStatement EOF )
            // InternalPoST.g:2046:2: iv_ruleSetStateStatement= ruleSetStateStatement EOF
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
    // InternalPoST.g:2052:1: ruleSetStateStatement returns [EObject current=null] : ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) ) ;
    public final EObject ruleSetStateStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_next_4_0=null;


        	enterRule();

        try {
            // InternalPoST.g:2058:2: ( ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) ) )
            // InternalPoST.g:2059:2: ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) )
            {
            // InternalPoST.g:2059:2: ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) )
            // InternalPoST.g:2060:3: () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) )
            {
            // InternalPoST.g:2060:3: ()
            // InternalPoST.g:2061:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSetStateStatementAccess().getSetStateStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,63,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getSetStateStatementAccess().getSETKeyword_1());
            		
            // InternalPoST.g:2071:3: ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==60) ) {
                alt28=1;
            }
            else if ( (LA28_0==64) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalPoST.g:2072:4: (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalPoST.g:2072:4: (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) )
                    // InternalPoST.g:2073:5: otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,60,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getSetStateStatementAccess().getSTATEKeyword_2_0_0());
                    				
                    // InternalPoST.g:2077:5: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:2078:6: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:2078:6: (otherlv_3= RULE_ID )
                    // InternalPoST.g:2079:7: otherlv_3= RULE_ID
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
                    // InternalPoST.g:2092:4: ( (lv_next_4_0= 'NEXT' ) )
                    {
                    // InternalPoST.g:2092:4: ( (lv_next_4_0= 'NEXT' ) )
                    // InternalPoST.g:2093:5: (lv_next_4_0= 'NEXT' )
                    {
                    // InternalPoST.g:2093:5: (lv_next_4_0= 'NEXT' )
                    // InternalPoST.g:2094:6: lv_next_4_0= 'NEXT'
                    {
                    lv_next_4_0=(Token)match(input,64,FOLLOW_2); 

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
    // InternalPoST.g:2111:1: entryRuleProcessStatements returns [EObject current=null] : iv_ruleProcessStatements= ruleProcessStatements EOF ;
    public final EObject entryRuleProcessStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessStatements = null;


        try {
            // InternalPoST.g:2111:58: (iv_ruleProcessStatements= ruleProcessStatements EOF )
            // InternalPoST.g:2112:2: iv_ruleProcessStatements= ruleProcessStatements EOF
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
    // InternalPoST.g:2118:1: ruleProcessStatements returns [EObject current=null] : (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement ) ;
    public final EObject ruleProcessStatements() throws RecognitionException {
        EObject current = null;

        EObject this_StartProcessStatement_0 = null;

        EObject this_StopProcessStatement_1 = null;

        EObject this_ErrorProcessStatement_2 = null;



        	enterRule();

        try {
            // InternalPoST.g:2124:2: ( (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement ) )
            // InternalPoST.g:2125:2: (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement )
            {
            // InternalPoST.g:2125:2: (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 69:
            case 70:
                {
                alt29=1;
                }
                break;
            case 67:
                {
                alt29=2;
                }
                break;
            case 68:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalPoST.g:2126:3: this_StartProcessStatement_0= ruleStartProcessStatement
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
                    // InternalPoST.g:2135:3: this_StopProcessStatement_1= ruleStopProcessStatement
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
                    // InternalPoST.g:2144:3: this_ErrorProcessStatement_2= ruleErrorProcessStatement
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
    // InternalPoST.g:2156:1: entryRuleProcessStatusExpression returns [EObject current=null] : iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF ;
    public final EObject entryRuleProcessStatusExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessStatusExpression = null;


        try {
            // InternalPoST.g:2156:64: (iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF )
            // InternalPoST.g:2157:2: iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF
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
    // InternalPoST.g:2163:1: ruleProcessStatusExpression returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) ) ;
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
            // InternalPoST.g:2169:2: ( (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) ) )
            // InternalPoST.g:2170:2: (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) )
            {
            // InternalPoST.g:2170:2: (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) )
            // InternalPoST.g:2171:3: otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessStatusExpressionAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:2175:3: ( (otherlv_1= RULE_ID ) )
            // InternalPoST.g:2176:4: (otherlv_1= RULE_ID )
            {
            // InternalPoST.g:2176:4: (otherlv_1= RULE_ID )
            // InternalPoST.g:2177:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessStatusExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(otherlv_1, grammarAccess.getProcessStatusExpressionAccess().getProcessVariableCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,65,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getProcessStatusExpressionAccess().getINKeyword_2());
            		
            otherlv_3=(Token)match(input,60,FOLLOW_43); 

            			newLeafNode(otherlv_3, grammarAccess.getProcessStatusExpressionAccess().getSTATEKeyword_3());
            		
            // InternalPoST.g:2196:3: ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt30=1;
                }
                break;
            case 66:
                {
                alt30=2;
                }
                break;
            case 67:
                {
                alt30=3;
                }
                break;
            case 68:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalPoST.g:2197:4: ( (lv_active_4_0= 'ACTIVE' ) )
                    {
                    // InternalPoST.g:2197:4: ( (lv_active_4_0= 'ACTIVE' ) )
                    // InternalPoST.g:2198:5: (lv_active_4_0= 'ACTIVE' )
                    {
                    // InternalPoST.g:2198:5: (lv_active_4_0= 'ACTIVE' )
                    // InternalPoST.g:2199:6: lv_active_4_0= 'ACTIVE'
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
                    // InternalPoST.g:2212:4: ( (lv_inactive_5_0= 'INACTIVE' ) )
                    {
                    // InternalPoST.g:2212:4: ( (lv_inactive_5_0= 'INACTIVE' ) )
                    // InternalPoST.g:2213:5: (lv_inactive_5_0= 'INACTIVE' )
                    {
                    // InternalPoST.g:2213:5: (lv_inactive_5_0= 'INACTIVE' )
                    // InternalPoST.g:2214:6: lv_inactive_5_0= 'INACTIVE'
                    {
                    lv_inactive_5_0=(Token)match(input,66,FOLLOW_2); 

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
                    // InternalPoST.g:2227:4: ( (lv_stop_6_0= 'STOP' ) )
                    {
                    // InternalPoST.g:2227:4: ( (lv_stop_6_0= 'STOP' ) )
                    // InternalPoST.g:2228:5: (lv_stop_6_0= 'STOP' )
                    {
                    // InternalPoST.g:2228:5: (lv_stop_6_0= 'STOP' )
                    // InternalPoST.g:2229:6: lv_stop_6_0= 'STOP'
                    {
                    lv_stop_6_0=(Token)match(input,67,FOLLOW_2); 

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
                    // InternalPoST.g:2242:4: ( (lv_error_7_0= 'ERROR' ) )
                    {
                    // InternalPoST.g:2242:4: ( (lv_error_7_0= 'ERROR' ) )
                    // InternalPoST.g:2243:5: (lv_error_7_0= 'ERROR' )
                    {
                    // InternalPoST.g:2243:5: (lv_error_7_0= 'ERROR' )
                    // InternalPoST.g:2244:6: lv_error_7_0= 'ERROR'
                    {
                    lv_error_7_0=(Token)match(input,68,FOLLOW_2); 

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
    // InternalPoST.g:2261:1: entryRuleStartProcessStatement returns [EObject current=null] : iv_ruleStartProcessStatement= ruleStartProcessStatement EOF ;
    public final EObject entryRuleStartProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcessStatement = null;


        try {
            // InternalPoST.g:2261:62: (iv_ruleStartProcessStatement= ruleStartProcessStatement EOF )
            // InternalPoST.g:2262:2: iv_ruleStartProcessStatement= ruleStartProcessStatement EOF
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
    // InternalPoST.g:2268:1: ruleStartProcessStatement returns [EObject current=null] : ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) ) ;
    public final EObject ruleStartProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalPoST.g:2274:2: ( ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) ) )
            // InternalPoST.g:2275:2: ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) )
            {
            // InternalPoST.g:2275:2: ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==69) ) {
                alt31=1;
            }
            else if ( (LA31_0==70) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalPoST.g:2276:3: ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) )
                    {
                    // InternalPoST.g:2276:3: ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) )
                    // InternalPoST.g:2277:4: () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalPoST.g:2277:4: ()
                    // InternalPoST.g:2278:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStartProcessStatementAccess().getStartProcessStatementAction_0_0(),
                    						current);
                    				

                    }

                    // InternalPoST.g:2284:4: (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )
                    // InternalPoST.g:2285:5: otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,69,FOLLOW_44); 

                    					newLeafNode(otherlv_1, grammarAccess.getStartProcessStatementAccess().getSTARTKeyword_0_1_0());
                    				
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getStartProcessStatementAccess().getPROCESSKeyword_0_1_1());
                    				
                    // InternalPoST.g:2293:5: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:2294:6: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:2294:6: (otherlv_3= RULE_ID )
                    // InternalPoST.g:2295:7: otherlv_3= RULE_ID
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
                    // InternalPoST.g:2309:3: ( () otherlv_5= 'RESTART' )
                    {
                    // InternalPoST.g:2309:3: ( () otherlv_5= 'RESTART' )
                    // InternalPoST.g:2310:4: () otherlv_5= 'RESTART'
                    {
                    // InternalPoST.g:2310:4: ()
                    // InternalPoST.g:2311:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStartProcessStatementAccess().getStartProcessStatementAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,70,FOLLOW_2); 

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
    // InternalPoST.g:2326:1: entryRuleStopProcessStatement returns [EObject current=null] : iv_ruleStopProcessStatement= ruleStopProcessStatement EOF ;
    public final EObject entryRuleStopProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcessStatement = null;


        try {
            // InternalPoST.g:2326:61: (iv_ruleStopProcessStatement= ruleStopProcessStatement EOF )
            // InternalPoST.g:2327:2: iv_ruleStopProcessStatement= ruleStopProcessStatement EOF
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
    // InternalPoST.g:2333:1: ruleStopProcessStatement returns [EObject current=null] : ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleStopProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPoST.g:2339:2: ( ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalPoST.g:2340:2: ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalPoST.g:2340:2: ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalPoST.g:2341:3: () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalPoST.g:2341:3: ()
            // InternalPoST.g:2342:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStopProcessStatementAccess().getStopProcessStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,67,FOLLOW_45); 

            			newLeafNode(otherlv_1, grammarAccess.getStopProcessStatementAccess().getSTOPKeyword_1());
            		
            // InternalPoST.g:2352:3: (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==52) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalPoST.g:2353:4: otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getStopProcessStatementAccess().getPROCESSKeyword_2_0());
                    			
                    // InternalPoST.g:2357:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:2358:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:2358:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:2359:6: otherlv_3= RULE_ID
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
    // InternalPoST.g:2375:1: entryRuleErrorProcessStatement returns [EObject current=null] : iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF ;
    public final EObject entryRuleErrorProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorProcessStatement = null;


        try {
            // InternalPoST.g:2375:62: (iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF )
            // InternalPoST.g:2376:2: iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF
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
    // InternalPoST.g:2382:1: ruleErrorProcessStatement returns [EObject current=null] : ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleErrorProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPoST.g:2388:2: ( ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalPoST.g:2389:2: ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalPoST.g:2389:2: ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalPoST.g:2390:3: () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalPoST.g:2390:3: ()
            // InternalPoST.g:2391:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getErrorProcessStatementAccess().getErrorProcessStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,68,FOLLOW_45); 

            			newLeafNode(otherlv_1, grammarAccess.getErrorProcessStatementAccess().getERRORKeyword_1());
            		
            // InternalPoST.g:2401:3: (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==52) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalPoST.g:2402:4: otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getErrorProcessStatementAccess().getPROCESSKeyword_2_0());
                    			
                    // InternalPoST.g:2406:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:2407:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:2407:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:2408:6: otherlv_3= RULE_ID
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
    // InternalPoST.g:2424:1: entryRuleTimeoutStatement returns [EObject current=null] : iv_ruleTimeoutStatement= ruleTimeoutStatement EOF ;
    public final EObject entryRuleTimeoutStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutStatement = null;


        try {
            // InternalPoST.g:2424:57: (iv_ruleTimeoutStatement= ruleTimeoutStatement EOF )
            // InternalPoST.g:2425:2: iv_ruleTimeoutStatement= ruleTimeoutStatement EOF
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
    // InternalPoST.g:2431:1: ruleTimeoutStatement returns [EObject current=null] : (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' ) ;
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
            // InternalPoST.g:2437:2: ( (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' ) )
            // InternalPoST.g:2438:2: (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' )
            {
            // InternalPoST.g:2438:2: (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' )
            // InternalPoST.g:2439:3: otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeoutStatementAccess().getTIMEOUTKeyword_0());
            		
            // InternalPoST.g:2443:3: ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_INTEGER||LA34_0==RULE_TIME_PREF_LITERAL||(LA34_0>=RULE_REAL_TYPE_NAME && LA34_0<=RULE_REAL)||LA34_0==112) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_ID) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalPoST.g:2444:4: ( (lv_const_1_0= ruleConstant ) )
                    {
                    // InternalPoST.g:2444:4: ( (lv_const_1_0= ruleConstant ) )
                    // InternalPoST.g:2445:5: (lv_const_1_0= ruleConstant )
                    {
                    // InternalPoST.g:2445:5: (lv_const_1_0= ruleConstant )
                    // InternalPoST.g:2446:6: lv_const_1_0= ruleConstant
                    {

                    						newCompositeNode(grammarAccess.getTimeoutStatementAccess().getConstConstantParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_46);
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
                    // InternalPoST.g:2464:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalPoST.g:2464:4: ( (otherlv_2= RULE_ID ) )
                    // InternalPoST.g:2465:5: (otherlv_2= RULE_ID )
                    {
                    // InternalPoST.g:2465:5: (otherlv_2= RULE_ID )
                    // InternalPoST.g:2466:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeoutStatementRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_46); 

                    						newLeafNode(otherlv_2, grammarAccess.getTimeoutStatementAccess().getVariableSymbolicVariableCrossReference_1_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,72,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getTimeoutStatementAccess().getTHENKeyword_2());
            		
            // InternalPoST.g:2482:3: ( (lv_statement_4_0= ruleStatementList ) )
            // InternalPoST.g:2483:4: (lv_statement_4_0= ruleStatementList )
            {
            // InternalPoST.g:2483:4: (lv_statement_4_0= ruleStatementList )
            // InternalPoST.g:2484:5: lv_statement_4_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getTimeoutStatementAccess().getStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_48);
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

            otherlv_5=(Token)match(input,73,FOLLOW_2); 

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
    // InternalPoST.g:2509:1: entryRuleResetTimerStatement returns [EObject current=null] : iv_ruleResetTimerStatement= ruleResetTimerStatement EOF ;
    public final EObject entryRuleResetTimerStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetTimerStatement = null;


        try {
            // InternalPoST.g:2509:60: (iv_ruleResetTimerStatement= ruleResetTimerStatement EOF )
            // InternalPoST.g:2510:2: iv_ruleResetTimerStatement= ruleResetTimerStatement EOF
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
    // InternalPoST.g:2516:1: ruleResetTimerStatement returns [EObject current=null] : ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' ) ;
    public final EObject ruleResetTimerStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalPoST.g:2522:2: ( ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' ) )
            // InternalPoST.g:2523:2: ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' )
            {
            // InternalPoST.g:2523:2: ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' )
            // InternalPoST.g:2524:3: () otherlv_1= 'RESET' otherlv_2= 'TIMER'
            {
            // InternalPoST.g:2524:3: ()
            // InternalPoST.g:2525:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getResetTimerStatementAccess().getResetTimerStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,74,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getResetTimerStatementAccess().getRESETKeyword_1());
            		
            otherlv_2=(Token)match(input,75,FOLLOW_2); 

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


    // $ANTLR start "entryRuleFunctionCall"
    // InternalPoST.g:2543:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalPoST.g:2543:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalPoST.g:2544:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
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
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalPoST.g:2550:1: ruleFunctionCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleFunctionCallElements ) ) otherlv_3= ')' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_args_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2556:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleFunctionCallElements ) ) otherlv_3= ')' ) )
            // InternalPoST.g:2557:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleFunctionCallElements ) ) otherlv_3= ')' )
            {
            // InternalPoST.g:2557:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleFunctionCallElements ) ) otherlv_3= ')' )
            // InternalPoST.g:2558:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleFunctionCallElements ) ) otherlv_3= ')'
            {
            // InternalPoST.g:2558:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:2559:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:2559:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:2560:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionCallRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_0, grammarAccess.getFunctionCallAccess().getFunctionFunctionCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,45,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalPoST.g:2575:3: ( (lv_args_2_0= ruleFunctionCallElements ) )
            // InternalPoST.g:2576:4: (lv_args_2_0= ruleFunctionCallElements )
            {
            // InternalPoST.g:2576:4: (lv_args_2_0= ruleFunctionCallElements )
            // InternalPoST.g:2577:5: lv_args_2_0= ruleFunctionCallElements
            {

            					newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsFunctionCallElementsParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_13);
            lv_args_2_0=ruleFunctionCallElements();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionCallRule());
            					}
            					set(
            						current,
            						"args",
            						lv_args_2_0,
            						"su.nsk.iae.post.PoST.FunctionCallElements");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,46,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleFunctionCallElements"
    // InternalPoST.g:2602:1: entryRuleFunctionCallElements returns [EObject current=null] : iv_ruleFunctionCallElements= ruleFunctionCallElements EOF ;
    public final EObject entryRuleFunctionCallElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCallElements = null;


        try {
            // InternalPoST.g:2602:61: (iv_ruleFunctionCallElements= ruleFunctionCallElements EOF )
            // InternalPoST.g:2603:2: iv_ruleFunctionCallElements= ruleFunctionCallElements EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallElementsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCallElements=ruleFunctionCallElements();

            state._fsp--;

             current =iv_ruleFunctionCallElements; 
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
    // $ANTLR end "entryRuleFunctionCallElements"


    // $ANTLR start "ruleFunctionCallElements"
    // InternalPoST.g:2609:1: ruleFunctionCallElements returns [EObject current=null] : ( ( (lv_elements_0_0= ruleParamAssignment ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleParamAssignment ) ) )* ) ;
    public final EObject ruleFunctionCallElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2615:2: ( ( ( (lv_elements_0_0= ruleParamAssignment ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleParamAssignment ) ) )* ) )
            // InternalPoST.g:2616:2: ( ( (lv_elements_0_0= ruleParamAssignment ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleParamAssignment ) ) )* )
            {
            // InternalPoST.g:2616:2: ( ( (lv_elements_0_0= ruleParamAssignment ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleParamAssignment ) ) )* )
            // InternalPoST.g:2617:3: ( (lv_elements_0_0= ruleParamAssignment ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleParamAssignment ) ) )*
            {
            // InternalPoST.g:2617:3: ( (lv_elements_0_0= ruleParamAssignment ) )
            // InternalPoST.g:2618:4: (lv_elements_0_0= ruleParamAssignment )
            {
            // InternalPoST.g:2618:4: (lv_elements_0_0= ruleParamAssignment )
            // InternalPoST.g:2619:5: lv_elements_0_0= ruleParamAssignment
            {

            					newCompositeNode(grammarAccess.getFunctionCallElementsAccess().getElementsParamAssignmentParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_elements_0_0=ruleParamAssignment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionCallElementsRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_0_0,
            						"su.nsk.iae.post.PoST.ParamAssignment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:2636:3: (otherlv_1= ',' ( (lv_elements_2_0= ruleParamAssignment ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==48) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalPoST.g:2637:4: otherlv_1= ',' ( (lv_elements_2_0= ruleParamAssignment ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getFunctionCallElementsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:2641:4: ( (lv_elements_2_0= ruleParamAssignment ) )
            	    // InternalPoST.g:2642:5: (lv_elements_2_0= ruleParamAssignment )
            	    {
            	    // InternalPoST.g:2642:5: (lv_elements_2_0= ruleParamAssignment )
            	    // InternalPoST.g:2643:6: lv_elements_2_0= ruleParamAssignment
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionCallElementsAccess().getElementsParamAssignmentParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_elements_2_0=ruleParamAssignment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFunctionCallElementsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_2_0,
            	    							"su.nsk.iae.post.PoST.ParamAssignment");
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
    // $ANTLR end "ruleFunctionCallElements"


    // $ANTLR start "entryRuleParamAssignment"
    // InternalPoST.g:2665:1: entryRuleParamAssignment returns [EObject current=null] : iv_ruleParamAssignment= ruleParamAssignment EOF ;
    public final EObject entryRuleParamAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamAssignment = null;


        try {
            // InternalPoST.g:2665:56: (iv_ruleParamAssignment= ruleParamAssignment EOF )
            // InternalPoST.g:2666:2: iv_ruleParamAssignment= ruleParamAssignment EOF
            {
             newCompositeNode(grammarAccess.getParamAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParamAssignment=ruleParamAssignment();

            state._fsp--;

             current =iv_ruleParamAssignment; 
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
    // $ANTLR end "entryRuleParamAssignment"


    // $ANTLR start "ruleParamAssignment"
    // InternalPoST.g:2672:1: ruleParamAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleParamAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_assig_1_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2678:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalPoST.g:2679:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalPoST.g:2679:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( (lv_value_2_0= ruleExpression ) ) )
            // InternalPoST.g:2680:3: ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalPoST.g:2680:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:2681:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:2681:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:2682:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParamAssignmentRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_0, grammarAccess.getParamAssignmentAccess().getVariableSymbolicVariableCrossReference_0_0());
            				

            }


            }

            // InternalPoST.g:2693:3: ( (lv_assig_1_0= ruleAssignmentType ) )
            // InternalPoST.g:2694:4: (lv_assig_1_0= ruleAssignmentType )
            {
            // InternalPoST.g:2694:4: (lv_assig_1_0= ruleAssignmentType )
            // InternalPoST.g:2695:5: lv_assig_1_0= ruleAssignmentType
            {

            					newCompositeNode(grammarAccess.getParamAssignmentAccess().getAssigAssignmentTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_50);
            lv_assig_1_0=ruleAssignmentType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParamAssignmentRule());
            					}
            					set(
            						current,
            						"assig",
            						lv_assig_1_0,
            						"su.nsk.iae.post.PoST.AssignmentType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:2712:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalPoST.g:2713:4: (lv_value_2_0= ruleExpression )
            {
            // InternalPoST.g:2713:4: (lv_value_2_0= ruleExpression )
            // InternalPoST.g:2714:5: lv_value_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getParamAssignmentAccess().getValueExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParamAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
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
    // $ANTLR end "ruleParamAssignment"


    // $ANTLR start "entryRuleExpression"
    // InternalPoST.g:2735:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalPoST.g:2735:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalPoST.g:2736:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalPoST.g:2742:1: ruleExpression returns [EObject current=null] : (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token this_OR_OPERATOR_2=null;
        EObject this_XorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2748:2: ( (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* ) )
            // InternalPoST.g:2749:2: (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* )
            {
            // InternalPoST.g:2749:2: (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* )
            // InternalPoST.g:2750:3: this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getExpressionAccess().getXorExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_51);
            this_XorExpression_0=ruleXorExpression();

            state._fsp--;


            			current = this_XorExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2758:3: ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_OR_OPERATOR) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalPoST.g:2759:4: () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) )
            	    {
            	    // InternalPoST.g:2759:4: ()
            	    // InternalPoST.g:2760:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getExpressionAccess().getExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_OR_OPERATOR_2=(Token)match(input,RULE_OR_OPERATOR,FOLLOW_50); 

            	    				newLeafNode(this_OR_OPERATOR_2, grammarAccess.getExpressionAccess().getOR_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2770:4: ( (lv_right_3_0= ruleXorExpression ) )
            	    // InternalPoST.g:2771:5: (lv_right_3_0= ruleXorExpression )
            	    {
            	    // InternalPoST.g:2771:5: (lv_right_3_0= ruleXorExpression )
            	    // InternalPoST.g:2772:6: lv_right_3_0= ruleXorExpression
            	    {

            	    						newCompositeNode(grammarAccess.getExpressionAccess().getRightXorExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_51);
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleXorExpression"
    // InternalPoST.g:2794:1: entryRuleXorExpression returns [EObject current=null] : iv_ruleXorExpression= ruleXorExpression EOF ;
    public final EObject entryRuleXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpression = null;


        try {
            // InternalPoST.g:2794:54: (iv_ruleXorExpression= ruleXorExpression EOF )
            // InternalPoST.g:2795:2: iv_ruleXorExpression= ruleXorExpression EOF
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
    // InternalPoST.g:2801:1: ruleXorExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_XOR_OPERATOR_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2807:2: ( (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalPoST.g:2808:2: (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPoST.g:2808:2: (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalPoST.g:2809:3: this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_52);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2817:3: ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_XOR_OPERATOR) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalPoST.g:2818:4: () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalPoST.g:2818:4: ()
            	    // InternalPoST.g:2819:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorExpressionAccess().getXorExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_XOR_OPERATOR_2=(Token)match(input,RULE_XOR_OPERATOR,FOLLOW_50); 

            	    				newLeafNode(this_XOR_OPERATOR_2, grammarAccess.getXorExpressionAccess().getXOR_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2829:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalPoST.g:2830:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalPoST.g:2830:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalPoST.g:2831:6: lv_right_3_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_52);
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
    // $ANTLR end "ruleXorExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalPoST.g:2853:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPoST.g:2853:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPoST.g:2854:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalPoST.g:2860:1: ruleAndExpression returns [EObject current=null] : (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_AND_OPERATOR_2=null;
        EObject this_CompExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2866:2: ( (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* ) )
            // InternalPoST.g:2867:2: (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* )
            {
            // InternalPoST.g:2867:2: (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* )
            // InternalPoST.g:2868:3: this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getCompExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_53);
            this_CompExpression_0=ruleCompExpression();

            state._fsp--;


            			current = this_CompExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2876:3: ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_AND_OPERATOR) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalPoST.g:2877:4: () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) )
            	    {
            	    // InternalPoST.g:2877:4: ()
            	    // InternalPoST.g:2878:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_AND_OPERATOR_2=(Token)match(input,RULE_AND_OPERATOR,FOLLOW_50); 

            	    				newLeafNode(this_AND_OPERATOR_2, grammarAccess.getAndExpressionAccess().getAND_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2888:4: ( (lv_right_3_0= ruleCompExpression ) )
            	    // InternalPoST.g:2889:5: (lv_right_3_0= ruleCompExpression )
            	    {
            	    // InternalPoST.g:2889:5: (lv_right_3_0= ruleCompExpression )
            	    // InternalPoST.g:2890:6: lv_right_3_0= ruleCompExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightCompExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_53);
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleCompExpression"
    // InternalPoST.g:2912:1: entryRuleCompExpression returns [EObject current=null] : iv_ruleCompExpression= ruleCompExpression EOF ;
    public final EObject entryRuleCompExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompExpression = null;


        try {
            // InternalPoST.g:2912:55: (iv_ruleCompExpression= ruleCompExpression EOF )
            // InternalPoST.g:2913:2: iv_ruleCompExpression= ruleCompExpression EOF
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
    // InternalPoST.g:2919:1: ruleCompExpression returns [EObject current=null] : (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* ) ;
    public final EObject ruleCompExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EquExpression_0 = null;

        Enumerator lv_compOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2925:2: ( (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* ) )
            // InternalPoST.g:2926:2: (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* )
            {
            // InternalPoST.g:2926:2: (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* )
            // InternalPoST.g:2927:3: this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getCompExpressionAccess().getEquExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_EquExpression_0=ruleEquExpression();

            state._fsp--;


            			current = this_EquExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2935:3: ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=114 && LA39_0<=115)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalPoST.g:2936:4: () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) )
            	    {
            	    // InternalPoST.g:2936:4: ()
            	    // InternalPoST.g:2937:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getCompExpressionAccess().getCompExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2943:4: ( (lv_compOp_2_0= ruleCompOperator ) )
            	    // InternalPoST.g:2944:5: (lv_compOp_2_0= ruleCompOperator )
            	    {
            	    // InternalPoST.g:2944:5: (lv_compOp_2_0= ruleCompOperator )
            	    // InternalPoST.g:2945:6: lv_compOp_2_0= ruleCompOperator
            	    {

            	    						newCompositeNode(grammarAccess.getCompExpressionAccess().getCompOpCompOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
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

            	    // InternalPoST.g:2962:4: ( (lv_right_3_0= ruleEquExpression ) )
            	    // InternalPoST.g:2963:5: (lv_right_3_0= ruleEquExpression )
            	    {
            	    // InternalPoST.g:2963:5: (lv_right_3_0= ruleEquExpression )
            	    // InternalPoST.g:2964:6: lv_right_3_0= ruleEquExpression
            	    {

            	    						newCompositeNode(grammarAccess.getCompExpressionAccess().getRightEquExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_54);
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
    // $ANTLR end "ruleCompExpression"


    // $ANTLR start "entryRuleEquExpression"
    // InternalPoST.g:2986:1: entryRuleEquExpression returns [EObject current=null] : iv_ruleEquExpression= ruleEquExpression EOF ;
    public final EObject entryRuleEquExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquExpression = null;


        try {
            // InternalPoST.g:2986:54: (iv_ruleEquExpression= ruleEquExpression EOF )
            // InternalPoST.g:2987:2: iv_ruleEquExpression= ruleEquExpression EOF
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
    // InternalPoST.g:2993:1: ruleEquExpression returns [EObject current=null] : (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* ) ;
    public final EObject ruleEquExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AddExpression_0 = null;

        Enumerator lv_equOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2999:2: ( (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* ) )
            // InternalPoST.g:3000:2: (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* )
            {
            // InternalPoST.g:3000:2: (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* )
            // InternalPoST.g:3001:3: this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getEquExpressionAccess().getAddExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_55);
            this_AddExpression_0=ruleAddExpression();

            state._fsp--;


            			current = this_AddExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:3009:3: ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=116 && LA40_0<=119)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalPoST.g:3010:4: () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) )
            	    {
            	    // InternalPoST.g:3010:4: ()
            	    // InternalPoST.g:3011:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEquExpressionAccess().getEquExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:3017:4: ( (lv_equOp_2_0= ruleEquOperator ) )
            	    // InternalPoST.g:3018:5: (lv_equOp_2_0= ruleEquOperator )
            	    {
            	    // InternalPoST.g:3018:5: (lv_equOp_2_0= ruleEquOperator )
            	    // InternalPoST.g:3019:6: lv_equOp_2_0= ruleEquOperator
            	    {

            	    						newCompositeNode(grammarAccess.getEquExpressionAccess().getEquOpEquOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
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

            	    // InternalPoST.g:3036:4: ( (lv_right_3_0= ruleAddExpression ) )
            	    // InternalPoST.g:3037:5: (lv_right_3_0= ruleAddExpression )
            	    {
            	    // InternalPoST.g:3037:5: (lv_right_3_0= ruleAddExpression )
            	    // InternalPoST.g:3038:6: lv_right_3_0= ruleAddExpression
            	    {

            	    						newCompositeNode(grammarAccess.getEquExpressionAccess().getRightAddExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_55);
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
    // $ANTLR end "ruleEquExpression"


    // $ANTLR start "entryRuleAddExpression"
    // InternalPoST.g:3060:1: entryRuleAddExpression returns [EObject current=null] : iv_ruleAddExpression= ruleAddExpression EOF ;
    public final EObject entryRuleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddExpression = null;


        try {
            // InternalPoST.g:3060:54: (iv_ruleAddExpression= ruleAddExpression EOF )
            // InternalPoST.g:3061:2: iv_ruleAddExpression= ruleAddExpression EOF
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
    // InternalPoST.g:3067:1: ruleAddExpression returns [EObject current=null] : (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* ) ;
    public final EObject ruleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MulExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3073:2: ( (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* ) )
            // InternalPoST.g:3074:2: (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* )
            {
            // InternalPoST.g:3074:2: (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* )
            // InternalPoST.g:3075:3: this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAddExpressionAccess().getMulExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_56);
            this_MulExpression_0=ruleMulExpression();

            state._fsp--;


            			current = this_MulExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:3083:3: ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==112||LA41_0==120) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalPoST.g:3084:4: () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) )
            	    {
            	    // InternalPoST.g:3084:4: ()
            	    // InternalPoST.g:3085:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAddExpressionAccess().getAddExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:3091:4: ( (lv_addOp_2_0= ruleAddOperator ) )
            	    // InternalPoST.g:3092:5: (lv_addOp_2_0= ruleAddOperator )
            	    {
            	    // InternalPoST.g:3092:5: (lv_addOp_2_0= ruleAddOperator )
            	    // InternalPoST.g:3093:6: lv_addOp_2_0= ruleAddOperator
            	    {

            	    						newCompositeNode(grammarAccess.getAddExpressionAccess().getAddOpAddOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
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

            	    // InternalPoST.g:3110:4: ( (lv_right_3_0= ruleMulExpression ) )
            	    // InternalPoST.g:3111:5: (lv_right_3_0= ruleMulExpression )
            	    {
            	    // InternalPoST.g:3111:5: (lv_right_3_0= ruleMulExpression )
            	    // InternalPoST.g:3112:6: lv_right_3_0= ruleMulExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAddExpressionAccess().getRightMulExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_56);
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
            	    break loop41;
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
    // InternalPoST.g:3134:1: entryRuleMulExpression returns [EObject current=null] : iv_ruleMulExpression= ruleMulExpression EOF ;
    public final EObject entryRuleMulExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMulExpression = null;


        try {
            // InternalPoST.g:3134:54: (iv_ruleMulExpression= ruleMulExpression EOF )
            // InternalPoST.g:3135:2: iv_ruleMulExpression= ruleMulExpression EOF
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
    // InternalPoST.g:3141:1: ruleMulExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) ;
    public final EObject ruleMulExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3147:2: ( (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) )
            // InternalPoST.g:3148:2: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            {
            // InternalPoST.g:3148:2: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            // InternalPoST.g:3149:3: this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMulExpressionAccess().getPowerExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_57);
            this_PowerExpression_0=rulePowerExpression();

            state._fsp--;


            			current = this_PowerExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:3157:3: ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==109||(LA42_0>=121 && LA42_0<=122)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalPoST.g:3158:4: () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) )
            	    {
            	    // InternalPoST.g:3158:4: ()
            	    // InternalPoST.g:3159:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getMulExpressionAccess().getMulExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:3165:4: ( (lv_mulOp_2_0= ruleMulOperator ) )
            	    // InternalPoST.g:3166:5: (lv_mulOp_2_0= ruleMulOperator )
            	    {
            	    // InternalPoST.g:3166:5: (lv_mulOp_2_0= ruleMulOperator )
            	    // InternalPoST.g:3167:6: lv_mulOp_2_0= ruleMulOperator
            	    {

            	    						newCompositeNode(grammarAccess.getMulExpressionAccess().getMulOpMulOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
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

            	    // InternalPoST.g:3184:4: ( (lv_right_3_0= rulePowerExpression ) )
            	    // InternalPoST.g:3185:5: (lv_right_3_0= rulePowerExpression )
            	    {
            	    // InternalPoST.g:3185:5: (lv_right_3_0= rulePowerExpression )
            	    // InternalPoST.g:3186:6: lv_right_3_0= rulePowerExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMulExpressionAccess().getRightPowerExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_57);
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
            	    break loop42;
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
    // InternalPoST.g:3208:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // InternalPoST.g:3208:56: (iv_rulePowerExpression= rulePowerExpression EOF )
            // InternalPoST.g:3209:2: iv_rulePowerExpression= rulePowerExpression EOF
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
    // InternalPoST.g:3215:1: rulePowerExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        Token this_POWER_OPERATOR_2=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3221:2: ( (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) )
            // InternalPoST.g:3222:2: (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            {
            // InternalPoST.g:3222:2: (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            // InternalPoST.g:3223:3: this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_58);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;


            			current = this_UnaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:3231:3: ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_POWER_OPERATOR) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalPoST.g:3232:4: () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) )
            	    {
            	    // InternalPoST.g:3232:4: ()
            	    // InternalPoST.g:3233:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPowerExpressionAccess().getPowerExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_POWER_OPERATOR_2=(Token)match(input,RULE_POWER_OPERATOR,FOLLOW_50); 

            	    				newLeafNode(this_POWER_OPERATOR_2, grammarAccess.getPowerExpressionAccess().getPOWER_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:3243:4: ( (lv_right_3_0= ruleUnaryExpression ) )
            	    // InternalPoST.g:3244:5: (lv_right_3_0= ruleUnaryExpression )
            	    {
            	    // InternalPoST.g:3244:5: (lv_right_3_0= ruleUnaryExpression )
            	    // InternalPoST.g:3245:6: lv_right_3_0= ruleUnaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getPowerExpressionAccess().getRightUnaryExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_58);
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
    // $ANTLR end "rulePowerExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalPoST.g:3267:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPoST.g:3267:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPoST.g:3268:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalPoST.g:3274:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_unOp_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3280:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) ) )
            // InternalPoST.g:3281:2: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) )
            {
            // InternalPoST.g:3281:2: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) )
            int alt44=2;
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
                alt44=1;
                }
                break;
            case 112:
                {
                switch ( input.LA(2) ) {
                case RULE_INTEGER:
                    {
                    alt44=1;
                    }
                    break;
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
                case 112:
                    {
                    alt44=2;
                    }
                    break;
                case RULE_REAL:
                    {
                    alt44=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;
                }

                }
                break;
            case 123:
                {
                alt44=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalPoST.g:3282:3: this_PrimaryExpression_0= rulePrimaryExpression
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
                    // InternalPoST.g:3291:3: ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) )
                    {
                    // InternalPoST.g:3291:3: ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) )
                    // InternalPoST.g:3292:4: ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) )
                    {
                    // InternalPoST.g:3292:4: ( (lv_unOp_1_0= ruleUnaryOperator ) )
                    // InternalPoST.g:3293:5: (lv_unOp_1_0= ruleUnaryOperator )
                    {
                    // InternalPoST.g:3293:5: (lv_unOp_1_0= ruleUnaryOperator )
                    // InternalPoST.g:3294:6: lv_unOp_1_0= ruleUnaryOperator
                    {

                    						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnOpUnaryOperatorEnumRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_59);
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

                    // InternalPoST.g:3311:4: ( (lv_right_2_0= rulePrimaryExpression ) )
                    // InternalPoST.g:3312:5: (lv_right_2_0= rulePrimaryExpression )
                    {
                    // InternalPoST.g:3312:5: (lv_right_2_0= rulePrimaryExpression )
                    // InternalPoST.g:3313:6: lv_right_2_0= rulePrimaryExpression
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
    // InternalPoST.g:3335:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPoST.g:3335:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPoST.g:3336:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalPoST.g:3342:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | ( (lv_funCall_4_0= ruleFunctionCall ) ) | (otherlv_5= '(' ( (lv_nestExpr_6_0= ruleExpression ) ) otherlv_7= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_const_0_0 = null;

        EObject lv_array_2_0 = null;

        EObject lv_procStatus_3_0 = null;

        EObject lv_funCall_4_0 = null;

        EObject lv_nestExpr_6_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3348:2: ( ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | ( (lv_funCall_4_0= ruleFunctionCall ) ) | (otherlv_5= '(' ( (lv_nestExpr_6_0= ruleExpression ) ) otherlv_7= ')' ) ) )
            // InternalPoST.g:3349:2: ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | ( (lv_funCall_4_0= ruleFunctionCall ) ) | (otherlv_5= '(' ( (lv_nestExpr_6_0= ruleExpression ) ) otherlv_7= ')' ) )
            {
            // InternalPoST.g:3349:2: ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | ( (lv_funCall_4_0= ruleFunctionCall ) ) | (otherlv_5= '(' ( (lv_nestExpr_6_0= ruleExpression ) ) otherlv_7= ')' ) )
            int alt45=6;
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
            case 112:
                {
                alt45=1;
                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case EOF:
                case RULE_OR_OPERATOR:
                case RULE_XOR_OPERATOR:
                case RULE_AND_OPERATOR:
                case RULE_POWER_OPERATOR:
                case 43:
                case 46:
                case 48:
                case 72:
                case 81:
                case 84:
                case 86:
                case 87:
                case 92:
                case 107:
                case 109:
                case 110:
                case 112:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                    {
                    alt45=2;
                    }
                    break;
                case 106:
                    {
                    alt45=3;
                    }
                    break;
                case 45:
                    {
                    alt45=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 2, input);

                    throw nvae;
                }

                }
                break;
            case 52:
                {
                alt45=4;
                }
                break;
            case 45:
                {
                alt45=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalPoST.g:3350:3: ( (lv_const_0_0= ruleConstant ) )
                    {
                    // InternalPoST.g:3350:3: ( (lv_const_0_0= ruleConstant ) )
                    // InternalPoST.g:3351:4: (lv_const_0_0= ruleConstant )
                    {
                    // InternalPoST.g:3351:4: (lv_const_0_0= ruleConstant )
                    // InternalPoST.g:3352:5: lv_const_0_0= ruleConstant
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
                    // InternalPoST.g:3370:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalPoST.g:3370:3: ( (otherlv_1= RULE_ID ) )
                    // InternalPoST.g:3371:4: (otherlv_1= RULE_ID )
                    {
                    // InternalPoST.g:3371:4: (otherlv_1= RULE_ID )
                    // InternalPoST.g:3372:5: otherlv_1= RULE_ID
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
                    // InternalPoST.g:3384:3: ( (lv_array_2_0= ruleArrayVariable ) )
                    {
                    // InternalPoST.g:3384:3: ( (lv_array_2_0= ruleArrayVariable ) )
                    // InternalPoST.g:3385:4: (lv_array_2_0= ruleArrayVariable )
                    {
                    // InternalPoST.g:3385:4: (lv_array_2_0= ruleArrayVariable )
                    // InternalPoST.g:3386:5: lv_array_2_0= ruleArrayVariable
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
                    // InternalPoST.g:3404:3: ( (lv_procStatus_3_0= ruleProcessStatusExpression ) )
                    {
                    // InternalPoST.g:3404:3: ( (lv_procStatus_3_0= ruleProcessStatusExpression ) )
                    // InternalPoST.g:3405:4: (lv_procStatus_3_0= ruleProcessStatusExpression )
                    {
                    // InternalPoST.g:3405:4: (lv_procStatus_3_0= ruleProcessStatusExpression )
                    // InternalPoST.g:3406:5: lv_procStatus_3_0= ruleProcessStatusExpression
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
                    // InternalPoST.g:3424:3: ( (lv_funCall_4_0= ruleFunctionCall ) )
                    {
                    // InternalPoST.g:3424:3: ( (lv_funCall_4_0= ruleFunctionCall ) )
                    // InternalPoST.g:3425:4: (lv_funCall_4_0= ruleFunctionCall )
                    {
                    // InternalPoST.g:3425:4: (lv_funCall_4_0= ruleFunctionCall )
                    // InternalPoST.g:3426:5: lv_funCall_4_0= ruleFunctionCall
                    {

                    					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunCallFunctionCallParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_funCall_4_0=ruleFunctionCall();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    					}
                    					set(
                    						current,
                    						"funCall",
                    						lv_funCall_4_0,
                    						"su.nsk.iae.post.PoST.FunctionCall");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalPoST.g:3444:3: (otherlv_5= '(' ( (lv_nestExpr_6_0= ruleExpression ) ) otherlv_7= ')' )
                    {
                    // InternalPoST.g:3444:3: (otherlv_5= '(' ( (lv_nestExpr_6_0= ruleExpression ) ) otherlv_7= ')' )
                    // InternalPoST.g:3445:4: otherlv_5= '(' ( (lv_nestExpr_6_0= ruleExpression ) ) otherlv_7= ')'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_50); 

                    				newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_5_0());
                    			
                    // InternalPoST.g:3449:4: ( (lv_nestExpr_6_0= ruleExpression ) )
                    // InternalPoST.g:3450:5: (lv_nestExpr_6_0= ruleExpression )
                    {
                    // InternalPoST.g:3450:5: (lv_nestExpr_6_0= ruleExpression )
                    // InternalPoST.g:3451:6: lv_nestExpr_6_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNestExprExpressionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_nestExpr_6_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"nestExpr",
                    							lv_nestExpr_6_0,
                    							"su.nsk.iae.post.PoST.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,46,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_5_2());
                    			

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
    // InternalPoST.g:3477:1: entryRuleStatementList returns [EObject current=null] : iv_ruleStatementList= ruleStatementList EOF ;
    public final EObject entryRuleStatementList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementList = null;


        try {
            // InternalPoST.g:3477:54: (iv_ruleStatementList= ruleStatementList EOF )
            // InternalPoST.g:3478:2: iv_ruleStatementList= ruleStatementList EOF
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
    // InternalPoST.g:3484:1: ruleStatementList returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleStatementList() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3490:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalPoST.g:3491:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalPoST.g:3491:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalPoST.g:3492:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalPoST.g:3492:3: ()
            // InternalPoST.g:3493:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStatementListAccess().getStatementListAction_0(),
            					current);
            			

            }

            // InternalPoST.g:3499:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID||LA46_0==63||(LA46_0>=67 && LA46_0<=70)||LA46_0==74||LA46_0==76||LA46_0==80||LA46_0==83||LA46_0==88||LA46_0==90||(LA46_0>=93 && LA46_0<=94)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalPoST.g:3500:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalPoST.g:3500:4: (lv_statements_1_0= ruleStatement )
            	    // InternalPoST.g:3501:5: lv_statements_1_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getStatementListAccess().getStatementsStatementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_60);
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
            	    break loop46;
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
    // InternalPoST.g:3522:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalPoST.g:3522:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalPoST.g:3523:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalPoST.g:3529:1: ruleStatement returns [EObject current=null] : ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) ) ;
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
            // InternalPoST.g:3535:2: ( ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) ) )
            // InternalPoST.g:3536:2: ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) )
            {
            // InternalPoST.g:3536:2: ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) )
            int alt47=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt47=1;
                }
                break;
            case 76:
            case 80:
                {
                alt47=2;
                }
                break;
            case 83:
            case 88:
            case 90:
                {
                alt47=3;
                }
                break;
            case 93:
                {
                alt47=4;
                }
                break;
            case 94:
                {
                alt47=5;
                }
                break;
            case 67:
            case 68:
            case 69:
            case 70:
                {
                alt47=6;
                }
                break;
            case 63:
                {
                alt47=7;
                }
                break;
            case 74:
                {
                alt47=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalPoST.g:3537:3: (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' )
                    {
                    // InternalPoST.g:3537:3: (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' )
                    // InternalPoST.g:3538:4: this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';'
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
                    // InternalPoST.g:3552:3: this_SelectionStatement_2= ruleSelectionStatement
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
                    // InternalPoST.g:3561:3: this_IterationStatement_3= ruleIterationStatement
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
                    // InternalPoST.g:3570:3: (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' )
                    {
                    // InternalPoST.g:3570:3: (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' )
                    // InternalPoST.g:3571:4: this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';'
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
                    // InternalPoST.g:3585:3: (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' )
                    {
                    // InternalPoST.g:3585:3: (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' )
                    // InternalPoST.g:3586:4: this_ExitStatement_6= ruleExitStatement otherlv_7= ';'
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
                    // InternalPoST.g:3600:3: (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' )
                    {
                    // InternalPoST.g:3600:3: (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' )
                    // InternalPoST.g:3601:4: this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';'
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
                    // InternalPoST.g:3615:3: (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' )
                    {
                    // InternalPoST.g:3615:3: (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' )
                    // InternalPoST.g:3616:4: this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';'
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
                    // InternalPoST.g:3630:3: (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' )
                    {
                    // InternalPoST.g:3630:3: (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' )
                    // InternalPoST.g:3631:4: this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';'
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
    // InternalPoST.g:3648:1: entryRuleAssignmentStatement returns [EObject current=null] : iv_ruleAssignmentStatement= ruleAssignmentStatement EOF ;
    public final EObject entryRuleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStatement = null;


        try {
            // InternalPoST.g:3648:60: (iv_ruleAssignmentStatement= ruleAssignmentStatement EOF )
            // InternalPoST.g:3649:2: iv_ruleAssignmentStatement= ruleAssignmentStatement EOF
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
    // InternalPoST.g:3655:1: ruleAssignmentStatement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_array_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3661:2: ( ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalPoST.g:3662:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalPoST.g:3662:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            // InternalPoST.g:3663:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) )
            {
            // InternalPoST.g:3663:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==47) ) {
                    alt48=1;
                }
                else if ( (LA48_1==106) ) {
                    alt48=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalPoST.g:3664:4: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalPoST.g:3664:4: ( (otherlv_0= RULE_ID ) )
                    // InternalPoST.g:3665:5: (otherlv_0= RULE_ID )
                    {
                    // InternalPoST.g:3665:5: (otherlv_0= RULE_ID )
                    // InternalPoST.g:3666:6: otherlv_0= RULE_ID
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
                    // InternalPoST.g:3678:4: ( (lv_array_1_0= ruleArrayVariable ) )
                    {
                    // InternalPoST.g:3678:4: ( (lv_array_1_0= ruleArrayVariable ) )
                    // InternalPoST.g:3679:5: (lv_array_1_0= ruleArrayVariable )
                    {
                    // InternalPoST.g:3679:5: (lv_array_1_0= ruleArrayVariable )
                    // InternalPoST.g:3680:6: lv_array_1_0= ruleArrayVariable
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

            otherlv_2=(Token)match(input,47,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getAssignmentStatementAccess().getColonEqualsSignKeyword_1());
            		
            // InternalPoST.g:3702:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalPoST.g:3703:4: (lv_value_3_0= ruleExpression )
            {
            // InternalPoST.g:3703:4: (lv_value_3_0= ruleExpression )
            // InternalPoST.g:3704:5: lv_value_3_0= ruleExpression
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
    // InternalPoST.g:3725:1: entryRuleSelectionStatement returns [EObject current=null] : iv_ruleSelectionStatement= ruleSelectionStatement EOF ;
    public final EObject entryRuleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionStatement = null;


        try {
            // InternalPoST.g:3725:59: (iv_ruleSelectionStatement= ruleSelectionStatement EOF )
            // InternalPoST.g:3726:2: iv_ruleSelectionStatement= ruleSelectionStatement EOF
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
    // InternalPoST.g:3732:1: ruleSelectionStatement returns [EObject current=null] : (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement ) ;
    public final EObject ruleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_IfStatement_0 = null;

        EObject this_CaseStatement_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:3738:2: ( (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement ) )
            // InternalPoST.g:3739:2: (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement )
            {
            // InternalPoST.g:3739:2: (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==76) ) {
                alt49=1;
            }
            else if ( (LA49_0==80) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalPoST.g:3740:3: this_IfStatement_0= ruleIfStatement
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
                    // InternalPoST.g:3749:3: this_CaseStatement_1= ruleCaseStatement
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
    // InternalPoST.g:3761:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalPoST.g:3761:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalPoST.g:3762:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalPoST.g:3768:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' ) ;
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
            // InternalPoST.g:3774:2: ( (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' ) )
            // InternalPoST.g:3775:2: (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' )
            {
            // InternalPoST.g:3775:2: (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' )
            // InternalPoST.g:3776:3: otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIFKeyword_0());
            		
            // InternalPoST.g:3780:3: ( (lv_mainCond_1_0= ruleExpression ) )
            // InternalPoST.g:3781:4: (lv_mainCond_1_0= ruleExpression )
            {
            // InternalPoST.g:3781:4: (lv_mainCond_1_0= ruleExpression )
            // InternalPoST.g:3782:5: lv_mainCond_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getMainCondExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_46);
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

            otherlv_2=(Token)match(input,72,FOLLOW_61); 

            			newLeafNode(otherlv_2, grammarAccess.getIfStatementAccess().getTHENKeyword_2());
            		
            // InternalPoST.g:3803:3: ( (lv_mainStatement_3_0= ruleStatementList ) )
            // InternalPoST.g:3804:4: (lv_mainStatement_3_0= ruleStatementList )
            {
            // InternalPoST.g:3804:4: (lv_mainStatement_3_0= ruleStatementList )
            // InternalPoST.g:3805:5: lv_mainStatement_3_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getMainStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_62);
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

            // InternalPoST.g:3822:3: (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==77) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalPoST.g:3823:4: otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) )
            	    {
            	    otherlv_4=(Token)match(input,77,FOLLOW_50); 

            	    				newLeafNode(otherlv_4, grammarAccess.getIfStatementAccess().getELSIFKeyword_4_0());
            	    			
            	    // InternalPoST.g:3827:4: ( (lv_elseIfCond_5_0= ruleExpression ) )
            	    // InternalPoST.g:3828:5: (lv_elseIfCond_5_0= ruleExpression )
            	    {
            	    // InternalPoST.g:3828:5: (lv_elseIfCond_5_0= ruleExpression )
            	    // InternalPoST.g:3829:6: lv_elseIfCond_5_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfCondExpressionParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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

            	    otherlv_6=(Token)match(input,72,FOLLOW_61); 

            	    				newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getTHENKeyword_4_2());
            	    			
            	    // InternalPoST.g:3850:4: ( (lv_elseIfStatements_7_0= ruleStatementList ) )
            	    // InternalPoST.g:3851:5: (lv_elseIfStatements_7_0= ruleStatementList )
            	    {
            	    // InternalPoST.g:3851:5: (lv_elseIfStatements_7_0= ruleStatementList )
            	    // InternalPoST.g:3852:6: lv_elseIfStatements_7_0= ruleStatementList
            	    {

            	    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfStatementsStatementListParserRuleCall_4_3_0());
            	    					
            	    pushFollow(FOLLOW_62);
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
            	    break loop50;
                }
            } while (true);

            // InternalPoST.g:3870:3: (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==78) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalPoST.g:3871:4: otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) )
                    {
                    otherlv_8=(Token)match(input,78,FOLLOW_63); 

                    				newLeafNode(otherlv_8, grammarAccess.getIfStatementAccess().getELSEKeyword_5_0());
                    			
                    // InternalPoST.g:3875:4: ( (lv_elseStatement_9_0= ruleStatementList ) )
                    // InternalPoST.g:3876:5: (lv_elseStatement_9_0= ruleStatementList )
                    {
                    // InternalPoST.g:3876:5: (lv_elseStatement_9_0= ruleStatementList )
                    // InternalPoST.g:3877:6: lv_elseStatement_9_0= ruleStatementList
                    {

                    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseStatementStatementListParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_64);
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

            otherlv_10=(Token)match(input,79,FOLLOW_2); 

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
    // InternalPoST.g:3903:1: entryRuleCaseStatement returns [EObject current=null] : iv_ruleCaseStatement= ruleCaseStatement EOF ;
    public final EObject entryRuleCaseStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStatement = null;


        try {
            // InternalPoST.g:3903:54: (iv_ruleCaseStatement= ruleCaseStatement EOF )
            // InternalPoST.g:3904:2: iv_ruleCaseStatement= ruleCaseStatement EOF
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
    // InternalPoST.g:3910:1: ruleCaseStatement returns [EObject current=null] : (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' ) ;
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
            // InternalPoST.g:3916:2: ( (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' ) )
            // InternalPoST.g:3917:2: (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' )
            {
            // InternalPoST.g:3917:2: (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' )
            // InternalPoST.g:3918:3: otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getCaseStatementAccess().getCASEKeyword_0());
            		
            // InternalPoST.g:3922:3: ( (lv_cond_1_0= ruleExpression ) )
            // InternalPoST.g:3923:4: (lv_cond_1_0= ruleExpression )
            {
            // InternalPoST.g:3923:4: (lv_cond_1_0= ruleExpression )
            // InternalPoST.g:3924:5: lv_cond_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getCaseStatementAccess().getCondExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_65);
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

            otherlv_2=(Token)match(input,81,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getCaseStatementAccess().getOFKeyword_2());
            		
            // InternalPoST.g:3945:3: ( (lv_caseElements_3_0= ruleCaseElement ) )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_INTEGER||LA52_0==112) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalPoST.g:3946:4: (lv_caseElements_3_0= ruleCaseElement )
            	    {
            	    // InternalPoST.g:3946:4: (lv_caseElements_3_0= ruleCaseElement )
            	    // InternalPoST.g:3947:5: lv_caseElements_3_0= ruleCaseElement
            	    {

            	    					newCompositeNode(grammarAccess.getCaseStatementAccess().getCaseElementsCaseElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_67);
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
            	    if ( cnt52 >= 1 ) break loop52;
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
            } while (true);

            // InternalPoST.g:3964:3: (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==78) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalPoST.g:3965:4: otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) )
                    {
                    otherlv_4=(Token)match(input,78,FOLLOW_68); 

                    				newLeafNode(otherlv_4, grammarAccess.getCaseStatementAccess().getELSEKeyword_4_0());
                    			
                    // InternalPoST.g:3969:4: ( (lv_elseStatement_5_0= ruleStatementList ) )
                    // InternalPoST.g:3970:5: (lv_elseStatement_5_0= ruleStatementList )
                    {
                    // InternalPoST.g:3970:5: (lv_elseStatement_5_0= ruleStatementList )
                    // InternalPoST.g:3971:6: lv_elseStatement_5_0= ruleStatementList
                    {

                    						newCompositeNode(grammarAccess.getCaseStatementAccess().getElseStatementStatementListParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_69);
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

            otherlv_6=(Token)match(input,82,FOLLOW_2); 

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
    // InternalPoST.g:3997:1: entryRuleCaseElement returns [EObject current=null] : iv_ruleCaseElement= ruleCaseElement EOF ;
    public final EObject entryRuleCaseElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseElement = null;


        try {
            // InternalPoST.g:3997:52: (iv_ruleCaseElement= ruleCaseElement EOF )
            // InternalPoST.g:3998:2: iv_ruleCaseElement= ruleCaseElement EOF
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
    // InternalPoST.g:4004:1: ruleCaseElement returns [EObject current=null] : ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) ) ;
    public final EObject ruleCaseElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_caseList_0_0 = null;

        EObject lv_statement_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4010:2: ( ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) ) )
            // InternalPoST.g:4011:2: ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) )
            {
            // InternalPoST.g:4011:2: ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) )
            // InternalPoST.g:4012:3: ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) )
            {
            // InternalPoST.g:4012:3: ( (lv_caseList_0_0= ruleCaseList ) )
            // InternalPoST.g:4013:4: (lv_caseList_0_0= ruleCaseList )
            {
            // InternalPoST.g:4013:4: (lv_caseList_0_0= ruleCaseList )
            // InternalPoST.g:4014:5: lv_caseList_0_0= ruleCaseList
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

            otherlv_1=(Token)match(input,51,FOLLOW_70); 

            			newLeafNode(otherlv_1, grammarAccess.getCaseElementAccess().getColonKeyword_1());
            		
            // InternalPoST.g:4035:3: ( (lv_statement_2_0= ruleStatementList ) )
            // InternalPoST.g:4036:4: (lv_statement_2_0= ruleStatementList )
            {
            // InternalPoST.g:4036:4: (lv_statement_2_0= ruleStatementList )
            // InternalPoST.g:4037:5: lv_statement_2_0= ruleStatementList
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
    // InternalPoST.g:4058:1: entryRuleCaseList returns [EObject current=null] : iv_ruleCaseList= ruleCaseList EOF ;
    public final EObject entryRuleCaseList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseList = null;


        try {
            // InternalPoST.g:4058:49: (iv_ruleCaseList= ruleCaseList EOF )
            // InternalPoST.g:4059:2: iv_ruleCaseList= ruleCaseList EOF
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
    // InternalPoST.g:4065:1: ruleCaseList returns [EObject current=null] : ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* ) ;
    public final EObject ruleCaseList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_caseListElement_0_0 = null;

        EObject lv_caseListElement_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4071:2: ( ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* ) )
            // InternalPoST.g:4072:2: ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* )
            {
            // InternalPoST.g:4072:2: ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* )
            // InternalPoST.g:4073:3: ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )*
            {
            // InternalPoST.g:4073:3: ( (lv_caseListElement_0_0= ruleSignedInteger ) )
            // InternalPoST.g:4074:4: (lv_caseListElement_0_0= ruleSignedInteger )
            {
            // InternalPoST.g:4074:4: (lv_caseListElement_0_0= ruleSignedInteger )
            // InternalPoST.g:4075:5: lv_caseListElement_0_0= ruleSignedInteger
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

            // InternalPoST.g:4092:3: (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==48) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalPoST.g:4093:4: otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_66); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCaseListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:4097:4: ( (lv_caseListElement_2_0= ruleSignedInteger ) )
            	    // InternalPoST.g:4098:5: (lv_caseListElement_2_0= ruleSignedInteger )
            	    {
            	    // InternalPoST.g:4098:5: (lv_caseListElement_2_0= ruleSignedInteger )
            	    // InternalPoST.g:4099:6: lv_caseListElement_2_0= ruleSignedInteger
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
            	    break loop54;
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
    // InternalPoST.g:4121:1: entryRuleIterationStatement returns [EObject current=null] : iv_ruleIterationStatement= ruleIterationStatement EOF ;
    public final EObject entryRuleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationStatement = null;


        try {
            // InternalPoST.g:4121:59: (iv_ruleIterationStatement= ruleIterationStatement EOF )
            // InternalPoST.g:4122:2: iv_ruleIterationStatement= ruleIterationStatement EOF
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
    // InternalPoST.g:4128:1: ruleIterationStatement returns [EObject current=null] : (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement ) ;
    public final EObject ruleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatement_0 = null;

        EObject this_WhileStatement_1 = null;

        EObject this_RepeatStatement_2 = null;



        	enterRule();

        try {
            // InternalPoST.g:4134:2: ( (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement ) )
            // InternalPoST.g:4135:2: (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement )
            {
            // InternalPoST.g:4135:2: (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt55=1;
                }
                break;
            case 88:
                {
                alt55=2;
                }
                break;
            case 90:
                {
                alt55=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalPoST.g:4136:3: this_ForStatement_0= ruleForStatement
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
                    // InternalPoST.g:4145:3: this_WhileStatement_1= ruleWhileStatement
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
                    // InternalPoST.g:4154:3: this_RepeatStatement_2= ruleRepeatStatement
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
    // InternalPoST.g:4166:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalPoST.g:4166:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalPoST.g:4167:2: iv_ruleForStatement= ruleForStatement EOF
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
    // InternalPoST.g:4173:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' ) ;
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
            // InternalPoST.g:4179:2: ( (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' ) )
            // InternalPoST.g:4180:2: (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' )
            {
            // InternalPoST.g:4180:2: (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' )
            // InternalPoST.g:4181:3: otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getFORKeyword_0());
            		
            // InternalPoST.g:4185:3: ( (otherlv_1= RULE_ID ) )
            // InternalPoST.g:4186:4: (otherlv_1= RULE_ID )
            {
            // InternalPoST.g:4186:4: (otherlv_1= RULE_ID )
            // InternalPoST.g:4187:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getForStatementRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getVariableSymbolicVariableCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,47,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getForStatementAccess().getColonEqualsSignKeyword_2());
            		
            // InternalPoST.g:4202:3: ( (lv_forList_3_0= ruleForList ) )
            // InternalPoST.g:4203:4: (lv_forList_3_0= ruleForList )
            {
            // InternalPoST.g:4203:4: (lv_forList_3_0= ruleForList )
            // InternalPoST.g:4204:5: lv_forList_3_0= ruleForList
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getForListForListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_71);
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

            otherlv_4=(Token)match(input,84,FOLLOW_72); 

            			newLeafNode(otherlv_4, grammarAccess.getForStatementAccess().getDOKeyword_4());
            		
            // InternalPoST.g:4225:3: ( (lv_statement_5_0= ruleStatementList ) )
            // InternalPoST.g:4226:4: (lv_statement_5_0= ruleStatementList )
            {
            // InternalPoST.g:4226:4: (lv_statement_5_0= ruleStatementList )
            // InternalPoST.g:4227:5: lv_statement_5_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getStatementStatementListParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_73);
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

            otherlv_6=(Token)match(input,85,FOLLOW_2); 

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
    // InternalPoST.g:4252:1: entryRuleForList returns [EObject current=null] : iv_ruleForList= ruleForList EOF ;
    public final EObject entryRuleForList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForList = null;


        try {
            // InternalPoST.g:4252:48: (iv_ruleForList= ruleForList EOF )
            // InternalPoST.g:4253:2: iv_ruleForList= ruleForList EOF
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
    // InternalPoST.g:4259:1: ruleForList returns [EObject current=null] : ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleForList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_start_0_0 = null;

        EObject lv_end_2_0 = null;

        EObject lv_step_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4265:2: ( ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? ) )
            // InternalPoST.g:4266:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? )
            {
            // InternalPoST.g:4266:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? )
            // InternalPoST.g:4267:3: ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )?
            {
            // InternalPoST.g:4267:3: ( (lv_start_0_0= ruleExpression ) )
            // InternalPoST.g:4268:4: (lv_start_0_0= ruleExpression )
            {
            // InternalPoST.g:4268:4: (lv_start_0_0= ruleExpression )
            // InternalPoST.g:4269:5: lv_start_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getForListAccess().getStartExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_74);
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

            otherlv_1=(Token)match(input,86,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getForListAccess().getTOKeyword_1());
            		
            // InternalPoST.g:4290:3: ( (lv_end_2_0= ruleExpression ) )
            // InternalPoST.g:4291:4: (lv_end_2_0= ruleExpression )
            {
            // InternalPoST.g:4291:4: (lv_end_2_0= ruleExpression )
            // InternalPoST.g:4292:5: lv_end_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getForListAccess().getEndExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_75);
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

            // InternalPoST.g:4309:3: (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==87) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalPoST.g:4310:4: otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,87,FOLLOW_50); 

                    				newLeafNode(otherlv_3, grammarAccess.getForListAccess().getBYKeyword_3_0());
                    			
                    // InternalPoST.g:4314:4: ( (lv_step_4_0= ruleExpression ) )
                    // InternalPoST.g:4315:5: (lv_step_4_0= ruleExpression )
                    {
                    // InternalPoST.g:4315:5: (lv_step_4_0= ruleExpression )
                    // InternalPoST.g:4316:6: lv_step_4_0= ruleExpression
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
    // InternalPoST.g:4338:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalPoST.g:4338:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalPoST.g:4339:2: iv_ruleWhileStatement= ruleWhileStatement EOF
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
    // InternalPoST.g:4345:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_cond_1_0 = null;

        EObject lv_statement_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4351:2: ( (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' ) )
            // InternalPoST.g:4352:2: (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' )
            {
            // InternalPoST.g:4352:2: (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' )
            // InternalPoST.g:4353:3: otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWHILEKeyword_0());
            		
            // InternalPoST.g:4357:3: ( (lv_cond_1_0= ruleExpression ) )
            // InternalPoST.g:4358:4: (lv_cond_1_0= ruleExpression )
            {
            // InternalPoST.g:4358:4: (lv_cond_1_0= ruleExpression )
            // InternalPoST.g:4359:5: lv_cond_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getCondExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_71);
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

            otherlv_2=(Token)match(input,84,FOLLOW_76); 

            			newLeafNode(otherlv_2, grammarAccess.getWhileStatementAccess().getDOKeyword_2());
            		
            // InternalPoST.g:4380:3: ( (lv_statement_3_0= ruleStatementList ) )
            // InternalPoST.g:4381:4: (lv_statement_3_0= ruleStatementList )
            {
            // InternalPoST.g:4381:4: (lv_statement_3_0= ruleStatementList )
            // InternalPoST.g:4382:5: lv_statement_3_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_77);
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

            otherlv_4=(Token)match(input,89,FOLLOW_2); 

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
    // InternalPoST.g:4407:1: entryRuleRepeatStatement returns [EObject current=null] : iv_ruleRepeatStatement= ruleRepeatStatement EOF ;
    public final EObject entryRuleRepeatStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeatStatement = null;


        try {
            // InternalPoST.g:4407:56: (iv_ruleRepeatStatement= ruleRepeatStatement EOF )
            // InternalPoST.g:4408:2: iv_ruleRepeatStatement= ruleRepeatStatement EOF
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
    // InternalPoST.g:4414:1: ruleRepeatStatement returns [EObject current=null] : (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' ) ;
    public final EObject ruleRepeatStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_statement_1_0 = null;

        EObject lv_cond_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4420:2: ( (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' ) )
            // InternalPoST.g:4421:2: (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' )
            {
            // InternalPoST.g:4421:2: (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' )
            // InternalPoST.g:4422:3: otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT'
            {
            otherlv_0=(Token)match(input,90,FOLLOW_78); 

            			newLeafNode(otherlv_0, grammarAccess.getRepeatStatementAccess().getREPEATKeyword_0());
            		
            // InternalPoST.g:4426:3: ( (lv_statement_1_0= ruleStatementList ) )
            // InternalPoST.g:4427:4: (lv_statement_1_0= ruleStatementList )
            {
            // InternalPoST.g:4427:4: (lv_statement_1_0= ruleStatementList )
            // InternalPoST.g:4428:5: lv_statement_1_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getRepeatStatementAccess().getStatementStatementListParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_79);
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

            otherlv_2=(Token)match(input,91,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getRepeatStatementAccess().getUNTILKeyword_2());
            		
            // InternalPoST.g:4449:3: ( (lv_cond_3_0= ruleExpression ) )
            // InternalPoST.g:4450:4: (lv_cond_3_0= ruleExpression )
            {
            // InternalPoST.g:4450:4: (lv_cond_3_0= ruleExpression )
            // InternalPoST.g:4451:5: lv_cond_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getRepeatStatementAccess().getCondExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_80);
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

            otherlv_4=(Token)match(input,92,FOLLOW_2); 

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
    // InternalPoST.g:4476:1: entryRuleSubprogramControlStatement returns [EObject current=null] : iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF ;
    public final EObject entryRuleSubprogramControlStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubprogramControlStatement = null;


        try {
            // InternalPoST.g:4476:67: (iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF )
            // InternalPoST.g:4477:2: iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF
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
    // InternalPoST.g:4483:1: ruleSubprogramControlStatement returns [EObject current=null] : ( () otherlv_1= 'RETURN' ) ;
    public final EObject ruleSubprogramControlStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPoST.g:4489:2: ( ( () otherlv_1= 'RETURN' ) )
            // InternalPoST.g:4490:2: ( () otherlv_1= 'RETURN' )
            {
            // InternalPoST.g:4490:2: ( () otherlv_1= 'RETURN' )
            // InternalPoST.g:4491:3: () otherlv_1= 'RETURN'
            {
            // InternalPoST.g:4491:3: ()
            // InternalPoST.g:4492:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubprogramControlStatementAccess().getSubprogramControlStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,93,FOLLOW_2); 

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
    // InternalPoST.g:4506:1: entryRuleExitStatement returns [EObject current=null] : iv_ruleExitStatement= ruleExitStatement EOF ;
    public final EObject entryRuleExitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitStatement = null;


        try {
            // InternalPoST.g:4506:54: (iv_ruleExitStatement= ruleExitStatement EOF )
            // InternalPoST.g:4507:2: iv_ruleExitStatement= ruleExitStatement EOF
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
    // InternalPoST.g:4513:1: ruleExitStatement returns [EObject current=null] : ( () otherlv_1= 'EXIT' ) ;
    public final EObject ruleExitStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPoST.g:4519:2: ( ( () otherlv_1= 'EXIT' ) )
            // InternalPoST.g:4520:2: ( () otherlv_1= 'EXIT' )
            {
            // InternalPoST.g:4520:2: ( () otherlv_1= 'EXIT' )
            // InternalPoST.g:4521:3: () otherlv_1= 'EXIT'
            {
            // InternalPoST.g:4521:3: ()
            // InternalPoST.g:4522:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExitStatementAccess().getExitStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,94,FOLLOW_2); 

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
    // InternalPoST.g:4536:1: entryRuleSymbolicVariable returns [EObject current=null] : iv_ruleSymbolicVariable= ruleSymbolicVariable EOF ;
    public final EObject entryRuleSymbolicVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolicVariable = null;


        try {
            // InternalPoST.g:4536:57: (iv_ruleSymbolicVariable= ruleSymbolicVariable EOF )
            // InternalPoST.g:4537:2: iv_ruleSymbolicVariable= ruleSymbolicVariable EOF
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
    // InternalPoST.g:4543:1: ruleSymbolicVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleSymbolicVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPoST.g:4549:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPoST.g:4550:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPoST.g:4550:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPoST.g:4551:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPoST.g:4551:3: (lv_name_0_0= RULE_ID )
            // InternalPoST.g:4552:4: lv_name_0_0= RULE_ID
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
    // InternalPoST.g:4571:1: entryRuleSimpleSpecificationInit returns [EObject current=null] : iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF ;
    public final EObject entryRuleSimpleSpecificationInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleSpecificationInit = null;


        try {
            // InternalPoST.g:4571:64: (iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF )
            // InternalPoST.g:4572:2: iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF
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
    // InternalPoST.g:4578:1: ruleSimpleSpecificationInit returns [EObject current=null] : ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleSimpleSpecificationInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4584:2: ( ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )? ) )
            // InternalPoST.g:4585:2: ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )? )
            {
            // InternalPoST.g:4585:2: ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )? )
            // InternalPoST.g:4586:3: () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )?
            {
            // InternalPoST.g:4586:3: ()
            // InternalPoST.g:4587:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleSpecificationInitAccess().getSimpleSpecificationInitAction_0(),
            					current);
            			

            }

            // InternalPoST.g:4593:3: ( (lv_type_1_0= ruleDataTypeName ) )
            // InternalPoST.g:4594:4: (lv_type_1_0= ruleDataTypeName )
            {
            // InternalPoST.g:4594:4: (lv_type_1_0= ruleDataTypeName )
            // InternalPoST.g:4595:5: lv_type_1_0= ruleDataTypeName
            {

            					newCompositeNode(grammarAccess.getSimpleSpecificationInitAccess().getTypeDataTypeNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_81);
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

            // InternalPoST.g:4612:3: (otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==47) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalPoST.g:4613:4: otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_50); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleSpecificationInitAccess().getColonEqualsSignKeyword_2_0());
                    			
                    // InternalPoST.g:4617:4: ( (lv_value_3_0= ruleExpression ) )
                    // InternalPoST.g:4618:5: (lv_value_3_0= ruleExpression )
                    {
                    // InternalPoST.g:4618:5: (lv_value_3_0= ruleExpression )
                    // InternalPoST.g:4619:6: lv_value_3_0= ruleExpression
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
    // InternalPoST.g:4641:1: entryRuleVarList returns [EObject current=null] : iv_ruleVarList= ruleVarList EOF ;
    public final EObject entryRuleVarList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarList = null;


        try {
            // InternalPoST.g:4641:48: (iv_ruleVarList= ruleVarList EOF )
            // InternalPoST.g:4642:2: iv_ruleVarList= ruleVarList EOF
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
    // InternalPoST.g:4648:1: ruleVarList returns [EObject current=null] : ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* ) ;
    public final EObject ruleVarList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_vars_0_0 = null;

        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4654:2: ( ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* ) )
            // InternalPoST.g:4655:2: ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* )
            {
            // InternalPoST.g:4655:2: ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* )
            // InternalPoST.g:4656:3: ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )*
            {
            // InternalPoST.g:4656:3: ( (lv_vars_0_0= ruleSymbolicVariable ) )
            // InternalPoST.g:4657:4: (lv_vars_0_0= ruleSymbolicVariable )
            {
            // InternalPoST.g:4657:4: (lv_vars_0_0= ruleSymbolicVariable )
            // InternalPoST.g:4658:5: lv_vars_0_0= ruleSymbolicVariable
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

            // InternalPoST.g:4675:3: (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==48) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalPoST.g:4676:4: otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getVarListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:4680:4: ( (lv_vars_2_0= ruleSymbolicVariable ) )
            	    // InternalPoST.g:4681:5: (lv_vars_2_0= ruleSymbolicVariable )
            	    {
            	    // InternalPoST.g:4681:5: (lv_vars_2_0= ruleSymbolicVariable )
            	    // InternalPoST.g:4682:6: lv_vars_2_0= ruleSymbolicVariable
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
            	    break loop58;
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
    // InternalPoST.g:4704:1: entryRuleVarInitDeclaration returns [EObject current=null] : iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF ;
    public final EObject entryRuleVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarInitDeclaration = null;


        try {
            // InternalPoST.g:4704:59: (iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF )
            // InternalPoST.g:4705:2: iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF
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
    // InternalPoST.g:4711:1: ruleVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) ) ) ;
    public final EObject ruleVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_varList_0_0 = null;

        EObject lv_spec_2_0 = null;

        EObject lv_arrSpec_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4717:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) ) ) )
            // InternalPoST.g:4718:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) ) )
            {
            // InternalPoST.g:4718:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) ) )
            // InternalPoST.g:4719:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) )
            {
            // InternalPoST.g:4719:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:4720:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:4720:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:4721:5: lv_varList_0_0= ruleVarList
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

            otherlv_1=(Token)match(input,51,FOLLOW_82); 

            			newLeafNode(otherlv_1, grammarAccess.getVarInitDeclarationAccess().getColonKeyword_1());
            		
            // InternalPoST.g:4742:3: ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_BIT_STRING_TYPE_NAME && LA59_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt59=1;
            }
            else if ( (LA59_0==108) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalPoST.g:4743:4: ( (lv_spec_2_0= ruleSimpleSpecificationInit ) )
                    {
                    // InternalPoST.g:4743:4: ( (lv_spec_2_0= ruleSimpleSpecificationInit ) )
                    // InternalPoST.g:4744:5: (lv_spec_2_0= ruleSimpleSpecificationInit )
                    {
                    // InternalPoST.g:4744:5: (lv_spec_2_0= ruleSimpleSpecificationInit )
                    // InternalPoST.g:4745:6: lv_spec_2_0= ruleSimpleSpecificationInit
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
                    // InternalPoST.g:4763:4: ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) )
                    {
                    // InternalPoST.g:4763:4: ( (lv_arrSpec_3_0= ruleArraySpecificationInit ) )
                    // InternalPoST.g:4764:5: (lv_arrSpec_3_0= ruleArraySpecificationInit )
                    {
                    // InternalPoST.g:4764:5: (lv_arrSpec_3_0= ruleArraySpecificationInit )
                    // InternalPoST.g:4765:6: lv_arrSpec_3_0= ruleArraySpecificationInit
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
    // InternalPoST.g:4787:1: entryRuleInputVarDeclaration returns [EObject current=null] : iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF ;
    public final EObject entryRuleInputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputVarDeclaration = null;


        try {
            // InternalPoST.g:4787:60: (iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF )
            // InternalPoST.g:4788:2: iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF
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
    // InternalPoST.g:4794:1: ruleInputVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleInputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4800:2: ( ( () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4801:2: ( () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4801:2: ( () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:4802:3: () otherlv_1= 'VAR_INPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:4802:3: ()
            // InternalPoST.g:4803:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInputVarDeclarationAccess().getInputVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,95,FOLLOW_83); 

            			newLeafNode(otherlv_1, grammarAccess.getInputVarDeclarationAccess().getVAR_INPUTKeyword_1());
            		
            // InternalPoST.g:4813:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalPoST.g:4814:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4814:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4815:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4815:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4816:6: lv_vars_2_0= ruleVarInitDeclaration
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

            	    otherlv_3=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_3, grammarAccess.getInputVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            otherlv_4=(Token)match(input,96,FOLLOW_2); 

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
    // InternalPoST.g:4846:1: entryRuleOutputVarDeclaration returns [EObject current=null] : iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF ;
    public final EObject entryRuleOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputVarDeclaration = null;


        try {
            // InternalPoST.g:4846:61: (iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF )
            // InternalPoST.g:4847:2: iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF
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
    // InternalPoST.g:4853:1: ruleOutputVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4859:2: ( ( () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4860:2: ( () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4860:2: ( () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:4861:3: () otherlv_1= 'VAR_OUTPUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:4861:3: ()
            // InternalPoST.g:4862:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOutputVarDeclarationAccess().getOutputVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,97,FOLLOW_83); 

            			newLeafNode(otherlv_1, grammarAccess.getOutputVarDeclarationAccess().getVAR_OUTPUTKeyword_1());
            		
            // InternalPoST.g:4872:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_ID) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalPoST.g:4873:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4873:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4874:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4874:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4875:6: lv_vars_2_0= ruleVarInitDeclaration
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

            	    otherlv_3=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOutputVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            otherlv_4=(Token)match(input,96,FOLLOW_2); 

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
    // InternalPoST.g:4905:1: entryRuleInputOutputVarDeclaration returns [EObject current=null] : iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF ;
    public final EObject entryRuleInputOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputOutputVarDeclaration = null;


        try {
            // InternalPoST.g:4905:66: (iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF )
            // InternalPoST.g:4906:2: iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF
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
    // InternalPoST.g:4912:1: ruleInputOutputVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleInputOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4918:2: ( ( () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4919:2: ( () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4919:2: ( () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:4920:3: () otherlv_1= 'VAR_IN_OUT' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:4920:3: ()
            // InternalPoST.g:4921:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInputOutputVarDeclarationAccess().getInputOutputVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,98,FOLLOW_83); 

            			newLeafNode(otherlv_1, grammarAccess.getInputOutputVarDeclarationAccess().getVAR_IN_OUTKeyword_1());
            		
            // InternalPoST.g:4931:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalPoST.g:4932:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4932:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4933:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4933:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4934:6: lv_vars_2_0= ruleVarInitDeclaration
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

            	    otherlv_3=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_3, grammarAccess.getInputOutputVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_4=(Token)match(input,96,FOLLOW_2); 

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
    // InternalPoST.g:4964:1: entryRuleVarDeclaration returns [EObject current=null] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final EObject entryRuleVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDeclaration = null;


        try {
            // InternalPoST.g:4964:55: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // InternalPoST.g:4965:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
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
    // InternalPoST.g:4971:1: ruleVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' ) ;
    public final EObject ruleVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_const_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_vars_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4977:2: ( ( () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' ) )
            // InternalPoST.g:4978:2: ( () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' )
            {
            // InternalPoST.g:4978:2: ( () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' )
            // InternalPoST.g:4979:3: () otherlv_1= 'VAR' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR'
            {
            // InternalPoST.g:4979:3: ()
            // InternalPoST.g:4980:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVarDeclarationAccess().getVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,99,FOLLOW_84); 

            			newLeafNode(otherlv_1, grammarAccess.getVarDeclarationAccess().getVARKeyword_1());
            		
            // InternalPoST.g:4990:3: ( (lv_const_2_0= 'CONSTANT' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==100) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalPoST.g:4991:4: (lv_const_2_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4991:4: (lv_const_2_0= 'CONSTANT' )
                    // InternalPoST.g:4992:5: lv_const_2_0= 'CONSTANT'
                    {
                    lv_const_2_0=(Token)match(input,100,FOLLOW_83); 

                    					newLeafNode(lv_const_2_0, grammarAccess.getVarDeclarationAccess().getConstCONSTANTKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_2_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:5004:3: ( ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalPoST.g:5005:4: ( (lv_vars_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';'
            	    {
            	    // InternalPoST.g:5005:4: ( (lv_vars_3_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:5006:5: (lv_vars_3_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:5006:5: (lv_vars_3_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:5007:6: lv_vars_3_0= ruleVarInitDeclaration
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

            	    otherlv_4=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_4, grammarAccess.getVarDeclarationAccess().getSemicolonKeyword_3_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            otherlv_5=(Token)match(input,96,FOLLOW_2); 

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
    // InternalPoST.g:5037:1: entryRuleTempVarDeclaration returns [EObject current=null] : iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF ;
    public final EObject entryRuleTempVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTempVarDeclaration = null;


        try {
            // InternalPoST.g:5037:59: (iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF )
            // InternalPoST.g:5038:2: iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF
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
    // InternalPoST.g:5044:1: ruleTempVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleTempVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5050:2: ( ( () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:5051:2: ( () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:5051:2: ( () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:5052:3: () otherlv_1= 'VAR_TEMP' ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:5052:3: ()
            // InternalPoST.g:5053:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTempVarDeclarationAccess().getTempVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,101,FOLLOW_83); 

            			newLeafNode(otherlv_1, grammarAccess.getTempVarDeclarationAccess().getVAR_TEMPKeyword_1());
            		
            // InternalPoST.g:5063:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_ID) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalPoST.g:5064:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:5064:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:5065:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:5065:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:5066:6: lv_vars_2_0= ruleVarInitDeclaration
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

            	    otherlv_3=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_3, grammarAccess.getTempVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            otherlv_4=(Token)match(input,96,FOLLOW_2); 

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
    // InternalPoST.g:5096:1: entryRuleExternalVarInitDeclaration returns [EObject current=null] : iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF ;
    public final EObject entryRuleExternalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalVarInitDeclaration = null;


        try {
            // InternalPoST.g:5096:67: (iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF )
            // InternalPoST.g:5097:2: iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF
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
    // InternalPoST.g:5103:1: ruleExternalVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleExternalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_varList_0_0 = null;

        AntlrDatatypeRuleToken lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5109:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:5110:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:5110:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) )
            // InternalPoST.g:5111:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) )
            {
            // InternalPoST.g:5111:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:5112:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:5112:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:5113:5: lv_varList_0_0= ruleVarList
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

            otherlv_1=(Token)match(input,51,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalVarInitDeclarationAccess().getColonKeyword_1());
            		
            // InternalPoST.g:5134:3: ( (lv_type_2_0= ruleDataTypeName ) )
            // InternalPoST.g:5135:4: (lv_type_2_0= ruleDataTypeName )
            {
            // InternalPoST.g:5135:4: (lv_type_2_0= ruleDataTypeName )
            // InternalPoST.g:5136:5: lv_type_2_0= ruleDataTypeName
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
    // InternalPoST.g:5157:1: entryRuleExternalVarDeclaration returns [EObject current=null] : iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF ;
    public final EObject entryRuleExternalVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalVarDeclaration = null;


        try {
            // InternalPoST.g:5157:63: (iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF )
            // InternalPoST.g:5158:2: iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF
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
    // InternalPoST.g:5164:1: ruleExternalVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' ) ;
    public final EObject ruleExternalVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_const_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_vars_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5170:2: ( ( () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' ) )
            // InternalPoST.g:5171:2: ( () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' )
            {
            // InternalPoST.g:5171:2: ( () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR' )
            // InternalPoST.g:5172:3: () otherlv_1= 'VAR_EXTERNAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )* otherlv_5= 'END_VAR'
            {
            // InternalPoST.g:5172:3: ()
            // InternalPoST.g:5173:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExternalVarDeclarationAccess().getExternalVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,102,FOLLOW_84); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalVarDeclarationAccess().getVAR_EXTERNALKeyword_1());
            		
            // InternalPoST.g:5183:3: ( (lv_const_2_0= 'CONSTANT' ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==100) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalPoST.g:5184:4: (lv_const_2_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:5184:4: (lv_const_2_0= 'CONSTANT' )
                    // InternalPoST.g:5185:5: lv_const_2_0= 'CONSTANT'
                    {
                    lv_const_2_0=(Token)match(input,100,FOLLOW_83); 

                    					newLeafNode(lv_const_2_0, grammarAccess.getExternalVarDeclarationAccess().getConstCONSTANTKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getExternalVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_2_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:5197:3: ( ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';' )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==RULE_ID) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalPoST.g:5198:4: ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) ) otherlv_4= ';'
            	    {
            	    // InternalPoST.g:5198:4: ( (lv_vars_3_0= ruleExternalVarInitDeclaration ) )
            	    // InternalPoST.g:5199:5: (lv_vars_3_0= ruleExternalVarInitDeclaration )
            	    {
            	    // InternalPoST.g:5199:5: (lv_vars_3_0= ruleExternalVarInitDeclaration )
            	    // InternalPoST.g:5200:6: lv_vars_3_0= ruleExternalVarInitDeclaration
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

            	    otherlv_4=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_4, grammarAccess.getExternalVarDeclarationAccess().getSemicolonKeyword_3_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            otherlv_5=(Token)match(input,96,FOLLOW_2); 

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
    // InternalPoST.g:5230:1: entryRuleGlobalVarInitDeclaration returns [EObject current=null] : iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF ;
    public final EObject entryRuleGlobalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVarInitDeclaration = null;


        try {
            // InternalPoST.g:5230:65: (iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF )
            // InternalPoST.g:5231:2: iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF
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
    // InternalPoST.g:5237:1: ruleGlobalVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleGlobalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_location_2_0=null;
        Token otherlv_3=null;
        EObject lv_varList_0_0 = null;

        AntlrDatatypeRuleToken lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5243:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:5244:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:5244:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) )
            // InternalPoST.g:5245:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) )
            {
            // InternalPoST.g:5245:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:5246:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:5246:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:5247:5: lv_varList_0_0= ruleVarList
            {

            					newCompositeNode(grammarAccess.getGlobalVarInitDeclarationAccess().getVarListVarListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_85);
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

            otherlv_1=(Token)match(input,103,FOLLOW_86); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalVarInitDeclarationAccess().getATKeyword_1());
            		
            // InternalPoST.g:5268:3: ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) )
            // InternalPoST.g:5269:4: (lv_location_2_0= RULE_DIRECT_VARIABLE )
            {
            // InternalPoST.g:5269:4: (lv_location_2_0= RULE_DIRECT_VARIABLE )
            // InternalPoST.g:5270:5: lv_location_2_0= RULE_DIRECT_VARIABLE
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

            otherlv_3=(Token)match(input,51,FOLLOW_31); 

            			newLeafNode(otherlv_3, grammarAccess.getGlobalVarInitDeclarationAccess().getColonKeyword_3());
            		
            // InternalPoST.g:5290:3: ( (lv_type_4_0= ruleDataTypeName ) )
            // InternalPoST.g:5291:4: (lv_type_4_0= ruleDataTypeName )
            {
            // InternalPoST.g:5291:4: (lv_type_4_0= ruleDataTypeName )
            // InternalPoST.g:5292:5: lv_type_4_0= ruleDataTypeName
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
    // InternalPoST.g:5313:1: entryRuleGlobalVarDeclaration returns [EObject current=null] : iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF ;
    public final EObject entryRuleGlobalVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVarDeclaration = null;


        try {
            // InternalPoST.g:5313:61: (iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF )
            // InternalPoST.g:5314:2: iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF
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
    // InternalPoST.g:5320:1: ruleGlobalVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR' ) ;
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
            // InternalPoST.g:5326:2: ( ( () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR' ) )
            // InternalPoST.g:5327:2: ( () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR' )
            {
            // InternalPoST.g:5327:2: ( () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR' )
            // InternalPoST.g:5328:3: () otherlv_1= 'VAR_GLOBAL' ( (lv_const_2_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )* otherlv_7= 'END_VAR'
            {
            // InternalPoST.g:5328:3: ()
            // InternalPoST.g:5329:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGlobalVarDeclarationAccess().getGlobalVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,104,FOLLOW_84); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalVarDeclarationAccess().getVAR_GLOBALKeyword_1());
            		
            // InternalPoST.g:5339:3: ( (lv_const_2_0= 'CONSTANT' ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==100) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalPoST.g:5340:4: (lv_const_2_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:5340:4: (lv_const_2_0= 'CONSTANT' )
                    // InternalPoST.g:5341:5: lv_const_2_0= 'CONSTANT'
                    {
                    lv_const_2_0=(Token)match(input,100,FOLLOW_83); 

                    					newLeafNode(lv_const_2_0, grammarAccess.getGlobalVarDeclarationAccess().getConstCONSTANTKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGlobalVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_2_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:5353:3: ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )*
            loop69:
            do {
                int alt69=3;
                alt69 = dfa69.predict(input);
                switch (alt69) {
            	case 1 :
            	    // InternalPoST.g:5354:4: ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )
            	    {
            	    // InternalPoST.g:5354:4: ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' )
            	    // InternalPoST.g:5355:5: ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';'
            	    {
            	    // InternalPoST.g:5355:5: ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:5356:6: (lv_varsSimple_3_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:5356:6: (lv_varsSimple_3_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:5357:7: lv_varsSimple_3_0= ruleVarInitDeclaration
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

            	    otherlv_4=(Token)match(input,43,FOLLOW_83); 

            	    					newLeafNode(otherlv_4, grammarAccess.getGlobalVarDeclarationAccess().getSemicolonKeyword_3_0_1());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:5380:4: ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' )
            	    {
            	    // InternalPoST.g:5380:4: ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' )
            	    // InternalPoST.g:5381:5: ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';'
            	    {
            	    // InternalPoST.g:5381:5: ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) )
            	    // InternalPoST.g:5382:6: (lv_varsAs_5_0= ruleGlobalVarInitDeclaration )
            	    {
            	    // InternalPoST.g:5382:6: (lv_varsAs_5_0= ruleGlobalVarInitDeclaration )
            	    // InternalPoST.g:5383:7: lv_varsAs_5_0= ruleGlobalVarInitDeclaration
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

            	    otherlv_6=(Token)match(input,43,FOLLOW_83); 

            	    					newLeafNode(otherlv_6, grammarAccess.getGlobalVarDeclarationAccess().getSemicolonKeyword_3_1_1());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            otherlv_7=(Token)match(input,96,FOLLOW_2); 

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
    // InternalPoST.g:5414:1: entryRuleProcessVariable returns [EObject current=null] : iv_ruleProcessVariable= ruleProcessVariable EOF ;
    public final EObject entryRuleProcessVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVariable = null;


        try {
            // InternalPoST.g:5414:56: (iv_ruleProcessVariable= ruleProcessVariable EOF )
            // InternalPoST.g:5415:2: iv_ruleProcessVariable= ruleProcessVariable EOF
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
    // InternalPoST.g:5421:1: ruleProcessVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleProcessVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5427:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPoST.g:5428:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPoST.g:5428:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPoST.g:5429:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPoST.g:5429:3: (lv_name_0_0= RULE_ID )
            // InternalPoST.g:5430:4: lv_name_0_0= RULE_ID
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
    // InternalPoST.g:5449:1: entryRuleProcessVarList returns [EObject current=null] : iv_ruleProcessVarList= ruleProcessVarList EOF ;
    public final EObject entryRuleProcessVarList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVarList = null;


        try {
            // InternalPoST.g:5449:55: (iv_ruleProcessVarList= ruleProcessVarList EOF )
            // InternalPoST.g:5450:2: iv_ruleProcessVarList= ruleProcessVarList EOF
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
    // InternalPoST.g:5456:1: ruleProcessVarList returns [EObject current=null] : ( ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )* ) ;
    public final EObject ruleProcessVarList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_vars_0_0 = null;

        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5462:2: ( ( ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )* ) )
            // InternalPoST.g:5463:2: ( ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )* )
            {
            // InternalPoST.g:5463:2: ( ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )* )
            // InternalPoST.g:5464:3: ( (lv_vars_0_0= ruleProcessVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )*
            {
            // InternalPoST.g:5464:3: ( (lv_vars_0_0= ruleProcessVariable ) )
            // InternalPoST.g:5465:4: (lv_vars_0_0= ruleProcessVariable )
            {
            // InternalPoST.g:5465:4: (lv_vars_0_0= ruleProcessVariable )
            // InternalPoST.g:5466:5: lv_vars_0_0= ruleProcessVariable
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

            // InternalPoST.g:5483:3: (otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==48) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalPoST.g:5484:4: otherlv_1= ',' ( (lv_vars_2_0= ruleProcessVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getProcessVarListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:5488:4: ( (lv_vars_2_0= ruleProcessVariable ) )
            	    // InternalPoST.g:5489:5: (lv_vars_2_0= ruleProcessVariable )
            	    {
            	    // InternalPoST.g:5489:5: (lv_vars_2_0= ruleProcessVariable )
            	    // InternalPoST.g:5490:6: lv_vars_2_0= ruleProcessVariable
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
            	    break loop70;
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
    // InternalPoST.g:5512:1: entryRuleProcessVarInitDeclaration returns [EObject current=null] : iv_ruleProcessVarInitDeclaration= ruleProcessVarInitDeclaration EOF ;
    public final EObject entryRuleProcessVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVarInitDeclaration = null;


        try {
            // InternalPoST.g:5512:66: (iv_ruleProcessVarInitDeclaration= ruleProcessVarInitDeclaration EOF )
            // InternalPoST.g:5513:2: iv_ruleProcessVarInitDeclaration= ruleProcessVarInitDeclaration EOF
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
    // InternalPoST.g:5519:1: ruleProcessVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleProcessVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_varList_0_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5525:2: ( ( ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalPoST.g:5526:2: ( ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalPoST.g:5526:2: ( ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalPoST.g:5527:3: ( (lv_varList_0_0= ruleProcessVarList ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalPoST.g:5527:3: ( (lv_varList_0_0= ruleProcessVarList ) )
            // InternalPoST.g:5528:4: (lv_varList_0_0= ruleProcessVarList )
            {
            // InternalPoST.g:5528:4: (lv_varList_0_0= ruleProcessVarList )
            // InternalPoST.g:5529:5: lv_varList_0_0= ruleProcessVarList
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
            		
            // InternalPoST.g:5550:3: ( (otherlv_2= RULE_ID ) )
            // InternalPoST.g:5551:4: (otherlv_2= RULE_ID )
            {
            // InternalPoST.g:5551:4: (otherlv_2= RULE_ID )
            // InternalPoST.g:5552:5: otherlv_2= RULE_ID
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
    // InternalPoST.g:5567:1: entryRuleProcessVarDeclaration returns [EObject current=null] : iv_ruleProcessVarDeclaration= ruleProcessVarDeclaration EOF ;
    public final EObject entryRuleProcessVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVarDeclaration = null;


        try {
            // InternalPoST.g:5567:62: (iv_ruleProcessVarDeclaration= ruleProcessVarDeclaration EOF )
            // InternalPoST.g:5568:2: iv_ruleProcessVarDeclaration= ruleProcessVarDeclaration EOF
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
    // InternalPoST.g:5574:1: ruleProcessVarDeclaration returns [EObject current=null] : ( () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) ;
    public final EObject ruleProcessVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5580:2: ( ( () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:5581:2: ( () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:5581:2: ( () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR' )
            // InternalPoST.g:5582:3: () otherlv_1= 'VAR_PROCESS' ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )* otherlv_4= 'END_VAR'
            {
            // InternalPoST.g:5582:3: ()
            // InternalPoST.g:5583:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProcessVarDeclarationAccess().getProcessVarDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,105,FOLLOW_83); 

            			newLeafNode(otherlv_1, grammarAccess.getProcessVarDeclarationAccess().getVAR_PROCESSKeyword_1());
            		
            // InternalPoST.g:5593:3: ( ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';' )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_ID) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalPoST.g:5594:4: ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:5594:4: ( (lv_vars_2_0= ruleProcessVarInitDeclaration ) )
            	    // InternalPoST.g:5595:5: (lv_vars_2_0= ruleProcessVarInitDeclaration )
            	    {
            	    // InternalPoST.g:5595:5: (lv_vars_2_0= ruleProcessVarInitDeclaration )
            	    // InternalPoST.g:5596:6: lv_vars_2_0= ruleProcessVarInitDeclaration
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

            	    otherlv_3=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_3, grammarAccess.getProcessVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            otherlv_4=(Token)match(input,96,FOLLOW_2); 

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
    // InternalPoST.g:5626:1: entryRuleArrayVariable returns [EObject current=null] : iv_ruleArrayVariable= ruleArrayVariable EOF ;
    public final EObject entryRuleArrayVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayVariable = null;


        try {
            // InternalPoST.g:5626:54: (iv_ruleArrayVariable= ruleArrayVariable EOF )
            // InternalPoST.g:5627:2: iv_ruleArrayVariable= ruleArrayVariable EOF
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
    // InternalPoST.g:5633:1: ruleArrayVariable returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) ;
    public final EObject ruleArrayVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_index_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5639:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) )
            // InternalPoST.g:5640:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
            {
            // InternalPoST.g:5640:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
            // InternalPoST.g:5641:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']'
            {
            // InternalPoST.g:5641:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:5642:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:5642:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:5643:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArrayVariableRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_87); 

            					newLeafNode(otherlv_0, grammarAccess.getArrayVariableAccess().getVariableSymbolicVariableCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,106,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayVariableAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalPoST.g:5658:3: ( (lv_index_2_0= ruleExpression ) )
            // InternalPoST.g:5659:4: (lv_index_2_0= ruleExpression )
            {
            // InternalPoST.g:5659:4: (lv_index_2_0= ruleExpression )
            // InternalPoST.g:5660:5: lv_index_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getArrayVariableAccess().getIndexExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_88);
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

            otherlv_3=(Token)match(input,107,FOLLOW_2); 

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
    // InternalPoST.g:5685:1: entryRuleArraySpecificationInit returns [EObject current=null] : iv_ruleArraySpecificationInit= ruleArraySpecificationInit EOF ;
    public final EObject entryRuleArraySpecificationInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecificationInit = null;


        try {
            // InternalPoST.g:5685:63: (iv_ruleArraySpecificationInit= ruleArraySpecificationInit EOF )
            // InternalPoST.g:5686:2: iv_ruleArraySpecificationInit= ruleArraySpecificationInit EOF
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
    // InternalPoST.g:5692:1: ruleArraySpecificationInit returns [EObject current=null] : ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? ) ;
    public final EObject ruleArraySpecificationInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_init_0_0 = null;

        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5698:2: ( ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? ) )
            // InternalPoST.g:5699:2: ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? )
            {
            // InternalPoST.g:5699:2: ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? )
            // InternalPoST.g:5700:3: ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )?
            {
            // InternalPoST.g:5700:3: ( (lv_init_0_0= ruleArraySpecification ) )
            // InternalPoST.g:5701:4: (lv_init_0_0= ruleArraySpecification )
            {
            // InternalPoST.g:5701:4: (lv_init_0_0= ruleArraySpecification )
            // InternalPoST.g:5702:5: lv_init_0_0= ruleArraySpecification
            {

            					newCompositeNode(grammarAccess.getArraySpecificationInitAccess().getInitArraySpecificationParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_81);
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

            // InternalPoST.g:5719:3: (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==47) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalPoST.g:5720:4: otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) )
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_87); 

                    				newLeafNode(otherlv_1, grammarAccess.getArraySpecificationInitAccess().getColonEqualsSignKeyword_1_0());
                    			
                    // InternalPoST.g:5724:4: ( (lv_values_2_0= ruleArrayInitialization ) )
                    // InternalPoST.g:5725:5: (lv_values_2_0= ruleArrayInitialization )
                    {
                    // InternalPoST.g:5725:5: (lv_values_2_0= ruleArrayInitialization )
                    // InternalPoST.g:5726:6: lv_values_2_0= ruleArrayInitialization
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
    // InternalPoST.g:5748:1: entryRuleArraySpecification returns [EObject current=null] : iv_ruleArraySpecification= ruleArraySpecification EOF ;
    public final EObject entryRuleArraySpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecification = null;


        try {
            // InternalPoST.g:5748:59: (iv_ruleArraySpecification= ruleArraySpecification EOF )
            // InternalPoST.g:5749:2: iv_ruleArraySpecification= ruleArraySpecification EOF
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
    // InternalPoST.g:5755:1: ruleArraySpecification returns [EObject current=null] : (otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) ) ) ;
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
            // InternalPoST.g:5761:2: ( (otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:5762:2: (otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:5762:2: (otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) ) )
            // InternalPoST.g:5763:3: otherlv_0= 'ARRAY' otherlv_1= '[' ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' ) otherlv_4= ']' otherlv_5= 'OF' ( (lv_type_6_0= ruleDataTypeName ) )
            {
            otherlv_0=(Token)match(input,108,FOLLOW_87); 

            			newLeafNode(otherlv_0, grammarAccess.getArraySpecificationAccess().getARRAYKeyword_0());
            		
            otherlv_1=(Token)match(input,106,FOLLOW_89); 

            			newLeafNode(otherlv_1, grammarAccess.getArraySpecificationAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalPoST.g:5771:3: ( ( (lv_interval_2_0= ruleArrayInterval ) ) | otherlv_3= '*' )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID||LA73_0==RULE_INTEGER||LA73_0==RULE_TIME_PREF_LITERAL||(LA73_0>=RULE_REAL_TYPE_NAME && LA73_0<=RULE_REAL)||LA73_0==45||LA73_0==52||LA73_0==112||LA73_0==123) ) {
                alt73=1;
            }
            else if ( (LA73_0==109) ) {
                alt73=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalPoST.g:5772:4: ( (lv_interval_2_0= ruleArrayInterval ) )
                    {
                    // InternalPoST.g:5772:4: ( (lv_interval_2_0= ruleArrayInterval ) )
                    // InternalPoST.g:5773:5: (lv_interval_2_0= ruleArrayInterval )
                    {
                    // InternalPoST.g:5773:5: (lv_interval_2_0= ruleArrayInterval )
                    // InternalPoST.g:5774:6: lv_interval_2_0= ruleArrayInterval
                    {

                    						newCompositeNode(grammarAccess.getArraySpecificationAccess().getIntervalArrayIntervalParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_88);
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
                    // InternalPoST.g:5792:4: otherlv_3= '*'
                    {
                    otherlv_3=(Token)match(input,109,FOLLOW_88); 

                    				newLeafNode(otherlv_3, grammarAccess.getArraySpecificationAccess().getAsteriskKeyword_2_1());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,107,FOLLOW_65); 

            			newLeafNode(otherlv_4, grammarAccess.getArraySpecificationAccess().getRightSquareBracketKeyword_3());
            		
            otherlv_5=(Token)match(input,81,FOLLOW_31); 

            			newLeafNode(otherlv_5, grammarAccess.getArraySpecificationAccess().getOFKeyword_4());
            		
            // InternalPoST.g:5805:3: ( (lv_type_6_0= ruleDataTypeName ) )
            // InternalPoST.g:5806:4: (lv_type_6_0= ruleDataTypeName )
            {
            // InternalPoST.g:5806:4: (lv_type_6_0= ruleDataTypeName )
            // InternalPoST.g:5807:5: lv_type_6_0= ruleDataTypeName
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
    // InternalPoST.g:5828:1: entryRuleArrayInterval returns [EObject current=null] : iv_ruleArrayInterval= ruleArrayInterval EOF ;
    public final EObject entryRuleArrayInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayInterval = null;


        try {
            // InternalPoST.g:5828:54: (iv_ruleArrayInterval= ruleArrayInterval EOF )
            // InternalPoST.g:5829:2: iv_ruleArrayInterval= ruleArrayInterval EOF
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
    // InternalPoST.g:5835:1: ruleArrayInterval returns [EObject current=null] : ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) ) ) ;
    public final EObject ruleArrayInterval() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_start_0_0 = null;

        EObject lv_end_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5841:2: ( ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) ) ) )
            // InternalPoST.g:5842:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) ) )
            {
            // InternalPoST.g:5842:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) ) )
            // InternalPoST.g:5843:3: ( (lv_start_0_0= ruleExpression ) ) otherlv_1= '..' ( (lv_end_2_0= ruleExpression ) )
            {
            // InternalPoST.g:5843:3: ( (lv_start_0_0= ruleExpression ) )
            // InternalPoST.g:5844:4: (lv_start_0_0= ruleExpression )
            {
            // InternalPoST.g:5844:4: (lv_start_0_0= ruleExpression )
            // InternalPoST.g:5845:5: lv_start_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getArrayIntervalAccess().getStartExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_90);
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

            otherlv_1=(Token)match(input,110,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayIntervalAccess().getFullStopFullStopKeyword_1());
            		
            // InternalPoST.g:5866:3: ( (lv_end_2_0= ruleExpression ) )
            // InternalPoST.g:5867:4: (lv_end_2_0= ruleExpression )
            {
            // InternalPoST.g:5867:4: (lv_end_2_0= ruleExpression )
            // InternalPoST.g:5868:5: lv_end_2_0= ruleExpression
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
    // InternalPoST.g:5889:1: entryRuleArrayInitialization returns [EObject current=null] : iv_ruleArrayInitialization= ruleArrayInitialization EOF ;
    public final EObject entryRuleArrayInitialization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayInitialization = null;


        try {
            // InternalPoST.g:5889:60: (iv_ruleArrayInitialization= ruleArrayInitialization EOF )
            // InternalPoST.g:5890:2: iv_ruleArrayInitialization= ruleArrayInitialization EOF
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
    // InternalPoST.g:5896:1: ruleArrayInitialization returns [EObject current=null] : (otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleArrayInitialization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5902:2: ( (otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']' ) )
            // InternalPoST.g:5903:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']' )
            {
            // InternalPoST.g:5903:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']' )
            // InternalPoST.g:5904:3: otherlv_0= '[' ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,106,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getArrayInitializationAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalPoST.g:5908:3: ( (lv_elements_1_0= ruleExpression ) )
            // InternalPoST.g:5909:4: (lv_elements_1_0= ruleExpression )
            {
            // InternalPoST.g:5909:4: (lv_elements_1_0= ruleExpression )
            // InternalPoST.g:5910:5: lv_elements_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getArrayInitializationAccess().getElementsExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_91);
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

            // InternalPoST.g:5927:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==48) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalPoST.g:5928:4: otherlv_2= ',' ( (lv_elements_3_0= ruleExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,48,FOLLOW_50); 

            	    				newLeafNode(otherlv_2, grammarAccess.getArrayInitializationAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalPoST.g:5932:4: ( (lv_elements_3_0= ruleExpression ) )
            	    // InternalPoST.g:5933:5: (lv_elements_3_0= ruleExpression )
            	    {
            	    // InternalPoST.g:5933:5: (lv_elements_3_0= ruleExpression )
            	    // InternalPoST.g:5934:6: lv_elements_3_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getArrayInitializationAccess().getElementsExpressionParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_91);
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
            	    break loop74;
                }
            } while (true);

            otherlv_4=(Token)match(input,107,FOLLOW_2); 

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
    // InternalPoST.g:5960:1: entryRuleTimeLiteral returns [EObject current=null] : iv_ruleTimeLiteral= ruleTimeLiteral EOF ;
    public final EObject entryRuleTimeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeLiteral = null;


        try {
            // InternalPoST.g:5960:52: (iv_ruleTimeLiteral= ruleTimeLiteral EOF )
            // InternalPoST.g:5961:2: iv_ruleTimeLiteral= ruleTimeLiteral EOF
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
    // InternalPoST.g:5967:1: ruleTimeLiteral returns [EObject current=null] : (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) ) ;
    public final EObject ruleTimeLiteral() throws RecognitionException {
        EObject current = null;

        Token this_TIME_PREF_LITERAL_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_interval_3_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5973:2: ( (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) ) )
            // InternalPoST.g:5974:2: (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) )
            {
            // InternalPoST.g:5974:2: (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) )
            // InternalPoST.g:5975:3: this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) )
            {
            this_TIME_PREF_LITERAL_0=(Token)match(input,RULE_TIME_PREF_LITERAL,FOLLOW_92); 

            			newLeafNode(this_TIME_PREF_LITERAL_0, grammarAccess.getTimeLiteralAccess().getTIME_PREF_LITERALTerminalRuleCall_0());
            		
            otherlv_1=(Token)match(input,111,FOLLOW_93); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeLiteralAccess().getNumberSignKeyword_1());
            		
            // InternalPoST.g:5983:3: (otherlv_2= '-' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==112) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalPoST.g:5984:4: otherlv_2= '-'
                    {
                    otherlv_2=(Token)match(input,112,FOLLOW_94); 

                    				newLeafNode(otherlv_2, grammarAccess.getTimeLiteralAccess().getHyphenMinusKeyword_2());
                    			

                    }
                    break;

            }

            // InternalPoST.g:5989:3: ( (lv_interval_3_0= RULE_INTERVAL ) )
            // InternalPoST.g:5990:4: (lv_interval_3_0= RULE_INTERVAL )
            {
            // InternalPoST.g:5990:4: (lv_interval_3_0= RULE_INTERVAL )
            // InternalPoST.g:5991:5: lv_interval_3_0= RULE_INTERVAL
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
    // InternalPoST.g:6011:1: entryRuleDataTypeName returns [String current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final String entryRuleDataTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeName = null;


        try {
            // InternalPoST.g:6011:52: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // InternalPoST.g:6012:2: iv_ruleDataTypeName= ruleDataTypeName EOF
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
    // InternalPoST.g:6018:1: ruleDataTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BIT_STRING_TYPE_NAME_1=null;
        Token this_TIME_TYPE_NAME_2=null;
        Token this_STRING_TYPE_NAME_3=null;
        AntlrDatatypeRuleToken this_NumericTypeName_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:6024:2: ( (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME ) )
            // InternalPoST.g:6025:2: (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME )
            {
            // InternalPoST.g:6025:2: (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME )
            int alt76=4;
            switch ( input.LA(1) ) {
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
                {
                alt76=1;
                }
                break;
            case RULE_BIT_STRING_TYPE_NAME:
                {
                alt76=2;
                }
                break;
            case RULE_TIME_TYPE_NAME:
                {
                alt76=3;
                }
                break;
            case RULE_STRING_TYPE_NAME:
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
                    // InternalPoST.g:6026:3: this_NumericTypeName_0= ruleNumericTypeName
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
                    // InternalPoST.g:6037:3: this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME
                    {
                    this_BIT_STRING_TYPE_NAME_1=(Token)match(input,RULE_BIT_STRING_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_BIT_STRING_TYPE_NAME_1);
                    		

                    			newLeafNode(this_BIT_STRING_TYPE_NAME_1, grammarAccess.getDataTypeNameAccess().getBIT_STRING_TYPE_NAMETerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPoST.g:6045:3: this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME
                    {
                    this_TIME_TYPE_NAME_2=(Token)match(input,RULE_TIME_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_TIME_TYPE_NAME_2);
                    		

                    			newLeafNode(this_TIME_TYPE_NAME_2, grammarAccess.getDataTypeNameAccess().getTIME_TYPE_NAMETerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPoST.g:6053:3: this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME
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
    // InternalPoST.g:6064:1: entryRuleNumericTypeName returns [String current=null] : iv_ruleNumericTypeName= ruleNumericTypeName EOF ;
    public final String entryRuleNumericTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumericTypeName = null;


        try {
            // InternalPoST.g:6064:55: (iv_ruleNumericTypeName= ruleNumericTypeName EOF )
            // InternalPoST.g:6065:2: iv_ruleNumericTypeName= ruleNumericTypeName EOF
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
    // InternalPoST.g:6071:1: ruleNumericTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleNumericTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_TYPE_NAME_1=null;
        AntlrDatatypeRuleToken this_IntegerTypeName_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:6077:2: ( (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME ) )
            // InternalPoST.g:6078:2: (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME )
            {
            // InternalPoST.g:6078:2: (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=RULE_SIGNED_INTEGER_TYPE_NAME && LA77_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt77=1;
            }
            else if ( (LA77_0==RULE_REAL_TYPE_NAME) ) {
                alt77=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // InternalPoST.g:6079:3: this_IntegerTypeName_0= ruleIntegerTypeName
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
                    // InternalPoST.g:6090:3: this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME
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
    // InternalPoST.g:6101:1: entryRuleIntegerTypeName returns [String current=null] : iv_ruleIntegerTypeName= ruleIntegerTypeName EOF ;
    public final String entryRuleIntegerTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerTypeName = null;


        try {
            // InternalPoST.g:6101:55: (iv_ruleIntegerTypeName= ruleIntegerTypeName EOF )
            // InternalPoST.g:6102:2: iv_ruleIntegerTypeName= ruleIntegerTypeName EOF
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
    // InternalPoST.g:6108:1: ruleIntegerTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleIntegerTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIGNED_INTEGER_TYPE_NAME_0=null;
        Token this_UNSIGNED_INTEGER_TYPE_NAME_1=null;


        	enterRule();

        try {
            // InternalPoST.g:6114:2: ( (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME ) )
            // InternalPoST.g:6115:2: (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME )
            {
            // InternalPoST.g:6115:2: (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_SIGNED_INTEGER_TYPE_NAME) ) {
                alt78=1;
            }
            else if ( (LA78_0==RULE_UNSIGNED_INTEGER_TYPE_NAME) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalPoST.g:6116:3: this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME
                    {
                    this_SIGNED_INTEGER_TYPE_NAME_0=(Token)match(input,RULE_SIGNED_INTEGER_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_SIGNED_INTEGER_TYPE_NAME_0);
                    		

                    			newLeafNode(this_SIGNED_INTEGER_TYPE_NAME_0, grammarAccess.getIntegerTypeNameAccess().getSIGNED_INTEGER_TYPE_NAMETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:6124:3: this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME
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
    // InternalPoST.g:6135:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalPoST.g:6135:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalPoST.g:6136:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalPoST.g:6142:1: ruleConstant returns [EObject current=null] : ( ( (lv_num_0_0= ruleNumericLiteral ) ) | ( (lv_time_1_0= ruleTimeLiteral ) ) | ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) ) ) ;
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
            // InternalPoST.g:6148:2: ( ( ( (lv_num_0_0= ruleNumericLiteral ) ) | ( (lv_time_1_0= ruleTimeLiteral ) ) | ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) ) ) )
            // InternalPoST.g:6149:2: ( ( (lv_num_0_0= ruleNumericLiteral ) ) | ( (lv_time_1_0= ruleTimeLiteral ) ) | ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) ) )
            {
            // InternalPoST.g:6149:2: ( ( (lv_num_0_0= ruleNumericLiteral ) ) | ( (lv_time_1_0= ruleTimeLiteral ) ) | ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) ) )
            int alt80=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
            case RULE_REAL:
            case 112:
                {
                alt80=1;
                }
                break;
            case RULE_TIME_PREF_LITERAL:
                {
                alt80=2;
                }
                break;
            case RULE_BINARY_INTEGER:
            case RULE_OCTAL_INTEGER:
            case RULE_HEX_INTEGER:
            case RULE_BOOLEAN_LITERAL:
                {
                alt80=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // InternalPoST.g:6150:3: ( (lv_num_0_0= ruleNumericLiteral ) )
                    {
                    // InternalPoST.g:6150:3: ( (lv_num_0_0= ruleNumericLiteral ) )
                    // InternalPoST.g:6151:4: (lv_num_0_0= ruleNumericLiteral )
                    {
                    // InternalPoST.g:6151:4: (lv_num_0_0= ruleNumericLiteral )
                    // InternalPoST.g:6152:5: lv_num_0_0= ruleNumericLiteral
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
                    // InternalPoST.g:6170:3: ( (lv_time_1_0= ruleTimeLiteral ) )
                    {
                    // InternalPoST.g:6170:3: ( (lv_time_1_0= ruleTimeLiteral ) )
                    // InternalPoST.g:6171:4: (lv_time_1_0= ruleTimeLiteral )
                    {
                    // InternalPoST.g:6171:4: (lv_time_1_0= ruleTimeLiteral )
                    // InternalPoST.g:6172:5: lv_time_1_0= ruleTimeLiteral
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
                    // InternalPoST.g:6190:3: ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) )
                    {
                    // InternalPoST.g:6190:3: ( ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) ) )
                    // InternalPoST.g:6191:4: ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) )
                    {
                    // InternalPoST.g:6191:4: ( (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL ) )
                    // InternalPoST.g:6192:5: (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL )
                    {
                    // InternalPoST.g:6192:5: (lv_oth_2_1= RULE_BINARY_INTEGER | lv_oth_2_2= RULE_OCTAL_INTEGER | lv_oth_2_3= RULE_HEX_INTEGER | lv_oth_2_4= RULE_BOOLEAN_LITERAL )
                    int alt79=4;
                    switch ( input.LA(1) ) {
                    case RULE_BINARY_INTEGER:
                        {
                        alt79=1;
                        }
                        break;
                    case RULE_OCTAL_INTEGER:
                        {
                        alt79=2;
                        }
                        break;
                    case RULE_HEX_INTEGER:
                        {
                        alt79=3;
                        }
                        break;
                    case RULE_BOOLEAN_LITERAL:
                        {
                        alt79=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 79, 0, input);

                        throw nvae;
                    }

                    switch (alt79) {
                        case 1 :
                            // InternalPoST.g:6193:6: lv_oth_2_1= RULE_BINARY_INTEGER
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
                            // InternalPoST.g:6208:6: lv_oth_2_2= RULE_OCTAL_INTEGER
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
                            // InternalPoST.g:6223:6: lv_oth_2_3= RULE_HEX_INTEGER
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
                            // InternalPoST.g:6238:6: lv_oth_2_4= RULE_BOOLEAN_LITERAL
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
    // InternalPoST.g:6259:1: entryRuleSignedInteger returns [EObject current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final EObject entryRuleSignedInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedInteger = null;


        try {
            // InternalPoST.g:6259:54: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // InternalPoST.g:6260:2: iv_ruleSignedInteger= ruleSignedInteger EOF
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
    // InternalPoST.g:6266:1: ruleSignedInteger returns [EObject current=null] : ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleSignedInteger() throws RecognitionException {
        EObject current = null;

        Token lv_iSig_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalPoST.g:6272:2: ( ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // InternalPoST.g:6273:2: ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // InternalPoST.g:6273:2: ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // InternalPoST.g:6274:3: ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // InternalPoST.g:6274:3: ( (lv_iSig_0_0= '-' ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==112) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalPoST.g:6275:4: (lv_iSig_0_0= '-' )
                    {
                    // InternalPoST.g:6275:4: (lv_iSig_0_0= '-' )
                    // InternalPoST.g:6276:5: lv_iSig_0_0= '-'
                    {
                    lv_iSig_0_0=(Token)match(input,112,FOLLOW_18); 

                    					newLeafNode(lv_iSig_0_0, grammarAccess.getSignedIntegerAccess().getISigHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSignedIntegerRule());
                    					}
                    					setWithLastConsumed(current, "iSig", lv_iSig_0_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:6288:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // InternalPoST.g:6289:4: (lv_value_1_0= RULE_INTEGER )
            {
            // InternalPoST.g:6289:4: (lv_value_1_0= RULE_INTEGER )
            // InternalPoST.g:6290:5: lv_value_1_0= RULE_INTEGER
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
    // InternalPoST.g:6310:1: entryRuleNumericLiteral returns [EObject current=null] : iv_ruleNumericLiteral= ruleNumericLiteral EOF ;
    public final EObject entryRuleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericLiteral = null;


        try {
            // InternalPoST.g:6310:55: (iv_ruleNumericLiteral= ruleNumericLiteral EOF )
            // InternalPoST.g:6311:2: iv_ruleNumericLiteral= ruleNumericLiteral EOF
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
    // InternalPoST.g:6317:1: ruleNumericLiteral returns [EObject current=null] : (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteral_0 = null;

        EObject this_RealLiteral_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:6323:2: ( (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalPoST.g:6324:2: (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalPoST.g:6324:2: (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt82=2;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
                {
                alt82=1;
                }
                break;
            case 112:
                {
                int LA82_2 = input.LA(2);

                if ( (LA82_2==RULE_INTEGER) ) {
                    alt82=1;
                }
                else if ( (LA82_2==RULE_REAL) ) {
                    alt82=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 82, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REAL_TYPE_NAME:
            case RULE_REAL:
                {
                alt82=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalPoST.g:6325:3: this_IntegerLiteral_0= ruleIntegerLiteral
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
                    // InternalPoST.g:6334:3: this_RealLiteral_1= ruleRealLiteral
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
    // InternalPoST.g:6346:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // InternalPoST.g:6346:55: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // InternalPoST.g:6347:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
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
    // InternalPoST.g:6353:1: ruleIntegerLiteral returns [EObject current=null] : ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:6359:2: ( ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) ) )
            // InternalPoST.g:6360:2: ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) )
            {
            // InternalPoST.g:6360:2: ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) )
            // InternalPoST.g:6361:3: ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) )
            {
            // InternalPoST.g:6361:3: ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=RULE_SIGNED_INTEGER_TYPE_NAME && LA83_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalPoST.g:6362:4: ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#'
                    {
                    // InternalPoST.g:6362:4: ( (lv_type_0_0= ruleIntegerTypeName ) )
                    // InternalPoST.g:6363:5: (lv_type_0_0= ruleIntegerTypeName )
                    {
                    // InternalPoST.g:6363:5: (lv_type_0_0= ruleIntegerTypeName )
                    // InternalPoST.g:6364:6: lv_type_0_0= ruleIntegerTypeName
                    {

                    						newCompositeNode(grammarAccess.getIntegerLiteralAccess().getTypeIntegerTypeNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_92);
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

                    otherlv_1=(Token)match(input,111,FOLLOW_66); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntegerLiteralAccess().getNumberSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalPoST.g:6386:3: ( (lv_value_2_0= ruleSignedInteger ) )
            // InternalPoST.g:6387:4: (lv_value_2_0= ruleSignedInteger )
            {
            // InternalPoST.g:6387:4: (lv_value_2_0= ruleSignedInteger )
            // InternalPoST.g:6388:5: lv_value_2_0= ruleSignedInteger
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
    // InternalPoST.g:6409:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalPoST.g:6409:52: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalPoST.g:6410:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalPoST.g:6416:1: ruleRealLiteral returns [EObject current=null] : ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token otherlv_1=null;
        Token lv_rSig_2_0=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalPoST.g:6422:2: ( ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) ) )
            // InternalPoST.g:6423:2: ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) )
            {
            // InternalPoST.g:6423:2: ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) )
            // InternalPoST.g:6424:3: ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) )
            {
            // InternalPoST.g:6424:3: ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_REAL_TYPE_NAME) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalPoST.g:6425:4: ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#'
                    {
                    // InternalPoST.g:6425:4: ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) )
                    // InternalPoST.g:6426:5: (lv_type_0_0= RULE_REAL_TYPE_NAME )
                    {
                    // InternalPoST.g:6426:5: (lv_type_0_0= RULE_REAL_TYPE_NAME )
                    // InternalPoST.g:6427:6: lv_type_0_0= RULE_REAL_TYPE_NAME
                    {
                    lv_type_0_0=(Token)match(input,RULE_REAL_TYPE_NAME,FOLLOW_92); 

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

                    otherlv_1=(Token)match(input,111,FOLLOW_95); 

                    				newLeafNode(otherlv_1, grammarAccess.getRealLiteralAccess().getNumberSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalPoST.g:6448:3: ( (lv_rSig_2_0= '-' ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==112) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalPoST.g:6449:4: (lv_rSig_2_0= '-' )
                    {
                    // InternalPoST.g:6449:4: (lv_rSig_2_0= '-' )
                    // InternalPoST.g:6450:5: lv_rSig_2_0= '-'
                    {
                    lv_rSig_2_0=(Token)match(input,112,FOLLOW_96); 

                    					newLeafNode(lv_rSig_2_0, grammarAccess.getRealLiteralAccess().getRSigHyphenMinusKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRealLiteralRule());
                    					}
                    					setWithLastConsumed(current, "rSig", lv_rSig_2_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:6462:3: ( (lv_value_3_0= RULE_REAL ) )
            // InternalPoST.g:6463:4: (lv_value_3_0= RULE_REAL )
            {
            // InternalPoST.g:6463:4: (lv_value_3_0= RULE_REAL )
            // InternalPoST.g:6464:5: lv_value_3_0= RULE_REAL
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
    // InternalPoST.g:6484:1: ruleAssignmentType returns [Enumerator current=null] : ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) ) ;
    public final Enumerator ruleAssignmentType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:6490:2: ( ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) ) )
            // InternalPoST.g:6491:2: ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) )
            {
            // InternalPoST.g:6491:2: ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==47) ) {
                alt86=1;
            }
            else if ( (LA86_0==113) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalPoST.g:6492:3: (enumLiteral_0= ':=' )
                    {
                    // InternalPoST.g:6492:3: (enumLiteral_0= ':=' )
                    // InternalPoST.g:6493:4: enumLiteral_0= ':='
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getAssignmentTypeAccess().getInEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAssignmentTypeAccess().getInEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6500:3: (enumLiteral_1= '=>' )
                    {
                    // InternalPoST.g:6500:3: (enumLiteral_1= '=>' )
                    // InternalPoST.g:6501:4: enumLiteral_1= '=>'
                    {
                    enumLiteral_1=(Token)match(input,113,FOLLOW_2); 

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
    // InternalPoST.g:6511:1: ruleCompOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) ;
    public final Enumerator ruleCompOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:6517:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) )
            // InternalPoST.g:6518:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            {
            // InternalPoST.g:6518:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==114) ) {
                alt87=1;
            }
            else if ( (LA87_0==115) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalPoST.g:6519:3: (enumLiteral_0= '=' )
                    {
                    // InternalPoST.g:6519:3: (enumLiteral_0= '=' )
                    // InternalPoST.g:6520:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getCompOperatorAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompOperatorAccess().getEQUALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6527:3: (enumLiteral_1= '<>' )
                    {
                    // InternalPoST.g:6527:3: (enumLiteral_1= '<>' )
                    // InternalPoST.g:6528:4: enumLiteral_1= '<>'
                    {
                    enumLiteral_1=(Token)match(input,115,FOLLOW_2); 

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
    // InternalPoST.g:6538:1: ruleEquOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleEquOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalPoST.g:6544:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) )
            // InternalPoST.g:6545:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalPoST.g:6545:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            int alt88=4;
            switch ( input.LA(1) ) {
            case 116:
                {
                alt88=1;
                }
                break;
            case 117:
                {
                alt88=2;
                }
                break;
            case 118:
                {
                alt88=3;
                }
                break;
            case 119:
                {
                alt88=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalPoST.g:6546:3: (enumLiteral_0= '<' )
                    {
                    // InternalPoST.g:6546:3: (enumLiteral_0= '<' )
                    // InternalPoST.g:6547:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEquOperatorAccess().getLESSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6554:3: (enumLiteral_1= '>' )
                    {
                    // InternalPoST.g:6554:3: (enumLiteral_1= '>' )
                    // InternalPoST.g:6555:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEquOperatorAccess().getGREATEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:6562:3: (enumLiteral_2= '<=' )
                    {
                    // InternalPoST.g:6562:3: (enumLiteral_2= '<=' )
                    // InternalPoST.g:6563:4: enumLiteral_2= '<='
                    {
                    enumLiteral_2=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getLESS_EQUEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getEquOperatorAccess().getLESS_EQUEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalPoST.g:6570:3: (enumLiteral_3= '>=' )
                    {
                    // InternalPoST.g:6570:3: (enumLiteral_3= '>=' )
                    // InternalPoST.g:6571:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,119,FOLLOW_2); 

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
    // InternalPoST.g:6581:1: ruleAddOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:6587:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalPoST.g:6588:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalPoST.g:6588:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==120) ) {
                alt89=1;
            }
            else if ( (LA89_0==112) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // InternalPoST.g:6589:3: (enumLiteral_0= '+' )
                    {
                    // InternalPoST.g:6589:3: (enumLiteral_0= '+' )
                    // InternalPoST.g:6590:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getAddOperatorAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOperatorAccess().getPLUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6597:3: (enumLiteral_1= '-' )
                    {
                    // InternalPoST.g:6597:3: (enumLiteral_1= '-' )
                    // InternalPoST.g:6598:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_2); 

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
    // InternalPoST.g:6608:1: ruleMulOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) ) ;
    public final Enumerator ruleMulOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalPoST.g:6614:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) ) )
            // InternalPoST.g:6615:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) )
            {
            // InternalPoST.g:6615:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) )
            int alt90=3;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt90=1;
                }
                break;
            case 121:
                {
                alt90=2;
                }
                break;
            case 122:
                {
                alt90=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalPoST.g:6616:3: (enumLiteral_0= '*' )
                    {
                    // InternalPoST.g:6616:3: (enumLiteral_0= '*' )
                    // InternalPoST.g:6617:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getMulOperatorAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMulOperatorAccess().getMULEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6624:3: (enumLiteral_1= '/' )
                    {
                    // InternalPoST.g:6624:3: (enumLiteral_1= '/' )
                    // InternalPoST.g:6625:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getMulOperatorAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMulOperatorAccess().getDIVEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:6632:3: (enumLiteral_2= 'MOD' )
                    {
                    // InternalPoST.g:6632:3: (enumLiteral_2= 'MOD' )
                    // InternalPoST.g:6633:4: enumLiteral_2= 'MOD'
                    {
                    enumLiteral_2=(Token)match(input,122,FOLLOW_2); 

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
    // InternalPoST.g:6643:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:6649:2: ( ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) ) )
            // InternalPoST.g:6650:2: ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) )
            {
            // InternalPoST.g:6650:2: ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==123) ) {
                alt91=1;
            }
            else if ( (LA91_0==112) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalPoST.g:6651:3: (enumLiteral_0= 'NOT' )
                    {
                    // InternalPoST.g:6651:3: (enumLiteral_0= 'NOT' )
                    // InternalPoST.g:6652:4: enumLiteral_0= 'NOT'
                    {
                    enumLiteral_0=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getUnaryOperatorAccess().getNOTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getNOTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:6659:3: (enumLiteral_1= '-' )
                    {
                    // InternalPoST.g:6659:3: (enumLiteral_1= '-' )
                    // InternalPoST.g:6660:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_2); 

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


    protected DFA69 dfa69 = new DFA69(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\4\1\uffff\1\60\1\4\2\uffff\1\60";
    static final String dfa_3s = "\1\140\1\uffff\1\147\1\4\2\uffff\1\147";
    static final String dfa_4s = "\1\uffff\1\3\2\uffff\1\1\1\2\1\uffff";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\133\uffff\1\1",
            "",
            "\1\3\2\uffff\1\4\63\uffff\1\5",
            "\1\6",
            "",
            "",
            "\1\3\2\uffff\1\4\63\uffff\1\5"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 5353:3: ( ( ( (lv_varsSimple_3_0= ruleVarInitDeclaration ) ) otherlv_4= ';' ) | ( ( (lv_varsAs_5_0= ruleGlobalVarInitDeclaration ) ) otherlv_6= ';' ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0282004000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000018000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0002140000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0002100000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000007F84100L,0x0001000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0010000000000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000800000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000007F84110L,0x0001000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0020000000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0050000000000000L,0x0000006E80000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0110000000000000L,0x0000006E80000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0110000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x8400000000000010L,0x0000000EE5091478L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x1800000000000000L,0x0000022E80000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x1800000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0xE000000000000010L,0x00000000650914F8L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xC000000000000010L,0x00000000650914F8L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0020000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x8000000000000010L,0x0000000065091678L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0010200007F84110L,0x0801000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x000C000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x00F0000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0101000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0600200000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0010200007F84110L,0x0001000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x8000000000000012L,0x0000000065091478L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x8000000000000010L,0x000000006509F478L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x000000000000E000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x8000000000000010L,0x0000000065099478L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000300100L,0x0001000000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000300100L,0x0001000000044000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x8000000000000010L,0x00000000650D1478L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x8000000000000010L,0x0000000065091478L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x8000000000000010L,0x0000000065291478L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x8000000000000010L,0x0000000067091478L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x8000000000000010L,0x000000006D091478L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x00000000003F0000L,0x0000100000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000010L,0x0000000100000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000010L,0x0000001100000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0010200007F84110L,0x0801200000000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0001000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000008000L,0x0001000000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000004000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000004000000L});

}
