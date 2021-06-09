# rest-demo
실행방법
1. DemoApplication -> run
2. 브라우저에서 localhost:8080/api/posts

기본배포 흐름
1. aws cli, kubectl, docker window 버전으로 설치하기
2. Terminal 창에서 docker image 생성하기 (Docker rising)
- docker build -t 268081345066.dkr.ecr.ap-northeast-2.amazonaws.com/rest-demo-order1:v1 .
3. 생성된 이미지 목록 확인
- docker images
4.나의 ECR를 바라보기 위해 토큰 가져오기
- docker login --username AWS -p $(aws ecr get-login-password --region ap-northeast-2) 268081345066.dkr.ecr.ap-northeast-2.amazonaws.com/
5. Docker 이미지 올리기 push
- docker push 268081345066.dkr.ecr.ap-northeast-2.amazonaws.com/rest-demo-order1:v1
6. IAM > 본인계정 > 액세스 키 만들기
- aws configure
- AWS Access Key ID [None]: 
- AWS Secret Access Key [None]: 
- Default region name [None]: ap-northeast-2
- Default output format [None]: json
7. AWS 클러스터 생성
- eksctl create cluster --name rest-demo-order1 --version 1.19 --nodegroup-name standard-workers --node-type t3.medium --nodes 2 --nodes-min 1 --nodes-max 2
8. AWS 클러스터 토큰 가져오기 -> 로컬 쿠버네티스 클라이언트에게 바라볼 될 대상 지정 하는것
- aws eks --region ap-northeast-2 update-kubeconfig --name rest-demo-order1
9. 소스내 k8s 경로에 있는 yaml 파일로 pod 배포하고 service 배포하기
10. CI/CD 구성하기
