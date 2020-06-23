#!/bin/bash
# Author: Igor Oliveira
# This script creates a ECS cluster, to which we will deploy
# our application

echo "Configuring cluster options..."
ecs-cli configure \
--cluster cluster-ecs \
--default-launch-type FARGATE \
--config-name config \
--region us-west-2
result=$?

echo $result

if [ $result -eq 0 ]
then
    echo -e "\nDone!"
else
    echo "Error configuring cluster options!" >&2
    exit $result
fi


echo "Creating the cluster. This may take a while..."
ecs-cli up \
--cluster-config config \
--ecs-profile ecs-profile
result=$?

if [ $result -eq 0 ]
then
    echo -e "\nDone!"
else
    echo "Error creating the cluster!" >&2
fi

echo "Retrieving subnets ids from cloudformation stack..."
id1=$(aws cloudformation describe-stack-resource --stack-name amazon-ecs-cli-setup-cluster-ecs --logical-resource-id PubSubnetAz1 | jq -r .StackResourceDetail.PhysicalResourceId)
id2=$(aws cloudformation describe-stack-resource --stack-name amazon-ecs-cli-setup-cluster-ecs --logical-resource-id PubSubnetAz2 | jq -r .StackResourceDetail.PhysicalResourceId)
echo "Ids are $id1, $id2"

echo "Adding subnets ids to ecs-params.yml..."
echo "      subnets:" >> ecs-params.yml
echo "        - $id1" >> ecs-params.yml
echo "        - $id2" >> ecs-params.yml


exit $result
