#!/bin/bash

echo "HELLO FROM .profile"

curl -O http://mirror.olnevhost.net/pub/apache/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz
tar -zxvf apache-maven-3.6.0-bin.tar.gz

export PATH="$(pwd)/apache-maven-3.6.0/bin:$PATH"
export JAVA_HOME="/home/vcap/app/.java-buildpack/open_jdk_jre"

mvn -v
