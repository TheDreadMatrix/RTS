
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.returntosirandora.core.RTSApplication;

public class Main {

    public static void main(String[] args) {

        new Lwjgl3Application(new RTSApplication(), RTSApplication._giveConfiguration());
    }
}
