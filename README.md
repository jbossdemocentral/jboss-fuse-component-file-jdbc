File & JDBC Bank DEMO
======================================================
This demo demonstrates the use of File and JDBC connector in Camel, also added the use if Spilt pattern and Exception handling method. 
The scenario of the demo is to mimic the transaction process between bank accounts, where it takes in XML file from different branch in a directory, each contains cash deposit, cash withdraw and transfer information of bank accounts, depending on the type of transaction, spilt up each transaction retrieve balance from a database, does the transaction and calculate the transaction fee and then place the balance back to the database storage. 



Setup and configuration
-----------------------

Download JBoss Fuse from jboss.org, and place the downloaded zip file under installs folder.

Add fabric server passwords for Maven Plugin to your ~/.m2/settings.xml file the fabric server's user and password so that the maven plugin can login to the fabric.

```
<server>
  <id>fabric8.upload.repo</id>
  <username>admin</username>
  <password>admin</password>
</server>
```

run 
```
init.sh
```

It will setup JBoss Fuse, install fabric, build and deploy the profile. 

Runnig the demo,
 


The demo video are located here too:

1.	https://vimeo.com/113289566
2.	https://vimeo.com/114960456  
