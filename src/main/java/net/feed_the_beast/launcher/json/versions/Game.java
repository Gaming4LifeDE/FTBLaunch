/*
 * This file is part of FTB Launcher.
 *
 * Copyright © 2012-2018, FTB Launcher Contributors <https://github.com/Slowpoke101/FTBLaunch/>
 * FTB Launcher is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.feed_the_beast.launcher.json.versions;

import lombok.Data;

import java.util.List;

@Data
public class Game {
    public Game () {
    }

    public Game (String txt, boolean use) {
        this.text = txt;
        this.useText = use;
    }
    public Game(List<String> value, List<GameRule> rules, String text, boolean useText) {
        this.useText = useText;
        this.text = text;
        this.value = value;
        this.rules = rules;
    }

    private boolean useText = false;
    private String text;
    private List<String> value;
    private List<GameRule> rules;

    public boolean applies () {
        for (GameRule g : rules) {
            if (g.applies()) {
                return true;
            }
        }
        return false;
    }
}
