

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {

	public static void main(String args[]) {
		// Create an image to save
		
		ImageWriterExample imgWriter = new ImageWriterExample();
		RenderedImage rendImage = imgWriter.myCreateImage(600, 200);

		// Write generated image to a file
		try {
			// Save as PNG
			File file = new File("newimage.png");
			ImageIO.write(rendImage, "png", file);

			// Save as JPEG
			file = new File("newimage.jpg");
			ImageIO.write(rendImage, "jpg", file);
		} catch (IOException e) {
			System.out.println("error cannot save: " + e.getMessage());
		}
	}

	// Returns a generated image.
	public RenderedImage myCreateImage(int width, int height) {

		// Create a buffered image in which to draw
		BufferedImage bufferedImage = 
			new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// Create a graphics contents on the buffered image
		Graphics2D g2d = bufferedImage.createGraphics();

		// Draw graphics
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.black);
		
		int w = 5;
		for (int i = 0; i < width; i += w) {
			int h = (int)(Math.random() * (height -10) );
			g2d.fillRect(i, 0, w, h);
		}
		
		// Graphics context no longer needed so dispose it
		g2d.dispose();

		return bufferedImage;
	}
}
