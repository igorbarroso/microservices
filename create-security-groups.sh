#!/bin/bash
# Author: Igor Oliveira
# This script creates a security group for ECS cluster and allows access to port 443

echo "Retrieving vpc id from cloudformation stack..."
vpc_id=$(aws cloudformation describe-stack-resource --stack-name amazon-ecs-cli-setup-cluster-ecs --logical-resource-id Vpc | jq -r .StackResourceDetail.PhysicalResourceId)


echo "Creating security group for cluster..."
aws ec2 create-security-group \
--description "Manages access to ecs cluster" \
--group-name "ecs-cluster-sg" \
--vpc-id $vpc_id
result=$?

if [ $result -eq 0 ]
then
    echo -e "\nDone!"
else
    echo "Error creating security group!" >&2
    exit $result
fi


echo "Retrieving security group 'ecs-cluster-sg' id..."
id=$(aws ec2 describe-security-groups --filters Name=group-name,Values=ecs-cluster-sg | jq -r .SecurityGroups[0].GroupId)
echo "Id is $id"

echo "Creating security group rule to allow access to port 8000..."
aws ec2 authorize-security-group-ingress \
--group-id $id \
--protocol tcp \
--port 8000 \
--cidr 0.0.0.0/0 \
--region us-west-2
result=$?

if [ $result -eq 0 ]
then
    echo -e "\nDone!"
else
    echo "Error creating security group rule!" >&2
    exit $result
fi

echo "Adding security group 'ecs-cluster-sg' id to ecs-params.yml..."
echo "      security_groups:" >> ecs-params.yml
echo "        - $id" >> ecs-params.yml

exit 0