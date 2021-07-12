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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SINGLE_DECLARATION", "RULE_INTERVAL_DECLARATION", "RULE_PRIORITY_DECLARATION", "RULE_INTEGER", "RULE_OR_OPERATOR", "RULE_XOR_OPERATOR", "RULE_AND_OPERATOR", "RULE_POWER_OPERATOR", "RULE_DIRECT_VARIABLE", "RULE_TIME_PREF_LITERAL", "RULE_INTERVAL", "RULE_BIT_STRING_TYPE_NAME", "RULE_TIME_TYPE_NAME", "RULE_STRING_TYPE_NAME", "RULE_REAL_TYPE_NAME", "RULE_SIGNED_INTEGER_TYPE_NAME", "RULE_UNSIGNED_INTEGER_TYPE_NAME", "RULE_BINARY_INTEGER", "RULE_OCTAL_INTEGER", "RULE_HEX_INTEGER", "RULE_BOOLEAN_LITERAL", "RULE_REAL", "RULE_DIRECT_TYPE_PREFIX", "RULE_DIRECT_SIZE_PREFIX", "RULE_DIGIT", "RULE_BIT", "RULE_OCTAL_DIGIT", "RULE_HEX_DIGIT", "RULE_LETTER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'CONFIGURATION'", "'END_CONFIGURATION'", "'RESOURCE'", "'ON'", "'END_RESOURCE'", "';'", "'TASK'", "'('", "')'", "':='", "','", "'PROGRAM'", "'WITH'", "':'", "'PROCESS'", "'ACTIVE'", "'END_PROGRAM'", "'FUNCTION_BLOCK'", "'END_FUNCTION_BLOCK'", "'END_PROCESS'", "'STATE'", "'LOOPED'", "'END_STATE'", "'SET'", "'NEXT'", "'IN'", "'INACTIVE'", "'STOP'", "'ERROR'", "'START'", "'RESTART'", "'TIMEOUT'", "'THEN'", "'END_TIMEOUT'", "'RESET'", "'TIMER'", "'IF'", "'ELSIF'", "'ELSE'", "'END_IF'", "'CASE'", "'OF'", "'END_CASE'", "'FOR'", "'DO'", "'END_FOR'", "'TO'", "'BY'", "'WHILE'", "'END_WHILE'", "'REPEAT'", "'UNTIL'", "'END_REPEAT'", "'RETURN'", "'EXIT'", "'['", "']'", "'VAR_INPUT'", "'END_VAR'", "'VAR_OUTPUT'", "'VAR_IN_OUT'", "'VAR'", "'CONSTANT'", "'VAR_TEMP'", "'VAR_EXTERNAL'", "'VAR_GLOBAL'", "'AT'", "'ARRAY'", "'..'", "'#'", "'-'", "'=>'", "'='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'+'", "'*'", "'/'", "'MOD'", "'NOT'"
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
    // InternalPoST.g:72:1: ruleModel returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_confs_1_0 = null;

        EObject lv_globVars_2_0 = null;

        EObject lv_programs_3_0 = null;

        EObject lv_fbs_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:78:2: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) ) ) )
            // InternalPoST.g:79:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) ) )
            {
            // InternalPoST.g:79:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) ) )
            // InternalPoST.g:80:3: ( ( ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) )
            {
            // InternalPoST.g:80:3: ( ( ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* ) )
            // InternalPoST.g:81:4: ( ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* )
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getModelAccess().getUnorderedGroup());
            			
            // InternalPoST.g:84:4: ( ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )* )
            // InternalPoST.g:85:5: ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )*
            {
            // InternalPoST.g:85:5: ( ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_globVars_2_0= ruleGlobalVarDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_programs_3_0= ruleProgram ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_fbs_4_0= ruleFunctionBlock ) ) )+ ) ) )*
            loop4:
            do {
                int alt4=5;
                int LA4_0 = input.LA(1);

                if ( LA4_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 0) ) {
                    alt4=1;
                }
                else if ( LA4_0 == 103 && getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 1) ) {
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
            	    // InternalPoST.g:86:3: ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) )
            	    {
            	    // InternalPoST.g:86:3: ({...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) ) )
            	    // InternalPoST.g:87:4: {...}? => ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getModelAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalPoST.g:87:99: ( ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) ) )
            	    // InternalPoST.g:88:5: ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getModelAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalPoST.g:91:8: ({...}? => ( (lv_confs_1_0= ruleConfiguration ) ) )
            	    // InternalPoST.g:91:9: {...}? => ( (lv_confs_1_0= ruleConfiguration ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModel", "true");
            	    }
            	    // InternalPoST.g:91:18: ( (lv_confs_1_0= ruleConfiguration ) )
            	    // InternalPoST.g:91:19: (lv_confs_1_0= ruleConfiguration )
            	    {
            	    // InternalPoST.g:91:19: (lv_confs_1_0= ruleConfiguration )
            	    // InternalPoST.g:92:9: lv_confs_1_0= ruleConfiguration
            	    {

            	    									newCompositeNode(grammarAccess.getModelAccess().getConfsConfigurationParserRuleCall_0_0());
            	    								
            	    pushFollow(FOLLOW_3);
            	    lv_confs_1_0=ruleConfiguration();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getModelRule());
            	    									}
            	    									set(
            	    										current,
            	    										"confs",
            	    										lv_confs_1_0,
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

            	        if ( (LA1_0==103) ) {
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

                if ( (LA5_0==103) ) {
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

                if ( (LA6_0==103) ) {
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
            else if ( (LA13_0==RULE_INTEGER||LA13_0==RULE_TIME_PREF_LITERAL||(LA13_0>=RULE_REAL_TYPE_NAME && LA13_0<=RULE_REAL)||LA13_0==108) ) {
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
    // InternalPoST.g:954:1: ruleTemplateProcessConfElement returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleProcessTemplateElements ) ) otherlv_7= ')' )? ) ;
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
            // InternalPoST.g:960:2: ( (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleProcessTemplateElements ) ) otherlv_7= ')' )? ) )
            // InternalPoST.g:961:2: (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleProcessTemplateElements ) ) otherlv_7= ')' )? )
            {
            // InternalPoST.g:961:2: (otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleProcessTemplateElements ) ) otherlv_7= ')' )? )
            // InternalPoST.g:962:3: otherlv_0= 'PROCESS' ( (lv_active_1_0= 'ACTIVE' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ruleProcessTemplateElements ) ) otherlv_7= ')' )?
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

            // InternalPoST.g:1015:3: (otherlv_5= '(' ( (lv_args_6_0= ruleProcessTemplateElements ) ) otherlv_7= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==45) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalPoST.g:1016:4: otherlv_5= '(' ( (lv_args_6_0= ruleProcessTemplateElements ) ) otherlv_7= ')'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getTemplateProcessConfElementAccess().getLeftParenthesisKeyword_5_0());
                    			
                    // InternalPoST.g:1020:4: ( (lv_args_6_0= ruleProcessTemplateElements ) )
                    // InternalPoST.g:1021:5: (lv_args_6_0= ruleProcessTemplateElements )
                    {
                    // InternalPoST.g:1021:5: (lv_args_6_0= ruleProcessTemplateElements )
                    // InternalPoST.g:1022:6: lv_args_6_0= ruleProcessTemplateElements
                    {

                    						newCompositeNode(grammarAccess.getTemplateProcessConfElementAccess().getArgsProcessTemplateElementsParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_args_6_0=ruleProcessTemplateElements();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTemplateProcessConfElementRule());
                    						}
                    						set(
                    							current,
                    							"args",
                    							lv_args_6_0,
                    							"su.nsk.iae.post.PoST.ProcessTemplateElements");
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


    // $ANTLR start "entryRuleProcessTemplateElements"
    // InternalPoST.g:1048:1: entryRuleProcessTemplateElements returns [EObject current=null] : iv_ruleProcessTemplateElements= ruleProcessTemplateElements EOF ;
    public final EObject entryRuleProcessTemplateElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessTemplateElements = null;


        try {
            // InternalPoST.g:1048:64: (iv_ruleProcessTemplateElements= ruleProcessTemplateElements EOF )
            // InternalPoST.g:1049:2: iv_ruleProcessTemplateElements= ruleProcessTemplateElements EOF
            {
             newCompositeNode(grammarAccess.getProcessTemplateElementsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessTemplateElements=ruleProcessTemplateElements();

            state._fsp--;

             current =iv_ruleProcessTemplateElements; 
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
    // $ANTLR end "entryRuleProcessTemplateElements"


    // $ANTLR start "ruleProcessTemplateElements"
    // InternalPoST.g:1055:1: ruleProcessTemplateElements returns [EObject current=null] : ( ( (lv_elements_0_0= ruleAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleAttachVariableConfElement ) ) )* ) ;
    public final EObject ruleProcessTemplateElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1061:2: ( ( ( (lv_elements_0_0= ruleAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleAttachVariableConfElement ) ) )* ) )
            // InternalPoST.g:1062:2: ( ( (lv_elements_0_0= ruleAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleAttachVariableConfElement ) ) )* )
            {
            // InternalPoST.g:1062:2: ( ( (lv_elements_0_0= ruleAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleAttachVariableConfElement ) ) )* )
            // InternalPoST.g:1063:3: ( (lv_elements_0_0= ruleAttachVariableConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleAttachVariableConfElement ) ) )*
            {
            // InternalPoST.g:1063:3: ( (lv_elements_0_0= ruleAttachVariableConfElement ) )
            // InternalPoST.g:1064:4: (lv_elements_0_0= ruleAttachVariableConfElement )
            {
            // InternalPoST.g:1064:4: (lv_elements_0_0= ruleAttachVariableConfElement )
            // InternalPoST.g:1065:5: lv_elements_0_0= ruleAttachVariableConfElement
            {

            					newCompositeNode(grammarAccess.getProcessTemplateElementsAccess().getElementsAttachVariableConfElementParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_elements_0_0=ruleAttachVariableConfElement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProcessTemplateElementsRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_0_0,
            						"su.nsk.iae.post.PoST.AttachVariableConfElement");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:1082:3: (otherlv_1= ',' ( (lv_elements_2_0= ruleAttachVariableConfElement ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==48) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPoST.g:1083:4: otherlv_1= ',' ( (lv_elements_2_0= ruleAttachVariableConfElement ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getProcessTemplateElementsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:1087:4: ( (lv_elements_2_0= ruleAttachVariableConfElement ) )
            	    // InternalPoST.g:1088:5: (lv_elements_2_0= ruleAttachVariableConfElement )
            	    {
            	    // InternalPoST.g:1088:5: (lv_elements_2_0= ruleAttachVariableConfElement )
            	    // InternalPoST.g:1089:6: lv_elements_2_0= ruleAttachVariableConfElement
            	    {

            	    						newCompositeNode(grammarAccess.getProcessTemplateElementsAccess().getElementsAttachVariableConfElementParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_elements_2_0=ruleAttachVariableConfElement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessTemplateElementsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_2_0,
            	    							"su.nsk.iae.post.PoST.AttachVariableConfElement");
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
    // $ANTLR end "ruleProcessTemplateElements"


    // $ANTLR start "entryRuleProgram"
    // InternalPoST.g:1111:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalPoST.g:1111:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalPoST.g:1112:2: iv_ruleProgram= ruleProgram EOF
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
    // InternalPoST.g:1118:1: ruleProgram returns [EObject current=null] : (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' ) ;
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
            // InternalPoST.g:1124:2: ( (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' ) )
            // InternalPoST.g:1125:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' )
            {
            // InternalPoST.g:1125:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' )
            // InternalPoST.g:1126:3: otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramAccess().getPROGRAMKeyword_0());
            		
            // InternalPoST.g:1130:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1131:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1131:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1132:5: lv_name_1_0= RULE_ID
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

            // InternalPoST.g:1148:3: ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )*
            loop17:
            do {
                int alt17=7;
                switch ( input.LA(1) ) {
                case 95:
                    {
                    alt17=1;
                    }
                    break;
                case 97:
                    {
                    alt17=2;
                    }
                    break;
                case 98:
                    {
                    alt17=3;
                    }
                    break;
                case 99:
                    {
                    alt17=4;
                    }
                    break;
                case 101:
                    {
                    alt17=5;
                    }
                    break;
                case 102:
                    {
                    alt17=6;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // InternalPoST.g:1149:4: ( (lv_progInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1149:4: ( (lv_progInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1150:5: (lv_progInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1150:5: (lv_progInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1151:6: lv_progInVars_2_0= ruleInputVarDeclaration
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
            	    // InternalPoST.g:1169:4: ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1169:4: ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1170:5: (lv_progOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1170:5: (lv_progOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1171:6: lv_progOutVars_3_0= ruleOutputVarDeclaration
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
            	    // InternalPoST.g:1189:4: ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1189:4: ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1190:5: (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1190:5: (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1191:6: lv_progInOutVars_4_0= ruleInputOutputVarDeclaration
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
            	    // InternalPoST.g:1209:4: ( (lv_progVars_5_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1209:4: ( (lv_progVars_5_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1210:5: (lv_progVars_5_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1210:5: (lv_progVars_5_0= ruleVarDeclaration )
            	    // InternalPoST.g:1211:6: lv_progVars_5_0= ruleVarDeclaration
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
            	    // InternalPoST.g:1229:4: ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1229:4: ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1230:5: (lv_progTempVars_6_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1230:5: (lv_progTempVars_6_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1231:6: lv_progTempVars_6_0= ruleTempVarDeclaration
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
            	    // InternalPoST.g:1249:4: ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1249:4: ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) )
            	    // InternalPoST.g:1250:5: (lv_progExternVars_7_0= ruleExternalVarDeclaration )
            	    {
            	    // InternalPoST.g:1250:5: (lv_progExternVars_7_0= ruleExternalVarDeclaration )
            	    // InternalPoST.g:1251:6: lv_progExternVars_7_0= ruleExternalVarDeclaration
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
            	    break loop17;
                }
            } while (true);

            // InternalPoST.g:1269:3: ( (lv_processes_8_0= ruleProcess ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==52) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalPoST.g:1270:4: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalPoST.g:1270:4: (lv_processes_8_0= ruleProcess )
            	    // InternalPoST.g:1271:5: lv_processes_8_0= ruleProcess
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
            	    break loop18;
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
    // InternalPoST.g:1296:1: entryRuleFunctionBlock returns [EObject current=null] : iv_ruleFunctionBlock= ruleFunctionBlock EOF ;
    public final EObject entryRuleFunctionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionBlock = null;


        try {
            // InternalPoST.g:1296:54: (iv_ruleFunctionBlock= ruleFunctionBlock EOF )
            // InternalPoST.g:1297:2: iv_ruleFunctionBlock= ruleFunctionBlock EOF
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
    // InternalPoST.g:1303:1: ruleFunctionBlock returns [EObject current=null] : (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' ) ;
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
            // InternalPoST.g:1309:2: ( (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' ) )
            // InternalPoST.g:1310:2: (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' )
            {
            // InternalPoST.g:1310:2: (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' )
            // InternalPoST.g:1311:3: otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionBlockAccess().getFUNCTION_BLOCKKeyword_0());
            		
            // InternalPoST.g:1315:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1316:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1316:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1317:5: lv_name_1_0= RULE_ID
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

            // InternalPoST.g:1333:3: ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )*
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
            	    // InternalPoST.g:1334:4: ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1334:4: ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1335:5: (lv_fbInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1335:5: (lv_fbInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1336:6: lv_fbInVars_2_0= ruleInputVarDeclaration
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
            	    // InternalPoST.g:1354:4: ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1354:4: ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1355:5: (lv_fbOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1355:5: (lv_fbOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1356:6: lv_fbOutVars_3_0= ruleOutputVarDeclaration
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
            	    // InternalPoST.g:1374:4: ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1374:4: ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1375:5: (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1375:5: (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1376:6: lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration
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
            	    // InternalPoST.g:1394:4: ( (lv_fbVars_5_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1394:4: ( (lv_fbVars_5_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1395:5: (lv_fbVars_5_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1395:5: (lv_fbVars_5_0= ruleVarDeclaration )
            	    // InternalPoST.g:1396:6: lv_fbVars_5_0= ruleVarDeclaration
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
            	    // InternalPoST.g:1414:4: ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1414:4: ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1415:5: (lv_fbTempVars_6_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1415:5: (lv_fbTempVars_6_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1416:6: lv_fbTempVars_6_0= ruleTempVarDeclaration
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
            	    // InternalPoST.g:1434:4: ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1434:4: ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) )
            	    // InternalPoST.g:1435:5: (lv_fbExternVars_7_0= ruleExternalVarDeclaration )
            	    {
            	    // InternalPoST.g:1435:5: (lv_fbExternVars_7_0= ruleExternalVarDeclaration )
            	    // InternalPoST.g:1436:6: lv_fbExternVars_7_0= ruleExternalVarDeclaration
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
            	    break loop19;
                }
            } while (true);

            // InternalPoST.g:1454:3: ( (lv_processes_8_0= ruleProcess ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==52) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPoST.g:1455:4: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalPoST.g:1455:4: (lv_processes_8_0= ruleProcess )
            	    // InternalPoST.g:1456:5: lv_processes_8_0= ruleProcess
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
            	    break loop20;
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
    // InternalPoST.g:1481:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalPoST.g:1481:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalPoST.g:1482:2: iv_ruleProcess= ruleProcess EOF
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
    // InternalPoST.g:1488:1: ruleProcess returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procVars_5_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_6_0= ruleTempVarDeclaration ) ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= 'END_PROCESS' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_8=null;
        EObject lv_procInVars_2_0 = null;

        EObject lv_procOutVars_3_0 = null;

        EObject lv_procInOutVars_4_0 = null;

        EObject lv_procVars_5_0 = null;

        EObject lv_procTempVars_6_0 = null;

        EObject lv_states_7_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1494:2: ( (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procVars_5_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_6_0= ruleTempVarDeclaration ) ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= 'END_PROCESS' ) )
            // InternalPoST.g:1495:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procVars_5_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_6_0= ruleTempVarDeclaration ) ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= 'END_PROCESS' )
            {
            // InternalPoST.g:1495:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procVars_5_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_6_0= ruleTempVarDeclaration ) ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= 'END_PROCESS' )
            // InternalPoST.g:1496:3: otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procVars_5_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_6_0= ruleTempVarDeclaration ) ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= 'END_PROCESS'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:1500:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1501:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1501:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1502:5: lv_name_1_0= RULE_ID
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

            // InternalPoST.g:1518:3: ( ( (lv_procInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_procVars_5_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_6_0= ruleTempVarDeclaration ) ) )*
            loop21:
            do {
                int alt21=6;
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

                }

                switch (alt21) {
            	case 1 :
            	    // InternalPoST.g:1519:4: ( (lv_procInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1519:4: ( (lv_procInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1520:5: (lv_procInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1520:5: (lv_procInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1521:6: lv_procInVars_2_0= ruleInputVarDeclaration
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
            	    // InternalPoST.g:1539:4: ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1539:4: ( (lv_procOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1540:5: (lv_procOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1540:5: (lv_procOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1541:6: lv_procOutVars_3_0= ruleOutputVarDeclaration
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
            	    // InternalPoST.g:1559:4: ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1559:4: ( (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1560:5: (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1560:5: (lv_procInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1561:6: lv_procInOutVars_4_0= ruleInputOutputVarDeclaration
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
            	    // InternalPoST.g:1579:4: ( (lv_procVars_5_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1579:4: ( (lv_procVars_5_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1580:5: (lv_procVars_5_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1580:5: (lv_procVars_5_0= ruleVarDeclaration )
            	    // InternalPoST.g:1581:6: lv_procVars_5_0= ruleVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcVarsVarDeclarationParserRuleCall_2_3_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_procVars_5_0=ruleVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procVars",
            	    							lv_procVars_5_0,
            	    							"su.nsk.iae.post.PoST.VarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalPoST.g:1599:4: ( (lv_procTempVars_6_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1599:4: ( (lv_procTempVars_6_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1600:5: (lv_procTempVars_6_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1600:5: (lv_procTempVars_6_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1601:6: lv_procTempVars_6_0= ruleTempVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcTempVarsTempVarDeclarationParserRuleCall_2_4_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_procTempVars_6_0=ruleTempVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procTempVars",
            	    							lv_procTempVars_6_0,
            	    							"su.nsk.iae.post.PoST.TempVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalPoST.g:1619:3: ( (lv_states_7_0= ruleState ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==58) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPoST.g:1620:4: (lv_states_7_0= ruleState )
            	    {
            	    // InternalPoST.g:1620:4: (lv_states_7_0= ruleState )
            	    // InternalPoST.g:1621:5: lv_states_7_0= ruleState
            	    {

            	    					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_states_7_0=ruleState();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProcessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"states",
            	    						lv_states_7_0,
            	    						"su.nsk.iae.post.PoST.State");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_8=(Token)match(input,57,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getProcessAccess().getEND_PROCESSKeyword_4());
            		

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
    // InternalPoST.g:1646:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalPoST.g:1646:46: (iv_ruleState= ruleState EOF )
            // InternalPoST.g:1647:2: iv_ruleState= ruleState EOF
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
    // InternalPoST.g:1653:1: ruleState returns [EObject current=null] : (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' ) ;
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
            // InternalPoST.g:1659:2: ( (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' ) )
            // InternalPoST.g:1660:2: (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' )
            {
            // InternalPoST.g:1660:2: (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' )
            // InternalPoST.g:1661:3: otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getSTATEKeyword_0());
            		
            // InternalPoST.g:1665:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1666:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1666:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1667:5: lv_name_1_0= RULE_ID
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

            // InternalPoST.g:1683:3: ( (lv_looped_2_0= 'LOOPED' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==59) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalPoST.g:1684:4: (lv_looped_2_0= 'LOOPED' )
                    {
                    // InternalPoST.g:1684:4: (lv_looped_2_0= 'LOOPED' )
                    // InternalPoST.g:1685:5: lv_looped_2_0= 'LOOPED'
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

            // InternalPoST.g:1697:3: ( (lv_statement_3_0= ruleStatementList ) )
            // InternalPoST.g:1698:4: (lv_statement_3_0= ruleStatementList )
            {
            // InternalPoST.g:1698:4: (lv_statement_3_0= ruleStatementList )
            // InternalPoST.g:1699:5: lv_statement_3_0= ruleStatementList
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

            // InternalPoST.g:1716:3: ( (lv_timeout_4_0= ruleTimeoutStatement ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==69) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalPoST.g:1717:4: (lv_timeout_4_0= ruleTimeoutStatement )
                    {
                    // InternalPoST.g:1717:4: (lv_timeout_4_0= ruleTimeoutStatement )
                    // InternalPoST.g:1718:5: lv_timeout_4_0= ruleTimeoutStatement
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
    // InternalPoST.g:1743:1: entryRuleSetStateStatement returns [EObject current=null] : iv_ruleSetStateStatement= ruleSetStateStatement EOF ;
    public final EObject entryRuleSetStateStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStatement = null;


        try {
            // InternalPoST.g:1743:58: (iv_ruleSetStateStatement= ruleSetStateStatement EOF )
            // InternalPoST.g:1744:2: iv_ruleSetStateStatement= ruleSetStateStatement EOF
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
    // InternalPoST.g:1750:1: ruleSetStateStatement returns [EObject current=null] : ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) ) ;
    public final EObject ruleSetStateStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_next_4_0=null;


        	enterRule();

        try {
            // InternalPoST.g:1756:2: ( ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) ) )
            // InternalPoST.g:1757:2: ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) )
            {
            // InternalPoST.g:1757:2: ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) )
            // InternalPoST.g:1758:3: () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) )
            {
            // InternalPoST.g:1758:3: ()
            // InternalPoST.g:1759:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSetStateStatementAccess().getSetStateStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,61,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getSetStateStatementAccess().getSETKeyword_1());
            		
            // InternalPoST.g:1769:3: ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==58) ) {
                alt25=1;
            }
            else if ( (LA25_0==62) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalPoST.g:1770:4: (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalPoST.g:1770:4: (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) )
                    // InternalPoST.g:1771:5: otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,58,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getSetStateStatementAccess().getSTATEKeyword_2_0_0());
                    				
                    // InternalPoST.g:1775:5: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:1776:6: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:1776:6: (otherlv_3= RULE_ID )
                    // InternalPoST.g:1777:7: otherlv_3= RULE_ID
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
                    // InternalPoST.g:1790:4: ( (lv_next_4_0= 'NEXT' ) )
                    {
                    // InternalPoST.g:1790:4: ( (lv_next_4_0= 'NEXT' ) )
                    // InternalPoST.g:1791:5: (lv_next_4_0= 'NEXT' )
                    {
                    // InternalPoST.g:1791:5: (lv_next_4_0= 'NEXT' )
                    // InternalPoST.g:1792:6: lv_next_4_0= 'NEXT'
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
    // InternalPoST.g:1809:1: entryRuleProcessStatements returns [EObject current=null] : iv_ruleProcessStatements= ruleProcessStatements EOF ;
    public final EObject entryRuleProcessStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessStatements = null;


        try {
            // InternalPoST.g:1809:58: (iv_ruleProcessStatements= ruleProcessStatements EOF )
            // InternalPoST.g:1810:2: iv_ruleProcessStatements= ruleProcessStatements EOF
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
    // InternalPoST.g:1816:1: ruleProcessStatements returns [EObject current=null] : (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement ) ;
    public final EObject ruleProcessStatements() throws RecognitionException {
        EObject current = null;

        EObject this_StartProcessStatement_0 = null;

        EObject this_StopProcessStatement_1 = null;

        EObject this_ErrorProcessStatement_2 = null;



        	enterRule();

        try {
            // InternalPoST.g:1822:2: ( (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement ) )
            // InternalPoST.g:1823:2: (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement )
            {
            // InternalPoST.g:1823:2: (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 67:
            case 68:
                {
                alt26=1;
                }
                break;
            case 65:
                {
                alt26=2;
                }
                break;
            case 66:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalPoST.g:1824:3: this_StartProcessStatement_0= ruleStartProcessStatement
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
                    // InternalPoST.g:1833:3: this_StopProcessStatement_1= ruleStopProcessStatement
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
                    // InternalPoST.g:1842:3: this_ErrorProcessStatement_2= ruleErrorProcessStatement
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
    // InternalPoST.g:1854:1: entryRuleProcessStatusExpression returns [EObject current=null] : iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF ;
    public final EObject entryRuleProcessStatusExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessStatusExpression = null;


        try {
            // InternalPoST.g:1854:64: (iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF )
            // InternalPoST.g:1855:2: iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF
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
    // InternalPoST.g:1861:1: ruleProcessStatusExpression returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) ) ;
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
            // InternalPoST.g:1867:2: ( (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) ) )
            // InternalPoST.g:1868:2: (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) )
            {
            // InternalPoST.g:1868:2: (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) )
            // InternalPoST.g:1869:3: otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessStatusExpressionAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:1873:3: ( (otherlv_1= RULE_ID ) )
            // InternalPoST.g:1874:4: (otherlv_1= RULE_ID )
            {
            // InternalPoST.g:1874:4: (otherlv_1= RULE_ID )
            // InternalPoST.g:1875:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessStatusExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(otherlv_1, grammarAccess.getProcessStatusExpressionAccess().getProcessProcessCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,63,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getProcessStatusExpressionAccess().getINKeyword_2());
            		
            otherlv_3=(Token)match(input,58,FOLLOW_40); 

            			newLeafNode(otherlv_3, grammarAccess.getProcessStatusExpressionAccess().getSTATEKeyword_3());
            		
            // InternalPoST.g:1894:3: ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) )
            int alt27=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt27=1;
                }
                break;
            case 64:
                {
                alt27=2;
                }
                break;
            case 65:
                {
                alt27=3;
                }
                break;
            case 66:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalPoST.g:1895:4: ( (lv_active_4_0= 'ACTIVE' ) )
                    {
                    // InternalPoST.g:1895:4: ( (lv_active_4_0= 'ACTIVE' ) )
                    // InternalPoST.g:1896:5: (lv_active_4_0= 'ACTIVE' )
                    {
                    // InternalPoST.g:1896:5: (lv_active_4_0= 'ACTIVE' )
                    // InternalPoST.g:1897:6: lv_active_4_0= 'ACTIVE'
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
                    // InternalPoST.g:1910:4: ( (lv_inactive_5_0= 'INACTIVE' ) )
                    {
                    // InternalPoST.g:1910:4: ( (lv_inactive_5_0= 'INACTIVE' ) )
                    // InternalPoST.g:1911:5: (lv_inactive_5_0= 'INACTIVE' )
                    {
                    // InternalPoST.g:1911:5: (lv_inactive_5_0= 'INACTIVE' )
                    // InternalPoST.g:1912:6: lv_inactive_5_0= 'INACTIVE'
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
                    // InternalPoST.g:1925:4: ( (lv_stop_6_0= 'STOP' ) )
                    {
                    // InternalPoST.g:1925:4: ( (lv_stop_6_0= 'STOP' ) )
                    // InternalPoST.g:1926:5: (lv_stop_6_0= 'STOP' )
                    {
                    // InternalPoST.g:1926:5: (lv_stop_6_0= 'STOP' )
                    // InternalPoST.g:1927:6: lv_stop_6_0= 'STOP'
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
                    // InternalPoST.g:1940:4: ( (lv_error_7_0= 'ERROR' ) )
                    {
                    // InternalPoST.g:1940:4: ( (lv_error_7_0= 'ERROR' ) )
                    // InternalPoST.g:1941:5: (lv_error_7_0= 'ERROR' )
                    {
                    // InternalPoST.g:1941:5: (lv_error_7_0= 'ERROR' )
                    // InternalPoST.g:1942:6: lv_error_7_0= 'ERROR'
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
    // InternalPoST.g:1959:1: entryRuleStartProcessStatement returns [EObject current=null] : iv_ruleStartProcessStatement= ruleStartProcessStatement EOF ;
    public final EObject entryRuleStartProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcessStatement = null;


        try {
            // InternalPoST.g:1959:62: (iv_ruleStartProcessStatement= ruleStartProcessStatement EOF )
            // InternalPoST.g:1960:2: iv_ruleStartProcessStatement= ruleStartProcessStatement EOF
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
    // InternalPoST.g:1966:1: ruleStartProcessStatement returns [EObject current=null] : ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) ) ;
    public final EObject ruleStartProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalPoST.g:1972:2: ( ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) ) )
            // InternalPoST.g:1973:2: ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) )
            {
            // InternalPoST.g:1973:2: ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==67) ) {
                alt28=1;
            }
            else if ( (LA28_0==68) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalPoST.g:1974:3: ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) )
                    {
                    // InternalPoST.g:1974:3: ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) )
                    // InternalPoST.g:1975:4: () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalPoST.g:1975:4: ()
                    // InternalPoST.g:1976:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStartProcessStatementAccess().getStartProcessStatementAction_0_0(),
                    						current);
                    				

                    }

                    // InternalPoST.g:1982:4: (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )
                    // InternalPoST.g:1983:5: otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,67,FOLLOW_41); 

                    					newLeafNode(otherlv_1, grammarAccess.getStartProcessStatementAccess().getSTARTKeyword_0_1_0());
                    				
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getStartProcessStatementAccess().getPROCESSKeyword_0_1_1());
                    				
                    // InternalPoST.g:1991:5: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:1992:6: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:1992:6: (otherlv_3= RULE_ID )
                    // InternalPoST.g:1993:7: otherlv_3= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getStartProcessStatementRule());
                    							}
                    						
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    							newLeafNode(otherlv_3, grammarAccess.getStartProcessStatementAccess().getProcessProcessCrossReference_0_1_2_0());
                    						

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:2007:3: ( () otherlv_5= 'RESTART' )
                    {
                    // InternalPoST.g:2007:3: ( () otherlv_5= 'RESTART' )
                    // InternalPoST.g:2008:4: () otherlv_5= 'RESTART'
                    {
                    // InternalPoST.g:2008:4: ()
                    // InternalPoST.g:2009:5: 
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
    // InternalPoST.g:2024:1: entryRuleStopProcessStatement returns [EObject current=null] : iv_ruleStopProcessStatement= ruleStopProcessStatement EOF ;
    public final EObject entryRuleStopProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcessStatement = null;


        try {
            // InternalPoST.g:2024:61: (iv_ruleStopProcessStatement= ruleStopProcessStatement EOF )
            // InternalPoST.g:2025:2: iv_ruleStopProcessStatement= ruleStopProcessStatement EOF
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
    // InternalPoST.g:2031:1: ruleStopProcessStatement returns [EObject current=null] : ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleStopProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPoST.g:2037:2: ( ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalPoST.g:2038:2: ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalPoST.g:2038:2: ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalPoST.g:2039:3: () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalPoST.g:2039:3: ()
            // InternalPoST.g:2040:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStopProcessStatementAccess().getStopProcessStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,65,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getStopProcessStatementAccess().getSTOPKeyword_1());
            		
            // InternalPoST.g:2050:3: (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==52) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalPoST.g:2051:4: otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getStopProcessStatementAccess().getPROCESSKeyword_2_0());
                    			
                    // InternalPoST.g:2055:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:2056:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:2056:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:2057:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStopProcessStatementRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_3, grammarAccess.getStopProcessStatementAccess().getProcessProcessCrossReference_2_1_0());
                    					

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
    // InternalPoST.g:2073:1: entryRuleErrorProcessStatement returns [EObject current=null] : iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF ;
    public final EObject entryRuleErrorProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorProcessStatement = null;


        try {
            // InternalPoST.g:2073:62: (iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF )
            // InternalPoST.g:2074:2: iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF
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
    // InternalPoST.g:2080:1: ruleErrorProcessStatement returns [EObject current=null] : ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleErrorProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPoST.g:2086:2: ( ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalPoST.g:2087:2: ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalPoST.g:2087:2: ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalPoST.g:2088:3: () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalPoST.g:2088:3: ()
            // InternalPoST.g:2089:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getErrorProcessStatementAccess().getErrorProcessStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,66,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getErrorProcessStatementAccess().getERRORKeyword_1());
            		
            // InternalPoST.g:2099:3: (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==52) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalPoST.g:2100:4: otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getErrorProcessStatementAccess().getPROCESSKeyword_2_0());
                    			
                    // InternalPoST.g:2104:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:2105:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:2105:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:2106:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getErrorProcessStatementRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_3, grammarAccess.getErrorProcessStatementAccess().getProcessProcessCrossReference_2_1_0());
                    					

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
    // InternalPoST.g:2122:1: entryRuleTimeoutStatement returns [EObject current=null] : iv_ruleTimeoutStatement= ruleTimeoutStatement EOF ;
    public final EObject entryRuleTimeoutStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutStatement = null;


        try {
            // InternalPoST.g:2122:57: (iv_ruleTimeoutStatement= ruleTimeoutStatement EOF )
            // InternalPoST.g:2123:2: iv_ruleTimeoutStatement= ruleTimeoutStatement EOF
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
    // InternalPoST.g:2129:1: ruleTimeoutStatement returns [EObject current=null] : (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' ) ;
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
            // InternalPoST.g:2135:2: ( (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' ) )
            // InternalPoST.g:2136:2: (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' )
            {
            // InternalPoST.g:2136:2: (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' )
            // InternalPoST.g:2137:3: otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeoutStatementAccess().getTIMEOUTKeyword_0());
            		
            // InternalPoST.g:2141:3: ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_INTEGER||LA31_0==RULE_TIME_PREF_LITERAL||(LA31_0>=RULE_REAL_TYPE_NAME && LA31_0<=RULE_REAL)||LA31_0==108) ) {
                alt31=1;
            }
            else if ( (LA31_0==RULE_ID) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalPoST.g:2142:4: ( (lv_const_1_0= ruleConstant ) )
                    {
                    // InternalPoST.g:2142:4: ( (lv_const_1_0= ruleConstant ) )
                    // InternalPoST.g:2143:5: (lv_const_1_0= ruleConstant )
                    {
                    // InternalPoST.g:2143:5: (lv_const_1_0= ruleConstant )
                    // InternalPoST.g:2144:6: lv_const_1_0= ruleConstant
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
                    // InternalPoST.g:2162:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalPoST.g:2162:4: ( (otherlv_2= RULE_ID ) )
                    // InternalPoST.g:2163:5: (otherlv_2= RULE_ID )
                    {
                    // InternalPoST.g:2163:5: (otherlv_2= RULE_ID )
                    // InternalPoST.g:2164:6: otherlv_2= RULE_ID
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
            		
            // InternalPoST.g:2180:3: ( (lv_statement_4_0= ruleStatementList ) )
            // InternalPoST.g:2181:4: (lv_statement_4_0= ruleStatementList )
            {
            // InternalPoST.g:2181:4: (lv_statement_4_0= ruleStatementList )
            // InternalPoST.g:2182:5: lv_statement_4_0= ruleStatementList
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
    // InternalPoST.g:2207:1: entryRuleResetTimerStatement returns [EObject current=null] : iv_ruleResetTimerStatement= ruleResetTimerStatement EOF ;
    public final EObject entryRuleResetTimerStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetTimerStatement = null;


        try {
            // InternalPoST.g:2207:60: (iv_ruleResetTimerStatement= ruleResetTimerStatement EOF )
            // InternalPoST.g:2208:2: iv_ruleResetTimerStatement= ruleResetTimerStatement EOF
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
    // InternalPoST.g:2214:1: ruleResetTimerStatement returns [EObject current=null] : ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' ) ;
    public final EObject ruleResetTimerStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalPoST.g:2220:2: ( ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' ) )
            // InternalPoST.g:2221:2: ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' )
            {
            // InternalPoST.g:2221:2: ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' )
            // InternalPoST.g:2222:3: () otherlv_1= 'RESET' otherlv_2= 'TIMER'
            {
            // InternalPoST.g:2222:3: ()
            // InternalPoST.g:2223:4: 
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
    // InternalPoST.g:2241:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalPoST.g:2241:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalPoST.g:2242:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalPoST.g:2248:1: ruleExpression returns [EObject current=null] : (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token this_OR_OPERATOR_2=null;
        EObject this_XorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2254:2: ( (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* ) )
            // InternalPoST.g:2255:2: (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* )
            {
            // InternalPoST.g:2255:2: (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* )
            // InternalPoST.g:2256:3: this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getExpressionAccess().getXorExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_47);
            this_XorExpression_0=ruleXorExpression();

            state._fsp--;


            			current = this_XorExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2264:3: ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_OR_OPERATOR) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalPoST.g:2265:4: () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) )
            	    {
            	    // InternalPoST.g:2265:4: ()
            	    // InternalPoST.g:2266:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getExpressionAccess().getExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_OR_OPERATOR_2=(Token)match(input,RULE_OR_OPERATOR,FOLLOW_48); 

            	    				newLeafNode(this_OR_OPERATOR_2, grammarAccess.getExpressionAccess().getOR_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2276:4: ( (lv_right_3_0= ruleXorExpression ) )
            	    // InternalPoST.g:2277:5: (lv_right_3_0= ruleXorExpression )
            	    {
            	    // InternalPoST.g:2277:5: (lv_right_3_0= ruleXorExpression )
            	    // InternalPoST.g:2278:6: lv_right_3_0= ruleXorExpression
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
            	    break loop32;
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
    // InternalPoST.g:2300:1: entryRuleXorExpression returns [EObject current=null] : iv_ruleXorExpression= ruleXorExpression EOF ;
    public final EObject entryRuleXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpression = null;


        try {
            // InternalPoST.g:2300:54: (iv_ruleXorExpression= ruleXorExpression EOF )
            // InternalPoST.g:2301:2: iv_ruleXorExpression= ruleXorExpression EOF
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
    // InternalPoST.g:2307:1: ruleXorExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_XOR_OPERATOR_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2313:2: ( (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalPoST.g:2314:2: (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPoST.g:2314:2: (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalPoST.g:2315:3: this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_49);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2323:3: ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_XOR_OPERATOR) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalPoST.g:2324:4: () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalPoST.g:2324:4: ()
            	    // InternalPoST.g:2325:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorExpressionAccess().getXorExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_XOR_OPERATOR_2=(Token)match(input,RULE_XOR_OPERATOR,FOLLOW_48); 

            	    				newLeafNode(this_XOR_OPERATOR_2, grammarAccess.getXorExpressionAccess().getXOR_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2335:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalPoST.g:2336:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalPoST.g:2336:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalPoST.g:2337:6: lv_right_3_0= ruleAndExpression
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
    // $ANTLR end "ruleXorExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalPoST.g:2359:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPoST.g:2359:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPoST.g:2360:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalPoST.g:2366:1: ruleAndExpression returns [EObject current=null] : (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_AND_OPERATOR_2=null;
        EObject this_CompExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2372:2: ( (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* ) )
            // InternalPoST.g:2373:2: (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* )
            {
            // InternalPoST.g:2373:2: (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* )
            // InternalPoST.g:2374:3: this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getCompExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_50);
            this_CompExpression_0=ruleCompExpression();

            state._fsp--;


            			current = this_CompExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2382:3: ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_AND_OPERATOR) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalPoST.g:2383:4: () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) )
            	    {
            	    // InternalPoST.g:2383:4: ()
            	    // InternalPoST.g:2384:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_AND_OPERATOR_2=(Token)match(input,RULE_AND_OPERATOR,FOLLOW_48); 

            	    				newLeafNode(this_AND_OPERATOR_2, grammarAccess.getAndExpressionAccess().getAND_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2394:4: ( (lv_right_3_0= ruleCompExpression ) )
            	    // InternalPoST.g:2395:5: (lv_right_3_0= ruleCompExpression )
            	    {
            	    // InternalPoST.g:2395:5: (lv_right_3_0= ruleCompExpression )
            	    // InternalPoST.g:2396:6: lv_right_3_0= ruleCompExpression
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleCompExpression"
    // InternalPoST.g:2418:1: entryRuleCompExpression returns [EObject current=null] : iv_ruleCompExpression= ruleCompExpression EOF ;
    public final EObject entryRuleCompExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompExpression = null;


        try {
            // InternalPoST.g:2418:55: (iv_ruleCompExpression= ruleCompExpression EOF )
            // InternalPoST.g:2419:2: iv_ruleCompExpression= ruleCompExpression EOF
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
    // InternalPoST.g:2425:1: ruleCompExpression returns [EObject current=null] : (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* ) ;
    public final EObject ruleCompExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EquExpression_0 = null;

        Enumerator lv_compOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2431:2: ( (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* ) )
            // InternalPoST.g:2432:2: (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* )
            {
            // InternalPoST.g:2432:2: (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* )
            // InternalPoST.g:2433:3: this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getCompExpressionAccess().getEquExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_51);
            this_EquExpression_0=ruleEquExpression();

            state._fsp--;


            			current = this_EquExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2441:3: ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=110 && LA35_0<=111)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalPoST.g:2442:4: () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) )
            	    {
            	    // InternalPoST.g:2442:4: ()
            	    // InternalPoST.g:2443:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getCompExpressionAccess().getCompExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2449:4: ( (lv_compOp_2_0= ruleCompOperator ) )
            	    // InternalPoST.g:2450:5: (lv_compOp_2_0= ruleCompOperator )
            	    {
            	    // InternalPoST.g:2450:5: (lv_compOp_2_0= ruleCompOperator )
            	    // InternalPoST.g:2451:6: lv_compOp_2_0= ruleCompOperator
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

            	    // InternalPoST.g:2468:4: ( (lv_right_3_0= ruleEquExpression ) )
            	    // InternalPoST.g:2469:5: (lv_right_3_0= ruleEquExpression )
            	    {
            	    // InternalPoST.g:2469:5: (lv_right_3_0= ruleEquExpression )
            	    // InternalPoST.g:2470:6: lv_right_3_0= ruleEquExpression
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
    // $ANTLR end "ruleCompExpression"


    // $ANTLR start "entryRuleEquExpression"
    // InternalPoST.g:2492:1: entryRuleEquExpression returns [EObject current=null] : iv_ruleEquExpression= ruleEquExpression EOF ;
    public final EObject entryRuleEquExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquExpression = null;


        try {
            // InternalPoST.g:2492:54: (iv_ruleEquExpression= ruleEquExpression EOF )
            // InternalPoST.g:2493:2: iv_ruleEquExpression= ruleEquExpression EOF
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
    // InternalPoST.g:2499:1: ruleEquExpression returns [EObject current=null] : (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* ) ;
    public final EObject ruleEquExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AddExpression_0 = null;

        Enumerator lv_equOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2505:2: ( (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* ) )
            // InternalPoST.g:2506:2: (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* )
            {
            // InternalPoST.g:2506:2: (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* )
            // InternalPoST.g:2507:3: this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getEquExpressionAccess().getAddExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_52);
            this_AddExpression_0=ruleAddExpression();

            state._fsp--;


            			current = this_AddExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2515:3: ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=112 && LA36_0<=115)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalPoST.g:2516:4: () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) )
            	    {
            	    // InternalPoST.g:2516:4: ()
            	    // InternalPoST.g:2517:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEquExpressionAccess().getEquExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2523:4: ( (lv_equOp_2_0= ruleEquOperator ) )
            	    // InternalPoST.g:2524:5: (lv_equOp_2_0= ruleEquOperator )
            	    {
            	    // InternalPoST.g:2524:5: (lv_equOp_2_0= ruleEquOperator )
            	    // InternalPoST.g:2525:6: lv_equOp_2_0= ruleEquOperator
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

            	    // InternalPoST.g:2542:4: ( (lv_right_3_0= ruleAddExpression ) )
            	    // InternalPoST.g:2543:5: (lv_right_3_0= ruleAddExpression )
            	    {
            	    // InternalPoST.g:2543:5: (lv_right_3_0= ruleAddExpression )
            	    // InternalPoST.g:2544:6: lv_right_3_0= ruleAddExpression
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
    // $ANTLR end "ruleEquExpression"


    // $ANTLR start "entryRuleAddExpression"
    // InternalPoST.g:2566:1: entryRuleAddExpression returns [EObject current=null] : iv_ruleAddExpression= ruleAddExpression EOF ;
    public final EObject entryRuleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddExpression = null;


        try {
            // InternalPoST.g:2566:54: (iv_ruleAddExpression= ruleAddExpression EOF )
            // InternalPoST.g:2567:2: iv_ruleAddExpression= ruleAddExpression EOF
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
    // InternalPoST.g:2573:1: ruleAddExpression returns [EObject current=null] : (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* ) ;
    public final EObject ruleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MulExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2579:2: ( (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* ) )
            // InternalPoST.g:2580:2: (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* )
            {
            // InternalPoST.g:2580:2: (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* )
            // InternalPoST.g:2581:3: this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAddExpressionAccess().getMulExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_53);
            this_MulExpression_0=ruleMulExpression();

            state._fsp--;


            			current = this_MulExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2589:3: ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==108||LA37_0==116) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalPoST.g:2590:4: () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) )
            	    {
            	    // InternalPoST.g:2590:4: ()
            	    // InternalPoST.g:2591:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAddExpressionAccess().getAddExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2597:4: ( (lv_addOp_2_0= ruleAddOperator ) )
            	    // InternalPoST.g:2598:5: (lv_addOp_2_0= ruleAddOperator )
            	    {
            	    // InternalPoST.g:2598:5: (lv_addOp_2_0= ruleAddOperator )
            	    // InternalPoST.g:2599:6: lv_addOp_2_0= ruleAddOperator
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

            	    // InternalPoST.g:2616:4: ( (lv_right_3_0= ruleMulExpression ) )
            	    // InternalPoST.g:2617:5: (lv_right_3_0= ruleMulExpression )
            	    {
            	    // InternalPoST.g:2617:5: (lv_right_3_0= ruleMulExpression )
            	    // InternalPoST.g:2618:6: lv_right_3_0= ruleMulExpression
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
    // $ANTLR end "ruleAddExpression"


    // $ANTLR start "entryRuleMulExpression"
    // InternalPoST.g:2640:1: entryRuleMulExpression returns [EObject current=null] : iv_ruleMulExpression= ruleMulExpression EOF ;
    public final EObject entryRuleMulExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMulExpression = null;


        try {
            // InternalPoST.g:2640:54: (iv_ruleMulExpression= ruleMulExpression EOF )
            // InternalPoST.g:2641:2: iv_ruleMulExpression= ruleMulExpression EOF
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
    // InternalPoST.g:2647:1: ruleMulExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) ;
    public final EObject ruleMulExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2653:2: ( (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) )
            // InternalPoST.g:2654:2: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            {
            // InternalPoST.g:2654:2: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            // InternalPoST.g:2655:3: this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMulExpressionAccess().getPowerExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_PowerExpression_0=rulePowerExpression();

            state._fsp--;


            			current = this_PowerExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2663:3: ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=117 && LA38_0<=119)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalPoST.g:2664:4: () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) )
            	    {
            	    // InternalPoST.g:2664:4: ()
            	    // InternalPoST.g:2665:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getMulExpressionAccess().getMulExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2671:4: ( (lv_mulOp_2_0= ruleMulOperator ) )
            	    // InternalPoST.g:2672:5: (lv_mulOp_2_0= ruleMulOperator )
            	    {
            	    // InternalPoST.g:2672:5: (lv_mulOp_2_0= ruleMulOperator )
            	    // InternalPoST.g:2673:6: lv_mulOp_2_0= ruleMulOperator
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

            	    // InternalPoST.g:2690:4: ( (lv_right_3_0= rulePowerExpression ) )
            	    // InternalPoST.g:2691:5: (lv_right_3_0= rulePowerExpression )
            	    {
            	    // InternalPoST.g:2691:5: (lv_right_3_0= rulePowerExpression )
            	    // InternalPoST.g:2692:6: lv_right_3_0= rulePowerExpression
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
    // $ANTLR end "ruleMulExpression"


    // $ANTLR start "entryRulePowerExpression"
    // InternalPoST.g:2714:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // InternalPoST.g:2714:56: (iv_rulePowerExpression= rulePowerExpression EOF )
            // InternalPoST.g:2715:2: iv_rulePowerExpression= rulePowerExpression EOF
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
    // InternalPoST.g:2721:1: rulePowerExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        Token this_POWER_OPERATOR_2=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2727:2: ( (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) )
            // InternalPoST.g:2728:2: (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            {
            // InternalPoST.g:2728:2: (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            // InternalPoST.g:2729:3: this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_55);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;


            			current = this_UnaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2737:3: ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_POWER_OPERATOR) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalPoST.g:2738:4: () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) )
            	    {
            	    // InternalPoST.g:2738:4: ()
            	    // InternalPoST.g:2739:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPowerExpressionAccess().getPowerExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_POWER_OPERATOR_2=(Token)match(input,RULE_POWER_OPERATOR,FOLLOW_48); 

            	    				newLeafNode(this_POWER_OPERATOR_2, grammarAccess.getPowerExpressionAccess().getPOWER_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2749:4: ( (lv_right_3_0= ruleUnaryExpression ) )
            	    // InternalPoST.g:2750:5: (lv_right_3_0= ruleUnaryExpression )
            	    {
            	    // InternalPoST.g:2750:5: (lv_right_3_0= ruleUnaryExpression )
            	    // InternalPoST.g:2751:6: lv_right_3_0= ruleUnaryExpression
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
    // $ANTLR end "rulePowerExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalPoST.g:2773:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPoST.g:2773:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPoST.g:2774:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalPoST.g:2780:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_unOp_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2786:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) ) )
            // InternalPoST.g:2787:2: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) )
            {
            // InternalPoST.g:2787:2: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) )
            int alt40=2;
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
                alt40=1;
                }
                break;
            case 108:
                {
                switch ( input.LA(2) ) {
                case RULE_INTEGER:
                    {
                    alt40=1;
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
                case 108:
                    {
                    alt40=2;
                    }
                    break;
                case RULE_REAL:
                    {
                    alt40=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;
                }

                }
                break;
            case 120:
                {
                alt40=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalPoST.g:2788:3: this_PrimaryExpression_0= rulePrimaryExpression
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
                    // InternalPoST.g:2797:3: ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) )
                    {
                    // InternalPoST.g:2797:3: ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) )
                    // InternalPoST.g:2798:4: ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) )
                    {
                    // InternalPoST.g:2798:4: ( (lv_unOp_1_0= ruleUnaryOperator ) )
                    // InternalPoST.g:2799:5: (lv_unOp_1_0= ruleUnaryOperator )
                    {
                    // InternalPoST.g:2799:5: (lv_unOp_1_0= ruleUnaryOperator )
                    // InternalPoST.g:2800:6: lv_unOp_1_0= ruleUnaryOperator
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

                    // InternalPoST.g:2817:4: ( (lv_right_2_0= rulePrimaryExpression ) )
                    // InternalPoST.g:2818:5: (lv_right_2_0= rulePrimaryExpression )
                    {
                    // InternalPoST.g:2818:5: (lv_right_2_0= rulePrimaryExpression )
                    // InternalPoST.g:2819:6: lv_right_2_0= rulePrimaryExpression
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
    // InternalPoST.g:2841:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPoST.g:2841:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPoST.g:2842:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalPoST.g:2848:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) ;
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
            // InternalPoST.g:2854:2: ( ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) )
            // InternalPoST.g:2855:2: ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            {
            // InternalPoST.g:2855:2: ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            int alt41=5;
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
            case 108:
                {
                alt41=1;
                }
                break;
            case RULE_ID:
                {
                int LA41_2 = input.LA(2);

                if ( (LA41_2==EOF||(LA41_2>=RULE_OR_OPERATOR && LA41_2<=RULE_POWER_OPERATOR)||LA41_2==43||LA41_2==46||LA41_2==70||LA41_2==79||LA41_2==82||(LA41_2>=84 && LA41_2<=85)||LA41_2==90||LA41_2==94||LA41_2==108||(LA41_2>=110 && LA41_2<=119)) ) {
                    alt41=2;
                }
                else if ( (LA41_2==93) ) {
                    alt41=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 2, input);

                    throw nvae;
                }
                }
                break;
            case 52:
                {
                alt41=4;
                }
                break;
            case 45:
                {
                alt41=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalPoST.g:2856:3: ( (lv_const_0_0= ruleConstant ) )
                    {
                    // InternalPoST.g:2856:3: ( (lv_const_0_0= ruleConstant ) )
                    // InternalPoST.g:2857:4: (lv_const_0_0= ruleConstant )
                    {
                    // InternalPoST.g:2857:4: (lv_const_0_0= ruleConstant )
                    // InternalPoST.g:2858:5: lv_const_0_0= ruleConstant
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
                    // InternalPoST.g:2876:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalPoST.g:2876:3: ( (otherlv_1= RULE_ID ) )
                    // InternalPoST.g:2877:4: (otherlv_1= RULE_ID )
                    {
                    // InternalPoST.g:2877:4: (otherlv_1= RULE_ID )
                    // InternalPoST.g:2878:5: otherlv_1= RULE_ID
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
                    // InternalPoST.g:2890:3: ( (lv_array_2_0= ruleArrayVariable ) )
                    {
                    // InternalPoST.g:2890:3: ( (lv_array_2_0= ruleArrayVariable ) )
                    // InternalPoST.g:2891:4: (lv_array_2_0= ruleArrayVariable )
                    {
                    // InternalPoST.g:2891:4: (lv_array_2_0= ruleArrayVariable )
                    // InternalPoST.g:2892:5: lv_array_2_0= ruleArrayVariable
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
                    // InternalPoST.g:2910:3: ( (lv_procStatus_3_0= ruleProcessStatusExpression ) )
                    {
                    // InternalPoST.g:2910:3: ( (lv_procStatus_3_0= ruleProcessStatusExpression ) )
                    // InternalPoST.g:2911:4: (lv_procStatus_3_0= ruleProcessStatusExpression )
                    {
                    // InternalPoST.g:2911:4: (lv_procStatus_3_0= ruleProcessStatusExpression )
                    // InternalPoST.g:2912:5: lv_procStatus_3_0= ruleProcessStatusExpression
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
                    // InternalPoST.g:2930:3: (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalPoST.g:2930:3: (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalPoST.g:2931:4: otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,45,FOLLOW_48); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalPoST.g:2935:4: ( (lv_nestExpr_5_0= ruleExpression ) )
                    // InternalPoST.g:2936:5: (lv_nestExpr_5_0= ruleExpression )
                    {
                    // InternalPoST.g:2936:5: (lv_nestExpr_5_0= ruleExpression )
                    // InternalPoST.g:2937:6: lv_nestExpr_5_0= ruleExpression
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
    // InternalPoST.g:2963:1: entryRuleStatementList returns [EObject current=null] : iv_ruleStatementList= ruleStatementList EOF ;
    public final EObject entryRuleStatementList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementList = null;


        try {
            // InternalPoST.g:2963:54: (iv_ruleStatementList= ruleStatementList EOF )
            // InternalPoST.g:2964:2: iv_ruleStatementList= ruleStatementList EOF
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
    // InternalPoST.g:2970:1: ruleStatementList returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleStatementList() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2976:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalPoST.g:2977:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalPoST.g:2977:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalPoST.g:2978:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalPoST.g:2978:3: ()
            // InternalPoST.g:2979:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStatementListAccess().getStatementListAction_0(),
            					current);
            			

            }

            // InternalPoST.g:2985:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ID||LA42_0==61||(LA42_0>=65 && LA42_0<=68)||LA42_0==72||LA42_0==74||LA42_0==78||LA42_0==81||LA42_0==86||LA42_0==88||(LA42_0>=91 && LA42_0<=92)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalPoST.g:2986:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalPoST.g:2986:4: (lv_statements_1_0= ruleStatement )
            	    // InternalPoST.g:2987:5: lv_statements_1_0= ruleStatement
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
    // $ANTLR end "ruleStatementList"


    // $ANTLR start "entryRuleStatement"
    // InternalPoST.g:3008:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalPoST.g:3008:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalPoST.g:3009:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalPoST.g:3015:1: ruleStatement returns [EObject current=null] : ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) ) ;
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
            // InternalPoST.g:3021:2: ( ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) ) )
            // InternalPoST.g:3022:2: ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) )
            {
            // InternalPoST.g:3022:2: ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) )
            int alt43=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt43=1;
                }
                break;
            case 74:
            case 78:
                {
                alt43=2;
                }
                break;
            case 81:
            case 86:
            case 88:
                {
                alt43=3;
                }
                break;
            case 91:
                {
                alt43=4;
                }
                break;
            case 92:
                {
                alt43=5;
                }
                break;
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt43=6;
                }
                break;
            case 61:
                {
                alt43=7;
                }
                break;
            case 72:
                {
                alt43=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalPoST.g:3023:3: (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' )
                    {
                    // InternalPoST.g:3023:3: (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' )
                    // InternalPoST.g:3024:4: this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';'
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
                    // InternalPoST.g:3038:3: this_SelectionStatement_2= ruleSelectionStatement
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
                    // InternalPoST.g:3047:3: this_IterationStatement_3= ruleIterationStatement
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
                    // InternalPoST.g:3056:3: (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' )
                    {
                    // InternalPoST.g:3056:3: (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' )
                    // InternalPoST.g:3057:4: this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';'
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
                    // InternalPoST.g:3071:3: (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' )
                    {
                    // InternalPoST.g:3071:3: (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' )
                    // InternalPoST.g:3072:4: this_ExitStatement_6= ruleExitStatement otherlv_7= ';'
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
                    // InternalPoST.g:3086:3: (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' )
                    {
                    // InternalPoST.g:3086:3: (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' )
                    // InternalPoST.g:3087:4: this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';'
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
                    // InternalPoST.g:3101:3: (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' )
                    {
                    // InternalPoST.g:3101:3: (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' )
                    // InternalPoST.g:3102:4: this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';'
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
                    // InternalPoST.g:3116:3: (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' )
                    {
                    // InternalPoST.g:3116:3: (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' )
                    // InternalPoST.g:3117:4: this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';'
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
    // InternalPoST.g:3134:1: entryRuleAssignmentStatement returns [EObject current=null] : iv_ruleAssignmentStatement= ruleAssignmentStatement EOF ;
    public final EObject entryRuleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStatement = null;


        try {
            // InternalPoST.g:3134:60: (iv_ruleAssignmentStatement= ruleAssignmentStatement EOF )
            // InternalPoST.g:3135:2: iv_ruleAssignmentStatement= ruleAssignmentStatement EOF
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
    // InternalPoST.g:3141:1: ruleAssignmentStatement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_array_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3147:2: ( ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalPoST.g:3148:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalPoST.g:3148:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            // InternalPoST.g:3149:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) )
            {
            // InternalPoST.g:3149:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==47) ) {
                    alt44=1;
                }
                else if ( (LA44_1==93) ) {
                    alt44=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalPoST.g:3150:4: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalPoST.g:3150:4: ( (otherlv_0= RULE_ID ) )
                    // InternalPoST.g:3151:5: (otherlv_0= RULE_ID )
                    {
                    // InternalPoST.g:3151:5: (otherlv_0= RULE_ID )
                    // InternalPoST.g:3152:6: otherlv_0= RULE_ID
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
                    // InternalPoST.g:3164:4: ( (lv_array_1_0= ruleArrayVariable ) )
                    {
                    // InternalPoST.g:3164:4: ( (lv_array_1_0= ruleArrayVariable ) )
                    // InternalPoST.g:3165:5: (lv_array_1_0= ruleArrayVariable )
                    {
                    // InternalPoST.g:3165:5: (lv_array_1_0= ruleArrayVariable )
                    // InternalPoST.g:3166:6: lv_array_1_0= ruleArrayVariable
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
            		
            // InternalPoST.g:3188:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalPoST.g:3189:4: (lv_value_3_0= ruleExpression )
            {
            // InternalPoST.g:3189:4: (lv_value_3_0= ruleExpression )
            // InternalPoST.g:3190:5: lv_value_3_0= ruleExpression
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
    // InternalPoST.g:3211:1: entryRuleSelectionStatement returns [EObject current=null] : iv_ruleSelectionStatement= ruleSelectionStatement EOF ;
    public final EObject entryRuleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionStatement = null;


        try {
            // InternalPoST.g:3211:59: (iv_ruleSelectionStatement= ruleSelectionStatement EOF )
            // InternalPoST.g:3212:2: iv_ruleSelectionStatement= ruleSelectionStatement EOF
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
    // InternalPoST.g:3218:1: ruleSelectionStatement returns [EObject current=null] : (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement ) ;
    public final EObject ruleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_IfStatement_0 = null;

        EObject this_CaseStatement_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:3224:2: ( (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement ) )
            // InternalPoST.g:3225:2: (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement )
            {
            // InternalPoST.g:3225:2: (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==74) ) {
                alt45=1;
            }
            else if ( (LA45_0==78) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalPoST.g:3226:3: this_IfStatement_0= ruleIfStatement
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
                    // InternalPoST.g:3235:3: this_CaseStatement_1= ruleCaseStatement
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
    // InternalPoST.g:3247:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalPoST.g:3247:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalPoST.g:3248:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalPoST.g:3254:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' ) ;
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
            // InternalPoST.g:3260:2: ( (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' ) )
            // InternalPoST.g:3261:2: (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' )
            {
            // InternalPoST.g:3261:2: (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' )
            // InternalPoST.g:3262:3: otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIFKeyword_0());
            		
            // InternalPoST.g:3266:3: ( (lv_mainCond_1_0= ruleExpression ) )
            // InternalPoST.g:3267:4: (lv_mainCond_1_0= ruleExpression )
            {
            // InternalPoST.g:3267:4: (lv_mainCond_1_0= ruleExpression )
            // InternalPoST.g:3268:5: lv_mainCond_1_0= ruleExpression
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
            		
            // InternalPoST.g:3289:3: ( (lv_mainStatement_3_0= ruleStatementList ) )
            // InternalPoST.g:3290:4: (lv_mainStatement_3_0= ruleStatementList )
            {
            // InternalPoST.g:3290:4: (lv_mainStatement_3_0= ruleStatementList )
            // InternalPoST.g:3291:5: lv_mainStatement_3_0= ruleStatementList
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

            // InternalPoST.g:3308:3: (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==75) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalPoST.g:3309:4: otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) )
            	    {
            	    otherlv_4=(Token)match(input,75,FOLLOW_48); 

            	    				newLeafNode(otherlv_4, grammarAccess.getIfStatementAccess().getELSIFKeyword_4_0());
            	    			
            	    // InternalPoST.g:3313:4: ( (lv_elseIfCond_5_0= ruleExpression ) )
            	    // InternalPoST.g:3314:5: (lv_elseIfCond_5_0= ruleExpression )
            	    {
            	    // InternalPoST.g:3314:5: (lv_elseIfCond_5_0= ruleExpression )
            	    // InternalPoST.g:3315:6: lv_elseIfCond_5_0= ruleExpression
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
            	    			
            	    // InternalPoST.g:3336:4: ( (lv_elseIfStatements_7_0= ruleStatementList ) )
            	    // InternalPoST.g:3337:5: (lv_elseIfStatements_7_0= ruleStatementList )
            	    {
            	    // InternalPoST.g:3337:5: (lv_elseIfStatements_7_0= ruleStatementList )
            	    // InternalPoST.g:3338:6: lv_elseIfStatements_7_0= ruleStatementList
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
            	    break loop46;
                }
            } while (true);

            // InternalPoST.g:3356:3: (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==76) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalPoST.g:3357:4: otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) )
                    {
                    otherlv_8=(Token)match(input,76,FOLLOW_60); 

                    				newLeafNode(otherlv_8, grammarAccess.getIfStatementAccess().getELSEKeyword_5_0());
                    			
                    // InternalPoST.g:3361:4: ( (lv_elseStatement_9_0= ruleStatementList ) )
                    // InternalPoST.g:3362:5: (lv_elseStatement_9_0= ruleStatementList )
                    {
                    // InternalPoST.g:3362:5: (lv_elseStatement_9_0= ruleStatementList )
                    // InternalPoST.g:3363:6: lv_elseStatement_9_0= ruleStatementList
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
    // InternalPoST.g:3389:1: entryRuleCaseStatement returns [EObject current=null] : iv_ruleCaseStatement= ruleCaseStatement EOF ;
    public final EObject entryRuleCaseStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStatement = null;


        try {
            // InternalPoST.g:3389:54: (iv_ruleCaseStatement= ruleCaseStatement EOF )
            // InternalPoST.g:3390:2: iv_ruleCaseStatement= ruleCaseStatement EOF
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
    // InternalPoST.g:3396:1: ruleCaseStatement returns [EObject current=null] : (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' ) ;
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
            // InternalPoST.g:3402:2: ( (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' ) )
            // InternalPoST.g:3403:2: (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' )
            {
            // InternalPoST.g:3403:2: (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' )
            // InternalPoST.g:3404:3: otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getCaseStatementAccess().getCASEKeyword_0());
            		
            // InternalPoST.g:3408:3: ( (lv_cond_1_0= ruleExpression ) )
            // InternalPoST.g:3409:4: (lv_cond_1_0= ruleExpression )
            {
            // InternalPoST.g:3409:4: (lv_cond_1_0= ruleExpression )
            // InternalPoST.g:3410:5: lv_cond_1_0= ruleExpression
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
            		
            // InternalPoST.g:3431:3: ( (lv_caseElements_3_0= ruleCaseElement ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_INTEGER||LA48_0==108) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalPoST.g:3432:4: (lv_caseElements_3_0= ruleCaseElement )
            	    {
            	    // InternalPoST.g:3432:4: (lv_caseElements_3_0= ruleCaseElement )
            	    // InternalPoST.g:3433:5: lv_caseElements_3_0= ruleCaseElement
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
            	    if ( cnt48 >= 1 ) break loop48;
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);

            // InternalPoST.g:3450:3: (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==76) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalPoST.g:3451:4: otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) )
                    {
                    otherlv_4=(Token)match(input,76,FOLLOW_65); 

                    				newLeafNode(otherlv_4, grammarAccess.getCaseStatementAccess().getELSEKeyword_4_0());
                    			
                    // InternalPoST.g:3455:4: ( (lv_elseStatement_5_0= ruleStatementList ) )
                    // InternalPoST.g:3456:5: (lv_elseStatement_5_0= ruleStatementList )
                    {
                    // InternalPoST.g:3456:5: (lv_elseStatement_5_0= ruleStatementList )
                    // InternalPoST.g:3457:6: lv_elseStatement_5_0= ruleStatementList
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
    // InternalPoST.g:3483:1: entryRuleCaseElement returns [EObject current=null] : iv_ruleCaseElement= ruleCaseElement EOF ;
    public final EObject entryRuleCaseElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseElement = null;


        try {
            // InternalPoST.g:3483:52: (iv_ruleCaseElement= ruleCaseElement EOF )
            // InternalPoST.g:3484:2: iv_ruleCaseElement= ruleCaseElement EOF
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
    // InternalPoST.g:3490:1: ruleCaseElement returns [EObject current=null] : ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) ) ;
    public final EObject ruleCaseElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_caseList_0_0 = null;

        EObject lv_statement_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3496:2: ( ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) ) )
            // InternalPoST.g:3497:2: ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) )
            {
            // InternalPoST.g:3497:2: ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) )
            // InternalPoST.g:3498:3: ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) )
            {
            // InternalPoST.g:3498:3: ( (lv_caseList_0_0= ruleCaseList ) )
            // InternalPoST.g:3499:4: (lv_caseList_0_0= ruleCaseList )
            {
            // InternalPoST.g:3499:4: (lv_caseList_0_0= ruleCaseList )
            // InternalPoST.g:3500:5: lv_caseList_0_0= ruleCaseList
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
            		
            // InternalPoST.g:3521:3: ( (lv_statement_2_0= ruleStatementList ) )
            // InternalPoST.g:3522:4: (lv_statement_2_0= ruleStatementList )
            {
            // InternalPoST.g:3522:4: (lv_statement_2_0= ruleStatementList )
            // InternalPoST.g:3523:5: lv_statement_2_0= ruleStatementList
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
    // InternalPoST.g:3544:1: entryRuleCaseList returns [EObject current=null] : iv_ruleCaseList= ruleCaseList EOF ;
    public final EObject entryRuleCaseList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseList = null;


        try {
            // InternalPoST.g:3544:49: (iv_ruleCaseList= ruleCaseList EOF )
            // InternalPoST.g:3545:2: iv_ruleCaseList= ruleCaseList EOF
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
    // InternalPoST.g:3551:1: ruleCaseList returns [EObject current=null] : ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* ) ;
    public final EObject ruleCaseList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_caseListElement_0_0 = null;

        EObject lv_caseListElement_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3557:2: ( ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* ) )
            // InternalPoST.g:3558:2: ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* )
            {
            // InternalPoST.g:3558:2: ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* )
            // InternalPoST.g:3559:3: ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )*
            {
            // InternalPoST.g:3559:3: ( (lv_caseListElement_0_0= ruleSignedInteger ) )
            // InternalPoST.g:3560:4: (lv_caseListElement_0_0= ruleSignedInteger )
            {
            // InternalPoST.g:3560:4: (lv_caseListElement_0_0= ruleSignedInteger )
            // InternalPoST.g:3561:5: lv_caseListElement_0_0= ruleSignedInteger
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

            // InternalPoST.g:3578:3: (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==48) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalPoST.g:3579:4: otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_63); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCaseListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:3583:4: ( (lv_caseListElement_2_0= ruleSignedInteger ) )
            	    // InternalPoST.g:3584:5: (lv_caseListElement_2_0= ruleSignedInteger )
            	    {
            	    // InternalPoST.g:3584:5: (lv_caseListElement_2_0= ruleSignedInteger )
            	    // InternalPoST.g:3585:6: lv_caseListElement_2_0= ruleSignedInteger
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
            	    break loop50;
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
    // InternalPoST.g:3607:1: entryRuleIterationStatement returns [EObject current=null] : iv_ruleIterationStatement= ruleIterationStatement EOF ;
    public final EObject entryRuleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationStatement = null;


        try {
            // InternalPoST.g:3607:59: (iv_ruleIterationStatement= ruleIterationStatement EOF )
            // InternalPoST.g:3608:2: iv_ruleIterationStatement= ruleIterationStatement EOF
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
    // InternalPoST.g:3614:1: ruleIterationStatement returns [EObject current=null] : (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement ) ;
    public final EObject ruleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatement_0 = null;

        EObject this_WhileStatement_1 = null;

        EObject this_RepeatStatement_2 = null;



        	enterRule();

        try {
            // InternalPoST.g:3620:2: ( (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement ) )
            // InternalPoST.g:3621:2: (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement )
            {
            // InternalPoST.g:3621:2: (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement )
            int alt51=3;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt51=1;
                }
                break;
            case 86:
                {
                alt51=2;
                }
                break;
            case 88:
                {
                alt51=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalPoST.g:3622:3: this_ForStatement_0= ruleForStatement
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
                    // InternalPoST.g:3631:3: this_WhileStatement_1= ruleWhileStatement
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
                    // InternalPoST.g:3640:3: this_RepeatStatement_2= ruleRepeatStatement
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
    // InternalPoST.g:3652:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalPoST.g:3652:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalPoST.g:3653:2: iv_ruleForStatement= ruleForStatement EOF
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
    // InternalPoST.g:3659:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' ) ;
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
            // InternalPoST.g:3665:2: ( (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' ) )
            // InternalPoST.g:3666:2: (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' )
            {
            // InternalPoST.g:3666:2: (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' )
            // InternalPoST.g:3667:3: otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getFORKeyword_0());
            		
            // InternalPoST.g:3671:3: ( (otherlv_1= RULE_ID ) )
            // InternalPoST.g:3672:4: (otherlv_1= RULE_ID )
            {
            // InternalPoST.g:3672:4: (otherlv_1= RULE_ID )
            // InternalPoST.g:3673:5: otherlv_1= RULE_ID
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
            		
            // InternalPoST.g:3688:3: ( (lv_forList_3_0= ruleForList ) )
            // InternalPoST.g:3689:4: (lv_forList_3_0= ruleForList )
            {
            // InternalPoST.g:3689:4: (lv_forList_3_0= ruleForList )
            // InternalPoST.g:3690:5: lv_forList_3_0= ruleForList
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
            		
            // InternalPoST.g:3711:3: ( (lv_statement_5_0= ruleStatementList ) )
            // InternalPoST.g:3712:4: (lv_statement_5_0= ruleStatementList )
            {
            // InternalPoST.g:3712:4: (lv_statement_5_0= ruleStatementList )
            // InternalPoST.g:3713:5: lv_statement_5_0= ruleStatementList
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
    // InternalPoST.g:3738:1: entryRuleForList returns [EObject current=null] : iv_ruleForList= ruleForList EOF ;
    public final EObject entryRuleForList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForList = null;


        try {
            // InternalPoST.g:3738:48: (iv_ruleForList= ruleForList EOF )
            // InternalPoST.g:3739:2: iv_ruleForList= ruleForList EOF
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
    // InternalPoST.g:3745:1: ruleForList returns [EObject current=null] : ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleForList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_start_0_0 = null;

        EObject lv_end_2_0 = null;

        EObject lv_step_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3751:2: ( ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? ) )
            // InternalPoST.g:3752:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? )
            {
            // InternalPoST.g:3752:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? )
            // InternalPoST.g:3753:3: ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )?
            {
            // InternalPoST.g:3753:3: ( (lv_start_0_0= ruleExpression ) )
            // InternalPoST.g:3754:4: (lv_start_0_0= ruleExpression )
            {
            // InternalPoST.g:3754:4: (lv_start_0_0= ruleExpression )
            // InternalPoST.g:3755:5: lv_start_0_0= ruleExpression
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
            		
            // InternalPoST.g:3776:3: ( (lv_end_2_0= ruleExpression ) )
            // InternalPoST.g:3777:4: (lv_end_2_0= ruleExpression )
            {
            // InternalPoST.g:3777:4: (lv_end_2_0= ruleExpression )
            // InternalPoST.g:3778:5: lv_end_2_0= ruleExpression
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

            // InternalPoST.g:3795:3: (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==85) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalPoST.g:3796:4: otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,85,FOLLOW_48); 

                    				newLeafNode(otherlv_3, grammarAccess.getForListAccess().getBYKeyword_3_0());
                    			
                    // InternalPoST.g:3800:4: ( (lv_step_4_0= ruleExpression ) )
                    // InternalPoST.g:3801:5: (lv_step_4_0= ruleExpression )
                    {
                    // InternalPoST.g:3801:5: (lv_step_4_0= ruleExpression )
                    // InternalPoST.g:3802:6: lv_step_4_0= ruleExpression
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
    // InternalPoST.g:3824:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalPoST.g:3824:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalPoST.g:3825:2: iv_ruleWhileStatement= ruleWhileStatement EOF
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
    // InternalPoST.g:3831:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_cond_1_0 = null;

        EObject lv_statement_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3837:2: ( (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' ) )
            // InternalPoST.g:3838:2: (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' )
            {
            // InternalPoST.g:3838:2: (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' )
            // InternalPoST.g:3839:3: otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE'
            {
            otherlv_0=(Token)match(input,86,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWHILEKeyword_0());
            		
            // InternalPoST.g:3843:3: ( (lv_cond_1_0= ruleExpression ) )
            // InternalPoST.g:3844:4: (lv_cond_1_0= ruleExpression )
            {
            // InternalPoST.g:3844:4: (lv_cond_1_0= ruleExpression )
            // InternalPoST.g:3845:5: lv_cond_1_0= ruleExpression
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
            		
            // InternalPoST.g:3866:3: ( (lv_statement_3_0= ruleStatementList ) )
            // InternalPoST.g:3867:4: (lv_statement_3_0= ruleStatementList )
            {
            // InternalPoST.g:3867:4: (lv_statement_3_0= ruleStatementList )
            // InternalPoST.g:3868:5: lv_statement_3_0= ruleStatementList
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
    // InternalPoST.g:3893:1: entryRuleRepeatStatement returns [EObject current=null] : iv_ruleRepeatStatement= ruleRepeatStatement EOF ;
    public final EObject entryRuleRepeatStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeatStatement = null;


        try {
            // InternalPoST.g:3893:56: (iv_ruleRepeatStatement= ruleRepeatStatement EOF )
            // InternalPoST.g:3894:2: iv_ruleRepeatStatement= ruleRepeatStatement EOF
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
    // InternalPoST.g:3900:1: ruleRepeatStatement returns [EObject current=null] : (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' ) ;
    public final EObject ruleRepeatStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_statement_1_0 = null;

        EObject lv_cond_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3906:2: ( (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' ) )
            // InternalPoST.g:3907:2: (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' )
            {
            // InternalPoST.g:3907:2: (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' )
            // InternalPoST.g:3908:3: otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_75); 

            			newLeafNode(otherlv_0, grammarAccess.getRepeatStatementAccess().getREPEATKeyword_0());
            		
            // InternalPoST.g:3912:3: ( (lv_statement_1_0= ruleStatementList ) )
            // InternalPoST.g:3913:4: (lv_statement_1_0= ruleStatementList )
            {
            // InternalPoST.g:3913:4: (lv_statement_1_0= ruleStatementList )
            // InternalPoST.g:3914:5: lv_statement_1_0= ruleStatementList
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
            		
            // InternalPoST.g:3935:3: ( (lv_cond_3_0= ruleExpression ) )
            // InternalPoST.g:3936:4: (lv_cond_3_0= ruleExpression )
            {
            // InternalPoST.g:3936:4: (lv_cond_3_0= ruleExpression )
            // InternalPoST.g:3937:5: lv_cond_3_0= ruleExpression
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
    // InternalPoST.g:3962:1: entryRuleSubprogramControlStatement returns [EObject current=null] : iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF ;
    public final EObject entryRuleSubprogramControlStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubprogramControlStatement = null;


        try {
            // InternalPoST.g:3962:67: (iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF )
            // InternalPoST.g:3963:2: iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF
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
    // InternalPoST.g:3969:1: ruleSubprogramControlStatement returns [EObject current=null] : ( () otherlv_1= 'RETURN' ) ;
    public final EObject ruleSubprogramControlStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPoST.g:3975:2: ( ( () otherlv_1= 'RETURN' ) )
            // InternalPoST.g:3976:2: ( () otherlv_1= 'RETURN' )
            {
            // InternalPoST.g:3976:2: ( () otherlv_1= 'RETURN' )
            // InternalPoST.g:3977:3: () otherlv_1= 'RETURN'
            {
            // InternalPoST.g:3977:3: ()
            // InternalPoST.g:3978:4: 
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
    // InternalPoST.g:3992:1: entryRuleExitStatement returns [EObject current=null] : iv_ruleExitStatement= ruleExitStatement EOF ;
    public final EObject entryRuleExitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitStatement = null;


        try {
            // InternalPoST.g:3992:54: (iv_ruleExitStatement= ruleExitStatement EOF )
            // InternalPoST.g:3993:2: iv_ruleExitStatement= ruleExitStatement EOF
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
    // InternalPoST.g:3999:1: ruleExitStatement returns [EObject current=null] : ( () otherlv_1= 'EXIT' ) ;
    public final EObject ruleExitStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPoST.g:4005:2: ( ( () otherlv_1= 'EXIT' ) )
            // InternalPoST.g:4006:2: ( () otherlv_1= 'EXIT' )
            {
            // InternalPoST.g:4006:2: ( () otherlv_1= 'EXIT' )
            // InternalPoST.g:4007:3: () otherlv_1= 'EXIT'
            {
            // InternalPoST.g:4007:3: ()
            // InternalPoST.g:4008:4: 
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


    // $ANTLR start "entryRuleArrayVariable"
    // InternalPoST.g:4022:1: entryRuleArrayVariable returns [EObject current=null] : iv_ruleArrayVariable= ruleArrayVariable EOF ;
    public final EObject entryRuleArrayVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayVariable = null;


        try {
            // InternalPoST.g:4022:54: (iv_ruleArrayVariable= ruleArrayVariable EOF )
            // InternalPoST.g:4023:2: iv_ruleArrayVariable= ruleArrayVariable EOF
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
    // InternalPoST.g:4029:1: ruleArrayVariable returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) ;
    public final EObject ruleArrayVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_index_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4035:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) )
            // InternalPoST.g:4036:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
            {
            // InternalPoST.g:4036:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
            // InternalPoST.g:4037:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']'
            {
            // InternalPoST.g:4037:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:4038:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:4038:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:4039:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArrayVariableRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_78); 

            					newLeafNode(otherlv_0, grammarAccess.getArrayVariableAccess().getVarNameSymbolicVariableCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,93,FOLLOW_48); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayVariableAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalPoST.g:4054:3: ( (lv_index_2_0= ruleExpression ) )
            // InternalPoST.g:4055:4: (lv_index_2_0= ruleExpression )
            {
            // InternalPoST.g:4055:4: (lv_index_2_0= ruleExpression )
            // InternalPoST.g:4056:5: lv_index_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getArrayVariableAccess().getIndexExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_79);
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

            otherlv_3=(Token)match(input,94,FOLLOW_2); 

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


    // $ANTLR start "entryRuleSymbolicVariable"
    // InternalPoST.g:4081:1: entryRuleSymbolicVariable returns [EObject current=null] : iv_ruleSymbolicVariable= ruleSymbolicVariable EOF ;
    public final EObject entryRuleSymbolicVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolicVariable = null;


        try {
            // InternalPoST.g:4081:57: (iv_ruleSymbolicVariable= ruleSymbolicVariable EOF )
            // InternalPoST.g:4082:2: iv_ruleSymbolicVariable= ruleSymbolicVariable EOF
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
    // InternalPoST.g:4088:1: ruleSymbolicVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleSymbolicVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPoST.g:4094:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPoST.g:4095:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPoST.g:4095:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPoST.g:4096:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPoST.g:4096:3: (lv_name_0_0= RULE_ID )
            // InternalPoST.g:4097:4: lv_name_0_0= RULE_ID
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


    // $ANTLR start "entryRuleVarInitDeclaration"
    // InternalPoST.g:4116:1: entryRuleVarInitDeclaration returns [EObject current=null] : iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF ;
    public final EObject entryRuleVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarInitDeclaration = null;


        try {
            // InternalPoST.g:4116:59: (iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF )
            // InternalPoST.g:4117:2: iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF
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
    // InternalPoST.g:4123:1: ruleVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) ) ) ;
    public final EObject ruleVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_varList_0_0 = null;

        EObject lv_spec_2_0 = null;

        EObject lv_arrSpec_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4129:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) ) ) )
            // InternalPoST.g:4130:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) ) )
            {
            // InternalPoST.g:4130:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) ) )
            // InternalPoST.g:4131:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) )
            {
            // InternalPoST.g:4131:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:4132:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:4132:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:4133:5: lv_varList_0_0= ruleVarList
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

            otherlv_1=(Token)match(input,51,FOLLOW_80); 

            			newLeafNode(otherlv_1, grammarAccess.getVarInitDeclarationAccess().getColonKeyword_1());
            		
            // InternalPoST.g:4154:3: ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=RULE_BIT_STRING_TYPE_NAME && LA53_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt53=1;
            }
            else if ( (LA53_0==105) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalPoST.g:4155:4: ( (lv_spec_2_0= ruleSimpleSpecificationInit ) )
                    {
                    // InternalPoST.g:4155:4: ( (lv_spec_2_0= ruleSimpleSpecificationInit ) )
                    // InternalPoST.g:4156:5: (lv_spec_2_0= ruleSimpleSpecificationInit )
                    {
                    // InternalPoST.g:4156:5: (lv_spec_2_0= ruleSimpleSpecificationInit )
                    // InternalPoST.g:4157:6: lv_spec_2_0= ruleSimpleSpecificationInit
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
                    // InternalPoST.g:4175:4: ( (lv_arrSpec_3_0= ruleArraySpecInit ) )
                    {
                    // InternalPoST.g:4175:4: ( (lv_arrSpec_3_0= ruleArraySpecInit ) )
                    // InternalPoST.g:4176:5: (lv_arrSpec_3_0= ruleArraySpecInit )
                    {
                    // InternalPoST.g:4176:5: (lv_arrSpec_3_0= ruleArraySpecInit )
                    // InternalPoST.g:4177:6: lv_arrSpec_3_0= ruleArraySpecInit
                    {

                    						newCompositeNode(grammarAccess.getVarInitDeclarationAccess().getArrSpecArraySpecInitParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_arrSpec_3_0=ruleArraySpecInit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVarInitDeclarationRule());
                    						}
                    						set(
                    							current,
                    							"arrSpec",
                    							lv_arrSpec_3_0,
                    							"su.nsk.iae.post.PoST.ArraySpecInit");
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


    // $ANTLR start "entryRuleVarList"
    // InternalPoST.g:4199:1: entryRuleVarList returns [EObject current=null] : iv_ruleVarList= ruleVarList EOF ;
    public final EObject entryRuleVarList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarList = null;


        try {
            // InternalPoST.g:4199:48: (iv_ruleVarList= ruleVarList EOF )
            // InternalPoST.g:4200:2: iv_ruleVarList= ruleVarList EOF
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
    // InternalPoST.g:4206:1: ruleVarList returns [EObject current=null] : ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* ) ;
    public final EObject ruleVarList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_vars_0_0 = null;

        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4212:2: ( ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* ) )
            // InternalPoST.g:4213:2: ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* )
            {
            // InternalPoST.g:4213:2: ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* )
            // InternalPoST.g:4214:3: ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )*
            {
            // InternalPoST.g:4214:3: ( (lv_vars_0_0= ruleSymbolicVariable ) )
            // InternalPoST.g:4215:4: (lv_vars_0_0= ruleSymbolicVariable )
            {
            // InternalPoST.g:4215:4: (lv_vars_0_0= ruleSymbolicVariable )
            // InternalPoST.g:4216:5: lv_vars_0_0= ruleSymbolicVariable
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

            // InternalPoST.g:4233:3: (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==48) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalPoST.g:4234:4: otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getVarListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:4238:4: ( (lv_vars_2_0= ruleSymbolicVariable ) )
            	    // InternalPoST.g:4239:5: (lv_vars_2_0= ruleSymbolicVariable )
            	    {
            	    // InternalPoST.g:4239:5: (lv_vars_2_0= ruleSymbolicVariable )
            	    // InternalPoST.g:4240:6: lv_vars_2_0= ruleSymbolicVariable
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
    // $ANTLR end "ruleVarList"


    // $ANTLR start "entryRuleInputVarDeclaration"
    // InternalPoST.g:4262:1: entryRuleInputVarDeclaration returns [EObject current=null] : iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF ;
    public final EObject entryRuleInputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputVarDeclaration = null;


        try {
            // InternalPoST.g:4262:60: (iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF )
            // InternalPoST.g:4263:2: iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF
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
    // InternalPoST.g:4269:1: ruleInputVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) ;
    public final EObject ruleInputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_vars_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4275:2: ( (otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) )
            // InternalPoST.g:4276:2: (otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            {
            // InternalPoST.g:4276:2: (otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            // InternalPoST.g:4277:3: otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInputVarDeclarationAccess().getVAR_INPUTKeyword_0());
            		
            // InternalPoST.g:4281:3: ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ID) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalPoST.g:4282:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:4282:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4283:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4283:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4284:6: lv_vars_1_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getInputVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_1_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInputVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_1_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_81); 

            	    				newLeafNode(otherlv_2, grammarAccess.getInputVarDeclarationAccess().getSemicolonKeyword_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);

            otherlv_3=(Token)match(input,96,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getInputVarDeclarationAccess().getEND_VARKeyword_2());
            		

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
    // InternalPoST.g:4314:1: entryRuleOutputVarDeclaration returns [EObject current=null] : iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF ;
    public final EObject entryRuleOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputVarDeclaration = null;


        try {
            // InternalPoST.g:4314:61: (iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF )
            // InternalPoST.g:4315:2: iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF
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
    // InternalPoST.g:4321:1: ruleOutputVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) ;
    public final EObject ruleOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_vars_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4327:2: ( (otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) )
            // InternalPoST.g:4328:2: (otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            {
            // InternalPoST.g:4328:2: (otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            // InternalPoST.g:4329:3: otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR'
            {
            otherlv_0=(Token)match(input,97,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getOutputVarDeclarationAccess().getVAR_OUTPUTKeyword_0());
            		
            // InternalPoST.g:4333:3: ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_ID) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalPoST.g:4334:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:4334:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4335:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4335:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4336:6: lv_vars_1_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getOutputVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_1_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOutputVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_1_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_81); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOutputVarDeclarationAccess().getSemicolonKeyword_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);

            otherlv_3=(Token)match(input,96,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getOutputVarDeclarationAccess().getEND_VARKeyword_2());
            		

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
    // InternalPoST.g:4366:1: entryRuleInputOutputVarDeclaration returns [EObject current=null] : iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF ;
    public final EObject entryRuleInputOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputOutputVarDeclaration = null;


        try {
            // InternalPoST.g:4366:66: (iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF )
            // InternalPoST.g:4367:2: iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF
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
    // InternalPoST.g:4373:1: ruleInputOutputVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) ;
    public final EObject ruleInputOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_vars_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4379:2: ( (otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) )
            // InternalPoST.g:4380:2: (otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            {
            // InternalPoST.g:4380:2: (otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            // InternalPoST.g:4381:3: otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInputOutputVarDeclarationAccess().getVAR_IN_OUTKeyword_0());
            		
            // InternalPoST.g:4385:3: ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ID) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalPoST.g:4386:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:4386:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4387:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4387:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4388:6: lv_vars_1_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getInputOutputVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_1_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInputOutputVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_1_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_81); 

            	    				newLeafNode(otherlv_2, grammarAccess.getInputOutputVarDeclarationAccess().getSemicolonKeyword_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
            } while (true);

            otherlv_3=(Token)match(input,96,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getInputOutputVarDeclarationAccess().getEND_VARKeyword_2());
            		

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
    // InternalPoST.g:4418:1: entryRuleVarDeclaration returns [EObject current=null] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final EObject entryRuleVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDeclaration = null;


        try {
            // InternalPoST.g:4418:55: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // InternalPoST.g:4419:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
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
    // InternalPoST.g:4425:1: ruleVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' ) ;
    public final EObject ruleVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_const_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4431:2: ( (otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4432:2: (otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4432:2: (otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' )
            // InternalPoST.g:4433:3: otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR'
            {
            otherlv_0=(Token)match(input,99,FOLLOW_82); 

            			newLeafNode(otherlv_0, grammarAccess.getVarDeclarationAccess().getVARKeyword_0());
            		
            // InternalPoST.g:4437:3: ( (lv_const_1_0= 'CONSTANT' ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==100) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalPoST.g:4438:4: (lv_const_1_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4438:4: (lv_const_1_0= 'CONSTANT' )
                    // InternalPoST.g:4439:5: lv_const_1_0= 'CONSTANT'
                    {
                    lv_const_1_0=(Token)match(input,100,FOLLOW_4); 

                    					newLeafNode(lv_const_1_0, grammarAccess.getVarDeclarationAccess().getConstCONSTANTKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_1_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:4451:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+
            int cnt59=0;
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ID) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalPoST.g:4452:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4452:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4453:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4453:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4454:6: lv_vars_2_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_2_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,43,FOLLOW_81); 

            	    				newLeafNode(otherlv_3, grammarAccess.getVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt59 >= 1 ) break loop59;
                        EarlyExitException eee =
                            new EarlyExitException(59, input);
                        throw eee;
                }
                cnt59++;
            } while (true);

            otherlv_4=(Token)match(input,96,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getVarDeclarationAccess().getEND_VARKeyword_3());
            		

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
    // InternalPoST.g:4484:1: entryRuleTempVarDeclaration returns [EObject current=null] : iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF ;
    public final EObject entryRuleTempVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTempVarDeclaration = null;


        try {
            // InternalPoST.g:4484:59: (iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF )
            // InternalPoST.g:4485:2: iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF
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
    // InternalPoST.g:4491:1: ruleTempVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) ;
    public final EObject ruleTempVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_vars_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4497:2: ( (otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) )
            // InternalPoST.g:4498:2: (otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            {
            // InternalPoST.g:4498:2: (otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            // InternalPoST.g:4499:3: otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR'
            {
            otherlv_0=(Token)match(input,101,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTempVarDeclarationAccess().getVAR_TEMPKeyword_0());
            		
            // InternalPoST.g:4503:3: ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalPoST.g:4504:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:4504:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4505:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4505:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4506:6: lv_vars_1_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getTempVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_1_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTempVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_1_0,
            	    							"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_81); 

            	    				newLeafNode(otherlv_2, grammarAccess.getTempVarDeclarationAccess().getSemicolonKeyword_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
            } while (true);

            otherlv_3=(Token)match(input,96,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getTempVarDeclarationAccess().getEND_VARKeyword_2());
            		

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


    // $ANTLR start "entryRuleExternalVarDeclaration"
    // InternalPoST.g:4536:1: entryRuleExternalVarDeclaration returns [EObject current=null] : iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF ;
    public final EObject entryRuleExternalVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalVarDeclaration = null;


        try {
            // InternalPoST.g:4536:63: (iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF )
            // InternalPoST.g:4537:2: iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF
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
    // InternalPoST.g:4543:1: ruleExternalVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' ) ;
    public final EObject ruleExternalVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_const_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4549:2: ( (otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4550:2: (otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4550:2: (otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' )
            // InternalPoST.g:4551:3: otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR'
            {
            otherlv_0=(Token)match(input,102,FOLLOW_82); 

            			newLeafNode(otherlv_0, grammarAccess.getExternalVarDeclarationAccess().getVAR_EXTERNALKeyword_0());
            		
            // InternalPoST.g:4555:3: ( (lv_const_1_0= 'CONSTANT' ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==100) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalPoST.g:4556:4: (lv_const_1_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4556:4: (lv_const_1_0= 'CONSTANT' )
                    // InternalPoST.g:4557:5: lv_const_1_0= 'CONSTANT'
                    {
                    lv_const_1_0=(Token)match(input,100,FOLLOW_82); 

                    					newLeafNode(lv_const_1_0, grammarAccess.getExternalVarDeclarationAccess().getConstCONSTANTKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getExternalVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_1_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:4569:3: ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalPoST.g:4570:4: ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4570:4: ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) )
            	    // InternalPoST.g:4571:5: (lv_vars_2_0= ruleExternalVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4571:5: (lv_vars_2_0= ruleExternalVarInitDeclaration )
            	    // InternalPoST.g:4572:6: lv_vars_2_0= ruleExternalVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getExternalVarDeclarationAccess().getVarsExternalVarInitDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_vars_2_0=ruleExternalVarInitDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExternalVarDeclarationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"su.nsk.iae.post.PoST.ExternalVarInitDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_3, grammarAccess.getExternalVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);

            otherlv_4=(Token)match(input,96,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getExternalVarDeclarationAccess().getEND_VARKeyword_3());
            		

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


    // $ANTLR start "entryRuleExternalVarInitDeclaration"
    // InternalPoST.g:4602:1: entryRuleExternalVarInitDeclaration returns [EObject current=null] : iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF ;
    public final EObject entryRuleExternalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalVarInitDeclaration = null;


        try {
            // InternalPoST.g:4602:67: (iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF )
            // InternalPoST.g:4603:2: iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF
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
    // InternalPoST.g:4609:1: ruleExternalVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleExternalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_varList_0_0 = null;

        AntlrDatatypeRuleToken lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4615:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:4616:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:4616:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) )
            // InternalPoST.g:4617:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) )
            {
            // InternalPoST.g:4617:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:4618:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:4618:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:4619:5: lv_varList_0_0= ruleVarList
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

            otherlv_1=(Token)match(input,51,FOLLOW_84); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalVarInitDeclarationAccess().getColonKeyword_1());
            		
            // InternalPoST.g:4640:3: ( (lv_type_2_0= ruleDataTypeName ) )
            // InternalPoST.g:4641:4: (lv_type_2_0= ruleDataTypeName )
            {
            // InternalPoST.g:4641:4: (lv_type_2_0= ruleDataTypeName )
            // InternalPoST.g:4642:5: lv_type_2_0= ruleDataTypeName
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


    // $ANTLR start "entryRuleGlobalVarDeclaration"
    // InternalPoST.g:4663:1: entryRuleGlobalVarDeclaration returns [EObject current=null] : iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF ;
    public final EObject entryRuleGlobalVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVarDeclaration = null;


        try {
            // InternalPoST.g:4663:61: (iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF )
            // InternalPoST.g:4664:2: iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF
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
    // InternalPoST.g:4670:1: ruleGlobalVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR' ) ;
    public final EObject ruleGlobalVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_const_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_varsSimple_2_0 = null;

        EObject lv_varsAs_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4676:2: ( (otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR' ) )
            // InternalPoST.g:4677:2: (otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR' )
            {
            // InternalPoST.g:4677:2: (otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR' )
            // InternalPoST.g:4678:3: otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_82); 

            			newLeafNode(otherlv_0, grammarAccess.getGlobalVarDeclarationAccess().getVAR_GLOBALKeyword_0());
            		
            // InternalPoST.g:4682:3: ( (lv_const_1_0= 'CONSTANT' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==100) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalPoST.g:4683:4: (lv_const_1_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4683:4: (lv_const_1_0= 'CONSTANT' )
                    // InternalPoST.g:4684:5: lv_const_1_0= 'CONSTANT'
                    {
                    lv_const_1_0=(Token)match(input,100,FOLLOW_82); 

                    					newLeafNode(lv_const_1_0, grammarAccess.getGlobalVarDeclarationAccess().getConstCONSTANTKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGlobalVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_1_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:4696:3: ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+
            int cnt64=0;
            loop64:
            do {
                int alt64=3;
                alt64 = dfa64.predict(input);
                switch (alt64) {
            	case 1 :
            	    // InternalPoST.g:4697:4: ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )
            	    {
            	    // InternalPoST.g:4697:4: ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )
            	    // InternalPoST.g:4698:5: ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4698:5: ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4699:6: (lv_varsSimple_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4699:6: (lv_varsSimple_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4700:7: lv_varsSimple_2_0= ruleVarInitDeclaration
            	    {

            	    							newCompositeNode(grammarAccess.getGlobalVarDeclarationAccess().getVarsSimpleVarInitDeclarationParserRuleCall_2_0_0_0());
            	    						
            	    pushFollow(FOLLOW_9);
            	    lv_varsSimple_2_0=ruleVarInitDeclaration();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getGlobalVarDeclarationRule());
            	    							}
            	    							add(
            	    								current,
            	    								"varsSimple",
            	    								lv_varsSimple_2_0,
            	    								"su.nsk.iae.post.PoST.VarInitDeclaration");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    otherlv_3=(Token)match(input,43,FOLLOW_83); 

            	    					newLeafNode(otherlv_3, grammarAccess.getGlobalVarDeclarationAccess().getSemicolonKeyword_2_0_1());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:4723:4: ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' )
            	    {
            	    // InternalPoST.g:4723:4: ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' )
            	    // InternalPoST.g:4724:5: ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';'
            	    {
            	    // InternalPoST.g:4724:5: ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) )
            	    // InternalPoST.g:4725:6: (lv_varsAs_4_0= ruleGlobalVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4725:6: (lv_varsAs_4_0= ruleGlobalVarInitDeclaration )
            	    // InternalPoST.g:4726:7: lv_varsAs_4_0= ruleGlobalVarInitDeclaration
            	    {

            	    							newCompositeNode(grammarAccess.getGlobalVarDeclarationAccess().getVarsAsGlobalVarInitDeclarationParserRuleCall_2_1_0_0());
            	    						
            	    pushFollow(FOLLOW_9);
            	    lv_varsAs_4_0=ruleGlobalVarInitDeclaration();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getGlobalVarDeclarationRule());
            	    							}
            	    							add(
            	    								current,
            	    								"varsAs",
            	    								lv_varsAs_4_0,
            	    								"su.nsk.iae.post.PoST.GlobalVarInitDeclaration");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    otherlv_5=(Token)match(input,43,FOLLOW_83); 

            	    					newLeafNode(otherlv_5, grammarAccess.getGlobalVarDeclarationAccess().getSemicolonKeyword_2_1_1());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
            } while (true);

            otherlv_6=(Token)match(input,96,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getGlobalVarDeclarationAccess().getEND_VARKeyword_3());
            		

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


    // $ANTLR start "entryRuleGlobalVarInitDeclaration"
    // InternalPoST.g:4757:1: entryRuleGlobalVarInitDeclaration returns [EObject current=null] : iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF ;
    public final EObject entryRuleGlobalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVarInitDeclaration = null;


        try {
            // InternalPoST.g:4757:65: (iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF )
            // InternalPoST.g:4758:2: iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF
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
    // InternalPoST.g:4764:1: ruleGlobalVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleGlobalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_location_2_0=null;
        Token otherlv_3=null;
        EObject lv_varList_0_0 = null;

        AntlrDatatypeRuleToken lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4770:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:4771:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:4771:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) )
            // InternalPoST.g:4772:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) )
            {
            // InternalPoST.g:4772:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:4773:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:4773:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:4774:5: lv_varList_0_0= ruleVarList
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

            otherlv_1=(Token)match(input,104,FOLLOW_86); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalVarInitDeclarationAccess().getATKeyword_1());
            		
            // InternalPoST.g:4795:3: ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) )
            // InternalPoST.g:4796:4: (lv_location_2_0= RULE_DIRECT_VARIABLE )
            {
            // InternalPoST.g:4796:4: (lv_location_2_0= RULE_DIRECT_VARIABLE )
            // InternalPoST.g:4797:5: lv_location_2_0= RULE_DIRECT_VARIABLE
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

            otherlv_3=(Token)match(input,51,FOLLOW_84); 

            			newLeafNode(otherlv_3, grammarAccess.getGlobalVarInitDeclarationAccess().getColonKeyword_3());
            		
            // InternalPoST.g:4817:3: ( (lv_type_4_0= ruleDataTypeName ) )
            // InternalPoST.g:4818:4: (lv_type_4_0= ruleDataTypeName )
            {
            // InternalPoST.g:4818:4: (lv_type_4_0= ruleDataTypeName )
            // InternalPoST.g:4819:5: lv_type_4_0= ruleDataTypeName
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


    // $ANTLR start "entryRuleArraySpecInit"
    // InternalPoST.g:4840:1: entryRuleArraySpecInit returns [EObject current=null] : iv_ruleArraySpecInit= ruleArraySpecInit EOF ;
    public final EObject entryRuleArraySpecInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecInit = null;


        try {
            // InternalPoST.g:4840:54: (iv_ruleArraySpecInit= ruleArraySpecInit EOF )
            // InternalPoST.g:4841:2: iv_ruleArraySpecInit= ruleArraySpecInit EOF
            {
             newCompositeNode(grammarAccess.getArraySpecInitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArraySpecInit=ruleArraySpecInit();

            state._fsp--;

             current =iv_ruleArraySpecInit; 
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
    // $ANTLR end "entryRuleArraySpecInit"


    // $ANTLR start "ruleArraySpecInit"
    // InternalPoST.g:4847:1: ruleArraySpecInit returns [EObject current=null] : ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? ) ;
    public final EObject ruleArraySpecInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_init_0_0 = null;

        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4853:2: ( ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? ) )
            // InternalPoST.g:4854:2: ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? )
            {
            // InternalPoST.g:4854:2: ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? )
            // InternalPoST.g:4855:3: ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )?
            {
            // InternalPoST.g:4855:3: ( (lv_init_0_0= ruleArraySpecification ) )
            // InternalPoST.g:4856:4: (lv_init_0_0= ruleArraySpecification )
            {
            // InternalPoST.g:4856:4: (lv_init_0_0= ruleArraySpecification )
            // InternalPoST.g:4857:5: lv_init_0_0= ruleArraySpecification
            {

            					newCompositeNode(grammarAccess.getArraySpecInitAccess().getInitArraySpecificationParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_87);
            lv_init_0_0=ruleArraySpecification();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArraySpecInitRule());
            					}
            					set(
            						current,
            						"init",
            						lv_init_0_0,
            						"su.nsk.iae.post.PoST.ArraySpecification");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:4874:3: (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==47) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalPoST.g:4875:4: otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) )
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_78); 

                    				newLeafNode(otherlv_1, grammarAccess.getArraySpecInitAccess().getColonEqualsSignKeyword_1_0());
                    			
                    // InternalPoST.g:4879:4: ( (lv_values_2_0= ruleArrayInitialization ) )
                    // InternalPoST.g:4880:5: (lv_values_2_0= ruleArrayInitialization )
                    {
                    // InternalPoST.g:4880:5: (lv_values_2_0= ruleArrayInitialization )
                    // InternalPoST.g:4881:6: lv_values_2_0= ruleArrayInitialization
                    {

                    						newCompositeNode(grammarAccess.getArraySpecInitAccess().getValuesArrayInitializationParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_values_2_0=ruleArrayInitialization();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArraySpecInitRule());
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
    // $ANTLR end "ruleArraySpecInit"


    // $ANTLR start "entryRuleArraySpecification"
    // InternalPoST.g:4903:1: entryRuleArraySpecification returns [EObject current=null] : iv_ruleArraySpecification= ruleArraySpecification EOF ;
    public final EObject entryRuleArraySpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecification = null;


        try {
            // InternalPoST.g:4903:59: (iv_ruleArraySpecification= ruleArraySpecification EOF )
            // InternalPoST.g:4904:2: iv_ruleArraySpecification= ruleArraySpecification EOF
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
    // InternalPoST.g:4910:1: ruleArraySpecification returns [EObject current=null] : (otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleArraySpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_start_2_0 = null;

        EObject lv_end_4_0 = null;

        AntlrDatatypeRuleToken lv_type_7_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4916:2: ( (otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:4917:2: (otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:4917:2: (otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) ) )
            // InternalPoST.g:4918:3: otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) )
            {
            otherlv_0=(Token)match(input,105,FOLLOW_78); 

            			newLeafNode(otherlv_0, grammarAccess.getArraySpecificationAccess().getARRAYKeyword_0());
            		
            otherlv_1=(Token)match(input,93,FOLLOW_63); 

            			newLeafNode(otherlv_1, grammarAccess.getArraySpecificationAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalPoST.g:4926:3: ( (lv_start_2_0= ruleSignedInteger ) )
            // InternalPoST.g:4927:4: (lv_start_2_0= ruleSignedInteger )
            {
            // InternalPoST.g:4927:4: (lv_start_2_0= ruleSignedInteger )
            // InternalPoST.g:4928:5: lv_start_2_0= ruleSignedInteger
            {

            					newCompositeNode(grammarAccess.getArraySpecificationAccess().getStartSignedIntegerParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_88);
            lv_start_2_0=ruleSignedInteger();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArraySpecificationRule());
            					}
            					set(
            						current,
            						"start",
            						lv_start_2_0,
            						"su.nsk.iae.post.PoST.SignedInteger");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,106,FOLLOW_63); 

            			newLeafNode(otherlv_3, grammarAccess.getArraySpecificationAccess().getFullStopFullStopKeyword_3());
            		
            // InternalPoST.g:4949:3: ( (lv_end_4_0= ruleSignedInteger ) )
            // InternalPoST.g:4950:4: (lv_end_4_0= ruleSignedInteger )
            {
            // InternalPoST.g:4950:4: (lv_end_4_0= ruleSignedInteger )
            // InternalPoST.g:4951:5: lv_end_4_0= ruleSignedInteger
            {

            					newCompositeNode(grammarAccess.getArraySpecificationAccess().getEndSignedIntegerParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_79);
            lv_end_4_0=ruleSignedInteger();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArraySpecificationRule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_4_0,
            						"su.nsk.iae.post.PoST.SignedInteger");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,94,FOLLOW_62); 

            			newLeafNode(otherlv_5, grammarAccess.getArraySpecificationAccess().getRightSquareBracketKeyword_5());
            		
            otherlv_6=(Token)match(input,79,FOLLOW_84); 

            			newLeafNode(otherlv_6, grammarAccess.getArraySpecificationAccess().getOFKeyword_6());
            		
            // InternalPoST.g:4976:3: ( (lv_type_7_0= ruleDataTypeName ) )
            // InternalPoST.g:4977:4: (lv_type_7_0= ruleDataTypeName )
            {
            // InternalPoST.g:4977:4: (lv_type_7_0= ruleDataTypeName )
            // InternalPoST.g:4978:5: lv_type_7_0= ruleDataTypeName
            {

            					newCompositeNode(grammarAccess.getArraySpecificationAccess().getTypeDataTypeNameParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_7_0=ruleDataTypeName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArraySpecificationRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_7_0,
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


    // $ANTLR start "entryRuleArrayInitialization"
    // InternalPoST.g:4999:1: entryRuleArrayInitialization returns [EObject current=null] : iv_ruleArrayInitialization= ruleArrayInitialization EOF ;
    public final EObject entryRuleArrayInitialization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayInitialization = null;


        try {
            // InternalPoST.g:4999:60: (iv_ruleArrayInitialization= ruleArrayInitialization EOF )
            // InternalPoST.g:5000:2: iv_ruleArrayInitialization= ruleArrayInitialization EOF
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
    // InternalPoST.g:5006:1: ruleArrayInitialization returns [EObject current=null] : (otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleArrayInitialization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5012:2: ( (otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']' ) )
            // InternalPoST.g:5013:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']' )
            {
            // InternalPoST.g:5013:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']' )
            // InternalPoST.g:5014:3: otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getArrayInitializationAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalPoST.g:5018:3: ( (lv_elements_1_0= ruleConstant ) )
            // InternalPoST.g:5019:4: (lv_elements_1_0= ruleConstant )
            {
            // InternalPoST.g:5019:4: (lv_elements_1_0= ruleConstant )
            // InternalPoST.g:5020:5: lv_elements_1_0= ruleConstant
            {

            					newCompositeNode(grammarAccess.getArrayInitializationAccess().getElementsConstantParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_89);
            lv_elements_1_0=ruleConstant();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArrayInitializationRule());
            					}
            					add(
            						current,
            						"elements",
            						lv_elements_1_0,
            						"su.nsk.iae.post.PoST.Constant");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalPoST.g:5037:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==48) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalPoST.g:5038:4: otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) )
            	    {
            	    otherlv_2=(Token)match(input,48,FOLLOW_15); 

            	    				newLeafNode(otherlv_2, grammarAccess.getArrayInitializationAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalPoST.g:5042:4: ( (lv_elements_3_0= ruleConstant ) )
            	    // InternalPoST.g:5043:5: (lv_elements_3_0= ruleConstant )
            	    {
            	    // InternalPoST.g:5043:5: (lv_elements_3_0= ruleConstant )
            	    // InternalPoST.g:5044:6: lv_elements_3_0= ruleConstant
            	    {

            	    						newCompositeNode(grammarAccess.getArrayInitializationAccess().getElementsConstantParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_89);
            	    lv_elements_3_0=ruleConstant();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getArrayInitializationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"elements",
            	    							lv_elements_3_0,
            	    							"su.nsk.iae.post.PoST.Constant");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            otherlv_4=(Token)match(input,94,FOLLOW_2); 

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
    // InternalPoST.g:5070:1: entryRuleTimeLiteral returns [EObject current=null] : iv_ruleTimeLiteral= ruleTimeLiteral EOF ;
    public final EObject entryRuleTimeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeLiteral = null;


        try {
            // InternalPoST.g:5070:52: (iv_ruleTimeLiteral= ruleTimeLiteral EOF )
            // InternalPoST.g:5071:2: iv_ruleTimeLiteral= ruleTimeLiteral EOF
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
    // InternalPoST.g:5077:1: ruleTimeLiteral returns [EObject current=null] : (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) ) ;
    public final EObject ruleTimeLiteral() throws RecognitionException {
        EObject current = null;

        Token this_TIME_PREF_LITERAL_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_interval_3_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5083:2: ( (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) ) )
            // InternalPoST.g:5084:2: (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) )
            {
            // InternalPoST.g:5084:2: (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) )
            // InternalPoST.g:5085:3: this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) )
            {
            this_TIME_PREF_LITERAL_0=(Token)match(input,RULE_TIME_PREF_LITERAL,FOLLOW_90); 

            			newLeafNode(this_TIME_PREF_LITERAL_0, grammarAccess.getTimeLiteralAccess().getTIME_PREF_LITERALTerminalRuleCall_0());
            		
            otherlv_1=(Token)match(input,107,FOLLOW_91); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeLiteralAccess().getNumberSignKeyword_1());
            		
            // InternalPoST.g:5093:3: (otherlv_2= '-' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==108) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalPoST.g:5094:4: otherlv_2= '-'
                    {
                    otherlv_2=(Token)match(input,108,FOLLOW_92); 

                    				newLeafNode(otherlv_2, grammarAccess.getTimeLiteralAccess().getHyphenMinusKeyword_2());
                    			

                    }
                    break;

            }

            // InternalPoST.g:5099:3: ( (lv_interval_3_0= RULE_INTERVAL ) )
            // InternalPoST.g:5100:4: (lv_interval_3_0= RULE_INTERVAL )
            {
            // InternalPoST.g:5100:4: (lv_interval_3_0= RULE_INTERVAL )
            // InternalPoST.g:5101:5: lv_interval_3_0= RULE_INTERVAL
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
    // InternalPoST.g:5121:1: entryRuleDataTypeName returns [String current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final String entryRuleDataTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeName = null;


        try {
            // InternalPoST.g:5121:52: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // InternalPoST.g:5122:2: iv_ruleDataTypeName= ruleDataTypeName EOF
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
    // InternalPoST.g:5128:1: ruleDataTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BIT_STRING_TYPE_NAME_1=null;
        Token this_TIME_TYPE_NAME_2=null;
        Token this_STRING_TYPE_NAME_3=null;
        AntlrDatatypeRuleToken this_NumericTypeName_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5134:2: ( (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME ) )
            // InternalPoST.g:5135:2: (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME )
            {
            // InternalPoST.g:5135:2: (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME )
            int alt68=4;
            switch ( input.LA(1) ) {
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
                {
                alt68=1;
                }
                break;
            case RULE_BIT_STRING_TYPE_NAME:
                {
                alt68=2;
                }
                break;
            case RULE_TIME_TYPE_NAME:
                {
                alt68=3;
                }
                break;
            case RULE_STRING_TYPE_NAME:
                {
                alt68=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalPoST.g:5136:3: this_NumericTypeName_0= ruleNumericTypeName
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
                    // InternalPoST.g:5147:3: this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME
                    {
                    this_BIT_STRING_TYPE_NAME_1=(Token)match(input,RULE_BIT_STRING_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_BIT_STRING_TYPE_NAME_1);
                    		

                    			newLeafNode(this_BIT_STRING_TYPE_NAME_1, grammarAccess.getDataTypeNameAccess().getBIT_STRING_TYPE_NAMETerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPoST.g:5155:3: this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME
                    {
                    this_TIME_TYPE_NAME_2=(Token)match(input,RULE_TIME_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_TIME_TYPE_NAME_2);
                    		

                    			newLeafNode(this_TIME_TYPE_NAME_2, grammarAccess.getDataTypeNameAccess().getTIME_TYPE_NAMETerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPoST.g:5163:3: this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME
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
    // InternalPoST.g:5174:1: entryRuleNumericTypeName returns [String current=null] : iv_ruleNumericTypeName= ruleNumericTypeName EOF ;
    public final String entryRuleNumericTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumericTypeName = null;


        try {
            // InternalPoST.g:5174:55: (iv_ruleNumericTypeName= ruleNumericTypeName EOF )
            // InternalPoST.g:5175:2: iv_ruleNumericTypeName= ruleNumericTypeName EOF
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
    // InternalPoST.g:5181:1: ruleNumericTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleNumericTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_TYPE_NAME_1=null;
        AntlrDatatypeRuleToken this_IntegerTypeName_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5187:2: ( (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME ) )
            // InternalPoST.g:5188:2: (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME )
            {
            // InternalPoST.g:5188:2: (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_SIGNED_INTEGER_TYPE_NAME && LA69_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt69=1;
            }
            else if ( (LA69_0==RULE_REAL_TYPE_NAME) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalPoST.g:5189:3: this_IntegerTypeName_0= ruleIntegerTypeName
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
                    // InternalPoST.g:5200:3: this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME
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
    // InternalPoST.g:5211:1: entryRuleIntegerTypeName returns [String current=null] : iv_ruleIntegerTypeName= ruleIntegerTypeName EOF ;
    public final String entryRuleIntegerTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerTypeName = null;


        try {
            // InternalPoST.g:5211:55: (iv_ruleIntegerTypeName= ruleIntegerTypeName EOF )
            // InternalPoST.g:5212:2: iv_ruleIntegerTypeName= ruleIntegerTypeName EOF
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
    // InternalPoST.g:5218:1: ruleIntegerTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleIntegerTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIGNED_INTEGER_TYPE_NAME_0=null;
        Token this_UNSIGNED_INTEGER_TYPE_NAME_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5224:2: ( (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME ) )
            // InternalPoST.g:5225:2: (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME )
            {
            // InternalPoST.g:5225:2: (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_SIGNED_INTEGER_TYPE_NAME) ) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_UNSIGNED_INTEGER_TYPE_NAME) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalPoST.g:5226:3: this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME
                    {
                    this_SIGNED_INTEGER_TYPE_NAME_0=(Token)match(input,RULE_SIGNED_INTEGER_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_SIGNED_INTEGER_TYPE_NAME_0);
                    		

                    			newLeafNode(this_SIGNED_INTEGER_TYPE_NAME_0, grammarAccess.getIntegerTypeNameAccess().getSIGNED_INTEGER_TYPE_NAMETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:5234:3: this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME
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


    // $ANTLR start "entryRuleSimpleSpecificationInit"
    // InternalPoST.g:5245:1: entryRuleSimpleSpecificationInit returns [EObject current=null] : iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF ;
    public final EObject entryRuleSimpleSpecificationInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleSpecificationInit = null;


        try {
            // InternalPoST.g:5245:64: (iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF )
            // InternalPoST.g:5246:2: iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF
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
    // InternalPoST.g:5252:1: ruleSimpleSpecificationInit returns [EObject current=null] : ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )? ) ;
    public final EObject ruleSimpleSpecificationInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5258:2: ( ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )? ) )
            // InternalPoST.g:5259:2: ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )? )
            {
            // InternalPoST.g:5259:2: ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )? )
            // InternalPoST.g:5260:3: () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )?
            {
            // InternalPoST.g:5260:3: ()
            // InternalPoST.g:5261:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleSpecificationInitAccess().getSimpleSpecificationInitAction_0(),
            					current);
            			

            }

            // InternalPoST.g:5267:3: ( (lv_type_1_0= ruleDataTypeName ) )
            // InternalPoST.g:5268:4: (lv_type_1_0= ruleDataTypeName )
            {
            // InternalPoST.g:5268:4: (lv_type_1_0= ruleDataTypeName )
            // InternalPoST.g:5269:5: lv_type_1_0= ruleDataTypeName
            {

            					newCompositeNode(grammarAccess.getSimpleSpecificationInitAccess().getTypeDataTypeNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_87);
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

            // InternalPoST.g:5286:3: (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==47) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalPoST.g:5287:4: otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) )
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_15); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleSpecificationInitAccess().getColonEqualsSignKeyword_2_0());
                    			
                    // InternalPoST.g:5291:4: ( (lv_value_3_0= ruleConstant ) )
                    // InternalPoST.g:5292:5: (lv_value_3_0= ruleConstant )
                    {
                    // InternalPoST.g:5292:5: (lv_value_3_0= ruleConstant )
                    // InternalPoST.g:5293:6: lv_value_3_0= ruleConstant
                    {

                    						newCompositeNode(grammarAccess.getSimpleSpecificationInitAccess().getValueConstantParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleConstant();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleSpecificationInitRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_3_0,
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
    // $ANTLR end "ruleSimpleSpecificationInit"


    // $ANTLR start "entryRuleConstant"
    // InternalPoST.g:5315:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalPoST.g:5315:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalPoST.g:5316:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalPoST.g:5322:1: ruleConstant returns [EObject current=null] : (this_NumericLiteral_0= ruleNumericLiteral | this_TimeLiteral_1= ruleTimeLiteral | ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER ) | ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER ) | ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER ) | ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token this_BINARY_INTEGER_3=null;
        Token this_OCTAL_INTEGER_5=null;
        Token this_HEX_INTEGER_7=null;
        Token this_BOOLEAN_LITERAL_9=null;
        EObject this_NumericLiteral_0 = null;

        EObject this_TimeLiteral_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:5328:2: ( (this_NumericLiteral_0= ruleNumericLiteral | this_TimeLiteral_1= ruleTimeLiteral | ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER ) | ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER ) | ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER ) | ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL ) ) )
            // InternalPoST.g:5329:2: (this_NumericLiteral_0= ruleNumericLiteral | this_TimeLiteral_1= ruleTimeLiteral | ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER ) | ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER ) | ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER ) | ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL ) )
            {
            // InternalPoST.g:5329:2: (this_NumericLiteral_0= ruleNumericLiteral | this_TimeLiteral_1= ruleTimeLiteral | ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER ) | ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER ) | ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER ) | ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL ) )
            int alt72=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
            case RULE_REAL:
            case 108:
                {
                alt72=1;
                }
                break;
            case RULE_TIME_PREF_LITERAL:
                {
                alt72=2;
                }
                break;
            case RULE_BINARY_INTEGER:
                {
                alt72=3;
                }
                break;
            case RULE_OCTAL_INTEGER:
                {
                alt72=4;
                }
                break;
            case RULE_HEX_INTEGER:
                {
                alt72=5;
                }
                break;
            case RULE_BOOLEAN_LITERAL:
                {
                alt72=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalPoST.g:5330:3: this_NumericLiteral_0= ruleNumericLiteral
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getNumericLiteralParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericLiteral_0=ruleNumericLiteral();

                    state._fsp--;


                    			current = this_NumericLiteral_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:5339:3: this_TimeLiteral_1= ruleTimeLiteral
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getTimeLiteralParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeLiteral_1=ruleTimeLiteral();

                    state._fsp--;


                    			current = this_TimeLiteral_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalPoST.g:5348:3: ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER )
                    {
                    // InternalPoST.g:5348:3: ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER )
                    // InternalPoST.g:5349:4: () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER
                    {
                    // InternalPoST.g:5349:4: ()
                    // InternalPoST.g:5350:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getConstantAction_2_0(),
                    						current);
                    				

                    }

                    this_BINARY_INTEGER_3=(Token)match(input,RULE_BINARY_INTEGER,FOLLOW_2); 

                    				newLeafNode(this_BINARY_INTEGER_3, grammarAccess.getConstantAccess().getBINARY_INTEGERTerminalRuleCall_2_1());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalPoST.g:5362:3: ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER )
                    {
                    // InternalPoST.g:5362:3: ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER )
                    // InternalPoST.g:5363:4: () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER
                    {
                    // InternalPoST.g:5363:4: ()
                    // InternalPoST.g:5364:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getConstantAction_3_0(),
                    						current);
                    				

                    }

                    this_OCTAL_INTEGER_5=(Token)match(input,RULE_OCTAL_INTEGER,FOLLOW_2); 

                    				newLeafNode(this_OCTAL_INTEGER_5, grammarAccess.getConstantAccess().getOCTAL_INTEGERTerminalRuleCall_3_1());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalPoST.g:5376:3: ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER )
                    {
                    // InternalPoST.g:5376:3: ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER )
                    // InternalPoST.g:5377:4: () this_HEX_INTEGER_7= RULE_HEX_INTEGER
                    {
                    // InternalPoST.g:5377:4: ()
                    // InternalPoST.g:5378:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getConstantAction_4_0(),
                    						current);
                    				

                    }

                    this_HEX_INTEGER_7=(Token)match(input,RULE_HEX_INTEGER,FOLLOW_2); 

                    				newLeafNode(this_HEX_INTEGER_7, grammarAccess.getConstantAccess().getHEX_INTEGERTerminalRuleCall_4_1());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalPoST.g:5390:3: ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL )
                    {
                    // InternalPoST.g:5390:3: ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL )
                    // InternalPoST.g:5391:4: () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL
                    {
                    // InternalPoST.g:5391:4: ()
                    // InternalPoST.g:5392:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getConstantAction_5_0(),
                    						current);
                    				

                    }

                    this_BOOLEAN_LITERAL_9=(Token)match(input,RULE_BOOLEAN_LITERAL,FOLLOW_2); 

                    				newLeafNode(this_BOOLEAN_LITERAL_9, grammarAccess.getConstantAccess().getBOOLEAN_LITERALTerminalRuleCall_5_1());
                    			

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
    // InternalPoST.g:5407:1: entryRuleSignedInteger returns [EObject current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final EObject entryRuleSignedInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedInteger = null;


        try {
            // InternalPoST.g:5407:54: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // InternalPoST.g:5408:2: iv_ruleSignedInteger= ruleSignedInteger EOF
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
    // InternalPoST.g:5414:1: ruleSignedInteger returns [EObject current=null] : ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleSignedInteger() throws RecognitionException {
        EObject current = null;

        Token lv_iSig_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5420:2: ( ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // InternalPoST.g:5421:2: ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // InternalPoST.g:5421:2: ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // InternalPoST.g:5422:3: ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // InternalPoST.g:5422:3: ( (lv_iSig_0_0= '-' ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==108) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalPoST.g:5423:4: (lv_iSig_0_0= '-' )
                    {
                    // InternalPoST.g:5423:4: (lv_iSig_0_0= '-' )
                    // InternalPoST.g:5424:5: lv_iSig_0_0= '-'
                    {
                    lv_iSig_0_0=(Token)match(input,108,FOLLOW_18); 

                    					newLeafNode(lv_iSig_0_0, grammarAccess.getSignedIntegerAccess().getISigHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSignedIntegerRule());
                    					}
                    					setWithLastConsumed(current, "iSig", lv_iSig_0_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:5436:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // InternalPoST.g:5437:4: (lv_value_1_0= RULE_INTEGER )
            {
            // InternalPoST.g:5437:4: (lv_value_1_0= RULE_INTEGER )
            // InternalPoST.g:5438:5: lv_value_1_0= RULE_INTEGER
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
    // InternalPoST.g:5458:1: entryRuleNumericLiteral returns [EObject current=null] : iv_ruleNumericLiteral= ruleNumericLiteral EOF ;
    public final EObject entryRuleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericLiteral = null;


        try {
            // InternalPoST.g:5458:55: (iv_ruleNumericLiteral= ruleNumericLiteral EOF )
            // InternalPoST.g:5459:2: iv_ruleNumericLiteral= ruleNumericLiteral EOF
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
    // InternalPoST.g:5465:1: ruleNumericLiteral returns [EObject current=null] : (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteral_0 = null;

        EObject this_RealLiteral_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:5471:2: ( (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalPoST.g:5472:2: (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalPoST.g:5472:2: (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt74=2;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
                {
                alt74=1;
                }
                break;
            case 108:
                {
                int LA74_2 = input.LA(2);

                if ( (LA74_2==RULE_INTEGER) ) {
                    alt74=1;
                }
                else if ( (LA74_2==RULE_REAL) ) {
                    alt74=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REAL_TYPE_NAME:
            case RULE_REAL:
                {
                alt74=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // InternalPoST.g:5473:3: this_IntegerLiteral_0= ruleIntegerLiteral
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
                    // InternalPoST.g:5482:3: this_RealLiteral_1= ruleRealLiteral
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
    // InternalPoST.g:5494:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // InternalPoST.g:5494:55: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // InternalPoST.g:5495:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
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
    // InternalPoST.g:5501:1: ruleIntegerLiteral returns [EObject current=null] : ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5507:2: ( ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) ) )
            // InternalPoST.g:5508:2: ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) )
            {
            // InternalPoST.g:5508:2: ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) )
            // InternalPoST.g:5509:3: ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) )
            {
            // InternalPoST.g:5509:3: ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_SIGNED_INTEGER_TYPE_NAME && LA75_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalPoST.g:5510:4: ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#'
                    {
                    // InternalPoST.g:5510:4: ( (lv_type_0_0= ruleIntegerTypeName ) )
                    // InternalPoST.g:5511:5: (lv_type_0_0= ruleIntegerTypeName )
                    {
                    // InternalPoST.g:5511:5: (lv_type_0_0= ruleIntegerTypeName )
                    // InternalPoST.g:5512:6: lv_type_0_0= ruleIntegerTypeName
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

                    otherlv_1=(Token)match(input,107,FOLLOW_63); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntegerLiteralAccess().getNumberSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalPoST.g:5534:3: ( (lv_value_2_0= ruleSignedInteger ) )
            // InternalPoST.g:5535:4: (lv_value_2_0= ruleSignedInteger )
            {
            // InternalPoST.g:5535:4: (lv_value_2_0= ruleSignedInteger )
            // InternalPoST.g:5536:5: lv_value_2_0= ruleSignedInteger
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
    // InternalPoST.g:5557:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalPoST.g:5557:52: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalPoST.g:5558:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalPoST.g:5564:1: ruleRealLiteral returns [EObject current=null] : ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token otherlv_1=null;
        Token lv_rSig_2_0=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5570:2: ( ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) ) )
            // InternalPoST.g:5571:2: ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) )
            {
            // InternalPoST.g:5571:2: ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) )
            // InternalPoST.g:5572:3: ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) )
            {
            // InternalPoST.g:5572:3: ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_REAL_TYPE_NAME) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalPoST.g:5573:4: ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#'
                    {
                    // InternalPoST.g:5573:4: ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) )
                    // InternalPoST.g:5574:5: (lv_type_0_0= RULE_REAL_TYPE_NAME )
                    {
                    // InternalPoST.g:5574:5: (lv_type_0_0= RULE_REAL_TYPE_NAME )
                    // InternalPoST.g:5575:6: lv_type_0_0= RULE_REAL_TYPE_NAME
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

                    otherlv_1=(Token)match(input,107,FOLLOW_93); 

                    				newLeafNode(otherlv_1, grammarAccess.getRealLiteralAccess().getNumberSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalPoST.g:5596:3: ( (lv_rSig_2_0= '-' ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==108) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalPoST.g:5597:4: (lv_rSig_2_0= '-' )
                    {
                    // InternalPoST.g:5597:4: (lv_rSig_2_0= '-' )
                    // InternalPoST.g:5598:5: lv_rSig_2_0= '-'
                    {
                    lv_rSig_2_0=(Token)match(input,108,FOLLOW_94); 

                    					newLeafNode(lv_rSig_2_0, grammarAccess.getRealLiteralAccess().getRSigHyphenMinusKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRealLiteralRule());
                    					}
                    					setWithLastConsumed(current, "rSig", lv_rSig_2_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:5610:3: ( (lv_value_3_0= RULE_REAL ) )
            // InternalPoST.g:5611:4: (lv_value_3_0= RULE_REAL )
            {
            // InternalPoST.g:5611:4: (lv_value_3_0= RULE_REAL )
            // InternalPoST.g:5612:5: lv_value_3_0= RULE_REAL
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
    // InternalPoST.g:5632:1: ruleAssignmentType returns [Enumerator current=null] : ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) ) ;
    public final Enumerator ruleAssignmentType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5638:2: ( ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) ) )
            // InternalPoST.g:5639:2: ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) )
            {
            // InternalPoST.g:5639:2: ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==47) ) {
                alt78=1;
            }
            else if ( (LA78_0==109) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalPoST.g:5640:3: (enumLiteral_0= ':=' )
                    {
                    // InternalPoST.g:5640:3: (enumLiteral_0= ':=' )
                    // InternalPoST.g:5641:4: enumLiteral_0= ':='
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getAssignmentTypeAccess().getInEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAssignmentTypeAccess().getInEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5648:3: (enumLiteral_1= '=>' )
                    {
                    // InternalPoST.g:5648:3: (enumLiteral_1= '=>' )
                    // InternalPoST.g:5649:4: enumLiteral_1= '=>'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_2); 

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
    // InternalPoST.g:5659:1: ruleCompOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) ;
    public final Enumerator ruleCompOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5665:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) )
            // InternalPoST.g:5666:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            {
            // InternalPoST.g:5666:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==110) ) {
                alt79=1;
            }
            else if ( (LA79_0==111) ) {
                alt79=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalPoST.g:5667:3: (enumLiteral_0= '=' )
                    {
                    // InternalPoST.g:5667:3: (enumLiteral_0= '=' )
                    // InternalPoST.g:5668:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getCompOperatorAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompOperatorAccess().getEQUALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5675:3: (enumLiteral_1= '<>' )
                    {
                    // InternalPoST.g:5675:3: (enumLiteral_1= '<>' )
                    // InternalPoST.g:5676:4: enumLiteral_1= '<>'
                    {
                    enumLiteral_1=(Token)match(input,111,FOLLOW_2); 

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
    // InternalPoST.g:5686:1: ruleEquOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleEquOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalPoST.g:5692:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) )
            // InternalPoST.g:5693:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalPoST.g:5693:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            int alt80=4;
            switch ( input.LA(1) ) {
            case 112:
                {
                alt80=1;
                }
                break;
            case 113:
                {
                alt80=2;
                }
                break;
            case 114:
                {
                alt80=3;
                }
                break;
            case 115:
                {
                alt80=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // InternalPoST.g:5694:3: (enumLiteral_0= '<' )
                    {
                    // InternalPoST.g:5694:3: (enumLiteral_0= '<' )
                    // InternalPoST.g:5695:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEquOperatorAccess().getLESSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5702:3: (enumLiteral_1= '>' )
                    {
                    // InternalPoST.g:5702:3: (enumLiteral_1= '>' )
                    // InternalPoST.g:5703:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEquOperatorAccess().getGREATEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:5710:3: (enumLiteral_2= '<=' )
                    {
                    // InternalPoST.g:5710:3: (enumLiteral_2= '<=' )
                    // InternalPoST.g:5711:4: enumLiteral_2= '<='
                    {
                    enumLiteral_2=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getLESS_EQUEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getEquOperatorAccess().getLESS_EQUEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalPoST.g:5718:3: (enumLiteral_3= '>=' )
                    {
                    // InternalPoST.g:5718:3: (enumLiteral_3= '>=' )
                    // InternalPoST.g:5719:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,115,FOLLOW_2); 

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
    // InternalPoST.g:5729:1: ruleAddOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5735:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalPoST.g:5736:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalPoST.g:5736:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==116) ) {
                alt81=1;
            }
            else if ( (LA81_0==108) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // InternalPoST.g:5737:3: (enumLiteral_0= '+' )
                    {
                    // InternalPoST.g:5737:3: (enumLiteral_0= '+' )
                    // InternalPoST.g:5738:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getAddOperatorAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOperatorAccess().getPLUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5745:3: (enumLiteral_1= '-' )
                    {
                    // InternalPoST.g:5745:3: (enumLiteral_1= '-' )
                    // InternalPoST.g:5746:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,108,FOLLOW_2); 

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
    // InternalPoST.g:5756:1: ruleMulOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) ) ;
    public final Enumerator ruleMulOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalPoST.g:5762:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) ) )
            // InternalPoST.g:5763:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) )
            {
            // InternalPoST.g:5763:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) )
            int alt82=3;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt82=1;
                }
                break;
            case 118:
                {
                alt82=2;
                }
                break;
            case 119:
                {
                alt82=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalPoST.g:5764:3: (enumLiteral_0= '*' )
                    {
                    // InternalPoST.g:5764:3: (enumLiteral_0= '*' )
                    // InternalPoST.g:5765:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getMulOperatorAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMulOperatorAccess().getMULEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5772:3: (enumLiteral_1= '/' )
                    {
                    // InternalPoST.g:5772:3: (enumLiteral_1= '/' )
                    // InternalPoST.g:5773:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getMulOperatorAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMulOperatorAccess().getDIVEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:5780:3: (enumLiteral_2= 'MOD' )
                    {
                    // InternalPoST.g:5780:3: (enumLiteral_2= 'MOD' )
                    // InternalPoST.g:5781:4: enumLiteral_2= 'MOD'
                    {
                    enumLiteral_2=(Token)match(input,119,FOLLOW_2); 

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
    // InternalPoST.g:5791:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5797:2: ( ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) ) )
            // InternalPoST.g:5798:2: ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) )
            {
            // InternalPoST.g:5798:2: ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==120) ) {
                alt83=1;
            }
            else if ( (LA83_0==108) ) {
                alt83=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // InternalPoST.g:5799:3: (enumLiteral_0= 'NOT' )
                    {
                    // InternalPoST.g:5799:3: (enumLiteral_0= 'NOT' )
                    // InternalPoST.g:5800:4: enumLiteral_0= 'NOT'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getUnaryOperatorAccess().getNOTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getNOTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5807:3: (enumLiteral_1= '-' )
                    {
                    // InternalPoST.g:5807:3: (enumLiteral_1= '-' )
                    // InternalPoST.g:5808:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,108,FOLLOW_2); 

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


    protected DFA64 dfa64 = new DFA64(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\4\1\uffff\1\60\1\4\2\uffff\1\60";
    static final String dfa_3s = "\1\140\1\uffff\1\150\1\4\2\uffff\1\150";
    static final String dfa_4s = "\1\uffff\1\3\2\uffff\1\2\1\1\1\uffff";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\133\uffff\1\1",
            "",
            "\1\3\2\uffff\1\5\64\uffff\1\4",
            "\1\6",
            "",
            "",
            "\1\3\2\uffff\1\5\64\uffff\1\4"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()+ loopback of 4696:3: ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0082004000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000018000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0002140000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0002100000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000007F84100L,0x0000100000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0010000000000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000800000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000007F84110L,0x0000100000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0020000000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0050000000000000L,0x0000006E80000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0110000000000000L,0x0000006E80000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0110000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0600000000000000L,0x0000002E80000000L});
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
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0010200007F84110L,0x0100100000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000C00000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x000F000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0010100000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x00E0000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0010200007F84110L,0x0000100000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x2000000000000012L,0x000000001942451EL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x2000000000000010L,0x0000000019427D1EL});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003800L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x2000000000000010L,0x000000001942651EL});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000300100L,0x0000100000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000300100L,0x0000100000011000L});
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
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x00000000003F0000L,0x0000020000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000010L,0x0000000100000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000010L,0x0000001000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000010L,0x0000001100000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0001000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000008000L,0x0000100000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000004000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000004000000L});

}
