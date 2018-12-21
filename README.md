# Spring .profile Demo

A simple demonstration of adding a `.profile` script to the jar root to install maven in a Cloud Foundry container.

## Getting Started

Build and Push
```
./build.sh
cf push -p target/profile-demo-0.0.1-SNAPSHOT.jar
```

Start tailing logs
```
cf logs profile-demo
```

Now, navigate to http://profile-demo.your-app-domain.com/hello

You should see the maven archetype being generated in the logs:

```
...
...
   2018-12-21T11:31:46.44-0600 [APP/PROC/WEB/0] OUT [INFO] ----------------------------------------------------------------------------
   2018-12-21T11:31:46.44-0600 [APP/PROC/WEB/0] OUT [INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-archetype:1.0
   2018-12-21T11:31:46.44-0600 [APP/PROC/WEB/0] OUT [INFO] ----------------------------------------------------------------------------
   2018-12-21T11:31:46.45-0600 [APP/PROC/WEB/0] OUT [INFO] Parameter: basedir, Value: /home/vcap/app
   2018-12-21T11:31:46.45-0600 [APP/PROC/WEB/0] OUT [INFO] Parameter: package, Value: groupId
   2018-12-21T11:31:46.45-0600 [APP/PROC/WEB/0] OUT [INFO] Parameter: groupId, Value: groupId
   2018-12-21T11:31:46.45-0600 [APP/PROC/WEB/0] OUT [INFO] Parameter: artifactId, Value: asimio-api-archetype
   2018-12-21T11:31:46.45-0600 [APP/PROC/WEB/0] OUT [INFO] Parameter: packageName, Value: groupId
   2018-12-21T11:31:46.45-0600 [APP/PROC/WEB/0] OUT [INFO] Parameter: version, Value: 1.0-SNAPSHOT
   2018-12-21T11:31:46.47-0600 [APP/PROC/WEB/0] OUT [INFO] project created from Old (1.x) Archetype in dir: /home/vcap/app/asimio-api-archetype
   2018-12-21T11:31:46.47-0600 [APP/PROC/WEB/0] OUT [INFO] ------------------------------------------------------------------------
   2018-12-21T11:31:46.47-0600 [APP/PROC/WEB/0] OUT [INFO] BUILD SUCCESS
   2018-12-21T11:31:46.47-0600 [APP/PROC/WEB/0] OUT [INFO] ------------------------------------------------------------------------
   2018-12-21T11:31:46.47-0600 [APP/PROC/WEB/0] OUT [INFO] Total time:  9.039 s
   2018-12-21T11:31:46.47-0600 [APP/PROC/WEB/0] OUT [INFO] Finished at: 2018-12-21T17:31:46Z
   2018-12-21T11:31:46.47-0600 [APP/PROC/WEB/0] OUT [INFO] ------------------------------------------------------------------------
```

## Pertinent Files

  * [.profile](./.profile) - installs maven in application container
  * [build.sh](./build.sh) - builds the project and adds `.profile` to the jar root
  * [GreetingController](./src/main/java/com/example/profiledemo/GreetingController.java) - simple controller to trigger `mvn archetype:generate`
