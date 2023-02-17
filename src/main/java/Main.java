import Engine.Object2D;
import Engine.ShaderProgram;
import Engine.Window;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window(800,800, "Hello World");
    ArrayList<Object2D> objects = new ArrayList<Object2D>();
    public void run(){
        init();
        loop();
        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }
    public void init(){
        window.init();
        GL.createCapabilities();
        // code dst jangan ditaruh diatas code diatas
        //
        objects.add(new Object2D(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(0.0f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f)
                                )
                        )
                )
        );
    }
    public void loop(){
        while (window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            for (Object2D object2d : objects)
            {
                object2d.draw();
            }
            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
