package nl.tmg.dutchnews.view_model.main

import nl.tmg.dutchnews.view_model.BaseViewModel
import nl.tmg.dutchnews.view_model.IBaseViewModel
import javax.inject.Inject

interface IMainViewModelContract : IBaseViewModel

class MainViewModel @Inject constructor() : BaseViewModel(), IMainViewModelContract {
    val testProperty = "viewModelFactory was injected successfully"
}
