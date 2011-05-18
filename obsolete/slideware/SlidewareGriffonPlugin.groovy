/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres.Almiray
 */
class SlidewareGriffonPlugin {
    def version = '0.3'
    def griffonVersion = '0.9 > *'
    def pluginIncludes = []
    def license = 'Apache Software License 2.0'
    def toolkits = ['swing']

    def dependsOn = ['transitions':    '0.3',
                     'css-builder':    '0.6',
                     'jide-builder':   '0.4',
                     'glazedlists':    '0.4',
                     'jbusycomponent': '0.4',
                     'lookandfeel':    '0.1']

    def author = 'Andres Almiray'
    def authorEmail = 'aalmiray@users.sourceforge.net'
    def title = 'Griffon based slideware'
    def description = '''
Griffon based slideware
'''

    def documentation = 'http://griffon.codehaus.org/Slideware+Plugin'
}
