#!/bin/sh

if [ -f "share.war" ]; then
  jar uvf share.war WEB-INF
else 
  echo "Please copy share.war to current working directory"
  exit 2
fi
