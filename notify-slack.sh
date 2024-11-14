#!/bin/bash

set -e
set -o errexit
set -o pipefail
set -o nounset

MESSAGE="Released http4k version $1 (See <https://http4k.org/ecosystem/changelog/|Changelog> for details)."
curl -X POST -H 'Content-type: application/json' --data "{'text':'$MESSAGE'}" $SLACK_WEBHOOK
