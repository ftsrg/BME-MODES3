package hu.bme.mit.ftsrg.ptregex.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import hu.bme.mit.ftsrg.ptregex.services.RegularExpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRegularExpressionParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alphabet'", "'='", "'{'", "'}'", "','", "'/'", "'expression'", "'['", "']'", "'|'", "'*'", "'+'", "'('", "')'", "'S'", "'\\\\'", "'<'", "'>'", "'_'"
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
    public String getGrammarFileName() { return "../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g"; }


     
     	private RegularExpressionGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(RegularExpressionGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleRegexModel"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:60:1: entryRuleRegexModel : ruleRegexModel EOF ;
    public final void entryRuleRegexModel() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:61:1: ( ruleRegexModel EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:62:1: ruleRegexModel EOF
            {
             before(grammarAccess.getRegexModelRule()); 
            pushFollow(FOLLOW_ruleRegexModel_in_entryRuleRegexModel61);
            ruleRegexModel();

            state._fsp--;

             after(grammarAccess.getRegexModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegexModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegexModel"


    // $ANTLR start "ruleRegexModel"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:69:1: ruleRegexModel : ( ( rule__RegexModel__Group__0 ) ) ;
    public final void ruleRegexModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:73:2: ( ( ( rule__RegexModel__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:74:1: ( ( rule__RegexModel__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:74:1: ( ( rule__RegexModel__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:75:1: ( rule__RegexModel__Group__0 )
            {
             before(grammarAccess.getRegexModelAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:76:1: ( rule__RegexModel__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:76:2: rule__RegexModel__Group__0
            {
            pushFollow(FOLLOW_rule__RegexModel__Group__0_in_ruleRegexModel94);
            rule__RegexModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRegexModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegexModel"


    // $ANTLR start "entryRuleAlphabet"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:88:1: entryRuleAlphabet : ruleAlphabet EOF ;
    public final void entryRuleAlphabet() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:89:1: ( ruleAlphabet EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:90:1: ruleAlphabet EOF
            {
             before(grammarAccess.getAlphabetRule()); 
            pushFollow(FOLLOW_ruleAlphabet_in_entryRuleAlphabet121);
            ruleAlphabet();

            state._fsp--;

             after(grammarAccess.getAlphabetRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlphabet128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAlphabet"


    // $ANTLR start "ruleAlphabet"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:97:1: ruleAlphabet : ( ( rule__Alphabet__Group__0 ) ) ;
    public final void ruleAlphabet() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:101:2: ( ( ( rule__Alphabet__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:102:1: ( ( rule__Alphabet__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:102:1: ( ( rule__Alphabet__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:103:1: ( rule__Alphabet__Group__0 )
            {
             before(grammarAccess.getAlphabetAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:104:1: ( rule__Alphabet__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:104:2: rule__Alphabet__Group__0
            {
            pushFollow(FOLLOW_rule__Alphabet__Group__0_in_ruleAlphabet154);
            rule__Alphabet__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlphabetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlphabet"


    // $ANTLR start "entryRuleFunctor"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:116:1: entryRuleFunctor : ruleFunctor EOF ;
    public final void entryRuleFunctor() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:117:1: ( ruleFunctor EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:118:1: ruleFunctor EOF
            {
             before(grammarAccess.getFunctorRule()); 
            pushFollow(FOLLOW_ruleFunctor_in_entryRuleFunctor181);
            ruleFunctor();

            state._fsp--;

             after(grammarAccess.getFunctorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctor188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunctor"


    // $ANTLR start "ruleFunctor"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:125:1: ruleFunctor : ( ( rule__Functor__Group__0 ) ) ;
    public final void ruleFunctor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:129:2: ( ( ( rule__Functor__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:130:1: ( ( rule__Functor__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:130:1: ( ( rule__Functor__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:131:1: ( rule__Functor__Group__0 )
            {
             before(grammarAccess.getFunctorAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:132:1: ( rule__Functor__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:132:2: rule__Functor__Group__0
            {
            pushFollow(FOLLOW_rule__Functor__Group__0_in_ruleFunctor214);
            rule__Functor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunctorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunctor"


    // $ANTLR start "entryRuleExpressionDeclaration"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:144:1: entryRuleExpressionDeclaration : ruleExpressionDeclaration EOF ;
    public final void entryRuleExpressionDeclaration() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:145:1: ( ruleExpressionDeclaration EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:146:1: ruleExpressionDeclaration EOF
            {
             before(grammarAccess.getExpressionDeclarationRule()); 
            pushFollow(FOLLOW_ruleExpressionDeclaration_in_entryRuleExpressionDeclaration241);
            ruleExpressionDeclaration();

            state._fsp--;

             after(grammarAccess.getExpressionDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionDeclaration248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpressionDeclaration"


    // $ANTLR start "ruleExpressionDeclaration"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:153:1: ruleExpressionDeclaration : ( ( rule__ExpressionDeclaration__Group__0 ) ) ;
    public final void ruleExpressionDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:157:2: ( ( ( rule__ExpressionDeclaration__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:158:1: ( ( rule__ExpressionDeclaration__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:158:1: ( ( rule__ExpressionDeclaration__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:159:1: ( rule__ExpressionDeclaration__Group__0 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:160:1: ( rule__ExpressionDeclaration__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:160:2: rule__ExpressionDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__0_in_ruleExpressionDeclaration274);
            rule__ExpressionDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpressionDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpressionDeclaration"


    // $ANTLR start "entryRuleExpression"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:172:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:173:1: ( ruleExpression EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:174:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression301);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:181:1: ruleExpression : ( ruleChoice ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:185:2: ( ( ruleChoice ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:186:1: ( ruleChoice )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:186:1: ( ruleChoice )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:187:1: ruleChoice
            {
             before(grammarAccess.getExpressionAccess().getChoiceParserRuleCall()); 
            pushFollow(FOLLOW_ruleChoice_in_ruleExpression334);
            ruleChoice();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getChoiceParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleChoice"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:200:1: entryRuleChoice : ruleChoice EOF ;
    public final void entryRuleChoice() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:201:1: ( ruleChoice EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:202:1: ruleChoice EOF
            {
             before(grammarAccess.getChoiceRule()); 
            pushFollow(FOLLOW_ruleChoice_in_entryRuleChoice360);
            ruleChoice();

            state._fsp--;

             after(grammarAccess.getChoiceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoice367); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleChoice"


    // $ANTLR start "ruleChoice"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:209:1: ruleChoice : ( ( rule__Choice__Group__0 ) ) ;
    public final void ruleChoice() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:213:2: ( ( ( rule__Choice__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:214:1: ( ( rule__Choice__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:214:1: ( ( rule__Choice__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:215:1: ( rule__Choice__Group__0 )
            {
             before(grammarAccess.getChoiceAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:216:1: ( rule__Choice__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:216:2: rule__Choice__Group__0
            {
            pushFollow(FOLLOW_rule__Choice__Group__0_in_ruleChoice393);
            rule__Choice__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChoiceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChoice"


    // $ANTLR start "entryRuleSequence"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:228:1: entryRuleSequence : ruleSequence EOF ;
    public final void entryRuleSequence() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:229:1: ( ruleSequence EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:230:1: ruleSequence EOF
            {
             before(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence420);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getSequenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence427); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:237:1: ruleSequence : ( ( rule__Sequence__Group__0 ) ) ;
    public final void ruleSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:241:2: ( ( ( rule__Sequence__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:242:1: ( ( rule__Sequence__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:242:1: ( ( rule__Sequence__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:243:1: ( rule__Sequence__Group__0 )
            {
             before(grammarAccess.getSequenceAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:244:1: ( rule__Sequence__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:244:2: rule__Sequence__Group__0
            {
            pushFollow(FOLLOW_rule__Sequence__Group__0_in_ruleSequence453);
            rule__Sequence__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleMultExpression"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:256:1: entryRuleMultExpression : ruleMultExpression EOF ;
    public final void entryRuleMultExpression() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:257:1: ( ruleMultExpression EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:258:1: ruleMultExpression EOF
            {
             before(grammarAccess.getMultExpressionRule()); 
            pushFollow(FOLLOW_ruleMultExpression_in_entryRuleMultExpression480);
            ruleMultExpression();

            state._fsp--;

             after(grammarAccess.getMultExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultExpression487); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultExpression"


    // $ANTLR start "ruleMultExpression"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:265:1: ruleMultExpression : ( ( rule__MultExpression__Group__0 ) ) ;
    public final void ruleMultExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:269:2: ( ( ( rule__MultExpression__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:270:1: ( ( rule__MultExpression__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:270:1: ( ( rule__MultExpression__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:271:1: ( rule__MultExpression__Group__0 )
            {
             before(grammarAccess.getMultExpressionAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:272:1: ( rule__MultExpression__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:272:2: rule__MultExpression__Group__0
            {
            pushFollow(FOLLOW_rule__MultExpression__Group__0_in_ruleMultExpression513);
            rule__MultExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultExpression"


    // $ANTLR start "entryRuleParenExpression"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:284:1: entryRuleParenExpression : ruleParenExpression EOF ;
    public final void entryRuleParenExpression() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:285:1: ( ruleParenExpression EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:286:1: ruleParenExpression EOF
            {
             before(grammarAccess.getParenExpressionRule()); 
            pushFollow(FOLLOW_ruleParenExpression_in_entryRuleParenExpression540);
            ruleParenExpression();

            state._fsp--;

             after(grammarAccess.getParenExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenExpression547); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParenExpression"


    // $ANTLR start "ruleParenExpression"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:293:1: ruleParenExpression : ( ( rule__ParenExpression__Alternatives ) ) ;
    public final void ruleParenExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:297:2: ( ( ( rule__ParenExpression__Alternatives ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:298:1: ( ( rule__ParenExpression__Alternatives ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:298:1: ( ( rule__ParenExpression__Alternatives ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:299:1: ( rule__ParenExpression__Alternatives )
            {
             before(grammarAccess.getParenExpressionAccess().getAlternatives()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:300:1: ( rule__ParenExpression__Alternatives )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:300:2: rule__ParenExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__ParenExpression__Alternatives_in_ruleParenExpression573);
            rule__ParenExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParenExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenExpression"


    // $ANTLR start "entryRuleAny"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:312:1: entryRuleAny : ruleAny EOF ;
    public final void entryRuleAny() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:313:1: ( ruleAny EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:314:1: ruleAny EOF
            {
             before(grammarAccess.getAnyRule()); 
            pushFollow(FOLLOW_ruleAny_in_entryRuleAny600);
            ruleAny();

            state._fsp--;

             after(grammarAccess.getAnyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAny607); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAny"


    // $ANTLR start "ruleAny"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:321:1: ruleAny : ( ( rule__Any__Group__0 ) ) ;
    public final void ruleAny() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:325:2: ( ( ( rule__Any__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:326:1: ( ( rule__Any__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:326:1: ( ( rule__Any__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:327:1: ( rule__Any__Group__0 )
            {
             before(grammarAccess.getAnyAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:328:1: ( rule__Any__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:328:2: rule__Any__Group__0
            {
            pushFollow(FOLLOW_rule__Any__Group__0_in_ruleAny633);
            rule__Any__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAnyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAny"


    // $ANTLR start "entryRuleInverse"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:340:1: entryRuleInverse : ruleInverse EOF ;
    public final void entryRuleInverse() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:341:1: ( ruleInverse EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:342:1: ruleInverse EOF
            {
             before(grammarAccess.getInverseRule()); 
            pushFollow(FOLLOW_ruleInverse_in_entryRuleInverse660);
            ruleInverse();

            state._fsp--;

             after(grammarAccess.getInverseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInverse667); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInverse"


    // $ANTLR start "ruleInverse"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:349:1: ruleInverse : ( ( rule__Inverse__Group__0 ) ) ;
    public final void ruleInverse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:353:2: ( ( ( rule__Inverse__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:354:1: ( ( rule__Inverse__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:354:1: ( ( rule__Inverse__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:355:1: ( rule__Inverse__Group__0 )
            {
             before(grammarAccess.getInverseAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:356:1: ( rule__Inverse__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:356:2: rule__Inverse__Group__0
            {
            pushFollow(FOLLOW_rule__Inverse__Group__0_in_ruleInverse693);
            rule__Inverse__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInverseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInverse"


    // $ANTLR start "entryRuleTimedExpression"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:368:1: entryRuleTimedExpression : ruleTimedExpression EOF ;
    public final void entryRuleTimedExpression() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:369:1: ( ruleTimedExpression EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:370:1: ruleTimedExpression EOF
            {
             before(grammarAccess.getTimedExpressionRule()); 
            pushFollow(FOLLOW_ruleTimedExpression_in_entryRuleTimedExpression720);
            ruleTimedExpression();

            state._fsp--;

             after(grammarAccess.getTimedExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimedExpression727); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTimedExpression"


    // $ANTLR start "ruleTimedExpression"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:377:1: ruleTimedExpression : ( ( rule__TimedExpression__Group__0 ) ) ;
    public final void ruleTimedExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:381:2: ( ( ( rule__TimedExpression__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:382:1: ( ( rule__TimedExpression__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:382:1: ( ( rule__TimedExpression__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:383:1: ( rule__TimedExpression__Group__0 )
            {
             before(grammarAccess.getTimedExpressionAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:384:1: ( rule__TimedExpression__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:384:2: rule__TimedExpression__Group__0
            {
            pushFollow(FOLLOW_rule__TimedExpression__Group__0_in_ruleTimedExpression753);
            rule__TimedExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimedExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTimedExpression"


    // $ANTLR start "entryRuleEvent"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:396:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:397:1: ( ruleEvent EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:398:1: ruleEvent EOF
            {
             before(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent780);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getEventRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent787); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:405:1: ruleEvent : ( ( rule__Event__Group__0 ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:409:2: ( ( ( rule__Event__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:410:1: ( ( rule__Event__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:410:1: ( ( rule__Event__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:411:1: ( rule__Event__Group__0 )
            {
             before(grammarAccess.getEventAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:412:1: ( rule__Event__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:412:2: rule__Event__Group__0
            {
            pushFollow(FOLLOW_rule__Event__Group__0_in_ruleEvent813);
            rule__Event__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:424:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:425:1: ( ruleParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:426:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter840);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter847); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:433:1: ruleParameter : ( ( rule__Parameter__Alternatives ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:437:2: ( ( ( rule__Parameter__Alternatives ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:438:1: ( ( rule__Parameter__Alternatives ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:438:1: ( ( rule__Parameter__Alternatives ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:439:1: ( rule__Parameter__Alternatives )
            {
             before(grammarAccess.getParameterAccess().getAlternatives()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:440:1: ( rule__Parameter__Alternatives )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:440:2: rule__Parameter__Alternatives
            {
            pushFollow(FOLLOW_rule__Parameter__Alternatives_in_ruleParameter873);
            rule__Parameter__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleFixParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:452:1: entryRuleFixParameter : ruleFixParameter EOF ;
    public final void entryRuleFixParameter() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:453:1: ( ruleFixParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:454:1: ruleFixParameter EOF
            {
             before(grammarAccess.getFixParameterRule()); 
            pushFollow(FOLLOW_ruleFixParameter_in_entryRuleFixParameter900);
            ruleFixParameter();

            state._fsp--;

             after(grammarAccess.getFixParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixParameter907); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFixParameter"


    // $ANTLR start "ruleFixParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:461:1: ruleFixParameter : ( ( rule__FixParameter__Alternatives ) ) ;
    public final void ruleFixParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:465:2: ( ( ( rule__FixParameter__Alternatives ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:466:1: ( ( rule__FixParameter__Alternatives ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:466:1: ( ( rule__FixParameter__Alternatives ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:467:1: ( rule__FixParameter__Alternatives )
            {
             before(grammarAccess.getFixParameterAccess().getAlternatives()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:468:1: ( rule__FixParameter__Alternatives )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:468:2: rule__FixParameter__Alternatives
            {
            pushFollow(FOLLOW_rule__FixParameter__Alternatives_in_ruleFixParameter933);
            rule__FixParameter__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFixParameterAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFixParameter"


    // $ANTLR start "entryRuleFixIntParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:480:1: entryRuleFixIntParameter : ruleFixIntParameter EOF ;
    public final void entryRuleFixIntParameter() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:481:1: ( ruleFixIntParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:482:1: ruleFixIntParameter EOF
            {
             before(grammarAccess.getFixIntParameterRule()); 
            pushFollow(FOLLOW_ruleFixIntParameter_in_entryRuleFixIntParameter960);
            ruleFixIntParameter();

            state._fsp--;

             after(grammarAccess.getFixIntParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixIntParameter967); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFixIntParameter"


    // $ANTLR start "ruleFixIntParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:489:1: ruleFixIntParameter : ( ( rule__FixIntParameter__BodyAssignment ) ) ;
    public final void ruleFixIntParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:493:2: ( ( ( rule__FixIntParameter__BodyAssignment ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:494:1: ( ( rule__FixIntParameter__BodyAssignment ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:494:1: ( ( rule__FixIntParameter__BodyAssignment ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:495:1: ( rule__FixIntParameter__BodyAssignment )
            {
             before(grammarAccess.getFixIntParameterAccess().getBodyAssignment()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:496:1: ( rule__FixIntParameter__BodyAssignment )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:496:2: rule__FixIntParameter__BodyAssignment
            {
            pushFollow(FOLLOW_rule__FixIntParameter__BodyAssignment_in_ruleFixIntParameter993);
            rule__FixIntParameter__BodyAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFixIntParameterAccess().getBodyAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFixIntParameter"


    // $ANTLR start "entryRuleFixStringParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:508:1: entryRuleFixStringParameter : ruleFixStringParameter EOF ;
    public final void entryRuleFixStringParameter() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:509:1: ( ruleFixStringParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:510:1: ruleFixStringParameter EOF
            {
             before(grammarAccess.getFixStringParameterRule()); 
            pushFollow(FOLLOW_ruleFixStringParameter_in_entryRuleFixStringParameter1020);
            ruleFixStringParameter();

            state._fsp--;

             after(grammarAccess.getFixStringParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixStringParameter1027); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFixStringParameter"


    // $ANTLR start "ruleFixStringParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:517:1: ruleFixStringParameter : ( ( rule__FixStringParameter__BodyAssignment ) ) ;
    public final void ruleFixStringParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:521:2: ( ( ( rule__FixStringParameter__BodyAssignment ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:522:1: ( ( rule__FixStringParameter__BodyAssignment ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:522:1: ( ( rule__FixStringParameter__BodyAssignment ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:523:1: ( rule__FixStringParameter__BodyAssignment )
            {
             before(grammarAccess.getFixStringParameterAccess().getBodyAssignment()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:524:1: ( rule__FixStringParameter__BodyAssignment )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:524:2: rule__FixStringParameter__BodyAssignment
            {
            pushFollow(FOLLOW_rule__FixStringParameter__BodyAssignment_in_ruleFixStringParameter1053);
            rule__FixStringParameter__BodyAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFixStringParameterAccess().getBodyAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFixStringParameter"


    // $ANTLR start "entryRuleVarParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:536:1: entryRuleVarParameter : ruleVarParameter EOF ;
    public final void entryRuleVarParameter() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:537:1: ( ruleVarParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:538:1: ruleVarParameter EOF
            {
             before(grammarAccess.getVarParameterRule()); 
            pushFollow(FOLLOW_ruleVarParameter_in_entryRuleVarParameter1080);
            ruleVarParameter();

            state._fsp--;

             after(grammarAccess.getVarParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarParameter1087); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVarParameter"


    // $ANTLR start "ruleVarParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:545:1: ruleVarParameter : ( ( rule__VarParameter__VarAssignment ) ) ;
    public final void ruleVarParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:549:2: ( ( ( rule__VarParameter__VarAssignment ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:550:1: ( ( rule__VarParameter__VarAssignment ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:550:1: ( ( rule__VarParameter__VarAssignment ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:551:1: ( rule__VarParameter__VarAssignment )
            {
             before(grammarAccess.getVarParameterAccess().getVarAssignment()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:552:1: ( rule__VarParameter__VarAssignment )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:552:2: rule__VarParameter__VarAssignment
            {
            pushFollow(FOLLOW_rule__VarParameter__VarAssignment_in_ruleVarParameter1113);
            rule__VarParameter__VarAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVarParameterAccess().getVarAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVarParameter"


    // $ANTLR start "entryRuleSingletonParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:564:1: entryRuleSingletonParameter : ruleSingletonParameter EOF ;
    public final void entryRuleSingletonParameter() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:565:1: ( ruleSingletonParameter EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:566:1: ruleSingletonParameter EOF
            {
             before(grammarAccess.getSingletonParameterRule()); 
            pushFollow(FOLLOW_ruleSingletonParameter_in_entryRuleSingletonParameter1140);
            ruleSingletonParameter();

            state._fsp--;

             after(grammarAccess.getSingletonParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSingletonParameter1147); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSingletonParameter"


    // $ANTLR start "ruleSingletonParameter"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:573:1: ruleSingletonParameter : ( ( rule__SingletonParameter__Group__0 ) ) ;
    public final void ruleSingletonParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:577:2: ( ( ( rule__SingletonParameter__Group__0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:578:1: ( ( rule__SingletonParameter__Group__0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:578:1: ( ( rule__SingletonParameter__Group__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:579:1: ( rule__SingletonParameter__Group__0 )
            {
             before(grammarAccess.getSingletonParameterAccess().getGroup()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:580:1: ( rule__SingletonParameter__Group__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:580:2: rule__SingletonParameter__Group__0
            {
            pushFollow(FOLLOW_rule__SingletonParameter__Group__0_in_ruleSingletonParameter1173);
            rule__SingletonParameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSingletonParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSingletonParameter"


    // $ANTLR start "entryRuleVar"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:592:1: entryRuleVar : ruleVar EOF ;
    public final void entryRuleVar() throws RecognitionException {
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:593:1: ( ruleVar EOF )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:594:1: ruleVar EOF
            {
             before(grammarAccess.getVarRule()); 
            pushFollow(FOLLOW_ruleVar_in_entryRuleVar1200);
            ruleVar();

            state._fsp--;

             after(grammarAccess.getVarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVar1207); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVar"


    // $ANTLR start "ruleVar"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:601:1: ruleVar : ( ( rule__Var__NameAssignment ) ) ;
    public final void ruleVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:605:2: ( ( ( rule__Var__NameAssignment ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:606:1: ( ( rule__Var__NameAssignment ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:606:1: ( ( rule__Var__NameAssignment ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:607:1: ( rule__Var__NameAssignment )
            {
             before(grammarAccess.getVarAccess().getNameAssignment()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:608:1: ( rule__Var__NameAssignment )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:608:2: rule__Var__NameAssignment
            {
            pushFollow(FOLLOW_rule__Var__NameAssignment_in_ruleVar1233);
            rule__Var__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVarAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVar"


    // $ANTLR start "rule__MultExpression__Alternatives_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:620:1: rule__MultExpression__Alternatives_1 : ( ( ( rule__MultExpression__Group_1_0__0 ) ) | ( ( rule__MultExpression__Group_1_1__0 ) ) | ( ( rule__MultExpression__Group_1_2__0 ) ) );
    public final void rule__MultExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:624:1: ( ( ( rule__MultExpression__Group_1_0__0 ) ) | ( ( rule__MultExpression__Group_1_1__0 ) ) | ( ( rule__MultExpression__Group_1_2__0 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt1=1;
                }
                break;
            case 22:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:625:1: ( ( rule__MultExpression__Group_1_0__0 ) )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:625:1: ( ( rule__MultExpression__Group_1_0__0 ) )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:626:1: ( rule__MultExpression__Group_1_0__0 )
                    {
                     before(grammarAccess.getMultExpressionAccess().getGroup_1_0()); 
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:627:1: ( rule__MultExpression__Group_1_0__0 )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:627:2: rule__MultExpression__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__MultExpression__Group_1_0__0_in_rule__MultExpression__Alternatives_11269);
                    rule__MultExpression__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultExpressionAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:631:6: ( ( rule__MultExpression__Group_1_1__0 ) )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:631:6: ( ( rule__MultExpression__Group_1_1__0 ) )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:632:1: ( rule__MultExpression__Group_1_1__0 )
                    {
                     before(grammarAccess.getMultExpressionAccess().getGroup_1_1()); 
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:633:1: ( rule__MultExpression__Group_1_1__0 )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:633:2: rule__MultExpression__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__MultExpression__Group_1_1__0_in_rule__MultExpression__Alternatives_11287);
                    rule__MultExpression__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultExpressionAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:637:6: ( ( rule__MultExpression__Group_1_2__0 ) )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:637:6: ( ( rule__MultExpression__Group_1_2__0 ) )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:638:1: ( rule__MultExpression__Group_1_2__0 )
                    {
                     before(grammarAccess.getMultExpressionAccess().getGroup_1_2()); 
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:639:1: ( rule__MultExpression__Group_1_2__0 )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:639:2: rule__MultExpression__Group_1_2__0
                    {
                    pushFollow(FOLLOW_rule__MultExpression__Group_1_2__0_in_rule__MultExpression__Alternatives_11305);
                    rule__MultExpression__Group_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultExpressionAccess().getGroup_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Alternatives_1"


    // $ANTLR start "rule__ParenExpression__Alternatives"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:648:1: rule__ParenExpression__Alternatives : ( ( ( rule__ParenExpression__Group_0__0 ) ) | ( ruleAny ) | ( ruleInverse ) | ( ruleTimedExpression ) | ( ruleEvent ) );
    public final void rule__ParenExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:652:1: ( ( ( rule__ParenExpression__Group_0__0 ) ) | ( ruleAny ) | ( ruleInverse ) | ( ruleTimedExpression ) | ( ruleEvent ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_ID||LA2_1==23||LA2_1==27) ) {
                    alt2=1;
                }
                else if ( (LA2_1==25) ) {
                    int LA2_6 = input.LA(3);

                    if ( (LA2_6==RULE_ID||LA2_6==13||(LA2_6>=20 && LA2_6<=25)||LA2_6==27) ) {
                        alt2=1;
                    }
                    else if ( (LA2_6==26) ) {
                        alt2=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 6, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case 25:
                {
                alt2=2;
                }
                break;
            case 27:
                {
                alt2=4;
                }
                break;
            case RULE_ID:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:653:1: ( ( rule__ParenExpression__Group_0__0 ) )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:653:1: ( ( rule__ParenExpression__Group_0__0 ) )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:654:1: ( rule__ParenExpression__Group_0__0 )
                    {
                     before(grammarAccess.getParenExpressionAccess().getGroup_0()); 
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:655:1: ( rule__ParenExpression__Group_0__0 )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:655:2: rule__ParenExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ParenExpression__Group_0__0_in_rule__ParenExpression__Alternatives1338);
                    rule__ParenExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParenExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:659:6: ( ruleAny )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:659:6: ( ruleAny )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:660:1: ruleAny
                    {
                     before(grammarAccess.getParenExpressionAccess().getAnyParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleAny_in_rule__ParenExpression__Alternatives1356);
                    ruleAny();

                    state._fsp--;

                     after(grammarAccess.getParenExpressionAccess().getAnyParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:665:6: ( ruleInverse )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:665:6: ( ruleInverse )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:666:1: ruleInverse
                    {
                     before(grammarAccess.getParenExpressionAccess().getInverseParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleInverse_in_rule__ParenExpression__Alternatives1373);
                    ruleInverse();

                    state._fsp--;

                     after(grammarAccess.getParenExpressionAccess().getInverseParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:671:6: ( ruleTimedExpression )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:671:6: ( ruleTimedExpression )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:672:1: ruleTimedExpression
                    {
                     before(grammarAccess.getParenExpressionAccess().getTimedExpressionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleTimedExpression_in_rule__ParenExpression__Alternatives1390);
                    ruleTimedExpression();

                    state._fsp--;

                     after(grammarAccess.getParenExpressionAccess().getTimedExpressionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:677:6: ( ruleEvent )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:677:6: ( ruleEvent )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:678:1: ruleEvent
                    {
                     before(grammarAccess.getParenExpressionAccess().getEventParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleEvent_in_rule__ParenExpression__Alternatives1407);
                    ruleEvent();

                    state._fsp--;

                     after(grammarAccess.getParenExpressionAccess().getEventParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenExpression__Alternatives"


    // $ANTLR start "rule__Parameter__Alternatives"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:688:1: rule__Parameter__Alternatives : ( ( ruleVarParameter ) | ( ruleSingletonParameter ) | ( ruleFixParameter ) );
    public final void rule__Parameter__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:692:1: ( ( ruleVarParameter ) | ( ruleSingletonParameter ) | ( ruleFixParameter ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt3=1;
                }
                break;
            case 29:
                {
                alt3=2;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:693:1: ( ruleVarParameter )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:693:1: ( ruleVarParameter )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:694:1: ruleVarParameter
                    {
                     before(grammarAccess.getParameterAccess().getVarParameterParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleVarParameter_in_rule__Parameter__Alternatives1439);
                    ruleVarParameter();

                    state._fsp--;

                     after(grammarAccess.getParameterAccess().getVarParameterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:699:6: ( ruleSingletonParameter )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:699:6: ( ruleSingletonParameter )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:700:1: ruleSingletonParameter
                    {
                     before(grammarAccess.getParameterAccess().getSingletonParameterParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSingletonParameter_in_rule__Parameter__Alternatives1456);
                    ruleSingletonParameter();

                    state._fsp--;

                     after(grammarAccess.getParameterAccess().getSingletonParameterParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:705:6: ( ruleFixParameter )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:705:6: ( ruleFixParameter )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:706:1: ruleFixParameter
                    {
                     before(grammarAccess.getParameterAccess().getFixParameterParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleFixParameter_in_rule__Parameter__Alternatives1473);
                    ruleFixParameter();

                    state._fsp--;

                     after(grammarAccess.getParameterAccess().getFixParameterParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Alternatives"


    // $ANTLR start "rule__FixParameter__Alternatives"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:716:1: rule__FixParameter__Alternatives : ( ( ruleFixIntParameter ) | ( ruleFixStringParameter ) );
    public final void rule__FixParameter__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:720:1: ( ( ruleFixIntParameter ) | ( ruleFixStringParameter ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_INT) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_STRING) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:721:1: ( ruleFixIntParameter )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:721:1: ( ruleFixIntParameter )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:722:1: ruleFixIntParameter
                    {
                     before(grammarAccess.getFixParameterAccess().getFixIntParameterParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFixIntParameter_in_rule__FixParameter__Alternatives1505);
                    ruleFixIntParameter();

                    state._fsp--;

                     after(grammarAccess.getFixParameterAccess().getFixIntParameterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:727:6: ( ruleFixStringParameter )
                    {
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:727:6: ( ruleFixStringParameter )
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:728:1: ruleFixStringParameter
                    {
                     before(grammarAccess.getFixParameterAccess().getFixStringParameterParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleFixStringParameter_in_rule__FixParameter__Alternatives1522);
                    ruleFixStringParameter();

                    state._fsp--;

                     after(grammarAccess.getFixParameterAccess().getFixStringParameterParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FixParameter__Alternatives"


    // $ANTLR start "rule__RegexModel__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:740:1: rule__RegexModel__Group__0 : rule__RegexModel__Group__0__Impl rule__RegexModel__Group__1 ;
    public final void rule__RegexModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:744:1: ( rule__RegexModel__Group__0__Impl rule__RegexModel__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:745:2: rule__RegexModel__Group__0__Impl rule__RegexModel__Group__1
            {
            pushFollow(FOLLOW_rule__RegexModel__Group__0__Impl_in_rule__RegexModel__Group__01552);
            rule__RegexModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RegexModel__Group__1_in_rule__RegexModel__Group__01555);
            rule__RegexModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexModel__Group__0"


    // $ANTLR start "rule__RegexModel__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:752:1: rule__RegexModel__Group__0__Impl : ( ( rule__RegexModel__AlphabetAssignment_0 )? ) ;
    public final void rule__RegexModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:756:1: ( ( ( rule__RegexModel__AlphabetAssignment_0 )? ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:757:1: ( ( rule__RegexModel__AlphabetAssignment_0 )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:757:1: ( ( rule__RegexModel__AlphabetAssignment_0 )? )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:758:1: ( rule__RegexModel__AlphabetAssignment_0 )?
            {
             before(grammarAccess.getRegexModelAccess().getAlphabetAssignment_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:759:1: ( rule__RegexModel__AlphabetAssignment_0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:759:2: rule__RegexModel__AlphabetAssignment_0
                    {
                    pushFollow(FOLLOW_rule__RegexModel__AlphabetAssignment_0_in_rule__RegexModel__Group__0__Impl1582);
                    rule__RegexModel__AlphabetAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRegexModelAccess().getAlphabetAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexModel__Group__0__Impl"


    // $ANTLR start "rule__RegexModel__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:769:1: rule__RegexModel__Group__1 : rule__RegexModel__Group__1__Impl ;
    public final void rule__RegexModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:773:1: ( rule__RegexModel__Group__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:774:2: rule__RegexModel__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RegexModel__Group__1__Impl_in_rule__RegexModel__Group__11613);
            rule__RegexModel__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexModel__Group__1"


    // $ANTLR start "rule__RegexModel__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:780:1: rule__RegexModel__Group__1__Impl : ( ( rule__RegexModel__DeclarationsAssignment_1 )* ) ;
    public final void rule__RegexModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:784:1: ( ( ( rule__RegexModel__DeclarationsAssignment_1 )* ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:785:1: ( ( rule__RegexModel__DeclarationsAssignment_1 )* )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:785:1: ( ( rule__RegexModel__DeclarationsAssignment_1 )* )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:786:1: ( rule__RegexModel__DeclarationsAssignment_1 )*
            {
             before(grammarAccess.getRegexModelAccess().getDeclarationsAssignment_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:787:1: ( rule__RegexModel__DeclarationsAssignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:787:2: rule__RegexModel__DeclarationsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__RegexModel__DeclarationsAssignment_1_in_rule__RegexModel__Group__1__Impl1640);
            	    rule__RegexModel__DeclarationsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRegexModelAccess().getDeclarationsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexModel__Group__1__Impl"


    // $ANTLR start "rule__Alphabet__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:801:1: rule__Alphabet__Group__0 : rule__Alphabet__Group__0__Impl rule__Alphabet__Group__1 ;
    public final void rule__Alphabet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:805:1: ( rule__Alphabet__Group__0__Impl rule__Alphabet__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:806:2: rule__Alphabet__Group__0__Impl rule__Alphabet__Group__1
            {
            pushFollow(FOLLOW_rule__Alphabet__Group__0__Impl_in_rule__Alphabet__Group__01675);
            rule__Alphabet__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Alphabet__Group__1_in_rule__Alphabet__Group__01678);
            rule__Alphabet__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__0"


    // $ANTLR start "rule__Alphabet__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:813:1: rule__Alphabet__Group__0__Impl : ( () ) ;
    public final void rule__Alphabet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:817:1: ( ( () ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:818:1: ( () )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:818:1: ( () )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:819:1: ()
            {
             before(grammarAccess.getAlphabetAccess().getAlphabetAction_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:820:1: ()
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:822:1: 
            {
            }

             after(grammarAccess.getAlphabetAccess().getAlphabetAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__0__Impl"


    // $ANTLR start "rule__Alphabet__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:832:1: rule__Alphabet__Group__1 : rule__Alphabet__Group__1__Impl rule__Alphabet__Group__2 ;
    public final void rule__Alphabet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:836:1: ( rule__Alphabet__Group__1__Impl rule__Alphabet__Group__2 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:837:2: rule__Alphabet__Group__1__Impl rule__Alphabet__Group__2
            {
            pushFollow(FOLLOW_rule__Alphabet__Group__1__Impl_in_rule__Alphabet__Group__11736);
            rule__Alphabet__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Alphabet__Group__2_in_rule__Alphabet__Group__11739);
            rule__Alphabet__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__1"


    // $ANTLR start "rule__Alphabet__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:844:1: rule__Alphabet__Group__1__Impl : ( 'alphabet' ) ;
    public final void rule__Alphabet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:848:1: ( ( 'alphabet' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:849:1: ( 'alphabet' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:849:1: ( 'alphabet' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:850:1: 'alphabet'
            {
             before(grammarAccess.getAlphabetAccess().getAlphabetKeyword_1()); 
            match(input,11,FOLLOW_11_in_rule__Alphabet__Group__1__Impl1767); 
             after(grammarAccess.getAlphabetAccess().getAlphabetKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__1__Impl"


    // $ANTLR start "rule__Alphabet__Group__2"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:863:1: rule__Alphabet__Group__2 : rule__Alphabet__Group__2__Impl rule__Alphabet__Group__3 ;
    public final void rule__Alphabet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:867:1: ( rule__Alphabet__Group__2__Impl rule__Alphabet__Group__3 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:868:2: rule__Alphabet__Group__2__Impl rule__Alphabet__Group__3
            {
            pushFollow(FOLLOW_rule__Alphabet__Group__2__Impl_in_rule__Alphabet__Group__21798);
            rule__Alphabet__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Alphabet__Group__3_in_rule__Alphabet__Group__21801);
            rule__Alphabet__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__2"


    // $ANTLR start "rule__Alphabet__Group__2__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:875:1: rule__Alphabet__Group__2__Impl : ( '=' ) ;
    public final void rule__Alphabet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:879:1: ( ( '=' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:880:1: ( '=' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:880:1: ( '=' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:881:1: '='
            {
             before(grammarAccess.getAlphabetAccess().getEqualsSignKeyword_2()); 
            match(input,12,FOLLOW_12_in_rule__Alphabet__Group__2__Impl1829); 
             after(grammarAccess.getAlphabetAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__2__Impl"


    // $ANTLR start "rule__Alphabet__Group__3"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:894:1: rule__Alphabet__Group__3 : rule__Alphabet__Group__3__Impl rule__Alphabet__Group__4 ;
    public final void rule__Alphabet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:898:1: ( rule__Alphabet__Group__3__Impl rule__Alphabet__Group__4 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:899:2: rule__Alphabet__Group__3__Impl rule__Alphabet__Group__4
            {
            pushFollow(FOLLOW_rule__Alphabet__Group__3__Impl_in_rule__Alphabet__Group__31860);
            rule__Alphabet__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Alphabet__Group__4_in_rule__Alphabet__Group__31863);
            rule__Alphabet__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__3"


    // $ANTLR start "rule__Alphabet__Group__3__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:906:1: rule__Alphabet__Group__3__Impl : ( '{' ) ;
    public final void rule__Alphabet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:910:1: ( ( '{' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:911:1: ( '{' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:911:1: ( '{' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:912:1: '{'
            {
             before(grammarAccess.getAlphabetAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,13,FOLLOW_13_in_rule__Alphabet__Group__3__Impl1891); 
             after(grammarAccess.getAlphabetAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__3__Impl"


    // $ANTLR start "rule__Alphabet__Group__4"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:925:1: rule__Alphabet__Group__4 : rule__Alphabet__Group__4__Impl rule__Alphabet__Group__5 ;
    public final void rule__Alphabet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:929:1: ( rule__Alphabet__Group__4__Impl rule__Alphabet__Group__5 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:930:2: rule__Alphabet__Group__4__Impl rule__Alphabet__Group__5
            {
            pushFollow(FOLLOW_rule__Alphabet__Group__4__Impl_in_rule__Alphabet__Group__41922);
            rule__Alphabet__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Alphabet__Group__5_in_rule__Alphabet__Group__41925);
            rule__Alphabet__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__4"


    // $ANTLR start "rule__Alphabet__Group__4__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:937:1: rule__Alphabet__Group__4__Impl : ( ( rule__Alphabet__Group_4__0 )? ) ;
    public final void rule__Alphabet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:941:1: ( ( ( rule__Alphabet__Group_4__0 )? ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:942:1: ( ( rule__Alphabet__Group_4__0 )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:942:1: ( ( rule__Alphabet__Group_4__0 )? )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:943:1: ( rule__Alphabet__Group_4__0 )?
            {
             before(grammarAccess.getAlphabetAccess().getGroup_4()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:944:1: ( rule__Alphabet__Group_4__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:944:2: rule__Alphabet__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Alphabet__Group_4__0_in_rule__Alphabet__Group__4__Impl1952);
                    rule__Alphabet__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlphabetAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__4__Impl"


    // $ANTLR start "rule__Alphabet__Group__5"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:954:1: rule__Alphabet__Group__5 : rule__Alphabet__Group__5__Impl ;
    public final void rule__Alphabet__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:958:1: ( rule__Alphabet__Group__5__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:959:2: rule__Alphabet__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Alphabet__Group__5__Impl_in_rule__Alphabet__Group__51983);
            rule__Alphabet__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__5"


    // $ANTLR start "rule__Alphabet__Group__5__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:965:1: rule__Alphabet__Group__5__Impl : ( '}' ) ;
    public final void rule__Alphabet__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:969:1: ( ( '}' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:970:1: ( '}' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:970:1: ( '}' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:971:1: '}'
            {
             before(grammarAccess.getAlphabetAccess().getRightCurlyBracketKeyword_5()); 
            match(input,14,FOLLOW_14_in_rule__Alphabet__Group__5__Impl2011); 
             after(grammarAccess.getAlphabetAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group__5__Impl"


    // $ANTLR start "rule__Alphabet__Group_4__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:996:1: rule__Alphabet__Group_4__0 : rule__Alphabet__Group_4__0__Impl rule__Alphabet__Group_4__1 ;
    public final void rule__Alphabet__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1000:1: ( rule__Alphabet__Group_4__0__Impl rule__Alphabet__Group_4__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1001:2: rule__Alphabet__Group_4__0__Impl rule__Alphabet__Group_4__1
            {
            pushFollow(FOLLOW_rule__Alphabet__Group_4__0__Impl_in_rule__Alphabet__Group_4__02054);
            rule__Alphabet__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Alphabet__Group_4__1_in_rule__Alphabet__Group_4__02057);
            rule__Alphabet__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group_4__0"


    // $ANTLR start "rule__Alphabet__Group_4__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1008:1: rule__Alphabet__Group_4__0__Impl : ( ( rule__Alphabet__FunctorsAssignment_4_0 ) ) ;
    public final void rule__Alphabet__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1012:1: ( ( ( rule__Alphabet__FunctorsAssignment_4_0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1013:1: ( ( rule__Alphabet__FunctorsAssignment_4_0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1013:1: ( ( rule__Alphabet__FunctorsAssignment_4_0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1014:1: ( rule__Alphabet__FunctorsAssignment_4_0 )
            {
             before(grammarAccess.getAlphabetAccess().getFunctorsAssignment_4_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1015:1: ( rule__Alphabet__FunctorsAssignment_4_0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1015:2: rule__Alphabet__FunctorsAssignment_4_0
            {
            pushFollow(FOLLOW_rule__Alphabet__FunctorsAssignment_4_0_in_rule__Alphabet__Group_4__0__Impl2084);
            rule__Alphabet__FunctorsAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getAlphabetAccess().getFunctorsAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group_4__0__Impl"


    // $ANTLR start "rule__Alphabet__Group_4__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1025:1: rule__Alphabet__Group_4__1 : rule__Alphabet__Group_4__1__Impl ;
    public final void rule__Alphabet__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1029:1: ( rule__Alphabet__Group_4__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1030:2: rule__Alphabet__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Alphabet__Group_4__1__Impl_in_rule__Alphabet__Group_4__12114);
            rule__Alphabet__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group_4__1"


    // $ANTLR start "rule__Alphabet__Group_4__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1036:1: rule__Alphabet__Group_4__1__Impl : ( ( rule__Alphabet__Group_4_1__0 )* ) ;
    public final void rule__Alphabet__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1040:1: ( ( ( rule__Alphabet__Group_4_1__0 )* ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1041:1: ( ( rule__Alphabet__Group_4_1__0 )* )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1041:1: ( ( rule__Alphabet__Group_4_1__0 )* )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1042:1: ( rule__Alphabet__Group_4_1__0 )*
            {
             before(grammarAccess.getAlphabetAccess().getGroup_4_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1043:1: ( rule__Alphabet__Group_4_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1043:2: rule__Alphabet__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Alphabet__Group_4_1__0_in_rule__Alphabet__Group_4__1__Impl2141);
            	    rule__Alphabet__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getAlphabetAccess().getGroup_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group_4__1__Impl"


    // $ANTLR start "rule__Alphabet__Group_4_1__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1057:1: rule__Alphabet__Group_4_1__0 : rule__Alphabet__Group_4_1__0__Impl rule__Alphabet__Group_4_1__1 ;
    public final void rule__Alphabet__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1061:1: ( rule__Alphabet__Group_4_1__0__Impl rule__Alphabet__Group_4_1__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1062:2: rule__Alphabet__Group_4_1__0__Impl rule__Alphabet__Group_4_1__1
            {
            pushFollow(FOLLOW_rule__Alphabet__Group_4_1__0__Impl_in_rule__Alphabet__Group_4_1__02176);
            rule__Alphabet__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Alphabet__Group_4_1__1_in_rule__Alphabet__Group_4_1__02179);
            rule__Alphabet__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group_4_1__0"


    // $ANTLR start "rule__Alphabet__Group_4_1__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1069:1: rule__Alphabet__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__Alphabet__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1073:1: ( ( ',' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1074:1: ( ',' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1074:1: ( ',' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1075:1: ','
            {
             before(grammarAccess.getAlphabetAccess().getCommaKeyword_4_1_0()); 
            match(input,15,FOLLOW_15_in_rule__Alphabet__Group_4_1__0__Impl2207); 
             after(grammarAccess.getAlphabetAccess().getCommaKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group_4_1__0__Impl"


    // $ANTLR start "rule__Alphabet__Group_4_1__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1088:1: rule__Alphabet__Group_4_1__1 : rule__Alphabet__Group_4_1__1__Impl ;
    public final void rule__Alphabet__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1092:1: ( rule__Alphabet__Group_4_1__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1093:2: rule__Alphabet__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Alphabet__Group_4_1__1__Impl_in_rule__Alphabet__Group_4_1__12238);
            rule__Alphabet__Group_4_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group_4_1__1"


    // $ANTLR start "rule__Alphabet__Group_4_1__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1099:1: rule__Alphabet__Group_4_1__1__Impl : ( ( rule__Alphabet__FunctorsAssignment_4_1_1 ) ) ;
    public final void rule__Alphabet__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1103:1: ( ( ( rule__Alphabet__FunctorsAssignment_4_1_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1104:1: ( ( rule__Alphabet__FunctorsAssignment_4_1_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1104:1: ( ( rule__Alphabet__FunctorsAssignment_4_1_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1105:1: ( rule__Alphabet__FunctorsAssignment_4_1_1 )
            {
             before(grammarAccess.getAlphabetAccess().getFunctorsAssignment_4_1_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1106:1: ( rule__Alphabet__FunctorsAssignment_4_1_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1106:2: rule__Alphabet__FunctorsAssignment_4_1_1
            {
            pushFollow(FOLLOW_rule__Alphabet__FunctorsAssignment_4_1_1_in_rule__Alphabet__Group_4_1__1__Impl2265);
            rule__Alphabet__FunctorsAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAlphabetAccess().getFunctorsAssignment_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__Group_4_1__1__Impl"


    // $ANTLR start "rule__Functor__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1120:1: rule__Functor__Group__0 : rule__Functor__Group__0__Impl rule__Functor__Group__1 ;
    public final void rule__Functor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1124:1: ( rule__Functor__Group__0__Impl rule__Functor__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1125:2: rule__Functor__Group__0__Impl rule__Functor__Group__1
            {
            pushFollow(FOLLOW_rule__Functor__Group__0__Impl_in_rule__Functor__Group__02299);
            rule__Functor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Functor__Group__1_in_rule__Functor__Group__02302);
            rule__Functor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__Group__0"


    // $ANTLR start "rule__Functor__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1132:1: rule__Functor__Group__0__Impl : ( ( rule__Functor__NameAssignment_0 ) ) ;
    public final void rule__Functor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1136:1: ( ( ( rule__Functor__NameAssignment_0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1137:1: ( ( rule__Functor__NameAssignment_0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1137:1: ( ( rule__Functor__NameAssignment_0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1138:1: ( rule__Functor__NameAssignment_0 )
            {
             before(grammarAccess.getFunctorAccess().getNameAssignment_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1139:1: ( rule__Functor__NameAssignment_0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1139:2: rule__Functor__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Functor__NameAssignment_0_in_rule__Functor__Group__0__Impl2329);
            rule__Functor__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFunctorAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__Group__0__Impl"


    // $ANTLR start "rule__Functor__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1149:1: rule__Functor__Group__1 : rule__Functor__Group__1__Impl ;
    public final void rule__Functor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1153:1: ( rule__Functor__Group__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1154:2: rule__Functor__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Functor__Group__1__Impl_in_rule__Functor__Group__12359);
            rule__Functor__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__Group__1"


    // $ANTLR start "rule__Functor__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1160:1: rule__Functor__Group__1__Impl : ( ( rule__Functor__Group_1__0 )? ) ;
    public final void rule__Functor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1164:1: ( ( ( rule__Functor__Group_1__0 )? ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1165:1: ( ( rule__Functor__Group_1__0 )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1165:1: ( ( rule__Functor__Group_1__0 )? )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1166:1: ( rule__Functor__Group_1__0 )?
            {
             before(grammarAccess.getFunctorAccess().getGroup_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1167:1: ( rule__Functor__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1167:2: rule__Functor__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Functor__Group_1__0_in_rule__Functor__Group__1__Impl2386);
                    rule__Functor__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFunctorAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__Group__1__Impl"


    // $ANTLR start "rule__Functor__Group_1__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1181:1: rule__Functor__Group_1__0 : rule__Functor__Group_1__0__Impl rule__Functor__Group_1__1 ;
    public final void rule__Functor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1185:1: ( rule__Functor__Group_1__0__Impl rule__Functor__Group_1__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1186:2: rule__Functor__Group_1__0__Impl rule__Functor__Group_1__1
            {
            pushFollow(FOLLOW_rule__Functor__Group_1__0__Impl_in_rule__Functor__Group_1__02421);
            rule__Functor__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Functor__Group_1__1_in_rule__Functor__Group_1__02424);
            rule__Functor__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__Group_1__0"


    // $ANTLR start "rule__Functor__Group_1__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1193:1: rule__Functor__Group_1__0__Impl : ( '/' ) ;
    public final void rule__Functor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1197:1: ( ( '/' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1198:1: ( '/' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1198:1: ( '/' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1199:1: '/'
            {
             before(grammarAccess.getFunctorAccess().getSolidusKeyword_1_0()); 
            match(input,16,FOLLOW_16_in_rule__Functor__Group_1__0__Impl2452); 
             after(grammarAccess.getFunctorAccess().getSolidusKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__Group_1__0__Impl"


    // $ANTLR start "rule__Functor__Group_1__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1212:1: rule__Functor__Group_1__1 : rule__Functor__Group_1__1__Impl ;
    public final void rule__Functor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1216:1: ( rule__Functor__Group_1__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1217:2: rule__Functor__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Functor__Group_1__1__Impl_in_rule__Functor__Group_1__12483);
            rule__Functor__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__Group_1__1"


    // $ANTLR start "rule__Functor__Group_1__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1223:1: rule__Functor__Group_1__1__Impl : ( ( rule__Functor__ArityAssignment_1_1 ) ) ;
    public final void rule__Functor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1227:1: ( ( ( rule__Functor__ArityAssignment_1_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1228:1: ( ( rule__Functor__ArityAssignment_1_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1228:1: ( ( rule__Functor__ArityAssignment_1_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1229:1: ( rule__Functor__ArityAssignment_1_1 )
            {
             before(grammarAccess.getFunctorAccess().getArityAssignment_1_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1230:1: ( rule__Functor__ArityAssignment_1_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1230:2: rule__Functor__ArityAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Functor__ArityAssignment_1_1_in_rule__Functor__Group_1__1__Impl2510);
            rule__Functor__ArityAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctorAccess().getArityAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__Group_1__1__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1244:1: rule__ExpressionDeclaration__Group__0 : rule__ExpressionDeclaration__Group__0__Impl rule__ExpressionDeclaration__Group__1 ;
    public final void rule__ExpressionDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1248:1: ( rule__ExpressionDeclaration__Group__0__Impl rule__ExpressionDeclaration__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1249:2: rule__ExpressionDeclaration__Group__0__Impl rule__ExpressionDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__0__Impl_in_rule__ExpressionDeclaration__Group__02544);
            rule__ExpressionDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__1_in_rule__ExpressionDeclaration__Group__02547);
            rule__ExpressionDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__0"


    // $ANTLR start "rule__ExpressionDeclaration__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1256:1: rule__ExpressionDeclaration__Group__0__Impl : ( 'expression' ) ;
    public final void rule__ExpressionDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1260:1: ( ( 'expression' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1261:1: ( 'expression' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1261:1: ( 'expression' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1262:1: 'expression'
            {
             before(grammarAccess.getExpressionDeclarationAccess().getExpressionKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__ExpressionDeclaration__Group__0__Impl2575); 
             after(grammarAccess.getExpressionDeclarationAccess().getExpressionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__0__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1275:1: rule__ExpressionDeclaration__Group__1 : rule__ExpressionDeclaration__Group__1__Impl rule__ExpressionDeclaration__Group__2 ;
    public final void rule__ExpressionDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1279:1: ( rule__ExpressionDeclaration__Group__1__Impl rule__ExpressionDeclaration__Group__2 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1280:2: rule__ExpressionDeclaration__Group__1__Impl rule__ExpressionDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__1__Impl_in_rule__ExpressionDeclaration__Group__12606);
            rule__ExpressionDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__2_in_rule__ExpressionDeclaration__Group__12609);
            rule__ExpressionDeclaration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__1"


    // $ANTLR start "rule__ExpressionDeclaration__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1287:1: rule__ExpressionDeclaration__Group__1__Impl : ( ( rule__ExpressionDeclaration__NameAssignment_1 ) ) ;
    public final void rule__ExpressionDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1291:1: ( ( ( rule__ExpressionDeclaration__NameAssignment_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1292:1: ( ( rule__ExpressionDeclaration__NameAssignment_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1292:1: ( ( rule__ExpressionDeclaration__NameAssignment_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1293:1: ( rule__ExpressionDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getNameAssignment_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1294:1: ( rule__ExpressionDeclaration__NameAssignment_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1294:2: rule__ExpressionDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__NameAssignment_1_in_rule__ExpressionDeclaration__Group__1__Impl2636);
            rule__ExpressionDeclaration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionDeclarationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__1__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group__2"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1304:1: rule__ExpressionDeclaration__Group__2 : rule__ExpressionDeclaration__Group__2__Impl rule__ExpressionDeclaration__Group__3 ;
    public final void rule__ExpressionDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1308:1: ( rule__ExpressionDeclaration__Group__2__Impl rule__ExpressionDeclaration__Group__3 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1309:2: rule__ExpressionDeclaration__Group__2__Impl rule__ExpressionDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__2__Impl_in_rule__ExpressionDeclaration__Group__22666);
            rule__ExpressionDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__3_in_rule__ExpressionDeclaration__Group__22669);
            rule__ExpressionDeclaration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__2"


    // $ANTLR start "rule__ExpressionDeclaration__Group__2__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1316:1: rule__ExpressionDeclaration__Group__2__Impl : ( ( rule__ExpressionDeclaration__Group_2__0 )? ) ;
    public final void rule__ExpressionDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1320:1: ( ( ( rule__ExpressionDeclaration__Group_2__0 )? ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1321:1: ( ( rule__ExpressionDeclaration__Group_2__0 )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1321:1: ( ( rule__ExpressionDeclaration__Group_2__0 )? )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1322:1: ( rule__ExpressionDeclaration__Group_2__0 )?
            {
             before(grammarAccess.getExpressionDeclarationAccess().getGroup_2()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1323:1: ( rule__ExpressionDeclaration__Group_2__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1323:2: rule__ExpressionDeclaration__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2__0_in_rule__ExpressionDeclaration__Group__2__Impl2696);
                    rule__ExpressionDeclaration__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExpressionDeclarationAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__2__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group__3"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1333:1: rule__ExpressionDeclaration__Group__3 : rule__ExpressionDeclaration__Group__3__Impl rule__ExpressionDeclaration__Group__4 ;
    public final void rule__ExpressionDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1337:1: ( rule__ExpressionDeclaration__Group__3__Impl rule__ExpressionDeclaration__Group__4 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1338:2: rule__ExpressionDeclaration__Group__3__Impl rule__ExpressionDeclaration__Group__4
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__3__Impl_in_rule__ExpressionDeclaration__Group__32727);
            rule__ExpressionDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__4_in_rule__ExpressionDeclaration__Group__32730);
            rule__ExpressionDeclaration__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__3"


    // $ANTLR start "rule__ExpressionDeclaration__Group__3__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1345:1: rule__ExpressionDeclaration__Group__3__Impl : ( '=' ) ;
    public final void rule__ExpressionDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1349:1: ( ( '=' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1350:1: ( '=' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1350:1: ( '=' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1351:1: '='
            {
             before(grammarAccess.getExpressionDeclarationAccess().getEqualsSignKeyword_3()); 
            match(input,12,FOLLOW_12_in_rule__ExpressionDeclaration__Group__3__Impl2758); 
             after(grammarAccess.getExpressionDeclarationAccess().getEqualsSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__3__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group__4"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1364:1: rule__ExpressionDeclaration__Group__4 : rule__ExpressionDeclaration__Group__4__Impl ;
    public final void rule__ExpressionDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1368:1: ( rule__ExpressionDeclaration__Group__4__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1369:2: rule__ExpressionDeclaration__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group__4__Impl_in_rule__ExpressionDeclaration__Group__42789);
            rule__ExpressionDeclaration__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__4"


    // $ANTLR start "rule__ExpressionDeclaration__Group__4__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1375:1: rule__ExpressionDeclaration__Group__4__Impl : ( ( rule__ExpressionDeclaration__BodyAssignment_4 ) ) ;
    public final void rule__ExpressionDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1379:1: ( ( ( rule__ExpressionDeclaration__BodyAssignment_4 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1380:1: ( ( rule__ExpressionDeclaration__BodyAssignment_4 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1380:1: ( ( rule__ExpressionDeclaration__BodyAssignment_4 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1381:1: ( rule__ExpressionDeclaration__BodyAssignment_4 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getBodyAssignment_4()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1382:1: ( rule__ExpressionDeclaration__BodyAssignment_4 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1382:2: rule__ExpressionDeclaration__BodyAssignment_4
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__BodyAssignment_4_in_rule__ExpressionDeclaration__Group__4__Impl2816);
            rule__ExpressionDeclaration__BodyAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getExpressionDeclarationAccess().getBodyAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group__4__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1402:1: rule__ExpressionDeclaration__Group_2__0 : rule__ExpressionDeclaration__Group_2__0__Impl rule__ExpressionDeclaration__Group_2__1 ;
    public final void rule__ExpressionDeclaration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1406:1: ( rule__ExpressionDeclaration__Group_2__0__Impl rule__ExpressionDeclaration__Group_2__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1407:2: rule__ExpressionDeclaration__Group_2__0__Impl rule__ExpressionDeclaration__Group_2__1
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2__0__Impl_in_rule__ExpressionDeclaration__Group_2__02856);
            rule__ExpressionDeclaration__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2__1_in_rule__ExpressionDeclaration__Group_2__02859);
            rule__ExpressionDeclaration__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2__0"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1414:1: rule__ExpressionDeclaration__Group_2__0__Impl : ( '[' ) ;
    public final void rule__ExpressionDeclaration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1418:1: ( ( '[' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1419:1: ( '[' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1419:1: ( '[' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1420:1: '['
            {
             before(grammarAccess.getExpressionDeclarationAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__ExpressionDeclaration__Group_2__0__Impl2887); 
             after(grammarAccess.getExpressionDeclarationAccess().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2__0__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1433:1: rule__ExpressionDeclaration__Group_2__1 : rule__ExpressionDeclaration__Group_2__1__Impl rule__ExpressionDeclaration__Group_2__2 ;
    public final void rule__ExpressionDeclaration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1437:1: ( rule__ExpressionDeclaration__Group_2__1__Impl rule__ExpressionDeclaration__Group_2__2 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1438:2: rule__ExpressionDeclaration__Group_2__1__Impl rule__ExpressionDeclaration__Group_2__2
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2__1__Impl_in_rule__ExpressionDeclaration__Group_2__12918);
            rule__ExpressionDeclaration__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2__2_in_rule__ExpressionDeclaration__Group_2__12921);
            rule__ExpressionDeclaration__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2__1"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1445:1: rule__ExpressionDeclaration__Group_2__1__Impl : ( ( rule__ExpressionDeclaration__VarsAssignment_2_1 ) ) ;
    public final void rule__ExpressionDeclaration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1449:1: ( ( ( rule__ExpressionDeclaration__VarsAssignment_2_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1450:1: ( ( rule__ExpressionDeclaration__VarsAssignment_2_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1450:1: ( ( rule__ExpressionDeclaration__VarsAssignment_2_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1451:1: ( rule__ExpressionDeclaration__VarsAssignment_2_1 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getVarsAssignment_2_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1452:1: ( rule__ExpressionDeclaration__VarsAssignment_2_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1452:2: rule__ExpressionDeclaration__VarsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__VarsAssignment_2_1_in_rule__ExpressionDeclaration__Group_2__1__Impl2948);
            rule__ExpressionDeclaration__VarsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionDeclarationAccess().getVarsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2__1__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2__2"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1462:1: rule__ExpressionDeclaration__Group_2__2 : rule__ExpressionDeclaration__Group_2__2__Impl rule__ExpressionDeclaration__Group_2__3 ;
    public final void rule__ExpressionDeclaration__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1466:1: ( rule__ExpressionDeclaration__Group_2__2__Impl rule__ExpressionDeclaration__Group_2__3 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1467:2: rule__ExpressionDeclaration__Group_2__2__Impl rule__ExpressionDeclaration__Group_2__3
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2__2__Impl_in_rule__ExpressionDeclaration__Group_2__22978);
            rule__ExpressionDeclaration__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2__3_in_rule__ExpressionDeclaration__Group_2__22981);
            rule__ExpressionDeclaration__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2__2"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2__2__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1474:1: rule__ExpressionDeclaration__Group_2__2__Impl : ( ( rule__ExpressionDeclaration__Group_2_2__0 )* ) ;
    public final void rule__ExpressionDeclaration__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1478:1: ( ( ( rule__ExpressionDeclaration__Group_2_2__0 )* ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1479:1: ( ( rule__ExpressionDeclaration__Group_2_2__0 )* )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1479:1: ( ( rule__ExpressionDeclaration__Group_2_2__0 )* )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1480:1: ( rule__ExpressionDeclaration__Group_2_2__0 )*
            {
             before(grammarAccess.getExpressionDeclarationAccess().getGroup_2_2()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1481:1: ( rule__ExpressionDeclaration__Group_2_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1481:2: rule__ExpressionDeclaration__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2_2__0_in_rule__ExpressionDeclaration__Group_2__2__Impl3008);
            	    rule__ExpressionDeclaration__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getExpressionDeclarationAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2__2__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2__3"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1491:1: rule__ExpressionDeclaration__Group_2__3 : rule__ExpressionDeclaration__Group_2__3__Impl ;
    public final void rule__ExpressionDeclaration__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1495:1: ( rule__ExpressionDeclaration__Group_2__3__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1496:2: rule__ExpressionDeclaration__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2__3__Impl_in_rule__ExpressionDeclaration__Group_2__33039);
            rule__ExpressionDeclaration__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2__3"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2__3__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1502:1: rule__ExpressionDeclaration__Group_2__3__Impl : ( ']' ) ;
    public final void rule__ExpressionDeclaration__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1506:1: ( ( ']' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1507:1: ( ']' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1507:1: ( ']' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1508:1: ']'
            {
             before(grammarAccess.getExpressionDeclarationAccess().getRightSquareBracketKeyword_2_3()); 
            match(input,19,FOLLOW_19_in_rule__ExpressionDeclaration__Group_2__3__Impl3067); 
             after(grammarAccess.getExpressionDeclarationAccess().getRightSquareBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2__3__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2_2__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1529:1: rule__ExpressionDeclaration__Group_2_2__0 : rule__ExpressionDeclaration__Group_2_2__0__Impl rule__ExpressionDeclaration__Group_2_2__1 ;
    public final void rule__ExpressionDeclaration__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1533:1: ( rule__ExpressionDeclaration__Group_2_2__0__Impl rule__ExpressionDeclaration__Group_2_2__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1534:2: rule__ExpressionDeclaration__Group_2_2__0__Impl rule__ExpressionDeclaration__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2_2__0__Impl_in_rule__ExpressionDeclaration__Group_2_2__03106);
            rule__ExpressionDeclaration__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2_2__1_in_rule__ExpressionDeclaration__Group_2_2__03109);
            rule__ExpressionDeclaration__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2_2__0"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2_2__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1541:1: rule__ExpressionDeclaration__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__ExpressionDeclaration__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1545:1: ( ( ',' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1546:1: ( ',' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1546:1: ( ',' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1547:1: ','
            {
             before(grammarAccess.getExpressionDeclarationAccess().getCommaKeyword_2_2_0()); 
            match(input,15,FOLLOW_15_in_rule__ExpressionDeclaration__Group_2_2__0__Impl3137); 
             after(grammarAccess.getExpressionDeclarationAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2_2__0__Impl"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2_2__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1560:1: rule__ExpressionDeclaration__Group_2_2__1 : rule__ExpressionDeclaration__Group_2_2__1__Impl ;
    public final void rule__ExpressionDeclaration__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1564:1: ( rule__ExpressionDeclaration__Group_2_2__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1565:2: rule__ExpressionDeclaration__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__Group_2_2__1__Impl_in_rule__ExpressionDeclaration__Group_2_2__13168);
            rule__ExpressionDeclaration__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2_2__1"


    // $ANTLR start "rule__ExpressionDeclaration__Group_2_2__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1571:1: rule__ExpressionDeclaration__Group_2_2__1__Impl : ( ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 ) ) ;
    public final void rule__ExpressionDeclaration__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1575:1: ( ( ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1576:1: ( ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1576:1: ( ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1577:1: ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getVarsAssignment_2_2_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1578:1: ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1578:2: rule__ExpressionDeclaration__VarsAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__ExpressionDeclaration__VarsAssignment_2_2_1_in_rule__ExpressionDeclaration__Group_2_2__1__Impl3195);
            rule__ExpressionDeclaration__VarsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getExpressionDeclarationAccess().getVarsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__Group_2_2__1__Impl"


    // $ANTLR start "rule__Choice__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1592:1: rule__Choice__Group__0 : rule__Choice__Group__0__Impl rule__Choice__Group__1 ;
    public final void rule__Choice__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1596:1: ( rule__Choice__Group__0__Impl rule__Choice__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1597:2: rule__Choice__Group__0__Impl rule__Choice__Group__1
            {
            pushFollow(FOLLOW_rule__Choice__Group__0__Impl_in_rule__Choice__Group__03229);
            rule__Choice__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Choice__Group__1_in_rule__Choice__Group__03232);
            rule__Choice__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group__0"


    // $ANTLR start "rule__Choice__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1604:1: rule__Choice__Group__0__Impl : ( ruleSequence ) ;
    public final void rule__Choice__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1608:1: ( ( ruleSequence ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1609:1: ( ruleSequence )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1609:1: ( ruleSequence )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1610:1: ruleSequence
            {
             before(grammarAccess.getChoiceAccess().getSequenceParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleSequence_in_rule__Choice__Group__0__Impl3259);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getChoiceAccess().getSequenceParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group__0__Impl"


    // $ANTLR start "rule__Choice__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1621:1: rule__Choice__Group__1 : rule__Choice__Group__1__Impl ;
    public final void rule__Choice__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1625:1: ( rule__Choice__Group__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1626:2: rule__Choice__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Choice__Group__1__Impl_in_rule__Choice__Group__13288);
            rule__Choice__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group__1"


    // $ANTLR start "rule__Choice__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1632:1: rule__Choice__Group__1__Impl : ( ( rule__Choice__Group_1__0 )? ) ;
    public final void rule__Choice__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1636:1: ( ( ( rule__Choice__Group_1__0 )? ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1637:1: ( ( rule__Choice__Group_1__0 )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1637:1: ( ( rule__Choice__Group_1__0 )? )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1638:1: ( rule__Choice__Group_1__0 )?
            {
             before(grammarAccess.getChoiceAccess().getGroup_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1639:1: ( rule__Choice__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1639:2: rule__Choice__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Choice__Group_1__0_in_rule__Choice__Group__1__Impl3315);
                    rule__Choice__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getChoiceAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group__1__Impl"


    // $ANTLR start "rule__Choice__Group_1__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1653:1: rule__Choice__Group_1__0 : rule__Choice__Group_1__0__Impl rule__Choice__Group_1__1 ;
    public final void rule__Choice__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1657:1: ( rule__Choice__Group_1__0__Impl rule__Choice__Group_1__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1658:2: rule__Choice__Group_1__0__Impl rule__Choice__Group_1__1
            {
            pushFollow(FOLLOW_rule__Choice__Group_1__0__Impl_in_rule__Choice__Group_1__03350);
            rule__Choice__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Choice__Group_1__1_in_rule__Choice__Group_1__03353);
            rule__Choice__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group_1__0"


    // $ANTLR start "rule__Choice__Group_1__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1665:1: rule__Choice__Group_1__0__Impl : ( () ) ;
    public final void rule__Choice__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1669:1: ( ( () ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1670:1: ( () )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1670:1: ( () )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1671:1: ()
            {
             before(grammarAccess.getChoiceAccess().getChoiceElementsAction_1_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1672:1: ()
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1674:1: 
            {
            }

             after(grammarAccess.getChoiceAccess().getChoiceElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group_1__0__Impl"


    // $ANTLR start "rule__Choice__Group_1__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1684:1: rule__Choice__Group_1__1 : rule__Choice__Group_1__1__Impl ;
    public final void rule__Choice__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1688:1: ( rule__Choice__Group_1__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1689:2: rule__Choice__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Choice__Group_1__1__Impl_in_rule__Choice__Group_1__13411);
            rule__Choice__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group_1__1"


    // $ANTLR start "rule__Choice__Group_1__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1695:1: rule__Choice__Group_1__1__Impl : ( ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* ) ) ;
    public final void rule__Choice__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1699:1: ( ( ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1700:1: ( ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1700:1: ( ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1701:1: ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1701:1: ( ( rule__Choice__Group_1_1__0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1702:1: ( rule__Choice__Group_1_1__0 )
            {
             before(grammarAccess.getChoiceAccess().getGroup_1_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1703:1: ( rule__Choice__Group_1_1__0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1703:2: rule__Choice__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__Choice__Group_1_1__0_in_rule__Choice__Group_1__1__Impl3440);
            rule__Choice__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getChoiceAccess().getGroup_1_1()); 

            }

            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1706:1: ( ( rule__Choice__Group_1_1__0 )* )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1707:1: ( rule__Choice__Group_1_1__0 )*
            {
             before(grammarAccess.getChoiceAccess().getGroup_1_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1708:1: ( rule__Choice__Group_1_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1708:2: rule__Choice__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Choice__Group_1_1__0_in_rule__Choice__Group_1__1__Impl3452);
            	    rule__Choice__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getChoiceAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group_1__1__Impl"


    // $ANTLR start "rule__Choice__Group_1_1__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1723:1: rule__Choice__Group_1_1__0 : rule__Choice__Group_1_1__0__Impl rule__Choice__Group_1_1__1 ;
    public final void rule__Choice__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1727:1: ( rule__Choice__Group_1_1__0__Impl rule__Choice__Group_1_1__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1728:2: rule__Choice__Group_1_1__0__Impl rule__Choice__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__Choice__Group_1_1__0__Impl_in_rule__Choice__Group_1_1__03489);
            rule__Choice__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Choice__Group_1_1__1_in_rule__Choice__Group_1_1__03492);
            rule__Choice__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group_1_1__0"


    // $ANTLR start "rule__Choice__Group_1_1__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1735:1: rule__Choice__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Choice__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1739:1: ( ( '|' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1740:1: ( '|' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1740:1: ( '|' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1741:1: '|'
            {
             before(grammarAccess.getChoiceAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,20,FOLLOW_20_in_rule__Choice__Group_1_1__0__Impl3520); 
             after(grammarAccess.getChoiceAccess().getVerticalLineKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group_1_1__0__Impl"


    // $ANTLR start "rule__Choice__Group_1_1__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1754:1: rule__Choice__Group_1_1__1 : rule__Choice__Group_1_1__1__Impl ;
    public final void rule__Choice__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1758:1: ( rule__Choice__Group_1_1__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1759:2: rule__Choice__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Choice__Group_1_1__1__Impl_in_rule__Choice__Group_1_1__13551);
            rule__Choice__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group_1_1__1"


    // $ANTLR start "rule__Choice__Group_1_1__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1765:1: rule__Choice__Group_1_1__1__Impl : ( ( rule__Choice__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__Choice__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1769:1: ( ( ( rule__Choice__ElementsAssignment_1_1_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1770:1: ( ( rule__Choice__ElementsAssignment_1_1_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1770:1: ( ( rule__Choice__ElementsAssignment_1_1_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1771:1: ( rule__Choice__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getChoiceAccess().getElementsAssignment_1_1_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1772:1: ( rule__Choice__ElementsAssignment_1_1_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1772:2: rule__Choice__ElementsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__Choice__ElementsAssignment_1_1_1_in_rule__Choice__Group_1_1__1__Impl3578);
            rule__Choice__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getChoiceAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__Group_1_1__1__Impl"


    // $ANTLR start "rule__Sequence__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1786:1: rule__Sequence__Group__0 : rule__Sequence__Group__0__Impl rule__Sequence__Group__1 ;
    public final void rule__Sequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1790:1: ( rule__Sequence__Group__0__Impl rule__Sequence__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1791:2: rule__Sequence__Group__0__Impl rule__Sequence__Group__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group__0__Impl_in_rule__Sequence__Group__03612);
            rule__Sequence__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group__1_in_rule__Sequence__Group__03615);
            rule__Sequence__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__0"


    // $ANTLR start "rule__Sequence__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1798:1: rule__Sequence__Group__0__Impl : ( ruleMultExpression ) ;
    public final void rule__Sequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1802:1: ( ( ruleMultExpression ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1803:1: ( ruleMultExpression )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1803:1: ( ruleMultExpression )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1804:1: ruleMultExpression
            {
             before(grammarAccess.getSequenceAccess().getMultExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleMultExpression_in_rule__Sequence__Group__0__Impl3642);
            ruleMultExpression();

            state._fsp--;

             after(grammarAccess.getSequenceAccess().getMultExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__0__Impl"


    // $ANTLR start "rule__Sequence__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1815:1: rule__Sequence__Group__1 : rule__Sequence__Group__1__Impl ;
    public final void rule__Sequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1819:1: ( rule__Sequence__Group__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1820:2: rule__Sequence__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group__1__Impl_in_rule__Sequence__Group__13671);
            rule__Sequence__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__1"


    // $ANTLR start "rule__Sequence__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1826:1: rule__Sequence__Group__1__Impl : ( ( rule__Sequence__Group_1__0 )? ) ;
    public final void rule__Sequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1830:1: ( ( ( rule__Sequence__Group_1__0 )? ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1831:1: ( ( rule__Sequence__Group_1__0 )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1831:1: ( ( rule__Sequence__Group_1__0 )? )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1832:1: ( rule__Sequence__Group_1__0 )?
            {
             before(grammarAccess.getSequenceAccess().getGroup_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1833:1: ( rule__Sequence__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID||LA14_0==23||LA14_0==25||LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1833:2: rule__Sequence__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Group__1__Impl3698);
                    rule__Sequence__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSequenceAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group__1__Impl"


    // $ANTLR start "rule__Sequence__Group_1__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1847:1: rule__Sequence__Group_1__0 : rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 ;
    public final void rule__Sequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1851:1: ( rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1852:2: rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__03733);
            rule__Sequence__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__03736);
            rule__Sequence__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__0"


    // $ANTLR start "rule__Sequence__Group_1__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1859:1: rule__Sequence__Group_1__0__Impl : ( () ) ;
    public final void rule__Sequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1863:1: ( ( () ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1864:1: ( () )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1864:1: ( () )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1865:1: ()
            {
             before(grammarAccess.getSequenceAccess().getSequenceElementsAction_1_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1866:1: ()
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1868:1: 
            {
            }

             after(grammarAccess.getSequenceAccess().getSequenceElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__0__Impl"


    // $ANTLR start "rule__Sequence__Group_1__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1878:1: rule__Sequence__Group_1__1 : rule__Sequence__Group_1__1__Impl ;
    public final void rule__Sequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1882:1: ( rule__Sequence__Group_1__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1883:2: rule__Sequence__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__13794);
            rule__Sequence__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__1"


    // $ANTLR start "rule__Sequence__Group_1__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1889:1: rule__Sequence__Group_1__1__Impl : ( ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__Sequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1893:1: ( ( ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1894:1: ( ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1894:1: ( ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1895:1: ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1895:1: ( ( rule__Sequence__ElementsAssignment_1_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1896:1: ( rule__Sequence__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getSequenceAccess().getElementsAssignment_1_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1897:1: ( rule__Sequence__ElementsAssignment_1_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1897:2: rule__Sequence__ElementsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Sequence__ElementsAssignment_1_1_in_rule__Sequence__Group_1__1__Impl3823);
            rule__Sequence__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getElementsAssignment_1_1()); 

            }

            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1900:1: ( ( rule__Sequence__ElementsAssignment_1_1 )* )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1901:1: ( rule__Sequence__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getSequenceAccess().getElementsAssignment_1_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1902:1: ( rule__Sequence__ElementsAssignment_1_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID||LA15_0==23||LA15_0==25||LA15_0==27) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1902:2: rule__Sequence__ElementsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_rule__Sequence__ElementsAssignment_1_1_in_rule__Sequence__Group_1__1__Impl3835);
            	    rule__Sequence__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getSequenceAccess().getElementsAssignment_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__Group_1__1__Impl"


    // $ANTLR start "rule__MultExpression__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1917:1: rule__MultExpression__Group__0 : rule__MultExpression__Group__0__Impl rule__MultExpression__Group__1 ;
    public final void rule__MultExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1921:1: ( rule__MultExpression__Group__0__Impl rule__MultExpression__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1922:2: rule__MultExpression__Group__0__Impl rule__MultExpression__Group__1
            {
            pushFollow(FOLLOW_rule__MultExpression__Group__0__Impl_in_rule__MultExpression__Group__03872);
            rule__MultExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultExpression__Group__1_in_rule__MultExpression__Group__03875);
            rule__MultExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group__0"


    // $ANTLR start "rule__MultExpression__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1929:1: rule__MultExpression__Group__0__Impl : ( ruleParenExpression ) ;
    public final void rule__MultExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1933:1: ( ( ruleParenExpression ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1934:1: ( ruleParenExpression )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1934:1: ( ruleParenExpression )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1935:1: ruleParenExpression
            {
             before(grammarAccess.getMultExpressionAccess().getParenExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleParenExpression_in_rule__MultExpression__Group__0__Impl3902);
            ruleParenExpression();

            state._fsp--;

             after(grammarAccess.getMultExpressionAccess().getParenExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group__0__Impl"


    // $ANTLR start "rule__MultExpression__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1946:1: rule__MultExpression__Group__1 : rule__MultExpression__Group__1__Impl ;
    public final void rule__MultExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1950:1: ( rule__MultExpression__Group__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1951:2: rule__MultExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MultExpression__Group__1__Impl_in_rule__MultExpression__Group__13931);
            rule__MultExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group__1"


    // $ANTLR start "rule__MultExpression__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1957:1: rule__MultExpression__Group__1__Impl : ( ( rule__MultExpression__Alternatives_1 )? ) ;
    public final void rule__MultExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1961:1: ( ( ( rule__MultExpression__Alternatives_1 )? ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1962:1: ( ( rule__MultExpression__Alternatives_1 )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1962:1: ( ( rule__MultExpression__Alternatives_1 )? )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1963:1: ( rule__MultExpression__Alternatives_1 )?
            {
             before(grammarAccess.getMultExpressionAccess().getAlternatives_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1964:1: ( rule__MultExpression__Alternatives_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==13||(LA16_0>=21 && LA16_0<=22)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1964:2: rule__MultExpression__Alternatives_1
                    {
                    pushFollow(FOLLOW_rule__MultExpression__Alternatives_1_in_rule__MultExpression__Group__1__Impl3958);
                    rule__MultExpression__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultExpressionAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group__1__Impl"


    // $ANTLR start "rule__MultExpression__Group_1_0__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1978:1: rule__MultExpression__Group_1_0__0 : rule__MultExpression__Group_1_0__0__Impl rule__MultExpression__Group_1_0__1 ;
    public final void rule__MultExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1982:1: ( rule__MultExpression__Group_1_0__0__Impl rule__MultExpression__Group_1_0__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1983:2: rule__MultExpression__Group_1_0__0__Impl rule__MultExpression__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__MultExpression__Group_1_0__0__Impl_in_rule__MultExpression__Group_1_0__03993);
            rule__MultExpression__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultExpression__Group_1_0__1_in_rule__MultExpression__Group_1_0__03996);
            rule__MultExpression__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_0__0"


    // $ANTLR start "rule__MultExpression__Group_1_0__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1990:1: rule__MultExpression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__MultExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1994:1: ( ( () ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1995:1: ( () )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1995:1: ( () )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1996:1: ()
            {
             before(grammarAccess.getMultExpressionAccess().getStarBodyAction_1_0_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1997:1: ()
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:1999:1: 
            {
            }

             after(grammarAccess.getMultExpressionAccess().getStarBodyAction_1_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__MultExpression__Group_1_0__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2009:1: rule__MultExpression__Group_1_0__1 : rule__MultExpression__Group_1_0__1__Impl ;
    public final void rule__MultExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2013:1: ( rule__MultExpression__Group_1_0__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2014:2: rule__MultExpression__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__MultExpression__Group_1_0__1__Impl_in_rule__MultExpression__Group_1_0__14054);
            rule__MultExpression__Group_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_0__1"


    // $ANTLR start "rule__MultExpression__Group_1_0__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2020:1: rule__MultExpression__Group_1_0__1__Impl : ( '*' ) ;
    public final void rule__MultExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2024:1: ( ( '*' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2025:1: ( '*' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2025:1: ( '*' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2026:1: '*'
            {
             before(grammarAccess.getMultExpressionAccess().getAsteriskKeyword_1_0_1()); 
            match(input,21,FOLLOW_21_in_rule__MultExpression__Group_1_0__1__Impl4082); 
             after(grammarAccess.getMultExpressionAccess().getAsteriskKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_0__1__Impl"


    // $ANTLR start "rule__MultExpression__Group_1_1__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2043:1: rule__MultExpression__Group_1_1__0 : rule__MultExpression__Group_1_1__0__Impl rule__MultExpression__Group_1_1__1 ;
    public final void rule__MultExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2047:1: ( rule__MultExpression__Group_1_1__0__Impl rule__MultExpression__Group_1_1__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2048:2: rule__MultExpression__Group_1_1__0__Impl rule__MultExpression__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__MultExpression__Group_1_1__0__Impl_in_rule__MultExpression__Group_1_1__04117);
            rule__MultExpression__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultExpression__Group_1_1__1_in_rule__MultExpression__Group_1_1__04120);
            rule__MultExpression__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_1__0"


    // $ANTLR start "rule__MultExpression__Group_1_1__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2055:1: rule__MultExpression__Group_1_1__0__Impl : ( () ) ;
    public final void rule__MultExpression__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2059:1: ( ( () ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2060:1: ( () )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2060:1: ( () )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2061:1: ()
            {
             before(grammarAccess.getMultExpressionAccess().getPlusBodyAction_1_1_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2062:1: ()
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2064:1: 
            {
            }

             after(grammarAccess.getMultExpressionAccess().getPlusBodyAction_1_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_1__0__Impl"


    // $ANTLR start "rule__MultExpression__Group_1_1__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2074:1: rule__MultExpression__Group_1_1__1 : rule__MultExpression__Group_1_1__1__Impl ;
    public final void rule__MultExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2078:1: ( rule__MultExpression__Group_1_1__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2079:2: rule__MultExpression__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__MultExpression__Group_1_1__1__Impl_in_rule__MultExpression__Group_1_1__14178);
            rule__MultExpression__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_1__1"


    // $ANTLR start "rule__MultExpression__Group_1_1__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2085:1: rule__MultExpression__Group_1_1__1__Impl : ( '+' ) ;
    public final void rule__MultExpression__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2089:1: ( ( '+' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2090:1: ( '+' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2090:1: ( '+' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2091:1: '+'
            {
             before(grammarAccess.getMultExpressionAccess().getPlusSignKeyword_1_1_1()); 
            match(input,22,FOLLOW_22_in_rule__MultExpression__Group_1_1__1__Impl4206); 
             after(grammarAccess.getMultExpressionAccess().getPlusSignKeyword_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_1__1__Impl"


    // $ANTLR start "rule__MultExpression__Group_1_2__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2108:1: rule__MultExpression__Group_1_2__0 : rule__MultExpression__Group_1_2__0__Impl rule__MultExpression__Group_1_2__1 ;
    public final void rule__MultExpression__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2112:1: ( rule__MultExpression__Group_1_2__0__Impl rule__MultExpression__Group_1_2__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2113:2: rule__MultExpression__Group_1_2__0__Impl rule__MultExpression__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__MultExpression__Group_1_2__0__Impl_in_rule__MultExpression__Group_1_2__04241);
            rule__MultExpression__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultExpression__Group_1_2__1_in_rule__MultExpression__Group_1_2__04244);
            rule__MultExpression__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_2__0"


    // $ANTLR start "rule__MultExpression__Group_1_2__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2120:1: rule__MultExpression__Group_1_2__0__Impl : ( () ) ;
    public final void rule__MultExpression__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2124:1: ( ( () ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2125:1: ( () )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2125:1: ( () )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2126:1: ()
            {
             before(grammarAccess.getMultExpressionAccess().getCardinalityBodyAction_1_2_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2127:1: ()
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2129:1: 
            {
            }

             after(grammarAccess.getMultExpressionAccess().getCardinalityBodyAction_1_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_2__0__Impl"


    // $ANTLR start "rule__MultExpression__Group_1_2__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2139:1: rule__MultExpression__Group_1_2__1 : rule__MultExpression__Group_1_2__1__Impl rule__MultExpression__Group_1_2__2 ;
    public final void rule__MultExpression__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2143:1: ( rule__MultExpression__Group_1_2__1__Impl rule__MultExpression__Group_1_2__2 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2144:2: rule__MultExpression__Group_1_2__1__Impl rule__MultExpression__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__MultExpression__Group_1_2__1__Impl_in_rule__MultExpression__Group_1_2__14302);
            rule__MultExpression__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultExpression__Group_1_2__2_in_rule__MultExpression__Group_1_2__14305);
            rule__MultExpression__Group_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_2__1"


    // $ANTLR start "rule__MultExpression__Group_1_2__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2151:1: rule__MultExpression__Group_1_2__1__Impl : ( '{' ) ;
    public final void rule__MultExpression__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2155:1: ( ( '{' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2156:1: ( '{' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2156:1: ( '{' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2157:1: '{'
            {
             before(grammarAccess.getMultExpressionAccess().getLeftCurlyBracketKeyword_1_2_1()); 
            match(input,13,FOLLOW_13_in_rule__MultExpression__Group_1_2__1__Impl4333); 
             after(grammarAccess.getMultExpressionAccess().getLeftCurlyBracketKeyword_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_2__1__Impl"


    // $ANTLR start "rule__MultExpression__Group_1_2__2"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2170:1: rule__MultExpression__Group_1_2__2 : rule__MultExpression__Group_1_2__2__Impl rule__MultExpression__Group_1_2__3 ;
    public final void rule__MultExpression__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2174:1: ( rule__MultExpression__Group_1_2__2__Impl rule__MultExpression__Group_1_2__3 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2175:2: rule__MultExpression__Group_1_2__2__Impl rule__MultExpression__Group_1_2__3
            {
            pushFollow(FOLLOW_rule__MultExpression__Group_1_2__2__Impl_in_rule__MultExpression__Group_1_2__24364);
            rule__MultExpression__Group_1_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultExpression__Group_1_2__3_in_rule__MultExpression__Group_1_2__24367);
            rule__MultExpression__Group_1_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_2__2"


    // $ANTLR start "rule__MultExpression__Group_1_2__2__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2182:1: rule__MultExpression__Group_1_2__2__Impl : ( ( rule__MultExpression__NAssignment_1_2_2 ) ) ;
    public final void rule__MultExpression__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2186:1: ( ( ( rule__MultExpression__NAssignment_1_2_2 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2187:1: ( ( rule__MultExpression__NAssignment_1_2_2 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2187:1: ( ( rule__MultExpression__NAssignment_1_2_2 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2188:1: ( rule__MultExpression__NAssignment_1_2_2 )
            {
             before(grammarAccess.getMultExpressionAccess().getNAssignment_1_2_2()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2189:1: ( rule__MultExpression__NAssignment_1_2_2 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2189:2: rule__MultExpression__NAssignment_1_2_2
            {
            pushFollow(FOLLOW_rule__MultExpression__NAssignment_1_2_2_in_rule__MultExpression__Group_1_2__2__Impl4394);
            rule__MultExpression__NAssignment_1_2_2();

            state._fsp--;


            }

             after(grammarAccess.getMultExpressionAccess().getNAssignment_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_2__2__Impl"


    // $ANTLR start "rule__MultExpression__Group_1_2__3"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2199:1: rule__MultExpression__Group_1_2__3 : rule__MultExpression__Group_1_2__3__Impl ;
    public final void rule__MultExpression__Group_1_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2203:1: ( rule__MultExpression__Group_1_2__3__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2204:2: rule__MultExpression__Group_1_2__3__Impl
            {
            pushFollow(FOLLOW_rule__MultExpression__Group_1_2__3__Impl_in_rule__MultExpression__Group_1_2__34424);
            rule__MultExpression__Group_1_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_2__3"


    // $ANTLR start "rule__MultExpression__Group_1_2__3__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2210:1: rule__MultExpression__Group_1_2__3__Impl : ( '}' ) ;
    public final void rule__MultExpression__Group_1_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2214:1: ( ( '}' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2215:1: ( '}' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2215:1: ( '}' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2216:1: '}'
            {
             before(grammarAccess.getMultExpressionAccess().getRightCurlyBracketKeyword_1_2_3()); 
            match(input,14,FOLLOW_14_in_rule__MultExpression__Group_1_2__3__Impl4452); 
             after(grammarAccess.getMultExpressionAccess().getRightCurlyBracketKeyword_1_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1_2__3__Impl"


    // $ANTLR start "rule__ParenExpression__Group_0__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2237:1: rule__ParenExpression__Group_0__0 : rule__ParenExpression__Group_0__0__Impl rule__ParenExpression__Group_0__1 ;
    public final void rule__ParenExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2241:1: ( rule__ParenExpression__Group_0__0__Impl rule__ParenExpression__Group_0__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2242:2: rule__ParenExpression__Group_0__0__Impl rule__ParenExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__ParenExpression__Group_0__0__Impl_in_rule__ParenExpression__Group_0__04491);
            rule__ParenExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParenExpression__Group_0__1_in_rule__ParenExpression__Group_0__04494);
            rule__ParenExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenExpression__Group_0__0"


    // $ANTLR start "rule__ParenExpression__Group_0__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2249:1: rule__ParenExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__ParenExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2253:1: ( ( '(' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2254:1: ( '(' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2254:1: ( '(' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2255:1: '('
            {
             before(grammarAccess.getParenExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,23,FOLLOW_23_in_rule__ParenExpression__Group_0__0__Impl4522); 
             after(grammarAccess.getParenExpressionAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenExpression__Group_0__0__Impl"


    // $ANTLR start "rule__ParenExpression__Group_0__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2268:1: rule__ParenExpression__Group_0__1 : rule__ParenExpression__Group_0__1__Impl rule__ParenExpression__Group_0__2 ;
    public final void rule__ParenExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2272:1: ( rule__ParenExpression__Group_0__1__Impl rule__ParenExpression__Group_0__2 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2273:2: rule__ParenExpression__Group_0__1__Impl rule__ParenExpression__Group_0__2
            {
            pushFollow(FOLLOW_rule__ParenExpression__Group_0__1__Impl_in_rule__ParenExpression__Group_0__14553);
            rule__ParenExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParenExpression__Group_0__2_in_rule__ParenExpression__Group_0__14556);
            rule__ParenExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenExpression__Group_0__1"


    // $ANTLR start "rule__ParenExpression__Group_0__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2280:1: rule__ParenExpression__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__ParenExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2284:1: ( ( ruleExpression ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2285:1: ( ruleExpression )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2285:1: ( ruleExpression )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2286:1: ruleExpression
            {
             before(grammarAccess.getParenExpressionAccess().getExpressionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ParenExpression__Group_0__1__Impl4583);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getParenExpressionAccess().getExpressionParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenExpression__Group_0__1__Impl"


    // $ANTLR start "rule__ParenExpression__Group_0__2"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2297:1: rule__ParenExpression__Group_0__2 : rule__ParenExpression__Group_0__2__Impl ;
    public final void rule__ParenExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2301:1: ( rule__ParenExpression__Group_0__2__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2302:2: rule__ParenExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__ParenExpression__Group_0__2__Impl_in_rule__ParenExpression__Group_0__24612);
            rule__ParenExpression__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenExpression__Group_0__2"


    // $ANTLR start "rule__ParenExpression__Group_0__2__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2308:1: rule__ParenExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__ParenExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2312:1: ( ( ')' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2313:1: ( ')' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2313:1: ( ')' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2314:1: ')'
            {
             before(grammarAccess.getParenExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,24,FOLLOW_24_in_rule__ParenExpression__Group_0__2__Impl4640); 
             after(grammarAccess.getParenExpressionAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenExpression__Group_0__2__Impl"


    // $ANTLR start "rule__Any__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2333:1: rule__Any__Group__0 : rule__Any__Group__0__Impl rule__Any__Group__1 ;
    public final void rule__Any__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2337:1: ( rule__Any__Group__0__Impl rule__Any__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2338:2: rule__Any__Group__0__Impl rule__Any__Group__1
            {
            pushFollow(FOLLOW_rule__Any__Group__0__Impl_in_rule__Any__Group__04677);
            rule__Any__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Any__Group__1_in_rule__Any__Group__04680);
            rule__Any__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Any__Group__0"


    // $ANTLR start "rule__Any__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2345:1: rule__Any__Group__0__Impl : ( () ) ;
    public final void rule__Any__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2349:1: ( ( () ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2350:1: ( () )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2350:1: ( () )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2351:1: ()
            {
             before(grammarAccess.getAnyAccess().getAnyAction_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2352:1: ()
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2354:1: 
            {
            }

             after(grammarAccess.getAnyAccess().getAnyAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Any__Group__0__Impl"


    // $ANTLR start "rule__Any__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2364:1: rule__Any__Group__1 : rule__Any__Group__1__Impl ;
    public final void rule__Any__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2368:1: ( rule__Any__Group__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2369:2: rule__Any__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Any__Group__1__Impl_in_rule__Any__Group__14738);
            rule__Any__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Any__Group__1"


    // $ANTLR start "rule__Any__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2375:1: rule__Any__Group__1__Impl : ( 'S' ) ;
    public final void rule__Any__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2379:1: ( ( 'S' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2380:1: ( 'S' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2380:1: ( 'S' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2381:1: 'S'
            {
             before(grammarAccess.getAnyAccess().getSKeyword_1()); 
            match(input,25,FOLLOW_25_in_rule__Any__Group__1__Impl4766); 
             after(grammarAccess.getAnyAccess().getSKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Any__Group__1__Impl"


    // $ANTLR start "rule__Inverse__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2398:1: rule__Inverse__Group__0 : rule__Inverse__Group__0__Impl rule__Inverse__Group__1 ;
    public final void rule__Inverse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2402:1: ( rule__Inverse__Group__0__Impl rule__Inverse__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2403:2: rule__Inverse__Group__0__Impl rule__Inverse__Group__1
            {
            pushFollow(FOLLOW_rule__Inverse__Group__0__Impl_in_rule__Inverse__Group__04801);
            rule__Inverse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Inverse__Group__1_in_rule__Inverse__Group__04804);
            rule__Inverse__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__0"


    // $ANTLR start "rule__Inverse__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2410:1: rule__Inverse__Group__0__Impl : ( '(' ) ;
    public final void rule__Inverse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2414:1: ( ( '(' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2415:1: ( '(' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2415:1: ( '(' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2416:1: '('
            {
             before(grammarAccess.getInverseAccess().getLeftParenthesisKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__Inverse__Group__0__Impl4832); 
             after(grammarAccess.getInverseAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__0__Impl"


    // $ANTLR start "rule__Inverse__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2429:1: rule__Inverse__Group__1 : rule__Inverse__Group__1__Impl rule__Inverse__Group__2 ;
    public final void rule__Inverse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2433:1: ( rule__Inverse__Group__1__Impl rule__Inverse__Group__2 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2434:2: rule__Inverse__Group__1__Impl rule__Inverse__Group__2
            {
            pushFollow(FOLLOW_rule__Inverse__Group__1__Impl_in_rule__Inverse__Group__14863);
            rule__Inverse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Inverse__Group__2_in_rule__Inverse__Group__14866);
            rule__Inverse__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__1"


    // $ANTLR start "rule__Inverse__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2441:1: rule__Inverse__Group__1__Impl : ( 'S' ) ;
    public final void rule__Inverse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2445:1: ( ( 'S' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2446:1: ( 'S' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2446:1: ( 'S' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2447:1: 'S'
            {
             before(grammarAccess.getInverseAccess().getSKeyword_1()); 
            match(input,25,FOLLOW_25_in_rule__Inverse__Group__1__Impl4894); 
             after(grammarAccess.getInverseAccess().getSKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__1__Impl"


    // $ANTLR start "rule__Inverse__Group__2"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2460:1: rule__Inverse__Group__2 : rule__Inverse__Group__2__Impl rule__Inverse__Group__3 ;
    public final void rule__Inverse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2464:1: ( rule__Inverse__Group__2__Impl rule__Inverse__Group__3 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2465:2: rule__Inverse__Group__2__Impl rule__Inverse__Group__3
            {
            pushFollow(FOLLOW_rule__Inverse__Group__2__Impl_in_rule__Inverse__Group__24925);
            rule__Inverse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Inverse__Group__3_in_rule__Inverse__Group__24928);
            rule__Inverse__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__2"


    // $ANTLR start "rule__Inverse__Group__2__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2472:1: rule__Inverse__Group__2__Impl : ( '\\\\' ) ;
    public final void rule__Inverse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2476:1: ( ( '\\\\' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2477:1: ( '\\\\' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2477:1: ( '\\\\' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2478:1: '\\\\'
            {
             before(grammarAccess.getInverseAccess().getReverseSolidusKeyword_2()); 
            match(input,26,FOLLOW_26_in_rule__Inverse__Group__2__Impl4956); 
             after(grammarAccess.getInverseAccess().getReverseSolidusKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__2__Impl"


    // $ANTLR start "rule__Inverse__Group__3"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2491:1: rule__Inverse__Group__3 : rule__Inverse__Group__3__Impl rule__Inverse__Group__4 ;
    public final void rule__Inverse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2495:1: ( rule__Inverse__Group__3__Impl rule__Inverse__Group__4 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2496:2: rule__Inverse__Group__3__Impl rule__Inverse__Group__4
            {
            pushFollow(FOLLOW_rule__Inverse__Group__3__Impl_in_rule__Inverse__Group__34987);
            rule__Inverse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Inverse__Group__4_in_rule__Inverse__Group__34990);
            rule__Inverse__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__3"


    // $ANTLR start "rule__Inverse__Group__3__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2503:1: rule__Inverse__Group__3__Impl : ( ( rule__Inverse__ExcludesAssignment_3 ) ) ;
    public final void rule__Inverse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2507:1: ( ( ( rule__Inverse__ExcludesAssignment_3 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2508:1: ( ( rule__Inverse__ExcludesAssignment_3 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2508:1: ( ( rule__Inverse__ExcludesAssignment_3 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2509:1: ( rule__Inverse__ExcludesAssignment_3 )
            {
             before(grammarAccess.getInverseAccess().getExcludesAssignment_3()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2510:1: ( rule__Inverse__ExcludesAssignment_3 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2510:2: rule__Inverse__ExcludesAssignment_3
            {
            pushFollow(FOLLOW_rule__Inverse__ExcludesAssignment_3_in_rule__Inverse__Group__3__Impl5017);
            rule__Inverse__ExcludesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getInverseAccess().getExcludesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__3__Impl"


    // $ANTLR start "rule__Inverse__Group__4"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2520:1: rule__Inverse__Group__4 : rule__Inverse__Group__4__Impl rule__Inverse__Group__5 ;
    public final void rule__Inverse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2524:1: ( rule__Inverse__Group__4__Impl rule__Inverse__Group__5 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2525:2: rule__Inverse__Group__4__Impl rule__Inverse__Group__5
            {
            pushFollow(FOLLOW_rule__Inverse__Group__4__Impl_in_rule__Inverse__Group__45047);
            rule__Inverse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Inverse__Group__5_in_rule__Inverse__Group__45050);
            rule__Inverse__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__4"


    // $ANTLR start "rule__Inverse__Group__4__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2532:1: rule__Inverse__Group__4__Impl : ( ( rule__Inverse__Group_4__0 )* ) ;
    public final void rule__Inverse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2536:1: ( ( ( rule__Inverse__Group_4__0 )* ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2537:1: ( ( rule__Inverse__Group_4__0 )* )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2537:1: ( ( rule__Inverse__Group_4__0 )* )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2538:1: ( rule__Inverse__Group_4__0 )*
            {
             before(grammarAccess.getInverseAccess().getGroup_4()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2539:1: ( rule__Inverse__Group_4__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==15) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2539:2: rule__Inverse__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__Inverse__Group_4__0_in_rule__Inverse__Group__4__Impl5077);
            	    rule__Inverse__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getInverseAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__4__Impl"


    // $ANTLR start "rule__Inverse__Group__5"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2549:1: rule__Inverse__Group__5 : rule__Inverse__Group__5__Impl ;
    public final void rule__Inverse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2553:1: ( rule__Inverse__Group__5__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2554:2: rule__Inverse__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Inverse__Group__5__Impl_in_rule__Inverse__Group__55108);
            rule__Inverse__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__5"


    // $ANTLR start "rule__Inverse__Group__5__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2560:1: rule__Inverse__Group__5__Impl : ( ')' ) ;
    public final void rule__Inverse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2564:1: ( ( ')' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2565:1: ( ')' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2565:1: ( ')' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2566:1: ')'
            {
             before(grammarAccess.getInverseAccess().getRightParenthesisKeyword_5()); 
            match(input,24,FOLLOW_24_in_rule__Inverse__Group__5__Impl5136); 
             after(grammarAccess.getInverseAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group__5__Impl"


    // $ANTLR start "rule__Inverse__Group_4__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2591:1: rule__Inverse__Group_4__0 : rule__Inverse__Group_4__0__Impl rule__Inverse__Group_4__1 ;
    public final void rule__Inverse__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2595:1: ( rule__Inverse__Group_4__0__Impl rule__Inverse__Group_4__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2596:2: rule__Inverse__Group_4__0__Impl rule__Inverse__Group_4__1
            {
            pushFollow(FOLLOW_rule__Inverse__Group_4__0__Impl_in_rule__Inverse__Group_4__05179);
            rule__Inverse__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Inverse__Group_4__1_in_rule__Inverse__Group_4__05182);
            rule__Inverse__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group_4__0"


    // $ANTLR start "rule__Inverse__Group_4__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2603:1: rule__Inverse__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Inverse__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2607:1: ( ( ',' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2608:1: ( ',' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2608:1: ( ',' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2609:1: ','
            {
             before(grammarAccess.getInverseAccess().getCommaKeyword_4_0()); 
            match(input,15,FOLLOW_15_in_rule__Inverse__Group_4__0__Impl5210); 
             after(grammarAccess.getInverseAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group_4__0__Impl"


    // $ANTLR start "rule__Inverse__Group_4__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2622:1: rule__Inverse__Group_4__1 : rule__Inverse__Group_4__1__Impl ;
    public final void rule__Inverse__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2626:1: ( rule__Inverse__Group_4__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2627:2: rule__Inverse__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Inverse__Group_4__1__Impl_in_rule__Inverse__Group_4__15241);
            rule__Inverse__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group_4__1"


    // $ANTLR start "rule__Inverse__Group_4__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2633:1: rule__Inverse__Group_4__1__Impl : ( ( rule__Inverse__ExcludesAssignment_4_1 ) ) ;
    public final void rule__Inverse__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2637:1: ( ( ( rule__Inverse__ExcludesAssignment_4_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2638:1: ( ( rule__Inverse__ExcludesAssignment_4_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2638:1: ( ( rule__Inverse__ExcludesAssignment_4_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2639:1: ( rule__Inverse__ExcludesAssignment_4_1 )
            {
             before(grammarAccess.getInverseAccess().getExcludesAssignment_4_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2640:1: ( rule__Inverse__ExcludesAssignment_4_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2640:2: rule__Inverse__ExcludesAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Inverse__ExcludesAssignment_4_1_in_rule__Inverse__Group_4__1__Impl5268);
            rule__Inverse__ExcludesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getInverseAccess().getExcludesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__Group_4__1__Impl"


    // $ANTLR start "rule__TimedExpression__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2654:1: rule__TimedExpression__Group__0 : rule__TimedExpression__Group__0__Impl rule__TimedExpression__Group__1 ;
    public final void rule__TimedExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2658:1: ( rule__TimedExpression__Group__0__Impl rule__TimedExpression__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2659:2: rule__TimedExpression__Group__0__Impl rule__TimedExpression__Group__1
            {
            pushFollow(FOLLOW_rule__TimedExpression__Group__0__Impl_in_rule__TimedExpression__Group__05302);
            rule__TimedExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TimedExpression__Group__1_in_rule__TimedExpression__Group__05305);
            rule__TimedExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__0"


    // $ANTLR start "rule__TimedExpression__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2666:1: rule__TimedExpression__Group__0__Impl : ( '<' ) ;
    public final void rule__TimedExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2670:1: ( ( '<' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2671:1: ( '<' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2671:1: ( '<' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2672:1: '<'
            {
             before(grammarAccess.getTimedExpressionAccess().getLessThanSignKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__TimedExpression__Group__0__Impl5333); 
             after(grammarAccess.getTimedExpressionAccess().getLessThanSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__0__Impl"


    // $ANTLR start "rule__TimedExpression__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2685:1: rule__TimedExpression__Group__1 : rule__TimedExpression__Group__1__Impl rule__TimedExpression__Group__2 ;
    public final void rule__TimedExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2689:1: ( rule__TimedExpression__Group__1__Impl rule__TimedExpression__Group__2 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2690:2: rule__TimedExpression__Group__1__Impl rule__TimedExpression__Group__2
            {
            pushFollow(FOLLOW_rule__TimedExpression__Group__1__Impl_in_rule__TimedExpression__Group__15364);
            rule__TimedExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TimedExpression__Group__2_in_rule__TimedExpression__Group__15367);
            rule__TimedExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__1"


    // $ANTLR start "rule__TimedExpression__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2697:1: rule__TimedExpression__Group__1__Impl : ( ( rule__TimedExpression__BodyAssignment_1 ) ) ;
    public final void rule__TimedExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2701:1: ( ( ( rule__TimedExpression__BodyAssignment_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2702:1: ( ( rule__TimedExpression__BodyAssignment_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2702:1: ( ( rule__TimedExpression__BodyAssignment_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2703:1: ( rule__TimedExpression__BodyAssignment_1 )
            {
             before(grammarAccess.getTimedExpressionAccess().getBodyAssignment_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2704:1: ( rule__TimedExpression__BodyAssignment_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2704:2: rule__TimedExpression__BodyAssignment_1
            {
            pushFollow(FOLLOW_rule__TimedExpression__BodyAssignment_1_in_rule__TimedExpression__Group__1__Impl5394);
            rule__TimedExpression__BodyAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTimedExpressionAccess().getBodyAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__1__Impl"


    // $ANTLR start "rule__TimedExpression__Group__2"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2714:1: rule__TimedExpression__Group__2 : rule__TimedExpression__Group__2__Impl rule__TimedExpression__Group__3 ;
    public final void rule__TimedExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2718:1: ( rule__TimedExpression__Group__2__Impl rule__TimedExpression__Group__3 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2719:2: rule__TimedExpression__Group__2__Impl rule__TimedExpression__Group__3
            {
            pushFollow(FOLLOW_rule__TimedExpression__Group__2__Impl_in_rule__TimedExpression__Group__25424);
            rule__TimedExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TimedExpression__Group__3_in_rule__TimedExpression__Group__25427);
            rule__TimedExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__2"


    // $ANTLR start "rule__TimedExpression__Group__2__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2726:1: rule__TimedExpression__Group__2__Impl : ( '>' ) ;
    public final void rule__TimedExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2730:1: ( ( '>' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2731:1: ( '>' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2731:1: ( '>' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2732:1: '>'
            {
             before(grammarAccess.getTimedExpressionAccess().getGreaterThanSignKeyword_2()); 
            match(input,28,FOLLOW_28_in_rule__TimedExpression__Group__2__Impl5455); 
             after(grammarAccess.getTimedExpressionAccess().getGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__2__Impl"


    // $ANTLR start "rule__TimedExpression__Group__3"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2745:1: rule__TimedExpression__Group__3 : rule__TimedExpression__Group__3__Impl rule__TimedExpression__Group__4 ;
    public final void rule__TimedExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2749:1: ( rule__TimedExpression__Group__3__Impl rule__TimedExpression__Group__4 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2750:2: rule__TimedExpression__Group__3__Impl rule__TimedExpression__Group__4
            {
            pushFollow(FOLLOW_rule__TimedExpression__Group__3__Impl_in_rule__TimedExpression__Group__35486);
            rule__TimedExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TimedExpression__Group__4_in_rule__TimedExpression__Group__35489);
            rule__TimedExpression__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__3"


    // $ANTLR start "rule__TimedExpression__Group__3__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2757:1: rule__TimedExpression__Group__3__Impl : ( '[' ) ;
    public final void rule__TimedExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2761:1: ( ( '[' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2762:1: ( '[' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2762:1: ( '[' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2763:1: '['
            {
             before(grammarAccess.getTimedExpressionAccess().getLeftSquareBracketKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__TimedExpression__Group__3__Impl5517); 
             after(grammarAccess.getTimedExpressionAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__3__Impl"


    // $ANTLR start "rule__TimedExpression__Group__4"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2776:1: rule__TimedExpression__Group__4 : rule__TimedExpression__Group__4__Impl rule__TimedExpression__Group__5 ;
    public final void rule__TimedExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2780:1: ( rule__TimedExpression__Group__4__Impl rule__TimedExpression__Group__5 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2781:2: rule__TimedExpression__Group__4__Impl rule__TimedExpression__Group__5
            {
            pushFollow(FOLLOW_rule__TimedExpression__Group__4__Impl_in_rule__TimedExpression__Group__45548);
            rule__TimedExpression__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TimedExpression__Group__5_in_rule__TimedExpression__Group__45551);
            rule__TimedExpression__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__4"


    // $ANTLR start "rule__TimedExpression__Group__4__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2788:1: rule__TimedExpression__Group__4__Impl : ( ( rule__TimedExpression__TimeoutAssignment_4 ) ) ;
    public final void rule__TimedExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2792:1: ( ( ( rule__TimedExpression__TimeoutAssignment_4 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2793:1: ( ( rule__TimedExpression__TimeoutAssignment_4 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2793:1: ( ( rule__TimedExpression__TimeoutAssignment_4 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2794:1: ( rule__TimedExpression__TimeoutAssignment_4 )
            {
             before(grammarAccess.getTimedExpressionAccess().getTimeoutAssignment_4()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2795:1: ( rule__TimedExpression__TimeoutAssignment_4 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2795:2: rule__TimedExpression__TimeoutAssignment_4
            {
            pushFollow(FOLLOW_rule__TimedExpression__TimeoutAssignment_4_in_rule__TimedExpression__Group__4__Impl5578);
            rule__TimedExpression__TimeoutAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTimedExpressionAccess().getTimeoutAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__4__Impl"


    // $ANTLR start "rule__TimedExpression__Group__5"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2805:1: rule__TimedExpression__Group__5 : rule__TimedExpression__Group__5__Impl ;
    public final void rule__TimedExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2809:1: ( rule__TimedExpression__Group__5__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2810:2: rule__TimedExpression__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__TimedExpression__Group__5__Impl_in_rule__TimedExpression__Group__55608);
            rule__TimedExpression__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__5"


    // $ANTLR start "rule__TimedExpression__Group__5__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2816:1: rule__TimedExpression__Group__5__Impl : ( ']' ) ;
    public final void rule__TimedExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2820:1: ( ( ']' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2821:1: ( ']' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2821:1: ( ']' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2822:1: ']'
            {
             before(grammarAccess.getTimedExpressionAccess().getRightSquareBracketKeyword_5()); 
            match(input,19,FOLLOW_19_in_rule__TimedExpression__Group__5__Impl5636); 
             after(grammarAccess.getTimedExpressionAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__Group__5__Impl"


    // $ANTLR start "rule__Event__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2847:1: rule__Event__Group__0 : rule__Event__Group__0__Impl rule__Event__Group__1 ;
    public final void rule__Event__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2851:1: ( rule__Event__Group__0__Impl rule__Event__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2852:2: rule__Event__Group__0__Impl rule__Event__Group__1
            {
            pushFollow(FOLLOW_rule__Event__Group__0__Impl_in_rule__Event__Group__05679);
            rule__Event__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Event__Group__1_in_rule__Event__Group__05682);
            rule__Event__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group__0"


    // $ANTLR start "rule__Event__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2859:1: rule__Event__Group__0__Impl : ( ( rule__Event__FunctorAssignment_0 ) ) ;
    public final void rule__Event__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2863:1: ( ( ( rule__Event__FunctorAssignment_0 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2864:1: ( ( rule__Event__FunctorAssignment_0 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2864:1: ( ( rule__Event__FunctorAssignment_0 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2865:1: ( rule__Event__FunctorAssignment_0 )
            {
             before(grammarAccess.getEventAccess().getFunctorAssignment_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2866:1: ( rule__Event__FunctorAssignment_0 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2866:2: rule__Event__FunctorAssignment_0
            {
            pushFollow(FOLLOW_rule__Event__FunctorAssignment_0_in_rule__Event__Group__0__Impl5709);
            rule__Event__FunctorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getFunctorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group__0__Impl"


    // $ANTLR start "rule__Event__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2876:1: rule__Event__Group__1 : rule__Event__Group__1__Impl ;
    public final void rule__Event__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2880:1: ( rule__Event__Group__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2881:2: rule__Event__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Event__Group__1__Impl_in_rule__Event__Group__15739);
            rule__Event__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group__1"


    // $ANTLR start "rule__Event__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2887:1: rule__Event__Group__1__Impl : ( ( rule__Event__Group_1__0 )? ) ;
    public final void rule__Event__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2891:1: ( ( ( rule__Event__Group_1__0 )? ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2892:1: ( ( rule__Event__Group_1__0 )? )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2892:1: ( ( rule__Event__Group_1__0 )? )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2893:1: ( rule__Event__Group_1__0 )?
            {
             before(grammarAccess.getEventAccess().getGroup_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2894:1: ( rule__Event__Group_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2894:2: rule__Event__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Event__Group_1__0_in_rule__Event__Group__1__Impl5766);
                    rule__Event__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEventAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group__1__Impl"


    // $ANTLR start "rule__Event__Group_1__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2908:1: rule__Event__Group_1__0 : rule__Event__Group_1__0__Impl rule__Event__Group_1__1 ;
    public final void rule__Event__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2912:1: ( rule__Event__Group_1__0__Impl rule__Event__Group_1__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2913:2: rule__Event__Group_1__0__Impl rule__Event__Group_1__1
            {
            pushFollow(FOLLOW_rule__Event__Group_1__0__Impl_in_rule__Event__Group_1__05801);
            rule__Event__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Event__Group_1__1_in_rule__Event__Group_1__05804);
            rule__Event__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1__0"


    // $ANTLR start "rule__Event__Group_1__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2920:1: rule__Event__Group_1__0__Impl : ( '[' ) ;
    public final void rule__Event__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2924:1: ( ( '[' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2925:1: ( '[' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2925:1: ( '[' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2926:1: '['
            {
             before(grammarAccess.getEventAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,18,FOLLOW_18_in_rule__Event__Group_1__0__Impl5832); 
             after(grammarAccess.getEventAccess().getLeftSquareBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1__0__Impl"


    // $ANTLR start "rule__Event__Group_1__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2939:1: rule__Event__Group_1__1 : rule__Event__Group_1__1__Impl rule__Event__Group_1__2 ;
    public final void rule__Event__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2943:1: ( rule__Event__Group_1__1__Impl rule__Event__Group_1__2 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2944:2: rule__Event__Group_1__1__Impl rule__Event__Group_1__2
            {
            pushFollow(FOLLOW_rule__Event__Group_1__1__Impl_in_rule__Event__Group_1__15863);
            rule__Event__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Event__Group_1__2_in_rule__Event__Group_1__15866);
            rule__Event__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1__1"


    // $ANTLR start "rule__Event__Group_1__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2951:1: rule__Event__Group_1__1__Impl : ( ( rule__Event__ParametersAssignment_1_1 ) ) ;
    public final void rule__Event__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2955:1: ( ( ( rule__Event__ParametersAssignment_1_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2956:1: ( ( rule__Event__ParametersAssignment_1_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2956:1: ( ( rule__Event__ParametersAssignment_1_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2957:1: ( rule__Event__ParametersAssignment_1_1 )
            {
             before(grammarAccess.getEventAccess().getParametersAssignment_1_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2958:1: ( rule__Event__ParametersAssignment_1_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2958:2: rule__Event__ParametersAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Event__ParametersAssignment_1_1_in_rule__Event__Group_1__1__Impl5893);
            rule__Event__ParametersAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getParametersAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1__1__Impl"


    // $ANTLR start "rule__Event__Group_1__2"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2968:1: rule__Event__Group_1__2 : rule__Event__Group_1__2__Impl rule__Event__Group_1__3 ;
    public final void rule__Event__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2972:1: ( rule__Event__Group_1__2__Impl rule__Event__Group_1__3 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2973:2: rule__Event__Group_1__2__Impl rule__Event__Group_1__3
            {
            pushFollow(FOLLOW_rule__Event__Group_1__2__Impl_in_rule__Event__Group_1__25923);
            rule__Event__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Event__Group_1__3_in_rule__Event__Group_1__25926);
            rule__Event__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1__2"


    // $ANTLR start "rule__Event__Group_1__2__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2980:1: rule__Event__Group_1__2__Impl : ( ( rule__Event__Group_1_2__0 )* ) ;
    public final void rule__Event__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2984:1: ( ( ( rule__Event__Group_1_2__0 )* ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2985:1: ( ( rule__Event__Group_1_2__0 )* )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2985:1: ( ( rule__Event__Group_1_2__0 )* )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2986:1: ( rule__Event__Group_1_2__0 )*
            {
             before(grammarAccess.getEventAccess().getGroup_1_2()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2987:1: ( rule__Event__Group_1_2__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==15) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2987:2: rule__Event__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Event__Group_1_2__0_in_rule__Event__Group_1__2__Impl5953);
            	    rule__Event__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getEventAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1__2__Impl"


    // $ANTLR start "rule__Event__Group_1__3"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:2997:1: rule__Event__Group_1__3 : rule__Event__Group_1__3__Impl ;
    public final void rule__Event__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3001:1: ( rule__Event__Group_1__3__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3002:2: rule__Event__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Event__Group_1__3__Impl_in_rule__Event__Group_1__35984);
            rule__Event__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1__3"


    // $ANTLR start "rule__Event__Group_1__3__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3008:1: rule__Event__Group_1__3__Impl : ( ']' ) ;
    public final void rule__Event__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3012:1: ( ( ']' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3013:1: ( ']' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3013:1: ( ']' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3014:1: ']'
            {
             before(grammarAccess.getEventAccess().getRightSquareBracketKeyword_1_3()); 
            match(input,19,FOLLOW_19_in_rule__Event__Group_1__3__Impl6012); 
             after(grammarAccess.getEventAccess().getRightSquareBracketKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1__3__Impl"


    // $ANTLR start "rule__Event__Group_1_2__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3035:1: rule__Event__Group_1_2__0 : rule__Event__Group_1_2__0__Impl rule__Event__Group_1_2__1 ;
    public final void rule__Event__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3039:1: ( rule__Event__Group_1_2__0__Impl rule__Event__Group_1_2__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3040:2: rule__Event__Group_1_2__0__Impl rule__Event__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Event__Group_1_2__0__Impl_in_rule__Event__Group_1_2__06051);
            rule__Event__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Event__Group_1_2__1_in_rule__Event__Group_1_2__06054);
            rule__Event__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1_2__0"


    // $ANTLR start "rule__Event__Group_1_2__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3047:1: rule__Event__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__Event__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3051:1: ( ( ',' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3052:1: ( ',' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3052:1: ( ',' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3053:1: ','
            {
             before(grammarAccess.getEventAccess().getCommaKeyword_1_2_0()); 
            match(input,15,FOLLOW_15_in_rule__Event__Group_1_2__0__Impl6082); 
             after(grammarAccess.getEventAccess().getCommaKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1_2__0__Impl"


    // $ANTLR start "rule__Event__Group_1_2__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3066:1: rule__Event__Group_1_2__1 : rule__Event__Group_1_2__1__Impl ;
    public final void rule__Event__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3070:1: ( rule__Event__Group_1_2__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3071:2: rule__Event__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Event__Group_1_2__1__Impl_in_rule__Event__Group_1_2__16113);
            rule__Event__Group_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1_2__1"


    // $ANTLR start "rule__Event__Group_1_2__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3077:1: rule__Event__Group_1_2__1__Impl : ( ( rule__Event__ParametersAssignment_1_2_1 ) ) ;
    public final void rule__Event__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3081:1: ( ( ( rule__Event__ParametersAssignment_1_2_1 ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3082:1: ( ( rule__Event__ParametersAssignment_1_2_1 ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3082:1: ( ( rule__Event__ParametersAssignment_1_2_1 ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3083:1: ( rule__Event__ParametersAssignment_1_2_1 )
            {
             before(grammarAccess.getEventAccess().getParametersAssignment_1_2_1()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3084:1: ( rule__Event__ParametersAssignment_1_2_1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3084:2: rule__Event__ParametersAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Event__ParametersAssignment_1_2_1_in_rule__Event__Group_1_2__1__Impl6140);
            rule__Event__ParametersAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getParametersAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Group_1_2__1__Impl"


    // $ANTLR start "rule__SingletonParameter__Group__0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3098:1: rule__SingletonParameter__Group__0 : rule__SingletonParameter__Group__0__Impl rule__SingletonParameter__Group__1 ;
    public final void rule__SingletonParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3102:1: ( rule__SingletonParameter__Group__0__Impl rule__SingletonParameter__Group__1 )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3103:2: rule__SingletonParameter__Group__0__Impl rule__SingletonParameter__Group__1
            {
            pushFollow(FOLLOW_rule__SingletonParameter__Group__0__Impl_in_rule__SingletonParameter__Group__06174);
            rule__SingletonParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SingletonParameter__Group__1_in_rule__SingletonParameter__Group__06177);
            rule__SingletonParameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingletonParameter__Group__0"


    // $ANTLR start "rule__SingletonParameter__Group__0__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3110:1: rule__SingletonParameter__Group__0__Impl : ( () ) ;
    public final void rule__SingletonParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3114:1: ( ( () ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3115:1: ( () )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3115:1: ( () )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3116:1: ()
            {
             before(grammarAccess.getSingletonParameterAccess().getSingletonParameterAction_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3117:1: ()
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3119:1: 
            {
            }

             after(grammarAccess.getSingletonParameterAccess().getSingletonParameterAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingletonParameter__Group__0__Impl"


    // $ANTLR start "rule__SingletonParameter__Group__1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3129:1: rule__SingletonParameter__Group__1 : rule__SingletonParameter__Group__1__Impl ;
    public final void rule__SingletonParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3133:1: ( rule__SingletonParameter__Group__1__Impl )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3134:2: rule__SingletonParameter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SingletonParameter__Group__1__Impl_in_rule__SingletonParameter__Group__16235);
            rule__SingletonParameter__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingletonParameter__Group__1"


    // $ANTLR start "rule__SingletonParameter__Group__1__Impl"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3140:1: rule__SingletonParameter__Group__1__Impl : ( '_' ) ;
    public final void rule__SingletonParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3144:1: ( ( '_' ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3145:1: ( '_' )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3145:1: ( '_' )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3146:1: '_'
            {
             before(grammarAccess.getSingletonParameterAccess().get_Keyword_1()); 
            match(input,29,FOLLOW_29_in_rule__SingletonParameter__Group__1__Impl6263); 
             after(grammarAccess.getSingletonParameterAccess().get_Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SingletonParameter__Group__1__Impl"


    // $ANTLR start "rule__RegexModel__AlphabetAssignment_0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3164:1: rule__RegexModel__AlphabetAssignment_0 : ( ruleAlphabet ) ;
    public final void rule__RegexModel__AlphabetAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3168:1: ( ( ruleAlphabet ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3169:1: ( ruleAlphabet )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3169:1: ( ruleAlphabet )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3170:1: ruleAlphabet
            {
             before(grammarAccess.getRegexModelAccess().getAlphabetAlphabetParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAlphabet_in_rule__RegexModel__AlphabetAssignment_06303);
            ruleAlphabet();

            state._fsp--;

             after(grammarAccess.getRegexModelAccess().getAlphabetAlphabetParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexModel__AlphabetAssignment_0"


    // $ANTLR start "rule__RegexModel__DeclarationsAssignment_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3179:1: rule__RegexModel__DeclarationsAssignment_1 : ( ruleExpressionDeclaration ) ;
    public final void rule__RegexModel__DeclarationsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3183:1: ( ( ruleExpressionDeclaration ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3184:1: ( ruleExpressionDeclaration )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3184:1: ( ruleExpressionDeclaration )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3185:1: ruleExpressionDeclaration
            {
             before(grammarAccess.getRegexModelAccess().getDeclarationsExpressionDeclarationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleExpressionDeclaration_in_rule__RegexModel__DeclarationsAssignment_16334);
            ruleExpressionDeclaration();

            state._fsp--;

             after(grammarAccess.getRegexModelAccess().getDeclarationsExpressionDeclarationParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexModel__DeclarationsAssignment_1"


    // $ANTLR start "rule__Alphabet__FunctorsAssignment_4_0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3194:1: rule__Alphabet__FunctorsAssignment_4_0 : ( ruleFunctor ) ;
    public final void rule__Alphabet__FunctorsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3198:1: ( ( ruleFunctor ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3199:1: ( ruleFunctor )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3199:1: ( ruleFunctor )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3200:1: ruleFunctor
            {
             before(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_ruleFunctor_in_rule__Alphabet__FunctorsAssignment_4_06365);
            ruleFunctor();

            state._fsp--;

             after(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__FunctorsAssignment_4_0"


    // $ANTLR start "rule__Alphabet__FunctorsAssignment_4_1_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3209:1: rule__Alphabet__FunctorsAssignment_4_1_1 : ( ruleFunctor ) ;
    public final void rule__Alphabet__FunctorsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3213:1: ( ( ruleFunctor ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3214:1: ( ruleFunctor )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3214:1: ( ruleFunctor )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3215:1: ruleFunctor
            {
             before(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_ruleFunctor_in_rule__Alphabet__FunctorsAssignment_4_1_16396);
            ruleFunctor();

            state._fsp--;

             after(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alphabet__FunctorsAssignment_4_1_1"


    // $ANTLR start "rule__Functor__NameAssignment_0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3224:1: rule__Functor__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Functor__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3228:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3229:1: ( RULE_ID )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3229:1: ( RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3230:1: RULE_ID
            {
             before(grammarAccess.getFunctorAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Functor__NameAssignment_06427); 
             after(grammarAccess.getFunctorAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__NameAssignment_0"


    // $ANTLR start "rule__Functor__ArityAssignment_1_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3239:1: rule__Functor__ArityAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__Functor__ArityAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3243:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3244:1: ( RULE_INT )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3244:1: ( RULE_INT )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3245:1: RULE_INT
            {
             before(grammarAccess.getFunctorAccess().getArityINTTerminalRuleCall_1_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Functor__ArityAssignment_1_16458); 
             after(grammarAccess.getFunctorAccess().getArityINTTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Functor__ArityAssignment_1_1"


    // $ANTLR start "rule__ExpressionDeclaration__NameAssignment_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3254:1: rule__ExpressionDeclaration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ExpressionDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3258:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3259:1: ( RULE_ID )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3259:1: ( RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3260:1: RULE_ID
            {
             before(grammarAccess.getExpressionDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ExpressionDeclaration__NameAssignment_16489); 
             after(grammarAccess.getExpressionDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__NameAssignment_1"


    // $ANTLR start "rule__ExpressionDeclaration__VarsAssignment_2_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3269:1: rule__ExpressionDeclaration__VarsAssignment_2_1 : ( ruleVar ) ;
    public final void rule__ExpressionDeclaration__VarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3273:1: ( ( ruleVar ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3274:1: ( ruleVar )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3274:1: ( ruleVar )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3275:1: ruleVar
            {
             before(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleVar_in_rule__ExpressionDeclaration__VarsAssignment_2_16520);
            ruleVar();

            state._fsp--;

             after(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__VarsAssignment_2_1"


    // $ANTLR start "rule__ExpressionDeclaration__VarsAssignment_2_2_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3284:1: rule__ExpressionDeclaration__VarsAssignment_2_2_1 : ( ruleVar ) ;
    public final void rule__ExpressionDeclaration__VarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3288:1: ( ( ruleVar ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3289:1: ( ruleVar )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3289:1: ( ruleVar )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3290:1: ruleVar
            {
             before(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleVar_in_rule__ExpressionDeclaration__VarsAssignment_2_2_16551);
            ruleVar();

            state._fsp--;

             after(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__VarsAssignment_2_2_1"


    // $ANTLR start "rule__ExpressionDeclaration__BodyAssignment_4"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3299:1: rule__ExpressionDeclaration__BodyAssignment_4 : ( ruleExpression ) ;
    public final void rule__ExpressionDeclaration__BodyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3303:1: ( ( ruleExpression ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3304:1: ( ruleExpression )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3304:1: ( ruleExpression )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3305:1: ruleExpression
            {
             before(grammarAccess.getExpressionDeclarationAccess().getBodyExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ExpressionDeclaration__BodyAssignment_46582);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionDeclarationAccess().getBodyExpressionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpressionDeclaration__BodyAssignment_4"


    // $ANTLR start "rule__Choice__ElementsAssignment_1_1_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3314:1: rule__Choice__ElementsAssignment_1_1_1 : ( ruleSequence ) ;
    public final void rule__Choice__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3318:1: ( ( ruleSequence ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3319:1: ( ruleSequence )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3319:1: ( ruleSequence )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3320:1: ruleSequence
            {
             before(grammarAccess.getChoiceAccess().getElementsSequenceParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleSequence_in_rule__Choice__ElementsAssignment_1_1_16613);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getChoiceAccess().getElementsSequenceParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Choice__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__Sequence__ElementsAssignment_1_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3329:1: rule__Sequence__ElementsAssignment_1_1 : ( ruleMultExpression ) ;
    public final void rule__Sequence__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3333:1: ( ( ruleMultExpression ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3334:1: ( ruleMultExpression )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3334:1: ( ruleMultExpression )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3335:1: ruleMultExpression
            {
             before(grammarAccess.getSequenceAccess().getElementsMultExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMultExpression_in_rule__Sequence__ElementsAssignment_1_16644);
            ruleMultExpression();

            state._fsp--;

             after(grammarAccess.getSequenceAccess().getElementsMultExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sequence__ElementsAssignment_1_1"


    // $ANTLR start "rule__MultExpression__NAssignment_1_2_2"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3344:1: rule__MultExpression__NAssignment_1_2_2 : ( RULE_INT ) ;
    public final void rule__MultExpression__NAssignment_1_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3348:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3349:1: ( RULE_INT )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3349:1: ( RULE_INT )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3350:1: RULE_INT
            {
             before(grammarAccess.getMultExpressionAccess().getNINTTerminalRuleCall_1_2_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__MultExpression__NAssignment_1_2_26675); 
             after(grammarAccess.getMultExpressionAccess().getNINTTerminalRuleCall_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__NAssignment_1_2_2"


    // $ANTLR start "rule__Inverse__ExcludesAssignment_3"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3359:1: rule__Inverse__ExcludesAssignment_3 : ( ruleEvent ) ;
    public final void rule__Inverse__ExcludesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3363:1: ( ( ruleEvent ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3364:1: ( ruleEvent )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3364:1: ( ruleEvent )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3365:1: ruleEvent
            {
             before(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Inverse__ExcludesAssignment_36706);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__ExcludesAssignment_3"


    // $ANTLR start "rule__Inverse__ExcludesAssignment_4_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3374:1: rule__Inverse__ExcludesAssignment_4_1 : ( ruleEvent ) ;
    public final void rule__Inverse__ExcludesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3378:1: ( ( ruleEvent ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3379:1: ( ruleEvent )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3379:1: ( ruleEvent )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3380:1: ruleEvent
            {
             before(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Inverse__ExcludesAssignment_4_16737);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Inverse__ExcludesAssignment_4_1"


    // $ANTLR start "rule__TimedExpression__BodyAssignment_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3389:1: rule__TimedExpression__BodyAssignment_1 : ( ruleExpression ) ;
    public final void rule__TimedExpression__BodyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3393:1: ( ( ruleExpression ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3394:1: ( ruleExpression )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3394:1: ( ruleExpression )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3395:1: ruleExpression
            {
             before(grammarAccess.getTimedExpressionAccess().getBodyExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__TimedExpression__BodyAssignment_16768);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getTimedExpressionAccess().getBodyExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__BodyAssignment_1"


    // $ANTLR start "rule__TimedExpression__TimeoutAssignment_4"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3404:1: rule__TimedExpression__TimeoutAssignment_4 : ( RULE_INT ) ;
    public final void rule__TimedExpression__TimeoutAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3408:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3409:1: ( RULE_INT )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3409:1: ( RULE_INT )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3410:1: RULE_INT
            {
             before(grammarAccess.getTimedExpressionAccess().getTimeoutINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TimedExpression__TimeoutAssignment_46799); 
             after(grammarAccess.getTimedExpressionAccess().getTimeoutINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimedExpression__TimeoutAssignment_4"


    // $ANTLR start "rule__Event__FunctorAssignment_0"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3419:1: rule__Event__FunctorAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Event__FunctorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3423:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3424:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3424:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3425:1: ( RULE_ID )
            {
             before(grammarAccess.getEventAccess().getFunctorFunctorCrossReference_0_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3426:1: ( RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3427:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getFunctorFunctorIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Event__FunctorAssignment_06834); 
             after(grammarAccess.getEventAccess().getFunctorFunctorIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getEventAccess().getFunctorFunctorCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__FunctorAssignment_0"


    // $ANTLR start "rule__Event__ParametersAssignment_1_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3438:1: rule__Event__ParametersAssignment_1_1 : ( ruleParameter ) ;
    public final void rule__Event__ParametersAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3442:1: ( ( ruleParameter ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3443:1: ( ruleParameter )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3443:1: ( ruleParameter )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3444:1: ruleParameter
            {
             before(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Event__ParametersAssignment_1_16869);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__ParametersAssignment_1_1"


    // $ANTLR start "rule__Event__ParametersAssignment_1_2_1"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3453:1: rule__Event__ParametersAssignment_1_2_1 : ( ruleParameter ) ;
    public final void rule__Event__ParametersAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3457:1: ( ( ruleParameter ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3458:1: ( ruleParameter )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3458:1: ( ruleParameter )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3459:1: ruleParameter
            {
             before(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_2_1_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Event__ParametersAssignment_1_2_16900);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__ParametersAssignment_1_2_1"


    // $ANTLR start "rule__FixIntParameter__BodyAssignment"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3468:1: rule__FixIntParameter__BodyAssignment : ( RULE_INT ) ;
    public final void rule__FixIntParameter__BodyAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3472:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3473:1: ( RULE_INT )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3473:1: ( RULE_INT )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3474:1: RULE_INT
            {
             before(grammarAccess.getFixIntParameterAccess().getBodyINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FixIntParameter__BodyAssignment6931); 
             after(grammarAccess.getFixIntParameterAccess().getBodyINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FixIntParameter__BodyAssignment"


    // $ANTLR start "rule__FixStringParameter__BodyAssignment"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3483:1: rule__FixStringParameter__BodyAssignment : ( RULE_STRING ) ;
    public final void rule__FixStringParameter__BodyAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3487:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3488:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3488:1: ( RULE_STRING )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3489:1: RULE_STRING
            {
             before(grammarAccess.getFixStringParameterAccess().getBodySTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__FixStringParameter__BodyAssignment6962); 
             after(grammarAccess.getFixStringParameterAccess().getBodySTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FixStringParameter__BodyAssignment"


    // $ANTLR start "rule__VarParameter__VarAssignment"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3498:1: rule__VarParameter__VarAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VarParameter__VarAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3502:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3503:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3503:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3504:1: ( RULE_ID )
            {
             before(grammarAccess.getVarParameterAccess().getVarVarCrossReference_0()); 
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3505:1: ( RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3506:1: RULE_ID
            {
             before(grammarAccess.getVarParameterAccess().getVarVarIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VarParameter__VarAssignment6997); 
             after(grammarAccess.getVarParameterAccess().getVarVarIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getVarParameterAccess().getVarVarCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarParameter__VarAssignment"


    // $ANTLR start "rule__Var__NameAssignment"
    // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3517:1: rule__Var__NameAssignment : ( RULE_ID ) ;
    public final void rule__Var__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3521:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3522:1: ( RULE_ID )
            {
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3522:1: ( RULE_ID )
            // ../hu.bme.mit.ftsrg.ptregex.ui/src-gen/hu/bme/mit/ftsrg/ptregex/ui/contentassist/antlr/internal/InternalRegularExpression.g:3523:1: RULE_ID
            {
             before(grammarAccess.getVarAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Var__NameAssignment7032); 
             after(grammarAccess.getVarAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Var__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleRegexModel_in_entryRuleRegexModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegexModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegexModel__Group__0_in_ruleRegexModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlphabet_in_entryRuleAlphabet121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlphabet128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__0_in_ruleAlphabet154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctor_in_entryRuleFunctor181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctor188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Functor__Group__0_in_ruleFunctor214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionDeclaration_in_entryRuleExpressionDeclaration241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionDeclaration248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__0_in_ruleExpressionDeclaration274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoice_in_ruleExpression334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoice_in_entryRuleChoice360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoice367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Choice__Group__0_in_ruleChoice393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group__0_in_ruleSequence453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultExpression_in_entryRuleMultExpression480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultExpression487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group__0_in_ruleMultExpression513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenExpression_in_entryRuleParenExpression540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenExpression547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenExpression__Alternatives_in_ruleParenExpression573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAny_in_entryRuleAny600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAny607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Any__Group__0_in_ruleAny633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInverse_in_entryRuleInverse660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInverse667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__Group__0_in_ruleInverse693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimedExpression_in_entryRuleTimedExpression720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimedExpression727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__0_in_ruleTimedExpression753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__0_in_ruleEvent813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Alternatives_in_ruleParameter873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixParameter_in_entryRuleFixParameter900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixParameter907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FixParameter__Alternatives_in_ruleFixParameter933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixIntParameter_in_entryRuleFixIntParameter960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixIntParameter967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FixIntParameter__BodyAssignment_in_ruleFixIntParameter993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixStringParameter_in_entryRuleFixStringParameter1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixStringParameter1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FixStringParameter__BodyAssignment_in_ruleFixStringParameter1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarParameter_in_entryRuleVarParameter1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarParameter1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarParameter__VarAssignment_in_ruleVarParameter1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingletonParameter_in_entryRuleSingletonParameter1140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSingletonParameter1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SingletonParameter__Group__0_in_ruleSingletonParameter1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_entryRuleVar1200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVar1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__NameAssignment_in_ruleVar1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_0__0_in_rule__MultExpression__Alternatives_11269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_1__0_in_rule__MultExpression__Alternatives_11287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_2__0_in_rule__MultExpression__Alternatives_11305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenExpression__Group_0__0_in_rule__ParenExpression__Alternatives1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAny_in_rule__ParenExpression__Alternatives1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInverse_in_rule__ParenExpression__Alternatives1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimedExpression_in_rule__ParenExpression__Alternatives1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__ParenExpression__Alternatives1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarParameter_in_rule__Parameter__Alternatives1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSingletonParameter_in_rule__Parameter__Alternatives1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixParameter_in_rule__Parameter__Alternatives1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixIntParameter_in_rule__FixParameter__Alternatives1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixStringParameter_in_rule__FixParameter__Alternatives1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegexModel__Group__0__Impl_in_rule__RegexModel__Group__01552 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__RegexModel__Group__1_in_rule__RegexModel__Group__01555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegexModel__AlphabetAssignment_0_in_rule__RegexModel__Group__0__Impl1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegexModel__Group__1__Impl_in_rule__RegexModel__Group__11613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RegexModel__DeclarationsAssignment_1_in_rule__RegexModel__Group__1__Impl1640 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__0__Impl_in_rule__Alphabet__Group__01675 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__1_in_rule__Alphabet__Group__01678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__1__Impl_in_rule__Alphabet__Group__11736 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__2_in_rule__Alphabet__Group__11739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Alphabet__Group__1__Impl1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__2__Impl_in_rule__Alphabet__Group__21798 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__3_in_rule__Alphabet__Group__21801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Alphabet__Group__2__Impl1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__3__Impl_in_rule__Alphabet__Group__31860 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__4_in_rule__Alphabet__Group__31863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Alphabet__Group__3__Impl1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__4__Impl_in_rule__Alphabet__Group__41922 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__5_in_rule__Alphabet__Group__41925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group_4__0_in_rule__Alphabet__Group__4__Impl1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group__5__Impl_in_rule__Alphabet__Group__51983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Alphabet__Group__5__Impl2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group_4__0__Impl_in_rule__Alphabet__Group_4__02054 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Alphabet__Group_4__1_in_rule__Alphabet__Group_4__02057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__FunctorsAssignment_4_0_in_rule__Alphabet__Group_4__0__Impl2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group_4__1__Impl_in_rule__Alphabet__Group_4__12114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group_4_1__0_in_rule__Alphabet__Group_4__1__Impl2141 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group_4_1__0__Impl_in_rule__Alphabet__Group_4_1__02176 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Alphabet__Group_4_1__1_in_rule__Alphabet__Group_4_1__02179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Alphabet__Group_4_1__0__Impl2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__Group_4_1__1__Impl_in_rule__Alphabet__Group_4_1__12238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Alphabet__FunctorsAssignment_4_1_1_in_rule__Alphabet__Group_4_1__1__Impl2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Functor__Group__0__Impl_in_rule__Functor__Group__02299 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Functor__Group__1_in_rule__Functor__Group__02302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Functor__NameAssignment_0_in_rule__Functor__Group__0__Impl2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Functor__Group__1__Impl_in_rule__Functor__Group__12359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Functor__Group_1__0_in_rule__Functor__Group__1__Impl2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Functor__Group_1__0__Impl_in_rule__Functor__Group_1__02421 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Functor__Group_1__1_in_rule__Functor__Group_1__02424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Functor__Group_1__0__Impl2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Functor__Group_1__1__Impl_in_rule__Functor__Group_1__12483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Functor__ArityAssignment_1_1_in_rule__Functor__Group_1__1__Impl2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__0__Impl_in_rule__ExpressionDeclaration__Group__02544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__1_in_rule__ExpressionDeclaration__Group__02547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ExpressionDeclaration__Group__0__Impl2575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__1__Impl_in_rule__ExpressionDeclaration__Group__12606 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__2_in_rule__ExpressionDeclaration__Group__12609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__NameAssignment_1_in_rule__ExpressionDeclaration__Group__1__Impl2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__2__Impl_in_rule__ExpressionDeclaration__Group__22666 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__3_in_rule__ExpressionDeclaration__Group__22669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2__0_in_rule__ExpressionDeclaration__Group__2__Impl2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__3__Impl_in_rule__ExpressionDeclaration__Group__32727 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__4_in_rule__ExpressionDeclaration__Group__32730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ExpressionDeclaration__Group__3__Impl2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group__4__Impl_in_rule__ExpressionDeclaration__Group__42789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__BodyAssignment_4_in_rule__ExpressionDeclaration__Group__4__Impl2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2__0__Impl_in_rule__ExpressionDeclaration__Group_2__02856 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2__1_in_rule__ExpressionDeclaration__Group_2__02859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ExpressionDeclaration__Group_2__0__Impl2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2__1__Impl_in_rule__ExpressionDeclaration__Group_2__12918 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2__2_in_rule__ExpressionDeclaration__Group_2__12921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__VarsAssignment_2_1_in_rule__ExpressionDeclaration__Group_2__1__Impl2948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2__2__Impl_in_rule__ExpressionDeclaration__Group_2__22978 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2__3_in_rule__ExpressionDeclaration__Group_2__22981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2_2__0_in_rule__ExpressionDeclaration__Group_2__2__Impl3008 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2__3__Impl_in_rule__ExpressionDeclaration__Group_2__33039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ExpressionDeclaration__Group_2__3__Impl3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2_2__0__Impl_in_rule__ExpressionDeclaration__Group_2_2__03106 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2_2__1_in_rule__ExpressionDeclaration__Group_2_2__03109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ExpressionDeclaration__Group_2_2__0__Impl3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__Group_2_2__1__Impl_in_rule__ExpressionDeclaration__Group_2_2__13168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionDeclaration__VarsAssignment_2_2_1_in_rule__ExpressionDeclaration__Group_2_2__1__Impl3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Choice__Group__0__Impl_in_rule__Choice__Group__03229 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Choice__Group__1_in_rule__Choice__Group__03232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_rule__Choice__Group__0__Impl3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Choice__Group__1__Impl_in_rule__Choice__Group__13288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Choice__Group_1__0_in_rule__Choice__Group__1__Impl3315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Choice__Group_1__0__Impl_in_rule__Choice__Group_1__03350 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Choice__Group_1__1_in_rule__Choice__Group_1__03353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Choice__Group_1__1__Impl_in_rule__Choice__Group_1__13411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Choice__Group_1_1__0_in_rule__Choice__Group_1__1__Impl3440 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Choice__Group_1_1__0_in_rule__Choice__Group_1__1__Impl3452 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Choice__Group_1_1__0__Impl_in_rule__Choice__Group_1_1__03489 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_rule__Choice__Group_1_1__1_in_rule__Choice__Group_1_1__03492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Choice__Group_1_1__0__Impl3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Choice__Group_1_1__1__Impl_in_rule__Choice__Group_1_1__13551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Choice__ElementsAssignment_1_1_1_in_rule__Choice__Group_1_1__1__Impl3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group__0__Impl_in_rule__Sequence__Group__03612 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_rule__Sequence__Group__1_in_rule__Sequence__Group__03615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultExpression_in_rule__Sequence__Group__0__Impl3642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group__1__Impl_in_rule__Sequence__Group__13671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0_in_rule__Sequence__Group__1__Impl3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__0__Impl_in_rule__Sequence__Group_1__03733 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1_in_rule__Sequence__Group_1__03736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__Group_1__1__Impl_in_rule__Sequence__Group_1__13794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sequence__ElementsAssignment_1_1_in_rule__Sequence__Group_1__1__Impl3823 = new BitSet(new long[]{0x000000000A800012L});
    public static final BitSet FOLLOW_rule__Sequence__ElementsAssignment_1_1_in_rule__Sequence__Group_1__1__Impl3835 = new BitSet(new long[]{0x000000000A800012L});
    public static final BitSet FOLLOW_rule__MultExpression__Group__0__Impl_in_rule__MultExpression__Group__03872 = new BitSet(new long[]{0x0000000000602000L});
    public static final BitSet FOLLOW_rule__MultExpression__Group__1_in_rule__MultExpression__Group__03875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenExpression_in_rule__MultExpression__Group__0__Impl3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group__1__Impl_in_rule__MultExpression__Group__13931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Alternatives_1_in_rule__MultExpression__Group__1__Impl3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_0__0__Impl_in_rule__MultExpression__Group_1_0__03993 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_0__1_in_rule__MultExpression__Group_1_0__03996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_0__1__Impl_in_rule__MultExpression__Group_1_0__14054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__MultExpression__Group_1_0__1__Impl4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_1__0__Impl_in_rule__MultExpression__Group_1_1__04117 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_1__1_in_rule__MultExpression__Group_1_1__04120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_1__1__Impl_in_rule__MultExpression__Group_1_1__14178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MultExpression__Group_1_1__1__Impl4206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_2__0__Impl_in_rule__MultExpression__Group_1_2__04241 = new BitSet(new long[]{0x0000000000602000L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_2__1_in_rule__MultExpression__Group_1_2__04244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_2__1__Impl_in_rule__MultExpression__Group_1_2__14302 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_2__2_in_rule__MultExpression__Group_1_2__14305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__MultExpression__Group_1_2__1__Impl4333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_2__2__Impl_in_rule__MultExpression__Group_1_2__24364 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_2__3_in_rule__MultExpression__Group_1_2__24367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__NAssignment_1_2_2_in_rule__MultExpression__Group_1_2__2__Impl4394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultExpression__Group_1_2__3__Impl_in_rule__MultExpression__Group_1_2__34424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__MultExpression__Group_1_2__3__Impl4452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenExpression__Group_0__0__Impl_in_rule__ParenExpression__Group_0__04491 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_rule__ParenExpression__Group_0__1_in_rule__ParenExpression__Group_0__04494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ParenExpression__Group_0__0__Impl4522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenExpression__Group_0__1__Impl_in_rule__ParenExpression__Group_0__14553 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__ParenExpression__Group_0__2_in_rule__ParenExpression__Group_0__14556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ParenExpression__Group_0__1__Impl4583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenExpression__Group_0__2__Impl_in_rule__ParenExpression__Group_0__24612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ParenExpression__Group_0__2__Impl4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Any__Group__0__Impl_in_rule__Any__Group__04677 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Any__Group__1_in_rule__Any__Group__04680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Any__Group__1__Impl_in_rule__Any__Group__14738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Any__Group__1__Impl4766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__Group__0__Impl_in_rule__Inverse__Group__04801 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Inverse__Group__1_in_rule__Inverse__Group__04804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Inverse__Group__0__Impl4832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__Group__1__Impl_in_rule__Inverse__Group__14863 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Inverse__Group__2_in_rule__Inverse__Group__14866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Inverse__Group__1__Impl4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__Group__2__Impl_in_rule__Inverse__Group__24925 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_rule__Inverse__Group__3_in_rule__Inverse__Group__24928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Inverse__Group__2__Impl4956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__Group__3__Impl_in_rule__Inverse__Group__34987 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_rule__Inverse__Group__4_in_rule__Inverse__Group__34990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__ExcludesAssignment_3_in_rule__Inverse__Group__3__Impl5017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__Group__4__Impl_in_rule__Inverse__Group__45047 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_rule__Inverse__Group__5_in_rule__Inverse__Group__45050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__Group_4__0_in_rule__Inverse__Group__4__Impl5077 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Inverse__Group__5__Impl_in_rule__Inverse__Group__55108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Inverse__Group__5__Impl5136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__Group_4__0__Impl_in_rule__Inverse__Group_4__05179 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_rule__Inverse__Group_4__1_in_rule__Inverse__Group_4__05182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Inverse__Group_4__0__Impl5210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__Group_4__1__Impl_in_rule__Inverse__Group_4__15241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Inverse__ExcludesAssignment_4_1_in_rule__Inverse__Group_4__1__Impl5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__0__Impl_in_rule__TimedExpression__Group__05302 = new BitSet(new long[]{0x000000000A800010L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__1_in_rule__TimedExpression__Group__05305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__TimedExpression__Group__0__Impl5333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__1__Impl_in_rule__TimedExpression__Group__15364 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__2_in_rule__TimedExpression__Group__15367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimedExpression__BodyAssignment_1_in_rule__TimedExpression__Group__1__Impl5394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__2__Impl_in_rule__TimedExpression__Group__25424 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__3_in_rule__TimedExpression__Group__25427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__TimedExpression__Group__2__Impl5455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__3__Impl_in_rule__TimedExpression__Group__35486 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__4_in_rule__TimedExpression__Group__35489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__TimedExpression__Group__3__Impl5517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__4__Impl_in_rule__TimedExpression__Group__45548 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__5_in_rule__TimedExpression__Group__45551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimedExpression__TimeoutAssignment_4_in_rule__TimedExpression__Group__4__Impl5578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimedExpression__Group__5__Impl_in_rule__TimedExpression__Group__55608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__TimedExpression__Group__5__Impl5636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__0__Impl_in_rule__Event__Group__05679 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Event__Group__1_in_rule__Event__Group__05682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__FunctorAssignment_0_in_rule__Event__Group__0__Impl5709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group__1__Impl_in_rule__Event__Group__15739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group_1__0_in_rule__Event__Group__1__Impl5766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group_1__0__Impl_in_rule__Event__Group_1__05801 = new BitSet(new long[]{0x0000000020000070L});
    public static final BitSet FOLLOW_rule__Event__Group_1__1_in_rule__Event__Group_1__05804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Event__Group_1__0__Impl5832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group_1__1__Impl_in_rule__Event__Group_1__15863 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_rule__Event__Group_1__2_in_rule__Event__Group_1__15866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__ParametersAssignment_1_1_in_rule__Event__Group_1__1__Impl5893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group_1__2__Impl_in_rule__Event__Group_1__25923 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_rule__Event__Group_1__3_in_rule__Event__Group_1__25926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group_1_2__0_in_rule__Event__Group_1__2__Impl5953 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Event__Group_1__3__Impl_in_rule__Event__Group_1__35984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Event__Group_1__3__Impl6012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group_1_2__0__Impl_in_rule__Event__Group_1_2__06051 = new BitSet(new long[]{0x0000000020000070L});
    public static final BitSet FOLLOW_rule__Event__Group_1_2__1_in_rule__Event__Group_1_2__06054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Event__Group_1_2__0__Impl6082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Group_1_2__1__Impl_in_rule__Event__Group_1_2__16113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__ParametersAssignment_1_2_1_in_rule__Event__Group_1_2__1__Impl6140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SingletonParameter__Group__0__Impl_in_rule__SingletonParameter__Group__06174 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__SingletonParameter__Group__1_in_rule__SingletonParameter__Group__06177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SingletonParameter__Group__1__Impl_in_rule__SingletonParameter__Group__16235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__SingletonParameter__Group__1__Impl6263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlphabet_in_rule__RegexModel__AlphabetAssignment_06303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionDeclaration_in_rule__RegexModel__DeclarationsAssignment_16334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctor_in_rule__Alphabet__FunctorsAssignment_4_06365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctor_in_rule__Alphabet__FunctorsAssignment_4_1_16396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Functor__NameAssignment_06427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Functor__ArityAssignment_1_16458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ExpressionDeclaration__NameAssignment_16489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_rule__ExpressionDeclaration__VarsAssignment_2_16520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_rule__ExpressionDeclaration__VarsAssignment_2_2_16551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ExpressionDeclaration__BodyAssignment_46582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_rule__Choice__ElementsAssignment_1_1_16613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultExpression_in_rule__Sequence__ElementsAssignment_1_16644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__MultExpression__NAssignment_1_2_26675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Inverse__ExcludesAssignment_36706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Inverse__ExcludesAssignment_4_16737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__TimedExpression__BodyAssignment_16768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TimedExpression__TimeoutAssignment_46799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Event__FunctorAssignment_06834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Event__ParametersAssignment_1_16869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Event__ParametersAssignment_1_2_16900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FixIntParameter__BodyAssignment6931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__FixStringParameter__BodyAssignment6962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VarParameter__VarAssignment6997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Var__NameAssignment7032 = new BitSet(new long[]{0x0000000000000002L});

}