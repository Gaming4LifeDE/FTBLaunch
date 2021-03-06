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
public class JVM {
    public JVM () {
    }

    public JVM (String txt, boolean use) {
        this.text = txt;
        this.useText = use;
    }
    public JVM(List<String> value, List<OSRule> rules, String text, boolean useText) {
        this.useText = useText;
        this.text = text;
        this.value = value;
        this.rules = rules;
    }


    private List<OSRule> rules;
    private List<String> value;
    private boolean useText = false;
    private String text;

    public boolean applies () {
        for (OSRule r : rules) {
            if (r.applies()) {
                return true;
            }
        }
        return false;
    }
}
