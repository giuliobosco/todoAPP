package ch.giuliobosco.todoappandroid.ui.login

import android.annotation.SuppressLint
import ch.giuliobosco.todoappandroid.repository.Repository
import ch.giuliobosco.todoappandroid.util.ApiError
import ch.giuliobosco.todoappandroid.util.MySharedPreferences

class LoginInteractorImpl(private val presenter: LoginPresenter): LoginInteractor {
    @SuppressLint("CheckResult")
    override fun login(username: String, password: String) {
        Repository.login(username, password)
            .subscribe({ result ->
                presenter.onSuccess()
                MySharedPreferences.saveToken(result.token)
            }, { error ->
                val apiError = ApiError(error)
                presenter.onError(apiError.code, apiError.message)
            })
    }
}