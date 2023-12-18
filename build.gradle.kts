// Top-level build file where you can add configuration options common to all sub-projects/modules.
// vpg 12/17/23 added buildscript
buildscript {
    dependencies{
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
    }
}

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false           //vpg 12/17/23
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.21-1.0.16" apply false    // 12/17/23
}