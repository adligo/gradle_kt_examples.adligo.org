#!/bin/bash
#Expand new lines \n
shopt -s xpg_echo
tdir=`pwd`
function exec() {
  cd $tdir
  #pwd
  dir=$1
  cd $dir
  status=$?
  cmd=$2
  eval $cmd
  status=$?
  if [[ "$status" == "0" ]]; then
    echo "$cmd exited with success in $dir"
  else
    echo "$cmd exited with FAILURE $status in $dir"
    exit 9
  fi
}

exec "basic/first" "gradle build > /dev/null 2>&1"
exec "basic/printOutline" "gradle hw > /dev/null 2>&1"

exec "multi/printOutline" "gradle hw > /dev/null 2>&1"
