#!/bin/bash

./mvnw clean install
jar uvf target/profile-demo-0.0.1-SNAPSHOT.jar .profile 
