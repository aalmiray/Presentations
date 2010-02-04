import griffon.jme.app.SimpleGameGriffonApplication
import griffon.jme.app.SimpleGameDelegate

import com.jme.math.Quaternion
import com.jme.math.Vector3f
import com.jme.scene.shape.Box
import com.jme.image.Texture
import com.jme.scene.state.TextureState
import com.jme.util.TextureManager

class MySimpleGameDelegate extends SimpleGameDelegate {
    List cubes = []

    MySimpleGameDelegate(SimpleGameGriffonApplication app) {
        super(app)
    }

    void simpleInitGame() {
       cubes << [cube: makeCube('codemash-logo.png', new Vector3f(-5f, 0f, 0f)),
                 axis: new Vector3f(-5f, -1f, -1f), angle: 0f]
       cubes << [cube: makeCube('griffon-icon-256x256.png', new Vector3f(5f, 0f, 0f)),
                 axis: new Vector3f(5f, 1f, 1f), angle: 0f]
       cubes.each { rootNode.attachChild(it.cube) }
    }

    private makeCube(String texture, Vector3f anchor) {
        Box cube = new Box('cube', anchor, 3, 3, 3)

        // Load a texture
        ClassLoader cl = getClass().getClassLoader()
        URL url = cl.getResource(texture)
        Texture tex = TextureManager.loadTexture(url,
                          Texture.MinificationFilter.Trilinear,
                          Texture.MagnificationFilter.Bilinear)

        // Create a TextureState instance
        TextureState ts = display.renderer.createTextureState()

        // Assign the texture
        ts.texture = tex

        // Assign texture state to cube
        cube.renderState = ts

        return cube
   }

   void simpleUpdate() {
        cubes.each { c ->
            c.angle += 0.01f
            Quaternion q = new Quaternion()
            q.fromAngleAxis(c.angle as float, c.axis)
            c.cube.localRotation = q
        }
   }
}
