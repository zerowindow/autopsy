/*
 * Autopsy Forensic Browser
 *
 * Copyright 2014 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
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
package org.sleuthkit.autopsy.imageanalyzer.actions;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import org.controlsfx.control.action.Action;
import org.sleuthkit.autopsy.imageanalyzer.ImageAnalyzerController;

/**
 *
 */
//TODO: This and the corresponding timeline action are identical except for the type of the controller...  abstract something! -jm
public class Back extends Action {

    private static final Image BACK_IMAGE = new Image("/org/sleuthkit/autopsy/imageanalyzer/images/arrow-180.png", 16, 16, true, true, true);

    private final ImageAnalyzerController controller;

    public Back(ImageAnalyzerController controller) {
        super("Back");
        setGraphic(new ImageView(BACK_IMAGE));
        setAccelerator(new KeyCodeCombination(KeyCode.LEFT, KeyCodeCombination.ALT_DOWN));
        this.controller = controller;
        disabledProperty().bind(controller.getCanRetreat().not());
        setEventHandler((ActionEvent ae) -> {
            controller.retreat();
        });
    }

}
