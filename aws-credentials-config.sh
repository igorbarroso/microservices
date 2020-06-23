#!/bin/bash
# Author: Igor Oliveira
# This script configures AWS-CLI with the user's account information and 
# must be run once before all configuration takes place. 
# The user to provide the credentials must be root.


echo -e "Configuring AWS-CLI credentials..."
{ echo <YOUR-ACCESS-KEY-ID>; echo <YOUR-SECRET-ACCESS-KEY>; echo us-west-2; echo json; } | aws configure
result=$?

if [ $result -eq 0 ]
then
    echo -e "\nDone!"
else
    echo "Configuration failed!" >&2
fi

echo -e "Configuring ECS-CLI credentials..."
ecs-cli configure profile \
--access-key <YOUR-ACCESS-KEY-ID> \
--secret-key <YOUR-SECRET-ACCESS-KEY> \
--profile-name ecs-profile
if [ $result -eq 0 ]
then
    echo -e "\nDone!"
else
    echo "Configuration failed!" >&2
fi

exit $result

