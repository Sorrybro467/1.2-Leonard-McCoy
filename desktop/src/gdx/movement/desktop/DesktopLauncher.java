package gdx.movement.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import gdx.movement.GdxMovement;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                //config.height = 800;
                //config.width = 1200;
		new LwjglApplication(new GdxMovement(), config);
	}
}
