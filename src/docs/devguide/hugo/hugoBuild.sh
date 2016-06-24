#!/usr/bin/env bash

# Run a hugo build from the comfort of a docker container
#
# ----------------------------------------------------------------------------------------------------------------------
# usage:
#
#   hugoBuild.sh BASE_DIR
#
#     BASE_DIR: maven ${basedir} property, the base dir of this project
#


BASE_DIR=$1

if [ -z $CI ]; then
  echo ''
  echo '  + Ensure docker-machine is started [only required for mac]'
  echo ''

  docker-machine start default
  eval $(docker-machine env default)
fi

echo ''
echo ''
echo '  + Running hugo build'
echo ''
docker run --name "hugo" -v ${BASE_DIR}/target/devguide/hugo:/src -v ${BASE_DIR}/target/devguide/site:/output -e "HUGO_THEME=hugo-material-docs" -e "HUGO_BASEURL=/" jojomi/hugo

if [ -z $CI ]; then
  echo ''
  echo '  + Remove box and stop docker-machine [only required for mac]'
  echo ''

  docker stop hugo &> /dev/null
  docker rm hugo &> /dev/null
  docker-machine stop default
fi
