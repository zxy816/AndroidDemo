package com.zxy.plugin

object Version {
    const val kotlin = "1.5.21"
    const val multidex = "2.0.1"
    const val appcompat = "1.3.0"
    const val constraintLayout = "2.1.0"
    const val fragment = "1.3.6"
    const val material = "1.2.0"
    const val startupRuntime = "1.1.0"
    const val hilt = "2.38.1"
    const val retrofit = "2.9.0"
    const val lifecycle = "2.3.0"
    const val navigation = "2.2.0"
    const val room = "2.3.0"
    const val paging = "3.0.0"
    const val glide = "4.11.0"
    const val coroutinesAndroid = "1.4.3"
    const val coroutinesCore = "1.3.9"
    const val compose = "1.0.1"
    const val rxlifecycle4 = "4.0.0"
}

object Androidx {
    const val multidex = "com.android.support:multidex:${Version.multidex}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val fragment = "androidx.fragment:fragment:${Version.fragment}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragment}"
    const val startupRuntime = "androidx.startup:startup-runtime:${Version.startupRuntime}"
    const val viewPager2 = "androidx.viewpager2:viewpager2:1.0.0"
}


object Material {
    const val material = "com.google.android.material:material:${Version.material}"
}

object Compose {
    const val compose = "androidx.compose.ui:ui:${Version.compose}"
    const val composeActivity = "androidx.activity:activity-compose:1.3.1"
    const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
    const val composeUI = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
}

object Navigation {
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
}

object Coroutines {
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesAndroid}"
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
    const val retrofitCoroutine =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
}

object LifeCycle {
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val lifecycleLivaData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycle}"
    const val rxlifecycle = "com.trello.rxlifecycle4:rxlifecycle:${Version.rxlifecycle4}"
    const val rxlifecycleComponent = "com.trello.rxlifecycle4:rxlifecycle-components:${Version.rxlifecycle4}"
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
    const val composeTest = "androidx.compose.ui:ui-test-junit4:${Version.compose}"
    const val debugCompose = "androidx.compose.ui:ui-tooling:${Version.compose}"
}