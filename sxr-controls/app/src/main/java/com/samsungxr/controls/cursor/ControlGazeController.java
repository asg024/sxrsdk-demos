/* Copyright 2015 Samsung Electronics Co., LTD
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

package com.samsungxr.controls.cursor;

import com.samsungxr.SXRAndroidResource;
import com.samsungxr.SXRContext;
import com.samsungxr.SXRRenderData;
import com.samsungxr.SXRNode;
import com.samsungxr.controls.R;

public class ControlGazeController {

    private static SXRNode cursor;
    private static SXRNode highlightCursor;

    private static float CURSOR_HIGH_OPACITY = 1.0f;
    private static float CURSOR_LOW_OPACITY = 0.0f;

    private static float NORMAL_CURSOR_SIZE = 0.4f;
    private static float HIGHLIGHT_CURSOR_SIZE = 0.4f;
    private static float CURSOR_Z_POSITION = -9.0f;

    private static int CURSOR_RENDER_ORDER = 100000;

    public static void setupGazeCursor(SXRContext context) {

        cursor = new SXRNode(context,
                context.createQuad(NORMAL_CURSOR_SIZE, NORMAL_CURSOR_SIZE),
                context.getAssetLoader().loadTexture(new SXRAndroidResource(context,
                        R.drawable.cursor_idle)));
        cursor.getTransform().setPositionZ(CURSOR_Z_POSITION);
        cursor.getRenderData().setRenderingOrder(
                SXRRenderData.SXRRenderingOrder.OVERLAY);
        cursor.getRenderData().setDepthTest(false);
        cursor.getRenderData().setRenderingOrder(CURSOR_RENDER_ORDER);
        context.getMainScene().getMainCameraRig().addChildObject(cursor);

        highlightCursor = new SXRNode(context,
                context.createQuad(HIGHLIGHT_CURSOR_SIZE, HIGHLIGHT_CURSOR_SIZE),
                context.getAssetLoader().loadTexture(new SXRAndroidResource(context,
                        R.drawable.cursor_hover)));
        highlightCursor.getTransform().setPositionZ(CURSOR_Z_POSITION);
        highlightCursor.getRenderData().setRenderingOrder(
                SXRRenderData.SXRRenderingOrder.OVERLAY);
        highlightCursor.getRenderData().setDepthTest(false);
        highlightCursor.getRenderData().setRenderingOrder(CURSOR_RENDER_ORDER);
        context.getMainScene().getMainCameraRig().addChildObject(highlightCursor);

        highlightCursor.getRenderData().getMaterial().setOpacity(0f);

        cursor.getTransform().setScale(.35f, .35f, .35f);
        highlightCursor.getTransform().setScale(.35f, .35f, .3f);
    }

    public static void enableInteractiveCursor() {
        highlightCursor.getRenderData().getMaterial().setOpacity(CURSOR_HIGH_OPACITY);
        cursor.getRenderData().getMaterial().setOpacity(CURSOR_LOW_OPACITY);
    }

    public static void disableInteractiveCursor() {
        highlightCursor.getRenderData().getMaterial().setOpacity(CURSOR_LOW_OPACITY);
        cursor.getRenderData().getMaterial().setOpacity(CURSOR_HIGH_OPACITY);
    }
}