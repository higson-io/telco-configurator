#!/usr/bin/env bash

mvn clean install
mvn -B -DpushChanges=false release:prepare release:perform -Dresume=false -DlocalRepoDirectory=true -nsu
