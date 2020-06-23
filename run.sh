#!/bin/bash
# Author: Igor Oliveira
# This is the main script, which calls all other 
# scripts in a pre-defined order.
# This file must be made executable using "chmod +x run.sh"

/bin/bash aws-credentials-config.sh
/bin/bash create-cluster.sh
/bin/bash create-security-groups.sh
/bin/bash deploy-compose.sh
