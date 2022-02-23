#!/bin/bash

set -eou pipefail

# install certs
if command -v mkcert &> /dev/null; then
  mkcert -install -pkcs12 localhost
  # cp localhost.p12 ./api/src/main/resources/
  # cp localhost.p12 ./site/resources/
  cp localhost.p12 ./etl/src/main/resources
  rm localhost.p12
else
  echo You must install mkcert
fi