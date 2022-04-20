# Ktor REST Kotlin

Based on:
https://seroter.com/2022/04/18/measuring-container-size-and-startup-latency-for-serverless-apps-written-in-c-node-js-go-and-java/

Run locally:
```
./gradlew runDebugExecutable
```

Create native executable:
```
./gradlew linkReleaseExecutable
```

Dockerize:
```
docker build -t ktorrestapi .
```

Run on Docker:
```
docker run -p8080:8080 ktorrestapi
```

### GCP

```
export PROJECT_ID=YOUR_PROJECT_ID

docker build -t gcr.io/$PROJECT_ID/ktorrestapi-kotlin .

docker push gcr.io/$PROJECT_ID/ktorrestapi-kotlin

gcloud run deploy \
  --image=gcr.io/$PROJECT_ID/ktorrestapi-kotlin \
  --platform=managed \
  --allow-unauthenticated \
  --project=$PROJECT_ID \
  --region=us-central1 \
  ktorrestapi-kotlin
```