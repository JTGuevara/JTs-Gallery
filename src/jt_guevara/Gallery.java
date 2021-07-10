/* FILE: Gallery.java
 * DESCRIPTION: The Gallery class is the collection class of the image gallery application. A Gallery object represents an image gallery and is structured as an array deque with Image 
 * 				objects as the data type of the elements in the deque
 * 
 * FUNCTIONS:
 * 		public Gallery();	
 * 			RESULT: Creates an empty gallery with a minimum size of 16	
 * 									
 * 		public Gallery(int size);	
 * 			PARAMETERS: int size		- integer parameter for setting gallery size
 * 			PREREQUISITE: size > 0
 * 			RESULT:	A Gallery is initialized with the given size parameter	
 * 						
 * 		public ArrayDeque<Image> getImages();						
			RESULT: A collection of images(ArrayDeque<Image>) is returned
			
 * 		public void addImage(Image img);
 * 			PARAMETERS: Image img		- Image object used to add to the Gallery
 * 			PREREQUISITE: img contains a valid URL 
 * 			RESULT: img is added to the end of the deque 
 * 							
 * 		public int getSize();	
 * 			RESULT: The size of images is returned	
 * 								
 * 		public void clearGallery();									
			RESULT: The gallery is cleared of all images
 * 
 * (Note: To return the first or last image of a gallery, use the ArrayDeque methods getFirst(), getLast())(java.util.ArrayDeque)
 * 
 */

package jt_guevara;

import java.util.ArrayDeque;

import javafx.scene.image.Image;

public class Gallery {
	private ArrayDeque<Image> images;//data structure used to represent the image gallery
	public Gallery() {images = new ArrayDeque<Image>();}
	public Gallery(int size) {images = new ArrayDeque<Image>(size);}
	public ArrayDeque<Image> getImages() {return images;}
	public void addImage(Image img){images.addLast(img);}
	public int getSize() {return images.size();}
	public void clearGallery() {images.clear();}
}
