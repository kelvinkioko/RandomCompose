package com.graph.randomcompose.hilt.di

import com.graph.randomcompose.hilt.network.AppNetworkAdapter
import com.graph.randomcompose.hilt.network.NetworkAdapter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindNetworkAdapterImpl(appNetworkAdapterImpl: AppNetworkAdapter): NetworkAdapter
}