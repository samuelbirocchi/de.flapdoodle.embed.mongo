/**
 * Copyright (C) 2011
 *   Can Yaman <can@yaman.me>
 *   Michael Mosmann <michael@mosmann.de>
 *   Martin Jöhren <m.joehren@googlemail.com>
 *
 * with contributions from
 * 	konstantin-ba@github,Archimedes Trajano	(trajano@github)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.embed.mongo;

import de.flapdoodle.embed.mongo.config.IMongoDumpConfig;
import de.flapdoodle.embed.mongo.config.RuntimeConfigBuilder;
import de.flapdoodle.embed.process.config.IRuntimeConfig;
import de.flapdoodle.embed.process.distribution.Distribution;
import de.flapdoodle.embed.process.extract.IExtractedFileSet;
import de.flapdoodle.embed.process.runtime.Starter;

public class MongoDumpStarter extends Starter<IMongoDumpConfig,MongoDumpExecutable,MongoDumpProcess> {

    private MongoDumpStarter(IRuntimeConfig config) {
        super(config);
    }

    public static MongoDumpStarter getInstance(IRuntimeConfig config) {
        return new MongoDumpStarter(config);
    }

    public static MongoDumpStarter getDefaultInstance() {
        return getInstance(new RuntimeConfigBuilder().defaults(Command.MongoDump).build());
    }

    @Override
    protected MongoDumpExecutable newExecutable(IMongoDumpConfig mongoRestoreConfig, Distribution distribution, IRuntimeConfig runtime, IExtractedFileSet files) {
        return new MongoDumpExecutable(distribution, mongoRestoreConfig, runtime, files);
    }
}