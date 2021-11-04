OVERVIEW
--------

The image gallery application consists of these main components:
   - main layout: main application layout that contains a menu, gallery display and button layout
   - gallery display: display component that contains image canvases for viewing images (visual representation of the image gallery)
   - button layout: layout that contains buttons for manipulating images
   - event handler/controller: component that handles user actions (button clicks, scrolling through images, etc.)
   - image gallery: collection class which stores the images in an array

The figure below visually demonstrates the application components:
   
   ![app_info](https://user-images.githubusercontent.com/84116849/127747463-b1464088-26c5-42b3-80e1-5ad80478b363.png)
   
<br/>
<h2>ADVANCED SETUP</h2>
To build the project yourself:
<ol>
  <li>Download and install OpenJDK 16.0.1 and JavaFX 11 on your computer<br/>
    <ul>
      <li>(OpenJDK): https://openjdk.java.net/</li>
      <li>(OpenJFX): https://openjfx.io/index.html</li>
    </ul>
  </li>
  <li>Download the project(.zip archive) or clone the repository locally on your machine using Git</li>
  <li>Import the project into a Java-supported developer tool or IDE of your choice(Eclipse, IntelliJ, Netbeans, etc.)</li>
  <li>Configure the project's build settings to link necessary JavaFX libraries needed to run the application:<br/><br/>
    (<i>Example using Eclipse</i>):<br/>
    <ul>
      <li>Right-click your project in the Package Explorer on the left. On the dropdown menu select Build Path-->Configure Build Path</li>
      <li>On the left highlight Java Build Path and select the Libraries tab</li>
      <li>Highlight Classpath and click Add External Jars</li>
      <li>Add the following three .jar files by navigating to your JavaFX SDK folder and opening its 'lib' sub-folder:<br/>
        javafx.base.jar, javafx.controls.jar, javafx.graphics.jar</li>
      <li>Click Apply-->Apply & Close</li>
    </ul>
    <br/><br/>
	  (<i>Example using IntelliJ</i>):<br/>
	  <ul>
		  <li>From the menu, go to File-->Project Structure. On the left, click the Libraries tab.</li>
		  <li>Highlight and click the plus sign to add a New Project Library and choose Java.</li>
		  <li>On the Select Library Files window, select the path of your JavaFX SDK folder and select its 'lib' sub-folder.</li>
		  <li>Click OK and then apply changes.</li>
	  </ul>
	  <br/><br/>
  </li>
  <li>Finally, use the command-line and enter the following VM arguments. This can be done using your IDE's run configuration options:	   
				   
		  --module-path "[YOUR PATH TO JFX FOLDER]\javafx-sdk-11.0.2\lib" --add-modules javafx.controls
  </li>
  </ol>

   
