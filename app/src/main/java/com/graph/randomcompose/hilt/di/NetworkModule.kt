package com.graph.randomcompose.hilt.di

import com.graph.randomcompose.hilt.network.AppNetworkAdapter
import com.graph.randomcompose.hilt.network.InterceptorImpl
import com.graph.randomcompose.hilt.network.NetworkAdapter
import com.graph.randomcompose.hilt.network.NetworkService
import com.graph.randomcompose.hilt.network.ResponseInterceptorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

//    @Binds
//    abstract fun bindNetworkAdapterImpl(appNetworkAdapterImpl: AppNetworkAdapter): NetworkAdapter

//    @Provides
//    fun provideNetworkService(): NetworkService {
//        return NetworkService.Builder()
//            .host(host = "Google.com")
//            .protocol(protocol = "HTTPS")
//            .build()
//    }

    @CallInterceptor
    @Provides
    fun provideCallNetworkService(): NetworkService {
        return NetworkService.Builder()
            .host(host = "Google.com")
            .protocol(protocol = "HTTPS")
            .interceptor(interceptor = InterceptorImpl())
            .build()
    }

    @ResponseInterceptor
    @Provides
    fun provideResponseNetworkService(): NetworkService {
        return NetworkService.Builder()
            .host(host = "Google.com")
            .protocol(protocol = "HTTPS")
            .interceptor(interceptor = ResponseInterceptorImpl())
            .build()
    }

}