# Alfresco Tracking Image Removal Patch
Remove that *hidden*, *hardcoded* and *annoying* tracking image from Alfresco Community

Distributed for free without any warranty. Use at your own risk.

## Instructions
### Build
get the sources:
```console
$ git clone https://github.com/saidone75/alfresco-tracking-removal.git -b v1.0.0
```
build the amp:
```console
$ cd alfresco-tracking-removal
$ mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------< org.saidone:alfresco-tracking-removal >----------------
[INFO] Building alfresco-tracking-removal AMP project 1.0
[INFO] --------------------------------[ amp ]---------------------------------
[INFO]
[INFO] --- maven-enforcer-plugin:1.4.1:enforce (enforce-sdk-requirements) @ alfresco-tracking-removal ---
[...]
[INFO] --- alfresco-maven-plugin:2.2.0:amp (default-amp) @ alfresco-tracking-removal ---
[INFO] Building jar: /home/saidone/workspace-alfresco/alfresco-tracking-removal/target/amp/lib/alfresco-tracking-removal-1.0.jar
[INFO] Building amp: /home/saidone/workspace-alfresco/alfresco-tracking-removal/target/alfresco-tracking-removal-1.0.amp
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.688 s
[INFO] Finished at: 2020-12-26T15:15:55+01:00
[INFO] ------------------------------------------------------------------------
```
### Installation
Install the amp against share.war using the Module Management Tool (MMT):
```
$ java -jar alfresco-mmt.jar install alfresco-tracking-removal-1.0.amp share.war
```
and restart Alfresco.

## Credits
Credits for this patch goes to:

http://penguindreams.org/blog/removing-the-tracking-image-from-alfresco 

Sumit Khanna - <sumit@penguindreams.org>
