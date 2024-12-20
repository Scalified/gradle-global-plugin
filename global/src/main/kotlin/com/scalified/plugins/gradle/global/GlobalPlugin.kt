/*
 * MIT License
 *
 * Copyright (c) 2020 Scalified
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.scalified.plugins.gradle.global

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.slf4j.LoggerFactory

/**
 * @author shell
 * @since 2020-03-05
 */
open class GlobalPlugin : Plugin<Project> {

    private val logger = LoggerFactory.getLogger(GlobalPlugin::class.java)

    override fun apply(project: Project) {
        project.configurations.create(GLOBAL) globalConfiguration@{
            isCanBeResolved = false
            isCanBeConsumed = false
            logger.info("Created '$GLOBAL' configuration")

            project.configurations.all {
                if (isCanBeResolved) extendsFrom(this@globalConfiguration)
                logger.debug("Configured '$GLOBAL' configuration")
            }
        }
    }

}
