# JTs-Gallery
JT's Gallery is a personal project. This project is an image gallery application developed in Java and JavaFX.

<h2>DEMO</h2>

With JT's Gallery, you will be able to upload and re-upload images from your computer as well as scroll
through and zoom on them. The following screenshots demonstrate the application.

<table>
<td><img src="https://user-images.githubusercontent.com/84116849/128273531-2679db68-3984-4067-bb3c-afcae8982199.png" width=340></td>
<td><img src="https://user-images.githubusercontent.com/84116849/128273546-185a7093-7a92-49a4-80fa-796a67644e17.png" width=340></td>
<td><img src="https://user-images.githubusercontent.com/84116849/128273552-9939d931-16ac-46c4-881a-8911d3234692.png" width=340></td>
</table>

<h2>REQUIREMENTS</h2>
<ol>
  <li>Java Development Kit (version 16.0.1)(OpenJDK)</li>
  <li>JavaFX Development Kit (version 11.0.2)(OpenJFX)</li>
  </ol>
  
<h2>SETUP</h2>
To build the project:
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
  
<h2>USING THE IMAGE GALLERY</h2>
<ol>
  <li>Click the 'Load Gallery' menu item on the top-left corner of the application to upload and view images of your choice.</li>
  <li>Use the left-scroll and right-scroll buttons to cycle through images and the zoom button(the plus sign) to zoom in and out on the center image.</li>
  <li>Click 'Exit' to close the application.</li>
  </ol>
