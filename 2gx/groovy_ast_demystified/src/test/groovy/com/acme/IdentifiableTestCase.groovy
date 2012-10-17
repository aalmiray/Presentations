package com.acme

class IdentifiableTestCase extends GroovyTestCase {
    @Identifiable
    private class IdentifiableBean { }

    void testIdentifiableTransformation() {
        def bean = new IdentifiableBean()
        assert !bean.id
        bean.id = 1L
        assert bean.id == 1L
    }
}
