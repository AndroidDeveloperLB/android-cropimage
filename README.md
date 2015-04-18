# Android CropImage

This library is a fork of another library with the same name (here: https://github.com/lvillani/android-cropimage ).

As opposed to the other library, it supports Android API 8 and above. That's the main difference. The rest is for cleaning some code.

Here's the original documentation:

--------------------------------------------------------------------------------

<img src="https://cdn.rawgit.com/lvillani/android-cropimage/f55253d2be3e6c28a06dd8bdd1e45aa7fd0b22a1/logo.svg" align="right" width="200" height="200"/>

[![License](http://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat)](http://choosealicense.com/licenses/apache-2.0/)
[![Paid Support](http://img.shields.io/badge/paid_support-available-brightgreen.svg?style=flat)](lorenzo@villani.me)

--------------------------------------------------------------------------------

The `CropImage` activity extracted from `Gallery.apk` (AOSP 4.4.4). Compatible
with Android API Level 15 and up.


## Android Studio and Gradle

The project was created with Android Studio and uses the Gradle build system.


## Intent-based API

The `CropImage` activity is controlled by an Intent-based API. Please use the wrapper class
[CropImageIntentBuilder](CropImage/src/main/java/com/android/camera/CropImageIntentBuilder.java)
for a type-safe interface.


## Example Project

It is contained inside the `CropImageExample` module.


## Gradle Repository

There's a [Gradle repository](http://lorenzo.villani.me/android-cropimage/) available at
<http://lorenzo.villani.me/android-cropimage/>.

In your top-level `build.gradle` add the address of the Maven repository to the `repositories`
section so that it looks like:

```groovy
repositories {
    mavenCentral()

    maven {
        url 'http://lorenzo.villani.me/android-cropimage/'
    }
}
```

Then add the dependency to your `dependencies` section:

```groovy
compile 'me.villani.lorenzo.android:android-cropimage:1.1.0'
```

For more information see the `CropImageRepo` example (the project doesn't do anything, it only shows
how to pull the dependency through Gradle).


## Paid Support

I offer part-time paid support to work on extra features and services (such as publishing on Maven
Central). Request a quote by shooting me an email to <lorenzo@villani.me>.
