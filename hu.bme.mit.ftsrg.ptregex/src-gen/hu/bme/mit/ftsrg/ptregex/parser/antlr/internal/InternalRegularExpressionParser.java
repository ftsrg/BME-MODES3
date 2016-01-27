package hu.bme.mit.ftsrg.ptregex.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.ftsrg.ptregex.services.RegularExpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRegularExpressionParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alphabet'", "'='", "'{'", "','", "'}'", "'/'", "'expression'", "'['", "']'", "'|'", "'*'", "'+'", "'('", "')'", "'S'", "'\\\\'", "'<'", "'>'", "'_'"
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


        public InternalRegularExpressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRegularExpressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRegularExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g"; }



     	private RegularExpressionGrammarAccess grammarAccess;
     	
        public InternalRegularExpressionParser(TokenStream input, RegularExpressionGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RegexModel";	
       	}
       	
       	@Override
       	protected RegularExpressionGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRegexModel"
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:67:1: entryRuleRegexModel returns [EObject current=null] : iv_ruleRegexModel= ruleRegexModel EOF ;
    public final EObject entryRuleRegexModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexModel = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:68:2: (iv_ruleRegexModel= ruleRegexModel EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:69:2: iv_ruleRegexModel= ruleRegexModel EOF
            {
             newCompositeNode(grammarAccess.getRegexModelRule()); 
            pushFollow(FOLLOW_ruleRegexModel_in_entryRuleRegexModel75);
            iv_ruleRegexModel=ruleRegexModel();

            state._fsp--;

             current =iv_ruleRegexModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegexModel85); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:76:1: ruleRegexModel returns [EObject current=null] : ( ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )* ) ;
    public final EObject ruleRegexModel() throws RecognitionException {
        EObject current = null;

        EObject lv_alphabet_0_0 = null;

        EObject lv_declarations_1_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:79:28: ( ( ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )* ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:80:1: ( ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )* )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:80:1: ( ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )* )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:80:2: ( (lv_alphabet_0_0= ruleAlphabet ) )? ( (lv_declarations_1_0= ruleExpressionDeclaration ) )*
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:80:2: ( (lv_alphabet_0_0= ruleAlphabet ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:81:1: (lv_alphabet_0_0= ruleAlphabet )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:81:1: (lv_alphabet_0_0= ruleAlphabet )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:82:3: lv_alphabet_0_0= ruleAlphabet
                    {
                     
                    	        newCompositeNode(grammarAccess.getRegexModelAccess().getAlphabetAlphabetParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAlphabet_in_ruleRegexModel131);
                    lv_alphabet_0_0=ruleAlphabet();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRegexModelRule());
                    	        }
                           		set(
                           			current, 
                           			"alphabet",
                            		lv_alphabet_0_0, 
                            		"Alphabet");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:98:3: ( (lv_declarations_1_0= ruleExpressionDeclaration ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:99:1: (lv_declarations_1_0= ruleExpressionDeclaration )
            	    {
            	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:99:1: (lv_declarations_1_0= ruleExpressionDeclaration )
            	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:100:3: lv_declarations_1_0= ruleExpressionDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRegexModelAccess().getDeclarationsExpressionDeclarationParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpressionDeclaration_in_ruleRegexModel153);
            	    lv_declarations_1_0=ruleExpressionDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRegexModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"declarations",
            	            		lv_declarations_1_0, 
            	            		"ExpressionDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleRegexModel"


    // $ANTLR start "entryRuleAlphabet"
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:124:1: entryRuleAlphabet returns [EObject current=null] : iv_ruleAlphabet= ruleAlphabet EOF ;
    public final EObject entryRuleAlphabet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlphabet = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:125:2: (iv_ruleAlphabet= ruleAlphabet EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:126:2: iv_ruleAlphabet= ruleAlphabet EOF
            {
             newCompositeNode(grammarAccess.getAlphabetRule()); 
            pushFollow(FOLLOW_ruleAlphabet_in_entryRuleAlphabet190);
            iv_ruleAlphabet=ruleAlphabet();

            state._fsp--;

             current =iv_ruleAlphabet; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlphabet200); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:133:1: ruleAlphabet returns [EObject current=null] : ( () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}' ) ;
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
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:136:28: ( ( () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}' ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:137:1: ( () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}' )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:137:1: ( () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}' )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:137:2: () otherlv_1= 'alphabet' otherlv_2= '=' otherlv_3= '{' ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )? otherlv_7= '}'
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:137:2: ()
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:138:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAlphabetAccess().getAlphabetAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleAlphabet246); 

                	newLeafNode(otherlv_1, grammarAccess.getAlphabetAccess().getAlphabetKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleAlphabet258); 

                	newLeafNode(otherlv_2, grammarAccess.getAlphabetAccess().getEqualsSignKeyword_2());
                
            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleAlphabet270); 

                	newLeafNode(otherlv_3, grammarAccess.getAlphabetAccess().getLeftCurlyBracketKeyword_3());
                
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:155:1: ( ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:155:2: ( (lv_functors_4_0= ruleFunctor ) ) (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )*
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:155:2: ( (lv_functors_4_0= ruleFunctor ) )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:156:1: (lv_functors_4_0= ruleFunctor )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:156:1: (lv_functors_4_0= ruleFunctor )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:157:3: lv_functors_4_0= ruleFunctor
                    {
                     
                    	        newCompositeNode(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFunctor_in_ruleAlphabet292);
                    lv_functors_4_0=ruleFunctor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAlphabetRule());
                    	        }
                           		add(
                           			current, 
                           			"functors",
                            		lv_functors_4_0, 
                            		"Functor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:173:2: (otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==14) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:173:4: otherlv_5= ',' ( (lv_functors_6_0= ruleFunctor ) )
                    	    {
                    	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAlphabet305); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getAlphabetAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:177:1: ( (lv_functors_6_0= ruleFunctor ) )
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:178:1: (lv_functors_6_0= ruleFunctor )
                    	    {
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:178:1: (lv_functors_6_0= ruleFunctor )
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:179:3: lv_functors_6_0= ruleFunctor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFunctor_in_ruleAlphabet326);
                    	    lv_functors_6_0=ruleFunctor();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAlphabetRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"functors",
                    	            		lv_functors_6_0, 
                    	            		"Functor");
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

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAlphabet342); 

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:207:1: entryRuleFunctor returns [EObject current=null] : iv_ruleFunctor= ruleFunctor EOF ;
    public final EObject entryRuleFunctor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctor = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:208:2: (iv_ruleFunctor= ruleFunctor EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:209:2: iv_ruleFunctor= ruleFunctor EOF
            {
             newCompositeNode(grammarAccess.getFunctorRule()); 
            pushFollow(FOLLOW_ruleFunctor_in_entryRuleFunctor378);
            iv_ruleFunctor=ruleFunctor();

            state._fsp--;

             current =iv_ruleFunctor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctor388); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:216:1: ruleFunctor returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )? ) ;
    public final EObject ruleFunctor() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_arity_2_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:219:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )? ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:220:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:220:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )? )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:220:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )?
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:220:2: ( (lv_name_0_0= RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:221:1: (lv_name_0_0= RULE_ID )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:221:1: (lv_name_0_0= RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:222:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctor430); 

            			newLeafNode(lv_name_0_0, grammarAccess.getFunctorAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:238:2: (otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:238:4: otherlv_1= '/' ( (lv_arity_2_0= RULE_INT ) )
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleFunctor448); 

                        	newLeafNode(otherlv_1, grammarAccess.getFunctorAccess().getSolidusKeyword_1_0());
                        
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:242:1: ( (lv_arity_2_0= RULE_INT ) )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:243:1: (lv_arity_2_0= RULE_INT )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:243:1: (lv_arity_2_0= RULE_INT )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:244:3: lv_arity_2_0= RULE_INT
                    {
                    lv_arity_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFunctor465); 

                    			newLeafNode(lv_arity_2_0, grammarAccess.getFunctorAccess().getArityINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFunctorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"arity",
                            		lv_arity_2_0, 
                            		"INT");
                    	    

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:268:1: entryRuleExpressionDeclaration returns [EObject current=null] : iv_ruleExpressionDeclaration= ruleExpressionDeclaration EOF ;
    public final EObject entryRuleExpressionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionDeclaration = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:269:2: (iv_ruleExpressionDeclaration= ruleExpressionDeclaration EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:270:2: iv_ruleExpressionDeclaration= ruleExpressionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getExpressionDeclarationRule()); 
            pushFollow(FOLLOW_ruleExpressionDeclaration_in_entryRuleExpressionDeclaration508);
            iv_ruleExpressionDeclaration=ruleExpressionDeclaration();

            state._fsp--;

             current =iv_ruleExpressionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionDeclaration518); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:277:1: ruleExpressionDeclaration returns [EObject current=null] : (otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) ) ) ;
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
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:280:28: ( (otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) ) ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:281:1: (otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:281:1: (otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:281:3: otherlv_0= 'expression' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )? otherlv_7= '=' ( (lv_body_8_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleExpressionDeclaration555); 

                	newLeafNode(otherlv_0, grammarAccess.getExpressionDeclarationAccess().getExpressionKeyword_0());
                
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:285:1: ( (lv_name_1_0= RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:286:1: (lv_name_1_0= RULE_ID )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:286:1: (lv_name_1_0= RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:287:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExpressionDeclaration572); 

            			newLeafNode(lv_name_1_0, grammarAccess.getExpressionDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExpressionDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:303:2: (otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:303:4: otherlv_2= '[' ( (lv_vars_3_0= ruleVar ) ) (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleExpressionDeclaration590); 

                        	newLeafNode(otherlv_2, grammarAccess.getExpressionDeclarationAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:307:1: ( (lv_vars_3_0= ruleVar ) )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:308:1: (lv_vars_3_0= ruleVar )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:308:1: (lv_vars_3_0= ruleVar )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:309:3: lv_vars_3_0= ruleVar
                    {
                     
                    	        newCompositeNode(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVar_in_ruleExpressionDeclaration611);
                    lv_vars_3_0=ruleVar();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExpressionDeclarationRule());
                    	        }
                           		add(
                           			current, 
                           			"vars",
                            		lv_vars_3_0, 
                            		"Var");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:325:2: (otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==14) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:325:4: otherlv_4= ',' ( (lv_vars_5_0= ruleVar ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleExpressionDeclaration624); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getExpressionDeclarationAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:329:1: ( (lv_vars_5_0= ruleVar ) )
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:330:1: (lv_vars_5_0= ruleVar )
                    	    {
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:330:1: (lv_vars_5_0= ruleVar )
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:331:3: lv_vars_5_0= ruleVar
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVar_in_ruleExpressionDeclaration645);
                    	    lv_vars_5_0=ruleVar();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getExpressionDeclarationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"vars",
                    	            		lv_vars_5_0, 
                    	            		"Var");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleExpressionDeclaration659); 

                        	newLeafNode(otherlv_6, grammarAccess.getExpressionDeclarationAccess().getRightSquareBracketKeyword_2_3());
                        

                    }
                    break;

            }

            otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleExpressionDeclaration673); 

                	newLeafNode(otherlv_7, grammarAccess.getExpressionDeclarationAccess().getEqualsSignKeyword_3());
                
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:355:1: ( (lv_body_8_0= ruleExpression ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:356:1: (lv_body_8_0= ruleExpression )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:356:1: (lv_body_8_0= ruleExpression )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:357:3: lv_body_8_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionDeclarationAccess().getBodyExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionDeclaration694);
            lv_body_8_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"body",
                    		lv_body_8_0, 
                    		"Expression");
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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:381:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:382:2: (iv_ruleExpression= ruleExpression EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:383:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression730);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression740); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:390:1: ruleExpression returns [EObject current=null] : this_Choice_0= ruleChoice ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Choice_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:393:28: (this_Choice_0= ruleChoice )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:395:5: this_Choice_0= ruleChoice
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getChoiceParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleChoice_in_ruleExpression786);
            this_Choice_0=ruleChoice();

            state._fsp--;

             
                    current = this_Choice_0; 
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


    // $ANTLR start "entryRuleChoice"
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:411:1: entryRuleChoice returns [EObject current=null] : iv_ruleChoice= ruleChoice EOF ;
    public final EObject entryRuleChoice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoice = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:412:2: (iv_ruleChoice= ruleChoice EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:413:2: iv_ruleChoice= ruleChoice EOF
            {
             newCompositeNode(grammarAccess.getChoiceRule()); 
            pushFollow(FOLLOW_ruleChoice_in_entryRuleChoice820);
            iv_ruleChoice=ruleChoice();

            state._fsp--;

             current =iv_ruleChoice; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoice830); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:420:1: ruleChoice returns [EObject current=null] : (this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )? ) ;
    public final EObject ruleChoice() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Sequence_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:423:28: ( (this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )? ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:424:1: (this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:424:1: (this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )? )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:425:5: this_Sequence_0= ruleSequence ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getChoiceAccess().getSequenceParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleSequence_in_ruleChoice877);
            this_Sequence_0=ruleSequence();

            state._fsp--;

             
                    current = this_Sequence_0; 
                    afterParserOrEnumRuleCall();
                
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:433:1: ( () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:433:2: () (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:433:2: ()
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:434:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getChoiceAccess().getChoiceElementsAction_1_0(),
                                current);
                        

                    }

                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:439:2: (otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) ) )+
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
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:439:4: otherlv_2= '|' ( (lv_elements_3_0= ruleSequence ) )
                    	    {
                    	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleChoice899); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getChoiceAccess().getVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:443:1: ( (lv_elements_3_0= ruleSequence ) )
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:444:1: (lv_elements_3_0= ruleSequence )
                    	    {
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:444:1: (lv_elements_3_0= ruleSequence )
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:445:3: lv_elements_3_0= ruleSequence
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getChoiceAccess().getElementsSequenceParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSequence_in_ruleChoice920);
                    	    lv_elements_3_0=ruleSequence();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getChoiceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_3_0, 
                    	            		"Sequence");
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
    // $ANTLR end "ruleChoice"


    // $ANTLR start "entryRuleSequence"
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:469:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:470:2: (iv_ruleSequence= ruleSequence EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:471:2: iv_ruleSequence= ruleSequence EOF
            {
             newCompositeNode(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence960);
            iv_ruleSequence=ruleSequence();

            state._fsp--;

             current =iv_ruleSequence; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence970); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:478:1: ruleSequence returns [EObject current=null] : (this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )? ) ;
    public final EObject ruleSequence() throws RecognitionException {
        EObject current = null;

        EObject this_MultExpression_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:481:28: ( (this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )? ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:482:1: (this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:482:1: (this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )? )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:483:5: this_MultExpression_0= ruleMultExpression ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getSequenceAccess().getMultExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleMultExpression_in_ruleSequence1017);
            this_MultExpression_0=ruleMultExpression();

            state._fsp--;

             
                    current = this_MultExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:491:1: ( () ( (lv_elements_2_0= ruleMultExpression ) )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==23||LA11_0==25||LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:491:2: () ( (lv_elements_2_0= ruleMultExpression ) )+
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:491:2: ()
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:492:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getSequenceAccess().getSequenceElementsAction_1_0(),
                                current);
                        

                    }

                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:497:2: ( (lv_elements_2_0= ruleMultExpression ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID||LA10_0==23||LA10_0==25||LA10_0==27) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:498:1: (lv_elements_2_0= ruleMultExpression )
                    	    {
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:498:1: (lv_elements_2_0= ruleMultExpression )
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:499:3: lv_elements_2_0= ruleMultExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSequenceAccess().getElementsMultExpressionParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultExpression_in_ruleSequence1047);
                    	    lv_elements_2_0=ruleMultExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSequenceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_2_0, 
                    	            		"MultExpression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleMultExpression"
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:523:1: entryRuleMultExpression returns [EObject current=null] : iv_ruleMultExpression= ruleMultExpression EOF ;
    public final EObject entryRuleMultExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultExpression = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:524:2: (iv_ruleMultExpression= ruleMultExpression EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:525:2: iv_ruleMultExpression= ruleMultExpression EOF
            {
             newCompositeNode(grammarAccess.getMultExpressionRule()); 
            pushFollow(FOLLOW_ruleMultExpression_in_entryRuleMultExpression1086);
            iv_ruleMultExpression=ruleMultExpression();

            state._fsp--;

             current =iv_ruleMultExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultExpression1096); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:532:1: ruleMultExpression returns [EObject current=null] : (this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )? ) ;
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
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:535:28: ( (this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )? ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:536:1: (this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:536:1: (this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )? )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:537:5: this_ParenExpression_0= ruleParenExpression ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )?
            {
             
                    newCompositeNode(grammarAccess.getMultExpressionAccess().getParenExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleParenExpression_in_ruleMultExpression1143);
            this_ParenExpression_0=ruleParenExpression();

            state._fsp--;

             
                    current = this_ParenExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:545:1: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '+' ) | ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' ) )?
            int alt12=4;
            switch ( input.LA(1) ) {
                case 21:
                    {
                    alt12=1;
                    }
                    break;
                case 22:
                    {
                    alt12=2;
                    }
                    break;
                case 13:
                    {
                    alt12=3;
                    }
                    break;
            }

            switch (alt12) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:545:2: ( () otherlv_2= '*' )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:545:2: ( () otherlv_2= '*' )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:545:3: () otherlv_2= '*'
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:545:3: ()
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:546:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getMultExpressionAccess().getStarBodyAction_1_0_0(),
                                current);
                        

                    }

                    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleMultExpression1165); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultExpressionAccess().getAsteriskKeyword_1_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:556:6: ( () otherlv_4= '+' )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:556:6: ( () otherlv_4= '+' )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:556:7: () otherlv_4= '+'
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:556:7: ()
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:557:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getMultExpressionAccess().getPlusBodyAction_1_1_0(),
                                current);
                        

                    }

                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleMultExpression1194); 

                        	newLeafNode(otherlv_4, grammarAccess.getMultExpressionAccess().getPlusSignKeyword_1_1_1());
                        

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:567:6: ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:567:6: ( () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}' )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:567:7: () otherlv_6= '{' ( (lv_n_7_0= RULE_INT ) ) otherlv_8= '}'
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:567:7: ()
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:568:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getMultExpressionAccess().getCardinalityBodyAction_1_2_0(),
                                current);
                        

                    }

                    otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleMultExpression1223); 

                        	newLeafNode(otherlv_6, grammarAccess.getMultExpressionAccess().getLeftCurlyBracketKeyword_1_2_1());
                        
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:577:1: ( (lv_n_7_0= RULE_INT ) )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:578:1: (lv_n_7_0= RULE_INT )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:578:1: (lv_n_7_0= RULE_INT )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:579:3: lv_n_7_0= RULE_INT
                    {
                    lv_n_7_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleMultExpression1240); 

                    			newLeafNode(lv_n_7_0, grammarAccess.getMultExpressionAccess().getNINTTerminalRuleCall_1_2_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"n",
                            		lv_n_7_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleMultExpression1257); 

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:607:1: entryRuleParenExpression returns [EObject current=null] : iv_ruleParenExpression= ruleParenExpression EOF ;
    public final EObject entryRuleParenExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenExpression = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:608:2: (iv_ruleParenExpression= ruleParenExpression EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:609:2: iv_ruleParenExpression= ruleParenExpression EOF
            {
             newCompositeNode(grammarAccess.getParenExpressionRule()); 
            pushFollow(FOLLOW_ruleParenExpression_in_entryRuleParenExpression1296);
            iv_ruleParenExpression=ruleParenExpression();

            state._fsp--;

             current =iv_ruleParenExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenExpression1306); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:616:1: ruleParenExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Any_3= ruleAny | this_Inverse_4= ruleInverse | this_TimedExpression_5= ruleTimedExpression | this_Event_6= ruleEvent ) ;
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
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:619:28: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Any_3= ruleAny | this_Inverse_4= ruleInverse | this_TimedExpression_5= ruleTimedExpression | this_Event_6= ruleEvent ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:620:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Any_3= ruleAny | this_Inverse_4= ruleInverse | this_TimedExpression_5= ruleTimedExpression | this_Event_6= ruleEvent )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:620:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Any_3= ruleAny | this_Inverse_4= ruleInverse | this_TimedExpression_5= ruleTimedExpression | this_Event_6= ruleEvent )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==25) ) {
                    int LA13_5 = input.LA(3);

                    if ( (LA13_5==RULE_ID||LA13_5==13||(LA13_5>=20 && LA13_5<=25)||LA13_5==27) ) {
                        alt13=1;
                    }
                    else if ( (LA13_5==26) ) {
                        alt13=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 5, input);

                        throw nvae;
                    }
                }
                else if ( (LA13_1==RULE_ID||LA13_1==23||LA13_1==27) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case 25:
                {
                alt13=2;
                }
                break;
            case 27:
                {
                alt13=4;
                }
                break;
            case RULE_ID:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:620:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:620:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:620:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleParenExpression1344); 

                        	newLeafNode(otherlv_0, grammarAccess.getParenExpressionAccess().getLeftParenthesisKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getParenExpressionAccess().getExpressionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleParenExpression1366);
                    this_Expression_1=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_1; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleParenExpression1377); 

                        	newLeafNode(otherlv_2, grammarAccess.getParenExpressionAccess().getRightParenthesisKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:639:5: this_Any_3= ruleAny
                    {
                     
                            newCompositeNode(grammarAccess.getParenExpressionAccess().getAnyParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAny_in_ruleParenExpression1406);
                    this_Any_3=ruleAny();

                    state._fsp--;

                     
                            current = this_Any_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:649:5: this_Inverse_4= ruleInverse
                    {
                     
                            newCompositeNode(grammarAccess.getParenExpressionAccess().getInverseParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInverse_in_ruleParenExpression1433);
                    this_Inverse_4=ruleInverse();

                    state._fsp--;

                     
                            current = this_Inverse_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:659:5: this_TimedExpression_5= ruleTimedExpression
                    {
                     
                            newCompositeNode(grammarAccess.getParenExpressionAccess().getTimedExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleTimedExpression_in_ruleParenExpression1460);
                    this_TimedExpression_5=ruleTimedExpression();

                    state._fsp--;

                     
                            current = this_TimedExpression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:669:5: this_Event_6= ruleEvent
                    {
                     
                            newCompositeNode(grammarAccess.getParenExpressionAccess().getEventParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleEvent_in_ruleParenExpression1487);
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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:685:1: entryRuleAny returns [EObject current=null] : iv_ruleAny= ruleAny EOF ;
    public final EObject entryRuleAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAny = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:686:2: (iv_ruleAny= ruleAny EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:687:2: iv_ruleAny= ruleAny EOF
            {
             newCompositeNode(grammarAccess.getAnyRule()); 
            pushFollow(FOLLOW_ruleAny_in_entryRuleAny1522);
            iv_ruleAny=ruleAny();

            state._fsp--;

             current =iv_ruleAny; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAny1532); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:694:1: ruleAny returns [EObject current=null] : ( () otherlv_1= 'S' ) ;
    public final EObject ruleAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:697:28: ( ( () otherlv_1= 'S' ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:698:1: ( () otherlv_1= 'S' )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:698:1: ( () otherlv_1= 'S' )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:698:2: () otherlv_1= 'S'
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:698:2: ()
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:699:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAnyAccess().getAnyAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleAny1578); 

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:716:1: entryRuleInverse returns [EObject current=null] : iv_ruleInverse= ruleInverse EOF ;
    public final EObject entryRuleInverse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInverse = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:717:2: (iv_ruleInverse= ruleInverse EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:718:2: iv_ruleInverse= ruleInverse EOF
            {
             newCompositeNode(grammarAccess.getInverseRule()); 
            pushFollow(FOLLOW_ruleInverse_in_entryRuleInverse1614);
            iv_ruleInverse=ruleInverse();

            state._fsp--;

             current =iv_ruleInverse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInverse1624); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:725:1: ruleInverse returns [EObject current=null] : (otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')' ) ;
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
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:728:28: ( (otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')' ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:729:1: (otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')' )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:729:1: (otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')' )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:729:3: otherlv_0= '(' otherlv_1= 'S' otherlv_2= '\\\\' ( (lv_excludes_3_0= ruleEvent ) ) (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )* otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleInverse1661); 

                	newLeafNode(otherlv_0, grammarAccess.getInverseAccess().getLeftParenthesisKeyword_0());
                
            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleInverse1673); 

                	newLeafNode(otherlv_1, grammarAccess.getInverseAccess().getSKeyword_1());
                
            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleInverse1685); 

                	newLeafNode(otherlv_2, grammarAccess.getInverseAccess().getReverseSolidusKeyword_2());
                
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:741:1: ( (lv_excludes_3_0= ruleEvent ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:742:1: (lv_excludes_3_0= ruleEvent )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:742:1: (lv_excludes_3_0= ruleEvent )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:743:3: lv_excludes_3_0= ruleEvent
            {
             
            	        newCompositeNode(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleEvent_in_ruleInverse1706);
            lv_excludes_3_0=ruleEvent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInverseRule());
            	        }
                   		add(
                   			current, 
                   			"excludes",
                    		lv_excludes_3_0, 
                    		"Event");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:759:2: (otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==14) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:759:4: otherlv_4= ',' ( (lv_excludes_5_0= ruleEvent ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleInverse1719); 

            	        	newLeafNode(otherlv_4, grammarAccess.getInverseAccess().getCommaKeyword_4_0());
            	        
            	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:763:1: ( (lv_excludes_5_0= ruleEvent ) )
            	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:764:1: (lv_excludes_5_0= ruleEvent )
            	    {
            	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:764:1: (lv_excludes_5_0= ruleEvent )
            	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:765:3: lv_excludes_5_0= ruleEvent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEvent_in_ruleInverse1740);
            	    lv_excludes_5_0=ruleEvent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInverseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"excludes",
            	            		lv_excludes_5_0, 
            	            		"Event");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleInverse1754); 

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:793:1: entryRuleTimedExpression returns [EObject current=null] : iv_ruleTimedExpression= ruleTimedExpression EOF ;
    public final EObject entryRuleTimedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimedExpression = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:794:2: (iv_ruleTimedExpression= ruleTimedExpression EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:795:2: iv_ruleTimedExpression= ruleTimedExpression EOF
            {
             newCompositeNode(grammarAccess.getTimedExpressionRule()); 
            pushFollow(FOLLOW_ruleTimedExpression_in_entryRuleTimedExpression1790);
            iv_ruleTimedExpression=ruleTimedExpression();

            state._fsp--;

             current =iv_ruleTimedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimedExpression1800); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:802:1: ruleTimedExpression returns [EObject current=null] : (otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']' ) ;
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
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:805:28: ( (otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']' ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:806:1: (otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']' )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:806:1: (otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']' )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:806:3: otherlv_0= '<' ( (lv_body_1_0= ruleExpression ) ) otherlv_2= '>' otherlv_3= '[' ( (lv_timeout_4_0= RULE_INT ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleTimedExpression1837); 

                	newLeafNode(otherlv_0, grammarAccess.getTimedExpressionAccess().getLessThanSignKeyword_0());
                
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:810:1: ( (lv_body_1_0= ruleExpression ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:811:1: (lv_body_1_0= ruleExpression )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:811:1: (lv_body_1_0= ruleExpression )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:812:3: lv_body_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getTimedExpressionAccess().getBodyExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleTimedExpression1858);
            lv_body_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTimedExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"body",
                    		lv_body_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleTimedExpression1870); 

                	newLeafNode(otherlv_2, grammarAccess.getTimedExpressionAccess().getGreaterThanSignKeyword_2());
                
            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleTimedExpression1882); 

                	newLeafNode(otherlv_3, grammarAccess.getTimedExpressionAccess().getLeftSquareBracketKeyword_3());
                
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:836:1: ( (lv_timeout_4_0= RULE_INT ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:837:1: (lv_timeout_4_0= RULE_INT )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:837:1: (lv_timeout_4_0= RULE_INT )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:838:3: lv_timeout_4_0= RULE_INT
            {
            lv_timeout_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTimedExpression1899); 

            			newLeafNode(lv_timeout_4_0, grammarAccess.getTimedExpressionAccess().getTimeoutINTTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTimedExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeout",
                    		lv_timeout_4_0, 
                    		"INT");
            	    

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleTimedExpression1916); 

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:866:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:867:2: (iv_ruleEvent= ruleEvent EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:868:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent1952);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent1962); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:875:1: ruleEvent returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )? ) ;
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
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:878:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )? ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:879:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:879:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )? )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:879:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )?
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:879:2: ( (otherlv_0= RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:880:1: (otherlv_0= RULE_ID )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:880:1: (otherlv_0= RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:881:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEventRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent2007); 

            		newLeafNode(otherlv_0, grammarAccess.getEventAccess().getFunctorFunctorCrossReference_0_0()); 
            	

            }


            }

            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:892:2: (otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==18) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:892:4: otherlv_1= '[' ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleEvent2020); 

                        	newLeafNode(otherlv_1, grammarAccess.getEventAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:896:1: ( (lv_parameters_2_0= ruleParameter ) )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:897:1: (lv_parameters_2_0= ruleParameter )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:897:1: (lv_parameters_2_0= ruleParameter )
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:898:3: lv_parameters_2_0= ruleParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParameter_in_ruleEvent2041);
                    lv_parameters_2_0=ruleParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEventRule());
                    	        }
                           		add(
                           			current, 
                           			"parameters",
                            		lv_parameters_2_0, 
                            		"Parameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:914:2: (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==14) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:914:4: otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleEvent2054); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getEventAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:918:1: ( (lv_parameters_4_0= ruleParameter ) )
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:919:1: (lv_parameters_4_0= ruleParameter )
                    	    {
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:919:1: (lv_parameters_4_0= ruleParameter )
                    	    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:920:3: lv_parameters_4_0= ruleParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameter_in_ruleEvent2075);
                    	    lv_parameters_4_0=ruleParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEventRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parameters",
                    	            		lv_parameters_4_0, 
                    	            		"Parameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleEvent2089); 

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:948:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:949:2: (iv_ruleParameter= ruleParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:950:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter2127);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter2137); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:957:1: ruleParameter returns [EObject current=null] : (this_VarParameter_0= ruleVarParameter | this_SingletonParameter_1= ruleSingletonParameter | this_FixParameter_2= ruleFixParameter ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject this_VarParameter_0 = null;

        EObject this_SingletonParameter_1 = null;

        EObject this_FixParameter_2 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:960:28: ( (this_VarParameter_0= ruleVarParameter | this_SingletonParameter_1= ruleSingletonParameter | this_FixParameter_2= ruleFixParameter ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:961:1: (this_VarParameter_0= ruleVarParameter | this_SingletonParameter_1= ruleSingletonParameter | this_FixParameter_2= ruleFixParameter )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:961:1: (this_VarParameter_0= ruleVarParameter | this_SingletonParameter_1= ruleSingletonParameter | this_FixParameter_2= ruleFixParameter )
            int alt17=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt17=1;
                }
                break;
            case 29:
                {
                alt17=2;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:962:5: this_VarParameter_0= ruleVarParameter
                    {
                     
                            newCompositeNode(grammarAccess.getParameterAccess().getVarParameterParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVarParameter_in_ruleParameter2184);
                    this_VarParameter_0=ruleVarParameter();

                    state._fsp--;

                     
                            current = this_VarParameter_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:972:5: this_SingletonParameter_1= ruleSingletonParameter
                    {
                     
                            newCompositeNode(grammarAccess.getParameterAccess().getSingletonParameterParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSingletonParameter_in_ruleParameter2211);
                    this_SingletonParameter_1=ruleSingletonParameter();

                    state._fsp--;

                     
                            current = this_SingletonParameter_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:982:5: this_FixParameter_2= ruleFixParameter
                    {
                     
                            newCompositeNode(grammarAccess.getParameterAccess().getFixParameterParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleFixParameter_in_ruleParameter2238);
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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:998:1: entryRuleFixParameter returns [EObject current=null] : iv_ruleFixParameter= ruleFixParameter EOF ;
    public final EObject entryRuleFixParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixParameter = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:999:2: (iv_ruleFixParameter= ruleFixParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1000:2: iv_ruleFixParameter= ruleFixParameter EOF
            {
             newCompositeNode(grammarAccess.getFixParameterRule()); 
            pushFollow(FOLLOW_ruleFixParameter_in_entryRuleFixParameter2273);
            iv_ruleFixParameter=ruleFixParameter();

            state._fsp--;

             current =iv_ruleFixParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixParameter2283); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1007:1: ruleFixParameter returns [EObject current=null] : (this_FixIntParameter_0= ruleFixIntParameter | this_FixStringParameter_1= ruleFixStringParameter ) ;
    public final EObject ruleFixParameter() throws RecognitionException {
        EObject current = null;

        EObject this_FixIntParameter_0 = null;

        EObject this_FixStringParameter_1 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1010:28: ( (this_FixIntParameter_0= ruleFixIntParameter | this_FixStringParameter_1= ruleFixStringParameter ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1011:1: (this_FixIntParameter_0= ruleFixIntParameter | this_FixStringParameter_1= ruleFixStringParameter )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1011:1: (this_FixIntParameter_0= ruleFixIntParameter | this_FixStringParameter_1= ruleFixStringParameter )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INT) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_STRING) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1012:5: this_FixIntParameter_0= ruleFixIntParameter
                    {
                     
                            newCompositeNode(grammarAccess.getFixParameterAccess().getFixIntParameterParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixIntParameter_in_ruleFixParameter2330);
                    this_FixIntParameter_0=ruleFixIntParameter();

                    state._fsp--;

                     
                            current = this_FixIntParameter_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1022:5: this_FixStringParameter_1= ruleFixStringParameter
                    {
                     
                            newCompositeNode(grammarAccess.getFixParameterAccess().getFixStringParameterParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleFixStringParameter_in_ruleFixParameter2357);
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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1038:1: entryRuleFixIntParameter returns [EObject current=null] : iv_ruleFixIntParameter= ruleFixIntParameter EOF ;
    public final EObject entryRuleFixIntParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixIntParameter = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1039:2: (iv_ruleFixIntParameter= ruleFixIntParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1040:2: iv_ruleFixIntParameter= ruleFixIntParameter EOF
            {
             newCompositeNode(grammarAccess.getFixIntParameterRule()); 
            pushFollow(FOLLOW_ruleFixIntParameter_in_entryRuleFixIntParameter2392);
            iv_ruleFixIntParameter=ruleFixIntParameter();

            state._fsp--;

             current =iv_ruleFixIntParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixIntParameter2402); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1047:1: ruleFixIntParameter returns [EObject current=null] : ( (lv_body_0_0= RULE_INT ) ) ;
    public final EObject ruleFixIntParameter() throws RecognitionException {
        EObject current = null;

        Token lv_body_0_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1050:28: ( ( (lv_body_0_0= RULE_INT ) ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1051:1: ( (lv_body_0_0= RULE_INT ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1051:1: ( (lv_body_0_0= RULE_INT ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1052:1: (lv_body_0_0= RULE_INT )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1052:1: (lv_body_0_0= RULE_INT )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1053:3: lv_body_0_0= RULE_INT
            {
            lv_body_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFixIntParameter2443); 

            			newLeafNode(lv_body_0_0, grammarAccess.getFixIntParameterAccess().getBodyINTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFixIntParameterRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"body",
                    		lv_body_0_0, 
                    		"INT");
            	    

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1077:1: entryRuleFixStringParameter returns [EObject current=null] : iv_ruleFixStringParameter= ruleFixStringParameter EOF ;
    public final EObject entryRuleFixStringParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixStringParameter = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1078:2: (iv_ruleFixStringParameter= ruleFixStringParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1079:2: iv_ruleFixStringParameter= ruleFixStringParameter EOF
            {
             newCompositeNode(grammarAccess.getFixStringParameterRule()); 
            pushFollow(FOLLOW_ruleFixStringParameter_in_entryRuleFixStringParameter2483);
            iv_ruleFixStringParameter=ruleFixStringParameter();

            state._fsp--;

             current =iv_ruleFixStringParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixStringParameter2493); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1086:1: ruleFixStringParameter returns [EObject current=null] : ( (lv_body_0_0= RULE_STRING ) ) ;
    public final EObject ruleFixStringParameter() throws RecognitionException {
        EObject current = null;

        Token lv_body_0_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1089:28: ( ( (lv_body_0_0= RULE_STRING ) ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1090:1: ( (lv_body_0_0= RULE_STRING ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1090:1: ( (lv_body_0_0= RULE_STRING ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1091:1: (lv_body_0_0= RULE_STRING )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1091:1: (lv_body_0_0= RULE_STRING )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1092:3: lv_body_0_0= RULE_STRING
            {
            lv_body_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFixStringParameter2534); 

            			newLeafNode(lv_body_0_0, grammarAccess.getFixStringParameterAccess().getBodySTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFixStringParameterRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"body",
                    		lv_body_0_0, 
                    		"STRING");
            	    

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1116:1: entryRuleVarParameter returns [EObject current=null] : iv_ruleVarParameter= ruleVarParameter EOF ;
    public final EObject entryRuleVarParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarParameter = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1117:2: (iv_ruleVarParameter= ruleVarParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1118:2: iv_ruleVarParameter= ruleVarParameter EOF
            {
             newCompositeNode(grammarAccess.getVarParameterRule()); 
            pushFollow(FOLLOW_ruleVarParameter_in_entryRuleVarParameter2574);
            iv_ruleVarParameter=ruleVarParameter();

            state._fsp--;

             current =iv_ruleVarParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarParameter2584); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1125:1: ruleVarParameter returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVarParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1128:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1129:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1129:1: ( (otherlv_0= RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1130:1: (otherlv_0= RULE_ID )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1130:1: (otherlv_0= RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1131:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVarParameterRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarParameter2628); 

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1150:1: entryRuleSingletonParameter returns [EObject current=null] : iv_ruleSingletonParameter= ruleSingletonParameter EOF ;
    public final EObject entryRuleSingletonParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonParameter = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1151:2: (iv_ruleSingletonParameter= ruleSingletonParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1152:2: iv_ruleSingletonParameter= ruleSingletonParameter EOF
            {
             newCompositeNode(grammarAccess.getSingletonParameterRule()); 
            pushFollow(FOLLOW_ruleSingletonParameter_in_entryRuleSingletonParameter2663);
            iv_ruleSingletonParameter=ruleSingletonParameter();

            state._fsp--;

             current =iv_ruleSingletonParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingletonParameter2673); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1159:1: ruleSingletonParameter returns [EObject current=null] : ( () otherlv_1= '_' ) ;
    public final EObject ruleSingletonParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1162:28: ( ( () otherlv_1= '_' ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1163:1: ( () otherlv_1= '_' )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1163:1: ( () otherlv_1= '_' )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1163:2: () otherlv_1= '_'
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1163:2: ()
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1164:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSingletonParameterAccess().getSingletonParameterAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleSingletonParameter2719); 

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1181:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1182:2: (iv_ruleVar= ruleVar EOF )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1183:2: iv_ruleVar= ruleVar EOF
            {
             newCompositeNode(grammarAccess.getVarRule()); 
            pushFollow(FOLLOW_ruleVar_in_entryRuleVar2755);
            iv_ruleVar=ruleVar();

            state._fsp--;

             current =iv_ruleVar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVar2765); 

            }

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
    // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1190:1: ruleVar returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1193:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1194:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1194:1: ( (lv_name_0_0= RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1195:1: (lv_name_0_0= RULE_ID )
            {
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1195:1: (lv_name_0_0= RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex/src-gen/hu/bme/mit/ftsrg/ptregex/parser/antlr/internal/InternalRegularExpression.g:1196:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVar2806); 

            			newLeafNode(lv_name_0_0, grammarAccess.getVarAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVarRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

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


 

    public static final BitSet FOLLOW_ruleRegexModel_in_entryRuleRegexModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegexModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlphabet_in_ruleRegexModel131 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleExpressionDeclaration_in_ruleRegexModel153 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleAlphabet_in_entryRuleAlphabet190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlphabet200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAlphabet246 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAlphabet258 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAlphabet270 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleFunctor_in_ruleAlphabet292 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleAlphabet305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFunctor_in_ruleAlphabet326 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleAlphabet342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctor_in_entryRuleFunctor378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctor388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctor430 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFunctor448 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFunctor465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionDeclaration_in_entryRuleExpressionDeclaration508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionDeclaration518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleExpressionDeclaration555 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExpressionDeclaration572 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_18_in_ruleExpressionDeclaration590 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVar_in_ruleExpressionDeclaration611 = new BitSet(new long[]{0x0000000000084000L});
    public static final BitSet FOLLOW_14_in_ruleExpressionDeclaration624 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVar_in_ruleExpressionDeclaration645 = new BitSet(new long[]{0x0000000000084000L});
    public static final BitSet FOLLOW_19_in_ruleExpressionDeclaration659 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleExpressionDeclaration673 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionDeclaration694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoice_in_ruleExpression786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoice_in_entryRuleChoice820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoice830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_ruleChoice877 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleChoice899 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_ruleSequence_in_ruleChoice920 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultExpression_in_ruleSequence1017 = new BitSet(new long[]{0x000000000A800012L});
    public static final BitSet FOLLOW_ruleMultExpression_in_ruleSequence1047 = new BitSet(new long[]{0x000000000A800012L});
    public static final BitSet FOLLOW_ruleMultExpression_in_entryRuleMultExpression1086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultExpression1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenExpression_in_ruleMultExpression1143 = new BitSet(new long[]{0x0000000000602002L});
    public static final BitSet FOLLOW_21_in_ruleMultExpression1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleMultExpression1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleMultExpression1223 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleMultExpression1240 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMultExpression1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenExpression_in_entryRuleParenExpression1296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenExpression1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleParenExpression1344 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenExpression1366 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleParenExpression1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAny_in_ruleParenExpression1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInverse_in_ruleParenExpression1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimedExpression_in_ruleParenExpression1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleParenExpression1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAny_in_entryRuleAny1522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAny1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleAny1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInverse_in_entryRuleInverse1614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInverse1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleInverse1661 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleInverse1673 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleInverse1685 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleInverse1706 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_14_in_ruleInverse1719 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleInverse1740 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_24_in_ruleInverse1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimedExpression_in_entryRuleTimedExpression1790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimedExpression1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTimedExpression1837 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleTimedExpression1858 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTimedExpression1870 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTimedExpression1882 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTimedExpression1899 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTimedExpression1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent1952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent2007 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleEvent2020 = new BitSet(new long[]{0x0000000020000070L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleEvent2041 = new BitSet(new long[]{0x0000000000084000L});
    public static final BitSet FOLLOW_14_in_ruleEvent2054 = new BitSet(new long[]{0x0000000020000070L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleEvent2075 = new BitSet(new long[]{0x0000000000084000L});
    public static final BitSet FOLLOW_19_in_ruleEvent2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarParameter_in_ruleParameter2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingletonParameter_in_ruleParameter2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixParameter_in_ruleParameter2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixParameter_in_entryRuleFixParameter2273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixParameter2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixIntParameter_in_ruleFixParameter2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixStringParameter_in_ruleFixParameter2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixIntParameter_in_entryRuleFixIntParameter2392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixIntParameter2402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFixIntParameter2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixStringParameter_in_entryRuleFixStringParameter2483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixStringParameter2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFixStringParameter2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarParameter_in_entryRuleVarParameter2574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarParameter2584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarParameter2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingletonParameter_in_entryRuleSingletonParameter2663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingletonParameter2673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleSingletonParameter2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_entryRuleVar2755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVar2765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVar2806 = new BitSet(new long[]{0x0000000000000002L});

}