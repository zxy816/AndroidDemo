package com.zxy.plugin

object Version {
    const val kotlin = "1.5.0"
    const val multidex = "1.0.3"
    const val appcompat = "1.2.0"
    const val constraintLayout = "2.0.4"
    const val fragment = "1.2.5"
    const val material = "1.2.0"
    const val startupRuntime = "1.0.0-alpha03"
    const val hilt = "2.28-alpha"
    const val retrofit = "2.9.0"
    const val lifecycle = "2.3.0"
    const val navigation = "2.2.0"
    const val room = "2.3.0-alpha01"
    const val paging = "3.0.0-beta01"
    const val glide = "4.11.0"
    const val coroutinesAndroid = "1.4.3"
    const val coroutinesCore = "1.3.9"
}

object Androidx {
    const val multidex = "com.android.support:multidex:${Version.multidex}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val fragment = "androidx.fragment:fragment:${Version.fragment}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragment}"
    const val startupRuntime = "androidx.startup:startup-runtime:${Version.startupRuntime}"
}

object Kt {
    const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
}

object Material {
    const val material = "com.google.android.material:material:${Version.material}"
}

object Navigation {
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
}

object Coroutines {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutinesCore}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesAndroid}"
}

object Hilt {
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0-alpha02"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    const val retrofitRxjava = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofit}"
    const val okHttpIntercept = "com.squareup.okhttp3:logging-interceptor:3.9.0"
    const val retrofitCoroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
}

object LifeCycle {
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val lifecycleLivaData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycle}"
}

object Room {
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val roomRxjava = "androidx.room:room-rxjava2:${Version.room}"
    const val roomGuava = "androidx.room:room-guava:${Version.room}"
    const val roomTesting = "androidx.room:room-testing:${Version.room}"
}

object Paging {
    const val pagingRuntime = "androidx.paging:paging-runtime:${Version.paging}"
    const val pagingCommon = "androidx.paging:paging-common:${Version.paging}"
    const val pagingRxjava = "androidx.paging:paging-rxjava2:${Version.paging}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"
}

object Test {
    const val junit = "junit:junit:4.13"
    const val testJunit = "androidx.test.ext:junit:1.1.2"
    const val testCore = "androidx.test.espresso:espresso-core:3.2.0"
}