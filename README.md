# Gradle Global Plugin

[![Build Status](https://travis-ci.org/Scalified/gradle-global-plugin.svg)](https://travis-ci.org/Scalified/gradle-global-plugin)

## Description

[Gradle Global Plugin](https://plugins.gradle.org/plugin/com.scalified.plugins.gradle.global) provides the global configuration

## Requirements

* [Gradle 6+](https://gradle.org/)

## Changelog

[Changelog](CHANGELOG.md)

## Applying

Using the plugins DSL (Kotlin):

```kotlin
plugins {
  id("com.scalified.plugins.gradle.global") version "$version"
}
```

Using legacy plugin application (Kotlin):

```kotlin
buildscript {
  repositories {
    maven {
      url = uri("https://plugins.gradle.org/m2/")
    }
  }
  dependencies {
    classpath("gradle.plugin.com.scalified.plugins.gradle:global:$version")
  }
}

apply(plugin = "com.scalified.plugins.gradle.global")
```

## Usage

After applying the plugin, the following takes place:

1. A new configuration named **global** added. It is configured with **canBeResolved** and **canBeConsumed** flags set to **false**
2. All configurations, which have **canBeResolved** flag set to **true** are configured to extend from **global** configuration

## License

```
MIT License

Copyright (c) 2020 Scalified

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Scalified Links

* [Scalified](http://www.scalified.com)
* [Scalified Official Facebook Page](https://www.facebook.com/scalified)
* <a href="mailto:info@scalified.com?subject=[Gradle Global Plugin]: Proposals And Suggestions">Scalified Support</a>
