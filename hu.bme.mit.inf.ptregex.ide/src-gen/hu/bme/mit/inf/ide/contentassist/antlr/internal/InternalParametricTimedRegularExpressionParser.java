package hu.bme.mit.inf.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import hu.bme.mit.inf.services.ParametricTimedRegularExpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalParametricTimedRegularExpressionParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alphabet'", "'='", "'{'", "'}'", "','", "'/'", "'expression'", "'['", "']'", "'&'", "'|'", "'*'", "'+'", "'('", "')'", "'S'", "'\\\\'", "'<'", "'>'", "'_'"
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

    	public void setGrammarAccess(ParametricTimedRegularExpressionGrammarAccess grammarAccess) {
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
    // InternalParametricTimedRegularExpression.g:53:1: entryRuleRegexModel : ruleRegexModel EOF ;
    public final void entryRuleRegexModel() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:54:1: ( ruleRegexModel EOF )
            // InternalParametricTimedRegularExpression.g:55:1: ruleRegexModel EOF
            {
             before(grammarAccess.getRegexModelRule()); 
            pushFollow(FOLLOW_1);
            ruleRegexModel();

            state._fsp--;

             after(grammarAccess.getRegexModelRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:62:1: ruleRegexModel : ( ( rule__RegexModel__Group__0 ) ) ;
    public final void ruleRegexModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:66:2: ( ( ( rule__RegexModel__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:67:2: ( ( rule__RegexModel__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:67:2: ( ( rule__RegexModel__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:68:3: ( rule__RegexModel__Group__0 )
            {
             before(grammarAccess.getRegexModelAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:69:3: ( rule__RegexModel__Group__0 )
            // InternalParametricTimedRegularExpression.g:69:4: rule__RegexModel__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:78:1: entryRuleAlphabet : ruleAlphabet EOF ;
    public final void entryRuleAlphabet() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:79:1: ( ruleAlphabet EOF )
            // InternalParametricTimedRegularExpression.g:80:1: ruleAlphabet EOF
            {
             before(grammarAccess.getAlphabetRule()); 
            pushFollow(FOLLOW_1);
            ruleAlphabet();

            state._fsp--;

             after(grammarAccess.getAlphabetRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:87:1: ruleAlphabet : ( ( rule__Alphabet__Group__0 ) ) ;
    public final void ruleAlphabet() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:91:2: ( ( ( rule__Alphabet__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:92:2: ( ( rule__Alphabet__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:92:2: ( ( rule__Alphabet__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:93:3: ( rule__Alphabet__Group__0 )
            {
             before(grammarAccess.getAlphabetAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:94:3: ( rule__Alphabet__Group__0 )
            // InternalParametricTimedRegularExpression.g:94:4: rule__Alphabet__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:103:1: entryRuleFunctor : ruleFunctor EOF ;
    public final void entryRuleFunctor() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:104:1: ( ruleFunctor EOF )
            // InternalParametricTimedRegularExpression.g:105:1: ruleFunctor EOF
            {
             before(grammarAccess.getFunctorRule()); 
            pushFollow(FOLLOW_1);
            ruleFunctor();

            state._fsp--;

             after(grammarAccess.getFunctorRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:112:1: ruleFunctor : ( ( rule__Functor__Group__0 ) ) ;
    public final void ruleFunctor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:116:2: ( ( ( rule__Functor__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:117:2: ( ( rule__Functor__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:117:2: ( ( rule__Functor__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:118:3: ( rule__Functor__Group__0 )
            {
             before(grammarAccess.getFunctorAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:119:3: ( rule__Functor__Group__0 )
            // InternalParametricTimedRegularExpression.g:119:4: rule__Functor__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:128:1: entryRuleExpressionDeclaration : ruleExpressionDeclaration EOF ;
    public final void entryRuleExpressionDeclaration() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:129:1: ( ruleExpressionDeclaration EOF )
            // InternalParametricTimedRegularExpression.g:130:1: ruleExpressionDeclaration EOF
            {
             before(grammarAccess.getExpressionDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleExpressionDeclaration();

            state._fsp--;

             after(grammarAccess.getExpressionDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:137:1: ruleExpressionDeclaration : ( ( rule__ExpressionDeclaration__Group__0 ) ) ;
    public final void ruleExpressionDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:141:2: ( ( ( rule__ExpressionDeclaration__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:142:2: ( ( rule__ExpressionDeclaration__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:142:2: ( ( rule__ExpressionDeclaration__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:143:3: ( rule__ExpressionDeclaration__Group__0 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:144:3: ( rule__ExpressionDeclaration__Group__0 )
            // InternalParametricTimedRegularExpression.g:144:4: rule__ExpressionDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:153:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:154:1: ( ruleExpression EOF )
            // InternalParametricTimedRegularExpression.g:155:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:162:1: ruleExpression : ( ruleAnd ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:166:2: ( ( ruleAnd ) )
            // InternalParametricTimedRegularExpression.g:167:2: ( ruleAnd )
            {
            // InternalParametricTimedRegularExpression.g:167:2: ( ruleAnd )
            // InternalParametricTimedRegularExpression.g:168:3: ruleAnd
            {
             before(grammarAccess.getExpressionAccess().getAndParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getAndParserRuleCall()); 

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


    // $ANTLR start "entryRuleAnd"
    // InternalParametricTimedRegularExpression.g:178:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:179:1: ( ruleAnd EOF )
            // InternalParametricTimedRegularExpression.g:180:1: ruleAnd EOF
            {
             before(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getAndRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalParametricTimedRegularExpression.g:187:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:191:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:192:2: ( ( rule__And__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:192:2: ( ( rule__And__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:193:3: ( rule__And__Group__0 )
            {
             before(grammarAccess.getAndAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:194:3: ( rule__And__Group__0 )
            // InternalParametricTimedRegularExpression.g:194:4: rule__And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getGroup()); 

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
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleChoice"
    // InternalParametricTimedRegularExpression.g:203:1: entryRuleChoice : ruleChoice EOF ;
    public final void entryRuleChoice() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:204:1: ( ruleChoice EOF )
            // InternalParametricTimedRegularExpression.g:205:1: ruleChoice EOF
            {
             before(grammarAccess.getChoiceRule()); 
            pushFollow(FOLLOW_1);
            ruleChoice();

            state._fsp--;

             after(grammarAccess.getChoiceRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:212:1: ruleChoice : ( ( rule__Choice__Group__0 ) ) ;
    public final void ruleChoice() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:216:2: ( ( ( rule__Choice__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:217:2: ( ( rule__Choice__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:217:2: ( ( rule__Choice__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:218:3: ( rule__Choice__Group__0 )
            {
             before(grammarAccess.getChoiceAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:219:3: ( rule__Choice__Group__0 )
            // InternalParametricTimedRegularExpression.g:219:4: rule__Choice__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:228:1: entryRuleSequence : ruleSequence EOF ;
    public final void entryRuleSequence() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:229:1: ( ruleSequence EOF )
            // InternalParametricTimedRegularExpression.g:230:1: ruleSequence EOF
            {
             before(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_1);
            ruleSequence();

            state._fsp--;

             after(grammarAccess.getSequenceRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:237:1: ruleSequence : ( ( rule__Sequence__Group__0 ) ) ;
    public final void ruleSequence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:241:2: ( ( ( rule__Sequence__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:242:2: ( ( rule__Sequence__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:242:2: ( ( rule__Sequence__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:243:3: ( rule__Sequence__Group__0 )
            {
             before(grammarAccess.getSequenceAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:244:3: ( rule__Sequence__Group__0 )
            // InternalParametricTimedRegularExpression.g:244:4: rule__Sequence__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:253:1: entryRuleMultExpression : ruleMultExpression EOF ;
    public final void entryRuleMultExpression() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:254:1: ( ruleMultExpression EOF )
            // InternalParametricTimedRegularExpression.g:255:1: ruleMultExpression EOF
            {
             before(grammarAccess.getMultExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleMultExpression();

            state._fsp--;

             after(grammarAccess.getMultExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:262:1: ruleMultExpression : ( ( rule__MultExpression__Group__0 ) ) ;
    public final void ruleMultExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:266:2: ( ( ( rule__MultExpression__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:267:2: ( ( rule__MultExpression__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:267:2: ( ( rule__MultExpression__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:268:3: ( rule__MultExpression__Group__0 )
            {
             before(grammarAccess.getMultExpressionAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:269:3: ( rule__MultExpression__Group__0 )
            // InternalParametricTimedRegularExpression.g:269:4: rule__MultExpression__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:278:1: entryRuleParenExpression : ruleParenExpression EOF ;
    public final void entryRuleParenExpression() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:279:1: ( ruleParenExpression EOF )
            // InternalParametricTimedRegularExpression.g:280:1: ruleParenExpression EOF
            {
             before(grammarAccess.getParenExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleParenExpression();

            state._fsp--;

             after(grammarAccess.getParenExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:287:1: ruleParenExpression : ( ( rule__ParenExpression__Alternatives ) ) ;
    public final void ruleParenExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:291:2: ( ( ( rule__ParenExpression__Alternatives ) ) )
            // InternalParametricTimedRegularExpression.g:292:2: ( ( rule__ParenExpression__Alternatives ) )
            {
            // InternalParametricTimedRegularExpression.g:292:2: ( ( rule__ParenExpression__Alternatives ) )
            // InternalParametricTimedRegularExpression.g:293:3: ( rule__ParenExpression__Alternatives )
            {
             before(grammarAccess.getParenExpressionAccess().getAlternatives()); 
            // InternalParametricTimedRegularExpression.g:294:3: ( rule__ParenExpression__Alternatives )
            // InternalParametricTimedRegularExpression.g:294:4: rule__ParenExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:303:1: entryRuleAny : ruleAny EOF ;
    public final void entryRuleAny() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:304:1: ( ruleAny EOF )
            // InternalParametricTimedRegularExpression.g:305:1: ruleAny EOF
            {
             before(grammarAccess.getAnyRule()); 
            pushFollow(FOLLOW_1);
            ruleAny();

            state._fsp--;

             after(grammarAccess.getAnyRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:312:1: ruleAny : ( ( rule__Any__Group__0 ) ) ;
    public final void ruleAny() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:316:2: ( ( ( rule__Any__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:317:2: ( ( rule__Any__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:317:2: ( ( rule__Any__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:318:3: ( rule__Any__Group__0 )
            {
             before(grammarAccess.getAnyAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:319:3: ( rule__Any__Group__0 )
            // InternalParametricTimedRegularExpression.g:319:4: rule__Any__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:328:1: entryRuleInverse : ruleInverse EOF ;
    public final void entryRuleInverse() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:329:1: ( ruleInverse EOF )
            // InternalParametricTimedRegularExpression.g:330:1: ruleInverse EOF
            {
             before(grammarAccess.getInverseRule()); 
            pushFollow(FOLLOW_1);
            ruleInverse();

            state._fsp--;

             after(grammarAccess.getInverseRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:337:1: ruleInverse : ( ( rule__Inverse__Group__0 ) ) ;
    public final void ruleInverse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:341:2: ( ( ( rule__Inverse__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:342:2: ( ( rule__Inverse__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:342:2: ( ( rule__Inverse__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:343:3: ( rule__Inverse__Group__0 )
            {
             before(grammarAccess.getInverseAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:344:3: ( rule__Inverse__Group__0 )
            // InternalParametricTimedRegularExpression.g:344:4: rule__Inverse__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:353:1: entryRuleTimedExpression : ruleTimedExpression EOF ;
    public final void entryRuleTimedExpression() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:354:1: ( ruleTimedExpression EOF )
            // InternalParametricTimedRegularExpression.g:355:1: ruleTimedExpression EOF
            {
             before(grammarAccess.getTimedExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleTimedExpression();

            state._fsp--;

             after(grammarAccess.getTimedExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:362:1: ruleTimedExpression : ( ( rule__TimedExpression__Group__0 ) ) ;
    public final void ruleTimedExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:366:2: ( ( ( rule__TimedExpression__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:367:2: ( ( rule__TimedExpression__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:367:2: ( ( rule__TimedExpression__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:368:3: ( rule__TimedExpression__Group__0 )
            {
             before(grammarAccess.getTimedExpressionAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:369:3: ( rule__TimedExpression__Group__0 )
            // InternalParametricTimedRegularExpression.g:369:4: rule__TimedExpression__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:378:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:379:1: ( ruleEvent EOF )
            // InternalParametricTimedRegularExpression.g:380:1: ruleEvent EOF
            {
             before(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getEventRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:387:1: ruleEvent : ( ( rule__Event__Group__0 ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:391:2: ( ( ( rule__Event__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:392:2: ( ( rule__Event__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:392:2: ( ( rule__Event__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:393:3: ( rule__Event__Group__0 )
            {
             before(grammarAccess.getEventAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:394:3: ( rule__Event__Group__0 )
            // InternalParametricTimedRegularExpression.g:394:4: rule__Event__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:403:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:404:1: ( ruleParameter EOF )
            // InternalParametricTimedRegularExpression.g:405:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:412:1: ruleParameter : ( ( rule__Parameter__Alternatives ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:416:2: ( ( ( rule__Parameter__Alternatives ) ) )
            // InternalParametricTimedRegularExpression.g:417:2: ( ( rule__Parameter__Alternatives ) )
            {
            // InternalParametricTimedRegularExpression.g:417:2: ( ( rule__Parameter__Alternatives ) )
            // InternalParametricTimedRegularExpression.g:418:3: ( rule__Parameter__Alternatives )
            {
             before(grammarAccess.getParameterAccess().getAlternatives()); 
            // InternalParametricTimedRegularExpression.g:419:3: ( rule__Parameter__Alternatives )
            // InternalParametricTimedRegularExpression.g:419:4: rule__Parameter__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:428:1: entryRuleFixParameter : ruleFixParameter EOF ;
    public final void entryRuleFixParameter() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:429:1: ( ruleFixParameter EOF )
            // InternalParametricTimedRegularExpression.g:430:1: ruleFixParameter EOF
            {
             before(grammarAccess.getFixParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleFixParameter();

            state._fsp--;

             after(grammarAccess.getFixParameterRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:437:1: ruleFixParameter : ( ( rule__FixParameter__Alternatives ) ) ;
    public final void ruleFixParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:441:2: ( ( ( rule__FixParameter__Alternatives ) ) )
            // InternalParametricTimedRegularExpression.g:442:2: ( ( rule__FixParameter__Alternatives ) )
            {
            // InternalParametricTimedRegularExpression.g:442:2: ( ( rule__FixParameter__Alternatives ) )
            // InternalParametricTimedRegularExpression.g:443:3: ( rule__FixParameter__Alternatives )
            {
             before(grammarAccess.getFixParameterAccess().getAlternatives()); 
            // InternalParametricTimedRegularExpression.g:444:3: ( rule__FixParameter__Alternatives )
            // InternalParametricTimedRegularExpression.g:444:4: rule__FixParameter__Alternatives
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:453:1: entryRuleFixIntParameter : ruleFixIntParameter EOF ;
    public final void entryRuleFixIntParameter() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:454:1: ( ruleFixIntParameter EOF )
            // InternalParametricTimedRegularExpression.g:455:1: ruleFixIntParameter EOF
            {
             before(grammarAccess.getFixIntParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleFixIntParameter();

            state._fsp--;

             after(grammarAccess.getFixIntParameterRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:462:1: ruleFixIntParameter : ( ( rule__FixIntParameter__BodyAssignment ) ) ;
    public final void ruleFixIntParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:466:2: ( ( ( rule__FixIntParameter__BodyAssignment ) ) )
            // InternalParametricTimedRegularExpression.g:467:2: ( ( rule__FixIntParameter__BodyAssignment ) )
            {
            // InternalParametricTimedRegularExpression.g:467:2: ( ( rule__FixIntParameter__BodyAssignment ) )
            // InternalParametricTimedRegularExpression.g:468:3: ( rule__FixIntParameter__BodyAssignment )
            {
             before(grammarAccess.getFixIntParameterAccess().getBodyAssignment()); 
            // InternalParametricTimedRegularExpression.g:469:3: ( rule__FixIntParameter__BodyAssignment )
            // InternalParametricTimedRegularExpression.g:469:4: rule__FixIntParameter__BodyAssignment
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:478:1: entryRuleFixStringParameter : ruleFixStringParameter EOF ;
    public final void entryRuleFixStringParameter() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:479:1: ( ruleFixStringParameter EOF )
            // InternalParametricTimedRegularExpression.g:480:1: ruleFixStringParameter EOF
            {
             before(grammarAccess.getFixStringParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleFixStringParameter();

            state._fsp--;

             after(grammarAccess.getFixStringParameterRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:487:1: ruleFixStringParameter : ( ( rule__FixStringParameter__BodyAssignment ) ) ;
    public final void ruleFixStringParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:491:2: ( ( ( rule__FixStringParameter__BodyAssignment ) ) )
            // InternalParametricTimedRegularExpression.g:492:2: ( ( rule__FixStringParameter__BodyAssignment ) )
            {
            // InternalParametricTimedRegularExpression.g:492:2: ( ( rule__FixStringParameter__BodyAssignment ) )
            // InternalParametricTimedRegularExpression.g:493:3: ( rule__FixStringParameter__BodyAssignment )
            {
             before(grammarAccess.getFixStringParameterAccess().getBodyAssignment()); 
            // InternalParametricTimedRegularExpression.g:494:3: ( rule__FixStringParameter__BodyAssignment )
            // InternalParametricTimedRegularExpression.g:494:4: rule__FixStringParameter__BodyAssignment
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:503:1: entryRuleVarParameter : ruleVarParameter EOF ;
    public final void entryRuleVarParameter() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:504:1: ( ruleVarParameter EOF )
            // InternalParametricTimedRegularExpression.g:505:1: ruleVarParameter EOF
            {
             before(grammarAccess.getVarParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleVarParameter();

            state._fsp--;

             after(grammarAccess.getVarParameterRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:512:1: ruleVarParameter : ( ( rule__VarParameter__VarAssignment ) ) ;
    public final void ruleVarParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:516:2: ( ( ( rule__VarParameter__VarAssignment ) ) )
            // InternalParametricTimedRegularExpression.g:517:2: ( ( rule__VarParameter__VarAssignment ) )
            {
            // InternalParametricTimedRegularExpression.g:517:2: ( ( rule__VarParameter__VarAssignment ) )
            // InternalParametricTimedRegularExpression.g:518:3: ( rule__VarParameter__VarAssignment )
            {
             before(grammarAccess.getVarParameterAccess().getVarAssignment()); 
            // InternalParametricTimedRegularExpression.g:519:3: ( rule__VarParameter__VarAssignment )
            // InternalParametricTimedRegularExpression.g:519:4: rule__VarParameter__VarAssignment
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:528:1: entryRuleSingletonParameter : ruleSingletonParameter EOF ;
    public final void entryRuleSingletonParameter() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:529:1: ( ruleSingletonParameter EOF )
            // InternalParametricTimedRegularExpression.g:530:1: ruleSingletonParameter EOF
            {
             before(grammarAccess.getSingletonParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleSingletonParameter();

            state._fsp--;

             after(grammarAccess.getSingletonParameterRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:537:1: ruleSingletonParameter : ( ( rule__SingletonParameter__Group__0 ) ) ;
    public final void ruleSingletonParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:541:2: ( ( ( rule__SingletonParameter__Group__0 ) ) )
            // InternalParametricTimedRegularExpression.g:542:2: ( ( rule__SingletonParameter__Group__0 ) )
            {
            // InternalParametricTimedRegularExpression.g:542:2: ( ( rule__SingletonParameter__Group__0 ) )
            // InternalParametricTimedRegularExpression.g:543:3: ( rule__SingletonParameter__Group__0 )
            {
             before(grammarAccess.getSingletonParameterAccess().getGroup()); 
            // InternalParametricTimedRegularExpression.g:544:3: ( rule__SingletonParameter__Group__0 )
            // InternalParametricTimedRegularExpression.g:544:4: rule__SingletonParameter__Group__0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:553:1: entryRuleVar : ruleVar EOF ;
    public final void entryRuleVar() throws RecognitionException {
        try {
            // InternalParametricTimedRegularExpression.g:554:1: ( ruleVar EOF )
            // InternalParametricTimedRegularExpression.g:555:1: ruleVar EOF
            {
             before(grammarAccess.getVarRule()); 
            pushFollow(FOLLOW_1);
            ruleVar();

            state._fsp--;

             after(grammarAccess.getVarRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalParametricTimedRegularExpression.g:562:1: ruleVar : ( ( rule__Var__NameAssignment ) ) ;
    public final void ruleVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:566:2: ( ( ( rule__Var__NameAssignment ) ) )
            // InternalParametricTimedRegularExpression.g:567:2: ( ( rule__Var__NameAssignment ) )
            {
            // InternalParametricTimedRegularExpression.g:567:2: ( ( rule__Var__NameAssignment ) )
            // InternalParametricTimedRegularExpression.g:568:3: ( rule__Var__NameAssignment )
            {
             before(grammarAccess.getVarAccess().getNameAssignment()); 
            // InternalParametricTimedRegularExpression.g:569:3: ( rule__Var__NameAssignment )
            // InternalParametricTimedRegularExpression.g:569:4: rule__Var__NameAssignment
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:577:1: rule__MultExpression__Alternatives_1 : ( ( ( rule__MultExpression__Group_1_0__0 ) ) | ( ( rule__MultExpression__Group_1_1__0 ) ) | ( ( rule__MultExpression__Group_1_2__0 ) ) );
    public final void rule__MultExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:581:1: ( ( ( rule__MultExpression__Group_1_0__0 ) ) | ( ( rule__MultExpression__Group_1_1__0 ) ) | ( ( rule__MultExpression__Group_1_2__0 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt1=1;
                }
                break;
            case 23:
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
                    // InternalParametricTimedRegularExpression.g:582:2: ( ( rule__MultExpression__Group_1_0__0 ) )
                    {
                    // InternalParametricTimedRegularExpression.g:582:2: ( ( rule__MultExpression__Group_1_0__0 ) )
                    // InternalParametricTimedRegularExpression.g:583:3: ( rule__MultExpression__Group_1_0__0 )
                    {
                     before(grammarAccess.getMultExpressionAccess().getGroup_1_0()); 
                    // InternalParametricTimedRegularExpression.g:584:3: ( rule__MultExpression__Group_1_0__0 )
                    // InternalParametricTimedRegularExpression.g:584:4: rule__MultExpression__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultExpression__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultExpressionAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalParametricTimedRegularExpression.g:588:2: ( ( rule__MultExpression__Group_1_1__0 ) )
                    {
                    // InternalParametricTimedRegularExpression.g:588:2: ( ( rule__MultExpression__Group_1_1__0 ) )
                    // InternalParametricTimedRegularExpression.g:589:3: ( rule__MultExpression__Group_1_1__0 )
                    {
                     before(grammarAccess.getMultExpressionAccess().getGroup_1_1()); 
                    // InternalParametricTimedRegularExpression.g:590:3: ( rule__MultExpression__Group_1_1__0 )
                    // InternalParametricTimedRegularExpression.g:590:4: rule__MultExpression__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultExpression__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultExpressionAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalParametricTimedRegularExpression.g:594:2: ( ( rule__MultExpression__Group_1_2__0 ) )
                    {
                    // InternalParametricTimedRegularExpression.g:594:2: ( ( rule__MultExpression__Group_1_2__0 ) )
                    // InternalParametricTimedRegularExpression.g:595:3: ( rule__MultExpression__Group_1_2__0 )
                    {
                     before(grammarAccess.getMultExpressionAccess().getGroup_1_2()); 
                    // InternalParametricTimedRegularExpression.g:596:3: ( rule__MultExpression__Group_1_2__0 )
                    // InternalParametricTimedRegularExpression.g:596:4: rule__MultExpression__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:604:1: rule__ParenExpression__Alternatives : ( ( ( rule__ParenExpression__Group_0__0 ) ) | ( ruleAny ) | ( ruleInverse ) | ( ruleTimedExpression ) | ( ruleEvent ) );
    public final void rule__ParenExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:608:1: ( ( ( rule__ParenExpression__Group_0__0 ) ) | ( ruleAny ) | ( ruleInverse ) | ( ruleTimedExpression ) | ( ruleEvent ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_ID||LA2_1==24||LA2_1==28) ) {
                    alt2=1;
                }
                else if ( (LA2_1==26) ) {
                    int LA2_6 = input.LA(3);

                    if ( (LA2_6==27) ) {
                        alt2=3;
                    }
                    else if ( (LA2_6==RULE_ID||LA2_6==13||(LA2_6>=20 && LA2_6<=26)||LA2_6==28) ) {
                        alt2=1;
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
            case 26:
                {
                alt2=2;
                }
                break;
            case 28:
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
                    // InternalParametricTimedRegularExpression.g:609:2: ( ( rule__ParenExpression__Group_0__0 ) )
                    {
                    // InternalParametricTimedRegularExpression.g:609:2: ( ( rule__ParenExpression__Group_0__0 ) )
                    // InternalParametricTimedRegularExpression.g:610:3: ( rule__ParenExpression__Group_0__0 )
                    {
                     before(grammarAccess.getParenExpressionAccess().getGroup_0()); 
                    // InternalParametricTimedRegularExpression.g:611:3: ( rule__ParenExpression__Group_0__0 )
                    // InternalParametricTimedRegularExpression.g:611:4: rule__ParenExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParenExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParenExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalParametricTimedRegularExpression.g:615:2: ( ruleAny )
                    {
                    // InternalParametricTimedRegularExpression.g:615:2: ( ruleAny )
                    // InternalParametricTimedRegularExpression.g:616:3: ruleAny
                    {
                     before(grammarAccess.getParenExpressionAccess().getAnyParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleAny();

                    state._fsp--;

                     after(grammarAccess.getParenExpressionAccess().getAnyParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalParametricTimedRegularExpression.g:621:2: ( ruleInverse )
                    {
                    // InternalParametricTimedRegularExpression.g:621:2: ( ruleInverse )
                    // InternalParametricTimedRegularExpression.g:622:3: ruleInverse
                    {
                     before(grammarAccess.getParenExpressionAccess().getInverseParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleInverse();

                    state._fsp--;

                     after(grammarAccess.getParenExpressionAccess().getInverseParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalParametricTimedRegularExpression.g:627:2: ( ruleTimedExpression )
                    {
                    // InternalParametricTimedRegularExpression.g:627:2: ( ruleTimedExpression )
                    // InternalParametricTimedRegularExpression.g:628:3: ruleTimedExpression
                    {
                     before(grammarAccess.getParenExpressionAccess().getTimedExpressionParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleTimedExpression();

                    state._fsp--;

                     after(grammarAccess.getParenExpressionAccess().getTimedExpressionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalParametricTimedRegularExpression.g:633:2: ( ruleEvent )
                    {
                    // InternalParametricTimedRegularExpression.g:633:2: ( ruleEvent )
                    // InternalParametricTimedRegularExpression.g:634:3: ruleEvent
                    {
                     before(grammarAccess.getParenExpressionAccess().getEventParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:643:1: rule__Parameter__Alternatives : ( ( ruleVarParameter ) | ( ruleSingletonParameter ) | ( ruleFixParameter ) );
    public final void rule__Parameter__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:647:1: ( ( ruleVarParameter ) | ( ruleSingletonParameter ) | ( ruleFixParameter ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt3=1;
                }
                break;
            case 30:
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
                    // InternalParametricTimedRegularExpression.g:648:2: ( ruleVarParameter )
                    {
                    // InternalParametricTimedRegularExpression.g:648:2: ( ruleVarParameter )
                    // InternalParametricTimedRegularExpression.g:649:3: ruleVarParameter
                    {
                     before(grammarAccess.getParameterAccess().getVarParameterParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleVarParameter();

                    state._fsp--;

                     after(grammarAccess.getParameterAccess().getVarParameterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalParametricTimedRegularExpression.g:654:2: ( ruleSingletonParameter )
                    {
                    // InternalParametricTimedRegularExpression.g:654:2: ( ruleSingletonParameter )
                    // InternalParametricTimedRegularExpression.g:655:3: ruleSingletonParameter
                    {
                     before(grammarAccess.getParameterAccess().getSingletonParameterParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleSingletonParameter();

                    state._fsp--;

                     after(grammarAccess.getParameterAccess().getSingletonParameterParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalParametricTimedRegularExpression.g:660:2: ( ruleFixParameter )
                    {
                    // InternalParametricTimedRegularExpression.g:660:2: ( ruleFixParameter )
                    // InternalParametricTimedRegularExpression.g:661:3: ruleFixParameter
                    {
                     before(grammarAccess.getParameterAccess().getFixParameterParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:670:1: rule__FixParameter__Alternatives : ( ( ruleFixIntParameter ) | ( ruleFixStringParameter ) );
    public final void rule__FixParameter__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:674:1: ( ( ruleFixIntParameter ) | ( ruleFixStringParameter ) )
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
                    // InternalParametricTimedRegularExpression.g:675:2: ( ruleFixIntParameter )
                    {
                    // InternalParametricTimedRegularExpression.g:675:2: ( ruleFixIntParameter )
                    // InternalParametricTimedRegularExpression.g:676:3: ruleFixIntParameter
                    {
                     before(grammarAccess.getFixParameterAccess().getFixIntParameterParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleFixIntParameter();

                    state._fsp--;

                     after(grammarAccess.getFixParameterAccess().getFixIntParameterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalParametricTimedRegularExpression.g:681:2: ( ruleFixStringParameter )
                    {
                    // InternalParametricTimedRegularExpression.g:681:2: ( ruleFixStringParameter )
                    // InternalParametricTimedRegularExpression.g:682:3: ruleFixStringParameter
                    {
                     before(grammarAccess.getFixParameterAccess().getFixStringParameterParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:691:1: rule__RegexModel__Group__0 : rule__RegexModel__Group__0__Impl rule__RegexModel__Group__1 ;
    public final void rule__RegexModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:695:1: ( rule__RegexModel__Group__0__Impl rule__RegexModel__Group__1 )
            // InternalParametricTimedRegularExpression.g:696:2: rule__RegexModel__Group__0__Impl rule__RegexModel__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RegexModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:703:1: rule__RegexModel__Group__0__Impl : ( ( rule__RegexModel__AlphabetAssignment_0 )? ) ;
    public final void rule__RegexModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:707:1: ( ( ( rule__RegexModel__AlphabetAssignment_0 )? ) )
            // InternalParametricTimedRegularExpression.g:708:1: ( ( rule__RegexModel__AlphabetAssignment_0 )? )
            {
            // InternalParametricTimedRegularExpression.g:708:1: ( ( rule__RegexModel__AlphabetAssignment_0 )? )
            // InternalParametricTimedRegularExpression.g:709:2: ( rule__RegexModel__AlphabetAssignment_0 )?
            {
             before(grammarAccess.getRegexModelAccess().getAlphabetAssignment_0()); 
            // InternalParametricTimedRegularExpression.g:710:2: ( rule__RegexModel__AlphabetAssignment_0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:710:3: rule__RegexModel__AlphabetAssignment_0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:718:1: rule__RegexModel__Group__1 : rule__RegexModel__Group__1__Impl ;
    public final void rule__RegexModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:722:1: ( rule__RegexModel__Group__1__Impl )
            // InternalParametricTimedRegularExpression.g:723:2: rule__RegexModel__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:729:1: rule__RegexModel__Group__1__Impl : ( ( ( rule__RegexModel__DeclarationsAssignment_1 ) ) ( ( rule__RegexModel__DeclarationsAssignment_1 )* ) ) ;
    public final void rule__RegexModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:733:1: ( ( ( ( rule__RegexModel__DeclarationsAssignment_1 ) ) ( ( rule__RegexModel__DeclarationsAssignment_1 )* ) ) )
            // InternalParametricTimedRegularExpression.g:734:1: ( ( ( rule__RegexModel__DeclarationsAssignment_1 ) ) ( ( rule__RegexModel__DeclarationsAssignment_1 )* ) )
            {
            // InternalParametricTimedRegularExpression.g:734:1: ( ( ( rule__RegexModel__DeclarationsAssignment_1 ) ) ( ( rule__RegexModel__DeclarationsAssignment_1 )* ) )
            // InternalParametricTimedRegularExpression.g:735:2: ( ( rule__RegexModel__DeclarationsAssignment_1 ) ) ( ( rule__RegexModel__DeclarationsAssignment_1 )* )
            {
            // InternalParametricTimedRegularExpression.g:735:2: ( ( rule__RegexModel__DeclarationsAssignment_1 ) )
            // InternalParametricTimedRegularExpression.g:736:3: ( rule__RegexModel__DeclarationsAssignment_1 )
            {
             before(grammarAccess.getRegexModelAccess().getDeclarationsAssignment_1()); 
            // InternalParametricTimedRegularExpression.g:737:3: ( rule__RegexModel__DeclarationsAssignment_1 )
            // InternalParametricTimedRegularExpression.g:737:4: rule__RegexModel__DeclarationsAssignment_1
            {
            pushFollow(FOLLOW_4);
            rule__RegexModel__DeclarationsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRegexModelAccess().getDeclarationsAssignment_1()); 

            }

            // InternalParametricTimedRegularExpression.g:740:2: ( ( rule__RegexModel__DeclarationsAssignment_1 )* )
            // InternalParametricTimedRegularExpression.g:741:3: ( rule__RegexModel__DeclarationsAssignment_1 )*
            {
             before(grammarAccess.getRegexModelAccess().getDeclarationsAssignment_1()); 
            // InternalParametricTimedRegularExpression.g:742:3: ( rule__RegexModel__DeclarationsAssignment_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:742:4: rule__RegexModel__DeclarationsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
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
    // InternalParametricTimedRegularExpression.g:752:1: rule__Alphabet__Group__0 : rule__Alphabet__Group__0__Impl rule__Alphabet__Group__1 ;
    public final void rule__Alphabet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:756:1: ( rule__Alphabet__Group__0__Impl rule__Alphabet__Group__1 )
            // InternalParametricTimedRegularExpression.g:757:2: rule__Alphabet__Group__0__Impl rule__Alphabet__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Alphabet__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:764:1: rule__Alphabet__Group__0__Impl : ( () ) ;
    public final void rule__Alphabet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:768:1: ( ( () ) )
            // InternalParametricTimedRegularExpression.g:769:1: ( () )
            {
            // InternalParametricTimedRegularExpression.g:769:1: ( () )
            // InternalParametricTimedRegularExpression.g:770:2: ()
            {
             before(grammarAccess.getAlphabetAccess().getAlphabetAction_0()); 
            // InternalParametricTimedRegularExpression.g:771:2: ()
            // InternalParametricTimedRegularExpression.g:771:3: 
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
    // InternalParametricTimedRegularExpression.g:779:1: rule__Alphabet__Group__1 : rule__Alphabet__Group__1__Impl rule__Alphabet__Group__2 ;
    public final void rule__Alphabet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:783:1: ( rule__Alphabet__Group__1__Impl rule__Alphabet__Group__2 )
            // InternalParametricTimedRegularExpression.g:784:2: rule__Alphabet__Group__1__Impl rule__Alphabet__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Alphabet__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:791:1: rule__Alphabet__Group__1__Impl : ( 'alphabet' ) ;
    public final void rule__Alphabet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:795:1: ( ( 'alphabet' ) )
            // InternalParametricTimedRegularExpression.g:796:1: ( 'alphabet' )
            {
            // InternalParametricTimedRegularExpression.g:796:1: ( 'alphabet' )
            // InternalParametricTimedRegularExpression.g:797:2: 'alphabet'
            {
             before(grammarAccess.getAlphabetAccess().getAlphabetKeyword_1()); 
            match(input,11,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:806:1: rule__Alphabet__Group__2 : rule__Alphabet__Group__2__Impl rule__Alphabet__Group__3 ;
    public final void rule__Alphabet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:810:1: ( rule__Alphabet__Group__2__Impl rule__Alphabet__Group__3 )
            // InternalParametricTimedRegularExpression.g:811:2: rule__Alphabet__Group__2__Impl rule__Alphabet__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Alphabet__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:818:1: rule__Alphabet__Group__2__Impl : ( '=' ) ;
    public final void rule__Alphabet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:822:1: ( ( '=' ) )
            // InternalParametricTimedRegularExpression.g:823:1: ( '=' )
            {
            // InternalParametricTimedRegularExpression.g:823:1: ( '=' )
            // InternalParametricTimedRegularExpression.g:824:2: '='
            {
             before(grammarAccess.getAlphabetAccess().getEqualsSignKeyword_2()); 
            match(input,12,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:833:1: rule__Alphabet__Group__3 : rule__Alphabet__Group__3__Impl rule__Alphabet__Group__4 ;
    public final void rule__Alphabet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:837:1: ( rule__Alphabet__Group__3__Impl rule__Alphabet__Group__4 )
            // InternalParametricTimedRegularExpression.g:838:2: rule__Alphabet__Group__3__Impl rule__Alphabet__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__Alphabet__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:845:1: rule__Alphabet__Group__3__Impl : ( '{' ) ;
    public final void rule__Alphabet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:849:1: ( ( '{' ) )
            // InternalParametricTimedRegularExpression.g:850:1: ( '{' )
            {
            // InternalParametricTimedRegularExpression.g:850:1: ( '{' )
            // InternalParametricTimedRegularExpression.g:851:2: '{'
            {
             before(grammarAccess.getAlphabetAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,13,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:860:1: rule__Alphabet__Group__4 : rule__Alphabet__Group__4__Impl rule__Alphabet__Group__5 ;
    public final void rule__Alphabet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:864:1: ( rule__Alphabet__Group__4__Impl rule__Alphabet__Group__5 )
            // InternalParametricTimedRegularExpression.g:865:2: rule__Alphabet__Group__4__Impl rule__Alphabet__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Alphabet__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:872:1: rule__Alphabet__Group__4__Impl : ( ( rule__Alphabet__Group_4__0 )? ) ;
    public final void rule__Alphabet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:876:1: ( ( ( rule__Alphabet__Group_4__0 )? ) )
            // InternalParametricTimedRegularExpression.g:877:1: ( ( rule__Alphabet__Group_4__0 )? )
            {
            // InternalParametricTimedRegularExpression.g:877:1: ( ( rule__Alphabet__Group_4__0 )? )
            // InternalParametricTimedRegularExpression.g:878:2: ( rule__Alphabet__Group_4__0 )?
            {
             before(grammarAccess.getAlphabetAccess().getGroup_4()); 
            // InternalParametricTimedRegularExpression.g:879:2: ( rule__Alphabet__Group_4__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:879:3: rule__Alphabet__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:887:1: rule__Alphabet__Group__5 : rule__Alphabet__Group__5__Impl ;
    public final void rule__Alphabet__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:891:1: ( rule__Alphabet__Group__5__Impl )
            // InternalParametricTimedRegularExpression.g:892:2: rule__Alphabet__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:898:1: rule__Alphabet__Group__5__Impl : ( '}' ) ;
    public final void rule__Alphabet__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:902:1: ( ( '}' ) )
            // InternalParametricTimedRegularExpression.g:903:1: ( '}' )
            {
            // InternalParametricTimedRegularExpression.g:903:1: ( '}' )
            // InternalParametricTimedRegularExpression.g:904:2: '}'
            {
             before(grammarAccess.getAlphabetAccess().getRightCurlyBracketKeyword_5()); 
            match(input,14,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:914:1: rule__Alphabet__Group_4__0 : rule__Alphabet__Group_4__0__Impl rule__Alphabet__Group_4__1 ;
    public final void rule__Alphabet__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:918:1: ( rule__Alphabet__Group_4__0__Impl rule__Alphabet__Group_4__1 )
            // InternalParametricTimedRegularExpression.g:919:2: rule__Alphabet__Group_4__0__Impl rule__Alphabet__Group_4__1
            {
            pushFollow(FOLLOW_9);
            rule__Alphabet__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:926:1: rule__Alphabet__Group_4__0__Impl : ( ( rule__Alphabet__FunctorsAssignment_4_0 ) ) ;
    public final void rule__Alphabet__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:930:1: ( ( ( rule__Alphabet__FunctorsAssignment_4_0 ) ) )
            // InternalParametricTimedRegularExpression.g:931:1: ( ( rule__Alphabet__FunctorsAssignment_4_0 ) )
            {
            // InternalParametricTimedRegularExpression.g:931:1: ( ( rule__Alphabet__FunctorsAssignment_4_0 ) )
            // InternalParametricTimedRegularExpression.g:932:2: ( rule__Alphabet__FunctorsAssignment_4_0 )
            {
             before(grammarAccess.getAlphabetAccess().getFunctorsAssignment_4_0()); 
            // InternalParametricTimedRegularExpression.g:933:2: ( rule__Alphabet__FunctorsAssignment_4_0 )
            // InternalParametricTimedRegularExpression.g:933:3: rule__Alphabet__FunctorsAssignment_4_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:941:1: rule__Alphabet__Group_4__1 : rule__Alphabet__Group_4__1__Impl ;
    public final void rule__Alphabet__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:945:1: ( rule__Alphabet__Group_4__1__Impl )
            // InternalParametricTimedRegularExpression.g:946:2: rule__Alphabet__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:952:1: rule__Alphabet__Group_4__1__Impl : ( ( rule__Alphabet__Group_4_1__0 )* ) ;
    public final void rule__Alphabet__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:956:1: ( ( ( rule__Alphabet__Group_4_1__0 )* ) )
            // InternalParametricTimedRegularExpression.g:957:1: ( ( rule__Alphabet__Group_4_1__0 )* )
            {
            // InternalParametricTimedRegularExpression.g:957:1: ( ( rule__Alphabet__Group_4_1__0 )* )
            // InternalParametricTimedRegularExpression.g:958:2: ( rule__Alphabet__Group_4_1__0 )*
            {
             before(grammarAccess.getAlphabetAccess().getGroup_4_1()); 
            // InternalParametricTimedRegularExpression.g:959:2: ( rule__Alphabet__Group_4_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:959:3: rule__Alphabet__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_10);
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
    // InternalParametricTimedRegularExpression.g:968:1: rule__Alphabet__Group_4_1__0 : rule__Alphabet__Group_4_1__0__Impl rule__Alphabet__Group_4_1__1 ;
    public final void rule__Alphabet__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:972:1: ( rule__Alphabet__Group_4_1__0__Impl rule__Alphabet__Group_4_1__1 )
            // InternalParametricTimedRegularExpression.g:973:2: rule__Alphabet__Group_4_1__0__Impl rule__Alphabet__Group_4_1__1
            {
            pushFollow(FOLLOW_11);
            rule__Alphabet__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:980:1: rule__Alphabet__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__Alphabet__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:984:1: ( ( ',' ) )
            // InternalParametricTimedRegularExpression.g:985:1: ( ',' )
            {
            // InternalParametricTimedRegularExpression.g:985:1: ( ',' )
            // InternalParametricTimedRegularExpression.g:986:2: ','
            {
             before(grammarAccess.getAlphabetAccess().getCommaKeyword_4_1_0()); 
            match(input,15,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:995:1: rule__Alphabet__Group_4_1__1 : rule__Alphabet__Group_4_1__1__Impl ;
    public final void rule__Alphabet__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:999:1: ( rule__Alphabet__Group_4_1__1__Impl )
            // InternalParametricTimedRegularExpression.g:1000:2: rule__Alphabet__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1006:1: rule__Alphabet__Group_4_1__1__Impl : ( ( rule__Alphabet__FunctorsAssignment_4_1_1 ) ) ;
    public final void rule__Alphabet__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1010:1: ( ( ( rule__Alphabet__FunctorsAssignment_4_1_1 ) ) )
            // InternalParametricTimedRegularExpression.g:1011:1: ( ( rule__Alphabet__FunctorsAssignment_4_1_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:1011:1: ( ( rule__Alphabet__FunctorsAssignment_4_1_1 ) )
            // InternalParametricTimedRegularExpression.g:1012:2: ( rule__Alphabet__FunctorsAssignment_4_1_1 )
            {
             before(grammarAccess.getAlphabetAccess().getFunctorsAssignment_4_1_1()); 
            // InternalParametricTimedRegularExpression.g:1013:2: ( rule__Alphabet__FunctorsAssignment_4_1_1 )
            // InternalParametricTimedRegularExpression.g:1013:3: rule__Alphabet__FunctorsAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1022:1: rule__Functor__Group__0 : rule__Functor__Group__0__Impl rule__Functor__Group__1 ;
    public final void rule__Functor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1026:1: ( rule__Functor__Group__0__Impl rule__Functor__Group__1 )
            // InternalParametricTimedRegularExpression.g:1027:2: rule__Functor__Group__0__Impl rule__Functor__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Functor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1034:1: rule__Functor__Group__0__Impl : ( ( rule__Functor__NameAssignment_0 ) ) ;
    public final void rule__Functor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1038:1: ( ( ( rule__Functor__NameAssignment_0 ) ) )
            // InternalParametricTimedRegularExpression.g:1039:1: ( ( rule__Functor__NameAssignment_0 ) )
            {
            // InternalParametricTimedRegularExpression.g:1039:1: ( ( rule__Functor__NameAssignment_0 ) )
            // InternalParametricTimedRegularExpression.g:1040:2: ( rule__Functor__NameAssignment_0 )
            {
             before(grammarAccess.getFunctorAccess().getNameAssignment_0()); 
            // InternalParametricTimedRegularExpression.g:1041:2: ( rule__Functor__NameAssignment_0 )
            // InternalParametricTimedRegularExpression.g:1041:3: rule__Functor__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1049:1: rule__Functor__Group__1 : rule__Functor__Group__1__Impl ;
    public final void rule__Functor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1053:1: ( rule__Functor__Group__1__Impl )
            // InternalParametricTimedRegularExpression.g:1054:2: rule__Functor__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1060:1: rule__Functor__Group__1__Impl : ( ( rule__Functor__Group_1__0 )? ) ;
    public final void rule__Functor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1064:1: ( ( ( rule__Functor__Group_1__0 )? ) )
            // InternalParametricTimedRegularExpression.g:1065:1: ( ( rule__Functor__Group_1__0 )? )
            {
            // InternalParametricTimedRegularExpression.g:1065:1: ( ( rule__Functor__Group_1__0 )? )
            // InternalParametricTimedRegularExpression.g:1066:2: ( rule__Functor__Group_1__0 )?
            {
             before(grammarAccess.getFunctorAccess().getGroup_1()); 
            // InternalParametricTimedRegularExpression.g:1067:2: ( rule__Functor__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:1067:3: rule__Functor__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1076:1: rule__Functor__Group_1__0 : rule__Functor__Group_1__0__Impl rule__Functor__Group_1__1 ;
    public final void rule__Functor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1080:1: ( rule__Functor__Group_1__0__Impl rule__Functor__Group_1__1 )
            // InternalParametricTimedRegularExpression.g:1081:2: rule__Functor__Group_1__0__Impl rule__Functor__Group_1__1
            {
            pushFollow(FOLLOW_13);
            rule__Functor__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1088:1: rule__Functor__Group_1__0__Impl : ( '/' ) ;
    public final void rule__Functor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1092:1: ( ( '/' ) )
            // InternalParametricTimedRegularExpression.g:1093:1: ( '/' )
            {
            // InternalParametricTimedRegularExpression.g:1093:1: ( '/' )
            // InternalParametricTimedRegularExpression.g:1094:2: '/'
            {
             before(grammarAccess.getFunctorAccess().getSolidusKeyword_1_0()); 
            match(input,16,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:1103:1: rule__Functor__Group_1__1 : rule__Functor__Group_1__1__Impl ;
    public final void rule__Functor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1107:1: ( rule__Functor__Group_1__1__Impl )
            // InternalParametricTimedRegularExpression.g:1108:2: rule__Functor__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1114:1: rule__Functor__Group_1__1__Impl : ( ( rule__Functor__ArityAssignment_1_1 ) ) ;
    public final void rule__Functor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1118:1: ( ( ( rule__Functor__ArityAssignment_1_1 ) ) )
            // InternalParametricTimedRegularExpression.g:1119:1: ( ( rule__Functor__ArityAssignment_1_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:1119:1: ( ( rule__Functor__ArityAssignment_1_1 ) )
            // InternalParametricTimedRegularExpression.g:1120:2: ( rule__Functor__ArityAssignment_1_1 )
            {
             before(grammarAccess.getFunctorAccess().getArityAssignment_1_1()); 
            // InternalParametricTimedRegularExpression.g:1121:2: ( rule__Functor__ArityAssignment_1_1 )
            // InternalParametricTimedRegularExpression.g:1121:3: rule__Functor__ArityAssignment_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1130:1: rule__ExpressionDeclaration__Group__0 : rule__ExpressionDeclaration__Group__0__Impl rule__ExpressionDeclaration__Group__1 ;
    public final void rule__ExpressionDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1134:1: ( rule__ExpressionDeclaration__Group__0__Impl rule__ExpressionDeclaration__Group__1 )
            // InternalParametricTimedRegularExpression.g:1135:2: rule__ExpressionDeclaration__Group__0__Impl rule__ExpressionDeclaration__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__ExpressionDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1142:1: rule__ExpressionDeclaration__Group__0__Impl : ( 'expression' ) ;
    public final void rule__ExpressionDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1146:1: ( ( 'expression' ) )
            // InternalParametricTimedRegularExpression.g:1147:1: ( 'expression' )
            {
            // InternalParametricTimedRegularExpression.g:1147:1: ( 'expression' )
            // InternalParametricTimedRegularExpression.g:1148:2: 'expression'
            {
             before(grammarAccess.getExpressionDeclarationAccess().getExpressionKeyword_0()); 
            match(input,17,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:1157:1: rule__ExpressionDeclaration__Group__1 : rule__ExpressionDeclaration__Group__1__Impl rule__ExpressionDeclaration__Group__2 ;
    public final void rule__ExpressionDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1161:1: ( rule__ExpressionDeclaration__Group__1__Impl rule__ExpressionDeclaration__Group__2 )
            // InternalParametricTimedRegularExpression.g:1162:2: rule__ExpressionDeclaration__Group__1__Impl rule__ExpressionDeclaration__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__ExpressionDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1169:1: rule__ExpressionDeclaration__Group__1__Impl : ( ( rule__ExpressionDeclaration__NameAssignment_1 ) ) ;
    public final void rule__ExpressionDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1173:1: ( ( ( rule__ExpressionDeclaration__NameAssignment_1 ) ) )
            // InternalParametricTimedRegularExpression.g:1174:1: ( ( rule__ExpressionDeclaration__NameAssignment_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:1174:1: ( ( rule__ExpressionDeclaration__NameAssignment_1 ) )
            // InternalParametricTimedRegularExpression.g:1175:2: ( rule__ExpressionDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getNameAssignment_1()); 
            // InternalParametricTimedRegularExpression.g:1176:2: ( rule__ExpressionDeclaration__NameAssignment_1 )
            // InternalParametricTimedRegularExpression.g:1176:3: rule__ExpressionDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1184:1: rule__ExpressionDeclaration__Group__2 : rule__ExpressionDeclaration__Group__2__Impl rule__ExpressionDeclaration__Group__3 ;
    public final void rule__ExpressionDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1188:1: ( rule__ExpressionDeclaration__Group__2__Impl rule__ExpressionDeclaration__Group__3 )
            // InternalParametricTimedRegularExpression.g:1189:2: rule__ExpressionDeclaration__Group__2__Impl rule__ExpressionDeclaration__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__ExpressionDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1196:1: rule__ExpressionDeclaration__Group__2__Impl : ( ( rule__ExpressionDeclaration__Group_2__0 )? ) ;
    public final void rule__ExpressionDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1200:1: ( ( ( rule__ExpressionDeclaration__Group_2__0 )? ) )
            // InternalParametricTimedRegularExpression.g:1201:1: ( ( rule__ExpressionDeclaration__Group_2__0 )? )
            {
            // InternalParametricTimedRegularExpression.g:1201:1: ( ( rule__ExpressionDeclaration__Group_2__0 )? )
            // InternalParametricTimedRegularExpression.g:1202:2: ( rule__ExpressionDeclaration__Group_2__0 )?
            {
             before(grammarAccess.getExpressionDeclarationAccess().getGroup_2()); 
            // InternalParametricTimedRegularExpression.g:1203:2: ( rule__ExpressionDeclaration__Group_2__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:1203:3: rule__ExpressionDeclaration__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1211:1: rule__ExpressionDeclaration__Group__3 : rule__ExpressionDeclaration__Group__3__Impl rule__ExpressionDeclaration__Group__4 ;
    public final void rule__ExpressionDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1215:1: ( rule__ExpressionDeclaration__Group__3__Impl rule__ExpressionDeclaration__Group__4 )
            // InternalParametricTimedRegularExpression.g:1216:2: rule__ExpressionDeclaration__Group__3__Impl rule__ExpressionDeclaration__Group__4
            {
            pushFollow(FOLLOW_15);
            rule__ExpressionDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1223:1: rule__ExpressionDeclaration__Group__3__Impl : ( '=' ) ;
    public final void rule__ExpressionDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1227:1: ( ( '=' ) )
            // InternalParametricTimedRegularExpression.g:1228:1: ( '=' )
            {
            // InternalParametricTimedRegularExpression.g:1228:1: ( '=' )
            // InternalParametricTimedRegularExpression.g:1229:2: '='
            {
             before(grammarAccess.getExpressionDeclarationAccess().getEqualsSignKeyword_3()); 
            match(input,12,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:1238:1: rule__ExpressionDeclaration__Group__4 : rule__ExpressionDeclaration__Group__4__Impl ;
    public final void rule__ExpressionDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1242:1: ( rule__ExpressionDeclaration__Group__4__Impl )
            // InternalParametricTimedRegularExpression.g:1243:2: rule__ExpressionDeclaration__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1249:1: rule__ExpressionDeclaration__Group__4__Impl : ( ( rule__ExpressionDeclaration__BodyAssignment_4 ) ) ;
    public final void rule__ExpressionDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1253:1: ( ( ( rule__ExpressionDeclaration__BodyAssignment_4 ) ) )
            // InternalParametricTimedRegularExpression.g:1254:1: ( ( rule__ExpressionDeclaration__BodyAssignment_4 ) )
            {
            // InternalParametricTimedRegularExpression.g:1254:1: ( ( rule__ExpressionDeclaration__BodyAssignment_4 ) )
            // InternalParametricTimedRegularExpression.g:1255:2: ( rule__ExpressionDeclaration__BodyAssignment_4 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getBodyAssignment_4()); 
            // InternalParametricTimedRegularExpression.g:1256:2: ( rule__ExpressionDeclaration__BodyAssignment_4 )
            // InternalParametricTimedRegularExpression.g:1256:3: rule__ExpressionDeclaration__BodyAssignment_4
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1265:1: rule__ExpressionDeclaration__Group_2__0 : rule__ExpressionDeclaration__Group_2__0__Impl rule__ExpressionDeclaration__Group_2__1 ;
    public final void rule__ExpressionDeclaration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1269:1: ( rule__ExpressionDeclaration__Group_2__0__Impl rule__ExpressionDeclaration__Group_2__1 )
            // InternalParametricTimedRegularExpression.g:1270:2: rule__ExpressionDeclaration__Group_2__0__Impl rule__ExpressionDeclaration__Group_2__1
            {
            pushFollow(FOLLOW_11);
            rule__ExpressionDeclaration__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1277:1: rule__ExpressionDeclaration__Group_2__0__Impl : ( '[' ) ;
    public final void rule__ExpressionDeclaration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1281:1: ( ( '[' ) )
            // InternalParametricTimedRegularExpression.g:1282:1: ( '[' )
            {
            // InternalParametricTimedRegularExpression.g:1282:1: ( '[' )
            // InternalParametricTimedRegularExpression.g:1283:2: '['
            {
             before(grammarAccess.getExpressionDeclarationAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,18,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:1292:1: rule__ExpressionDeclaration__Group_2__1 : rule__ExpressionDeclaration__Group_2__1__Impl rule__ExpressionDeclaration__Group_2__2 ;
    public final void rule__ExpressionDeclaration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1296:1: ( rule__ExpressionDeclaration__Group_2__1__Impl rule__ExpressionDeclaration__Group_2__2 )
            // InternalParametricTimedRegularExpression.g:1297:2: rule__ExpressionDeclaration__Group_2__1__Impl rule__ExpressionDeclaration__Group_2__2
            {
            pushFollow(FOLLOW_16);
            rule__ExpressionDeclaration__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1304:1: rule__ExpressionDeclaration__Group_2__1__Impl : ( ( rule__ExpressionDeclaration__VarsAssignment_2_1 ) ) ;
    public final void rule__ExpressionDeclaration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1308:1: ( ( ( rule__ExpressionDeclaration__VarsAssignment_2_1 ) ) )
            // InternalParametricTimedRegularExpression.g:1309:1: ( ( rule__ExpressionDeclaration__VarsAssignment_2_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:1309:1: ( ( rule__ExpressionDeclaration__VarsAssignment_2_1 ) )
            // InternalParametricTimedRegularExpression.g:1310:2: ( rule__ExpressionDeclaration__VarsAssignment_2_1 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getVarsAssignment_2_1()); 
            // InternalParametricTimedRegularExpression.g:1311:2: ( rule__ExpressionDeclaration__VarsAssignment_2_1 )
            // InternalParametricTimedRegularExpression.g:1311:3: rule__ExpressionDeclaration__VarsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1319:1: rule__ExpressionDeclaration__Group_2__2 : rule__ExpressionDeclaration__Group_2__2__Impl rule__ExpressionDeclaration__Group_2__3 ;
    public final void rule__ExpressionDeclaration__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1323:1: ( rule__ExpressionDeclaration__Group_2__2__Impl rule__ExpressionDeclaration__Group_2__3 )
            // InternalParametricTimedRegularExpression.g:1324:2: rule__ExpressionDeclaration__Group_2__2__Impl rule__ExpressionDeclaration__Group_2__3
            {
            pushFollow(FOLLOW_16);
            rule__ExpressionDeclaration__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1331:1: rule__ExpressionDeclaration__Group_2__2__Impl : ( ( rule__ExpressionDeclaration__Group_2_2__0 )* ) ;
    public final void rule__ExpressionDeclaration__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1335:1: ( ( ( rule__ExpressionDeclaration__Group_2_2__0 )* ) )
            // InternalParametricTimedRegularExpression.g:1336:1: ( ( rule__ExpressionDeclaration__Group_2_2__0 )* )
            {
            // InternalParametricTimedRegularExpression.g:1336:1: ( ( rule__ExpressionDeclaration__Group_2_2__0 )* )
            // InternalParametricTimedRegularExpression.g:1337:2: ( rule__ExpressionDeclaration__Group_2_2__0 )*
            {
             before(grammarAccess.getExpressionDeclarationAccess().getGroup_2_2()); 
            // InternalParametricTimedRegularExpression.g:1338:2: ( rule__ExpressionDeclaration__Group_2_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:1338:3: rule__ExpressionDeclaration__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_10);
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
    // InternalParametricTimedRegularExpression.g:1346:1: rule__ExpressionDeclaration__Group_2__3 : rule__ExpressionDeclaration__Group_2__3__Impl ;
    public final void rule__ExpressionDeclaration__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1350:1: ( rule__ExpressionDeclaration__Group_2__3__Impl )
            // InternalParametricTimedRegularExpression.g:1351:2: rule__ExpressionDeclaration__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1357:1: rule__ExpressionDeclaration__Group_2__3__Impl : ( ']' ) ;
    public final void rule__ExpressionDeclaration__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1361:1: ( ( ']' ) )
            // InternalParametricTimedRegularExpression.g:1362:1: ( ']' )
            {
            // InternalParametricTimedRegularExpression.g:1362:1: ( ']' )
            // InternalParametricTimedRegularExpression.g:1363:2: ']'
            {
             before(grammarAccess.getExpressionDeclarationAccess().getRightSquareBracketKeyword_2_3()); 
            match(input,19,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:1373:1: rule__ExpressionDeclaration__Group_2_2__0 : rule__ExpressionDeclaration__Group_2_2__0__Impl rule__ExpressionDeclaration__Group_2_2__1 ;
    public final void rule__ExpressionDeclaration__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1377:1: ( rule__ExpressionDeclaration__Group_2_2__0__Impl rule__ExpressionDeclaration__Group_2_2__1 )
            // InternalParametricTimedRegularExpression.g:1378:2: rule__ExpressionDeclaration__Group_2_2__0__Impl rule__ExpressionDeclaration__Group_2_2__1
            {
            pushFollow(FOLLOW_11);
            rule__ExpressionDeclaration__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1385:1: rule__ExpressionDeclaration__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__ExpressionDeclaration__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1389:1: ( ( ',' ) )
            // InternalParametricTimedRegularExpression.g:1390:1: ( ',' )
            {
            // InternalParametricTimedRegularExpression.g:1390:1: ( ',' )
            // InternalParametricTimedRegularExpression.g:1391:2: ','
            {
             before(grammarAccess.getExpressionDeclarationAccess().getCommaKeyword_2_2_0()); 
            match(input,15,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:1400:1: rule__ExpressionDeclaration__Group_2_2__1 : rule__ExpressionDeclaration__Group_2_2__1__Impl ;
    public final void rule__ExpressionDeclaration__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1404:1: ( rule__ExpressionDeclaration__Group_2_2__1__Impl )
            // InternalParametricTimedRegularExpression.g:1405:2: rule__ExpressionDeclaration__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1411:1: rule__ExpressionDeclaration__Group_2_2__1__Impl : ( ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 ) ) ;
    public final void rule__ExpressionDeclaration__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1415:1: ( ( ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 ) ) )
            // InternalParametricTimedRegularExpression.g:1416:1: ( ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:1416:1: ( ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 ) )
            // InternalParametricTimedRegularExpression.g:1417:2: ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 )
            {
             before(grammarAccess.getExpressionDeclarationAccess().getVarsAssignment_2_2_1()); 
            // InternalParametricTimedRegularExpression.g:1418:2: ( rule__ExpressionDeclaration__VarsAssignment_2_2_1 )
            // InternalParametricTimedRegularExpression.g:1418:3: rule__ExpressionDeclaration__VarsAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__And__Group__0"
    // InternalParametricTimedRegularExpression.g:1427:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1431:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalParametricTimedRegularExpression.g:1432:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__And__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group__1();

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
    // $ANTLR end "rule__And__Group__0"


    // $ANTLR start "rule__And__Group__0__Impl"
    // InternalParametricTimedRegularExpression.g:1439:1: rule__And__Group__0__Impl : ( ruleChoice ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1443:1: ( ( ruleChoice ) )
            // InternalParametricTimedRegularExpression.g:1444:1: ( ruleChoice )
            {
            // InternalParametricTimedRegularExpression.g:1444:1: ( ruleChoice )
            // InternalParametricTimedRegularExpression.g:1445:2: ruleChoice
            {
             before(grammarAccess.getAndAccess().getChoiceParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleChoice();

            state._fsp--;

             after(grammarAccess.getAndAccess().getChoiceParserRuleCall_0()); 

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
    // $ANTLR end "rule__And__Group__0__Impl"


    // $ANTLR start "rule__And__Group__1"
    // InternalParametricTimedRegularExpression.g:1454:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1458:1: ( rule__And__Group__1__Impl )
            // InternalParametricTimedRegularExpression.g:1459:2: rule__And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__1__Impl();

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
    // $ANTLR end "rule__And__Group__1"


    // $ANTLR start "rule__And__Group__1__Impl"
    // InternalParametricTimedRegularExpression.g:1465:1: rule__And__Group__1__Impl : ( ( rule__And__Group_1__0 )? ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1469:1: ( ( ( rule__And__Group_1__0 )? ) )
            // InternalParametricTimedRegularExpression.g:1470:1: ( ( rule__And__Group_1__0 )? )
            {
            // InternalParametricTimedRegularExpression.g:1470:1: ( ( rule__And__Group_1__0 )? )
            // InternalParametricTimedRegularExpression.g:1471:2: ( rule__And__Group_1__0 )?
            {
             before(grammarAccess.getAndAccess().getGroup_1()); 
            // InternalParametricTimedRegularExpression.g:1472:2: ( rule__And__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:1472:3: rule__And__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__And__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAndAccess().getGroup_1()); 

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
    // $ANTLR end "rule__And__Group__1__Impl"


    // $ANTLR start "rule__And__Group_1__0"
    // InternalParametricTimedRegularExpression.g:1481:1: rule__And__Group_1__0 : rule__And__Group_1__0__Impl rule__And__Group_1__1 ;
    public final void rule__And__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1485:1: ( rule__And__Group_1__0__Impl rule__And__Group_1__1 )
            // InternalParametricTimedRegularExpression.g:1486:2: rule__And__Group_1__0__Impl rule__And__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__And__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1__1();

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
    // $ANTLR end "rule__And__Group_1__0"


    // $ANTLR start "rule__And__Group_1__0__Impl"
    // InternalParametricTimedRegularExpression.g:1493:1: rule__And__Group_1__0__Impl : ( () ) ;
    public final void rule__And__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1497:1: ( ( () ) )
            // InternalParametricTimedRegularExpression.g:1498:1: ( () )
            {
            // InternalParametricTimedRegularExpression.g:1498:1: ( () )
            // InternalParametricTimedRegularExpression.g:1499:2: ()
            {
             before(grammarAccess.getAndAccess().getAndElementsAction_1_0()); 
            // InternalParametricTimedRegularExpression.g:1500:2: ()
            // InternalParametricTimedRegularExpression.g:1500:3: 
            {
            }

             after(grammarAccess.getAndAccess().getAndElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group_1__0__Impl"


    // $ANTLR start "rule__And__Group_1__1"
    // InternalParametricTimedRegularExpression.g:1508:1: rule__And__Group_1__1 : rule__And__Group_1__1__Impl ;
    public final void rule__And__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1512:1: ( rule__And__Group_1__1__Impl )
            // InternalParametricTimedRegularExpression.g:1513:2: rule__And__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group_1__1__Impl();

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
    // $ANTLR end "rule__And__Group_1__1"


    // $ANTLR start "rule__And__Group_1__1__Impl"
    // InternalParametricTimedRegularExpression.g:1519:1: rule__And__Group_1__1__Impl : ( ( ( rule__And__Group_1_1__0 ) ) ( ( rule__And__Group_1_1__0 )* ) ) ;
    public final void rule__And__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1523:1: ( ( ( ( rule__And__Group_1_1__0 ) ) ( ( rule__And__Group_1_1__0 )* ) ) )
            // InternalParametricTimedRegularExpression.g:1524:1: ( ( ( rule__And__Group_1_1__0 ) ) ( ( rule__And__Group_1_1__0 )* ) )
            {
            // InternalParametricTimedRegularExpression.g:1524:1: ( ( ( rule__And__Group_1_1__0 ) ) ( ( rule__And__Group_1_1__0 )* ) )
            // InternalParametricTimedRegularExpression.g:1525:2: ( ( rule__And__Group_1_1__0 ) ) ( ( rule__And__Group_1_1__0 )* )
            {
            // InternalParametricTimedRegularExpression.g:1525:2: ( ( rule__And__Group_1_1__0 ) )
            // InternalParametricTimedRegularExpression.g:1526:3: ( rule__And__Group_1_1__0 )
            {
             before(grammarAccess.getAndAccess().getGroup_1_1()); 
            // InternalParametricTimedRegularExpression.g:1527:3: ( rule__And__Group_1_1__0 )
            // InternalParametricTimedRegularExpression.g:1527:4: rule__And__Group_1_1__0
            {
            pushFollow(FOLLOW_18);
            rule__And__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getGroup_1_1()); 

            }

            // InternalParametricTimedRegularExpression.g:1530:2: ( ( rule__And__Group_1_1__0 )* )
            // InternalParametricTimedRegularExpression.g:1531:3: ( rule__And__Group_1_1__0 )*
            {
             before(grammarAccess.getAndAccess().getGroup_1_1()); 
            // InternalParametricTimedRegularExpression.g:1532:3: ( rule__And__Group_1_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:1532:4: rule__And__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__And__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getAndAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__And__Group_1__1__Impl"


    // $ANTLR start "rule__And__Group_1_1__0"
    // InternalParametricTimedRegularExpression.g:1542:1: rule__And__Group_1_1__0 : rule__And__Group_1_1__0__Impl rule__And__Group_1_1__1 ;
    public final void rule__And__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1546:1: ( rule__And__Group_1_1__0__Impl rule__And__Group_1_1__1 )
            // InternalParametricTimedRegularExpression.g:1547:2: rule__And__Group_1_1__0__Impl rule__And__Group_1_1__1
            {
            pushFollow(FOLLOW_15);
            rule__And__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group_1_1__1();

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
    // $ANTLR end "rule__And__Group_1_1__0"


    // $ANTLR start "rule__And__Group_1_1__0__Impl"
    // InternalParametricTimedRegularExpression.g:1554:1: rule__And__Group_1_1__0__Impl : ( '&' ) ;
    public final void rule__And__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1558:1: ( ( '&' ) )
            // InternalParametricTimedRegularExpression.g:1559:1: ( '&' )
            {
            // InternalParametricTimedRegularExpression.g:1559:1: ( '&' )
            // InternalParametricTimedRegularExpression.g:1560:2: '&'
            {
             before(grammarAccess.getAndAccess().getAmpersandKeyword_1_1_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getAndAccess().getAmpersandKeyword_1_1_0()); 

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
    // $ANTLR end "rule__And__Group_1_1__0__Impl"


    // $ANTLR start "rule__And__Group_1_1__1"
    // InternalParametricTimedRegularExpression.g:1569:1: rule__And__Group_1_1__1 : rule__And__Group_1_1__1__Impl ;
    public final void rule__And__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1573:1: ( rule__And__Group_1_1__1__Impl )
            // InternalParametricTimedRegularExpression.g:1574:2: rule__And__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__And__Group_1_1__1"


    // $ANTLR start "rule__And__Group_1_1__1__Impl"
    // InternalParametricTimedRegularExpression.g:1580:1: rule__And__Group_1_1__1__Impl : ( ( rule__And__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__And__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1584:1: ( ( ( rule__And__ElementsAssignment_1_1_1 ) ) )
            // InternalParametricTimedRegularExpression.g:1585:1: ( ( rule__And__ElementsAssignment_1_1_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:1585:1: ( ( rule__And__ElementsAssignment_1_1_1 ) )
            // InternalParametricTimedRegularExpression.g:1586:2: ( rule__And__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAndAccess().getElementsAssignment_1_1_1()); 
            // InternalParametricTimedRegularExpression.g:1587:2: ( rule__And__ElementsAssignment_1_1_1 )
            // InternalParametricTimedRegularExpression.g:1587:3: rule__And__ElementsAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__And__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getElementsAssignment_1_1_1()); 

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
    // $ANTLR end "rule__And__Group_1_1__1__Impl"


    // $ANTLR start "rule__Choice__Group__0"
    // InternalParametricTimedRegularExpression.g:1596:1: rule__Choice__Group__0 : rule__Choice__Group__0__Impl rule__Choice__Group__1 ;
    public final void rule__Choice__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1600:1: ( rule__Choice__Group__0__Impl rule__Choice__Group__1 )
            // InternalParametricTimedRegularExpression.g:1601:2: rule__Choice__Group__0__Impl rule__Choice__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Choice__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1608:1: rule__Choice__Group__0__Impl : ( ruleSequence ) ;
    public final void rule__Choice__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1612:1: ( ( ruleSequence ) )
            // InternalParametricTimedRegularExpression.g:1613:1: ( ruleSequence )
            {
            // InternalParametricTimedRegularExpression.g:1613:1: ( ruleSequence )
            // InternalParametricTimedRegularExpression.g:1614:2: ruleSequence
            {
             before(grammarAccess.getChoiceAccess().getSequenceParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1623:1: rule__Choice__Group__1 : rule__Choice__Group__1__Impl ;
    public final void rule__Choice__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1627:1: ( rule__Choice__Group__1__Impl )
            // InternalParametricTimedRegularExpression.g:1628:2: rule__Choice__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1634:1: rule__Choice__Group__1__Impl : ( ( rule__Choice__Group_1__0 )? ) ;
    public final void rule__Choice__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1638:1: ( ( ( rule__Choice__Group_1__0 )? ) )
            // InternalParametricTimedRegularExpression.g:1639:1: ( ( rule__Choice__Group_1__0 )? )
            {
            // InternalParametricTimedRegularExpression.g:1639:1: ( ( rule__Choice__Group_1__0 )? )
            // InternalParametricTimedRegularExpression.g:1640:2: ( rule__Choice__Group_1__0 )?
            {
             before(grammarAccess.getChoiceAccess().getGroup_1()); 
            // InternalParametricTimedRegularExpression.g:1641:2: ( rule__Choice__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:1641:3: rule__Choice__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1650:1: rule__Choice__Group_1__0 : rule__Choice__Group_1__0__Impl rule__Choice__Group_1__1 ;
    public final void rule__Choice__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1654:1: ( rule__Choice__Group_1__0__Impl rule__Choice__Group_1__1 )
            // InternalParametricTimedRegularExpression.g:1655:2: rule__Choice__Group_1__0__Impl rule__Choice__Group_1__1
            {
            pushFollow(FOLLOW_19);
            rule__Choice__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1662:1: rule__Choice__Group_1__0__Impl : ( () ) ;
    public final void rule__Choice__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1666:1: ( ( () ) )
            // InternalParametricTimedRegularExpression.g:1667:1: ( () )
            {
            // InternalParametricTimedRegularExpression.g:1667:1: ( () )
            // InternalParametricTimedRegularExpression.g:1668:2: ()
            {
             before(grammarAccess.getChoiceAccess().getChoiceElementsAction_1_0()); 
            // InternalParametricTimedRegularExpression.g:1669:2: ()
            // InternalParametricTimedRegularExpression.g:1669:3: 
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
    // InternalParametricTimedRegularExpression.g:1677:1: rule__Choice__Group_1__1 : rule__Choice__Group_1__1__Impl ;
    public final void rule__Choice__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1681:1: ( rule__Choice__Group_1__1__Impl )
            // InternalParametricTimedRegularExpression.g:1682:2: rule__Choice__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1688:1: rule__Choice__Group_1__1__Impl : ( ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* ) ) ;
    public final void rule__Choice__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1692:1: ( ( ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* ) ) )
            // InternalParametricTimedRegularExpression.g:1693:1: ( ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* ) )
            {
            // InternalParametricTimedRegularExpression.g:1693:1: ( ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* ) )
            // InternalParametricTimedRegularExpression.g:1694:2: ( ( rule__Choice__Group_1_1__0 ) ) ( ( rule__Choice__Group_1_1__0 )* )
            {
            // InternalParametricTimedRegularExpression.g:1694:2: ( ( rule__Choice__Group_1_1__0 ) )
            // InternalParametricTimedRegularExpression.g:1695:3: ( rule__Choice__Group_1_1__0 )
            {
             before(grammarAccess.getChoiceAccess().getGroup_1_1()); 
            // InternalParametricTimedRegularExpression.g:1696:3: ( rule__Choice__Group_1_1__0 )
            // InternalParametricTimedRegularExpression.g:1696:4: rule__Choice__Group_1_1__0
            {
            pushFollow(FOLLOW_20);
            rule__Choice__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getChoiceAccess().getGroup_1_1()); 

            }

            // InternalParametricTimedRegularExpression.g:1699:2: ( ( rule__Choice__Group_1_1__0 )* )
            // InternalParametricTimedRegularExpression.g:1700:3: ( rule__Choice__Group_1_1__0 )*
            {
             before(grammarAccess.getChoiceAccess().getGroup_1_1()); 
            // InternalParametricTimedRegularExpression.g:1701:3: ( rule__Choice__Group_1_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==21) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:1701:4: rule__Choice__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__Choice__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalParametricTimedRegularExpression.g:1711:1: rule__Choice__Group_1_1__0 : rule__Choice__Group_1_1__0__Impl rule__Choice__Group_1_1__1 ;
    public final void rule__Choice__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1715:1: ( rule__Choice__Group_1_1__0__Impl rule__Choice__Group_1_1__1 )
            // InternalParametricTimedRegularExpression.g:1716:2: rule__Choice__Group_1_1__0__Impl rule__Choice__Group_1_1__1
            {
            pushFollow(FOLLOW_15);
            rule__Choice__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1723:1: rule__Choice__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Choice__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1727:1: ( ( '|' ) )
            // InternalParametricTimedRegularExpression.g:1728:1: ( '|' )
            {
            // InternalParametricTimedRegularExpression.g:1728:1: ( '|' )
            // InternalParametricTimedRegularExpression.g:1729:2: '|'
            {
             before(grammarAccess.getChoiceAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,21,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:1738:1: rule__Choice__Group_1_1__1 : rule__Choice__Group_1_1__1__Impl ;
    public final void rule__Choice__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1742:1: ( rule__Choice__Group_1_1__1__Impl )
            // InternalParametricTimedRegularExpression.g:1743:2: rule__Choice__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1749:1: rule__Choice__Group_1_1__1__Impl : ( ( rule__Choice__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__Choice__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1753:1: ( ( ( rule__Choice__ElementsAssignment_1_1_1 ) ) )
            // InternalParametricTimedRegularExpression.g:1754:1: ( ( rule__Choice__ElementsAssignment_1_1_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:1754:1: ( ( rule__Choice__ElementsAssignment_1_1_1 ) )
            // InternalParametricTimedRegularExpression.g:1755:2: ( rule__Choice__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getChoiceAccess().getElementsAssignment_1_1_1()); 
            // InternalParametricTimedRegularExpression.g:1756:2: ( rule__Choice__ElementsAssignment_1_1_1 )
            // InternalParametricTimedRegularExpression.g:1756:3: rule__Choice__ElementsAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1765:1: rule__Sequence__Group__0 : rule__Sequence__Group__0__Impl rule__Sequence__Group__1 ;
    public final void rule__Sequence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1769:1: ( rule__Sequence__Group__0__Impl rule__Sequence__Group__1 )
            // InternalParametricTimedRegularExpression.g:1770:2: rule__Sequence__Group__0__Impl rule__Sequence__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Sequence__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1777:1: rule__Sequence__Group__0__Impl : ( ruleMultExpression ) ;
    public final void rule__Sequence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1781:1: ( ( ruleMultExpression ) )
            // InternalParametricTimedRegularExpression.g:1782:1: ( ruleMultExpression )
            {
            // InternalParametricTimedRegularExpression.g:1782:1: ( ruleMultExpression )
            // InternalParametricTimedRegularExpression.g:1783:2: ruleMultExpression
            {
             before(grammarAccess.getSequenceAccess().getMultExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1792:1: rule__Sequence__Group__1 : rule__Sequence__Group__1__Impl ;
    public final void rule__Sequence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1796:1: ( rule__Sequence__Group__1__Impl )
            // InternalParametricTimedRegularExpression.g:1797:2: rule__Sequence__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1803:1: rule__Sequence__Group__1__Impl : ( ( rule__Sequence__Group_1__0 )? ) ;
    public final void rule__Sequence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1807:1: ( ( ( rule__Sequence__Group_1__0 )? ) )
            // InternalParametricTimedRegularExpression.g:1808:1: ( ( rule__Sequence__Group_1__0 )? )
            {
            // InternalParametricTimedRegularExpression.g:1808:1: ( ( rule__Sequence__Group_1__0 )? )
            // InternalParametricTimedRegularExpression.g:1809:2: ( rule__Sequence__Group_1__0 )?
            {
             before(grammarAccess.getSequenceAccess().getGroup_1()); 
            // InternalParametricTimedRegularExpression.g:1810:2: ( rule__Sequence__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID||LA16_0==24||LA16_0==26||LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:1810:3: rule__Sequence__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1819:1: rule__Sequence__Group_1__0 : rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 ;
    public final void rule__Sequence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1823:1: ( rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1 )
            // InternalParametricTimedRegularExpression.g:1824:2: rule__Sequence__Group_1__0__Impl rule__Sequence__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__Sequence__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1831:1: rule__Sequence__Group_1__0__Impl : ( () ) ;
    public final void rule__Sequence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1835:1: ( ( () ) )
            // InternalParametricTimedRegularExpression.g:1836:1: ( () )
            {
            // InternalParametricTimedRegularExpression.g:1836:1: ( () )
            // InternalParametricTimedRegularExpression.g:1837:2: ()
            {
             before(grammarAccess.getSequenceAccess().getSequenceElementsAction_1_0()); 
            // InternalParametricTimedRegularExpression.g:1838:2: ()
            // InternalParametricTimedRegularExpression.g:1838:3: 
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
    // InternalParametricTimedRegularExpression.g:1846:1: rule__Sequence__Group_1__1 : rule__Sequence__Group_1__1__Impl ;
    public final void rule__Sequence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1850:1: ( rule__Sequence__Group_1__1__Impl )
            // InternalParametricTimedRegularExpression.g:1851:2: rule__Sequence__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1857:1: rule__Sequence__Group_1__1__Impl : ( ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__Sequence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1861:1: ( ( ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* ) ) )
            // InternalParametricTimedRegularExpression.g:1862:1: ( ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* ) )
            {
            // InternalParametricTimedRegularExpression.g:1862:1: ( ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* ) )
            // InternalParametricTimedRegularExpression.g:1863:2: ( ( rule__Sequence__ElementsAssignment_1_1 ) ) ( ( rule__Sequence__ElementsAssignment_1_1 )* )
            {
            // InternalParametricTimedRegularExpression.g:1863:2: ( ( rule__Sequence__ElementsAssignment_1_1 ) )
            // InternalParametricTimedRegularExpression.g:1864:3: ( rule__Sequence__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getSequenceAccess().getElementsAssignment_1_1()); 
            // InternalParametricTimedRegularExpression.g:1865:3: ( rule__Sequence__ElementsAssignment_1_1 )
            // InternalParametricTimedRegularExpression.g:1865:4: rule__Sequence__ElementsAssignment_1_1
            {
            pushFollow(FOLLOW_21);
            rule__Sequence__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSequenceAccess().getElementsAssignment_1_1()); 

            }

            // InternalParametricTimedRegularExpression.g:1868:2: ( ( rule__Sequence__ElementsAssignment_1_1 )* )
            // InternalParametricTimedRegularExpression.g:1869:3: ( rule__Sequence__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getSequenceAccess().getElementsAssignment_1_1()); 
            // InternalParametricTimedRegularExpression.g:1870:3: ( rule__Sequence__ElementsAssignment_1_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==24||LA17_0==26||LA17_0==28) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:1870:4: rule__Sequence__ElementsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Sequence__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalParametricTimedRegularExpression.g:1880:1: rule__MultExpression__Group__0 : rule__MultExpression__Group__0__Impl rule__MultExpression__Group__1 ;
    public final void rule__MultExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1884:1: ( rule__MultExpression__Group__0__Impl rule__MultExpression__Group__1 )
            // InternalParametricTimedRegularExpression.g:1885:2: rule__MultExpression__Group__0__Impl rule__MultExpression__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__MultExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1892:1: rule__MultExpression__Group__0__Impl : ( ruleParenExpression ) ;
    public final void rule__MultExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1896:1: ( ( ruleParenExpression ) )
            // InternalParametricTimedRegularExpression.g:1897:1: ( ruleParenExpression )
            {
            // InternalParametricTimedRegularExpression.g:1897:1: ( ruleParenExpression )
            // InternalParametricTimedRegularExpression.g:1898:2: ruleParenExpression
            {
             before(grammarAccess.getMultExpressionAccess().getParenExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1907:1: rule__MultExpression__Group__1 : rule__MultExpression__Group__1__Impl ;
    public final void rule__MultExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1911:1: ( rule__MultExpression__Group__1__Impl )
            // InternalParametricTimedRegularExpression.g:1912:2: rule__MultExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1918:1: rule__MultExpression__Group__1__Impl : ( ( rule__MultExpression__Alternatives_1 )? ) ;
    public final void rule__MultExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1922:1: ( ( ( rule__MultExpression__Alternatives_1 )? ) )
            // InternalParametricTimedRegularExpression.g:1923:1: ( ( rule__MultExpression__Alternatives_1 )? )
            {
            // InternalParametricTimedRegularExpression.g:1923:1: ( ( rule__MultExpression__Alternatives_1 )? )
            // InternalParametricTimedRegularExpression.g:1924:2: ( rule__MultExpression__Alternatives_1 )?
            {
             before(grammarAccess.getMultExpressionAccess().getAlternatives_1()); 
            // InternalParametricTimedRegularExpression.g:1925:2: ( rule__MultExpression__Alternatives_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13||(LA18_0>=22 && LA18_0<=23)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:1925:3: rule__MultExpression__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1934:1: rule__MultExpression__Group_1_0__0 : rule__MultExpression__Group_1_0__0__Impl rule__MultExpression__Group_1_0__1 ;
    public final void rule__MultExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1938:1: ( rule__MultExpression__Group_1_0__0__Impl rule__MultExpression__Group_1_0__1 )
            // InternalParametricTimedRegularExpression.g:1939:2: rule__MultExpression__Group_1_0__0__Impl rule__MultExpression__Group_1_0__1
            {
            pushFollow(FOLLOW_23);
            rule__MultExpression__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1946:1: rule__MultExpression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__MultExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1950:1: ( ( () ) )
            // InternalParametricTimedRegularExpression.g:1951:1: ( () )
            {
            // InternalParametricTimedRegularExpression.g:1951:1: ( () )
            // InternalParametricTimedRegularExpression.g:1952:2: ()
            {
             before(grammarAccess.getMultExpressionAccess().getStarBodyAction_1_0_0()); 
            // InternalParametricTimedRegularExpression.g:1953:2: ()
            // InternalParametricTimedRegularExpression.g:1953:3: 
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
    // InternalParametricTimedRegularExpression.g:1961:1: rule__MultExpression__Group_1_0__1 : rule__MultExpression__Group_1_0__1__Impl ;
    public final void rule__MultExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1965:1: ( rule__MultExpression__Group_1_0__1__Impl )
            // InternalParametricTimedRegularExpression.g:1966:2: rule__MultExpression__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:1972:1: rule__MultExpression__Group_1_0__1__Impl : ( '*' ) ;
    public final void rule__MultExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1976:1: ( ( '*' ) )
            // InternalParametricTimedRegularExpression.g:1977:1: ( '*' )
            {
            // InternalParametricTimedRegularExpression.g:1977:1: ( '*' )
            // InternalParametricTimedRegularExpression.g:1978:2: '*'
            {
             before(grammarAccess.getMultExpressionAccess().getAsteriskKeyword_1_0_1()); 
            match(input,22,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:1988:1: rule__MultExpression__Group_1_1__0 : rule__MultExpression__Group_1_1__0__Impl rule__MultExpression__Group_1_1__1 ;
    public final void rule__MultExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:1992:1: ( rule__MultExpression__Group_1_1__0__Impl rule__MultExpression__Group_1_1__1 )
            // InternalParametricTimedRegularExpression.g:1993:2: rule__MultExpression__Group_1_1__0__Impl rule__MultExpression__Group_1_1__1
            {
            pushFollow(FOLLOW_24);
            rule__MultExpression__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2000:1: rule__MultExpression__Group_1_1__0__Impl : ( () ) ;
    public final void rule__MultExpression__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2004:1: ( ( () ) )
            // InternalParametricTimedRegularExpression.g:2005:1: ( () )
            {
            // InternalParametricTimedRegularExpression.g:2005:1: ( () )
            // InternalParametricTimedRegularExpression.g:2006:2: ()
            {
             before(grammarAccess.getMultExpressionAccess().getPlusBodyAction_1_1_0()); 
            // InternalParametricTimedRegularExpression.g:2007:2: ()
            // InternalParametricTimedRegularExpression.g:2007:3: 
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
    // InternalParametricTimedRegularExpression.g:2015:1: rule__MultExpression__Group_1_1__1 : rule__MultExpression__Group_1_1__1__Impl ;
    public final void rule__MultExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2019:1: ( rule__MultExpression__Group_1_1__1__Impl )
            // InternalParametricTimedRegularExpression.g:2020:2: rule__MultExpression__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2026:1: rule__MultExpression__Group_1_1__1__Impl : ( '+' ) ;
    public final void rule__MultExpression__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2030:1: ( ( '+' ) )
            // InternalParametricTimedRegularExpression.g:2031:1: ( '+' )
            {
            // InternalParametricTimedRegularExpression.g:2031:1: ( '+' )
            // InternalParametricTimedRegularExpression.g:2032:2: '+'
            {
             before(grammarAccess.getMultExpressionAccess().getPlusSignKeyword_1_1_1()); 
            match(input,23,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2042:1: rule__MultExpression__Group_1_2__0 : rule__MultExpression__Group_1_2__0__Impl rule__MultExpression__Group_1_2__1 ;
    public final void rule__MultExpression__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2046:1: ( rule__MultExpression__Group_1_2__0__Impl rule__MultExpression__Group_1_2__1 )
            // InternalParametricTimedRegularExpression.g:2047:2: rule__MultExpression__Group_1_2__0__Impl rule__MultExpression__Group_1_2__1
            {
            pushFollow(FOLLOW_22);
            rule__MultExpression__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2054:1: rule__MultExpression__Group_1_2__0__Impl : ( () ) ;
    public final void rule__MultExpression__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2058:1: ( ( () ) )
            // InternalParametricTimedRegularExpression.g:2059:1: ( () )
            {
            // InternalParametricTimedRegularExpression.g:2059:1: ( () )
            // InternalParametricTimedRegularExpression.g:2060:2: ()
            {
             before(grammarAccess.getMultExpressionAccess().getCardinalityBodyAction_1_2_0()); 
            // InternalParametricTimedRegularExpression.g:2061:2: ()
            // InternalParametricTimedRegularExpression.g:2061:3: 
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
    // InternalParametricTimedRegularExpression.g:2069:1: rule__MultExpression__Group_1_2__1 : rule__MultExpression__Group_1_2__1__Impl rule__MultExpression__Group_1_2__2 ;
    public final void rule__MultExpression__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2073:1: ( rule__MultExpression__Group_1_2__1__Impl rule__MultExpression__Group_1_2__2 )
            // InternalParametricTimedRegularExpression.g:2074:2: rule__MultExpression__Group_1_2__1__Impl rule__MultExpression__Group_1_2__2
            {
            pushFollow(FOLLOW_13);
            rule__MultExpression__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2081:1: rule__MultExpression__Group_1_2__1__Impl : ( '{' ) ;
    public final void rule__MultExpression__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2085:1: ( ( '{' ) )
            // InternalParametricTimedRegularExpression.g:2086:1: ( '{' )
            {
            // InternalParametricTimedRegularExpression.g:2086:1: ( '{' )
            // InternalParametricTimedRegularExpression.g:2087:2: '{'
            {
             before(grammarAccess.getMultExpressionAccess().getLeftCurlyBracketKeyword_1_2_1()); 
            match(input,13,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2096:1: rule__MultExpression__Group_1_2__2 : rule__MultExpression__Group_1_2__2__Impl rule__MultExpression__Group_1_2__3 ;
    public final void rule__MultExpression__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2100:1: ( rule__MultExpression__Group_1_2__2__Impl rule__MultExpression__Group_1_2__3 )
            // InternalParametricTimedRegularExpression.g:2101:2: rule__MultExpression__Group_1_2__2__Impl rule__MultExpression__Group_1_2__3
            {
            pushFollow(FOLLOW_25);
            rule__MultExpression__Group_1_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2108:1: rule__MultExpression__Group_1_2__2__Impl : ( ( rule__MultExpression__NAssignment_1_2_2 ) ) ;
    public final void rule__MultExpression__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2112:1: ( ( ( rule__MultExpression__NAssignment_1_2_2 ) ) )
            // InternalParametricTimedRegularExpression.g:2113:1: ( ( rule__MultExpression__NAssignment_1_2_2 ) )
            {
            // InternalParametricTimedRegularExpression.g:2113:1: ( ( rule__MultExpression__NAssignment_1_2_2 ) )
            // InternalParametricTimedRegularExpression.g:2114:2: ( rule__MultExpression__NAssignment_1_2_2 )
            {
             before(grammarAccess.getMultExpressionAccess().getNAssignment_1_2_2()); 
            // InternalParametricTimedRegularExpression.g:2115:2: ( rule__MultExpression__NAssignment_1_2_2 )
            // InternalParametricTimedRegularExpression.g:2115:3: rule__MultExpression__NAssignment_1_2_2
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2123:1: rule__MultExpression__Group_1_2__3 : rule__MultExpression__Group_1_2__3__Impl ;
    public final void rule__MultExpression__Group_1_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2127:1: ( rule__MultExpression__Group_1_2__3__Impl )
            // InternalParametricTimedRegularExpression.g:2128:2: rule__MultExpression__Group_1_2__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2134:1: rule__MultExpression__Group_1_2__3__Impl : ( '}' ) ;
    public final void rule__MultExpression__Group_1_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2138:1: ( ( '}' ) )
            // InternalParametricTimedRegularExpression.g:2139:1: ( '}' )
            {
            // InternalParametricTimedRegularExpression.g:2139:1: ( '}' )
            // InternalParametricTimedRegularExpression.g:2140:2: '}'
            {
             before(grammarAccess.getMultExpressionAccess().getRightCurlyBracketKeyword_1_2_3()); 
            match(input,14,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2150:1: rule__ParenExpression__Group_0__0 : rule__ParenExpression__Group_0__0__Impl rule__ParenExpression__Group_0__1 ;
    public final void rule__ParenExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2154:1: ( rule__ParenExpression__Group_0__0__Impl rule__ParenExpression__Group_0__1 )
            // InternalParametricTimedRegularExpression.g:2155:2: rule__ParenExpression__Group_0__0__Impl rule__ParenExpression__Group_0__1
            {
            pushFollow(FOLLOW_15);
            rule__ParenExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2162:1: rule__ParenExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__ParenExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2166:1: ( ( '(' ) )
            // InternalParametricTimedRegularExpression.g:2167:1: ( '(' )
            {
            // InternalParametricTimedRegularExpression.g:2167:1: ( '(' )
            // InternalParametricTimedRegularExpression.g:2168:2: '('
            {
             before(grammarAccess.getParenExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2177:1: rule__ParenExpression__Group_0__1 : rule__ParenExpression__Group_0__1__Impl rule__ParenExpression__Group_0__2 ;
    public final void rule__ParenExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2181:1: ( rule__ParenExpression__Group_0__1__Impl rule__ParenExpression__Group_0__2 )
            // InternalParametricTimedRegularExpression.g:2182:2: rule__ParenExpression__Group_0__1__Impl rule__ParenExpression__Group_0__2
            {
            pushFollow(FOLLOW_26);
            rule__ParenExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2189:1: rule__ParenExpression__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__ParenExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2193:1: ( ( ruleExpression ) )
            // InternalParametricTimedRegularExpression.g:2194:1: ( ruleExpression )
            {
            // InternalParametricTimedRegularExpression.g:2194:1: ( ruleExpression )
            // InternalParametricTimedRegularExpression.g:2195:2: ruleExpression
            {
             before(grammarAccess.getParenExpressionAccess().getExpressionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2204:1: rule__ParenExpression__Group_0__2 : rule__ParenExpression__Group_0__2__Impl ;
    public final void rule__ParenExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2208:1: ( rule__ParenExpression__Group_0__2__Impl )
            // InternalParametricTimedRegularExpression.g:2209:2: rule__ParenExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2215:1: rule__ParenExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__ParenExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2219:1: ( ( ')' ) )
            // InternalParametricTimedRegularExpression.g:2220:1: ( ')' )
            {
            // InternalParametricTimedRegularExpression.g:2220:1: ( ')' )
            // InternalParametricTimedRegularExpression.g:2221:2: ')'
            {
             before(grammarAccess.getParenExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,25,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2231:1: rule__Any__Group__0 : rule__Any__Group__0__Impl rule__Any__Group__1 ;
    public final void rule__Any__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2235:1: ( rule__Any__Group__0__Impl rule__Any__Group__1 )
            // InternalParametricTimedRegularExpression.g:2236:2: rule__Any__Group__0__Impl rule__Any__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__Any__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2243:1: rule__Any__Group__0__Impl : ( () ) ;
    public final void rule__Any__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2247:1: ( ( () ) )
            // InternalParametricTimedRegularExpression.g:2248:1: ( () )
            {
            // InternalParametricTimedRegularExpression.g:2248:1: ( () )
            // InternalParametricTimedRegularExpression.g:2249:2: ()
            {
             before(grammarAccess.getAnyAccess().getAnyAction_0()); 
            // InternalParametricTimedRegularExpression.g:2250:2: ()
            // InternalParametricTimedRegularExpression.g:2250:3: 
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
    // InternalParametricTimedRegularExpression.g:2258:1: rule__Any__Group__1 : rule__Any__Group__1__Impl ;
    public final void rule__Any__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2262:1: ( rule__Any__Group__1__Impl )
            // InternalParametricTimedRegularExpression.g:2263:2: rule__Any__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2269:1: rule__Any__Group__1__Impl : ( 'S' ) ;
    public final void rule__Any__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2273:1: ( ( 'S' ) )
            // InternalParametricTimedRegularExpression.g:2274:1: ( 'S' )
            {
            // InternalParametricTimedRegularExpression.g:2274:1: ( 'S' )
            // InternalParametricTimedRegularExpression.g:2275:2: 'S'
            {
             before(grammarAccess.getAnyAccess().getSKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2285:1: rule__Inverse__Group__0 : rule__Inverse__Group__0__Impl rule__Inverse__Group__1 ;
    public final void rule__Inverse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2289:1: ( rule__Inverse__Group__0__Impl rule__Inverse__Group__1 )
            // InternalParametricTimedRegularExpression.g:2290:2: rule__Inverse__Group__0__Impl rule__Inverse__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__Inverse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2297:1: rule__Inverse__Group__0__Impl : ( '(' ) ;
    public final void rule__Inverse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2301:1: ( ( '(' ) )
            // InternalParametricTimedRegularExpression.g:2302:1: ( '(' )
            {
            // InternalParametricTimedRegularExpression.g:2302:1: ( '(' )
            // InternalParametricTimedRegularExpression.g:2303:2: '('
            {
             before(grammarAccess.getInverseAccess().getLeftParenthesisKeyword_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2312:1: rule__Inverse__Group__1 : rule__Inverse__Group__1__Impl rule__Inverse__Group__2 ;
    public final void rule__Inverse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2316:1: ( rule__Inverse__Group__1__Impl rule__Inverse__Group__2 )
            // InternalParametricTimedRegularExpression.g:2317:2: rule__Inverse__Group__1__Impl rule__Inverse__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__Inverse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2324:1: rule__Inverse__Group__1__Impl : ( 'S' ) ;
    public final void rule__Inverse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2328:1: ( ( 'S' ) )
            // InternalParametricTimedRegularExpression.g:2329:1: ( 'S' )
            {
            // InternalParametricTimedRegularExpression.g:2329:1: ( 'S' )
            // InternalParametricTimedRegularExpression.g:2330:2: 'S'
            {
             before(grammarAccess.getInverseAccess().getSKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2339:1: rule__Inverse__Group__2 : rule__Inverse__Group__2__Impl rule__Inverse__Group__3 ;
    public final void rule__Inverse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2343:1: ( rule__Inverse__Group__2__Impl rule__Inverse__Group__3 )
            // InternalParametricTimedRegularExpression.g:2344:2: rule__Inverse__Group__2__Impl rule__Inverse__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__Inverse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2351:1: rule__Inverse__Group__2__Impl : ( '\\\\' ) ;
    public final void rule__Inverse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2355:1: ( ( '\\\\' ) )
            // InternalParametricTimedRegularExpression.g:2356:1: ( '\\\\' )
            {
            // InternalParametricTimedRegularExpression.g:2356:1: ( '\\\\' )
            // InternalParametricTimedRegularExpression.g:2357:2: '\\\\'
            {
             before(grammarAccess.getInverseAccess().getReverseSolidusKeyword_2()); 
            match(input,27,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2366:1: rule__Inverse__Group__3 : rule__Inverse__Group__3__Impl rule__Inverse__Group__4 ;
    public final void rule__Inverse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2370:1: ( rule__Inverse__Group__3__Impl rule__Inverse__Group__4 )
            // InternalParametricTimedRegularExpression.g:2371:2: rule__Inverse__Group__3__Impl rule__Inverse__Group__4
            {
            pushFollow(FOLLOW_29);
            rule__Inverse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2378:1: rule__Inverse__Group__3__Impl : ( ( rule__Inverse__ExcludesAssignment_3 ) ) ;
    public final void rule__Inverse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2382:1: ( ( ( rule__Inverse__ExcludesAssignment_3 ) ) )
            // InternalParametricTimedRegularExpression.g:2383:1: ( ( rule__Inverse__ExcludesAssignment_3 ) )
            {
            // InternalParametricTimedRegularExpression.g:2383:1: ( ( rule__Inverse__ExcludesAssignment_3 ) )
            // InternalParametricTimedRegularExpression.g:2384:2: ( rule__Inverse__ExcludesAssignment_3 )
            {
             before(grammarAccess.getInverseAccess().getExcludesAssignment_3()); 
            // InternalParametricTimedRegularExpression.g:2385:2: ( rule__Inverse__ExcludesAssignment_3 )
            // InternalParametricTimedRegularExpression.g:2385:3: rule__Inverse__ExcludesAssignment_3
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2393:1: rule__Inverse__Group__4 : rule__Inverse__Group__4__Impl rule__Inverse__Group__5 ;
    public final void rule__Inverse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2397:1: ( rule__Inverse__Group__4__Impl rule__Inverse__Group__5 )
            // InternalParametricTimedRegularExpression.g:2398:2: rule__Inverse__Group__4__Impl rule__Inverse__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__Inverse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2405:1: rule__Inverse__Group__4__Impl : ( ( rule__Inverse__Group_4__0 )* ) ;
    public final void rule__Inverse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2409:1: ( ( ( rule__Inverse__Group_4__0 )* ) )
            // InternalParametricTimedRegularExpression.g:2410:1: ( ( rule__Inverse__Group_4__0 )* )
            {
            // InternalParametricTimedRegularExpression.g:2410:1: ( ( rule__Inverse__Group_4__0 )* )
            // InternalParametricTimedRegularExpression.g:2411:2: ( rule__Inverse__Group_4__0 )*
            {
             before(grammarAccess.getInverseAccess().getGroup_4()); 
            // InternalParametricTimedRegularExpression.g:2412:2: ( rule__Inverse__Group_4__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==15) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:2412:3: rule__Inverse__Group_4__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Inverse__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalParametricTimedRegularExpression.g:2420:1: rule__Inverse__Group__5 : rule__Inverse__Group__5__Impl ;
    public final void rule__Inverse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2424:1: ( rule__Inverse__Group__5__Impl )
            // InternalParametricTimedRegularExpression.g:2425:2: rule__Inverse__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2431:1: rule__Inverse__Group__5__Impl : ( ')' ) ;
    public final void rule__Inverse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2435:1: ( ( ')' ) )
            // InternalParametricTimedRegularExpression.g:2436:1: ( ')' )
            {
            // InternalParametricTimedRegularExpression.g:2436:1: ( ')' )
            // InternalParametricTimedRegularExpression.g:2437:2: ')'
            {
             before(grammarAccess.getInverseAccess().getRightParenthesisKeyword_5()); 
            match(input,25,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2447:1: rule__Inverse__Group_4__0 : rule__Inverse__Group_4__0__Impl rule__Inverse__Group_4__1 ;
    public final void rule__Inverse__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2451:1: ( rule__Inverse__Group_4__0__Impl rule__Inverse__Group_4__1 )
            // InternalParametricTimedRegularExpression.g:2452:2: rule__Inverse__Group_4__0__Impl rule__Inverse__Group_4__1
            {
            pushFollow(FOLLOW_15);
            rule__Inverse__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2459:1: rule__Inverse__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Inverse__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2463:1: ( ( ',' ) )
            // InternalParametricTimedRegularExpression.g:2464:1: ( ',' )
            {
            // InternalParametricTimedRegularExpression.g:2464:1: ( ',' )
            // InternalParametricTimedRegularExpression.g:2465:2: ','
            {
             before(grammarAccess.getInverseAccess().getCommaKeyword_4_0()); 
            match(input,15,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2474:1: rule__Inverse__Group_4__1 : rule__Inverse__Group_4__1__Impl ;
    public final void rule__Inverse__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2478:1: ( rule__Inverse__Group_4__1__Impl )
            // InternalParametricTimedRegularExpression.g:2479:2: rule__Inverse__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2485:1: rule__Inverse__Group_4__1__Impl : ( ( rule__Inverse__ExcludesAssignment_4_1 ) ) ;
    public final void rule__Inverse__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2489:1: ( ( ( rule__Inverse__ExcludesAssignment_4_1 ) ) )
            // InternalParametricTimedRegularExpression.g:2490:1: ( ( rule__Inverse__ExcludesAssignment_4_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:2490:1: ( ( rule__Inverse__ExcludesAssignment_4_1 ) )
            // InternalParametricTimedRegularExpression.g:2491:2: ( rule__Inverse__ExcludesAssignment_4_1 )
            {
             before(grammarAccess.getInverseAccess().getExcludesAssignment_4_1()); 
            // InternalParametricTimedRegularExpression.g:2492:2: ( rule__Inverse__ExcludesAssignment_4_1 )
            // InternalParametricTimedRegularExpression.g:2492:3: rule__Inverse__ExcludesAssignment_4_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2501:1: rule__TimedExpression__Group__0 : rule__TimedExpression__Group__0__Impl rule__TimedExpression__Group__1 ;
    public final void rule__TimedExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2505:1: ( rule__TimedExpression__Group__0__Impl rule__TimedExpression__Group__1 )
            // InternalParametricTimedRegularExpression.g:2506:2: rule__TimedExpression__Group__0__Impl rule__TimedExpression__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__TimedExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2513:1: rule__TimedExpression__Group__0__Impl : ( '<' ) ;
    public final void rule__TimedExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2517:1: ( ( '<' ) )
            // InternalParametricTimedRegularExpression.g:2518:1: ( '<' )
            {
            // InternalParametricTimedRegularExpression.g:2518:1: ( '<' )
            // InternalParametricTimedRegularExpression.g:2519:2: '<'
            {
             before(grammarAccess.getTimedExpressionAccess().getLessThanSignKeyword_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2528:1: rule__TimedExpression__Group__1 : rule__TimedExpression__Group__1__Impl rule__TimedExpression__Group__2 ;
    public final void rule__TimedExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2532:1: ( rule__TimedExpression__Group__1__Impl rule__TimedExpression__Group__2 )
            // InternalParametricTimedRegularExpression.g:2533:2: rule__TimedExpression__Group__1__Impl rule__TimedExpression__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__TimedExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2540:1: rule__TimedExpression__Group__1__Impl : ( ( rule__TimedExpression__BodyAssignment_1 ) ) ;
    public final void rule__TimedExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2544:1: ( ( ( rule__TimedExpression__BodyAssignment_1 ) ) )
            // InternalParametricTimedRegularExpression.g:2545:1: ( ( rule__TimedExpression__BodyAssignment_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:2545:1: ( ( rule__TimedExpression__BodyAssignment_1 ) )
            // InternalParametricTimedRegularExpression.g:2546:2: ( rule__TimedExpression__BodyAssignment_1 )
            {
             before(grammarAccess.getTimedExpressionAccess().getBodyAssignment_1()); 
            // InternalParametricTimedRegularExpression.g:2547:2: ( rule__TimedExpression__BodyAssignment_1 )
            // InternalParametricTimedRegularExpression.g:2547:3: rule__TimedExpression__BodyAssignment_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2555:1: rule__TimedExpression__Group__2 : rule__TimedExpression__Group__2__Impl rule__TimedExpression__Group__3 ;
    public final void rule__TimedExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2559:1: ( rule__TimedExpression__Group__2__Impl rule__TimedExpression__Group__3 )
            // InternalParametricTimedRegularExpression.g:2560:2: rule__TimedExpression__Group__2__Impl rule__TimedExpression__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__TimedExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2567:1: rule__TimedExpression__Group__2__Impl : ( '>' ) ;
    public final void rule__TimedExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2571:1: ( ( '>' ) )
            // InternalParametricTimedRegularExpression.g:2572:1: ( '>' )
            {
            // InternalParametricTimedRegularExpression.g:2572:1: ( '>' )
            // InternalParametricTimedRegularExpression.g:2573:2: '>'
            {
             before(grammarAccess.getTimedExpressionAccess().getGreaterThanSignKeyword_2()); 
            match(input,29,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2582:1: rule__TimedExpression__Group__3 : rule__TimedExpression__Group__3__Impl rule__TimedExpression__Group__4 ;
    public final void rule__TimedExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2586:1: ( rule__TimedExpression__Group__3__Impl rule__TimedExpression__Group__4 )
            // InternalParametricTimedRegularExpression.g:2587:2: rule__TimedExpression__Group__3__Impl rule__TimedExpression__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__TimedExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2594:1: rule__TimedExpression__Group__3__Impl : ( '[' ) ;
    public final void rule__TimedExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2598:1: ( ( '[' ) )
            // InternalParametricTimedRegularExpression.g:2599:1: ( '[' )
            {
            // InternalParametricTimedRegularExpression.g:2599:1: ( '[' )
            // InternalParametricTimedRegularExpression.g:2600:2: '['
            {
             before(grammarAccess.getTimedExpressionAccess().getLeftSquareBracketKeyword_3()); 
            match(input,18,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2609:1: rule__TimedExpression__Group__4 : rule__TimedExpression__Group__4__Impl rule__TimedExpression__Group__5 ;
    public final void rule__TimedExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2613:1: ( rule__TimedExpression__Group__4__Impl rule__TimedExpression__Group__5 )
            // InternalParametricTimedRegularExpression.g:2614:2: rule__TimedExpression__Group__4__Impl rule__TimedExpression__Group__5
            {
            pushFollow(FOLLOW_32);
            rule__TimedExpression__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2621:1: rule__TimedExpression__Group__4__Impl : ( ( rule__TimedExpression__TimeoutAssignment_4 ) ) ;
    public final void rule__TimedExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2625:1: ( ( ( rule__TimedExpression__TimeoutAssignment_4 ) ) )
            // InternalParametricTimedRegularExpression.g:2626:1: ( ( rule__TimedExpression__TimeoutAssignment_4 ) )
            {
            // InternalParametricTimedRegularExpression.g:2626:1: ( ( rule__TimedExpression__TimeoutAssignment_4 ) )
            // InternalParametricTimedRegularExpression.g:2627:2: ( rule__TimedExpression__TimeoutAssignment_4 )
            {
             before(grammarAccess.getTimedExpressionAccess().getTimeoutAssignment_4()); 
            // InternalParametricTimedRegularExpression.g:2628:2: ( rule__TimedExpression__TimeoutAssignment_4 )
            // InternalParametricTimedRegularExpression.g:2628:3: rule__TimedExpression__TimeoutAssignment_4
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2636:1: rule__TimedExpression__Group__5 : rule__TimedExpression__Group__5__Impl ;
    public final void rule__TimedExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2640:1: ( rule__TimedExpression__Group__5__Impl )
            // InternalParametricTimedRegularExpression.g:2641:2: rule__TimedExpression__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2647:1: rule__TimedExpression__Group__5__Impl : ( ']' ) ;
    public final void rule__TimedExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2651:1: ( ( ']' ) )
            // InternalParametricTimedRegularExpression.g:2652:1: ( ']' )
            {
            // InternalParametricTimedRegularExpression.g:2652:1: ( ']' )
            // InternalParametricTimedRegularExpression.g:2653:2: ']'
            {
             before(grammarAccess.getTimedExpressionAccess().getRightSquareBracketKeyword_5()); 
            match(input,19,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2663:1: rule__Event__Group__0 : rule__Event__Group__0__Impl rule__Event__Group__1 ;
    public final void rule__Event__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2667:1: ( rule__Event__Group__0__Impl rule__Event__Group__1 )
            // InternalParametricTimedRegularExpression.g:2668:2: rule__Event__Group__0__Impl rule__Event__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__Event__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2675:1: rule__Event__Group__0__Impl : ( ( rule__Event__FunctorAssignment_0 ) ) ;
    public final void rule__Event__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2679:1: ( ( ( rule__Event__FunctorAssignment_0 ) ) )
            // InternalParametricTimedRegularExpression.g:2680:1: ( ( rule__Event__FunctorAssignment_0 ) )
            {
            // InternalParametricTimedRegularExpression.g:2680:1: ( ( rule__Event__FunctorAssignment_0 ) )
            // InternalParametricTimedRegularExpression.g:2681:2: ( rule__Event__FunctorAssignment_0 )
            {
             before(grammarAccess.getEventAccess().getFunctorAssignment_0()); 
            // InternalParametricTimedRegularExpression.g:2682:2: ( rule__Event__FunctorAssignment_0 )
            // InternalParametricTimedRegularExpression.g:2682:3: rule__Event__FunctorAssignment_0
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2690:1: rule__Event__Group__1 : rule__Event__Group__1__Impl ;
    public final void rule__Event__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2694:1: ( rule__Event__Group__1__Impl )
            // InternalParametricTimedRegularExpression.g:2695:2: rule__Event__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2701:1: rule__Event__Group__1__Impl : ( ( rule__Event__Group_1__0 )? ) ;
    public final void rule__Event__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2705:1: ( ( ( rule__Event__Group_1__0 )? ) )
            // InternalParametricTimedRegularExpression.g:2706:1: ( ( rule__Event__Group_1__0 )? )
            {
            // InternalParametricTimedRegularExpression.g:2706:1: ( ( rule__Event__Group_1__0 )? )
            // InternalParametricTimedRegularExpression.g:2707:2: ( rule__Event__Group_1__0 )?
            {
             before(grammarAccess.getEventAccess().getGroup_1()); 
            // InternalParametricTimedRegularExpression.g:2708:2: ( rule__Event__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==18) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalParametricTimedRegularExpression.g:2708:3: rule__Event__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2717:1: rule__Event__Group_1__0 : rule__Event__Group_1__0__Impl rule__Event__Group_1__1 ;
    public final void rule__Event__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2721:1: ( rule__Event__Group_1__0__Impl rule__Event__Group_1__1 )
            // InternalParametricTimedRegularExpression.g:2722:2: rule__Event__Group_1__0__Impl rule__Event__Group_1__1
            {
            pushFollow(FOLLOW_33);
            rule__Event__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2729:1: rule__Event__Group_1__0__Impl : ( '[' ) ;
    public final void rule__Event__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2733:1: ( ( '[' ) )
            // InternalParametricTimedRegularExpression.g:2734:1: ( '[' )
            {
            // InternalParametricTimedRegularExpression.g:2734:1: ( '[' )
            // InternalParametricTimedRegularExpression.g:2735:2: '['
            {
             before(grammarAccess.getEventAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,18,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2744:1: rule__Event__Group_1__1 : rule__Event__Group_1__1__Impl rule__Event__Group_1__2 ;
    public final void rule__Event__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2748:1: ( rule__Event__Group_1__1__Impl rule__Event__Group_1__2 )
            // InternalParametricTimedRegularExpression.g:2749:2: rule__Event__Group_1__1__Impl rule__Event__Group_1__2
            {
            pushFollow(FOLLOW_16);
            rule__Event__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2756:1: rule__Event__Group_1__1__Impl : ( ( rule__Event__ParametersAssignment_1_1 ) ) ;
    public final void rule__Event__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2760:1: ( ( ( rule__Event__ParametersAssignment_1_1 ) ) )
            // InternalParametricTimedRegularExpression.g:2761:1: ( ( rule__Event__ParametersAssignment_1_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:2761:1: ( ( rule__Event__ParametersAssignment_1_1 ) )
            // InternalParametricTimedRegularExpression.g:2762:2: ( rule__Event__ParametersAssignment_1_1 )
            {
             before(grammarAccess.getEventAccess().getParametersAssignment_1_1()); 
            // InternalParametricTimedRegularExpression.g:2763:2: ( rule__Event__ParametersAssignment_1_1 )
            // InternalParametricTimedRegularExpression.g:2763:3: rule__Event__ParametersAssignment_1_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2771:1: rule__Event__Group_1__2 : rule__Event__Group_1__2__Impl rule__Event__Group_1__3 ;
    public final void rule__Event__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2775:1: ( rule__Event__Group_1__2__Impl rule__Event__Group_1__3 )
            // InternalParametricTimedRegularExpression.g:2776:2: rule__Event__Group_1__2__Impl rule__Event__Group_1__3
            {
            pushFollow(FOLLOW_16);
            rule__Event__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2783:1: rule__Event__Group_1__2__Impl : ( ( rule__Event__Group_1_2__0 )* ) ;
    public final void rule__Event__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2787:1: ( ( ( rule__Event__Group_1_2__0 )* ) )
            // InternalParametricTimedRegularExpression.g:2788:1: ( ( rule__Event__Group_1_2__0 )* )
            {
            // InternalParametricTimedRegularExpression.g:2788:1: ( ( rule__Event__Group_1_2__0 )* )
            // InternalParametricTimedRegularExpression.g:2789:2: ( rule__Event__Group_1_2__0 )*
            {
             before(grammarAccess.getEventAccess().getGroup_1_2()); 
            // InternalParametricTimedRegularExpression.g:2790:2: ( rule__Event__Group_1_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==15) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalParametricTimedRegularExpression.g:2790:3: rule__Event__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Event__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalParametricTimedRegularExpression.g:2798:1: rule__Event__Group_1__3 : rule__Event__Group_1__3__Impl ;
    public final void rule__Event__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2802:1: ( rule__Event__Group_1__3__Impl )
            // InternalParametricTimedRegularExpression.g:2803:2: rule__Event__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2809:1: rule__Event__Group_1__3__Impl : ( ']' ) ;
    public final void rule__Event__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2813:1: ( ( ']' ) )
            // InternalParametricTimedRegularExpression.g:2814:1: ( ']' )
            {
            // InternalParametricTimedRegularExpression.g:2814:1: ( ']' )
            // InternalParametricTimedRegularExpression.g:2815:2: ']'
            {
             before(grammarAccess.getEventAccess().getRightSquareBracketKeyword_1_3()); 
            match(input,19,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2825:1: rule__Event__Group_1_2__0 : rule__Event__Group_1_2__0__Impl rule__Event__Group_1_2__1 ;
    public final void rule__Event__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2829:1: ( rule__Event__Group_1_2__0__Impl rule__Event__Group_1_2__1 )
            // InternalParametricTimedRegularExpression.g:2830:2: rule__Event__Group_1_2__0__Impl rule__Event__Group_1_2__1
            {
            pushFollow(FOLLOW_33);
            rule__Event__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2837:1: rule__Event__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__Event__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2841:1: ( ( ',' ) )
            // InternalParametricTimedRegularExpression.g:2842:1: ( ',' )
            {
            // InternalParametricTimedRegularExpression.g:2842:1: ( ',' )
            // InternalParametricTimedRegularExpression.g:2843:2: ','
            {
             before(grammarAccess.getEventAccess().getCommaKeyword_1_2_0()); 
            match(input,15,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2852:1: rule__Event__Group_1_2__1 : rule__Event__Group_1_2__1__Impl ;
    public final void rule__Event__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2856:1: ( rule__Event__Group_1_2__1__Impl )
            // InternalParametricTimedRegularExpression.g:2857:2: rule__Event__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2863:1: rule__Event__Group_1_2__1__Impl : ( ( rule__Event__ParametersAssignment_1_2_1 ) ) ;
    public final void rule__Event__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2867:1: ( ( ( rule__Event__ParametersAssignment_1_2_1 ) ) )
            // InternalParametricTimedRegularExpression.g:2868:1: ( ( rule__Event__ParametersAssignment_1_2_1 ) )
            {
            // InternalParametricTimedRegularExpression.g:2868:1: ( ( rule__Event__ParametersAssignment_1_2_1 ) )
            // InternalParametricTimedRegularExpression.g:2869:2: ( rule__Event__ParametersAssignment_1_2_1 )
            {
             before(grammarAccess.getEventAccess().getParametersAssignment_1_2_1()); 
            // InternalParametricTimedRegularExpression.g:2870:2: ( rule__Event__ParametersAssignment_1_2_1 )
            // InternalParametricTimedRegularExpression.g:2870:3: rule__Event__ParametersAssignment_1_2_1
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2879:1: rule__SingletonParameter__Group__0 : rule__SingletonParameter__Group__0__Impl rule__SingletonParameter__Group__1 ;
    public final void rule__SingletonParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2883:1: ( rule__SingletonParameter__Group__0__Impl rule__SingletonParameter__Group__1 )
            // InternalParametricTimedRegularExpression.g:2884:2: rule__SingletonParameter__Group__0__Impl rule__SingletonParameter__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__SingletonParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2891:1: rule__SingletonParameter__Group__0__Impl : ( () ) ;
    public final void rule__SingletonParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2895:1: ( ( () ) )
            // InternalParametricTimedRegularExpression.g:2896:1: ( () )
            {
            // InternalParametricTimedRegularExpression.g:2896:1: ( () )
            // InternalParametricTimedRegularExpression.g:2897:2: ()
            {
             before(grammarAccess.getSingletonParameterAccess().getSingletonParameterAction_0()); 
            // InternalParametricTimedRegularExpression.g:2898:2: ()
            // InternalParametricTimedRegularExpression.g:2898:3: 
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
    // InternalParametricTimedRegularExpression.g:2906:1: rule__SingletonParameter__Group__1 : rule__SingletonParameter__Group__1__Impl ;
    public final void rule__SingletonParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2910:1: ( rule__SingletonParameter__Group__1__Impl )
            // InternalParametricTimedRegularExpression.g:2911:2: rule__SingletonParameter__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2917:1: rule__SingletonParameter__Group__1__Impl : ( '_' ) ;
    public final void rule__SingletonParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2921:1: ( ( '_' ) )
            // InternalParametricTimedRegularExpression.g:2922:1: ( '_' )
            {
            // InternalParametricTimedRegularExpression.g:2922:1: ( '_' )
            // InternalParametricTimedRegularExpression.g:2923:2: '_'
            {
             before(grammarAccess.getSingletonParameterAccess().get_Keyword_1()); 
            match(input,30,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:2933:1: rule__RegexModel__AlphabetAssignment_0 : ( ruleAlphabet ) ;
    public final void rule__RegexModel__AlphabetAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2937:1: ( ( ruleAlphabet ) )
            // InternalParametricTimedRegularExpression.g:2938:2: ( ruleAlphabet )
            {
            // InternalParametricTimedRegularExpression.g:2938:2: ( ruleAlphabet )
            // InternalParametricTimedRegularExpression.g:2939:3: ruleAlphabet
            {
             before(grammarAccess.getRegexModelAccess().getAlphabetAlphabetParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2948:1: rule__RegexModel__DeclarationsAssignment_1 : ( ruleExpressionDeclaration ) ;
    public final void rule__RegexModel__DeclarationsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2952:1: ( ( ruleExpressionDeclaration ) )
            // InternalParametricTimedRegularExpression.g:2953:2: ( ruleExpressionDeclaration )
            {
            // InternalParametricTimedRegularExpression.g:2953:2: ( ruleExpressionDeclaration )
            // InternalParametricTimedRegularExpression.g:2954:3: ruleExpressionDeclaration
            {
             before(grammarAccess.getRegexModelAccess().getDeclarationsExpressionDeclarationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2963:1: rule__Alphabet__FunctorsAssignment_4_0 : ( ruleFunctor ) ;
    public final void rule__Alphabet__FunctorsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2967:1: ( ( ruleFunctor ) )
            // InternalParametricTimedRegularExpression.g:2968:2: ( ruleFunctor )
            {
            // InternalParametricTimedRegularExpression.g:2968:2: ( ruleFunctor )
            // InternalParametricTimedRegularExpression.g:2969:3: ruleFunctor
            {
             before(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2978:1: rule__Alphabet__FunctorsAssignment_4_1_1 : ( ruleFunctor ) ;
    public final void rule__Alphabet__FunctorsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2982:1: ( ( ruleFunctor ) )
            // InternalParametricTimedRegularExpression.g:2983:2: ( ruleFunctor )
            {
            // InternalParametricTimedRegularExpression.g:2983:2: ( ruleFunctor )
            // InternalParametricTimedRegularExpression.g:2984:3: ruleFunctor
            {
             before(grammarAccess.getAlphabetAccess().getFunctorsFunctorParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:2993:1: rule__Functor__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Functor__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:2997:1: ( ( RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:2998:2: ( RULE_ID )
            {
            // InternalParametricTimedRegularExpression.g:2998:2: ( RULE_ID )
            // InternalParametricTimedRegularExpression.g:2999:3: RULE_ID
            {
             before(grammarAccess.getFunctorAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:3008:1: rule__Functor__ArityAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__Functor__ArityAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3012:1: ( ( RULE_INT ) )
            // InternalParametricTimedRegularExpression.g:3013:2: ( RULE_INT )
            {
            // InternalParametricTimedRegularExpression.g:3013:2: ( RULE_INT )
            // InternalParametricTimedRegularExpression.g:3014:3: RULE_INT
            {
             before(grammarAccess.getFunctorAccess().getArityINTTerminalRuleCall_1_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:3023:1: rule__ExpressionDeclaration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ExpressionDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3027:1: ( ( RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:3028:2: ( RULE_ID )
            {
            // InternalParametricTimedRegularExpression.g:3028:2: ( RULE_ID )
            // InternalParametricTimedRegularExpression.g:3029:3: RULE_ID
            {
             before(grammarAccess.getExpressionDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:3038:1: rule__ExpressionDeclaration__VarsAssignment_2_1 : ( ruleVar ) ;
    public final void rule__ExpressionDeclaration__VarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3042:1: ( ( ruleVar ) )
            // InternalParametricTimedRegularExpression.g:3043:2: ( ruleVar )
            {
            // InternalParametricTimedRegularExpression.g:3043:2: ( ruleVar )
            // InternalParametricTimedRegularExpression.g:3044:3: ruleVar
            {
             before(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:3053:1: rule__ExpressionDeclaration__VarsAssignment_2_2_1 : ( ruleVar ) ;
    public final void rule__ExpressionDeclaration__VarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3057:1: ( ( ruleVar ) )
            // InternalParametricTimedRegularExpression.g:3058:2: ( ruleVar )
            {
            // InternalParametricTimedRegularExpression.g:3058:2: ( ruleVar )
            // InternalParametricTimedRegularExpression.g:3059:3: ruleVar
            {
             before(grammarAccess.getExpressionDeclarationAccess().getVarsVarParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:3068:1: rule__ExpressionDeclaration__BodyAssignment_4 : ( ruleExpression ) ;
    public final void rule__ExpressionDeclaration__BodyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3072:1: ( ( ruleExpression ) )
            // InternalParametricTimedRegularExpression.g:3073:2: ( ruleExpression )
            {
            // InternalParametricTimedRegularExpression.g:3073:2: ( ruleExpression )
            // InternalParametricTimedRegularExpression.g:3074:3: ruleExpression
            {
             before(grammarAccess.getExpressionDeclarationAccess().getBodyExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "rule__And__ElementsAssignment_1_1_1"
    // InternalParametricTimedRegularExpression.g:3083:1: rule__And__ElementsAssignment_1_1_1 : ( ruleChoice ) ;
    public final void rule__And__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3087:1: ( ( ruleChoice ) )
            // InternalParametricTimedRegularExpression.g:3088:2: ( ruleChoice )
            {
            // InternalParametricTimedRegularExpression.g:3088:2: ( ruleChoice )
            // InternalParametricTimedRegularExpression.g:3089:3: ruleChoice
            {
             before(grammarAccess.getAndAccess().getElementsChoiceParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleChoice();

            state._fsp--;

             after(grammarAccess.getAndAccess().getElementsChoiceParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end "rule__And__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__Choice__ElementsAssignment_1_1_1"
    // InternalParametricTimedRegularExpression.g:3098:1: rule__Choice__ElementsAssignment_1_1_1 : ( ruleSequence ) ;
    public final void rule__Choice__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3102:1: ( ( ruleSequence ) )
            // InternalParametricTimedRegularExpression.g:3103:2: ( ruleSequence )
            {
            // InternalParametricTimedRegularExpression.g:3103:2: ( ruleSequence )
            // InternalParametricTimedRegularExpression.g:3104:3: ruleSequence
            {
             before(grammarAccess.getChoiceAccess().getElementsSequenceParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:3113:1: rule__Sequence__ElementsAssignment_1_1 : ( ruleMultExpression ) ;
    public final void rule__Sequence__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3117:1: ( ( ruleMultExpression ) )
            // InternalParametricTimedRegularExpression.g:3118:2: ( ruleMultExpression )
            {
            // InternalParametricTimedRegularExpression.g:3118:2: ( ruleMultExpression )
            // InternalParametricTimedRegularExpression.g:3119:3: ruleMultExpression
            {
             before(grammarAccess.getSequenceAccess().getElementsMultExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:3128:1: rule__MultExpression__NAssignment_1_2_2 : ( RULE_INT ) ;
    public final void rule__MultExpression__NAssignment_1_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3132:1: ( ( RULE_INT ) )
            // InternalParametricTimedRegularExpression.g:3133:2: ( RULE_INT )
            {
            // InternalParametricTimedRegularExpression.g:3133:2: ( RULE_INT )
            // InternalParametricTimedRegularExpression.g:3134:3: RULE_INT
            {
             before(grammarAccess.getMultExpressionAccess().getNINTTerminalRuleCall_1_2_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:3143:1: rule__Inverse__ExcludesAssignment_3 : ( ruleEvent ) ;
    public final void rule__Inverse__ExcludesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3147:1: ( ( ruleEvent ) )
            // InternalParametricTimedRegularExpression.g:3148:2: ( ruleEvent )
            {
            // InternalParametricTimedRegularExpression.g:3148:2: ( ruleEvent )
            // InternalParametricTimedRegularExpression.g:3149:3: ruleEvent
            {
             before(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:3158:1: rule__Inverse__ExcludesAssignment_4_1 : ( ruleEvent ) ;
    public final void rule__Inverse__ExcludesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3162:1: ( ( ruleEvent ) )
            // InternalParametricTimedRegularExpression.g:3163:2: ( ruleEvent )
            {
            // InternalParametricTimedRegularExpression.g:3163:2: ( ruleEvent )
            // InternalParametricTimedRegularExpression.g:3164:3: ruleEvent
            {
             before(grammarAccess.getInverseAccess().getExcludesEventParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:3173:1: rule__TimedExpression__BodyAssignment_1 : ( ruleExpression ) ;
    public final void rule__TimedExpression__BodyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3177:1: ( ( ruleExpression ) )
            // InternalParametricTimedRegularExpression.g:3178:2: ( ruleExpression )
            {
            // InternalParametricTimedRegularExpression.g:3178:2: ( ruleExpression )
            // InternalParametricTimedRegularExpression.g:3179:3: ruleExpression
            {
             before(grammarAccess.getTimedExpressionAccess().getBodyExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:3188:1: rule__TimedExpression__TimeoutAssignment_4 : ( RULE_INT ) ;
    public final void rule__TimedExpression__TimeoutAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3192:1: ( ( RULE_INT ) )
            // InternalParametricTimedRegularExpression.g:3193:2: ( RULE_INT )
            {
            // InternalParametricTimedRegularExpression.g:3193:2: ( RULE_INT )
            // InternalParametricTimedRegularExpression.g:3194:3: RULE_INT
            {
             before(grammarAccess.getTimedExpressionAccess().getTimeoutINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:3203:1: rule__Event__FunctorAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Event__FunctorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3207:1: ( ( ( RULE_ID ) ) )
            // InternalParametricTimedRegularExpression.g:3208:2: ( ( RULE_ID ) )
            {
            // InternalParametricTimedRegularExpression.g:3208:2: ( ( RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:3209:3: ( RULE_ID )
            {
             before(grammarAccess.getEventAccess().getFunctorFunctorCrossReference_0_0()); 
            // InternalParametricTimedRegularExpression.g:3210:3: ( RULE_ID )
            // InternalParametricTimedRegularExpression.g:3211:4: RULE_ID
            {
             before(grammarAccess.getEventAccess().getFunctorFunctorIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:3222:1: rule__Event__ParametersAssignment_1_1 : ( ruleParameter ) ;
    public final void rule__Event__ParametersAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3226:1: ( ( ruleParameter ) )
            // InternalParametricTimedRegularExpression.g:3227:2: ( ruleParameter )
            {
            // InternalParametricTimedRegularExpression.g:3227:2: ( ruleParameter )
            // InternalParametricTimedRegularExpression.g:3228:3: ruleParameter
            {
             before(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:3237:1: rule__Event__ParametersAssignment_1_2_1 : ( ruleParameter ) ;
    public final void rule__Event__ParametersAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3241:1: ( ( ruleParameter ) )
            // InternalParametricTimedRegularExpression.g:3242:2: ( ruleParameter )
            {
            // InternalParametricTimedRegularExpression.g:3242:2: ( ruleParameter )
            // InternalParametricTimedRegularExpression.g:3243:3: ruleParameter
            {
             before(grammarAccess.getEventAccess().getParametersParameterParserRuleCall_1_2_1_0()); 
            pushFollow(FOLLOW_2);
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
    // InternalParametricTimedRegularExpression.g:3252:1: rule__FixIntParameter__BodyAssignment : ( RULE_INT ) ;
    public final void rule__FixIntParameter__BodyAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3256:1: ( ( RULE_INT ) )
            // InternalParametricTimedRegularExpression.g:3257:2: ( RULE_INT )
            {
            // InternalParametricTimedRegularExpression.g:3257:2: ( RULE_INT )
            // InternalParametricTimedRegularExpression.g:3258:3: RULE_INT
            {
             before(grammarAccess.getFixIntParameterAccess().getBodyINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:3267:1: rule__FixStringParameter__BodyAssignment : ( RULE_STRING ) ;
    public final void rule__FixStringParameter__BodyAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3271:1: ( ( RULE_STRING ) )
            // InternalParametricTimedRegularExpression.g:3272:2: ( RULE_STRING )
            {
            // InternalParametricTimedRegularExpression.g:3272:2: ( RULE_STRING )
            // InternalParametricTimedRegularExpression.g:3273:3: RULE_STRING
            {
             before(grammarAccess.getFixStringParameterAccess().getBodySTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:3282:1: rule__VarParameter__VarAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VarParameter__VarAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3286:1: ( ( ( RULE_ID ) ) )
            // InternalParametricTimedRegularExpression.g:3287:2: ( ( RULE_ID ) )
            {
            // InternalParametricTimedRegularExpression.g:3287:2: ( ( RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:3288:3: ( RULE_ID )
            {
             before(grammarAccess.getVarParameterAccess().getVarVarCrossReference_0()); 
            // InternalParametricTimedRegularExpression.g:3289:3: ( RULE_ID )
            // InternalParametricTimedRegularExpression.g:3290:4: RULE_ID
            {
             before(grammarAccess.getVarParameterAccess().getVarVarIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // InternalParametricTimedRegularExpression.g:3301:1: rule__Var__NameAssignment : ( RULE_ID ) ;
    public final void rule__Var__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalParametricTimedRegularExpression.g:3305:1: ( ( RULE_ID ) )
            // InternalParametricTimedRegularExpression.g:3306:2: ( RULE_ID )
            {
            // InternalParametricTimedRegularExpression.g:3306:2: ( RULE_ID )
            // InternalParametricTimedRegularExpression.g:3307:3: RULE_ID
            {
             before(grammarAccess.getVarAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000015000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000015000012L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000C02000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000002008000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000040000070L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000040000000L});

}