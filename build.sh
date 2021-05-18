#!/bin/bash
mvn install
docker build -t 268081345066.dkr.ecr.ap-northeast-2.amazonaws.com/order1-ecr:v1 .
docker push 268081345066.dkr.ecr.ap-northeast-2.amazonaws.com/order1-ecr:v1