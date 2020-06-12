package ch.giuliobosco.todoappandroid.ui.login

interface LoginView {
    fun showProgress()
    fun hideProgress()
    fun onSuccess()
    fun onError(code:Int, message:String)
}