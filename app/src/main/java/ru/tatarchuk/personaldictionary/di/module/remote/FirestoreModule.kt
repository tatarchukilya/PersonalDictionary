package ru.tatarchuk.personaldictionary.di.module.remote

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import ru.tatarchuk.personaldictionary.data.remote.firestore.FireStoreApi
import ru.tatarchuk.personaldictionary.data.remote.firestore.FireStoreApiImpl
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author tatarchukilya@gmail.com
 */
@Module
object FirestoreModule {

    const val EN_RU = "En-Ru"

    @JvmStatic
    @Provides
    @Singleton
    @Named(EN_RU)
    fun provideDictionaryCollection(): CollectionReference =
        FirebaseFirestore.getInstance().collection(EN_RU)


    @JvmStatic
    @Provides
    @Singleton
    fun provideFirestoreApi(@Named(EN_RU) collection: CollectionReference): FireStoreApi =
        FireStoreApiImpl(collection)
}