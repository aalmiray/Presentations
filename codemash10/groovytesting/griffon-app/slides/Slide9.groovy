import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[center]5%","[center]"), title: "Groovy provides...") {
    textArea("Closures!, operator overloading, turbocharged POJOs, native syntax for Maps & Lists & Ranges, iterator methods, regexps as first-class citizens, metaprogramming capabilities, optional typing, dynamic types, everything is an object, and more!", editable: false, cssClass: "header", constraints: "growx", lineWrap: true, wrapStyleWord: true)
}
