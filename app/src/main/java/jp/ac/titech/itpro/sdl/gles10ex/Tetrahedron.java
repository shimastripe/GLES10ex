package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by takagi_go on 2017/05/26.
 */

public class Tetrahedron implements SimpleRenderer.Obj {
    private FloatBuffer vbuf;
    private float x, y, z;

    public Tetrahedron(float s, float x, float y, float z) {
        float[] vertices = {
                // upleft
                -s, 0, -s,
                0, s, 0,
                -s, 0, s,
                // upright
                s, 0, -s,
                0, s, 0,
                s, 0, s,
                // upback
                -s, 0, -s,
                0, s, 0,
                s, 0, -s,
                // upfront
                -s, 0, s,
                0, s, 0,
                s, 0, s,
                // downleft
                -s, 0, -s,
                0, -s, 0,
                -s, 0, s,
                // downright
                s, 0, -s,
                0, -s, 0,
                s, 0, s,
                // downback
                -s, 0, -s,
                0, -s, 0,
                s, 0, -s,
                // downfront
                -s, 0, s,
                0, -s, 0,
                s, 0, s
        };
        vbuf = ByteBuffer.allocateDirect(vertices.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(vertices);
        vbuf.position(0);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // upleft
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // upright
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // upback
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // upfront
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // downleft
        gl.glNormal3f(-1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);

        // downright
        gl.glNormal3f(1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // downback
        gl.glNormal3f(0, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // downfront
        gl.glNormal3f(0, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }
}