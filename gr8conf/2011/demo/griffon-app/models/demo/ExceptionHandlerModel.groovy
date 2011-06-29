package demo

class ExceptionHandlerModel extends AbstractDialogModel {
    @Bindable String message
    protected String getDialogKey() { 'Error' }
    protected String getDialogTitle() { 'Error' }
}
