# simple-cache-service
[![Maven Package](https://github.com/mhmtonrn/simple-cache-service/actions/workflows/maven-publish.yml/badge.svg?branch=master)](https://github.com/mhmtonrn/simple-cache-service/actions/workflows/maven-publish.yml)
[![SonarCloud analysis](https://github.com/mhmtonrn/simple-cache-service/actions/workflows/sonarcloud.yml/badge.svg)](https://github.com/mhmtonrn/simple-cache-service/actions/workflows/sonarcloud.yml)
[![Docker Image CI](https://github.com/mhmtonrn/simple-cache-service/actions/workflows/docker-image.yml/badge.svg?branch=master)](https://github.com/mhmtonrn/simple-cache-service/actions/workflows/docker-image.yml)

Simple cache service is a cache mechanism for your application. Simple cache service runs in-memory mode thus your cached datas lost after service stopped.

run with docker

```
docker run -p 8080:8080 monar2/simple-cache-service 
```

cahce runs in-memory 

### to set no expire time cache
``` 
POST /cache/ HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
{
    "key":"test5",
    "value":"test"
}
```

### to set cache with expire at after x millisecond
``` 
POST /cache/ HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
{
	"key":"test5",
	"value":"test",
	"expireAtMillisecond": 30000
}
```

### to set cache with expire at given time
``` 
POST /cache/ HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
{
	"key":"test1",
	"value":"test",
	"expireAtTime":"2022-10-12 20:25:00"
}
```

### To get cache value  
```shell
curl -X GET http://localhost:8080/cache/{KEY}
```

### To list key set
```shell
curl -X GET http://localhost:8080/cache
```
