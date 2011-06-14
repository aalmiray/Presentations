def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide7')
m.editable = true
m.code = '''class Person { String name }

@Immutable
class ImmutablePerson { String name }

person1 = new Person(name: 'Duke')
person2 = new Person(name: 'Duke')
assert person1 != person2

person1 = new ImmutablePerson('Duke')
person2 = new ImmutablePerson(name: 'Duke')
assert person1 == person2

shouldFail(ReadOnlyPropertyException) {
    person1.name = 'boom!' 
}









def shouldFail(Class clazz, Closure code) {
    Throwable th = null;
    try {
        code.call();
    } catch (GroovyRuntimeException gre) {
        th = org.codehaus.groovy.runtime.ScriptBytecodeAdapter.unwrap(gre);
    } catch (Throwable e) {
        th = e;
    }
    
    if (th == null) {
        throw new junit.framework.AssertionFailedError("Closure " + code + " should have failed with an exception of type " + clazz.getName());
    } else if (!clazz.isInstance(th)) {
        throw new junit.framework.AssertionFailedError("Closure " + code + " should have failed with an exception of type " + clazz.getName() + ", instead got Exception " + th);
    }
    return th.getMessage(); 
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Immutable')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
