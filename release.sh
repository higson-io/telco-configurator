#!/usr/bin/env bash

mvn -B -DpushChanges=false release:prepare release:perform -Dresume=false -DlocalRepoDirectory=true -nsu
