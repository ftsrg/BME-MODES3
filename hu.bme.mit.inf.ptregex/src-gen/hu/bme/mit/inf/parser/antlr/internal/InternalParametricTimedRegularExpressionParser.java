package hu.bme.mit.inf.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.inf.services.ParametricTimedRegularExpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalParametricTimedRegularExpressionParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alphabet'", "'='", "'{'", "','", "'}'", "'/'", "'expression'", "'['", "']'", "'&'", "'|'", "'*'", "'+'", "'('", "')'", "'S'", "'\\\\'", "'<'", "'>'", "'_'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalParametricTimedRegularExpressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalParametricTimedRegularExpressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalParametricTimedRegularExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "InternalParametricTimedRegularExpression.g"; }



     	private ParametricTimedRegularExpressionGrammarAccess grammarAccess;

        public InternalParametricTimedRegularExpressionParser(TokenStream input, ParametricTimedRegularExpressionGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "RegexModel";
       	}

       	@Override
       	protected ParametricTimedRegularExpressionGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRegexModel"
    // InternalParametricTimedRegularExpression.g:64:1: entryRuleRegexModel returns [EObject current=null] : iv_ruleRegexModel= ruleRegexModel EOF ;
    public final EObject entryRuleRegexModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexModel = null;


        try {
            // InternalParametricTimedRegularExpression.g:64:51: (iv_ruleRegexModel= ruleRegexModel EOF )
            // InternalParametricTimedRegularExpression.g:65:2: iv_ruleRegexModel= ruleRegexModel EOF
            {
             newCompositeNode(grammarAccess.getRegexModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegexModel=ruleRegexModel();

            state._fsp--;

             current =iv_ruleRegexModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegexModel"


    // $ANTLR start "ruleRegexModel"
    // InternalParametricTimedRegularExpression.g:71:1: ruleRegexModel returns [EObject current=null] : ( ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )+ ) ;
    public final EObject ruleRegexModel() throws RecognitionException {
        EObject current = null;

        EObject lv_alphabet_0_0 = null;

        EObject lv_declarations_1_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:77:2: ( ( ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )+ ) )
            // InternalParametricTimedRegularExpression.g:78:2: ( ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )+ )
            {
            // InternalParametricTimedRegularExpression.g:78:2: ( ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )+ )
            // InternalParametricTimedRegularExpression.g:79:3: ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )+
            {
            // InternalParametricTimedRegularExpression.g:79:3: ( (lv_alphabet_0_0= ruleAlphabet ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:80:4: (lv_alphabet_0_0= ruleAlphabet )
                    {
                    // InternalParametricTimedRegularExpression.g:80:4: (lv_alphabet_0_0= ruleAlphabet )
                    // InternalParametricTimedRegularExpression.g:81:5: lv_alphabet_0_0= ruleAlphabet
                    {

                    					newCompositeNode(grammarAccess.getRegexModelAccess().getAlphabetAlphabetParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_alphabet_0_0=ruleAlphabet();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRegexModelRule());
                    					}
                    					set(
                    						current,
                    						"alphabet",
                    						lv_alphabet_0_0,
                    						"hu.bme.mit.inf.ParametricTimedRegularExpression.Alphabet");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalParametricTimedRegularExpression.g:98:3: ( (lv_declarations_1_0= ruleExpressionDeclaration ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:99:4: (lv_declarations_1_0= ruleExpressionDeclaration )
            	    {
            	    // InternalParametricTimedRegularExpression.g:99:4: (lv_declarations_1_0= ruleExpressionDeclaration )
            	    // InternalParametricTimedRegularExpression.g:100:5: lv_declarations_1_0= ruleExpressionDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getRegexModelAccess().getDeclarationsExpressionDeclarationParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_declarations_1_0=ruleExpressionDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRegexModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"declarations",
            	    						lv_declarations_1_0,
            	    						"hu.bme.mit.inf.ParametricTimedRegularExpression.ExpressionDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

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


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegexModel"


    // $ANTLR start "entryRuleAlphabet"
    // InternalParametricTimedRegularExpression.g:121:1: entryRuleAlphabet returns [EObject current=null] : iv_ruleAlphabet= ruleAlphabet EOF ;
    public final EObject entryRuleAlphabet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlphabet = null;


        try {
            // InternalParametricTimedRegularExpression.g:121:49: (iv_ruleAlphabet= ruleAlphabet EOF )
            // InternalParametricTimedRegularExpression.g:122:2: iv_ruleAlphabet= ruleAlphabet EOF
            {
             newCompositeNode(grammarAccess.getAlphabetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlphabet=ruleAlphabet();

            state._fsp--;

             current =iv_ruleAlphabet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlphabet"


    // $ANTLR start "ruleAlphabet"
    // InternalParametricTimedRegularExpression.g:128:1: ruleAlphabet returns [EObject current=null] : ( () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}' ) ;
    public final EObject ruleAlphabet() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_functors_4_0 = null;

        EObject lv_functors_6_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:134:2: ( ( () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}' ) )
            // InternalParametricTimedRegularExpression.g:135:2: ( () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}' )
            {
            // InternalParametricTimedRegularExpression.g:135:2: ( () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}' )
            // InternalParametricTimedRegularExpression.g:136:3: () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}'
            {
            // InternalParametricTimedRegularExpression.g:136:3: ()
            // InternalParametricTimedRegularExpression.g:137:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAlphabetAccess().getAlphabetAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getAlphabetAccess().getAlphabetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getAlphabetAccess().getEqualsSignKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getAlphabetAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalParametricTimedRegularExpression.g:155:3: ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:156:4: ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )*
                    {
                    // InternalParametricTimedRegularExpression.g:156:4: ( (lv_functors_4_0= ruleFunctor ) )
                    // InternalParametricTimedRegularExpression.g:157:5: (lv_functors_4_0= ruleFunctor )
                    {
                    // InternalParametricTimedRegularExpression.g:157:5: (lv_functors_4_0= ruleFunctor )
                    // InternalParametricTimedRegularExpression.g:158:6: lv_functors_4_0= ruleFunctor
                    {

                    						newCompositeNode(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_functors_4_0=ruleFunctor();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAlphabetRule());
                    						}
                    						add(
                    							current,
                    							"functors",
                    							lv_functors_4_0,
                    							"hu.bme.mit.inf.ParametricTimedRegularExpression.Functor");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalParametricTimedRegularExpression.g:175:4: (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==14) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalParametricTimedRegularExpression.g:176:5: otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) )
                    	    {
                    	    otherlv_5=(Token)match(input,14,FOLLOW_9); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getAlphabetAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalParametricTimedRegularExpression.g:180:5: ( (lv_functors_6_0= ruleFunctor ) )
                    	    // InternalParametricTimedRegularExpression.g:181:6: (lv_functors_6_0= ruleFunctor )
                    	    {
                    	    // InternalParametricTimedRegularExpression.g:181:6: (lv_functors_6_0= ruleFunctor )
                    	    // InternalParametricTimedRegularExpression.g:182:7: lv_functors_6_0= ruleFunctor
                    	    {

                    	    							newCompositeNode(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_functors_6_0=ruleFunctor();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAlphabetRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"functors",
                    	    								lv_functors_6_0,
                    	    								"hu.bme.mit.inf.ParametricTimedRegularExpression.Functor");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getAlphabetAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlphabet"


    // $ANTLR start "entryRuleFunctor"
    // InternalParametricTimedRegularExpression.g:209:1: entryRuleFunctor returns [EObject current=null] : iv_ruleFunctor= ruleFunctor EOF ;
    public final EObject entryRuleFunctor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctor = null;


        try {
            // InternalParametricTimedRegularExpression.g:209:48: (iv_ruleFunctor= ruleFunctor EOF )
            // InternalParametricTimedRegularExpression.g:210:2: iv_ruleFunctor= ruleFunctor EOF
            {
             newCompositeNode(grammarAccess.getFunctorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctor=ruleFunctor();

            state._fsp--;

             current =iv_ruleFunctor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctor"


    // $ANTLR start "ruleFunctor"
    // InternalParametricTimedRegularExpression.g:216:1: ruleFunctor returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleFunctor() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_arity_2_0=null;


        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:222:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )? ) )
            // InternalParametricTimedRegularExpression.g:223:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )? )
            {
            // InternalParametricTimedRegularExpression.g:223:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )? )
            // InternalParametricTimedRegularExpression.g:224:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )?
            {
            // InternalParametricTimedRegularExpression.g:224:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:225:4: (lv_name_0_0= RULE_ID )
            {
            // InternalParametricTimedRegularExpression.g:225:4: (lv_name_0_0= RULE_ID )
            // InternalParametricTimedRegularExpression.g:226:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_0_0, grammarAccess.getFunctorAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"hu.bme.mit.inf.ParametricTimedRegularExpression.ID");
            				

            }


            }

            // InternalParametricTimedRegularExpression.g:242:3: (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:243:4: otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_1, grammarAccess.getFunctorAccess().getSolidusKeyword_1_0());
                    			
                    // InternalParametricTimedRegularExpression.g:247:4: ( (lv_arity_2_0= RULE_INT ) )
                    // InternalParametricTimedRegularExpression.g:248:5: (lv_arity_2_0= RULE_INT )
                    {
                    // InternalParametricTimedRegularExpression.g:248:5: (lv_arity_2_0= RULE_INT )
                    // InternalParametricTimedRegularExpression.g:249:6: lv_arity_2_0= RULE_INT
                    {
                    lv_arity_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_arity_2_0, grammarAccess.getFunctorAccess().getArityINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFunctorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arity",
                    							lv_arity_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

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
    // $ANTLR end "ruleFunctor"


    // $ANTLR start "entryRuleExpressionDeclaration"
    // InternalParametricTimedRegularExpression.g:270:1: entryRuleExpressionDeclaration returns [EObject current=null] : iv_ruleExpressionDeclaration= ruleExpressionDeclaration EOF ;
    public final EObject entryRuleExpressionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionDeclaration = null;


        try {
            // InternalParametricTimedRegularExpression.g:270:62: (iv_ruleExpressionDeclaration= ruleExpressionDeclaration EOF )
            // InternalParametricTimedRegularExpression.g:271:2: iv_ruleExpressionDeclaration= ruleExpressionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getExpressionDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpressionDeclaration=ruleExpressionDeclaration();

            state._fsp--;

             current =iv_ruleExpressionDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionDeclaration"


    // $ANTLR start "ruleExpressionDeclaration"
    // InternalParametricTimedRegularExpression.g:277:1: ruleExpressionDeclaration returns [EObject current=null] : (otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) ) ) ;
    public final EObject ruleExpressionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_vars_3_0 = null;

        EObject lv_vars_5_0 = null;

        EObject lv_body_8_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:283:2: ( (otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) ) ) )
            // InternalParametricTimedRegularExpression.g:284:2: (otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) ) )
            {
            // InternalParametricTimedRegularExpression.g:284:2: (otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) ) )
            // InternalParametricTimedRegularExpression.g:285:3: otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getExpressionDeclarationAccess().getExpressionKeyword_0());
            		
            // InternalParametricTimedRegularExpression.g:289:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:290:4: (lv_name_1_0= RULE_ID )
            {
            // InternalParametricTimedRegularExpression.g:290:4: (lv_name_1_0= RULE_ID )
            // InternalParametricTimedRegularExpression.g:291:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(lv_name_1_0, grammarAccess.getExpressionDeclarationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExpressionDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"hu.bme.mit.inf.ParametricTimedRegularExpression.ID");
            				

            }


            }

            // InternalParametricTimedRegularExpression.g:307:3: (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:308:4: otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getExpressionDeclarationAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalParametricTimedRegularExpression.g:312:4: ( (lv_vars_3_0= ruleVar ) )
                    // InternalParametricTimedRegularExpression.g:313:5: (lv_vars_3_0= ruleVar )
                    {
                    // InternalParametricTimedRegularExpression.g:313:5: (lv_vars_3_0= ruleVar )
                    // InternalParametricTimedRegularExpression.g:314:6: lv_vars_3_0= ruleVar
                    {

                    						newCompositeNode(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_vars_3_0=ruleVar();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpressionDeclarationRule());
                    						}
                    						add(
                    							current,
                    							"vars",
                    							lv_vars_3_0,
                    							"hu.bme.mit.inf.ParametricTimedRegularExpression.Var");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalParametricTimedRegularExpression.g:331:4: (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==14) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalParametricTimedRegularExpression.g:332:5: otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_9); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getExpressionDeclarationAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalParametricTimedRegularExpression.g:336:5: ( (lv_vars_5_0= ruleVar ) )
                    	    // InternalParametricTimedRegularExpression.g:337:6: (lv_vars_5_0= ruleVar )
                    	    {
                    	    // InternalParametricTimedRegularExpression.g:337:6: (lv_vars_5_0= ruleVar )
                    	    // InternalParametricTimedRegularExpression.g:338:7: lv_vars_5_0= ruleVar
                    	    {

                    	    							newCompositeNode(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_vars_5_0=ruleVar();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getExpressionDeclarationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"vars",
                    	    								lv_vars_5_0,
                    	    								"hu.bme.mit.inf.ParametricTimedRegularExpression.Var");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_5); 

                    				newLeafNode(otherlv_6, grammarAccess.getExpressionDeclarationAccess().getRightSquareBracketKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_7, grammarAccess.getExpressionDeclarationAccess().getEqualsSignKeyword_3());
            		
            // InternalParametricTimedRegularExpression.g:365:3: ( (lv_body_8_0= ruleExpression ) )
            // InternalParametricTimedRegularExpression.g:366:4: (lv_body_8_0= ruleExpression )
            {
            // InternalParametricTimedRegularExpression.g:366:4: (lv_body_8_0= ruleExpression )
            // InternalParametricTimedRegularExpression.g:367:5: lv_body_8_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getExpressionDeclarationAccess().getBodyExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_body_8_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExpressionDeclarationRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_8_0,
            						"hu.bme.mit.inf.ParametricTimedRegularExpression.Expression");
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
    // $ANTLR end "ruleExpressionDeclaration"


    // $ANTLR start "entryRuleExpression"
    // InternalParametricTimedRegularExpression.g:388:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalParametricTimedRegularExpression.g:388:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalParametricTimedRegularExpression.g:389:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalParametricTimedRegularExpression.g:395:1: ruleExpression returns [EObject current=null] : this_And_0= ruleAnd ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_And_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:401:2: (this_And_0= ruleAnd )
            // InternalParametricTimedRegularExpression.g:402:2: this_And_0= ruleAnd
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getAndParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_And_0=ruleAnd();

            state._fsp--;


            		current = this_And_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

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


    // $ANTLR start "entryRuleAnd"
    // InternalParametricTimedRegularExpression.g:413:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalParametricTimedRegularExpression.g:413:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalParametricTimedRegularExpression.g:414:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalParametricTimedRegularExpression.g:420:1: ruleAnd returns [EObject current=null] : (this_Choice_0= ruleChoice ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleChoice ) ) )+ )? ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Choice_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:426:2: ( (this_Choice_0= ruleChoice ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleChoice ) ) )+ )? ) )
            // InternalParametricTimedRegularExpression.g:427:2: (this_Choice_0= ruleChoice ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleChoice ) ) )+ )? )
            {
            // InternalParametricTimedRegularExpression.g:427:2: (this_Choice_0= ruleChoice ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleChoice ) ) )+ )? )
            // InternalParametricTimedRegularExpression.g:428:3: this_Choice_0= ruleChoice ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleChoice ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getAndAccess().getChoiceParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_Choice_0=ruleChoice();

            state._fsp--;


            			current = this_Choice_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalParametricTimedRegularExpression.g:436:3: ( () (otherlv_2= '&' ( (lv_elements_3_0= ruleChoice ) ) )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:437:4: () (otherlv_2= '&' ( (lv_elements_3_0= ruleChoice ) ) )+
                    {
                    // InternalParametricTimedRegularExpression.g:437:4: ()
                    // InternalParametricTimedRegularExpression.g:438:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getAndAccess().getAndElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalParametricTimedRegularExpression.g:444:4: (otherlv_2= '&' ( (lv_elements_3_0= ruleChoice ) ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==20) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalParametricTimedRegularExpression.g:445:5: otherlv_2= '&' ( (lv_elements_3_0= ruleChoice ) )
                    	    {
                    	    otherlv_2=(Token)match(input,20,FOLLOW_14); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAmpersandKeyword_1_1_0());
                    	    				
                    	    // InternalParametricTimedRegularExpression.g:449:5: ( (lv_elements_3_0= ruleChoice ) )
                    	    // InternalParametricTimedRegularExpression.g:450:6: (lv_elements_3_0= ruleChoice )
                    	    {
                    	    // InternalParametricTimedRegularExpression.g:450:6: (lv_elements_3_0= ruleChoice )
                    	    // InternalParametricTimedRegularExpression.g:451:7: lv_elements_3_0= ruleChoice
                    	    {

                    	    							newCompositeNode(grammarAccess.getAndAccess().getElementsChoiceParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_15);
                    	    lv_elements_3_0=ruleChoice();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAndRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"hu.bme.mit.inf.ParametricTimedRegularExpression.Choice");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


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
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleChoice"
    // InternalParametricTimedRegularExpression.g:474:1: entryRuleChoice returns [EObject current=null] : iv_ruleChoice= ruleChoice EOF ;
    public final EObject entryRuleChoice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoice = null;


        try {
            // InternalParametricTimedRegularExpression.g:474:47: (iv_ruleChoice= ruleChoice EOF )
            // InternalParametricTimedRegularExpression.g:475:2: iv_ruleChoice= ruleChoice EOF
            {
             newCompositeNode(grammarAccess.getChoiceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChoice=ruleChoice();

            state._fsp--;

             current =iv_ruleChoice; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChoice"


    // $ANTLR start "ruleChoice"
    // InternalParametricTimedRegularExpression.g:481:1: ruleChoice returns [EObject current=null] : (this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )? ) ;
    public final EObject ruleChoice() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Sequence_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:487:2: ( (this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )? ) )
            // InternalParametricTimedRegularExpression.g:488:2: (this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )? )
            {
            // InternalParametricTimedRegularExpression.g:488:2: (this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )? )
            // InternalParametricTimedRegularExpression.g:489:3: this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )?
            {

            			newCompositeNode(grammarAccess.getChoiceAccess().getSequenceParserRuleCall_0());
            		
            pushFollow(FOLLOW_16);
            this_Sequence_0=ruleSequence();

            state._fsp--;


            			current = this_Sequence_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalParametricTimedRegularExpression.g:497:3: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:498:4: () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+
                    {
                    // InternalParametricTimedRegularExpression.g:498:4: ()
                    // InternalParametricTimedRegularExpression.g:499:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getChoiceAccess().getChoiceElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalParametricTimedRegularExpression.g:505:4: (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==21) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalParametricTimedRegularExpression.g:506:5: otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_14); 

                    	    					newLeafNode(otherlv_2, grammarAccess.getChoiceAccess().getVerticalLineKeyword_1_1_0());
                    	    				
                    	    // InternalParametricTimedRegularExpression.g:510:5: ( (lv_elements_3_0= ruleSequence ) )
                    	    // InternalParametricTimedRegularExpression.g:511:6: (lv_elements_3_0= ruleSequence )
                    	    {
                    	    // InternalParametricTimedRegularExpression.g:511:6: (lv_elements_3_0= ruleSequence )
                    	    // InternalParametricTimedRegularExpression.g:512:7: lv_elements_3_0= ruleSequence
                    	    {

                    	    							newCompositeNode(grammarAccess.getChoiceAccess().getElementsSequenceParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_16);
                    	    lv_elements_3_0=ruleSequence();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getChoiceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_3_0,
                    	    								"hu.bme.mit.inf.ParametricTimedRegularExpression.Sequence");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


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
    // $ANTLR end "ruleChoice"


    // $ANTLR start "entryRuleSequence"
    // InternalParametricTimedRegularExpression.g:535:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // InternalParametricTimedRegularExpression.g:535:49: (iv_ruleSequence= ruleSequence EOF )
            // InternalParametricTimedRegularExpression.g:536:2: iv_ruleSequence= ruleSequence EOF
            {
             newCompositeNode(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequence=ruleSequence();

            state._fsp--;

             current =iv_ruleSequence; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // InternalParametricTimedRegularExpression.g:542:1: ruleSequence returns [EObject current=null] : (this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )? ) ;
    public final EObject ruleSequence() throws RecognitionException {
        EObject current = null;

        EObject this_MultExpression_0 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:548:2: ( (this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )? ) )
            // InternalParametricTimedRegularExpression.g:549:2: (this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )? )
            {
            // InternalParametricTimedRegularExpression.g:549:2: (this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )? )
            // InternalParametricTimedRegularExpression.g:550:3: this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )?
            {

            			newCompositeNode(grammarAccess.getSequenceAccess().getMultExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_17);
            this_MultExpression_0=ruleMultExpression();

            state._fsp--;


            			current = this_MultExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalParametricTimedRegularExpression.g:558:3: ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID||LA13_0==24||LA13_0==26||LA13_0==28) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:559:4: () ( (lv_elements_2_0= ruleMultExpression ) )+
                    {
                    // InternalParametricTimedRegularExpression.g:559:4: ()
                    // InternalParametricTimedRegularExpression.g:560:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getSequenceAccess().getSequenceElementsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalParametricTimedRegularExpression.g:566:4: ( (lv_elements_2_0= ruleMultExpression ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID||LA12_0==24||LA12_0==26||LA12_0==28) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalParametricTimedRegularExpression.g:567:5: (lv_elements_2_0= ruleMultExpression )
                    	    {
                    	    // InternalParametricTimedRegularExpression.g:567:5: (lv_elements_2_0= ruleMultExpression )
                    	    // InternalParametricTimedRegularExpression.g:568:6: lv_elements_2_0= ruleMultExpression
                    	    {

                    	    						newCompositeNode(grammarAccess.getSequenceAccess().getElementsMultExpressionParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_17);
                    	    lv_elements_2_0=ruleMultExpression();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSequenceRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"elements",
                    	    							lv_elements_2_0,
                    	    							"hu.bme.mit.inf.ParametricTimedRegularExpression.MultExpression");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


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
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleMultExpression"
    // InternalParametricTimedRegularExpression.g:590:1: entryRuleMultExpression returns [EObject current=null] : iv_ruleMultExpression= ruleMultExpression EOF ;
    public final EObject entryRuleMultExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultExpression = null;


        try {
            // InternalParametricTimedRegularExpression.g:590:55: (iv_ruleMultExpression= ruleMultExpression EOF )
            // InternalParametricTimedRegularExpression.g:591:2: iv_ruleMultExpression= ruleMultExpression EOF
            {
             newCompositeNode(grammarAccess.getMultExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultExpression=ruleMultExpression();

            state._fsp--;

             current =iv_ruleMultExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultExpression"


    // $ANTLR start "ruleMultExpression"
    // InternalParametricTimedRegularExpression.g:597:1: ruleMultExpression returns [EObject current=null] : (this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )? ) ;
    public final EObject ruleMultExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_n_7_0=null;
        Token otherlv_8=null;
        EObject this_ParenExpression_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:603:2: ( (this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )? ) )
            // InternalParametricTimedRegularExpression.g:604:2: (this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )? )
            {
            // InternalParametricTimedRegularExpression.g:604:2: (this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )? )
            // InternalParametricTimedRegularExpression.g:605:3: this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )?
            {

            			newCompositeNode(grammarAccess.getMultExpressionAccess().getParenExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_18);
            this_ParenExpression_0=ruleParenExpression();

            state._fsp--;


            			current = this_ParenExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalParametricTimedRegularExpression.g:613:3: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )?
            int alt14=4;
            switch ( input.LA(1) ) {
                case 22:
                    {
                    alt14=1;
                    }
                    break;
                case 23:
                    {
                    alt14=2;
                    }
                    break;
                case 13:
                    {
                    alt14=3;
                    }
                    break;
            }

            switch (alt14) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:614:4: ( () otherlv_2= '*' )
                    {
                    // InternalParametricTimedRegularExpression.g:614:4: ( () otherlv_2= '*' )
                    // InternalParametricTimedRegularExpression.g:615:5: () otherlv_2= '*'
                    {
                    // InternalParametricTimedRegularExpression.g:615:5: ()
                    // InternalParametricTimedRegularExpression.g:616:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getMultExpressionAccess().getStarBodyAction_1_0_0(),
                    							current);
                    					

                    }

                    otherlv_2=(Token)match(input,22,FOLLOW_2); 

                    					newLeafNode(otherlv_2, grammarAccess.getMultExpressionAccess().getAsteriskKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalParametricTimedRegularExpression.g:628:4: ( () otherlv_4= '+' )
                    {
                    // InternalParametricTimedRegularExpression.g:628:4: ( () otherlv_4= '+' )
                    // InternalParametricTimedRegularExpression.g:629:5: () otherlv_4= '+'
                    {
                    // InternalParametricTimedRegularExpression.g:629:5: ()
                    // InternalParametricTimedRegularExpression.g:630:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getMultExpressionAccess().getPlusBodyAction_1_1_0(),
                    							current);
                    					

                    }

                    otherlv_4=(Token)match(input,23,FOLLOW_2); 

                    					newLeafNode(otherlv_4, grammarAccess.getMultExpressionAccess().getPlusSignKeyword_1_1_1());
                    				

                    }


                    }
                    break;
                case 3 :
                    // InternalParametricTimedRegularExpression.g:642:4: ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' )
                    {
                    // InternalParametricTimedRegularExpression.g:642:4: ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' )
                    // InternalParametricTimedRegularExpression.g:643:5: () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}'
                    {
                    // InternalParametricTimedRegularExpression.g:643:5: ()
                    // InternalParametricTimedRegularExpression.g:644:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getMultExpressionAccess().getCardinalityBodyAction_1_2_0(),
                    							current);
                    					

                    }

                    otherlv_6=(Token)match(input,13,FOLLOW_11); 

                    					newLeafNode(otherlv_6, grammarAccess.getMultExpressionAccess().getLeftCurlyBracketKeyword_1_2_1());
                    				
                    // InternalParametricTimedRegularExpression.g:654:5: ( (lv_n_7_0= RULE_INT ) )
                    // InternalParametricTimedRegularExpression.g:655:6: (lv_n_7_0= RULE_INT )
                    {
                    // InternalParametricTimedRegularExpression.g:655:6: (lv_n_7_0= RULE_INT )
                    // InternalParametricTimedRegularExpression.g:656:7: lv_n_7_0= RULE_INT
                    {
                    lv_n_7_0=(Token)match(input,RULE_INT,FOLLOW_19); 

                    							newLeafNode(lv_n_7_0, grammarAccess.getMultExpressionAccess().getNINTTerminalRuleCall_1_2_2_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getMultExpressionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"n",
                    								lv_n_7_0,
                    								"org.eclipse.xtext.common.Terminals.INT");
                    						

                    }


                    }

                    otherlv_8=(Token)match(input,15,FOLLOW_2); 

                    					newLeafNode(otherlv_8, grammarAccess.getMultExpressionAccess().getRightCurlyBracketKeyword_1_2_3());
                    				

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
    // $ANTLR end "ruleMultExpression"


    // $ANTLR start "entryRuleParenExpression"
    // InternalParametricTimedRegularExpression.g:682:1: entryRuleParenExpression returns [EObject current=null] : iv_ruleParenExpression= ruleParenExpression EOF ;
    public final EObject entryRuleParenExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenExpression = null;


        try {
            // InternalParametricTimedRegularExpression.g:682:56: (iv_ruleParenExpression= ruleParenExpression EOF )
            // InternalParametricTimedRegularExpression.g:683:2: iv_ruleParenExpression= ruleParenExpression EOF
            {
             newCompositeNode(grammarAccess.getParenExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParenExpression=ruleParenExpression();

            state._fsp--;

             current =iv_ruleParenExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenExpression"


    // $ANTLR start "ruleParenExpression"
    // InternalParametricTimedRegularExpression.g:689:1: ruleParenExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Any_3= ruleAny | this_Inverse_4= ruleInverse | this_TimedExpression_5= ruleTimedExpression | this_Event_6= ruleEvent ) ;
    public final EObject ruleParenExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;

        EObject this_Any_3 = null;

        EObject this_Inverse_4 = null;

        EObject this_TimedExpression_5 = null;

        EObject this_Event_6 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:695:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Any_3= ruleAny | this_Inverse_4= ruleInverse | this_TimedExpression_5= ruleTimedExpression | this_Event_6= ruleEvent ) )
            // InternalParametricTimedRegularExpression.g:696:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Any_3= ruleAny | this_Inverse_4= ruleInverse | this_TimedExpression_5= ruleTimedExpression | this_Event_6= ruleEvent )
            {
            // InternalParametricTimedRegularExpression.g:696:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Any_3= ruleAny | this_Inverse_4= ruleInverse | this_TimedExpression_5= ruleTimedExpression | this_Event_6= ruleEvent )
            int alt15=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==RULE_ID||LA15_1==24||LA15_1==28) ) {
                    alt15=1;
                }
                else if ( (LA15_1==26) ) {
                    int LA15_6 = input.LA(3);

                    if ( (LA15_6==RULE_ID||LA15_6==13||(LA15_6>=20 && LA15_6<=26)||LA15_6==28) ) {
                        alt15=1;
                    }
                    else if ( (LA15_6==27) ) {
                        alt15=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 6, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
                }
                break;
            case 26:
                {
                alt15=2;
                }
                break;
            case 28:
                {
                alt15=4;
                }
                break;
            case RULE_ID:
                {
                alt15=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:697:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalParametricTimedRegularExpression.g:697:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalParametricTimedRegularExpression.g:698:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_14); 

                    				newLeafNode(otherlv_0, grammarAccess.getParenExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getParenExpressionAccess().getExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_20);
                    this_Expression_1=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,25,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getParenExpressionAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalParametricTimedRegularExpression.g:716:3: this_Any_3= ruleAny
                    {

                    			newCompositeNode(grammarAccess.getParenExpressionAccess().getAnyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Any_3=ruleAny();

                    state._fsp--;


                    			current = this_Any_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalParametricTimedRegularExpression.g:725:3: this_Inverse_4= ruleInverse
                    {

                    			newCompositeNode(grammarAccess.getParenExpressionAccess().getInverseParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Inverse_4=ruleInverse();

                    state._fsp--;


                    			current = this_Inverse_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalParametricTimedRegularExpression.g:734:3: this_TimedExpression_5= ruleTimedExpression
                    {

                    			newCompositeNode(grammarAccess.getParenExpressionAccess().getTimedExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimedExpression_5=ruleTimedExpression();

                    state._fsp--;


                    			current = this_TimedExpression_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalParametricTimedRegularExpression.g:743:3: this_Event_6= ruleEvent
                    {

                    			newCompositeNode(grammarAccess.getParenExpressionAccess().getEventParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Event_6=ruleEvent();

                    state._fsp--;


                    			current = this_Event_6;
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
    // $ANTLR end "ruleParenExpression"


    // $ANTLR start "entryRuleAny"
    // InternalParametricTimedRegularExpression.g:755:1: entryRuleAny returns [EObject current=null] : iv_ruleAny= ruleAny EOF ;
    public final EObject entryRuleAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAny = null;


        try {
            // InternalParametricTimedRegularExpression.g:755:44: (iv_ruleAny= ruleAny EOF )
            // InternalParametricTimedRegularExpression.g:756:2: iv_ruleAny= ruleAny EOF
            {
             newCompositeNode(grammarAccess.getAnyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAny=ruleAny();

            state._fsp--;

             current =iv_ruleAny; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAny"


    // $ANTLR start "ruleAny"
    // InternalParametricTimedRegularExpression.g:762:1: ruleAny returns [EObject current=null] : ( () otherlv_1= 'S' ) ;
    public final EObject ruleAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:768:2: ( ( () otherlv_1= 'S' ) )
            // InternalParametricTimedRegularExpression.g:769:2: ( () otherlv_1= 'S' )
            {
            // InternalParametricTimedRegularExpression.g:769:2: ( () otherlv_1= 'S' )
            // InternalParametricTimedRegularExpression.g:770:3: () otherlv_1= 'S'
            {
            // InternalParametricTimedRegularExpression.g:770:3: ()
            // InternalParametricTimedRegularExpression.g:771:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAnyAccess().getAnyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getAnyAccess().getSKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAny"


    // $ANTLR start "entryRuleInverse"
    // InternalParametricTimedRegularExpression.g:785:1: entryRuleInverse returns [EObject current=null] : iv_ruleInverse= ruleInverse EOF ;
    public final EObject entryRuleInverse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInverse = null;


        try {
            // InternalParametricTimedRegularExpression.g:785:48: (iv_ruleInverse= ruleInverse EOF )
            // InternalParametricTimedRegularExpression.g:786:2: iv_ruleInverse= ruleInverse EOF
            {
             newCompositeNode(grammarAccess.getInverseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInverse=ruleInverse();

            state._fsp--;

             current =iv_ruleInverse; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInverse"


    // $ANTLR start "ruleInverse"
    // InternalParametricTimedRegularExpression.g:792:1: ruleInverse returns [EObject current=null] : (otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')' ) ;
    public final EObject ruleInverse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_excludes_3_0 = null;

        EObject lv_excludes_5_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:798:2: ( (otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')' ) )
            // InternalParametricTimedRegularExpression.g:799:2: (otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')' )
            {
            // InternalParametricTimedRegularExpression.g:799:2: (otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')' )
            // InternalParametricTimedRegularExpression.g:800:3: otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getInverseAccess().getLeftParenthesisKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getInverseAccess().getSKeyword_1());
            		
            otherlv_2=(Token)match(input,27,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getInverseAccess().getReverseSolidusKeyword_2());
            		
            // InternalParametricTimedRegularExpression.g:812:3: ( (lv_excludes_3_0= ruleEvent ) )
            // InternalParametricTimedRegularExpression.g:813:4: (lv_excludes_3_0= ruleEvent )
            {
            // InternalParametricTimedRegularExpression.g:813:4: (lv_excludes_3_0= ruleEvent )
            // InternalParametricTimedRegularExpression.g:814:5: lv_excludes_3_0= ruleEvent
            {

            					newCompositeNode(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_23);
            lv_excludes_3_0=ruleEvent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInverseRule());
            					}
            					add(
            						current,
            						"excludes",
            						lv_excludes_3_0,
            						"hu.bme.mit.inf.ParametricTimedRegularExpression.Event");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalParametricTimedRegularExpression.g:831:3: (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==14) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:832:4: otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14); 

            	    				newLeafNode(otherlv_4, grammarAccess.getInverseAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalParametricTimedRegularExpression.g:836:4: ( (lv_excludes_5_0= ruleEvent ) )
            	    // InternalParametricTimedRegularExpression.g:837:5: (lv_excludes_5_0= ruleEvent )
            	    {
            	    // InternalParametricTimedRegularExpression.g:837:5: (lv_excludes_5_0= ruleEvent )
            	    // InternalParametricTimedRegularExpression.g:838:6: lv_excludes_5_0= ruleEvent
            	    {

            	    						newCompositeNode(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_excludes_5_0=ruleEvent();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInverseRule());
            	    						}
            	    						add(
            	    							current,
            	    							"excludes",
            	    							lv_excludes_5_0,
            	    							"hu.bme.mit.inf.ParametricTimedRegularExpression.Event");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_6=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getInverseAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInverse"


    // $ANTLR start "entryRuleTimedExpression"
    // InternalParametricTimedRegularExpression.g:864:1: entryRuleTimedExpression returns [EObject current=null] : iv_ruleTimedExpression= ruleTimedExpression EOF ;
    public final EObject entryRuleTimedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimedExpression = null;


        try {
            // InternalParametricTimedRegularExpression.g:864:56: (iv_ruleTimedExpression= ruleTimedExpression EOF )
            // InternalParametricTimedRegularExpression.g:865:2: iv_ruleTimedExpression= ruleTimedExpression EOF
            {
             newCompositeNode(grammarAccess.getTimedExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimedExpression=ruleTimedExpression();

            state._fsp--;

             current =iv_ruleTimedExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimedExpression"


    // $ANTLR start "ruleTimedExpression"
    // InternalParametricTimedRegularExpression.g:871:1: ruleTimedExpression returns [EObject current=null] : (otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']' ) ;
    public final EObject ruleTimedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_timeout_4_0=null;
        Token otherlv_5=null;
        EObject lv_body_1_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:877:2: ( (otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']' ) )
            // InternalParametricTimedRegularExpression.g:878:2: (otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']' )
            {
            // InternalParametricTimedRegularExpression.g:878:2: (otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']' )
            // InternalParametricTimedRegularExpression.g:879:3: otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getTimedExpressionAccess().getLessThanSignKeyword_0());
            		
            // InternalParametricTimedRegularExpression.g:883:3: ( (lv_body_1_0= ruleExpression ) )
            // InternalParametricTimedRegularExpression.g:884:4: (lv_body_1_0= ruleExpression )
            {
            // InternalParametricTimedRegularExpression.g:884:4: (lv_body_1_0= ruleExpression )
            // InternalParametricTimedRegularExpression.g:885:5: lv_body_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getTimedExpressionAccess().getBodyExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
            lv_body_1_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimedExpressionRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_1_0,
            						"hu.bme.mit.inf.ParametricTimedRegularExpression.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getTimedExpressionAccess().getGreaterThanSignKeyword_2());
            		
            otherlv_3=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getTimedExpressionAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalParametricTimedRegularExpression.g:910:3: ( (lv_timeout_4_0= RULE_INT ) )
            // InternalParametricTimedRegularExpression.g:911:4: (lv_timeout_4_0= RULE_INT )
            {
            // InternalParametricTimedRegularExpression.g:911:4: (lv_timeout_4_0= RULE_INT )
            // InternalParametricTimedRegularExpression.g:912:5: lv_timeout_4_0= RULE_INT
            {
            lv_timeout_4_0=(Token)match(input,RULE_INT,FOLLOW_26); 

            					newLeafNode(lv_timeout_4_0, grammarAccess.getTimedExpressionAccess().getTimeoutINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimedExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"timeout",
            						lv_timeout_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTimedExpressionAccess().getRightSquareBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimedExpression"


    // $ANTLR start "entryRuleEvent"
    // InternalParametricTimedRegularExpression.g:936:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalParametricTimedRegularExpression.g:936:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalParametricTimedRegularExpression.g:937:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalParametricTimedRegularExpression.g:943:1: ruleEvent returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )? ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:949:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )? ) )
            // InternalParametricTimedRegularExpression.g:950:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )? )
            {
            // InternalParametricTimedRegularExpression.g:950:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )? )
            // InternalParametricTimedRegularExpression.g:951:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )?
            {
            // InternalParametricTimedRegularExpression.g:951:3: ( (otherlv_0= RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:952:4: (otherlv_0= RULE_ID )
            {
            // InternalParametricTimedRegularExpression.g:952:4: (otherlv_0= RULE_ID )
            // InternalParametricTimedRegularExpression.g:953:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(otherlv_0, grammarAccess.getEventAccess().getFunctorFunctorCrossReference_0_0());
            				

            }


            }

            // InternalParametricTimedRegularExpression.g:964:3: (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:965:4: otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_28); 

                    				newLeafNode(otherlv_1, grammarAccess.getEventAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalParametricTimedRegularExpression.g:969:4: ( (lv_parameters_2_0= ruleParameter ) )
                    // InternalParametricTimedRegularExpression.g:970:5: (lv_parameters_2_0= ruleParameter )
                    {
                    // InternalParametricTimedRegularExpression.g:970:5: (lv_parameters_2_0= ruleParameter )
                    // InternalParametricTimedRegularExpression.g:971:6: lv_parameters_2_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_parameters_2_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_2_0,
                    							"hu.bme.mit.inf.ParametricTimedRegularExpression.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalParametricTimedRegularExpression.g:988:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==14) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalParametricTimedRegularExpression.g:989:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,14,FOLLOW_28); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getEventAccess().getCommaKeyword_1_2_0());
                    	    				
                    	    // InternalParametricTimedRegularExpression.g:993:5: ( (lv_parameters_4_0= ruleParameter ) )
                    	    // InternalParametricTimedRegularExpression.g:994:6: (lv_parameters_4_0= ruleParameter )
                    	    {
                    	    // InternalParametricTimedRegularExpression.g:994:6: (lv_parameters_4_0= ruleParameter )
                    	    // InternalParametricTimedRegularExpression.g:995:7: lv_parameters_4_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_parameters_4_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEventRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_4_0,
                    	    								"hu.bme.mit.inf.ParametricTimedRegularExpression.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getEventAccess().getRightSquareBracketKeyword_1_3());
                    			

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
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleParameter"
    // InternalParametricTimedRegularExpression.g:1022:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalParametricTimedRegularExpression.g:1022:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalParametricTimedRegularExpression.g:1023:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalParametricTimedRegularExpression.g:1029:1: ruleParameter returns [EObject current=null] : (this_VarParameter_0= ruleVarParameter | this_SingletonParameter_1= ruleSingletonParameter | this_FixParameter_2= ruleFixParameter ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject this_VarParameter_0 = null;

        EObject this_SingletonParameter_1 = null;

        EObject this_FixParameter_2 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:1035:2: ( (this_VarParameter_0= ruleVarParameter | this_SingletonParameter_1= ruleSingletonParameter | this_FixParameter_2= ruleFixParameter ) )
            // InternalParametricTimedRegularExpression.g:1036:2: (this_VarParameter_0= ruleVarParameter | this_SingletonParameter_1= ruleSingletonParameter | this_FixParameter_2= ruleFixParameter )
            {
            // InternalParametricTimedRegularExpression.g:1036:2: (this_VarParameter_0= ruleVarParameter | this_SingletonParameter_1= ruleSingletonParameter | this_FixParameter_2= ruleFixParameter )
            int alt19=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt19=1;
                }
                break;
            case 30:
                {
                alt19=2;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:1037:3: this_VarParameter_0= ruleVarParameter
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getVarParameterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_VarParameter_0=ruleVarParameter();

                    state._fsp--;


                    			current = this_VarParameter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalParametricTimedRegularExpression.g:1046:3: this_SingletonParameter_1= ruleSingletonParameter
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getSingletonParameterParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SingletonParameter_1=ruleSingletonParameter();

                    state._fsp--;


                    			current = this_SingletonParameter_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalParametricTimedRegularExpression.g:1055:3: this_FixParameter_2= ruleFixParameter
                    {

                    			newCompositeNode(grammarAccess.getParameterAccess().getFixParameterParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_FixParameter_2=ruleFixParameter();

                    state._fsp--;


                    			current = this_FixParameter_2;
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleFixParameter"
    // InternalParametricTimedRegularExpression.g:1067:1: entryRuleFixParameter returns [EObject current=null] : iv_ruleFixParameter= ruleFixParameter EOF ;
    public final EObject entryRuleFixParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixParameter = null;


        try {
            // InternalParametricTimedRegularExpression.g:1067:53: (iv_ruleFixParameter= ruleFixParameter EOF )
            // InternalParametricTimedRegularExpression.g:1068:2: iv_ruleFixParameter= ruleFixParameter EOF
            {
             newCompositeNode(grammarAccess.getFixParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFixParameter=ruleFixParameter();

            state._fsp--;

             current =iv_ruleFixParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFixParameter"


    // $ANTLR start "ruleFixParameter"
    // InternalParametricTimedRegularExpression.g:1074:1: ruleFixParameter returns [EObject current=null] : (this_FixIntParameter_0= ruleFixIntParameter | this_FixStringParameter_1= ruleFixStringParameter ) ;
    public final EObject ruleFixParameter() throws RecognitionException {
        EObject current = null;

        EObject this_FixIntParameter_0 = null;

        EObject this_FixStringParameter_1 = null;



        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:1080:2: ( (this_FixIntParameter_0= ruleFixIntParameter | this_FixStringParameter_1= ruleFixStringParameter ) )
            // InternalParametricTimedRegularExpression.g:1081:2: (this_FixIntParameter_0= ruleFixIntParameter | this_FixStringParameter_1= ruleFixStringParameter )
            {
            // InternalParametricTimedRegularExpression.g:1081:2: (this_FixIntParameter_0= ruleFixIntParameter | this_FixStringParameter_1= ruleFixStringParameter )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_STRING) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:1082:3: this_FixIntParameter_0= ruleFixIntParameter
                    {

                    			newCompositeNode(grammarAccess.getFixParameterAccess().getFixIntParameterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FixIntParameter_0=ruleFixIntParameter();

                    state._fsp--;


                    			current = this_FixIntParameter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalParametricTimedRegularExpression.g:1091:3: this_FixStringParameter_1= ruleFixStringParameter
                    {

                    			newCompositeNode(grammarAccess.getFixParameterAccess().getFixStringParameterParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FixStringParameter_1=ruleFixStringParameter();

                    state._fsp--;


                    			current = this_FixStringParameter_1;
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
    // $ANTLR end "ruleFixParameter"


    // $ANTLR start "entryRuleFixIntParameter"
    // InternalParametricTimedRegularExpression.g:1103:1: entryRuleFixIntParameter returns [EObject current=null] : iv_ruleFixIntParameter= ruleFixIntParameter EOF ;
    public final EObject entryRuleFixIntParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixIntParameter = null;


        try {
            // InternalParametricTimedRegularExpression.g:1103:56: (iv_ruleFixIntParameter= ruleFixIntParameter EOF )
            // InternalParametricTimedRegularExpression.g:1104:2: iv_ruleFixIntParameter= ruleFixIntParameter EOF
            {
             newCompositeNode(grammarAccess.getFixIntParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFixIntParameter=ruleFixIntParameter();

            state._fsp--;

             current =iv_ruleFixIntParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFixIntParameter"


    // $ANTLR start "ruleFixIntParameter"
    // InternalParametricTimedRegularExpression.g:1110:1: ruleFixIntParameter returns [EObject current=null] : ( (lv_body_0_0= RULE_INT ) ) ;
    public final EObject ruleFixIntParameter() throws RecognitionException {
        EObject current = null;

        Token lv_body_0_0=null;


        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:1116:2: ( ( (lv_body_0_0= RULE_INT ) ) )
            // InternalParametricTimedRegularExpression.g:1117:2: ( (lv_body_0_0= RULE_INT ) )
            {
            // InternalParametricTimedRegularExpression.g:1117:2: ( (lv_body_0_0= RULE_INT ) )
            // InternalParametricTimedRegularExpression.g:1118:3: (lv_body_0_0= RULE_INT )
            {
            // InternalParametricTimedRegularExpression.g:1118:3: (lv_body_0_0= RULE_INT )
            // InternalParametricTimedRegularExpression.g:1119:4: lv_body_0_0= RULE_INT
            {
            lv_body_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_body_0_0, grammarAccess.getFixIntParameterAccess().getBodyINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getFixIntParameterRule());
            				}
            				setWithLastConsumed(
            					current,
            					"body",
            					lv_body_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

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
    // $ANTLR end "ruleFixIntParameter"


    // $ANTLR start "entryRuleFixStringParameter"
    // InternalParametricTimedRegularExpression.g:1138:1: entryRuleFixStringParameter returns [EObject current=null] : iv_ruleFixStringParameter= ruleFixStringParameter EOF ;
    public final EObject entryRuleFixStringParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixStringParameter = null;


        try {
            // InternalParametricTimedRegularExpression.g:1138:59: (iv_ruleFixStringParameter= ruleFixStringParameter EOF )
            // InternalParametricTimedRegularExpression.g:1139:2: iv_ruleFixStringParameter= ruleFixStringParameter EOF
            {
             newCompositeNode(grammarAccess.getFixStringParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFixStringParameter=ruleFixStringParameter();

            state._fsp--;

             current =iv_ruleFixStringParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFixStringParameter"


    // $ANTLR start "ruleFixStringParameter"
    // InternalParametricTimedRegularExpression.g:1145:1: ruleFixStringParameter returns [EObject current=null] : ( (lv_body_0_0= RULE_STRING ) ) ;
    public final EObject ruleFixStringParameter() throws RecognitionException {
        EObject current = null;

        Token lv_body_0_0=null;


        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:1151:2: ( ( (lv_body_0_0= RULE_STRING ) ) )
            // InternalParametricTimedRegularExpression.g:1152:2: ( (lv_body_0_0= RULE_STRING ) )
            {
            // InternalParametricTimedRegularExpression.g:1152:2: ( (lv_body_0_0= RULE_STRING ) )
            // InternalParametricTimedRegularExpression.g:1153:3: (lv_body_0_0= RULE_STRING )
            {
            // InternalParametricTimedRegularExpression.g:1153:3: (lv_body_0_0= RULE_STRING )
            // InternalParametricTimedRegularExpression.g:1154:4: lv_body_0_0= RULE_STRING
            {
            lv_body_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_body_0_0, grammarAccess.getFixStringParameterAccess().getBodySTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getFixStringParameterRule());
            				}
            				setWithLastConsumed(
            					current,
            					"body",
            					lv_body_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

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
    // $ANTLR end "ruleFixStringParameter"


    // $ANTLR start "entryRuleVarParameter"
    // InternalParametricTimedRegularExpression.g:1173:1: entryRuleVarParameter returns [EObject current=null] : iv_ruleVarParameter= ruleVarParameter EOF ;
    public final EObject entryRuleVarParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarParameter = null;


        try {
            // InternalParametricTimedRegularExpression.g:1173:53: (iv_ruleVarParameter= ruleVarParameter EOF )
            // InternalParametricTimedRegularExpression.g:1174:2: iv_ruleVarParameter= ruleVarParameter EOF
            {
             newCompositeNode(grammarAccess.getVarParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarParameter=ruleVarParameter();

            state._fsp--;

             current =iv_ruleVarParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarParameter"


    // $ANTLR start "ruleVarParameter"
    // InternalParametricTimedRegularExpression.g:1180:1: ruleVarParameter returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVarParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:1186:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalParametricTimedRegularExpression.g:1187:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalParametricTimedRegularExpression.g:1187:2: ( (otherlv_0= RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:1188:3: (otherlv_0= RULE_ID )
            {
            // InternalParametricTimedRegularExpression.g:1188:3: (otherlv_0= RULE_ID )
            // InternalParametricTimedRegularExpression.g:1189:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVarParameterRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getVarParameterAccess().getVarVarCrossReference_0());
            			

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
    // $ANTLR end "ruleVarParameter"


    // $ANTLR start "entryRuleSingletonParameter"
    // InternalParametricTimedRegularExpression.g:1203:1: entryRuleSingletonParameter returns [EObject current=null] : iv_ruleSingletonParameter= ruleSingletonParameter EOF ;
    public final EObject entryRuleSingletonParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonParameter = null;


        try {
            // InternalParametricTimedRegularExpression.g:1203:59: (iv_ruleSingletonParameter= ruleSingletonParameter EOF )
            // InternalParametricTimedRegularExpression.g:1204:2: iv_ruleSingletonParameter= ruleSingletonParameter EOF
            {
             newCompositeNode(grammarAccess.getSingletonParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingletonParameter=ruleSingletonParameter();

            state._fsp--;

             current =iv_ruleSingletonParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingletonParameter"


    // $ANTLR start "ruleSingletonParameter"
    // InternalParametricTimedRegularExpression.g:1210:1: ruleSingletonParameter returns [EObject current=null] : ( () otherlv_1= '_' ) ;
    public final EObject ruleSingletonParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:1216:2: ( ( () otherlv_1= '_' ) )
            // InternalParametricTimedRegularExpression.g:1217:2: ( () otherlv_1= '_' )
            {
            // InternalParametricTimedRegularExpression.g:1217:2: ( () otherlv_1= '_' )
            // InternalParametricTimedRegularExpression.g:1218:3: () otherlv_1= '_'
            {
            // InternalParametricTimedRegularExpression.g:1218:3: ()
            // InternalParametricTimedRegularExpression.g:1219:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSingletonParameterAccess().getSingletonParameterAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSingletonParameterAccess().get_Keyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingletonParameter"


    // $ANTLR start "entryRuleVar"
    // InternalParametricTimedRegularExpression.g:1233:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // InternalParametricTimedRegularExpression.g:1233:44: (iv_ruleVar= ruleVar EOF )
            // InternalParametricTimedRegularExpression.g:1234:2: iv_ruleVar= ruleVar EOF
            {
             newCompositeNode(grammarAccess.getVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVar=ruleVar();

            state._fsp--;

             current =iv_ruleVar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVar"


    // $ANTLR start "ruleVar"
    // InternalParametricTimedRegularExpression.g:1240:1: ruleVar returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalParametricTimedRegularExpression.g:1246:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalParametricTimedRegularExpression.g:1247:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalParametricTimedRegularExpression.g:1247:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:1248:3: (lv_name_0_0= RULE_ID )
            {
            // InternalParametricTimedRegularExpression.g:1248:3: (lv_name_0_0= RULE_ID )
            // InternalParametricTimedRegularExpression.g:1249:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getVarAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVarRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"hu.bme.mit.inf.ParametricTimedRegularExpression.ID");
            			

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
    // $ANTLR end "ruleVar"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000084000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000015000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000015000012L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000C02002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000070L});

}