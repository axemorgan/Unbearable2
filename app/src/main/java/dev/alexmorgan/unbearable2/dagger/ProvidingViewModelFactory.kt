package dev.alexmorgan.unbearable2.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.MapKey
import java.lang.IllegalStateException
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class ProvidingViewModelFactory @Inject constructor(
    private val providers: Map<@JvmSuppressWildcards Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val provider = providers[modelClass]
            ?: throw IllegalStateException("ViewModel $modelClass is not bound in the dependencies graph")
        @Suppress("UNCHECKED_CAST")
        return provider.get() as T
    }
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
