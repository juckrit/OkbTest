package com.example.ookbeetest.presentation.di

import com.example.ookbeetest.BuildConfig
import com.example.ookbeetest.DI_NAME_AUTHORIZATION_KEY
import com.example.ookbeetest.DI_NAME_BOOKREPOSITORY
import com.example.ookbeetest.DI_NAME_INSERTBOOKUSECASE
import com.example.ookbeetest.data.api.OokBeeService
import com.example.ookbeetest.data.repository.BookRepositoryImpl
import com.example.ookbeetest.data.repository.datasourceImpl.BookRemoteDataSourceImpl
import com.example.ookbeetest.domain.repository.BookRepository
import com.example.ookbeetest.domain.usecase.InsertBookUseCase
import com.example.ookbeetest.presentation.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appMoule = module {

    single<String>(named(DI_NAME_AUTHORIZATION_KEY)) {
        "putKeyHere"
    }

    single {
        Retrofit.Builder().baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    single {
        get<Retrofit>().create(OokBeeService::class.java)
    }

    single {
        BookRemoteDataSourceImpl(get(),get(named(DI_NAME_AUTHORIZATION_KEY)))
    }

    single<BookRepository>(named(DI_NAME_BOOKREPOSITORY)) {
        BookRepositoryImpl(get()) as BookRepository
    }

    single(named(DI_NAME_INSERTBOOKUSECASE)) {
        InsertBookUseCase(get(named(DI_NAME_BOOKREPOSITORY)) as BookRepository)
    }

    viewModel {
        MainViewModel(get(named(DI_NAME_INSERTBOOKUSECASE)))
    }


}