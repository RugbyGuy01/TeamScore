//plugins {
//    id("com.android.application")
//    id("org.jetbrains.kotlin.android")
//    id("dagger.hilt.android.plugin")    //vpg 12/17/23
//    id("com.google.devtools.ksp")
//    id("kotlin-kapt")
//}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
    // id("kotlin-kapt")
}

android {
    namespace = "com.golfpvcc.todo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.golfpvcc.todo"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17    //vpg 12/17/23
        targetCompatibility = JavaVersion.VERSION_17    //vpg 12/17/23
    }
    kotlinOptions {
        jvmTarget = "17"    //vpg 12/17/23
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
//    def composeBom = platform ('androidx.compose:compose-bom:2023.06.00')
//    def kotlinBom = platform ('org.jetbrains.kotlin:kotlin-bom:1.8.0')
    implementation ("org.jetbrains.kotlin:kotlin-bom:1.9.0")
    implementation ("androidx.compose:compose-bom:2023.10.01")
    androidTestImplementation ("androidx.compose:compose-bom:2023.10.01")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //accompanist
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.31.5-beta")

    // extended Icons
    implementation ("androidx.compose.material:material-icons-extended")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose")

    // Dagger - Hilt

    implementation ("com.google.dagger:hilt-android:2.48")
    ksp ("com.google.dagger:dagger-compiler:2.48") // Dagger compiler
    ksp ("com.google.dagger:hilt-compiler:2.48")   // Hilt compiler
 //   ksp "com.google.dagger:hilt-compiler:2.44"
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    // VPG added from git
    // Compose dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation("androidx.compose.material:material-icons-extended:1.5.4")
    // room issues VPG

    implementation("com.google.code.gson:gson:2.10")
    // Room
   // def room_version = "2.6.1"
    implementation ("androidx.room:room-runtime:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")
    ksp ("androidx.room:room-compiler:2.6.1")
    testImplementation ("androidx.room:room-testing:2.6.1")
    androidTestImplementation ("androidx.room:room-testing:2.6.1")
//
    // Room
    //   def room_version = "2.5.0"
//    implementation("androidx.room:room-ktx:2.6.1")
//    ksp("androidx.room:room-compiler:2.6.1")

    // Kotlin extensions and Room coroutine support
    //implementation("androidx.room:room-ktx:2.5.2")


}