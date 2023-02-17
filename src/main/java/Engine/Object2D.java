package Engine;

import org.joml.Vector3f;

import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class Object2D extends ShaderProgram {
    List<Vector3f> vertices;

    int vao, vbo;
    public Object2D(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices)
    {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
    }

    public void setupVAOVBO(){
        // set VAO
        vao= glGenVertexArrays();

        // set VBO
        vbo = glGenBuffers();

        glBindBuffer(GL_ARRAY_BUFFER, vbo);

        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void drawSetup(){
        bind();
        //Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3, GL_FLOAT, false, 0,0);
    }
    public void draw(){
        drawSetup();
        // Draw vertices
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }
}
