package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.RegistrationComponent
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
// Definition of a Dagger component that adds info from the StorageModule to the graph
@Component(modules = [StorageModule::class, AppSubcomponents::class])
//@Component(modules = [StorageModule::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Expose RegistrationComponent factory from the graph
    fun registrationComponent(): RegistrationComponent.Factory

    // Classes that can be injected by this Component
//    fun inject(activity: RegistrationActivity)
//    fun inject(fragment: EnterDetailsFragment)
//    fun inject(fragment: TermsAndConditionsFragment)
    fun inject(activity: MainActivity)
}
