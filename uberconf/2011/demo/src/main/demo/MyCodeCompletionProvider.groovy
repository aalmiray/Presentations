package demo

import org.fife.ui.autocomplete.*

class MyCodeCompletionProvider extends DefaultCompletionProvider {
    MyCodeCompletionProvider() {
        keyword(this, 'abstract')
        keyword(this, 'assert')
        keyword(this, 'as')
        keyword(this, 'break')
        keyword(this, 'case')
        keyword(this, 'catch')
        keyword(this, 'class')
        keyword(this, 'const')
        keyword(this, 'continue')
        keyword(this, 'default')
        keyword(this, 'do')
        keyword(this, 'else')
        keyword(this, 'enum')
        keyword(this, 'extends')
        keyword(this, 'final')
        keyword(this, 'finally')
        keyword(this, 'for')
        keyword(this, 'goto')
        keyword(this, 'if')
        keyword(this, 'implements')
        keyword(this, 'import')
        keyword(this, 'in')
        keyword(this, 'instanceof')
        keyword(this, 'interface')
        keyword(this, 'native')
        keyword(this, 'new')
        keyword(this, 'package')
        keyword(this, 'private')
        keyword(this, 'protected')
        keyword(this, 'public')
        keyword(this, 'return')
        keyword(this, 'static')
        keyword(this, 'strictfp')
        keyword(this, 'super')
        keyword(this, 'switch')
        keyword(this, 'synchronized')
        keyword(this, 'this')
        keyword(this, 'throw')
        keyword(this, 'throws')
        keyword(this, 'transient')
        keyword(this, 'try')
        keyword(this, 'void')
        keyword(this, 'volatile')
        keyword(this, 'while')
    }

    private static void keyword(CompletionProvider provider, String text) {
        provider.addCompletion(new KeywordCompletion(provider, text))
    }

    static class KeywordCompletion extends BasicCompletion {
        KeywordCompletion(CompletionProvider provider, String text) {
            super(provider, text)
        }

        String getReplacementText() {
            super.getReplacementText() + ' '
        }

        String getInputText() {
            getReplacementText()[0..-2]
        }
    }
}
