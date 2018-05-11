Allows you to specify a text view's shadowDx/shadowDy/shadowRadius parameters in dips. You can't do that with the default Android's `TextView`, which is quite inconvenient.

Usage
=====

```xml
<com.github.rongi.TextViewShadowDips
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/text"
    app:shadowColor="@android:color/darker_gray"
    app:shadowDx="2sp"
    app:shadowDy="2sp"
    app:shadowRadius="2sp"/>
```

Download
========

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```groovy
dependencies {
    implementation 'com.github.rongi:text-view-shadow-dips:v1.0'
}
```
