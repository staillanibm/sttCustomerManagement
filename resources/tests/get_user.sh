#!/bin/bash

source .env

if [ $# -ne 1 ]; then
    echo "Error - you need to pass the account ID as an argument."
    echo "Usage: $0 <account_id>"
    exit 1
fi

ACCOUNT_ID=$1

curl -u Administrator:${ADMIN_PASSWORD} "${ROOT_URL}/rad/sttCustomerManagement.apis:AccountAPI/accounts/${ACCOUNT_ID}" -H "Accept: application/json" -s | jq