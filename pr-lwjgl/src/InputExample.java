import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class InputExample {

	int dx=0,dy=0;
	int iz=0,der=0,arr=0,aba=0;
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		// init OpenGL here
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		while (!Display.isCloseRequested()) {
			// render OpenGL here
			pollInput();
			// Clear the screen and depth buffer
		    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
		    // set the color of the quad (R,G,B,A)
		    GL11.glColor3f(0.5f,0.5f,1.0f);
		    // draw quad
		    GL11.glBegin(GL11.GL_QUADS);
		    GL11.glVertex2f(100+dx,100+dy);
			GL11.glVertex2f(100+200+dx,100+dy);
			GL11.glVertex2f(100+200+dx,100+200+dy);
			GL11.glVertex2f(100+dx,100+200+dy);
		    GL11.glEnd();
			Display.update();
		}

		Display.destroy();
	}

	public void pollInput() {

		if (Mouse.isButtonDown(0)) {
			int x = Mouse.getX();
			int y = Mouse.getY();

			System.out.println("MOUSE DOWN @ X: " + x + " Y: " + y);
		}

		/*if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			System.out.println("SPACE KEY IS DOWN");
		}*/

		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
					System.out.println("left Key Pressed");
					dx--;
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
					System.out.println("right Key Pressed");
					dx++;
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
					System.out.println("up Key Pressed");
					dy++;
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
					System.out.println("down Key Pressed");
					dy--;
				}
				if(Keyboard.getEventKey()==Keyboard.KEY_SPACE){
					System.out.println("space key pressed");
					dx=0;
					dy=0;
				}
			} else {
				if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
					System.out.println("left Key released");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
					System.out.println("right Key released");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
					System.out.println("up Key released");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
					System.out.println("down Key released");
				}
				if(Keyboard.getEventKey()==Keyboard.KEY_SPACE){
					System.out.println("space key released");
				}
			}
		}
	}

	public static void main(String[] argv) {
		InputExample inputExample = new InputExample();
		inputExample.start();
	}
}