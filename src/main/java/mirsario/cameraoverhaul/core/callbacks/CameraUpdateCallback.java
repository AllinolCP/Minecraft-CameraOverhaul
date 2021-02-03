package mirsario.cameraoverhaul.core.callbacks;

import mirsario.cameraoverhaul.core.events.Event;
import mirsario.cameraoverhaul.core.events.EventHelper;
import mirsario.cameraoverhaul.core.structures.Transform;
import net.minecraft.client.renderer.ActiveRenderInfo;

public interface CameraUpdateCallback {
    Event<CameraUpdateCallback> EVENT = EventHelper.CreateEvent(CameraUpdateCallback.class,
            (listeners) -> (camera, transform, deltaTime) -> {
                for (CameraUpdateCallback listener : listeners) {
                    listener.OnCameraUpdate(camera, transform, deltaTime);
                }
            }
    );

    void OnCameraUpdate(ActiveRenderInfo camera, Transform cameraTransform, float deltaTime);
}