slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'And may more!', constraints: 'wrap')
    vbox {
        bullet('@AutoClone - @AutoExternalize')
        bullet('@ConditionalInterrupt - @TimedInterrupt')
        bullet('@ThreadInterrupt')
        bullet('@PackageScope')
        bullet('@WithReadLock - @WithWriteLock')
        bullet('@Field')
        bullet('@ListenerList')
    }
}
