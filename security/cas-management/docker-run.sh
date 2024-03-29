#!/bin/bash

docker stop cas > /dev/null 2>&1
docker rm cas > /dev/null 2>&1
image_tag=(`cat gradle.properties | grep "casmgmt.version" | cut -d= -f2`)
docker run -d -p 8080:8080 -p 8444:8443 --name="cas-management" apereo/cas-management:"v${image_tag}"
docker logs -f cas-management
