#!/bin/bash

for directory in $(find * -maxdepth 0 -type d -print)
do
    cd $directory
    find * -type f -print > manifest
    cd ..
done
