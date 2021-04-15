#!/bin/sh -x
dir=$(cd `dirname $0`;pwd)
echo $dir
sed -i '' '/^alias lth=/d' ~/.bash_profile
echo "alias lth='cd $dir && java -jar $dir/target/lth-1.0.0.jar'" >> ~/.bash_profile
exec ./mvnw clean install -DskipTests
source ~/.bash_profile

