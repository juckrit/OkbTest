package com.example.ookbeetest.presentation.di

import com.example.ookbeetest.*
import com.example.ookbeetest.data.api.OokBeeService
import com.example.ookbeetest.data.repository.auth.AuthRepositoryImpl
import com.example.ookbeetest.data.repository.auth.datasourceImpl.AuthDataSourceImpl
import com.example.ookbeetest.data.repository.book.BookRepositoryImpl
import com.example.ookbeetest.data.repository.book.datasourceImpl.BookRemoteDataSourceImpl
import com.example.ookbeetest.domain.repository.AuthRepository
import com.example.ookbeetest.domain.repository.BookRepository
import com.example.ookbeetest.domain.usecase.GetTokenUseCase
import com.example.ookbeetest.domain.usecase.InsertBookUseCase
import com.example.ookbeetest.domain.usecase.SaveTokenUseCase
import com.example.ookbeetest.presentation.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appMoule = module {

    single(named(DI_NAME_OokBeeService)) {
        OokBeeService.instance
    }

    single(named(DI_NAME_BookRemoteDataSourceImpl)) {
        BookRemoteDataSourceImpl(
            get(named(DI_NAME_OokBeeService))
        )

    }

    single<BookRepository>(named(DI_NAME_BookRepository)) {
        BookRepositoryImpl(get(named(DI_NAME_BookRemoteDataSourceImpl)))
    }

    single(named(DI_NAME_InsertBookUseCase)) {
        InsertBookUseCase(get(named(DI_NAME_BookRepository)))
    }

    single(named(DI_NAME_AuthDataSourceImpl)) {
        AuthDataSourceImpl(get()) //context as argument
    }

    single(named(DI_NAME_AuthRepository)) {
        AuthRepositoryImpl(get(named(DI_NAME_AuthDataSourceImpl))) as AuthRepository
    }

    single(named(DI_NAME_GetTokenUseCase)) {
        GetTokenUseCase(get(named(DI_NAME_AuthRepository)))
    }

    single(named(DI_NAME_SaveTokenUseCase)) {
        SaveTokenUseCase(get(named(DI_NAME_AuthRepository)))
    }

    viewModel {
        MainViewModel(
            get(named(DI_NAME_InsertBookUseCase)), get(named(DI_NAME_GetTokenUseCase)), get(
                named(
                    DI_NAME_SaveTokenUseCase
                )
            )
        )
    }


}