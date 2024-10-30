# Gradle Global Plugin

[![Build Status](https://github.com/Scalified/gradle-global-plugin/actions/workflows/build.yml/badge.svg)](https://github.com/Scalified/gradle-global-plugin/actions)
[![Gradle Plugin Portal](https://img.shields.io/maven-metadata/v?label=Plugin&metadataUrl=https%3A%2F%2Fplugins.gradle.org%2Fm2%2Fcom%2Fscalified%2Fplugins%2Fgradle%2Fglobal%2Fcom.scalified.plugins.gradle.global.gradle.plugin%2Fmaven-metadata.xml)](https://plugins.gradle.org/plugin/com.scalified.plugins.gradle.global)

## Description

[Gradle Global Plugin](https://plugins.gradle.org/plugin/com.scalified.plugins.gradle.global) provides the global configuration,
which handles the problem of importing BOM / platform dependencies for all configurations. 
See [**issue 7576**](https://github.com/gradle/gradle/issues/7576)

Applying this plugin is literally the same as adding the following configuration:

```kotlin
configurations {
    global {
       canBeResolved = false
       canBeConsumed = false
    }
}
configurations.all { configuration ->
    if (configuration.canBeResolved) {
       configuration.extendsFrom(configurations.globalPlatforms)
    }
}
```

## Requirements

* [Gradle 8+](https://gradle.org/)

## Usage

```kotlin
import com.scalified.plugins.gradle.global.GlobalPlugin

plugins {
    id("com.scalified.plugins.gradle.global") version "$version"
}

subprojects {
    apply<GlobalPlugin>()
    
    dependencies {
        global(platform("<platform coordinates>"))
    }
}
```

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
