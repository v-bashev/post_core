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
    // InternalPoST.g:72:1: ruleModel returns [EObject current=null] : ( ( (lv_confs_0_0= ruleConfiguration ) ) | ( (lv_globVars_1_0= ruleGlobalVarDeclaration ) ) | ( (lv_programs_2_0= ruleProgram ) ) | ( (lv_fbs_3_0= ruleFunctionBlock ) ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_confs_0_0 = null;

        EObject lv_globVars_1_0 = null;

        EObject lv_programs_2_0 = null;

        EObject lv_fbs_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:78:2: ( ( ( (lv_confs_0_0= ruleConfiguration ) ) | ( (lv_globVars_1_0= ruleGlobalVarDeclaration ) ) | ( (lv_programs_2_0= ruleProgram ) ) | ( (lv_fbs_3_0= ruleFunctionBlock ) ) )* )
            // InternalPoST.g:79:2: ( ( (lv_confs_0_0= ruleConfiguration ) ) | ( (lv_globVars_1_0= ruleGlobalVarDeclaration ) ) | ( (lv_programs_2_0= ruleProgram ) ) | ( (lv_fbs_3_0= ruleFunctionBlock ) ) )*
            {
            // InternalPoST.g:79:2: ( ( (lv_confs_0_0= ruleConfiguration ) ) | ( (lv_globVars_1_0= ruleGlobalVarDeclaration ) ) | ( (lv_programs_2_0= ruleProgram ) ) | ( (lv_fbs_3_0= ruleFunctionBlock ) ) )*
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case 38:
                    {
                    alt1=1;
                    }
                    break;
                case 103:
                    {
                    alt1=2;
                    }
                    break;
                case 49:
                    {
                    alt1=3;
                    }
                    break;
                case 55:
                    {
                    alt1=4;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // InternalPoST.g:80:3: ( (lv_confs_0_0= ruleConfiguration ) )
            	    {
            	    // InternalPoST.g:80:3: ( (lv_confs_0_0= ruleConfiguration ) )
            	    // InternalPoST.g:81:4: (lv_confs_0_0= ruleConfiguration )
            	    {
            	    // InternalPoST.g:81:4: (lv_confs_0_0= ruleConfiguration )
            	    // InternalPoST.g:82:5: lv_confs_0_0= ruleConfiguration
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getConfsConfigurationParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_confs_0_0=ruleConfiguration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"confs",
            	    						lv_confs_0_0,
            	    						"su.nsk.iae.post.PoST.Configuration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:100:3: ( (lv_globVars_1_0= ruleGlobalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:100:3: ( (lv_globVars_1_0= ruleGlobalVarDeclaration ) )
            	    // InternalPoST.g:101:4: (lv_globVars_1_0= ruleGlobalVarDeclaration )
            	    {
            	    // InternalPoST.g:101:4: (lv_globVars_1_0= ruleGlobalVarDeclaration )
            	    // InternalPoST.g:102:5: lv_globVars_1_0= ruleGlobalVarDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getGlobVarsGlobalVarDeclarationParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_globVars_1_0=ruleGlobalVarDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"globVars",
            	    						lv_globVars_1_0,
            	    						"su.nsk.iae.post.PoST.GlobalVarDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalPoST.g:120:3: ( (lv_programs_2_0= ruleProgram ) )
            	    {
            	    // InternalPoST.g:120:3: ( (lv_programs_2_0= ruleProgram ) )
            	    // InternalPoST.g:121:4: (lv_programs_2_0= ruleProgram )
            	    {
            	    // InternalPoST.g:121:4: (lv_programs_2_0= ruleProgram )
            	    // InternalPoST.g:122:5: lv_programs_2_0= ruleProgram
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getProgramsProgramParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_programs_2_0=ruleProgram();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"programs",
            	    						lv_programs_2_0,
            	    						"su.nsk.iae.post.PoST.Program");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalPoST.g:140:3: ( (lv_fbs_3_0= ruleFunctionBlock ) )
            	    {
            	    // InternalPoST.g:140:3: ( (lv_fbs_3_0= ruleFunctionBlock ) )
            	    // InternalPoST.g:141:4: (lv_fbs_3_0= ruleFunctionBlock )
            	    {
            	    // InternalPoST.g:141:4: (lv_fbs_3_0= ruleFunctionBlock )
            	    // InternalPoST.g:142:5: lv_fbs_3_0= ruleFunctionBlock
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getFbsFunctionBlockParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_fbs_3_0=ruleFunctionBlock();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"fbs",
            	    						lv_fbs_3_0,
            	    						"su.nsk.iae.post.PoST.FunctionBlock");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

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
    // InternalPoST.g:163:1: entryRuleConfiguration returns [EObject current=null] : iv_ruleConfiguration= ruleConfiguration EOF ;
    public final EObject entryRuleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfiguration = null;


        try {
            // InternalPoST.g:163:54: (iv_ruleConfiguration= ruleConfiguration EOF )
            // InternalPoST.g:164:2: iv_ruleConfiguration= ruleConfiguration EOF
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
    // InternalPoST.g:170:1: ruleConfiguration returns [EObject current=null] : (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        EObject lv_confGlobVars_2_0 = null;

        EObject lv_resources_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:176:2: ( (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' ) )
            // InternalPoST.g:177:2: (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' )
            {
            // InternalPoST.g:177:2: (otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION' )
            // InternalPoST.g:178:3: otherlv_0= 'CONFIGURATION' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) ( (lv_resources_3_0= ruleResource ) ) )* otherlv_4= 'END_CONFIGURATION'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getConfigurationAccess().getCONFIGURATIONKeyword_0());
            		
            // InternalPoST.g:182:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:183:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:183:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:184:5: lv_name_1_0= RULE_ID
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

            // InternalPoST.g:200:3: ( ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) ( (lv_resources_3_0= ruleResource ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==103) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPoST.g:201:4: ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) ) ( (lv_resources_3_0= ruleResource ) )
            	    {
            	    // InternalPoST.g:201:4: ( (lv_confGlobVars_2_0= ruleGlobalVarDeclaration ) )
            	    // InternalPoST.g:202:5: (lv_confGlobVars_2_0= ruleGlobalVarDeclaration )
            	    {
            	    // InternalPoST.g:202:5: (lv_confGlobVars_2_0= ruleGlobalVarDeclaration )
            	    // InternalPoST.g:203:6: lv_confGlobVars_2_0= ruleGlobalVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getConfigurationAccess().getConfGlobVarsGlobalVarDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_6);
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

            	    // InternalPoST.g:220:4: ( (lv_resources_3_0= ruleResource ) )
            	    // InternalPoST.g:221:5: (lv_resources_3_0= ruleResource )
            	    {
            	    // InternalPoST.g:221:5: (lv_resources_3_0= ruleResource )
            	    // InternalPoST.g:222:6: lv_resources_3_0= ruleResource
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
            	    break loop2;
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
    // InternalPoST.g:248:1: entryRuleResource returns [EObject current=null] : iv_ruleResource= ruleResource EOF ;
    public final EObject entryRuleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResource = null;


        try {
            // InternalPoST.g:248:49: (iv_ruleResource= ruleResource EOF )
            // InternalPoST.g:249:2: iv_ruleResource= ruleResource EOF
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
    // InternalPoST.g:255:1: ruleResource returns [EObject current=null] : (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' ) ;
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
            // InternalPoST.g:261:2: ( (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' ) )
            // InternalPoST.g:262:2: (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' )
            {
            // InternalPoST.g:262:2: (otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE' )
            // InternalPoST.g:263:3: otherlv_0= 'RESOURCE' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ON' ( (lv_type_3_0= RULE_ID ) ) ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )* ( (lv_resStatement_5_0= ruleSingleResource ) ) otherlv_6= 'END_RESOURCE'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getResourceAccess().getRESOURCEKeyword_0());
            		
            // InternalPoST.g:267:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:268:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:268:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:269:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

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
            		
            // InternalPoST.g:289:3: ( (lv_type_3_0= RULE_ID ) )
            // InternalPoST.g:290:4: (lv_type_3_0= RULE_ID )
            {
            // InternalPoST.g:290:4: (lv_type_3_0= RULE_ID )
            // InternalPoST.g:291:5: lv_type_3_0= RULE_ID
            {
            lv_type_3_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            // InternalPoST.g:307:3: ( (lv_resGlobVars_4_0= ruleGlobalVarDeclaration ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==103) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalPoST.g:308:4: (lv_resGlobVars_4_0= ruleGlobalVarDeclaration )
            	    {
            	    // InternalPoST.g:308:4: (lv_resGlobVars_4_0= ruleGlobalVarDeclaration )
            	    // InternalPoST.g:309:5: lv_resGlobVars_4_0= ruleGlobalVarDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getResourceAccess().getResGlobVarsGlobalVarDeclarationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_8);
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
            	    break loop3;
                }
            } while (true);

            // InternalPoST.g:326:3: ( (lv_resStatement_5_0= ruleSingleResource ) )
            // InternalPoST.g:327:4: (lv_resStatement_5_0= ruleSingleResource )
            {
            // InternalPoST.g:327:4: (lv_resStatement_5_0= ruleSingleResource )
            // InternalPoST.g:328:5: lv_resStatement_5_0= ruleSingleResource
            {

            					newCompositeNode(grammarAccess.getResourceAccess().getResStatementSingleResourceParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
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
    // InternalPoST.g:353:1: entryRuleSingleResource returns [EObject current=null] : iv_ruleSingleResource= ruleSingleResource EOF ;
    public final EObject entryRuleSingleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleResource = null;


        try {
            // InternalPoST.g:353:55: (iv_ruleSingleResource= ruleSingleResource EOF )
            // InternalPoST.g:354:2: iv_ruleSingleResource= ruleSingleResource EOF
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
    // InternalPoST.g:360:1: ruleSingleResource returns [EObject current=null] : ( () ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )* ) ;
    public final EObject ruleSingleResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_tasks_1_0 = null;

        EObject lv_programConfs_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:366:2: ( ( () ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )* ) )
            // InternalPoST.g:367:2: ( () ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )* )
            {
            // InternalPoST.g:367:2: ( () ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )* )
            // InternalPoST.g:368:3: () ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )*
            {
            // InternalPoST.g:368:3: ()
            // InternalPoST.g:369:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSingleResourceAccess().getSingleResourceAction_0(),
            					current);
            			

            }

            // InternalPoST.g:375:3: ( ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==44) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalPoST.g:376:4: ( (lv_tasks_1_0= ruleTask ) ) otherlv_2= ';' ( (lv_programConfs_3_0= ruleProgramConfiguration ) ) otherlv_4= ';'
            	    {
            	    // InternalPoST.g:376:4: ( (lv_tasks_1_0= ruleTask ) )
            	    // InternalPoST.g:377:5: (lv_tasks_1_0= ruleTask )
            	    {
            	    // InternalPoST.g:377:5: (lv_tasks_1_0= ruleTask )
            	    // InternalPoST.g:378:6: lv_tasks_1_0= ruleTask
            	    {

            	    						newCompositeNode(grammarAccess.getSingleResourceAccess().getTasksTaskParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_2=(Token)match(input,43,FOLLOW_11); 

            	    				newLeafNode(otherlv_2, grammarAccess.getSingleResourceAccess().getSemicolonKeyword_1_1());
            	    			
            	    // InternalPoST.g:399:4: ( (lv_programConfs_3_0= ruleProgramConfiguration ) )
            	    // InternalPoST.g:400:5: (lv_programConfs_3_0= ruleProgramConfiguration )
            	    {
            	    // InternalPoST.g:400:5: (lv_programConfs_3_0= ruleProgramConfiguration )
            	    // InternalPoST.g:401:6: lv_programConfs_3_0= ruleProgramConfiguration
            	    {

            	    						newCompositeNode(grammarAccess.getSingleResourceAccess().getProgramConfsProgramConfigurationParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_4=(Token)match(input,43,FOLLOW_12); 

            	    				newLeafNode(otherlv_4, grammarAccess.getSingleResourceAccess().getSemicolonKeyword_1_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // InternalPoST.g:427:1: entryRuleTask returns [EObject current=null] : iv_ruleTask= ruleTask EOF ;
    public final EObject entryRuleTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTask = null;


        try {
            // InternalPoST.g:427:45: (iv_ruleTask= ruleTask EOF )
            // InternalPoST.g:428:2: iv_ruleTask= ruleTask EOF
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
    // InternalPoST.g:434:1: ruleTask returns [EObject current=null] : (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' ) ;
    public final EObject ruleTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_init_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:440:2: ( (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' ) )
            // InternalPoST.g:441:2: (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' )
            {
            // InternalPoST.g:441:2: (otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')' )
            // InternalPoST.g:442:3: otherlv_0= 'TASK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_init_3_0= ruleTaskInitialization ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTaskAccess().getTASKKeyword_0());
            		
            // InternalPoST.g:446:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:447:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:447:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:448:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_2=(Token)match(input,45,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getTaskAccess().getLeftParenthesisKeyword_2());
            		
            // InternalPoST.g:468:3: ( (lv_init_3_0= ruleTaskInitialization ) )
            // InternalPoST.g:469:4: (lv_init_3_0= ruleTaskInitialization )
            {
            // InternalPoST.g:469:4: (lv_init_3_0= ruleTaskInitialization )
            // InternalPoST.g:470:5: lv_init_3_0= ruleTaskInitialization
            {

            					newCompositeNode(grammarAccess.getTaskAccess().getInitTaskInitializationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_15);
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
    // InternalPoST.g:495:1: entryRuleTaskInitialization returns [EObject current=null] : iv_ruleTaskInitialization= ruleTaskInitialization EOF ;
    public final EObject entryRuleTaskInitialization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTaskInitialization = null;


        try {
            // InternalPoST.g:495:59: (iv_ruleTaskInitialization= ruleTaskInitialization EOF )
            // InternalPoST.g:496:2: iv_ruleTaskInitialization= ruleTaskInitialization EOF
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
    // InternalPoST.g:502:1: ruleTaskInitialization returns [EObject current=null] : ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) ) ;
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
            // InternalPoST.g:508:2: ( ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) ) )
            // InternalPoST.g:509:2: ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) )
            {
            // InternalPoST.g:509:2: ( (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) ) | ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_SINGLE_DECLARATION) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_INTERVAL_DECLARATION) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalPoST.g:510:3: (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) )
                    {
                    // InternalPoST.g:510:3: (this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) ) )
                    // InternalPoST.g:511:4: this_SINGLE_DECLARATION_0= RULE_SINGLE_DECLARATION otherlv_1= ':=' ( (lv_single_2_0= ruleConstant ) )
                    {
                    this_SINGLE_DECLARATION_0=(Token)match(input,RULE_SINGLE_DECLARATION,FOLLOW_16); 

                    				newLeafNode(this_SINGLE_DECLARATION_0, grammarAccess.getTaskInitializationAccess().getSINGLE_DECLARATIONTerminalRuleCall_0_0());
                    			
                    otherlv_1=(Token)match(input,47,FOLLOW_17); 

                    				newLeafNode(otherlv_1, grammarAccess.getTaskInitializationAccess().getColonEqualsSignKeyword_0_1());
                    			
                    // InternalPoST.g:519:4: ( (lv_single_2_0= ruleConstant ) )
                    // InternalPoST.g:520:5: (lv_single_2_0= ruleConstant )
                    {
                    // InternalPoST.g:520:5: (lv_single_2_0= ruleConstant )
                    // InternalPoST.g:521:6: lv_single_2_0= ruleConstant
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
                    // InternalPoST.g:540:3: ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) )
                    {
                    // InternalPoST.g:540:3: ( (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) ) )
                    // InternalPoST.g:541:4: (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) ) otherlv_6= ',' this_PRIORITY_DECLARATION_7= RULE_PRIORITY_DECLARATION otherlv_8= ':=' ( (lv_priority_9_0= RULE_INTEGER ) )
                    {
                    // InternalPoST.g:541:4: (this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) ) )
                    // InternalPoST.g:542:5: this_INTERVAL_DECLARATION_3= RULE_INTERVAL_DECLARATION otherlv_4= ':=' ( (lv_interval_5_0= ruleConstant ) )
                    {
                    this_INTERVAL_DECLARATION_3=(Token)match(input,RULE_INTERVAL_DECLARATION,FOLLOW_16); 

                    					newLeafNode(this_INTERVAL_DECLARATION_3, grammarAccess.getTaskInitializationAccess().getINTERVAL_DECLARATIONTerminalRuleCall_1_0_0());
                    				
                    otherlv_4=(Token)match(input,47,FOLLOW_17); 

                    					newLeafNode(otherlv_4, grammarAccess.getTaskInitializationAccess().getColonEqualsSignKeyword_1_0_1());
                    				
                    // InternalPoST.g:550:5: ( (lv_interval_5_0= ruleConstant ) )
                    // InternalPoST.g:551:6: (lv_interval_5_0= ruleConstant )
                    {
                    // InternalPoST.g:551:6: (lv_interval_5_0= ruleConstant )
                    // InternalPoST.g:552:7: lv_interval_5_0= ruleConstant
                    {

                    							newCompositeNode(grammarAccess.getTaskInitializationAccess().getIntervalConstantParserRuleCall_1_0_2_0());
                    						
                    pushFollow(FOLLOW_18);
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

                    otherlv_6=(Token)match(input,48,FOLLOW_19); 

                    				newLeafNode(otherlv_6, grammarAccess.getTaskInitializationAccess().getCommaKeyword_1_1());
                    			
                    this_PRIORITY_DECLARATION_7=(Token)match(input,RULE_PRIORITY_DECLARATION,FOLLOW_16); 

                    				newLeafNode(this_PRIORITY_DECLARATION_7, grammarAccess.getTaskInitializationAccess().getPRIORITY_DECLARATIONTerminalRuleCall_1_2());
                    			
                    otherlv_8=(Token)match(input,47,FOLLOW_20); 

                    				newLeafNode(otherlv_8, grammarAccess.getTaskInitializationAccess().getColonEqualsSignKeyword_1_3());
                    			
                    // InternalPoST.g:582:4: ( (lv_priority_9_0= RULE_INTEGER ) )
                    // InternalPoST.g:583:5: (lv_priority_9_0= RULE_INTEGER )
                    {
                    // InternalPoST.g:583:5: (lv_priority_9_0= RULE_INTEGER )
                    // InternalPoST.g:584:6: lv_priority_9_0= RULE_INTEGER
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
    // InternalPoST.g:605:1: entryRuleProgramConfiguration returns [EObject current=null] : iv_ruleProgramConfiguration= ruleProgramConfiguration EOF ;
    public final EObject entryRuleProgramConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfiguration = null;


        try {
            // InternalPoST.g:605:61: (iv_ruleProgramConfiguration= ruleProgramConfiguration EOF )
            // InternalPoST.g:606:2: iv_ruleProgramConfiguration= ruleProgramConfiguration EOF
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
    // InternalPoST.g:612:1: ruleProgramConfiguration returns [EObject current=null] : (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? ) ;
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
            // InternalPoST.g:618:2: ( (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? ) )
            // InternalPoST.g:619:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? )
            {
            // InternalPoST.g:619:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )? )
            // InternalPoST.g:620:3: otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ':' ( (otherlv_5= RULE_ID ) ) (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramConfigurationAccess().getPROGRAMKeyword_0());
            		
            // InternalPoST.g:624:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:625:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:625:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:626:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

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

            // InternalPoST.g:642:3: (otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==50) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalPoST.g:643:4: otherlv_2= 'WITH' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getProgramConfigurationAccess().getWITHKeyword_2_0());
                    			
                    // InternalPoST.g:647:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:648:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:648:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:649:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProgramConfigurationRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_22); 

                    						newLeafNode(otherlv_3, grammarAccess.getProgramConfigurationAccess().getTaskTaskCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,51,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getProgramConfigurationAccess().getColonKeyword_3());
            		
            // InternalPoST.g:665:3: ( (otherlv_5= RULE_ID ) )
            // InternalPoST.g:666:4: (otherlv_5= RULE_ID )
            {
            // InternalPoST.g:666:4: (otherlv_5= RULE_ID )
            // InternalPoST.g:667:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProgramConfigurationRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_5, grammarAccess.getProgramConfigurationAccess().getProgramProgramCrossReference_4_0());
            				

            }


            }

            // InternalPoST.g:678:3: (otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==45) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalPoST.g:679:4: otherlv_6= '(' ( (lv_args_7_0= ruleProgramConfElements ) ) otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,45,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getProgramConfigurationAccess().getLeftParenthesisKeyword_5_0());
                    			
                    // InternalPoST.g:683:4: ( (lv_args_7_0= ruleProgramConfElements ) )
                    // InternalPoST.g:684:5: (lv_args_7_0= ruleProgramConfElements )
                    {
                    // InternalPoST.g:684:5: (lv_args_7_0= ruleProgramConfElements )
                    // InternalPoST.g:685:6: lv_args_7_0= ruleProgramConfElements
                    {

                    						newCompositeNode(grammarAccess.getProgramConfigurationAccess().getArgsProgramConfElementsParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_15);
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
    // InternalPoST.g:711:1: entryRuleProgramConfElements returns [EObject current=null] : iv_ruleProgramConfElements= ruleProgramConfElements EOF ;
    public final EObject entryRuleProgramConfElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfElements = null;


        try {
            // InternalPoST.g:711:60: (iv_ruleProgramConfElements= ruleProgramConfElements EOF )
            // InternalPoST.g:712:2: iv_ruleProgramConfElements= ruleProgramConfElements EOF
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
    // InternalPoST.g:718:1: ruleProgramConfElements returns [EObject current=null] : ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* ) ;
    public final EObject ruleProgramConfElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_elements_0_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:724:2: ( ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* ) )
            // InternalPoST.g:725:2: ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* )
            {
            // InternalPoST.g:725:2: ( ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )* )
            // InternalPoST.g:726:3: ( (lv_elements_0_0= ruleProgramConfElement ) ) (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )*
            {
            // InternalPoST.g:726:3: ( (lv_elements_0_0= ruleProgramConfElement ) )
            // InternalPoST.g:727:4: (lv_elements_0_0= ruleProgramConfElement )
            {
            // InternalPoST.g:727:4: (lv_elements_0_0= ruleProgramConfElement )
            // InternalPoST.g:728:5: lv_elements_0_0= ruleProgramConfElement
            {

            					newCompositeNode(grammarAccess.getProgramConfElementsAccess().getElementsProgramConfElementParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_25);
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

            // InternalPoST.g:745:3: (otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==48) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalPoST.g:746:4: otherlv_1= ',' ( (lv_elements_2_0= ruleProgramConfElement ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_24); 

            	    				newLeafNode(otherlv_1, grammarAccess.getProgramConfElementsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:750:4: ( (lv_elements_2_0= ruleProgramConfElement ) )
            	    // InternalPoST.g:751:5: (lv_elements_2_0= ruleProgramConfElement )
            	    {
            	    // InternalPoST.g:751:5: (lv_elements_2_0= ruleProgramConfElement )
            	    // InternalPoST.g:752:6: lv_elements_2_0= ruleProgramConfElement
            	    {

            	    						newCompositeNode(grammarAccess.getProgramConfElementsAccess().getElementsProgramConfElementParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
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
    // $ANTLR end "ruleProgramConfElements"


    // $ANTLR start "entryRuleProgramConfElement"
    // InternalPoST.g:774:1: entryRuleProgramConfElement returns [EObject current=null] : iv_ruleProgramConfElement= ruleProgramConfElement EOF ;
    public final EObject entryRuleProgramConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramConfElement = null;


        try {
            // InternalPoST.g:774:59: (iv_ruleProgramConfElement= ruleProgramConfElement EOF )
            // InternalPoST.g:775:2: iv_ruleProgramConfElement= ruleProgramConfElement EOF
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
    // InternalPoST.g:781:1: ruleProgramConfElement returns [EObject current=null] : (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement ) ;
    public final EObject ruleProgramConfElement() throws RecognitionException {
        EObject current = null;

        EObject this_AttachVariableConfElement_0 = null;

        EObject this_TemplateProcessConfElement_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:787:2: ( (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement ) )
            // InternalPoST.g:788:2: (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement )
            {
            // InternalPoST.g:788:2: (this_AttachVariableConfElement_0= ruleAttachVariableConfElement | this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==52) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalPoST.g:789:3: this_AttachVariableConfElement_0= ruleAttachVariableConfElement
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
                    // InternalPoST.g:798:3: this_TemplateProcessConfElement_1= ruleTemplateProcessConfElement
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
    // InternalPoST.g:810:1: entryRuleAttachVariableConfElement returns [EObject current=null] : iv_ruleAttachVariableConfElement= ruleAttachVariableConfElement EOF ;
    public final EObject entryRuleAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttachVariableConfElement = null;


        try {
            // InternalPoST.g:810:66: (iv_ruleAttachVariableConfElement= ruleAttachVariableConfElement EOF )
            // InternalPoST.g:811:2: iv_ruleAttachVariableConfElement= ruleAttachVariableConfElement EOF
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
    // InternalPoST.g:817:1: ruleAttachVariableConfElement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) ;
    public final EObject ruleAttachVariableConfElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_assig_1_0 = null;

        EObject lv_const_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:823:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) ) )
            // InternalPoST.g:824:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            {
            // InternalPoST.g:824:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) ) )
            // InternalPoST.g:825:3: ( (otherlv_0= RULE_ID ) ) ( (lv_assig_1_0= ruleAssignmentType ) ) ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            {
            // InternalPoST.g:825:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:826:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:826:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:827:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttachVariableConfElementRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(otherlv_0, grammarAccess.getAttachVariableConfElementAccess().getProgramVarSymbolicVariableCrossReference_0_0());
            				

            }


            }

            // InternalPoST.g:838:3: ( (lv_assig_1_0= ruleAssignmentType ) )
            // InternalPoST.g:839:4: (lv_assig_1_0= ruleAssignmentType )
            {
            // InternalPoST.g:839:4: (lv_assig_1_0= ruleAssignmentType )
            // InternalPoST.g:840:5: lv_assig_1_0= ruleAssignmentType
            {

            					newCompositeNode(grammarAccess.getAttachVariableConfElementAccess().getAssigAssignmentTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_27);
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

            // InternalPoST.g:857:3: ( ( (otherlv_2= RULE_ID ) ) | ( (lv_const_3_0= ruleConstant ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_INTEGER||LA10_0==RULE_TIME_PREF_LITERAL||(LA10_0>=RULE_REAL_TYPE_NAME && LA10_0<=RULE_REAL)||LA10_0==108) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalPoST.g:858:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalPoST.g:858:4: ( (otherlv_2= RULE_ID ) )
                    // InternalPoST.g:859:5: (otherlv_2= RULE_ID )
                    {
                    // InternalPoST.g:859:5: (otherlv_2= RULE_ID )
                    // InternalPoST.g:860:6: otherlv_2= RULE_ID
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
                    // InternalPoST.g:872:4: ( (lv_const_3_0= ruleConstant ) )
                    {
                    // InternalPoST.g:872:4: ( (lv_const_3_0= ruleConstant ) )
                    // InternalPoST.g:873:5: (lv_const_3_0= ruleConstant )
                    {
                    // InternalPoST.g:873:5: (lv_const_3_0= ruleConstant )
                    // InternalPoST.g:874:6: lv_const_3_0= ruleConstant
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
    // InternalPoST.g:896:1: entryRuleTemplateProcessConfElement returns [EObject current=null] : iv_ruleTemplateProcessConfElement= ruleTemplateProcessConfElement EOF ;
    public final EObject entryRuleTemplateProcessConfElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateProcessConfElement = null;


        try {
            // InternalPoST.g:896:67: (iv_ruleTemplateProcessConfElement= ruleTemplateProcessConfElement EOF )
            // InternalPoST.g:897:2: iv_ruleTemplateProcessConfElement= ruleTemplateProcessConfElement EOF
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
    // InternalPoST.g:903:1: ruleTemplateProcessConfElement returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( (lv_active_2_0= 'ACTIVE' ) )? otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ')' ) ) )? ) ;
    public final EObject ruleTemplateProcessConfElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_active_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_args_6_0=null;


        	enterRule();

        try {
            // InternalPoST.g:909:2: ( (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( (lv_active_2_0= 'ACTIVE' ) )? otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ')' ) ) )? ) )
            // InternalPoST.g:910:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( (lv_active_2_0= 'ACTIVE' ) )? otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ')' ) ) )? )
            {
            // InternalPoST.g:910:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( (lv_active_2_0= 'ACTIVE' ) )? otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ')' ) ) )? )
            // InternalPoST.g:911:3: otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( (lv_active_2_0= 'ACTIVE' ) )? otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( (lv_args_6_0= ')' ) ) )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTemplateProcessConfElementAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:915:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:916:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:916:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:917:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTemplateProcessConfElementAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemplateProcessConfElementRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"su.nsk.iae.post.PoST.ID");
            				

            }


            }

            // InternalPoST.g:933:3: ( (lv_active_2_0= 'ACTIVE' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==53) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalPoST.g:934:4: (lv_active_2_0= 'ACTIVE' )
                    {
                    // InternalPoST.g:934:4: (lv_active_2_0= 'ACTIVE' )
                    // InternalPoST.g:935:5: lv_active_2_0= 'ACTIVE'
                    {
                    lv_active_2_0=(Token)match(input,53,FOLLOW_22); 

                    					newLeafNode(lv_active_2_0, grammarAccess.getTemplateProcessConfElementAccess().getActiveACTIVEKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTemplateProcessConfElementRule());
                    					}
                    					setWithLastConsumed(current, "active", lv_active_2_0 != null, "ACTIVE");
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,51,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getTemplateProcessConfElementAccess().getColonKeyword_3());
            		
            // InternalPoST.g:951:3: ( (otherlv_4= RULE_ID ) )
            // InternalPoST.g:952:4: (otherlv_4= RULE_ID )
            {
            // InternalPoST.g:952:4: (otherlv_4= RULE_ID )
            // InternalPoST.g:953:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemplateProcessConfElementRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_4, grammarAccess.getTemplateProcessConfElementAccess().getProcessTemplateProcessCrossReference_4_0());
            				

            }


            }

            // InternalPoST.g:964:3: (otherlv_5= '(' ( (lv_args_6_0= ')' ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==45) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalPoST.g:965:4: otherlv_5= '(' ( (lv_args_6_0= ')' ) )
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_15); 

                    				newLeafNode(otherlv_5, grammarAccess.getTemplateProcessConfElementAccess().getLeftParenthesisKeyword_5_0());
                    			
                    // InternalPoST.g:969:4: ( (lv_args_6_0= ')' ) )
                    // InternalPoST.g:970:5: (lv_args_6_0= ')' )
                    {
                    // InternalPoST.g:970:5: (lv_args_6_0= ')' )
                    // InternalPoST.g:971:6: lv_args_6_0= ')'
                    {
                    lv_args_6_0=(Token)match(input,46,FOLLOW_2); 

                    						newLeafNode(lv_args_6_0, grammarAccess.getTemplateProcessConfElementAccess().getArgsRightParenthesisKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTemplateProcessConfElementRule());
                    						}
                    						setWithLastConsumed(current, "args", lv_args_6_0, ")");
                    					

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
    // $ANTLR end "ruleTemplateProcessConfElement"


    // $ANTLR start "entryRuleProgram"
    // InternalPoST.g:988:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalPoST.g:988:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalPoST.g:989:2: iv_ruleProgram= ruleProgram EOF
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
    // InternalPoST.g:995:1: ruleProgram returns [EObject current=null] : (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' ) ;
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
            // InternalPoST.g:1001:2: ( (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' ) )
            // InternalPoST.g:1002:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' )
            {
            // InternalPoST.g:1002:2: (otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM' )
            // InternalPoST.g:1003:3: otherlv_0= 'PROGRAM' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_PROGRAM'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProgramAccess().getPROGRAMKeyword_0());
            		
            // InternalPoST.g:1007:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1008:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1008:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1009:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_29); 

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

            // InternalPoST.g:1025:3: ( ( (lv_progInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_progVars_5_0= ruleVarDeclaration ) ) | ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) ) )*
            loop13:
            do {
                int alt13=7;
                switch ( input.LA(1) ) {
                case 95:
                    {
                    alt13=1;
                    }
                    break;
                case 97:
                    {
                    alt13=2;
                    }
                    break;
                case 98:
                    {
                    alt13=3;
                    }
                    break;
                case 99:
                    {
                    alt13=4;
                    }
                    break;
                case 101:
                    {
                    alt13=5;
                    }
                    break;
                case 102:
                    {
                    alt13=6;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // InternalPoST.g:1026:4: ( (lv_progInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1026:4: ( (lv_progInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1027:5: (lv_progInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1027:5: (lv_progInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1028:6: lv_progInVars_2_0= ruleInputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgInVarsInputVarDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    // InternalPoST.g:1046:4: ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1046:4: ( (lv_progOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1047:5: (lv_progOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1047:5: (lv_progOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1048:6: lv_progOutVars_3_0= ruleOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgOutVarsOutputVarDeclarationParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    // InternalPoST.g:1066:4: ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1066:4: ( (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1067:5: (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1067:5: (lv_progInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1068:6: lv_progInOutVars_4_0= ruleInputOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgInOutVarsInputOutputVarDeclarationParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    // InternalPoST.g:1086:4: ( (lv_progVars_5_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1086:4: ( (lv_progVars_5_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1087:5: (lv_progVars_5_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1087:5: (lv_progVars_5_0= ruleVarDeclaration )
            	    // InternalPoST.g:1088:6: lv_progVars_5_0= ruleVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgVarsVarDeclarationParserRuleCall_2_3_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    // InternalPoST.g:1106:4: ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1106:4: ( (lv_progTempVars_6_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1107:5: (lv_progTempVars_6_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1107:5: (lv_progTempVars_6_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1108:6: lv_progTempVars_6_0= ruleTempVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgTempVarsTempVarDeclarationParserRuleCall_2_4_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    // InternalPoST.g:1126:4: ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1126:4: ( (lv_progExternVars_7_0= ruleExternalVarDeclaration ) )
            	    // InternalPoST.g:1127:5: (lv_progExternVars_7_0= ruleExternalVarDeclaration )
            	    {
            	    // InternalPoST.g:1127:5: (lv_progExternVars_7_0= ruleExternalVarDeclaration )
            	    // InternalPoST.g:1128:6: lv_progExternVars_7_0= ruleExternalVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProgramAccess().getProgExternVarsExternalVarDeclarationParserRuleCall_2_5_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    break loop13;
                }
            } while (true);

            // InternalPoST.g:1146:3: ( (lv_processes_8_0= ruleProcess ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==52) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPoST.g:1147:4: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalPoST.g:1147:4: (lv_processes_8_0= ruleProcess )
            	    // InternalPoST.g:1148:5: lv_processes_8_0= ruleProcess
            	    {

            	    					newCompositeNode(grammarAccess.getProgramAccess().getProcessesProcessParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_30);
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
            	    break loop14;
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
    // InternalPoST.g:1173:1: entryRuleFunctionBlock returns [EObject current=null] : iv_ruleFunctionBlock= ruleFunctionBlock EOF ;
    public final EObject entryRuleFunctionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionBlock = null;


        try {
            // InternalPoST.g:1173:54: (iv_ruleFunctionBlock= ruleFunctionBlock EOF )
            // InternalPoST.g:1174:2: iv_ruleFunctionBlock= ruleFunctionBlock EOF
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
    // InternalPoST.g:1180:1: ruleFunctionBlock returns [EObject current=null] : (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' ) ;
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
            // InternalPoST.g:1186:2: ( (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' ) )
            // InternalPoST.g:1187:2: (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' )
            {
            // InternalPoST.g:1187:2: (otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK' )
            // InternalPoST.g:1188:3: otherlv_0= 'FUNCTION_BLOCK' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )* ( (lv_processes_8_0= ruleProcess ) )* otherlv_9= 'END_FUNCTION_BLOCK'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionBlockAccess().getFUNCTION_BLOCKKeyword_0());
            		
            // InternalPoST.g:1192:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1193:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1193:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1194:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_31); 

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

            // InternalPoST.g:1210:3: ( ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) ) | ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) ) | ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) ) | ( (lv_fbVars_5_0= ruleVarDeclaration ) ) | ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) ) | ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) ) )*
            loop15:
            do {
                int alt15=7;
                switch ( input.LA(1) ) {
                case 95:
                    {
                    alt15=1;
                    }
                    break;
                case 97:
                    {
                    alt15=2;
                    }
                    break;
                case 98:
                    {
                    alt15=3;
                    }
                    break;
                case 99:
                    {
                    alt15=4;
                    }
                    break;
                case 101:
                    {
                    alt15=5;
                    }
                    break;
                case 102:
                    {
                    alt15=6;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // InternalPoST.g:1211:4: ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1211:4: ( (lv_fbInVars_2_0= ruleInputVarDeclaration ) )
            	    // InternalPoST.g:1212:5: (lv_fbInVars_2_0= ruleInputVarDeclaration )
            	    {
            	    // InternalPoST.g:1212:5: (lv_fbInVars_2_0= ruleInputVarDeclaration )
            	    // InternalPoST.g:1213:6: lv_fbInVars_2_0= ruleInputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbInVarsInputVarDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_31);
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
            	    // InternalPoST.g:1231:4: ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1231:4: ( (lv_fbOutVars_3_0= ruleOutputVarDeclaration ) )
            	    // InternalPoST.g:1232:5: (lv_fbOutVars_3_0= ruleOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1232:5: (lv_fbOutVars_3_0= ruleOutputVarDeclaration )
            	    // InternalPoST.g:1233:6: lv_fbOutVars_3_0= ruleOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbOutVarsOutputVarDeclarationParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_31);
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
            	    // InternalPoST.g:1251:4: ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1251:4: ( (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration ) )
            	    // InternalPoST.g:1252:5: (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    {
            	    // InternalPoST.g:1252:5: (lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration )
            	    // InternalPoST.g:1253:6: lv_fbInOutVars_4_0= ruleInputOutputVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbInOutVarsInputOutputVarDeclarationParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_31);
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
            	    // InternalPoST.g:1271:4: ( (lv_fbVars_5_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1271:4: ( (lv_fbVars_5_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1272:5: (lv_fbVars_5_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1272:5: (lv_fbVars_5_0= ruleVarDeclaration )
            	    // InternalPoST.g:1273:6: lv_fbVars_5_0= ruleVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbVarsVarDeclarationParserRuleCall_2_3_0());
            	    					
            	    pushFollow(FOLLOW_31);
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
            	    // InternalPoST.g:1291:4: ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1291:4: ( (lv_fbTempVars_6_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1292:5: (lv_fbTempVars_6_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1292:5: (lv_fbTempVars_6_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1293:6: lv_fbTempVars_6_0= ruleTempVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbTempVarsTempVarDeclarationParserRuleCall_2_4_0());
            	    					
            	    pushFollow(FOLLOW_31);
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
            	    // InternalPoST.g:1311:4: ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1311:4: ( (lv_fbExternVars_7_0= ruleExternalVarDeclaration ) )
            	    // InternalPoST.g:1312:5: (lv_fbExternVars_7_0= ruleExternalVarDeclaration )
            	    {
            	    // InternalPoST.g:1312:5: (lv_fbExternVars_7_0= ruleExternalVarDeclaration )
            	    // InternalPoST.g:1313:6: lv_fbExternVars_7_0= ruleExternalVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getFunctionBlockAccess().getFbExternVarsExternalVarDeclarationParserRuleCall_2_5_0());
            	    					
            	    pushFollow(FOLLOW_31);
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
            	    break loop15;
                }
            } while (true);

            // InternalPoST.g:1331:3: ( (lv_processes_8_0= ruleProcess ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==52) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPoST.g:1332:4: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalPoST.g:1332:4: (lv_processes_8_0= ruleProcess )
            	    // InternalPoST.g:1333:5: lv_processes_8_0= ruleProcess
            	    {

            	    					newCompositeNode(grammarAccess.getFunctionBlockAccess().getProcessesProcessParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_32);
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
            	    break loop16;
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
    // InternalPoST.g:1358:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalPoST.g:1358:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalPoST.g:1359:2: iv_ruleProcess= ruleProcess EOF
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
    // InternalPoST.g:1365:1: ruleProcess returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procVars_2_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_3_0= ruleTempVarDeclaration ) ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= 'END_PROCESS' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_5=null;
        EObject lv_procVars_2_0 = null;

        EObject lv_procTempVars_3_0 = null;

        EObject lv_states_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:1371:2: ( (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procVars_2_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_3_0= ruleTempVarDeclaration ) ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= 'END_PROCESS' ) )
            // InternalPoST.g:1372:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procVars_2_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_3_0= ruleTempVarDeclaration ) ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= 'END_PROCESS' )
            {
            // InternalPoST.g:1372:2: (otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procVars_2_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_3_0= ruleTempVarDeclaration ) ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= 'END_PROCESS' )
            // InternalPoST.g:1373:3: otherlv_0= 'PROCESS' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_procVars_2_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_3_0= ruleTempVarDeclaration ) ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= 'END_PROCESS'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:1377:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1378:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1378:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1379:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); 

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

            // InternalPoST.g:1395:3: ( ( (lv_procVars_2_0= ruleVarDeclaration ) ) | ( (lv_procTempVars_3_0= ruleTempVarDeclaration ) ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==99) ) {
                    alt17=1;
                }
                else if ( (LA17_0==101) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalPoST.g:1396:4: ( (lv_procVars_2_0= ruleVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1396:4: ( (lv_procVars_2_0= ruleVarDeclaration ) )
            	    // InternalPoST.g:1397:5: (lv_procVars_2_0= ruleVarDeclaration )
            	    {
            	    // InternalPoST.g:1397:5: (lv_procVars_2_0= ruleVarDeclaration )
            	    // InternalPoST.g:1398:6: lv_procVars_2_0= ruleVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcVarsVarDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_33);
            	    lv_procVars_2_0=ruleVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procVars",
            	    							lv_procVars_2_0,
            	    							"su.nsk.iae.post.PoST.VarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:1416:4: ( (lv_procTempVars_3_0= ruleTempVarDeclaration ) )
            	    {
            	    // InternalPoST.g:1416:4: ( (lv_procTempVars_3_0= ruleTempVarDeclaration ) )
            	    // InternalPoST.g:1417:5: (lv_procTempVars_3_0= ruleTempVarDeclaration )
            	    {
            	    // InternalPoST.g:1417:5: (lv_procTempVars_3_0= ruleTempVarDeclaration )
            	    // InternalPoST.g:1418:6: lv_procTempVars_3_0= ruleTempVarDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getProcessAccess().getProcTempVarsTempVarDeclarationParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_33);
            	    lv_procTempVars_3_0=ruleTempVarDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getProcessRule());
            	    						}
            	    						add(
            	    							current,
            	    							"procTempVars",
            	    							lv_procTempVars_3_0,
            	    							"su.nsk.iae.post.PoST.TempVarDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // InternalPoST.g:1436:3: ( (lv_states_4_0= ruleState ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==58) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalPoST.g:1437:4: (lv_states_4_0= ruleState )
            	    {
            	    // InternalPoST.g:1437:4: (lv_states_4_0= ruleState )
            	    // InternalPoST.g:1438:5: lv_states_4_0= ruleState
            	    {

            	    					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_34);
            	    lv_states_4_0=ruleState();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProcessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"states",
            	    						lv_states_4_0,
            	    						"su.nsk.iae.post.PoST.State");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_5=(Token)match(input,57,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getEND_PROCESSKeyword_4());
            		

            }


            }


            	leaveRule();

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
    // InternalPoST.g:1463:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalPoST.g:1463:46: (iv_ruleState= ruleState EOF )
            // InternalPoST.g:1464:2: iv_ruleState= ruleState EOF
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
    // InternalPoST.g:1470:1: ruleState returns [EObject current=null] : (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' ) ;
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
            // InternalPoST.g:1476:2: ( (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' ) )
            // InternalPoST.g:1477:2: (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' )
            {
            // InternalPoST.g:1477:2: (otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE' )
            // InternalPoST.g:1478:3: otherlv_0= 'STATE' ( (lv_name_1_0= RULE_ID ) ) ( (lv_looped_2_0= 'LOOPED' ) )? ( (lv_statement_3_0= ruleStatementList ) ) ( (lv_timeout_4_0= ruleTimeoutStatement ) )? otherlv_5= 'END_STATE'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getSTATEKeyword_0());
            		
            // InternalPoST.g:1482:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalPoST.g:1483:4: (lv_name_1_0= RULE_ID )
            {
            // InternalPoST.g:1483:4: (lv_name_1_0= RULE_ID )
            // InternalPoST.g:1484:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_35); 

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

            // InternalPoST.g:1500:3: ( (lv_looped_2_0= 'LOOPED' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==59) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalPoST.g:1501:4: (lv_looped_2_0= 'LOOPED' )
                    {
                    // InternalPoST.g:1501:4: (lv_looped_2_0= 'LOOPED' )
                    // InternalPoST.g:1502:5: lv_looped_2_0= 'LOOPED'
                    {
                    lv_looped_2_0=(Token)match(input,59,FOLLOW_36); 

                    					newLeafNode(lv_looped_2_0, grammarAccess.getStateAccess().getLoopedLOOPEDKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getStateRule());
                    					}
                    					setWithLastConsumed(current, "looped", lv_looped_2_0 != null, "LOOPED");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:1514:3: ( (lv_statement_3_0= ruleStatementList ) )
            // InternalPoST.g:1515:4: (lv_statement_3_0= ruleStatementList )
            {
            // InternalPoST.g:1515:4: (lv_statement_3_0= ruleStatementList )
            // InternalPoST.g:1516:5: lv_statement_3_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getStateAccess().getStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_37);
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

            // InternalPoST.g:1533:3: ( (lv_timeout_4_0= ruleTimeoutStatement ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==69) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalPoST.g:1534:4: (lv_timeout_4_0= ruleTimeoutStatement )
                    {
                    // InternalPoST.g:1534:4: (lv_timeout_4_0= ruleTimeoutStatement )
                    // InternalPoST.g:1535:5: lv_timeout_4_0= ruleTimeoutStatement
                    {

                    					newCompositeNode(grammarAccess.getStateAccess().getTimeoutTimeoutStatementParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_38);
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
    // InternalPoST.g:1560:1: entryRuleSetStateStatement returns [EObject current=null] : iv_ruleSetStateStatement= ruleSetStateStatement EOF ;
    public final EObject entryRuleSetStateStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStatement = null;


        try {
            // InternalPoST.g:1560:58: (iv_ruleSetStateStatement= ruleSetStateStatement EOF )
            // InternalPoST.g:1561:2: iv_ruleSetStateStatement= ruleSetStateStatement EOF
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
    // InternalPoST.g:1567:1: ruleSetStateStatement returns [EObject current=null] : ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) ) ;
    public final EObject ruleSetStateStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_next_4_0=null;


        	enterRule();

        try {
            // InternalPoST.g:1573:2: ( ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) ) )
            // InternalPoST.g:1574:2: ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) )
            {
            // InternalPoST.g:1574:2: ( () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) ) )
            // InternalPoST.g:1575:3: () otherlv_1= 'SET' ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) )
            {
            // InternalPoST.g:1575:3: ()
            // InternalPoST.g:1576:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSetStateStatementAccess().getSetStateStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,61,FOLLOW_39); 

            			newLeafNode(otherlv_1, grammarAccess.getSetStateStatementAccess().getSETKeyword_1());
            		
            // InternalPoST.g:1586:3: ( (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) ) | ( (lv_next_4_0= 'NEXT' ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==58) ) {
                alt21=1;
            }
            else if ( (LA21_0==62) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalPoST.g:1587:4: (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalPoST.g:1587:4: (otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) ) )
                    // InternalPoST.g:1588:5: otherlv_2= 'STATE' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,58,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getSetStateStatementAccess().getSTATEKeyword_2_0_0());
                    				
                    // InternalPoST.g:1592:5: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:1593:6: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:1593:6: (otherlv_3= RULE_ID )
                    // InternalPoST.g:1594:7: otherlv_3= RULE_ID
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
                    // InternalPoST.g:1607:4: ( (lv_next_4_0= 'NEXT' ) )
                    {
                    // InternalPoST.g:1607:4: ( (lv_next_4_0= 'NEXT' ) )
                    // InternalPoST.g:1608:5: (lv_next_4_0= 'NEXT' )
                    {
                    // InternalPoST.g:1608:5: (lv_next_4_0= 'NEXT' )
                    // InternalPoST.g:1609:6: lv_next_4_0= 'NEXT'
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
    // InternalPoST.g:1626:1: entryRuleProcessStatements returns [EObject current=null] : iv_ruleProcessStatements= ruleProcessStatements EOF ;
    public final EObject entryRuleProcessStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessStatements = null;


        try {
            // InternalPoST.g:1626:58: (iv_ruleProcessStatements= ruleProcessStatements EOF )
            // InternalPoST.g:1627:2: iv_ruleProcessStatements= ruleProcessStatements EOF
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
    // InternalPoST.g:1633:1: ruleProcessStatements returns [EObject current=null] : (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement ) ;
    public final EObject ruleProcessStatements() throws RecognitionException {
        EObject current = null;

        EObject this_StartProcessStatement_0 = null;

        EObject this_StopProcessStatement_1 = null;

        EObject this_ErrorProcessStatement_2 = null;



        	enterRule();

        try {
            // InternalPoST.g:1639:2: ( (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement ) )
            // InternalPoST.g:1640:2: (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement )
            {
            // InternalPoST.g:1640:2: (this_StartProcessStatement_0= ruleStartProcessStatement | this_StopProcessStatement_1= ruleStopProcessStatement | this_ErrorProcessStatement_2= ruleErrorProcessStatement )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 67:
            case 68:
                {
                alt22=1;
                }
                break;
            case 65:
                {
                alt22=2;
                }
                break;
            case 66:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalPoST.g:1641:3: this_StartProcessStatement_0= ruleStartProcessStatement
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
                    // InternalPoST.g:1650:3: this_StopProcessStatement_1= ruleStopProcessStatement
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
                    // InternalPoST.g:1659:3: this_ErrorProcessStatement_2= ruleErrorProcessStatement
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
    // InternalPoST.g:1671:1: entryRuleProcessStatusExpression returns [EObject current=null] : iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF ;
    public final EObject entryRuleProcessStatusExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessStatusExpression = null;


        try {
            // InternalPoST.g:1671:64: (iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF )
            // InternalPoST.g:1672:2: iv_ruleProcessStatusExpression= ruleProcessStatusExpression EOF
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
    // InternalPoST.g:1678:1: ruleProcessStatusExpression returns [EObject current=null] : (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) ) ;
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
            // InternalPoST.g:1684:2: ( (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) ) )
            // InternalPoST.g:1685:2: (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) )
            {
            // InternalPoST.g:1685:2: (otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) ) )
            // InternalPoST.g:1686:3: otherlv_0= 'PROCESS' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'IN' otherlv_3= 'STATE' ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessStatusExpressionAccess().getPROCESSKeyword_0());
            		
            // InternalPoST.g:1690:3: ( (otherlv_1= RULE_ID ) )
            // InternalPoST.g:1691:4: (otherlv_1= RULE_ID )
            {
            // InternalPoST.g:1691:4: (otherlv_1= RULE_ID )
            // InternalPoST.g:1692:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessStatusExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_40); 

            					newLeafNode(otherlv_1, grammarAccess.getProcessStatusExpressionAccess().getProcessProcessCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,63,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getProcessStatusExpressionAccess().getINKeyword_2());
            		
            otherlv_3=(Token)match(input,58,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getProcessStatusExpressionAccess().getSTATEKeyword_3());
            		
            // InternalPoST.g:1711:3: ( ( (lv_active_4_0= 'ACTIVE' ) ) | ( (lv_inactive_5_0= 'INACTIVE' ) ) | ( (lv_stop_6_0= 'STOP' ) ) | ( (lv_error_7_0= 'ERROR' ) ) )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt23=1;
                }
                break;
            case 64:
                {
                alt23=2;
                }
                break;
            case 65:
                {
                alt23=3;
                }
                break;
            case 66:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalPoST.g:1712:4: ( (lv_active_4_0= 'ACTIVE' ) )
                    {
                    // InternalPoST.g:1712:4: ( (lv_active_4_0= 'ACTIVE' ) )
                    // InternalPoST.g:1713:5: (lv_active_4_0= 'ACTIVE' )
                    {
                    // InternalPoST.g:1713:5: (lv_active_4_0= 'ACTIVE' )
                    // InternalPoST.g:1714:6: lv_active_4_0= 'ACTIVE'
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
                    // InternalPoST.g:1727:4: ( (lv_inactive_5_0= 'INACTIVE' ) )
                    {
                    // InternalPoST.g:1727:4: ( (lv_inactive_5_0= 'INACTIVE' ) )
                    // InternalPoST.g:1728:5: (lv_inactive_5_0= 'INACTIVE' )
                    {
                    // InternalPoST.g:1728:5: (lv_inactive_5_0= 'INACTIVE' )
                    // InternalPoST.g:1729:6: lv_inactive_5_0= 'INACTIVE'
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
                    // InternalPoST.g:1742:4: ( (lv_stop_6_0= 'STOP' ) )
                    {
                    // InternalPoST.g:1742:4: ( (lv_stop_6_0= 'STOP' ) )
                    // InternalPoST.g:1743:5: (lv_stop_6_0= 'STOP' )
                    {
                    // InternalPoST.g:1743:5: (lv_stop_6_0= 'STOP' )
                    // InternalPoST.g:1744:6: lv_stop_6_0= 'STOP'
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
                    // InternalPoST.g:1757:4: ( (lv_error_7_0= 'ERROR' ) )
                    {
                    // InternalPoST.g:1757:4: ( (lv_error_7_0= 'ERROR' ) )
                    // InternalPoST.g:1758:5: (lv_error_7_0= 'ERROR' )
                    {
                    // InternalPoST.g:1758:5: (lv_error_7_0= 'ERROR' )
                    // InternalPoST.g:1759:6: lv_error_7_0= 'ERROR'
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
    // InternalPoST.g:1776:1: entryRuleStartProcessStatement returns [EObject current=null] : iv_ruleStartProcessStatement= ruleStartProcessStatement EOF ;
    public final EObject entryRuleStartProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcessStatement = null;


        try {
            // InternalPoST.g:1776:62: (iv_ruleStartProcessStatement= ruleStartProcessStatement EOF )
            // InternalPoST.g:1777:2: iv_ruleStartProcessStatement= ruleStartProcessStatement EOF
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
    // InternalPoST.g:1783:1: ruleStartProcessStatement returns [EObject current=null] : ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) ) ;
    public final EObject ruleStartProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalPoST.g:1789:2: ( ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) ) )
            // InternalPoST.g:1790:2: ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) )
            {
            // InternalPoST.g:1790:2: ( ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) ) | ( () otherlv_5= 'RESTART' ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==67) ) {
                alt24=1;
            }
            else if ( (LA24_0==68) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalPoST.g:1791:3: ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) )
                    {
                    // InternalPoST.g:1791:3: ( () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) ) )
                    // InternalPoST.g:1792:4: () (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalPoST.g:1792:4: ()
                    // InternalPoST.g:1793:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStartProcessStatementAccess().getStartProcessStatementAction_0_0(),
                    						current);
                    				

                    }

                    // InternalPoST.g:1799:4: (otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )
                    // InternalPoST.g:1800:5: otherlv_1= 'START' otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,67,FOLLOW_43); 

                    					newLeafNode(otherlv_1, grammarAccess.getStartProcessStatementAccess().getSTARTKeyword_0_1_0());
                    				
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getStartProcessStatementAccess().getPROCESSKeyword_0_1_1());
                    				
                    // InternalPoST.g:1808:5: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:1809:6: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:1809:6: (otherlv_3= RULE_ID )
                    // InternalPoST.g:1810:7: otherlv_3= RULE_ID
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
                    // InternalPoST.g:1824:3: ( () otherlv_5= 'RESTART' )
                    {
                    // InternalPoST.g:1824:3: ( () otherlv_5= 'RESTART' )
                    // InternalPoST.g:1825:4: () otherlv_5= 'RESTART'
                    {
                    // InternalPoST.g:1825:4: ()
                    // InternalPoST.g:1826:5: 
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
    // InternalPoST.g:1841:1: entryRuleStopProcessStatement returns [EObject current=null] : iv_ruleStopProcessStatement= ruleStopProcessStatement EOF ;
    public final EObject entryRuleStopProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcessStatement = null;


        try {
            // InternalPoST.g:1841:61: (iv_ruleStopProcessStatement= ruleStopProcessStatement EOF )
            // InternalPoST.g:1842:2: iv_ruleStopProcessStatement= ruleStopProcessStatement EOF
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
    // InternalPoST.g:1848:1: ruleStopProcessStatement returns [EObject current=null] : ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleStopProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPoST.g:1854:2: ( ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalPoST.g:1855:2: ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalPoST.g:1855:2: ( () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalPoST.g:1856:3: () otherlv_1= 'STOP' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalPoST.g:1856:3: ()
            // InternalPoST.g:1857:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStopProcessStatementAccess().getStopProcessStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,65,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getStopProcessStatementAccess().getSTOPKeyword_1());
            		
            // InternalPoST.g:1867:3: (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==52) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalPoST.g:1868:4: otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getStopProcessStatementAccess().getPROCESSKeyword_2_0());
                    			
                    // InternalPoST.g:1872:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:1873:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:1873:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:1874:6: otherlv_3= RULE_ID
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
    // InternalPoST.g:1890:1: entryRuleErrorProcessStatement returns [EObject current=null] : iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF ;
    public final EObject entryRuleErrorProcessStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorProcessStatement = null;


        try {
            // InternalPoST.g:1890:62: (iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF )
            // InternalPoST.g:1891:2: iv_ruleErrorProcessStatement= ruleErrorProcessStatement EOF
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
    // InternalPoST.g:1897:1: ruleErrorProcessStatement returns [EObject current=null] : ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleErrorProcessStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalPoST.g:1903:2: ( ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalPoST.g:1904:2: ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalPoST.g:1904:2: ( () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )? )
            // InternalPoST.g:1905:3: () otherlv_1= 'ERROR' (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalPoST.g:1905:3: ()
            // InternalPoST.g:1906:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getErrorProcessStatementAccess().getErrorProcessStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,66,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getErrorProcessStatementAccess().getERRORKeyword_1());
            		
            // InternalPoST.g:1916:3: (otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==52) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalPoST.g:1917:4: otherlv_2= 'PROCESS' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getErrorProcessStatementAccess().getPROCESSKeyword_2_0());
                    			
                    // InternalPoST.g:1921:4: ( (otherlv_3= RULE_ID ) )
                    // InternalPoST.g:1922:5: (otherlv_3= RULE_ID )
                    {
                    // InternalPoST.g:1922:5: (otherlv_3= RULE_ID )
                    // InternalPoST.g:1923:6: otherlv_3= RULE_ID
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
    // InternalPoST.g:1939:1: entryRuleTimeoutStatement returns [EObject current=null] : iv_ruleTimeoutStatement= ruleTimeoutStatement EOF ;
    public final EObject entryRuleTimeoutStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutStatement = null;


        try {
            // InternalPoST.g:1939:57: (iv_ruleTimeoutStatement= ruleTimeoutStatement EOF )
            // InternalPoST.g:1940:2: iv_ruleTimeoutStatement= ruleTimeoutStatement EOF
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
    // InternalPoST.g:1946:1: ruleTimeoutStatement returns [EObject current=null] : (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' ) ;
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
            // InternalPoST.g:1952:2: ( (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' ) )
            // InternalPoST.g:1953:2: (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' )
            {
            // InternalPoST.g:1953:2: (otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT' )
            // InternalPoST.g:1954:3: otherlv_0= 'TIMEOUT' ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) ) otherlv_3= 'THEN' ( (lv_statement_4_0= ruleStatementList ) ) otherlv_5= 'END_TIMEOUT'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeoutStatementAccess().getTIMEOUTKeyword_0());
            		
            // InternalPoST.g:1958:3: ( ( (lv_const_1_0= ruleConstant ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_INTEGER||LA27_0==RULE_TIME_PREF_LITERAL||(LA27_0>=RULE_REAL_TYPE_NAME && LA27_0<=RULE_REAL)||LA27_0==108) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_ID) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalPoST.g:1959:4: ( (lv_const_1_0= ruleConstant ) )
                    {
                    // InternalPoST.g:1959:4: ( (lv_const_1_0= ruleConstant ) )
                    // InternalPoST.g:1960:5: (lv_const_1_0= ruleConstant )
                    {
                    // InternalPoST.g:1960:5: (lv_const_1_0= ruleConstant )
                    // InternalPoST.g:1961:6: lv_const_1_0= ruleConstant
                    {

                    						newCompositeNode(grammarAccess.getTimeoutStatementAccess().getConstConstantParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_45);
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
                    // InternalPoST.g:1979:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalPoST.g:1979:4: ( (otherlv_2= RULE_ID ) )
                    // InternalPoST.g:1980:5: (otherlv_2= RULE_ID )
                    {
                    // InternalPoST.g:1980:5: (otherlv_2= RULE_ID )
                    // InternalPoST.g:1981:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeoutStatementRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_45); 

                    						newLeafNode(otherlv_2, grammarAccess.getTimeoutStatementAccess().getVariableSymbolicVariableCrossReference_1_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,70,FOLLOW_46); 

            			newLeafNode(otherlv_3, grammarAccess.getTimeoutStatementAccess().getTHENKeyword_2());
            		
            // InternalPoST.g:1997:3: ( (lv_statement_4_0= ruleStatementList ) )
            // InternalPoST.g:1998:4: (lv_statement_4_0= ruleStatementList )
            {
            // InternalPoST.g:1998:4: (lv_statement_4_0= ruleStatementList )
            // InternalPoST.g:1999:5: lv_statement_4_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getTimeoutStatementAccess().getStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_47);
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
    // InternalPoST.g:2024:1: entryRuleResetTimerStatement returns [EObject current=null] : iv_ruleResetTimerStatement= ruleResetTimerStatement EOF ;
    public final EObject entryRuleResetTimerStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetTimerStatement = null;


        try {
            // InternalPoST.g:2024:60: (iv_ruleResetTimerStatement= ruleResetTimerStatement EOF )
            // InternalPoST.g:2025:2: iv_ruleResetTimerStatement= ruleResetTimerStatement EOF
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
    // InternalPoST.g:2031:1: ruleResetTimerStatement returns [EObject current=null] : ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' ) ;
    public final EObject ruleResetTimerStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalPoST.g:2037:2: ( ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' ) )
            // InternalPoST.g:2038:2: ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' )
            {
            // InternalPoST.g:2038:2: ( () otherlv_1= 'RESET' otherlv_2= 'TIMER' )
            // InternalPoST.g:2039:3: () otherlv_1= 'RESET' otherlv_2= 'TIMER'
            {
            // InternalPoST.g:2039:3: ()
            // InternalPoST.g:2040:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getResetTimerStatementAccess().getResetTimerStatementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,72,FOLLOW_48); 

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
    // InternalPoST.g:2058:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalPoST.g:2058:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalPoST.g:2059:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalPoST.g:2065:1: ruleExpression returns [EObject current=null] : (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token this_OR_OPERATOR_2=null;
        EObject this_XorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2071:2: ( (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* ) )
            // InternalPoST.g:2072:2: (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* )
            {
            // InternalPoST.g:2072:2: (this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )* )
            // InternalPoST.g:2073:3: this_XorExpression_0= ruleXorExpression ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getExpressionAccess().getXorExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_49);
            this_XorExpression_0=ruleXorExpression();

            state._fsp--;


            			current = this_XorExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2081:3: ( () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_OR_OPERATOR) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalPoST.g:2082:4: () this_OR_OPERATOR_2= RULE_OR_OPERATOR ( (lv_right_3_0= ruleXorExpression ) )
            	    {
            	    // InternalPoST.g:2082:4: ()
            	    // InternalPoST.g:2083:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getExpressionAccess().getExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_OR_OPERATOR_2=(Token)match(input,RULE_OR_OPERATOR,FOLLOW_50); 

            	    				newLeafNode(this_OR_OPERATOR_2, grammarAccess.getExpressionAccess().getOR_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2093:4: ( (lv_right_3_0= ruleXorExpression ) )
            	    // InternalPoST.g:2094:5: (lv_right_3_0= ruleXorExpression )
            	    {
            	    // InternalPoST.g:2094:5: (lv_right_3_0= ruleXorExpression )
            	    // InternalPoST.g:2095:6: lv_right_3_0= ruleXorExpression
            	    {

            	    						newCompositeNode(grammarAccess.getExpressionAccess().getRightXorExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_49);
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
            	    break loop28;
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
    // InternalPoST.g:2117:1: entryRuleXorExpression returns [EObject current=null] : iv_ruleXorExpression= ruleXorExpression EOF ;
    public final EObject entryRuleXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpression = null;


        try {
            // InternalPoST.g:2117:54: (iv_ruleXorExpression= ruleXorExpression EOF )
            // InternalPoST.g:2118:2: iv_ruleXorExpression= ruleXorExpression EOF
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
    // InternalPoST.g:2124:1: ruleXorExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_XOR_OPERATOR_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2130:2: ( (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalPoST.g:2131:2: (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalPoST.g:2131:2: (this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalPoST.g:2132:3: this_AndExpression_0= ruleAndExpression ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_51);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2140:3: ( () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_XOR_OPERATOR) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalPoST.g:2141:4: () this_XOR_OPERATOR_2= RULE_XOR_OPERATOR ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalPoST.g:2141:4: ()
            	    // InternalPoST.g:2142:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorExpressionAccess().getXorExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_XOR_OPERATOR_2=(Token)match(input,RULE_XOR_OPERATOR,FOLLOW_50); 

            	    				newLeafNode(this_XOR_OPERATOR_2, grammarAccess.getXorExpressionAccess().getXOR_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2152:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalPoST.g:2153:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalPoST.g:2153:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalPoST.g:2154:6: lv_right_3_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getXorExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_51);
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
            	    break loop29;
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
    // InternalPoST.g:2176:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalPoST.g:2176:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalPoST.g:2177:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalPoST.g:2183:1: ruleAndExpression returns [EObject current=null] : (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_AND_OPERATOR_2=null;
        EObject this_CompExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2189:2: ( (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* ) )
            // InternalPoST.g:2190:2: (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* )
            {
            // InternalPoST.g:2190:2: (this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )* )
            // InternalPoST.g:2191:3: this_CompExpression_0= ruleCompExpression ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getCompExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_52);
            this_CompExpression_0=ruleCompExpression();

            state._fsp--;


            			current = this_CompExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2199:3: ( () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_AND_OPERATOR) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalPoST.g:2200:4: () this_AND_OPERATOR_2= RULE_AND_OPERATOR ( (lv_right_3_0= ruleCompExpression ) )
            	    {
            	    // InternalPoST.g:2200:4: ()
            	    // InternalPoST.g:2201:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_AND_OPERATOR_2=(Token)match(input,RULE_AND_OPERATOR,FOLLOW_50); 

            	    				newLeafNode(this_AND_OPERATOR_2, grammarAccess.getAndExpressionAccess().getAND_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2211:4: ( (lv_right_3_0= ruleCompExpression ) )
            	    // InternalPoST.g:2212:5: (lv_right_3_0= ruleCompExpression )
            	    {
            	    // InternalPoST.g:2212:5: (lv_right_3_0= ruleCompExpression )
            	    // InternalPoST.g:2213:6: lv_right_3_0= ruleCompExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightCompExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_52);
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
            	    break loop30;
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
    // InternalPoST.g:2235:1: entryRuleCompExpression returns [EObject current=null] : iv_ruleCompExpression= ruleCompExpression EOF ;
    public final EObject entryRuleCompExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompExpression = null;


        try {
            // InternalPoST.g:2235:55: (iv_ruleCompExpression= ruleCompExpression EOF )
            // InternalPoST.g:2236:2: iv_ruleCompExpression= ruleCompExpression EOF
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
    // InternalPoST.g:2242:1: ruleCompExpression returns [EObject current=null] : (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* ) ;
    public final EObject ruleCompExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EquExpression_0 = null;

        Enumerator lv_compOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2248:2: ( (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* ) )
            // InternalPoST.g:2249:2: (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* )
            {
            // InternalPoST.g:2249:2: (this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )* )
            // InternalPoST.g:2250:3: this_EquExpression_0= ruleEquExpression ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getCompExpressionAccess().getEquExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_53);
            this_EquExpression_0=ruleEquExpression();

            state._fsp--;


            			current = this_EquExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2258:3: ( () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=110 && LA31_0<=111)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalPoST.g:2259:4: () ( (lv_compOp_2_0= ruleCompOperator ) ) ( (lv_right_3_0= ruleEquExpression ) )
            	    {
            	    // InternalPoST.g:2259:4: ()
            	    // InternalPoST.g:2260:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getCompExpressionAccess().getCompExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2266:4: ( (lv_compOp_2_0= ruleCompOperator ) )
            	    // InternalPoST.g:2267:5: (lv_compOp_2_0= ruleCompOperator )
            	    {
            	    // InternalPoST.g:2267:5: (lv_compOp_2_0= ruleCompOperator )
            	    // InternalPoST.g:2268:6: lv_compOp_2_0= ruleCompOperator
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

            	    // InternalPoST.g:2285:4: ( (lv_right_3_0= ruleEquExpression ) )
            	    // InternalPoST.g:2286:5: (lv_right_3_0= ruleEquExpression )
            	    {
            	    // InternalPoST.g:2286:5: (lv_right_3_0= ruleEquExpression )
            	    // InternalPoST.g:2287:6: lv_right_3_0= ruleEquExpression
            	    {

            	    						newCompositeNode(grammarAccess.getCompExpressionAccess().getRightEquExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_53);
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
            	    break loop31;
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
    // InternalPoST.g:2309:1: entryRuleEquExpression returns [EObject current=null] : iv_ruleEquExpression= ruleEquExpression EOF ;
    public final EObject entryRuleEquExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquExpression = null;


        try {
            // InternalPoST.g:2309:54: (iv_ruleEquExpression= ruleEquExpression EOF )
            // InternalPoST.g:2310:2: iv_ruleEquExpression= ruleEquExpression EOF
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
    // InternalPoST.g:2316:1: ruleEquExpression returns [EObject current=null] : (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* ) ;
    public final EObject ruleEquExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AddExpression_0 = null;

        Enumerator lv_equOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2322:2: ( (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* ) )
            // InternalPoST.g:2323:2: (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* )
            {
            // InternalPoST.g:2323:2: (this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )* )
            // InternalPoST.g:2324:3: this_AddExpression_0= ruleAddExpression ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getEquExpressionAccess().getAddExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_AddExpression_0=ruleAddExpression();

            state._fsp--;


            			current = this_AddExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2332:3: ( () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=112 && LA32_0<=115)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalPoST.g:2333:4: () ( (lv_equOp_2_0= ruleEquOperator ) ) ( (lv_right_3_0= ruleAddExpression ) )
            	    {
            	    // InternalPoST.g:2333:4: ()
            	    // InternalPoST.g:2334:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEquExpressionAccess().getEquExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2340:4: ( (lv_equOp_2_0= ruleEquOperator ) )
            	    // InternalPoST.g:2341:5: (lv_equOp_2_0= ruleEquOperator )
            	    {
            	    // InternalPoST.g:2341:5: (lv_equOp_2_0= ruleEquOperator )
            	    // InternalPoST.g:2342:6: lv_equOp_2_0= ruleEquOperator
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

            	    // InternalPoST.g:2359:4: ( (lv_right_3_0= ruleAddExpression ) )
            	    // InternalPoST.g:2360:5: (lv_right_3_0= ruleAddExpression )
            	    {
            	    // InternalPoST.g:2360:5: (lv_right_3_0= ruleAddExpression )
            	    // InternalPoST.g:2361:6: lv_right_3_0= ruleAddExpression
            	    {

            	    						newCompositeNode(grammarAccess.getEquExpressionAccess().getRightAddExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_54);
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
    // $ANTLR end "ruleEquExpression"


    // $ANTLR start "entryRuleAddExpression"
    // InternalPoST.g:2383:1: entryRuleAddExpression returns [EObject current=null] : iv_ruleAddExpression= ruleAddExpression EOF ;
    public final EObject entryRuleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddExpression = null;


        try {
            // InternalPoST.g:2383:54: (iv_ruleAddExpression= ruleAddExpression EOF )
            // InternalPoST.g:2384:2: iv_ruleAddExpression= ruleAddExpression EOF
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
    // InternalPoST.g:2390:1: ruleAddExpression returns [EObject current=null] : (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* ) ;
    public final EObject ruleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MulExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2396:2: ( (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* ) )
            // InternalPoST.g:2397:2: (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* )
            {
            // InternalPoST.g:2397:2: (this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )* )
            // InternalPoST.g:2398:3: this_MulExpression_0= ruleMulExpression ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAddExpressionAccess().getMulExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_55);
            this_MulExpression_0=ruleMulExpression();

            state._fsp--;


            			current = this_MulExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2406:3: ( () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==108||LA33_0==116) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalPoST.g:2407:4: () ( (lv_addOp_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMulExpression ) )
            	    {
            	    // InternalPoST.g:2407:4: ()
            	    // InternalPoST.g:2408:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAddExpressionAccess().getAddExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2414:4: ( (lv_addOp_2_0= ruleAddOperator ) )
            	    // InternalPoST.g:2415:5: (lv_addOp_2_0= ruleAddOperator )
            	    {
            	    // InternalPoST.g:2415:5: (lv_addOp_2_0= ruleAddOperator )
            	    // InternalPoST.g:2416:6: lv_addOp_2_0= ruleAddOperator
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

            	    // InternalPoST.g:2433:4: ( (lv_right_3_0= ruleMulExpression ) )
            	    // InternalPoST.g:2434:5: (lv_right_3_0= ruleMulExpression )
            	    {
            	    // InternalPoST.g:2434:5: (lv_right_3_0= ruleMulExpression )
            	    // InternalPoST.g:2435:6: lv_right_3_0= ruleMulExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAddExpressionAccess().getRightMulExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_55);
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
    // $ANTLR end "ruleAddExpression"


    // $ANTLR start "entryRuleMulExpression"
    // InternalPoST.g:2457:1: entryRuleMulExpression returns [EObject current=null] : iv_ruleMulExpression= ruleMulExpression EOF ;
    public final EObject entryRuleMulExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMulExpression = null;


        try {
            // InternalPoST.g:2457:54: (iv_ruleMulExpression= ruleMulExpression EOF )
            // InternalPoST.g:2458:2: iv_ruleMulExpression= ruleMulExpression EOF
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
    // InternalPoST.g:2464:1: ruleMulExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) ;
    public final EObject ruleMulExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2470:2: ( (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) )
            // InternalPoST.g:2471:2: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            {
            // InternalPoST.g:2471:2: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            // InternalPoST.g:2472:3: this_PowerExpression_0= rulePowerExpression ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMulExpressionAccess().getPowerExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_56);
            this_PowerExpression_0=rulePowerExpression();

            state._fsp--;


            			current = this_PowerExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2480:3: ( () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=117 && LA34_0<=119)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalPoST.g:2481:4: () ( (lv_mulOp_2_0= ruleMulOperator ) ) ( (lv_right_3_0= rulePowerExpression ) )
            	    {
            	    // InternalPoST.g:2481:4: ()
            	    // InternalPoST.g:2482:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getMulExpressionAccess().getMulExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalPoST.g:2488:4: ( (lv_mulOp_2_0= ruleMulOperator ) )
            	    // InternalPoST.g:2489:5: (lv_mulOp_2_0= ruleMulOperator )
            	    {
            	    // InternalPoST.g:2489:5: (lv_mulOp_2_0= ruleMulOperator )
            	    // InternalPoST.g:2490:6: lv_mulOp_2_0= ruleMulOperator
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

            	    // InternalPoST.g:2507:4: ( (lv_right_3_0= rulePowerExpression ) )
            	    // InternalPoST.g:2508:5: (lv_right_3_0= rulePowerExpression )
            	    {
            	    // InternalPoST.g:2508:5: (lv_right_3_0= rulePowerExpression )
            	    // InternalPoST.g:2509:6: lv_right_3_0= rulePowerExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMulExpressionAccess().getRightPowerExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_56);
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
    // $ANTLR end "ruleMulExpression"


    // $ANTLR start "entryRulePowerExpression"
    // InternalPoST.g:2531:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // InternalPoST.g:2531:56: (iv_rulePowerExpression= rulePowerExpression EOF )
            // InternalPoST.g:2532:2: iv_rulePowerExpression= rulePowerExpression EOF
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
    // InternalPoST.g:2538:1: rulePowerExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        Token this_POWER_OPERATOR_2=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2544:2: ( (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) )
            // InternalPoST.g:2545:2: (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            {
            // InternalPoST.g:2545:2: (this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            // InternalPoST.g:2546:3: this_UnaryExpression_0= ruleUnaryExpression ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_57);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;


            			current = this_UnaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalPoST.g:2554:3: ( () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_POWER_OPERATOR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalPoST.g:2555:4: () this_POWER_OPERATOR_2= RULE_POWER_OPERATOR ( (lv_right_3_0= ruleUnaryExpression ) )
            	    {
            	    // InternalPoST.g:2555:4: ()
            	    // InternalPoST.g:2556:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPowerExpressionAccess().getPowerExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    this_POWER_OPERATOR_2=(Token)match(input,RULE_POWER_OPERATOR,FOLLOW_50); 

            	    				newLeafNode(this_POWER_OPERATOR_2, grammarAccess.getPowerExpressionAccess().getPOWER_OPERATORTerminalRuleCall_1_1());
            	    			
            	    // InternalPoST.g:2566:4: ( (lv_right_3_0= ruleUnaryExpression ) )
            	    // InternalPoST.g:2567:5: (lv_right_3_0= ruleUnaryExpression )
            	    {
            	    // InternalPoST.g:2567:5: (lv_right_3_0= ruleUnaryExpression )
            	    // InternalPoST.g:2568:6: lv_right_3_0= ruleUnaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getPowerExpressionAccess().getRightUnaryExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_57);
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
    // $ANTLR end "rulePowerExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalPoST.g:2590:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalPoST.g:2590:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalPoST.g:2591:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalPoST.g:2597:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_unOp_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2603:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) ) )
            // InternalPoST.g:2604:2: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) )
            {
            // InternalPoST.g:2604:2: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) ) )
            int alt36=2;
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
                alt36=1;
                }
                break;
            case 108:
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
                case 108:
                    {
                    alt36=2;
                    }
                    break;
                case RULE_INTEGER:
                    {
                    alt36=1;
                    }
                    break;
                case RULE_REAL:
                    {
                    alt36=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 2, input);

                    throw nvae;
                }

                }
                break;
            case 120:
                {
                alt36=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalPoST.g:2605:3: this_PrimaryExpression_0= rulePrimaryExpression
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
                    // InternalPoST.g:2614:3: ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) )
                    {
                    // InternalPoST.g:2614:3: ( ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) ) )
                    // InternalPoST.g:2615:4: ( (lv_unOp_1_0= ruleUnaryOperator ) ) ( (lv_right_2_0= rulePrimaryExpression ) )
                    {
                    // InternalPoST.g:2615:4: ( (lv_unOp_1_0= ruleUnaryOperator ) )
                    // InternalPoST.g:2616:5: (lv_unOp_1_0= ruleUnaryOperator )
                    {
                    // InternalPoST.g:2616:5: (lv_unOp_1_0= ruleUnaryOperator )
                    // InternalPoST.g:2617:6: lv_unOp_1_0= ruleUnaryOperator
                    {

                    						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnOpUnaryOperatorEnumRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_58);
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

                    // InternalPoST.g:2634:4: ( (lv_right_2_0= rulePrimaryExpression ) )
                    // InternalPoST.g:2635:5: (lv_right_2_0= rulePrimaryExpression )
                    {
                    // InternalPoST.g:2635:5: (lv_right_2_0= rulePrimaryExpression )
                    // InternalPoST.g:2636:6: lv_right_2_0= rulePrimaryExpression
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
    // InternalPoST.g:2658:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalPoST.g:2658:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalPoST.g:2659:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalPoST.g:2665:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) ;
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
            // InternalPoST.g:2671:2: ( ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) )
            // InternalPoST.g:2672:2: ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            {
            // InternalPoST.g:2672:2: ( ( (lv_const_0_0= ruleConstant ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_array_2_0= ruleArrayVariable ) ) | ( (lv_procStatus_3_0= ruleProcessStatusExpression ) ) | (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            int alt37=5;
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
                alt37=1;
                }
                break;
            case RULE_ID:
                {
                int LA37_2 = input.LA(2);

                if ( (LA37_2==EOF||(LA37_2>=RULE_OR_OPERATOR && LA37_2<=RULE_POWER_OPERATOR)||LA37_2==43||LA37_2==46||LA37_2==70||LA37_2==79||LA37_2==82||(LA37_2>=84 && LA37_2<=85)||LA37_2==90||LA37_2==94||LA37_2==108||(LA37_2>=110 && LA37_2<=119)) ) {
                    alt37=2;
                }
                else if ( (LA37_2==93) ) {
                    alt37=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 2, input);

                    throw nvae;
                }
                }
                break;
            case 52:
                {
                alt37=4;
                }
                break;
            case 45:
                {
                alt37=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalPoST.g:2673:3: ( (lv_const_0_0= ruleConstant ) )
                    {
                    // InternalPoST.g:2673:3: ( (lv_const_0_0= ruleConstant ) )
                    // InternalPoST.g:2674:4: (lv_const_0_0= ruleConstant )
                    {
                    // InternalPoST.g:2674:4: (lv_const_0_0= ruleConstant )
                    // InternalPoST.g:2675:5: lv_const_0_0= ruleConstant
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
                    // InternalPoST.g:2693:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalPoST.g:2693:3: ( (otherlv_1= RULE_ID ) )
                    // InternalPoST.g:2694:4: (otherlv_1= RULE_ID )
                    {
                    // InternalPoST.g:2694:4: (otherlv_1= RULE_ID )
                    // InternalPoST.g:2695:5: otherlv_1= RULE_ID
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
                    // InternalPoST.g:2707:3: ( (lv_array_2_0= ruleArrayVariable ) )
                    {
                    // InternalPoST.g:2707:3: ( (lv_array_2_0= ruleArrayVariable ) )
                    // InternalPoST.g:2708:4: (lv_array_2_0= ruleArrayVariable )
                    {
                    // InternalPoST.g:2708:4: (lv_array_2_0= ruleArrayVariable )
                    // InternalPoST.g:2709:5: lv_array_2_0= ruleArrayVariable
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
                    // InternalPoST.g:2727:3: ( (lv_procStatus_3_0= ruleProcessStatusExpression ) )
                    {
                    // InternalPoST.g:2727:3: ( (lv_procStatus_3_0= ruleProcessStatusExpression ) )
                    // InternalPoST.g:2728:4: (lv_procStatus_3_0= ruleProcessStatusExpression )
                    {
                    // InternalPoST.g:2728:4: (lv_procStatus_3_0= ruleProcessStatusExpression )
                    // InternalPoST.g:2729:5: lv_procStatus_3_0= ruleProcessStatusExpression
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
                    // InternalPoST.g:2747:3: (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalPoST.g:2747:3: (otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalPoST.g:2748:4: otherlv_4= '(' ( (lv_nestExpr_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,45,FOLLOW_50); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_4_0());
                    			
                    // InternalPoST.g:2752:4: ( (lv_nestExpr_5_0= ruleExpression ) )
                    // InternalPoST.g:2753:5: (lv_nestExpr_5_0= ruleExpression )
                    {
                    // InternalPoST.g:2753:5: (lv_nestExpr_5_0= ruleExpression )
                    // InternalPoST.g:2754:6: lv_nestExpr_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNestExprExpressionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_15);
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
    // InternalPoST.g:2780:1: entryRuleStatementList returns [EObject current=null] : iv_ruleStatementList= ruleStatementList EOF ;
    public final EObject entryRuleStatementList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementList = null;


        try {
            // InternalPoST.g:2780:54: (iv_ruleStatementList= ruleStatementList EOF )
            // InternalPoST.g:2781:2: iv_ruleStatementList= ruleStatementList EOF
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
    // InternalPoST.g:2787:1: ruleStatementList returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleStatementList() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2793:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalPoST.g:2794:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalPoST.g:2794:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalPoST.g:2795:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalPoST.g:2795:3: ()
            // InternalPoST.g:2796:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStatementListAccess().getStatementListAction_0(),
            					current);
            			

            }

            // InternalPoST.g:2802:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID||LA38_0==61||(LA38_0>=65 && LA38_0<=68)||LA38_0==72||LA38_0==74||LA38_0==78||LA38_0==81||LA38_0==86||LA38_0==88||(LA38_0>=91 && LA38_0<=92)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalPoST.g:2803:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalPoST.g:2803:4: (lv_statements_1_0= ruleStatement )
            	    // InternalPoST.g:2804:5: lv_statements_1_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getStatementListAccess().getStatementsStatementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_59);
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
    // $ANTLR end "ruleStatementList"


    // $ANTLR start "entryRuleStatement"
    // InternalPoST.g:2825:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalPoST.g:2825:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalPoST.g:2826:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalPoST.g:2832:1: ruleStatement returns [EObject current=null] : ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) ) ;
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
            // InternalPoST.g:2838:2: ( ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) ) )
            // InternalPoST.g:2839:2: ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) )
            {
            // InternalPoST.g:2839:2: ( (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' ) | this_SelectionStatement_2= ruleSelectionStatement | this_IterationStatement_3= ruleIterationStatement | (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' ) | (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' ) | (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' ) | (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' ) | (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' ) )
            int alt39=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt39=1;
                }
                break;
            case 74:
            case 78:
                {
                alt39=2;
                }
                break;
            case 81:
            case 86:
            case 88:
                {
                alt39=3;
                }
                break;
            case 91:
                {
                alt39=4;
                }
                break;
            case 92:
                {
                alt39=5;
                }
                break;
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt39=6;
                }
                break;
            case 61:
                {
                alt39=7;
                }
                break;
            case 72:
                {
                alt39=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalPoST.g:2840:3: (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' )
                    {
                    // InternalPoST.g:2840:3: (this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';' )
                    // InternalPoST.g:2841:4: this_AssignmentStatement_0= ruleAssignmentStatement otherlv_1= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_10);
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
                    // InternalPoST.g:2855:3: this_SelectionStatement_2= ruleSelectionStatement
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
                    // InternalPoST.g:2864:3: this_IterationStatement_3= ruleIterationStatement
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
                    // InternalPoST.g:2873:3: (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' )
                    {
                    // InternalPoST.g:2873:3: (this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';' )
                    // InternalPoST.g:2874:4: this_SubprogramControlStatement_4= ruleSubprogramControlStatement otherlv_5= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getSubprogramControlStatementParserRuleCall_3_0());
                    			
                    pushFollow(FOLLOW_10);
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
                    // InternalPoST.g:2888:3: (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' )
                    {
                    // InternalPoST.g:2888:3: (this_ExitStatement_6= ruleExitStatement otherlv_7= ';' )
                    // InternalPoST.g:2889:4: this_ExitStatement_6= ruleExitStatement otherlv_7= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getExitStatementParserRuleCall_4_0());
                    			
                    pushFollow(FOLLOW_10);
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
                    // InternalPoST.g:2903:3: (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' )
                    {
                    // InternalPoST.g:2903:3: (this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';' )
                    // InternalPoST.g:2904:4: this_ProcessStatements_8= ruleProcessStatements otherlv_9= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getProcessStatementsParserRuleCall_5_0());
                    			
                    pushFollow(FOLLOW_10);
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
                    // InternalPoST.g:2918:3: (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' )
                    {
                    // InternalPoST.g:2918:3: (this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';' )
                    // InternalPoST.g:2919:4: this_SetStateStatement_10= ruleSetStateStatement otherlv_11= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getSetStateStatementParserRuleCall_6_0());
                    			
                    pushFollow(FOLLOW_10);
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
                    // InternalPoST.g:2933:3: (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' )
                    {
                    // InternalPoST.g:2933:3: (this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';' )
                    // InternalPoST.g:2934:4: this_ResetTimerStatement_12= ruleResetTimerStatement otherlv_13= ';'
                    {

                    				newCompositeNode(grammarAccess.getStatementAccess().getResetTimerStatementParserRuleCall_7_0());
                    			
                    pushFollow(FOLLOW_10);
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
    // InternalPoST.g:2951:1: entryRuleAssignmentStatement returns [EObject current=null] : iv_ruleAssignmentStatement= ruleAssignmentStatement EOF ;
    public final EObject entryRuleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStatement = null;


        try {
            // InternalPoST.g:2951:60: (iv_ruleAssignmentStatement= ruleAssignmentStatement EOF )
            // InternalPoST.g:2952:2: iv_ruleAssignmentStatement= ruleAssignmentStatement EOF
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
    // InternalPoST.g:2958:1: ruleAssignmentStatement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_array_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:2964:2: ( ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalPoST.g:2965:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalPoST.g:2965:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            // InternalPoST.g:2966:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) )
            {
            // InternalPoST.g:2966:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_array_1_0= ruleArrayVariable ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==93) ) {
                    alt40=2;
                }
                else if ( (LA40_1==47) ) {
                    alt40=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalPoST.g:2967:4: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalPoST.g:2967:4: ( (otherlv_0= RULE_ID ) )
                    // InternalPoST.g:2968:5: (otherlv_0= RULE_ID )
                    {
                    // InternalPoST.g:2968:5: (otherlv_0= RULE_ID )
                    // InternalPoST.g:2969:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAssignmentStatementRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_16); 

                    						newLeafNode(otherlv_0, grammarAccess.getAssignmentStatementAccess().getVariableSymbolicVariableCrossReference_0_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:2981:4: ( (lv_array_1_0= ruleArrayVariable ) )
                    {
                    // InternalPoST.g:2981:4: ( (lv_array_1_0= ruleArrayVariable ) )
                    // InternalPoST.g:2982:5: (lv_array_1_0= ruleArrayVariable )
                    {
                    // InternalPoST.g:2982:5: (lv_array_1_0= ruleArrayVariable )
                    // InternalPoST.g:2983:6: lv_array_1_0= ruleArrayVariable
                    {

                    						newCompositeNode(grammarAccess.getAssignmentStatementAccess().getArrayArrayVariableParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_16);
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
            		
            // InternalPoST.g:3005:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalPoST.g:3006:4: (lv_value_3_0= ruleExpression )
            {
            // InternalPoST.g:3006:4: (lv_value_3_0= ruleExpression )
            // InternalPoST.g:3007:5: lv_value_3_0= ruleExpression
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
    // InternalPoST.g:3028:1: entryRuleSelectionStatement returns [EObject current=null] : iv_ruleSelectionStatement= ruleSelectionStatement EOF ;
    public final EObject entryRuleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionStatement = null;


        try {
            // InternalPoST.g:3028:59: (iv_ruleSelectionStatement= ruleSelectionStatement EOF )
            // InternalPoST.g:3029:2: iv_ruleSelectionStatement= ruleSelectionStatement EOF
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
    // InternalPoST.g:3035:1: ruleSelectionStatement returns [EObject current=null] : (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement ) ;
    public final EObject ruleSelectionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_IfStatement_0 = null;

        EObject this_CaseStatement_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:3041:2: ( (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement ) )
            // InternalPoST.g:3042:2: (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement )
            {
            // InternalPoST.g:3042:2: (this_IfStatement_0= ruleIfStatement | this_CaseStatement_1= ruleCaseStatement )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==74) ) {
                alt41=1;
            }
            else if ( (LA41_0==78) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalPoST.g:3043:3: this_IfStatement_0= ruleIfStatement
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
                    // InternalPoST.g:3052:3: this_CaseStatement_1= ruleCaseStatement
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
    // InternalPoST.g:3064:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalPoST.g:3064:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalPoST.g:3065:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalPoST.g:3071:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' ) ;
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
            // InternalPoST.g:3077:2: ( (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' ) )
            // InternalPoST.g:3078:2: (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' )
            {
            // InternalPoST.g:3078:2: (otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF' )
            // InternalPoST.g:3079:3: otherlv_0= 'IF' ( (lv_mainCond_1_0= ruleExpression ) ) otherlv_2= 'THEN' ( (lv_mainStatement_3_0= ruleStatementList ) ) (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )* (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )? otherlv_10= 'END_IF'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIFKeyword_0());
            		
            // InternalPoST.g:3083:3: ( (lv_mainCond_1_0= ruleExpression ) )
            // InternalPoST.g:3084:4: (lv_mainCond_1_0= ruleExpression )
            {
            // InternalPoST.g:3084:4: (lv_mainCond_1_0= ruleExpression )
            // InternalPoST.g:3085:5: lv_mainCond_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getMainCondExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_45);
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

            otherlv_2=(Token)match(input,70,FOLLOW_60); 

            			newLeafNode(otherlv_2, grammarAccess.getIfStatementAccess().getTHENKeyword_2());
            		
            // InternalPoST.g:3106:3: ( (lv_mainStatement_3_0= ruleStatementList ) )
            // InternalPoST.g:3107:4: (lv_mainStatement_3_0= ruleStatementList )
            {
            // InternalPoST.g:3107:4: (lv_mainStatement_3_0= ruleStatementList )
            // InternalPoST.g:3108:5: lv_mainStatement_3_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getMainStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_61);
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

            // InternalPoST.g:3125:3: (otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==75) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalPoST.g:3126:4: otherlv_4= 'ELSIF' ( (lv_elseIfCond_5_0= ruleExpression ) ) otherlv_6= 'THEN' ( (lv_elseIfStatements_7_0= ruleStatementList ) )
            	    {
            	    otherlv_4=(Token)match(input,75,FOLLOW_50); 

            	    				newLeafNode(otherlv_4, grammarAccess.getIfStatementAccess().getELSIFKeyword_4_0());
            	    			
            	    // InternalPoST.g:3130:4: ( (lv_elseIfCond_5_0= ruleExpression ) )
            	    // InternalPoST.g:3131:5: (lv_elseIfCond_5_0= ruleExpression )
            	    {
            	    // InternalPoST.g:3131:5: (lv_elseIfCond_5_0= ruleExpression )
            	    // InternalPoST.g:3132:6: lv_elseIfCond_5_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfCondExpressionParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_45);
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

            	    otherlv_6=(Token)match(input,70,FOLLOW_60); 

            	    				newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getTHENKeyword_4_2());
            	    			
            	    // InternalPoST.g:3153:4: ( (lv_elseIfStatements_7_0= ruleStatementList ) )
            	    // InternalPoST.g:3154:5: (lv_elseIfStatements_7_0= ruleStatementList )
            	    {
            	    // InternalPoST.g:3154:5: (lv_elseIfStatements_7_0= ruleStatementList )
            	    // InternalPoST.g:3155:6: lv_elseIfStatements_7_0= ruleStatementList
            	    {

            	    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfStatementsStatementListParserRuleCall_4_3_0());
            	    					
            	    pushFollow(FOLLOW_61);
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
            	    break loop42;
                }
            } while (true);

            // InternalPoST.g:3173:3: (otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==76) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalPoST.g:3174:4: otherlv_8= 'ELSE' ( (lv_elseStatement_9_0= ruleStatementList ) )
                    {
                    otherlv_8=(Token)match(input,76,FOLLOW_62); 

                    				newLeafNode(otherlv_8, grammarAccess.getIfStatementAccess().getELSEKeyword_5_0());
                    			
                    // InternalPoST.g:3178:4: ( (lv_elseStatement_9_0= ruleStatementList ) )
                    // InternalPoST.g:3179:5: (lv_elseStatement_9_0= ruleStatementList )
                    {
                    // InternalPoST.g:3179:5: (lv_elseStatement_9_0= ruleStatementList )
                    // InternalPoST.g:3180:6: lv_elseStatement_9_0= ruleStatementList
                    {

                    						newCompositeNode(grammarAccess.getIfStatementAccess().getElseStatementStatementListParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_63);
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
    // InternalPoST.g:3206:1: entryRuleCaseStatement returns [EObject current=null] : iv_ruleCaseStatement= ruleCaseStatement EOF ;
    public final EObject entryRuleCaseStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStatement = null;


        try {
            // InternalPoST.g:3206:54: (iv_ruleCaseStatement= ruleCaseStatement EOF )
            // InternalPoST.g:3207:2: iv_ruleCaseStatement= ruleCaseStatement EOF
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
    // InternalPoST.g:3213:1: ruleCaseStatement returns [EObject current=null] : (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' ) ;
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
            // InternalPoST.g:3219:2: ( (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' ) )
            // InternalPoST.g:3220:2: (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' )
            {
            // InternalPoST.g:3220:2: (otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE' )
            // InternalPoST.g:3221:3: otherlv_0= 'CASE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'OF' ( (lv_caseElements_3_0= ruleCaseElement ) )+ (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )? otherlv_6= 'END_CASE'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getCaseStatementAccess().getCASEKeyword_0());
            		
            // InternalPoST.g:3225:3: ( (lv_cond_1_0= ruleExpression ) )
            // InternalPoST.g:3226:4: (lv_cond_1_0= ruleExpression )
            {
            // InternalPoST.g:3226:4: (lv_cond_1_0= ruleExpression )
            // InternalPoST.g:3227:5: lv_cond_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getCaseStatementAccess().getCondExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_64);
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

            otherlv_2=(Token)match(input,79,FOLLOW_65); 

            			newLeafNode(otherlv_2, grammarAccess.getCaseStatementAccess().getOFKeyword_2());
            		
            // InternalPoST.g:3248:3: ( (lv_caseElements_3_0= ruleCaseElement ) )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_INTEGER||LA44_0==108) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalPoST.g:3249:4: (lv_caseElements_3_0= ruleCaseElement )
            	    {
            	    // InternalPoST.g:3249:4: (lv_caseElements_3_0= ruleCaseElement )
            	    // InternalPoST.g:3250:5: lv_caseElements_3_0= ruleCaseElement
            	    {

            	    					newCompositeNode(grammarAccess.getCaseStatementAccess().getCaseElementsCaseElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_66);
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
            	    if ( cnt44 >= 1 ) break loop44;
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);

            // InternalPoST.g:3267:3: (otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==76) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalPoST.g:3268:4: otherlv_4= 'ELSE' ( (lv_elseStatement_5_0= ruleStatementList ) )
                    {
                    otherlv_4=(Token)match(input,76,FOLLOW_67); 

                    				newLeafNode(otherlv_4, grammarAccess.getCaseStatementAccess().getELSEKeyword_4_0());
                    			
                    // InternalPoST.g:3272:4: ( (lv_elseStatement_5_0= ruleStatementList ) )
                    // InternalPoST.g:3273:5: (lv_elseStatement_5_0= ruleStatementList )
                    {
                    // InternalPoST.g:3273:5: (lv_elseStatement_5_0= ruleStatementList )
                    // InternalPoST.g:3274:6: lv_elseStatement_5_0= ruleStatementList
                    {

                    						newCompositeNode(grammarAccess.getCaseStatementAccess().getElseStatementStatementListParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_68);
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
    // InternalPoST.g:3300:1: entryRuleCaseElement returns [EObject current=null] : iv_ruleCaseElement= ruleCaseElement EOF ;
    public final EObject entryRuleCaseElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseElement = null;


        try {
            // InternalPoST.g:3300:52: (iv_ruleCaseElement= ruleCaseElement EOF )
            // InternalPoST.g:3301:2: iv_ruleCaseElement= ruleCaseElement EOF
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
    // InternalPoST.g:3307:1: ruleCaseElement returns [EObject current=null] : ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) ) ;
    public final EObject ruleCaseElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_caseList_0_0 = null;

        EObject lv_statement_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3313:2: ( ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) ) )
            // InternalPoST.g:3314:2: ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) )
            {
            // InternalPoST.g:3314:2: ( ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) ) )
            // InternalPoST.g:3315:3: ( (lv_caseList_0_0= ruleCaseList ) ) otherlv_1= ':' ( (lv_statement_2_0= ruleStatementList ) )
            {
            // InternalPoST.g:3315:3: ( (lv_caseList_0_0= ruleCaseList ) )
            // InternalPoST.g:3316:4: (lv_caseList_0_0= ruleCaseList )
            {
            // InternalPoST.g:3316:4: (lv_caseList_0_0= ruleCaseList )
            // InternalPoST.g:3317:5: lv_caseList_0_0= ruleCaseList
            {

            					newCompositeNode(grammarAccess.getCaseElementAccess().getCaseListCaseListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_22);
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

            otherlv_1=(Token)match(input,51,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getCaseElementAccess().getColonKeyword_1());
            		
            // InternalPoST.g:3338:3: ( (lv_statement_2_0= ruleStatementList ) )
            // InternalPoST.g:3339:4: (lv_statement_2_0= ruleStatementList )
            {
            // InternalPoST.g:3339:4: (lv_statement_2_0= ruleStatementList )
            // InternalPoST.g:3340:5: lv_statement_2_0= ruleStatementList
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
    // InternalPoST.g:3361:1: entryRuleCaseList returns [EObject current=null] : iv_ruleCaseList= ruleCaseList EOF ;
    public final EObject entryRuleCaseList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseList = null;


        try {
            // InternalPoST.g:3361:49: (iv_ruleCaseList= ruleCaseList EOF )
            // InternalPoST.g:3362:2: iv_ruleCaseList= ruleCaseList EOF
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
    // InternalPoST.g:3368:1: ruleCaseList returns [EObject current=null] : ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* ) ;
    public final EObject ruleCaseList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_caseListElement_0_0 = null;

        EObject lv_caseListElement_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3374:2: ( ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* ) )
            // InternalPoST.g:3375:2: ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* )
            {
            // InternalPoST.g:3375:2: ( ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )* )
            // InternalPoST.g:3376:3: ( (lv_caseListElement_0_0= ruleSignedInteger ) ) (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )*
            {
            // InternalPoST.g:3376:3: ( (lv_caseListElement_0_0= ruleSignedInteger ) )
            // InternalPoST.g:3377:4: (lv_caseListElement_0_0= ruleSignedInteger )
            {
            // InternalPoST.g:3377:4: (lv_caseListElement_0_0= ruleSignedInteger )
            // InternalPoST.g:3378:5: lv_caseListElement_0_0= ruleSignedInteger
            {

            					newCompositeNode(grammarAccess.getCaseListAccess().getCaseListElementSignedIntegerParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_25);
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

            // InternalPoST.g:3395:3: (otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==48) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalPoST.g:3396:4: otherlv_1= ',' ( (lv_caseListElement_2_0= ruleSignedInteger ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_65); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCaseListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:3400:4: ( (lv_caseListElement_2_0= ruleSignedInteger ) )
            	    // InternalPoST.g:3401:5: (lv_caseListElement_2_0= ruleSignedInteger )
            	    {
            	    // InternalPoST.g:3401:5: (lv_caseListElement_2_0= ruleSignedInteger )
            	    // InternalPoST.g:3402:6: lv_caseListElement_2_0= ruleSignedInteger
            	    {

            	    						newCompositeNode(grammarAccess.getCaseListAccess().getCaseListElementSignedIntegerParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
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
    // $ANTLR end "ruleCaseList"


    // $ANTLR start "entryRuleIterationStatement"
    // InternalPoST.g:3424:1: entryRuleIterationStatement returns [EObject current=null] : iv_ruleIterationStatement= ruleIterationStatement EOF ;
    public final EObject entryRuleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationStatement = null;


        try {
            // InternalPoST.g:3424:59: (iv_ruleIterationStatement= ruleIterationStatement EOF )
            // InternalPoST.g:3425:2: iv_ruleIterationStatement= ruleIterationStatement EOF
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
    // InternalPoST.g:3431:1: ruleIterationStatement returns [EObject current=null] : (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement ) ;
    public final EObject ruleIterationStatement() throws RecognitionException {
        EObject current = null;

        EObject this_ForStatement_0 = null;

        EObject this_WhileStatement_1 = null;

        EObject this_RepeatStatement_2 = null;



        	enterRule();

        try {
            // InternalPoST.g:3437:2: ( (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement ) )
            // InternalPoST.g:3438:2: (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement )
            {
            // InternalPoST.g:3438:2: (this_ForStatement_0= ruleForStatement | this_WhileStatement_1= ruleWhileStatement | this_RepeatStatement_2= ruleRepeatStatement )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt47=1;
                }
                break;
            case 86:
                {
                alt47=2;
                }
                break;
            case 88:
                {
                alt47=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalPoST.g:3439:3: this_ForStatement_0= ruleForStatement
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
                    // InternalPoST.g:3448:3: this_WhileStatement_1= ruleWhileStatement
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
                    // InternalPoST.g:3457:3: this_RepeatStatement_2= ruleRepeatStatement
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
    // InternalPoST.g:3469:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalPoST.g:3469:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalPoST.g:3470:2: iv_ruleForStatement= ruleForStatement EOF
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
    // InternalPoST.g:3476:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' ) ;
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
            // InternalPoST.g:3482:2: ( (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' ) )
            // InternalPoST.g:3483:2: (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' )
            {
            // InternalPoST.g:3483:2: (otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR' )
            // InternalPoST.g:3484:3: otherlv_0= 'FOR' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_forList_3_0= ruleForList ) ) otherlv_4= 'DO' ( (lv_statement_5_0= ruleStatementList ) ) otherlv_6= 'END_FOR'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getFORKeyword_0());
            		
            // InternalPoST.g:3488:3: ( (otherlv_1= RULE_ID ) )
            // InternalPoST.g:3489:4: (otherlv_1= RULE_ID )
            {
            // InternalPoST.g:3489:4: (otherlv_1= RULE_ID )
            // InternalPoST.g:3490:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getForStatementRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getVariableSymbolicVariableCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,47,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getForStatementAccess().getColonEqualsSignKeyword_2());
            		
            // InternalPoST.g:3505:3: ( (lv_forList_3_0= ruleForList ) )
            // InternalPoST.g:3506:4: (lv_forList_3_0= ruleForList )
            {
            // InternalPoST.g:3506:4: (lv_forList_3_0= ruleForList )
            // InternalPoST.g:3507:5: lv_forList_3_0= ruleForList
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getForListForListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_70);
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

            otherlv_4=(Token)match(input,82,FOLLOW_71); 

            			newLeafNode(otherlv_4, grammarAccess.getForStatementAccess().getDOKeyword_4());
            		
            // InternalPoST.g:3528:3: ( (lv_statement_5_0= ruleStatementList ) )
            // InternalPoST.g:3529:4: (lv_statement_5_0= ruleStatementList )
            {
            // InternalPoST.g:3529:4: (lv_statement_5_0= ruleStatementList )
            // InternalPoST.g:3530:5: lv_statement_5_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getForStatementAccess().getStatementStatementListParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_72);
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
    // InternalPoST.g:3555:1: entryRuleForList returns [EObject current=null] : iv_ruleForList= ruleForList EOF ;
    public final EObject entryRuleForList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForList = null;


        try {
            // InternalPoST.g:3555:48: (iv_ruleForList= ruleForList EOF )
            // InternalPoST.g:3556:2: iv_ruleForList= ruleForList EOF
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
    // InternalPoST.g:3562:1: ruleForList returns [EObject current=null] : ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleForList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_start_0_0 = null;

        EObject lv_end_2_0 = null;

        EObject lv_step_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3568:2: ( ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? ) )
            // InternalPoST.g:3569:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? )
            {
            // InternalPoST.g:3569:2: ( ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )? )
            // InternalPoST.g:3570:3: ( (lv_start_0_0= ruleExpression ) ) otherlv_1= 'TO' ( (lv_end_2_0= ruleExpression ) ) (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )?
            {
            // InternalPoST.g:3570:3: ( (lv_start_0_0= ruleExpression ) )
            // InternalPoST.g:3571:4: (lv_start_0_0= ruleExpression )
            {
            // InternalPoST.g:3571:4: (lv_start_0_0= ruleExpression )
            // InternalPoST.g:3572:5: lv_start_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getForListAccess().getStartExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_73);
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

            otherlv_1=(Token)match(input,84,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getForListAccess().getTOKeyword_1());
            		
            // InternalPoST.g:3593:3: ( (lv_end_2_0= ruleExpression ) )
            // InternalPoST.g:3594:4: (lv_end_2_0= ruleExpression )
            {
            // InternalPoST.g:3594:4: (lv_end_2_0= ruleExpression )
            // InternalPoST.g:3595:5: lv_end_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getForListAccess().getEndExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_74);
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

            // InternalPoST.g:3612:3: (otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==85) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalPoST.g:3613:4: otherlv_3= 'BY' ( (lv_step_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,85,FOLLOW_50); 

                    				newLeafNode(otherlv_3, grammarAccess.getForListAccess().getBYKeyword_3_0());
                    			
                    // InternalPoST.g:3617:4: ( (lv_step_4_0= ruleExpression ) )
                    // InternalPoST.g:3618:5: (lv_step_4_0= ruleExpression )
                    {
                    // InternalPoST.g:3618:5: (lv_step_4_0= ruleExpression )
                    // InternalPoST.g:3619:6: lv_step_4_0= ruleExpression
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
    // InternalPoST.g:3641:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalPoST.g:3641:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalPoST.g:3642:2: iv_ruleWhileStatement= ruleWhileStatement EOF
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
    // InternalPoST.g:3648:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_cond_1_0 = null;

        EObject lv_statement_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3654:2: ( (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' ) )
            // InternalPoST.g:3655:2: (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' )
            {
            // InternalPoST.g:3655:2: (otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE' )
            // InternalPoST.g:3656:3: otherlv_0= 'WHILE' ( (lv_cond_1_0= ruleExpression ) ) otherlv_2= 'DO' ( (lv_statement_3_0= ruleStatementList ) ) otherlv_4= 'END_WHILE'
            {
            otherlv_0=(Token)match(input,86,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWHILEKeyword_0());
            		
            // InternalPoST.g:3660:3: ( (lv_cond_1_0= ruleExpression ) )
            // InternalPoST.g:3661:4: (lv_cond_1_0= ruleExpression )
            {
            // InternalPoST.g:3661:4: (lv_cond_1_0= ruleExpression )
            // InternalPoST.g:3662:5: lv_cond_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getCondExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_70);
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

            otherlv_2=(Token)match(input,82,FOLLOW_75); 

            			newLeafNode(otherlv_2, grammarAccess.getWhileStatementAccess().getDOKeyword_2());
            		
            // InternalPoST.g:3683:3: ( (lv_statement_3_0= ruleStatementList ) )
            // InternalPoST.g:3684:4: (lv_statement_3_0= ruleStatementList )
            {
            // InternalPoST.g:3684:4: (lv_statement_3_0= ruleStatementList )
            // InternalPoST.g:3685:5: lv_statement_3_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getWhileStatementAccess().getStatementStatementListParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_76);
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
    // InternalPoST.g:3710:1: entryRuleRepeatStatement returns [EObject current=null] : iv_ruleRepeatStatement= ruleRepeatStatement EOF ;
    public final EObject entryRuleRepeatStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeatStatement = null;


        try {
            // InternalPoST.g:3710:56: (iv_ruleRepeatStatement= ruleRepeatStatement EOF )
            // InternalPoST.g:3711:2: iv_ruleRepeatStatement= ruleRepeatStatement EOF
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
    // InternalPoST.g:3717:1: ruleRepeatStatement returns [EObject current=null] : (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' ) ;
    public final EObject ruleRepeatStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_statement_1_0 = null;

        EObject lv_cond_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3723:2: ( (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' ) )
            // InternalPoST.g:3724:2: (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' )
            {
            // InternalPoST.g:3724:2: (otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT' )
            // InternalPoST.g:3725:3: otherlv_0= 'REPEAT' ( (lv_statement_1_0= ruleStatementList ) ) otherlv_2= 'UNTIL' ( (lv_cond_3_0= ruleExpression ) ) otherlv_4= 'END_REPEAT'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_77); 

            			newLeafNode(otherlv_0, grammarAccess.getRepeatStatementAccess().getREPEATKeyword_0());
            		
            // InternalPoST.g:3729:3: ( (lv_statement_1_0= ruleStatementList ) )
            // InternalPoST.g:3730:4: (lv_statement_1_0= ruleStatementList )
            {
            // InternalPoST.g:3730:4: (lv_statement_1_0= ruleStatementList )
            // InternalPoST.g:3731:5: lv_statement_1_0= ruleStatementList
            {

            					newCompositeNode(grammarAccess.getRepeatStatementAccess().getStatementStatementListParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_78);
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

            otherlv_2=(Token)match(input,89,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getRepeatStatementAccess().getUNTILKeyword_2());
            		
            // InternalPoST.g:3752:3: ( (lv_cond_3_0= ruleExpression ) )
            // InternalPoST.g:3753:4: (lv_cond_3_0= ruleExpression )
            {
            // InternalPoST.g:3753:4: (lv_cond_3_0= ruleExpression )
            // InternalPoST.g:3754:5: lv_cond_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getRepeatStatementAccess().getCondExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_79);
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
    // InternalPoST.g:3779:1: entryRuleSubprogramControlStatement returns [EObject current=null] : iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF ;
    public final EObject entryRuleSubprogramControlStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubprogramControlStatement = null;


        try {
            // InternalPoST.g:3779:67: (iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF )
            // InternalPoST.g:3780:2: iv_ruleSubprogramControlStatement= ruleSubprogramControlStatement EOF
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
    // InternalPoST.g:3786:1: ruleSubprogramControlStatement returns [EObject current=null] : ( () otherlv_1= 'RETURN' ) ;
    public final EObject ruleSubprogramControlStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPoST.g:3792:2: ( ( () otherlv_1= 'RETURN' ) )
            // InternalPoST.g:3793:2: ( () otherlv_1= 'RETURN' )
            {
            // InternalPoST.g:3793:2: ( () otherlv_1= 'RETURN' )
            // InternalPoST.g:3794:3: () otherlv_1= 'RETURN'
            {
            // InternalPoST.g:3794:3: ()
            // InternalPoST.g:3795:4: 
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
    // InternalPoST.g:3809:1: entryRuleExitStatement returns [EObject current=null] : iv_ruleExitStatement= ruleExitStatement EOF ;
    public final EObject entryRuleExitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitStatement = null;


        try {
            // InternalPoST.g:3809:54: (iv_ruleExitStatement= ruleExitStatement EOF )
            // InternalPoST.g:3810:2: iv_ruleExitStatement= ruleExitStatement EOF
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
    // InternalPoST.g:3816:1: ruleExitStatement returns [EObject current=null] : ( () otherlv_1= 'EXIT' ) ;
    public final EObject ruleExitStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalPoST.g:3822:2: ( ( () otherlv_1= 'EXIT' ) )
            // InternalPoST.g:3823:2: ( () otherlv_1= 'EXIT' )
            {
            // InternalPoST.g:3823:2: ( () otherlv_1= 'EXIT' )
            // InternalPoST.g:3824:3: () otherlv_1= 'EXIT'
            {
            // InternalPoST.g:3824:3: ()
            // InternalPoST.g:3825:4: 
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
    // InternalPoST.g:3839:1: entryRuleArrayVariable returns [EObject current=null] : iv_ruleArrayVariable= ruleArrayVariable EOF ;
    public final EObject entryRuleArrayVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayVariable = null;


        try {
            // InternalPoST.g:3839:54: (iv_ruleArrayVariable= ruleArrayVariable EOF )
            // InternalPoST.g:3840:2: iv_ruleArrayVariable= ruleArrayVariable EOF
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
    // InternalPoST.g:3846:1: ruleArrayVariable returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) ;
    public final EObject ruleArrayVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_index_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3852:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' ) )
            // InternalPoST.g:3853:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
            {
            // InternalPoST.g:3853:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )
            // InternalPoST.g:3854:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']'
            {
            // InternalPoST.g:3854:3: ( (otherlv_0= RULE_ID ) )
            // InternalPoST.g:3855:4: (otherlv_0= RULE_ID )
            {
            // InternalPoST.g:3855:4: (otherlv_0= RULE_ID )
            // InternalPoST.g:3856:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArrayVariableRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_80); 

            					newLeafNode(otherlv_0, grammarAccess.getArrayVariableAccess().getVarNameSymbolicVariableCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,93,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getArrayVariableAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalPoST.g:3871:3: ( (lv_index_2_0= ruleExpression ) )
            // InternalPoST.g:3872:4: (lv_index_2_0= ruleExpression )
            {
            // InternalPoST.g:3872:4: (lv_index_2_0= ruleExpression )
            // InternalPoST.g:3873:5: lv_index_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getArrayVariableAccess().getIndexExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_81);
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
    // InternalPoST.g:3898:1: entryRuleSymbolicVariable returns [EObject current=null] : iv_ruleSymbolicVariable= ruleSymbolicVariable EOF ;
    public final EObject entryRuleSymbolicVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolicVariable = null;


        try {
            // InternalPoST.g:3898:57: (iv_ruleSymbolicVariable= ruleSymbolicVariable EOF )
            // InternalPoST.g:3899:2: iv_ruleSymbolicVariable= ruleSymbolicVariable EOF
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
    // InternalPoST.g:3905:1: ruleSymbolicVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleSymbolicVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalPoST.g:3911:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalPoST.g:3912:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalPoST.g:3912:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalPoST.g:3913:3: (lv_name_0_0= RULE_ID )
            {
            // InternalPoST.g:3913:3: (lv_name_0_0= RULE_ID )
            // InternalPoST.g:3914:4: lv_name_0_0= RULE_ID
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
    // InternalPoST.g:3933:1: entryRuleVarInitDeclaration returns [EObject current=null] : iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF ;
    public final EObject entryRuleVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarInitDeclaration = null;


        try {
            // InternalPoST.g:3933:59: (iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF )
            // InternalPoST.g:3934:2: iv_ruleVarInitDeclaration= ruleVarInitDeclaration EOF
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
    // InternalPoST.g:3940:1: ruleVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) ) ) ;
    public final EObject ruleVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_varList_0_0 = null;

        EObject lv_spec_2_0 = null;

        EObject lv_arrSpec_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:3946:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) ) ) )
            // InternalPoST.g:3947:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) ) )
            {
            // InternalPoST.g:3947:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) ) )
            // InternalPoST.g:3948:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) )
            {
            // InternalPoST.g:3948:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:3949:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:3949:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:3950:5: lv_varList_0_0= ruleVarList
            {

            					newCompositeNode(grammarAccess.getVarInitDeclarationAccess().getVarListVarListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_22);
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
            		
            // InternalPoST.g:3971:3: ( ( (lv_spec_2_0= ruleSimpleSpecificationInit ) ) | ( (lv_arrSpec_3_0= ruleArraySpecInit ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_BIT_STRING_TYPE_NAME && LA49_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt49=1;
            }
            else if ( (LA49_0==105) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalPoST.g:3972:4: ( (lv_spec_2_0= ruleSimpleSpecificationInit ) )
                    {
                    // InternalPoST.g:3972:4: ( (lv_spec_2_0= ruleSimpleSpecificationInit ) )
                    // InternalPoST.g:3973:5: (lv_spec_2_0= ruleSimpleSpecificationInit )
                    {
                    // InternalPoST.g:3973:5: (lv_spec_2_0= ruleSimpleSpecificationInit )
                    // InternalPoST.g:3974:6: lv_spec_2_0= ruleSimpleSpecificationInit
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
                    // InternalPoST.g:3992:4: ( (lv_arrSpec_3_0= ruleArraySpecInit ) )
                    {
                    // InternalPoST.g:3992:4: ( (lv_arrSpec_3_0= ruleArraySpecInit ) )
                    // InternalPoST.g:3993:5: (lv_arrSpec_3_0= ruleArraySpecInit )
                    {
                    // InternalPoST.g:3993:5: (lv_arrSpec_3_0= ruleArraySpecInit )
                    // InternalPoST.g:3994:6: lv_arrSpec_3_0= ruleArraySpecInit
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
    // InternalPoST.g:4016:1: entryRuleVarList returns [EObject current=null] : iv_ruleVarList= ruleVarList EOF ;
    public final EObject entryRuleVarList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarList = null;


        try {
            // InternalPoST.g:4016:48: (iv_ruleVarList= ruleVarList EOF )
            // InternalPoST.g:4017:2: iv_ruleVarList= ruleVarList EOF
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
    // InternalPoST.g:4023:1: ruleVarList returns [EObject current=null] : ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* ) ;
    public final EObject ruleVarList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_vars_0_0 = null;

        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4029:2: ( ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* ) )
            // InternalPoST.g:4030:2: ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* )
            {
            // InternalPoST.g:4030:2: ( ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )* )
            // InternalPoST.g:4031:3: ( (lv_vars_0_0= ruleSymbolicVariable ) ) (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )*
            {
            // InternalPoST.g:4031:3: ( (lv_vars_0_0= ruleSymbolicVariable ) )
            // InternalPoST.g:4032:4: (lv_vars_0_0= ruleSymbolicVariable )
            {
            // InternalPoST.g:4032:4: (lv_vars_0_0= ruleSymbolicVariable )
            // InternalPoST.g:4033:5: lv_vars_0_0= ruleSymbolicVariable
            {

            					newCompositeNode(grammarAccess.getVarListAccess().getVarsSymbolicVariableParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_25);
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

            // InternalPoST.g:4050:3: (otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==48) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalPoST.g:4051:4: otherlv_1= ',' ( (lv_vars_2_0= ruleSymbolicVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,48,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getVarListAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalPoST.g:4055:4: ( (lv_vars_2_0= ruleSymbolicVariable ) )
            	    // InternalPoST.g:4056:5: (lv_vars_2_0= ruleSymbolicVariable )
            	    {
            	    // InternalPoST.g:4056:5: (lv_vars_2_0= ruleSymbolicVariable )
            	    // InternalPoST.g:4057:6: lv_vars_2_0= ruleSymbolicVariable
            	    {

            	    						newCompositeNode(grammarAccess.getVarListAccess().getVarsSymbolicVariableParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
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
    // $ANTLR end "ruleVarList"


    // $ANTLR start "entryRuleInputVarDeclaration"
    // InternalPoST.g:4079:1: entryRuleInputVarDeclaration returns [EObject current=null] : iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF ;
    public final EObject entryRuleInputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputVarDeclaration = null;


        try {
            // InternalPoST.g:4079:60: (iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF )
            // InternalPoST.g:4080:2: iv_ruleInputVarDeclaration= ruleInputVarDeclaration EOF
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
    // InternalPoST.g:4086:1: ruleInputVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) ;
    public final EObject ruleInputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_vars_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4092:2: ( (otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) )
            // InternalPoST.g:4093:2: (otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            {
            // InternalPoST.g:4093:2: (otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            // InternalPoST.g:4094:3: otherlv_0= 'VAR_INPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInputVarDeclarationAccess().getVAR_INPUTKeyword_0());
            		
            // InternalPoST.g:4098:3: ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalPoST.g:4099:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:4099:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4100:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4100:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4101:6: lv_vars_1_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getInputVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_2=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_2, grammarAccess.getInputVarDeclarationAccess().getSemicolonKeyword_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
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
    // InternalPoST.g:4131:1: entryRuleOutputVarDeclaration returns [EObject current=null] : iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF ;
    public final EObject entryRuleOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputVarDeclaration = null;


        try {
            // InternalPoST.g:4131:61: (iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF )
            // InternalPoST.g:4132:2: iv_ruleOutputVarDeclaration= ruleOutputVarDeclaration EOF
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
    // InternalPoST.g:4138:1: ruleOutputVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) ;
    public final EObject ruleOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_vars_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4144:2: ( (otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) )
            // InternalPoST.g:4145:2: (otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            {
            // InternalPoST.g:4145:2: (otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            // InternalPoST.g:4146:3: otherlv_0= 'VAR_OUTPUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR'
            {
            otherlv_0=(Token)match(input,97,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getOutputVarDeclarationAccess().getVAR_OUTPUTKeyword_0());
            		
            // InternalPoST.g:4150:3: ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalPoST.g:4151:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:4151:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4152:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4152:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4153:6: lv_vars_1_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getOutputVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_2=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOutputVarDeclarationAccess().getSemicolonKeyword_1_1());
            	    			

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
    // InternalPoST.g:4183:1: entryRuleInputOutputVarDeclaration returns [EObject current=null] : iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF ;
    public final EObject entryRuleInputOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputOutputVarDeclaration = null;


        try {
            // InternalPoST.g:4183:66: (iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF )
            // InternalPoST.g:4184:2: iv_ruleInputOutputVarDeclaration= ruleInputOutputVarDeclaration EOF
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
    // InternalPoST.g:4190:1: ruleInputOutputVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) ;
    public final EObject ruleInputOutputVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_vars_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4196:2: ( (otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) )
            // InternalPoST.g:4197:2: (otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            {
            // InternalPoST.g:4197:2: (otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            // InternalPoST.g:4198:3: otherlv_0= 'VAR_IN_OUT' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInputOutputVarDeclarationAccess().getVAR_IN_OUTKeyword_0());
            		
            // InternalPoST.g:4202:3: ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalPoST.g:4203:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:4203:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4204:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4204:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4205:6: lv_vars_1_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getInputOutputVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_2=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_2, grammarAccess.getInputOutputVarDeclarationAccess().getSemicolonKeyword_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
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
    // InternalPoST.g:4235:1: entryRuleVarDeclaration returns [EObject current=null] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final EObject entryRuleVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDeclaration = null;


        try {
            // InternalPoST.g:4235:55: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // InternalPoST.g:4236:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
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
    // InternalPoST.g:4242:1: ruleVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' ) ;
    public final EObject ruleVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_const_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4248:2: ( (otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4249:2: (otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4249:2: (otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' )
            // InternalPoST.g:4250:3: otherlv_0= 'VAR' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR'
            {
            otherlv_0=(Token)match(input,99,FOLLOW_84); 

            			newLeafNode(otherlv_0, grammarAccess.getVarDeclarationAccess().getVARKeyword_0());
            		
            // InternalPoST.g:4254:3: ( (lv_const_1_0= 'CONSTANT' ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==100) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalPoST.g:4255:4: (lv_const_1_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4255:4: (lv_const_1_0= 'CONSTANT' )
                    // InternalPoST.g:4256:5: lv_const_1_0= 'CONSTANT'
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

            // InternalPoST.g:4268:3: ( ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )+
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
            	    // InternalPoST.g:4269:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4269:4: ( (lv_vars_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4270:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4270:5: (lv_vars_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4271:6: lv_vars_2_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_3=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_3, grammarAccess.getVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

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
    // InternalPoST.g:4301:1: entryRuleTempVarDeclaration returns [EObject current=null] : iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF ;
    public final EObject entryRuleTempVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTempVarDeclaration = null;


        try {
            // InternalPoST.g:4301:59: (iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF )
            // InternalPoST.g:4302:2: iv_ruleTempVarDeclaration= ruleTempVarDeclaration EOF
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
    // InternalPoST.g:4308:1: ruleTempVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) ;
    public final EObject ruleTempVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_vars_1_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4314:2: ( (otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' ) )
            // InternalPoST.g:4315:2: (otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            {
            // InternalPoST.g:4315:2: (otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR' )
            // InternalPoST.g:4316:3: otherlv_0= 'VAR_TEMP' ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+ otherlv_3= 'END_VAR'
            {
            otherlv_0=(Token)match(input,101,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTempVarDeclarationAccess().getVAR_TEMPKeyword_0());
            		
            // InternalPoST.g:4320:3: ( ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';' )+
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
            	    // InternalPoST.g:4321:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) ) otherlv_2= ';'
            	    {
            	    // InternalPoST.g:4321:4: ( (lv_vars_1_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4322:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4322:5: (lv_vars_1_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4323:6: lv_vars_1_0= ruleVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getTempVarDeclarationAccess().getVarsVarInitDeclarationParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_2=(Token)match(input,43,FOLLOW_83); 

            	    				newLeafNode(otherlv_2, grammarAccess.getTempVarDeclarationAccess().getSemicolonKeyword_1_1());
            	    			

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
    // InternalPoST.g:4353:1: entryRuleExternalVarDeclaration returns [EObject current=null] : iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF ;
    public final EObject entryRuleExternalVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalVarDeclaration = null;


        try {
            // InternalPoST.g:4353:63: (iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF )
            // InternalPoST.g:4354:2: iv_ruleExternalVarDeclaration= ruleExternalVarDeclaration EOF
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
    // InternalPoST.g:4360:1: ruleExternalVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' ) ;
    public final EObject ruleExternalVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_const_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_vars_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4366:2: ( (otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' ) )
            // InternalPoST.g:4367:2: (otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' )
            {
            // InternalPoST.g:4367:2: (otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR' )
            // InternalPoST.g:4368:3: otherlv_0= 'VAR_EXTERNAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+ otherlv_4= 'END_VAR'
            {
            otherlv_0=(Token)match(input,102,FOLLOW_84); 

            			newLeafNode(otherlv_0, grammarAccess.getExternalVarDeclarationAccess().getVAR_EXTERNALKeyword_0());
            		
            // InternalPoST.g:4372:3: ( (lv_const_1_0= 'CONSTANT' ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==100) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalPoST.g:4373:4: (lv_const_1_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4373:4: (lv_const_1_0= 'CONSTANT' )
                    // InternalPoST.g:4374:5: lv_const_1_0= 'CONSTANT'
                    {
                    lv_const_1_0=(Token)match(input,100,FOLLOW_84); 

                    					newLeafNode(lv_const_1_0, grammarAccess.getExternalVarDeclarationAccess().getConstCONSTANTKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getExternalVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_1_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:4386:3: ( ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';' )+
            int cnt58=0;
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalPoST.g:4387:4: ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4387:4: ( (lv_vars_2_0= ruleExternalVarInitDeclaration ) )
            	    // InternalPoST.g:4388:5: (lv_vars_2_0= ruleExternalVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4388:5: (lv_vars_2_0= ruleExternalVarInitDeclaration )
            	    // InternalPoST.g:4389:6: lv_vars_2_0= ruleExternalVarInitDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getExternalVarDeclarationAccess().getVarsExternalVarInitDeclarationParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_3=(Token)match(input,43,FOLLOW_85); 

            	    				newLeafNode(otherlv_3, grammarAccess.getExternalVarDeclarationAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt58 >= 1 ) break loop58;
                        EarlyExitException eee =
                            new EarlyExitException(58, input);
                        throw eee;
                }
                cnt58++;
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
    // InternalPoST.g:4419:1: entryRuleExternalVarInitDeclaration returns [EObject current=null] : iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF ;
    public final EObject entryRuleExternalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalVarInitDeclaration = null;


        try {
            // InternalPoST.g:4419:67: (iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF )
            // InternalPoST.g:4420:2: iv_ruleExternalVarInitDeclaration= ruleExternalVarInitDeclaration EOF
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
    // InternalPoST.g:4426:1: ruleExternalVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleExternalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_varList_0_0 = null;

        AntlrDatatypeRuleToken lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4432:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:4433:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:4433:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) ) )
            // InternalPoST.g:4434:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeName ) )
            {
            // InternalPoST.g:4434:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:4435:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:4435:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:4436:5: lv_varList_0_0= ruleVarList
            {

            					newCompositeNode(grammarAccess.getExternalVarInitDeclarationAccess().getVarListVarListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_22);
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

            otherlv_1=(Token)match(input,51,FOLLOW_86); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalVarInitDeclarationAccess().getColonKeyword_1());
            		
            // InternalPoST.g:4457:3: ( (lv_type_2_0= ruleDataTypeName ) )
            // InternalPoST.g:4458:4: (lv_type_2_0= ruleDataTypeName )
            {
            // InternalPoST.g:4458:4: (lv_type_2_0= ruleDataTypeName )
            // InternalPoST.g:4459:5: lv_type_2_0= ruleDataTypeName
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
    // InternalPoST.g:4480:1: entryRuleGlobalVarDeclaration returns [EObject current=null] : iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF ;
    public final EObject entryRuleGlobalVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVarDeclaration = null;


        try {
            // InternalPoST.g:4480:61: (iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF )
            // InternalPoST.g:4481:2: iv_ruleGlobalVarDeclaration= ruleGlobalVarDeclaration EOF
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
    // InternalPoST.g:4487:1: ruleGlobalVarDeclaration returns [EObject current=null] : (otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR' ) ;
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
            // InternalPoST.g:4493:2: ( (otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR' ) )
            // InternalPoST.g:4494:2: (otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR' )
            {
            // InternalPoST.g:4494:2: (otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR' )
            // InternalPoST.g:4495:3: otherlv_0= 'VAR_GLOBAL' ( (lv_const_1_0= 'CONSTANT' ) )? ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+ otherlv_6= 'END_VAR'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_84); 

            			newLeafNode(otherlv_0, grammarAccess.getGlobalVarDeclarationAccess().getVAR_GLOBALKeyword_0());
            		
            // InternalPoST.g:4499:3: ( (lv_const_1_0= 'CONSTANT' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==100) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalPoST.g:4500:4: (lv_const_1_0= 'CONSTANT' )
                    {
                    // InternalPoST.g:4500:4: (lv_const_1_0= 'CONSTANT' )
                    // InternalPoST.g:4501:5: lv_const_1_0= 'CONSTANT'
                    {
                    lv_const_1_0=(Token)match(input,100,FOLLOW_84); 

                    					newLeafNode(lv_const_1_0, grammarAccess.getGlobalVarDeclarationAccess().getConstCONSTANTKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGlobalVarDeclarationRule());
                    					}
                    					setWithLastConsumed(current, "const", lv_const_1_0 != null, "CONSTANT");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:4513:3: ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+
            int cnt60=0;
            loop60:
            do {
                int alt60=3;
                alt60 = dfa60.predict(input);
                switch (alt60) {
            	case 1 :
            	    // InternalPoST.g:4514:4: ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )
            	    {
            	    // InternalPoST.g:4514:4: ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' )
            	    // InternalPoST.g:4515:5: ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';'
            	    {
            	    // InternalPoST.g:4515:5: ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) )
            	    // InternalPoST.g:4516:6: (lv_varsSimple_2_0= ruleVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4516:6: (lv_varsSimple_2_0= ruleVarInitDeclaration )
            	    // InternalPoST.g:4517:7: lv_varsSimple_2_0= ruleVarInitDeclaration
            	    {

            	    							newCompositeNode(grammarAccess.getGlobalVarDeclarationAccess().getVarsSimpleVarInitDeclarationParserRuleCall_2_0_0_0());
            	    						
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_3=(Token)match(input,43,FOLLOW_85); 

            	    					newLeafNode(otherlv_3, grammarAccess.getGlobalVarDeclarationAccess().getSemicolonKeyword_2_0_1());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalPoST.g:4540:4: ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' )
            	    {
            	    // InternalPoST.g:4540:4: ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' )
            	    // InternalPoST.g:4541:5: ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';'
            	    {
            	    // InternalPoST.g:4541:5: ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) )
            	    // InternalPoST.g:4542:6: (lv_varsAs_4_0= ruleGlobalVarInitDeclaration )
            	    {
            	    // InternalPoST.g:4542:6: (lv_varsAs_4_0= ruleGlobalVarInitDeclaration )
            	    // InternalPoST.g:4543:7: lv_varsAs_4_0= ruleGlobalVarInitDeclaration
            	    {

            	    							newCompositeNode(grammarAccess.getGlobalVarDeclarationAccess().getVarsAsGlobalVarInitDeclarationParserRuleCall_2_1_0_0());
            	    						
            	    pushFollow(FOLLOW_10);
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

            	    otherlv_5=(Token)match(input,43,FOLLOW_85); 

            	    					newLeafNode(otherlv_5, grammarAccess.getGlobalVarDeclarationAccess().getSemicolonKeyword_2_1_1());
            	    				

            	    }


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
    // InternalPoST.g:4574:1: entryRuleGlobalVarInitDeclaration returns [EObject current=null] : iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF ;
    public final EObject entryRuleGlobalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVarInitDeclaration = null;


        try {
            // InternalPoST.g:4574:65: (iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF )
            // InternalPoST.g:4575:2: iv_ruleGlobalVarInitDeclaration= ruleGlobalVarInitDeclaration EOF
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
    // InternalPoST.g:4581:1: ruleGlobalVarInitDeclaration returns [EObject current=null] : ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) ) ;
    public final EObject ruleGlobalVarInitDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_location_2_0=null;
        Token otherlv_3=null;
        EObject lv_varList_0_0 = null;

        AntlrDatatypeRuleToken lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4587:2: ( ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:4588:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:4588:2: ( ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) )
            // InternalPoST.g:4589:3: ( (lv_varList_0_0= ruleVarList ) ) otherlv_1= 'AT' ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) )
            {
            // InternalPoST.g:4589:3: ( (lv_varList_0_0= ruleVarList ) )
            // InternalPoST.g:4590:4: (lv_varList_0_0= ruleVarList )
            {
            // InternalPoST.g:4590:4: (lv_varList_0_0= ruleVarList )
            // InternalPoST.g:4591:5: lv_varList_0_0= ruleVarList
            {

            					newCompositeNode(grammarAccess.getGlobalVarInitDeclarationAccess().getVarListVarListParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_87);
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

            otherlv_1=(Token)match(input,104,FOLLOW_88); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalVarInitDeclarationAccess().getATKeyword_1());
            		
            // InternalPoST.g:4612:3: ( (lv_location_2_0= RULE_DIRECT_VARIABLE ) )
            // InternalPoST.g:4613:4: (lv_location_2_0= RULE_DIRECT_VARIABLE )
            {
            // InternalPoST.g:4613:4: (lv_location_2_0= RULE_DIRECT_VARIABLE )
            // InternalPoST.g:4614:5: lv_location_2_0= RULE_DIRECT_VARIABLE
            {
            lv_location_2_0=(Token)match(input,RULE_DIRECT_VARIABLE,FOLLOW_22); 

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

            otherlv_3=(Token)match(input,51,FOLLOW_86); 

            			newLeafNode(otherlv_3, grammarAccess.getGlobalVarInitDeclarationAccess().getColonKeyword_3());
            		
            // InternalPoST.g:4634:3: ( (lv_type_4_0= ruleDataTypeName ) )
            // InternalPoST.g:4635:4: (lv_type_4_0= ruleDataTypeName )
            {
            // InternalPoST.g:4635:4: (lv_type_4_0= ruleDataTypeName )
            // InternalPoST.g:4636:5: lv_type_4_0= ruleDataTypeName
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
    // InternalPoST.g:4657:1: entryRuleArraySpecInit returns [EObject current=null] : iv_ruleArraySpecInit= ruleArraySpecInit EOF ;
    public final EObject entryRuleArraySpecInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecInit = null;


        try {
            // InternalPoST.g:4657:54: (iv_ruleArraySpecInit= ruleArraySpecInit EOF )
            // InternalPoST.g:4658:2: iv_ruleArraySpecInit= ruleArraySpecInit EOF
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
    // InternalPoST.g:4664:1: ruleArraySpecInit returns [EObject current=null] : ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? ) ;
    public final EObject ruleArraySpecInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_init_0_0 = null;

        EObject lv_values_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4670:2: ( ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? ) )
            // InternalPoST.g:4671:2: ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? )
            {
            // InternalPoST.g:4671:2: ( ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )? )
            // InternalPoST.g:4672:3: ( (lv_init_0_0= ruleArraySpecification ) ) (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )?
            {
            // InternalPoST.g:4672:3: ( (lv_init_0_0= ruleArraySpecification ) )
            // InternalPoST.g:4673:4: (lv_init_0_0= ruleArraySpecification )
            {
            // InternalPoST.g:4673:4: (lv_init_0_0= ruleArraySpecification )
            // InternalPoST.g:4674:5: lv_init_0_0= ruleArraySpecification
            {

            					newCompositeNode(grammarAccess.getArraySpecInitAccess().getInitArraySpecificationParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_89);
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

            // InternalPoST.g:4691:3: (otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==47) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalPoST.g:4692:4: otherlv_1= ':=' ( (lv_values_2_0= ruleArrayInitialization ) )
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_80); 

                    				newLeafNode(otherlv_1, grammarAccess.getArraySpecInitAccess().getColonEqualsSignKeyword_1_0());
                    			
                    // InternalPoST.g:4696:4: ( (lv_values_2_0= ruleArrayInitialization ) )
                    // InternalPoST.g:4697:5: (lv_values_2_0= ruleArrayInitialization )
                    {
                    // InternalPoST.g:4697:5: (lv_values_2_0= ruleArrayInitialization )
                    // InternalPoST.g:4698:6: lv_values_2_0= ruleArrayInitialization
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
    // InternalPoST.g:4720:1: entryRuleArraySpecification returns [EObject current=null] : iv_ruleArraySpecification= ruleArraySpecification EOF ;
    public final EObject entryRuleArraySpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecification = null;


        try {
            // InternalPoST.g:4720:59: (iv_ruleArraySpecification= ruleArraySpecification EOF )
            // InternalPoST.g:4721:2: iv_ruleArraySpecification= ruleArraySpecification EOF
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
    // InternalPoST.g:4727:1: ruleArraySpecification returns [EObject current=null] : (otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) ) ) ;
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
            // InternalPoST.g:4733:2: ( (otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) ) ) )
            // InternalPoST.g:4734:2: (otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) ) )
            {
            // InternalPoST.g:4734:2: (otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) ) )
            // InternalPoST.g:4735:3: otherlv_0= 'ARRAY' otherlv_1= '[' ( (lv_start_2_0= ruleSignedInteger ) ) otherlv_3= '..' ( (lv_end_4_0= ruleSignedInteger ) ) otherlv_5= ']' otherlv_6= 'OF' ( (lv_type_7_0= ruleDataTypeName ) )
            {
            otherlv_0=(Token)match(input,105,FOLLOW_80); 

            			newLeafNode(otherlv_0, grammarAccess.getArraySpecificationAccess().getARRAYKeyword_0());
            		
            otherlv_1=(Token)match(input,93,FOLLOW_65); 

            			newLeafNode(otherlv_1, grammarAccess.getArraySpecificationAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalPoST.g:4743:3: ( (lv_start_2_0= ruleSignedInteger ) )
            // InternalPoST.g:4744:4: (lv_start_2_0= ruleSignedInteger )
            {
            // InternalPoST.g:4744:4: (lv_start_2_0= ruleSignedInteger )
            // InternalPoST.g:4745:5: lv_start_2_0= ruleSignedInteger
            {

            					newCompositeNode(grammarAccess.getArraySpecificationAccess().getStartSignedIntegerParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_90);
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

            otherlv_3=(Token)match(input,106,FOLLOW_65); 

            			newLeafNode(otherlv_3, grammarAccess.getArraySpecificationAccess().getFullStopFullStopKeyword_3());
            		
            // InternalPoST.g:4766:3: ( (lv_end_4_0= ruleSignedInteger ) )
            // InternalPoST.g:4767:4: (lv_end_4_0= ruleSignedInteger )
            {
            // InternalPoST.g:4767:4: (lv_end_4_0= ruleSignedInteger )
            // InternalPoST.g:4768:5: lv_end_4_0= ruleSignedInteger
            {

            					newCompositeNode(grammarAccess.getArraySpecificationAccess().getEndSignedIntegerParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_81);
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

            otherlv_5=(Token)match(input,94,FOLLOW_64); 

            			newLeafNode(otherlv_5, grammarAccess.getArraySpecificationAccess().getRightSquareBracketKeyword_5());
            		
            otherlv_6=(Token)match(input,79,FOLLOW_86); 

            			newLeafNode(otherlv_6, grammarAccess.getArraySpecificationAccess().getOFKeyword_6());
            		
            // InternalPoST.g:4793:3: ( (lv_type_7_0= ruleDataTypeName ) )
            // InternalPoST.g:4794:4: (lv_type_7_0= ruleDataTypeName )
            {
            // InternalPoST.g:4794:4: (lv_type_7_0= ruleDataTypeName )
            // InternalPoST.g:4795:5: lv_type_7_0= ruleDataTypeName
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
    // InternalPoST.g:4816:1: entryRuleArrayInitialization returns [EObject current=null] : iv_ruleArrayInitialization= ruleArrayInitialization EOF ;
    public final EObject entryRuleArrayInitialization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayInitialization = null;


        try {
            // InternalPoST.g:4816:60: (iv_ruleArrayInitialization= ruleArrayInitialization EOF )
            // InternalPoST.g:4817:2: iv_ruleArrayInitialization= ruleArrayInitialization EOF
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
    // InternalPoST.g:4823:1: ruleArrayInitialization returns [EObject current=null] : (otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleArrayInitialization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4829:2: ( (otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']' ) )
            // InternalPoST.g:4830:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']' )
            {
            // InternalPoST.g:4830:2: (otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']' )
            // InternalPoST.g:4831:3: otherlv_0= '[' ( (lv_elements_1_0= ruleConstant ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getArrayInitializationAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalPoST.g:4835:3: ( (lv_elements_1_0= ruleConstant ) )
            // InternalPoST.g:4836:4: (lv_elements_1_0= ruleConstant )
            {
            // InternalPoST.g:4836:4: (lv_elements_1_0= ruleConstant )
            // InternalPoST.g:4837:5: lv_elements_1_0= ruleConstant
            {

            					newCompositeNode(grammarAccess.getArrayInitializationAccess().getElementsConstantParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_91);
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

            // InternalPoST.g:4854:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==48) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalPoST.g:4855:4: otherlv_2= ',' ( (lv_elements_3_0= ruleConstant ) )
            	    {
            	    otherlv_2=(Token)match(input,48,FOLLOW_17); 

            	    				newLeafNode(otherlv_2, grammarAccess.getArrayInitializationAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalPoST.g:4859:4: ( (lv_elements_3_0= ruleConstant ) )
            	    // InternalPoST.g:4860:5: (lv_elements_3_0= ruleConstant )
            	    {
            	    // InternalPoST.g:4860:5: (lv_elements_3_0= ruleConstant )
            	    // InternalPoST.g:4861:6: lv_elements_3_0= ruleConstant
            	    {

            	    						newCompositeNode(grammarAccess.getArrayInitializationAccess().getElementsConstantParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_91);
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
            	    break loop62;
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
    // InternalPoST.g:4887:1: entryRuleTimeLiteral returns [EObject current=null] : iv_ruleTimeLiteral= ruleTimeLiteral EOF ;
    public final EObject entryRuleTimeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeLiteral = null;


        try {
            // InternalPoST.g:4887:52: (iv_ruleTimeLiteral= ruleTimeLiteral EOF )
            // InternalPoST.g:4888:2: iv_ruleTimeLiteral= ruleTimeLiteral EOF
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
    // InternalPoST.g:4894:1: ruleTimeLiteral returns [EObject current=null] : (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) ) ;
    public final EObject ruleTimeLiteral() throws RecognitionException {
        EObject current = null;

        Token this_TIME_PREF_LITERAL_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_interval_3_0=null;


        	enterRule();

        try {
            // InternalPoST.g:4900:2: ( (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) ) )
            // InternalPoST.g:4901:2: (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) )
            {
            // InternalPoST.g:4901:2: (this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) ) )
            // InternalPoST.g:4902:3: this_TIME_PREF_LITERAL_0= RULE_TIME_PREF_LITERAL otherlv_1= '#' (otherlv_2= '-' )? ( (lv_interval_3_0= RULE_INTERVAL ) )
            {
            this_TIME_PREF_LITERAL_0=(Token)match(input,RULE_TIME_PREF_LITERAL,FOLLOW_92); 

            			newLeafNode(this_TIME_PREF_LITERAL_0, grammarAccess.getTimeLiteralAccess().getTIME_PREF_LITERALTerminalRuleCall_0());
            		
            otherlv_1=(Token)match(input,107,FOLLOW_93); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeLiteralAccess().getNumberSignKeyword_1());
            		
            // InternalPoST.g:4910:3: (otherlv_2= '-' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==108) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalPoST.g:4911:4: otherlv_2= '-'
                    {
                    otherlv_2=(Token)match(input,108,FOLLOW_94); 

                    				newLeafNode(otherlv_2, grammarAccess.getTimeLiteralAccess().getHyphenMinusKeyword_2());
                    			

                    }
                    break;

            }

            // InternalPoST.g:4916:3: ( (lv_interval_3_0= RULE_INTERVAL ) )
            // InternalPoST.g:4917:4: (lv_interval_3_0= RULE_INTERVAL )
            {
            // InternalPoST.g:4917:4: (lv_interval_3_0= RULE_INTERVAL )
            // InternalPoST.g:4918:5: lv_interval_3_0= RULE_INTERVAL
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
    // InternalPoST.g:4938:1: entryRuleDataTypeName returns [String current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final String entryRuleDataTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDataTypeName = null;


        try {
            // InternalPoST.g:4938:52: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // InternalPoST.g:4939:2: iv_ruleDataTypeName= ruleDataTypeName EOF
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
    // InternalPoST.g:4945:1: ruleDataTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleDataTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BIT_STRING_TYPE_NAME_1=null;
        Token this_TIME_TYPE_NAME_2=null;
        Token this_STRING_TYPE_NAME_3=null;
        AntlrDatatypeRuleToken this_NumericTypeName_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:4951:2: ( (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME ) )
            // InternalPoST.g:4952:2: (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME )
            {
            // InternalPoST.g:4952:2: (this_NumericTypeName_0= ruleNumericTypeName | this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME | this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME | this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME )
            int alt64=4;
            switch ( input.LA(1) ) {
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
                {
                alt64=1;
                }
                break;
            case RULE_BIT_STRING_TYPE_NAME:
                {
                alt64=2;
                }
                break;
            case RULE_TIME_TYPE_NAME:
                {
                alt64=3;
                }
                break;
            case RULE_STRING_TYPE_NAME:
                {
                alt64=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalPoST.g:4953:3: this_NumericTypeName_0= ruleNumericTypeName
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
                    // InternalPoST.g:4964:3: this_BIT_STRING_TYPE_NAME_1= RULE_BIT_STRING_TYPE_NAME
                    {
                    this_BIT_STRING_TYPE_NAME_1=(Token)match(input,RULE_BIT_STRING_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_BIT_STRING_TYPE_NAME_1);
                    		

                    			newLeafNode(this_BIT_STRING_TYPE_NAME_1, grammarAccess.getDataTypeNameAccess().getBIT_STRING_TYPE_NAMETerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalPoST.g:4972:3: this_TIME_TYPE_NAME_2= RULE_TIME_TYPE_NAME
                    {
                    this_TIME_TYPE_NAME_2=(Token)match(input,RULE_TIME_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_TIME_TYPE_NAME_2);
                    		

                    			newLeafNode(this_TIME_TYPE_NAME_2, grammarAccess.getDataTypeNameAccess().getTIME_TYPE_NAMETerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalPoST.g:4980:3: this_STRING_TYPE_NAME_3= RULE_STRING_TYPE_NAME
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
    // InternalPoST.g:4991:1: entryRuleNumericTypeName returns [String current=null] : iv_ruleNumericTypeName= ruleNumericTypeName EOF ;
    public final String entryRuleNumericTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumericTypeName = null;


        try {
            // InternalPoST.g:4991:55: (iv_ruleNumericTypeName= ruleNumericTypeName EOF )
            // InternalPoST.g:4992:2: iv_ruleNumericTypeName= ruleNumericTypeName EOF
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
    // InternalPoST.g:4998:1: ruleNumericTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleNumericTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_TYPE_NAME_1=null;
        AntlrDatatypeRuleToken this_IntegerTypeName_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5004:2: ( (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME ) )
            // InternalPoST.g:5005:2: (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME )
            {
            // InternalPoST.g:5005:2: (this_IntegerTypeName_0= ruleIntegerTypeName | this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=RULE_SIGNED_INTEGER_TYPE_NAME && LA65_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt65=1;
            }
            else if ( (LA65_0==RULE_REAL_TYPE_NAME) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalPoST.g:5006:3: this_IntegerTypeName_0= ruleIntegerTypeName
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
                    // InternalPoST.g:5017:3: this_REAL_TYPE_NAME_1= RULE_REAL_TYPE_NAME
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
    // InternalPoST.g:5028:1: entryRuleIntegerTypeName returns [String current=null] : iv_ruleIntegerTypeName= ruleIntegerTypeName EOF ;
    public final String entryRuleIntegerTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerTypeName = null;


        try {
            // InternalPoST.g:5028:55: (iv_ruleIntegerTypeName= ruleIntegerTypeName EOF )
            // InternalPoST.g:5029:2: iv_ruleIntegerTypeName= ruleIntegerTypeName EOF
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
    // InternalPoST.g:5035:1: ruleIntegerTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME ) ;
    public final AntlrDatatypeRuleToken ruleIntegerTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIGNED_INTEGER_TYPE_NAME_0=null;
        Token this_UNSIGNED_INTEGER_TYPE_NAME_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5041:2: ( (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME ) )
            // InternalPoST.g:5042:2: (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME )
            {
            // InternalPoST.g:5042:2: (this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME | this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_SIGNED_INTEGER_TYPE_NAME) ) {
                alt66=1;
            }
            else if ( (LA66_0==RULE_UNSIGNED_INTEGER_TYPE_NAME) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalPoST.g:5043:3: this_SIGNED_INTEGER_TYPE_NAME_0= RULE_SIGNED_INTEGER_TYPE_NAME
                    {
                    this_SIGNED_INTEGER_TYPE_NAME_0=(Token)match(input,RULE_SIGNED_INTEGER_TYPE_NAME,FOLLOW_2); 

                    			current.merge(this_SIGNED_INTEGER_TYPE_NAME_0);
                    		

                    			newLeafNode(this_SIGNED_INTEGER_TYPE_NAME_0, grammarAccess.getIntegerTypeNameAccess().getSIGNED_INTEGER_TYPE_NAMETerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalPoST.g:5051:3: this_UNSIGNED_INTEGER_TYPE_NAME_1= RULE_UNSIGNED_INTEGER_TYPE_NAME
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
    // InternalPoST.g:5062:1: entryRuleSimpleSpecificationInit returns [EObject current=null] : iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF ;
    public final EObject entryRuleSimpleSpecificationInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleSpecificationInit = null;


        try {
            // InternalPoST.g:5062:64: (iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF )
            // InternalPoST.g:5063:2: iv_ruleSimpleSpecificationInit= ruleSimpleSpecificationInit EOF
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
    // InternalPoST.g:5069:1: ruleSimpleSpecificationInit returns [EObject current=null] : ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )? ) ;
    public final EObject ruleSimpleSpecificationInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5075:2: ( ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )? ) )
            // InternalPoST.g:5076:2: ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )? )
            {
            // InternalPoST.g:5076:2: ( () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )? )
            // InternalPoST.g:5077:3: () ( (lv_type_1_0= ruleDataTypeName ) ) (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )?
            {
            // InternalPoST.g:5077:3: ()
            // InternalPoST.g:5078:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleSpecificationInitAccess().getSimpleSpecificationInitAction_0(),
            					current);
            			

            }

            // InternalPoST.g:5084:3: ( (lv_type_1_0= ruleDataTypeName ) )
            // InternalPoST.g:5085:4: (lv_type_1_0= ruleDataTypeName )
            {
            // InternalPoST.g:5085:4: (lv_type_1_0= ruleDataTypeName )
            // InternalPoST.g:5086:5: lv_type_1_0= ruleDataTypeName
            {

            					newCompositeNode(grammarAccess.getSimpleSpecificationInitAccess().getTypeDataTypeNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_89);
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

            // InternalPoST.g:5103:3: (otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==47) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalPoST.g:5104:4: otherlv_2= ':=' ( (lv_value_3_0= ruleConstant ) )
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleSpecificationInitAccess().getColonEqualsSignKeyword_2_0());
                    			
                    // InternalPoST.g:5108:4: ( (lv_value_3_0= ruleConstant ) )
                    // InternalPoST.g:5109:5: (lv_value_3_0= ruleConstant )
                    {
                    // InternalPoST.g:5109:5: (lv_value_3_0= ruleConstant )
                    // InternalPoST.g:5110:6: lv_value_3_0= ruleConstant
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
    // InternalPoST.g:5132:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalPoST.g:5132:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalPoST.g:5133:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalPoST.g:5139:1: ruleConstant returns [EObject current=null] : (this_NumericLiteral_0= ruleNumericLiteral | this_TimeLiteral_1= ruleTimeLiteral | ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER ) | ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER ) | ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER ) | ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL ) ) ;
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
            // InternalPoST.g:5145:2: ( (this_NumericLiteral_0= ruleNumericLiteral | this_TimeLiteral_1= ruleTimeLiteral | ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER ) | ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER ) | ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER ) | ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL ) ) )
            // InternalPoST.g:5146:2: (this_NumericLiteral_0= ruleNumericLiteral | this_TimeLiteral_1= ruleTimeLiteral | ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER ) | ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER ) | ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER ) | ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL ) )
            {
            // InternalPoST.g:5146:2: (this_NumericLiteral_0= ruleNumericLiteral | this_TimeLiteral_1= ruleTimeLiteral | ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER ) | ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER ) | ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER ) | ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL ) )
            int alt68=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
            case RULE_REAL_TYPE_NAME:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
            case RULE_REAL:
            case 108:
                {
                alt68=1;
                }
                break;
            case RULE_TIME_PREF_LITERAL:
                {
                alt68=2;
                }
                break;
            case RULE_BINARY_INTEGER:
                {
                alt68=3;
                }
                break;
            case RULE_OCTAL_INTEGER:
                {
                alt68=4;
                }
                break;
            case RULE_HEX_INTEGER:
                {
                alt68=5;
                }
                break;
            case RULE_BOOLEAN_LITERAL:
                {
                alt68=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalPoST.g:5147:3: this_NumericLiteral_0= ruleNumericLiteral
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
                    // InternalPoST.g:5156:3: this_TimeLiteral_1= ruleTimeLiteral
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
                    // InternalPoST.g:5165:3: ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER )
                    {
                    // InternalPoST.g:5165:3: ( () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER )
                    // InternalPoST.g:5166:4: () this_BINARY_INTEGER_3= RULE_BINARY_INTEGER
                    {
                    // InternalPoST.g:5166:4: ()
                    // InternalPoST.g:5167:5: 
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
                    // InternalPoST.g:5179:3: ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER )
                    {
                    // InternalPoST.g:5179:3: ( () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER )
                    // InternalPoST.g:5180:4: () this_OCTAL_INTEGER_5= RULE_OCTAL_INTEGER
                    {
                    // InternalPoST.g:5180:4: ()
                    // InternalPoST.g:5181:5: 
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
                    // InternalPoST.g:5193:3: ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER )
                    {
                    // InternalPoST.g:5193:3: ( () this_HEX_INTEGER_7= RULE_HEX_INTEGER )
                    // InternalPoST.g:5194:4: () this_HEX_INTEGER_7= RULE_HEX_INTEGER
                    {
                    // InternalPoST.g:5194:4: ()
                    // InternalPoST.g:5195:5: 
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
                    // InternalPoST.g:5207:3: ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL )
                    {
                    // InternalPoST.g:5207:3: ( () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL )
                    // InternalPoST.g:5208:4: () this_BOOLEAN_LITERAL_9= RULE_BOOLEAN_LITERAL
                    {
                    // InternalPoST.g:5208:4: ()
                    // InternalPoST.g:5209:5: 
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
    // InternalPoST.g:5224:1: entryRuleSignedInteger returns [EObject current=null] : iv_ruleSignedInteger= ruleSignedInteger EOF ;
    public final EObject entryRuleSignedInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedInteger = null;


        try {
            // InternalPoST.g:5224:54: (iv_ruleSignedInteger= ruleSignedInteger EOF )
            // InternalPoST.g:5225:2: iv_ruleSignedInteger= ruleSignedInteger EOF
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
    // InternalPoST.g:5231:1: ruleSignedInteger returns [EObject current=null] : ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleSignedInteger() throws RecognitionException {
        EObject current = null;

        Token lv_iSig_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5237:2: ( ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // InternalPoST.g:5238:2: ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // InternalPoST.g:5238:2: ( ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // InternalPoST.g:5239:3: ( (lv_iSig_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // InternalPoST.g:5239:3: ( (lv_iSig_0_0= '-' ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==108) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalPoST.g:5240:4: (lv_iSig_0_0= '-' )
                    {
                    // InternalPoST.g:5240:4: (lv_iSig_0_0= '-' )
                    // InternalPoST.g:5241:5: lv_iSig_0_0= '-'
                    {
                    lv_iSig_0_0=(Token)match(input,108,FOLLOW_20); 

                    					newLeafNode(lv_iSig_0_0, grammarAccess.getSignedIntegerAccess().getISigHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSignedIntegerRule());
                    					}
                    					setWithLastConsumed(current, "iSig", lv_iSig_0_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:5253:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // InternalPoST.g:5254:4: (lv_value_1_0= RULE_INTEGER )
            {
            // InternalPoST.g:5254:4: (lv_value_1_0= RULE_INTEGER )
            // InternalPoST.g:5255:5: lv_value_1_0= RULE_INTEGER
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
    // InternalPoST.g:5275:1: entryRuleNumericLiteral returns [EObject current=null] : iv_ruleNumericLiteral= ruleNumericLiteral EOF ;
    public final EObject entryRuleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericLiteral = null;


        try {
            // InternalPoST.g:5275:55: (iv_ruleNumericLiteral= ruleNumericLiteral EOF )
            // InternalPoST.g:5276:2: iv_ruleNumericLiteral= ruleNumericLiteral EOF
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
    // InternalPoST.g:5282:1: ruleNumericLiteral returns [EObject current=null] : (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral ) ;
    public final EObject ruleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteral_0 = null;

        EObject this_RealLiteral_1 = null;



        	enterRule();

        try {
            // InternalPoST.g:5288:2: ( (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral ) )
            // InternalPoST.g:5289:2: (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral )
            {
            // InternalPoST.g:5289:2: (this_IntegerLiteral_0= ruleIntegerLiteral | this_RealLiteral_1= ruleRealLiteral )
            int alt70=2;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
            case RULE_SIGNED_INTEGER_TYPE_NAME:
            case RULE_UNSIGNED_INTEGER_TYPE_NAME:
                {
                alt70=1;
                }
                break;
            case 108:
                {
                int LA70_2 = input.LA(2);

                if ( (LA70_2==RULE_REAL) ) {
                    alt70=2;
                }
                else if ( (LA70_2==RULE_INTEGER) ) {
                    alt70=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REAL_TYPE_NAME:
            case RULE_REAL:
                {
                alt70=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalPoST.g:5290:3: this_IntegerLiteral_0= ruleIntegerLiteral
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
                    // InternalPoST.g:5299:3: this_RealLiteral_1= ruleRealLiteral
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
    // InternalPoST.g:5311:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // InternalPoST.g:5311:55: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // InternalPoST.g:5312:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
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
    // InternalPoST.g:5318:1: ruleIntegerLiteral returns [EObject current=null] : ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalPoST.g:5324:2: ( ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) ) )
            // InternalPoST.g:5325:2: ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) )
            {
            // InternalPoST.g:5325:2: ( ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) ) )
            // InternalPoST.g:5326:3: ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )? ( (lv_value_2_0= ruleSignedInteger ) )
            {
            // InternalPoST.g:5326:3: ( ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_SIGNED_INTEGER_TYPE_NAME && LA71_0<=RULE_UNSIGNED_INTEGER_TYPE_NAME)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalPoST.g:5327:4: ( (lv_type_0_0= ruleIntegerTypeName ) ) otherlv_1= '#'
                    {
                    // InternalPoST.g:5327:4: ( (lv_type_0_0= ruleIntegerTypeName ) )
                    // InternalPoST.g:5328:5: (lv_type_0_0= ruleIntegerTypeName )
                    {
                    // InternalPoST.g:5328:5: (lv_type_0_0= ruleIntegerTypeName )
                    // InternalPoST.g:5329:6: lv_type_0_0= ruleIntegerTypeName
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

                    otherlv_1=(Token)match(input,107,FOLLOW_65); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntegerLiteralAccess().getNumberSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalPoST.g:5351:3: ( (lv_value_2_0= ruleSignedInteger ) )
            // InternalPoST.g:5352:4: (lv_value_2_0= ruleSignedInteger )
            {
            // InternalPoST.g:5352:4: (lv_value_2_0= ruleSignedInteger )
            // InternalPoST.g:5353:5: lv_value_2_0= ruleSignedInteger
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
    // InternalPoST.g:5374:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // InternalPoST.g:5374:52: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // InternalPoST.g:5375:2: iv_ruleRealLiteral= ruleRealLiteral EOF
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
    // InternalPoST.g:5381:1: ruleRealLiteral returns [EObject current=null] : ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token otherlv_1=null;
        Token lv_rSig_2_0=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalPoST.g:5387:2: ( ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) ) )
            // InternalPoST.g:5388:2: ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) )
            {
            // InternalPoST.g:5388:2: ( ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) ) )
            // InternalPoST.g:5389:3: ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )? ( (lv_rSig_2_0= '-' ) )? ( (lv_value_3_0= RULE_REAL ) )
            {
            // InternalPoST.g:5389:3: ( ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_REAL_TYPE_NAME) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalPoST.g:5390:4: ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) ) otherlv_1= '#'
                    {
                    // InternalPoST.g:5390:4: ( (lv_type_0_0= RULE_REAL_TYPE_NAME ) )
                    // InternalPoST.g:5391:5: (lv_type_0_0= RULE_REAL_TYPE_NAME )
                    {
                    // InternalPoST.g:5391:5: (lv_type_0_0= RULE_REAL_TYPE_NAME )
                    // InternalPoST.g:5392:6: lv_type_0_0= RULE_REAL_TYPE_NAME
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

                    otherlv_1=(Token)match(input,107,FOLLOW_95); 

                    				newLeafNode(otherlv_1, grammarAccess.getRealLiteralAccess().getNumberSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalPoST.g:5413:3: ( (lv_rSig_2_0= '-' ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==108) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalPoST.g:5414:4: (lv_rSig_2_0= '-' )
                    {
                    // InternalPoST.g:5414:4: (lv_rSig_2_0= '-' )
                    // InternalPoST.g:5415:5: lv_rSig_2_0= '-'
                    {
                    lv_rSig_2_0=(Token)match(input,108,FOLLOW_96); 

                    					newLeafNode(lv_rSig_2_0, grammarAccess.getRealLiteralAccess().getRSigHyphenMinusKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRealLiteralRule());
                    					}
                    					setWithLastConsumed(current, "rSig", lv_rSig_2_0 != null, "-");
                    				

                    }


                    }
                    break;

            }

            // InternalPoST.g:5427:3: ( (lv_value_3_0= RULE_REAL ) )
            // InternalPoST.g:5428:4: (lv_value_3_0= RULE_REAL )
            {
            // InternalPoST.g:5428:4: (lv_value_3_0= RULE_REAL )
            // InternalPoST.g:5429:5: lv_value_3_0= RULE_REAL
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
    // InternalPoST.g:5449:1: ruleAssignmentType returns [Enumerator current=null] : ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) ) ;
    public final Enumerator ruleAssignmentType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5455:2: ( ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) ) )
            // InternalPoST.g:5456:2: ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) )
            {
            // InternalPoST.g:5456:2: ( (enumLiteral_0= ':=' ) | (enumLiteral_1= '=>' ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==47) ) {
                alt74=1;
            }
            else if ( (LA74_0==109) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalPoST.g:5457:3: (enumLiteral_0= ':=' )
                    {
                    // InternalPoST.g:5457:3: (enumLiteral_0= ':=' )
                    // InternalPoST.g:5458:4: enumLiteral_0= ':='
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getAssignmentTypeAccess().getInEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAssignmentTypeAccess().getInEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5465:3: (enumLiteral_1= '=>' )
                    {
                    // InternalPoST.g:5465:3: (enumLiteral_1= '=>' )
                    // InternalPoST.g:5466:4: enumLiteral_1= '=>'
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
    // InternalPoST.g:5476:1: ruleCompOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) ;
    public final Enumerator ruleCompOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5482:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) ) )
            // InternalPoST.g:5483:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            {
            // InternalPoST.g:5483:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==110) ) {
                alt75=1;
            }
            else if ( (LA75_0==111) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalPoST.g:5484:3: (enumLiteral_0= '=' )
                    {
                    // InternalPoST.g:5484:3: (enumLiteral_0= '=' )
                    // InternalPoST.g:5485:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getCompOperatorAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCompOperatorAccess().getEQUALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5492:3: (enumLiteral_1= '<>' )
                    {
                    // InternalPoST.g:5492:3: (enumLiteral_1= '<>' )
                    // InternalPoST.g:5493:4: enumLiteral_1= '<>'
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
    // InternalPoST.g:5503:1: ruleEquOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleEquOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalPoST.g:5509:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) ) )
            // InternalPoST.g:5510:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalPoST.g:5510:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '<=' ) | (enumLiteral_3= '>=' ) )
            int alt76=4;
            switch ( input.LA(1) ) {
            case 112:
                {
                alt76=1;
                }
                break;
            case 113:
                {
                alt76=2;
                }
                break;
            case 114:
                {
                alt76=3;
                }
                break;
            case 115:
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
                    // InternalPoST.g:5511:3: (enumLiteral_0= '<' )
                    {
                    // InternalPoST.g:5511:3: (enumLiteral_0= '<' )
                    // InternalPoST.g:5512:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEquOperatorAccess().getLESSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5519:3: (enumLiteral_1= '>' )
                    {
                    // InternalPoST.g:5519:3: (enumLiteral_1= '>' )
                    // InternalPoST.g:5520:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEquOperatorAccess().getGREATEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:5527:3: (enumLiteral_2= '<=' )
                    {
                    // InternalPoST.g:5527:3: (enumLiteral_2= '<=' )
                    // InternalPoST.g:5528:4: enumLiteral_2= '<='
                    {
                    enumLiteral_2=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getEquOperatorAccess().getLESS_EQUEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getEquOperatorAccess().getLESS_EQUEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalPoST.g:5535:3: (enumLiteral_3= '>=' )
                    {
                    // InternalPoST.g:5535:3: (enumLiteral_3= '>=' )
                    // InternalPoST.g:5536:4: enumLiteral_3= '>='
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
    // InternalPoST.g:5546:1: ruleAddOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5552:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalPoST.g:5553:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalPoST.g:5553:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==116) ) {
                alt77=1;
            }
            else if ( (LA77_0==108) ) {
                alt77=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // InternalPoST.g:5554:3: (enumLiteral_0= '+' )
                    {
                    // InternalPoST.g:5554:3: (enumLiteral_0= '+' )
                    // InternalPoST.g:5555:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getAddOperatorAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOperatorAccess().getPLUSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5562:3: (enumLiteral_1= '-' )
                    {
                    // InternalPoST.g:5562:3: (enumLiteral_1= '-' )
                    // InternalPoST.g:5563:4: enumLiteral_1= '-'
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
    // InternalPoST.g:5573:1: ruleMulOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) ) ;
    public final Enumerator ruleMulOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalPoST.g:5579:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) ) )
            // InternalPoST.g:5580:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) )
            {
            // InternalPoST.g:5580:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= 'MOD' ) )
            int alt78=3;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt78=1;
                }
                break;
            case 118:
                {
                alt78=2;
                }
                break;
            case 119:
                {
                alt78=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalPoST.g:5581:3: (enumLiteral_0= '*' )
                    {
                    // InternalPoST.g:5581:3: (enumLiteral_0= '*' )
                    // InternalPoST.g:5582:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getMulOperatorAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMulOperatorAccess().getMULEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5589:3: (enumLiteral_1= '/' )
                    {
                    // InternalPoST.g:5589:3: (enumLiteral_1= '/' )
                    // InternalPoST.g:5590:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getMulOperatorAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMulOperatorAccess().getDIVEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalPoST.g:5597:3: (enumLiteral_2= 'MOD' )
                    {
                    // InternalPoST.g:5597:3: (enumLiteral_2= 'MOD' )
                    // InternalPoST.g:5598:4: enumLiteral_2= 'MOD'
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
    // InternalPoST.g:5608:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalPoST.g:5614:2: ( ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) ) )
            // InternalPoST.g:5615:2: ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) )
            {
            // InternalPoST.g:5615:2: ( (enumLiteral_0= 'NOT' ) | (enumLiteral_1= '-' ) )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==120) ) {
                alt79=1;
            }
            else if ( (LA79_0==108) ) {
                alt79=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalPoST.g:5616:3: (enumLiteral_0= 'NOT' )
                    {
                    // InternalPoST.g:5616:3: (enumLiteral_0= 'NOT' )
                    // InternalPoST.g:5617:4: enumLiteral_0= 'NOT'
                    {
                    enumLiteral_0=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getUnaryOperatorAccess().getNOTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getNOTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalPoST.g:5624:3: (enumLiteral_1= '-' )
                    {
                    // InternalPoST.g:5624:3: (enumLiteral_1= '-' )
                    // InternalPoST.g:5625:4: enumLiteral_1= '-'
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


    protected DFA60 dfa60 = new DFA60(this);
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

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()+ loopback of 4513:3: ( ( ( (lv_varsSimple_2_0= ruleVarInitDeclaration ) ) otherlv_3= ';' ) | ( ( (lv_varsAs_4_0= ruleGlobalVarInitDeclaration ) ) otherlv_5= ';' ) )+";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0082004000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000008000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000140000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000007F84100L,0x0000100000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0010000000000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000800000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000007F84110L,0x0000100000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0028000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0050000000000000L,0x0000006E80000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0110000000000000L,0x0000006E80000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0110000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0600000000000000L,0x0000002800000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x3800000000000010L,0x000000001942453EL});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x3000000000000010L,0x000000001942453EL});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x4400000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x2000000000000010L,0x000000001942459EL});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0010200007F84110L,0x0100100000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000C00000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x000F000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0010100000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x00E0000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0010200007F84110L,0x0000100000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x2000000000000012L,0x000000001942451EL});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x2000000000000010L,0x0000000019427D1EL});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003800L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x2000000000000010L,0x000000001942651EL});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000300100L,0x0000100000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000300100L,0x0000100000011000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x2000000000000010L,0x000000001943451EL});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x2000000000000010L,0x000000001942451EL});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x2000000000000010L,0x00000000194A451EL});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x2000000000000010L,0x0000000019C2451EL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x2000000000000010L,0x000000001B42451EL});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x00000000003F0000L,0x0000020000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000010L,0x0000000100000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000010L,0x0000001000000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000010L,0x0000001100000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0001000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000008000L,0x0000100000000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000004000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000004000000L});

}