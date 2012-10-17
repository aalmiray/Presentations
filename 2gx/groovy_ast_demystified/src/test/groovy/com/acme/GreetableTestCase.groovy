package com.acme

class GreetableTestCase extends GroovyTestCase {
    @Greetable
    private class GreetableBean1 { }

    @Greetable(salutation = 'Howdy ')
    private class GreetableBean2 { }


    void testIdentifiableTransformation() {
        def bean = new GreetableBean1()
        assert bean.greet('World!') == 'Hello World!'
        bean = new GreetableBean2()
        assert bean.greet('stranger!') == 'Howdy stranger!'
    }
}
