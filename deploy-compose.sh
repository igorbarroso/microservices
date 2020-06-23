#!/bin/bash
# Author: Igor Oliveira
# This script deploys the compose file to the cluster

echo "Deploying services..."
ecs-cli compose \
service up \
--cluster-config config \
--ecs-profile ecs-profile
result=$?

if [ $result -eq 0 ]
then
    echo -e "\nDone!"
else
    echo "Error deploying services!" >&2
fi

exit $result