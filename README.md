# LogAuditor
LogAuditor application to audit log i.e. it will Scan each line from the log file and checks if it's a starter or finisher log. 
It identifies the alert criteria & inserts into database and show the output on the console. 

# Requirements
Eclipse - Enterprise Java Developers Oxygen Release (4.12.0) <br>
Java    - 1.8 <br>
Gradle  - 5.6.2 <br>

# Pre-run steps
<b>Information before running the project</b>
1. Goto command prompt enter c:\users> <Path to service project>\LogAuditor <br>
2. press enter.<br>
3. gradle clean <br>
4. press enter. It Will clean the project. <br>
5. gradle customFatJar <br>
6. press enter. It Will genrate the custom Jar file which will have all dependencies which have been added in build.gradle.<br>

# Run instructions:
<b>There are couple of ways you can run this project.</b><br><br>
==========================<b> Run as main class from Eclipse </b>========================<br>
1. Open LogAuditor project in eclipse and refresh it using F5.<br>
2. Right click on Java file com.admin.process.logs.Application.java -> Run as -> Java Application. <br>
3. The console will ask for Enter the File location and press ENTER button : <Enter File Location> <br>
4. press enter. <br>
5. If the File format is provided as per requirement, it will Scan each line from the log file and checks if it's a starter or finisher log .<br>  
6. It identifies the alert criteria & inserts into database and show the output on the console.<br>

===========================================================================<br>


==========================<b> Run from executable jar </b>================================
1. Ensure that you have a .jar file in the folder  LogAuditor\build\libs\LogAuditor-all.jar <br>
2. Goto command prompt enter c:\users>java -jar <Path to service project>\LogAuditor\build\libs\LogAuditor-all.jar<br>
3. press enter<br>
4. The console will ask for Enter the File location and press ENTER button : <Enter File Location><br>
5. press enter.<br>
6. If the File format is provided as per requirement, it will Scan each line from the log file and checks if it's a starter or finisher log .  <br>
7. It identifies the alert criteria & inserts into database and show the output on the console.<br>

==========================================================================<br>

==========================<b> Run from command line </b>================================ 
1. Goto command prompt enter c:\users>java -jar <Path to service project>\LogAuditor<br>
2. press enter<br>
3. gradle run<br>
4. The command line will ask for Enter the File location and press ENTER button : <Enter File Location><br>
5. press enter.<br>
6. If the File format is provided as per requirement, it will Scan each line from the log file and checks if it's a starter or finisher log . <br> 
7. It identifies the alert criteria & inserts into database and show the output on the console.<br>

==========================================================================<br>


==========================<b> Running Junit Test cases </b>================================
1. In the eclipse, go to the java class LogAuditorTestAll.java<br>
2. right click and Run as -> JUnit Test<br>
3. Junit tests will also be run automatically when you try to generate an executable from the eclipse.<br>

===========================================================================

