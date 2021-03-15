package ru.tatarchuk.personaldictionary.presentation.viewmodel

import androidx.lifecycle.ViewModel
import ru.tatarchuk.personaldictionary.domain.usecase.singleword.SingleWordInteractor

/**
 * @author tatarchukilya@gmail.com
 */
class SingleWordViewModel(private val interactor: SingleWordInteractor) : ViewModel() {

}