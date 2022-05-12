# JTs-Gallery
JT's Gallery is a personal project. This project is an image gallery application developed in Java and JavaFX.

<h2>DEMO</h2>

<table>
<td><img src="docs/demo.png" width=340></td>
<td><img src="docs/demo2.png" width=340></td>
<td><img src="docs/demo3.png" width=340></td>
</table>

<h2>REQUIREMENTS</h2>
<ol>
  <li><em>Java Development Kit (version 16 or higher)(OpenJDK)</em>
    (contains the Java platform (Java Runtime Environment) for running Java applications)</li>
  <li><em>JavaFX Development Kit (version 11.0.2) (OpenJFX)</em>
    (contains the JavaFX platform and libraries)</li>
  </ol>
  

<h2>RUNNING THE IMAGE GALLERY</h2>
<ol>
  <li>Download the project (.zip folder) or clone the repository locally on your machine. Also make sure to download both Java SDKs.</li>
  <li>Configure your computer to run Java applications.</li><br/>
  <i>(Example with Windows 10:)</i><br/>
  <ul>
    
  <li>Click on Start Menu-->Settings-->System-->About-->Advanced System Settings</li>
  <li>In the Advanced System Settings window, click on the Advanced tab and select Environment Variables.
  <li>Under user variables, highlight 'Path' and click Edit. Then, add a new directory with the location of your JDK.</li>
  </ul>
  <br/>
  <li>To run the application: open your system's command-line interface, navigate to the project's root directory (/JTs-Gallery/..), input the following 
    commands and press Enter:
  
    java -classpath ./bin --module-path "<YOUR PATH TO JAVAFX SDK>/lib" --add-modules javafx.controls jt_guevara.Main
  </li>
  </ol>
