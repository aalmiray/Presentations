slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'What are AST Transformations?', constraints: 'wrap')
    vbox {
        bullet('Essentially byte code generation')
        bullet('They enable compile-tiem metaprogramming')
        bullet('There are two types: global and local')
        bullet('Local transformations require an specific context')
    }
}
