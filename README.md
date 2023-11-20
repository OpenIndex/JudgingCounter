# Judging Counter

This a simple and distraction free mobile app for judges in fighting events. It allows to easily keep track of points / strikes.

---

<p align="center">
<img src="share/screenshots/android/02.png" width="300" />
</p>


## Installation

| Android | Android (F-Droid) | iOS |
|:-:|:-:|:-:|
| [<img src="share/resources/google-play-badge.png" height="50">](https://play.google.com/store/apps/details?id=de.openindex.judging.counter) | *not available yet* | [<img src="share/resources/appstore-badge.png" height="50">](https://apps.apple.com/us/app/judging-counter/id6472386291) |


## Development

This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
