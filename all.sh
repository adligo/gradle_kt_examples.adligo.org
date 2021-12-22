#!/bin/bash
#Expand new lines \n
shopt -s xpg_echo

function exec() {
  dir=$1
  cd $dir
  status=$?
  cmd=$2
  eval $cmd
  status=$?
  if [[ "$status" == "0" ]]; then
    echo "$cmd exited with success in $dir"
  else
    echo "$cmd exited with FAILURE in $dir"
    exit 9
  fi
}

exec "basic/first" "gradle build > /dev/null 2>&1"
