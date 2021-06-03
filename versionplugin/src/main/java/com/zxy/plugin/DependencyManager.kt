package com.zxy.plugin

object Version {
    val kotlin = "1.5.0"
    val multidex = "1.0.3"
    val appcompat = "1.2.0"
    val contraintLayout = "2.0.4"
    val fragment = "1.2.5"
    val material = "1.2.0"
    val startupRuntime = "1.0.0-alpha03"
    val hilt = "2.28-alpha"
    val retrofit = "2.9.0"
    val lifecycler = "2.3.0"
    val navigation = "2.2.0"
    val room = "2.3.0-alpha01"
    val paging = "3.0.0-beta01"
    val glide = "4.11.0"
    val coroutinesAndroid = "1.4.3"
    val coroutinesCore = "1.3.9"
}

object Androidx {
    val multidex = "com.android.support:multidex:${Version.multidex}"
    val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.contraintLayout}"
    val fragment = "androidx.fragment:fragment:${Version.fragment}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragment}"
    val startupRuntime = "androidx.startup:startup-runtime:${Version.startupRuntime}"
}

object Kt {
    val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
}

object Material {
    val material = "com.google.android.material:material:${Version.material}"
}

object Navigation {
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
}

object Coroutines {
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutinesCore}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesAndroid}"
}

object Hilt {
    val hiltAndroid = "com.google.dagger:hilt-android:${Version.hilt}"
    val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
    val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02"
    val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0-alpha02"
}

object Retrofit {
    val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    val retrofitGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    val retrofitRxjava = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofit}"
    val okHttpIntercept = "com.squareup.okhttp3:logging-interceptor:3.9.0"
    val retrofitCoroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
}

object LifeCycle {
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycler}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycler}"
    val lifecycleLivaData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycler}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycler}"
}

object Room {
    val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    val roomKtx = "androidx.room:room-ktx:${Version.room}"
    val roomRxjava = "androidx.room:room-rxjava2:${Version.room}"
    val roomGuava = "androidx.room:room-guava:${Version.room}"
    val roomTesting = "androidx.room:room-testing:${Version.room}"
}

object Paging {
    val pagingRuntime = "androidx.paging:paging-runtime:${Version.paging}"
    val pagingCommon = "androidx.paging:paging-common:${Version.paging}"
    val pagingRxjava = "androidx.paging:paging-rxjava2:${Version.paging}"
}

object Glide {
    val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"
}

object Test {
    val junit = "junit:junit:4.13"
    val testJunit = "androidx.test.ext:junit:1.1.2"
    val testCore = "androidx.test.espresso:espresso-core:3.2.0"
}